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
    private View bdb;
    private View bdc;
    private FrameLayout bdd;
    private Button bde;
    private GradientTextView bdf;
    private LinearLayout bdg;
    private LinearLayout bdh;
    private ImageView bdi;
    private Runnable mRunnable;

    public HostLiveGoodsAuthGuide(@NonNull Context context) {
        super(context);
        this.mRunnable = new Runnable() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                HostLiveGoodsAuthGuide.this.bdb.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bdg.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bdb.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bdi.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bdg.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bdb.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bdi.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bdg.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bdh.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bdc.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bde.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bdd.setVisibility(0);
                b.wN().d(HostLiveGoodsAuthGuide.this);
                c.vf().putBoolean("has_show_goods_auth_guide", true);
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
                HostLiveGoodsAuthGuide.this.bdb.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bdg.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bdb.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bdi.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bdg.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bdb.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bdi.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bdg.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bdh.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bdc.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bde.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bdd.setVisibility(0);
                b.wN().d(HostLiveGoodsAuthGuide.this);
                c.vf().putBoolean("has_show_goods_auth_guide", true);
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
                HostLiveGoodsAuthGuide.this.bdb.getLocationOnScreen(iArr);
                HostLiveGoodsAuthGuide.this.bdg.measure(0, 0);
                int width = (iArr[0] + (HostLiveGoodsAuthGuide.this.bdb.getWidth() / 2)) - (HostLiveGoodsAuthGuide.this.bdi.getMeasuredWidth() / 2);
                HostLiveGoodsAuthGuide.this.bdg.setY(((iArr[1] + (HostLiveGoodsAuthGuide.this.bdb.getHeight() / 2)) + (HostLiveGoodsAuthGuide.this.bdi.getMeasuredHeight() / 2)) - HostLiveGoodsAuthGuide.this.bdg.getMeasuredHeight());
                HostLiveGoodsAuthGuide.this.bdh.setX(width);
                int[] iArr2 = new int[2];
                HostLiveGoodsAuthGuide.this.bdc.getLocationOnScreen(iArr2);
                HostLiveGoodsAuthGuide.this.bde.setY(iArr2[1]);
                HostLiveGoodsAuthGuide.this.bdd.setVisibility(0);
                b.wN().d(HostLiveGoodsAuthGuide.this);
                c.vf().putBoolean("has_show_goods_auth_guide", true);
            }
        };
        init(context);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void wH() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void wI() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void wJ() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void wK() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void release() {
        removeCallbacks(this.mRunnable);
    }

    private void init(Context context) {
        View inflate = View.inflate(context, a.h.ala_live_goods_auth_guide, this);
        this.bdd = (FrameLayout) inflate.findViewById(a.g.goodsAuthGuide_layout);
        this.bde = (Button) inflate.findViewById(a.g.goodsAuthGuideKnown_button);
        this.bdg = (LinearLayout) inflate.findViewById(a.g.goodsAuthGuideContent_layout);
        this.bdf = (GradientTextView) inflate.findViewById(a.g.goodsAuthGuideTitle_textView);
        this.bdh = (LinearLayout) inflate.findViewById(a.g.goodsAuthGuideShopping_layout);
        this.bdi = (ImageView) inflate.findViewById(a.g.goodsAuthGuideShopping_imageView);
        this.bde.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.wN().e(HostLiveGoodsAuthGuide.this);
            }
        });
    }

    public void c(View view, View view2) {
        this.bdb = view;
        this.bdc = view2;
        view.post(this.mRunnable);
    }
}
