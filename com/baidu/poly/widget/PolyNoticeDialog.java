package com.baidu.poly.widget;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.g0.c;
import c.a.g0.g;
import c.a.g0.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class PolyNoticeDialog extends BaseDialogFragment implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout layoutActionOfBtn;
    public TextView leftActionBtn;
    public a optionOnClickListener;
    public TextView rightActionBtn;
    public TextView singleBtn;
    public ImageView tipsImageView;
    public TextView tipsTv;
    public TextView titleTv;

    /* loaded from: classes10.dex */
    public interface a {
        void a();

        void onDismiss();

        void onOptionClick(int i2);
    }

    public PolyNoticeDialog() {
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

    @Override // com.baidu.poly.widget.BaseDialogFragment
    public int getLayoutResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? h.poly_notice_dialog_window : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || (aVar = this.optionOnClickListener) == null) {
            return;
        }
        aVar.onOptionClick(view.getId());
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) {
            super.onDismiss(dialogInterface);
            a aVar = this.optionOnClickListener;
            if (aVar != null) {
                aVar.onDismiss();
            }
        }
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            this.titleTv = (TextView) view.findViewById(g.poly_notice_dialog_title);
            this.tipsTv = (TextView) view.findViewById(g.poly_notice_dialog_tips);
            this.tipsImageView = (ImageView) view.findViewById(g.poly_notice_dialog_progress_view);
            this.singleBtn = (TextView) view.findViewById(g.poly_notice_dialog_single_btn);
            this.layoutActionOfBtn = (LinearLayout) view.findViewById(g.poly_layout_action_of_btn);
            this.leftActionBtn = (TextView) view.findViewById(g.poly_notice_dialog_left_action_btn);
            this.rightActionBtn = (TextView) view.findViewById(g.poly_notice_dialog_right_action_btn);
            this.singleBtn.setOnClickListener(this);
            this.leftActionBtn.setOnClickListener(this);
            this.rightActionBtn.setOnClickListener(this);
            a aVar = this.optionOnClickListener;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void setActionLayoutBtnText(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.singleBtn.setVisibility(8);
            this.layoutActionOfBtn.setVisibility(0);
            this.leftActionBtn.setText(str);
            this.rightActionBtn.setText(str2);
        }
    }

    public void setOptionOnClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.optionOnClickListener = aVar;
        }
    }

    public void setRightBtnEnable(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (textView = this.rightActionBtn) == null) {
            return;
        }
        textView.setEnabled(z);
    }

    public void setSingleBtnText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.singleBtn.setVisibility(0);
            this.singleBtn.setText(str);
            this.layoutActionOfBtn.setVisibility(8);
        }
    }

    public void setTips(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || (textView = this.tipsTv) == null) {
            return;
        }
        textView.setText(str);
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.titleTv.setText(str);
        }
    }

    public void startLoadingAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.tipsImageView.setVisibility(0);
            this.tipsImageView.startAnimation(AnimationUtils.loadAnimation(this.tipsImageView.getContext(), c.loading_rotate));
        }
    }

    public void stopLoadingAnim() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (imageView = this.tipsImageView) == null) {
            return;
        }
        imageView.clearAnimation();
        this.tipsImageView.setVisibility(8);
    }
}
