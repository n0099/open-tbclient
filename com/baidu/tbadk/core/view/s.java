package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class s extends LinearLayout {
    private static /* synthetic */ int[] Yz;
    private TbImageView Yo;
    private TextView Yp;
    private TextView Yq;
    private TextView Yr;
    private TextView Ys;
    private TextView Yt;
    private TextView Yu;
    private String Yv;
    private String Yw;
    private View Yx;
    private NoDataViewFactory.ImgType Yy;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] tL() {
        int[] iArr = Yz;
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
            try {
                iArr[NoDataViewFactory.ImgType.WEBVIEW.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            Yz = iArr;
        }
        return iArr;
    }

    public s(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.no_data_view, this);
        this.Yo = (TbImageView) this.mRootView.findViewById(com.baidu.tieba.v.iv_no_data_img);
        this.Yo.setDefaultBgResource(0);
        this.Yo.setDefaultResource(0);
        this.Yp = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.tv_text_reamrk);
        this.Yq = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.tv_subtitle);
        this.Yr = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.tv_title);
        this.Ys = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.btn_func);
        this.Yx = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.v.two_button_layout);
    }

    public void a(u uVar, v vVar, w wVar) {
        setButtonOption(uVar);
        setImgOption(vVar);
        setTextOption(wVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.j<?> jVar, int i) {
        if (jVar instanceof TbPageContext) {
            ((TbPageContext) jVar).getLayoutMode().X(i == 1);
            ((TbPageContext) jVar).getLayoutMode().h(this);
        }
        if (this.Yy == NoDataViewFactory.ImgType.WEBVIEW) {
            ba.a(this.Yo, com.baidu.tieba.u.pic_emotion08, i);
        } else if (i == 1) {
            this.Yo.c(this.Yw, 29, false);
        } else {
            this.Yo.c(this.Yv, 29, false);
        }
    }

    public void setTextOption(w wVar) {
        if (wVar != null) {
            if (!TextUtils.isEmpty(wVar.mTitle)) {
                this.Yr.setText(wVar.mTitle);
                this.Yr.setVisibility(0);
            } else {
                this.Yr.setVisibility(8);
            }
            if (!TextUtils.isEmpty(wVar.YF)) {
                this.Yq.setText(wVar.YF);
                if (TextUtils.isEmpty(wVar.mTitle)) {
                    this.Yq.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.fontsize28));
                }
            } else {
                this.Yq.setVisibility(8);
            }
            if (!TextUtils.isEmpty(wVar.YG)) {
                this.Yp.setText(wVar.YG);
                this.Yp.setVisibility(0);
                return;
            }
            this.Yp.setVisibility(8);
        }
    }

    public void setImgOption(v vVar) {
        if (vVar != null) {
            this.Yy = vVar.YD;
            switch (tL()[vVar.YD.ordinal()]) {
                case 2:
                    this.Yv = com.baidu.tbadk.util.b.Dc().eF("pic_emotion03.png");
                    this.Yw = com.baidu.tbadk.util.b.Dc().eF("pic_emotion03_1.png");
                    break;
                case 3:
                    this.Yv = com.baidu.tbadk.util.b.Dc().eF("pic_emotion05.png");
                    this.Yw = com.baidu.tbadk.util.b.Dc().eF("pic_emotion05_1.png");
                    break;
                case 4:
                    this.Yv = com.baidu.tbadk.util.b.Dc().eF("pic_emotion01.png");
                    this.Yw = com.baidu.tbadk.util.b.Dc().eF("pic_emotion01_1.png");
                    break;
                case 5:
                    this.Yv = com.baidu.tbadk.util.b.Dc().eF("pic_emotion02.png");
                    this.Yw = com.baidu.tbadk.util.b.Dc().eF("pic_emotion02_1.png");
                    break;
                case 6:
                    this.Yv = com.baidu.tbadk.util.b.Dc().eF("pic_emotion06.png");
                    this.Yw = com.baidu.tbadk.util.b.Dc().eF("pic_emotion06_1.png");
                    break;
                case 7:
                    this.Yv = com.baidu.tbadk.util.b.Dc().eF("pic_emotion07.png");
                    this.Yw = com.baidu.tbadk.util.b.Dc().eF("pic_emotion07_1.png");
                    break;
                case 8:
                    this.Yv = com.baidu.tbadk.util.b.Dc().eF("pic_emotion08.png");
                    this.Yw = com.baidu.tbadk.util.b.Dc().eF("pic_emotion08_1.png");
                    break;
            }
            if (vVar.mHeight >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Yo.getLayoutParams();
                layoutParams.setMargins(0, vVar.mHeight, 0, 0);
                this.Yo.setLayoutParams(layoutParams);
            }
        }
    }

    public void setButtonOption(u uVar) {
        if (uVar == null) {
            this.Ys.setVisibility(8);
            this.Yx.setVisibility(8);
            return;
        }
        t tVar = uVar.YB;
        t tVar2 = uVar.YC;
        if (tVar2 == null && tVar != null) {
            this.Ys.setOnClickListener(tVar.YA);
            this.Ys.setText(tVar.mText);
            this.Ys.setVisibility(0);
        }
        if (tVar2 != null && tVar != null) {
            this.Yt = (TextView) this.Yx.findViewById(com.baidu.tieba.v.btn_left);
            this.Yu = (TextView) this.Yx.findViewById(com.baidu.tieba.v.btn_right);
            this.Yt.setOnClickListener(tVar.YA);
            this.Yt.setText(tVar.mText);
            this.Yu.setOnClickListener(tVar2.YA);
            this.Yu.setText(tVar2.mText);
            this.Yx.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.j<?> jVar) {
        onChangeSkinType(jVar, TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void onActivityStop() {
        this.Yo.setBackgroundResource(0);
    }
}
