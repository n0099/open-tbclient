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
    private View bqJ;
    private View bqK;
    private FrameLayout bqL;
    private Button bqM;
    private GradientTextView bqN;
    private LinearLayout bqO;
    private LinearLayout bqP;
    private ImageView bqQ;
    private Runnable mRunnable;

    public HostLiveGoodsAuthGuide(@NonNull Context context) {
        super(context);
        this.mRunnable = new Runnable() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                HostLiveGoodsAuthGuide.this.bqJ.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bqO.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bqJ.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bqQ.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bqO.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bqJ.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bqQ.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bqO.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bqP.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bqK.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bqM.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bqL.setVisibility(0);
                b.Do().d(HostLiveGoodsAuthGuide.this);
                d.Aq().putBoolean("has_show_goods_auth_guide", true);
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
                HostLiveGoodsAuthGuide.this.bqJ.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bqO.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bqJ.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bqQ.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bqO.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bqJ.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bqQ.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bqO.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bqP.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bqK.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bqM.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bqL.setVisibility(0);
                b.Do().d(HostLiveGoodsAuthGuide.this);
                d.Aq().putBoolean("has_show_goods_auth_guide", true);
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
                HostLiveGoodsAuthGuide.this.bqJ.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bqO.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bqJ.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bqQ.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bqO.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bqJ.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bqQ.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bqO.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bqP.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bqK.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bqM.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bqL.setVisibility(0);
                b.Do().d(HostLiveGoodsAuthGuide.this);
                d.Aq().putBoolean("has_show_goods_auth_guide", true);
            }
        };
        init(context);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Di() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Dj() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Dk() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Dl() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void release() {
        removeCallbacks(this.mRunnable);
    }

    private void init(Context context) {
        View inflate = View.inflate(context, a.g.ala_live_goods_auth_guide, this);
        this.bqL = (FrameLayout) inflate.findViewById(a.f.goodsAuthGuide_layout);
        this.bqM = (Button) inflate.findViewById(a.f.goodsAuthGuideKnown_button);
        this.bqO = (LinearLayout) inflate.findViewById(a.f.goodsAuthGuideContent_layout);
        this.bqN = (GradientTextView) inflate.findViewById(a.f.goodsAuthGuideTitle_textView);
        this.bqP = (LinearLayout) inflate.findViewById(a.f.goodsAuthGuideShopping_layout);
        this.bqQ = (ImageView) inflate.findViewById(a.f.goodsAuthGuideShopping_imageView);
        this.bqM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.Do().e(HostLiveGoodsAuthGuide.this);
            }
        });
    }

    public void c(View view, View view2) {
        this.bqJ = view;
        this.bqK = view2;
        view.post(this.mRunnable);
    }
}
