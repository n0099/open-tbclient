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
/* loaded from: classes4.dex */
public class HostPreLiveGoodsEnterView extends FrameLayout implements a {
    private View bmG;
    private ImageView bmH;
    private TextView bmI;
    private TextView bmJ;
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
        this.bmG = this.rootView.findViewById(a.g.goods_layout);
        this.bmH = (ImageView) this.rootView.findViewById(a.g.goods_imageView);
        this.bmI = (TextView) this.rootView.findViewById(a.g.goods_textView);
        this.bmJ = (TextView) this.rootView.findViewById(a.g.goods_num_textView);
    }

    public void setOutClickListener(View.OnClickListener onClickListener) {
        this.bmH.setOnClickListener(onClickListener);
        this.bmI.setOnClickListener(onClickListener);
        this.bmJ.setOnClickListener(onClickListener);
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
        return this.bmG;
    }

    public ImageView getGoodsImageView() {
        return this.bmH;
    }

    public TextView getGoodsTextView() {
        return this.bmI;
    }

    public TextView getGoodsNumTextView() {
        return this.bmJ;
    }

    public void NL() {
        this.bmG.setVisibility(0);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.LIVE_ACTION, "shopcart_show"));
    }

    public void eS(int i) {
        if (i > 0) {
            this.bmJ.setText(i + "");
            this.bmJ.setVisibility(0);
            return;
        }
        this.bmJ.setVisibility(8);
    }

    public void NM() {
        this.bmG.setVisibility(8);
    }
}
