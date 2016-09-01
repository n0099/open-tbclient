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
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class q extends LinearLayout {
    private static /* synthetic */ int[] afs;
    private TbImageView afg;
    private TextView afh;
    private TextView afi;
    private TextView afj;
    private TextView afk;
    private TextView afl;
    private TextView afm;
    private String afn;
    private String afo;
    private View afp;
    private NoDataViewFactory.ImgType afq;
    private int afr;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] wb() {
        int[] iArr = afs;
        if (iArr == null) {
            iArr = new int[NoDataViewFactory.ImgType.valuesCustom().length];
            try {
                iArr[NoDataViewFactory.ImgType.CREATE.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.EMOTION.ordinal()] = 5;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.FINDBAR.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.GIFT.ordinal()] = 7;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.LOCAL.ordinal()] = 9;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.NODATA.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.SINGALL.ordinal()] = 6;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.WEBVIEW.ordinal()] = 8;
            } catch (NoSuchFieldError e9) {
            }
            afs = iArr;
        }
        return iArr;
    }

    public q(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(t.h.no_data_view, this);
        this.afg = (TbImageView) this.mRootView.findViewById(t.g.iv_no_data_img);
        this.afg.setDefaultBgResource(0);
        this.afg.setDefaultResource(0);
        this.afg.setDefaultErrorResource(0);
        this.afh = (TextView) this.mRootView.findViewById(t.g.tv_text_reamrk);
        this.afi = (TextView) this.mRootView.findViewById(t.g.tv_subtitle);
        this.afj = (TextView) this.mRootView.findViewById(t.g.tv_title);
        this.afk = (TextView) this.mRootView.findViewById(t.g.btn_func);
        this.afp = (LinearLayout) this.mRootView.findViewById(t.g.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ah(i == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this);
        }
        if (this.afq == NoDataViewFactory.ImgType.WEBVIEW) {
            this.afg.setImageBitmap(com.baidu.tbadk.core.util.av.cP(t.f.pic_emotion08));
        } else if (this.afq == NoDataViewFactory.ImgType.NODATA) {
            this.afg.setImageBitmap(com.baidu.tbadk.core.util.av.cP(t.f.no_data_image));
        } else if (this.afq == NoDataViewFactory.ImgType.LOCAL) {
            this.afg.setImageBitmap(com.baidu.tbadk.core.util.av.cP(this.afr));
        } else if (i == 1) {
            this.afg.c(this.afo, 29, false);
        } else {
            this.afg.c(this.afn, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.afj.setText(dVar.mTitle);
                this.afj.setVisibility(0);
            } else {
                this.afj.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.afi.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.afi.setTextSize(0, getResources().getDimension(t.e.fontsize28));
                    if (dVar.afB >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afi.getLayoutParams();
                        layoutParams.topMargin = dVar.afB;
                        this.afi.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.WP != 0) {
                    setSubTitleCompoundDrawable(dVar.WP);
                }
            } else {
                this.afi.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.afA)) {
                this.afh.setText(dVar.afA);
                this.afh.setVisibility(0);
                return;
            }
            this.afh.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.afq = cVar.afx;
            this.afr = cVar.afr;
            switch (wb()[cVar.afx.ordinal()]) {
                case 2:
                    this.afn = com.baidu.tbadk.util.b.GR().gm("pic_emotion03.png");
                    this.afo = com.baidu.tbadk.util.b.GR().gm("pic_emotion03_1.png");
                    break;
                case 3:
                    this.afn = com.baidu.tbadk.util.b.GR().gm("pic_emotion05.png");
                    this.afo = com.baidu.tbadk.util.b.GR().gm("pic_emotion05_1.png");
                    break;
                case 4:
                    this.afn = com.baidu.tbadk.util.b.GR().gm("pic_emotion01.png");
                    this.afo = com.baidu.tbadk.util.b.GR().gm("pic_emotion01_1.png");
                    break;
                case 5:
                    this.afn = com.baidu.tbadk.util.b.GR().gm("pic_emotion02.png");
                    this.afo = com.baidu.tbadk.util.b.GR().gm("pic_emotion02_1.png");
                    break;
                case 6:
                    this.afn = com.baidu.tbadk.util.b.GR().gm("pic_emotion06.png");
                    this.afo = com.baidu.tbadk.util.b.GR().gm("pic_emotion06_1.png");
                    break;
                case 7:
                    this.afn = com.baidu.tbadk.util.b.GR().gm("pic_emotion07.png");
                    this.afo = com.baidu.tbadk.util.b.GR().gm("pic_emotion07_1.png");
                    break;
                case 8:
                    this.afn = com.baidu.tbadk.util.b.GR().gm("pic_emotion08.png");
                    this.afo = com.baidu.tbadk.util.b.GR().gm("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afg.getLayoutParams();
            if (cVar.afy >= 0) {
                layoutParams.setMargins(0, cVar.afy, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.afg.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.afk.setVisibility(8);
            this.afp.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.afu;
        NoDataViewFactory.a aVar2 = bVar.afv;
        if (aVar2 == null && aVar != null) {
            this.afk.setOnClickListener(aVar.aft);
            this.afk.setText(aVar.Zp);
            this.afk.setVisibility(0);
            if (bVar.afw >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afk.getLayoutParams();
                layoutParams.topMargin = bVar.afw;
                this.afk.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.afl = (TextView) this.afp.findViewById(t.g.btn_left);
            this.afm = (TextView) this.afp.findViewById(t.g.btn_right);
            this.afl.setOnClickListener(aVar.aft);
            this.afl.setText(aVar.Zp);
            this.afm.setOnClickListener(aVar2.aft);
            this.afm.setText(aVar2.Zp);
            this.afp.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.h<?> hVar) {
        onChangeSkinType(hVar, TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void onActivityStop() {
        this.afg.setImageDrawable(null);
        this.afg.c(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.afj != null) {
            com.baidu.tbadk.core.util.av.c(this.afj, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.afi != null) {
            com.baidu.tbadk.core.util.av.c(this.afi, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.afh != null) {
            com.baidu.tbadk.core.util.av.c(this.afh, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = com.baidu.tbadk.core.util.av.getDrawable(i);
        int e = com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds32);
        int e2 = com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds8);
        drawable.setBounds(0, 0, e, e);
        this.afi.setCompoundDrawablePadding(e2);
        this.afi.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.afi;
    }
}
