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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class p extends LinearLayout {
    private static /* synthetic */ int[] afY;
    private TbImageView afM;
    private TextView afN;
    private TextView afO;
    private TextView afP;
    private TextView afQ;
    private TextView afR;
    private TextView afS;
    private String afT;
    private String afU;
    private View afV;
    private NoDataViewFactory.ImgType afW;
    private int afX;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] xn() {
        int[] iArr = afY;
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
            afY = iArr;
        }
        return iArr;
    }

    public p(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(t.h.no_data_view, this);
        this.afM = (TbImageView) this.mRootView.findViewById(t.g.iv_no_data_img);
        this.afM.setDefaultBgResource(0);
        this.afM.setDefaultResource(0);
        this.afM.setDefaultErrorResource(0);
        this.afN = (TextView) this.mRootView.findViewById(t.g.tv_text_reamrk);
        this.afO = (TextView) this.mRootView.findViewById(t.g.tv_subtitle);
        this.afP = (TextView) this.mRootView.findViewById(t.g.tv_title);
        this.afQ = (TextView) this.mRootView.findViewById(t.g.btn_func);
        this.afV = (LinearLayout) this.mRootView.findViewById(t.g.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ab(i == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this);
        }
        if (this.afW == NoDataViewFactory.ImgType.WEBVIEW) {
            this.afM.setImageBitmap(at.cT(t.f.pic_emotion08));
        } else if (this.afW == NoDataViewFactory.ImgType.NODATA) {
            this.afM.setImageBitmap(at.cT(t.f.no_data_image));
        } else if (this.afW == NoDataViewFactory.ImgType.LOCAL) {
            this.afM.setImageBitmap(at.cT(this.afX));
        } else if (i == 1) {
            this.afM.c(this.afU, 29, false);
        } else {
            this.afM.c(this.afT, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.afP.setText(dVar.mTitle);
                this.afP.setVisibility(0);
            } else {
                this.afP.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.SX)) {
                this.afO.setText(dVar.SX);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.afO.setTextSize(0, getResources().getDimension(t.e.fontsize28));
                    if (dVar.agi >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afO.getLayoutParams();
                        layoutParams.topMargin = dVar.agi;
                        this.afO.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.XM != 0) {
                    setSubTitleCompoundDrawable(dVar.XM);
                }
            } else {
                this.afO.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.agh)) {
                this.afN.setText(dVar.agh);
                this.afN.setVisibility(0);
                return;
            }
            this.afN.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.afW = cVar.agd;
            this.afX = cVar.afX;
            switch (xn()[cVar.agd.ordinal()]) {
                case 2:
                    this.afT = com.baidu.tbadk.util.b.Hp().gi("pic_emotion03.png");
                    this.afU = com.baidu.tbadk.util.b.Hp().gi("pic_emotion03_1.png");
                    break;
                case 3:
                    this.afT = com.baidu.tbadk.util.b.Hp().gi("pic_emotion05.png");
                    this.afU = com.baidu.tbadk.util.b.Hp().gi("pic_emotion05_1.png");
                    break;
                case 4:
                    this.afT = com.baidu.tbadk.util.b.Hp().gi("pic_emotion01.png");
                    this.afU = com.baidu.tbadk.util.b.Hp().gi("pic_emotion01_1.png");
                    break;
                case 5:
                    this.afT = com.baidu.tbadk.util.b.Hp().gi("pic_emotion02.png");
                    this.afU = com.baidu.tbadk.util.b.Hp().gi("pic_emotion02_1.png");
                    break;
                case 6:
                    this.afT = com.baidu.tbadk.util.b.Hp().gi("pic_emotion06.png");
                    this.afU = com.baidu.tbadk.util.b.Hp().gi("pic_emotion06_1.png");
                    break;
                case 7:
                    this.afT = com.baidu.tbadk.util.b.Hp().gi("pic_emotion07.png");
                    this.afU = com.baidu.tbadk.util.b.Hp().gi("pic_emotion07_1.png");
                    break;
                case 8:
                    this.afT = com.baidu.tbadk.util.b.Hp().gi("pic_emotion08.png");
                    this.afU = com.baidu.tbadk.util.b.Hp().gi("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afM.getLayoutParams();
            if (cVar.agf >= 0) {
                layoutParams.setMargins(0, cVar.agf, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.afM.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.afQ.setVisibility(8);
            this.afV.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.aga;
        NoDataViewFactory.a aVar2 = bVar.agb;
        if (aVar2 == null && aVar != null) {
            this.afQ.setOnClickListener(aVar.afZ);
            this.afQ.setText(aVar.aad);
            this.afQ.setVisibility(0);
            if (bVar.agc >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afQ.getLayoutParams();
                layoutParams.topMargin = bVar.agc;
                this.afQ.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.afR = (TextView) this.afV.findViewById(t.g.btn_left);
            this.afS = (TextView) this.afV.findViewById(t.g.btn_right);
            this.afR.setOnClickListener(aVar.afZ);
            this.afR.setText(aVar.aad);
            this.afS.setOnClickListener(aVar2.afZ);
            this.afS.setText(aVar2.aad);
            this.afV.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.h<?> hVar) {
        onChangeSkinType(hVar, TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void onActivityStop() {
        this.afM.setImageDrawable(null);
        this.afM.c(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.afP != null) {
            at.b(this.afP, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.afO != null) {
            at.b(this.afO, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.afN != null) {
            at.b(this.afN, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = at.getDrawable(i);
        int c = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds32);
        int c2 = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds8);
        drawable.setBounds(0, 0, c, c);
        this.afO.setCompoundDrawablePadding(c2);
        this.afO.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.afO;
    }
}
