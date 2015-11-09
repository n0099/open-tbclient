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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class m extends LinearLayout {
    private static /* synthetic */ int[] aec;
    private TbImageView adQ;
    private TextView adR;
    private TextView adS;
    private TextView adT;
    private TextView adU;
    private TextView adV;
    private TextView adW;
    private String adX;
    private String adY;
    private View adZ;
    private NoDataViewFactory.ImgType aea;
    private int aeb;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] vw() {
        int[] iArr = aec;
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
            aec = iArr;
        }
        return iArr;
    }

    public m(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(i.g.no_data_view, this);
        this.adQ = (TbImageView) this.mRootView.findViewById(i.f.iv_no_data_img);
        this.adQ.setDefaultBgResource(0);
        this.adQ.setDefaultResource(0);
        this.adR = (TextView) this.mRootView.findViewById(i.f.tv_text_reamrk);
        this.adS = (TextView) this.mRootView.findViewById(i.f.tv_subtitle);
        this.adT = (TextView) this.mRootView.findViewById(i.f.tv_title);
        this.adU = (TextView) this.mRootView.findViewById(i.f.btn_func);
        this.adZ = (LinearLayout) this.mRootView.findViewById(i.f.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ad(i == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this);
        }
        if (this.aea == NoDataViewFactory.ImgType.WEBVIEW) {
            this.adQ.setImageBitmap(an.cy(i.e.pic_emotion08));
        } else if (this.aea == NoDataViewFactory.ImgType.NODATA) {
            this.adQ.setImageBitmap(an.cy(i.e.no_data_image));
        } else if (this.aea == NoDataViewFactory.ImgType.LOCAL) {
            this.adQ.setImageBitmap(an.cy(this.aeb));
        } else if (i == 1) {
            this.adQ.d(this.adY, 29, false);
        } else {
            this.adQ.d(this.adX, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.adT.setText(dVar.mTitle);
                this.adT.setVisibility(0);
            } else {
                this.adT.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.UL)) {
                this.adS.setText(dVar.UL);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.adS.setTextSize(0, getResources().getDimension(i.d.fontsize28));
                    if (dVar.ael >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.adS.getLayoutParams();
                        layoutParams.topMargin = dVar.ael;
                        this.adS.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.XG != 0) {
                    setSubTitleCompoundDrawable(dVar.XG);
                }
            } else {
                this.adS.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.aek)) {
                this.adR.setText(dVar.aek);
                this.adR.setVisibility(0);
                return;
            }
            this.adR.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.aea = cVar.aeh;
            this.aeb = cVar.aeb;
            switch (vw()[cVar.aeh.ordinal()]) {
                case 2:
                    this.adX = com.baidu.tbadk.util.b.El().fK("pic_emotion03.png");
                    this.adY = com.baidu.tbadk.util.b.El().fK("pic_emotion03_1.png");
                    break;
                case 3:
                    this.adX = com.baidu.tbadk.util.b.El().fK("pic_emotion05.png");
                    this.adY = com.baidu.tbadk.util.b.El().fK("pic_emotion05_1.png");
                    break;
                case 4:
                    this.adX = com.baidu.tbadk.util.b.El().fK("pic_emotion01.png");
                    this.adY = com.baidu.tbadk.util.b.El().fK("pic_emotion01_1.png");
                    break;
                case 5:
                    this.adX = com.baidu.tbadk.util.b.El().fK("pic_emotion02.png");
                    this.adY = com.baidu.tbadk.util.b.El().fK("pic_emotion02_1.png");
                    break;
                case 6:
                    this.adX = com.baidu.tbadk.util.b.El().fK("pic_emotion06.png");
                    this.adY = com.baidu.tbadk.util.b.El().fK("pic_emotion06_1.png");
                    break;
                case 7:
                    this.adX = com.baidu.tbadk.util.b.El().fK("pic_emotion07.png");
                    this.adY = com.baidu.tbadk.util.b.El().fK("pic_emotion07_1.png");
                    break;
                case 8:
                    this.adX = com.baidu.tbadk.util.b.El().fK("pic_emotion08.png");
                    this.adY = com.baidu.tbadk.util.b.El().fK("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.adQ.getLayoutParams();
            if (cVar.aei >= 0) {
                layoutParams.setMargins(0, cVar.aei, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.adQ.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.adU.setVisibility(8);
            this.adZ.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.aee;
        NoDataViewFactory.a aVar2 = bVar.aef;
        if (aVar2 == null && aVar != null) {
            this.adU.setOnClickListener(aVar.aed);
            this.adU.setText(aVar.Zf);
            this.adU.setVisibility(0);
            if (bVar.aeg >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.adU.getLayoutParams();
                layoutParams.topMargin = bVar.aeg;
                this.adU.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.adV = (TextView) this.adZ.findViewById(i.f.btn_left);
            this.adW = (TextView) this.adZ.findViewById(i.f.btn_right);
            this.adV.setOnClickListener(aVar.aed);
            this.adV.setText(aVar.Zf);
            this.adW.setOnClickListener(aVar2.aed);
            this.adW.setText(aVar2.Zf);
            this.adZ.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.h<?> hVar) {
        onChangeSkinType(hVar, TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void onActivityStop() {
        this.adQ.setImageDrawable(null);
        this.adQ.d(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.adT != null) {
            an.b(this.adT, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.adS != null) {
            an.b(this.adS, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.adR != null) {
            an.b(this.adR, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = an.getDrawable(i);
        int d = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds32);
        int d2 = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds8);
        drawable.setBounds(0, 0, d, d);
        this.adS.setCompoundDrawablePadding(d2);
        this.adS.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.adS;
    }
}
