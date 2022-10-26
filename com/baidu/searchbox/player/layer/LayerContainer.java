package com.baidu.searchbox.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.BDVideoPlayer;
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
    public ArrayList<AbsLayer> mLayers;
    public FrameLayout.LayoutParams mLayoutParams;
    public BDVideoPlayer mPlayer;

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
        init();
    }

    public void attachKernelLayer(AbsLayer absLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, absLayer) == null) {
            detachLayer(absLayer);
            absLayer.setLayerContainer(this);
            absLayer.attachMessenger(getBindPlayer().getMessenger());
            this.mLayers.add(0, absLayer);
            if (absLayer.getContentView() != null) {
                addView(absLayer.getContentView(), 0, this.mLayoutParams);
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
        init();
    }

    public void addLayer(AbsLayer absLayer, FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absLayer, layoutParams) != null) || this.mLayers.contains(absLayer)) {
            return;
        }
        absLayer.setLayerContainer(this);
        absLayer.initLayer();
        absLayer.attachMessenger(getBindPlayer().getMessenger());
        this.mLayers.add(absLayer);
        if (absLayer.getContentView() != null && absLayer.getContentView() != this) {
            addView(absLayer.getContentView(), layoutParams);
        }
    }

    public void detachLayer(AbsLayer absLayer, boolean z) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, absLayer, z) == null) {
            this.mLayers.remove(absLayer);
            absLayer.onLayerDetach();
            if (absLayer.getContentView() != null && (viewGroup = (ViewGroup) absLayer.getContentView().getParent()) != null) {
                viewGroup.removeView(absLayer.getContentView());
            }
            if (z) {
                absLayer.detachMessenger();
            }
        }
    }

    public void insertLayer(AbsLayer absLayer, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, absLayer, i) == null) {
            detachLayer(absLayer);
            if (i < this.mLayers.size()) {
                absLayer.setLayerContainer(this);
                absLayer.attachMessenger(getBindPlayer().getMessenger());
                this.mLayers.add(i, absLayer);
                addView(absLayer.getContentView(), i, getContainerParams());
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
        init();
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mLayers = new ArrayList<>();
            this.mLayoutParams = new FrameLayout.LayoutParams(-1, -1);
        }
    }

    public BDVideoPlayer getBindPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mPlayer;
        }
        return (BDVideoPlayer) invokeV.objValue;
    }

    public FrameLayout.LayoutParams getContainerParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return new FrameLayout.LayoutParams(-1, -1);
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    public ArrayList<AbsLayer> getLayerList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mLayers;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void onContainerDetach() {
        ArrayList<AbsLayer> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (arrayList = this.mLayers) != null) {
            Iterator<AbsLayer> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onContainerDetach();
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            int size = this.mLayers.size();
            for (int i = 0; i < size; i++) {
                this.mLayers.get(i).onLayerRelease();
            }
            this.mLayers.clear();
            removeAllViews();
        }
    }

    public void addLayer(AbsLayer absLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, absLayer) == null) {
            addLayer(absLayer, getContainerParams());
        }
    }

    public void attachLayerMessenger(AbsLayer absLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, absLayer) == null) {
            absLayer.attachMessenger(getBindPlayer().getMessenger());
        }
    }

    public void bindPlayer(BDVideoPlayer bDVideoPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bDVideoPlayer) == null) {
            this.mPlayer = bDVideoPlayer;
        }
    }

    public void detachLayer(AbsLayer absLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, absLayer) == null) {
            detachLayer(absLayer, false);
        }
    }

    public void detachLayerMessenger(AbsLayer absLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, absLayer) == null) {
            absLayer.detachMessenger();
        }
    }

    @Deprecated
    public void detachLayer(ILayer iLayer) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, iLayer) == null) && (iLayer instanceof AbsLayer)) {
            detachLayer((AbsLayer) iLayer, false);
        }
    }

    @Deprecated
    public void detachLayer(ILayer iLayer, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, iLayer, z) == null) && (iLayer instanceof AbsLayer)) {
            detachLayer((AbsLayer) iLayer, z);
        }
    }

    public void insertLayer(AbsLayer absLayer, FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, absLayer, layoutParams) != null) || this.mLayers.contains(absLayer)) {
            return;
        }
        absLayer.setLayerContainer(this);
        absLayer.attachMessenger(getBindPlayer().getMessenger());
        this.mLayers.add(absLayer);
        if (layoutParams == null) {
            layoutParams = getContainerParams();
        }
        if (absLayer.getContentView() != this) {
            addView(absLayer.getContentView(), layoutParams);
        }
    }
}
