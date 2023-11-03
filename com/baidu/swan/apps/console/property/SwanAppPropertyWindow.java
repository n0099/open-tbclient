package com.baidu.swan.apps.console.property;

import android.annotation.SuppressLint;
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
import com.baidu.tieba.R;
import com.baidu.tieba.d42;
import com.baidu.tieba.rm1;
import com.baidu.tieba.xj3;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class SwanAppPropertyWindow extends FrameLayout {
    public static final boolean e = rm1.a;
    public static Map<String, String> f;
    public b[] a;
    public Map<String, TextView> b;
    public c c;
    public Map<String, Object> d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ ScrollView a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ String c;

        public a(ScrollView scrollView, TextView textView, String str) {
            this.a = scrollView;
            this.b = textView;
            this.c = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            if (this.a.getVisibility() == 0) {
                this.a.setVisibility(8);
            } else {
                this.a.setVisibility(0);
            }
            if (this.a.getVisibility() == 0) {
                str = "(点击关闭)";
            } else {
                str = "(点击打开)";
            }
            TextView textView = this.b;
            textView.setText(this.c + str);
        }
    }

    /* loaded from: classes4.dex */
    public class b {
        public String a;
        public String b;

        public b(String str) {
            this.a = "title";
            this.b = str;
        }

        public b(String str, String str2) {
            this.a = "title";
            this.a = str;
            this.b = str2;
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes4.dex */
    public class c extends Handler {
        public c() {
        }

        public /* synthetic */ c(SwanAppPropertyWindow swanAppPropertyWindow, a aVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (SwanAppPropertyWindow.this.d != null && SwanAppPropertyWindow.this.d.size() > 0) {
                for (Map.Entry entry : SwanAppPropertyWindow.this.d.entrySet()) {
                    SwanAppPropertyWindow.this.f((String) entry.getKey(), entry.getValue());
                }
            }
            if (SwanAppPropertyWindow.this.c != null) {
                SwanAppPropertyWindow.this.c.sendEmptyMessageDelayed(0, 3000L);
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f = hashMap;
        hashMap.put(d42.q, "api_info_expend");
        f.put(d42.r, "prelink_info_expend");
    }

    public final void g() {
        if (e) {
            Log.d("SwanAppPropertyWindow", "Start system monitor");
        }
        if (this.d == null) {
            this.d = d42.g().h();
        }
        if (this.c == null) {
            c cVar = new c(this, null);
            this.c = cVar;
            cVar.sendEmptyMessage(0);
        }
    }

    public final void h() {
        if (e) {
            Log.d("SwanAppPropertyWindow", "Stop system monitor");
        }
        if (this.d != null) {
            d42.g().i();
            this.d = null;
        }
        c cVar = this.c;
        if (cVar != null) {
            cVar.removeMessages(0);
            this.c = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    public SwanAppPropertyWindow(Context context) {
        super(context);
        this.a = new b[]{new b("对应开发者平台指标"), new b(d42.m, "上屏时长：%s ms"), new b(d42.k, "加载总时长(老指标)：%s ms"), new b("中间指标"), new b(d42.l, "下载耗时：%s ms"), new b(d42.j, "页面切换耗时：%s ms"), new b(d42.n, "初次渲染耗时：%s ms"), new b(d42.o, "再次渲染耗时：%s ms"), new b("frame", "帧率：%s fps"), new b("其他"), new b("cpu", "CPU：%s"), new b("mem", "内存：%sm"), new b(d42.p, "数据缓存：%s B"), new b("prelink_info_expend", "预连接调用情况"), new b(d42.r, "%s"), new b("api_info_expend", "启动过程API调用"), new b(d42.q, "%s")};
        this.b = new HashMap(this.a.length);
        d(context);
    }

    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new b[]{new b("对应开发者平台指标"), new b(d42.m, "上屏时长：%s ms"), new b(d42.k, "加载总时长(老指标)：%s ms"), new b("中间指标"), new b(d42.l, "下载耗时：%s ms"), new b(d42.j, "页面切换耗时：%s ms"), new b(d42.n, "初次渲染耗时：%s ms"), new b(d42.o, "再次渲染耗时：%s ms"), new b("frame", "帧率：%s fps"), new b("其他"), new b("cpu", "CPU：%s"), new b("mem", "内存：%sm"), new b(d42.p, "数据缓存：%s B"), new b("prelink_info_expend", "预连接调用情况"), new b(d42.r, "%s"), new b("api_info_expend", "启动过程API调用"), new b(d42.q, "%s")};
        this.b = new HashMap(this.a.length);
        d(context);
    }

    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new b[]{new b("对应开发者平台指标"), new b(d42.m, "上屏时长：%s ms"), new b(d42.k, "加载总时长(老指标)：%s ms"), new b("中间指标"), new b(d42.l, "下载耗时：%s ms"), new b(d42.j, "页面切换耗时：%s ms"), new b(d42.n, "初次渲染耗时：%s ms"), new b(d42.o, "再次渲染耗时：%s ms"), new b("frame", "帧率：%s fps"), new b("其他"), new b("cpu", "CPU：%s"), new b("mem", "内存：%sm"), new b(d42.p, "数据缓存：%s B"), new b("prelink_info_expend", "预连接调用情况"), new b(d42.r, "%s"), new b("api_info_expend", "启动过程API调用"), new b(d42.q, "%s")};
        this.b = new HashMap(this.a.length);
        d(context);
    }

    public final void d(Context context) {
        b[] bVarArr;
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00cb, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09019f);
        for (b bVar : this.a) {
            TextView textView = new TextView(context);
            if (TextUtils.equals(bVar.a, "title")) {
                textView.setTextAppearance(context, R.style.obfuscated_res_0x7f1001bf);
                textView.setText(bVar.b);
            } else if (!TextUtils.equals(bVar.a, "api_info_expend") && !TextUtils.equals(bVar.a, "prelink_info_expend")) {
                textView.setTextAppearance(context, R.style.obfuscated_res_0x7f1001be);
                textView.setTag(bVar.b);
                textView.setVisibility(8);
            } else {
                textView.setTextAppearance(context, R.style.obfuscated_res_0x7f1001bf);
                textView.setText(bVar.b);
                int g = xj3.g(5.0f);
                textView.setPadding(0, g, 0, g);
            }
            linearLayout.addView(textView);
            this.b.put(bVar.a, textView);
            if (f.containsKey(bVar.a)) {
                e(linearLayout, context, f.get(bVar.a), bVar.a);
            }
        }
        g();
    }

    public final void e(LinearLayout linearLayout, Context context, String str, String str2) {
        String str3;
        ScrollView scrollView = new ScrollView(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, xj3.g(200.0f));
        View view2 = (TextView) this.b.get(str2);
        if (view2 != null) {
            linearLayout.removeView(view2);
            linearLayout.addView(scrollView, layoutParams);
            scrollView.addView(view2);
            scrollView.setVisibility(8);
        }
        TextView textView = this.b.get(str);
        if (textView != null) {
            String charSequence = textView.getText().toString();
            if (scrollView.getVisibility() == 0) {
                str3 = "(点击关闭)";
            } else {
                str3 = "(点击打开)";
            }
            textView.setText(charSequence + str3);
            textView.setOnClickListener(new a(scrollView, textView, charSequence));
        }
    }

    public final void f(String str, Object obj) {
        TextView textView = this.b.get(str);
        if (textView != null) {
            textView.setText(String.format((String) textView.getTag(), obj));
            textView.setVisibility(0);
            if (e) {
                Log.d("SwanAppPropertyWindow", str + ZeusCrashHandler.NAME_SEPERATOR + obj);
            }
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view2, int i) {
        if (i == 0) {
            g();
        } else {
            h();
        }
    }
}
