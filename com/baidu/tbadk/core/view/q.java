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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class q extends LinearLayout {
    private static /* synthetic */ int[] aby;
    private TbImageView abl;
    private TextView abm;
    private TextView abn;
    private TextView abo;
    private TextView abp;
    private TextView abq;
    private TextView abr;
    private String abt;
    private String abu;
    private View abv;
    private NoDataViewFactory.ImgType abw;
    private int abx;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] uW() {
        int[] iArr = aby;
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
            aby = iArr;
        }
        return iArr;
    }

    public q(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(t.h.no_data_view, this);
        this.abl = (TbImageView) this.mRootView.findViewById(t.g.iv_no_data_img);
        this.abl.setDefaultBgResource(0);
        this.abl.setDefaultResource(0);
        this.abl.setDefaultErrorResource(0);
        this.abm = (TextView) this.mRootView.findViewById(t.g.tv_text_reamrk);
        this.abn = (TextView) this.mRootView.findViewById(t.g.tv_subtitle);
        this.abo = (TextView) this.mRootView.findViewById(t.g.tv_title);
        this.abp = (TextView) this.mRootView.findViewById(t.g.btn_func);
        this.abv = (LinearLayout) this.mRootView.findViewById(t.g.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ae(i == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this);
        }
        if (this.abw == NoDataViewFactory.ImgType.WEBVIEW) {
            this.abl.setImageBitmap(com.baidu.tbadk.core.util.at.cC(t.f.pic_emotion08));
        } else if (this.abw == NoDataViewFactory.ImgType.NODATA) {
            this.abl.setImageBitmap(com.baidu.tbadk.core.util.at.cC(t.f.no_data_image));
        } else if (this.abw == NoDataViewFactory.ImgType.LOCAL) {
            this.abl.setImageBitmap(com.baidu.tbadk.core.util.at.cC(this.abx));
        } else if (i == 1) {
            this.abl.c(this.abu, 29, false);
        } else {
            this.abl.c(this.abt, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.abo.setText(dVar.mTitle);
                this.abo.setVisibility(0);
            } else {
                this.abo.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.NJ)) {
                this.abn.setText(dVar.NJ);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.abn.setTextSize(0, getResources().getDimension(t.e.fontsize28));
                    if (dVar.abH >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.abn.getLayoutParams();
                        layoutParams.topMargin = dVar.abH;
                        this.abn.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.Ta != 0) {
                    setSubTitleCompoundDrawable(dVar.Ta);
                }
            } else {
                this.abn.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.abG)) {
                this.abm.setText(dVar.abG);
                this.abm.setVisibility(0);
                return;
            }
            this.abm.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.abw = cVar.abD;
            this.abx = cVar.abx;
            switch (uW()[cVar.abD.ordinal()]) {
                case 2:
                    this.abt = com.baidu.tbadk.util.b.Fm().gf("pic_emotion03.png");
                    this.abu = com.baidu.tbadk.util.b.Fm().gf("pic_emotion03_1.png");
                    break;
                case 3:
                    this.abt = com.baidu.tbadk.util.b.Fm().gf("pic_emotion05.png");
                    this.abu = com.baidu.tbadk.util.b.Fm().gf("pic_emotion05_1.png");
                    break;
                case 4:
                    this.abt = com.baidu.tbadk.util.b.Fm().gf("pic_emotion01.png");
                    this.abu = com.baidu.tbadk.util.b.Fm().gf("pic_emotion01_1.png");
                    break;
                case 5:
                    this.abt = com.baidu.tbadk.util.b.Fm().gf("pic_emotion02.png");
                    this.abu = com.baidu.tbadk.util.b.Fm().gf("pic_emotion02_1.png");
                    break;
                case 6:
                    this.abt = com.baidu.tbadk.util.b.Fm().gf("pic_emotion06.png");
                    this.abu = com.baidu.tbadk.util.b.Fm().gf("pic_emotion06_1.png");
                    break;
                case 7:
                    this.abt = com.baidu.tbadk.util.b.Fm().gf("pic_emotion07.png");
                    this.abu = com.baidu.tbadk.util.b.Fm().gf("pic_emotion07_1.png");
                    break;
                case 8:
                    this.abt = com.baidu.tbadk.util.b.Fm().gf("pic_emotion08.png");
                    this.abu = com.baidu.tbadk.util.b.Fm().gf("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.abl.getLayoutParams();
            if (cVar.abE >= 0) {
                layoutParams.setMargins(0, cVar.abE, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.abl.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.abp.setVisibility(8);
            this.abv.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.abA;
        NoDataViewFactory.a aVar2 = bVar.abB;
        if (aVar2 == null && aVar != null) {
            this.abp.setOnClickListener(aVar.abz);
            this.abp.setText(aVar.VC);
            this.abp.setVisibility(0);
            if (bVar.abC >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.abp.getLayoutParams();
                layoutParams.topMargin = bVar.abC;
                this.abp.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.abq = (TextView) this.abv.findViewById(t.g.btn_left);
            this.abr = (TextView) this.abv.findViewById(t.g.btn_right);
            this.abq.setOnClickListener(aVar.abz);
            this.abq.setText(aVar.VC);
            this.abr.setOnClickListener(aVar2.abz);
            this.abr.setText(aVar2.VC);
            this.abv.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.h<?> hVar) {
        onChangeSkinType(hVar, TbadkCoreApplication.m11getInst().getSkinType());
    }

    public void onActivityStop() {
        this.abl.setImageDrawable(null);
        this.abl.c(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.abo != null) {
            com.baidu.tbadk.core.util.at.c(this.abo, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.abn != null) {
            com.baidu.tbadk.core.util.at.c(this.abn, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.abm != null) {
            com.baidu.tbadk.core.util.at.c(this.abm, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = com.baidu.tbadk.core.util.at.getDrawable(i);
        int c = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds32);
        int c2 = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds8);
        drawable.setBounds(0, 0, c, c);
        this.abn.setCompoundDrawablePadding(c2);
        this.abn.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.abn;
    }
}
