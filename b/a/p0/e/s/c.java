package b.a.p0.e.s;

import b.a.p0.a.a2.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c<ContenT> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, c<ContenT>.a> f9714a;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final String f9715e;

        /* renamed from: f  reason: collision with root package name */
        public final ContenT f9716f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f9717g;

        public a(c cVar, String str, ContenT content) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, content};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9717g = cVar;
            this.f9715e = str;
            this.f9716f = content;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9717g.d(this.f9715e);
            }
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9714a = new HashMap();
    }

    public synchronized ContenT a(String str, ContenT content, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, content, Long.valueOf(j)})) == null) {
            synchronized (this) {
                d(str);
                if (content == null) {
                    return null;
                }
                c<ContenT>.a aVar = new a(this, str, content);
                this.f9714a.put(str, aVar);
                if (j > 0) {
                    d.i().postDelayed(aVar, j);
                }
                return content;
            }
        }
        return (ContenT) invokeCommon.objValue;
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                for (c<ContenT>.a aVar : this.f9714a.values()) {
                    if (aVar != null) {
                        d.i().removeCallbacks(aVar);
                    }
                }
                this.f9714a.clear();
            }
        }
    }

    public ContenT c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            c<ContenT>.a aVar = this.f9714a.get(str);
            if (aVar == null) {
                return null;
            }
            return aVar.f9716f;
        }
        return (ContenT) invokeL.objValue;
    }

    public synchronized ContenT d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                c<ContenT>.a remove = this.f9714a.remove(str);
                if (remove != null) {
                    d.i().removeCallbacks(remove);
                    return remove.f9716f;
                }
                return null;
            }
        }
        return (ContenT) invokeL.objValue;
    }
}
