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
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
/* loaded from: classes10.dex */
public class HostLiveGoodsEnterView extends FrameLayout implements a {
    private View bwH;
    private ImageView bwI;
    private TextView bwZ;
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
        this.bwH = this.rootView.findViewById(a.f.host_goods_layout);
        this.bwI = (ImageView) this.rootView.findViewById(a.f.host_goods_imageView);
        this.bwZ = (TextView) this.rootView.findViewById(a.f.host_goods_num_textView);
        if (ExtraParamsManager.getABTestSwitcher(ExtraParamsManager.KEY_SHOP_GIFT_ICON_AB, true)) {
            this.bwI.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testa);
        } else {
            this.bwI.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testb);
        }
    }

    public void setOutClickListener(View.OnClickListener onClickListener) {
        if (this.bwI != null) {
            this.bwI.setOnClickListener(onClickListener);
        }
    }

    public void OH() {
        if (this.bwH.getVisibility() == 8) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "author_liveroom", "shopcart_show"));
        }
        this.bwH.setVisibility(0);
    }

    public void OI() {
        this.bwH.setVisibility(8);
    }

    public void dS(int i) {
        if (i <= 0) {
            this.bwZ.setVisibility(8);
            this.bwZ.setText("");
            return;
        }
        this.bwZ.setText(i + "");
        this.bwZ.setVisibility(0);
    }

    @Override // com.baidu.live.core.a.a
    public View getRootLayout() {
        return this;
    }

    @Override // com.baidu.live.core.a.a
    public void setTargetView(View view) {
    }
}
