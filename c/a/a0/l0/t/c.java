package c.a.a0.l0.t;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.nadcore.widget.view.NadExpressNaBaseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final View f1497b;

    /* renamed from: c  reason: collision with root package name */
    public String f1498c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.a0.l0.r.b f1499d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.a0.l0.r.a f1500e;

    public c(int i, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1498c = null;
        this.a = i;
        this.f1497b = view;
    }

    public static boolean c(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        c.a.a0.s.c cVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adBaseModel)) == null) ? d(adBaseModel) && adBaseModel.f27545h.a == AdOperator.TYPE.DOWNLOAD && (cVar = adBaseModel.l) != null && cVar.f1535e : invokeL.booleanValue;
    }

    public static boolean d(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adBaseModel)) == null) ? (adBaseModel == null || adBaseModel.f27545h == null) ? false : true : invokeL.booleanValue;
    }

    public final <T> T a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? (T) this.f1497b.findViewById(i) : (T) invokeI.objValue;
    }

    public final <T> T b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (T) this.f1497b.getTag() : (T) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public void f(c.a.a0.l0.r.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f1499d = bVar;
        }
    }

    public final <T> void g(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
            this.f1497b.setTag(t);
        }
    }

    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1497b.getContext() : (Context) invokeV.objValue;
    }

    public final Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f1497b.getResources() : (Resources) invokeV.objValue;
    }

    public void h(c.a.a0.l0.r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f1500e = aVar;
        }
    }

    public final void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f1497b.setVisibility(i);
        }
    }

    public void j() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (view = this.f1497b) == null || view.getLayoutParams() == null) {
            return;
        }
        this.f1497b.getLayoutParams().height = -2;
        View view2 = this.f1497b;
        view2.setLayoutParams(view2.getLayoutParams());
    }

    public void update(AdBaseModel adBaseModel, NadExpressNaBaseView nadExpressNaBaseView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, adBaseModel, nadExpressNaBaseView) == null) {
            g(adBaseModel);
        }
    }
}
