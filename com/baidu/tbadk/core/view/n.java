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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class n extends LinearLayout {
    private static /* synthetic */ int[] aeZ;
    private TbImageView aeN;
    private TextView aeO;
    private TextView aeP;
    private TextView aeQ;
    private TextView aeR;
    private TextView aeS;
    private TextView aeT;
    private String aeU;
    private String aeV;
    private View aeW;
    private NoDataViewFactory.ImgType aeX;
    private int aeY;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] wc() {
        int[] iArr = aeZ;
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
            aeZ = iArr;
        }
        return iArr;
    }

    public n(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(n.g.no_data_view, this);
        this.aeN = (TbImageView) this.mRootView.findViewById(n.f.iv_no_data_img);
        this.aeN.setDefaultBgResource(0);
        this.aeN.setDefaultResource(0);
        this.aeO = (TextView) this.mRootView.findViewById(n.f.tv_text_reamrk);
        this.aeP = (TextView) this.mRootView.findViewById(n.f.tv_subtitle);
        this.aeQ = (TextView) this.mRootView.findViewById(n.f.tv_title);
        this.aeR = (TextView) this.mRootView.findViewById(n.f.btn_func);
        this.aeW = (LinearLayout) this.mRootView.findViewById(n.f.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().af(i == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this);
        }
        if (this.aeX == NoDataViewFactory.ImgType.WEBVIEW) {
            this.aeN.setImageBitmap(as.cG(n.e.pic_emotion08));
        } else if (this.aeX == NoDataViewFactory.ImgType.NODATA) {
            this.aeN.setImageBitmap(as.cG(n.e.no_data_image));
        } else if (this.aeX == NoDataViewFactory.ImgType.LOCAL) {
            this.aeN.setImageBitmap(as.cG(this.aeY));
        } else if (i == 1) {
            this.aeN.d(this.aeV, 29, false);
        } else {
            this.aeN.d(this.aeU, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.aeQ.setText(dVar.mTitle);
                this.aeQ.setVisibility(0);
            } else {
                this.aeQ.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.Vc)) {
                this.aeP.setText(dVar.Vc);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.aeP.setTextSize(0, getResources().getDimension(n.d.fontsize28));
                    if (dVar.afi >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aeP.getLayoutParams();
                        layoutParams.topMargin = dVar.afi;
                        this.aeP.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.Yt != 0) {
                    setSubTitleCompoundDrawable(dVar.Yt);
                }
            } else {
                this.aeP.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.afh)) {
                this.aeO.setText(dVar.afh);
                this.aeO.setVisibility(0);
                return;
            }
            this.aeO.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.aeX = cVar.afe;
            this.aeY = cVar.aeY;
            switch (wc()[cVar.afe.ordinal()]) {
                case 2:
                    this.aeU = com.baidu.tbadk.util.b.Fn().fY("pic_emotion03.png");
                    this.aeV = com.baidu.tbadk.util.b.Fn().fY("pic_emotion03_1.png");
                    break;
                case 3:
                    this.aeU = com.baidu.tbadk.util.b.Fn().fY("pic_emotion05.png");
                    this.aeV = com.baidu.tbadk.util.b.Fn().fY("pic_emotion05_1.png");
                    break;
                case 4:
                    this.aeU = com.baidu.tbadk.util.b.Fn().fY("pic_emotion01.png");
                    this.aeV = com.baidu.tbadk.util.b.Fn().fY("pic_emotion01_1.png");
                    break;
                case 5:
                    this.aeU = com.baidu.tbadk.util.b.Fn().fY("pic_emotion02.png");
                    this.aeV = com.baidu.tbadk.util.b.Fn().fY("pic_emotion02_1.png");
                    break;
                case 6:
                    this.aeU = com.baidu.tbadk.util.b.Fn().fY("pic_emotion06.png");
                    this.aeV = com.baidu.tbadk.util.b.Fn().fY("pic_emotion06_1.png");
                    break;
                case 7:
                    this.aeU = com.baidu.tbadk.util.b.Fn().fY("pic_emotion07.png");
                    this.aeV = com.baidu.tbadk.util.b.Fn().fY("pic_emotion07_1.png");
                    break;
                case 8:
                    this.aeU = com.baidu.tbadk.util.b.Fn().fY("pic_emotion08.png");
                    this.aeV = com.baidu.tbadk.util.b.Fn().fY("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aeN.getLayoutParams();
            if (cVar.aff >= 0) {
                layoutParams.setMargins(0, cVar.aff, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.aeN.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.aeR.setVisibility(8);
            this.aeW.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.afb;
        NoDataViewFactory.a aVar2 = bVar.afc;
        if (aVar2 == null && aVar != null) {
            this.aeR.setOnClickListener(aVar.afa);
            this.aeR.setText(aVar.ZR);
            this.aeR.setVisibility(0);
            if (bVar.afd >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aeR.getLayoutParams();
                layoutParams.topMargin = bVar.afd;
                this.aeR.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.aeS = (TextView) this.aeW.findViewById(n.f.btn_left);
            this.aeT = (TextView) this.aeW.findViewById(n.f.btn_right);
            this.aeS.setOnClickListener(aVar.afa);
            this.aeS.setText(aVar.ZR);
            this.aeT.setOnClickListener(aVar2.afa);
            this.aeT.setText(aVar2.ZR);
            this.aeW.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.h<?> hVar) {
        onChangeSkinType(hVar, TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void onActivityStop() {
        this.aeN.setImageDrawable(null);
        this.aeN.d(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.aeQ != null) {
            as.b(this.aeQ, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.aeP != null) {
            as.b(this.aeP, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.aeO != null) {
            as.b(this.aeO, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = as.getDrawable(i);
        int d = com.baidu.adp.lib.util.k.d(this.mContext, n.d.ds32);
        int d2 = com.baidu.adp.lib.util.k.d(this.mContext, n.d.ds8);
        drawable.setBounds(0, 0, d, d);
        this.aeP.setCompoundDrawablePadding(d2);
        this.aeP.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.aeP;
    }
}
