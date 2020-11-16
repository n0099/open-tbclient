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
public class HostLiveGoodsEnterView extends FrameLayout implements a {
    private TextView brQ;
    private View bry;
    private ImageView brz;
    private View rootView;

    public HostLiveGoodsEnterView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public HostLiveGoodsEnterView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public HostLiveGoodsEnterView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void init(Context context) {
        this.rootView = View.inflate(context, a.g.ala_master_live_goods_enter_view, this);
        this.bry = this.rootView.findViewById(a.f.host_goods_layout);
        this.brz = (ImageView) this.rootView.findViewById(a.f.host_goods_imageView);
        this.brQ = (TextView) this.rootView.findViewById(a.f.host_goods_num_textView);
        if (ExtraParamsManager.getABTestSwitcher(ExtraParamsManager.KEY_SHOP_GIFT_ICON_AB, true)) {
            this.brz.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testa);
        } else {
            this.brz.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testb);
        }
    }

    public void setOutClickListener(View.OnClickListener onClickListener) {
        if (this.brz != null) {
            this.brz.setOnClickListener(onClickListener);
        }
    }

    public void Pf() {
        if (this.bry.getVisibility() == 8) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "shopcart_show"));
        }
        this.bry.setVisibility(0);
    }

    public void Pg() {
        this.bry.setVisibility(8);
    }

    public void eZ(int i) {
        if (i <= 0) {
            this.brQ.setVisibility(8);
            this.brQ.setText("");
            return;
        }
        this.brQ.setText(i + "");
        this.brQ.setVisibility(0);
    }

    @Override // com.baidu.live.core.a.a
    public View getRootLayout() {
        return this;
    }

    @Override // com.baidu.live.core.a.a
    public void setTargetView(View view) {
    }
}
