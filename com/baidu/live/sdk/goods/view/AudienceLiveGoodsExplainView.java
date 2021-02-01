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
/* loaded from: classes11.dex */
public class AudienceLiveGoodsExplainView extends PendantChildView {
    private a bAA;
    private float bAr;
    private float bAs;
    private float bAt;
    private float bAu;
    private BdRoundedImageView bAv;
    private TextView bAw;
    private TextView bAx;
    private View bAy;
    private FrameLayout bAz;
    private com.baidu.live.sdk.goods.a.a bzE;
    private Activity mActivity;

    /* loaded from: classes11.dex */
    public interface a {
        void a(View view, com.baidu.live.sdk.goods.a.a aVar);
    }

    public AudienceLiveGoodsExplainView(Activity activity) {
        super(activity);
        this.mActivity = activity;
        this.bAr = this.mActivity.getResources().getDimension(a.d.sdk_ds20);
        this.bAt = this.mActivity.getResources().getDimension(a.d.sdk_ds196);
        Qg();
    }

    public void setOnCloseBtnClickListener(a aVar) {
        this.bAA = aVar;
    }

    public void f(com.baidu.live.sdk.goods.a.a aVar) {
        if (aVar != null) {
            this.bzE = aVar;
            this.bAx.setText(this.bzE.title);
            this.bAw.setText(this.bzE.price);
            ImageLoaderManager.getInstance().buildImageLoader().loadImage(this.bzE.imageUrl, new IImageLoaderListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.1
                @Override // com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderListener
                public void onLoadComplete(String str, Bitmap bitmap) {
                    AudienceLiveGoodsExplainView.this.bAv.setImageBitmap(bitmap);
                }
            });
            this.bAy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AudienceLiveGoodsExplainView.this.bAA != null) {
                        AudienceLiveGoodsExplainView.this.bAA.a(view, AudienceLiveGoodsExplainView.this.bzE);
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
                this.bAs = realScreenHeight * 0.3f;
            } else {
                this.bAs = realScreenWidth * 0.3f;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = (int) this.bAr;
            layoutParams.leftMargin = (int) this.bAr;
            if (this.bAs < (this.bAr * 2.0f) + this.bAt) {
                this.bAu = this.bAs - (this.bAr * 2.0f);
            } else {
                this.bAu = this.bAt;
            }
            ViewGroup.LayoutParams layoutParams2 = this.bAz.getLayoutParams();
            layoutParams2.width = (int) this.bAu;
            layoutParams2.height = (int) this.bAu;
            pendantParentView.a(this, layoutParams);
        }
    }

    private void Qg() {
        this.mActivity.getLayoutInflater().inflate(a.g.ala_sdk_goods_explain, this);
        this.bAv = (BdRoundedImageView) findViewById(a.f.conver_imageView);
        this.bAy = findViewById(a.f.iv_goods_explain_close);
        this.bAx = (TextView) findViewById(a.f.tv_goods_title);
        this.bAw = (TextView) findViewById(a.f.price_textView);
        this.bAz = (FrameLayout) findViewById(a.f.fl_iv_container);
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
    public PendantParentView.Position getVerticalBBChattingPosition() {
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
