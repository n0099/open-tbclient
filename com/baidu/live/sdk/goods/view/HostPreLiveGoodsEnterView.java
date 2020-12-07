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
    private View bxb;
    private ImageView bxc;
    private TextView bxd;
    private TextView bxe;
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
        this.bxb = this.rootView.findViewById(a.f.goods_layout);
        this.bxc = (ImageView) this.rootView.findViewById(a.f.goods_imageView);
        this.bxd = (TextView) this.rootView.findViewById(a.f.goods_textView);
        this.bxe = (TextView) this.rootView.findViewById(a.f.goods_num_textView);
        if (ExtraParamsManager.getABTestSwitcher(ExtraParamsManager.KEY_SHOP_GIFT_ICON_AB, true)) {
            this.bxc.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testa);
        } else {
            this.bxc.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testb);
        }
    }

    public void setOutClickListener(View.OnClickListener onClickListener) {
        this.bxc.setOnClickListener(onClickListener);
        this.bxd.setOnClickListener(onClickListener);
        this.bxe.setOnClickListener(onClickListener);
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
        return this.bxb;
    }

    public ImageView getGoodsImageView() {
        return this.bxc;
    }

    public TextView getGoodsTextView() {
        return this.bxd;
    }

    public TextView getGoodsNumTextView() {
        return this.bxe;
    }

    public void Rz() {
        this.bxb.setVisibility(0);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.LIVE_ACTION, "shopcart_show"));
    }

    public void fx(int i) {
        if (i > 0) {
            this.bxe.setText(i + "");
            this.bxe.setVisibility(0);
            return;
        }
        this.bxe.setVisibility(8);
    }

    public void RA() {
        this.bxb.setVisibility(8);
    }
}
