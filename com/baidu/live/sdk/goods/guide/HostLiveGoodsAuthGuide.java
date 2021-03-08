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
    private View bAV;
    private View bAW;
    private FrameLayout bAX;
    private Button bAY;
    private GradientTextView bAZ;
    private LinearLayout bBa;
    private LinearLayout bBb;
    private ImageView bBc;
    private Runnable mRunnable;

    public HostLiveGoodsAuthGuide(@NonNull Context context) {
        super(context);
        this.mRunnable = new Runnable() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                HostLiveGoodsAuthGuide.this.bAV.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bBa.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bAV.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bBc.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bBa.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bAV.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bBc.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bBa.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bBb.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bAW.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bAY.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bAX.setVisibility(0);
                b.Bf().d(HostLiveGoodsAuthGuide.this);
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
                HostLiveGoodsAuthGuide.this.bAV.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bBa.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bAV.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bBc.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bBa.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bAV.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bBc.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bBa.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bBb.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bAW.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bAY.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bAX.setVisibility(0);
                b.Bf().d(HostLiveGoodsAuthGuide.this);
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
                HostLiveGoodsAuthGuide.this.bAV.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bBa.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bAV.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bBc.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bBa.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bAV.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bBc.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bBa.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bBb.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bAW.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bAY.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bAX.setVisibility(0);
                b.Bf().d(HostLiveGoodsAuthGuide.this);
                d.xf().putBoolean("has_show_goods_auth_guide", true);
            }
        };
        init(context);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void AZ() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ba() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Bb() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Bc() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void release() {
        removeCallbacks(this.mRunnable);
    }

    private void init(Context context) {
        View inflate = View.inflate(context, a.g.ala_live_goods_auth_guide, this);
        this.bAX = (FrameLayout) inflate.findViewById(a.f.goodsAuthGuide_layout);
        this.bAY = (Button) inflate.findViewById(a.f.goodsAuthGuideKnown_button);
        this.bBa = (LinearLayout) inflate.findViewById(a.f.goodsAuthGuideContent_layout);
        this.bAZ = (GradientTextView) inflate.findViewById(a.f.goodsAuthGuideTitle_textView);
        this.bBb = (LinearLayout) inflate.findViewById(a.f.goodsAuthGuideShopping_layout);
        this.bBc = (ImageView) inflate.findViewById(a.f.goodsAuthGuideShopping_imageView);
        this.bAY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.Bf().e(HostLiveGoodsAuthGuide.this);
            }
        });
    }

    public void c(View view, View view2) {
        this.bAV = view;
        this.bAW = view2;
        view.post(this.mRunnable);
    }
}
