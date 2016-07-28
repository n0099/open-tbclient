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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class q extends LinearLayout {
    private static /* synthetic */ int[] acC;
    private NoDataViewFactory.ImgType acA;
    private int acB;
    private TbImageView acq;
    private TextView acr;
    private TextView acs;
    private TextView act;
    private TextView acu;
    private TextView acv;
    private TextView acw;
    private String acx;
    private String acy;
    private View acz;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] uX() {
        int[] iArr = acC;
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
            acC = iArr;
        }
        return iArr;
    }

    public q(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(u.h.no_data_view, this);
        this.acq = (TbImageView) this.mRootView.findViewById(u.g.iv_no_data_img);
        this.acq.setDefaultBgResource(0);
        this.acq.setDefaultResource(0);
        this.acq.setDefaultErrorResource(0);
        this.acr = (TextView) this.mRootView.findViewById(u.g.tv_text_reamrk);
        this.acs = (TextView) this.mRootView.findViewById(u.g.tv_subtitle);
        this.act = (TextView) this.mRootView.findViewById(u.g.tv_title);
        this.acu = (TextView) this.mRootView.findViewById(u.g.btn_func);
        this.acz = (LinearLayout) this.mRootView.findViewById(u.g.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().af(i == 1);
            ((TbPageContext) hVar).getLayoutMode().w(this);
        }
        if (this.acA == NoDataViewFactory.ImgType.WEBVIEW) {
            this.acq.setImageBitmap(av.cC(u.f.pic_emotion08));
        } else if (this.acA == NoDataViewFactory.ImgType.NODATA) {
            this.acq.setImageBitmap(av.cC(u.f.no_data_image));
        } else if (this.acA == NoDataViewFactory.ImgType.LOCAL) {
            this.acq.setImageBitmap(av.cC(this.acB));
        } else if (i == 1) {
            this.acq.c(this.acy, 29, false);
        } else {
            this.acq.c(this.acx, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.act.setText(dVar.mTitle);
                this.act.setVisibility(0);
            } else {
                this.act.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.acs.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.acs.setTextSize(0, getResources().getDimension(u.e.fontsize28));
                    if (dVar.acL >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.acs.getLayoutParams();
                        layoutParams.topMargin = dVar.acL;
                        this.acs.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.Ua != 0) {
                    setSubTitleCompoundDrawable(dVar.Ua);
                }
            } else {
                this.acs.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.acK)) {
                this.acr.setText(dVar.acK);
                this.acr.setVisibility(0);
                return;
            }
            this.acr.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.acA = cVar.acH;
            this.acB = cVar.acB;
            switch (uX()[cVar.acH.ordinal()]) {
                case 2:
                    this.acx = com.baidu.tbadk.util.b.Fx().gj("pic_emotion03.png");
                    this.acy = com.baidu.tbadk.util.b.Fx().gj("pic_emotion03_1.png");
                    break;
                case 3:
                    this.acx = com.baidu.tbadk.util.b.Fx().gj("pic_emotion05.png");
                    this.acy = com.baidu.tbadk.util.b.Fx().gj("pic_emotion05_1.png");
                    break;
                case 4:
                    this.acx = com.baidu.tbadk.util.b.Fx().gj("pic_emotion01.png");
                    this.acy = com.baidu.tbadk.util.b.Fx().gj("pic_emotion01_1.png");
                    break;
                case 5:
                    this.acx = com.baidu.tbadk.util.b.Fx().gj("pic_emotion02.png");
                    this.acy = com.baidu.tbadk.util.b.Fx().gj("pic_emotion02_1.png");
                    break;
                case 6:
                    this.acx = com.baidu.tbadk.util.b.Fx().gj("pic_emotion06.png");
                    this.acy = com.baidu.tbadk.util.b.Fx().gj("pic_emotion06_1.png");
                    break;
                case 7:
                    this.acx = com.baidu.tbadk.util.b.Fx().gj("pic_emotion07.png");
                    this.acy = com.baidu.tbadk.util.b.Fx().gj("pic_emotion07_1.png");
                    break;
                case 8:
                    this.acx = com.baidu.tbadk.util.b.Fx().gj("pic_emotion08.png");
                    this.acy = com.baidu.tbadk.util.b.Fx().gj("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.acq.getLayoutParams();
            if (cVar.acI >= 0) {
                layoutParams.setMargins(0, cVar.acI, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.acq.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.acu.setVisibility(8);
            this.acz.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.acE;
        NoDataViewFactory.a aVar2 = bVar.acF;
        if (aVar2 == null && aVar != null) {
            this.acu.setOnClickListener(aVar.acD);
            this.acu.setText(aVar.WB);
            this.acu.setVisibility(0);
            if (bVar.acG >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.acu.getLayoutParams();
                layoutParams.topMargin = bVar.acG;
                this.acu.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.acv = (TextView) this.acz.findViewById(u.g.btn_left);
            this.acw = (TextView) this.acz.findViewById(u.g.btn_right);
            this.acv.setOnClickListener(aVar.acD);
            this.acv.setText(aVar.WB);
            this.acw.setOnClickListener(aVar2.acD);
            this.acw.setText(aVar2.WB);
            this.acz.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.h<?> hVar) {
        onChangeSkinType(hVar, TbadkCoreApplication.m10getInst().getSkinType());
    }

    public void onActivityStop() {
        this.acq.setImageDrawable(null);
        this.acq.c(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.act != null) {
            av.c(this.act, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.acs != null) {
            av.c(this.acs, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.acr != null) {
            av.c(this.acr, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = av.getDrawable(i);
        int c = com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds32);
        int c2 = com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds8);
        drawable.setBounds(0, 0, c, c);
        this.acs.setCompoundDrawablePadding(c2);
        this.acs.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.acs;
    }
}
