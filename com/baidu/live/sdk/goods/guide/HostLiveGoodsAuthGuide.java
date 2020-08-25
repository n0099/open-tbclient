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
/* loaded from: classes7.dex */
public class HostLiveGoodsAuthGuide extends LayerChildView {
    private View biE;
    private View biF;
    private FrameLayout biG;
    private Button biH;
    private GradientTextView biI;
    private LinearLayout biJ;
    private LinearLayout biK;
    private ImageView biL;
    private Runnable mRunnable;

    public HostLiveGoodsAuthGuide(@NonNull Context context) {
        super(context);
        this.mRunnable = new Runnable() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                HostLiveGoodsAuthGuide.this.biE.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.biJ.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.biE.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.biL.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.biJ.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.biE.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.biL.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.biJ.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.biK.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.biF.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.biH.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.biG.setVisibility(0);
                b.Cl().d(HostLiveGoodsAuthGuide.this);
                c.AD().putBoolean("has_show_goods_auth_guide", true);
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
                HostLiveGoodsAuthGuide.this.biE.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.biJ.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.biE.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.biL.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.biJ.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.biE.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.biL.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.biJ.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.biK.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.biF.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.biH.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.biG.setVisibility(0);
                b.Cl().d(HostLiveGoodsAuthGuide.this);
                c.AD().putBoolean("has_show_goods_auth_guide", true);
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
                HostLiveGoodsAuthGuide.this.biE.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.biJ.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.biE.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.biL.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.biJ.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.biE.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.biL.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.biJ.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.biK.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.biF.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.biH.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.biG.setVisibility(0);
                b.Cl().d(HostLiveGoodsAuthGuide.this);
                c.AD().putBoolean("has_show_goods_auth_guide", true);
            }
        };
        init(context);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Cf() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Cg() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ch() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ci() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void release() {
        removeCallbacks(this.mRunnable);
    }

    private void init(Context context) {
        View inflate = View.inflate(context, a.h.ala_live_goods_auth_guide, this);
        this.biG = (FrameLayout) inflate.findViewById(a.g.goodsAuthGuide_layout);
        this.biH = (Button) inflate.findViewById(a.g.goodsAuthGuideKnown_button);
        this.biJ = (LinearLayout) inflate.findViewById(a.g.goodsAuthGuideContent_layout);
        this.biI = (GradientTextView) inflate.findViewById(a.g.goodsAuthGuideTitle_textView);
        this.biK = (LinearLayout) inflate.findViewById(a.g.goodsAuthGuideShopping_layout);
        this.biL = (ImageView) inflate.findViewById(a.g.goodsAuthGuideShopping_imageView);
        this.biH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.Cl().e(HostLiveGoodsAuthGuide.this);
            }
        });
    }

    public void c(View view, View view2) {
        this.biE = view;
        this.biF = view2;
        view.post(this.mRunnable);
    }
}
