package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f extends LinearLayout {
    private TbImageView akS;
    private TextView akT;
    private TextView akU;
    private TextView akV;
    private TextView akW;
    private TextView akX;
    private TextView akY;
    private String akZ;
    private String ala;
    private View alb;
    private NoDataViewFactory.ImgType alc;
    private int ald;
    private Context mContext;
    private View mRootView;

    public f(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.no_data_view, this);
        this.akS = (TbImageView) this.mRootView.findViewById(d.h.iv_no_data_img);
        this.akS.setDefaultBgResource(0);
        this.akS.setDefaultResource(0);
        this.akS.setDefaultErrorResource(0);
        this.akT = (TextView) this.mRootView.findViewById(d.h.tv_text_reamrk);
        this.akU = (TextView) this.mRootView.findViewById(d.h.tv_subtitle);
        this.akV = (TextView) this.mRootView.findViewById(d.h.tv_title);
        this.akW = (TextView) this.mRootView.findViewById(d.h.btn_func);
        this.alb = (LinearLayout) this.mRootView.findViewById(d.h.two_button_layout);
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
        if (this.alc == NoDataViewFactory.ImgType.WEBVIEW) {
            this.akS.setImageBitmap(aj.cS(d.g.pic_emotion08));
        } else if (this.alc == NoDataViewFactory.ImgType.NODATA) {
            this.akS.setImageBitmap(aj.cS(d.g.no_data_image));
        } else if (this.alc == NoDataViewFactory.ImgType.LOCAL) {
            this.akS.setImageBitmap(aj.cS(this.ald));
        } else if (i == 1) {
            this.akS.c(this.ala, 29, false);
        } else {
            this.akS.c(this.akZ, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.akV.setText(dVar.mTitle);
                this.akV.setVisibility(0);
            } else {
                this.akV.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.VG)) {
                this.akU.setText(dVar.VG);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.akU.setTextSize(0, getResources().getDimension(d.f.fontsize28));
                    if (dVar.alo >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akU.getLayoutParams();
                        layoutParams.topMargin = dVar.alo;
                        this.akU.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.alp != 0) {
                    setSubTitleCompoundDrawable(dVar.alp);
                }
            } else {
                this.akU.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.aln)) {
                this.akT.setText(dVar.aln);
                this.akT.setVisibility(0);
                return;
            }
            this.akT.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.alc = cVar.alj;
            this.ald = cVar.ald;
            switch (cVar.alj) {
                case CREATE:
                    this.akZ = com.baidu.tbadk.util.b.Gw().gA("pic_emotion03.png");
                    this.ala = com.baidu.tbadk.util.b.Gw().gA("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.akZ = com.baidu.tbadk.util.b.Gw().gA("pic_emotion05.png");
                    this.ala = com.baidu.tbadk.util.b.Gw().gA("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.akZ = com.baidu.tbadk.util.b.Gw().gA("pic_emotion01.png");
                    this.ala = com.baidu.tbadk.util.b.Gw().gA("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.akZ = com.baidu.tbadk.util.b.Gw().gA("pic_emotion02.png");
                    this.ala = com.baidu.tbadk.util.b.Gw().gA("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.akZ = com.baidu.tbadk.util.b.Gw().gA("pic_emotion07.png");
                    this.ala = com.baidu.tbadk.util.b.Gw().gA("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.akZ = com.baidu.tbadk.util.b.Gw().gA("pic_emotion06.png");
                    this.ala = com.baidu.tbadk.util.b.Gw().gA("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.akZ = com.baidu.tbadk.util.b.Gw().gA("pic_emotion08.png");
                    this.ala = com.baidu.tbadk.util.b.Gw().gA("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akS.getLayoutParams();
            if (cVar.alk >= 0) {
                layoutParams.setMargins(0, cVar.alk, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.akS.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.akW.setVisibility(8);
            this.alb.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.alg;
        NoDataViewFactory.a aVar2 = bVar.alh;
        if (aVar2 == null && aVar != null) {
            this.akW.setOnClickListener(aVar.alf);
            this.akW.setText(aVar.aer);
            this.akW.setVisibility(0);
            if (bVar.ali >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akW.getLayoutParams();
                layoutParams.topMargin = bVar.ali;
                this.akW.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.akX = (TextView) this.alb.findViewById(d.h.btn_left);
            this.akY = (TextView) this.alb.findViewById(d.h.btn_right);
            this.akX.setOnClickListener(aVar.alf);
            this.akX.setText(aVar.aer);
            this.akY.setOnClickListener(aVar2.alf);
            this.akY.setText(aVar2.aer);
            this.alb.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.akS.setImageDrawable(null);
        this.akS.c(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.akV != null) {
            aj.c(this.akV, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.akU != null) {
            aj.c(this.akU, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.akT != null) {
            aj.c(this.akT, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = aj.getDrawable(i);
        int f = l.f(this.mContext, d.f.ds32);
        int f2 = l.f(this.mContext, d.f.ds8);
        drawable.setBounds(0, 0, f, f);
        this.akU.setCompoundDrawablePadding(f2);
        this.akU.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.akU;
    }
}
