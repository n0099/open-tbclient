package com.baidu.mobads.sdk.internal;

import android.app.Fragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.CPUComponent;
import com.baidu.mobads.sdk.internal.concrete.FragmentDelegate;
import com.baidu.mobads.sdk.internal.concrete.FragmentV4Delegate;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class cw extends com.baidu.mobads.sdk.internal.a.e implements CPUComponent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final cx a;
    public Fragment b;
    public androidx.fragment.app.Fragment c;

    public cw(cx cxVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cxVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cxVar;
    }

    @Override // com.baidu.mobads.sdk.api.CPUComponent
    public void destroy() {
        cx cxVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (cxVar = this.a) != null) {
            cxVar.e();
        }
    }

    @Override // com.baidu.mobads.sdk.api.CPUComponent
    public Fragment getFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Fragment fragment = this.b;
            if (fragment != null) {
                if (fragment instanceof FragmentDelegate) {
                    ((FragmentDelegate) fragment).setProxy(this);
                }
                return this.b;
            }
            cx cxVar = this.a;
            if (cxVar != null) {
                Fragment a = cxVar.a((com.baidu.mobads.sdk.internal.a.e) this);
                this.b = a;
                return a;
            }
            return null;
        }
        return (Fragment) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.CPUComponent
    public androidx.fragment.app.Fragment getSupportFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            androidx.fragment.app.Fragment fragment = this.c;
            if (fragment != null) {
                if (fragment instanceof FragmentV4Delegate) {
                    ((FragmentV4Delegate) fragment).setProxy(this);
                }
                return this.c;
            }
            cx cxVar = this.a;
            if (cxVar != null) {
                androidx.fragment.app.Fragment b = cxVar.b((com.baidu.mobads.sdk.internal.a.e) this);
                this.c = b;
                return b;
            }
            return null;
        }
        return (androidx.fragment.app.Fragment) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.CPUComponent
    public void refresh() {
        cx cxVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (cxVar = this.a) != null) {
            cxVar.f();
        }
    }
}
