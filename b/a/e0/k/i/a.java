package b.a.e0.k.i;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import b.a.e0.f;
import b.a.e0.g;
import b.a.e0.h;
import b.a.e0.p.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.poly.widget.m;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f2641e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f2642a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.poly.a.l.c f2643b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.e0.p.c f2644c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.e0.p.c f2645d;

    /* renamed from: b.a.e0.k.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0054a extends b.a.e0.k.a.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f2646a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f2647b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f2648c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Bundle f2649d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f2650e;

        public C0054a(a aVar, m mVar, boolean z, Context context, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, mVar, Boolean.valueOf(z), context, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2650e = aVar;
            this.f2646a = mVar;
            this.f2647b = z;
            this.f2648c = context;
            this.f2649d = bundle;
        }

        @Override // b.a.e0.k.a.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) {
                this.f2650e.j("2", str);
                m mVar = this.f2646a;
                mVar.a("get trade state failed : " + str, (String) null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e0.k.a.a
        /* renamed from: c */
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                int optInt = jSONObject.optInt("payStatus", 3);
                this.f2650e.j("1", String.valueOf(optInt));
                if (optInt == 2) {
                    this.f2646a.a(0, b.a.e0.n.b.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
                } else if (this.f2647b) {
                    this.f2650e.c(this.f2648c, this.f2649d, this.f2646a);
                } else {
                    this.f2650e.e(this.f2648c, this.f2646a);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f2651e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f2652f;

        public b(a aVar, m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2652f = aVar;
            this.f2651e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f2652f.f2644c.q();
                b.a.e0.k.h.b bVar = new b.a.e0.k.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
                bVar.c("1");
                b.a.e0.k.h.d.b(bVar);
                this.f2651e.a(3, "pay failed , click choose window");
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f2653e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f2654f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ m f2655g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f2656h;

        public c(a aVar, Context context, Bundle bundle, m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, bundle, mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2656h = aVar;
            this.f2653e = context;
            this.f2654f = bundle;
            this.f2655g = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f2656h.f2644c.q();
                b.a.e0.k.h.b bVar = new b.a.e0.k.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
                bVar.c("2");
                b.a.e0.k.h.d.b(bVar);
                this.f2656h.d(this.f2653e, this.f2654f, this.f2655g, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f2657e;

        public d(a aVar) {
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
            this.f2657e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f2657e.f2645d != null && this.f2657e.f2645d.u()) {
                this.f2657e.f2645d.q();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f2658a;

        public e(a aVar, m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2658a = mVar;
        }

        @Override // b.a.e0.p.c.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2658a.a(3, "pay failed , click error window");
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static a k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (f2641e == null) {
                synchronized (a.class) {
                    if (f2641e == null) {
                        f2641e = new a();
                    }
                }
            }
            return f2641e;
        }
        return (a) invokeV.objValue;
    }

    public final View a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activity)) == null) {
            if (activity == null || activity.getWindow() == null) {
                return null;
            }
            return activity.getWindow().getDecorView().findViewById(16908290);
        }
        return (View) invokeL.objValue;
    }

    public final void c(Context context, Bundle bundle, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bundle, mVar) == null) {
            View inflate = View.inflate(mVar.getContext(), g.pay_confirm, null);
            b.a.e0.p.c cVar = new b.a.e0.p.c(inflate, -1, -1, true);
            this.f2644c = cVar;
            cVar.y(false);
            this.f2644c.C(false);
            ((TextView) inflate.findViewById(f.bt_pay_meet_problems)).setOnClickListener(new b(this, mVar));
            ((TextView) inflate.findViewById(f.bt_pay_already_finish)).setOnClickListener(new c(this, context, bundle, mVar));
            this.f2644c.E(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
            b.a.e0.k.h.d.b(new b.a.e0.k.h.b(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY));
        }
    }

    public void d(Context context, Bundle bundle, m mVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, bundle, mVar, Boolean.valueOf(z)}) == null) || context == null || bundle == null || mVar == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f2643b = b.a.e0.k.k.a.a((ViewGroup) a((Activity) context), layoutParams, null, -1L);
        this.f2642a = System.currentTimeMillis();
        b.a.e0.k.b.b.j().g(bundle, new C0054a(this, mVar, z, context, bundle));
    }

    public final void e(Context context, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, mVar) == null) {
            View inflate = View.inflate(mVar.getContext(), g.default_pop_window, null);
            ((TextView) inflate.findViewById(f.pop_title)).setText(h.pay_failed);
            ((TextView) inflate.findViewById(f.pop_tips)).setText(h.pay_failed_sub_text);
            b.a.e0.p.c cVar = new b.a.e0.p.c(inflate, -1, -1, true);
            this.f2645d = cVar;
            cVar.y(false);
            this.f2645d.C(false);
            this.f2645d.x(new ColorDrawable(0));
            ((TextView) inflate.findViewById(f.pop_button)).setOnClickListener(new d(this));
            this.f2645d.h(new e(this, mVar));
            this.f2645d.E(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        }
    }

    public final void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            b.a.e0.k.k.a.c(this.f2643b);
            try {
                if (this.f2642a == 0) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("rt", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("msg", str2);
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() - this.f2642a);
                if (valueOf.longValue() >= 0) {
                    jSONObject.put("du", String.valueOf(valueOf));
                }
                b.a.e0.k.h.b bVar = new b.a.e0.k.h.b(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN);
                bVar.b(jSONObject);
                b.a.e0.k.h.d.b(bVar);
            } catch (JSONException e2) {
                if (b.a.e0.n.d.f2687d) {
                    e2.printStackTrace();
                }
            } finally {
                this.f2642a = 0L;
            }
        }
    }
}
