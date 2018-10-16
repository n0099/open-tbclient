package com.baidu.searchbox.ng.ai.apps.monitor;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.AiAppsActivity;
import com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragment;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.core.listener.IOnScrollChangedListener;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppsPerformanceUBC;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.searchbox.ng.ai.apps.trace.ErrCode;
import com.baidu.searchbox.ng.ai.apps.util.AiAppRomUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.webkit.sdk.WebView;
import java.io.ByteArrayOutputStream;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppsMonitor extends HandlerThread implements IOnScrollChangedListener {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_PAGE_MONITOR_DELAY_SECONDS = 6;
    private static final int GREY_BACKGROUND = -657931;
    private static final long LOADING_PAGE_CHECK_INTERVAL_S = 10000;
    private static final String LOADING_PAGE_URL = "loading";
    private static final int MSG_FULL_SCREEN_SHOT = 3;
    private static final int MSG_LOADING_PAGE = 4;
    private static final int MSG_NEW_PAGE = 1;
    private static final int MSG_PART_SCREEN_SHOT = 2;
    private static final int PART_CAPTURE_WIDTH = 200;
    private static final long RETRY_INTERVAL_S = 1000;
    private static final long RETRY_MAX_TIME = 3;
    private static final String TAG = AiAppsMonitor.class.getSimpleName();
    public static final String WHITE_SCREEN_MONITOR_SWITCH = "aiapps_white_screen_switch";
    private static volatile AiAppsMonitor sInstance;
    private volatile boolean isAiAppBackground;
    private String mCurToken;
    private Handler mHandler;
    private long mMonitorDelayMilliseconds;
    private int mMonitorPageCount;
    private int mReportCnt;
    private long mStartTime;

    private AiAppsMonitor() {
        super("AiAppsMonitor", 5);
        this.isAiAppBackground = false;
        this.mReportCnt = 0;
        this.mMonitorPageCount = 0;
        this.mMonitorDelayMilliseconds = AiAppsRuntime.getAiAppAbTestRuntime().whiteScreenMonitorDelayTime() * 1000;
    }

    public static AiAppsMonitor getInstance() {
        if (sInstance == null) {
            synchronized (AiAppsMonitor.class) {
                if (sInstance == null) {
                    sInstance = new AiAppsMonitor();
                }
            }
        }
        return sInstance;
    }

    public static void destroyInstance() {
        if (sInstance != null) {
            synchronized (AiAppsMonitor.class) {
                if (sInstance != null) {
                    sInstance.stopMonitor();
                    sInstance = null;
                }
            }
        }
    }

    private void initHandler() {
        Looper looper = getLooper();
        if (looper != null) {
            this.mHandler = new MonitorHandler(looper);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.listener.IOnScrollChangedListener
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0 && i == 0 && i2 == 1) {
            log("scroll (" + i3 + "," + i4 + ") -> (" + i + "," + i2 + ")");
        } else {
            removePendingActions();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class MonitorHandler extends Handler {
        int curRetryCnt;

        private MonitorHandler(Looper looper) {
            super(looper);
            this.curRetryCnt = 0;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AiAppsMonitor.this.log("get message " + message.what);
            if (AiAppsMonitor.this.isAiAppBackground) {
                AiAppsMonitor.this.log("aiapp is in background, ignore message");
                return;
            }
            switch (message.what) {
                case 1:
                    AiAppsFragmentManager aiAppsFragmentManager = AiAppsController.getInstance().getAiAppsFragmentManager();
                    if (aiAppsFragmentManager != null) {
                        AiAppsBaseFragment topFragment = aiAppsFragmentManager.getTopFragment();
                        if (topFragment == null || !(topFragment instanceof AiAppsFragment)) {
                            AiAppsMonitor.this.log("top fragment is not aiappfragment");
                            return;
                        }
                        String slaveWebViewId = ((AiAppsFragment) topFragment).getSlaveWebViewId();
                        if (TextUtils.isEmpty(slaveWebViewId)) {
                            if (this.curRetryCnt == 3) {
                                AiAppsMonitor.this.log("can't get slaveId after retrying 3 times");
                                this.curRetryCnt = 0;
                                return;
                            }
                            AiAppsMonitor.this.mHandler.sendEmptyMessageDelayed(1, 1000L);
                            return;
                        }
                        AiAppsWebViewManager webViewManager = AiAppsController.getInstance().getWebViewManager(slaveWebViewId);
                        if (webViewManager != null) {
                            webViewManager.addOnScrollChangedListener(AiAppsMonitor.this);
                        }
                        AiAppsMonitor.this.monitorNewPage(topFragment, slaveWebViewId);
                        this.curRetryCnt = 0;
                        return;
                    }
                    return;
                case 2:
                    CaptureInfo captureInfo = (CaptureInfo) message.obj;
                    if (captureInfo != null) {
                        if (!TextUtils.equals(captureInfo.token, AiAppsMonitor.this.mCurToken)) {
                            AiAppsMonitor.this.log("page has changed from " + captureInfo.token + " => " + AiAppsMonitor.this.mCurToken);
                            return;
                        } else if (AiAppsMonitor.this.isWhiteScreen(captureInfo)) {
                            post(new FullMonitorRunnable(captureInfo.url, captureInfo.token));
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 3:
                    CaptureInfo captureInfo2 = (CaptureInfo) message.obj;
                    if (captureInfo2 != null) {
                        if (!TextUtils.equals(captureInfo2.token, AiAppsMonitor.this.mCurToken)) {
                            AiAppsMonitor.this.log("page has changed from " + captureInfo2.token + " => " + AiAppsMonitor.this.mCurToken);
                            return;
                        } else if (AiAppsMonitor.this.isWhiteScreen(captureInfo2)) {
                            AiAppsMonitor.this.errorReport(captureInfo2);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 4:
                    AiAppsMonitor.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.monitor.AiAppsMonitor.MonitorHandler.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AiAppsFragmentManager aiAppsFragmentManager2 = AiAppsController.getInstance().getAiAppsFragmentManager();
                            if (aiAppsFragmentManager2 != null && aiAppsFragmentManager2.getTopFragment() == null) {
                                CaptureInfo captureInfo3 = new CaptureInfo();
                                captureInfo3.url = AiAppsMonitor.LOADING_PAGE_URL;
                                AiAppsMonitor.this.errorReport(captureInfo3);
                            }
                        }
                    }, 10000L);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void errorReport(CaptureInfo captureInfo) {
        this.mReportCnt++;
        String aiAppsInfo = getAiAppsInfo(captureInfo);
        log(aiAppsInfo);
        ErrCode detail = new ErrCode().feature(5L).error(19L).detail(aiAppsInfo);
        AiAppsPerformanceUBC.onEvent(new AiAppsPerformanceUBC.Event(AiAppsPerformanceUBC.ID_STABILITY).from("swan").appId(AiApp.getAiAppId()).type(String.valueOf(detail.code())).page(String.valueOf(this.mMonitorPageCount)).enableStackTrace(false).infoAdd("detail", detail.details().toString()));
    }

    private String getAiAppsInfo(CaptureInfo captureInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SystemScreenshotManager.PAGE, captureInfo.url);
            if (AiApp.get() != null) {
                jSONObject.put("name", AiApp.get().getName());
            } else {
                jSONObject.put("name", AiAppRomUtils.UNKNOWN);
            }
            jSONObject.put("slaveId", this.mCurToken);
            jSONObject.put("errCnt", this.mReportCnt);
            jSONObject.put("startTime", this.mStartTime);
            jSONObject.put("monitorCnt", this.mMonitorPageCount);
            jSONObject.put("firstPage", this.mMonitorPageCount == 1);
            jSONObject.put("zeus", AiAppsRuntime.getConfigRuntime().getZeusVersion(AppRuntime.getAppContext()));
            jSONObject.put("image", getImageBase64(captureInfo.capture));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isWhiteScreen(CaptureInfo captureInfo) {
        boolean z = true;
        Bitmap bitmap = captureInfo.capture;
        if (bitmap == null) {
            return false;
        }
        int pixel = bitmap.getPixel(1, 1);
        for (int i = 1; i < bitmap.getWidth() - 1; i++) {
            for (int i2 = 1; i2 < bitmap.getHeight() - 1; i2++) {
                if (pixel != bitmap.getPixel(i, i2)) {
                    log("非白屏, 图片大小 " + bitmap.getWidth() + " x " + bitmap.getHeight() + "; slaveId:" + this.mCurToken + ": " + bitmap.getPixel(i, i2));
                    return false;
                }
            }
        }
        log(((pixel == -1 || pixel == GREY_BACKGROUND) ? "" : "非") + "白屏, 图片大小 " + bitmap.getWidth() + " x " + bitmap.getHeight() + "; slaveId:" + this.mCurToken);
        if (pixel != -1 && pixel != GREY_BACKGROUND) {
            z = false;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void monitorNewPage(AiAppsBaseFragment aiAppsBaseFragment, String str) {
        String str2 = "";
        if (aiAppsBaseFragment instanceof AiAppsFragment) {
            str2 = ((AiAppsFragment) aiAppsBaseFragment).getCurPage();
        }
        if (!TextUtils.equals(str, this.mCurToken)) {
            this.mCurToken = str;
            this.mHandler.postDelayed(new PartMonitorRunnable(str2, str), this.mMonitorDelayMilliseconds);
        }
    }

    /* loaded from: classes2.dex */
    private class FullMonitorRunnable implements Runnable {
        final String token;
        final String url;

        private FullMonitorRunnable(String str, String str2) {
            this.url = str;
            this.token = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.equals(this.token, AiAppsMonitor.this.mCurToken)) {
                AiAppsUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.monitor.AiAppsMonitor.FullMonitorRunnable.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AiAppsMonitor.this.log("start full capture, slave id: " + FullMonitorRunnable.this.token + "; url:" + FullMonitorRunnable.this.url);
                        WebView bdWebViewBySlaveId = AiAppsController.getInstance().getBdWebViewBySlaveId(FullMonitorRunnable.this.token);
                        if (bdWebViewBySlaveId == null || bdWebViewBySlaveId.getWidth() <= 0 || bdWebViewBySlaveId.getHeight() <= 0) {
                            AiAppsMonitor.this.log("invalid webview " + bdWebViewBySlaveId);
                            return;
                        }
                        Bitmap screenshot = AiAppsUIUtils.getScreenshot();
                        if (screenshot != null) {
                            CaptureInfo captureInfo = new CaptureInfo();
                            captureInfo.token = FullMonitorRunnable.this.token;
                            captureInfo.capture = screenshot;
                            Message obtainMessage = AiAppsMonitor.this.mHandler.obtainMessage(3);
                            obtainMessage.obj = captureInfo;
                            AiAppsMonitor.this.mHandler.sendMessage(obtainMessage);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class PartMonitorRunnable implements Runnable {
        final String token;
        final String url;

        private PartMonitorRunnable(String str, String str2) {
            this.url = str;
            this.token = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.equals(this.token, AiAppsMonitor.this.mCurToken)) {
                AiAppsUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.monitor.AiAppsMonitor.PartMonitorRunnable.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AiAppsMonitor.this.log("start part capture, slaveid " + PartMonitorRunnable.this.token + "; url:" + PartMonitorRunnable.this.url);
                        WebView bdWebViewBySlaveId = AiAppsController.getInstance().getBdWebViewBySlaveId(PartMonitorRunnable.this.token);
                        if (bdWebViewBySlaveId == null || bdWebViewBySlaveId.getWidth() <= 0 || bdWebViewBySlaveId.getHeight() <= 0) {
                            AiAppsMonitor.this.log("invalid webview " + bdWebViewBySlaveId);
                            return;
                        }
                        Bitmap createBitmap = Bitmap.createBitmap(200, bdWebViewBySlaveId.getHeight(), Bitmap.Config.ARGB_4444);
                        createBitmap.eraseColor(-1);
                        Canvas canvas = new Canvas(createBitmap);
                        int i = 0;
                        if (bdWebViewBySlaveId.getWidth() > 200) {
                            i = (-(bdWebViewBySlaveId.getWidth() - 200)) / 2;
                        }
                        canvas.translate(i, 0.0f);
                        bdWebViewBySlaveId.draw(canvas);
                        CaptureInfo captureInfo = new CaptureInfo();
                        captureInfo.token = PartMonitorRunnable.this.token;
                        captureInfo.capture = createBitmap;
                        captureInfo.url = PartMonitorRunnable.this.url;
                        Message obtainMessage = AiAppsMonitor.this.mHandler.obtainMessage(2);
                        obtainMessage.obj = captureInfo;
                        AiAppsMonitor.this.mHandler.sendMessage(obtainMessage);
                    }
                });
            }
        }
    }

    private void monitorNewPageLoading(@NonNull AiAppsActivity aiAppsActivity) {
        AiAppsFragmentManager aiAppsFragmentManager;
        if (this.mHandler == null) {
            initHandler();
        }
        if (this.mHandler != null && (aiAppsFragmentManager = aiAppsActivity.getAiAppsFragmentManager()) != null) {
            removePendingActions();
            AiAppsBaseFragment topFragment = aiAppsFragmentManager.getTopFragment();
            if (topFragment == null) {
                this.mHandler.sendEmptyMessage(4);
            } else if (topFragment instanceof AiAppsFragment) {
                this.mHandler.sendEmptyMessageDelayed(1, 1000L);
                this.mMonitorPageCount++;
                log("page count: " + this.mMonitorPageCount);
            }
            this.mStartTime = System.currentTimeMillis();
        }
    }

    public void startMonitor(@NonNull AiAppsActivity aiAppsActivity) {
        try {
            if (!isAlive()) {
                start();
            }
            monitorNewPageLoading(aiAppsActivity);
        } catch (Error | Exception e) {
            e.printStackTrace();
        }
    }

    public void stopMonitor() {
        log("stop monitor");
        this.mMonitorPageCount = 0;
        this.mReportCnt = 0;
        removePendingActions();
    }

    public void onForegroundChange(boolean z) {
        log("this aiapp changes to " + (z ? "background" : "foreground"));
        if (z) {
            removePendingActions();
        }
        this.isAiAppBackground = z;
    }

    private String getLogTag() {
        return AiApp.get() != null ? TAG + AiApp.get().getName() : TAG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
    }

    private void removePendingActions() {
        log("remove pending actions");
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    private String getImageBase64(Bitmap bitmap) {
        if (bitmap == null || new Random().nextInt(10) % 3 != 0) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.WEBP, 0, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CaptureInfo {
        Bitmap capture;
        String token;
        String url;

        private CaptureInfo() {
        }
    }
}
