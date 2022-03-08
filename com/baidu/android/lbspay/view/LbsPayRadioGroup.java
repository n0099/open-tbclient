package com.baidu.android.lbspay.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.channelpay.ChannelPayUtil;
import com.baidu.android.lbspay.network.NewCashierContent;
import com.baidu.android.lbspay.utils.PayMode;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
/* loaded from: classes3.dex */
public class LbsPayRadioGroup extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ChannelViewBase checkedView;
    public CheckedViewClickListener checkedViewClickListener;
    public OnCheckedListener mCheckedListener;
    public PayChannelController.GetPayModeListener mGetPayModeListener;

    /* loaded from: classes3.dex */
    public class CheckedViewClickListener implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LbsPayRadioGroup this$0;

        public CheckedViewClickListener(LbsPayRadioGroup lbsPayRadioGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lbsPayRadioGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = lbsPayRadioGroup;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.this$0.isEnabled()) {
                this.this$0.onChecked((ChannelViewBase) view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface OnCheckedListener {
        void onChecked(ChannelViewBase channelViewBase);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"NewApi"})
    public LbsPayRadioGroup(Context context, AttributeSet attributeSet, int i2) {
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
        this.checkedViewClickListener = new CheckedViewClickListener(this);
        setOrientation(1);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, view, i2, layoutParams) == null) {
            if (ChannelViewBase.class.isInstance(view)) {
                view.setOnClickListener(this.checkedViewClickListener);
            }
            super.addView(view, i2, layoutParams);
        }
    }

    public void changeChannelDivide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if ((childAt instanceof ChannelView) && childAt.getVisibility() == 0) {
                    ((ChannelView) childAt).setDividerMargin((int) ResUtils.getDimension(getContext(), "lbspay_cashier_item_marginleft"));
                }
            }
        }
    }

    public NewCashierContent.IBaseChannel getChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ChannelViewBase channelViewBase = this.checkedView;
            if (channelViewBase != null) {
                return (NewCashierContent.IBaseChannel) channelViewBase.getTag();
            }
            return null;
        }
        return (NewCashierContent.IBaseChannel) invokeV.objValue;
    }

    public void onChecked(ChannelViewBase channelViewBase) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, channelViewBase) == null) || this.checkedView == channelViewBase) {
            return;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (ChannelViewBase.class.isInstance(childAt)) {
                if (channelViewBase == childAt) {
                    this.checkedView = channelViewBase;
                    ((ChannelViewBase) childAt).setChecked(true);
                    OnCheckedListener onCheckedListener = this.mCheckedListener;
                    if (onCheckedListener != null) {
                        onCheckedListener.onChecked(channelViewBase);
                    }
                    if (this.mGetPayModeListener != null) {
                        if (channelViewBase.getTag() instanceof NewCashierContent.IBaseChannel) {
                            this.mGetPayModeListener.getSelectPayMode(ChannelPayUtil.getPayMode(((NewCashierContent.IBaseChannel) channelViewBase.getTag()).getChanelId()));
                        } else {
                            this.mGetPayModeListener.getSelectPayMode(PayMode.unknownPay);
                        }
                    }
                } else {
                    ((ChannelViewBase) childAt).setChecked(false);
                }
            }
        }
    }

    public void setGetPayModeListener(PayChannelController.GetPayModeListener getPayModeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, getPayModeListener) == null) {
            this.mGetPayModeListener = getPayModeListener;
        }
    }

    public void setOnCheckedListener(OnCheckedListener onCheckedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onCheckedListener) == null) {
            this.mCheckedListener = onCheckedListener;
        }
    }

    public void setOncheckedView(ChannelViewBase channelViewBase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, channelViewBase) == null) {
            this.checkedView = channelViewBase;
        }
    }

    public void showAllChannels() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (ChannelViewBase.class.isInstance(childAt)) {
                    childAt.setVisibility(0);
                }
            }
            changeChannelDivide();
        }
    }

    public void updateBaiduPayDesc(NewCashierContent.IBaseChannel iBaseChannel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iBaseChannel) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (ChannelViewBase.class.isInstance(childAt) && (childAt.getTag() instanceof NewCashierContent.IBaseChannel) && 126 == ((NewCashierContent.IBaseChannel) childAt.getTag()).getChanelId()) {
                    ((ChannelViewBase) childAt).setChannel(iBaseChannel);
                    childAt.setTag(iBaseChannel);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LbsPayRadioGroup(Context context, AttributeSet attributeSet) {
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
        this.checkedViewClickListener = new CheckedViewClickListener(this);
        setOrientation(1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LbsPayRadioGroup(Context context) {
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
        this.checkedViewClickListener = new CheckedViewClickListener(this);
        setOrientation(1);
    }
}
