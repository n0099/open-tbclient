package com.baidu.location.d;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ WeakReference a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f26041b;

    public b(a aVar, WeakReference weakReference) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, weakReference};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26041b = aVar;
        this.a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = (a) this.a.get()) == null) {
            return;
        }
        i = aVar.f26040h;
        if (i == 3) {
            Log.d("baidu_location_service", "baidu location service force stopped ...");
            aVar.b();
        }
    }
}
