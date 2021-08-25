package c.a.e0.k.i;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import c.a.e0.f;
import c.a.e0.g;
import c.a.e0.h;
import c.a.e0.p.c;
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
    public static volatile a f3201e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f3202a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.poly.a.l.c f3203b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.e0.p.c f3204c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.e0.p.c f3205d;

    /* renamed from: c.a.e0.k.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0059a extends c.a.e0.k.a.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f3206a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f3207b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f3208c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Bundle f3209d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3210e;

        public C0059a(a aVar, m mVar, boolean z, Context context, Bundle bundle) {
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
            this.f3210e = aVar;
            this.f3206a = mVar;
            this.f3207b = z;
            this.f3208c = context;
            this.f3209d = bundle;
        }

        @Override // c.a.e0.k.a.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) {
                this.f3210e.j("2", str);
                m mVar = this.f3206a;
                mVar.a("get trade state failed : " + str, (String) null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e0.k.a.a
        /* renamed from: c */
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                int optInt = jSONObject.optInt("payStatus", 3);
                this.f3210e.j("1", String.valueOf(optInt));
                if (optInt == 2) {
                    this.f3206a.a(0, c.a.e0.n.b.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
                } else if (this.f3207b) {
                    this.f3210e.c(this.f3208c, this.f3209d, this.f3206a);
                } else {
                    this.f3210e.e(this.f3208c, this.f3206a);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f3211e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f3212f;

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
            this.f3212f = aVar;
            this.f3211e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f3212f.f3204c.q();
                c.a.e0.k.h.b bVar = new c.a.e0.k.h.b("103");
                bVar.c("1");
                c.a.e0.k.h.d.b(bVar);
                this.f3211e.a(3, "pay failed , click choose window");
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f3213e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f3214f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ m f3215g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f3216h;

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
            this.f3216h = aVar;
            this.f3213e = context;
            this.f3214f = bundle;
            this.f3215g = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f3216h.f3204c.q();
                c.a.e0.k.h.b bVar = new c.a.e0.k.h.b("103");
                bVar.c("2");
                c.a.e0.k.h.d.b(bVar);
                this.f3216h.d(this.f3213e, this.f3214f, this.f3215g, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3217e;

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
            this.f3217e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f3217e.f3205d != null && this.f3217e.f3205d.u()) {
                this.f3217e.f3205d.q();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f3218a;

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
            this.f3218a = mVar;
        }

        @Override // c.a.e0.p.c.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3218a.a(3, "pay failed , click error window");
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
            if (f3201e == null) {
                synchronized (a.class) {
                    if (f3201e == null) {
                        f3201e = new a();
                    }
                }
            }
            return f3201e;
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
            c.a.e0.p.c cVar = new c.a.e0.p.c(inflate, -1, -1, true);
            this.f3204c = cVar;
            cVar.y(false);
            this.f3204c.C(false);
            ((TextView) inflate.findViewById(f.bt_pay_meet_problems)).setOnClickListener(new b(this, mVar));
            ((TextView) inflate.findViewById(f.bt_pay_already_finish)).setOnClickListener(new c(this, context, bundle, mVar));
            this.f3204c.E(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
            c.a.e0.k.h.d.b(new c.a.e0.k.h.b("102"));
        }
    }

    public void d(Context context, Bundle bundle, m mVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, bundle, mVar, Boolean.valueOf(z)}) == null) || context == null || bundle == null || mVar == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f3203b = c.a.e0.k.k.a.a((ViewGroup) a((Activity) context), layoutParams, null, -1L);
        this.f3202a = System.currentTimeMillis();
        c.a.e0.k.b.b.j().g(bundle, new C0059a(this, mVar, z, context, bundle));
    }

    public final void e(Context context, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, mVar) == null) {
            View inflate = View.inflate(mVar.getContext(), g.default_pop_window, null);
            ((TextView) inflate.findViewById(f.pop_title)).setText(h.pay_failed);
            ((TextView) inflate.findViewById(f.pop_tips)).setText(h.pay_failed_sub_text);
            c.a.e0.p.c cVar = new c.a.e0.p.c(inflate, -1, -1, true);
            this.f3205d = cVar;
            cVar.y(false);
            this.f3205d.C(false);
            this.f3205d.x(new ColorDrawable(0));
            ((TextView) inflate.findViewById(f.pop_button)).setOnClickListener(new d(this));
            this.f3205d.h(new e(this, mVar));
            this.f3205d.E(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        }
    }

    public final void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            c.a.e0.k.k.a.c(this.f3203b);
            try {
                if (this.f3202a == 0) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("rt", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("msg", str2);
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() - this.f3202a);
                if (valueOf.longValue() >= 0) {
                    jSONObject.put("du", String.valueOf(valueOf));
                }
                c.a.e0.k.h.b bVar = new c.a.e0.k.h.b(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN);
                bVar.b(jSONObject);
                c.a.e0.k.h.d.b(bVar);
            } catch (JSONException e2) {
                if (c.a.e0.n.d.f3247d) {
                    e2.printStackTrace();
                }
            } finally {
                this.f3202a = 0L;
            }
        }
    }
}
