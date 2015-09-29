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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class m extends LinearLayout {
    private static /* synthetic */ int[] adW;
    private TbImageView adK;
    private TextView adL;
    private TextView adM;
    private TextView adN;
    private TextView adO;
    private TextView adP;
    private TextView adQ;
    private String adR;
    private String adS;
    private View adT;
    private NoDataViewFactory.ImgType adU;
    private int adV;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] vv() {
        int[] iArr = adW;
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
            adW = iArr;
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
        this.adK = (TbImageView) this.mRootView.findViewById(i.f.iv_no_data_img);
        this.adK.setDefaultBgResource(0);
        this.adK.setDefaultResource(0);
        this.adL = (TextView) this.mRootView.findViewById(i.f.tv_text_reamrk);
        this.adM = (TextView) this.mRootView.findViewById(i.f.tv_subtitle);
        this.adN = (TextView) this.mRootView.findViewById(i.f.tv_title);
        this.adO = (TextView) this.mRootView.findViewById(i.f.btn_func);
        this.adT = (LinearLayout) this.mRootView.findViewById(i.f.two_button_layout);
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
        if (this.adU == NoDataViewFactory.ImgType.WEBVIEW) {
            this.adK.setImageBitmap(am.cy(i.e.pic_emotion08));
        } else if (this.adU == NoDataViewFactory.ImgType.NODATA) {
            this.adK.setImageBitmap(am.cy(i.e.no_data_image));
        } else if (this.adU == NoDataViewFactory.ImgType.LOCAL) {
            this.adK.setImageBitmap(am.cy(this.adV));
        } else if (i == 1) {
            this.adK.d(this.adS, 29, false);
        } else {
            this.adK.d(this.adR, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.adN.setText(dVar.mTitle);
                this.adN.setVisibility(0);
            } else {
                this.adN.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.UI)) {
                this.adM.setText(dVar.UI);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.adM.setTextSize(0, getResources().getDimension(i.d.fontsize28));
                    if (dVar.aef >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.adM.getLayoutParams();
                        layoutParams.topMargin = dVar.aef;
                        this.adM.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.XB != 0) {
                    setSubTitleCompoundDrawable(dVar.XB);
                }
            } else {
                this.adM.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.aee)) {
                this.adL.setText(dVar.aee);
                this.adL.setVisibility(0);
                return;
            }
            this.adL.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.adU = cVar.aeb;
            this.adV = cVar.adV;
            switch (vv()[cVar.aeb.ordinal()]) {
                case 2:
                    this.adR = com.baidu.tbadk.util.b.Ew().fI("pic_emotion03.png");
                    this.adS = com.baidu.tbadk.util.b.Ew().fI("pic_emotion03_1.png");
                    break;
                case 3:
                    this.adR = com.baidu.tbadk.util.b.Ew().fI("pic_emotion05.png");
                    this.adS = com.baidu.tbadk.util.b.Ew().fI("pic_emotion05_1.png");
                    break;
                case 4:
                    this.adR = com.baidu.tbadk.util.b.Ew().fI("pic_emotion01.png");
                    this.adS = com.baidu.tbadk.util.b.Ew().fI("pic_emotion01_1.png");
                    break;
                case 5:
                    this.adR = com.baidu.tbadk.util.b.Ew().fI("pic_emotion02.png");
                    this.adS = com.baidu.tbadk.util.b.Ew().fI("pic_emotion02_1.png");
                    break;
                case 6:
                    this.adR = com.baidu.tbadk.util.b.Ew().fI("pic_emotion06.png");
                    this.adS = com.baidu.tbadk.util.b.Ew().fI("pic_emotion06_1.png");
                    break;
                case 7:
                    this.adR = com.baidu.tbadk.util.b.Ew().fI("pic_emotion07.png");
                    this.adS = com.baidu.tbadk.util.b.Ew().fI("pic_emotion07_1.png");
                    break;
                case 8:
                    this.adR = com.baidu.tbadk.util.b.Ew().fI("pic_emotion08.png");
                    this.adS = com.baidu.tbadk.util.b.Ew().fI("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.adK.getLayoutParams();
            if (cVar.aec >= 0) {
                layoutParams.setMargins(0, cVar.aec, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.adK.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.adO.setVisibility(8);
            this.adT.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.adY;
        NoDataViewFactory.a aVar2 = bVar.adZ;
        if (aVar2 == null && aVar != null) {
            this.adO.setOnClickListener(aVar.adX);
            this.adO.setText(aVar.YZ);
            this.adO.setVisibility(0);
            if (bVar.aea >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.adO.getLayoutParams();
                layoutParams.topMargin = bVar.aea;
                this.adO.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.adP = (TextView) this.adT.findViewById(i.f.btn_left);
            this.adQ = (TextView) this.adT.findViewById(i.f.btn_right);
            this.adP.setOnClickListener(aVar.adX);
            this.adP.setText(aVar.YZ);
            this.adQ.setOnClickListener(aVar2.adX);
            this.adQ.setText(aVar2.YZ);
            this.adT.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.h<?> hVar) {
        onChangeSkinType(hVar, TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void onActivityStop() {
        this.adK.setImageDrawable(null);
        this.adK.d(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.adN != null) {
            am.b(this.adN, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.adM != null) {
            am.b(this.adM, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.adL != null) {
            am.b(this.adL, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = am.getDrawable(i);
        int d = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds32);
        int d2 = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds8);
        drawable.setBounds(0, 0, d, d);
        this.adM.setCompoundDrawablePadding(d2);
        this.adM.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.adM;
    }
}
