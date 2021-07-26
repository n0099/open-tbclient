package a.a.a.a;

import a.a.a.a.s.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import java.util.HashMap;
/* loaded from: classes.dex */
public class k<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<K, k<K, V>.a> f1066a;

    /* renamed from: b  reason: collision with root package name */
    public final b<?> f1067b;

    /* loaded from: classes.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f1068a;

        /* renamed from: b  reason: collision with root package name */
        public final h.a f1069b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1070c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1071d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1072e;

        /* renamed from: f  reason: collision with root package name */
        public FunAdInteractionListener f1073f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f1074g;

        public a(k kVar, String str, h.a aVar, V v) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, str, aVar, v};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1074g = kVar;
            this.f1068a = str;
            this.f1069b = aVar;
        }
    }

    public k(b<?> bVar) {
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
        this.f1066a = new HashMap<>();
        this.f1067b = bVar;
    }

    public final void a(K k) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, k) == null) {
            synchronized (this.f1066a) {
                this.f1066a.remove(k);
            }
        }
    }

    public final void a(K k, String str, h.a aVar, V v, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k, str, aVar, v, funAdInteractionListener) == null) {
            synchronized (this.f1066a) {
                k<K, V>.a aVar2 = this.f1066a.get(k);
                if (aVar2 == null) {
                    aVar2 = new a(this, str, aVar, v);
                    this.f1066a.put(k, aVar2);
                }
                a.a.a.a.v.g.g.c.a(aVar2.f1070c, aVar2.f1074g.f1067b.f1015h.f1441a, "sh_start", new Object[0]);
                aVar2.f1070c = true;
                aVar2.f1073f = funAdInteractionListener;
            }
        }
    }

    public final void b(K k) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k) == null) {
            synchronized (this.f1066a) {
                k<K, V>.a aVar = this.f1066a.get(k);
                if (aVar == null) {
                    return;
                }
                aVar.f1074g.f1067b.f1015h.a(aVar.f1072e);
                aVar.f1072e = true;
                FunAdInteractionListener funAdInteractionListener = aVar.f1073f;
                if (funAdInteractionListener != null) {
                    String str = aVar.f1068a;
                    h.a aVar2 = aVar.f1069b;
                    funAdInteractionListener.onAdClicked(str, aVar2.l.f1358c, aVar2.f1361c);
                }
            }
        }
    }

    public final void c(K k) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, k) == null) {
            synchronized (this.f1066a) {
                k<K, V>.a aVar = this.f1066a.get(k);
                if (aVar == null) {
                    return;
                }
                aVar.f1074g.f1067b.f1015h.b(aVar.f1071d);
                aVar.f1071d = true;
                FunAdInteractionListener funAdInteractionListener = aVar.f1073f;
                if (funAdInteractionListener != null) {
                    String str = aVar.f1068a;
                    h.a aVar2 = aVar.f1069b;
                    funAdInteractionListener.onAdShow(str, aVar2.l.f1358c, aVar2.f1361c);
                }
            }
        }
    }
}
