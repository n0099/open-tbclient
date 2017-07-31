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
    private NoDataViewFactory.ImgType amA;
    private int amB;
    private TbImageView amq;
    private TextView amr;
    private TextView ams;
    private TextView amt;
    private TextView amu;
    private TextView amv;
    private TextView amw;
    private String amx;
    private String amy;
    private View amz;
    private Context mContext;
    private View mRootView;

    public j(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.no_data_view, this);
        this.amq = (TbImageView) this.mRootView.findViewById(d.h.iv_no_data_img);
        this.amq.setDefaultBgResource(0);
        this.amq.setDefaultResource(0);
        this.amq.setDefaultErrorResource(0);
        this.amr = (TextView) this.mRootView.findViewById(d.h.tv_text_reamrk);
        this.ams = (TextView) this.mRootView.findViewById(d.h.tv_subtitle);
        this.amt = (TextView) this.mRootView.findViewById(d.h.tv_title);
        this.amu = (TextView) this.mRootView.findViewById(d.h.btn_func);
        this.amz = (LinearLayout) this.mRootView.findViewById(d.h.two_button_layout);
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
        if (this.amA == NoDataViewFactory.ImgType.WEBVIEW) {
            this.amq.setImageBitmap(ai.cU(d.g.pic_emotion08));
        } else if (this.amA == NoDataViewFactory.ImgType.NODATA) {
            this.amq.setImageBitmap(ai.cU(d.g.no_data_image));
        } else if (this.amA == NoDataViewFactory.ImgType.LOCAL) {
            this.amq.setImageBitmap(ai.cU(this.amB));
        } else if (i == 1) {
            this.amq.c(this.amy, 29, false);
        } else {
            this.amq.c(this.amx, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.amt.setText(dVar.mTitle);
                this.amt.setVisibility(0);
            } else {
                this.amt.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.ams.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.ams.setTextSize(0, getResources().getDimension(d.f.fontsize28));
                    if (dVar.amL >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ams.getLayoutParams();
                        layoutParams.topMargin = dVar.amL;
                        this.ams.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.ade != 0) {
                    setSubTitleCompoundDrawable(dVar.ade);
                }
            } else {
                this.ams.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.amK)) {
                this.amr.setText(dVar.amK);
                this.amr.setVisibility(0);
                return;
            }
            this.amr.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.amA = cVar.amH;
            this.amB = cVar.amB;
            switch (cVar.amH) {
                case CREATE:
                    this.amx = com.baidu.tbadk.util.b.GY().gF("pic_emotion03.png");
                    this.amy = com.baidu.tbadk.util.b.GY().gF("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.amx = com.baidu.tbadk.util.b.GY().gF("pic_emotion05.png");
                    this.amy = com.baidu.tbadk.util.b.GY().gF("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.amx = com.baidu.tbadk.util.b.GY().gF("pic_emotion01.png");
                    this.amy = com.baidu.tbadk.util.b.GY().gF("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.amx = com.baidu.tbadk.util.b.GY().gF("pic_emotion02.png");
                    this.amy = com.baidu.tbadk.util.b.GY().gF("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.amx = com.baidu.tbadk.util.b.GY().gF("pic_emotion07.png");
                    this.amy = com.baidu.tbadk.util.b.GY().gF("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.amx = com.baidu.tbadk.util.b.GY().gF("pic_emotion06.png");
                    this.amy = com.baidu.tbadk.util.b.GY().gF("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.amx = com.baidu.tbadk.util.b.GY().gF("pic_emotion08.png");
                    this.amy = com.baidu.tbadk.util.b.GY().gF("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amq.getLayoutParams();
            if (cVar.amI >= 0) {
                layoutParams.setMargins(0, cVar.amI, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.amq.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.amu.setVisibility(8);
            this.amz.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.amE;
        NoDataViewFactory.a aVar2 = bVar.amF;
        if (aVar2 == null && aVar != null) {
            this.amu.setOnClickListener(aVar.amD);
            this.amu.setText(aVar.afV);
            this.amu.setVisibility(0);
            if (bVar.amG >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amu.getLayoutParams();
                layoutParams.topMargin = bVar.amG;
                this.amu.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.amv = (TextView) this.amz.findViewById(d.h.btn_left);
            this.amw = (TextView) this.amz.findViewById(d.h.btn_right);
            this.amv.setOnClickListener(aVar.amD);
            this.amv.setText(aVar.afV);
            this.amw.setOnClickListener(aVar2.amD);
            this.amw.setText(aVar2.afV);
            this.amz.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.amq.setImageDrawable(null);
        this.amq.c(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.amt != null) {
            ai.c(this.amt, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.ams != null) {
            ai.c(this.ams, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.amr != null) {
            ai.c(this.amr, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = ai.getDrawable(i);
        int g = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32);
        int g2 = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds8);
        drawable.setBounds(0, 0, g, g);
        this.ams.setCompoundDrawablePadding(g2);
        this.ams.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.ams;
    }
}
