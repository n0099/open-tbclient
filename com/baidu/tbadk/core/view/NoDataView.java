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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class NoDataView extends LinearLayout {
    private TbImageView aEb;
    private TextView aEc;
    private TextView aEd;
    private TextView aEe;
    private TextView aEf;
    private TextView aEg;
    private TextView aEh;
    private String aEi;
    private String aEj;
    private View aEk;
    private NoDataViewFactory.ImgType aEl;
    private int aEm;
    private Context mContext;
    private View mRootView;

    public NoDataView(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    public NoDataView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.no_data_view, this);
        this.aEb = (TbImageView) this.mRootView.findViewById(e.g.iv_no_data_img);
        this.aEb.setDefaultBgResource(0);
        this.aEb.setDefaultResource(0);
        this.aEb.setDefaultErrorResource(0);
        this.aEc = (TextView) this.mRootView.findViewById(e.g.tv_text_reamrk);
        this.aEd = (TextView) this.mRootView.findViewById(e.g.tv_subtitle);
        this.aEe = (TextView) this.mRootView.findViewById(e.g.tv_title);
        this.aEf = (TextView) this.mRootView.findViewById(e.g.btn_func);
        this.aEk = (LinearLayout) this.mRootView.findViewById(e.g.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().setNightMode(i == 1);
            ((TbPageContext) eVar).getLayoutMode().onModeChanged(this);
        }
        if (this.aEl == NoDataViewFactory.ImgType.WEBVIEW) {
            this.aEb.setImageBitmap(al.dC(e.f.pic_emotion08));
        } else if (this.aEl == NoDataViewFactory.ImgType.NODATA) {
            this.aEb.setImageBitmap(al.dC(e.f.no_data_image));
        } else if (this.aEl == NoDataViewFactory.ImgType.LOCAL) {
            this.aEb.setImageBitmap(al.dC(this.aEm));
        } else if (this.aEl == NoDataViewFactory.ImgType.ANTI) {
            this.aEb.setImageBitmap(al.dC(e.f.pic_emotion05));
        } else if (i == 1) {
            this.aEb.startLoad(this.aEj, 29, false);
        } else {
            this.aEb.startLoad(this.aEi, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.aEe.setText(dVar.mTitle);
                this.aEe.setVisibility(0);
            } else {
                this.aEe.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.anq)) {
                this.aEd.setText(dVar.anq);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.aEd.setTextSize(0, getResources().getDimension(e.C0200e.fontsize28));
                    if (dVar.aEu >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aEd.getLayoutParams();
                        layoutParams.topMargin = dVar.aEu;
                        this.aEd.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.aEv != 0) {
                    setSubTitleCompoundDrawable(dVar.aEv);
                }
            } else {
                this.aEd.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.aEt)) {
                this.aEc.setText(dVar.aEt);
                this.aEc.setVisibility(0);
                return;
            }
            this.aEc.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.aEl = cVar.aEs;
            this.aEm = cVar.aEm;
            switch (cVar.aEs) {
                case CREATE:
                    this.aEi = com.baidu.tbadk.util.c.OF().ig("pic_emotion03.png");
                    this.aEj = com.baidu.tbadk.util.c.OF().ig("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.aEi = com.baidu.tbadk.util.c.OF().ig("pic_emotion05.png");
                    this.aEj = com.baidu.tbadk.util.c.OF().ig("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.aEi = com.baidu.tbadk.util.c.OF().ig("pic_emotion01.png");
                    this.aEj = com.baidu.tbadk.util.c.OF().ig("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.aEi = com.baidu.tbadk.util.c.OF().ig("pic_emotion02.png");
                    this.aEj = com.baidu.tbadk.util.c.OF().ig("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.aEi = com.baidu.tbadk.util.c.OF().ig("pic_emotion07.png");
                    this.aEj = com.baidu.tbadk.util.c.OF().ig("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.aEi = com.baidu.tbadk.util.c.OF().ig("pic_emotion06.png");
                    this.aEj = com.baidu.tbadk.util.c.OF().ig("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.aEi = com.baidu.tbadk.util.c.OF().ig("pic_emotion08.png");
                    this.aEj = com.baidu.tbadk.util.c.OF().ig("pic_emotion08_1.png");
                    break;
                case ANTI:
                    this.aEi = com.baidu.tbadk.util.c.OF().ig("pic_emotion05.png");
                    this.aEj = com.baidu.tbadk.util.c.OF().ig("pic_emotion05_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aEb.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.aEb.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.aEf.setVisibility(8);
            this.aEk.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.aEp;
        NoDataViewFactory.a aVar2 = bVar.aEq;
        if (aVar2 == null && aVar != null) {
            this.aEf.setOnClickListener(aVar.aEo);
            this.aEf.setText(aVar.mText);
            this.aEf.setVisibility(0);
            if (bVar.aEr >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aEf.getLayoutParams();
                layoutParams.topMargin = bVar.aEr;
                this.aEf.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.aEg = (TextView) this.aEk.findViewById(e.g.btn_left);
            this.aEh = (TextView) this.aEk.findViewById(e.g.btn_right);
            this.aEg.setOnClickListener(aVar.aEo);
            this.aEg.setText(aVar.mText);
            this.aEh.setOnClickListener(aVar2.aEo);
            this.aEh.setText(aVar2.mText);
            this.aEk.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.aEb.setImageDrawable(null);
        this.aEb.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.aEe != null) {
            al.c(this.aEe, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.aEd != null) {
            al.c(this.aEd, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.aEc != null) {
            al.c(this.aEc, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = al.getDrawable(i);
        int h = com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.ds32);
        int h2 = com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.ds8);
        drawable.setBounds(0, 0, h, h);
        this.aEd.setCompoundDrawablePadding(h2);
        this.aEd.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.aEe != null) {
            this.aEe.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.aEd;
    }
}
