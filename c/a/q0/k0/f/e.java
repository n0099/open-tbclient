package c.a.q0.k0.f;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.k0.d.b;
import c.a.r0.j3.t;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class e<D, S extends c.a.q0.k0.d.b> implements t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final ViewEventCenter f13549e;

    /* renamed from: f  reason: collision with root package name */
    public D f13550f;

    /* renamed from: g  reason: collision with root package name */
    public S f13551g;

    /* renamed from: h  reason: collision with root package name */
    public final View f13552h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<?> f13553i;

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
        this.f13553i = tbPageContext;
        this.f13552h = view;
        this.f13549e = viewEventCenter;
    }

    public Activity a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13553i.getPageActivity() : (Activity) invokeV.objValue;
    }

    public Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13553i.getContext() : (Context) invokeV.objValue;
    }

    public D c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13550f : (D) invokeV.objValue;
    }

    public ViewEventCenter d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13549e : (ViewEventCenter) invokeV.objValue;
    }

    public TbPageContext<?> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13553i : (TbPageContext) invokeV.objValue;
    }

    public Resources f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f13553i.getResources() : (Resources) invokeV.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f13552h : (View) invokeV.objValue;
    }

    public S h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f13551g : (S) invokeV.objValue;
    }

    public String i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? f().getString(i2) : (String) invokeI.objValue;
    }

    public BdUniqueId j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f13553i.getUniqueId() : (BdUniqueId) invokeV.objValue;
    }

    public void k(D d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, d2) == null) {
            this.f13550f = d2;
        }
    }

    public void l(D d2, S s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, d2, s) == null) {
            k(d2);
            m(s);
        }
    }

    public void m(S s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, s) == null) {
            this.f13551g = s;
        }
    }
}
