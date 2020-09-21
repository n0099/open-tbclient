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
    private View blB;
    private View blC;
    private FrameLayout blD;
    private Button blE;
    private GradientTextView blF;
    private LinearLayout blG;
    private LinearLayout blH;
    private ImageView blI;
    private Runnable mRunnable;

    public HostLiveGoodsAuthGuide(@NonNull Context context) {
        super(context);
        this.mRunnable = new Runnable() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                HostLiveGoodsAuthGuide.this.blB.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.blG.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.blB.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.blI.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.blG.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.blB.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.blI.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.blG.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.blH.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.blC.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.blE.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.blD.setVisibility(0);
                b.CA().d(HostLiveGoodsAuthGuide.this);
                c.AR().putBoolean("has_show_goods_auth_guide", true);
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
                HostLiveGoodsAuthGuide.this.blB.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.blG.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.blB.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.blI.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.blG.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.blB.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.blI.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.blG.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.blH.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.blC.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.blE.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.blD.setVisibility(0);
                b.CA().d(HostLiveGoodsAuthGuide.this);
                c.AR().putBoolean("has_show_goods_auth_guide", true);
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
                HostLiveGoodsAuthGuide.this.blB.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.blG.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.blB.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.blI.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.blG.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.blB.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.blI.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.blG.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.blH.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.blC.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.blE.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.blD.setVisibility(0);
                b.CA().d(HostLiveGoodsAuthGuide.this);
                c.AR().putBoolean("has_show_goods_auth_guide", true);
            }
        };
        init(context);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Cu() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Cv() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Cw() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Cx() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void release() {
        removeCallbacks(this.mRunnable);
    }

    private void init(Context context) {
        View inflate = View.inflate(context, a.h.ala_live_goods_auth_guide, this);
        this.blD = (FrameLayout) inflate.findViewById(a.g.goodsAuthGuide_layout);
        this.blE = (Button) inflate.findViewById(a.g.goodsAuthGuideKnown_button);
        this.blG = (LinearLayout) inflate.findViewById(a.g.goodsAuthGuideContent_layout);
        this.blF = (GradientTextView) inflate.findViewById(a.g.goodsAuthGuideTitle_textView);
        this.blH = (LinearLayout) inflate.findViewById(a.g.goodsAuthGuideShopping_layout);
        this.blI = (ImageView) inflate.findViewById(a.g.goodsAuthGuideShopping_imageView);
        this.blE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.CA().e(HostLiveGoodsAuthGuide.this);
            }
        });
    }

    public void c(View view, View view2) {
        this.blB = view;
        this.blC = view2;
        view.post(this.mRunnable);
    }
}
