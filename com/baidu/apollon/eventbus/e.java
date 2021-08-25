package com.baidu.apollon.eventbus;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList<d> f37766a;

    public e() {
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
        this.f37766a = new LinkedList<>();
    }

    public synchronized void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            synchronized (this) {
                if (dVar != null) {
                    this.f37766a.offer(dVar);
                    notifyAll();
                } else {
                    throw new NullPointerException("null cannot be enqueued");
                }
            }
        }
    }

    public synchronized d a() {
        InterceptResult invokeV;
        d poll;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                poll = this.f37766a.poll();
            }
            return poll;
        }
        return (d) invokeV.objValue;
    }

    public synchronized d a(int i2) throws InterruptedException {
        InterceptResult invokeI;
        d a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            synchronized (this) {
                a2 = a();
                if (a2 == null) {
                    wait(i2);
                    a2 = a();
                }
            }
            return a2;
        }
        return (d) invokeI.objValue;
    }
}
