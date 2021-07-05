package a.a.a.a;

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
    public final HashMap<K, l<K, V>.a> f1075a;

    /* renamed from: b  reason: collision with root package name */
    public final c<?> f1076b;

    /* loaded from: classes.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f1077a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1078b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1079c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1080d;

        /* renamed from: e  reason: collision with root package name */
        public FunAdInteractionListener f1081e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f1082f;

        public a(l lVar, String str, V v) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, str, v};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1082f = lVar;
            this.f1077a = str;
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
        this.f1075a = new HashMap<>();
        this.f1076b = cVar;
    }

    public final void a(K k) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, k) == null) {
            synchronized (this.f1075a) {
                this.f1075a.remove(k);
            }
        }
    }

    public final void a(K k, String str, V v, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k, str, v, funAdInteractionListener) == null) {
            synchronized (this.f1075a) {
                l<K, V>.a aVar = this.f1075a.get(k);
                if (aVar == null) {
                    aVar = new a(this, str, v);
                    this.f1075a.put(k, aVar);
                }
                a.a.a.a.y.f.g.c.a(aVar.f1078b, aVar.f1082f.f1076b.f1017h.f1409a, "sh_start", new Object[0]);
                aVar.f1078b = true;
                aVar.f1081e = funAdInteractionListener;
            }
        }
    }

    public final void b(K k) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k) == null) {
            synchronized (this.f1075a) {
                l<K, V>.a aVar = this.f1075a.get(k);
                if (aVar == null) {
                    return;
                }
                aVar.f1082f.f1076b.f1017h.a(aVar.f1080d);
                aVar.f1080d = true;
                FunAdInteractionListener funAdInteractionListener = aVar.f1081e;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdClicked(aVar.f1077a);
                }
            }
        }
    }

    public final void c(K k) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, k) == null) {
            synchronized (this.f1075a) {
                l<K, V>.a aVar = this.f1075a.get(k);
                if (aVar == null) {
                    return;
                }
                aVar.f1082f.f1076b.f1017h.b(aVar.f1079c);
                aVar.f1079c = true;
                FunAdInteractionListener funAdInteractionListener = aVar.f1081e;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdShow(aVar.f1077a);
                }
            }
        }
    }
}
