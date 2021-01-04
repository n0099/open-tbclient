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
/* loaded from: classes11.dex */
public class HostPreLiveGoodsEnterView extends FrameLayout implements a {
    private View bBM;
    private ImageView bBN;
    private TextView bBO;
    private TextView bBP;
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
        this.bBM = this.rootView.findViewById(a.f.goods_layout);
        this.bBN = (ImageView) this.rootView.findViewById(a.f.goods_imageView);
        this.bBO = (TextView) this.rootView.findViewById(a.f.goods_textView);
        this.bBP = (TextView) this.rootView.findViewById(a.f.goods_num_textView);
        if (ExtraParamsManager.getABTestSwitcher(ExtraParamsManager.KEY_SHOP_GIFT_ICON_AB, true)) {
            this.bBN.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testa);
        } else {
            this.bBN.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testb);
        }
    }

    public void setOutClickListener(View.OnClickListener onClickListener) {
        this.bBN.setOnClickListener(onClickListener);
        this.bBO.setOnClickListener(onClickListener);
        this.bBP.setOnClickListener(onClickListener);
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
        return this.bBM;
    }

    public ImageView getGoodsImageView() {
        return this.bBN;
    }

    public TextView getGoodsTextView() {
        return this.bBO;
    }

    public TextView getGoodsNumTextView() {
        return this.bBP;
    }

    public void SC() {
        this.bBM.setVisibility(0);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.LIVE_ACTION, "shopcart_show"));
    }

    public void fy(int i) {
        if (i > 0) {
            this.bBP.setText(i + "");
            this.bBP.setVisibility(0);
            return;
        }
        this.bBP.setVisibility(8);
    }

    public void SD() {
        this.bBM.setVisibility(8);
    }
}
