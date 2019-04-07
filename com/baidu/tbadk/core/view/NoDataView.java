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
    private TbImageView bQA;
    private TextView bQB;
    private TextView bQC;
    private TextView bQD;
    private EmotionButton bQE;
    private EmotionButton bQF;
    private EmotionButton bQG;
    private int bQH;
    private View bQI;
    private NoDataViewFactory.ImgType bQJ;
    private int bQK;
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
        this.bQA = (TbImageView) this.mRootView.findViewById(d.g.iv_no_data_img);
        this.bQA.setDefaultBgResource(0);
        this.bQA.setDefaultResource(0);
        this.bQA.setDefaultErrorResource(0);
        this.bQB = (TextView) this.mRootView.findViewById(d.g.tv_text_reamrk);
        this.bQC = (TextView) this.mRootView.findViewById(d.g.tv_subtitle);
        this.bQD = (TextView) this.mRootView.findViewById(d.g.tv_title);
        this.bQE = (EmotionButton) this.mRootView.findViewById(d.g.btn_func);
        this.bQI = (LinearLayout) this.mRootView.findViewById(d.g.two_button_layout);
        aeq();
    }

    private void aeq() {
        int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst());
        if (aQ > 0) {
            int i = (int) (aQ * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.bQA.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bQA.setLayoutParams(marginLayoutParams);
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
        if (this.bQJ == NoDataViewFactory.ImgType.WEBVIEW) {
            this.bQA.setImageBitmap(al.hr(d.f.new_pic_emotion_08));
        } else if (this.bQJ == NoDataViewFactory.ImgType.NODATA) {
            this.bQA.setImageBitmap(al.hr(d.f.new_pic_emotion_05));
        } else if (this.bQJ == NoDataViewFactory.ImgType.LOCAL) {
            this.bQA.setImageBitmap(al.hr(this.bQK));
        } else if (this.bQJ == NoDataViewFactory.ImgType.ANTI) {
            this.bQA.setImageBitmap(al.hr(d.f.new_pic_emotion_05));
        } else if (this.bQJ == NoDataViewFactory.ImgType.NETERROR) {
            this.bQA.setImageBitmap(al.hr(d.f.new_pic_emotion_09));
        } else {
            this.bQA.setImageBitmap(al.hr(this.bQH));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.bQD.setText(dVar.mTitle);
                this.bQD.setVisibility(0);
            } else {
                this.bQD.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.byn)) {
                this.bQC.setVisibility(0);
                this.bQC.setText(dVar.byn);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.bQS >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bQC.getLayoutParams();
                    layoutParams.topMargin = dVar.bQS;
                    this.bQC.setLayoutParams(layoutParams);
                }
                if (dVar.bQT != 0) {
                    setSubTitleCompoundDrawable(dVar.bQT);
                }
            } else {
                this.bQC.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.bQR)) {
                this.bQB.setText(dVar.bQR);
                this.bQB.setVisibility(0);
                return;
            }
            this.bQB.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.bQJ = cVar.bQQ;
            this.bQK = cVar.bQK;
            switch (cVar.bQQ) {
                case CREATE:
                    this.bQH = d.f.new_pic_emotion_03;
                    break;
                case NODATA:
                    this.bQH = d.f.new_pic_emotion_05;
                    break;
                case FINDBAR:
                    this.bQH = d.f.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.bQH = d.f.new_pic_emotion_02;
                    break;
                case GIFT:
                    this.bQH = d.f.new_pic_emotion_07;
                    break;
                case SINGALL:
                    this.bQH = d.f.new_pic_emotion_06;
                    break;
                case WEBVIEW:
                    this.bQH = d.f.new_pic_emotion_08;
                    break;
                case ANTI:
                    this.bQH = d.f.new_pic_emotion_05;
                    break;
                case NETERROR:
                    this.bQH = d.f.new_pic_emotion_09;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bQA.getLayoutParams();
            if (cVar.aME >= 0) {
                layoutParams.setMargins(0, cVar.aME, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.bQA.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.bQE.setVisibility(8);
            this.bQI.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.bQN;
        NoDataViewFactory.a aVar2 = bVar.bQO;
        if (aVar2 == null && aVar != null) {
            this.bQE.setOnClickListener(aVar.bQM);
            this.bQE.setText(aVar.alN);
            this.bQE.setVisibility(0);
            if (bVar.bQP >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bQE.getLayoutParams();
                layoutParams.topMargin = bVar.bQP;
                this.bQE.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.bQF = (EmotionButton) this.bQI.findViewById(d.g.btn_left);
            this.bQG = (EmotionButton) this.bQI.findViewById(d.g.btn_right);
            this.bQF.setOnClickListener(aVar.bQM);
            this.bQF.setText(aVar.alN);
            this.bQG.setOnClickListener(aVar2.bQM);
            this.bQG.setText(aVar2.alN);
            this.bQI.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.bQA.setImageDrawable(null);
        this.bQA.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.bQD != null) {
            al.d(this.bQD, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.bQC != null) {
            al.d(this.bQC, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.bQB != null) {
            al.d(this.bQB, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = al.getDrawable(i);
        int h = com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds32);
        int h2 = com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds8);
        drawable.setBounds(0, 0, h, h);
        this.bQC.setCompoundDrawablePadding(h2);
        this.bQC.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.bQD != null) {
            this.bQD.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.bQC;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }
}
