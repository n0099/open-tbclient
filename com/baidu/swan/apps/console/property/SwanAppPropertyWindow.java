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
/* loaded from: classes11.dex */
public class SwanAppPropertyWindow extends FrameLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a[] bld;
    private Map<String, TextView> ble;
    private b blf;
    private Map<String, Object> mData;

    public SwanAppPropertyWindow(Context context) {
        super(context);
        this.bld = new a[]{new a("基础"), new a(com.baidu.fsg.face.base.b.c.i, "CPU：%s"), new a("mem", "内存：%sm"), new a("启动和切换"), new a(com.baidu.swan.apps.console.property.b.bkJ, "页面切换耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bkK, "启动耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bkL, "下载耗时：%s ms"), new a("渲染"), new a(com.baidu.swan.apps.console.property.b.bkM, "启动首屏渲染时长：%s ms"), new a(com.baidu.swan.apps.console.property.b.bkN, "初次渲染耗时：%s ms"), new a("frame", "帧率：%s fps"), new a(com.baidu.swan.apps.console.property.b.bkO, "再次渲染耗时：%s ms"), new a("其他"), new a(com.baidu.swan.apps.console.property.b.bkP, "数据缓存：%s B")};
        this.ble = new HashMap(this.bld.length);
        init(context);
    }

    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bld = new a[]{new a("基础"), new a(com.baidu.fsg.face.base.b.c.i, "CPU：%s"), new a("mem", "内存：%sm"), new a("启动和切换"), new a(com.baidu.swan.apps.console.property.b.bkJ, "页面切换耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bkK, "启动耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bkL, "下载耗时：%s ms"), new a("渲染"), new a(com.baidu.swan.apps.console.property.b.bkM, "启动首屏渲染时长：%s ms"), new a(com.baidu.swan.apps.console.property.b.bkN, "初次渲染耗时：%s ms"), new a("frame", "帧率：%s fps"), new a(com.baidu.swan.apps.console.property.b.bkO, "再次渲染耗时：%s ms"), new a("其他"), new a(com.baidu.swan.apps.console.property.b.bkP, "数据缓存：%s B")};
        this.ble = new HashMap(this.bld.length);
        init(context);
    }

    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bld = new a[]{new a("基础"), new a(com.baidu.fsg.face.base.b.c.i, "CPU：%s"), new a("mem", "内存：%sm"), new a("启动和切换"), new a(com.baidu.swan.apps.console.property.b.bkJ, "页面切换耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bkK, "启动耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bkL, "下载耗时：%s ms"), new a("渲染"), new a(com.baidu.swan.apps.console.property.b.bkM, "启动首屏渲染时长：%s ms"), new a(com.baidu.swan.apps.console.property.b.bkN, "初次渲染耗时：%s ms"), new a("frame", "帧率：%s fps"), new a(com.baidu.swan.apps.console.property.b.bkO, "再次渲染耗时：%s ms"), new a("其他"), new a(com.baidu.swan.apps.console.property.b.bkP, "数据缓存：%s B")};
        this.ble = new HashMap(this.bld.length);
        init(context);
    }

    private void init(Context context) {
        a[] aVarArr;
        LayoutInflater.from(context).inflate(a.g.aiapps_property_window, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(a.f.ai_apps_property_root);
        for (a aVar : this.bld) {
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
            this.ble.put(aVar.tag, textView);
        }
        Mg();
    }

    private void Mg() {
        if (DEBUG) {
            Log.d("SwanAppPropertyWindow", "Start system monitor");
        }
        if (this.mData == null) {
            this.mData = com.baidu.swan.apps.console.property.b.Me().Mf();
        }
        if (this.blf == null) {
            this.blf = new b();
            this.blf.sendEmptyMessage(0);
        }
    }

    private void Mh() {
        if (DEBUG) {
            Log.d("SwanAppPropertyWindow", "Stop system monitor");
        }
        if (this.mData != null) {
            com.baidu.swan.apps.console.property.b.Me().recycle();
            this.mData = null;
        }
        if (this.blf != null) {
            this.blf.removeMessages(0);
            this.blf = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, Object obj) {
        TextView textView = this.ble.get(str);
        if (textView != null) {
            textView.setText(String.format((String) textView.getTag(), obj));
            textView.setVisibility(0);
            if (DEBUG) {
                Log.d("SwanAppPropertyWindow", str + " : " + obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (SwanAppPropertyWindow.this.mData != null && SwanAppPropertyWindow.this.mData.size() > 0) {
                for (Map.Entry entry : SwanAppPropertyWindow.this.mData.entrySet()) {
                    SwanAppPropertyWindow.this.g((String) entry.getKey(), entry.getValue());
                }
            }
            if (SwanAppPropertyWindow.this.blf != null) {
                SwanAppPropertyWindow.this.blf.sendEmptyMessageDelayed(0, 3000L);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Mh();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Mg();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i == 0) {
            Mg();
        } else {
            Mh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
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
