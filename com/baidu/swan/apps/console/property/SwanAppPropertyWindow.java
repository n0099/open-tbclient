package com.baidu.swan.apps.console.property;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ag;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class SwanAppPropertyWindow extends FrameLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a[] bSj;
    private Map<String, TextView> bSk;
    private b bSl;
    private Map<String, Object> mData;

    public SwanAppPropertyWindow(Context context) {
        super(context);
        this.bSj = new a[]{new a("对应开发者平台指标"), new a(com.baidu.swan.apps.console.property.b.bRR, "上屏时长：%s ms"), new a(com.baidu.swan.apps.console.property.b.bRO, "加载总时长(老指标)：%s ms"), new a("中间指标"), new a(com.baidu.swan.apps.console.property.b.bRP, "下载耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bRN, "页面切换耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bRS, "初次渲染耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bRT, "再次渲染耗时：%s ms"), new a("frame", "帧率：%s fps"), new a("其他"), new a(com.baidu.fsg.face.base.b.c.i, "CPU：%s"), new a("mem", "内存：%sm"), new a(com.baidu.swan.apps.console.property.b.bRU, "数据缓存：%s B"), new a("api_info_expend", "启动过程API调用"), new a(com.baidu.swan.apps.console.property.b.bRV, "%s")};
        this.bSk = new HashMap(this.bSj.length);
        init(context);
    }

    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bSj = new a[]{new a("对应开发者平台指标"), new a(com.baidu.swan.apps.console.property.b.bRR, "上屏时长：%s ms"), new a(com.baidu.swan.apps.console.property.b.bRO, "加载总时长(老指标)：%s ms"), new a("中间指标"), new a(com.baidu.swan.apps.console.property.b.bRP, "下载耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bRN, "页面切换耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bRS, "初次渲染耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bRT, "再次渲染耗时：%s ms"), new a("frame", "帧率：%s fps"), new a("其他"), new a(com.baidu.fsg.face.base.b.c.i, "CPU：%s"), new a("mem", "内存：%sm"), new a(com.baidu.swan.apps.console.property.b.bRU, "数据缓存：%s B"), new a("api_info_expend", "启动过程API调用"), new a(com.baidu.swan.apps.console.property.b.bRV, "%s")};
        this.bSk = new HashMap(this.bSj.length);
        init(context);
    }

    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bSj = new a[]{new a("对应开发者平台指标"), new a(com.baidu.swan.apps.console.property.b.bRR, "上屏时长：%s ms"), new a(com.baidu.swan.apps.console.property.b.bRO, "加载总时长(老指标)：%s ms"), new a("中间指标"), new a(com.baidu.swan.apps.console.property.b.bRP, "下载耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bRN, "页面切换耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bRS, "初次渲染耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bRT, "再次渲染耗时：%s ms"), new a("frame", "帧率：%s fps"), new a("其他"), new a(com.baidu.fsg.face.base.b.c.i, "CPU：%s"), new a("mem", "内存：%sm"), new a(com.baidu.swan.apps.console.property.b.bRU, "数据缓存：%s B"), new a("api_info_expend", "启动过程API调用"), new a(com.baidu.swan.apps.console.property.b.bRV, "%s")};
        this.bSk = new HashMap(this.bSj.length);
        init(context);
    }

    private void init(Context context) {
        a[] aVarArr;
        LayoutInflater.from(context).inflate(a.g.aiapps_property_window, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(a.f.ai_apps_property_root);
        for (a aVar : this.bSj) {
            TextView textView = new TextView(context);
            if (TextUtils.equals(aVar.tag, "title")) {
                textView.setTextAppearance(context, a.i.SwanAppPropertyWindowTitle);
                textView.setText(aVar.content);
            } else if (TextUtils.equals(aVar.tag, "api_info_expend")) {
                textView.setTextAppearance(context, a.i.SwanAppPropertyWindowTitle);
                textView.setText(aVar.content);
                int B = ag.B(5.0f);
                textView.setPadding(0, B, 0, B);
            } else {
                textView.setTextAppearance(context, a.i.SwanAppPropertyWindowContent);
                textView.setTag(aVar.content);
                textView.setVisibility(8);
            }
            linearLayout.addView(textView);
            this.bSk.put(aVar.tag, textView);
        }
        a(linearLayout, context);
        WA();
    }

    private void a(LinearLayout linearLayout, Context context) {
        final ScrollView scrollView = new ScrollView(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ag.B(200.0f));
        View view = (TextView) this.bSk.get(com.baidu.swan.apps.console.property.b.bRV);
        if (view != null) {
            linearLayout.removeView(view);
            linearLayout.addView(scrollView, layoutParams);
            scrollView.addView(view);
            scrollView.setVisibility(8);
        }
        final TextView textView = this.bSk.get("api_info_expend");
        if (textView != null) {
            final String charSequence = textView.getText().toString();
            textView.setText(charSequence + (scrollView.getVisibility() == 0 ? "(点击关闭)" : "(点击打开)"));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.console.property.SwanAppPropertyWindow.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (scrollView.getVisibility() == 0) {
                        scrollView.setVisibility(8);
                    } else {
                        scrollView.setVisibility(0);
                    }
                    textView.setText(charSequence + (scrollView.getVisibility() == 0 ? "(点击关闭)" : "(点击打开)"));
                }
            });
        }
    }

    private void WA() {
        if (DEBUG) {
            Log.d("SwanAppPropertyWindow", "Start system monitor");
        }
        if (this.mData == null) {
            this.mData = com.baidu.swan.apps.console.property.b.Wy().Wz();
        }
        if (this.bSl == null) {
            this.bSl = new b();
            this.bSl.sendEmptyMessage(0);
        }
    }

    private void WB() {
        if (DEBUG) {
            Log.d("SwanAppPropertyWindow", "Stop system monitor");
        }
        if (this.mData != null) {
            com.baidu.swan.apps.console.property.b.Wy().recycle();
            this.mData = null;
        }
        if (this.bSl != null) {
            this.bSl.removeMessages(0);
            this.bSl = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str, Object obj) {
        TextView textView = this.bSk.get(str);
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
                    SwanAppPropertyWindow.this.m((String) entry.getKey(), entry.getValue());
                }
            }
            if (SwanAppPropertyWindow.this.bSl != null) {
                SwanAppPropertyWindow.this.bSl.sendEmptyMessageDelayed(0, 3000L);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WB();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        WA();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i == 0) {
            WA();
        } else {
            WB();
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
