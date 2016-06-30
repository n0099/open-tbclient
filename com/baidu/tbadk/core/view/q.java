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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class q extends LinearLayout {
    private static /* synthetic */ int[] abS;
    private TbImageView abG;
    private TextView abH;
    private TextView abI;
    private TextView abJ;
    private TextView abK;
    private TextView abL;
    private TextView abM;
    private String abN;
    private String abO;
    private View abP;
    private NoDataViewFactory.ImgType abQ;
    private int abR;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] uX() {
        int[] iArr = abS;
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
            abS = iArr;
        }
        return iArr;
    }

    public q(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(u.h.no_data_view, this);
        this.abG = (TbImageView) this.mRootView.findViewById(u.g.iv_no_data_img);
        this.abG.setDefaultBgResource(0);
        this.abG.setDefaultResource(0);
        this.abG.setDefaultErrorResource(0);
        this.abH = (TextView) this.mRootView.findViewById(u.g.tv_text_reamrk);
        this.abI = (TextView) this.mRootView.findViewById(u.g.tv_subtitle);
        this.abJ = (TextView) this.mRootView.findViewById(u.g.tv_title);
        this.abK = (TextView) this.mRootView.findViewById(u.g.btn_func);
        this.abP = (LinearLayout) this.mRootView.findViewById(u.g.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ad(i == 1);
            ((TbPageContext) hVar).getLayoutMode().w(this);
        }
        if (this.abQ == NoDataViewFactory.ImgType.WEBVIEW) {
            this.abG.setImageBitmap(av.cC(u.f.pic_emotion08));
        } else if (this.abQ == NoDataViewFactory.ImgType.NODATA) {
            this.abG.setImageBitmap(av.cC(u.f.no_data_image));
        } else if (this.abQ == NoDataViewFactory.ImgType.LOCAL) {
            this.abG.setImageBitmap(av.cC(this.abR));
        } else if (i == 1) {
            this.abG.c(this.abO, 29, false);
        } else {
            this.abG.c(this.abN, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.abJ.setText(dVar.mTitle);
                this.abJ.setVisibility(0);
            } else {
                this.abJ.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.NI)) {
                this.abI.setText(dVar.NI);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.abI.setTextSize(0, getResources().getDimension(u.e.fontsize28));
                    if (dVar.acb >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.abI.getLayoutParams();
                        layoutParams.topMargin = dVar.acb;
                        this.abI.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.Tr != 0) {
                    setSubTitleCompoundDrawable(dVar.Tr);
                }
            } else {
                this.abI.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.aca)) {
                this.abH.setText(dVar.aca);
                this.abH.setVisibility(0);
                return;
            }
            this.abH.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.abQ = cVar.abX;
            this.abR = cVar.abR;
            switch (uX()[cVar.abX.ordinal()]) {
                case 2:
                    this.abN = com.baidu.tbadk.util.b.Fw().gl("pic_emotion03.png");
                    this.abO = com.baidu.tbadk.util.b.Fw().gl("pic_emotion03_1.png");
                    break;
                case 3:
                    this.abN = com.baidu.tbadk.util.b.Fw().gl("pic_emotion05.png");
                    this.abO = com.baidu.tbadk.util.b.Fw().gl("pic_emotion05_1.png");
                    break;
                case 4:
                    this.abN = com.baidu.tbadk.util.b.Fw().gl("pic_emotion01.png");
                    this.abO = com.baidu.tbadk.util.b.Fw().gl("pic_emotion01_1.png");
                    break;
                case 5:
                    this.abN = com.baidu.tbadk.util.b.Fw().gl("pic_emotion02.png");
                    this.abO = com.baidu.tbadk.util.b.Fw().gl("pic_emotion02_1.png");
                    break;
                case 6:
                    this.abN = com.baidu.tbadk.util.b.Fw().gl("pic_emotion06.png");
                    this.abO = com.baidu.tbadk.util.b.Fw().gl("pic_emotion06_1.png");
                    break;
                case 7:
                    this.abN = com.baidu.tbadk.util.b.Fw().gl("pic_emotion07.png");
                    this.abO = com.baidu.tbadk.util.b.Fw().gl("pic_emotion07_1.png");
                    break;
                case 8:
                    this.abN = com.baidu.tbadk.util.b.Fw().gl("pic_emotion08.png");
                    this.abO = com.baidu.tbadk.util.b.Fw().gl("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.abG.getLayoutParams();
            if (cVar.abY >= 0) {
                layoutParams.setMargins(0, cVar.abY, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.abG.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.abK.setVisibility(8);
            this.abP.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.abU;
        NoDataViewFactory.a aVar2 = bVar.abV;
        if (aVar2 == null && aVar != null) {
            this.abK.setOnClickListener(aVar.abT);
            this.abK.setText(aVar.VS);
            this.abK.setVisibility(0);
            if (bVar.abW >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.abK.getLayoutParams();
                layoutParams.topMargin = bVar.abW;
                this.abK.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.abL = (TextView) this.abP.findViewById(u.g.btn_left);
            this.abM = (TextView) this.abP.findViewById(u.g.btn_right);
            this.abL.setOnClickListener(aVar.abT);
            this.abL.setText(aVar.VS);
            this.abM.setOnClickListener(aVar2.abT);
            this.abM.setText(aVar2.VS);
            this.abP.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.h<?> hVar) {
        onChangeSkinType(hVar, TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void onActivityStop() {
        this.abG.setImageDrawable(null);
        this.abG.c(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.abJ != null) {
            av.c(this.abJ, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.abI != null) {
            av.c(this.abI, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.abH != null) {
            av.c(this.abH, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = av.getDrawable(i);
        int c = com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds32);
        int c2 = com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds8);
        drawable.setBounds(0, 0, c, c);
        this.abI.setCompoundDrawablePadding(c2);
        this.abI.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.abI;
    }
}
