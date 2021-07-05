package com.baidu.ar.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int is;
    public final ReentrantLock it;
    public Map<String, a> iu;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Thread iv;
        public com.baidu.ar.c.a iw;
        public BlockingQueue<com.baidu.ar.c.a> ix;
        public final /* synthetic */ b iy;
        public String tag;

        public a(b bVar, String str, com.baidu.ar.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.iy = bVar;
            this.iw = aVar;
            this.iv = new Thread(this);
            this.ix = new ArrayBlockingQueue(10);
            this.tag = str;
        }

        public a(b bVar, String str, BlockingQueue<com.baidu.ar.c.a> blockingQueue) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, blockingQueue};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.iy = bVar;
            this.iv = new Thread(this);
            this.ix = blockingQueue;
            this.tag = str;
        }

        private void cc() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                this.iy.it.lock();
                try {
                    this.iy.iu.remove(this.tag);
                    if (this.ix.size() > 0) {
                        a aVar = new a(this.iy, this.tag, this.ix);
                        this.iy.iu.put(this.tag, aVar);
                        aVar.iv.start();
                    }
                } finally {
                    this.iy.it.unlock();
                }
            }
        }

        public boolean b(com.baidu.ar.c.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? this.ix.offer(aVar) : invokeL.booleanValue;
        }

        public final void cb() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            com.baidu.ar.c.a aVar = this.iw;
            this.iw = null;
            while (true) {
                if (aVar == null) {
                    try {
                        aVar = this.ix.poll(this.iy.is, TimeUnit.MILLISECONDS);
                        if (aVar == null) {
                            return;
                        }
                    } finally {
                        cc();
                    }
                }
                aVar.run();
                aVar = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    cb();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public b() {
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
        this.is = 1500;
        this.it = new ReentrantLock();
        this.iu = new HashMap();
    }

    public int R(String str) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (aVar = this.iu.get(str)) == null) {
                return 0;
            }
            BlockingQueue<com.baidu.ar.c.a> blockingQueue = aVar.ix;
            int size = blockingQueue.size();
            blockingQueue.clear();
            return size;
        }
        return invokeL.intValue;
    }

    public boolean a(com.baidu.ar.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            if (aVar == null) {
                return false;
            }
            boolean z = true;
            ReentrantLock reentrantLock = this.it;
            reentrantLock.lock();
            try {
                String tag = aVar.getTag();
                if (tag == null) {
                    tag = "";
                }
                a aVar2 = this.iu.get(tag);
                if (aVar2 == null) {
                    a aVar3 = new a(this, tag, aVar);
                    this.iu.put(tag, aVar3);
                    aVar3.iv.start();
                } else {
                    z = aVar2.b(aVar);
                }
                return z;
            } finally {
                reentrantLock.unlock();
            }
        }
        return invokeL.booleanValue;
    }
}
