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
    private View bAF;
    private View bAG;
    private FrameLayout bAH;
    private Button bAI;
    private GradientTextView bAJ;
    private LinearLayout bAK;
    private LinearLayout bAL;
    private ImageView bAM;
    private Runnable mRunnable;

    public HostLiveGoodsAuthGuide(@NonNull Context context) {
        super(context);
        this.mRunnable = new Runnable() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                HostLiveGoodsAuthGuide.this.bAF.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bAK.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bAF.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bAM.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bAK.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bAF.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bAM.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bAK.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bAL.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bAG.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bAI.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bAH.setVisibility(0);
                b.En().d(HostLiveGoodsAuthGuide.this);
                d.Ba().putBoolean("has_show_goods_auth_guide", true);
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
                HostLiveGoodsAuthGuide.this.bAF.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bAK.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bAF.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bAM.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bAK.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bAF.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bAM.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bAK.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bAL.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bAG.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bAI.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bAH.setVisibility(0);
                b.En().d(HostLiveGoodsAuthGuide.this);
                d.Ba().putBoolean("has_show_goods_auth_guide", true);
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
                HostLiveGoodsAuthGuide.this.bAF.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bAK.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bAF.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bAM.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bAK.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bAF.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bAM.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bAK.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bAL.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bAG.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bAI.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bAH.setVisibility(0);
                b.En().d(HostLiveGoodsAuthGuide.this);
                d.Ba().putBoolean("has_show_goods_auth_guide", true);
            }
        };
        init(context);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Eh() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ei() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ej() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ek() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void release() {
        removeCallbacks(this.mRunnable);
    }

    private void init(Context context) {
        View inflate = View.inflate(context, a.g.ala_live_goods_auth_guide, this);
        this.bAH = (FrameLayout) inflate.findViewById(a.f.goodsAuthGuide_layout);
        this.bAI = (Button) inflate.findViewById(a.f.goodsAuthGuideKnown_button);
        this.bAK = (LinearLayout) inflate.findViewById(a.f.goodsAuthGuideContent_layout);
        this.bAJ = (GradientTextView) inflate.findViewById(a.f.goodsAuthGuideTitle_textView);
        this.bAL = (LinearLayout) inflate.findViewById(a.f.goodsAuthGuideShopping_layout);
        this.bAM = (ImageView) inflate.findViewById(a.f.goodsAuthGuideShopping_imageView);
        this.bAI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.En().e(HostLiveGoodsAuthGuide.this);
            }
        });
    }

    public void c(View view, View view2) {
        this.bAF = view;
        this.bAG = view2;
        view.post(this.mRunnable);
    }
}
