package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class o extends LinearLayout {
    private static /* synthetic */ int[] Id;
    private View HS;
    private TbImageView HT;
    private TextView HU;
    private TextView HV;
    private TextView HW;
    private TextView HX;
    private TextView HY;
    private TextView HZ;
    private String Ia;
    private String Ib;
    private View Ic;
    private Context mContext;

    static /* synthetic */ int[] nw() {
        int[] iArr = Id;
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
                iArr[NoDataViewFactory.ImgType.NODATA.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.SINGALL.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            Id = iArr;
        }
        return iArr;
    }

    public o(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.HS = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.no_data_view, this);
        this.HT = (TbImageView) this.HS.findViewById(com.baidu.tieba.v.iv_no_data_img);
        this.HT.setDefaultBgResource(0);
        this.HT.setDefaultResource(0);
        this.HT.setSupportNoImage(false);
        this.HU = (TextView) this.HS.findViewById(com.baidu.tieba.v.tv_text_reamrk);
        this.HV = (TextView) this.HS.findViewById(com.baidu.tieba.v.tv_subtitle);
        this.HW = (TextView) this.HS.findViewById(com.baidu.tieba.v.tv_title);
        this.HX = (TextView) this.HS.findViewById(com.baidu.tieba.v.btn_func);
        this.Ic = (LinearLayout) this.HS.findViewById(com.baidu.tieba.v.two_button_layout);
    }

    public void a(q qVar, r rVar, s sVar) {
        setButtonOption(qVar);
        setImgOption(rVar);
        setTextOption(sVar);
    }

    public void onChangeSkinType(int i) {
        if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).getLayoutMode().L(i == 1);
            ((BaseActivity) this.mContext).getLayoutMode().h(this);
        } else if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).getLayoutMode().L(i == 1);
            ((BaseFragmentActivity) this.mContext).getLayoutMode().h(this);
        }
        if (i == 1) {
            this.HT.c(this.Ib, 29, false);
        } else {
            this.HT.c(this.Ia, 29, false);
        }
    }

    public void setTextOption(s sVar) {
        if (sVar != null) {
            if (!TextUtils.isEmpty(sVar.mTitle)) {
                this.HW.setText(sVar.mTitle);
                this.HW.setVisibility(0);
            } else {
                this.HW.setVisibility(8);
            }
            if (!TextUtils.isEmpty(sVar.Ij)) {
                this.HV.setText(sVar.Ij);
                if (TextUtils.isEmpty(sVar.mTitle)) {
                    this.HV.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.fontsize28));
                }
            } else {
                this.HV.setVisibility(8);
            }
            if (!TextUtils.isEmpty(sVar.Ik)) {
                this.HU.setText(sVar.Ik);
                this.HU.setVisibility(0);
                return;
            }
            this.HU.setVisibility(8);
        }
    }

    public void setImgOption(r rVar) {
        if (rVar != null) {
            switch (nw()[rVar.Ih.ordinal()]) {
                case 2:
                    this.Ia = com.baidu.tbadk.util.b.uY().dO("pic_emotion03.png");
                    this.Ib = com.baidu.tbadk.util.b.uY().dO("pic_emotion03_1.png");
                    break;
                case 3:
                    this.Ia = com.baidu.tbadk.util.b.uY().dO("pic_emotion05.png");
                    this.Ib = com.baidu.tbadk.util.b.uY().dO("pic_emotion05_1.png");
                    break;
                case 4:
                    this.Ia = com.baidu.tbadk.util.b.uY().dO("pic_emotion01.png");
                    this.Ib = com.baidu.tbadk.util.b.uY().dO("pic_emotion01_1.png");
                    break;
                case 5:
                    this.Ia = com.baidu.tbadk.util.b.uY().dO("pic_emotion02.png");
                    this.Ib = com.baidu.tbadk.util.b.uY().dO("pic_emotion02_1.png");
                    break;
                case 6:
                    this.Ia = com.baidu.tbadk.util.b.uY().dO("pic_emotion06.png");
                    this.Ib = com.baidu.tbadk.util.b.uY().dO("pic_emotion06_1.png");
                    break;
                case 7:
                    this.Ia = com.baidu.tbadk.util.b.uY().dO("pic_emotion07.png");
                    this.Ib = com.baidu.tbadk.util.b.uY().dO("pic_emotion07_1.png");
                    break;
            }
            if (rVar.mHeight >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.HT.getLayoutParams();
                layoutParams.setMargins(0, rVar.mHeight, 0, 0);
                this.HT.setLayoutParams(layoutParams);
            }
        }
    }

    public void setButtonOption(q qVar) {
        if (qVar == null) {
            this.HX.setVisibility(8);
            this.Ic.setVisibility(8);
            return;
        }
        p pVar = qVar.If;
        p pVar2 = qVar.Ig;
        if (pVar2 == null && pVar != null) {
            this.HX.setOnClickListener(pVar.Ie);
            this.HX.setText(pVar.Dm);
            this.HX.setVisibility(0);
        }
        if (pVar2 != null && pVar != null) {
            this.HY = (TextView) this.Ic.findViewById(com.baidu.tieba.v.btn_left);
            this.HZ = (TextView) this.Ic.findViewById(com.baidu.tieba.v.btn_right);
            this.HY.setOnClickListener(pVar.Ie);
            this.HY.setText(pVar.Dm);
            this.HZ.setOnClickListener(pVar2.Ie);
            this.HZ.setText(pVar2.Dm);
            this.Ic.setVisibility(0);
        }
    }

    public void nv() {
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
    }

    public void onActivityStop() {
        this.HT.setBackgroundResource(0);
    }
}
