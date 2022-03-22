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
    public static c.a.d.c.g.b<Message<?>> f2007h;
    public transient /* synthetic */ FieldHolder $fh;
    public MessageManager a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<T> f2008b;

    /* renamed from: c  reason: collision with root package name */
    public final SparseArray<N> f2009c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<LinkedList<MessageListener<N>>> f2010d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.d.c.j.d f2011e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2012f;

    /* renamed from: g  reason: collision with root package name */
    public final SparseIntArray f2013g;

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f2008b = new SparseArray<>();
        this.f2009c = new SparseArray<>();
        this.f2010d = new SparseArray<>();
        this.f2011e = null;
        this.f2012f = false;
        this.f2013g = new SparseIntArray();
        this.a = messageManager;
    }

    public static void q(c.a.d.c.g.b<Message<?>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bVar) == null) {
            f2007h = bVar;
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f2012f = true;
        }
    }

    public final void b(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && k(i)) {
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
                if (this.f2011e != null) {
                    if (t.getTimeOut() == null) {
                        t.setTimeOut(this.f2011e.b());
                    }
                    if (t.getRetry() == 0) {
                        t.setRetry(this.f2011e.a());
                    }
                }
                if (m2 != null) {
                    f(m2, t);
                    return true;
                }
                BdLog.d("message is trapped:" + cmd);
                return false;
            }
            c.a.d.c.g.b<Message<?>> bVar = f2007h;
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
            if (this.f2009c.indexOfKey(cmd) >= 0) {
                this.f2009c.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.f2010d.get(cmd);
            if (linkedList == null) {
                return;
            }
            this.f2012f = false;
            l(cmd);
            try {
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.f2012f) {
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

    public synchronized T g(int i) {
        InterceptResult invokeI;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            synchronized (this) {
                t = this.f2008b.get(i);
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
                int size = this.f2008b.size();
                for (int i = 0; i < size; i++) {
                    arrayList.add(this.f2008b.valueAt(i));
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            LinkedList<MessageListener<N>> linkedList = this.f2010d.get(i);
            return linkedList != null && linkedList.size() > 0;
        }
        return invokeI.booleanValue;
    }

    public final synchronized boolean k(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            synchronized (this) {
                z = this.f2013g.get(i, 0) != 0;
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public final synchronized void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            synchronized (this) {
                this.f2013g.put(i, this.f2013g.get(i, 0) + 1);
            }
        }
    }

    public abstract M m(M m, T t);

    public void n(int i, MessageListener<N> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, messageListener) == null) {
            n.c();
            if (messageListener == null) {
                return;
            }
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            FrameHelper.f(i);
            b(i);
            LinkedList<MessageListener<N>> linkedList = this.f2010d.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.f2010d.put(i, linkedList);
            }
            FrameHelper.insert(linkedList, messageListener);
            N n = this.f2009c.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i) == null) || this.f2009c.indexOfKey(i) >= 0) {
            return;
        }
        this.f2009c.put(i, null);
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
                this.f2008b.put(cmd, t);
            }
        }
    }

    public final synchronized void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            synchronized (this) {
                int i2 = this.f2013g.get(i, 0);
                if (i2 <= 1) {
                    this.f2013g.delete(i);
                } else {
                    this.f2013g.put(i, i2 - 1);
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
            int size = this.f2010d.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.f2010d.keyAt(i);
                Iterator<MessageListener<N>> it = this.f2010d.valueAt(i).iterator();
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
                int size = this.f2010d.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.f2010d.valueAt(i);
                    int keyAt = this.f2010d.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        b(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            b(cmd);
            LinkedList<MessageListener<N>> linkedList = this.f2010d.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.f2009c.remove(i);
        }
    }

    public synchronized void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            synchronized (this) {
                this.f2008b.remove(i);
            }
        }
    }
}
