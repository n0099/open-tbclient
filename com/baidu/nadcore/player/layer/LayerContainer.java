package com.baidu.nadcore.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.br0;
import com.baidu.tieba.iw0;
import com.baidu.tieba.vw0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class LayerContainer extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout.LayoutParams a;
    public br0 b;
    public ArrayList c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayerContainer(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        g();
    }

    public void c(iw0 iw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iw0Var) == null) {
            e(iw0Var);
            iw0Var.I(this);
            iw0Var.r(getBindPlayer().x());
            this.c.add(0, iw0Var);
            if (iw0Var.getContentView() != null) {
                addView(iw0Var.getContentView(), 0, this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayerContainer(Context context, AttributeSet attributeSet) {
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
        g();
    }

    public void b(iw0 iw0Var, FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iw0Var, layoutParams) != null) || this.c.contains(iw0Var)) {
            return;
        }
        iw0Var.I(this);
        iw0Var.B();
        iw0Var.r(getBindPlayer().x());
        this.c.add(iw0Var);
        if (iw0Var.getContentView() != null && iw0Var.getContentView() != this) {
            addView(iw0Var.getContentView(), layoutParams);
        }
    }

    public void f(iw0 iw0Var, boolean z) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, iw0Var, z) == null) {
            this.c.remove(iw0Var);
            iw0Var.D();
            if (iw0Var.getContentView() != null && (viewGroup = (ViewGroup) iw0Var.getContentView().getParent()) != null) {
                viewGroup.removeView(iw0Var.getContentView());
            }
            if (z) {
                iw0Var.s();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayerContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        g();
    }

    public void a(iw0 iw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iw0Var) == null) {
            b(iw0Var, getContainerParams());
        }
    }

    public void d(br0 br0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, br0Var) == null) {
            this.b = br0Var;
        }
    }

    public void e(iw0 iw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iw0Var) == null) {
            f(iw0Var, false);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c = new ArrayList();
            this.a = new FrameLayout.LayoutParams(-1, -1);
        }
    }

    public br0 getBindPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (br0) invokeV.objValue;
    }

    public FrameLayout.LayoutParams getContainerParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return new FrameLayout.LayoutParams(-1, -1);
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    public ArrayList getLayerList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.c;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void h() {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (arrayList = this.c) != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((vw0) it.next()).onContainerDetach();
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                ((vw0) this.c.get(i)).onLayerRelease();
            }
            this.c.clear();
            removeAllViews();
        }
    }
}
