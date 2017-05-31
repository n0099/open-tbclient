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
    private static /* synthetic */ int[] ajR;
    private TbImageView ajF;
    private TextView ajG;
    private TextView ajH;
    private TextView ajI;
    private TextView ajJ;
    private TextView ajK;
    private TextView ajL;
    private String ajM;
    private String ajN;
    private View ajO;
    private NoDataViewFactory.ImgType ajP;
    private int ajQ;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] wd() {
        int[] iArr = ajR;
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
            ajR = iArr;
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
        this.ajF = (TbImageView) this.mRootView.findViewById(w.h.iv_no_data_img);
        this.ajF.setDefaultBgResource(0);
        this.ajF.setDefaultResource(0);
        this.ajF.setDefaultErrorResource(0);
        this.ajG = (TextView) this.mRootView.findViewById(w.h.tv_text_reamrk);
        this.ajH = (TextView) this.mRootView.findViewById(w.h.tv_subtitle);
        this.ajI = (TextView) this.mRootView.findViewById(w.h.tv_title);
        this.ajJ = (TextView) this.mRootView.findViewById(w.h.btn_func);
        this.ajO = (LinearLayout) this.mRootView.findViewById(w.h.two_button_layout);
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
        if (this.ajP == NoDataViewFactory.ImgType.WEBVIEW) {
            this.ajF.setImageBitmap(com.baidu.tbadk.core.util.aq.cO(w.g.pic_emotion08));
        } else if (this.ajP == NoDataViewFactory.ImgType.NODATA) {
            this.ajF.setImageBitmap(com.baidu.tbadk.core.util.aq.cO(w.g.no_data_image));
        } else if (this.ajP == NoDataViewFactory.ImgType.LOCAL) {
            this.ajF.setImageBitmap(com.baidu.tbadk.core.util.aq.cO(this.ajQ));
        } else if (i == 1) {
            this.ajF.c(this.ajN, 29, false);
        } else {
            this.ajF.c(this.ajM, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.ajI.setText(dVar.mTitle);
                this.ajI.setVisibility(0);
            } else {
                this.ajI.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.ajH.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.ajH.setTextSize(0, getResources().getDimension(w.f.fontsize28));
                    if (dVar.aka >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajH.getLayoutParams();
                        layoutParams.topMargin = dVar.aka;
                        this.ajH.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.abh != 0) {
                    setSubTitleCompoundDrawable(dVar.abh);
                }
            } else {
                this.ajH.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.ajZ)) {
                this.ajG.setText(dVar.ajZ);
                this.ajG.setVisibility(0);
                return;
            }
            this.ajG.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.ajP = cVar.ajW;
            this.ajQ = cVar.ajQ;
            switch (wd()[cVar.ajW.ordinal()]) {
                case 2:
                    this.ajM = com.baidu.tbadk.util.b.Gd().fZ("pic_emotion03.png");
                    this.ajN = com.baidu.tbadk.util.b.Gd().fZ("pic_emotion03_1.png");
                    break;
                case 3:
                    this.ajM = com.baidu.tbadk.util.b.Gd().fZ("pic_emotion05.png");
                    this.ajN = com.baidu.tbadk.util.b.Gd().fZ("pic_emotion05_1.png");
                    break;
                case 4:
                    this.ajM = com.baidu.tbadk.util.b.Gd().fZ("pic_emotion01.png");
                    this.ajN = com.baidu.tbadk.util.b.Gd().fZ("pic_emotion01_1.png");
                    break;
                case 5:
                    this.ajM = com.baidu.tbadk.util.b.Gd().fZ("pic_emotion02.png");
                    this.ajN = com.baidu.tbadk.util.b.Gd().fZ("pic_emotion02_1.png");
                    break;
                case 6:
                    this.ajM = com.baidu.tbadk.util.b.Gd().fZ("pic_emotion06.png");
                    this.ajN = com.baidu.tbadk.util.b.Gd().fZ("pic_emotion06_1.png");
                    break;
                case 7:
                    this.ajM = com.baidu.tbadk.util.b.Gd().fZ("pic_emotion07.png");
                    this.ajN = com.baidu.tbadk.util.b.Gd().fZ("pic_emotion07_1.png");
                    break;
                case 8:
                    this.ajM = com.baidu.tbadk.util.b.Gd().fZ("pic_emotion08.png");
                    this.ajN = com.baidu.tbadk.util.b.Gd().fZ("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajF.getLayoutParams();
            if (cVar.ajX >= 0) {
                layoutParams.setMargins(0, cVar.ajX, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.ajF.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.ajJ.setVisibility(8);
            this.ajO.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.ajT;
        NoDataViewFactory.a aVar2 = bVar.ajU;
        if (aVar2 == null && aVar != null) {
            this.ajJ.setOnClickListener(aVar.ajS);
            this.ajJ.setText(aVar.adw);
            this.ajJ.setVisibility(0);
            if (bVar.ajV >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajJ.getLayoutParams();
                layoutParams.topMargin = bVar.ajV;
                this.ajJ.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.ajK = (TextView) this.ajO.findViewById(w.h.btn_left);
            this.ajL = (TextView) this.ajO.findViewById(w.h.btn_right);
            this.ajK.setOnClickListener(aVar.ajS);
            this.ajK.setText(aVar.adw);
            this.ajL.setOnClickListener(aVar2.ajS);
            this.ajL.setText(aVar2.adw);
            this.ajO.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.g<?> gVar) {
        onChangeSkinType(gVar, TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void onActivityStop() {
        this.ajF.setImageDrawable(null);
        this.ajF.c(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.ajI != null) {
            com.baidu.tbadk.core.util.aq.c(this.ajI, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.ajH != null) {
            com.baidu.tbadk.core.util.aq.c(this.ajH, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.ajG != null) {
            com.baidu.tbadk.core.util.aq.c(this.ajG, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = com.baidu.tbadk.core.util.aq.getDrawable(i);
        int g = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
        int g2 = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
        drawable.setBounds(0, 0, g, g);
        this.ajH.setCompoundDrawablePadding(g2);
        this.ajH.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.ajH;
    }
}
