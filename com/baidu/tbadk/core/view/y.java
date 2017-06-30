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
    private static /* synthetic */ int[] akE;
    private String akA;
    private View akB;
    private NoDataViewFactory.ImgType akC;
    private int akD;
    private TbImageView aks;
    private TextView akt;
    private TextView aku;
    private TextView akv;
    private TextView akw;
    private TextView akx;
    private TextView aky;
    private String akz;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] wv() {
        int[] iArr = akE;
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
            akE = iArr;
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
        this.aks = (TbImageView) this.mRootView.findViewById(w.h.iv_no_data_img);
        this.aks.setDefaultBgResource(0);
        this.aks.setDefaultResource(0);
        this.aks.setDefaultErrorResource(0);
        this.akt = (TextView) this.mRootView.findViewById(w.h.tv_text_reamrk);
        this.aku = (TextView) this.mRootView.findViewById(w.h.tv_subtitle);
        this.akv = (TextView) this.mRootView.findViewById(w.h.tv_title);
        this.akw = (TextView) this.mRootView.findViewById(w.h.btn_func);
        this.akB = (LinearLayout) this.mRootView.findViewById(w.h.two_button_layout);
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
        if (this.akC == NoDataViewFactory.ImgType.WEBVIEW) {
            this.aks.setImageBitmap(com.baidu.tbadk.core.util.as.cQ(w.g.pic_emotion08));
        } else if (this.akC == NoDataViewFactory.ImgType.NODATA) {
            this.aks.setImageBitmap(com.baidu.tbadk.core.util.as.cQ(w.g.no_data_image));
        } else if (this.akC == NoDataViewFactory.ImgType.LOCAL) {
            this.aks.setImageBitmap(com.baidu.tbadk.core.util.as.cQ(this.akD));
        } else if (i == 1) {
            this.aks.c(this.akA, 29, false);
        } else {
            this.aks.c(this.akz, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.akv.setText(dVar.mTitle);
                this.akv.setVisibility(0);
            } else {
                this.akv.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.aku.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.aku.setTextSize(0, getResources().getDimension(w.f.fontsize28));
                    if (dVar.akN >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aku.getLayoutParams();
                        layoutParams.topMargin = dVar.akN;
                        this.aku.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.abi != 0) {
                    setSubTitleCompoundDrawable(dVar.abi);
                }
            } else {
                this.aku.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.akM)) {
                this.akt.setText(dVar.akM);
                this.akt.setVisibility(0);
                return;
            }
            this.akt.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.akC = cVar.akJ;
            this.akD = cVar.akD;
            switch (wv()[cVar.akJ.ordinal()]) {
                case 2:
                    this.akz = com.baidu.tbadk.util.b.GA().gu("pic_emotion03.png");
                    this.akA = com.baidu.tbadk.util.b.GA().gu("pic_emotion03_1.png");
                    break;
                case 3:
                    this.akz = com.baidu.tbadk.util.b.GA().gu("pic_emotion05.png");
                    this.akA = com.baidu.tbadk.util.b.GA().gu("pic_emotion05_1.png");
                    break;
                case 4:
                    this.akz = com.baidu.tbadk.util.b.GA().gu("pic_emotion01.png");
                    this.akA = com.baidu.tbadk.util.b.GA().gu("pic_emotion01_1.png");
                    break;
                case 5:
                    this.akz = com.baidu.tbadk.util.b.GA().gu("pic_emotion02.png");
                    this.akA = com.baidu.tbadk.util.b.GA().gu("pic_emotion02_1.png");
                    break;
                case 6:
                    this.akz = com.baidu.tbadk.util.b.GA().gu("pic_emotion06.png");
                    this.akA = com.baidu.tbadk.util.b.GA().gu("pic_emotion06_1.png");
                    break;
                case 7:
                    this.akz = com.baidu.tbadk.util.b.GA().gu("pic_emotion07.png");
                    this.akA = com.baidu.tbadk.util.b.GA().gu("pic_emotion07_1.png");
                    break;
                case 8:
                    this.akz = com.baidu.tbadk.util.b.GA().gu("pic_emotion08.png");
                    this.akA = com.baidu.tbadk.util.b.GA().gu("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aks.getLayoutParams();
            if (cVar.akK >= 0) {
                layoutParams.setMargins(0, cVar.akK, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.aks.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.akw.setVisibility(8);
            this.akB.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.akG;
        NoDataViewFactory.a aVar2 = bVar.akH;
        if (aVar2 == null && aVar != null) {
            this.akw.setOnClickListener(aVar.akF);
            this.akw.setText(aVar.aef);
            this.akw.setVisibility(0);
            if (bVar.akI >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akw.getLayoutParams();
                layoutParams.topMargin = bVar.akI;
                this.akw.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.akx = (TextView) this.akB.findViewById(w.h.btn_left);
            this.aky = (TextView) this.akB.findViewById(w.h.btn_right);
            this.akx.setOnClickListener(aVar.akF);
            this.akx.setText(aVar.aef);
            this.aky.setOnClickListener(aVar2.akF);
            this.aky.setText(aVar2.aef);
            this.akB.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.g<?> gVar) {
        onChangeSkinType(gVar, TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void onActivityStop() {
        this.aks.setImageDrawable(null);
        this.aks.c(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.akv != null) {
            com.baidu.tbadk.core.util.as.c(this.akv, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.aku != null) {
            com.baidu.tbadk.core.util.as.c(this.aku, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.akt != null) {
            com.baidu.tbadk.core.util.as.c(this.akt, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = com.baidu.tbadk.core.util.as.getDrawable(i);
        int g = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
        int g2 = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
        drawable.setBounds(0, 0, g, g);
        this.aku.setCompoundDrawablePadding(g2);
        this.aku.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.aku;
    }
}
