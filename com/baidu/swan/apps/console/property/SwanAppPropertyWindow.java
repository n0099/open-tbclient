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
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import d.a.m0.a.f;
import d.a.m0.a.g;
import d.a.m0.a.i;
import d.a.m0.a.k;
import d.a.m0.a.v2.n0;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class SwanAppPropertyWindow extends FrameLayout {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f10825i = k.f46983a;
    public static Map<String, String> j;

    /* renamed from: e  reason: collision with root package name */
    public b[] f10826e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, TextView> f10827f;

    /* renamed from: g  reason: collision with root package name */
    public c f10828g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, Object> f10829h;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScrollView f10830e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f10831f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f10832g;

        public a(ScrollView scrollView, TextView textView, String str) {
            this.f10830e = scrollView;
            this.f10831f = textView;
            this.f10832g = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f10830e.getVisibility() == 0) {
                this.f10830e.setVisibility(8);
            } else {
                this.f10830e.setVisibility(0);
            }
            String str = this.f10830e.getVisibility() == 0 ? "(点击关闭)" : "(点击打开)";
            TextView textView = this.f10831f;
            textView.setText(this.f10832g + str);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes3.dex */
    public class c extends Handler {
        public c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (SwanAppPropertyWindow.this.f10829h != null && SwanAppPropertyWindow.this.f10829h.size() > 0) {
                for (Map.Entry entry : SwanAppPropertyWindow.this.f10829h.entrySet()) {
                    SwanAppPropertyWindow.this.f((String) entry.getKey(), entry.getValue());
                }
            }
            if (SwanAppPropertyWindow.this.f10828g != null) {
                SwanAppPropertyWindow.this.f10828g.sendEmptyMessageDelayed(0, 3000L);
            }
        }

        public /* synthetic */ c(SwanAppPropertyWindow swanAppPropertyWindow, a aVar) {
            this();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        j = hashMap;
        hashMap.put(d.a.m0.a.e0.g.b.q, "api_info_expend");
        j.put(d.a.m0.a.e0.g.b.r, "prelink_info_expend");
    }

    public SwanAppPropertyWindow(Context context) {
        super(context);
        this.f10826e = new b[]{new b("对应开发者平台指标"), new b(d.a.m0.a.e0.g.b.m, "上屏时长：%s ms"), new b(d.a.m0.a.e0.g.b.k, "加载总时长(老指标)：%s ms"), new b("中间指标"), new b(d.a.m0.a.e0.g.b.l, "下载耗时：%s ms"), new b(d.a.m0.a.e0.g.b.j, "页面切换耗时：%s ms"), new b(d.a.m0.a.e0.g.b.n, "初次渲染耗时：%s ms"), new b(d.a.m0.a.e0.g.b.o, "再次渲染耗时：%s ms"), new b("frame", "帧率：%s fps"), new b("其他"), new b("cpu", "CPU：%s"), new b("mem", "内存：%sm"), new b(d.a.m0.a.e0.g.b.p, "数据缓存：%s B"), new b("prelink_info_expend", "预连接调用情况"), new b(d.a.m0.a.e0.g.b.r, "%s"), new b("api_info_expend", "启动过程API调用"), new b(d.a.m0.a.e0.g.b.q, "%s")};
        this.f10827f = new HashMap(this.f10826e.length);
        d(context);
    }

    public final void d(Context context) {
        b[] bVarArr;
        LayoutInflater.from(context).inflate(g.aiapps_property_window, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(f.ai_apps_property_root);
        for (b bVar : this.f10826e) {
            TextView textView = new TextView(context);
            if (TextUtils.equals(bVar.f10834a, "title")) {
                textView.setTextAppearance(context, i.SwanAppPropertyWindowTitle);
                textView.setText(bVar.f10835b);
            } else if (!TextUtils.equals(bVar.f10834a, "api_info_expend") && !TextUtils.equals(bVar.f10834a, "prelink_info_expend")) {
                textView.setTextAppearance(context, i.SwanAppPropertyWindowContent);
                textView.setTag(bVar.f10835b);
                textView.setVisibility(8);
            } else {
                textView.setTextAppearance(context, i.SwanAppPropertyWindowTitle);
                textView.setText(bVar.f10835b);
                int g2 = n0.g(5.0f);
                textView.setPadding(0, g2, 0, g2);
            }
            linearLayout.addView(textView);
            this.f10827f.put(bVar.f10834a, textView);
            if (j.containsKey(bVar.f10834a)) {
                e(linearLayout, context, j.get(bVar.f10834a), bVar.f10834a);
            }
        }
        g();
    }

    public final void e(LinearLayout linearLayout, Context context, String str, String str2) {
        ScrollView scrollView = new ScrollView(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, n0.g(200.0f));
        View view = (TextView) this.f10827f.get(str2);
        if (view != null) {
            linearLayout.removeView(view);
            linearLayout.addView(scrollView, layoutParams);
            scrollView.addView(view);
            scrollView.setVisibility(8);
        }
        TextView textView = this.f10827f.get(str);
        if (textView != null) {
            String charSequence = textView.getText().toString();
            String str3 = scrollView.getVisibility() == 0 ? "(点击关闭)" : "(点击打开)";
            textView.setText(charSequence + str3);
            textView.setOnClickListener(new a(scrollView, textView, charSequence));
        }
    }

    public final void f(String str, Object obj) {
        TextView textView = this.f10827f.get(str);
        if (textView != null) {
            textView.setText(String.format((String) textView.getTag(), obj));
            textView.setVisibility(0);
            if (f10825i) {
                Log.d("SwanAppPropertyWindow", str + ZeusCrashHandler.NAME_SEPERATOR + obj);
            }
        }
    }

    public final void g() {
        if (f10825i) {
            Log.d("SwanAppPropertyWindow", "Start system monitor");
        }
        if (this.f10829h == null) {
            this.f10829h = d.a.m0.a.e0.g.b.h().i();
        }
        if (this.f10828g == null) {
            c cVar = new c(this, null);
            this.f10828g = cVar;
            cVar.sendEmptyMessage(0);
        }
    }

    public final void h() {
        if (f10825i) {
            Log.d("SwanAppPropertyWindow", "Stop system monitor");
        }
        if (this.f10829h != null) {
            d.a.m0.a.e0.g.b.h().j();
            this.f10829h = null;
        }
        c cVar = this.f10828g;
        if (cVar != null) {
            cVar.removeMessages(0);
            this.f10828g = null;
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

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public String f10834a;

        /* renamed from: b  reason: collision with root package name */
        public String f10835b;

        public b(String str) {
            this.f10834a = "title";
            this.f10835b = str;
        }

        public b(String str, String str2) {
            this.f10834a = "title";
            this.f10834a = str;
            this.f10835b = str2;
        }
    }

    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10826e = new b[]{new b("对应开发者平台指标"), new b(d.a.m0.a.e0.g.b.m, "上屏时长：%s ms"), new b(d.a.m0.a.e0.g.b.k, "加载总时长(老指标)：%s ms"), new b("中间指标"), new b(d.a.m0.a.e0.g.b.l, "下载耗时：%s ms"), new b(d.a.m0.a.e0.g.b.j, "页面切换耗时：%s ms"), new b(d.a.m0.a.e0.g.b.n, "初次渲染耗时：%s ms"), new b(d.a.m0.a.e0.g.b.o, "再次渲染耗时：%s ms"), new b("frame", "帧率：%s fps"), new b("其他"), new b("cpu", "CPU：%s"), new b("mem", "内存：%sm"), new b(d.a.m0.a.e0.g.b.p, "数据缓存：%s B"), new b("prelink_info_expend", "预连接调用情况"), new b(d.a.m0.a.e0.g.b.r, "%s"), new b("api_info_expend", "启动过程API调用"), new b(d.a.m0.a.e0.g.b.q, "%s")};
        this.f10827f = new HashMap(this.f10826e.length);
        d(context);
    }

    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f10826e = new b[]{new b("对应开发者平台指标"), new b(d.a.m0.a.e0.g.b.m, "上屏时长：%s ms"), new b(d.a.m0.a.e0.g.b.k, "加载总时长(老指标)：%s ms"), new b("中间指标"), new b(d.a.m0.a.e0.g.b.l, "下载耗时：%s ms"), new b(d.a.m0.a.e0.g.b.j, "页面切换耗时：%s ms"), new b(d.a.m0.a.e0.g.b.n, "初次渲染耗时：%s ms"), new b(d.a.m0.a.e0.g.b.o, "再次渲染耗时：%s ms"), new b("frame", "帧率：%s fps"), new b("其他"), new b("cpu", "CPU：%s"), new b("mem", "内存：%sm"), new b(d.a.m0.a.e0.g.b.p, "数据缓存：%s B"), new b("prelink_info_expend", "预连接调用情况"), new b(d.a.m0.a.e0.g.b.r, "%s"), new b("api_info_expend", "启动过程API调用"), new b(d.a.m0.a.e0.g.b.q, "%s")};
        this.f10827f = new HashMap(this.f10826e.length);
        d(context);
    }
}
