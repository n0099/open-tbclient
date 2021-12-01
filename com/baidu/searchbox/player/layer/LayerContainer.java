package com.baidu.searchbox.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class LayerContainer extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ILayer> mLayers;
    public FrameLayout.LayoutParams mLayoutParams;
    public BDVideoPlayer mPlayer;

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
        init();
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mLayers = new ArrayList<>();
            this.mLayoutParams = new FrameLayout.LayoutParams(-1, -1);
        }
    }

    @PublicMethod
    public void addLayer(@NonNull AbsLayer absLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, absLayer) == null) {
            addLayer(absLayer, this.mLayoutParams);
        }
    }

    @PublicMethod
    public void attachKernelLayer(@NonNull AbsLayer absLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, absLayer) == null) {
            detachLayer(absLayer);
            absLayer.setLayerContainer(this);
            this.mLayers.add(0, absLayer);
            if (absLayer.getContentView() != null) {
                addView(absLayer.getContentView(), 0, this.mLayoutParams);
            }
        }
    }

    public void bindPlayer(@NonNull BDVideoPlayer bDVideoPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bDVideoPlayer) == null) {
            this.mPlayer = bDVideoPlayer;
        }
    }

    @PublicMethod
    public void detachLayer(@NonNull ILayer iLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iLayer) == null) {
            detachLayer(iLayer, false);
        }
    }

    @NonNull
    @PublicMethod
    public BDVideoPlayer getBindPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mPlayer : (BDVideoPlayer) invokeV.objValue;
    }

    @PublicMethod
    public ArrayList<ILayer> getLayerList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mLayers : (ArrayList) invokeV.objValue;
    }

    @PublicMethod
    public void insertLayer(@NonNull AbsLayer absLayer, @IntRange(from = 0, to = 20) int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, absLayer, i2) == null) {
            detachLayer(absLayer);
            if (i2 < this.mLayers.size()) {
                absLayer.setLayerContainer(this);
                this.mLayers.add(i2, absLayer);
                addView(absLayer.getContentView(), i2, this.mLayoutParams);
            }
        }
    }

    public void onContainerDetach() {
        ArrayList<ILayer> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (arrayList = this.mLayers) == null) {
            return;
        }
        Iterator<ILayer> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onContainerDetach();
        }
    }

    @PublicMethod
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int size = this.mLayers.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mLayers.get(i2).onLayerRelease();
            }
            this.mLayers.clear();
            removeAllViews();
        }
    }

    @PublicMethod
    public void addLayer(@NonNull AbsLayer absLayer, FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absLayer, layoutParams) == null) || this.mLayers.contains(absLayer)) {
            return;
        }
        absLayer.setLayerContainer(this);
        absLayer.initLayer();
        this.mLayers.add(absLayer);
        if (absLayer.getContentView() == null || absLayer.getContentView() == this) {
            return;
        }
        addView(absLayer.getContentView(), layoutParams);
    }

    @PublicMethod
    public void detachLayer(@NonNull ILayer iLayer, boolean z) {
        BDVideoPlayer bDVideoPlayer;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, iLayer, z) == null) {
            this.mLayers.remove(iLayer);
            iLayer.onLayerDetach();
            if (iLayer.getContentView() != null && (viewGroup = (ViewGroup) iLayer.getContentView().getParent()) != null) {
                viewGroup.removeView(iLayer.getContentView());
            }
            if (!z || (bDVideoPlayer = this.mPlayer) == null) {
                return;
            }
            bDVideoPlayer.getVideoSession().unregisterLayer(iLayer);
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
        init();
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
        init();
    }

    @PublicMethod
    public void insertLayer(@NonNull AbsLayer absLayer, @Nullable FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, absLayer, layoutParams) == null) || this.mLayers.contains(absLayer)) {
            return;
        }
        absLayer.setLayerContainer(this);
        this.mLayers.add(absLayer);
        if (layoutParams == null) {
            layoutParams = this.mLayoutParams;
        }
        if (absLayer.getContentView() != this) {
            addView(absLayer.getContentView(), layoutParams);
        }
    }
}
