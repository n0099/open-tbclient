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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
/* loaded from: classes7.dex */
public class HostPreLiveGoodsEnterView extends FrameLayout implements a {
    private View bjK;
    private ImageView bjL;
    private TextView bjM;
    private TextView bjN;
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
        this.rootView = View.inflate(context, a.h.ala_master_pre_live_goods_enter_view, this);
        this.bjK = this.rootView.findViewById(a.g.goods_layout);
        this.bjL = (ImageView) this.rootView.findViewById(a.g.goods_imageView);
        this.bjM = (TextView) this.rootView.findViewById(a.g.goods_textView);
        this.bjN = (TextView) this.rootView.findViewById(a.g.goods_num_textView);
    }

    public void setOutClickListener(View.OnClickListener onClickListener) {
        this.bjL.setOnClickListener(onClickListener);
        this.bjM.setOnClickListener(onClickListener);
        this.bjN.setOnClickListener(onClickListener);
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
        return this.bjK;
    }

    public ImageView getGoodsImageView() {
        return this.bjL;
    }

    public TextView getGoodsTextView() {
        return this.bjM;
    }

    public TextView getGoodsNumTextView() {
        return this.bjN;
    }

    public void Ni() {
        this.bjK.setVisibility(0);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.LIVE_ACTION, "shopcart_show"));
    }

    public void eH(int i) {
        if (i > 0) {
            this.bjN.setText(i + "");
            this.bjN.setVisibility(0);
            return;
        }
        this.bjN.setVisibility(8);
    }

    public void Nj() {
        this.bjK.setVisibility(8);
    }
}
