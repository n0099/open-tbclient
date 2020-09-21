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
    private com.baidu.live.sdk.goods.a.a blK;
    private TextView bmA;
    private View bmB;
    private FrameLayout bmC;
    private a bmD;
    private float bmu;
    private float bmv;
    private float bmw;
    private float bmx;
    private BdRoundedImageView bmy;
    private TextView bmz;
    private Activity mActivity;

    /* loaded from: classes4.dex */
    public interface a {
        void a(View view, com.baidu.live.sdk.goods.a.a aVar);
    }

    public AudienceLiveGoodsExplainView(Activity activity) {
        super(activity);
        this.mActivity = activity;
        this.bmu = this.mActivity.getResources().getDimension(a.e.sdk_ds20);
        this.bmw = this.mActivity.getResources().getDimension(a.e.sdk_ds196);
        NK();
    }

    public void setOnCloseBtnClickListener(a aVar) {
        this.bmD = aVar;
    }

    public void f(com.baidu.live.sdk.goods.a.a aVar) {
        if (aVar != null) {
            this.blK = aVar;
            this.bmA.setText(this.blK.title);
            this.bmz.setText(this.blK.price);
            ImageLoaderManager.getInstance().buildImageLoader().loadImage(this.blK.imageUrl, new IImageLoaderListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.1
                @Override // com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderListener
                public void onLoadComplete(String str, Bitmap bitmap) {
                    AudienceLiveGoodsExplainView.this.bmy.setImageBitmap(bitmap);
                }
            });
            this.bmB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AudienceLiveGoodsExplainView.this.bmD != null) {
                        AudienceLiveGoodsExplainView.this.bmD.a(view, AudienceLiveGoodsExplainView.this.blK);
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
                this.bmv = realScreenHeight * 0.3f;
            } else {
                this.bmv = realScreenWidth * 0.3f;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = (int) this.bmu;
            layoutParams.leftMargin = (int) this.bmu;
            if (this.bmv < (this.bmu * 2.0f) + this.bmw) {
                this.bmx = this.bmv - (this.bmu * 2.0f);
            } else {
                this.bmx = this.bmw;
            }
            ViewGroup.LayoutParams layoutParams2 = this.bmC.getLayoutParams();
            layoutParams2.width = (int) this.bmx;
            layoutParams2.height = (int) this.bmx;
            pendantParentView.a(this, layoutParams);
        }
    }

    private void NK() {
        this.mActivity.getLayoutInflater().inflate(a.h.ala_sdk_goods_explain, this);
        this.bmy = (BdRoundedImageView) findViewById(a.g.conver_imageView);
        this.bmB = findViewById(a.g.iv_goods_explain_close);
        this.bmA = (TextView) findViewById(a.g.tv_goods_title);
        this.bmz = (TextView) findViewById(a.g.price_textView);
        this.bmC = (FrameLayout) findViewById(a.g.fl_iv_container);
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
