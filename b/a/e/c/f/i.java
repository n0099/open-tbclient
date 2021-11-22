package b.a.e.c.f;

import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.MessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList<d> f1537a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<k> f1538b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<b> f1539c;

    /* renamed from: d  reason: collision with root package name */
    public final LinkedList<c> f1540d;

    /* renamed from: e  reason: collision with root package name */
    public final LinkedList<j> f1541e;

    /* renamed from: f  reason: collision with root package name */
    public final LinkedList<a> f1542f;

    /* renamed from: g  reason: collision with root package name */
    public final LinkedList<e> f1543g;

    public i() {
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
        this.f1537a = new LinkedList<>();
        this.f1538b = new LinkedList<>();
        this.f1539c = new LinkedList<>();
        this.f1540d = new LinkedList<>();
        this.f1541e = new LinkedList<>();
        this.f1542f = new LinkedList<>();
        this.f1543g = new LinkedList<>();
    }

    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            this.f1543g.add(eVar);
        }
    }

    public void b(f<?, ?> fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) || fVar == null) {
            return;
        }
        l.d();
        if (fVar instanceof d) {
            FrameHelper.insert(this.f1537a, (d) fVar);
        } else if (fVar instanceof k) {
            FrameHelper.insert(this.f1538b, (k) fVar);
        } else if (fVar instanceof b) {
            FrameHelper.insert(this.f1539c, (b) fVar);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public void c(g<?> gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) || gVar == null) {
            return;
        }
        l.d();
        if (gVar instanceof c) {
            FrameHelper.insert(this.f1540d, (c) gVar);
        } else if (gVar instanceof j) {
            FrameHelper.insert(this.f1541e, (j) gVar);
        } else if (gVar instanceof a) {
            FrameHelper.insert(this.f1542f, (a) gVar);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public void d(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            this.f1543g.remove(eVar);
        }
    }

    public void e(f<?, ?> fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) || fVar == null) {
            return;
        }
        l.d();
        if (fVar instanceof d) {
            this.f1537a.remove(fVar);
        } else if (fVar instanceof k) {
            this.f1538b.remove(fVar);
        } else if (fVar instanceof b) {
            this.f1539c.remove(fVar);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public void f(g<?> gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) || gVar == null) {
            return;
        }
        l.d();
        if (gVar instanceof c) {
            this.f1540d.remove(gVar);
        } else if (gVar instanceof j) {
            this.f1541e.remove(gVar);
        } else if (gVar instanceof a) {
            this.f1542f.remove(gVar);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public CustomMessage<?> g(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, customMessage, customMessageTask)) == null) ? (CustomMessage) k(this.f1539c, customMessage, customMessageTask) : (CustomMessage) invokeLL.objValue;
    }

    public CustomResponsedMessage<?> h(CustomResponsedMessage<?> customResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, customResponsedMessage)) == null) ? (CustomResponsedMessage) l(this.f1542f, customResponsedMessage) : (CustomResponsedMessage) invokeL.objValue;
    }

    public HttpMessage i(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, httpMessage, httpMessageTask)) == null) ? (HttpMessage) k(this.f1537a, httpMessage, httpMessageTask) : (HttpMessage) invokeLL.objValue;
    }

    public HttpResponsedMessage j(HttpResponsedMessage httpResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, httpResponsedMessage)) == null) ? (HttpResponsedMessage) l(this.f1540d, httpResponsedMessage) : (HttpResponsedMessage) invokeL.objValue;
    }

    public final <M extends Message<?>, T extends MessageTask> M k(LinkedList<? extends f<M, T>> linkedList, M m, T t) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, linkedList, m, t)) == null) {
            if (linkedList == null) {
                return null;
            }
            int size = linkedList.size();
            for (int i2 = 0; i2 < size && m != null; i2++) {
                try {
                    m = linkedList.get(i2).rule(m, t);
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            return m;
        }
        return (M) invokeLLL.objValue;
    }

    public final <M extends ResponsedMessage<?>> M l(LinkedList<? extends g<M>> linkedList, M m) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, linkedList, m)) == null) {
            if (linkedList == null) {
                return null;
            }
            int size = linkedList.size();
            for (int i2 = 0; i2 < size && m != null; i2++) {
                try {
                    m = linkedList.get(i2).b(m);
                } catch (Exception e2) {
                    BdLog.e("rule error = " + e2.getMessage());
                }
            }
            return m;
        }
        return (M) invokeLL.objValue;
    }

    public SocketMessage m(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, socketMessage, socketMessageTask)) == null) ? (SocketMessage) k(this.f1538b, socketMessage, socketMessageTask) : (SocketMessage) invokeLL.objValue;
    }

    public SocketResponsedMessage n(SocketResponsedMessage socketResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, socketResponsedMessage)) == null) ? (SocketResponsedMessage) l(this.f1541e, socketResponsedMessage) : (SocketResponsedMessage) invokeL.objValue;
    }

    public void o(int i2, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i2, bdUniqueId) == null) {
            int size = this.f1543g.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.f1543g.get(i3).a(i2, bdUniqueId);
            }
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bdUniqueId) == null) {
            int size = this.f1543g.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f1543g.get(i2).b(bdUniqueId);
            }
        }
    }
}
