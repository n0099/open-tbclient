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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class m extends LinearLayout {
    private static /* synthetic */ int[] adX;
    private TbImageView adL;
    private TextView adM;
    private TextView adN;
    private TextView adO;
    private TextView adP;
    private TextView adQ;
    private TextView adR;
    private String adS;
    private String adT;
    private View adU;
    private NoDataViewFactory.ImgType adV;
    private int adW;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] vv() {
        int[] iArr = adX;
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
            adX = iArr;
        }
        return iArr;
    }

    public m(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(i.g.no_data_view, this);
        this.adL = (TbImageView) this.mRootView.findViewById(i.f.iv_no_data_img);
        this.adL.setDefaultBgResource(0);
        this.adL.setDefaultResource(0);
        this.adM = (TextView) this.mRootView.findViewById(i.f.tv_text_reamrk);
        this.adN = (TextView) this.mRootView.findViewById(i.f.tv_subtitle);
        this.adO = (TextView) this.mRootView.findViewById(i.f.tv_title);
        this.adP = (TextView) this.mRootView.findViewById(i.f.btn_func);
        this.adU = (LinearLayout) this.mRootView.findViewById(i.f.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ad(i == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this);
        }
        if (this.adV == NoDataViewFactory.ImgType.WEBVIEW) {
            this.adL.setImageBitmap(an.cy(i.e.pic_emotion08));
        } else if (this.adV == NoDataViewFactory.ImgType.NODATA) {
            this.adL.setImageBitmap(an.cy(i.e.no_data_image));
        } else if (this.adV == NoDataViewFactory.ImgType.LOCAL) {
            this.adL.setImageBitmap(an.cy(this.adW));
        } else if (i == 1) {
            this.adL.d(this.adT, 29, false);
        } else {
            this.adL.d(this.adS, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.adO.setText(dVar.mTitle);
                this.adO.setVisibility(0);
            } else {
                this.adO.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.UK)) {
                this.adN.setText(dVar.UK);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.adN.setTextSize(0, getResources().getDimension(i.d.fontsize28));
                    if (dVar.aeg >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.adN.getLayoutParams();
                        layoutParams.topMargin = dVar.aeg;
                        this.adN.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.XD != 0) {
                    setSubTitleCompoundDrawable(dVar.XD);
                }
            } else {
                this.adN.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.aef)) {
                this.adM.setText(dVar.aef);
                this.adM.setVisibility(0);
                return;
            }
            this.adM.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.adV = cVar.aec;
            this.adW = cVar.adW;
            switch (vv()[cVar.aec.ordinal()]) {
                case 2:
                    this.adS = com.baidu.tbadk.util.b.Ew().fI("pic_emotion03.png");
                    this.adT = com.baidu.tbadk.util.b.Ew().fI("pic_emotion03_1.png");
                    break;
                case 3:
                    this.adS = com.baidu.tbadk.util.b.Ew().fI("pic_emotion05.png");
                    this.adT = com.baidu.tbadk.util.b.Ew().fI("pic_emotion05_1.png");
                    break;
                case 4:
                    this.adS = com.baidu.tbadk.util.b.Ew().fI("pic_emotion01.png");
                    this.adT = com.baidu.tbadk.util.b.Ew().fI("pic_emotion01_1.png");
                    break;
                case 5:
                    this.adS = com.baidu.tbadk.util.b.Ew().fI("pic_emotion02.png");
                    this.adT = com.baidu.tbadk.util.b.Ew().fI("pic_emotion02_1.png");
                    break;
                case 6:
                    this.adS = com.baidu.tbadk.util.b.Ew().fI("pic_emotion06.png");
                    this.adT = com.baidu.tbadk.util.b.Ew().fI("pic_emotion06_1.png");
                    break;
                case 7:
                    this.adS = com.baidu.tbadk.util.b.Ew().fI("pic_emotion07.png");
                    this.adT = com.baidu.tbadk.util.b.Ew().fI("pic_emotion07_1.png");
                    break;
                case 8:
                    this.adS = com.baidu.tbadk.util.b.Ew().fI("pic_emotion08.png");
                    this.adT = com.baidu.tbadk.util.b.Ew().fI("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.adL.getLayoutParams();
            if (cVar.aed >= 0) {
                layoutParams.setMargins(0, cVar.aed, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.adL.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.adP.setVisibility(8);
            this.adU.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.adZ;
        NoDataViewFactory.a aVar2 = bVar.aea;
        if (aVar2 == null && aVar != null) {
            this.adP.setOnClickListener(aVar.adY);
            this.adP.setText(aVar.Zb);
            this.adP.setVisibility(0);
            if (bVar.aeb >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.adP.getLayoutParams();
                layoutParams.topMargin = bVar.aeb;
                this.adP.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.adQ = (TextView) this.adU.findViewById(i.f.btn_left);
            this.adR = (TextView) this.adU.findViewById(i.f.btn_right);
            this.adQ.setOnClickListener(aVar.adY);
            this.adQ.setText(aVar.Zb);
            this.adR.setOnClickListener(aVar2.adY);
            this.adR.setText(aVar2.Zb);
            this.adU.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.h<?> hVar) {
        onChangeSkinType(hVar, TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void onActivityStop() {
        this.adL.setImageDrawable(null);
        this.adL.d(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.adO != null) {
            an.b(this.adO, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.adN != null) {
            an.b(this.adN, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.adM != null) {
            an.b(this.adM, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = an.getDrawable(i);
        int d = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds32);
        int d2 = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds8);
        drawable.setBounds(0, 0, d, d);
        this.adN.setCompoundDrawablePadding(d2);
        this.adN.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.adN;
    }
}
