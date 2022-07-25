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
import com.repackage.fy1;
import com.repackage.sg1;
import com.repackage.zd3;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class SwanAppPropertyWindow extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public static Map<String, String> f;
    public transient /* synthetic */ FieldHolder $fh;
    public b[] a;
    public Map<String, TextView> b;
    public c c;
    public Map<String, Object> d;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollView a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ String c;
        public final /* synthetic */ SwanAppPropertyWindow d;

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
            this.d = swanAppPropertyWindow;
            this.a = scrollView;
            this.b = textView;
            this.c = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.getVisibility() == 0) {
                    this.a.setVisibility(8);
                } else {
                    this.a.setVisibility(0);
                }
                String str = this.a.getVisibility() == 0 ? "(点击关闭)" : "(点击打开)";
                TextView textView = this.b;
                textView.setText(this.c + str);
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes2.dex */
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
                if (this.a.d != null && this.a.d.size() > 0) {
                    for (Map.Entry entry : this.a.d.entrySet()) {
                        this.a.f((String) entry.getKey(), entry.getValue());
                    }
                }
                if (this.a.c != null) {
                    this.a.c.sendEmptyMessageDelayed(0, 3000L);
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
        e = sg1.a;
        HashMap hashMap = new HashMap();
        f = hashMap;
        hashMap.put(fy1.q, "api_info_expend");
        f.put(fy1.r, "prelink_info_expend");
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
        this.a = new b[]{new b(this, "对应开发者平台指标"), new b(this, fy1.m, "上屏时长：%s ms"), new b(this, fy1.k, "加载总时长(老指标)：%s ms"), new b(this, "中间指标"), new b(this, fy1.l, "下载耗时：%s ms"), new b(this, fy1.j, "页面切换耗时：%s ms"), new b(this, fy1.n, "初次渲染耗时：%s ms"), new b(this, fy1.o, "再次渲染耗时：%s ms"), new b(this, "frame", "帧率：%s fps"), new b(this, "其他"), new b(this, "cpu", "CPU：%s"), new b(this, "mem", "内存：%sm"), new b(this, fy1.p, "数据缓存：%s B"), new b(this, "prelink_info_expend", "预连接调用情况"), new b(this, fy1.r, "%s"), new b(this, "api_info_expend", "启动过程API调用"), new b(this, fy1.q, "%s")};
        this.b = new HashMap(this.a.length);
        d(context);
    }

    public final void d(Context context) {
        b[] bVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00c0, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090177);
            for (b bVar : this.a) {
                TextView textView = new TextView(context);
                if (TextUtils.equals(bVar.a, "title")) {
                    textView.setTextAppearance(context, R.style.obfuscated_res_0x7f1001a7);
                    textView.setText(bVar.b);
                } else if (!TextUtils.equals(bVar.a, "api_info_expend") && !TextUtils.equals(bVar.a, "prelink_info_expend")) {
                    textView.setTextAppearance(context, R.style.obfuscated_res_0x7f1001a6);
                    textView.setTag(bVar.b);
                    textView.setVisibility(8);
                } else {
                    textView.setTextAppearance(context, R.style.obfuscated_res_0x7f1001a7);
                    textView.setText(bVar.b);
                    int g = zd3.g(5.0f);
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
    }

    public final void e(LinearLayout linearLayout, Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearLayout, context, str, str2) == null) {
            ScrollView scrollView = new ScrollView(context);
            ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, zd3.g(200.0f));
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
                String str3 = scrollView.getVisibility() == 0 ? "(点击关闭)" : "(点击打开)";
                textView.setText(charSequence + str3);
                textView.setOnClickListener(new a(this, scrollView, textView, charSequence));
            }
        }
    }

    public final void f(String str, Object obj) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, obj) == null) || (textView = this.b.get(str)) == null) {
            return;
        }
        textView.setText(String.format((String) textView.getTag(), obj));
        textView.setVisibility(0);
        if (e) {
            Log.d("SwanAppPropertyWindow", str + ZeusCrashHandler.NAME_SEPERATOR + obj);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (e) {
                Log.d("SwanAppPropertyWindow", "Start system monitor");
            }
            if (this.d == null) {
                this.d = fy1.g().h();
            }
            if (this.c == null) {
                c cVar = new c(this, null);
                this.c = cVar;
                cVar.sendEmptyMessage(0);
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (e) {
                Log.d("SwanAppPropertyWindow", "Stop system monitor");
            }
            if (this.d != null) {
                fy1.g().i();
                this.d = null;
            }
            c cVar = this.c;
            if (cVar != null) {
                cVar.removeMessages(0);
                this.c = null;
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
    public void onVisibilityChanged(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, view2, i) == null) {
            if (i == 0) {
                g();
            } else {
                h();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ SwanAppPropertyWindow c;

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
            this.c = swanAppPropertyWindow;
            this.a = "title";
            this.b = str;
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
            this.c = swanAppPropertyWindow;
            this.a = "title";
            this.a = str;
            this.b = str2;
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
        this.a = new b[]{new b(this, "对应开发者平台指标"), new b(this, fy1.m, "上屏时长：%s ms"), new b(this, fy1.k, "加载总时长(老指标)：%s ms"), new b(this, "中间指标"), new b(this, fy1.l, "下载耗时：%s ms"), new b(this, fy1.j, "页面切换耗时：%s ms"), new b(this, fy1.n, "初次渲染耗时：%s ms"), new b(this, fy1.o, "再次渲染耗时：%s ms"), new b(this, "frame", "帧率：%s fps"), new b(this, "其他"), new b(this, "cpu", "CPU：%s"), new b(this, "mem", "内存：%sm"), new b(this, fy1.p, "数据缓存：%s B"), new b(this, "prelink_info_expend", "预连接调用情况"), new b(this, fy1.r, "%s"), new b(this, "api_info_expend", "启动过程API调用"), new b(this, fy1.q, "%s")};
        this.b = new HashMap(this.a.length);
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
        this.a = new b[]{new b(this, "对应开发者平台指标"), new b(this, fy1.m, "上屏时长：%s ms"), new b(this, fy1.k, "加载总时长(老指标)：%s ms"), new b(this, "中间指标"), new b(this, fy1.l, "下载耗时：%s ms"), new b(this, fy1.j, "页面切换耗时：%s ms"), new b(this, fy1.n, "初次渲染耗时：%s ms"), new b(this, fy1.o, "再次渲染耗时：%s ms"), new b(this, "frame", "帧率：%s fps"), new b(this, "其他"), new b(this, "cpu", "CPU：%s"), new b(this, "mem", "内存：%sm"), new b(this, fy1.p, "数据缓存：%s B"), new b(this, "prelink_info_expend", "预连接调用情况"), new b(this, fy1.r, "%s"), new b(this, "api_info_expend", "启动过程API调用"), new b(this, fy1.q, "%s")};
        this.b = new HashMap(this.a.length);
        d(context);
    }
}
