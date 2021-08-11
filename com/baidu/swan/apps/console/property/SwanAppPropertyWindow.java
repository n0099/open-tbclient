package com.baidu.swan.apps.console.property;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import c.a.n0.a.f;
import c.a.n0.a.g;
import c.a.n0.a.i;
import c.a.n0.a.k;
import c.a.n0.a.v2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.text.FormattableUtils;
/* loaded from: classes6.dex */
public class SwanAppPropertyWindow extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_TITLE = "title";

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f45628i;

    /* renamed from: j  reason: collision with root package name */
    public static Map<String, String> f45629j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b[] f45630e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, TextView> f45631f;

    /* renamed from: g  reason: collision with root package name */
    public c f45632g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, Object> f45633h;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScrollView f45634e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f45635f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45636g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SwanAppPropertyWindow f45637h;

        public a(SwanAppPropertyWindow swanAppPropertyWindow, ScrollView scrollView, TextView textView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppPropertyWindow, scrollView, textView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45637h = swanAppPropertyWindow;
            this.f45634e = scrollView;
            this.f45635f = textView;
            this.f45636g = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f45634e.getVisibility() == 0) {
                    this.f45634e.setVisibility(8);
                } else {
                    this.f45634e.setVisibility(0);
                }
                String str = this.f45634e.getVisibility() == 0 ? "(点击关闭)" : "(点击打开)";
                TextView textView = this.f45635f;
                textView.setText(this.f45636g + str);
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes6.dex */
    public class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppPropertyWindow f45641a;

        public c(SwanAppPropertyWindow swanAppPropertyWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppPropertyWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45641a = swanAppPropertyWindow;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                if (this.f45641a.f45633h != null && this.f45641a.f45633h.size() > 0) {
                    for (Map.Entry entry : this.f45641a.f45633h.entrySet()) {
                        this.f45641a.f((String) entry.getKey(), entry.getValue());
                    }
                }
                if (this.f45641a.f45632g != null) {
                    this.f45641a.f45632g.sendEmptyMessageDelayed(0, 3000L);
                }
            }
        }

        public /* synthetic */ c(SwanAppPropertyWindow swanAppPropertyWindow, a aVar) {
            this(swanAppPropertyWindow);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(165896827, "Lcom/baidu/swan/apps/console/property/SwanAppPropertyWindow;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(165896827, "Lcom/baidu/swan/apps/console/property/SwanAppPropertyWindow;");
                return;
            }
        }
        f45628i = k.f6803a;
        HashMap hashMap = new HashMap();
        f45629j = hashMap;
        hashMap.put(c.a.n0.a.e0.g.b.q, "api_info_expend");
        f45629j.put(c.a.n0.a.e0.g.b.r, "prelink_info_expend");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppPropertyWindow(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45630e = new b[]{new b(this, "对应开发者平台指标"), new b(this, c.a.n0.a.e0.g.b.m, "上屏时长：%s ms"), new b(this, c.a.n0.a.e0.g.b.k, "加载总时长(老指标)：%s ms"), new b(this, "中间指标"), new b(this, c.a.n0.a.e0.g.b.l, "下载耗时：%s ms"), new b(this, c.a.n0.a.e0.g.b.f5046j, "页面切换耗时：%s ms"), new b(this, c.a.n0.a.e0.g.b.n, "初次渲染耗时：%s ms"), new b(this, c.a.n0.a.e0.g.b.o, "再次渲染耗时：%s ms"), new b(this, "frame", "帧率：%s fps"), new b(this, "其他"), new b(this, "cpu", "CPU：%s"), new b(this, "mem", "内存：%sm"), new b(this, c.a.n0.a.e0.g.b.p, "数据缓存：%s B"), new b(this, "prelink_info_expend", "预连接调用情况"), new b(this, c.a.n0.a.e0.g.b.r, FormattableUtils.SIMPLEST_FORMAT), new b(this, "api_info_expend", "启动过程API调用"), new b(this, c.a.n0.a.e0.g.b.q, FormattableUtils.SIMPLEST_FORMAT)};
        this.f45631f = new HashMap(this.f45630e.length);
        d(context);
    }

    public final void d(Context context) {
        b[] bVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(g.aiapps_property_window, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(f.ai_apps_property_root);
            for (b bVar : this.f45630e) {
                TextView textView = new TextView(context);
                if (TextUtils.equals(bVar.f45638a, "title")) {
                    textView.setTextAppearance(context, i.SwanAppPropertyWindowTitle);
                    textView.setText(bVar.f45639b);
                } else if (!TextUtils.equals(bVar.f45638a, "api_info_expend") && !TextUtils.equals(bVar.f45638a, "prelink_info_expend")) {
                    textView.setTextAppearance(context, i.SwanAppPropertyWindowContent);
                    textView.setTag(bVar.f45639b);
                    textView.setVisibility(8);
                } else {
                    textView.setTextAppearance(context, i.SwanAppPropertyWindowTitle);
                    textView.setText(bVar.f45639b);
                    int g2 = n0.g(5.0f);
                    textView.setPadding(0, g2, 0, g2);
                }
                linearLayout.addView(textView);
                this.f45631f.put(bVar.f45638a, textView);
                if (f45629j.containsKey(bVar.f45638a)) {
                    e(linearLayout, context, f45629j.get(bVar.f45638a), bVar.f45638a);
                }
            }
            g();
        }
    }

    public final void e(LinearLayout linearLayout, Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearLayout, context, str, str2) == null) {
            ScrollView scrollView = new ScrollView(context);
            ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, n0.g(200.0f));
            View view = (TextView) this.f45631f.get(str2);
            if (view != null) {
                linearLayout.removeView(view);
                linearLayout.addView(scrollView, layoutParams);
                scrollView.addView(view);
                scrollView.setVisibility(8);
            }
            TextView textView = this.f45631f.get(str);
            if (textView != null) {
                String charSequence = textView.getText().toString();
                String str3 = scrollView.getVisibility() == 0 ? "(点击关闭)" : "(点击打开)";
                textView.setText(charSequence + str3);
                textView.setOnClickListener(new a(this, scrollView, textView, charSequence));
            }
        }
    }

    public final void f(String str, Object obj) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, obj) == null) || (textView = this.f45631f.get(str)) == null) {
            return;
        }
        textView.setText(String.format((String) textView.getTag(), obj));
        textView.setVisibility(0);
        if (f45628i) {
            String str2 = str + ZeusCrashHandler.NAME_SEPERATOR + obj;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean z = f45628i;
            if (this.f45633h == null) {
                this.f45633h = c.a.n0.a.e0.g.b.h().i();
            }
            if (this.f45632g == null) {
                c cVar = new c(this, null);
                this.f45632g = cVar;
                cVar.sendEmptyMessage(0);
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = f45628i;
            if (this.f45633h != null) {
                c.a.n0.a.e0.g.b.h().j();
                this.f45633h = null;
            }
            c cVar = this.f45632g;
            if (cVar != null) {
                cVar.removeMessages(0);
                this.f45632g = null;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            g();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            h();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, view, i2) == null) {
            if (i2 == 0) {
                g();
            } else {
                h();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f45638a;

        /* renamed from: b  reason: collision with root package name */
        public String f45639b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SwanAppPropertyWindow f45640c;

        public b(SwanAppPropertyWindow swanAppPropertyWindow, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppPropertyWindow, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45640c = swanAppPropertyWindow;
            this.f45638a = "title";
            this.f45639b = str;
        }

        public b(SwanAppPropertyWindow swanAppPropertyWindow, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppPropertyWindow, str, str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f45640c = swanAppPropertyWindow;
            this.f45638a = "title";
            this.f45638a = str;
            this.f45639b = str2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f45630e = new b[]{new b(this, "对应开发者平台指标"), new b(this, c.a.n0.a.e0.g.b.m, "上屏时长：%s ms"), new b(this, c.a.n0.a.e0.g.b.k, "加载总时长(老指标)：%s ms"), new b(this, "中间指标"), new b(this, c.a.n0.a.e0.g.b.l, "下载耗时：%s ms"), new b(this, c.a.n0.a.e0.g.b.f5046j, "页面切换耗时：%s ms"), new b(this, c.a.n0.a.e0.g.b.n, "初次渲染耗时：%s ms"), new b(this, c.a.n0.a.e0.g.b.o, "再次渲染耗时：%s ms"), new b(this, "frame", "帧率：%s fps"), new b(this, "其他"), new b(this, "cpu", "CPU：%s"), new b(this, "mem", "内存：%sm"), new b(this, c.a.n0.a.e0.g.b.p, "数据缓存：%s B"), new b(this, "prelink_info_expend", "预连接调用情况"), new b(this, c.a.n0.a.e0.g.b.r, FormattableUtils.SIMPLEST_FORMAT), new b(this, "api_info_expend", "启动过程API调用"), new b(this, c.a.n0.a.e0.g.b.q, FormattableUtils.SIMPLEST_FORMAT)};
        this.f45631f = new HashMap(this.f45630e.length);
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f45630e = new b[]{new b(this, "对应开发者平台指标"), new b(this, c.a.n0.a.e0.g.b.m, "上屏时长：%s ms"), new b(this, c.a.n0.a.e0.g.b.k, "加载总时长(老指标)：%s ms"), new b(this, "中间指标"), new b(this, c.a.n0.a.e0.g.b.l, "下载耗时：%s ms"), new b(this, c.a.n0.a.e0.g.b.f5046j, "页面切换耗时：%s ms"), new b(this, c.a.n0.a.e0.g.b.n, "初次渲染耗时：%s ms"), new b(this, c.a.n0.a.e0.g.b.o, "再次渲染耗时：%s ms"), new b(this, "frame", "帧率：%s fps"), new b(this, "其他"), new b(this, "cpu", "CPU：%s"), new b(this, "mem", "内存：%sm"), new b(this, c.a.n0.a.e0.g.b.p, "数据缓存：%s B"), new b(this, "prelink_info_expend", "预连接调用情况"), new b(this, c.a.n0.a.e0.g.b.r, FormattableUtils.SIMPLEST_FORMAT), new b(this, "api_info_expend", "启动过程API调用"), new b(this, c.a.n0.a.e0.g.b.q, FormattableUtils.SIMPLEST_FORMAT)};
        this.f45631f = new HashMap(this.f45630e.length);
        d(context);
    }
}
