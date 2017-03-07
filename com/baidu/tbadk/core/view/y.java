package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class y extends LinearLayout {
    private static /* synthetic */ int[] akp;
    private TbImageView akd;
    private TextView ake;
    private TextView akf;
    private TextView akg;
    private TextView akh;
    private TextView aki;
    private TextView akj;
    private String akk;
    private String akl;
    private View akm;
    private NoDataViewFactory.ImgType akn;
    private int ako;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] wx() {
        int[] iArr = akp;
        if (iArr == null) {
            iArr = new int[NoDataViewFactory.ImgType.valuesCustom().length];
            try {
                iArr[NoDataViewFactory.ImgType.CREATE.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.EMOTION.ordinal()] = 5;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.FINDBAR.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.GIFT.ordinal()] = 7;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.LOCAL.ordinal()] = 9;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.NODATA.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.SINGALL.ordinal()] = 6;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.WEBVIEW.ordinal()] = 8;
            } catch (NoSuchFieldError e9) {
            }
            akp = iArr;
        }
        return iArr;
    }

    public y(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(w.j.no_data_view, this);
        this.akd = (TbImageView) this.mRootView.findViewById(w.h.iv_no_data_img);
        this.akd.setDefaultBgResource(0);
        this.akd.setDefaultResource(0);
        this.akd.setDefaultErrorResource(0);
        this.ake = (TextView) this.mRootView.findViewById(w.h.tv_text_reamrk);
        this.akf = (TextView) this.mRootView.findViewById(w.h.tv_subtitle);
        this.akg = (TextView) this.mRootView.findViewById(w.h.tv_title);
        this.akh = (TextView) this.mRootView.findViewById(w.h.btn_func);
        this.akm = (LinearLayout) this.mRootView.findViewById(w.h.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.g<?> gVar, int i) {
        if (gVar instanceof TbPageContext) {
            ((TbPageContext) gVar).getLayoutMode().ah(i == 1);
            ((TbPageContext) gVar).getLayoutMode().t(this);
        }
        if (this.akn == NoDataViewFactory.ImgType.WEBVIEW) {
            this.akd.setImageBitmap(com.baidu.tbadk.core.util.aq.cN(w.g.pic_emotion08));
        } else if (this.akn == NoDataViewFactory.ImgType.NODATA) {
            this.akd.setImageBitmap(com.baidu.tbadk.core.util.aq.cN(w.g.no_data_image));
        } else if (this.akn == NoDataViewFactory.ImgType.LOCAL) {
            this.akd.setImageBitmap(com.baidu.tbadk.core.util.aq.cN(this.ako));
        } else if (i == 1) {
            this.akd.c(this.akl, 29, false);
        } else {
            this.akd.c(this.akk, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.akg.setText(dVar.mTitle);
                this.akg.setVisibility(0);
            } else {
                this.akg.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.akf.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.akf.setTextSize(0, getResources().getDimension(w.f.fontsize28));
                    if (dVar.aky >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akf.getLayoutParams();
                        layoutParams.topMargin = dVar.aky;
                        this.akf.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.aby != 0) {
                    setSubTitleCompoundDrawable(dVar.aby);
                }
            } else {
                this.akf.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.akx)) {
                this.ake.setText(dVar.akx);
                this.ake.setVisibility(0);
                return;
            }
            this.ake.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.akn = cVar.aku;
            this.ako = cVar.ako;
            switch (wx()[cVar.aku.ordinal()]) {
                case 2:
                    this.akk = com.baidu.tbadk.util.b.GG().fX("pic_emotion03.png");
                    this.akl = com.baidu.tbadk.util.b.GG().fX("pic_emotion03_1.png");
                    break;
                case 3:
                    this.akk = com.baidu.tbadk.util.b.GG().fX("pic_emotion05.png");
                    this.akl = com.baidu.tbadk.util.b.GG().fX("pic_emotion05_1.png");
                    break;
                case 4:
                    this.akk = com.baidu.tbadk.util.b.GG().fX("pic_emotion01.png");
                    this.akl = com.baidu.tbadk.util.b.GG().fX("pic_emotion01_1.png");
                    break;
                case 5:
                    this.akk = com.baidu.tbadk.util.b.GG().fX("pic_emotion02.png");
                    this.akl = com.baidu.tbadk.util.b.GG().fX("pic_emotion02_1.png");
                    break;
                case 6:
                    this.akk = com.baidu.tbadk.util.b.GG().fX("pic_emotion06.png");
                    this.akl = com.baidu.tbadk.util.b.GG().fX("pic_emotion06_1.png");
                    break;
                case 7:
                    this.akk = com.baidu.tbadk.util.b.GG().fX("pic_emotion07.png");
                    this.akl = com.baidu.tbadk.util.b.GG().fX("pic_emotion07_1.png");
                    break;
                case 8:
                    this.akk = com.baidu.tbadk.util.b.GG().fX("pic_emotion08.png");
                    this.akl = com.baidu.tbadk.util.b.GG().fX("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akd.getLayoutParams();
            if (cVar.akv >= 0) {
                layoutParams.setMargins(0, cVar.akv, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.akd.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.akh.setVisibility(8);
            this.akm.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.akr;
        NoDataViewFactory.a aVar2 = bVar.aks;
        if (aVar2 == null && aVar != null) {
            this.akh.setOnClickListener(aVar.akq);
            this.akh.setText(aVar.adX);
            this.akh.setVisibility(0);
            if (bVar.akt >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akh.getLayoutParams();
                layoutParams.topMargin = bVar.akt;
                this.akh.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.aki = (TextView) this.akm.findViewById(w.h.btn_left);
            this.akj = (TextView) this.akm.findViewById(w.h.btn_right);
            this.aki.setOnClickListener(aVar.akq);
            this.aki.setText(aVar.adX);
            this.akj.setOnClickListener(aVar2.akq);
            this.akj.setText(aVar2.adX);
            this.akm.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.g<?> gVar) {
        onChangeSkinType(gVar, TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void onActivityStop() {
        this.akd.setImageDrawable(null);
        this.akd.c(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.akg != null) {
            com.baidu.tbadk.core.util.aq.c(this.akg, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.akf != null) {
            com.baidu.tbadk.core.util.aq.c(this.akf, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.ake != null) {
            com.baidu.tbadk.core.util.aq.c(this.ake, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = com.baidu.tbadk.core.util.aq.getDrawable(i);
        int g = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
        int g2 = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
        drawable.setBounds(0, 0, g, g);
        this.akf.setCompoundDrawablePadding(g2);
        this.akf.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.akf;
    }
}
