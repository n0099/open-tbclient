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
    private a[] bWX;
    private Map<String, TextView> bWY;
    private b bWZ;
    private Map<String, Object> mData;

    public SwanAppPropertyWindow(Context context) {
        super(context);
        this.bWX = new a[]{new a("对应开发者平台指标"), new a(com.baidu.swan.apps.console.property.b.bWF, "上屏时长：%s ms"), new a(com.baidu.swan.apps.console.property.b.bWC, "加载总时长(老指标)：%s ms"), new a("中间指标"), new a(com.baidu.swan.apps.console.property.b.bWD, "下载耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bWB, "页面切换耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bWG, "初次渲染耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bWH, "再次渲染耗时：%s ms"), new a("frame", "帧率：%s fps"), new a("其他"), new a(com.baidu.fsg.face.base.b.c.i, "CPU：%s"), new a("mem", "内存：%sm"), new a(com.baidu.swan.apps.console.property.b.bWI, "数据缓存：%s B"), new a("api_info_expend", "启动过程API调用"), new a(com.baidu.swan.apps.console.property.b.bWJ, "%s")};
        this.bWY = new HashMap(this.bWX.length);
        init(context);
    }

    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bWX = new a[]{new a("对应开发者平台指标"), new a(com.baidu.swan.apps.console.property.b.bWF, "上屏时长：%s ms"), new a(com.baidu.swan.apps.console.property.b.bWC, "加载总时长(老指标)：%s ms"), new a("中间指标"), new a(com.baidu.swan.apps.console.property.b.bWD, "下载耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bWB, "页面切换耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bWG, "初次渲染耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bWH, "再次渲染耗时：%s ms"), new a("frame", "帧率：%s fps"), new a("其他"), new a(com.baidu.fsg.face.base.b.c.i, "CPU：%s"), new a("mem", "内存：%sm"), new a(com.baidu.swan.apps.console.property.b.bWI, "数据缓存：%s B"), new a("api_info_expend", "启动过程API调用"), new a(com.baidu.swan.apps.console.property.b.bWJ, "%s")};
        this.bWY = new HashMap(this.bWX.length);
        init(context);
    }

    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bWX = new a[]{new a("对应开发者平台指标"), new a(com.baidu.swan.apps.console.property.b.bWF, "上屏时长：%s ms"), new a(com.baidu.swan.apps.console.property.b.bWC, "加载总时长(老指标)：%s ms"), new a("中间指标"), new a(com.baidu.swan.apps.console.property.b.bWD, "下载耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bWB, "页面切换耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bWG, "初次渲染耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bWH, "再次渲染耗时：%s ms"), new a("frame", "帧率：%s fps"), new a("其他"), new a(com.baidu.fsg.face.base.b.c.i, "CPU：%s"), new a("mem", "内存：%sm"), new a(com.baidu.swan.apps.console.property.b.bWI, "数据缓存：%s B"), new a("api_info_expend", "启动过程API调用"), new a(com.baidu.swan.apps.console.property.b.bWJ, "%s")};
        this.bWY = new HashMap(this.bWX.length);
        init(context);
    }

    private void init(Context context) {
        a[] aVarArr;
        LayoutInflater.from(context).inflate(a.g.aiapps_property_window, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(a.f.ai_apps_property_root);
        for (a aVar : this.bWX) {
            TextView textView = new TextView(context);
            if (TextUtils.equals(aVar.tag, "title")) {
                textView.setTextAppearance(context, a.i.SwanAppPropertyWindowTitle);
                textView.setText(aVar.content);
            } else if (TextUtils.equals(aVar.tag, "api_info_expend")) {
                textView.setTextAppearance(context, a.i.SwanAppPropertyWindowTitle);
                textView.setText(aVar.content);
                int D = ag.D(5.0f);
                textView.setPadding(0, D, 0, D);
            } else {
                textView.setTextAppearance(context, a.i.SwanAppPropertyWindowContent);
                textView.setTag(aVar.content);
                textView.setVisibility(8);
            }
            linearLayout.addView(textView);
            this.bWY.put(aVar.tag, textView);
        }
        a(linearLayout, context);
        XG();
    }

    private void a(LinearLayout linearLayout, Context context) {
        final ScrollView scrollView = new ScrollView(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ag.D(200.0f));
        View view = (TextView) this.bWY.get(com.baidu.swan.apps.console.property.b.bWJ);
        if (view != null) {
            linearLayout.removeView(view);
            linearLayout.addView(scrollView, layoutParams);
            scrollView.addView(view);
            scrollView.setVisibility(8);
        }
        final TextView textView = this.bWY.get("api_info_expend");
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

    private void XG() {
        if (DEBUG) {
            Log.d("SwanAppPropertyWindow", "Start system monitor");
        }
        if (this.mData == null) {
            this.mData = com.baidu.swan.apps.console.property.b.XE().XF();
        }
        if (this.bWZ == null) {
            this.bWZ = new b();
            this.bWZ.sendEmptyMessage(0);
        }
    }

    private void XH() {
        if (DEBUG) {
            Log.d("SwanAppPropertyWindow", "Stop system monitor");
        }
        if (this.mData != null) {
            com.baidu.swan.apps.console.property.b.XE().recycle();
            this.mData = null;
        }
        if (this.bWZ != null) {
            this.bWZ.removeMessages(0);
            this.bWZ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str, Object obj) {
        TextView textView = this.bWY.get(str);
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
            if (SwanAppPropertyWindow.this.bWZ != null) {
                SwanAppPropertyWindow.this.bWZ.sendEmptyMessageDelayed(0, 3000L);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        XH();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        XG();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i == 0) {
            XG();
        } else {
            XH();
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
