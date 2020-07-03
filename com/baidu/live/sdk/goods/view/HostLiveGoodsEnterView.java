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
/* loaded from: classes3.dex */
public class HostLiveGoodsEnterView extends FrameLayout implements a {
    private TextView bdP;
    private View bdy;
    private ImageView bdz;
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
        this.rootView = View.inflate(context, a.h.ala_master_live_goods_enter_view, this);
        this.bdy = this.rootView.findViewById(a.g.host_goods_layout);
        this.bdz = (ImageView) this.rootView.findViewById(a.g.host_goods_imageView);
        this.bdP = (TextView) this.rootView.findViewById(a.g.host_goods_num_textView);
    }

    public void setOutClickListener(View.OnClickListener onClickListener) {
        if (this.bdz != null) {
            this.bdz.setOnClickListener(onClickListener);
        }
    }

    public void Hk() {
        if (this.bdy.getVisibility() == 8) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "shopcart_show"));
        }
        this.bdy.setVisibility(0);
    }

    public void Hl() {
        this.bdy.setVisibility(8);
    }

    public void cN(int i) {
        if (i <= 0) {
            this.bdP.setVisibility(8);
            this.bdP.setText("");
            return;
        }
        this.bdP.setText(i + "");
        this.bdP.setVisibility(0);
    }

    @Override // com.baidu.live.core.a.a
    public View getRootLayout() {
        return this;
    }

    @Override // com.baidu.live.core.a.a
    public void setTargetView(View view) {
    }
}
