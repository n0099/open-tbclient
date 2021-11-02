package b.a.p0.a.e2.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.e2.c.j.b;
import b.a.p0.a.j2.k;
import b.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4830e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4831f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f4832g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f4833h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONArray f4834i;
        public final /* synthetic */ h j;

        public a(h hVar, CallbackHandler callbackHandler, String str, Context context, b.a.p0.a.a2.e eVar, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, callbackHandler, str, context, eVar, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = hVar;
            this.f4830e = callbackHandler;
            this.f4831f = str;
            this.f4832g = context;
            this.f4833h = eVar;
            this.f4834i = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.e2.c.d.h(iVar)) {
                    this.j.x((Activity) this.f4832g, this.f4833h, this.f4830e, this.f4834i, this.f4831f);
                } else {
                    b.a.p0.a.e2.c.d.p(iVar, this.f4830e, this.f4831f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.n1.q.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4835a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4836b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONArray f4837c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f4838d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f4839e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f4840f;

        /* loaded from: classes.dex */
        public class a implements b.a.p0.a.v2.e1.b<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.e2.c.f f4841e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f4842f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f4843g;

            /* renamed from: b.a.p0.a.e2.b.h$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0163a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Boolean f4844e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ a f4845f;

                public RunnableC0163a(a aVar, Boolean bool) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, bool};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f4845f = aVar;
                    this.f4844e = bool;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        a aVar = this.f4845f;
                        h hVar = aVar.f4843g.f4840f;
                        b.a.p0.a.e2.c.f fVar = aVar.f4841e;
                        List list = aVar.f4842f;
                        boolean booleanValue = this.f4844e.booleanValue();
                        b bVar = this.f4845f.f4843g;
                        hVar.P(fVar, list, booleanValue, bVar.f4839e, bVar.f4838d, bVar.f4835a, bVar.f4836b);
                    }
                }
            }

            public a(b bVar, b.a.p0.a.e2.c.f fVar, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, fVar, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4843g = bVar;
                this.f4841e = fVar;
                this.f4842f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    b bVar = this.f4843g;
                    bVar.f4840f.O(bVar.f4839e, this.f4841e, bool);
                    q0.X(new RunnableC0163a(this, bool));
                }
            }
        }

        /* renamed from: b.a.p0.a.e2.b.h$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0164b implements b.a.p0.a.v2.e1.b<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.e2.c.f f4846e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f4847f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f4848g;

            /* renamed from: b.a.p0.a.e2.b.h$b$b$a */
            /* loaded from: classes.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C0164b f4849e;

                public a(C0164b c0164b) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0164b};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f4849e = c0164b;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        C0164b c0164b = this.f4849e;
                        b bVar = c0164b.f4848g;
                        bVar.f4840f.P(c0164b.f4846e, c0164b.f4847f, false, bVar.f4839e, bVar.f4838d, bVar.f4835a, bVar.f4836b);
                    }
                }
            }

            public C0164b(b bVar, b.a.p0.a.e2.c.f fVar, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, fVar, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4848g = bVar;
                this.f4846e = fVar;
                this.f4847f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    b bVar = this.f4848g;
                    bVar.f4840f.N(bVar.f4839e, this.f4846e, str);
                    q0.X(new a(this));
                }
            }
        }

        public b(h hVar, CallbackHandler callbackHandler, String str, JSONArray jSONArray, b.a.p0.a.a2.e eVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, callbackHandler, str, jSONArray, eVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4840f = hVar;
            this.f4835a = callbackHandler;
            this.f4836b = str;
            this.f4837c = jSONArray;
            this.f4838d = eVar;
            this.f4839e = activity;
        }

        @Override // b.a.p0.a.n1.q.b.a
        public void a() {
            Map<String, b.a.p0.a.e2.c.f> g2;
            b.a.p0.a.e2.c.f y;
            List<b.a.p0.a.e2.c.f> w;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (y = this.f4840f.y((g2 = b.a.p0.a.n1.q.c.a.g(true)), this.f4835a, this.f4836b)) == null || (w = this.f4840f.w(g2, this.f4837c, this.f4835a, this.f4836b)) == null) {
                return;
            }
            y.g(w);
            if (this.f4838d.j().e(this.f4839e)) {
                this.f4840f.z(new C0164b(this, y, w));
            } else {
                b.a.p0.a.c1.a.T().a(this.f4839e, new a(this, y, w));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.p0.a.e2.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4850a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4851b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f4852c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f4853d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f4854e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f4855f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h f4856g;

        public c(h hVar, CallbackHandler callbackHandler, String str, boolean z, b.a.p0.a.a2.e eVar, Activity activity, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, callbackHandler, str, Boolean.valueOf(z), eVar, activity, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4856g = hVar;
            this.f4850a = callbackHandler;
            this.f4851b = str;
            this.f4852c = z;
            this.f4853d = eVar;
            this.f4854e = activity;
            this.f4855f = list;
        }

        @Override // b.a.p0.a.e2.c.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                b.a.p0.a.e0.d.g("MultiAuthorize", "showAuthDialog " + z);
                if (!z) {
                    b.a.p0.a.e2.c.d.n(10003, this.f4850a, this.f4851b);
                    return;
                }
                boolean z2 = this.f4852c;
                if (this.f4853d.j().e(this.f4854e)) {
                    this.f4856g.H(this.f4855f, this.f4854e, this.f4850a, this.f4851b);
                } else if (z2) {
                    this.f4856g.K(this.f4855f, this.f4854e, this.f4850a, this.f4851b);
                } else {
                    this.f4856g.G(this.f4855f, this.f4854e, this.f4850a, this.f4851b, this.f4853d);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f4857a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f4858b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4859c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f4860d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f4861e;

        public d(h hVar, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4861e = hVar;
            this.f4857a = list;
            this.f4858b = activity;
            this.f4859c = callbackHandler;
            this.f4860d = str;
        }

        @Override // b.a.p0.a.e2.b.h.j
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                b.a.p0.a.e0.d.g("MultiAuthorize", "login result:" + i2);
                if (z) {
                    this.f4861e.H(this.f4857a, this.f4858b, this.f4859c, this.f4860d);
                } else {
                    b.a.p0.a.e2.c.d.n(10004, this.f4859c, this.f4860d);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.a.p0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f4862e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f4863f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4864g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4865h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f4866i;

        public e(h hVar, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4866i = hVar;
            this.f4862e = list;
            this.f4863f = activity;
            this.f4864g = callbackHandler;
            this.f4865h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f4866i.I(TextUtils.equals(str, "1"), this.f4862e, this.f4863f, this.f4864g, this.f4865h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements b.a.p0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f4867e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f4868f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4869g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4870h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f4871i;

        public f(h hVar, Activity activity, List list, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, activity, list, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4871i = hVar;
            this.f4867e = activity;
            this.f4868f = list;
            this.f4869g = callbackHandler;
            this.f4870h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    this.f4871i.J(this.f4867e, this.f4868f, this.f4869g, this.f4870h);
                } else {
                    b.a.p0.a.e2.c.d.n(10003, this.f4869g, this.f4870h);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements b.a.p0.a.v2.e1.b<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f4872e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f4873f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4874g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4875h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f4876i;

        public g(h hVar, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4876i = hVar;
            this.f4872e = list;
            this.f4873f = activity;
            this.f4874g = callbackHandler;
            this.f4875h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                if (num.intValue() == 0) {
                    this.f4876i.H(this.f4872e, this.f4873f, this.f4874g, this.f4875h);
                } else {
                    b.a.p0.a.e2.c.d.n(10003, this.f4874g, this.f4875h);
                }
            }
        }
    }

    /* renamed from: b.a.p0.a.e2.b.h$h  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0165h implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4877e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4878f;

        public C0165h(h hVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4877e = callbackHandler;
            this.f4878f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar == null) {
                    b.a.p0.a.e2.c.d.n(10001, this.f4877e, this.f4878f);
                    k.p(10001, null);
                    return;
                }
                int b2 = iVar.b();
                b.a.p0.a.e0.d.l("MultiAuthorize", "requestAuthorize " + iVar.a() + ",  code=" + b2 + ", data=" + iVar.f4946a);
                if (b2 != 0) {
                    b.a.p0.a.e2.c.d.n(b2, this.f4877e, this.f4878f);
                } else {
                    this.f4877e.handleSchemeDispatchCallback(this.f4878f, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements b.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f4879e;

        public i(h hVar, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4879e = jVar;
        }

        @Override // b.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    this.f4879e.a(false, i2);
                } else {
                    this.f4879e.a(true, i2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface j {
        void a(boolean z, int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(b.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/multiAuthorize");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final boolean A(List<b.a.p0.a.e2.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list != null && list.size() > 0) {
                for (b.a.p0.a.e2.c.f fVar : list) {
                    if (fVar != null && C(fVar)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean B(b.a.p0.a.e2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) ? TextUtils.equals(fVar.f4905b, "mapp_location") || TextUtils.equals(fVar.f4905b, "mapp_images") || TextUtils.equals(fVar.f4905b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f4905b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(fVar.f4905b, "ppcert") || TextUtils.equals(fVar.f4905b, "mapp_i_face_verify") || TextUtils.equals(fVar.f4905b, "snsapi_userinfo") || TextUtils.equals(fVar.f4905b, "mapp_choose_address") || TextUtils.equals(fVar.f4905b, "mobile") || TextUtils.equals(fVar.f4905b, "mapp_choose_invoice") : invokeL.booleanValue;
    }

    public final boolean C(b.a.p0.a.e2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) == null) ? TextUtils.equals(fVar.f4905b, "ppcert") || TextUtils.equals(fVar.f4905b, "mapp_i_face_verify") : invokeL.booleanValue;
    }

    public final boolean D(List<b.a.p0.a.e2.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            boolean z = true;
            for (b.a.p0.a.e2.c.f fVar : list) {
                if (fVar != null && !E(fVar)) {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean E(b.a.p0.a.e2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fVar)) == null) ? TextUtils.equals(fVar.f4905b, "mapp_location") || TextUtils.equals(fVar.f4905b, "mapp_images") || TextUtils.equals(fVar.f4905b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f4905b, PermissionProxy.SCOPE_ID_CAMERA) : invokeL.booleanValue;
    }

    public final boolean F(List<b.a.p0.a.e2.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (b.a.p0.a.e2.c.f fVar : list) {
                if (fVar != null && C(fVar)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void G(List<b.a.p0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull b.a.p0.a.a2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, list, activity, callbackHandler, str, eVar) == null) {
            if (D(list)) {
                J(activity, list, callbackHandler, str);
            } else {
                L(eVar, activity, new d(this, list, activity, callbackHandler, str));
            }
        }
    }

    public final void H(List<b.a.p0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, list, activity, callbackHandler, str) == null) {
            if (F(list)) {
                J(activity, list, callbackHandler, str);
            } else {
                z(new e(this, list, activity, callbackHandler, str));
            }
        }
    }

    public final void I(boolean z, List<b.a.p0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), list, activity, callbackHandler, str}) == null) {
            if (z) {
                b.a.p0.a.e0.d.g("MultiAuthorize", "onCallback: real name success");
                J(activity, list, callbackHandler, str);
                return;
            }
            b.a.p0.a.e0.d.g("MultiAuthorize", "onCallback: real name fail");
            M(new f(this, activity, list, callbackHandler, str));
        }
    }

    public final void J(@NonNull Activity activity, @NonNull List<b.a.p0.a.e2.c.f> list, @NonNull CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, activity, list, callbackHandler, str) == null) {
            int size = list.size();
            String[] strArr = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                strArr[i2] = list.get(i2).f4905b;
            }
            b.a.p0.a.e2.c.j.b d2 = b.a.p0.a.a2.d.g().y().a().b().d(activity, false, true, strArr, null, true);
            d2.o(new C0165h(this, callbackHandler, str));
            d2.call();
        }
    }

    public final void K(List<b.a.p0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, list, activity, callbackHandler, str) == null) {
            b.a.p0.a.c1.a.T().d(new g(this, list, activity, callbackHandler, str));
        }
    }

    public final void L(@NonNull b.a.p0.a.a2.e eVar, @NonNull Activity activity, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, eVar, activity, jVar) == null) {
            v(eVar, activity, jVar);
        }
    }

    public final void M(b.a.p0.a.v2.e1.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            b.a.p0.a.c1.a.T().b(false, bVar);
        }
    }

    public final void N(@NonNull Activity activity, b.a.p0.a.e2.c.f fVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, activity, fVar, str) == null) {
            String N = b.a.p0.a.a2.d.g().r().N();
            boolean equals = TextUtils.equals(str, "1");
            if (!A(fVar.s)) {
                fVar.r = activity.getString(b.a.p0.a.h.swanapp_multi_auth_default_name_head) + N + activity.getString(b.a.p0.a.h.swanapp_multi_auth_default_name_end);
            } else if (equals) {
                fVar.r = activity.getString(b.a.p0.a.h.swanapp_multi_auth_default_name_head) + N + activity.getString(b.a.p0.a.h.swanapp_multi_auth_default_name_end);
            } else {
                fVar.r = activity.getString(b.a.p0.a.h.swanapp_multi_auth_un_realname_name_head) + N + activity.getString(b.a.p0.a.h.swanapp_multi_auth_default_name_end);
            }
        }
    }

    public final void O(@NonNull Activity activity, b.a.p0.a.e2.c.f fVar, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, activity, fVar, bool) == null) {
            String N = b.a.p0.a.a2.d.g().r().N();
            boolean D = D(fVar.s);
            boolean A = A(fVar.s);
            if (!bool.booleanValue() && !D) {
                fVar.r = activity.getString(b.a.p0.a.h.swanapp_multi_auth_guest_login_name_head) + N + activity.getString(b.a.p0.a.h.swanapp_multi_auth_default_name_end);
            } else if (A) {
                fVar.r = activity.getString(b.a.p0.a.h.swanapp_multi_auth_un_realname_name_head) + N + activity.getString(b.a.p0.a.h.swanapp_multi_auth_default_name_end);
            } else {
                fVar.r = activity.getString(b.a.p0.a.h.swanapp_multi_auth_default_name_head) + N + activity.getString(b.a.p0.a.h.swanapp_multi_auth_default_name_end);
            }
        }
    }

    public final void P(b.a.p0.a.e2.c.f fVar, List<b.a.p0.a.e2.c.f> list, boolean z, @NonNull Activity activity, @NonNull b.a.p0.a.a2.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{fVar, list, Boolean.valueOf(z), activity, eVar, callbackHandler, str}) == null) {
            b.a.p0.a.e2.c.d.t(activity, eVar, fVar, new JSONObject(), new c(this, callbackHandler, str, z, eVar, activity, list));
        }
    }

    @Override // b.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar != null && (context instanceof Activity)) {
                JSONObject a2 = a0.a(unitedSchemeEntity, "params");
                if (a2 != null && a2.has("scopes")) {
                    JSONArray optJSONArray = a2.optJSONArray("scopes");
                    if (optJSONArray != null && optJSONArray.length() >= 2 && optJSONArray.length() <= 4) {
                        eVar.S().g(context, "scope_multi_authorize", new a(this, callbackHandler, a2.optString("cb"), context, eVar, optJSONArray));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "scopes count error"));
                    return false;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "illegal parameter"));
                return false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401, "runtime parameter error");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void v(@NonNull b.a.p0.a.a2.e eVar, @NonNull Activity activity, @NonNull j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, eVar, activity, jVar) == null) {
            eVar.j().f(activity, null, new i(this, jVar));
        }
    }

    public final List<b.a.p0.a.e2.c.f> w(Map<String, b.a.p0.a.e2.c.f> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        b.a.p0.a.e2.c.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048594, this, map, jSONArray, callbackHandler, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            boolean z = true;
            for (int i2 = 0; i2 < length; i2++) {
                String optString = jSONArray.optString(i2);
                if (!TextUtils.isEmpty(optString) && map.containsKey(optString) && (fVar = map.get(optString)) != null) {
                    if (!B(fVar)) {
                        b.a.p0.a.e2.c.d.n(10005, callbackHandler, str);
                        k.p(10005, fVar);
                        return null;
                    } else if (fVar.f4907d) {
                        b.a.p0.a.e2.c.d.n(10005, callbackHandler, str);
                        k.p(10005, fVar);
                        return null;
                    } else {
                        if (!arrayList.contains(fVar) && !fVar.a()) {
                            arrayList.add(fVar);
                        }
                        if (!fVar.a()) {
                            z = false;
                        }
                    }
                }
            }
            if (z) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                return null;
            }
            b.a.p0.a.e0.d.g("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
            if (arrayList.isEmpty()) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
                return null;
            }
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull b.a.p0.a.a2.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048595, this, activity, eVar, callbackHandler, jSONArray, str) == null) {
            b.a.p0.a.n1.q.a.g().z(new b(this, callbackHandler, str, jSONArray, eVar, activity));
        }
    }

    public final b.a.p0.a.e2.c.f y(Map<String, b.a.p0.a.e2.c.f> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, map, callbackHandler, str)) == null) {
            b.a.p0.a.e2.c.f fVar = map.get("scope_multi_authorize");
            if (fVar == null) {
                b.a.p0.a.e2.c.d.n(10001, callbackHandler, str);
                k.p(10001, null);
                return null;
            } else if (fVar.f4907d) {
                b.a.p0.a.e2.c.d.n(10005, callbackHandler, str);
                k.p(10005, fVar);
                return null;
            } else {
                return fVar;
            }
        }
        return (b.a.p0.a.e2.c.f) invokeLLL.objValue;
    }

    public final void z(b.a.p0.a.v2.e1.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
            b.a.p0.a.c1.a.T().c(b.a.p0.a.c1.a.b(), bVar);
        }
    }
}
