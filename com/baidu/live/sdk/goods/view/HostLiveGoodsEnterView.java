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
    private View brQ;
    private ImageView brR;
    private TextView bsh;
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
        this.brQ = this.rootView.findViewById(a.g.host_goods_layout);
        this.brR = (ImageView) this.rootView.findViewById(a.g.host_goods_imageView);
        this.bsh = (TextView) this.rootView.findViewById(a.g.host_goods_num_textView);
    }

    public void setOutClickListener(View.OnClickListener onClickListener) {
        if (this.brR != null) {
            this.brR.setOnClickListener(onClickListener);
        }
    }

    public void Po() {
        if (this.brQ.getVisibility() == 8) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "shopcart_show"));
        }
        this.brQ.setVisibility(0);
    }

    public void Pp() {
        this.brQ.setVisibility(8);
    }

    public void fd(int i) {
        if (i <= 0) {
            this.bsh.setVisibility(8);
            this.bsh.setText("");
            return;
        }
        this.bsh.setText(i + "");
        this.bsh.setVisibility(0);
    }

    @Override // com.baidu.live.core.a.a
    public View getRootLayout() {
        return this;
    }

    @Override // com.baidu.live.core.a.a
    public void setTargetView(View view) {
    }
}
