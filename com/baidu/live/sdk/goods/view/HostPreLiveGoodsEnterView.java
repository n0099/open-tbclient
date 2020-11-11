package com.baidu.live.sdk.goods.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.core.a.a;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
/* loaded from: classes4.dex */
public class HostPreLiveGoodsEnterView extends FrameLayout implements a {
    private View btD;
    private ImageView btE;
    private TextView btF;
    private TextView btG;
    private View mTargetView;
    private View rootView;

    public HostPreLiveGoodsEnterView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public HostPreLiveGoodsEnterView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public HostPreLiveGoodsEnterView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.rootView = View.inflate(context, a.g.ala_master_pre_live_goods_enter_view, this);
        this.btD = this.rootView.findViewById(a.f.goods_layout);
        this.btE = (ImageView) this.rootView.findViewById(a.f.goods_imageView);
        this.btF = (TextView) this.rootView.findViewById(a.f.goods_textView);
        this.btG = (TextView) this.rootView.findViewById(a.f.goods_num_textView);
        if (ExtraParamsManager.getABTestSwitcher(ExtraParamsManager.KEY_SHOP_GIFT_ICON_AB, true)) {
            this.btE.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testa);
        } else {
            this.btE.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testb);
        }
    }

    public void setOutClickListener(View.OnClickListener onClickListener) {
        this.btE.setOnClickListener(onClickListener);
        this.btF.setOnClickListener(onClickListener);
        this.btG.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.live.core.a.a
    public View getRootLayout() {
        return this;
    }

    @Override // com.baidu.live.core.a.a
    public void setTargetView(View view) {
        this.mTargetView = view;
    }

    public View getTargetView() {
        return this.mTargetView;
    }

    public View getGoodsLayout() {
        return this.btD;
    }

    public ImageView getGoodsImageView() {
        return this.btE;
    }

    public TextView getGoodsTextView() {
        return this.btF;
    }

    public TextView getGoodsNumTextView() {
        return this.btG;
    }

    public void PO() {
        this.btD.setVisibility(0);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.LIVE_ACTION, "shopcart_show"));
    }

    public void fd(int i) {
        if (i > 0) {
            this.btG.setText(i + "");
            this.btG.setVisibility(0);
            return;
        }
        this.btG.setVisibility(8);
    }

    public void PP() {
        this.btD.setVisibility(8);
    }
}
