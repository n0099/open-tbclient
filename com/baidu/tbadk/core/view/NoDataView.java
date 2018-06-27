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
    private TbImageView avM;
    private TextView avN;
    private TextView avO;
    private TextView avP;
    private TextView avQ;
    private TextView avR;
    private TextView avS;
    private String avT;
    private String avU;
    private View avV;
    private NoDataViewFactory.ImgType avW;
    private int avX;
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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.no_data_view, this);
        this.avM = (TbImageView) this.mRootView.findViewById(d.g.iv_no_data_img);
        this.avM.setDefaultBgResource(0);
        this.avM.setDefaultResource(0);
        this.avM.setDefaultErrorResource(0);
        this.avN = (TextView) this.mRootView.findViewById(d.g.tv_text_reamrk);
        this.avO = (TextView) this.mRootView.findViewById(d.g.tv_subtitle);
        this.avP = (TextView) this.mRootView.findViewById(d.g.tv_title);
        this.avQ = (TextView) this.mRootView.findViewById(d.g.btn_func);
        this.avV = (LinearLayout) this.mRootView.findViewById(d.g.two_button_layout);
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
        if (this.avW == NoDataViewFactory.ImgType.WEBVIEW) {
            this.avM.setImageBitmap(am.cT(d.f.pic_emotion08));
        } else if (this.avW == NoDataViewFactory.ImgType.NODATA) {
            this.avM.setImageBitmap(am.cT(d.f.no_data_image));
        } else if (this.avW == NoDataViewFactory.ImgType.LOCAL) {
            this.avM.setImageBitmap(am.cT(this.avX));
        } else if (this.avW == NoDataViewFactory.ImgType.ANTI) {
            this.avM.setImageBitmap(am.cT(d.f.pic_emotion05));
        } else if (i == 1) {
            this.avM.startLoad(this.avU, 29, false);
        } else {
            this.avM.startLoad(this.avT, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.avP.setText(dVar.mTitle);
                this.avP.setVisibility(0);
            } else {
                this.avP.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.afM)) {
                this.avO.setText(dVar.afM);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.avO.setTextSize(0, getResources().getDimension(d.e.fontsize28));
                    if (dVar.awg >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avO.getLayoutParams();
                        layoutParams.topMargin = dVar.awg;
                        this.avO.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.awh != 0) {
                    setSubTitleCompoundDrawable(dVar.awh);
                }
            } else {
                this.avO.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.awf)) {
                this.avN.setText(dVar.awf);
                this.avN.setVisibility(0);
                return;
            }
            this.avN.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.avW = cVar.awd;
            this.avX = cVar.avX;
            switch (cVar.awd) {
                case CREATE:
                    this.avT = com.baidu.tbadk.util.b.Li().hw("pic_emotion03.png");
                    this.avU = com.baidu.tbadk.util.b.Li().hw("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.avT = com.baidu.tbadk.util.b.Li().hw("pic_emotion05.png");
                    this.avU = com.baidu.tbadk.util.b.Li().hw("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.avT = com.baidu.tbadk.util.b.Li().hw("pic_emotion01.png");
                    this.avU = com.baidu.tbadk.util.b.Li().hw("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.avT = com.baidu.tbadk.util.b.Li().hw("pic_emotion02.png");
                    this.avU = com.baidu.tbadk.util.b.Li().hw("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.avT = com.baidu.tbadk.util.b.Li().hw("pic_emotion07.png");
                    this.avU = com.baidu.tbadk.util.b.Li().hw("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.avT = com.baidu.tbadk.util.b.Li().hw("pic_emotion06.png");
                    this.avU = com.baidu.tbadk.util.b.Li().hw("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.avT = com.baidu.tbadk.util.b.Li().hw("pic_emotion08.png");
                    this.avU = com.baidu.tbadk.util.b.Li().hw("pic_emotion08_1.png");
                    break;
                case ANTI:
                    this.avT = com.baidu.tbadk.util.b.Li().hw("pic_emotion05.png");
                    this.avU = com.baidu.tbadk.util.b.Li().hw("pic_emotion05_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avM.getLayoutParams();
            if (cVar.awe >= 0) {
                layoutParams.setMargins(0, cVar.awe, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.avM.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.avQ.setVisibility(8);
            this.avV.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.awa;
        NoDataViewFactory.a aVar2 = bVar.awb;
        if (aVar2 == null && aVar != null) {
            this.avQ.setOnClickListener(aVar.avZ);
            this.avQ.setText(aVar.aoM);
            this.avQ.setVisibility(0);
            if (bVar.awc >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avQ.getLayoutParams();
                layoutParams.topMargin = bVar.awc;
                this.avQ.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.avR = (TextView) this.avV.findViewById(d.g.btn_left);
            this.avS = (TextView) this.avV.findViewById(d.g.btn_right);
            this.avR.setOnClickListener(aVar.avZ);
            this.avR.setText(aVar.aoM);
            this.avS.setOnClickListener(aVar2.avZ);
            this.avS.setText(aVar2.aoM);
            this.avV.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.avM.setImageDrawable(null);
        this.avM.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.avP != null) {
            am.c(this.avP, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.avO != null) {
            am.c(this.avO, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.avN != null) {
            am.c(this.avN, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = am.getDrawable(i);
        int e = com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds32);
        int e2 = com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds8);
        drawable.setBounds(0, 0, e, e);
        this.avO.setCompoundDrawablePadding(e2);
        this.avO.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.avP != null) {
            this.avP.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.avO;
    }
}
