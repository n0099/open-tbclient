package com.baidu.live.framework.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.framework.coordinatorlayout.CoordinatorLayout;
import com.baidu.tieba.nb0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ViewOffsetBehavior extends CoordinatorLayout.Behavior {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nb0 a;
    public int b;
    public int c;

    public ViewOffsetBehavior() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = 0;
    }

    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            nb0 nb0Var = this.a;
            if (nb0Var != null) {
                return nb0Var.a();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = 0;
    }

    public void F(CoordinatorLayout coordinatorLayout, View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, coordinatorLayout, view2, i) == null) {
            coordinatorLayout.C(view2, i);
        }
    }

    public boolean G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            nb0 nb0Var = this.a;
            if (nb0Var != null) {
                return nb0Var.d(i);
            }
            this.b = i;
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
    public boolean l(CoordinatorLayout coordinatorLayout, View view2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048579, this, coordinatorLayout, view2, i)) == null) {
            F(coordinatorLayout, view2, i);
            if (this.a == null) {
                this.a = new nb0(view2);
            }
            this.a.b();
            int i2 = this.b;
            if (i2 != 0) {
                this.a.d(i2);
                this.b = 0;
            }
            int i3 = this.c;
            if (i3 != 0) {
                this.a.c(i3);
                this.c = 0;
                return true;
            }
            return true;
        }
        return invokeLLI.booleanValue;
    }
}
