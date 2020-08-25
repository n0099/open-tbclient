package com.baidu.live.sdk.goods.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.image.loader.ImageLoaderManager;
import com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderListener;
import com.baidu.live.adp.widget.imageview.BdRoundedImageView;
import com.baidu.live.pendantview.FixedLocation;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.util.ScreenHelper;
/* loaded from: classes7.dex */
public class AudienceLiveGoodsExplainView extends PendantChildView {
    private com.baidu.live.sdk.goods.a.a biN;
    private float bjA;
    private float bjB;
    private BdRoundedImageView bjC;
    private TextView bjD;
    private TextView bjE;
    private View bjF;
    private FrameLayout bjG;
    private a bjH;
    private float bjy;
    private float bjz;
    private Activity mActivity;

    /* loaded from: classes7.dex */
    public interface a {
        void a(View view, com.baidu.live.sdk.goods.a.a aVar);
    }

    public AudienceLiveGoodsExplainView(Activity activity) {
        super(activity);
        this.mActivity = activity;
        this.bjy = this.mActivity.getResources().getDimension(a.e.sdk_ds20);
        this.bjA = this.mActivity.getResources().getDimension(a.e.sdk_ds196);
        Nh();
    }

    public void setOnCloseBtnClickListener(a aVar) {
        this.bjH = aVar;
    }

    public void f(com.baidu.live.sdk.goods.a.a aVar) {
        if (aVar != null) {
            this.biN = aVar;
            this.bjE.setText(this.biN.title);
            this.bjD.setText(this.biN.price);
            ImageLoaderManager.getInstance().buildImageLoader().loadImage(this.biN.imageUrl, new IImageLoaderListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.1
                @Override // com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderListener
                public void onLoadComplete(String str, Bitmap bitmap) {
                    AudienceLiveGoodsExplainView.this.bjC.setImageBitmap(bitmap);
                }
            });
            this.bjF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AudienceLiveGoodsExplainView.this.bjH != null) {
                        AudienceLiveGoodsExplainView.this.bjH.a(view, AudienceLiveGoodsExplainView.this.biN);
                    }
                }
            });
        }
    }

    public void a(PendantParentView pendantParentView) {
        if (pendantParentView != null) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            int realScreenWidth = ScreenHelper.getRealScreenWidth(this.mActivity);
            int realScreenHeight = ScreenHelper.getRealScreenHeight(this.mActivity);
            if (realScreenWidth > realScreenHeight) {
                this.bjz = realScreenHeight * 0.3f;
            } else {
                this.bjz = realScreenWidth * 0.3f;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = (int) this.bjy;
            layoutParams.leftMargin = (int) this.bjy;
            if (this.bjz < (this.bjy * 2.0f) + this.bjA) {
                this.bjB = this.bjz - (this.bjy * 2.0f);
            } else {
                this.bjB = this.bjA;
            }
            ViewGroup.LayoutParams layoutParams2 = this.bjG.getLayoutParams();
            layoutParams2.width = (int) this.bjB;
            layoutParams2.height = (int) this.bjB;
            pendantParentView.a(this, layoutParams);
        }
    }

    private void Nh() {
        this.mActivity.getLayoutInflater().inflate(a.h.ala_sdk_goods_explain, this);
        this.bjC = (BdRoundedImageView) findViewById(a.g.conver_imageView);
        this.bjF = findViewById(a.g.iv_goods_explain_close);
        this.bjE = (TextView) findViewById(a.g.tv_goods_title);
        this.bjD = (TextView) findViewById(a.g.price_textView);
        this.bjG = (FrameLayout) findViewById(a.g.fl_iv_container);
    }

    @Override // com.baidu.live.pendantview.PendantChildView
    public PendantParentView.Position getVerticalPosition() {
        return PendantParentView.Position.RIGHT;
    }

    @Override // com.baidu.live.pendantview.PendantChildView
    public PendantParentView.Position getVerticalPkPosition() {
        return PendantParentView.Position.RIGHT;
    }

    @Override // com.baidu.live.pendantview.PendantChildView
    public PendantParentView.Position getHorizontalPosition() {
        return PendantParentView.Position.RIGHT;
    }

    @Override // com.baidu.live.pendantview.PendantChildView
    public PendantParentView.Position getHorizontalFullPosition() {
        return PendantParentView.Position.RIGHT;
    }

    @Override // com.baidu.live.pendantview.PendantChildView
    public int getPriority() {
        return 15;
    }

    @Override // com.baidu.live.pendantview.PendantChildView
    public FixedLocation getFixedlocation() {
        return FixedLocation.BOTTOM;
    }
}
