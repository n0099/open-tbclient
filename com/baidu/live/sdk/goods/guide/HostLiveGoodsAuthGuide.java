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
    private View biH;
    private View biI;
    private FrameLayout biJ;
    private Button biK;
    private GradientTextView biL;
    private LinearLayout biM;
    private LinearLayout biN;
    private ImageView biO;
    private Runnable mRunnable;

    public HostLiveGoodsAuthGuide(@NonNull Context context) {
        super(context);
        this.mRunnable = new Runnable() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                HostLiveGoodsAuthGuide.this.biH.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.biM.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.biH.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.biO.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.biM.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.biH.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.biO.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.biM.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.biN.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.biI.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.biK.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.biJ.setVisibility(0);
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
                HostLiveGoodsAuthGuide.this.biH.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.biM.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.biH.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.biO.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.biM.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.biH.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.biO.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.biM.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.biN.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.biI.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.biK.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.biJ.setVisibility(0);
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
                HostLiveGoodsAuthGuide.this.biH.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.biM.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.biH.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.biO.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.biM.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.biH.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.biO.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.biM.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.biN.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.biI.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.biK.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.biJ.setVisibility(0);
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
        this.biJ = (FrameLayout) inflate.findViewById(a.g.goodsAuthGuide_layout);
        this.biK = (Button) inflate.findViewById(a.g.goodsAuthGuideKnown_button);
        this.biM = (LinearLayout) inflate.findViewById(a.g.goodsAuthGuideContent_layout);
        this.biL = (GradientTextView) inflate.findViewById(a.g.goodsAuthGuideTitle_textView);
        this.biN = (LinearLayout) inflate.findViewById(a.g.goodsAuthGuideShopping_layout);
        this.biO = (ImageView) inflate.findViewById(a.g.goodsAuthGuideShopping_imageView);
        this.biK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.Cl().e(HostLiveGoodsAuthGuide.this);
            }
        });
    }

    public void c(View view, View view2) {
        this.biH = view;
        this.biI = view2;
        view.post(this.mRunnable);
    }
}
