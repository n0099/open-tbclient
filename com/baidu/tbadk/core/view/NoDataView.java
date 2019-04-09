package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.view.EmotionButton;
/* loaded from: classes.dex */
public class NoDataView extends LinearLayout {
    private TbImageView bQB;
    private TextView bQC;
    private TextView bQD;
    private TextView bQE;
    private EmotionButton bQF;
    private EmotionButton bQG;
    private EmotionButton bQH;
    private int bQI;
    private View bQJ;
    private NoDataViewFactory.ImgType bQK;
    private int bQL;
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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.no_data_view, this);
        this.bQB = (TbImageView) this.mRootView.findViewById(d.g.iv_no_data_img);
        this.bQB.setDefaultBgResource(0);
        this.bQB.setDefaultResource(0);
        this.bQB.setDefaultErrorResource(0);
        this.bQC = (TextView) this.mRootView.findViewById(d.g.tv_text_reamrk);
        this.bQD = (TextView) this.mRootView.findViewById(d.g.tv_subtitle);
        this.bQE = (TextView) this.mRootView.findViewById(d.g.tv_title);
        this.bQF = (EmotionButton) this.mRootView.findViewById(d.g.btn_func);
        this.bQJ = (LinearLayout) this.mRootView.findViewById(d.g.two_button_layout);
        aeq();
    }

    private void aeq() {
        int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst());
        if (aQ > 0) {
            int i = (int) (aQ * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.bQB.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bQB.setLayoutParams(marginLayoutParams);
            }
        }
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
        if (this.bQK == NoDataViewFactory.ImgType.WEBVIEW) {
            this.bQB.setImageBitmap(al.hr(d.f.new_pic_emotion_08));
        } else if (this.bQK == NoDataViewFactory.ImgType.NODATA) {
            this.bQB.setImageBitmap(al.hr(d.f.new_pic_emotion_05));
        } else if (this.bQK == NoDataViewFactory.ImgType.LOCAL) {
            this.bQB.setImageBitmap(al.hr(this.bQL));
        } else if (this.bQK == NoDataViewFactory.ImgType.ANTI) {
            this.bQB.setImageBitmap(al.hr(d.f.new_pic_emotion_05));
        } else if (this.bQK == NoDataViewFactory.ImgType.NETERROR) {
            this.bQB.setImageBitmap(al.hr(d.f.new_pic_emotion_09));
        } else {
            this.bQB.setImageBitmap(al.hr(this.bQI));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.bQE.setText(dVar.mTitle);
                this.bQE.setVisibility(0);
            } else {
                this.bQE.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.byo)) {
                this.bQD.setVisibility(0);
                this.bQD.setText(dVar.byo);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.bQT >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bQD.getLayoutParams();
                    layoutParams.topMargin = dVar.bQT;
                    this.bQD.setLayoutParams(layoutParams);
                }
                if (dVar.bQU != 0) {
                    setSubTitleCompoundDrawable(dVar.bQU);
                }
            } else {
                this.bQD.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.bQS)) {
                this.bQC.setText(dVar.bQS);
                this.bQC.setVisibility(0);
                return;
            }
            this.bQC.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.bQK = cVar.bQR;
            this.bQL = cVar.bQL;
            switch (cVar.bQR) {
                case CREATE:
                    this.bQI = d.f.new_pic_emotion_03;
                    break;
                case NODATA:
                    this.bQI = d.f.new_pic_emotion_05;
                    break;
                case FINDBAR:
                    this.bQI = d.f.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.bQI = d.f.new_pic_emotion_02;
                    break;
                case GIFT:
                    this.bQI = d.f.new_pic_emotion_07;
                    break;
                case SINGALL:
                    this.bQI = d.f.new_pic_emotion_06;
                    break;
                case WEBVIEW:
                    this.bQI = d.f.new_pic_emotion_08;
                    break;
                case ANTI:
                    this.bQI = d.f.new_pic_emotion_05;
                    break;
                case NETERROR:
                    this.bQI = d.f.new_pic_emotion_09;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bQB.getLayoutParams();
            if (cVar.aMF >= 0) {
                layoutParams.setMargins(0, cVar.aMF, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.bQB.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.bQF.setVisibility(8);
            this.bQJ.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.bQO;
        NoDataViewFactory.a aVar2 = bVar.bQP;
        if (aVar2 == null && aVar != null) {
            this.bQF.setOnClickListener(aVar.bQN);
            this.bQF.setText(aVar.alO);
            this.bQF.setVisibility(0);
            if (bVar.bQQ >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bQF.getLayoutParams();
                layoutParams.topMargin = bVar.bQQ;
                this.bQF.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.bQG = (EmotionButton) this.bQJ.findViewById(d.g.btn_left);
            this.bQH = (EmotionButton) this.bQJ.findViewById(d.g.btn_right);
            this.bQG.setOnClickListener(aVar.bQN);
            this.bQG.setText(aVar.alO);
            this.bQH.setOnClickListener(aVar2.bQN);
            this.bQH.setText(aVar2.alO);
            this.bQJ.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.bQB.setImageDrawable(null);
        this.bQB.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.bQE != null) {
            al.d(this.bQE, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.bQD != null) {
            al.d(this.bQD, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.bQC != null) {
            al.d(this.bQC, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = al.getDrawable(i);
        int h = com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds32);
        int h2 = com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds8);
        drawable.setBounds(0, 0, h, h);
        this.bQD.setCompoundDrawablePadding(h2);
        this.bQD.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.bQE != null) {
            this.bQE.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.bQD;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }
}
