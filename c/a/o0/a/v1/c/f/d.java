package c.a.o0.a.v1.c.f;

import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import c.a.o0.a.v1.c.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class d implements a.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Deque<Message>> f9242a;

    public d() {
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
        this.f9242a = new HashMap();
    }

    @Override // c.a.o0.a.v1.c.a.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (String str : this.f9242a.keySet()) {
                c(str);
            }
        }
    }

    @Override // c.a.o0.a.v1.c.a.c
    public void b(@NonNull c.a.o0.a.v1.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            Message h2 = cVar.h();
            if (cVar.m()) {
                h(h2);
            }
            Set<SwanAppProcessInfo> l = cVar.l();
            Set<String> k = cVar.k();
            if (cVar.n()) {
                Iterator<c> it = e.k().q().iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    boolean g2 = g(next, k);
                    if (l.contains(next.f9236f) || g2) {
                        next.U(h2);
                        if (g2) {
                            k.remove(next.getAppId());
                        }
                    }
                }
                f(k, h2);
                return;
            }
            Iterator<c> it2 = e.k().q().iterator();
            while (it2.hasNext()) {
                c next2 = it2.next();
                if (next2 != null && next2.H() && (l.contains(next2.f9236f) || g(next2, k))) {
                    next2.U(h2);
                }
            }
        }
    }

    @Override // c.a.o0.a.v1.c.a.c
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            Deque<Message> deque = this.f9242a.get(str);
            c.a.o0.a.v1.c.a.f("flushMsg:: appid=" + str + " msgQueue=" + deque);
            if (deque == null || deque.isEmpty()) {
                return;
            }
            List<c> j2 = e.k().j(str);
            c.a.o0.a.v1.c.a.f("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + j2.size());
            if (j2.isEmpty()) {
                return;
            }
            for (c cVar : j2) {
                cVar.W(deque);
            }
            deque.clear();
        }
    }

    @Override // c.a.o0.a.v1.c.a.c
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f9242a.remove(str);
        }
    }

    public final void e(String str, @NonNull Message message) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, message) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        Deque<Message> deque = this.f9242a.get(str);
        if (deque == null) {
            deque = new ArrayDeque<>();
            this.f9242a.put(str, deque);
        }
        deque.offer(message);
    }

    public final void f(Set<String> set, @NonNull Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, set, message) == null) {
            for (String str : set) {
                e(str, message);
            }
        }
    }

    public boolean g(@NonNull c cVar, @NonNull Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, cVar, set)) == null) ? cVar.C() && set.contains(cVar.getAppId()) : invokeLL.booleanValue;
    }

    public final void h(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, message) == null) {
            try {
                e.k().f9249e.send(message);
            } catch (RemoteException e2) {
                c.a.o0.a.v1.c.a.f(Log.getStackTraceString(e2));
            }
        }
    }
}
