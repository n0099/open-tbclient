package com.baidu.browser.sailor.lightapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.BdSailorConfig;
import com.baidu.browser.sailor.lightapp.BdLightappConstants;
import com.baidu.browser.sailor.lightapp.BdLightappKernelJsCallback;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class BdLightappKernelClient implements INoProGuard, com.baidu.browser.sailor.feature.a.e, com.baidu.browser.sailor.feature.b, BdLightappKernelJsCallback.a {
    private static final String JSACTION_KEY = "jsaction_key";
    public static final long SDCARD_NEED_SPACE = 10485760;
    private static final int SPEED_DURATION = 5000;
    private static final String TAG = "BdLightappKernelClient";
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private String mCurrentFilePath;
    private MediaPlayer mMediaPlayer;
    private File mRecordFile;
    private MediaRecorder mRecorder;
    private File mRecordingFile;
    private WebView mWebView;
    private final SparseArray<BdLightappKernelJsCallback> mJsCallbacks = new SparseArray<>();
    private boolean mIsListenBattery = false;

    private void cloudaAsyncHandleResultForMedia(Uri uri, int i) {
        if (uri == null) {
            return;
        }
        new g(this, BdSailorPlatform.getInstance().getAppContext().getContentResolver(), i).execute(uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cloudaHandleResult(int i, String str, boolean z) {
        BdLightappKernelJsCallback bdLightappKernelJsCallback = this.mJsCallbacks.get(i);
        if (bdLightappKernelJsCallback == null) {
            return;
        }
        Log.d(TAG, "handle result:" + str);
        bdLightappKernelJsCallback.setResult(z);
        com.baidu.browser.sailor.util.b.a(new b(this, z, str, bdLightappKernelJsCallback, i), "compress_bitmap").start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureAudio() {
        if (this.mAudioManager == null || this.mMediaPlayer == null) {
            this.mAudioManager = (AudioManager) BdSailorPlatform.getInstance().getAppContext().getSystemService("audio");
            this.mMediaPlayer = new MediaPlayer();
            this.mMediaPlayer.setOnCompletionListener(new n(this));
            this.mMediaPlayer.setOnErrorListener(new c(this));
        }
    }

    public static boolean parseAbilityConfigArgs(String str, BdLightappKernelJsCallback bdLightappKernelJsCallback, String[] strArr) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (String str2 : strArr) {
                String optString = jSONObject.optString(str2);
                if (!TextUtils.isEmpty(optString)) {
                    bdLightappKernelJsCallback.getConfigsMap().put(str2, optString);
                }
            }
            return true;
        } catch (JSONException e) {
            Log.e(TAG, "json parse error");
            return false;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, CHECK_CAST]}, finally: {[IGET, INVOKE, CHECK_CAST, INVOKE, IGET, INVOKE, IF] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    public void prepareAudio(String str) {
        BdLightappKernelJsCallback bdLightappKernelJsCallback;
        ensureAudio();
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (this.mAudioManager.getStreamVolume(2) != 0) {
            mediaPlayer.setAudioStreamType(2);
            mediaPlayer.setLooping(false);
        }
        try {
            try {
                try {
                    try {
                        try {
                            mediaPlayer.reset();
                            if (!new File(str).exists()) {
                                str = com.baidu.browser.sailor.util.b.a(getPaivateDir(), str);
                                if (!new File(str).exists() && (bdLightappKernelJsCallback = this.mJsCallbacks.get(4)) != null) {
                                    bdLightappKernelJsCallback.sendCallBackWithRetCode(101);
                                    this.mJsCallbacks.remove(4);
                                }
                            }
                            mediaPlayer.setDataSource(str);
                            mediaPlayer.prepare();
                        } catch (IOException e) {
                            e.printStackTrace();
                            BdLightappKernelJsCallback bdLightappKernelJsCallback2 = this.mJsCallbacks.get(4);
                            if (bdLightappKernelJsCallback2 != null) {
                                bdLightappKernelJsCallback2.sendCallBackWithRetCode(1);
                                this.mJsCallbacks.remove(4);
                            }
                        }
                    } catch (IllegalArgumentException e2) {
                        e2.printStackTrace();
                        BdLightappKernelJsCallback bdLightappKernelJsCallback3 = this.mJsCallbacks.get(4);
                        if (bdLightappKernelJsCallback3 != null) {
                            bdLightappKernelJsCallback3.sendCallBackWithRetCode(1);
                            this.mJsCallbacks.remove(4);
                        }
                    }
                } catch (IllegalStateException e3) {
                    e3.printStackTrace();
                    BdLightappKernelJsCallback bdLightappKernelJsCallback4 = this.mJsCallbacks.get(4);
                    if (bdLightappKernelJsCallback4 != null) {
                        bdLightappKernelJsCallback4.sendCallBackWithRetCode(1);
                        this.mJsCallbacks.remove(4);
                    }
                }
            } catch (SecurityException e4) {
                e4.printStackTrace();
                BdLightappKernelJsCallback bdLightappKernelJsCallback5 = this.mJsCallbacks.get(4);
                if (bdLightappKernelJsCallback5 != null) {
                    bdLightappKernelJsCallback5.sendCallBackWithRetCode(1);
                    this.mJsCallbacks.remove(4);
                }
            }
        } catch (Throwable th) {
            BdLightappKernelJsCallback bdLightappKernelJsCallback6 = this.mJsCallbacks.get(4);
            if (bdLightappKernelJsCallback6 != null) {
                bdLightappKernelJsCallback6.sendCallBackWithRetCode(1);
                this.mJsCallbacks.remove(4);
            }
            throw th;
        }
    }

    private void releaseMediaPlayer() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetRecorder() {
        if (this.mRecorder != null) {
            this.mRecorder.stop();
            this.mRecorder.reset();
            this.mRecorder.release();
        }
        if (this.mRecordFile != null) {
            this.mRecordFile.delete();
        }
        if (this.mRecordingFile != null) {
            this.mRecordingFile.delete();
        }
        this.mRecordFile = null;
        this.mRecordingFile = null;
    }

    public abstract void addseniorWz(String str, String str2, String str3);

    public void audioSeekTo(String str, String str2, String str3) {
        BdLightappKernelJsCallback bdLightappKernelJsCallback = new BdLightappKernelJsCallback(str2, str3);
        bdLightappKernelJsCallback.setCallbackListener(this);
        try {
            com.baidu.browser.sailor.util.b.a(new k(this, Integer.parseInt(str), bdLightappKernelJsCallback));
        } catch (NumberFormatException e) {
            bdLightappKernelJsCallback.sendFailCallBack(e.getMessage());
        }
    }

    public void audioSpeedFF(String str, String str2) {
        BdLightappKernelJsCallback bdLightappKernelJsCallback = new BdLightappKernelJsCallback(str, str2);
        bdLightappKernelJsCallback.setCallbackListener(this);
        com.baidu.browser.sailor.util.b.a(new m(this, bdLightappKernelJsCallback));
    }

    public abstract void bdLogin(String str, String str2, String str3);

    public abstract void callShare(String str, String str2, String str3);

    public abstract void closeWindow();

    public void cloudaLaunchCamera(String str, String str2, String str3) {
        Uri uri;
        Intent intent = null;
        BdLightappKernelJsCallback bdLightappKernelJsCallback = new BdLightappKernelJsCallback(str2, str3);
        bdLightappKernelJsCallback.setCallbackListener(this);
        if (!parseAbilityConfigArgs(str, bdLightappKernelJsCallback, BdLightappConstants.a.adg)) {
            bdLightappKernelJsCallback.sendCallBackWithRetCode(2);
            return;
        }
        if (!(com.baidu.browser.sailor.util.b.a() && com.baidu.browser.sailor.util.b.b())) {
            bdLightappKernelJsCallback.sendCallBackWithRetCode(101);
            return;
        }
        String str4 = bdLightappKernelJsCallback.getConfigsMap().get("mediaType");
        this.mCurrentFilePath = null;
        if ("lightapp.device.MEDIA_TYPE.IMAGE".equals(str4)) {
            if (Build.VERSION.SDK_INT >= 24) {
                File a = com.baidu.browser.sailor.feature.a.d.a(str4);
                if (a != null) {
                    ContentValues contentValues = new ContentValues(1);
                    contentValues.put("_data", a.getAbsolutePath());
                    uri = BdSailor.getInstance().getAppContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                } else {
                    uri = null;
                }
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra("output", uri);
                this.mCurrentFilePath = a.getPath();
            } else {
                File a2 = com.baidu.browser.sailor.feature.a.d.a(str4);
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra("output", Uri.fromFile(a2));
                this.mCurrentFilePath = a2.getPath();
            }
        } else if ("lightapp.device.MEDIA_TYPE.VIDEO".equals(str4)) {
            File a3 = com.baidu.browser.sailor.feature.a.d.a(str4);
            intent = new Intent("android.media.action.VIDEO_CAPTURE");
            intent.putExtra("android.intent.extra.videoQuality", 1);
            this.mCurrentFilePath = a3.getPath();
        } else {
            bdLightappKernelJsCallback.sendCallBackWithRetCode(2);
            Log.e(TAG, "error camera type: " + str4);
        }
        if (intent != null) {
            this.mJsCallbacks.put(7, bdLightappKernelJsCallback);
            intent.putExtra(JSACTION_KEY, 7);
            startActivityForResultSafely(intent, 3002);
        }
    }

    public void cloudaLaunchGallery(String str, String str2, String str3) {
        BdLightappKernelJsCallback bdLightappKernelJsCallback = new BdLightappKernelJsCallback(str2, str3);
        bdLightappKernelJsCallback.setCallbackListener(this);
        if (!parseAbilityConfigArgs(str, bdLightappKernelJsCallback, BdLightappConstants.a.adg)) {
            bdLightappKernelJsCallback.sendCallBackWithRetCode(2);
            return;
        }
        if (!(com.baidu.browser.sailor.util.b.a() && com.baidu.browser.sailor.util.b.b())) {
            bdLightappKernelJsCallback.sendCallBackWithRetCode(101);
            return;
        }
        String str4 = bdLightappKernelJsCallback.getConfigsMap().get("mediaType");
        this.mJsCallbacks.put(8, bdLightappKernelJsCallback);
        Intent intent = new Intent("android.intent.action.PICK");
        if ("lightapp.device.MEDIA_TYPE.IMAGE".equals(str4)) {
            intent.setType("image/*");
        } else if (!"lightapp.device.MEDIA_TYPE.VIDEO".equals(str4)) {
            Log.e(TAG, "error media type: " + str4);
            bdLightappKernelJsCallback.sendCallBackWithRetCode(2);
            return;
        } else {
            intent.setType("video/*");
        }
        intent.putExtra(JSACTION_KEY, 8);
        startActivityForResultSafely(intent, CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL);
    }

    public abstract void consult(String str, String str2, String str3);

    public abstract void doPolymerPay(String str, String str2, String str3);

    public abstract void doThirdPay(String str, String str2, String str3);

    public abstract void dopay(String str, String str2, String str3, boolean z);

    public abstract void followSite(String str, String str2);

    public abstract void followZhida(String str, String str2, String str3);

    protected Activity getActivity() {
        return this.mActivity;
    }

    protected abstract String getAppId();

    public void getBattery(String str, String str2) {
        com.baidu.browser.sailor.platform.nativeability.a.e(str, str2, this);
    }

    public abstract void getCurrentPosition(String str, String str2);

    public String getCurrentUrl() {
        return this.mWebView != null ? this.mWebView.getUrl() : "";
    }

    public void getDeviceInfo(String str, String str2) {
        com.baidu.browser.sailor.platform.nativeability.a.a(str, str2, this);
    }

    public String getGlobalizationInfo() {
        return com.baidu.browser.sailor.platform.nativeability.a.a();
    }

    public void getNetworkType(String str, String str2) {
        com.baidu.browser.sailor.platform.nativeability.a.b(str, str2, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String getPaivateDir();

    public abstract void getPushToken(String str, String str2);

    public abstract void getWebKitPluginInfo(String str, String str2);

    public abstract void initpay(String str, String str2, String str3);

    public void invokeThirdApp(String str, String str2, String str3) {
        BdLightappKernelJsCallback bdLightappKernelJsCallback = new BdLightappKernelJsCallback(str2, str3);
        bdLightappKernelJsCallback.setCallbackListener(this);
        this.mJsCallbacks.put(12, bdLightappKernelJsCallback);
        JSONObject a = com.baidu.browser.sailor.util.e.a(str);
        try {
            String string = a.getString("action");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            Intent intent = new Intent(string);
            Iterator<String> keys = a.keys();
            Bundle bundle = new Bundle();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!"action".equals(next)) {
                    String string2 = a.getString(next);
                    if ("type".equals(next)) {
                        intent.setType(string2);
                    } else if ("data".equals(next) || DownloadDataConstants.Columns.COLUMN_URI.equals(next)) {
                        intent.setData(Uri.parse(string2));
                    } else {
                        bundle.putString(next, string2);
                        intent.putExtra(next, string2);
                    }
                }
            }
            intent.putExtras(bundle);
            intent.putExtra(JSACTION_KEY, 12);
            startActivitySafely(intent);
        } catch (JSONException e) {
            bdLightappKernelJsCallback.sendFailCallBack(e.getMessage());
            e.printStackTrace();
        }
    }

    public abstract void isLogin(String str, String str2, String str3);

    public abstract void launchSeniorVoiceRecognition(String str, String str2, String str3);

    public abstract void login(String str, String str2, String str3);

    @Override // com.baidu.browser.sailor.feature.b
    public boolean onActivityResult(int i, int i2, Intent intent) {
        Uri data = intent != null ? intent.getData() : null;
        switch (i) {
            case 3002:
            case CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL /* 3003 */:
                int i3 = i == 3002 ? 7 : 8;
                unregLappActivityResultListener();
                if (-1 == i2) {
                    if (data != null) {
                        if (data.getScheme().equals("content")) {
                            cloudaAsyncHandleResultForMedia(data, i3);
                            return true;
                        }
                        cloudaHandleResult(i3, data.getPath(), true);
                        return true;
                    } else if (this.mCurrentFilePath != null) {
                        File file = new File(this.mCurrentFilePath);
                        this.mCurrentFilePath = null;
                        cloudaHandleResult(i3, file.getPath(), true);
                        return true;
                    }
                } else if (i2 == 0) {
                    BdLightappKernelJsCallback bdLightappKernelJsCallback = this.mJsCallbacks.get(i3);
                    if (bdLightappKernelJsCallback != null) {
                        bdLightappKernelJsCallback.sendCallBackWithRetCode(3);
                        this.mJsCallbacks.remove(i3);
                        return true;
                    }
                    return true;
                }
                cloudaHandleResult(i3, "", false);
                return true;
            default:
                return false;
        }
    }

    @Override // com.baidu.browser.sailor.lightapp.BdLightappKernelJsCallback.a
    public void onCallBack(String str, String str2) {
        f fVar = new f(this, str, str2);
        if (this.mWebView != null) {
            this.mWebView.post(fVar);
        }
    }

    @Override // com.baidu.browser.sailor.feature.a.e
    public void onStopBackgroundWork() {
        stopBackgroundWork();
    }

    public void playAudio(String str, String str2, String str3, String str4) {
        BdLightappKernelJsCallback bdLightappKernelJsCallback = new BdLightappKernelJsCallback(str3, str4);
        bdLightappKernelJsCallback.setCallbackListener(this);
        com.baidu.browser.sailor.util.b.a(new j(this, str2, bdLightappKernelJsCallback, str));
    }

    public void postFile(String str, String str2, String str3, String str4) {
        com.baidu.browser.sailor.platform.nativeability.a.a(str, str2, str3, str4, this, getPaivateDir(), this.mWebView != null ? this.mWebView.getSettings().getUserAgentString() : "");
    }

    public abstract void queryWzStatus(String str, String str2);

    public abstract void queryZhidaStatus(String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: protected */
    public void regLappActivityResultListener() {
        com.baidu.browser.sailor.feature.a featureByName = BdSailorPlatform.getInstance().getFeatureByName(BdSailorConfig.SAILOR_EXT_LIGHT_APP);
        if (featureByName == null || this.mActivity == null) {
            Log.w(TAG, "lightAppFeature or mActivity null");
        } else {
            featureByName.regActivityResultCallback(this.mActivity.toString(), this);
        }
    }

    public void releaseObj() {
        this.mJsCallbacks.clear();
        this.mWebView = null;
        this.mActivity = null;
        this.mAudioManager = null;
        releaseMediaPlayer();
        resetRecorder();
        if (this.mIsListenBattery) {
            com.baidu.browser.sailor.platform.nativeability.a.b();
            this.mIsListenBattery = false;
        }
    }

    protected abstract void setActivity(Activity activity);

    public void setCurrentWebiew(WebView webView) {
        this.mWebView = webView;
    }

    public void setVolume(String str, String str2, String str3) {
        BdLightappKernelJsCallback bdLightappKernelJsCallback = new BdLightappKernelJsCallback(str2, str3);
        bdLightappKernelJsCallback.setCallbackListener(this);
        try {
            float parseFloat = Float.parseFloat(str);
            if (parseFloat < 0.0d || parseFloat > 1.0d) {
                bdLightappKernelJsCallback.sendFailCallBack("Volume out of range, should between [0.0,1.0]");
            } else {
                com.baidu.browser.sailor.util.b.a(new l(this, parseFloat, bdLightappKernelJsCallback));
            }
        } catch (Exception e) {
            bdLightappKernelJsCallback.sendFailCallBack(e.getMessage());
        }
    }

    public abstract void shareB64Img(String str);

    protected void startActivityForResultSafely(Intent intent, int i) {
        com.baidu.browser.sailor.util.b.a(new d(this, intent, i));
    }

    protected void startActivitySafely(Intent intent) {
        com.baidu.browser.sailor.util.b.a(new e(this, intent));
    }

    public void startListenBattery(String str, String str2) {
        com.baidu.browser.sailor.platform.nativeability.a.c(str, str2, this);
        this.mIsListenBattery = true;
    }

    public abstract void startListenKeyboard(String str, String str2, String str3);

    public abstract void startListenLocation(String str, String str2);

    public abstract void startQRcode(String str, String str2, String str3);

    public void startRecording(String str, String str2, String str3) {
        com.baidu.browser.sailor.util.b.a(new h(this, str2, str3, str));
    }

    protected void stopBackgroundWork() {
        if (this.mMediaPlayer == null || !this.mMediaPlayer.isPlaying()) {
            return;
        }
        this.mMediaPlayer.stop();
        BdLightappKernelJsCallback bdLightappKernelJsCallback = this.mJsCallbacks.get(4);
        if (bdLightappKernelJsCallback != null) {
            bdLightappKernelJsCallback.sendCallBackWithRetCode(3);
            this.mJsCallbacks.remove(4);
        }
    }

    public void stopListenBattery(String str, String str2) {
        com.baidu.browser.sailor.platform.nativeability.a.d(str, str2, this);
        this.mIsListenBattery = false;
    }

    public abstract void stopListenKeyboard(String str, String str2, String str3);

    public abstract void stopListenLocation(String str, String str2);

    public void stopRecording(String str, String str2) {
        com.baidu.browser.sailor.util.b.a(new i(this, str, str2));
    }

    public abstract void unSubscribeZhida(String str, String str2, String str3);

    protected void unregLappActivityResultListener() {
        com.baidu.browser.sailor.feature.a featureByName = BdSailorPlatform.getInstance().getFeatureByName(BdSailorConfig.SAILOR_EXT_LIGHT_APP);
        if (featureByName == null || this.mActivity == null) {
            Log.w(TAG, "lightAppFeature or mActivity null");
        } else {
            featureByName.unregActivityResultCallback(this.mActivity.toString());
        }
    }
}
