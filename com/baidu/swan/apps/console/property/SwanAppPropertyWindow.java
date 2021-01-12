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
import com.baidu.swan.apps.ao.ah;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class SwanAppPropertyWindow extends FrameLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Map<String, String> cLI = new HashMap();
    private a[] cLH;
    private Map<String, TextView> cLJ;
    private b cLK;
    private Map<String, Object> mData;

    static {
        cLI.put(com.baidu.swan.apps.console.property.b.cLs, "api_info_expend");
        cLI.put(com.baidu.swan.apps.console.property.b.cLt, "prelink_info_expend");
    }

    public SwanAppPropertyWindow(Context context) {
        super(context);
        this.cLH = new a[]{new a("对应开发者平台指标"), new a(com.baidu.swan.apps.console.property.b.cLo, "上屏时长：%s ms"), new a(com.baidu.swan.apps.console.property.b.cLl, "加载总时长(老指标)：%s ms"), new a("中间指标"), new a(com.baidu.swan.apps.console.property.b.cLm, "下载耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.cLk, "页面切换耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.cLp, "初次渲染耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.cLq, "再次渲染耗时：%s ms"), new a("frame", "帧率：%s fps"), new a("其他"), new a("cpu", "CPU：%s"), new a("mem", "内存：%sm"), new a(com.baidu.swan.apps.console.property.b.cLr, "数据缓存：%s B"), new a("prelink_info_expend", "预连接调用情况"), new a(com.baidu.swan.apps.console.property.b.cLt, "%s"), new a("api_info_expend", "启动过程API调用"), new a(com.baidu.swan.apps.console.property.b.cLs, "%s")};
        this.cLJ = new HashMap(this.cLH.length);
        init(context);
    }

    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cLH = new a[]{new a("对应开发者平台指标"), new a(com.baidu.swan.apps.console.property.b.cLo, "上屏时长：%s ms"), new a(com.baidu.swan.apps.console.property.b.cLl, "加载总时长(老指标)：%s ms"), new a("中间指标"), new a(com.baidu.swan.apps.console.property.b.cLm, "下载耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.cLk, "页面切换耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.cLp, "初次渲染耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.cLq, "再次渲染耗时：%s ms"), new a("frame", "帧率：%s fps"), new a("其他"), new a("cpu", "CPU：%s"), new a("mem", "内存：%sm"), new a(com.baidu.swan.apps.console.property.b.cLr, "数据缓存：%s B"), new a("prelink_info_expend", "预连接调用情况"), new a(com.baidu.swan.apps.console.property.b.cLt, "%s"), new a("api_info_expend", "启动过程API调用"), new a(com.baidu.swan.apps.console.property.b.cLs, "%s")};
        this.cLJ = new HashMap(this.cLH.length);
        init(context);
    }

    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cLH = new a[]{new a("对应开发者平台指标"), new a(com.baidu.swan.apps.console.property.b.cLo, "上屏时长：%s ms"), new a(com.baidu.swan.apps.console.property.b.cLl, "加载总时长(老指标)：%s ms"), new a("中间指标"), new a(com.baidu.swan.apps.console.property.b.cLm, "下载耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.cLk, "页面切换耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.cLp, "初次渲染耗时：%s ms"), new a(com.baidu.swan.apps.console.property.b.cLq, "再次渲染耗时：%s ms"), new a("frame", "帧率：%s fps"), new a("其他"), new a("cpu", "CPU：%s"), new a("mem", "内存：%sm"), new a(com.baidu.swan.apps.console.property.b.cLr, "数据缓存：%s B"), new a("prelink_info_expend", "预连接调用情况"), new a(com.baidu.swan.apps.console.property.b.cLt, "%s"), new a("api_info_expend", "启动过程API调用"), new a(com.baidu.swan.apps.console.property.b.cLs, "%s")};
        this.cLJ = new HashMap(this.cLH.length);
        init(context);
    }

    private void init(Context context) {
        a[] aVarArr;
        LayoutInflater.from(context).inflate(a.g.aiapps_property_window, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(a.f.ai_apps_property_root);
        for (a aVar : this.cLH) {
            TextView textView = new TextView(context);
            if (TextUtils.equals(aVar.tag, "title")) {
                textView.setTextAppearance(context, a.i.SwanAppPropertyWindowTitle);
                textView.setText(aVar.content);
            } else if (TextUtils.equals(aVar.tag, "api_info_expend") || TextUtils.equals(aVar.tag, "prelink_info_expend")) {
                textView.setTextAppearance(context, a.i.SwanAppPropertyWindowTitle);
                textView.setText(aVar.content);
                int O = ah.O(5.0f);
                textView.setPadding(0, O, 0, O);
            } else {
                textView.setTextAppearance(context, a.i.SwanAppPropertyWindowContent);
                textView.setTag(aVar.content);
                textView.setVisibility(8);
            }
            linearLayout.addView(textView);
            this.cLJ.put(aVar.tag, textView);
            if (cLI.containsKey(aVar.tag)) {
                a(linearLayout, context, cLI.get(aVar.tag), aVar.tag);
            }
        }
        ama();
    }

    private void a(LinearLayout linearLayout, Context context, String str, String str2) {
        final ScrollView scrollView = new ScrollView(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ah.O(200.0f));
        View view = (TextView) this.cLJ.get(str2);
        if (view != null) {
            linearLayout.removeView(view);
            linearLayout.addView(scrollView, layoutParams);
            scrollView.addView(view);
            scrollView.setVisibility(8);
        }
        final TextView textView = this.cLJ.get(str);
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

    private void ama() {
        if (DEBUG) {
            Log.d("SwanAppPropertyWindow", "Start system monitor");
        }
        if (this.mData == null) {
            this.mData = com.baidu.swan.apps.console.property.b.alY().alZ();
        }
        if (this.cLK == null) {
            this.cLK = new b();
            this.cLK.sendEmptyMessage(0);
        }
    }

    private void amb() {
        if (DEBUG) {
            Log.d("SwanAppPropertyWindow", "Stop system monitor");
        }
        if (this.mData != null) {
            com.baidu.swan.apps.console.property.b.alY().recycle();
            this.mData = null;
        }
        if (this.cLK != null) {
            this.cLK.removeMessages(0);
            this.cLK = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, Object obj) {
        TextView textView = this.cLJ.get(str);
        if (textView != null) {
            textView.setText(String.format((String) textView.getTag(), obj));
            textView.setVisibility(0);
            if (DEBUG) {
                Log.d("SwanAppPropertyWindow", str + " : " + obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (SwanAppPropertyWindow.this.mData != null && SwanAppPropertyWindow.this.mData.size() > 0) {
                for (Map.Entry entry : SwanAppPropertyWindow.this.mData.entrySet()) {
                    SwanAppPropertyWindow.this.l((String) entry.getKey(), entry.getValue());
                }
            }
            if (SwanAppPropertyWindow.this.cLK != null) {
                SwanAppPropertyWindow.this.cLK.sendEmptyMessageDelayed(0, IMConnection.RETRY_DELAY_TIMES);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        amb();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ama();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i == 0) {
            ama();
        } else {
            amb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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
