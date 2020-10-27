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
    private float brW;
    private float brX;
    private float brY;
    private float brZ;
    private com.baidu.live.sdk.goods.a.a brk;
    private BdRoundedImageView bsa;
    private TextView bsb;
    private TextView bsc;
    private View bsd;
    private FrameLayout bse;
    private a bsf;
    private Activity mActivity;

    /* loaded from: classes4.dex */
    public interface a {
        void a(View view, com.baidu.live.sdk.goods.a.a aVar);
    }

    public AudienceLiveGoodsExplainView(Activity activity) {
        super(activity);
        this.mActivity = activity;
        this.brW = this.mActivity.getResources().getDimension(a.e.sdk_ds20);
        this.brY = this.mActivity.getResources().getDimension(a.e.sdk_ds196);
        Pn();
    }

    public void setOnCloseBtnClickListener(a aVar) {
        this.bsf = aVar;
    }

    public void f(com.baidu.live.sdk.goods.a.a aVar) {
        if (aVar != null) {
            this.brk = aVar;
            this.bsc.setText(this.brk.title);
            this.bsb.setText(this.brk.price);
            ImageLoaderManager.getInstance().buildImageLoader().loadImage(this.brk.imageUrl, new IImageLoaderListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.1
                @Override // com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderListener
                public void onLoadComplete(String str, Bitmap bitmap) {
                    AudienceLiveGoodsExplainView.this.bsa.setImageBitmap(bitmap);
                }
            });
            this.bsd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AudienceLiveGoodsExplainView.this.bsf != null) {
                        AudienceLiveGoodsExplainView.this.bsf.a(view, AudienceLiveGoodsExplainView.this.brk);
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
                this.brX = realScreenHeight * 0.3f;
            } else {
                this.brX = realScreenWidth * 0.3f;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = (int) this.brW;
            layoutParams.leftMargin = (int) this.brW;
            if (this.brX < (this.brW * 2.0f) + this.brY) {
                this.brZ = this.brX - (this.brW * 2.0f);
            } else {
                this.brZ = this.brY;
            }
            ViewGroup.LayoutParams layoutParams2 = this.bse.getLayoutParams();
            layoutParams2.width = (int) this.brZ;
            layoutParams2.height = (int) this.brZ;
            pendantParentView.a(this, layoutParams);
        }
    }

    private void Pn() {
        this.mActivity.getLayoutInflater().inflate(a.h.ala_sdk_goods_explain, this);
        this.bsa = (BdRoundedImageView) findViewById(a.g.conver_imageView);
        this.bsd = findViewById(a.g.iv_goods_explain_close);
        this.bsc = (TextView) findViewById(a.g.tv_goods_title);
        this.bsb = (TextView) findViewById(a.g.price_textView);
        this.bse = (FrameLayout) findViewById(a.g.fl_iv_container);
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
