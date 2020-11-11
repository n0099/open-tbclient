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
    private LinearLayout bsA;
    private ImageView bsB;
    private View bsu;
    private View bsv;
    private FrameLayout bsw;
    private Button bsx;
    private GradientTextView bsy;
    private LinearLayout bsz;
    private Runnable mRunnable;

    public HostLiveGoodsAuthGuide(@NonNull Context context) {
        super(context);
        this.mRunnable = new Runnable() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                HostLiveGoodsAuthGuide.this.bsu.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bsz.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bsu.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bsB.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bsz.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bsu.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bsB.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bsz.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bsA.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bsv.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bsx.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bsw.setVisibility(0);
                b.DX().d(HostLiveGoodsAuthGuide.this);
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
                HostLiveGoodsAuthGuide.this.bsu.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bsz.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bsu.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bsB.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bsz.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bsu.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bsB.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bsz.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bsA.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bsv.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bsx.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bsw.setVisibility(0);
                b.DX().d(HostLiveGoodsAuthGuide.this);
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
                HostLiveGoodsAuthGuide.this.bsu.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bsz.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bsu.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bsB.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bsz.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bsu.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bsB.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bsz.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bsA.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bsv.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bsx.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bsw.setVisibility(0);
                b.DX().d(HostLiveGoodsAuthGuide.this);
                d.AZ().putBoolean("has_show_goods_auth_guide", true);
            }
        };
        init(context);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void DR() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void DS() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void DT() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void DU() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void release() {
        removeCallbacks(this.mRunnable);
    }

    private void init(Context context) {
        View inflate = View.inflate(context, a.g.ala_live_goods_auth_guide, this);
        this.bsw = (FrameLayout) inflate.findViewById(a.f.goodsAuthGuide_layout);
        this.bsx = (Button) inflate.findViewById(a.f.goodsAuthGuideKnown_button);
        this.bsz = (LinearLayout) inflate.findViewById(a.f.goodsAuthGuideContent_layout);
        this.bsy = (GradientTextView) inflate.findViewById(a.f.goodsAuthGuideTitle_textView);
        this.bsA = (LinearLayout) inflate.findViewById(a.f.goodsAuthGuideShopping_layout);
        this.bsB = (ImageView) inflate.findViewById(a.f.goodsAuthGuideShopping_imageView);
        this.bsx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.DX().e(HostLiveGoodsAuthGuide.this);
            }
        });
    }

    public void c(View view, View view2) {
        this.bsu = view;
        this.bsv = view2;
        view.post(this.mRunnable);
    }
}
