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
    private TbImageView aHC;
    private TextView aHD;
    private TextView aHE;
    private TextView aHF;
    private TextView aHG;
    private TextView aHH;
    private TextView aHI;
    private String aHJ;
    private String aHK;
    private View aHL;
    private NoDataViewFactory.ImgType aHM;
    private int aHN;
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
        this.aHC = (TbImageView) this.mRootView.findViewById(e.g.iv_no_data_img);
        this.aHC.setDefaultBgResource(0);
        this.aHC.setDefaultResource(0);
        this.aHC.setDefaultErrorResource(0);
        this.aHD = (TextView) this.mRootView.findViewById(e.g.tv_text_reamrk);
        this.aHE = (TextView) this.mRootView.findViewById(e.g.tv_subtitle);
        this.aHF = (TextView) this.mRootView.findViewById(e.g.tv_title);
        this.aHG = (TextView) this.mRootView.findViewById(e.g.btn_func);
        this.aHL = (LinearLayout) this.mRootView.findViewById(e.g.two_button_layout);
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
        if (this.aHM == NoDataViewFactory.ImgType.WEBVIEW) {
            this.aHC.setImageBitmap(al.dQ(e.f.pic_emotion08));
        } else if (this.aHM == NoDataViewFactory.ImgType.NODATA) {
            this.aHC.setImageBitmap(al.dQ(e.f.no_data_image));
        } else if (this.aHM == NoDataViewFactory.ImgType.LOCAL) {
            this.aHC.setImageBitmap(al.dQ(this.aHN));
        } else if (this.aHM == NoDataViewFactory.ImgType.ANTI) {
            this.aHC.setImageBitmap(al.dQ(e.f.pic_emotion05));
        } else if (i == 1) {
            this.aHC.startLoad(this.aHK, 29, false);
        } else {
            this.aHC.startLoad(this.aHJ, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.aHF.setText(dVar.mTitle);
                this.aHF.setVisibility(0);
            } else {
                this.aHF.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.aqR)) {
                this.aHE.setText(dVar.aqR);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.aHE.setTextSize(0, getResources().getDimension(e.C0210e.fontsize28));
                    if (dVar.aHV >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aHE.getLayoutParams();
                        layoutParams.topMargin = dVar.aHV;
                        this.aHE.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.aHW != 0) {
                    setSubTitleCompoundDrawable(dVar.aHW);
                }
            } else {
                this.aHE.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.aHU)) {
                this.aHD.setText(dVar.aHU);
                this.aHD.setVisibility(0);
                return;
            }
            this.aHD.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.aHM = cVar.aHT;
            this.aHN = cVar.aHN;
            switch (cVar.aHT) {
                case CREATE:
                    this.aHJ = com.baidu.tbadk.util.c.PN().iz("pic_emotion03.png");
                    this.aHK = com.baidu.tbadk.util.c.PN().iz("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.aHJ = com.baidu.tbadk.util.c.PN().iz("pic_emotion05.png");
                    this.aHK = com.baidu.tbadk.util.c.PN().iz("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.aHJ = com.baidu.tbadk.util.c.PN().iz("pic_emotion01.png");
                    this.aHK = com.baidu.tbadk.util.c.PN().iz("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.aHJ = com.baidu.tbadk.util.c.PN().iz("pic_emotion02.png");
                    this.aHK = com.baidu.tbadk.util.c.PN().iz("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.aHJ = com.baidu.tbadk.util.c.PN().iz("pic_emotion07.png");
                    this.aHK = com.baidu.tbadk.util.c.PN().iz("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.aHJ = com.baidu.tbadk.util.c.PN().iz("pic_emotion06.png");
                    this.aHK = com.baidu.tbadk.util.c.PN().iz("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.aHJ = com.baidu.tbadk.util.c.PN().iz("pic_emotion08.png");
                    this.aHK = com.baidu.tbadk.util.c.PN().iz("pic_emotion08_1.png");
                    break;
                case ANTI:
                    this.aHJ = com.baidu.tbadk.util.c.PN().iz("pic_emotion05.png");
                    this.aHK = com.baidu.tbadk.util.c.PN().iz("pic_emotion05_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aHC.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.aHC.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.aHG.setVisibility(8);
            this.aHL.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.aHQ;
        NoDataViewFactory.a aVar2 = bVar.aHR;
        if (aVar2 == null && aVar != null) {
            this.aHG.setOnClickListener(aVar.aHP);
            this.aHG.setText(aVar.mText);
            this.aHG.setVisibility(0);
            if (bVar.aHS >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aHG.getLayoutParams();
                layoutParams.topMargin = bVar.aHS;
                this.aHG.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.aHH = (TextView) this.aHL.findViewById(e.g.btn_left);
            this.aHI = (TextView) this.aHL.findViewById(e.g.btn_right);
            this.aHH.setOnClickListener(aVar.aHP);
            this.aHH.setText(aVar.mText);
            this.aHI.setOnClickListener(aVar2.aHP);
            this.aHI.setText(aVar2.mText);
            this.aHL.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.aHC.setImageDrawable(null);
        this.aHC.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.aHF != null) {
            al.c(this.aHF, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.aHE != null) {
            al.c(this.aHE, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.aHD != null) {
            al.c(this.aHD, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = al.getDrawable(i);
        int h = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds32);
        int h2 = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds8);
        drawable.setBounds(0, 0, h, h);
        this.aHE.setCompoundDrawablePadding(h2);
        this.aHE.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.aHF != null) {
            this.aHF.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.aHE;
    }
}
