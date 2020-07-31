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
import com.baidu.swan.apps.aq.ai;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class SwanAppPropertyWindow extends FrameLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Map<String, String> bXQ = new HashMap();
    private a[] bXP;
    private Map<String, TextView> bXR;
    private b bXS;
    private Map<String, Object> mData;

    static {
        bXQ.put(com.baidu.swan.apps.console.property.b.bXA, "api_info_expend");
        bXQ.put(com.baidu.swan.apps.console.property.b.bXB, "prelink_info_expend");
    }

    public SwanAppPropertyWindow(Context context) {
        super(context);
        this.bXP = new a[]{new a("对应开发者平台指标"), new a(com.baidu.swan.apps.console.property.b.bXw, "上屏时长：%s ms"), new a(com.baidu.swan.apps.console.property.b.bXt, "加载总时长(老指标)：%s ms"), new a("中间指标"), new a(com.baidu.swan.apps.console.property.b.bXu, "下载耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bXs, "页面切换耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bXx, "初次渲染耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bXy, "再次渲染耗时：%s ms"), new a("frame", "帧率：%s fps"), new a("其他"), new a(com.baidu.fsg.face.base.b.c.i, "CPU：%s"), new a("mem", "内存：%sm"), new a(com.baidu.swan.apps.console.property.b.bXz, "数据缓存：%s B"), new a("prelink_info_expend", "预连接调用情况"), new a(com.baidu.swan.apps.console.property.b.bXB, "%s"), new a("api_info_expend", "启动过程API调用"), new a(com.baidu.swan.apps.console.property.b.bXA, "%s")};
        this.bXR = new HashMap(this.bXP.length);
        init(context);
    }

    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bXP = new a[]{new a("对应开发者平台指标"), new a(com.baidu.swan.apps.console.property.b.bXw, "上屏时长：%s ms"), new a(com.baidu.swan.apps.console.property.b.bXt, "加载总时长(老指标)：%s ms"), new a("中间指标"), new a(com.baidu.swan.apps.console.property.b.bXu, "下载耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bXs, "页面切换耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bXx, "初次渲染耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bXy, "再次渲染耗时：%s ms"), new a("frame", "帧率：%s fps"), new a("其他"), new a(com.baidu.fsg.face.base.b.c.i, "CPU：%s"), new a("mem", "内存：%sm"), new a(com.baidu.swan.apps.console.property.b.bXz, "数据缓存：%s B"), new a("prelink_info_expend", "预连接调用情况"), new a(com.baidu.swan.apps.console.property.b.bXB, "%s"), new a("api_info_expend", "启动过程API调用"), new a(com.baidu.swan.apps.console.property.b.bXA, "%s")};
        this.bXR = new HashMap(this.bXP.length);
        init(context);
    }

    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bXP = new a[]{new a("对应开发者平台指标"), new a(com.baidu.swan.apps.console.property.b.bXw, "上屏时长：%s ms"), new a(com.baidu.swan.apps.console.property.b.bXt, "加载总时长(老指标)：%s ms"), new a("中间指标"), new a(com.baidu.swan.apps.console.property.b.bXu, "下载耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bXs, "页面切换耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bXx, "初次渲染耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.bXy, "再次渲染耗时：%s ms"), new a("frame", "帧率：%s fps"), new a("其他"), new a(com.baidu.fsg.face.base.b.c.i, "CPU：%s"), new a("mem", "内存：%sm"), new a(com.baidu.swan.apps.console.property.b.bXz, "数据缓存：%s B"), new a("prelink_info_expend", "预连接调用情况"), new a(com.baidu.swan.apps.console.property.b.bXB, "%s"), new a("api_info_expend", "启动过程API调用"), new a(com.baidu.swan.apps.console.property.b.bXA, "%s")};
        this.bXR = new HashMap(this.bXP.length);
        init(context);
    }

    private void init(Context context) {
        a[] aVarArr;
        LayoutInflater.from(context).inflate(a.g.aiapps_property_window, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(a.f.ai_apps_property_root);
        for (a aVar : this.bXP) {
            TextView textView = new TextView(context);
            if (TextUtils.equals(aVar.tag, "title")) {
                textView.setTextAppearance(context, a.i.SwanAppPropertyWindowTitle);
                textView.setText(aVar.content);
            } else if (TextUtils.equals(aVar.tag, "api_info_expend") || TextUtils.equals(aVar.tag, "prelink_info_expend")) {
                textView.setTextAppearance(context, a.i.SwanAppPropertyWindowTitle);
                textView.setText(aVar.content);
                int D = ai.D(5.0f);
                textView.setPadding(0, D, 0, D);
            } else {
                textView.setTextAppearance(context, a.i.SwanAppPropertyWindowContent);
                textView.setTag(aVar.content);
                textView.setVisibility(8);
            }
            linearLayout.addView(textView);
            this.bXR.put(aVar.tag, textView);
            if (bXQ.containsKey(aVar.tag)) {
                a(linearLayout, context, bXQ.get(aVar.tag), aVar.tag);
            }
        }
        Ym();
    }

    private void a(LinearLayout linearLayout, Context context, String str, String str2) {
        final ScrollView scrollView = new ScrollView(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ai.D(200.0f));
        View view = (TextView) this.bXR.get(str2);
        if (view != null) {
            linearLayout.removeView(view);
            linearLayout.addView(scrollView, layoutParams);
            scrollView.addView(view);
            scrollView.setVisibility(8);
        }
        final TextView textView = this.bXR.get(str);
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

    private void Ym() {
        if (DEBUG) {
            Log.d("SwanAppPropertyWindow", "Start system monitor");
        }
        if (this.mData == null) {
            this.mData = com.baidu.swan.apps.console.property.b.Yk().Yl();
        }
        if (this.bXS == null) {
            this.bXS = new b();
            this.bXS.sendEmptyMessage(0);
        }
    }

    private void Yn() {
        if (DEBUG) {
            Log.d("SwanAppPropertyWindow", "Stop system monitor");
        }
        if (this.mData != null) {
            com.baidu.swan.apps.console.property.b.Yk().recycle();
            this.mData = null;
        }
        if (this.bXS != null) {
            this.bXS.removeMessages(0);
            this.bXS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str, Object obj) {
        TextView textView = this.bXR.get(str);
        if (textView != null) {
            textView.setText(String.format((String) textView.getTag(), obj));
            textView.setVisibility(0);
            if (DEBUG) {
                Log.d("SwanAppPropertyWindow", str + " : " + obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
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
            if (SwanAppPropertyWindow.this.bXS != null) {
                SwanAppPropertyWindow.this.bXS.sendEmptyMessageDelayed(0, 3000L);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Yn();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Ym();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i == 0) {
            Ym();
        } else {
            Yn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
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
