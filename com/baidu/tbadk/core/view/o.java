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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class o extends LinearLayout {
    private static /* synthetic */ int[] afL;
    private TextView afA;
    private TextView afB;
    private TextView afC;
    private TextView afD;
    private TextView afE;
    private TextView afF;
    private String afG;
    private String afH;
    private View afI;
    private NoDataViewFactory.ImgType afJ;
    private int afK;
    private TbImageView afz;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] vM() {
        int[] iArr = afL;
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
            afL = iArr;
        }
        return iArr;
    }

    public o(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(n.h.no_data_view, this);
        this.afz = (TbImageView) this.mRootView.findViewById(n.g.iv_no_data_img);
        this.afz.setDefaultBgResource(0);
        this.afz.setDefaultResource(0);
        this.afA = (TextView) this.mRootView.findViewById(n.g.tv_text_reamrk);
        this.afB = (TextView) this.mRootView.findViewById(n.g.tv_subtitle);
        this.afC = (TextView) this.mRootView.findViewById(n.g.tv_title);
        this.afD = (TextView) this.mRootView.findViewById(n.g.btn_func);
        this.afI = (LinearLayout) this.mRootView.findViewById(n.g.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ac(i == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this);
        }
        if (this.afJ == NoDataViewFactory.ImgType.WEBVIEW) {
            this.afz.setImageBitmap(as.cz(n.f.pic_emotion08));
        } else if (this.afJ == NoDataViewFactory.ImgType.NODATA) {
            this.afz.setImageBitmap(as.cz(n.f.no_data_image));
        } else if (this.afJ == NoDataViewFactory.ImgType.LOCAL) {
            this.afz.setImageBitmap(as.cz(this.afK));
        } else if (i == 1) {
            this.afz.d(this.afH, 29, false);
        } else {
            this.afz.d(this.afG, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.afC.setText(dVar.mTitle);
                this.afC.setVisibility(0);
            } else {
                this.afC.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.VC)) {
                this.afB.setText(dVar.VC);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.afB.setTextSize(0, getResources().getDimension(n.e.fontsize28));
                    if (dVar.afU >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afB.getLayoutParams();
                        layoutParams.topMargin = dVar.afU;
                        this.afB.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.YW != 0) {
                    setSubTitleCompoundDrawable(dVar.YW);
                }
            } else {
                this.afB.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.afT)) {
                this.afA.setText(dVar.afT);
                this.afA.setVisibility(0);
                return;
            }
            this.afA.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.afJ = cVar.afQ;
            this.afK = cVar.afK;
            switch (vM()[cVar.afQ.ordinal()]) {
                case 2:
                    this.afG = com.baidu.tbadk.util.b.Fb().gc("pic_emotion03.png");
                    this.afH = com.baidu.tbadk.util.b.Fb().gc("pic_emotion03_1.png");
                    break;
                case 3:
                    this.afG = com.baidu.tbadk.util.b.Fb().gc("pic_emotion05.png");
                    this.afH = com.baidu.tbadk.util.b.Fb().gc("pic_emotion05_1.png");
                    break;
                case 4:
                    this.afG = com.baidu.tbadk.util.b.Fb().gc("pic_emotion01.png");
                    this.afH = com.baidu.tbadk.util.b.Fb().gc("pic_emotion01_1.png");
                    break;
                case 5:
                    this.afG = com.baidu.tbadk.util.b.Fb().gc("pic_emotion02.png");
                    this.afH = com.baidu.tbadk.util.b.Fb().gc("pic_emotion02_1.png");
                    break;
                case 6:
                    this.afG = com.baidu.tbadk.util.b.Fb().gc("pic_emotion06.png");
                    this.afH = com.baidu.tbadk.util.b.Fb().gc("pic_emotion06_1.png");
                    break;
                case 7:
                    this.afG = com.baidu.tbadk.util.b.Fb().gc("pic_emotion07.png");
                    this.afH = com.baidu.tbadk.util.b.Fb().gc("pic_emotion07_1.png");
                    break;
                case 8:
                    this.afG = com.baidu.tbadk.util.b.Fb().gc("pic_emotion08.png");
                    this.afH = com.baidu.tbadk.util.b.Fb().gc("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afz.getLayoutParams();
            if (cVar.afR >= 0) {
                layoutParams.setMargins(0, cVar.afR, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.afz.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.afD.setVisibility(8);
            this.afI.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.afN;
        NoDataViewFactory.a aVar2 = bVar.afO;
        if (aVar2 == null && aVar != null) {
            this.afD.setOnClickListener(aVar.afM);
            this.afD.setText(aVar.aav);
            this.afD.setVisibility(0);
            if (bVar.afP >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afD.getLayoutParams();
                layoutParams.topMargin = bVar.afP;
                this.afD.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.afE = (TextView) this.afI.findViewById(n.g.btn_left);
            this.afF = (TextView) this.afI.findViewById(n.g.btn_right);
            this.afE.setOnClickListener(aVar.afM);
            this.afE.setText(aVar.aav);
            this.afF.setOnClickListener(aVar2.afM);
            this.afF.setText(aVar2.aav);
            this.afI.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.h<?> hVar) {
        onChangeSkinType(hVar, TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void onActivityStop() {
        this.afz.setImageDrawable(null);
        this.afz.d(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.afC != null) {
            as.b(this.afC, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.afB != null) {
            as.b(this.afB, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.afA != null) {
            as.b(this.afA, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = as.getDrawable(i);
        int d = com.baidu.adp.lib.util.k.d(this.mContext, n.e.ds32);
        int d2 = com.baidu.adp.lib.util.k.d(this.mContext, n.e.ds8);
        drawable.setBounds(0, 0, d, d);
        this.afB.setCompoundDrawablePadding(d2);
        this.afB.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.afB;
    }
}
