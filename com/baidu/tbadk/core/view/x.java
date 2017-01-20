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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class x extends LinearLayout {
    private static /* synthetic */ int[] aeX;
    private TbImageView aeL;
    private TextView aeM;
    private TextView aeN;
    private TextView aeO;
    private TextView aeP;
    private TextView aeQ;
    private TextView aeR;
    private String aeS;
    private String aeT;
    private View aeU;
    private NoDataViewFactory.ImgType aeV;
    private int aeW;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] wa() {
        int[] iArr = aeX;
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
            aeX = iArr;
        }
        return iArr;
    }

    public x(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(r.j.no_data_view, this);
        this.aeL = (TbImageView) this.mRootView.findViewById(r.h.iv_no_data_img);
        this.aeL.setDefaultBgResource(0);
        this.aeL.setDefaultResource(0);
        this.aeL.setDefaultErrorResource(0);
        this.aeM = (TextView) this.mRootView.findViewById(r.h.tv_text_reamrk);
        this.aeN = (TextView) this.mRootView.findViewById(r.h.tv_subtitle);
        this.aeO = (TextView) this.mRootView.findViewById(r.h.tv_title);
        this.aeP = (TextView) this.mRootView.findViewById(r.h.btn_func);
        this.aeU = (LinearLayout) this.mRootView.findViewById(r.h.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.g<?> gVar, int i) {
        if (gVar instanceof TbPageContext) {
            ((TbPageContext) gVar).getLayoutMode().ai(i == 1);
            ((TbPageContext) gVar).getLayoutMode().v(this);
        }
        if (this.aeV == NoDataViewFactory.ImgType.WEBVIEW) {
            this.aeL.setImageBitmap(com.baidu.tbadk.core.util.ap.cR(r.g.pic_emotion08));
        } else if (this.aeV == NoDataViewFactory.ImgType.NODATA) {
            this.aeL.setImageBitmap(com.baidu.tbadk.core.util.ap.cR(r.g.no_data_image));
        } else if (this.aeV == NoDataViewFactory.ImgType.LOCAL) {
            this.aeL.setImageBitmap(com.baidu.tbadk.core.util.ap.cR(this.aeW));
        } else if (i == 1) {
            this.aeL.c(this.aeT, 29, false);
        } else {
            this.aeL.c(this.aeS, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.aeO.setText(dVar.mTitle);
                this.aeO.setVisibility(0);
            } else {
                this.aeO.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.aeN.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.aeN.setTextSize(0, getResources().getDimension(r.f.fontsize28));
                    if (dVar.afg >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aeN.getLayoutParams();
                        layoutParams.topMargin = dVar.afg;
                        this.aeN.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.Wk != 0) {
                    setSubTitleCompoundDrawable(dVar.Wk);
                }
            } else {
                this.aeN.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.aff)) {
                this.aeM.setText(dVar.aff);
                this.aeM.setVisibility(0);
                return;
            }
            this.aeM.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.aeV = cVar.afc;
            this.aeW = cVar.aeW;
            switch (wa()[cVar.afc.ordinal()]) {
                case 2:
                    this.aeS = com.baidu.tbadk.util.b.Gh().gi("pic_emotion03.png");
                    this.aeT = com.baidu.tbadk.util.b.Gh().gi("pic_emotion03_1.png");
                    break;
                case 3:
                    this.aeS = com.baidu.tbadk.util.b.Gh().gi("pic_emotion05.png");
                    this.aeT = com.baidu.tbadk.util.b.Gh().gi("pic_emotion05_1.png");
                    break;
                case 4:
                    this.aeS = com.baidu.tbadk.util.b.Gh().gi("pic_emotion01.png");
                    this.aeT = com.baidu.tbadk.util.b.Gh().gi("pic_emotion01_1.png");
                    break;
                case 5:
                    this.aeS = com.baidu.tbadk.util.b.Gh().gi("pic_emotion02.png");
                    this.aeT = com.baidu.tbadk.util.b.Gh().gi("pic_emotion02_1.png");
                    break;
                case 6:
                    this.aeS = com.baidu.tbadk.util.b.Gh().gi("pic_emotion06.png");
                    this.aeT = com.baidu.tbadk.util.b.Gh().gi("pic_emotion06_1.png");
                    break;
                case 7:
                    this.aeS = com.baidu.tbadk.util.b.Gh().gi("pic_emotion07.png");
                    this.aeT = com.baidu.tbadk.util.b.Gh().gi("pic_emotion07_1.png");
                    break;
                case 8:
                    this.aeS = com.baidu.tbadk.util.b.Gh().gi("pic_emotion08.png");
                    this.aeT = com.baidu.tbadk.util.b.Gh().gi("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aeL.getLayoutParams();
            if (cVar.afd >= 0) {
                layoutParams.setMargins(0, cVar.afd, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.aeL.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.aeP.setVisibility(8);
            this.aeU.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.aeZ;
        NoDataViewFactory.a aVar2 = bVar.afa;
        if (aVar2 == null && aVar != null) {
            this.aeP.setOnClickListener(aVar.aeY);
            this.aeP.setText(aVar.YI);
            this.aeP.setVisibility(0);
            if (bVar.afb >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aeP.getLayoutParams();
                layoutParams.topMargin = bVar.afb;
                this.aeP.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.aeQ = (TextView) this.aeU.findViewById(r.h.btn_left);
            this.aeR = (TextView) this.aeU.findViewById(r.h.btn_right);
            this.aeQ.setOnClickListener(aVar.aeY);
            this.aeQ.setText(aVar.YI);
            this.aeR.setOnClickListener(aVar2.aeY);
            this.aeR.setText(aVar2.YI);
            this.aeU.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.g<?> gVar) {
        onChangeSkinType(gVar, TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void onActivityStop() {
        this.aeL.setImageDrawable(null);
        this.aeL.c(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.aeO != null) {
            com.baidu.tbadk.core.util.ap.c(this.aeO, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.aeN != null) {
            com.baidu.tbadk.core.util.ap.c(this.aeN, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.aeM != null) {
            com.baidu.tbadk.core.util.ap.c(this.aeM, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = com.baidu.tbadk.core.util.ap.getDrawable(i);
        int e = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds32);
        int e2 = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds8);
        drawable.setBounds(0, 0, e, e);
        this.aeN.setCompoundDrawablePadding(e2);
        this.aeN.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.aeN;
    }
}
