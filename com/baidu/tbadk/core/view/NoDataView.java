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
    private TbImageView ayC;
    private TextView ayD;
    private TextView ayE;
    private TextView ayF;
    private TextView ayG;
    private TextView ayH;
    private TextView ayI;
    private String ayJ;
    private String ayK;
    private View ayL;
    private NoDataViewFactory.ImgType ayM;
    private int ayN;
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
        this.ayC = (TbImageView) this.mRootView.findViewById(e.g.iv_no_data_img);
        this.ayC.setDefaultBgResource(0);
        this.ayC.setDefaultResource(0);
        this.ayC.setDefaultErrorResource(0);
        this.ayD = (TextView) this.mRootView.findViewById(e.g.tv_text_reamrk);
        this.ayE = (TextView) this.mRootView.findViewById(e.g.tv_subtitle);
        this.ayF = (TextView) this.mRootView.findViewById(e.g.tv_title);
        this.ayG = (TextView) this.mRootView.findViewById(e.g.btn_func);
        this.ayL = (LinearLayout) this.mRootView.findViewById(e.g.two_button_layout);
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
        if (this.ayM == NoDataViewFactory.ImgType.WEBVIEW) {
            this.ayC.setImageBitmap(al.de(e.f.pic_emotion08));
        } else if (this.ayM == NoDataViewFactory.ImgType.NODATA) {
            this.ayC.setImageBitmap(al.de(e.f.no_data_image));
        } else if (this.ayM == NoDataViewFactory.ImgType.LOCAL) {
            this.ayC.setImageBitmap(al.de(this.ayN));
        } else if (this.ayM == NoDataViewFactory.ImgType.ANTI) {
            this.ayC.setImageBitmap(al.de(e.f.pic_emotion05));
        } else if (i == 1) {
            this.ayC.startLoad(this.ayK, 29, false);
        } else {
            this.ayC.startLoad(this.ayJ, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.ayF.setText(dVar.mTitle);
                this.ayF.setVisibility(0);
            } else {
                this.ayF.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.ahH)) {
                this.ayE.setText(dVar.ahH);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.ayE.setTextSize(0, getResources().getDimension(e.C0141e.fontsize28));
                    if (dVar.ayW >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ayE.getLayoutParams();
                        layoutParams.topMargin = dVar.ayW;
                        this.ayE.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.ayX != 0) {
                    setSubTitleCompoundDrawable(dVar.ayX);
                }
            } else {
                this.ayE.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.ayV)) {
                this.ayD.setText(dVar.ayV);
                this.ayD.setVisibility(0);
                return;
            }
            this.ayD.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.ayM = cVar.ayT;
            this.ayN = cVar.ayN;
            switch (cVar.ayT) {
                case CREATE:
                    this.ayJ = com.baidu.tbadk.util.c.My().hQ("pic_emotion03.png");
                    this.ayK = com.baidu.tbadk.util.c.My().hQ("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.ayJ = com.baidu.tbadk.util.c.My().hQ("pic_emotion05.png");
                    this.ayK = com.baidu.tbadk.util.c.My().hQ("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.ayJ = com.baidu.tbadk.util.c.My().hQ("pic_emotion01.png");
                    this.ayK = com.baidu.tbadk.util.c.My().hQ("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.ayJ = com.baidu.tbadk.util.c.My().hQ("pic_emotion02.png");
                    this.ayK = com.baidu.tbadk.util.c.My().hQ("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.ayJ = com.baidu.tbadk.util.c.My().hQ("pic_emotion07.png");
                    this.ayK = com.baidu.tbadk.util.c.My().hQ("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.ayJ = com.baidu.tbadk.util.c.My().hQ("pic_emotion06.png");
                    this.ayK = com.baidu.tbadk.util.c.My().hQ("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.ayJ = com.baidu.tbadk.util.c.My().hQ("pic_emotion08.png");
                    this.ayK = com.baidu.tbadk.util.c.My().hQ("pic_emotion08_1.png");
                    break;
                case ANTI:
                    this.ayJ = com.baidu.tbadk.util.c.My().hQ("pic_emotion05.png");
                    this.ayK = com.baidu.tbadk.util.c.My().hQ("pic_emotion05_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ayC.getLayoutParams();
            if (cVar.ayU >= 0) {
                layoutParams.setMargins(0, cVar.ayU, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.ayC.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.ayG.setVisibility(8);
            this.ayL.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.ayQ;
        NoDataViewFactory.a aVar2 = bVar.ayR;
        if (aVar2 == null && aVar != null) {
            this.ayG.setOnClickListener(aVar.ayP);
            this.ayG.setText(aVar.aqV);
            this.ayG.setVisibility(0);
            if (bVar.ayS >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ayG.getLayoutParams();
                layoutParams.topMargin = bVar.ayS;
                this.ayG.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.ayH = (TextView) this.ayL.findViewById(e.g.btn_left);
            this.ayI = (TextView) this.ayL.findViewById(e.g.btn_right);
            this.ayH.setOnClickListener(aVar.ayP);
            this.ayH.setText(aVar.aqV);
            this.ayI.setOnClickListener(aVar2.ayP);
            this.ayI.setText(aVar2.aqV);
            this.ayL.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.ayC.setImageDrawable(null);
        this.ayC.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.ayF != null) {
            al.c(this.ayF, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.ayE != null) {
            al.c(this.ayE, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.ayD != null) {
            al.c(this.ayD, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = al.getDrawable(i);
        int h = com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.ds32);
        int h2 = com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.ds8);
        drawable.setBounds(0, 0, h, h);
        this.ayE.setCompoundDrawablePadding(h2);
        this.ayE.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.ayF != null) {
            this.ayF.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.ayE;
    }
}
