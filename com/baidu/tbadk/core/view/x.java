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
    private static /* synthetic */ int[] Nt;
    private TbImageView Nj;
    private TextView Nk;
    private TextView Nl;
    private TextView Nm;
    private TextView Nn;
    private TextView No;
    private TextView Np;
    private String Nq;
    private String Nr;
    private View Ns;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] qG() {
        int[] iArr = Nt;
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
            Nt = iArr;
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
        this.Nj = (TbImageView) this.mRootView.findViewById(com.baidu.tieba.w.iv_no_data_img);
        this.Nj.setDefaultBgResource(0);
        this.Nj.setDefaultResource(0);
        this.Nj.setSupportNoImage(false);
        this.Nk = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.tv_text_reamrk);
        this.Nl = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.tv_subtitle);
        this.Nm = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.tv_title);
        this.Nn = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.btn_func);
        this.Ns = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.two_button_layout);
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
            this.Nj.d(this.Nr, 29, false);
        } else {
            this.Nj.d(this.Nq, 29, false);
        }
    }

    public void setTextOption(ab abVar) {
        if (abVar != null) {
            if (!TextUtils.isEmpty(abVar.mTitle)) {
                this.Nm.setText(abVar.mTitle);
                this.Nm.setVisibility(0);
            } else {
                this.Nm.setVisibility(8);
            }
            if (!TextUtils.isEmpty(abVar.Nz)) {
                this.Nl.setText(abVar.Nz);
                if (TextUtils.isEmpty(abVar.mTitle)) {
                    this.Nl.setTextSize(0, getResources().getDimension(com.baidu.tieba.u.fontsize28));
                }
            } else {
                this.Nl.setVisibility(8);
            }
            if (!TextUtils.isEmpty(abVar.NA)) {
                this.Nk.setText(abVar.NA);
                this.Nk.setVisibility(0);
                return;
            }
            this.Nk.setVisibility(8);
        }
    }

    public void setImgOption(aa aaVar) {
        if (aaVar != null) {
            switch (qG()[aaVar.Nx.ordinal()]) {
                case 2:
                    this.Nq = com.baidu.tbadk.util.b.zO().eD("pic_emotion03.png");
                    this.Nr = com.baidu.tbadk.util.b.zO().eD("pic_emotion03_1.png");
                    break;
                case 3:
                    this.Nq = com.baidu.tbadk.util.b.zO().eD("pic_emotion05.png");
                    this.Nr = com.baidu.tbadk.util.b.zO().eD("pic_emotion05_1.png");
                    break;
                case 4:
                    this.Nq = com.baidu.tbadk.util.b.zO().eD("pic_emotion01.png");
                    this.Nr = com.baidu.tbadk.util.b.zO().eD("pic_emotion01_1.png");
                    break;
                case 5:
                    this.Nq = com.baidu.tbadk.util.b.zO().eD("pic_emotion02.png");
                    this.Nr = com.baidu.tbadk.util.b.zO().eD("pic_emotion02_1.png");
                    break;
                case 6:
                    this.Nq = com.baidu.tbadk.util.b.zO().eD("pic_emotion06.png");
                    this.Nr = com.baidu.tbadk.util.b.zO().eD("pic_emotion06_1.png");
                    break;
                case 7:
                    this.Nq = com.baidu.tbadk.util.b.zO().eD("pic_emotion07.png");
                    this.Nr = com.baidu.tbadk.util.b.zO().eD("pic_emotion07_1.png");
                    break;
            }
            if (aaVar.mHeight >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Nj.getLayoutParams();
                layoutParams.setMargins(0, aaVar.mHeight, 0, 0);
                this.Nj.setLayoutParams(layoutParams);
            }
        }
    }

    public void setButtonOption(z zVar) {
        if (zVar == null) {
            this.Nn.setVisibility(8);
            this.Ns.setVisibility(8);
            return;
        }
        y yVar = zVar.Nv;
        y yVar2 = zVar.Nw;
        if (yVar2 == null && yVar != null) {
            this.Nn.setOnClickListener(yVar.Nu);
            this.Nn.setText(yVar.mText);
            this.Nn.setVisibility(0);
        }
        if (yVar2 != null && yVar != null) {
            this.No = (TextView) this.Ns.findViewById(com.baidu.tieba.w.btn_left);
            this.Np = (TextView) this.Ns.findViewById(com.baidu.tieba.w.btn_right);
            this.No.setOnClickListener(yVar.Nu);
            this.No.setText(yVar.mText);
            this.Np.setOnClickListener(yVar2.Nu);
            this.Np.setText(yVar2.mText);
            this.Ns.setVisibility(0);
        }
    }

    public void f(com.baidu.adp.base.j<?> jVar) {
        onChangeSkinType(jVar, TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void onActivityStop() {
        this.Nj.setBackgroundResource(0);
    }
}
