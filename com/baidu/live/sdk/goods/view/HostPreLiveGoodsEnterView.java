package com.baidu.live.sdk.goods.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.core.a.a;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
/* loaded from: classes10.dex */
public class HostPreLiveGoodsEnterView extends FrameLayout implements a {
    private View bxa;
    private ImageView bxb;
    private TextView bxc;
    private TextView bxd;
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
        this.bxa = this.rootView.findViewById(a.f.goods_layout);
        this.bxb = (ImageView) this.rootView.findViewById(a.f.goods_imageView);
        this.bxc = (TextView) this.rootView.findViewById(a.f.goods_textView);
        this.bxd = (TextView) this.rootView.findViewById(a.f.goods_num_textView);
        if (ExtraParamsManager.getABTestSwitcher(ExtraParamsManager.KEY_SHOP_GIFT_ICON_AB, true)) {
            this.bxb.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testa);
        } else {
            this.bxb.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testb);
        }
    }

    public void setOutClickListener(View.OnClickListener onClickListener) {
        this.bxb.setOnClickListener(onClickListener);
        this.bxc.setOnClickListener(onClickListener);
        this.bxd.setOnClickListener(onClickListener);
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
        return this.bxa;
    }

    public ImageView getGoodsImageView() {
        return this.bxb;
    }

    public TextView getGoodsTextView() {
        return this.bxc;
    }

    public TextView getGoodsNumTextView() {
        return this.bxd;
    }

    public void OH() {
        this.bxa.setVisibility(0);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.LIVE_ACTION, "shopcart_show"));
    }

    public void dS(int i) {
        if (i > 0) {
            this.bxd.setText(i + "");
            this.bxd.setVisibility(0);
            return;
        }
        this.bxd.setVisibility(8);
    }

    public void OI() {
        this.bxa.setVisibility(8);
    }
}
