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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class u extends LinearLayout {
    private static /* synthetic */ int[] aeK;
    private TextView aeA;
    private TextView aeB;
    private TextView aeC;
    private TextView aeD;
    private TextView aeE;
    private String aeF;
    private String aeG;
    private View aeH;
    private NoDataViewFactory.ImgType aeI;
    private int aeJ;
    private TbImageView aey;
    private TextView aez;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] vD() {
        int[] iArr = aeK;
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
            aeK = iArr;
        }
        return iArr;
    }

    public u(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(i.g.no_data_view, this);
        this.aey = (TbImageView) this.mRootView.findViewById(i.f.iv_no_data_img);
        this.aey.setDefaultBgResource(0);
        this.aey.setDefaultResource(0);
        this.aez = (TextView) this.mRootView.findViewById(i.f.tv_text_reamrk);
        this.aeA = (TextView) this.mRootView.findViewById(i.f.tv_subtitle);
        this.aeB = (TextView) this.mRootView.findViewById(i.f.tv_title);
        this.aeC = (TextView) this.mRootView.findViewById(i.f.btn_func);
        this.aeH = (LinearLayout) this.mRootView.findViewById(i.f.two_button_layout);
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
        if (this.aeI == NoDataViewFactory.ImgType.WEBVIEW) {
            this.aey.setImageBitmap(al.cw(i.e.pic_emotion08));
        } else if (this.aeI == NoDataViewFactory.ImgType.NODATA) {
            this.aey.setImageBitmap(al.cw(i.e.no_data_image));
        } else if (this.aeI == NoDataViewFactory.ImgType.LOCAL) {
            this.aey.setImageBitmap(al.cw(this.aeJ));
        } else if (i == 1) {
            this.aey.d(this.aeG, 29, false);
        } else {
            this.aey.d(this.aeF, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.aeB.setText(dVar.mTitle);
                this.aeB.setVisibility(0);
            } else {
                this.aeB.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.UU)) {
                this.aeA.setText(dVar.UU);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.aeA.setTextSize(0, getResources().getDimension(i.d.fontsize28));
                    if (dVar.aeT >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aeA.getLayoutParams();
                        layoutParams.topMargin = dVar.aeT;
                        this.aeA.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.XJ != 0) {
                    setSubTitleCompoundDrawable(dVar.XJ);
                }
            } else {
                this.aeA.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.aeS)) {
                this.aez.setText(dVar.aeS);
                this.aez.setVisibility(0);
                return;
            }
            this.aez.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.aeI = cVar.aeP;
            this.aeJ = cVar.aeJ;
            switch (vD()[cVar.aeP.ordinal()]) {
                case 2:
                    this.aeF = com.baidu.tbadk.util.b.EI().fD("pic_emotion03.png");
                    this.aeG = com.baidu.tbadk.util.b.EI().fD("pic_emotion03_1.png");
                    break;
                case 3:
                    this.aeF = com.baidu.tbadk.util.b.EI().fD("pic_emotion05.png");
                    this.aeG = com.baidu.tbadk.util.b.EI().fD("pic_emotion05_1.png");
                    break;
                case 4:
                    this.aeF = com.baidu.tbadk.util.b.EI().fD("pic_emotion01.png");
                    this.aeG = com.baidu.tbadk.util.b.EI().fD("pic_emotion01_1.png");
                    break;
                case 5:
                    this.aeF = com.baidu.tbadk.util.b.EI().fD("pic_emotion02.png");
                    this.aeG = com.baidu.tbadk.util.b.EI().fD("pic_emotion02_1.png");
                    break;
                case 6:
                    this.aeF = com.baidu.tbadk.util.b.EI().fD("pic_emotion06.png");
                    this.aeG = com.baidu.tbadk.util.b.EI().fD("pic_emotion06_1.png");
                    break;
                case 7:
                    this.aeF = com.baidu.tbadk.util.b.EI().fD("pic_emotion07.png");
                    this.aeG = com.baidu.tbadk.util.b.EI().fD("pic_emotion07_1.png");
                    break;
                case 8:
                    this.aeF = com.baidu.tbadk.util.b.EI().fD("pic_emotion08.png");
                    this.aeG = com.baidu.tbadk.util.b.EI().fD("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aey.getLayoutParams();
            if (cVar.aeQ >= 0) {
                layoutParams.setMargins(0, cVar.aeQ, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.aey.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.aeC.setVisibility(8);
            this.aeH.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.aeM;
        NoDataViewFactory.a aVar2 = bVar.aeN;
        if (aVar2 == null && aVar != null) {
            this.aeC.setOnClickListener(aVar.aeL);
            this.aeC.setText(aVar.Zf);
            this.aeC.setVisibility(0);
            if (bVar.aeO >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aeC.getLayoutParams();
                layoutParams.topMargin = bVar.aeO;
                this.aeC.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.aeD = (TextView) this.aeH.findViewById(i.f.btn_left);
            this.aeE = (TextView) this.aeH.findViewById(i.f.btn_right);
            this.aeD.setOnClickListener(aVar.aeL);
            this.aeD.setText(aVar.Zf);
            this.aeE.setOnClickListener(aVar2.aeL);
            this.aeE.setText(aVar2.Zf);
            this.aeH.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.h<?> hVar) {
        onChangeSkinType(hVar, TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void onActivityStop() {
        this.aey.setImageDrawable(null);
        this.aey.d(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.aeB != null) {
            al.b(this.aeB, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.aeA != null) {
            al.b(this.aeA, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.aez != null) {
            al.b(this.aez, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = al.getDrawable(i);
        int d = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds32);
        int d2 = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds8);
        drawable.setBounds(0, 0, d, d);
        this.aeA.setCompoundDrawablePadding(d2);
        this.aeA.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.aeA;
    }
}
