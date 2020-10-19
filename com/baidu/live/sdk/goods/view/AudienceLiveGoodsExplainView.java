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
    private com.baidu.live.sdk.goods.a.a bpx;
    private float bqh;
    private float bqi;
    private float bqj;
    private float bqk;
    private BdRoundedImageView bql;
    private TextView bqm;
    private TextView bqn;
    private View bqo;
    private FrameLayout bqp;
    private a bqq;
    private Activity mActivity;

    /* loaded from: classes4.dex */
    public interface a {
        void a(View view, com.baidu.live.sdk.goods.a.a aVar);
    }

    public AudienceLiveGoodsExplainView(Activity activity) {
        super(activity);
        this.mActivity = activity;
        this.bqh = this.mActivity.getResources().getDimension(a.e.sdk_ds20);
        this.bqj = this.mActivity.getResources().getDimension(a.e.sdk_ds196);
        OP();
    }

    public void setOnCloseBtnClickListener(a aVar) {
        this.bqq = aVar;
    }

    public void f(com.baidu.live.sdk.goods.a.a aVar) {
        if (aVar != null) {
            this.bpx = aVar;
            this.bqn.setText(this.bpx.title);
            this.bqm.setText(this.bpx.price);
            ImageLoaderManager.getInstance().buildImageLoader().loadImage(this.bpx.imageUrl, new IImageLoaderListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.1
                @Override // com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderListener
                public void onLoadComplete(String str, Bitmap bitmap) {
                    AudienceLiveGoodsExplainView.this.bql.setImageBitmap(bitmap);
                }
            });
            this.bqo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AudienceLiveGoodsExplainView.this.bqq != null) {
                        AudienceLiveGoodsExplainView.this.bqq.a(view, AudienceLiveGoodsExplainView.this.bpx);
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
                this.bqi = realScreenHeight * 0.3f;
            } else {
                this.bqi = realScreenWidth * 0.3f;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = (int) this.bqh;
            layoutParams.leftMargin = (int) this.bqh;
            if (this.bqi < (this.bqh * 2.0f) + this.bqj) {
                this.bqk = this.bqi - (this.bqh * 2.0f);
            } else {
                this.bqk = this.bqj;
            }
            ViewGroup.LayoutParams layoutParams2 = this.bqp.getLayoutParams();
            layoutParams2.width = (int) this.bqk;
            layoutParams2.height = (int) this.bqk;
            pendantParentView.a(this, layoutParams);
        }
    }

    private void OP() {
        this.mActivity.getLayoutInflater().inflate(a.h.ala_sdk_goods_explain, this);
        this.bql = (BdRoundedImageView) findViewById(a.g.conver_imageView);
        this.bqo = findViewById(a.g.iv_goods_explain_close);
        this.bqn = (TextView) findViewById(a.g.tv_goods_title);
        this.bqm = (TextView) findViewById(a.g.price_textView);
        this.bqp = (FrameLayout) findViewById(a.g.fl_iv_container);
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
