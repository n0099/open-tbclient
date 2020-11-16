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
    private com.baidu.live.sdk.goods.a.a bqS;
    private float brF;
    private float brG;
    private float brH;
    private float brI;
    private BdRoundedImageView brJ;
    private TextView brK;
    private TextView brL;
    private View brM;
    private FrameLayout brN;
    private a brO;
    private Activity mActivity;

    /* loaded from: classes4.dex */
    public interface a {
        void a(View view, com.baidu.live.sdk.goods.a.a aVar);
    }

    public AudienceLiveGoodsExplainView(Activity activity) {
        super(activity);
        this.mActivity = activity;
        this.brF = this.mActivity.getResources().getDimension(a.d.sdk_ds20);
        this.brH = this.mActivity.getResources().getDimension(a.d.sdk_ds196);
        Pe();
    }

    public void setOnCloseBtnClickListener(a aVar) {
        this.brO = aVar;
    }

    public void f(com.baidu.live.sdk.goods.a.a aVar) {
        if (aVar != null) {
            this.bqS = aVar;
            this.brL.setText(this.bqS.title);
            this.brK.setText(this.bqS.price);
            ImageLoaderManager.getInstance().buildImageLoader().loadImage(this.bqS.imageUrl, new IImageLoaderListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.1
                @Override // com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderListener
                public void onLoadComplete(String str, Bitmap bitmap) {
                    AudienceLiveGoodsExplainView.this.brJ.setImageBitmap(bitmap);
                }
            });
            this.brM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AudienceLiveGoodsExplainView.this.brO != null) {
                        AudienceLiveGoodsExplainView.this.brO.a(view, AudienceLiveGoodsExplainView.this.bqS);
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
                this.brG = realScreenHeight * 0.3f;
            } else {
                this.brG = realScreenWidth * 0.3f;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = (int) this.brF;
            layoutParams.leftMargin = (int) this.brF;
            if (this.brG < (this.brF * 2.0f) + this.brH) {
                this.brI = this.brG - (this.brF * 2.0f);
            } else {
                this.brI = this.brH;
            }
            ViewGroup.LayoutParams layoutParams2 = this.brN.getLayoutParams();
            layoutParams2.width = (int) this.brI;
            layoutParams2.height = (int) this.brI;
            pendantParentView.a(this, layoutParams);
        }
    }

    private void Pe() {
        this.mActivity.getLayoutInflater().inflate(a.g.ala_sdk_goods_explain, this);
        this.brJ = (BdRoundedImageView) findViewById(a.f.conver_imageView);
        this.brM = findViewById(a.f.iv_goods_explain_close);
        this.brL = (TextView) findViewById(a.f.tv_goods_title);
        this.brK = (TextView) findViewById(a.f.price_textView);
        this.brN = (FrameLayout) findViewById(a.f.fl_iv_container);
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
