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
    private TbImageView akW;
    private TextView akX;
    private TextView akY;
    private TextView akZ;
    private TextView ala;
    private TextView alb;
    private TextView alc;
    private String ald;
    private String ale;
    private View alf;
    private NoDataViewFactory.ImgType alg;
    private int alh;
    private Context mContext;
    private View mRootView;

    public j(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.no_data_view, this);
        this.akW = (TbImageView) this.mRootView.findViewById(d.h.iv_no_data_img);
        this.akW.setDefaultBgResource(0);
        this.akW.setDefaultResource(0);
        this.akW.setDefaultErrorResource(0);
        this.akX = (TextView) this.mRootView.findViewById(d.h.tv_text_reamrk);
        this.akY = (TextView) this.mRootView.findViewById(d.h.tv_subtitle);
        this.akZ = (TextView) this.mRootView.findViewById(d.h.tv_title);
        this.ala = (TextView) this.mRootView.findViewById(d.h.btn_func);
        this.alf = (LinearLayout) this.mRootView.findViewById(d.h.two_button_layout);
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
        if (this.alg == NoDataViewFactory.ImgType.WEBVIEW) {
            this.akW.setImageBitmap(ai.cS(d.g.pic_emotion08));
        } else if (this.alg == NoDataViewFactory.ImgType.NODATA) {
            this.akW.setImageBitmap(ai.cS(d.g.no_data_image));
        } else if (this.alg == NoDataViewFactory.ImgType.LOCAL) {
            this.akW.setImageBitmap(ai.cS(this.alh));
        } else if (i == 1) {
            this.akW.c(this.ale, 29, false);
        } else {
            this.akW.c(this.ald, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.akZ.setText(dVar.mTitle);
                this.akZ.setVisibility(0);
            } else {
                this.akZ.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.akY.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.akY.setTextSize(0, getResources().getDimension(d.f.fontsize28));
                    if (dVar.als >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akY.getLayoutParams();
                        layoutParams.topMargin = dVar.als;
                        this.akY.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.abH != 0) {
                    setSubTitleCompoundDrawable(dVar.abH);
                }
            } else {
                this.akY.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.alr)) {
                this.akX.setText(dVar.alr);
                this.akX.setVisibility(0);
                return;
            }
            this.akX.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.alg = cVar.alo;
            this.alh = cVar.alh;
            switch (cVar.alo) {
                case CREATE:
                    this.ald = com.baidu.tbadk.util.b.GQ().gA("pic_emotion03.png");
                    this.ale = com.baidu.tbadk.util.b.GQ().gA("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.ald = com.baidu.tbadk.util.b.GQ().gA("pic_emotion05.png");
                    this.ale = com.baidu.tbadk.util.b.GQ().gA("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.ald = com.baidu.tbadk.util.b.GQ().gA("pic_emotion01.png");
                    this.ale = com.baidu.tbadk.util.b.GQ().gA("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.ald = com.baidu.tbadk.util.b.GQ().gA("pic_emotion02.png");
                    this.ale = com.baidu.tbadk.util.b.GQ().gA("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.ald = com.baidu.tbadk.util.b.GQ().gA("pic_emotion07.png");
                    this.ale = com.baidu.tbadk.util.b.GQ().gA("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.ald = com.baidu.tbadk.util.b.GQ().gA("pic_emotion06.png");
                    this.ale = com.baidu.tbadk.util.b.GQ().gA("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.ald = com.baidu.tbadk.util.b.GQ().gA("pic_emotion08.png");
                    this.ale = com.baidu.tbadk.util.b.GQ().gA("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akW.getLayoutParams();
            if (cVar.alp >= 0) {
                layoutParams.setMargins(0, cVar.alp, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.akW.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.ala.setVisibility(8);
            this.alf.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.alk;
        NoDataViewFactory.a aVar2 = bVar.alm;
        if (aVar2 == null && aVar != null) {
            this.ala.setOnClickListener(aVar.alj);
            this.ala.setText(aVar.aeB);
            this.ala.setVisibility(0);
            if (bVar.aln >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ala.getLayoutParams();
                layoutParams.topMargin = bVar.aln;
                this.ala.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.alb = (TextView) this.alf.findViewById(d.h.btn_left);
            this.alc = (TextView) this.alf.findViewById(d.h.btn_right);
            this.alb.setOnClickListener(aVar.alj);
            this.alb.setText(aVar.aeB);
            this.alc.setOnClickListener(aVar2.alj);
            this.alc.setText(aVar2.aeB);
            this.alf.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.akW.setImageDrawable(null);
        this.akW.c(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.akZ != null) {
            ai.c(this.akZ, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.akY != null) {
            ai.c(this.akY, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.akX != null) {
            ai.c(this.akX, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = ai.getDrawable(i);
        int g = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32);
        int g2 = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds8);
        drawable.setBounds(0, 0, g, g);
        this.akY.setCompoundDrawablePadding(g2);
        this.akY.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.akY;
    }
}
