package c.a.w.e.a;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final View f30409a;

    /* renamed from: b  reason: collision with root package name */
    public int f30410b;

    /* renamed from: c  reason: collision with root package name */
    public int f30411c;

    /* renamed from: d  reason: collision with root package name */
    public int f30412d;

    /* renamed from: e  reason: collision with root package name */
    public int f30413e;

    public b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30409a = view;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30412d : invokeV.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f30410b = this.f30409a.getTop();
            this.f30411c = this.f30409a.getLeft();
            e();
        }
    }

    public boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (this.f30413e != i2) {
                this.f30413e = i2;
                e();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (this.f30412d != i2) {
                this.f30412d = i2;
                e();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View view = this.f30409a;
            ViewCompat.offsetTopAndBottom(view, this.f30412d - (view.getTop() - this.f30410b));
            View view2 = this.f30409a;
            ViewCompat.offsetLeftAndRight(view2, this.f30413e - (view2.getLeft() - this.f30411c));
        }
    }
}
