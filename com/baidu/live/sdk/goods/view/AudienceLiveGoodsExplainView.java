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
/* loaded from: classes4.dex */
public class AudienceLiveGoodsExplainView extends PendantChildView {
    private float bwP;
    private float bwQ;
    private float bwR;
    private float bwS;
    private BdRoundedImageView bwT;
    private TextView bwU;
    private TextView bwV;
    private View bwW;
    private FrameLayout bwX;
    private a bwY;
    private com.baidu.live.sdk.goods.a.a bwd;
    private Activity mActivity;

    /* loaded from: classes4.dex */
    public interface a {
        void a(View view, com.baidu.live.sdk.goods.a.a aVar);
    }

    public AudienceLiveGoodsExplainView(Activity activity) {
        super(activity);
        this.mActivity = activity;
        this.bwP = this.mActivity.getResources().getDimension(a.d.sdk_ds20);
        this.bwR = this.mActivity.getResources().getDimension(a.d.sdk_ds196);
        Ry();
    }

    public void setOnCloseBtnClickListener(a aVar) {
        this.bwY = aVar;
    }

    public void f(com.baidu.live.sdk.goods.a.a aVar) {
        if (aVar != null) {
            this.bwd = aVar;
            this.bwV.setText(this.bwd.title);
            this.bwU.setText(this.bwd.price);
            ImageLoaderManager.getInstance().buildImageLoader().loadImage(this.bwd.imageUrl, new IImageLoaderListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.1
                @Override // com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderListener
                public void onLoadComplete(String str, Bitmap bitmap) {
                    AudienceLiveGoodsExplainView.this.bwT.setImageBitmap(bitmap);
                }
            });
            this.bwW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AudienceLiveGoodsExplainView.this.bwY != null) {
                        AudienceLiveGoodsExplainView.this.bwY.a(view, AudienceLiveGoodsExplainView.this.bwd);
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
                this.bwQ = realScreenHeight * 0.3f;
            } else {
                this.bwQ = realScreenWidth * 0.3f;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = (int) this.bwP;
            layoutParams.leftMargin = (int) this.bwP;
            if (this.bwQ < (this.bwP * 2.0f) + this.bwR) {
                this.bwS = this.bwQ - (this.bwP * 2.0f);
            } else {
                this.bwS = this.bwR;
            }
            ViewGroup.LayoutParams layoutParams2 = this.bwX.getLayoutParams();
            layoutParams2.width = (int) this.bwS;
            layoutParams2.height = (int) this.bwS;
            pendantParentView.a(this, layoutParams);
        }
    }

    private void Ry() {
        this.mActivity.getLayoutInflater().inflate(a.g.ala_sdk_goods_explain, this);
        this.bwT = (BdRoundedImageView) findViewById(a.f.conver_imageView);
        this.bwW = findViewById(a.f.iv_goods_explain_close);
        this.bwV = (TextView) findViewById(a.f.tv_goods_title);
        this.bwU = (TextView) findViewById(a.f.price_textView);
        this.bwX = (FrameLayout) findViewById(a.f.fl_iv_container);
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
