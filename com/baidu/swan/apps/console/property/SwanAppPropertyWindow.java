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
import c.a.n0.a.p2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.kwad.v8.debug.ExecutionState;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class SwanAppPropertyWindow extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f28810e;

    /* renamed from: f  reason: collision with root package name */
    public static Map<String, String> f28811f;
    public transient /* synthetic */ FieldHolder $fh;
    public b[] a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, TextView> f28812b;

    /* renamed from: c  reason: collision with root package name */
    public c f28813c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, Object> f28814d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextView f28815b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f28816c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SwanAppPropertyWindow f28817d;

        public a(SwanAppPropertyWindow swanAppPropertyWindow, ScrollView scrollView, TextView textView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppPropertyWindow, scrollView, textView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28817d = swanAppPropertyWindow;
            this.a = scrollView;
            this.f28815b = textView;
            this.f28816c = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.getVisibility() == 0) {
                    this.a.setVisibility(8);
                } else {
                    this.a.setVisibility(0);
                }
                String str = this.a.getVisibility() == 0 ? "(点击关闭)" : "(点击打开)";
                TextView textView = this.f28815b;
                textView.setText(this.f28816c + str);
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes4.dex */
    public class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppPropertyWindow a;

        public c(SwanAppPropertyWindow swanAppPropertyWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppPropertyWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppPropertyWindow;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                if (this.a.f28814d != null && this.a.f28814d.size() > 0) {
                    for (Map.Entry entry : this.a.f28814d.entrySet()) {
                        this.a.f((String) entry.getKey(), entry.getValue());
                    }
                }
                if (this.a.f28813c != null) {
                    this.a.f28813c.sendEmptyMessageDelayed(0, 3000L);
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
        f28810e = c.a.n0.a.a.a;
        HashMap hashMap = new HashMap();
        f28811f = hashMap;
        hashMap.put(c.a.n0.a.u.g.b.q, "api_info_expend");
        f28811f.put(c.a.n0.a.u.g.b.r, "prelink_info_expend");
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new b[]{new b(this, "对应开发者平台指标"), new b(this, c.a.n0.a.u.g.b.m, "上屏时长：%s ms"), new b(this, c.a.n0.a.u.g.b.k, "加载总时长(老指标)：%s ms"), new b(this, "中间指标"), new b(this, c.a.n0.a.u.g.b.l, "下载耗时：%s ms"), new b(this, c.a.n0.a.u.g.b.j, "页面切换耗时：%s ms"), new b(this, c.a.n0.a.u.g.b.n, "初次渲染耗时：%s ms"), new b(this, c.a.n0.a.u.g.b.o, "再次渲染耗时：%s ms"), new b(this, ExecutionState.FRAME, "帧率：%s fps"), new b(this, "其他"), new b(this, "cpu", "CPU：%s"), new b(this, "mem", "内存：%sm"), new b(this, c.a.n0.a.u.g.b.p, "数据缓存：%s B"), new b(this, "prelink_info_expend", "预连接调用情况"), new b(this, c.a.n0.a.u.g.b.r, "%s"), new b(this, "api_info_expend", "启动过程API调用"), new b(this, c.a.n0.a.u.g.b.q, "%s")};
        this.f28812b = new HashMap(this.a.length);
        d(context);
    }

    public final void d(Context context) {
        b[] bVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00c7, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09017b);
            for (b bVar : this.a) {
                TextView textView = new TextView(context);
                if (TextUtils.equals(bVar.a, "title")) {
                    textView.setTextAppearance(context, R.style.obfuscated_res_0x7f1001a3);
                    textView.setText(bVar.f28818b);
                } else if (!TextUtils.equals(bVar.a, "api_info_expend") && !TextUtils.equals(bVar.a, "prelink_info_expend")) {
                    textView.setTextAppearance(context, R.style.obfuscated_res_0x7f1001a2);
                    textView.setTag(bVar.f28818b);
                    textView.setVisibility(8);
                } else {
                    textView.setTextAppearance(context, R.style.obfuscated_res_0x7f1001a3);
                    textView.setText(bVar.f28818b);
                    int g2 = n0.g(5.0f);
                    textView.setPadding(0, g2, 0, g2);
                }
                linearLayout.addView(textView);
                this.f28812b.put(bVar.a, textView);
                if (f28811f.containsKey(bVar.a)) {
                    e(linearLayout, context, f28811f.get(bVar.a), bVar.a);
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
            View view = (TextView) this.f28812b.get(str2);
            if (view != null) {
                linearLayout.removeView(view);
                linearLayout.addView(scrollView, layoutParams);
                scrollView.addView(view);
                scrollView.setVisibility(8);
            }
            TextView textView = this.f28812b.get(str);
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
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, obj) == null) || (textView = this.f28812b.get(str)) == null) {
            return;
        }
        textView.setText(String.format((String) textView.getTag(), obj));
        textView.setVisibility(0);
        if (f28810e) {
            Log.d("SwanAppPropertyWindow", str + ZeusCrashHandler.NAME_SEPERATOR + obj);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (f28810e) {
                Log.d("SwanAppPropertyWindow", "Start system monitor");
            }
            if (this.f28814d == null) {
                this.f28814d = c.a.n0.a.u.g.b.g().h();
            }
            if (this.f28813c == null) {
                c cVar = new c(this, null);
                this.f28813c = cVar;
                cVar.sendEmptyMessage(0);
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f28810e) {
                Log.d("SwanAppPropertyWindow", "Stop system monitor");
            }
            if (this.f28814d != null) {
                c.a.n0.a.u.g.b.g().i();
                this.f28814d = null;
            }
            c cVar = this.f28813c;
            if (cVar != null) {
                cVar.removeMessages(0);
                this.f28813c = null;
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
    public void onVisibilityChanged(View view, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, view, i) == null) {
            if (i == 0) {
                g();
            } else {
                h();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f28818b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SwanAppPropertyWindow f28819c;

        public b(SwanAppPropertyWindow swanAppPropertyWindow, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppPropertyWindow, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28819c = swanAppPropertyWindow;
            this.a = "title";
            this.f28818b = str;
        }

        public b(SwanAppPropertyWindow swanAppPropertyWindow, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppPropertyWindow, str, str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f28819c = swanAppPropertyWindow;
            this.a = "title";
            this.a = str;
            this.f28818b = str2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new b[]{new b(this, "对应开发者平台指标"), new b(this, c.a.n0.a.u.g.b.m, "上屏时长：%s ms"), new b(this, c.a.n0.a.u.g.b.k, "加载总时长(老指标)：%s ms"), new b(this, "中间指标"), new b(this, c.a.n0.a.u.g.b.l, "下载耗时：%s ms"), new b(this, c.a.n0.a.u.g.b.j, "页面切换耗时：%s ms"), new b(this, c.a.n0.a.u.g.b.n, "初次渲染耗时：%s ms"), new b(this, c.a.n0.a.u.g.b.o, "再次渲染耗时：%s ms"), new b(this, ExecutionState.FRAME, "帧率：%s fps"), new b(this, "其他"), new b(this, "cpu", "CPU：%s"), new b(this, "mem", "内存：%sm"), new b(this, c.a.n0.a.u.g.b.p, "数据缓存：%s B"), new b(this, "prelink_info_expend", "预连接调用情况"), new b(this, c.a.n0.a.u.g.b.r, "%s"), new b(this, "api_info_expend", "启动过程API调用"), new b(this, c.a.n0.a.u.g.b.q, "%s")};
        this.f28812b = new HashMap(this.a.length);
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppPropertyWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = new b[]{new b(this, "对应开发者平台指标"), new b(this, c.a.n0.a.u.g.b.m, "上屏时长：%s ms"), new b(this, c.a.n0.a.u.g.b.k, "加载总时长(老指标)：%s ms"), new b(this, "中间指标"), new b(this, c.a.n0.a.u.g.b.l, "下载耗时：%s ms"), new b(this, c.a.n0.a.u.g.b.j, "页面切换耗时：%s ms"), new b(this, c.a.n0.a.u.g.b.n, "初次渲染耗时：%s ms"), new b(this, c.a.n0.a.u.g.b.o, "再次渲染耗时：%s ms"), new b(this, ExecutionState.FRAME, "帧率：%s fps"), new b(this, "其他"), new b(this, "cpu", "CPU：%s"), new b(this, "mem", "内存：%sm"), new b(this, c.a.n0.a.u.g.b.p, "数据缓存：%s B"), new b(this, "prelink_info_expend", "预连接调用情况"), new b(this, c.a.n0.a.u.g.b.r, "%s"), new b(this, "api_info_expend", "启动过程API调用"), new b(this, c.a.n0.a.u.g.b.q, "%s")};
        this.f28812b = new HashMap(this.a.length);
        d(context);
    }
}
