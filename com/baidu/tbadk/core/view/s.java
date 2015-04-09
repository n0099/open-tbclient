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
    private static /* synthetic */ int[] YB;
    private NoDataViewFactory.ImgType YA;
    private TbImageView Yq;
    private TextView Yr;
    private TextView Ys;
    private TextView Yt;
    private TextView Yu;
    private TextView Yv;
    private TextView Yw;
    private String Yx;
    private String Yy;
    private View Yz;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] tL() {
        int[] iArr = YB;
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
            YB = iArr;
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
        this.Yq = (TbImageView) this.mRootView.findViewById(com.baidu.tieba.v.iv_no_data_img);
        this.Yq.setDefaultBgResource(0);
        this.Yq.setDefaultResource(0);
        this.Yr = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.tv_text_reamrk);
        this.Ys = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.tv_subtitle);
        this.Yt = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.tv_title);
        this.Yu = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.btn_func);
        this.Yz = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.v.two_button_layout);
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
        if (this.YA == NoDataViewFactory.ImgType.WEBVIEW) {
            ba.a(this.Yq, com.baidu.tieba.u.pic_emotion08, i);
        } else if (i == 1) {
            this.Yq.c(this.Yy, 29, false);
        } else {
            this.Yq.c(this.Yx, 29, false);
        }
    }

    public void setTextOption(w wVar) {
        if (wVar != null) {
            if (!TextUtils.isEmpty(wVar.mTitle)) {
                this.Yt.setText(wVar.mTitle);
                this.Yt.setVisibility(0);
            } else {
                this.Yt.setVisibility(8);
            }
            if (!TextUtils.isEmpty(wVar.YH)) {
                this.Ys.setText(wVar.YH);
                if (TextUtils.isEmpty(wVar.mTitle)) {
                    this.Ys.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.fontsize28));
                }
            } else {
                this.Ys.setVisibility(8);
            }
            if (!TextUtils.isEmpty(wVar.YI)) {
                this.Yr.setText(wVar.YI);
                this.Yr.setVisibility(0);
                return;
            }
            this.Yr.setVisibility(8);
        }
    }

    public void setImgOption(v vVar) {
        if (vVar != null) {
            this.YA = vVar.YF;
            switch (tL()[vVar.YF.ordinal()]) {
                case 2:
                    this.Yx = com.baidu.tbadk.util.b.Di().eI("pic_emotion03.png");
                    this.Yy = com.baidu.tbadk.util.b.Di().eI("pic_emotion03_1.png");
                    break;
                case 3:
                    this.Yx = com.baidu.tbadk.util.b.Di().eI("pic_emotion05.png");
                    this.Yy = com.baidu.tbadk.util.b.Di().eI("pic_emotion05_1.png");
                    break;
                case 4:
                    this.Yx = com.baidu.tbadk.util.b.Di().eI("pic_emotion01.png");
                    this.Yy = com.baidu.tbadk.util.b.Di().eI("pic_emotion01_1.png");
                    break;
                case 5:
                    this.Yx = com.baidu.tbadk.util.b.Di().eI("pic_emotion02.png");
                    this.Yy = com.baidu.tbadk.util.b.Di().eI("pic_emotion02_1.png");
                    break;
                case 6:
                    this.Yx = com.baidu.tbadk.util.b.Di().eI("pic_emotion06.png");
                    this.Yy = com.baidu.tbadk.util.b.Di().eI("pic_emotion06_1.png");
                    break;
                case 7:
                    this.Yx = com.baidu.tbadk.util.b.Di().eI("pic_emotion07.png");
                    this.Yy = com.baidu.tbadk.util.b.Di().eI("pic_emotion07_1.png");
                    break;
                case 8:
                    this.Yx = com.baidu.tbadk.util.b.Di().eI("pic_emotion08.png");
                    this.Yy = com.baidu.tbadk.util.b.Di().eI("pic_emotion08_1.png");
                    break;
            }
            if (vVar.mHeight >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Yq.getLayoutParams();
                layoutParams.setMargins(0, vVar.mHeight, 0, 0);
                this.Yq.setLayoutParams(layoutParams);
            }
        }
    }

    public void setButtonOption(u uVar) {
        if (uVar == null) {
            this.Yu.setVisibility(8);
            this.Yz.setVisibility(8);
            return;
        }
        t tVar = uVar.YD;
        t tVar2 = uVar.YE;
        if (tVar2 == null && tVar != null) {
            this.Yu.setOnClickListener(tVar.YC);
            this.Yu.setText(tVar.mText);
            this.Yu.setVisibility(0);
        }
        if (tVar2 != null && tVar != null) {
            this.Yv = (TextView) this.Yz.findViewById(com.baidu.tieba.v.btn_left);
            this.Yw = (TextView) this.Yz.findViewById(com.baidu.tieba.v.btn_right);
            this.Yv.setOnClickListener(tVar.YC);
            this.Yv.setText(tVar.mText);
            this.Yw.setOnClickListener(tVar2.YC);
            this.Yw.setText(tVar2.mText);
            this.Yz.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.j<?> jVar) {
        onChangeSkinType(jVar, TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void onActivityStop() {
        this.Yq.setBackgroundResource(0);
    }
}
