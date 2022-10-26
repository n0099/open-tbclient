package com.baidu.searchbox.player.layer;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.element.AbsElement;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.utils.BdViewOpUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class ElementLayer extends AbsLayer implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup mContainer;
    public final ArrayList mElements;

    public abstract void initContainer();

    public void layoutElement(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, viewGroup) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
        }
    }

    public abstract void setupElement();

    public ElementLayer() {
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
        this.mElements = new ArrayList();
    }

    public ArrayList getElements() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mElements;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return new int[]{4, 5, 2, 3, 1};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.layer.ILayer
    public void onContainerDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onContainerDetach();
            Iterator it = this.mElements.iterator();
            while (it.hasNext()) {
                ((AbsElement) it.next()).onContainerDetach();
            }
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.layer.ILayer
    public void onLayerDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onLayerDetach();
            Iterator it = this.mElements.iterator();
            while (it.hasNext()) {
                ((AbsElement) it.next()).onLayerDetach();
            }
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.layer.ILayer
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onLayerRelease();
            Iterator it = this.mElements.iterator();
            while (it.hasNext()) {
                ((AbsElement) it.next()).onLayerRelease();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ElementLayer(Activity activity) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mElements = new ArrayList();
    }

    public void attachElementView(AbsElement absElement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absElement) == null) {
            BdViewOpUtils.removeView(absElement.getContentView());
            if (checkLayoutParams(absElement.getLayoutParams())) {
                this.mContainer.addView(absElement.getContentView(), absElement.getLayoutParams());
            } else {
                this.mContainer.addView(absElement.getContentView());
            }
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutParams)) == null) {
            if (getContentView() instanceof FrameLayout) {
                return layoutParams instanceof FrameLayout.LayoutParams;
            }
            if (getContentView() instanceof LinearLayout) {
                return layoutParams instanceof LinearLayout.LayoutParams;
            }
            if (getContentView() instanceof RelativeLayout) {
                return layoutParams instanceof RelativeLayout.LayoutParams;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void addElement(AbsElement absElement) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, absElement) == null) && !this.mElements.contains(absElement)) {
            this.mElements.add(absElement);
        }
    }

    public void detachElementView(AbsElement absElement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, absElement) == null) {
            this.mContainer.removeView(absElement.getContentView());
        }
    }

    public void dispatchEvent(VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, videoEvent) == null) {
            Iterator it = this.mElements.iterator();
            while (it.hasNext()) {
                ((AbsElement) it.next()).onEventNotify(videoEvent);
            }
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer
    public void handleLayerMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, message) == null) {
            super.handleLayerMessage(message);
            Iterator it = this.mElements.iterator();
            while (it.hasNext()) {
                ((AbsElement) it.next()).handleLayerMessage(message);
            }
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onControlEventNotify(VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, videoEvent) == null) {
            super.onControlEventNotify(videoEvent);
            dispatchEvent(videoEvent);
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onInteractiveEventNotify(VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, videoEvent) == null) {
            super.onInteractiveEventNotify(videoEvent);
            dispatchEvent(videoEvent);
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onLayerEventNotify(VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, videoEvent) == null) {
            super.onLayerEventNotify(videoEvent);
            dispatchEvent(videoEvent);
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, videoEvent) == null) {
            super.onPlayerEventNotify(videoEvent);
            dispatchEvent(videoEvent);
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onSystemEventNotify(VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, videoEvent) == null) {
            super.onSystemEventNotify(videoEvent);
            dispatchEvent(videoEvent);
        }
    }

    public void removeElement(AbsElement absElement) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, absElement) == null) && this.mElements.remove(absElement)) {
            detachElementView(absElement);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.layer.ILayer
    public ViewGroup getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mContainer;
        }
        return (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.layer.ILayer
    public void initLayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            initContainer();
            setupElement();
            Iterator it = this.mElements.iterator();
            while (it.hasNext()) {
                AbsElement absElement = (AbsElement) it.next();
                absElement.setParent(this);
                absElement.initElement();
                if (absElement.attachToRootAtOnce()) {
                    attachElementView(absElement);
                }
            }
            layoutElement(this.mContainer);
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, playerStatus, playerStatus2) == null) {
            super.onPlayerStatusChanged(playerStatus, playerStatus2);
            Iterator it = this.mElements.iterator();
            while (it.hasNext()) {
                ((AbsElement) it.next()).onPlayerStatusChanged(playerStatus, playerStatus2);
            }
        }
    }
}
