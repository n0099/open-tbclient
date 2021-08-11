package b.a.a.a;

import b.a.a.a.u.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import java.util.HashMap;
/* loaded from: classes.dex */
public class l<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<K, l<K, V>.a> f1122a;

    /* renamed from: b  reason: collision with root package name */
    public final c<?> f1123b;

    /* loaded from: classes.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f1124a;

        /* renamed from: b  reason: collision with root package name */
        public final h.a f1125b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1126c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1127d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1128e;

        /* renamed from: f  reason: collision with root package name */
        public FunAdInteractionListener f1129f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ l f1130g;

        public a(l lVar, String str, h.a aVar, V v) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, str, aVar, v};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1130g = lVar;
            this.f1124a = str;
            this.f1125b = aVar;
        }
    }

    public l(c<?> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1122a = new HashMap<>();
        this.f1123b = cVar;
    }

    public final void a(K k) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, k) == null) {
            synchronized (this.f1122a) {
                this.f1122a.remove(k);
            }
        }
    }

    public final void b(K k, String str, h.a aVar, V v, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k, str, aVar, v, funAdInteractionListener) == null) {
            synchronized (this.f1122a) {
                l<K, V>.a aVar2 = this.f1122a.get(k);
                if (aVar2 == null) {
                    aVar2 = new a(this, str, aVar, v);
                    this.f1122a.put(k, aVar2);
                }
                b.a.a.a.x.f.g.b.g(aVar2.f1126c, aVar2.f1130g.f1123b.f1057h.f1519a, "sh_start", new Object[0]);
                aVar2.f1126c = true;
                aVar2.f1129f = funAdInteractionListener;
            }
        }
    }

    public final void c(K k) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k) == null) {
            synchronized (this.f1122a) {
                l<K, V>.a aVar = this.f1122a.get(k);
                if (aVar == null) {
                    return;
                }
                aVar.f1130g.f1123b.f1057h.f(aVar.f1128e);
                aVar.f1128e = true;
                FunAdInteractionListener funAdInteractionListener = aVar.f1129f;
                if (funAdInteractionListener != null) {
                    String str = aVar.f1124a;
                    h.a aVar2 = aVar.f1125b;
                    funAdInteractionListener.onAdClicked(str, aVar2.l.f1445c, aVar2.f1448c);
                }
            }
        }
    }

    public final void d(K k) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, k) == null) {
            synchronized (this.f1122a) {
                l<K, V>.a aVar = this.f1122a.get(k);
                if (aVar == null) {
                    return;
                }
                aVar.f1130g.f1123b.f1057h.k(aVar.f1127d);
                aVar.f1127d = true;
                FunAdInteractionListener funAdInteractionListener = aVar.f1129f;
                if (funAdInteractionListener != null) {
                    String str = aVar.f1124a;
                    h.a aVar2 = aVar.f1125b;
                    funAdInteractionListener.onAdShow(str, aVar2.l.f1445c, aVar2.f1448c);
                }
            }
        }
    }
}
