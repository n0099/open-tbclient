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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class NoDataView extends LinearLayout {
    private String avA;
    private View avB;
    private NoDataViewFactory.ImgType avC;
    private int avD;
    private TbImageView avs;
    private TextView avt;
    private TextView avu;
    private TextView avv;
    private TextView avw;
    private TextView avx;
    private TextView avy;
    private String avz;
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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.no_data_view, this);
        this.avs = (TbImageView) this.mRootView.findViewById(d.g.iv_no_data_img);
        this.avs.setDefaultBgResource(0);
        this.avs.setDefaultResource(0);
        this.avs.setDefaultErrorResource(0);
        this.avt = (TextView) this.mRootView.findViewById(d.g.tv_text_reamrk);
        this.avu = (TextView) this.mRootView.findViewById(d.g.tv_subtitle);
        this.avv = (TextView) this.mRootView.findViewById(d.g.tv_title);
        this.avw = (TextView) this.mRootView.findViewById(d.g.btn_func);
        this.avB = (LinearLayout) this.mRootView.findViewById(d.g.two_button_layout);
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
        if (this.avC == NoDataViewFactory.ImgType.WEBVIEW) {
            this.avs.setImageBitmap(am.cV(d.f.pic_emotion08));
        } else if (this.avC == NoDataViewFactory.ImgType.NODATA) {
            this.avs.setImageBitmap(am.cV(d.f.no_data_image));
        } else if (this.avC == NoDataViewFactory.ImgType.LOCAL) {
            this.avs.setImageBitmap(am.cV(this.avD));
        } else if (this.avC == NoDataViewFactory.ImgType.ANTI) {
            this.avs.setImageBitmap(am.cV(d.f.pic_emotion05));
        } else if (i == 1) {
            this.avs.startLoad(this.avA, 29, false);
        } else {
            this.avs.startLoad(this.avz, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.avv.setText(dVar.mTitle);
                this.avv.setVisibility(0);
            } else {
                this.avv.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.afg)) {
                this.avu.setText(dVar.afg);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.avu.setTextSize(0, getResources().getDimension(d.e.fontsize28));
                    if (dVar.avM >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avu.getLayoutParams();
                        layoutParams.topMargin = dVar.avM;
                        this.avu.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.avN != 0) {
                    setSubTitleCompoundDrawable(dVar.avN);
                }
            } else {
                this.avu.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.avL)) {
                this.avt.setText(dVar.avL);
                this.avt.setVisibility(0);
                return;
            }
            this.avt.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.avC = cVar.avJ;
            this.avD = cVar.avD;
            switch (cVar.avJ) {
                case CREATE:
                    this.avz = com.baidu.tbadk.util.b.Ld().ht("pic_emotion03.png");
                    this.avA = com.baidu.tbadk.util.b.Ld().ht("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.avz = com.baidu.tbadk.util.b.Ld().ht("pic_emotion05.png");
                    this.avA = com.baidu.tbadk.util.b.Ld().ht("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.avz = com.baidu.tbadk.util.b.Ld().ht("pic_emotion01.png");
                    this.avA = com.baidu.tbadk.util.b.Ld().ht("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.avz = com.baidu.tbadk.util.b.Ld().ht("pic_emotion02.png");
                    this.avA = com.baidu.tbadk.util.b.Ld().ht("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.avz = com.baidu.tbadk.util.b.Ld().ht("pic_emotion07.png");
                    this.avA = com.baidu.tbadk.util.b.Ld().ht("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.avz = com.baidu.tbadk.util.b.Ld().ht("pic_emotion06.png");
                    this.avA = com.baidu.tbadk.util.b.Ld().ht("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.avz = com.baidu.tbadk.util.b.Ld().ht("pic_emotion08.png");
                    this.avA = com.baidu.tbadk.util.b.Ld().ht("pic_emotion08_1.png");
                    break;
                case ANTI:
                    this.avz = com.baidu.tbadk.util.b.Ld().ht("pic_emotion05.png");
                    this.avA = com.baidu.tbadk.util.b.Ld().ht("pic_emotion05_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avs.getLayoutParams();
            if (cVar.avK >= 0) {
                layoutParams.setMargins(0, cVar.avK, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.avs.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.avw.setVisibility(8);
            this.avB.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.avG;
        NoDataViewFactory.a aVar2 = bVar.avH;
        if (aVar2 == null && aVar != null) {
            this.avw.setOnClickListener(aVar.avF);
            this.avw.setText(aVar.aoo);
            this.avw.setVisibility(0);
            if (bVar.avI >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avw.getLayoutParams();
                layoutParams.topMargin = bVar.avI;
                this.avw.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.avx = (TextView) this.avB.findViewById(d.g.btn_left);
            this.avy = (TextView) this.avB.findViewById(d.g.btn_right);
            this.avx.setOnClickListener(aVar.avF);
            this.avx.setText(aVar.aoo);
            this.avy.setOnClickListener(aVar2.avF);
            this.avy.setText(aVar2.aoo);
            this.avB.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.avs.setImageDrawable(null);
        this.avs.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.avv != null) {
            am.c(this.avv, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.avu != null) {
            am.c(this.avu, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.avt != null) {
            am.c(this.avt, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = am.getDrawable(i);
        int f = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32);
        int f2 = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds8);
        drawable.setBounds(0, 0, f, f);
        this.avu.setCompoundDrawablePadding(f2);
        this.avu.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.avv != null) {
            this.avv.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.avu;
    }
}
