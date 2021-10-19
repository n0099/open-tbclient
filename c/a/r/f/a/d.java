package c.a.r.f.a;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class d<T> implements c.a.r.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f15381a;

    /* renamed from: b  reason: collision with root package name */
    public final CountDownLatch f15382b;

    /* renamed from: c  reason: collision with root package name */
    public b<T> f15383c;

    /* renamed from: d  reason: collision with root package name */
    public a f15384d;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Bundle f15385a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public T f15386a;

        /* renamed from: b  reason: collision with root package name */
        public Bundle f15387b;

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
                }
            }
        }
    }

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
        this.f15381a = false;
        this.f15382b = new CountDownLatch(1);
        this.f15383c = null;
        this.f15384d = null;
    }

    public b<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15383c : (b) invokeV.objValue;
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            try {
                this.f15382b.await(i2, TimeUnit.MILLISECONDS);
                if (this.f15384d == null) {
                    this.f15384d = new a();
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            return this.f15381a;
        }
        return invokeI.booleanValue;
    }

    public a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15384d : (a) invokeV.objValue;
    }

    @Override // c.a.r.c
    public void onError(int i2, Throwable th, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, th, bundle) == null) {
            a aVar = new a();
            this.f15384d = aVar;
            aVar.f15385a = bundle;
            this.f15381a = false;
            this.f15382b.countDown();
        }
    }

    @Override // c.a.r.c
    public void onResult(T t, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, t, bundle) == null) {
            b<T> bVar = new b<>();
            this.f15383c = bVar;
            bVar.f15386a = t;
            bVar.f15387b = bundle;
            this.f15381a = true;
            this.f15382b.countDown();
        }
    }
}
