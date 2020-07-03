package com.baidu.live.sdk.goods.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.live.c;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.view.GradientTextView;
/* loaded from: classes3.dex */
public class b implements com.baidu.live.core.layer.a {
    private FrameLayout bcJ;
    private Button bcK;
    private GradientTextView bcL;
    private LinearLayout bcM;
    private LinearLayout bcN;
    private ImageView bcO;
    private final View rootView;

    public b(Context context) {
        this.rootView = View.inflate(context, a.h.ala_live_goods_auth_guide, null);
        this.bcJ = (FrameLayout) this.rootView.findViewById(a.g.goodsAuthGuide_layout);
        this.bcK = (Button) this.rootView.findViewById(a.g.goodsAuthGuideKnown_button);
        this.bcM = (LinearLayout) this.rootView.findViewById(a.g.goodsAuthGuideContent_layout);
        this.bcL = (GradientTextView) this.rootView.findViewById(a.g.goodsAuthGuideTitle_textView);
        this.bcN = (LinearLayout) this.rootView.findViewById(a.g.goodsAuthGuideShopping_layout);
        this.bcO = (ImageView) this.rootView.findViewById(a.g.goodsAuthGuideShopping_imageView);
        this.bcK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.live.core.layer.b.wk().et("layer_key_live_goods_auth");
            }
        });
    }

    @Override // com.baidu.live.core.layer.a
    public View getRootView() {
        return this.rootView;
    }

    @Override // com.baidu.live.core.layer.a
    public ViewGroup.LayoutParams wj() {
        return null;
    }

    @Override // com.baidu.live.core.layer.a
    public void release() {
    }

    public void c(final View view, final View view2) {
        view.post(new Runnable() { // from class: com.baidu.live.sdk.goods.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                b.this.bcM.measure(0, 0);
                int width = (iArr[0] + (view.getWidth() / 2)) - (b.this.bcO.getMeasuredWidth() / 2);
                b.this.bcM.setY(((iArr[1] + (view.getHeight() / 2)) + (b.this.bcO.getMeasuredHeight() / 2)) - b.this.bcM.getMeasuredHeight());
                b.this.bcN.setX(width);
                int[] iArr2 = new int[2];
                view2.getLocationOnScreen(iArr2);
                b.this.bcK.setY(iArr2[1]);
                b.this.bcJ.setVisibility(0);
                com.baidu.live.core.layer.b.wk().a("layer_key_live_goods_auth", b.this);
                c.vf().putBoolean("has_show_goods_auth_guide", true);
            }
        });
    }
}
