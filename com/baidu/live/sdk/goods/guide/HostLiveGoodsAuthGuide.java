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
    private View bvU;
    private View bvV;
    private FrameLayout bvW;
    private Button bvX;
    private GradientTextView bvY;
    private LinearLayout bvZ;
    private LinearLayout bwa;
    private ImageView bwb;
    private Runnable mRunnable;

    public HostLiveGoodsAuthGuide(@NonNull Context context) {
        super(context);
        this.mRunnable = new Runnable() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                HostLiveGoodsAuthGuide.this.bvU.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bvZ.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bvU.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bwb.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bvZ.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bvU.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bwb.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bvZ.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bwa.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bvV.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bvX.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bvW.setVisibility(0);
                b.EY().d(HostLiveGoodsAuthGuide.this);
                d.BM().putBoolean("has_show_goods_auth_guide", true);
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
                HostLiveGoodsAuthGuide.this.bvU.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bvZ.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bvU.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bwb.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bvZ.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bvU.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bwb.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bvZ.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bwa.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bvV.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bvX.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bvW.setVisibility(0);
                b.EY().d(HostLiveGoodsAuthGuide.this);
                d.BM().putBoolean("has_show_goods_auth_guide", true);
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
                HostLiveGoodsAuthGuide.this.bvU.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bvZ.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bvU.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bwb.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bvZ.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bvU.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bwb.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bvZ.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bwa.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bvV.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bvX.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bvW.setVisibility(0);
                b.EY().d(HostLiveGoodsAuthGuide.this);
                d.BM().putBoolean("has_show_goods_auth_guide", true);
            }
        };
        init(context);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void ES() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void ET() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void EU() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void EV() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void release() {
        removeCallbacks(this.mRunnable);
    }

    private void init(Context context) {
        View inflate = View.inflate(context, a.g.ala_live_goods_auth_guide, this);
        this.bvW = (FrameLayout) inflate.findViewById(a.f.goodsAuthGuide_layout);
        this.bvX = (Button) inflate.findViewById(a.f.goodsAuthGuideKnown_button);
        this.bvZ = (LinearLayout) inflate.findViewById(a.f.goodsAuthGuideContent_layout);
        this.bvY = (GradientTextView) inflate.findViewById(a.f.goodsAuthGuideTitle_textView);
        this.bwa = (LinearLayout) inflate.findViewById(a.f.goodsAuthGuideShopping_layout);
        this.bwb = (ImageView) inflate.findViewById(a.f.goodsAuthGuideShopping_imageView);
        this.bvX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.EY().e(HostLiveGoodsAuthGuide.this);
            }
        });
    }

    public void c(View view, View view2) {
        this.bvU = view;
        this.bvV = view2;
        view.post(this.mRunnable);
    }
}
