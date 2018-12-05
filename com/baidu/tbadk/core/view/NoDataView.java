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
    private TbImageView aHB;
    private TextView aHC;
    private TextView aHD;
    private TextView aHE;
    private TextView aHF;
    private TextView aHG;
    private TextView aHH;
    private String aHI;
    private String aHJ;
    private View aHK;
    private NoDataViewFactory.ImgType aHL;
    private int aHM;
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
        this.aHB = (TbImageView) this.mRootView.findViewById(e.g.iv_no_data_img);
        this.aHB.setDefaultBgResource(0);
        this.aHB.setDefaultResource(0);
        this.aHB.setDefaultErrorResource(0);
        this.aHC = (TextView) this.mRootView.findViewById(e.g.tv_text_reamrk);
        this.aHD = (TextView) this.mRootView.findViewById(e.g.tv_subtitle);
        this.aHE = (TextView) this.mRootView.findViewById(e.g.tv_title);
        this.aHF = (TextView) this.mRootView.findViewById(e.g.btn_func);
        this.aHK = (LinearLayout) this.mRootView.findViewById(e.g.two_button_layout);
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
        if (this.aHL == NoDataViewFactory.ImgType.WEBVIEW) {
            this.aHB.setImageBitmap(al.dQ(e.f.pic_emotion08));
        } else if (this.aHL == NoDataViewFactory.ImgType.NODATA) {
            this.aHB.setImageBitmap(al.dQ(e.f.no_data_image));
        } else if (this.aHL == NoDataViewFactory.ImgType.LOCAL) {
            this.aHB.setImageBitmap(al.dQ(this.aHM));
        } else if (this.aHL == NoDataViewFactory.ImgType.ANTI) {
            this.aHB.setImageBitmap(al.dQ(e.f.pic_emotion05));
        } else if (i == 1) {
            this.aHB.startLoad(this.aHJ, 29, false);
        } else {
            this.aHB.startLoad(this.aHI, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.aHE.setText(dVar.mTitle);
                this.aHE.setVisibility(0);
            } else {
                this.aHE.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.aqR)) {
                this.aHD.setText(dVar.aqR);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.aHD.setTextSize(0, getResources().getDimension(e.C0210e.fontsize28));
                    if (dVar.aHU >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aHD.getLayoutParams();
                        layoutParams.topMargin = dVar.aHU;
                        this.aHD.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.aHV != 0) {
                    setSubTitleCompoundDrawable(dVar.aHV);
                }
            } else {
                this.aHD.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.aHT)) {
                this.aHC.setText(dVar.aHT);
                this.aHC.setVisibility(0);
                return;
            }
            this.aHC.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.aHL = cVar.aHS;
            this.aHM = cVar.aHM;
            switch (cVar.aHS) {
                case CREATE:
                    this.aHI = com.baidu.tbadk.util.c.PL().iy("pic_emotion03.png");
                    this.aHJ = com.baidu.tbadk.util.c.PL().iy("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.aHI = com.baidu.tbadk.util.c.PL().iy("pic_emotion05.png");
                    this.aHJ = com.baidu.tbadk.util.c.PL().iy("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.aHI = com.baidu.tbadk.util.c.PL().iy("pic_emotion01.png");
                    this.aHJ = com.baidu.tbadk.util.c.PL().iy("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.aHI = com.baidu.tbadk.util.c.PL().iy("pic_emotion02.png");
                    this.aHJ = com.baidu.tbadk.util.c.PL().iy("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.aHI = com.baidu.tbadk.util.c.PL().iy("pic_emotion07.png");
                    this.aHJ = com.baidu.tbadk.util.c.PL().iy("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.aHI = com.baidu.tbadk.util.c.PL().iy("pic_emotion06.png");
                    this.aHJ = com.baidu.tbadk.util.c.PL().iy("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.aHI = com.baidu.tbadk.util.c.PL().iy("pic_emotion08.png");
                    this.aHJ = com.baidu.tbadk.util.c.PL().iy("pic_emotion08_1.png");
                    break;
                case ANTI:
                    this.aHI = com.baidu.tbadk.util.c.PL().iy("pic_emotion05.png");
                    this.aHJ = com.baidu.tbadk.util.c.PL().iy("pic_emotion05_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aHB.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.aHB.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.aHF.setVisibility(8);
            this.aHK.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.aHP;
        NoDataViewFactory.a aVar2 = bVar.aHQ;
        if (aVar2 == null && aVar != null) {
            this.aHF.setOnClickListener(aVar.aHO);
            this.aHF.setText(aVar.mText);
            this.aHF.setVisibility(0);
            if (bVar.aHR >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aHF.getLayoutParams();
                layoutParams.topMargin = bVar.aHR;
                this.aHF.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.aHG = (TextView) this.aHK.findViewById(e.g.btn_left);
            this.aHH = (TextView) this.aHK.findViewById(e.g.btn_right);
            this.aHG.setOnClickListener(aVar.aHO);
            this.aHG.setText(aVar.mText);
            this.aHH.setOnClickListener(aVar2.aHO);
            this.aHH.setText(aVar2.mText);
            this.aHK.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.aHB.setImageDrawable(null);
        this.aHB.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.aHE != null) {
            al.c(this.aHE, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.aHD != null) {
            al.c(this.aHD, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.aHC != null) {
            al.c(this.aHC, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = al.getDrawable(i);
        int h = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds32);
        int h2 = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds8);
        drawable.setBounds(0, 0, h, h);
        this.aHD.setCompoundDrawablePadding(h2);
        this.aHD.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.aHE != null) {
            this.aHE.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.aHD;
    }
}
