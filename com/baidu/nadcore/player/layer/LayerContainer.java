package com.baidu.nadcore.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ko0;
import com.repackage.rt0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class LayerContainer extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout.LayoutParams a;
    public ko0 b;
    public ArrayList<rt0> c;

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

    public void a(@NonNull rt0 rt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rt0Var) == null) {
            b(rt0Var, getContainerParams());
        }
    }

    public void b(@NonNull rt0 rt0Var, FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rt0Var, layoutParams) == null) || this.c.contains(rt0Var)) {
            return;
        }
        rt0Var.J(this);
        rt0Var.C();
        rt0Var.s(getBindPlayer().x());
        this.c.add(rt0Var);
        if (rt0Var.getContentView() == null || rt0Var.getContentView() == this) {
            return;
        }
        addView(rt0Var.getContentView(), layoutParams);
    }

    public void c(@NonNull rt0 rt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rt0Var) == null) {
            e(rt0Var);
            rt0Var.J(this);
            rt0Var.s(getBindPlayer().x());
            this.c.add(0, rt0Var);
            if (rt0Var.getContentView() != null) {
                addView(rt0Var.getContentView(), 0, this.a);
            }
        }
    }

    public void d(@NonNull ko0 ko0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ko0Var) == null) {
            this.b = ko0Var;
        }
    }

    public void e(@NonNull rt0 rt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, rt0Var) == null) {
            f(rt0Var, false);
        }
    }

    public void f(@NonNull rt0 rt0Var, boolean z) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, rt0Var, z) == null) {
            this.c.remove(rt0Var);
            rt0Var.E();
            if (rt0Var.getContentView() != null && (viewGroup = (ViewGroup) rt0Var.getContentView().getParent()) != null) {
                viewGroup.removeView(rt0Var.getContentView());
            }
            if (z) {
                rt0Var.t();
            }
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
    public ko0 getBindPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b : (ko0) invokeV.objValue;
    }

    public FrameLayout.LayoutParams getContainerParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new FrameLayout.LayoutParams(-1, -1) : (FrameLayout.LayoutParams) invokeV.objValue;
    }

    public ArrayList<rt0> getLayerList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.c : (ArrayList) invokeV.objValue;
    }

    public void h() {
        ArrayList<rt0> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (arrayList = this.c) == null) {
            return;
        }
        Iterator<rt0> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onContainerDetach();
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
}
