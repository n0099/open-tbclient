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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private TbImageView alL;
    private TextView alM;
    private TextView alN;
    private TextView alO;
    private TextView alP;
    private TextView alQ;
    private TextView alR;
    private String alS;
    private String alT;
    private View alU;
    private NoDataViewFactory.ImgType alV;
    private int alW;
    private Context mContext;
    private View mRootView;

    public j(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.no_data_view, this);
        this.alL = (TbImageView) this.mRootView.findViewById(d.h.iv_no_data_img);
        this.alL.setDefaultBgResource(0);
        this.alL.setDefaultResource(0);
        this.alL.setDefaultErrorResource(0);
        this.alM = (TextView) this.mRootView.findViewById(d.h.tv_text_reamrk);
        this.alN = (TextView) this.mRootView.findViewById(d.h.tv_subtitle);
        this.alO = (TextView) this.mRootView.findViewById(d.h.tv_title);
        this.alP = (TextView) this.mRootView.findViewById(d.h.btn_func);
        this.alU = (LinearLayout) this.mRootView.findViewById(d.h.two_button_layout);
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
        if (this.alV == NoDataViewFactory.ImgType.WEBVIEW) {
            this.alL.setImageBitmap(aj.cV(d.g.pic_emotion08));
        } else if (this.alV == NoDataViewFactory.ImgType.NODATA) {
            this.alL.setImageBitmap(aj.cV(d.g.no_data_image));
        } else if (this.alV == NoDataViewFactory.ImgType.LOCAL) {
            this.alL.setImageBitmap(aj.cV(this.alW));
        } else if (i == 1) {
            this.alL.c(this.alT, 29, false);
        } else {
            this.alL.c(this.alS, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.alO.setText(dVar.mTitle);
                this.alO.setVisibility(0);
            } else {
                this.alO.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.VE)) {
                this.alN.setText(dVar.VE);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.alN.setTextSize(0, getResources().getDimension(d.f.fontsize28));
                    if (dVar.amg >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alN.getLayoutParams();
                        layoutParams.topMargin = dVar.amg;
                        this.alN.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.acm != 0) {
                    setSubTitleCompoundDrawable(dVar.acm);
                }
            } else {
                this.alN.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.amf)) {
                this.alM.setText(dVar.amf);
                this.alM.setVisibility(0);
                return;
            }
            this.alM.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.alV = cVar.amc;
            this.alW = cVar.alW;
            switch (cVar.amc) {
                case CREATE:
                    this.alS = com.baidu.tbadk.util.b.GX().gE("pic_emotion03.png");
                    this.alT = com.baidu.tbadk.util.b.GX().gE("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.alS = com.baidu.tbadk.util.b.GX().gE("pic_emotion05.png");
                    this.alT = com.baidu.tbadk.util.b.GX().gE("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.alS = com.baidu.tbadk.util.b.GX().gE("pic_emotion01.png");
                    this.alT = com.baidu.tbadk.util.b.GX().gE("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.alS = com.baidu.tbadk.util.b.GX().gE("pic_emotion02.png");
                    this.alT = com.baidu.tbadk.util.b.GX().gE("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.alS = com.baidu.tbadk.util.b.GX().gE("pic_emotion07.png");
                    this.alT = com.baidu.tbadk.util.b.GX().gE("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.alS = com.baidu.tbadk.util.b.GX().gE("pic_emotion06.png");
                    this.alT = com.baidu.tbadk.util.b.GX().gE("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.alS = com.baidu.tbadk.util.b.GX().gE("pic_emotion08.png");
                    this.alT = com.baidu.tbadk.util.b.GX().gE("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alL.getLayoutParams();
            if (cVar.amd >= 0) {
                layoutParams.setMargins(0, cVar.amd, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.alL.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.alP.setVisibility(8);
            this.alU.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.alZ;
        NoDataViewFactory.a aVar2 = bVar.ama;
        if (aVar2 == null && aVar != null) {
            this.alP.setOnClickListener(aVar.alY);
            this.alP.setText(aVar.afh);
            this.alP.setVisibility(0);
            if (bVar.amb >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alP.getLayoutParams();
                layoutParams.topMargin = bVar.amb;
                this.alP.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.alQ = (TextView) this.alU.findViewById(d.h.btn_left);
            this.alR = (TextView) this.alU.findViewById(d.h.btn_right);
            this.alQ.setOnClickListener(aVar.alY);
            this.alQ.setText(aVar.afh);
            this.alR.setOnClickListener(aVar2.alY);
            this.alR.setText(aVar2.afh);
            this.alU.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.alL.setImageDrawable(null);
        this.alL.c(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.alO != null) {
            aj.c(this.alO, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.alN != null) {
            aj.c(this.alN, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.alM != null) {
            aj.c(this.alM, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = aj.getDrawable(i);
        int g = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32);
        int g2 = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds8);
        drawable.setBounds(0, 0, g, g);
        this.alN.setCompoundDrawablePadding(g2);
        this.alN.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.alN;
    }
}
