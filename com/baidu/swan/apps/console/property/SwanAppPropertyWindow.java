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
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import d.b.g0.a.f;
import d.b.g0.a.g;
import d.b.g0.a.i;
import d.b.g0.a.i2.h0;
import d.b.g0.a.k;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class SwanAppPropertyWindow extends FrameLayout {
    public static final boolean i = k.f45443a;
    public static Map<String, String> j;

    /* renamed from: e  reason: collision with root package name */
    public b[] f11794e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, TextView> f11795f;

    /* renamed from: g  reason: collision with root package name */
    public c f11796g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, Object> f11797h;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScrollView f11798e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f11799f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f11800g;

        public a(ScrollView scrollView, TextView textView, String str) {
            this.f11798e = scrollView;
            this.f11799f = textView;
            this.f11800g = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f11798e.getVisibility() == 0) {
                this.f11798e.setVisibility(8);
            } else {
                this.f11798e.setVisibility(0);
            }
            String str = this.f11798e.getVisibility() == 0 ? "(点击关闭)" : "(点击打开)";
            TextView textView = this.f11799f;
            textView.setText(this.f11800g + str);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends Handler {
        public c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (SwanAppPropertyWindow.this.f11797h != null && SwanAppPropertyWindow.this.f11797h.size() > 0) {
                for (Map.Entry entry : SwanAppPropertyWindow.this.f11797h.entrySet()) {
                    SwanAppPropertyWindow.this.f((String) entry.getKey(), entry.getValue());
                }
            }
            if (SwanAppPropertyWindow.this.f11796g != null) {
                SwanAppPropertyWindow.this.f11796g.sendEmptyMessageDelayed(0, 3000L);
            }
        }

        public /* synthetic */ c(SwanAppPropertyWindow swanAppPropertyWindow, a aVar) {
            this();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        j = hashMap;
        hashMap.put(d.b.g0.a.c0.e.b.q, "api_info_expend");
        j.put(d.b.g0.a.c0.e.b.r, "prelink_info_expend");
    }

    public SwanAppPropertyWindow(Context context) {
        super(context);
        this.f11794e = new b[]{new b("对应开发者平台指标"), new b(d.b.g0.a.c0.e.b.m, "上屏时长：%s ms"), new b(d.b.g0.a.c0.e.b.k, "加载总时长(老指标)：%s ms"), new b("中间指标"), new b(d.b.g0.a.c0.e.b.l, "下载耗时：%s ms"), new b(d.b.g0.a.c0.e.b.j, "页面切换耗时：%s ms"), new b(d.b.g0.a.c0.e.b.n, "初次渲染耗时：%s ms"), new b(d.b.g0.a.c0.e.b.o, "再次渲染耗时：%s ms"), new b("frame", "帧率：%s fps"), new b("其他"), new b("cpu", "CPU：%s"), new b("mem", "内存：%sm"), new b(d.b.g0.a.c0.e.b.p, "数据缓存：%s B"), new b("prelink_info_expend", "预连接调用情况"), new b(d.b.g0.a.c0.e.b.r, "%s"), new b("api_info_expend", "启动过程API调用"), new b(d.b.g0.a.c0.e.b.q, "%s")};
        this.f11795f = new HashMap(this.f11794e.length);
        d(context);
    }

    public final void d(Context context) {
        b[] bVarArr;
        LayoutInflater.from(context).inflate(g.aiapps_property_window, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(f.ai_apps_property_root);
        for (b bVar : this.f11794e) {
            TextView textView = new TextView(context);
            if (TextUtils.equals(bVar.f11802a, "title")) {
                textView.setTextAppearance(context, i.SwanAppPropertyWindowTitle);
                textView.setText(bVar.f11803b);
            } else if (!TextUtils.equals(bVar.f11802a, "api_info_expend") && !TextUtils.equals(bVar.f11802a, "prelink_info_expend")) {
                textView.setTextAppearance(context, i.SwanAppPropertyWindowContent);
                textView.setTag(bVar.f11803b);
                textView.setVisibility(8);
            } else {
                textView.setTextAppearance(context, i.SwanAppPropertyWindowTitle);
                textView.setText(bVar.f11803b);
                int f2 = h0.f(5.0f);
                textView.setPadding(0, f2, 0, f2);
            }
            linearLayout.addView(textView);
            this.f11795f.put(bVar.f11802a, textView);
            if (j.containsKey(bVar.f11802a)) {
                e(linearLayout, context, j.get(bVar.f11802a), bVar.f11802a);
            }
        }
        g();
    }

    public final void e(LinearLayout linearLayout, Context context, String str, String str2) {
        ScrollView scrollView = new ScrollView(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, h0.f(200.0f));
        View view = (TextView) this.f11795f.get(str2);
        if (view != null) {
            linearLayout.removeView(view);
            linearLayout.addView(scrollView, layoutParams);
            scrollView.addView(view);
            scrollView.setVisibility(8);
        }
        TextView textView = this.f11795f.get(str);
        if (textView != null) {
            String charSequence = textView.getText().toString();
            String str3 = scrollView.getVisibility() == 0 ? "(点击关闭)" : "(点击打开)";
            textView.setText(charSequence + str3);
            textView.setOnClickListener(new a(scrollView, textView, charSequence));
        }
    }

    public final void f(String str, Object obj) {
        TextView textView = this.f11795f.get(str);
        if (textView != null) {
            textView.setText(String.format((String) textView.getTag(), obj));
            textView.setVisibility(0);
            if (i) {
                Log.d("SwanAppPropertyWindow", str + ZeusCrashHandler.NAME_SEPERATOR + obj);
            }
        }
    }

    public final void g() {
        if (i) {
            Log.d("SwanAppPropertyWindow", "Start system monitor");
        }
        if (this.f11797h == null) {
            this.f11797h = d.b.g0.a.c0.e.b.h().i();
        }
        if (this.f11796g == null) {
            c cVar = new c(this, null);
            this.f11796g = cVar;
            cVar.sendEmptyMessage(0);
        }
    }

    public final void h() {
        if (i) {
            Log.d("SwanAppPropertyWindow", "Stop system monitor");
        }
        if (this.f11797h != null) {
            d.b.g0.a.c0.e.b.h().j();
            this.f11797h = null;
        }
        c cVar = this.f11796g;
        if (cVar != null) {
            cVar.removeMessages(0);
            this.f11796g = null;
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

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i2) {
        if (i2 == 0) {
            g();
        } else {
            h();
        }
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public String f11802a;

        /* renamed from: b  reason: collision with root package name */
        public String f11803b;

        public b(String str) {
            this.f11802a = "title";
            this.f11803b = str;
        }

        public b(String str, String str2) {
            this.f11802a = "title";
            this.f11802a = str;
            this.f11803b = str2;
        }
    }

    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11794e = new b[]{new b("对应开发者平台指标"), new b(d.b.g0.a.c0.e.b.m, "上屏时长：%s ms"), new b(d.b.g0.a.c0.e.b.k, "加载总时长(老指标)：%s ms"), new b("中间指标"), new b(d.b.g0.a.c0.e.b.l, "下载耗时：%s ms"), new b(d.b.g0.a.c0.e.b.j, "页面切换耗时：%s ms"), new b(d.b.g0.a.c0.e.b.n, "初次渲染耗时：%s ms"), new b(d.b.g0.a.c0.e.b.o, "再次渲染耗时：%s ms"), new b("frame", "帧率：%s fps"), new b("其他"), new b("cpu", "CPU：%s"), new b("mem", "内存：%sm"), new b(d.b.g0.a.c0.e.b.p, "数据缓存：%s B"), new b("prelink_info_expend", "预连接调用情况"), new b(d.b.g0.a.c0.e.b.r, "%s"), new b("api_info_expend", "启动过程API调用"), new b(d.b.g0.a.c0.e.b.q, "%s")};
        this.f11795f = new HashMap(this.f11794e.length);
        d(context);
    }

    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11794e = new b[]{new b("对应开发者平台指标"), new b(d.b.g0.a.c0.e.b.m, "上屏时长：%s ms"), new b(d.b.g0.a.c0.e.b.k, "加载总时长(老指标)：%s ms"), new b("中间指标"), new b(d.b.g0.a.c0.e.b.l, "下载耗时：%s ms"), new b(d.b.g0.a.c0.e.b.j, "页面切换耗时：%s ms"), new b(d.b.g0.a.c0.e.b.n, "初次渲染耗时：%s ms"), new b(d.b.g0.a.c0.e.b.o, "再次渲染耗时：%s ms"), new b("frame", "帧率：%s fps"), new b("其他"), new b("cpu", "CPU：%s"), new b("mem", "内存：%sm"), new b(d.b.g0.a.c0.e.b.p, "数据缓存：%s B"), new b("prelink_info_expend", "预连接调用情况"), new b(d.b.g0.a.c0.e.b.r, "%s"), new b("api_info_expend", "启动过程API调用"), new b(d.b.g0.a.c0.e.b.q, "%s")};
        this.f11795f = new HashMap(this.f11794e.length);
        d(context);
    }
}
