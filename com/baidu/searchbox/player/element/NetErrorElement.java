package com.baidu.searchbox.player.element;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class NetErrorElement extends AbsElement {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Button mBtnRetry;
    public LinearLayout mRootView;
    public TextView mTextNetError;

    @Override // com.baidu.searchbox.player.element.AbsElement
    public boolean attachToRootAtOnce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.player.element.AbsElement, com.baidu.searchbox.player.element.IElement
    public void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, playerStatus, playerStatus2) == null) {
        }
    }

    public NetErrorElement() {
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

    @Override // com.baidu.searchbox.player.element.IElement
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mRootView;
        }
        return (View) invokeV.objValue;
    }

    private void onSwitchFullStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBtnRetry.getLayoutParams();
            this.mTextNetError.setTextSize(0, getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070192));
            this.mBtnRetry.setTextSize(0, getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070192));
            layoutParams.width = getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07018d);
            layoutParams.height = getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07019e);
            layoutParams.topMargin = getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07019d);
            this.mBtnRetry.setLayoutParams(layoutParams);
        }
    }

    private void onSwitchHalfStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBtnRetry.getLayoutParams();
            this.mTextNetError.setTextSize(0, getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070190));
            this.mBtnRetry.setTextSize(0, getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070190));
            layoutParams.width = getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0701a4);
            layoutParams.height = getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070196);
            layoutParams.topMargin = getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070197);
            this.mBtnRetry.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.searchbox.player.element.AbsElement
    public void initElement() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.mRootView == null) {
                this.mRootView = (LinearLayout) View.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0156, null);
            }
            this.mTextNetError = (TextView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f0923d6);
            Button button = (Button) this.mRootView.findViewById(R.id.obfuscated_res_0x7f09042e);
            this.mBtnRetry = button;
            button.setOnClickListener(this.mParent);
        }
    }

    @Override // com.baidu.searchbox.player.element.AbsElement, com.baidu.searchbox.player.element.IElement
    public void onEventNotify(@NonNull VideoEvent videoEvent) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, videoEvent) == null) {
            String action = videoEvent.getAction();
            int hashCode = action.hashCode();
            if (hashCode != -552621273) {
                if (hashCode == -552580917 && action.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                    c = 1;
                }
                c = 65535;
            } else {
                if (action.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                    c = 0;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c == 1) {
                    onSwitchHalfStyle();
                    return;
                }
                return;
            }
            onSwitchFullStyle();
        }
    }
}
