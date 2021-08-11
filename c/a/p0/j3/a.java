package c.a.p0.j3;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import c.a.e.e.m.e;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.p0.h3.c;
import c.a.p0.j3.c.a;
import c.a.p0.j3.d.a;
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
public class a implements c.a.o0.y0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f20845a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.p0.j3.d.a f20846b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.o0.y0.b f20847c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.p0.j3.c.a f20848d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f20849e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20850f;

    /* renamed from: g  reason: collision with root package name */
    public a.c f20851g;

    /* renamed from: h  reason: collision with root package name */
    public a.d f20852h;

    /* renamed from: c.a.p0.j3.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0975a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f20853a;

        /* renamed from: c.a.p0.j3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0976a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0975a f20854e;

            public RunnableC0976a(C0975a c0975a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0975a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f20854e = c0975a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && j.z() && j.H()) {
                    this.f20854e.f20853a.f20848d.g();
                }
            }
        }

        public C0975a(a aVar) {
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
            this.f20853a = aVar;
        }

        @Override // c.a.p0.j3.c.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f20853a.f20850f && this.f20853a.f20847c != null) {
                this.f20853a.f20847c.a();
            }
        }

        @Override // c.a.p0.j3.c.a.c
        public void b(c.a.p0.j3.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (j.z()) {
                    this.f20853a.f20848d.e();
                } else if (this.f20853a.f20847c != null) {
                    this.f20853a.f20847c.a();
                }
                if (this.f20853a.f20850f) {
                    this.f20853a.f20849e.postDelayed(new RunnableC0976a(this), 800L);
                } else if (j.z() && j.H()) {
                    this.f20853a.f20848d.g();
                }
            }
        }

        @Override // c.a.p0.j3.c.a.c
        public void c(Object obj) {
            c.a.p0.j3.b.b c2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && this.f20853a.f20850f && (c2 = this.f20853a.f20848d.c()) != null) {
                StatisticItem h2 = c.a.p0.h3.a.h("a064", "common_fill", true, 1);
                if (c.a.e.a.j.a(this.f20853a.f20845a) != null) {
                    c.g().c(c.a.e.a.j.a(this.f20853a.f20845a).getUniqueId(), h2);
                }
                this.f20853a.f20846b.f(obj, ((int) c2.f20861c) / 1000);
                if (this.f20853a.f20847c != null) {
                    this.f20853a.f20847c.c(String.valueOf(c2.f20859a), c2.c(), c2.a());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f20855a;

        /* renamed from: c.a.p0.j3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0977a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f20856e;

            public RunnableC0977a(b bVar, String str) {
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
                this.f20856e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) c.a.e.a.j.a(c.a.e.a.b.f().b()), new String[]{this.f20856e}, true);
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
            this.f20855a = aVar;
        }

        @Override // c.a.p0.j3.d.a.d
        public void a() {
            c.a.p0.j3.b.b c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c2 = this.f20855a.f20848d.c()) == null) {
                return;
            }
            if (this.f20855a.f20847c != null) {
                this.f20855a.f20847c.b(String.valueOf(c2.f20859a), c2.c());
            }
            if (TextUtils.isEmpty(c2.f20864f)) {
                return;
            }
            if (!this.f20855a.j(c2.f20864f)) {
                UrlManager.getInstance().dealOneLink((TbPageContext) c.a.e.a.j.a(this.f20855a.f20845a), new String[]{c2.f20864f}, true);
            } else {
                e.a().postDelayed(new RunnableC0977a(this, c2.f20864f), 500L);
            }
        }

        @Override // c.a.p0.j3.d.a.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = false;
                if (this.f20855a.getView() != null) {
                    if (this.f20855a.getView().getHeight() == l.i(this.f20855a.getView().getContext())) {
                        z = true;
                    }
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 2).param("obj_type", z ? 2 : 1));
                if (this.f20855a.f20847c != null) {
                    this.f20855a.f20847c.onAdDismiss();
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
        this.f20849e = new Handler();
        this.f20850f = true;
        this.f20851g = new C0975a(this);
        this.f20852h = new b(this);
        this.f20845a = context;
        c.a.p0.j3.c.a aVar = new c.a.p0.j3.c.a();
        this.f20848d = aVar;
        aVar.h(this.f20851g);
        this.f20846b = new c.a.p0.j3.d.a(context, this.f20852h);
    }

    @Override // c.a.o0.y0.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f20848d.d();
        }
    }

    @Override // c.a.o0.y0.a
    public void b(c.a.o0.y0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f20847c = bVar;
        }
    }

    @Override // c.a.o0.y0.a
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20846b.b() : (View) invokeV.objValue;
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

    @Override // c.a.o0.y0.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f20850f = false;
            this.f20849e.removeCallbacksAndMessages(null);
        }
    }
}
