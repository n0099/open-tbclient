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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ah;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class SwanAppPropertyWindow extends FrameLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Map<String, String> cAw = new HashMap();
    private a[] cAv;
    private Map<String, TextView> cAx;
    private b cAy;
    private Map<String, Object> mData;

    static {
        cAw.put(com.baidu.swan.apps.console.property.b.cAg, "api_info_expend");
        cAw.put(com.baidu.swan.apps.console.property.b.cAh, "prelink_info_expend");
    }

    public SwanAppPropertyWindow(Context context) {
        super(context);
        this.cAv = new a[]{new a("对应开发者平台指标"), new a(com.baidu.swan.apps.console.property.b.cAc, "上屏时长：%s ms"), new a(com.baidu.swan.apps.console.property.b.czZ, "加载总时长(老指标)：%s ms"), new a("中间指标"), new a(com.baidu.swan.apps.console.property.b.cAa, "下载耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.czY, "页面切换耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.cAd, "初次渲染耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.cAe, "再次渲染耗时：%s ms"), new a("frame", "帧率：%s fps"), new a("其他"), new a(com.baidu.fsg.face.base.b.c.i, "CPU：%s"), new a("mem", "内存：%sm"), new a(com.baidu.swan.apps.console.property.b.cAf, "数据缓存：%s B"), new a("prelink_info_expend", "预连接调用情况"), new a(com.baidu.swan.apps.console.property.b.cAh, "%s"), new a("api_info_expend", "启动过程API调用"), new a(com.baidu.swan.apps.console.property.b.cAg, "%s")};
        this.cAx = new HashMap(this.cAv.length);
        init(context);
    }

    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cAv = new a[]{new a("对应开发者平台指标"), new a(com.baidu.swan.apps.console.property.b.cAc, "上屏时长：%s ms"), new a(com.baidu.swan.apps.console.property.b.czZ, "加载总时长(老指标)：%s ms"), new a("中间指标"), new a(com.baidu.swan.apps.console.property.b.cAa, "下载耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.czY, "页面切换耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.cAd, "初次渲染耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.cAe, "再次渲染耗时：%s ms"), new a("frame", "帧率：%s fps"), new a("其他"), new a(com.baidu.fsg.face.base.b.c.i, "CPU：%s"), new a("mem", "内存：%sm"), new a(com.baidu.swan.apps.console.property.b.cAf, "数据缓存：%s B"), new a("prelink_info_expend", "预连接调用情况"), new a(com.baidu.swan.apps.console.property.b.cAh, "%s"), new a("api_info_expend", "启动过程API调用"), new a(com.baidu.swan.apps.console.property.b.cAg, "%s")};
        this.cAx = new HashMap(this.cAv.length);
        init(context);
    }

    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cAv = new a[]{new a("对应开发者平台指标"), new a(com.baidu.swan.apps.console.property.b.cAc, "上屏时长：%s ms"), new a(com.baidu.swan.apps.console.property.b.czZ, "加载总时长(老指标)：%s ms"), new a("中间指标"), new a(com.baidu.swan.apps.console.property.b.cAa, "下载耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.czY, "页面切换耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.cAd, "初次渲染耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.cAe, "再次渲染耗时：%s ms"), new a("frame", "帧率：%s fps"), new a("其他"), new a(com.baidu.fsg.face.base.b.c.i, "CPU：%s"), new a("mem", "内存：%sm"), new a(com.baidu.swan.apps.console.property.b.cAf, "数据缓存：%s B"), new a("prelink_info_expend", "预连接调用情况"), new a(com.baidu.swan.apps.console.property.b.cAh, "%s"), new a("api_info_expend", "启动过程API调用"), new a(com.baidu.swan.apps.console.property.b.cAg, "%s")};
        this.cAx = new HashMap(this.cAv.length);
        init(context);
    }

    private void init(Context context) {
        a[] aVarArr;
        LayoutInflater.from(context).inflate(a.g.aiapps_property_window, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(a.f.ai_apps_property_root);
        for (a aVar : this.cAv) {
            TextView textView = new TextView(context);
            if (TextUtils.equals(aVar.tag, "title")) {
                textView.setTextAppearance(context, a.i.SwanAppPropertyWindowTitle);
                textView.setText(aVar.content);
            } else if (TextUtils.equals(aVar.tag, "api_info_expend") || TextUtils.equals(aVar.tag, "prelink_info_expend")) {
                textView.setTextAppearance(context, a.i.SwanAppPropertyWindowTitle);
                textView.setText(aVar.content);
                int L = ah.L(5.0f);
                textView.setPadding(0, L, 0, L);
            } else {
                textView.setTextAppearance(context, a.i.SwanAppPropertyWindowContent);
                textView.setTag(aVar.content);
                textView.setVisibility(8);
            }
            linearLayout.addView(textView);
            this.cAx.put(aVar.tag, textView);
            if (cAw.containsKey(aVar.tag)) {
                a(linearLayout, context, cAw.get(aVar.tag), aVar.tag);
            }
        }
        ajH();
    }

    private void a(LinearLayout linearLayout, Context context, String str, String str2) {
        final ScrollView scrollView = new ScrollView(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ah.L(200.0f));
        View view = (TextView) this.cAx.get(str2);
        if (view != null) {
            linearLayout.removeView(view);
            linearLayout.addView(scrollView, layoutParams);
            scrollView.addView(view);
            scrollView.setVisibility(8);
        }
        final TextView textView = this.cAx.get(str);
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

    private void ajH() {
        if (DEBUG) {
            Log.d("SwanAppPropertyWindow", "Start system monitor");
        }
        if (this.mData == null) {
            this.mData = com.baidu.swan.apps.console.property.b.ajF().ajG();
        }
        if (this.cAy == null) {
            this.cAy = new b();
            this.cAy.sendEmptyMessage(0);
        }
    }

    private void ajI() {
        if (DEBUG) {
            Log.d("SwanAppPropertyWindow", "Stop system monitor");
        }
        if (this.mData != null) {
            com.baidu.swan.apps.console.property.b.ajF().recycle();
            this.mData = null;
        }
        if (this.cAy != null) {
            this.cAy.removeMessages(0);
            this.cAy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str, Object obj) {
        TextView textView = this.cAx.get(str);
        if (textView != null) {
            textView.setText(String.format((String) textView.getTag(), obj));
            textView.setVisibility(0);
            if (DEBUG) {
                Log.d("SwanAppPropertyWindow", str + " : " + obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
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
            if (SwanAppPropertyWindow.this.cAy != null) {
                SwanAppPropertyWindow.this.cAy.sendEmptyMessageDelayed(0, IMConnection.RETRY_DELAY_TIMES);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ajI();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ajH();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i == 0) {
            ajH();
        } else {
            ajI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
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
