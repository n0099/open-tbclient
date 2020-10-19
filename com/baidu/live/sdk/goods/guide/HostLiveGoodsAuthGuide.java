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
import com.baidu.live.c;
import com.baidu.live.core.layer.LayerChildView;
import com.baidu.live.core.layer.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.view.GradientTextView;
/* loaded from: classes4.dex */
public class HostLiveGoodsAuthGuide extends LayerChildView {
    private View bpo;
    private View bpp;
    private FrameLayout bpq;
    private Button bpr;
    private GradientTextView bps;
    private LinearLayout bpt;
    private LinearLayout bpu;
    private ImageView bpv;
    private Runnable mRunnable;

    public HostLiveGoodsAuthGuide(@NonNull Context context) {
        super(context);
        this.mRunnable = new Runnable() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                HostLiveGoodsAuthGuide.this.bpo.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bpt.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bpo.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bpv.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bpt.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bpo.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bpv.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bpt.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bpu.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bpp.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bpr.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bpq.setVisibility(0);
                b.Dx().d(HostLiveGoodsAuthGuide.this);
                c.AZ().putBoolean("has_show_goods_auth_guide", true);
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
                HostLiveGoodsAuthGuide.this.bpo.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bpt.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bpo.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bpv.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bpt.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bpo.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bpv.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bpt.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bpu.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bpp.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bpr.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bpq.setVisibility(0);
                b.Dx().d(HostLiveGoodsAuthGuide.this);
                c.AZ().putBoolean("has_show_goods_auth_guide", true);
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
                HostLiveGoodsAuthGuide.this.bpo.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bpt.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bpo.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bpv.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bpt.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bpo.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bpv.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bpt.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bpu.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bpp.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bpr.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bpq.setVisibility(0);
                b.Dx().d(HostLiveGoodsAuthGuide.this);
                c.AZ().putBoolean("has_show_goods_auth_guide", true);
            }
        };
        init(context);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Dr() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ds() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Dt() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Du() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void release() {
        removeCallbacks(this.mRunnable);
    }

    private void init(Context context) {
        View inflate = View.inflate(context, a.h.ala_live_goods_auth_guide, this);
        this.bpq = (FrameLayout) inflate.findViewById(a.g.goodsAuthGuide_layout);
        this.bpr = (Button) inflate.findViewById(a.g.goodsAuthGuideKnown_button);
        this.bpt = (LinearLayout) inflate.findViewById(a.g.goodsAuthGuideContent_layout);
        this.bps = (GradientTextView) inflate.findViewById(a.g.goodsAuthGuideTitle_textView);
        this.bpu = (LinearLayout) inflate.findViewById(a.g.goodsAuthGuideShopping_layout);
        this.bpv = (ImageView) inflate.findViewById(a.g.goodsAuthGuideShopping_imageView);
        this.bpr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.Dx().e(HostLiveGoodsAuthGuide.this);
            }
        });
    }

    public void c(View view, View view2) {
        this.bpo = view;
        this.bpp = view2;
        view.post(this.mRunnable);
    }
}
