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
    private static /* synthetic */ int[] Ie;
    private View HT;
    private TbImageView HU;
    private TextView HV;
    private TextView HW;
    private TextView HX;
    private TextView HY;
    private TextView HZ;
    private TextView Ia;
    private String Ib;
    private String Ic;
    private View Id;
    private Context mContext;

    static /* synthetic */ int[] nw() {
        int[] iArr = Ie;
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
            Ie = iArr;
        }
        return iArr;
    }

    public o(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.HT = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.no_data_view, this);
        this.HU = (TbImageView) this.HT.findViewById(com.baidu.tieba.v.iv_no_data_img);
        this.HU.setDefaultBgResource(0);
        this.HU.setDefaultResource(0);
        this.HU.setSupportNoImage(false);
        this.HV = (TextView) this.HT.findViewById(com.baidu.tieba.v.tv_text_reamrk);
        this.HW = (TextView) this.HT.findViewById(com.baidu.tieba.v.tv_subtitle);
        this.HX = (TextView) this.HT.findViewById(com.baidu.tieba.v.tv_title);
        this.HY = (TextView) this.HT.findViewById(com.baidu.tieba.v.btn_func);
        this.Id = (LinearLayout) this.HT.findViewById(com.baidu.tieba.v.two_button_layout);
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
            this.HU.c(this.Ic, 29, false);
        } else {
            this.HU.c(this.Ib, 29, false);
        }
    }

    public void setTextOption(s sVar) {
        if (sVar != null) {
            if (!TextUtils.isEmpty(sVar.mTitle)) {
                this.HX.setText(sVar.mTitle);
                this.HX.setVisibility(0);
            } else {
                this.HX.setVisibility(8);
            }
            if (!TextUtils.isEmpty(sVar.Ik)) {
                this.HW.setText(sVar.Ik);
                if (TextUtils.isEmpty(sVar.mTitle)) {
                    this.HW.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.fontsize28));
                }
            } else {
                this.HW.setVisibility(8);
            }
            if (!TextUtils.isEmpty(sVar.Il)) {
                this.HV.setText(sVar.Il);
                this.HV.setVisibility(0);
                return;
            }
            this.HV.setVisibility(8);
        }
    }

    public void setImgOption(r rVar) {
        if (rVar != null) {
            switch (nw()[rVar.Ii.ordinal()]) {
                case 2:
                    this.Ib = com.baidu.tbadk.util.b.va().dO("pic_emotion03.png");
                    this.Ic = com.baidu.tbadk.util.b.va().dO("pic_emotion03_1.png");
                    break;
                case 3:
                    this.Ib = com.baidu.tbadk.util.b.va().dO("pic_emotion05.png");
                    this.Ic = com.baidu.tbadk.util.b.va().dO("pic_emotion05_1.png");
                    break;
                case 4:
                    this.Ib = com.baidu.tbadk.util.b.va().dO("pic_emotion01.png");
                    this.Ic = com.baidu.tbadk.util.b.va().dO("pic_emotion01_1.png");
                    break;
                case 5:
                    this.Ib = com.baidu.tbadk.util.b.va().dO("pic_emotion02.png");
                    this.Ic = com.baidu.tbadk.util.b.va().dO("pic_emotion02_1.png");
                    break;
                case 6:
                    this.Ib = com.baidu.tbadk.util.b.va().dO("pic_emotion06.png");
                    this.Ic = com.baidu.tbadk.util.b.va().dO("pic_emotion06_1.png");
                    break;
                case 7:
                    this.Ib = com.baidu.tbadk.util.b.va().dO("pic_emotion07.png");
                    this.Ic = com.baidu.tbadk.util.b.va().dO("pic_emotion07_1.png");
                    break;
            }
            if (rVar.mHeight >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.HU.getLayoutParams();
                layoutParams.setMargins(0, rVar.mHeight, 0, 0);
                this.HU.setLayoutParams(layoutParams);
            }
        }
    }

    public void setButtonOption(q qVar) {
        if (qVar == null) {
            this.HY.setVisibility(8);
            this.Id.setVisibility(8);
            return;
        }
        p pVar = qVar.Ig;
        p pVar2 = qVar.Ih;
        if (pVar2 == null && pVar != null) {
            this.HY.setOnClickListener(pVar.If);
            this.HY.setText(pVar.Dn);
            this.HY.setVisibility(0);
        }
        if (pVar2 != null && pVar != null) {
            this.HZ = (TextView) this.Id.findViewById(com.baidu.tieba.v.btn_left);
            this.Ia = (TextView) this.Id.findViewById(com.baidu.tieba.v.btn_right);
            this.HZ.setOnClickListener(pVar.If);
            this.HZ.setText(pVar.Dn);
            this.Ia.setOnClickListener(pVar2.If);
            this.Ia.setText(pVar2.Dn);
            this.Id.setVisibility(0);
        }
    }

    public void nv() {
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
    }

    public void onActivityStop() {
        this.HU.setBackgroundResource(0);
    }
}
