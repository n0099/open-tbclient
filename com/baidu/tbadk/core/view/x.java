package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class x extends LinearLayout {
    private static /* synthetic */ int[] MX;
    private TbImageView MN;
    private TextView MO;
    private TextView MP;
    private TextView MQ;
    private TextView MR;
    private TextView MS;
    private TextView MT;
    private String MU;
    private String MV;
    private View MW;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] qv() {
        int[] iArr = MX;
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
            MX = iArr;
        }
        return iArr;
    }

    public x(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.x.no_data_view, this);
        this.MN = (TbImageView) this.mRootView.findViewById(com.baidu.tieba.w.iv_no_data_img);
        this.MN.setDefaultBgResource(0);
        this.MN.setDefaultResource(0);
        this.MN.setSupportNoImage(false);
        this.MO = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.tv_text_reamrk);
        this.MP = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.tv_subtitle);
        this.MQ = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.tv_title);
        this.MR = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.btn_func);
        this.MW = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.two_button_layout);
    }

    public void a(z zVar, aa aaVar, ab abVar) {
        setButtonOption(zVar);
        setImgOption(aaVar);
        setTextOption(abVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.j<?> jVar, int i) {
        if (jVar instanceof TbPageContext) {
            ((TbPageContext) jVar).getLayoutMode().ab(i == 1);
            ((TbPageContext) jVar).getLayoutMode().h(this);
        }
        if (i == 1) {
            this.MN.d(this.MV, 29, false);
        } else {
            this.MN.d(this.MU, 29, false);
        }
    }

    public void setTextOption(ab abVar) {
        if (abVar != null) {
            if (!TextUtils.isEmpty(abVar.mTitle)) {
                this.MQ.setText(abVar.mTitle);
                this.MQ.setVisibility(0);
            } else {
                this.MQ.setVisibility(8);
            }
            if (!TextUtils.isEmpty(abVar.Nd)) {
                this.MP.setText(abVar.Nd);
                if (TextUtils.isEmpty(abVar.mTitle)) {
                    this.MP.setTextSize(0, getResources().getDimension(com.baidu.tieba.u.fontsize28));
                }
            } else {
                this.MP.setVisibility(8);
            }
            if (!TextUtils.isEmpty(abVar.Ne)) {
                this.MO.setText(abVar.Ne);
                this.MO.setVisibility(0);
                return;
            }
            this.MO.setVisibility(8);
        }
    }

    public void setImgOption(aa aaVar) {
        if (aaVar != null) {
            switch (qv()[aaVar.Nb.ordinal()]) {
                case 2:
                    this.MU = com.baidu.tbadk.util.b.zx().eD("pic_emotion03.png");
                    this.MV = com.baidu.tbadk.util.b.zx().eD("pic_emotion03_1.png");
                    break;
                case 3:
                    this.MU = com.baidu.tbadk.util.b.zx().eD("pic_emotion05.png");
                    this.MV = com.baidu.tbadk.util.b.zx().eD("pic_emotion05_1.png");
                    break;
                case 4:
                    this.MU = com.baidu.tbadk.util.b.zx().eD("pic_emotion01.png");
                    this.MV = com.baidu.tbadk.util.b.zx().eD("pic_emotion01_1.png");
                    break;
                case 5:
                    this.MU = com.baidu.tbadk.util.b.zx().eD("pic_emotion02.png");
                    this.MV = com.baidu.tbadk.util.b.zx().eD("pic_emotion02_1.png");
                    break;
                case 6:
                    this.MU = com.baidu.tbadk.util.b.zx().eD("pic_emotion06.png");
                    this.MV = com.baidu.tbadk.util.b.zx().eD("pic_emotion06_1.png");
                    break;
                case 7:
                    this.MU = com.baidu.tbadk.util.b.zx().eD("pic_emotion07.png");
                    this.MV = com.baidu.tbadk.util.b.zx().eD("pic_emotion07_1.png");
                    break;
            }
            if (aaVar.mHeight >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.MN.getLayoutParams();
                layoutParams.setMargins(0, aaVar.mHeight, 0, 0);
                this.MN.setLayoutParams(layoutParams);
            }
        }
    }

    public void setButtonOption(z zVar) {
        if (zVar == null) {
            this.MR.setVisibility(8);
            this.MW.setVisibility(8);
            return;
        }
        y yVar = zVar.MZ;
        y yVar2 = zVar.Na;
        if (yVar2 == null && yVar != null) {
            this.MR.setOnClickListener(yVar.MY);
            this.MR.setText(yVar.mText);
            this.MR.setVisibility(0);
        }
        if (yVar2 != null && yVar != null) {
            this.MS = (TextView) this.MW.findViewById(com.baidu.tieba.w.btn_left);
            this.MT = (TextView) this.MW.findViewById(com.baidu.tieba.w.btn_right);
            this.MS.setOnClickListener(yVar.MY);
            this.MS.setText(yVar.mText);
            this.MT.setOnClickListener(yVar2.MY);
            this.MT.setText(yVar2.mText);
            this.MW.setVisibility(0);
        }
    }

    public void f(com.baidu.adp.base.j<?> jVar) {
        onChangeSkinType(jVar, TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void onActivityStop() {
        this.MN.setBackgroundResource(0);
    }
}
