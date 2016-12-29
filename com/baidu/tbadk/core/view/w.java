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
public class w extends LinearLayout {
    private static /* synthetic */ int[] afK;
    private TextView afA;
    private TextView afB;
    private TextView afC;
    private TextView afD;
    private TextView afE;
    private String afF;
    private String afG;
    private View afH;
    private NoDataViewFactory.ImgType afI;
    private int afJ;
    private TbImageView afy;
    private TextView afz;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] wf() {
        int[] iArr = afK;
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
            afK = iArr;
        }
        return iArr;
    }

    public w(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(r.h.no_data_view, this);
        this.afy = (TbImageView) this.mRootView.findViewById(r.g.iv_no_data_img);
        this.afy.setDefaultBgResource(0);
        this.afy.setDefaultResource(0);
        this.afy.setDefaultErrorResource(0);
        this.afz = (TextView) this.mRootView.findViewById(r.g.tv_text_reamrk);
        this.afA = (TextView) this.mRootView.findViewById(r.g.tv_subtitle);
        this.afB = (TextView) this.mRootView.findViewById(r.g.tv_title);
        this.afC = (TextView) this.mRootView.findViewById(r.g.btn_func);
        this.afH = (LinearLayout) this.mRootView.findViewById(r.g.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ai(i == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this);
        }
        if (this.afI == NoDataViewFactory.ImgType.WEBVIEW) {
            this.afy.setImageBitmap(com.baidu.tbadk.core.util.ar.cS(r.f.pic_emotion08));
        } else if (this.afI == NoDataViewFactory.ImgType.NODATA) {
            this.afy.setImageBitmap(com.baidu.tbadk.core.util.ar.cS(r.f.no_data_image));
        } else if (this.afI == NoDataViewFactory.ImgType.LOCAL) {
            this.afy.setImageBitmap(com.baidu.tbadk.core.util.ar.cS(this.afJ));
        } else if (i == 1) {
            this.afy.c(this.afG, 29, false);
        } else {
            this.afy.c(this.afF, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.afB.setText(dVar.mTitle);
                this.afB.setVisibility(0);
            } else {
                this.afB.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.afA.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.afA.setTextSize(0, getResources().getDimension(r.e.fontsize28));
                    if (dVar.afT >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afA.getLayoutParams();
                        layoutParams.topMargin = dVar.afT;
                        this.afA.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.WU != 0) {
                    setSubTitleCompoundDrawable(dVar.WU);
                }
            } else {
                this.afA.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.afS)) {
                this.afz.setText(dVar.afS);
                this.afz.setVisibility(0);
                return;
            }
            this.afz.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.afI = cVar.afP;
            this.afJ = cVar.afJ;
            switch (wf()[cVar.afP.ordinal()]) {
                case 2:
                    this.afF = com.baidu.tbadk.util.b.Gp().gl("pic_emotion03.png");
                    this.afG = com.baidu.tbadk.util.b.Gp().gl("pic_emotion03_1.png");
                    break;
                case 3:
                    this.afF = com.baidu.tbadk.util.b.Gp().gl("pic_emotion05.png");
                    this.afG = com.baidu.tbadk.util.b.Gp().gl("pic_emotion05_1.png");
                    break;
                case 4:
                    this.afF = com.baidu.tbadk.util.b.Gp().gl("pic_emotion01.png");
                    this.afG = com.baidu.tbadk.util.b.Gp().gl("pic_emotion01_1.png");
                    break;
                case 5:
                    this.afF = com.baidu.tbadk.util.b.Gp().gl("pic_emotion02.png");
                    this.afG = com.baidu.tbadk.util.b.Gp().gl("pic_emotion02_1.png");
                    break;
                case 6:
                    this.afF = com.baidu.tbadk.util.b.Gp().gl("pic_emotion06.png");
                    this.afG = com.baidu.tbadk.util.b.Gp().gl("pic_emotion06_1.png");
                    break;
                case 7:
                    this.afF = com.baidu.tbadk.util.b.Gp().gl("pic_emotion07.png");
                    this.afG = com.baidu.tbadk.util.b.Gp().gl("pic_emotion07_1.png");
                    break;
                case 8:
                    this.afF = com.baidu.tbadk.util.b.Gp().gl("pic_emotion08.png");
                    this.afG = com.baidu.tbadk.util.b.Gp().gl("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afy.getLayoutParams();
            if (cVar.afQ >= 0) {
                layoutParams.setMargins(0, cVar.afQ, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.afy.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.afC.setVisibility(8);
            this.afH.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.afM;
        NoDataViewFactory.a aVar2 = bVar.afN;
        if (aVar2 == null && aVar != null) {
            this.afC.setOnClickListener(aVar.afL);
            this.afC.setText(aVar.Zu);
            this.afC.setVisibility(0);
            if (bVar.afO >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afC.getLayoutParams();
                layoutParams.topMargin = bVar.afO;
                this.afC.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.afD = (TextView) this.afH.findViewById(r.g.btn_left);
            this.afE = (TextView) this.afH.findViewById(r.g.btn_right);
            this.afD.setOnClickListener(aVar.afL);
            this.afD.setText(aVar.Zu);
            this.afE.setOnClickListener(aVar2.afL);
            this.afE.setText(aVar2.Zu);
            this.afH.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.h<?> hVar) {
        onChangeSkinType(hVar, TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void onActivityStop() {
        this.afy.setImageDrawable(null);
        this.afy.c(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.afB != null) {
            com.baidu.tbadk.core.util.ar.c(this.afB, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.afA != null) {
            com.baidu.tbadk.core.util.ar.c(this.afA, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.afz != null) {
            com.baidu.tbadk.core.util.ar.c(this.afz, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = com.baidu.tbadk.core.util.ar.getDrawable(i);
        int e = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32);
        int e2 = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds8);
        drawable.setBounds(0, 0, e, e);
        this.afA.setCompoundDrawablePadding(e2);
        this.afA.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.afA;
    }
}
