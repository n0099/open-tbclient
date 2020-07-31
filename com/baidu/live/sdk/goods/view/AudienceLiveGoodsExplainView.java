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
/* loaded from: classes4.dex */
public class AudienceLiveGoodsExplainView extends PendantChildView {
    private float bdW;
    private float bdX;
    private float bdY;
    private float bdZ;
    private com.baidu.live.sdk.goods.a.a bdk;
    private BdRoundedImageView bea;
    private TextView beb;
    private TextView bec;
    private View bed;
    private FrameLayout bee;
    private a bef;
    private Activity mActivity;

    /* loaded from: classes4.dex */
    public interface a {
        void a(View view, com.baidu.live.sdk.goods.a.a aVar);
    }

    public AudienceLiveGoodsExplainView(Activity activity) {
        super(activity);
        this.mActivity = activity;
        this.bdX = ScreenHelper.getRealScreenWidth(this.mActivity) * 0.3f;
        this.bdW = this.mActivity.getResources().getDimension(a.e.sdk_ds20);
        this.bdY = this.mActivity.getResources().getDimension(a.e.sdk_ds196);
        Hp();
    }

    public void setOnCloseBtnClickListener(a aVar) {
        this.bef = aVar;
    }

    public void d(com.baidu.live.sdk.goods.a.a aVar) {
        if (aVar != null) {
            this.bdk = aVar;
            this.bec.setText(this.bdk.title);
            this.beb.setText(this.bdk.price);
            ImageLoaderManager.getInstance().buildImageLoader().loadImage(this.bdk.imageUrl, new IImageLoaderListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.1
                @Override // com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderListener
                public void onLoadComplete(String str, Bitmap bitmap) {
                    AudienceLiveGoodsExplainView.this.bea.setImageBitmap(bitmap);
                }
            });
            this.bed.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AudienceLiveGoodsExplainView.this.bef != null) {
                        AudienceLiveGoodsExplainView.this.bef.a(view, AudienceLiveGoodsExplainView.this.bdk);
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
            layoutParams.rightMargin = (int) this.bdW;
            layoutParams.leftMargin = (int) this.bdW;
            if (this.bdX < (this.bdW * 2.0f) + this.bdY) {
                this.bdZ = this.bdX - (this.bdW * 2.0f);
            } else {
                this.bdZ = this.bdX;
            }
            ViewGroup.LayoutParams layoutParams2 = this.bee.getLayoutParams();
            layoutParams2.width = (int) this.bdZ;
            layoutParams2.height = (int) this.bdZ;
            pendantParentView.a(this, layoutParams);
        }
    }

    private void Hp() {
        this.mActivity.getLayoutInflater().inflate(a.h.ala_sdk_goods_explain, this);
        this.bea = (BdRoundedImageView) findViewById(a.g.conver_imageView);
        this.bed = findViewById(a.g.iv_goods_explain_close);
        this.bec = (TextView) findViewById(a.g.tv_goods_title);
        this.beb = (TextView) findViewById(a.g.price_textView);
        this.bee = (FrameLayout) findViewById(a.g.fl_iv_container);
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
