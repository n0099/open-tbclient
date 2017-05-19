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
    private static /* synthetic */ int[] akb;
    private TbImageView ajP;
    private TextView ajQ;
    private TextView ajR;
    private TextView ajS;
    private TextView ajT;
    private TextView ajU;
    private TextView ajV;
    private String ajW;
    private String ajX;
    private View ajY;
    private NoDataViewFactory.ImgType ajZ;
    private int aka;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] wg() {
        int[] iArr = akb;
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
            akb = iArr;
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
        this.ajP = (TbImageView) this.mRootView.findViewById(w.h.iv_no_data_img);
        this.ajP.setDefaultBgResource(0);
        this.ajP.setDefaultResource(0);
        this.ajP.setDefaultErrorResource(0);
        this.ajQ = (TextView) this.mRootView.findViewById(w.h.tv_text_reamrk);
        this.ajR = (TextView) this.mRootView.findViewById(w.h.tv_subtitle);
        this.ajS = (TextView) this.mRootView.findViewById(w.h.tv_title);
        this.ajT = (TextView) this.mRootView.findViewById(w.h.btn_func);
        this.ajY = (LinearLayout) this.mRootView.findViewById(w.h.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.g<?> gVar, int i) {
        if (gVar instanceof TbPageContext) {
            ((TbPageContext) gVar).getLayoutMode().ai(i == 1);
            ((TbPageContext) gVar).getLayoutMode().t(this);
        }
        if (this.ajZ == NoDataViewFactory.ImgType.WEBVIEW) {
            this.ajP.setImageBitmap(com.baidu.tbadk.core.util.aq.cN(w.g.pic_emotion08));
        } else if (this.ajZ == NoDataViewFactory.ImgType.NODATA) {
            this.ajP.setImageBitmap(com.baidu.tbadk.core.util.aq.cN(w.g.no_data_image));
        } else if (this.ajZ == NoDataViewFactory.ImgType.LOCAL) {
            this.ajP.setImageBitmap(com.baidu.tbadk.core.util.aq.cN(this.aka));
        } else if (i == 1) {
            this.ajP.c(this.ajX, 29, false);
        } else {
            this.ajP.c(this.ajW, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.ajS.setText(dVar.mTitle);
                this.ajS.setVisibility(0);
            } else {
                this.ajS.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.ajR.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.ajR.setTextSize(0, getResources().getDimension(w.f.fontsize28));
                    if (dVar.akk >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajR.getLayoutParams();
                        layoutParams.topMargin = dVar.akk;
                        this.ajR.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.abi != 0) {
                    setSubTitleCompoundDrawable(dVar.abi);
                }
            } else {
                this.ajR.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.akj)) {
                this.ajQ.setText(dVar.akj);
                this.ajQ.setVisibility(0);
                return;
            }
            this.ajQ.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.ajZ = cVar.akg;
            this.aka = cVar.aka;
            switch (wg()[cVar.akg.ordinal()]) {
                case 2:
                    this.ajW = com.baidu.tbadk.util.b.Gj().ga("pic_emotion03.png");
                    this.ajX = com.baidu.tbadk.util.b.Gj().ga("pic_emotion03_1.png");
                    break;
                case 3:
                    this.ajW = com.baidu.tbadk.util.b.Gj().ga("pic_emotion05.png");
                    this.ajX = com.baidu.tbadk.util.b.Gj().ga("pic_emotion05_1.png");
                    break;
                case 4:
                    this.ajW = com.baidu.tbadk.util.b.Gj().ga("pic_emotion01.png");
                    this.ajX = com.baidu.tbadk.util.b.Gj().ga("pic_emotion01_1.png");
                    break;
                case 5:
                    this.ajW = com.baidu.tbadk.util.b.Gj().ga("pic_emotion02.png");
                    this.ajX = com.baidu.tbadk.util.b.Gj().ga("pic_emotion02_1.png");
                    break;
                case 6:
                    this.ajW = com.baidu.tbadk.util.b.Gj().ga("pic_emotion06.png");
                    this.ajX = com.baidu.tbadk.util.b.Gj().ga("pic_emotion06_1.png");
                    break;
                case 7:
                    this.ajW = com.baidu.tbadk.util.b.Gj().ga("pic_emotion07.png");
                    this.ajX = com.baidu.tbadk.util.b.Gj().ga("pic_emotion07_1.png");
                    break;
                case 8:
                    this.ajW = com.baidu.tbadk.util.b.Gj().ga("pic_emotion08.png");
                    this.ajX = com.baidu.tbadk.util.b.Gj().ga("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajP.getLayoutParams();
            if (cVar.akh >= 0) {
                layoutParams.setMargins(0, cVar.akh, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.ajP.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.ajT.setVisibility(8);
            this.ajY.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.akd;
        NoDataViewFactory.a aVar2 = bVar.ake;
        if (aVar2 == null && aVar != null) {
            this.ajT.setOnClickListener(aVar.akc);
            this.ajT.setText(aVar.adE);
            this.ajT.setVisibility(0);
            if (bVar.akf >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajT.getLayoutParams();
                layoutParams.topMargin = bVar.akf;
                this.ajT.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.ajU = (TextView) this.ajY.findViewById(w.h.btn_left);
            this.ajV = (TextView) this.ajY.findViewById(w.h.btn_right);
            this.ajU.setOnClickListener(aVar.akc);
            this.ajU.setText(aVar.adE);
            this.ajV.setOnClickListener(aVar2.akc);
            this.ajV.setText(aVar2.adE);
            this.ajY.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.g<?> gVar) {
        onChangeSkinType(gVar, TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void onActivityStop() {
        this.ajP.setImageDrawable(null);
        this.ajP.c(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.ajS != null) {
            com.baidu.tbadk.core.util.aq.c(this.ajS, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.ajR != null) {
            com.baidu.tbadk.core.util.aq.c(this.ajR, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.ajQ != null) {
            com.baidu.tbadk.core.util.aq.c(this.ajQ, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = com.baidu.tbadk.core.util.aq.getDrawable(i);
        int g = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
        int g2 = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
        drawable.setBounds(0, 0, g, g);
        this.ajR.setCompoundDrawablePadding(g2);
        this.ajR.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.ajR;
    }
}
