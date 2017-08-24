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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private View amA;
    private NoDataViewFactory.ImgType amB;
    private int amC;
    private TbImageView amr;
    private TextView ams;
    private TextView amt;
    private TextView amu;
    private TextView amv;
    private TextView amw;
    private TextView amx;
    private String amy;
    private String amz;
    private Context mContext;
    private View mRootView;

    public j(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.no_data_view, this);
        this.amr = (TbImageView) this.mRootView.findViewById(d.h.iv_no_data_img);
        this.amr.setDefaultBgResource(0);
        this.amr.setDefaultResource(0);
        this.amr.setDefaultErrorResource(0);
        this.ams = (TextView) this.mRootView.findViewById(d.h.tv_text_reamrk);
        this.amt = (TextView) this.mRootView.findViewById(d.h.tv_subtitle);
        this.amu = (TextView) this.mRootView.findViewById(d.h.tv_title);
        this.amv = (TextView) this.mRootView.findViewById(d.h.btn_func);
        this.amA = (LinearLayout) this.mRootView.findViewById(d.h.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().ah(i == 1);
            ((TbPageContext) eVar).getLayoutMode().t(this);
        }
        if (this.amB == NoDataViewFactory.ImgType.WEBVIEW) {
            this.amr.setImageBitmap(ai.cU(d.g.pic_emotion08));
        } else if (this.amB == NoDataViewFactory.ImgType.NODATA) {
            this.amr.setImageBitmap(ai.cU(d.g.no_data_image));
        } else if (this.amB == NoDataViewFactory.ImgType.LOCAL) {
            this.amr.setImageBitmap(ai.cU(this.amC));
        } else if (i == 1) {
            this.amr.c(this.amz, 29, false);
        } else {
            this.amr.c(this.amy, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.amu.setText(dVar.mTitle);
                this.amu.setVisibility(0);
            } else {
                this.amu.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.amt.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.amt.setTextSize(0, getResources().getDimension(d.f.fontsize28));
                    if (dVar.amM >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amt.getLayoutParams();
                        layoutParams.topMargin = dVar.amM;
                        this.amt.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.adg != 0) {
                    setSubTitleCompoundDrawable(dVar.adg);
                }
            } else {
                this.amt.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.amL)) {
                this.ams.setText(dVar.amL);
                this.ams.setVisibility(0);
                return;
            }
            this.ams.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.amB = cVar.amI;
            this.amC = cVar.amC;
            switch (cVar.amI) {
                case CREATE:
                    this.amy = com.baidu.tbadk.util.b.GY().gI("pic_emotion03.png");
                    this.amz = com.baidu.tbadk.util.b.GY().gI("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.amy = com.baidu.tbadk.util.b.GY().gI("pic_emotion05.png");
                    this.amz = com.baidu.tbadk.util.b.GY().gI("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.amy = com.baidu.tbadk.util.b.GY().gI("pic_emotion01.png");
                    this.amz = com.baidu.tbadk.util.b.GY().gI("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.amy = com.baidu.tbadk.util.b.GY().gI("pic_emotion02.png");
                    this.amz = com.baidu.tbadk.util.b.GY().gI("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.amy = com.baidu.tbadk.util.b.GY().gI("pic_emotion07.png");
                    this.amz = com.baidu.tbadk.util.b.GY().gI("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.amy = com.baidu.tbadk.util.b.GY().gI("pic_emotion06.png");
                    this.amz = com.baidu.tbadk.util.b.GY().gI("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.amy = com.baidu.tbadk.util.b.GY().gI("pic_emotion08.png");
                    this.amz = com.baidu.tbadk.util.b.GY().gI("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amr.getLayoutParams();
            if (cVar.amJ >= 0) {
                layoutParams.setMargins(0, cVar.amJ, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.amr.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.amv.setVisibility(8);
            this.amA.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.amF;
        NoDataViewFactory.a aVar2 = bVar.amG;
        if (aVar2 == null && aVar != null) {
            this.amv.setOnClickListener(aVar.amE);
            this.amv.setText(aVar.afX);
            this.amv.setVisibility(0);
            if (bVar.amH >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amv.getLayoutParams();
                layoutParams.topMargin = bVar.amH;
                this.amv.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.amw = (TextView) this.amA.findViewById(d.h.btn_left);
            this.amx = (TextView) this.amA.findViewById(d.h.btn_right);
            this.amw.setOnClickListener(aVar.amE);
            this.amw.setText(aVar.afX);
            this.amx.setOnClickListener(aVar2.amE);
            this.amx.setText(aVar2.afX);
            this.amA.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.amr.setImageDrawable(null);
        this.amr.c(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.amu != null) {
            ai.c(this.amu, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.amt != null) {
            ai.c(this.amt, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.ams != null) {
            ai.c(this.ams, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = ai.getDrawable(i);
        int g = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32);
        int g2 = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds8);
        drawable.setBounds(0, 0, g, g);
        this.amt.setCompoundDrawablePadding(g2);
        this.amt.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.amt;
    }
}
