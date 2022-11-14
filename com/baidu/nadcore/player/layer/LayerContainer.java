package com.baidu.nadcore.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ax0;
import com.baidu.tieba.tr0;
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
    public tr0 b;
    public ArrayList<ax0> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayerContainer(@NonNull Context context) {
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

    public void c(@NonNull ax0 ax0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ax0Var) == null) {
            e(ax0Var);
            ax0Var.I(this);
            ax0Var.r(getBindPlayer().x());
            this.c.add(0, ax0Var);
            if (ax0Var.getContentView() != null) {
                addView(ax0Var.getContentView(), 0, this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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

    public void b(@NonNull ax0 ax0Var, FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ax0Var, layoutParams) != null) || this.c.contains(ax0Var)) {
            return;
        }
        ax0Var.I(this);
        ax0Var.B();
        ax0Var.r(getBindPlayer().x());
        this.c.add(ax0Var);
        if (ax0Var.getContentView() != null && ax0Var.getContentView() != this) {
            addView(ax0Var.getContentView(), layoutParams);
        }
    }

    public void f(@NonNull ax0 ax0Var, boolean z) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, ax0Var, z) == null) {
            this.c.remove(ax0Var);
            ax0Var.D();
            if (ax0Var.getContentView() != null && (viewGroup = (ViewGroup) ax0Var.getContentView().getParent()) != null) {
                viewGroup.removeView(ax0Var.getContentView());
            }
            if (z) {
                ax0Var.s();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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

    public void a(@NonNull ax0 ax0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ax0Var) == null) {
            b(ax0Var, getContainerParams());
        }
    }

    public void d(@NonNull tr0 tr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tr0Var) == null) {
            this.b = tr0Var;
        }
    }

    public void e(@NonNull ax0 ax0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ax0Var) == null) {
            f(ax0Var, false);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c = new ArrayList<>();
            this.a = new FrameLayout.LayoutParams(-1, -1);
        }
    }

    @NonNull
    public tr0 getBindPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (tr0) invokeV.objValue;
    }

    public FrameLayout.LayoutParams getContainerParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return new FrameLayout.LayoutParams(-1, -1);
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    public ArrayList<ax0> getLayerList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.c;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void h() {
        ArrayList<ax0> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (arrayList = this.c) != null) {
            Iterator<ax0> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onContainerDetach();
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                this.c.get(i).onLayerRelease();
            }
            this.c.clear();
            removeAllViews();
        }
    }
}
