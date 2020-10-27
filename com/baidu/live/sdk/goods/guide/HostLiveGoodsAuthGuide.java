package com.baidu.live.sdk.goods.guide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.live.core.layer.LayerChildView;
import com.baidu.live.core.layer.b;
import com.baidu.live.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.view.GradientTextView;
/* loaded from: classes4.dex */
public class HostLiveGoodsAuthGuide extends LayerChildView {
    private View brb;
    private View brc;
    private FrameLayout brd;
    private Button bre;
    private GradientTextView brf;
    private LinearLayout brg;
    private LinearLayout brh;
    private ImageView bri;
    private Runnable mRunnable;

    public HostLiveGoodsAuthGuide(@NonNull Context context) {
        super(context);
        this.mRunnable = new Runnable() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                HostLiveGoodsAuthGuide.this.brb.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.brg.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.brb.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bri.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.brg.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.brb.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bri.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.brg.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.brh.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.brc.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bre.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.brd.setVisibility(0);
                b.DE().d(HostLiveGoodsAuthGuide.this);
                d.AZ().putBoolean("has_show_goods_auth_guide", true);
            }
        };
        init(context);
    }

    public HostLiveGoodsAuthGuide(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRunnable = new Runnable() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                HostLiveGoodsAuthGuide.this.brb.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.brg.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.brb.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bri.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.brg.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.brb.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bri.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.brg.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.brh.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.brc.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bre.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.brd.setVisibility(0);
                b.DE().d(HostLiveGoodsAuthGuide.this);
                d.AZ().putBoolean("has_show_goods_auth_guide", true);
            }
        };
        init(context);
    }

    public HostLiveGoodsAuthGuide(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRunnable = new Runnable() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                HostLiveGoodsAuthGuide.this.brb.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.brg.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.brb.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bri.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.brg.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.brb.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bri.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.brg.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.brh.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.brc.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bre.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.brd.setVisibility(0);
                b.DE().d(HostLiveGoodsAuthGuide.this);
                d.AZ().putBoolean("has_show_goods_auth_guide", true);
            }
        };
        init(context);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Dy() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Dz() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void DA() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void DB() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void release() {
        removeCallbacks(this.mRunnable);
    }

    private void init(Context context) {
        View inflate = View.inflate(context, a.h.ala_live_goods_auth_guide, this);
        this.brd = (FrameLayout) inflate.findViewById(a.g.goodsAuthGuide_layout);
        this.bre = (Button) inflate.findViewById(a.g.goodsAuthGuideKnown_button);
        this.brg = (LinearLayout) inflate.findViewById(a.g.goodsAuthGuideContent_layout);
        this.brf = (GradientTextView) inflate.findViewById(a.g.goodsAuthGuideTitle_textView);
        this.brh = (LinearLayout) inflate.findViewById(a.g.goodsAuthGuideShopping_layout);
        this.bri = (ImageView) inflate.findViewById(a.g.goodsAuthGuideShopping_imageView);
        this.bre.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.DE().e(HostLiveGoodsAuthGuide.this);
            }
        });
    }

    public void c(View view, View view2) {
        this.brb = view;
        this.brc = view2;
        view.post(this.mRunnable);
    }
}
