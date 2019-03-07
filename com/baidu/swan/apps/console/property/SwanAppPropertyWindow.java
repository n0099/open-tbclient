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
import com.baidu.swan.apps.b;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class SwanAppPropertyWindow extends FrameLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private a[] anu;
    private Map<String, TextView> anv;
    private b anw;
    private Map<String, Object> mData;

    public SwanAppPropertyWindow(Context context) {
        super(context);
        this.anu = new a[]{new a("基础"), new a("cpu", "CPU：%s"), new a("mem", "内存：%sm"), new a("启动和切换"), new a(com.baidu.swan.apps.console.property.b.ana, "页面切换耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.anb, "启动耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.anc, "下载耗时：%s ms"), new a("渲染"), new a(com.baidu.swan.apps.console.property.b.and, "启动首屏渲染时长：%s ms"), new a(com.baidu.swan.apps.console.property.b.ane, "初次渲染耗时：%s ms"), new a("frame", "帧率：%s fps"), new a(com.baidu.swan.apps.console.property.b.anf, "再次渲染耗时：%s ms"), new a("其他"), new a(com.baidu.swan.apps.console.property.b.ang, "数据缓存：%s B")};
        this.anv = new HashMap(this.anu.length);
        init(context);
    }

    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anu = new a[]{new a("基础"), new a("cpu", "CPU：%s"), new a("mem", "内存：%sm"), new a("启动和切换"), new a(com.baidu.swan.apps.console.property.b.ana, "页面切换耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.anb, "启动耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.anc, "下载耗时：%s ms"), new a("渲染"), new a(com.baidu.swan.apps.console.property.b.and, "启动首屏渲染时长：%s ms"), new a(com.baidu.swan.apps.console.property.b.ane, "初次渲染耗时：%s ms"), new a("frame", "帧率：%s fps"), new a(com.baidu.swan.apps.console.property.b.anf, "再次渲染耗时：%s ms"), new a("其他"), new a(com.baidu.swan.apps.console.property.b.ang, "数据缓存：%s B")};
        this.anv = new HashMap(this.anu.length);
        init(context);
    }

    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.anu = new a[]{new a("基础"), new a("cpu", "CPU：%s"), new a("mem", "内存：%sm"), new a("启动和切换"), new a(com.baidu.swan.apps.console.property.b.ana, "页面切换耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.anb, "启动耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.anc, "下载耗时：%s ms"), new a("渲染"), new a(com.baidu.swan.apps.console.property.b.and, "启动首屏渲染时长：%s ms"), new a(com.baidu.swan.apps.console.property.b.ane, "初次渲染耗时：%s ms"), new a("frame", "帧率：%s fps"), new a(com.baidu.swan.apps.console.property.b.anf, "再次渲染耗时：%s ms"), new a("其他"), new a(com.baidu.swan.apps.console.property.b.ang, "数据缓存：%s B")};
        this.anv = new HashMap(this.anu.length);
        init(context);
    }

    private void init(Context context) {
        a[] aVarArr;
        LayoutInflater.from(context).inflate(b.g.aiapps_property_window, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(b.f.ai_apps_property_root);
        for (a aVar : this.anu) {
            TextView textView = new TextView(context);
            if (TextUtils.equals(aVar.tag, "title")) {
                textView.setTextAppearance(context, b.i.SwanAppPropertyWindowTitle);
                textView.setText(aVar.content);
            } else {
                textView.setTextAppearance(context, b.i.SwanAppPropertyWindowContent);
                textView.setTag(aVar.content);
                textView.setVisibility(8);
            }
            linearLayout.addView(textView);
            this.anv.put(aVar.tag, textView);
        }
        wV();
    }

    private void wV() {
        if (DEBUG) {
            Log.d("SwanAppPropertyWindow", "Start system monitor");
        }
        if (this.mData == null) {
            this.mData = com.baidu.swan.apps.console.property.b.wT().wU();
        }
        if (this.anw == null) {
            this.anw = new b();
            this.anw.sendEmptyMessage(0);
        }
    }

    private void wW() {
        if (DEBUG) {
            Log.d("SwanAppPropertyWindow", "Stop system monitor");
        }
        if (this.mData != null) {
            com.baidu.swan.apps.console.property.b.wT().recycle();
            this.mData = null;
        }
        if (this.anw != null) {
            this.anw.removeMessages(0);
            this.anw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, Object obj) {
        TextView textView = this.anv.get(str);
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
                    SwanAppPropertyWindow.this.h((String) entry.getKey(), entry.getValue());
                }
            }
            if (SwanAppPropertyWindow.this.anw != null) {
                SwanAppPropertyWindow.this.anw.sendEmptyMessageDelayed(0, 3000L);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        wW();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        wV();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i == 0) {
            wV();
        } else {
            wW();
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
