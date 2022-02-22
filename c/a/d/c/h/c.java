package c.a.d.c.h;

import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import c.a.d.c.f.f;
import c.a.d.f.p.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.MessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<M extends Message<?>, T extends MessageTask, R extends f<?, ?>, N extends ResponsedMessage<?>> implements c.a.d.c.b<M, T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static c.a.d.c.g.b<Message<?>> f1820h;
    public transient /* synthetic */ FieldHolder $fh;
    public MessageManager a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<T> f1821b;

    /* renamed from: c  reason: collision with root package name */
    public final SparseArray<N> f1822c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<LinkedList<MessageListener<N>>> f1823d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.d.c.j.d f1824e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1825f;

    /* renamed from: g  reason: collision with root package name */
    public final SparseIntArray f1826g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-588614948, "Lc/a/d/c/h/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-588614948, "Lc/a/d/c/h/c;");
        }
    }

    public c(MessageManager messageManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {messageManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f1821b = new SparseArray<>();
        this.f1822c = new SparseArray<>();
        this.f1823d = new SparseArray<>();
        this.f1824e = null;
        this.f1825f = false;
        this.f1826g = new SparseIntArray();
        this.a = messageManager;
    }

    public static void q(c.a.d.c.g.b<Message<?>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bVar) == null) {
            f1820h = bVar;
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f1825f = true;
        }
    }

    public final void b(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && k(i2)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public boolean c(M m, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, m, t)) == null) {
            n.c();
            if (m == null) {
                return false;
            }
            int cmd = m.getCmd();
            if (t == null) {
                t = g(cmd);
            }
            if (t != null) {
                M m2 = m(m, t);
                if (this.f1824e != null) {
                    if (t.getTimeOut() == null) {
                        t.setTimeOut(this.f1824e.b());
                    }
                    if (t.getRetry() == 0) {
                        t.setRetry(this.f1824e.a());
                    }
                }
                if (m2 != null) {
                    f(m2, t);
                    return true;
                }
                BdLog.d("message is trapped:" + cmd);
                return false;
            }
            c.a.d.c.g.b<Message<?>> bVar = f1820h;
            if (bVar != null) {
                bVar.a(m);
            }
            BdLog.e("task not register:" + cmd);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void d(N n) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, n) == null) {
            n.c();
            if (n == null) {
                return;
            }
            n.setProcessTime(System.currentTimeMillis());
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            BdUniqueId tag = orginalMessage != null ? orginalMessage.getTag() : null;
            if (this.f1822c.indexOfKey(cmd) >= 0) {
                this.f1822c.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.f1823d.get(cmd);
            if (linkedList == null) {
                return;
            }
            this.f1825f = false;
            l(cmd);
            try {
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.f1825f) {
                        MessageListener<N> next = it.next();
                        if (next != null && (!next.isSelfListener() || next.getTag() == tag)) {
                            try {
                                next.onMessage(n);
                            } catch (Exception e2) {
                                BdLog.detailException(n.getClass().getName(), e2, true);
                            }
                        }
                    }
                } catch (Exception e3) {
                    BdLog.detailException(n.getClass().getName(), e3, true);
                }
            } finally {
                r(cmd);
            }
        }
    }

    public synchronized T g(int i2) {
        InterceptResult invokeI;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            synchronized (this) {
                t = this.f1821b.get(i2);
            }
            return t;
        }
        return (T) invokeI.objValue;
    }

    public synchronized ArrayList<T> i() {
        InterceptResult invokeV;
        ArrayList<T> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList<>();
                int size = this.f1821b.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(this.f1821b.valueAt(i2));
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            LinkedList<MessageListener<N>> linkedList = this.f1823d.get(i2);
            return linkedList != null && linkedList.size() > 0;
        }
        return invokeI.booleanValue;
    }

    public final synchronized boolean k(int i2) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            synchronized (this) {
                z = this.f1826g.get(i2, 0) != 0;
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public final synchronized void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            synchronized (this) {
                this.f1826g.put(i2, this.f1826g.get(i2, 0) + 1);
            }
        }
    }

    public abstract M m(M m, T t);

    public void n(int i2, MessageListener<N> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, messageListener) == null) {
            n.c();
            if (messageListener == null) {
                return;
            }
            if ((i2 == 0 && messageListener.getCmd() == 0) || (i2 != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i2 == 0) {
                i2 = messageListener.getCmd();
            }
            FrameHelper.f(i2);
            b(i2);
            LinkedList<MessageListener<N>> linkedList = this.f1823d.get(i2);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.f1823d.put(i2, linkedList);
            }
            FrameHelper.insert(linkedList, messageListener);
            N n = this.f1822c.get(i2);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || this.f1822c.indexOfKey(i2) >= 0) {
            return;
        }
        this.f1822c.put(i2, null);
    }

    public synchronized void p(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, t) == null) {
            synchronized (this) {
                if (t == null) {
                    return;
                }
                int cmd = t.getCmd();
                FrameHelper.f(cmd);
                this.f1821b.put(cmd, t);
            }
        }
    }

    public final synchronized void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            synchronized (this) {
                int i3 = this.f1826g.get(i2, 0);
                if (i3 <= 1) {
                    this.f1826g.delete(i2);
                } else {
                    this.f1826g.put(i2, i3 - 1);
                }
            }
        }
    }

    public void s(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) {
            n.c();
            if (bdUniqueId == null) {
                return;
            }
            int size = this.f1823d.size();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt = this.f1823d.keyAt(i2);
                Iterator<MessageListener<N>> it = this.f1823d.valueAt(i2).iterator();
                while (it.hasNext()) {
                    MessageListener<N> next = it.next();
                    if (next != null && next.getTag() == bdUniqueId) {
                        b(keyAt);
                        it.remove();
                    }
                }
            }
        }
    }

    public void t(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, messageListener) == null) {
            n.c();
            if (messageListener == null) {
                return;
            }
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.f1823d.size();
                for (int i2 = 0; i2 < size; i2++) {
                    LinkedList<MessageListener<N>> valueAt = this.f1823d.valueAt(i2);
                    int keyAt = this.f1823d.keyAt(i2);
                    if (valueAt.contains(messageListener)) {
                        b(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            b(cmd);
            LinkedList<MessageListener<N>> linkedList = this.f1823d.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f1822c.remove(i2);
        }
    }

    public synchronized void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            synchronized (this) {
                this.f1821b.remove(i2);
            }
        }
    }
}
