package c.a.j.l.h.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.j.l.h.d.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f4085e;

        public a(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4085e = runnable;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f4085e.run();
                return Unit.INSTANCE;
            }
            return (Unit) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f4086e;

        public b(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4086e = runnable;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f4086e.run();
                return Unit.INSTANCE;
            }
            return (Unit) invokeV.objValue;
        }
    }

    /* renamed from: c.a.j.l.h.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class View$OnClickListenerC0176c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a f4087e;

        public View$OnClickListenerC0176c(b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4087e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f4087e.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4088e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f4089f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f4090g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ LinearLayout f4091h;

        /* loaded from: classes.dex */
        public class a implements Function0<Unit> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f4092e;

            /* renamed from: c.a.j.l.h.d.c$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0177a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f4093e;

                public RunnableC0177a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f4093e = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        d dVar = this.f4093e.f4092e;
                        dVar.f4090g.a(dVar.f4091h);
                    }
                }
            }

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4092e = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public Unit invoke() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    c.a.j.h.d.e.c(new RunnableC0177a(this));
                    return Unit.INSTANCE;
                }
                return (Unit) invokeV.objValue;
            }
        }

        /* loaded from: classes.dex */
        public class b implements Function0<Unit> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f4094e;

            /* loaded from: classes.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ b f4095e;

                public a(b bVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f4095e = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        d dVar = this.f4095e.f4094e;
                        dVar.f4090g.a(dVar.f4091h);
                    }
                }
            }

            public b(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4094e = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public Unit invoke() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    c.a.j.h.d.e.c(new a(this));
                    return Unit.INSTANCE;
                }
                return (Unit) invokeV.objValue;
            }
        }

        public d(String str, TextView textView, e eVar, LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, textView, eVar, linearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4088e = str;
            this.f4089f = textView;
            this.f4090g = eVar;
            this.f4091h = linearLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.f4088e)) {
                    com.baidu.bdtask.ui.utils.d.a.b(this.f4088e, this.f4089f, new a(this), new b(this));
                } else {
                    this.f4090g.a(this.f4091h);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(ViewGroup viewGroup);
    }

    public static ViewGroup a(Context context, CharSequence charSequence, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, context, charSequence, str, str2)) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(applicationContext).inflate(c.a.j.l.f.sdk_normal_toast_view, (ViewGroup) null);
            GradientDrawable gradientDrawable = (GradientDrawable) resources.getDrawable(c.a.j.l.d.sdk_normal_toast_view_bg);
            gradientDrawable.setColor(c.a.j.l.i.b.a.a(str, resources.getColor(c.a.j.l.b.task_sdk_toast_bg_color_default)));
            gradientDrawable.setAlpha(204);
            relativeLayout.setBackground(gradientDrawable);
            TextView textView = (TextView) relativeLayout.findViewById(c.a.j.l.e.normal_toast_text);
            if (textView != null) {
                textView.setTextColor(c.a.j.l.i.b.a.a(str2, resources.getColor(c.a.j.l.b.task_sdk_text_color_default)));
                textView.setText(charSequence);
            }
            return relativeLayout;
        }
        return (ViewGroup) invokeLLLL.objValue;
    }

    public static void b(Context context, CharSequence charSequence, int i2, CharSequence charSequence2, int i3, String str, String str2, String str3, String str4, String str5, String str6, e eVar, b.a aVar) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, charSequence, Integer.valueOf(i2), charSequence2, Integer.valueOf(i3), str, str2, str3, str4, str5, str6, eVar, aVar}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(c.a.j.l.f.sdk_right_button_toast_view, (ViewGroup) null);
            GradientDrawable gradientDrawable = (GradientDrawable) resources.getDrawable(c.a.j.l.d.sdk_normal_toast_view_bg);
            gradientDrawable.setColor(c.a.j.l.i.b.a.a(str, resources.getColor(c.a.j.l.b.task_sdk_toast_bg_color_default)));
            gradientDrawable.setAlpha(204);
            linearLayout.setBackground(gradientDrawable);
            linearLayout.setClickable(true);
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(c.a.j.l.e.right_button_toast_info_view)) != null) {
                textView.setText(charSequence);
                textView.setTextColor(c.a.j.l.i.b.a.a(str3, resources.getColor(c.a.j.l.b.task_sdk_text_color_default)));
                textView.setTextSize(1, i2);
            }
            TextView textView2 = (TextView) linearLayout.findViewById(c.a.j.l.e.right_button_toast_btn_view);
            GradientDrawable gradientDrawable2 = (GradientDrawable) resources.getDrawable(c.a.j.l.d.sdk_toast_btn_bg);
            gradientDrawable2.setColor(c.a.j.l.i.b.a.a(str4, resources.getColor(c.a.j.l.b.task_sdk_toast_bg_color_default)));
            textView2.setBackground(gradientDrawable2);
            if (!TextUtils.isEmpty(charSequence2)) {
                textView2.setText(charSequence2);
                textView2.setTextColor(c.a.j.l.i.b.a.a(str6, resources.getColor(c.a.j.l.b.task_sdk_text_color_default)));
                textView2.setTextSize(1, i3);
            }
            textView2.setOnClickListener(new View$OnClickListenerC0176c(aVar));
            c(str2, linearLayout, new d(str5, textView2, eVar, linearLayout));
        }
    }

    public static void c(String str, View view, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, str, view, runnable) == null) || runnable == null || view == null) {
            return;
        }
        com.baidu.bdtask.ui.utils.d.a.b(str, view, new a(runnable), new b(runnable));
    }
}
