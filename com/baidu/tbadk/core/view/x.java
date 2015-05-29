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
    private static /* synthetic */ int[] Zz;
    private TbImageView Zn;
    private TextView Zo;
    private TextView Zp;
    private TextView Zq;
    private TextView Zr;
    private TextView Zs;
    private TextView Zt;
    private String Zu;
    private String Zv;
    private View Zw;
    private NoDataViewFactory.ImgType Zx;
    private int Zy;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] uu() {
        int[] iArr = Zz;
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
            Zz = iArr;
        }
        return iArr;
    }

    public x(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = com.baidu.adp.lib.g.b.hr().inflate(this.mContext, com.baidu.tieba.r.no_data_view, this);
        this.Zn = (TbImageView) this.mRootView.findViewById(com.baidu.tieba.q.iv_no_data_img);
        this.Zn.setDefaultBgResource(0);
        this.Zn.setDefaultResource(0);
        this.Zo = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.tv_text_reamrk);
        this.Zp = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.tv_subtitle);
        this.Zq = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.tv_title);
        this.Zr = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.btn_func);
        this.Zw = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.q.two_button_layout);
    }

    public void a(z zVar, aa aaVar, ab abVar) {
        setButtonOption(zVar);
        setImgOption(aaVar);
        setTextOption(abVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.j<?> jVar, int i) {
        if (jVar instanceof TbPageContext) {
            ((TbPageContext) jVar).getLayoutMode().ab(i == 1);
            ((TbPageContext) jVar).getLayoutMode().j(this);
        }
        if (this.Zx == NoDataViewFactory.ImgType.WEBVIEW) {
            com.baidu.tbadk.core.util.ay.a(this.Zn, com.baidu.tieba.p.pic_emotion08, i);
        } else if (this.Zx == NoDataViewFactory.ImgType.NODATA) {
            com.baidu.tbadk.core.util.ay.a(this.Zn, com.baidu.tieba.p.no_data_image, i);
        } else if (this.Zx == NoDataViewFactory.ImgType.LOCAL) {
            com.baidu.tbadk.core.util.ay.a(this.Zn, this.Zy, i);
        } else if (i == 1) {
            this.Zn.c(this.Zv, 29, false);
        } else {
            this.Zn.c(this.Zu, 29, false);
        }
    }

    public void setTextOption(ab abVar) {
        if (abVar != null) {
            if (!TextUtils.isEmpty(abVar.mTitle)) {
                this.Zq.setText(abVar.mTitle);
                this.Zq.setVisibility(0);
            } else {
                this.Zq.setVisibility(8);
            }
            if (!TextUtils.isEmpty(abVar.ZH)) {
                this.Zp.setText(abVar.ZH);
                if (TextUtils.isEmpty(abVar.mTitle)) {
                    this.Zp.setTextSize(0, getResources().getDimension(com.baidu.tieba.o.fontsize28));
                    if (abVar.ZJ >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Zp.getLayoutParams();
                        layoutParams.topMargin = abVar.ZJ;
                        this.Zp.setLayoutParams(layoutParams);
                    }
                }
            } else {
                this.Zp.setVisibility(8);
            }
            if (!TextUtils.isEmpty(abVar.ZI)) {
                this.Zo.setText(abVar.ZI);
                this.Zo.setVisibility(0);
                return;
            }
            this.Zo.setVisibility(8);
        }
    }

    public void setImgOption(aa aaVar) {
        if (aaVar != null) {
            this.Zx = aaVar.ZE;
            this.Zy = aaVar.Zy;
            switch (uu()[aaVar.ZE.ordinal()]) {
                case 2:
                    this.Zu = com.baidu.tbadk.util.b.DS().fd("pic_emotion03.png");
                    this.Zv = com.baidu.tbadk.util.b.DS().fd("pic_emotion03_1.png");
                    break;
                case 3:
                    this.Zu = com.baidu.tbadk.util.b.DS().fd("pic_emotion05.png");
                    this.Zv = com.baidu.tbadk.util.b.DS().fd("pic_emotion05_1.png");
                    break;
                case 4:
                    this.Zu = com.baidu.tbadk.util.b.DS().fd("pic_emotion01.png");
                    this.Zv = com.baidu.tbadk.util.b.DS().fd("pic_emotion01_1.png");
                    break;
                case 5:
                    this.Zu = com.baidu.tbadk.util.b.DS().fd("pic_emotion02.png");
                    this.Zv = com.baidu.tbadk.util.b.DS().fd("pic_emotion02_1.png");
                    break;
                case 6:
                    this.Zu = com.baidu.tbadk.util.b.DS().fd("pic_emotion06.png");
                    this.Zv = com.baidu.tbadk.util.b.DS().fd("pic_emotion06_1.png");
                    break;
                case 7:
                    this.Zu = com.baidu.tbadk.util.b.DS().fd("pic_emotion07.png");
                    this.Zv = com.baidu.tbadk.util.b.DS().fd("pic_emotion07_1.png");
                    break;
                case 8:
                    this.Zu = com.baidu.tbadk.util.b.DS().fd("pic_emotion08.png");
                    this.Zv = com.baidu.tbadk.util.b.DS().fd("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Zn.getLayoutParams();
            if (aaVar.ZF >= 0) {
                layoutParams.setMargins(0, aaVar.ZF, 0, 0);
            }
            if (aaVar.mHeight > 0 && aaVar.mWidth > 0) {
                layoutParams.height = aaVar.mHeight;
                layoutParams.width = aaVar.mWidth;
            }
            this.Zn.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(z zVar) {
        if (zVar == null) {
            this.Zr.setVisibility(8);
            this.Zw.setVisibility(8);
            return;
        }
        y yVar = zVar.ZB;
        y yVar2 = zVar.ZC;
        if (yVar2 == null && yVar != null) {
            this.Zr.setOnClickListener(yVar.ZA);
            this.Zr.setText(yVar.mText);
            this.Zr.setVisibility(0);
            if (zVar.ZD >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Zr.getLayoutParams();
                layoutParams.topMargin = zVar.ZD;
                this.Zr.setLayoutParams(layoutParams);
            }
        }
        if (yVar2 != null && yVar != null) {
            this.Zs = (TextView) this.Zw.findViewById(com.baidu.tieba.q.btn_left);
            this.Zt = (TextView) this.Zw.findViewById(com.baidu.tieba.q.btn_right);
            this.Zs.setOnClickListener(yVar.ZA);
            this.Zs.setText(yVar.mText);
            this.Zt.setOnClickListener(yVar2.ZA);
            this.Zt.setText(yVar2.mText);
            this.Zw.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.j<?> jVar) {
        onChangeSkinType(jVar, TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void onActivityStop() {
        this.Zn.setBackgroundResource(0);
    }
}
