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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class v extends LinearLayout {
    private static /* synthetic */ int[] afR;
    private TbImageView afF;
    private TextView afG;
    private TextView afH;
    private TextView afI;
    private TextView afJ;
    private TextView afK;
    private TextView afL;
    private String afM;
    private String afN;
    private View afO;
    private NoDataViewFactory.ImgType afP;
    private int afQ;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] wr() {
        int[] iArr = afR;
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
            afR = iArr;
        }
        return iArr;
    }

    public v(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(r.h.no_data_view, this);
        this.afF = (TbImageView) this.mRootView.findViewById(r.g.iv_no_data_img);
        this.afF.setDefaultBgResource(0);
        this.afF.setDefaultResource(0);
        this.afF.setDefaultErrorResource(0);
        this.afG = (TextView) this.mRootView.findViewById(r.g.tv_text_reamrk);
        this.afH = (TextView) this.mRootView.findViewById(r.g.tv_subtitle);
        this.afI = (TextView) this.mRootView.findViewById(r.g.tv_title);
        this.afJ = (TextView) this.mRootView.findViewById(r.g.btn_func);
        this.afO = (LinearLayout) this.mRootView.findViewById(r.g.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ah(i == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this);
        }
        if (this.afP == NoDataViewFactory.ImgType.WEBVIEW) {
            this.afF.setImageBitmap(av.cP(r.f.pic_emotion08));
        } else if (this.afP == NoDataViewFactory.ImgType.NODATA) {
            this.afF.setImageBitmap(av.cP(r.f.no_data_image));
        } else if (this.afP == NoDataViewFactory.ImgType.LOCAL) {
            this.afF.setImageBitmap(av.cP(this.afQ));
        } else if (i == 1) {
            this.afF.c(this.afN, 29, false);
        } else {
            this.afF.c(this.afM, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.afI.setText(dVar.mTitle);
                this.afI.setVisibility(0);
            } else {
                this.afI.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.afH.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.afH.setTextSize(0, getResources().getDimension(r.e.fontsize28));
                    if (dVar.aga >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afH.getLayoutParams();
                        layoutParams.topMargin = dVar.aga;
                        this.afH.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.Xc != 0) {
                    setSubTitleCompoundDrawable(dVar.Xc);
                }
            } else {
                this.afH.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.afZ)) {
                this.afG.setText(dVar.afZ);
                this.afG.setVisibility(0);
                return;
            }
            this.afG.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.afP = cVar.afW;
            this.afQ = cVar.afQ;
            switch (wr()[cVar.afW.ordinal()]) {
                case 2:
                    this.afM = com.baidu.tbadk.util.b.GQ().gq("pic_emotion03.png");
                    this.afN = com.baidu.tbadk.util.b.GQ().gq("pic_emotion03_1.png");
                    break;
                case 3:
                    this.afM = com.baidu.tbadk.util.b.GQ().gq("pic_emotion05.png");
                    this.afN = com.baidu.tbadk.util.b.GQ().gq("pic_emotion05_1.png");
                    break;
                case 4:
                    this.afM = com.baidu.tbadk.util.b.GQ().gq("pic_emotion01.png");
                    this.afN = com.baidu.tbadk.util.b.GQ().gq("pic_emotion01_1.png");
                    break;
                case 5:
                    this.afM = com.baidu.tbadk.util.b.GQ().gq("pic_emotion02.png");
                    this.afN = com.baidu.tbadk.util.b.GQ().gq("pic_emotion02_1.png");
                    break;
                case 6:
                    this.afM = com.baidu.tbadk.util.b.GQ().gq("pic_emotion06.png");
                    this.afN = com.baidu.tbadk.util.b.GQ().gq("pic_emotion06_1.png");
                    break;
                case 7:
                    this.afM = com.baidu.tbadk.util.b.GQ().gq("pic_emotion07.png");
                    this.afN = com.baidu.tbadk.util.b.GQ().gq("pic_emotion07_1.png");
                    break;
                case 8:
                    this.afM = com.baidu.tbadk.util.b.GQ().gq("pic_emotion08.png");
                    this.afN = com.baidu.tbadk.util.b.GQ().gq("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afF.getLayoutParams();
            if (cVar.afX >= 0) {
                layoutParams.setMargins(0, cVar.afX, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.afF.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.afJ.setVisibility(8);
            this.afO.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.afT;
        NoDataViewFactory.a aVar2 = bVar.afU;
        if (aVar2 == null && aVar != null) {
            this.afJ.setOnClickListener(aVar.afS);
            this.afJ.setText(aVar.ZC);
            this.afJ.setVisibility(0);
            if (bVar.afV >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afJ.getLayoutParams();
                layoutParams.topMargin = bVar.afV;
                this.afJ.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.afK = (TextView) this.afO.findViewById(r.g.btn_left);
            this.afL = (TextView) this.afO.findViewById(r.g.btn_right);
            this.afK.setOnClickListener(aVar.afS);
            this.afK.setText(aVar.ZC);
            this.afL.setOnClickListener(aVar2.afS);
            this.afL.setText(aVar2.ZC);
            this.afO.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.h<?> hVar) {
        onChangeSkinType(hVar, TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void onActivityStop() {
        this.afF.setImageDrawable(null);
        this.afF.c(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.afI != null) {
            av.c(this.afI, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.afH != null) {
            av.c(this.afH, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.afG != null) {
            av.c(this.afG, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = av.getDrawable(i);
        int e = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32);
        int e2 = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds8);
        drawable.setBounds(0, 0, e, e);
        this.afH.setCompoundDrawablePadding(e2);
        this.afH.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.afH;
    }
}
