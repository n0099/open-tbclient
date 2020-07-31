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
public class HostLiveGoodsEnterView extends FrameLayout implements a {
    private View bdQ;
    private ImageView bdR;
    private TextView bei;
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
        this.bdQ = this.rootView.findViewById(a.g.host_goods_layout);
        this.bdR = (ImageView) this.rootView.findViewById(a.g.host_goods_imageView);
        this.bei = (TextView) this.rootView.findViewById(a.g.host_goods_num_textView);
    }

    public void setOutClickListener(View.OnClickListener onClickListener) {
        if (this.bdR != null) {
            this.bdR.setOnClickListener(onClickListener);
        }
    }

    public void Hq() {
        if (this.bdQ.getVisibility() == 8) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "shopcart_show"));
        }
        this.bdQ.setVisibility(0);
    }

    public void Hr() {
        this.bdQ.setVisibility(8);
    }

    public void cO(int i) {
        if (i <= 0) {
            this.bei.setVisibility(8);
            this.bei.setText("");
            return;
        }
        this.bei.setText(i + "");
        this.bei.setVisibility(0);
    }

    @Override // com.baidu.live.core.a.a
    public View getRootLayout() {
        return this;
    }

    @Override // com.baidu.live.core.a.a
    public void setTargetView(View view) {
    }
}
