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
    private TbImageView ale;
    private TextView alf;
    private TextView alg;
    private TextView alh;
    private TextView ali;
    private TextView alj;
    private TextView alk;
    private String alm;
    private String aln;
    private View alo;
    private NoDataViewFactory.ImgType alp;
    private int alq;
    private Context mContext;
    private View mRootView;

    public f(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.no_data_view, this);
        this.ale = (TbImageView) this.mRootView.findViewById(d.h.iv_no_data_img);
        this.ale.setDefaultBgResource(0);
        this.ale.setDefaultResource(0);
        this.ale.setDefaultErrorResource(0);
        this.alf = (TextView) this.mRootView.findViewById(d.h.tv_text_reamrk);
        this.alg = (TextView) this.mRootView.findViewById(d.h.tv_subtitle);
        this.alh = (TextView) this.mRootView.findViewById(d.h.tv_title);
        this.ali = (TextView) this.mRootView.findViewById(d.h.btn_func);
        this.alo = (LinearLayout) this.mRootView.findViewById(d.h.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().ai(i == 1);
            ((TbPageContext) eVar).getLayoutMode().t(this);
        }
        if (this.alp == NoDataViewFactory.ImgType.WEBVIEW) {
            this.ale.setImageBitmap(aj.cT(d.g.pic_emotion08));
        } else if (this.alp == NoDataViewFactory.ImgType.NODATA) {
            this.ale.setImageBitmap(aj.cT(d.g.no_data_image));
        } else if (this.alp == NoDataViewFactory.ImgType.LOCAL) {
            this.ale.setImageBitmap(aj.cT(this.alq));
        } else if (i == 1) {
            this.ale.c(this.aln, 29, false);
        } else {
            this.ale.c(this.alm, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.alh.setText(dVar.mTitle);
                this.alh.setVisibility(0);
            } else {
                this.alh.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.VS)) {
                this.alg.setText(dVar.VS);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.alg.setTextSize(0, getResources().getDimension(d.f.fontsize28));
                    if (dVar.alA >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alg.getLayoutParams();
                        layoutParams.topMargin = dVar.alA;
                        this.alg.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.alB != 0) {
                    setSubTitleCompoundDrawable(dVar.alB);
                }
            } else {
                this.alg.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.alz)) {
                this.alf.setText(dVar.alz);
                this.alf.setVisibility(0);
                return;
            }
            this.alf.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.alp = cVar.alw;
            this.alq = cVar.alq;
            switch (cVar.alw) {
                case CREATE:
                    this.alm = com.baidu.tbadk.util.b.GC().gB("pic_emotion03.png");
                    this.aln = com.baidu.tbadk.util.b.GC().gB("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.alm = com.baidu.tbadk.util.b.GC().gB("pic_emotion05.png");
                    this.aln = com.baidu.tbadk.util.b.GC().gB("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.alm = com.baidu.tbadk.util.b.GC().gB("pic_emotion01.png");
                    this.aln = com.baidu.tbadk.util.b.GC().gB("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.alm = com.baidu.tbadk.util.b.GC().gB("pic_emotion02.png");
                    this.aln = com.baidu.tbadk.util.b.GC().gB("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.alm = com.baidu.tbadk.util.b.GC().gB("pic_emotion07.png");
                    this.aln = com.baidu.tbadk.util.b.GC().gB("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.alm = com.baidu.tbadk.util.b.GC().gB("pic_emotion06.png");
                    this.aln = com.baidu.tbadk.util.b.GC().gB("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.alm = com.baidu.tbadk.util.b.GC().gB("pic_emotion08.png");
                    this.aln = com.baidu.tbadk.util.b.GC().gB("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ale.getLayoutParams();
            if (cVar.alx >= 0) {
                layoutParams.setMargins(0, cVar.alx, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.ale.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.ali.setVisibility(8);
            this.alo.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.alt;
        NoDataViewFactory.a aVar2 = bVar.alu;
        if (aVar2 == null && aVar != null) {
            this.ali.setOnClickListener(aVar.als);
            this.ali.setText(aVar.aeD);
            this.ali.setVisibility(0);
            if (bVar.alv >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ali.getLayoutParams();
                layoutParams.topMargin = bVar.alv;
                this.ali.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.alj = (TextView) this.alo.findViewById(d.h.btn_left);
            this.alk = (TextView) this.alo.findViewById(d.h.btn_right);
            this.alj.setOnClickListener(aVar.als);
            this.alj.setText(aVar.aeD);
            this.alk.setOnClickListener(aVar2.als);
            this.alk.setText(aVar2.aeD);
            this.alo.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.ale.setImageDrawable(null);
        this.ale.c(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.alh != null) {
            aj.c(this.alh, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.alg != null) {
            aj.c(this.alg, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.alf != null) {
            aj.c(this.alf, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = aj.getDrawable(i);
        int f = l.f(this.mContext, d.f.ds32);
        int f2 = l.f(this.mContext, d.f.ds8);
        drawable.setBounds(0, 0, f, f);
        this.alg.setCompoundDrawablePadding(f2);
        this.alg.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.alg;
    }
}
