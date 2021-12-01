package com.baidu.nadcore.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.s.e;
import c.a.b0.s.j0.b;
import c.a.b0.s.j0.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class LayerContainer extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout.LayoutParams f37614e;

    /* renamed from: f  reason: collision with root package name */
    public e f37615f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<b> f37616g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayerContainer(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f37616g = new ArrayList<>();
            this.f37614e = new FrameLayout.LayoutParams(-1, -1);
        }
    }

    public void addLayer(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            addLayer(bVar, getContainerParams());
        }
    }

    public void attachKernelLayer(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            detachLayer(bVar);
            bVar.M(this);
            bVar.s(getBindPlayer().x());
            this.f37616g.add(0, bVar);
            if (bVar.getContentView() != null) {
                addView(bVar.getContentView(), 0, this.f37614e);
            }
        }
    }

    public void attachLayerMessenger(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            bVar.s(getBindPlayer().x());
        }
    }

    public void bindPlayer(@NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            this.f37615f = eVar;
        }
    }

    @Deprecated
    public void detachLayer(@NonNull o oVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, oVar) == null) && (oVar instanceof b)) {
            detachLayer((b) oVar, false);
        }
    }

    public void detachLayerMessenger(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            bVar.t();
        }
    }

    @NonNull
    public e getBindPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f37615f : (e) invokeV.objValue;
    }

    public FrameLayout.LayoutParams getContainerParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new FrameLayout.LayoutParams(-1, -1) : (FrameLayout.LayoutParams) invokeV.objValue;
    }

    public ArrayList<b> getLayerList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f37616g : (ArrayList) invokeV.objValue;
    }

    public void insertLayer(@NonNull b bVar, @IntRange(from = 0, to = 20) int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, bVar, i2) == null) {
            detachLayer(bVar);
            if (i2 < this.f37616g.size()) {
                bVar.M(this);
                bVar.s(getBindPlayer().x());
                this.f37616g.add(i2, bVar);
                addView(bVar.getContentView(), i2, getContainerParams());
            }
        }
    }

    public void onContainerDetach() {
        ArrayList<b> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (arrayList = this.f37616g) == null) {
            return;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onContainerDetach();
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            int size = this.f37616g.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f37616g.get(i2).onLayerRelease();
            }
            this.f37616g.clear();
            removeAllViews();
        }
    }

    public void addLayer(@NonNull b bVar, FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bVar, layoutParams) == null) || this.f37616g.contains(bVar)) {
            return;
        }
        bVar.M(this);
        bVar.C();
        bVar.s(getBindPlayer().x());
        this.f37616g.add(bVar);
        if (bVar.getContentView() == null || bVar.getContentView() == this) {
            return;
        }
        addView(bVar.getContentView(), layoutParams);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a();
    }

    @Deprecated
    public void detachLayer(@NonNull o oVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048585, this, oVar, z) == null) && (oVar instanceof b)) {
            detachLayer((b) oVar, z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a();
    }

    public void detachLayer(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            detachLayer(bVar, false);
        }
    }

    public void detachLayer(@NonNull b bVar, boolean z) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, bVar, z) == null) {
            this.f37616g.remove(bVar);
            bVar.E();
            if (bVar.getContentView() != null && (viewGroup = (ViewGroup) bVar.getContentView().getParent()) != null) {
                viewGroup.removeView(bVar.getContentView());
            }
            if (z) {
                bVar.t();
            }
        }
    }

    public void insertLayer(@NonNull b bVar, @Nullable FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, bVar, layoutParams) == null) || this.f37616g.contains(bVar)) {
            return;
        }
        bVar.M(this);
        bVar.s(getBindPlayer().x());
        this.f37616g.add(bVar);
        if (layoutParams == null) {
            layoutParams = getContainerParams();
        }
        if (bVar.getContentView() != this) {
            addView(bVar.getContentView(), layoutParams);
        }
    }
}
