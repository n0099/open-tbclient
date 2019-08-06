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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.EmotionButton;
/* loaded from: classes.dex */
public class NoDataView extends LinearLayout {
    private TbImageView bZB;
    private TextView bZC;
    private TextView bZD;
    private TextView bZE;
    private EmotionButton bZF;
    private EmotionButton bZG;
    private EmotionButton bZH;
    private int bZI;
    private View bZJ;
    private NoDataViewFactory.ImgType bZK;
    private int bZL;
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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.no_data_view, this);
        this.bZB = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.bZB.setDefaultBgResource(0);
        this.bZB.setDefaultResource(0);
        this.bZB.setDefaultErrorResource(0);
        this.bZC = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.bZD = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.bZE = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.bZF = (EmotionButton) this.mRootView.findViewById(R.id.btn_func);
        this.bZJ = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        akv();
    }

    private void akv() {
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
        if (ah > 0) {
            int i = (int) (ah * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.bZB.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bZB.setLayoutParams(marginLayoutParams);
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
        if (this.bZK == NoDataViewFactory.ImgType.WEBVIEW) {
            this.bZB.setImageBitmap(am.il(R.drawable.new_pic_emotion_08));
        } else if (this.bZK == NoDataViewFactory.ImgType.NODATA) {
            this.bZB.setImageBitmap(am.il(R.drawable.new_pic_emotion_05));
        } else if (this.bZK == NoDataViewFactory.ImgType.LOCAL) {
            this.bZB.setImageBitmap(am.il(this.bZL));
        } else if (this.bZK == NoDataViewFactory.ImgType.ANTI) {
            this.bZB.setImageBitmap(am.il(R.drawable.new_pic_emotion_05));
        } else if (this.bZK == NoDataViewFactory.ImgType.NETERROR) {
            this.bZB.setImageBitmap(am.il(R.drawable.new_pic_emotion_09));
        } else {
            this.bZB.setImageBitmap(am.il(this.bZI));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.bZE.setText(dVar.mTitle);
                this.bZE.setVisibility(0);
            } else {
                this.bZE.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.bGC)) {
                this.bZD.setVisibility(0);
                this.bZD.setText(dVar.bGC);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.bZT >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bZD.getLayoutParams();
                    layoutParams.topMargin = dVar.bZT;
                    this.bZD.setLayoutParams(layoutParams);
                }
                if (dVar.bZU != 0) {
                    setSubTitleCompoundDrawable(dVar.bZU);
                }
            } else {
                this.bZD.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.bZS)) {
                this.bZC.setText(dVar.bZS);
                this.bZC.setVisibility(0);
                return;
            }
            this.bZC.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.bZK = cVar.bZR;
            this.bZL = cVar.bZL;
            switch (cVar.bZR) {
                case CREATE:
                    this.bZI = R.drawable.new_pic_emotion_03;
                    break;
                case NODATA:
                    this.bZI = R.drawable.new_pic_emotion_05;
                    break;
                case FINDBAR:
                    this.bZI = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.bZI = R.drawable.new_pic_emotion_02;
                    break;
                case GIFT:
                    this.bZI = R.drawable.new_pic_emotion_07;
                    break;
                case SINGALL:
                    this.bZI = R.drawable.new_pic_emotion_06;
                    break;
                case WEBVIEW:
                    this.bZI = R.drawable.new_pic_emotion_08;
                    break;
                case ANTI:
                    this.bZI = R.drawable.new_pic_emotion_05;
                    break;
                case NETERROR:
                    this.bZI = R.drawable.new_pic_emotion_09;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bZB.getLayoutParams();
            if (cVar.aPm >= 0) {
                layoutParams.setMargins(0, cVar.aPm, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.bZB.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.bZF.setVisibility(8);
            this.bZJ.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.bZO;
        NoDataViewFactory.a aVar2 = bVar.bZP;
        if (aVar2 == null && aVar != null) {
            this.bZF.setOnClickListener(aVar.bZN);
            this.bZF.setText(aVar.amD);
            this.bZF.setVisibility(0);
            if (bVar.bZQ >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bZF.getLayoutParams();
                layoutParams.topMargin = bVar.bZQ;
                this.bZF.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.bZG = (EmotionButton) this.bZJ.findViewById(R.id.btn_left);
            this.bZH = (EmotionButton) this.bZJ.findViewById(R.id.btn_right);
            this.bZG.setOnClickListener(aVar.bZN);
            this.bZG.setText(aVar.amD);
            this.bZH.setOnClickListener(aVar2.bZN);
            this.bZH.setText(aVar2.amD);
            this.bZJ.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void akw() {
        this.bZB.setImageDrawable(null);
        this.bZB.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.bZE != null) {
            am.f(this.bZE, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.bZD != null) {
            am.f(this.bZD, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.bZC != null) {
            am.f(this.bZC, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = am.getDrawable(i);
        int g = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds32);
        int g2 = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, g, g);
        this.bZD.setCompoundDrawablePadding(g2);
        this.bZD.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.bZE != null) {
            this.bZE.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.bZD;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }
}
