package com.baidu.location.d;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WeakReference f6738a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f6739b;

    public b(a aVar, WeakReference weakReference) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, weakReference};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6739b = aVar;
        this.f6738a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = (a) this.f6738a.get()) == null) {
            return;
        }
        i2 = aVar.f6736h;
        if (i2 == 3) {
            Log.d("baidu_location_service", "baidu location service force stopped ...");
            aVar.b();
        }
    }
}
