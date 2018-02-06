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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h extends LinearLayout {
    private TbImageView bbL;
    private TextView bbM;
    private TextView bbN;
    private TextView bbO;
    private TextView bbP;
    private TextView bbQ;
    private TextView bbR;
    private String bbS;
    private String bbT;
    private View bbU;
    private NoDataViewFactory.ImgType bbV;
    private int bbW;
    private Context mContext;
    private View mRootView;

    public h(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.no_data_view, this);
        this.bbL = (TbImageView) this.mRootView.findViewById(d.g.iv_no_data_img);
        this.bbL.setDefaultBgResource(0);
        this.bbL.setDefaultResource(0);
        this.bbL.setDefaultErrorResource(0);
        this.bbM = (TextView) this.mRootView.findViewById(d.g.tv_text_reamrk);
        this.bbN = (TextView) this.mRootView.findViewById(d.g.tv_subtitle);
        this.bbO = (TextView) this.mRootView.findViewById(d.g.tv_title);
        this.bbP = (TextView) this.mRootView.findViewById(d.g.btn_func);
        this.bbU = (LinearLayout) this.mRootView.findViewById(d.g.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().aQ(i == 1);
            ((TbPageContext) eVar).getLayoutMode().aM(this);
        }
        if (this.bbV == NoDataViewFactory.ImgType.WEBVIEW) {
            this.bbL.setImageBitmap(aj.fQ(d.f.pic_emotion08));
        } else if (this.bbV == NoDataViewFactory.ImgType.NODATA) {
            this.bbL.setImageBitmap(aj.fQ(d.f.no_data_image));
        } else if (this.bbV == NoDataViewFactory.ImgType.LOCAL) {
            this.bbL.setImageBitmap(aj.fQ(this.bbW));
        } else if (i == 1) {
            this.bbL.startLoad(this.bbT, 29, false);
        } else {
            this.bbL.startLoad(this.bbS, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.bbO.setText(dVar.mTitle);
                this.bbO.setVisibility(0);
            } else {
                this.bbO.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.aMk)) {
                this.bbN.setText(dVar.aMk);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.bbN.setTextSize(0, getResources().getDimension(d.e.fontsize28));
                    if (dVar.bcg >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbN.getLayoutParams();
                        layoutParams.topMargin = dVar.bcg;
                        this.bbN.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.bch != 0) {
                    setSubTitleCompoundDrawable(dVar.bch);
                }
            } else {
                this.bbN.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.bcf)) {
                this.bbM.setText(dVar.bcf);
                this.bbM.setVisibility(0);
                return;
            }
            this.bbM.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.bbV = cVar.bcc;
            this.bbW = cVar.bbW;
            switch (cVar.bcc) {
                case CREATE:
                    this.bbS = com.baidu.tbadk.util.b.OV().hf("pic_emotion03.png");
                    this.bbT = com.baidu.tbadk.util.b.OV().hf("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.bbS = com.baidu.tbadk.util.b.OV().hf("pic_emotion05.png");
                    this.bbT = com.baidu.tbadk.util.b.OV().hf("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.bbS = com.baidu.tbadk.util.b.OV().hf("pic_emotion01.png");
                    this.bbT = com.baidu.tbadk.util.b.OV().hf("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.bbS = com.baidu.tbadk.util.b.OV().hf("pic_emotion02.png");
                    this.bbT = com.baidu.tbadk.util.b.OV().hf("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.bbS = com.baidu.tbadk.util.b.OV().hf("pic_emotion07.png");
                    this.bbT = com.baidu.tbadk.util.b.OV().hf("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.bbS = com.baidu.tbadk.util.b.OV().hf("pic_emotion06.png");
                    this.bbT = com.baidu.tbadk.util.b.OV().hf("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.bbS = com.baidu.tbadk.util.b.OV().hf("pic_emotion08.png");
                    this.bbT = com.baidu.tbadk.util.b.OV().hf("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbL.getLayoutParams();
            if (cVar.bcd >= 0) {
                layoutParams.setMargins(0, cVar.bcd, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.bbL.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.bbP.setVisibility(8);
            this.bbU.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.bbZ;
        NoDataViewFactory.a aVar2 = bVar.bca;
        if (aVar2 == null && aVar != null) {
            this.bbP.setOnClickListener(aVar.bbY);
            this.bbP.setText(aVar.aUX);
            this.bbP.setVisibility(0);
            if (bVar.bcb >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbP.getLayoutParams();
                layoutParams.topMargin = bVar.bcb;
                this.bbP.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.bbQ = (TextView) this.bbU.findViewById(d.g.btn_left);
            this.bbR = (TextView) this.bbU.findViewById(d.g.btn_right);
            this.bbQ.setOnClickListener(aVar.bbY);
            this.bbQ.setText(aVar.aUX);
            this.bbR.setOnClickListener(aVar2.bbY);
            this.bbR.setText(aVar2.aUX);
            this.bbU.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.bbL.setImageDrawable(null);
        this.bbL.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.bbO != null) {
            aj.e(this.bbO, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.bbN != null) {
            aj.e(this.bbN, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.bbM != null) {
            aj.e(this.bbM, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = aj.getDrawable(i);
        int t = com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds32);
        int t2 = com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds8);
        drawable.setBounds(0, 0, t, t);
        this.bbN.setCompoundDrawablePadding(t2);
        this.bbN.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.bbN;
    }
}
