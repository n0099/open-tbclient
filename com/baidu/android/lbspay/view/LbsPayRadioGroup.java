package com.baidu.android.lbspay.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.android.lbspay.channelpay.ChannelPayUtil;
import com.baidu.android.lbspay.network.NewCashierContent;
import com.baidu.android.lbspay.utils.PayMode;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.apollon.utils.ResUtils;
/* loaded from: classes.dex */
public class LbsPayRadioGroup extends LinearLayout {
    public ChannelViewBase checkedView;
    public CheckedViewClickListener checkedViewClickListener;
    public OnCheckedListener mCheckedListener;
    public PayChannelController.GetPayModeListener mGetPayModeListener;

    /* loaded from: classes.dex */
    public class CheckedViewClickListener implements View.OnClickListener {
        public CheckedViewClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LbsPayRadioGroup.this.isEnabled()) {
                LbsPayRadioGroup.this.onChecked((ChannelViewBase) view);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OnCheckedListener {
        void onChecked(ChannelViewBase channelViewBase);
    }

    @SuppressLint({"NewApi"})
    public LbsPayRadioGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.checkedViewClickListener = new CheckedViewClickListener();
        setOrientation(1);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (ChannelViewBase.class.isInstance(view)) {
            view.setOnClickListener(this.checkedViewClickListener);
        }
        super.addView(view, i, layoutParams);
    }

    public void changeChannelDivide() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((childAt instanceof ChannelView) && childAt.getVisibility() == 0) {
                ((ChannelView) childAt).setDividerMargin((int) ResUtils.getDimension(getContext(), "lbspay_cashier_item_marginleft"));
            }
        }
    }

    public NewCashierContent.IBaseChannel getChannel() {
        ChannelViewBase channelViewBase = this.checkedView;
        if (channelViewBase != null) {
            return (NewCashierContent.IBaseChannel) channelViewBase.getTag();
        }
        return null;
    }

    public void onChecked(ChannelViewBase channelViewBase) {
        if (this.checkedView == channelViewBase) {
            return;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
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
        this.mGetPayModeListener = getPayModeListener;
    }

    public void setOnCheckedListener(OnCheckedListener onCheckedListener) {
        this.mCheckedListener = onCheckedListener;
    }

    public void setOncheckedView(ChannelViewBase channelViewBase) {
        this.checkedView = channelViewBase;
    }

    public void showAllChannels() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (ChannelViewBase.class.isInstance(childAt)) {
                childAt.setVisibility(0);
            }
        }
        changeChannelDivide();
    }

    public void updateBaiduPayDesc(NewCashierContent.IBaseChannel iBaseChannel) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (ChannelViewBase.class.isInstance(childAt) && (childAt.getTag() instanceof NewCashierContent.IBaseChannel) && 126 == ((NewCashierContent.IBaseChannel) childAt.getTag()).getChanelId()) {
                ((ChannelViewBase) childAt).setChannel(iBaseChannel);
                childAt.setTag(iBaseChannel);
            }
        }
    }

    public LbsPayRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.checkedViewClickListener = new CheckedViewClickListener();
        setOrientation(1);
    }

    public LbsPayRadioGroup(Context context) {
        super(context);
        this.checkedViewClickListener = new CheckedViewClickListener();
        setOrientation(1);
    }
}
