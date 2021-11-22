package b.a.q0.k0.f;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.k0.d.b;
import b.a.r0.m3.u;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class e<D, S extends b.a.q0.k0.d.b> implements u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final ViewEventCenter f13453e;

    /* renamed from: f  reason: collision with root package name */
    public D f13454f;

    /* renamed from: g  reason: collision with root package name */
    public S f13455g;

    /* renamed from: h  reason: collision with root package name */
    public final View f13456h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<?> f13457i;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13457i = tbPageContext;
        this.f13456h = view;
        this.f13453e = viewEventCenter;
    }

    public D a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13454f : (D) invokeV.objValue;
    }

    public ViewEventCenter b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13453e : (ViewEventCenter) invokeV.objValue;
    }

    public TbPageContext<?> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13457i : (TbPageContext) invokeV.objValue;
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13456h : (View) invokeV.objValue;
    }

    public S e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13455g : (S) invokeV.objValue;
    }

    public String f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? getResources().getString(i2) : (String) invokeI.objValue;
    }

    public BdUniqueId g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f13457i.getUniqueId() : (BdUniqueId) invokeV.objValue;
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f13457i.getPageActivity() : (Activity) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f13457i.getContext() : (Context) invokeV.objValue;
    }

    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f13457i.getResources() : (Resources) invokeV.objValue;
    }

    public void h(D d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, d2) == null) {
            this.f13454f = d2;
        }
    }

    public void i(D d2, S s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, d2, s) == null) {
            h(d2);
            j(s);
        }
    }

    public void j(S s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, s) == null) {
            this.f13455g = s;
        }
    }
}
