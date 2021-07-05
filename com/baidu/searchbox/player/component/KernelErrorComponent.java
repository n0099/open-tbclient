package com.baidu.searchbox.player.component;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.videoplayer.framework.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class KernelErrorComponent extends AbsComponent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout mRootView;
    public TextView mTextNetError;

    public KernelErrorComponent() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void onSwitchFullStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            Drawable[] compoundDrawables = this.mTextNetError.getCompoundDrawables();
            this.mTextNetError.setTextSize(0, getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_dimens_14dp));
            compoundDrawables[1].setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_dimens_47dp), getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_dimens_47dp));
            this.mTextNetError.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }
    }

    private void onSwitchHalfStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            Drawable[] compoundDrawables = this.mTextNetError.getCompoundDrawables();
            this.mTextNetError.setTextSize(0, getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_dimens_12dp));
            compoundDrawables[1].setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_dimens_42dp), getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_dimens_42dp));
            this.mTextNetError.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }
    }

    @Override // com.baidu.searchbox.player.component.AbsComponent
    public boolean attachToRootAtOnce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.player.component.IComponent
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mRootView : (View) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.component.AbsComponent
    public void initComponent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LinearLayout linearLayout = (LinearLayout) View.inflate(getContext(), R.layout.videoplayer_layout_kernel_error, null);
            this.mRootView = linearLayout;
            TextView textView = (TextView) linearLayout.findViewById(R.id.play_error_layout_retry);
            this.mTextNetError = textView;
            textView.setOnClickListener(this.mParent);
        }
    }

    @Override // com.baidu.searchbox.player.component.AbsComponent, com.baidu.searchbox.player.component.IComponent
    public void onEventNotify(@NonNull VideoEvent videoEvent) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, videoEvent) == null) {
            String action = videoEvent.getAction();
            int hashCode = action.hashCode();
            if (hashCode != -552621273) {
                if (hashCode == -552580917 && action.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                    c2 = 1;
                }
                c2 = 65535;
            } else {
                if (action.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                    c2 = 0;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                onSwitchFullStyle();
            } else if (c2 != 1) {
            } else {
                onSwitchHalfStyle();
            }
        }
    }

    @Override // com.baidu.searchbox.player.component.AbsComponent, com.baidu.searchbox.player.component.IComponent
    public void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, playerStatus, playerStatus2) == null) {
        }
    }
}
