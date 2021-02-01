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
/* loaded from: classes11.dex */
public class HostLiveGoodsAuthGuide extends LayerChildView {
    private LinearLayout bzA;
    private LinearLayout bzB;
    private ImageView bzC;
    private View bzv;
    private View bzw;
    private FrameLayout bzx;
    private Button bzy;
    private GradientTextView bzz;
    private Runnable mRunnable;

    public HostLiveGoodsAuthGuide(@NonNull Context context) {
        super(context);
        this.mRunnable = new Runnable() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                HostLiveGoodsAuthGuide.this.bzv.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bzA.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bzv.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bzC.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bzA.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bzv.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bzC.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bzA.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bzB.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bzw.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bzy.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bzx.setVisibility(0);
                b.Bc().d(HostLiveGoodsAuthGuide.this);
                d.xc().putBoolean("has_show_goods_auth_guide", true);
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
                HostLiveGoodsAuthGuide.this.bzv.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bzA.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bzv.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bzC.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bzA.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bzv.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bzC.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bzA.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bzB.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bzw.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bzy.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bzx.setVisibility(0);
                b.Bc().d(HostLiveGoodsAuthGuide.this);
                d.xc().putBoolean("has_show_goods_auth_guide", true);
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
                HostLiveGoodsAuthGuide.this.bzv.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bzA.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bzv.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bzC.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bzA.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bzv.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bzC.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bzA.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bzB.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bzw.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bzy.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bzx.setVisibility(0);
                b.Bc().d(HostLiveGoodsAuthGuide.this);
                d.xc().putBoolean("has_show_goods_auth_guide", true);
            }
        };
        init(context);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void AW() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void AX() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void AY() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void AZ() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void release() {
        removeCallbacks(this.mRunnable);
    }

    private void init(Context context) {
        View inflate = View.inflate(context, a.g.ala_live_goods_auth_guide, this);
        this.bzx = (FrameLayout) inflate.findViewById(a.f.goodsAuthGuide_layout);
        this.bzy = (Button) inflate.findViewById(a.f.goodsAuthGuideKnown_button);
        this.bzA = (LinearLayout) inflate.findViewById(a.f.goodsAuthGuideContent_layout);
        this.bzz = (GradientTextView) inflate.findViewById(a.f.goodsAuthGuideTitle_textView);
        this.bzB = (LinearLayout) inflate.findViewById(a.f.goodsAuthGuideShopping_layout);
        this.bzC = (ImageView) inflate.findViewById(a.f.goodsAuthGuideShopping_imageView);
        this.bzy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.Bc().e(HostLiveGoodsAuthGuide.this);
            }
        });
    }

    public void c(View view, View view2) {
        this.bzv = view;
        this.bzw = view2;
        view.post(this.mRunnable);
    }
}
