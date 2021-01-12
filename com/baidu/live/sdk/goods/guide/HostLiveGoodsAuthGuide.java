package com.baidu.live.sdk.goods.guide;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.core.layer.LayerChildView;
import com.baidu.live.core.layer.b;
import com.baidu.live.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.view.GradientTextView;
/* loaded from: classes10.dex */
public class HostLiveGoodsAuthGuide extends LayerChildView {
    private View bvT;
    private View bvU;
    private FrameLayout bvV;
    private Button bvW;
    private GradientTextView bvX;
    private LinearLayout bvY;
    private LinearLayout bvZ;
    private ImageView bwa;
    private Runnable mRunnable;

    public HostLiveGoodsAuthGuide(@NonNull Context context) {
        super(context);
        this.mRunnable = new Runnable() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                HostLiveGoodsAuthGuide.this.bvT.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bvY.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bvT.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bwa.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bvY.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bvT.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bwa.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bvY.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bvZ.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bvU.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bvW.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bvV.setVisibility(0);
                b.As().d(HostLiveGoodsAuthGuide.this);
                d.xf().putBoolean("has_show_goods_auth_guide", true);
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
                HostLiveGoodsAuthGuide.this.bvT.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bvY.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bvT.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bwa.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bvY.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bvT.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bwa.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bvY.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bvZ.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bvU.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bvW.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bvV.setVisibility(0);
                b.As().d(HostLiveGoodsAuthGuide.this);
                d.xf().putBoolean("has_show_goods_auth_guide", true);
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
                HostLiveGoodsAuthGuide.this.bvT.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bvY.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bvT.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bwa.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bvY.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bvT.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bwa.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bvY.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bvZ.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bvU.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bvW.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bvV.setVisibility(0);
                b.As().d(HostLiveGoodsAuthGuide.this);
                d.xf().putBoolean("has_show_goods_auth_guide", true);
            }
        };
        init(context);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Am() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void An() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ao() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ap() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void release() {
        removeCallbacks(this.mRunnable);
    }

    private void init(Context context) {
        View inflate = View.inflate(context, a.g.ala_live_goods_auth_guide, this);
        this.bvV = (FrameLayout) inflate.findViewById(a.f.goodsAuthGuide_layout);
        this.bvW = (Button) inflate.findViewById(a.f.goodsAuthGuideKnown_button);
        this.bvY = (LinearLayout) inflate.findViewById(a.f.goodsAuthGuideContent_layout);
        this.bvX = (GradientTextView) inflate.findViewById(a.f.goodsAuthGuideTitle_textView);
        this.bvZ = (LinearLayout) inflate.findViewById(a.f.goodsAuthGuideShopping_layout);
        this.bwa = (ImageView) inflate.findViewById(a.f.goodsAuthGuideShopping_imageView);
        this.bvW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.As().e(HostLiveGoodsAuthGuide.this);
            }
        });
    }

    public void c(View view, View view2) {
        this.bvT = view;
        this.bvU = view2;
        view.post(this.mRunnable);
    }
}
