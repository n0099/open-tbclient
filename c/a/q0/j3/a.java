package c.a.q0.j3;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import c.a.e.e.m.e;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.q0.h3.c;
import c.a.q0.j3.c.a;
import c.a.q0.j3.d.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.permissionhelper.context.ContextCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a implements c.a.p0.y0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f21175a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.q0.j3.d.a f21176b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.y0.b f21177c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.q0.j3.c.a f21178d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f21179e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21180f;

    /* renamed from: g  reason: collision with root package name */
    public a.c f21181g;

    /* renamed from: h  reason: collision with root package name */
    public a.d f21182h;

    /* renamed from: c.a.q0.j3.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0986a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f21183a;

        /* renamed from: c.a.q0.j3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0987a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0986a f21184e;

            public RunnableC0987a(C0986a c0986a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0986a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21184e = c0986a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && j.z() && j.H()) {
                    this.f21184e.f21183a.f21178d.g();
                }
            }
        }

        public C0986a(a aVar) {
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
            this.f21183a = aVar;
        }

        @Override // c.a.q0.j3.c.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f21183a.f21180f && this.f21183a.f21177c != null) {
                this.f21183a.f21177c.a();
            }
        }

        @Override // c.a.q0.j3.c.a.c
        public void b(c.a.q0.j3.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (j.z()) {
                    this.f21183a.f21178d.e();
                } else if (this.f21183a.f21177c != null) {
                    this.f21183a.f21177c.a();
                }
                if (this.f21183a.f21180f) {
                    this.f21183a.f21179e.postDelayed(new RunnableC0987a(this), 800L);
                } else if (j.z() && j.H()) {
                    this.f21183a.f21178d.g();
                }
            }
        }

        @Override // c.a.q0.j3.c.a.c
        public void c(Object obj) {
            c.a.q0.j3.b.b c2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && this.f21183a.f21180f && (c2 = this.f21183a.f21178d.c()) != null) {
                StatisticItem h2 = c.a.q0.h3.a.h("a064", "common_fill", true, 1);
                if (c.a.e.a.j.a(this.f21183a.f21175a) != null) {
                    c.g().c(c.a.e.a.j.a(this.f21183a.f21175a).getUniqueId(), h2);
                }
                this.f21183a.f21176b.f(obj, ((int) c2.f21191c) / 1000);
                if (this.f21183a.f21177c != null) {
                    this.f21183a.f21177c.c(String.valueOf(c2.f21189a), c2.c(), c2.a());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f21185a;

        /* renamed from: c.a.q0.j3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0988a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f21186e;

            public RunnableC0988a(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21186e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) c.a.e.a.j.a(c.a.e.a.b.f().b()), new String[]{this.f21186e}, true);
                }
            }
        }

        public b(a aVar) {
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
            this.f21185a = aVar;
        }

        @Override // c.a.q0.j3.d.a.d
        public void a() {
            c.a.q0.j3.b.b c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c2 = this.f21185a.f21178d.c()) == null) {
                return;
            }
            if (this.f21185a.f21177c != null) {
                this.f21185a.f21177c.b(String.valueOf(c2.f21189a), c2.c());
            }
            if (TextUtils.isEmpty(c2.f21194f)) {
                return;
            }
            if (!this.f21185a.j(c2.f21194f)) {
                UrlManager.getInstance().dealOneLink((TbPageContext) c.a.e.a.j.a(this.f21185a.f21175a), new String[]{c2.f21194f}, true);
            } else {
                e.a().postDelayed(new RunnableC0988a(this, c2.f21194f), 500L);
            }
        }

        @Override // c.a.q0.j3.d.a.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = false;
                if (this.f21185a.getView() != null) {
                    if (this.f21185a.getView().getHeight() == l.i(this.f21185a.getView().getContext())) {
                        z = true;
                    }
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 2).param("obj_type", z ? 2 : 1));
                if (this.f21185a.f21177c != null) {
                    this.f21185a.f21177c.onAdDismiss();
                }
            }
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21179e = new Handler();
        this.f21180f = true;
        this.f21181g = new C0986a(this);
        this.f21182h = new b(this);
        this.f21175a = context;
        this.f21178d = new c.a.q0.j3.c.a();
        this.f21176b = new c.a.q0.j3.d.a(context, this.f21182h);
        this.f21178d.h(this.f21181g);
    }

    @Override // c.a.p0.y0.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21178d.d();
        }
    }

    @Override // c.a.p0.y0.a
    public void b(c.a.p0.y0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f21177c = bVar;
        }
    }

    @Override // c.a.p0.y0.a
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21176b.b() : (View) invokeV.objValue;
    }

    public final boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (str.contains("/swan/") || str.contains("/swangame/")) {
                return !ContextCompat.checkPermissionGranted(c.a.e.a.b.f().b(), "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.p0.y0.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f21180f = false;
            this.f21179e.removeCallbacksAndMessages(null);
        }
    }
}
