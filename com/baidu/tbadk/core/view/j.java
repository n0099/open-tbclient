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
    private TbImageView alJ;
    private TextView alK;
    private TextView alL;
    private TextView alM;
    private TextView alN;
    private TextView alO;
    private TextView alP;
    private String alQ;
    private String alR;
    private View alS;
    private NoDataViewFactory.ImgType alT;
    private int alU;
    private Context mContext;
    private View mRootView;

    public j(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.no_data_view, this);
        this.alJ = (TbImageView) this.mRootView.findViewById(d.h.iv_no_data_img);
        this.alJ.setDefaultBgResource(0);
        this.alJ.setDefaultResource(0);
        this.alJ.setDefaultErrorResource(0);
        this.alK = (TextView) this.mRootView.findViewById(d.h.tv_text_reamrk);
        this.alL = (TextView) this.mRootView.findViewById(d.h.tv_subtitle);
        this.alM = (TextView) this.mRootView.findViewById(d.h.tv_title);
        this.alN = (TextView) this.mRootView.findViewById(d.h.btn_func);
        this.alS = (LinearLayout) this.mRootView.findViewById(d.h.two_button_layout);
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
        if (this.alT == NoDataViewFactory.ImgType.WEBVIEW) {
            this.alJ.setImageBitmap(aj.cV(d.g.pic_emotion08));
        } else if (this.alT == NoDataViewFactory.ImgType.NODATA) {
            this.alJ.setImageBitmap(aj.cV(d.g.no_data_image));
        } else if (this.alT == NoDataViewFactory.ImgType.LOCAL) {
            this.alJ.setImageBitmap(aj.cV(this.alU));
        } else if (i == 1) {
            this.alJ.c(this.alR, 29, false);
        } else {
            this.alJ.c(this.alQ, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.alM.setText(dVar.mTitle);
                this.alM.setVisibility(0);
            } else {
                this.alM.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.VE)) {
                this.alL.setText(dVar.VE);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.alL.setTextSize(0, getResources().getDimension(d.f.fontsize28));
                    if (dVar.ame >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alL.getLayoutParams();
                        layoutParams.topMargin = dVar.ame;
                        this.alL.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.acm != 0) {
                    setSubTitleCompoundDrawable(dVar.acm);
                }
            } else {
                this.alL.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.amd)) {
                this.alK.setText(dVar.amd);
                this.alK.setVisibility(0);
                return;
            }
            this.alK.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.alT = cVar.ama;
            this.alU = cVar.alU;
            switch (cVar.ama) {
                case CREATE:
                    this.alQ = com.baidu.tbadk.util.b.GX().gE("pic_emotion03.png");
                    this.alR = com.baidu.tbadk.util.b.GX().gE("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.alQ = com.baidu.tbadk.util.b.GX().gE("pic_emotion05.png");
                    this.alR = com.baidu.tbadk.util.b.GX().gE("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.alQ = com.baidu.tbadk.util.b.GX().gE("pic_emotion01.png");
                    this.alR = com.baidu.tbadk.util.b.GX().gE("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.alQ = com.baidu.tbadk.util.b.GX().gE("pic_emotion02.png");
                    this.alR = com.baidu.tbadk.util.b.GX().gE("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.alQ = com.baidu.tbadk.util.b.GX().gE("pic_emotion07.png");
                    this.alR = com.baidu.tbadk.util.b.GX().gE("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.alQ = com.baidu.tbadk.util.b.GX().gE("pic_emotion06.png");
                    this.alR = com.baidu.tbadk.util.b.GX().gE("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.alQ = com.baidu.tbadk.util.b.GX().gE("pic_emotion08.png");
                    this.alR = com.baidu.tbadk.util.b.GX().gE("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alJ.getLayoutParams();
            if (cVar.amb >= 0) {
                layoutParams.setMargins(0, cVar.amb, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.alJ.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.alN.setVisibility(8);
            this.alS.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.alX;
        NoDataViewFactory.a aVar2 = bVar.alY;
        if (aVar2 == null && aVar != null) {
            this.alN.setOnClickListener(aVar.alW);
            this.alN.setText(aVar.afg);
            this.alN.setVisibility(0);
            if (bVar.alZ >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alN.getLayoutParams();
                layoutParams.topMargin = bVar.alZ;
                this.alN.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.alO = (TextView) this.alS.findViewById(d.h.btn_left);
            this.alP = (TextView) this.alS.findViewById(d.h.btn_right);
            this.alO.setOnClickListener(aVar.alW);
            this.alO.setText(aVar.afg);
            this.alP.setOnClickListener(aVar2.alW);
            this.alP.setText(aVar2.afg);
            this.alS.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.alJ.setImageDrawable(null);
        this.alJ.c(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.alM != null) {
            aj.c(this.alM, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.alL != null) {
            aj.c(this.alL, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.alK != null) {
            aj.c(this.alK, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = aj.getDrawable(i);
        int f = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds32);
        int f2 = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds8);
        drawable.setBounds(0, 0, f, f);
        this.alL.setCompoundDrawablePadding(f2);
        this.alL.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.alL;
    }
}
