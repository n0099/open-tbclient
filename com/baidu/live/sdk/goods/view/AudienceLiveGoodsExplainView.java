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
    private com.baidu.live.sdk.goods.a.a bAO;
    private float bBA;
    private float bBB;
    private float bBC;
    private float bBD;
    private BdRoundedImageView bBE;
    private TextView bBF;
    private TextView bBG;
    private View bBH;
    private FrameLayout bBI;
    private a bBJ;
    private Activity mActivity;

    /* loaded from: classes11.dex */
    public interface a {
        void a(View view, com.baidu.live.sdk.goods.a.a aVar);
    }

    public AudienceLiveGoodsExplainView(Activity activity) {
        super(activity);
        this.mActivity = activity;
        this.bBA = this.mActivity.getResources().getDimension(a.d.sdk_ds20);
        this.bBC = this.mActivity.getResources().getDimension(a.d.sdk_ds196);
        SB();
    }

    public void setOnCloseBtnClickListener(a aVar) {
        this.bBJ = aVar;
    }

    public void f(com.baidu.live.sdk.goods.a.a aVar) {
        if (aVar != null) {
            this.bAO = aVar;
            this.bBG.setText(this.bAO.title);
            this.bBF.setText(this.bAO.price);
            ImageLoaderManager.getInstance().buildImageLoader().loadImage(this.bAO.imageUrl, new IImageLoaderListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.1
                @Override // com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderListener
                public void onLoadComplete(String str, Bitmap bitmap) {
                    AudienceLiveGoodsExplainView.this.bBE.setImageBitmap(bitmap);
                }
            });
            this.bBH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AudienceLiveGoodsExplainView.this.bBJ != null) {
                        AudienceLiveGoodsExplainView.this.bBJ.a(view, AudienceLiveGoodsExplainView.this.bAO);
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
                this.bBB = realScreenHeight * 0.3f;
            } else {
                this.bBB = realScreenWidth * 0.3f;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = (int) this.bBA;
            layoutParams.leftMargin = (int) this.bBA;
            if (this.bBB < (this.bBA * 2.0f) + this.bBC) {
                this.bBD = this.bBB - (this.bBA * 2.0f);
            } else {
                this.bBD = this.bBC;
            }
            ViewGroup.LayoutParams layoutParams2 = this.bBI.getLayoutParams();
            layoutParams2.width = (int) this.bBD;
            layoutParams2.height = (int) this.bBD;
            pendantParentView.a(this, layoutParams);
        }
    }

    private void SB() {
        this.mActivity.getLayoutInflater().inflate(a.g.ala_sdk_goods_explain, this);
        this.bBE = (BdRoundedImageView) findViewById(a.f.conver_imageView);
        this.bBH = findViewById(a.f.iv_goods_explain_close);
        this.bBG = (TextView) findViewById(a.f.tv_goods_title);
        this.bBF = (TextView) findViewById(a.f.price_textView);
        this.bBI = (FrameLayout) findViewById(a.f.fl_iv_container);
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
