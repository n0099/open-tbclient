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
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.util.ScreenHelper;
/* loaded from: classes3.dex */
public class AudienceLiveGoodsExplainView extends PendantChildView {
    private com.baidu.live.sdk.goods.a.a bcS;
    private float bdE;
    private float bdF;
    private float bdG;
    private float bdH;
    private BdRoundedImageView bdI;
    private TextView bdJ;
    private TextView bdK;
    private View bdL;
    private FrameLayout bdM;
    private a bdN;
    private Activity mActivity;

    /* loaded from: classes3.dex */
    public interface a {
        void a(View view, com.baidu.live.sdk.goods.a.a aVar);
    }

    public AudienceLiveGoodsExplainView(Activity activity) {
        super(activity);
        this.mActivity = activity;
        this.bdF = ScreenHelper.getRealScreenWidth(this.mActivity) * 0.3f;
        this.bdE = this.mActivity.getResources().getDimension(a.e.sdk_ds20);
        this.bdG = this.mActivity.getResources().getDimension(a.e.sdk_ds196);
        Hj();
    }

    public void setOnCloseBtnClickListener(a aVar) {
        this.bdN = aVar;
    }

    public void d(com.baidu.live.sdk.goods.a.a aVar) {
        if (aVar != null) {
            this.bcS = aVar;
            this.bdK.setText(this.bcS.title);
            this.bdJ.setText(this.bcS.price);
            ImageLoaderManager.getInstance().buildImageLoader().loadImage(this.bcS.imageUrl, new IImageLoaderListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.1
                @Override // com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderListener
                public void onLoadComplete(String str, Bitmap bitmap) {
                    AudienceLiveGoodsExplainView.this.bdI.setImageBitmap(bitmap);
                }
            });
            this.bdL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AudienceLiveGoodsExplainView.this.bdN != null) {
                        AudienceLiveGoodsExplainView.this.bdN.a(view, AudienceLiveGoodsExplainView.this.bcS);
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
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = (int) this.bdE;
            layoutParams.leftMargin = (int) this.bdE;
            if (this.bdF < (this.bdE * 2.0f) + this.bdG) {
                this.bdH = this.bdF - (this.bdE * 2.0f);
            } else {
                this.bdH = this.bdF;
            }
            ViewGroup.LayoutParams layoutParams2 = this.bdM.getLayoutParams();
            layoutParams2.width = (int) this.bdH;
            layoutParams2.height = (int) this.bdH;
            pendantParentView.a(this, layoutParams);
        }
    }

    private void Hj() {
        this.mActivity.getLayoutInflater().inflate(a.h.ala_sdk_goods_explain, this);
        this.bdI = (BdRoundedImageView) findViewById(a.g.conver_imageView);
        this.bdL = findViewById(a.g.iv_goods_explain_close);
        this.bdK = (TextView) findViewById(a.g.tv_goods_title);
        this.bdJ = (TextView) findViewById(a.g.price_textView);
        this.bdM = (FrameLayout) findViewById(a.g.fl_iv_container);
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
}
