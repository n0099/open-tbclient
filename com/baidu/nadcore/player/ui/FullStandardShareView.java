package com.baidu.nadcore.player.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.h0.q;
import c.a.b0.h0.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.videoplayer.ui.BaseVideoPlayEndUI;
import com.baidu.nadcore.video.videoplayer.widget.ImageTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class FullStandardShareView extends BaseVideoPlayEndUI implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public boolean f37649f;

    /* renamed from: g  reason: collision with root package name */
    public ImageTextView f37650g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullStandardShareView(Context context) {
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
    }

    @Override // com.baidu.nadcore.video.videoplayer.ui.BaseVideoPlayEndUI
    public boolean isShowSharePanel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37649f : invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseVideoPlayEndUI.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || (aVar = this.mOnItemClickListener) == null) {
            return;
        }
        aVar.a(view);
    }

    @Override // com.baidu.nadcore.video.videoplayer.ui.BaseVideoPlayEndUI
    public View onCreateView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            ImageTextView imageTextView = new ImageTextView(context);
            this.f37650g = imageTextView;
            imageTextView.setIconAndTitle(q.nad_videoplayer_new_player_replay_button_selector, t.nad_player_common_replay);
            this.f37650g.setTextColor(q.nad_videoplayer_quick_share_item);
            this.f37650g.setOnClickListener(this);
            return this.f37650g;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.nadcore.video.videoplayer.ui.BaseVideoPlayEndUI
    public void onLightWakeState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setVisibility(4);
        }
    }

    @Override // com.baidu.nadcore.video.videoplayer.ui.BaseVideoPlayEndUI
    public void onPlayBtnVisible(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f37650g.setVisibility(i2);
        }
    }

    @Override // com.baidu.nadcore.video.videoplayer.ui.BaseVideoPlayEndUI
    public void onPlayEndState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setVisibility(0);
        }
    }

    @Override // com.baidu.nadcore.video.videoplayer.ui.BaseVideoPlayEndUI
    public void onPlayingState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setVisibility(4);
        }
    }

    @Override // com.baidu.nadcore.video.videoplayer.ui.BaseVideoPlayEndUI
    public void onStandardWakeState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setVisibility(4);
        }
    }

    @Override // com.baidu.nadcore.video.videoplayer.ui.BaseVideoPlayEndUI
    public void setShowSharePanel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f37649f = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullStandardShareView(Context context, AttributeSet attributeSet) {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullStandardShareView(Context context, AttributeSet attributeSet, int i2) {
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
    }
}
