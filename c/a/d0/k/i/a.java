package c.a.d0.k.i;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import c.a.d0.f;
import c.a.d0.g;
import c.a.d0.h;
import c.a.d0.p.c;
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
    public static volatile a f1837e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f1838a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.poly.a.l.c f1839b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.d0.p.c f1840c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.d0.p.c f1841d;

    /* renamed from: c.a.d0.k.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0030a extends c.a.d0.k.a.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f1842a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f1843b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f1844c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Bundle f1845d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f1846e;

        public C0030a(a aVar, m mVar, boolean z, Context context, Bundle bundle) {
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
            this.f1846e = aVar;
            this.f1842a = mVar;
            this.f1843b = z;
            this.f1844c = context;
            this.f1845d = bundle;
        }

        @Override // c.a.d0.k.a.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) {
                this.f1846e.j("2", str);
                m mVar = this.f1842a;
                mVar.a("get trade state failed : " + str, (String) null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d0.k.a.a
        /* renamed from: c */
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                int optInt = jSONObject.optInt("payStatus", 3);
                this.f1846e.j("1", String.valueOf(optInt));
                if (optInt == 2) {
                    this.f1842a.a(0, c.a.d0.n.b.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
                } else if (this.f1843b) {
                    this.f1846e.c(this.f1844c, this.f1845d, this.f1842a);
                } else {
                    this.f1846e.e(this.f1844c, this.f1842a);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f1847e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f1848f;

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
            this.f1848f = aVar;
            this.f1847e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f1848f.f1840c.q();
                c.a.d0.k.h.b bVar = new c.a.d0.k.h.b("103");
                bVar.c("1");
                c.a.d0.k.h.d.b(bVar);
                this.f1847e.a(3, "pay failed , click choose window");
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f1849e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f1850f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ m f1851g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f1852h;

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
            this.f1852h = aVar;
            this.f1849e = context;
            this.f1850f = bundle;
            this.f1851g = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f1852h.f1840c.q();
                c.a.d0.k.h.b bVar = new c.a.d0.k.h.b("103");
                bVar.c("2");
                c.a.d0.k.h.d.b(bVar);
                this.f1852h.d(this.f1849e, this.f1850f, this.f1851g, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f1853e;

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
            this.f1853e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f1853e.f1841d != null && this.f1853e.f1841d.u()) {
                this.f1853e.f1841d.q();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f1854a;

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
            this.f1854a = mVar;
        }

        @Override // c.a.d0.p.c.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1854a.a(3, "pay failed , click error window");
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
            if (f1837e == null) {
                synchronized (a.class) {
                    if (f1837e == null) {
                        f1837e = new a();
                    }
                }
            }
            return f1837e;
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
            c.a.d0.p.c cVar = new c.a.d0.p.c(inflate, -1, -1, true);
            this.f1840c = cVar;
            cVar.y(false);
            this.f1840c.C(false);
            ((TextView) inflate.findViewById(f.bt_pay_meet_problems)).setOnClickListener(new b(this, mVar));
            ((TextView) inflate.findViewById(f.bt_pay_already_finish)).setOnClickListener(new c(this, context, bundle, mVar));
            this.f1840c.E(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
            c.a.d0.k.h.d.b(new c.a.d0.k.h.b("102"));
        }
    }

    public void d(Context context, Bundle bundle, m mVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, bundle, mVar, Boolean.valueOf(z)}) == null) || context == null || bundle == null || mVar == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f1839b = c.a.d0.k.k.a.a((ViewGroup) a((Activity) context), layoutParams, null, -1L);
        this.f1838a = System.currentTimeMillis();
        c.a.d0.k.b.b.j().g(bundle, new C0030a(this, mVar, z, context, bundle));
    }

    public final void e(Context context, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, mVar) == null) {
            View inflate = View.inflate(mVar.getContext(), g.default_pop_window, null);
            ((TextView) inflate.findViewById(f.pop_title)).setText(h.pay_failed);
            ((TextView) inflate.findViewById(f.pop_tips)).setText(h.pay_failed_sub_text);
            c.a.d0.p.c cVar = new c.a.d0.p.c(inflate, -1, -1, true);
            this.f1841d = cVar;
            cVar.y(false);
            this.f1841d.C(false);
            this.f1841d.x(new ColorDrawable(0));
            ((TextView) inflate.findViewById(f.pop_button)).setOnClickListener(new d(this));
            this.f1841d.h(new e(this, mVar));
            this.f1841d.E(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        }
    }

    public final void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            c.a.d0.k.k.a.c(this.f1839b);
            try {
                if (this.f1838a == 0) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("rt", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("msg", str2);
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() - this.f1838a);
                if (valueOf.longValue() >= 0) {
                    jSONObject.put("du", String.valueOf(valueOf));
                }
                c.a.d0.k.h.b bVar = new c.a.d0.k.h.b(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN);
                bVar.b(jSONObject);
                c.a.d0.k.h.d.b(bVar);
            } catch (JSONException e2) {
                if (c.a.d0.n.d.f1883d) {
                    e2.printStackTrace();
                }
            } finally {
                this.f1838a = 0L;
            }
        }
    }
}
