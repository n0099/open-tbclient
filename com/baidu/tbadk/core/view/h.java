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
    private TbImageView bbB;
    private TextView bbC;
    private TextView bbD;
    private TextView bbE;
    private TextView bbF;
    private TextView bbG;
    private TextView bbH;
    private String bbI;
    private String bbJ;
    private View bbK;
    private NoDataViewFactory.ImgType bbL;
    private int bbM;
    private Context mContext;
    private View mRootView;

    public h(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.no_data_view, this);
        this.bbB = (TbImageView) this.mRootView.findViewById(d.g.iv_no_data_img);
        this.bbB.setDefaultBgResource(0);
        this.bbB.setDefaultResource(0);
        this.bbB.setDefaultErrorResource(0);
        this.bbC = (TextView) this.mRootView.findViewById(d.g.tv_text_reamrk);
        this.bbD = (TextView) this.mRootView.findViewById(d.g.tv_subtitle);
        this.bbE = (TextView) this.mRootView.findViewById(d.g.tv_title);
        this.bbF = (TextView) this.mRootView.findViewById(d.g.btn_func);
        this.bbK = (LinearLayout) this.mRootView.findViewById(d.g.two_button_layout);
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
        if (this.bbL == NoDataViewFactory.ImgType.WEBVIEW) {
            this.bbB.setImageBitmap(aj.fQ(d.f.pic_emotion08));
        } else if (this.bbL == NoDataViewFactory.ImgType.NODATA) {
            this.bbB.setImageBitmap(aj.fQ(d.f.no_data_image));
        } else if (this.bbL == NoDataViewFactory.ImgType.LOCAL) {
            this.bbB.setImageBitmap(aj.fQ(this.bbM));
        } else if (i == 1) {
            this.bbB.startLoad(this.bbJ, 29, false);
        } else {
            this.bbB.startLoad(this.bbI, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.bbE.setText(dVar.mTitle);
                this.bbE.setVisibility(0);
            } else {
                this.bbE.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.aMa)) {
                this.bbD.setText(dVar.aMa);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.bbD.setTextSize(0, getResources().getDimension(d.e.fontsize28));
                    if (dVar.bbW >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbD.getLayoutParams();
                        layoutParams.topMargin = dVar.bbW;
                        this.bbD.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.bbX != 0) {
                    setSubTitleCompoundDrawable(dVar.bbX);
                }
            } else {
                this.bbD.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.bbV)) {
                this.bbC.setText(dVar.bbV);
                this.bbC.setVisibility(0);
                return;
            }
            this.bbC.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.bbL = cVar.bbS;
            this.bbM = cVar.bbM;
            switch (cVar.bbS) {
                case CREATE:
                    this.bbI = com.baidu.tbadk.util.b.OV().hf("pic_emotion03.png");
                    this.bbJ = com.baidu.tbadk.util.b.OV().hf("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.bbI = com.baidu.tbadk.util.b.OV().hf("pic_emotion05.png");
                    this.bbJ = com.baidu.tbadk.util.b.OV().hf("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.bbI = com.baidu.tbadk.util.b.OV().hf("pic_emotion01.png");
                    this.bbJ = com.baidu.tbadk.util.b.OV().hf("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.bbI = com.baidu.tbadk.util.b.OV().hf("pic_emotion02.png");
                    this.bbJ = com.baidu.tbadk.util.b.OV().hf("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.bbI = com.baidu.tbadk.util.b.OV().hf("pic_emotion07.png");
                    this.bbJ = com.baidu.tbadk.util.b.OV().hf("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.bbI = com.baidu.tbadk.util.b.OV().hf("pic_emotion06.png");
                    this.bbJ = com.baidu.tbadk.util.b.OV().hf("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.bbI = com.baidu.tbadk.util.b.OV().hf("pic_emotion08.png");
                    this.bbJ = com.baidu.tbadk.util.b.OV().hf("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbB.getLayoutParams();
            if (cVar.bbT >= 0) {
                layoutParams.setMargins(0, cVar.bbT, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.bbB.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.bbF.setVisibility(8);
            this.bbK.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.bbP;
        NoDataViewFactory.a aVar2 = bVar.bbQ;
        if (aVar2 == null && aVar != null) {
            this.bbF.setOnClickListener(aVar.bbO);
            this.bbF.setText(aVar.aUN);
            this.bbF.setVisibility(0);
            if (bVar.bbR >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbF.getLayoutParams();
                layoutParams.topMargin = bVar.bbR;
                this.bbF.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.bbG = (TextView) this.bbK.findViewById(d.g.btn_left);
            this.bbH = (TextView) this.bbK.findViewById(d.g.btn_right);
            this.bbG.setOnClickListener(aVar.bbO);
            this.bbG.setText(aVar.aUN);
            this.bbH.setOnClickListener(aVar2.bbO);
            this.bbH.setText(aVar2.aUN);
            this.bbK.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.bbB.setImageDrawable(null);
        this.bbB.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.bbE != null) {
            aj.e(this.bbE, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.bbD != null) {
            aj.e(this.bbD, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.bbC != null) {
            aj.e(this.bbC, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = aj.getDrawable(i);
        int t = com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds32);
        int t2 = com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds8);
        drawable.setBounds(0, 0, t, t);
        this.bbD.setCompoundDrawablePadding(t2);
        this.bbD.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.bbD;
    }
}
