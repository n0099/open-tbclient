package com.baidu.searchbox.ng.ai.apps.console;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.trace.Index;
import com.baidu.searchbox.ng.ai.apps.trace.Tracer;
import com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes2.dex */
public class AiAppsPropertyWindow extends FrameLayout {
    private static final boolean DEBUG = false;
    public static final String KEY_CPU = "cpu";
    public static final String KEY_FRAME = "frame";
    public static final String KEY_MEM = "mem";
    public static final String KEY_TITLE = "title";
    private static final int SECOND_IN_NANOS = 1000000000;
    private static final String TAG = "AiAppsPropertyWindow";
    private static final int UPDATE_DURATION = 3000;
    private static final int WHAT_UPDATE = 0;
    private CPUMonitor mCpuMonitor;
    private ConcurrentMap<String, Object> mData;
    private FrameMonitor mFrameCallback;
    private MonitorHandler mHandler;
    private Model[] mModels;
    private boolean mMonitoring;
    private Map<String, TextView> mTextViews;
    private TracerMonitor mTracerMonitor;
    public static final String KEY_PAGE_SWITCH = Tracer.INDEX_COST_RECENT_PAGE_SWITCH.id;
    public static final String KEY_BOOT = Tracer.INDEX_COST_RECENT_LAUNCH_TOTAL.id;
    public static final String KEY_DOWNLOAD = Tracer.INDEX_COST_RECENT_DOWNLOAD.id;
    public static final String KEY_FIRST_RENDER = Tracer.INDEX_COST_CURRENT_PAGE_RENDERED_INITIAL.id;
    public static final String KEY_NEXT_RENDER = Tracer.INDEX_COST_CURRENT_PAGE_RENDERED.id;
    public static final String KEY_CACHE = Tracer.INDEX_STORAGE_SIZE.id;

    public AiAppsPropertyWindow(Context context) {
        super(context);
        this.mModels = new Model[]{new Model("基础"), new Model("cpu", "CPU：%s"), new Model("mem", "内存：%sm"), new Model("启动和切换"), new Model(KEY_PAGE_SWITCH, "页面切换耗时：%s ms"), new Model(KEY_BOOT, "启动耗时：%s ms"), new Model(KEY_DOWNLOAD, "下载耗时：%s ms"), new Model("渲染"), new Model(KEY_FIRST_RENDER, "初次渲染耗时：%s ms"), new Model(KEY_FRAME, "帧率：%s fps"), new Model(KEY_NEXT_RENDER, "再次渲染耗时：%s ms"), new Model("其他"), new Model(KEY_CACHE, "数据缓存：%s B")};
        this.mTextViews = new HashMap(this.mModels.length);
        this.mData = new ConcurrentHashMap();
        init(context);
    }

    public AiAppsPropertyWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mModels = new Model[]{new Model("基础"), new Model("cpu", "CPU：%s"), new Model("mem", "内存：%sm"), new Model("启动和切换"), new Model(KEY_PAGE_SWITCH, "页面切换耗时：%s ms"), new Model(KEY_BOOT, "启动耗时：%s ms"), new Model(KEY_DOWNLOAD, "下载耗时：%s ms"), new Model("渲染"), new Model(KEY_FIRST_RENDER, "初次渲染耗时：%s ms"), new Model(KEY_FRAME, "帧率：%s fps"), new Model(KEY_NEXT_RENDER, "再次渲染耗时：%s ms"), new Model("其他"), new Model(KEY_CACHE, "数据缓存：%s B")};
        this.mTextViews = new HashMap(this.mModels.length);
        this.mData = new ConcurrentHashMap();
        init(context);
    }

    public AiAppsPropertyWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mModels = new Model[]{new Model("基础"), new Model("cpu", "CPU：%s"), new Model("mem", "内存：%sm"), new Model("启动和切换"), new Model(KEY_PAGE_SWITCH, "页面切换耗时：%s ms"), new Model(KEY_BOOT, "启动耗时：%s ms"), new Model(KEY_DOWNLOAD, "下载耗时：%s ms"), new Model("渲染"), new Model(KEY_FIRST_RENDER, "初次渲染耗时：%s ms"), new Model(KEY_FRAME, "帧率：%s fps"), new Model(KEY_NEXT_RENDER, "再次渲染耗时：%s ms"), new Model("其他"), new Model(KEY_CACHE, "数据缓存：%s B")};
        this.mTextViews = new HashMap(this.mModels.length);
        this.mData = new ConcurrentHashMap();
        init(context);
    }

    private void init(Context context) {
        Model[] modelArr;
        LayoutInflater.from(context).inflate(R.layout.aiapps_property_window, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ai_apps_property_root);
        for (Model model : this.mModels) {
            TextView textView = new TextView(context);
            if (TextUtils.equals(model.tag, "title")) {
                textView.setTextAppearance(context, R.style.AiAppsPropertyWindowTitle);
                textView.setText(model.content);
            } else {
                textView.setTextAppearance(context, R.style.AiAppsPropertyWindowContent);
                textView.setTag(model.content);
                textView.setVisibility(8);
            }
            linearLayout.addView(textView);
            this.mTextViews.put(model.tag, textView);
        }
        startSysMonitor();
    }

    private void startSysMonitor() {
        if (!this.mMonitoring) {
            this.mMonitoring = true;
            this.mFrameCallback = new FrameMonitor();
            Choreographer.getInstance().postFrameCallback(this.mFrameCallback);
            this.mCpuMonitor = new CPUMonitor();
            this.mTracerMonitor = new TracerMonitor();
            Tracer.get().regCallback(this.mTracerMonitor, Tracer.INDEX_COST_RECENT_PAGE_SWITCH, Tracer.INDEX_COST_RECENT_LAUNCH_TOTAL, Tracer.INDEX_COST_RECENT_DOWNLOAD, Tracer.INDEX_COST_CURRENT_PAGE_RENDERED_INITIAL, Tracer.INDEX_COST_CURRENT_PAGE_RENDERED, Tracer.INDEX_STORAGE_SIZE);
            this.mHandler = new MonitorHandler();
            this.mHandler.sendEmptyMessage(0);
        }
    }

    private void stopSysMonitor() {
        if (this.mMonitoring) {
            this.mMonitoring = false;
            if (this.mHandler != null) {
                this.mHandler.removeMessages(0);
                this.mHandler = null;
            }
            if (this.mTracerMonitor != null) {
                Tracer.get().unRegCallback(this.mTracerMonitor, new Index[0]);
                this.mTracerMonitor = null;
            }
            this.mFrameCallback = null;
            this.mCpuMonitor = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyProperties(Map<String, Object> map) {
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                notifyProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    private void notifyProperty(String str, Object obj) {
        TextView textView = this.mTextViews.get(str);
        if (textView != null) {
            textView.setText(String.format((String) textView.getTag(), obj));
            textView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class MonitorHandler extends Handler {
        private MonitorHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AiAppsPropertyWindow.this.getCpuRate();
            AiAppsPropertyWindow.this.mData.put("mem", Long.valueOf(((ActivityManager) AiAppsPropertyWindow.this.getContext().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
            AiAppsPropertyWindow.this.notifyProperties(AiAppsPropertyWindow.this.mData);
            AiAppsPropertyWindow.this.mHandler.sendEmptyMessageDelayed(0, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getCpuRate() {
        if (!this.mCpuMonitor.monitoring) {
            AiAppExecutorUtils.postOnIO(this.mCpuMonitor, "aiAppsCpuMonitor");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopSysMonitor();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startSysMonitor();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i == 0) {
            startSysMonitor();
        } else {
            stopSysMonitor();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CPUMonitor implements Runnable {
        private static final int INDEX_OF_CPU = 9;
        private boolean monitoring;
        private final String name;

        private CPUMonitor() {
            this.name = "aiAppsCpuMonitor";
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [322=4] */
        @Override // java.lang.Runnable
        public void run() {
            BufferedReader bufferedReader;
            this.monitoring = true;
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"sh", "-c", "top -n 1 | grep " + Process.myPid()}).getInputStream()));
            } catch (IOException e) {
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                AiAppsPropertyWindow.this.mData.put("cpu", getResultFromStream(bufferedReader));
                AiAppsFileUtils.closeSafely(bufferedReader);
                this.monitoring = false;
            } catch (IOException e2) {
                AiAppsFileUtils.closeSafely(bufferedReader);
                this.monitoring = false;
            } catch (Throwable th2) {
                bufferedReader2 = bufferedReader;
                th = th2;
                AiAppsFileUtils.closeSafely(bufferedReader2);
                this.monitoring = false;
                throw th;
            }
        }

        private String getResultFromStream(BufferedReader bufferedReader) throws IOException {
            char read;
            char read2;
            int i = 0;
            char[] cArr = new char[4];
            if (Build.VERSION.SDK_INT >= 26) {
                int i2 = 0;
                boolean z = true;
                int i3 = 0;
                do {
                    read2 = (char) bufferedReader.read();
                    if (z && read2 != ' ') {
                        i2++;
                    }
                    if (i2 == 9) {
                        if (read2 == '.' || read2 == ' ') {
                            break;
                        }
                        cArr[i3] = read2;
                        i3++;
                    }
                    z = read2 == ' ';
                    if (i2 > 9) {
                        break;
                    }
                } while (read2 != 65535);
                try {
                    i = Integer.parseInt(String.valueOf(cArr, 0, i3)) / Runtime.getRuntime().availableProcessors();
                } catch (NumberFormatException e) {
                }
                return i + "%";
            }
            int i4 = 0;
            do {
                read = (char) bufferedReader.read();
                if (read == ' ' || i4 == 4) {
                    i4 = 0;
                } else {
                    cArr[i4] = read;
                    i4++;
                }
                if (read == '%') {
                    break;
                }
            } while (read != 65535);
            return String.valueOf(cArr, 0, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class FrameMonitor implements Choreographer.FrameCallback {
        int lastFrame;
        long lastFrameNanos;

        private FrameMonitor() {
            this.lastFrameNanos = -1L;
            this.lastFrame = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (AiAppsPropertyWindow.this.mMonitoring) {
                if (this.lastFrameNanos > 0 && this.lastFrame != (i = (int) ((1.0d / (j - this.lastFrameNanos)) * 1.0E9d))) {
                    this.lastFrame = i;
                    AiAppsPropertyWindow.this.mData.put(AiAppsPropertyWindow.KEY_FRAME, Integer.valueOf(i));
                }
                this.lastFrameNanos = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class TracerMonitor implements Tracer.Callback {
        private TracerMonitor() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
        public void onCallback(Set<Index<?>> set) {
            if (set != null && set.size() > 0) {
                HashMap hashMap = new HashMap(set.size());
                for (Index<?> index : set) {
                    hashMap.put(index.id, index.getFormatValue());
                }
                AiAppsPropertyWindow.this.notifyProperties(hashMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class Model {
        String content;
        String tag;

        public Model(String str) {
            this.tag = "title";
            this.content = str;
        }

        public Model(String str, String str2) {
            this.tag = "title";
            this.tag = str;
            this.content = str2;
        }
    }
}
