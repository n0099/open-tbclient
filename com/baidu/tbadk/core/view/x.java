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
    private static /* synthetic */ int[] Nq;
    private TbImageView Ng;
    private TextView Nh;
    private TextView Ni;
    private TextView Nj;
    private TextView Nk;
    private TextView Nl;
    private TextView Nm;
    private String Nn;
    private String No;
    private View Np;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] qA() {
        int[] iArr = Nq;
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
            Nq = iArr;
        }
        return iArr;
    }

    public x(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.no_data_view, this);
        this.Ng = (TbImageView) this.mRootView.findViewById(com.baidu.tieba.w.iv_no_data_img);
        this.Ng.setDefaultBgResource(0);
        this.Ng.setDefaultResource(0);
        this.Ng.setSupportNoImage(false);
        this.Nh = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.tv_text_reamrk);
        this.Ni = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.tv_subtitle);
        this.Nj = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.tv_title);
        this.Nk = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.btn_func);
        this.Np = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.two_button_layout);
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
            this.Ng.d(this.No, 29, false);
        } else {
            this.Ng.d(this.Nn, 29, false);
        }
    }

    public void setTextOption(ab abVar) {
        if (abVar != null) {
            if (!TextUtils.isEmpty(abVar.mTitle)) {
                this.Nj.setText(abVar.mTitle);
                this.Nj.setVisibility(0);
            } else {
                this.Nj.setVisibility(8);
            }
            if (!TextUtils.isEmpty(abVar.Nw)) {
                this.Ni.setText(abVar.Nw);
                if (TextUtils.isEmpty(abVar.mTitle)) {
                    this.Ni.setTextSize(0, getResources().getDimension(com.baidu.tieba.u.fontsize28));
                }
            } else {
                this.Ni.setVisibility(8);
            }
            if (!TextUtils.isEmpty(abVar.Nx)) {
                this.Nh.setText(abVar.Nx);
                this.Nh.setVisibility(0);
                return;
            }
            this.Nh.setVisibility(8);
        }
    }

    public void setImgOption(aa aaVar) {
        if (aaVar != null) {
            switch (qA()[aaVar.Nu.ordinal()]) {
                case 2:
                    this.Nn = com.baidu.tbadk.util.b.zI().eA("pic_emotion03.png");
                    this.No = com.baidu.tbadk.util.b.zI().eA("pic_emotion03_1.png");
                    break;
                case 3:
                    this.Nn = com.baidu.tbadk.util.b.zI().eA("pic_emotion05.png");
                    this.No = com.baidu.tbadk.util.b.zI().eA("pic_emotion05_1.png");
                    break;
                case 4:
                    this.Nn = com.baidu.tbadk.util.b.zI().eA("pic_emotion01.png");
                    this.No = com.baidu.tbadk.util.b.zI().eA("pic_emotion01_1.png");
                    break;
                case 5:
                    this.Nn = com.baidu.tbadk.util.b.zI().eA("pic_emotion02.png");
                    this.No = com.baidu.tbadk.util.b.zI().eA("pic_emotion02_1.png");
                    break;
                case 6:
                    this.Nn = com.baidu.tbadk.util.b.zI().eA("pic_emotion06.png");
                    this.No = com.baidu.tbadk.util.b.zI().eA("pic_emotion06_1.png");
                    break;
                case 7:
                    this.Nn = com.baidu.tbadk.util.b.zI().eA("pic_emotion07.png");
                    this.No = com.baidu.tbadk.util.b.zI().eA("pic_emotion07_1.png");
                    break;
            }
            if (aaVar.mHeight >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Ng.getLayoutParams();
                layoutParams.setMargins(0, aaVar.mHeight, 0, 0);
                this.Ng.setLayoutParams(layoutParams);
            }
        }
    }

    public void setButtonOption(z zVar) {
        if (zVar == null) {
            this.Nk.setVisibility(8);
            this.Np.setVisibility(8);
            return;
        }
        y yVar = zVar.Ns;
        y yVar2 = zVar.Nt;
        if (yVar2 == null && yVar != null) {
            this.Nk.setOnClickListener(yVar.Nr);
            this.Nk.setText(yVar.mText);
            this.Nk.setVisibility(0);
        }
        if (yVar2 != null && yVar != null) {
            this.Nl = (TextView) this.Np.findViewById(com.baidu.tieba.w.btn_left);
            this.Nm = (TextView) this.Np.findViewById(com.baidu.tieba.w.btn_right);
            this.Nl.setOnClickListener(yVar.Nr);
            this.Nl.setText(yVar.mText);
            this.Nm.setOnClickListener(yVar2.Nr);
            this.Nm.setText(yVar2.mText);
            this.Np.setVisibility(0);
        }
    }

    public void f(com.baidu.adp.base.j<?> jVar) {
        onChangeSkinType(jVar, TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void onActivityStop() {
        this.Ng.setBackgroundResource(0);
    }
}
