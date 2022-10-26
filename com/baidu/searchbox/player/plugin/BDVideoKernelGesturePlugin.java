package com.baidu.searchbox.player.plugin;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.view.BdVideoMultipleGesturesDetector;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\b\"\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/player/plugin/BDVideoKernelGesturePlugin;", "Lcom/baidu/searchbox/player/plugin/AbsPlugin;", "Landroid/view/View;", "renderView", "Lcom/baidu/searchbox/player/view/BdVideoMultipleGesturesDetector;", "createGestureDetector", "(Landroid/view/View;)Lcom/baidu/searchbox/player/view/BdVideoMultipleGesturesDetector;", "getGestureDetector", "()Lcom/baidu/searchbox/player/view/BdVideoMultipleGesturesDetector;", "", "getSubscribeEvent", "()[I", "", "initGestureDetector", "()V", "Lcom/baidu/searchbox/player/event/VideoEvent;", "event", "onLayerEventNotify", "(Lcom/baidu/searchbox/player/event/VideoEvent;)V", "onPlayerEventNotify", "", "withAnimation", "recoverVideoViewMatrixChanges", "(Z)V", "kernelGestureDetector", "Lcom/baidu/searchbox/player/view/BdVideoMultipleGesturesDetector;", "getKernelGestureDetector", "setKernelGestureDetector", "(Lcom/baidu/searchbox/player/view/BdVideoMultipleGesturesDetector;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public abstract class BDVideoKernelGesturePlugin extends AbsPlugin {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdVideoMultipleGesturesDetector kernelGestureDetector;

    public abstract void initGestureDetector();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BDVideoKernelGesturePlugin(Context context) {
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
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void recoverVideoViewMatrixChanges$default(BDVideoKernelGesturePlugin bDVideoKernelGesturePlugin, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            bDVideoKernelGesturePlugin.recoverVideoViewMatrixChanges(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recoverVideoViewMatrixChanges");
    }

    public BdVideoMultipleGesturesDetector createGestureDetector(View renderView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, renderView)) == null) {
            Intrinsics.checkNotNullParameter(renderView, "renderView");
            return new BdVideoMultipleGesturesDetector(renderView);
        }
        return (BdVideoMultipleGesturesDetector) invokeL.objValue;
    }

    public void recoverVideoViewMatrixChanges(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (!z) {
                BdVideoMultipleGesturesDetector bdVideoMultipleGesturesDetector = this.kernelGestureDetector;
                if (bdVideoMultipleGesturesDetector != null) {
                    bdVideoMultipleGesturesDetector.switchNormal();
                    return;
                }
                return;
            }
            BdVideoMultipleGesturesDetector bdVideoMultipleGesturesDetector2 = this.kernelGestureDetector;
            if (bdVideoMultipleGesturesDetector2 != null) {
                bdVideoMultipleGesturesDetector2.switchNormalWithAnimation();
            }
        }
    }

    public final void setKernelGestureDetector(BdVideoMultipleGesturesDetector bdVideoMultipleGesturesDetector) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdVideoMultipleGesturesDetector) == null) {
            this.kernelGestureDetector = bdVideoMultipleGesturesDetector;
        }
    }

    public BdVideoMultipleGesturesDetector getGestureDetector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.kernelGestureDetector;
        }
        return (BdVideoMultipleGesturesDetector) invokeV.objValue;
    }

    public final BdVideoMultipleGesturesDetector getKernelGestureDetector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.kernelGestureDetector;
        }
        return (BdVideoMultipleGesturesDetector) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new int[]{3, 4};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public void onLayerEventNotify(VideoEvent event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            String action = event.getAction();
            int hashCode = action.hashCode();
            if (hashCode != -552580917) {
                if (hashCode == 287346615 && action.equals(LayerEvent.ACTION_VIDEO_VIEW_RECOVER)) {
                    recoverVideoViewMatrixChanges(event.getBooleanExtra(30, true));
                }
            } else if (action.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                recoverVideoViewMatrixChanges$default(this, false, 1, null);
            }
        }
    }

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(VideoEvent event) {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            String action = event.getAction();
            int hashCode = action.hashCode();
            Context context2 = null;
            boolean z = true;
            if (hashCode != -1043170264) {
                if (hashCode != -525235558) {
                    if (hashCode != -461848373 || !action.equals(PlayerEvent.ACTION_ON_ERROR)) {
                        return;
                    }
                } else if (!action.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                    return;
                }
                recoverVideoViewMatrixChanges$default(this, false, 1, null);
            } else if (action.equals(PlayerEvent.ACTION_PLAYER_ATTACH) && (context = getContext()) != null) {
                if (this.kernelGestureDetector != null) {
                    z = false;
                }
                if (z) {
                    context2 = context;
                }
                if (context2 != null) {
                    initGestureDetector();
                }
            }
        }
    }
}
