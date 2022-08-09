package com.baidu.searchbox.player.element;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.callback.ISeekBarListener;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.widget.BdPlayerSeekBar;
import com.baidu.searchbox.player.widget.BdThumbSeekBarView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b!\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0014\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0005J\u0019\u0010\u0017\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u0018J'\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0010H\u0004¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\u000f\u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010 ¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/player/element/SeekBarElement;", "Lcom/baidu/searchbox/player/callback/ISeekBarListener;", "Lcom/baidu/searchbox/player/element/AbsElement;", "", "bindSeekBarDuration", "()V", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "initElement", "Lcom/baidu/searchbox/player/event/VideoEvent;", "event", "onEventNotify", "(Lcom/baidu/searchbox/player/event/VideoEvent;)V", "Lcom/baidu/searchbox/player/widget/BdThumbSeekBarView;", "seekBar", "", "progress", "", "fromUser", "onProgressChanged", "(Lcom/baidu/searchbox/player/widget/BdThumbSeekBarView;IZ)V", "onProgressForward", "onStartTrackingTouch", "(Lcom/baidu/searchbox/player/widget/BdThumbSeekBarView;)V", "onStopTrackingTouch", CriusAttrConstants.POSITION, "duration", "buffer", "syncPos", "(III)V", "Lcom/baidu/searchbox/player/widget/BdPlayerSeekBar;", "Lcom/baidu/searchbox/player/widget/BdPlayerSeekBar;", "<init>", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class SeekBarElement extends AbsElement implements ISeekBarListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdPlayerSeekBar seekBar;

    public SeekBarElement() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void bindSeekBarDuration() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BdPlayerSeekBar bdPlayerSeekBar = this.seekBar;
            if (bdPlayerSeekBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("seekBar");
            }
            BDVideoPlayer videoPlayer = getVideoPlayer();
            Intrinsics.checkNotNullExpressionValue(videoPlayer, "videoPlayer");
            bdPlayerSeekBar.setDuration(videoPlayer.getDuration());
        }
    }

    @Override // com.baidu.searchbox.player.element.IElement
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BdPlayerSeekBar bdPlayerSeekBar = this.seekBar;
            if (bdPlayerSeekBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("seekBar");
            }
            return bdPlayerSeekBar;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.element.AbsElement
    public void initElement() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            BdPlayerSeekBar bdPlayerSeekBar = new BdPlayerSeekBar(context, null, 0, 6, null);
            bdPlayerSeekBar.setId(R.id.obfuscated_res_0x7f090361);
            Unit unit = Unit.INSTANCE;
            this.seekBar = bdPlayerSeekBar;
            if (bdPlayerSeekBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("seekBar");
            }
            bdPlayerSeekBar.setSeekBarListener(this);
            int dp2px = BdPlayerUtils.dp2px(bdPlayerSeekBar, 3.0f);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, BdPlayerUtils.dp2px(bdPlayerSeekBar, 35.0f));
            marginLayoutParams.leftMargin = dp2px;
            marginLayoutParams.rightMargin = dp2px;
            Unit unit2 = Unit.INSTANCE;
            bdPlayerSeekBar.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.baidu.searchbox.player.element.AbsElement, com.baidu.searchbox.player.element.IElement
    public void onEventNotify(VideoEvent event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            String action = event.getAction();
            switch (action.hashCode()) {
                case -1530009462:
                    if (action.equals(ControlEvent.ACTION_SYNC_PROGRESS)) {
                        syncPos(event.getIntExtra(1), event.getIntExtra(2), event.getIntExtra(3));
                        return;
                    }
                    return;
                case -552621273:
                    if (action.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        BdPlayerSeekBar bdPlayerSeekBar = this.seekBar;
                        if (bdPlayerSeekBar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("seekBar");
                        }
                        bdPlayerSeekBar.switchToFull();
                        return;
                    }
                    return;
                case -552580917:
                    if (action.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        BdPlayerSeekBar bdPlayerSeekBar2 = this.seekBar;
                        if (bdPlayerSeekBar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("seekBar");
                        }
                        bdPlayerSeekBar2.switchToHalf();
                        return;
                    }
                    return;
                case -525235558:
                    if (action.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                        bindSeekBarDuration();
                        return;
                    }
                    return;
                case 2064424334:
                    if (action.equals(LayerEvent.ACTION_POSITION_SLIDE)) {
                        int intExtra = event.getIntExtra(2);
                        int intExtra2 = event.getIntExtra(3);
                        BdPlayerSeekBar bdPlayerSeekBar3 = this.seekBar;
                        if (bdPlayerSeekBar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("seekBar");
                        }
                        bdPlayerSeekBar3.setPosition(intExtra + intExtra2);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.searchbox.player.callback.ISeekBarListener
    public void onProgressChanged(BdThumbSeekBarView bdThumbSeekBarView, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{bdThumbSeekBarView, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.callback.ISeekBarListener
    public void onProgressForward() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.callback.ISeekBarListener
    public void onStartTrackingTouch(BdThumbSeekBarView bdThumbSeekBarView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdThumbSeekBarView) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.callback.ISeekBarListener
    public void onStopTrackingTouch(BdThumbSeekBarView bdThumbSeekBarView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bdThumbSeekBarView) == null) || bdThumbSeekBarView == null) {
            return;
        }
        BdPlayerSeekBar bdPlayerSeekBar = this.seekBar;
        if (bdPlayerSeekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBar");
        }
        if (!(bdPlayerSeekBar.getVisibility() == 0)) {
            bdThumbSeekBarView = null;
        }
        if (bdThumbSeekBarView != null) {
            VideoEvent obtainEvent = LayerEvent.obtainEvent(LayerEvent.ACTION_SEEK);
            Intrinsics.checkNotNullExpressionValue(obtainEvent, "LayerEvent.obtainEvent(LayerEvent.ACTION_SEEK)");
            obtainEvent.putExtra(1, Integer.valueOf(bdThumbSeekBarView.getProgress()));
            sendEvent(obtainEvent);
        }
    }

    public final void syncPos(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3) == null) {
            BdPlayerSeekBar bdPlayerSeekBar = this.seekBar;
            if (bdPlayerSeekBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("seekBar");
            }
            bdPlayerSeekBar.syncPos(i, i2, i3);
        }
    }
}
