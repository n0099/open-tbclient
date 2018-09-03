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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class NoDataView extends LinearLayout {
    private NoDataViewFactory.ImgType avA;
    private int avB;
    private TbImageView avq;
    private TextView avr;
    private TextView avs;
    private TextView avt;
    private TextView avu;
    private TextView avv;
    private TextView avw;
    private String avx;
    private String avy;
    private View avz;
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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(f.h.no_data_view, this);
        this.avq = (TbImageView) this.mRootView.findViewById(f.g.iv_no_data_img);
        this.avq.setDefaultBgResource(0);
        this.avq.setDefaultResource(0);
        this.avq.setDefaultErrorResource(0);
        this.avr = (TextView) this.mRootView.findViewById(f.g.tv_text_reamrk);
        this.avs = (TextView) this.mRootView.findViewById(f.g.tv_subtitle);
        this.avt = (TextView) this.mRootView.findViewById(f.g.tv_title);
        this.avu = (TextView) this.mRootView.findViewById(f.g.btn_func);
        this.avz = (LinearLayout) this.mRootView.findViewById(f.g.two_button_layout);
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
        if (this.avA == NoDataViewFactory.ImgType.WEBVIEW) {
            this.avq.setImageBitmap(am.cV(f.C0146f.pic_emotion08));
        } else if (this.avA == NoDataViewFactory.ImgType.NODATA) {
            this.avq.setImageBitmap(am.cV(f.C0146f.no_data_image));
        } else if (this.avA == NoDataViewFactory.ImgType.LOCAL) {
            this.avq.setImageBitmap(am.cV(this.avB));
        } else if (this.avA == NoDataViewFactory.ImgType.ANTI) {
            this.avq.setImageBitmap(am.cV(f.C0146f.pic_emotion05));
        } else if (i == 1) {
            this.avq.startLoad(this.avy, 29, false);
        } else {
            this.avq.startLoad(this.avx, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.avt.setText(dVar.mTitle);
                this.avt.setVisibility(0);
            } else {
                this.avt.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.afg)) {
                this.avs.setText(dVar.afg);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.avs.setTextSize(0, getResources().getDimension(f.e.fontsize28));
                    if (dVar.avK >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avs.getLayoutParams();
                        layoutParams.topMargin = dVar.avK;
                        this.avs.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.avL != 0) {
                    setSubTitleCompoundDrawable(dVar.avL);
                }
            } else {
                this.avs.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.avJ)) {
                this.avr.setText(dVar.avJ);
                this.avr.setVisibility(0);
                return;
            }
            this.avr.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.avA = cVar.avH;
            this.avB = cVar.avB;
            switch (cVar.avH) {
                case CREATE:
                    this.avx = com.baidu.tbadk.util.b.Lh().ht("pic_emotion03.png");
                    this.avy = com.baidu.tbadk.util.b.Lh().ht("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.avx = com.baidu.tbadk.util.b.Lh().ht("pic_emotion05.png");
                    this.avy = com.baidu.tbadk.util.b.Lh().ht("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.avx = com.baidu.tbadk.util.b.Lh().ht("pic_emotion01.png");
                    this.avy = com.baidu.tbadk.util.b.Lh().ht("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.avx = com.baidu.tbadk.util.b.Lh().ht("pic_emotion02.png");
                    this.avy = com.baidu.tbadk.util.b.Lh().ht("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.avx = com.baidu.tbadk.util.b.Lh().ht("pic_emotion07.png");
                    this.avy = com.baidu.tbadk.util.b.Lh().ht("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.avx = com.baidu.tbadk.util.b.Lh().ht("pic_emotion06.png");
                    this.avy = com.baidu.tbadk.util.b.Lh().ht("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.avx = com.baidu.tbadk.util.b.Lh().ht("pic_emotion08.png");
                    this.avy = com.baidu.tbadk.util.b.Lh().ht("pic_emotion08_1.png");
                    break;
                case ANTI:
                    this.avx = com.baidu.tbadk.util.b.Lh().ht("pic_emotion05.png");
                    this.avy = com.baidu.tbadk.util.b.Lh().ht("pic_emotion05_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avq.getLayoutParams();
            if (cVar.avI >= 0) {
                layoutParams.setMargins(0, cVar.avI, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.avq.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.avu.setVisibility(8);
            this.avz.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.avE;
        NoDataViewFactory.a aVar2 = bVar.avF;
        if (aVar2 == null && aVar != null) {
            this.avu.setOnClickListener(aVar.avD);
            this.avu.setText(aVar.aop);
            this.avu.setVisibility(0);
            if (bVar.avG >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avu.getLayoutParams();
                layoutParams.topMargin = bVar.avG;
                this.avu.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.avv = (TextView) this.avz.findViewById(f.g.btn_left);
            this.avw = (TextView) this.avz.findViewById(f.g.btn_right);
            this.avv.setOnClickListener(aVar.avD);
            this.avv.setText(aVar.aop);
            this.avw.setOnClickListener(aVar2.avD);
            this.avw.setText(aVar2.aop);
            this.avz.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.avq.setImageDrawable(null);
        this.avq.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.avt != null) {
            am.c(this.avt, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.avs != null) {
            am.c(this.avs, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.avr != null) {
            am.c(this.avr, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = am.getDrawable(i);
        int f = com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds32);
        int f2 = com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds8);
        drawable.setBounds(0, 0, f, f);
        this.avs.setCompoundDrawablePadding(f2);
        this.avs.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.avt != null) {
            this.avt.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.avs;
    }
}
