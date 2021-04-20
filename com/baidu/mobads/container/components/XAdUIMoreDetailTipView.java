package com.baidu.mobads.container.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.util.AdResource;
import com.baidu.mobads.container.util.ScreenUtils;
/* loaded from: classes2.dex */
public class XAdUIMoreDetailTipView extends RelativeLayout {
    public Context context;
    public ImageView mImageView;
    public int parentViewId;

    public XAdUIMoreDetailTipView(XAdContainerContext xAdContainerContext, int i, int i2) {
        super(xAdContainerContext.getAdProdBase().getContext());
        Bitmap lp;
        this.parentViewId = 10;
        this.parentViewId = i2;
        this.context = xAdContainerContext.getAdProdBase().getContext();
        setGravity(17);
        this.mImageView = new ImageView(this.context);
        if (i == 2) {
            lp = AdResource.getDL();
        } else {
            lp = AdResource.getLP();
        }
        try {
            ImageView.class.getMethod("setBackground", BitmapDrawable.class).invoke(this.mImageView, new BitmapDrawable(this.context.getResources(), lp));
        } catch (Exception unused) {
            this.mImageView.setBackgroundDrawable(new BitmapDrawable(this.context.getResources(), lp));
        }
        this.mImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.mImageView);
        initLayout(xAdContainerContext);
    }

    private void initLayout(XAdContainerContext xAdContainerContext) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenUtils.getPixel(xAdContainerContext.getActivity(), (int) Math.round(77.0d)), ScreenUtils.getPixel(xAdContainerContext.getActivity(), (int) Math.round(33.0d)));
        layoutParams.addRule(11, this.parentViewId);
        layoutParams.addRule(12, this.parentViewId);
        layoutParams.rightMargin = ScreenUtils.getPixel(xAdContainerContext.getActivity(), 30);
        layoutParams.bottomMargin = ScreenUtils.getPixel(xAdContainerContext.getActivity(), 10);
        setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
