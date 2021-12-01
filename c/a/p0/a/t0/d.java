package c.a.p0.a.t0;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class d implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<b> a;

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
        this.a = new CopyOnWriteArrayList();
    }

    @Override // c.a.p0.a.t0.b
    public void a() {
        List<b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.a) {
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    @Override // c.a.p0.a.t0.b
    public void b() {
        List<b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.a) {
            bVar.b();
        }
    }

    @Override // c.a.p0.a.t0.b
    public void c() {
        List<b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.a) {
            bVar.c();
        }
    }

    @Override // c.a.p0.a.t0.b
    public void d() {
        List<b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.a) {
            bVar.d();
        }
    }

    @Override // c.a.p0.a.t0.b
    public void e() {
        List<b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.a) {
            bVar.e();
        }
    }

    @Override // c.a.p0.a.t0.b
    public void f() {
        List<b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.a) {
            bVar.f();
        }
    }

    @Override // c.a.p0.a.t0.b
    public void g() {
        List<b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.a) {
            bVar.g();
        }
    }

    public void h(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.a.add(bVar);
        }
    }

    public void i(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.a.remove(bVar);
        }
    }

    @Override // c.a.p0.a.t0.b
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, keyEvent)) == null) {
            List<b> list = this.a;
            if (list == null || list.size() <= 0) {
                return false;
            }
            while (true) {
                for (b bVar : this.a) {
                    z = z || bVar.onKeyDown(i2, keyEvent);
                }
                return z;
            }
        }
        return invokeIL.booleanValue;
    }
}
