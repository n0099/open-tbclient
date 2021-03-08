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
    private float bBR;
    private float bBS;
    private float bBT;
    private float bBU;
    private BdRoundedImageView bBV;
    private TextView bBW;
    private TextView bBX;
    private View bBY;
    private FrameLayout bBZ;
    private com.baidu.live.sdk.goods.a.a bBe;
    private a bCa;
    private Activity mActivity;

    /* loaded from: classes10.dex */
    public interface a {
        void a(View view, com.baidu.live.sdk.goods.a.a aVar);
    }

    public AudienceLiveGoodsExplainView(Activity activity) {
        super(activity);
        this.mActivity = activity;
        this.bBR = this.mActivity.getResources().getDimension(a.d.sdk_ds20);
        this.bBT = this.mActivity.getResources().getDimension(a.d.sdk_ds196);
        Qj();
    }

    public void setOnCloseBtnClickListener(a aVar) {
        this.bCa = aVar;
    }

    public void f(com.baidu.live.sdk.goods.a.a aVar) {
        if (aVar != null) {
            this.bBe = aVar;
            this.bBX.setText(this.bBe.title);
            this.bBW.setText(this.bBe.price);
            ImageLoaderManager.getInstance().buildImageLoader().loadImage(this.bBe.imageUrl, new IImageLoaderListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.1
                @Override // com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderListener
                public void onLoadComplete(String str, Bitmap bitmap) {
                    AudienceLiveGoodsExplainView.this.bBV.setImageBitmap(bitmap);
                }
            });
            this.bBY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AudienceLiveGoodsExplainView.this.bCa != null) {
                        AudienceLiveGoodsExplainView.this.bCa.a(view, AudienceLiveGoodsExplainView.this.bBe);
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
                this.bBS = realScreenHeight * 0.3f;
            } else {
                this.bBS = realScreenWidth * 0.3f;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = (int) this.bBR;
            layoutParams.leftMargin = (int) this.bBR;
            if (this.bBS < (this.bBR * 2.0f) + this.bBT) {
                this.bBU = this.bBS - (this.bBR * 2.0f);
            } else {
                this.bBU = this.bBT;
            }
            ViewGroup.LayoutParams layoutParams2 = this.bBZ.getLayoutParams();
            layoutParams2.width = (int) this.bBU;
            layoutParams2.height = (int) this.bBU;
            pendantParentView.a(this, layoutParams);
        }
    }

    private void Qj() {
        this.mActivity.getLayoutInflater().inflate(a.g.ala_sdk_goods_explain, this);
        this.bBV = (BdRoundedImageView) findViewById(a.f.conver_imageView);
        this.bBY = findViewById(a.f.iv_goods_explain_close);
        this.bBX = (TextView) findViewById(a.f.tv_goods_title);
        this.bBW = (TextView) findViewById(a.f.price_textView);
        this.bBZ = (FrameLayout) findViewById(a.f.fl_iv_container);
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
