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
    private int alA;
    private TbImageView alp;
    private TextView alq;
    private TextView alr;
    private TextView als;
    private TextView alt;
    private TextView alu;
    private TextView alv;
    private String alw;
    private String alx;
    private View aly;
    private NoDataViewFactory.ImgType alz;
    private Context mContext;
    private View mRootView;

    public f(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.no_data_view, this);
        this.alp = (TbImageView) this.mRootView.findViewById(d.g.iv_no_data_img);
        this.alp.setDefaultBgResource(0);
        this.alp.setDefaultResource(0);
        this.alp.setDefaultErrorResource(0);
        this.alq = (TextView) this.mRootView.findViewById(d.g.tv_text_reamrk);
        this.alr = (TextView) this.mRootView.findViewById(d.g.tv_subtitle);
        this.als = (TextView) this.mRootView.findViewById(d.g.tv_title);
        this.alt = (TextView) this.mRootView.findViewById(d.g.btn_func);
        this.aly = (LinearLayout) this.mRootView.findViewById(d.g.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().ag(i == 1);
            ((TbPageContext) eVar).getLayoutMode().t(this);
        }
        if (this.alz == NoDataViewFactory.ImgType.WEBVIEW) {
            this.alp.setImageBitmap(aj.cT(d.f.pic_emotion08));
        } else if (this.alz == NoDataViewFactory.ImgType.NODATA) {
            this.alp.setImageBitmap(aj.cT(d.f.no_data_image));
        } else if (this.alz == NoDataViewFactory.ImgType.LOCAL) {
            this.alp.setImageBitmap(aj.cT(this.alA));
        } else if (i == 1) {
            this.alp.startLoad(this.alx, 29, false);
        } else {
            this.alp.startLoad(this.alw, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.als.setText(dVar.mTitle);
                this.als.setVisibility(0);
            } else {
                this.als.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.VY)) {
                this.alr.setText(dVar.VY);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.alr.setTextSize(0, getResources().getDimension(d.e.fontsize28));
                    if (dVar.alK >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alr.getLayoutParams();
                        layoutParams.topMargin = dVar.alK;
                        this.alr.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.alL != 0) {
                    setSubTitleCompoundDrawable(dVar.alL);
                }
            } else {
                this.alr.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.alJ)) {
                this.alq.setText(dVar.alJ);
                this.alq.setVisibility(0);
                return;
            }
            this.alq.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.alz = cVar.alG;
            this.alA = cVar.alA;
            switch (cVar.alG) {
                case CREATE:
                    this.alw = com.baidu.tbadk.util.b.GI().gH("pic_emotion03.png");
                    this.alx = com.baidu.tbadk.util.b.GI().gH("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.alw = com.baidu.tbadk.util.b.GI().gH("pic_emotion05.png");
                    this.alx = com.baidu.tbadk.util.b.GI().gH("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.alw = com.baidu.tbadk.util.b.GI().gH("pic_emotion01.png");
                    this.alx = com.baidu.tbadk.util.b.GI().gH("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.alw = com.baidu.tbadk.util.b.GI().gH("pic_emotion02.png");
                    this.alx = com.baidu.tbadk.util.b.GI().gH("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.alw = com.baidu.tbadk.util.b.GI().gH("pic_emotion07.png");
                    this.alx = com.baidu.tbadk.util.b.GI().gH("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.alw = com.baidu.tbadk.util.b.GI().gH("pic_emotion06.png");
                    this.alx = com.baidu.tbadk.util.b.GI().gH("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.alw = com.baidu.tbadk.util.b.GI().gH("pic_emotion08.png");
                    this.alx = com.baidu.tbadk.util.b.GI().gH("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alp.getLayoutParams();
            if (cVar.alH >= 0) {
                layoutParams.setMargins(0, cVar.alH, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.alp.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.alt.setVisibility(8);
            this.aly.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.alD;
        NoDataViewFactory.a aVar2 = bVar.alE;
        if (aVar2 == null && aVar != null) {
            this.alt.setOnClickListener(aVar.alC);
            this.alt.setText(aVar.aeM);
            this.alt.setVisibility(0);
            if (bVar.alF >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alt.getLayoutParams();
                layoutParams.topMargin = bVar.alF;
                this.alt.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.alu = (TextView) this.aly.findViewById(d.g.btn_left);
            this.alv = (TextView) this.aly.findViewById(d.g.btn_right);
            this.alu.setOnClickListener(aVar.alC);
            this.alu.setText(aVar.aeM);
            this.alv.setOnClickListener(aVar2.alC);
            this.alv.setText(aVar2.aeM);
            this.aly.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.alp.setImageDrawable(null);
        this.alp.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.als != null) {
            aj.c(this.als, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.alr != null) {
            aj.c(this.alr, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.alq != null) {
            aj.c(this.alq, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = aj.getDrawable(i);
        int f = l.f(this.mContext, d.e.ds32);
        int f2 = l.f(this.mContext, d.e.ds8);
        drawable.setBounds(0, 0, f, f);
        this.alr.setCompoundDrawablePadding(f2);
        this.alr.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.alr;
    }
}
