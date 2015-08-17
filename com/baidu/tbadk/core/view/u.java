package com.baidu.tbadk.core.view;

import android.content.Context;
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
    private static /* synthetic */ int[] aeA;
    private TbImageView aeo;
    private TextView aep;
    private TextView aeq;
    private TextView aer;
    private TextView aes;
    private TextView aet;
    private TextView aeu;
    private String aev;
    private String aew;
    private View aex;
    private NoDataViewFactory.ImgType aey;
    private int aez;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] vy() {
        int[] iArr = aeA;
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
            aeA = iArr;
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
        this.aeo = (TbImageView) this.mRootView.findViewById(i.f.iv_no_data_img);
        this.aeo.setDefaultBgResource(0);
        this.aeo.setDefaultResource(0);
        this.aep = (TextView) this.mRootView.findViewById(i.f.tv_text_reamrk);
        this.aeq = (TextView) this.mRootView.findViewById(i.f.tv_subtitle);
        this.aer = (TextView) this.mRootView.findViewById(i.f.tv_title);
        this.aes = (TextView) this.mRootView.findViewById(i.f.btn_func);
        this.aex = (LinearLayout) this.mRootView.findViewById(i.f.two_button_layout);
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
        if (this.aey == NoDataViewFactory.ImgType.WEBVIEW) {
            this.aeo.setImageBitmap(al.cr(i.e.pic_emotion08));
        } else if (this.aey == NoDataViewFactory.ImgType.NODATA) {
            this.aeo.setImageBitmap(al.cr(i.e.no_data_image));
        } else if (this.aey == NoDataViewFactory.ImgType.LOCAL) {
            this.aeo.setImageBitmap(al.cr(this.aez));
        } else if (i == 1) {
            this.aeo.d(this.aew, 29, false);
        } else {
            this.aeo.d(this.aev, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.aer.setText(dVar.mTitle);
                this.aer.setVisibility(0);
            } else {
                this.aer.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.UT)) {
                this.aeq.setText(dVar.UT);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.aeq.setTextSize(0, getResources().getDimension(i.d.fontsize28));
                    if (dVar.aeJ >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aeq.getLayoutParams();
                        layoutParams.topMargin = dVar.aeJ;
                        this.aeq.setLayoutParams(layoutParams);
                    }
                }
            } else {
                this.aeq.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.aeI)) {
                this.aep.setText(dVar.aeI);
                this.aep.setVisibility(0);
                return;
            }
            this.aep.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.aey = cVar.aeF;
            this.aez = cVar.aez;
            switch (vy()[cVar.aeF.ordinal()]) {
                case 2:
                    this.aev = com.baidu.tbadk.util.b.Ey().fv("pic_emotion03.png");
                    this.aew = com.baidu.tbadk.util.b.Ey().fv("pic_emotion03_1.png");
                    break;
                case 3:
                    this.aev = com.baidu.tbadk.util.b.Ey().fv("pic_emotion05.png");
                    this.aew = com.baidu.tbadk.util.b.Ey().fv("pic_emotion05_1.png");
                    break;
                case 4:
                    this.aev = com.baidu.tbadk.util.b.Ey().fv("pic_emotion01.png");
                    this.aew = com.baidu.tbadk.util.b.Ey().fv("pic_emotion01_1.png");
                    break;
                case 5:
                    this.aev = com.baidu.tbadk.util.b.Ey().fv("pic_emotion02.png");
                    this.aew = com.baidu.tbadk.util.b.Ey().fv("pic_emotion02_1.png");
                    break;
                case 6:
                    this.aev = com.baidu.tbadk.util.b.Ey().fv("pic_emotion06.png");
                    this.aew = com.baidu.tbadk.util.b.Ey().fv("pic_emotion06_1.png");
                    break;
                case 7:
                    this.aev = com.baidu.tbadk.util.b.Ey().fv("pic_emotion07.png");
                    this.aew = com.baidu.tbadk.util.b.Ey().fv("pic_emotion07_1.png");
                    break;
                case 8:
                    this.aev = com.baidu.tbadk.util.b.Ey().fv("pic_emotion08.png");
                    this.aew = com.baidu.tbadk.util.b.Ey().fv("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aeo.getLayoutParams();
            if (cVar.aeG >= 0) {
                layoutParams.setMargins(0, cVar.aeG, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.aeo.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.aes.setVisibility(8);
            this.aex.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.aeC;
        NoDataViewFactory.a aVar2 = bVar.aeD;
        if (aVar2 == null && aVar != null) {
            this.aes.setOnClickListener(aVar.aeB);
            this.aes.setText(aVar.YW);
            this.aes.setVisibility(0);
            if (bVar.aeE >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aes.getLayoutParams();
                layoutParams.topMargin = bVar.aeE;
                this.aes.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.aet = (TextView) this.aex.findViewById(i.f.btn_left);
            this.aeu = (TextView) this.aex.findViewById(i.f.btn_right);
            this.aet.setOnClickListener(aVar.aeB);
            this.aet.setText(aVar.YW);
            this.aeu.setOnClickListener(aVar2.aeB);
            this.aeu.setText(aVar2.YW);
            this.aex.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.h<?> hVar) {
        onChangeSkinType(hVar, TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void onActivityStop() {
        this.aeo.setImageDrawable(null);
        this.aeo.d(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.aer != null) {
            al.b(this.aer, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.aeq != null) {
            al.b(this.aeq, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.aep != null) {
            al.b(this.aep, i, 1);
        }
    }
}
