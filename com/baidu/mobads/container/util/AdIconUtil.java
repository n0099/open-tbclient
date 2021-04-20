package com.baidu.mobads.container.util;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.util.filedownloader.MaterialLoader;
/* loaded from: classes2.dex */
public class AdIconUtil {
    public static final int AD_TEXT_ID = 65541;
    public static final int BAIDU_LOGO_ID = 65542;
    public int mBottom;
    public int mRight;
    public Context mViewContext;

    /* loaded from: classes2.dex */
    public static class AdLogoParameter {
        public int mBottom;
        public int mRight;
        public Context mViewContext;

        public AdIconUtil build(Context context) {
            return new AdIconUtil(context, this);
        }

        public AdLogoParameter setMarginBottom(int i) {
            this.mBottom = i;
            return this;
        }

        public AdLogoParameter setMarginRight(int i) {
            this.mRight = i;
            return this;
        }
    }

    public AdIconUtil(Context context, AdLogoParameter adLogoParameter) {
        this.mViewContext = context;
        this.mRight = adLogoParameter.mRight;
        this.mBottom = adLogoParameter.mBottom;
    }

    public RelativeLayout addAdLogo() {
        RelativeLayout relativeLayout = new RelativeLayout(this.mViewContext);
        ImageView imageView = new ImageView(this.mViewContext);
        imageView.setId(AD_TEXT_ID);
        MaterialLoader.getInstance(this.mViewContext).loadImageForURLString(imageView, "https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(CommonUtils.dip2px(this.mViewContext, 25.0f), CommonUtils.dip2px(this.mViewContext, 13.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, this.mRight, 0, this.mBottom);
        relativeLayout.addView(imageView, layoutParams);
        ImageView imageView2 = new ImageView(this.mViewContext);
        imageView2.setId(BAIDU_LOGO_ID);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        MaterialLoader.getInstance(this.mViewContext).loadImageForURLString(imageView2, "https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png");
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(CommonUtils.dip2px(this.mViewContext, 13.0f), CommonUtils.dip2px(this.mViewContext, 13.0f));
        layoutParams2.addRule(12);
        layoutParams2.addRule(0, AD_TEXT_ID);
        relativeLayout.addView(imageView2, layoutParams2);
        return relativeLayout;
    }
}
