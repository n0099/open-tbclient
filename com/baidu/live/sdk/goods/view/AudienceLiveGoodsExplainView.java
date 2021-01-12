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
/* loaded from: classes10.dex */
public class AudienceLiveGoodsExplainView extends PendantChildView {
    private float bwO;
    private float bwP;
    private float bwQ;
    private float bwR;
    private BdRoundedImageView bwS;
    private TextView bwT;
    private TextView bwU;
    private View bwV;
    private FrameLayout bwW;
    private a bwX;
    private com.baidu.live.sdk.goods.a.a bwc;
    private Activity mActivity;

    /* loaded from: classes10.dex */
    public interface a {
        void a(View view, com.baidu.live.sdk.goods.a.a aVar);
    }

    public AudienceLiveGoodsExplainView(Activity activity) {
        super(activity);
        this.mActivity = activity;
        this.bwO = this.mActivity.getResources().getDimension(a.d.sdk_ds20);
        this.bwQ = this.mActivity.getResources().getDimension(a.d.sdk_ds196);
        OG();
    }

    public void setOnCloseBtnClickListener(a aVar) {
        this.bwX = aVar;
    }

    public void f(com.baidu.live.sdk.goods.a.a aVar) {
        if (aVar != null) {
            this.bwc = aVar;
            this.bwU.setText(this.bwc.title);
            this.bwT.setText(this.bwc.price);
            ImageLoaderManager.getInstance().buildImageLoader().loadImage(this.bwc.imageUrl, new IImageLoaderListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.1
                @Override // com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderListener
                public void onLoadComplete(String str, Bitmap bitmap) {
                    AudienceLiveGoodsExplainView.this.bwS.setImageBitmap(bitmap);
                }
            });
            this.bwV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AudienceLiveGoodsExplainView.this.bwX != null) {
                        AudienceLiveGoodsExplainView.this.bwX.a(view, AudienceLiveGoodsExplainView.this.bwc);
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
                this.bwP = realScreenHeight * 0.3f;
            } else {
                this.bwP = realScreenWidth * 0.3f;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = (int) this.bwO;
            layoutParams.leftMargin = (int) this.bwO;
            if (this.bwP < (this.bwO * 2.0f) + this.bwQ) {
                this.bwR = this.bwP - (this.bwO * 2.0f);
            } else {
                this.bwR = this.bwQ;
            }
            ViewGroup.LayoutParams layoutParams2 = this.bwW.getLayoutParams();
            layoutParams2.width = (int) this.bwR;
            layoutParams2.height = (int) this.bwR;
            pendantParentView.a(this, layoutParams);
        }
    }

    private void OG() {
        this.mActivity.getLayoutInflater().inflate(a.g.ala_sdk_goods_explain, this);
        this.bwS = (BdRoundedImageView) findViewById(a.f.conver_imageView);
        this.bwV = findViewById(a.f.iv_goods_explain_close);
        this.bwU = (TextView) findViewById(a.f.tv_goods_title);
        this.bwT = (TextView) findViewById(a.f.price_textView);
        this.bwW = (FrameLayout) findViewById(a.f.fl_iv_container);
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
