package com.baidu.swan.apps.console.property;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class SwanAppPropertyWindow extends FrameLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a[] aIe;
    private Map<String, TextView> aIf;
    private b aIg;
    private Map<String, Object> mData;

    public SwanAppPropertyWindow(Context context) {
        super(context);
        this.aIe = new a[]{new a("基础"), new a("cpu", "CPU：%s"), new a("mem", "内存：%sm"), new a("启动和切换"), new a(com.baidu.swan.apps.console.property.b.aHK, "页面切换耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.aHL, "启动耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.aHM, "下载耗时：%s ms"), new a("渲染"), new a(com.baidu.swan.apps.console.property.b.aHN, "启动首屏渲染时长：%s ms"), new a(com.baidu.swan.apps.console.property.b.aHO, "初次渲染耗时：%s ms"), new a("frame", "帧率：%s fps"), new a(com.baidu.swan.apps.console.property.b.aHP, "再次渲染耗时：%s ms"), new a("其他"), new a(com.baidu.swan.apps.console.property.b.aHQ, "数据缓存：%s B")};
        this.aIf = new HashMap(this.aIe.length);
        init(context);
    }

    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIe = new a[]{new a("基础"), new a("cpu", "CPU：%s"), new a("mem", "内存：%sm"), new a("启动和切换"), new a(com.baidu.swan.apps.console.property.b.aHK, "页面切换耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.aHL, "启动耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.aHM, "下载耗时：%s ms"), new a("渲染"), new a(com.baidu.swan.apps.console.property.b.aHN, "启动首屏渲染时长：%s ms"), new a(com.baidu.swan.apps.console.property.b.aHO, "初次渲染耗时：%s ms"), new a("frame", "帧率：%s fps"), new a(com.baidu.swan.apps.console.property.b.aHP, "再次渲染耗时：%s ms"), new a("其他"), new a(com.baidu.swan.apps.console.property.b.aHQ, "数据缓存：%s B")};
        this.aIf = new HashMap(this.aIe.length);
        init(context);
    }

    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aIe = new a[]{new a("基础"), new a("cpu", "CPU：%s"), new a("mem", "内存：%sm"), new a("启动和切换"), new a(com.baidu.swan.apps.console.property.b.aHK, "页面切换耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.aHL, "启动耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.aHM, "下载耗时：%s ms"), new a("渲染"), new a(com.baidu.swan.apps.console.property.b.aHN, "启动首屏渲染时长：%s ms"), new a(com.baidu.swan.apps.console.property.b.aHO, "初次渲染耗时：%s ms"), new a("frame", "帧率：%s fps"), new a(com.baidu.swan.apps.console.property.b.aHP, "再次渲染耗时：%s ms"), new a("其他"), new a(com.baidu.swan.apps.console.property.b.aHQ, "数据缓存：%s B")};
        this.aIf = new HashMap(this.aIe.length);
        init(context);
    }

    private void init(Context context) {
        a[] aVarArr;
        LayoutInflater.from(context).inflate(a.g.aiapps_property_window, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(a.f.ai_apps_property_root);
        for (a aVar : this.aIe) {
            TextView textView = new TextView(context);
            if (TextUtils.equals(aVar.tag, "title")) {
                textView.setTextAppearance(context, a.i.SwanAppPropertyWindowTitle);
                textView.setText(aVar.content);
            } else {
                textView.setTextAppearance(context, a.i.SwanAppPropertyWindowContent);
                textView.setTag(aVar.content);
                textView.setVisibility(8);
            }
            linearLayout.addView(textView);
            this.aIf.put(aVar.tag, textView);
        }
        Dq();
    }

    private void Dq() {
        if (DEBUG) {
            Log.d("SwanAppPropertyWindow", "Start system monitor");
        }
        if (this.mData == null) {
            this.mData = com.baidu.swan.apps.console.property.b.Do().Dp();
        }
        if (this.aIg == null) {
            this.aIg = new b();
            this.aIg.sendEmptyMessage(0);
        }
    }

    private void Dr() {
        if (DEBUG) {
            Log.d("SwanAppPropertyWindow", "Stop system monitor");
        }
        if (this.mData != null) {
            com.baidu.swan.apps.console.property.b.Do().recycle();
            this.mData = null;
        }
        if (this.aIg != null) {
            this.aIg.removeMessages(0);
            this.aIg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, Object obj) {
        TextView textView = this.aIf.get(str);
        if (textView != null) {
            textView.setText(String.format((String) textView.getTag(), obj));
            textView.setVisibility(0);
            if (DEBUG) {
                Log.d("SwanAppPropertyWindow", str + " : " + obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (SwanAppPropertyWindow.this.mData != null && SwanAppPropertyWindow.this.mData.size() > 0) {
                for (Map.Entry entry : SwanAppPropertyWindow.this.mData.entrySet()) {
                    SwanAppPropertyWindow.this.f((String) entry.getKey(), entry.getValue());
                }
            }
            if (SwanAppPropertyWindow.this.aIg != null) {
                SwanAppPropertyWindow.this.aIg.sendEmptyMessageDelayed(0, 3000L);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Dr();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Dq();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i == 0) {
            Dq();
        } else {
            Dr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        String content;
        String tag;

        public a(String str) {
            this.tag = "title";
            this.content = str;
        }

        public a(String str, String str2) {
            this.tag = "title";
            this.tag = str;
            this.content = str2;
        }
    }
}
