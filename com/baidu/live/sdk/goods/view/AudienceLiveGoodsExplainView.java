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
    private com.baidu.live.sdk.goods.a.a biQ;
    private float bjB;
    private float bjC;
    private float bjD;
    private float bjE;
    private BdRoundedImageView bjF;
    private TextView bjG;
    private TextView bjH;
    private View bjI;
    private FrameLayout bjJ;
    private a bjK;
    private Activity mActivity;

    /* loaded from: classes7.dex */
    public interface a {
        void a(View view, com.baidu.live.sdk.goods.a.a aVar);
    }

    public AudienceLiveGoodsExplainView(Activity activity) {
        super(activity);
        this.mActivity = activity;
        this.bjB = this.mActivity.getResources().getDimension(a.e.sdk_ds20);
        this.bjD = this.mActivity.getResources().getDimension(a.e.sdk_ds196);
        Nh();
    }

    public void setOnCloseBtnClickListener(a aVar) {
        this.bjK = aVar;
    }

    public void f(com.baidu.live.sdk.goods.a.a aVar) {
        if (aVar != null) {
            this.biQ = aVar;
            this.bjH.setText(this.biQ.title);
            this.bjG.setText(this.biQ.price);
            ImageLoaderManager.getInstance().buildImageLoader().loadImage(this.biQ.imageUrl, new IImageLoaderListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.1
                @Override // com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderListener
                public void onLoadComplete(String str, Bitmap bitmap) {
                    AudienceLiveGoodsExplainView.this.bjF.setImageBitmap(bitmap);
                }
            });
            this.bjI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AudienceLiveGoodsExplainView.this.bjK != null) {
                        AudienceLiveGoodsExplainView.this.bjK.a(view, AudienceLiveGoodsExplainView.this.biQ);
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
                this.bjC = realScreenHeight * 0.3f;
            } else {
                this.bjC = realScreenWidth * 0.3f;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = (int) this.bjB;
            layoutParams.leftMargin = (int) this.bjB;
            if (this.bjC < (this.bjB * 2.0f) + this.bjD) {
                this.bjE = this.bjC - (this.bjB * 2.0f);
            } else {
                this.bjE = this.bjD;
            }
            ViewGroup.LayoutParams layoutParams2 = this.bjJ.getLayoutParams();
            layoutParams2.width = (int) this.bjE;
            layoutParams2.height = (int) this.bjE;
            pendantParentView.a(this, layoutParams);
        }
    }

    private void Nh() {
        this.mActivity.getLayoutInflater().inflate(a.h.ala_sdk_goods_explain, this);
        this.bjF = (BdRoundedImageView) findViewById(a.g.conver_imageView);
        this.bjI = findViewById(a.g.iv_goods_explain_close);
        this.bjH = (TextView) findViewById(a.g.tv_goods_title);
        this.bjG = (TextView) findViewById(a.g.price_textView);
        this.bjJ = (FrameLayout) findViewById(a.g.fl_iv_container);
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
