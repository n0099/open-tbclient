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
    private com.baidu.live.sdk.goods.a.a bsD;
    private a btA;
    private float btr;
    private float bts;
    private float btt;
    private float btu;
    private BdRoundedImageView btv;
    private TextView btw;
    private TextView btx;
    private View bty;
    private FrameLayout btz;
    private Activity mActivity;

    /* loaded from: classes4.dex */
    public interface a {
        void a(View view, com.baidu.live.sdk.goods.a.a aVar);
    }

    public AudienceLiveGoodsExplainView(Activity activity) {
        super(activity);
        this.mActivity = activity;
        this.btr = this.mActivity.getResources().getDimension(a.d.sdk_ds20);
        this.btt = this.mActivity.getResources().getDimension(a.d.sdk_ds196);
        PN();
    }

    public void setOnCloseBtnClickListener(a aVar) {
        this.btA = aVar;
    }

    public void f(com.baidu.live.sdk.goods.a.a aVar) {
        if (aVar != null) {
            this.bsD = aVar;
            this.btx.setText(this.bsD.title);
            this.btw.setText(this.bsD.price);
            ImageLoaderManager.getInstance().buildImageLoader().loadImage(this.bsD.imageUrl, new IImageLoaderListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.1
                @Override // com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderListener
                public void onLoadComplete(String str, Bitmap bitmap) {
                    AudienceLiveGoodsExplainView.this.btv.setImageBitmap(bitmap);
                }
            });
            this.bty.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AudienceLiveGoodsExplainView.this.btA != null) {
                        AudienceLiveGoodsExplainView.this.btA.a(view, AudienceLiveGoodsExplainView.this.bsD);
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
                this.bts = realScreenHeight * 0.3f;
            } else {
                this.bts = realScreenWidth * 0.3f;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = (int) this.btr;
            layoutParams.leftMargin = (int) this.btr;
            if (this.bts < (this.btr * 2.0f) + this.btt) {
                this.btu = this.bts - (this.btr * 2.0f);
            } else {
                this.btu = this.btt;
            }
            ViewGroup.LayoutParams layoutParams2 = this.btz.getLayoutParams();
            layoutParams2.width = (int) this.btu;
            layoutParams2.height = (int) this.btu;
            pendantParentView.a(this, layoutParams);
        }
    }

    private void PN() {
        this.mActivity.getLayoutInflater().inflate(a.g.ala_sdk_goods_explain, this);
        this.btv = (BdRoundedImageView) findViewById(a.f.conver_imageView);
        this.bty = findViewById(a.f.iv_goods_explain_close);
        this.btx = (TextView) findViewById(a.f.tv_goods_title);
        this.btw = (TextView) findViewById(a.f.price_textView);
        this.btz = (FrameLayout) findViewById(a.f.fl_iv_container);
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
