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
    private EmotionButton bZA;
    private EmotionButton bZB;
    private int bZC;
    private View bZD;
    private NoDataViewFactory.ImgType bZE;
    private int bZF;
    private TbImageView bZv;
    private TextView bZw;
    private TextView bZx;
    private TextView bZy;
    private EmotionButton bZz;
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
        this.bZv = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.bZv.setDefaultBgResource(0);
        this.bZv.setDefaultResource(0);
        this.bZv.setDefaultErrorResource(0);
        this.bZw = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.bZx = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.bZy = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.bZz = (EmotionButton) this.mRootView.findViewById(R.id.btn_func);
        this.bZD = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        akt();
    }

    private void akt() {
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
        if (ah > 0) {
            int i = (int) (ah * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.bZv.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bZv.setLayoutParams(marginLayoutParams);
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
        if (this.bZE == NoDataViewFactory.ImgType.WEBVIEW) {
            this.bZv.setImageBitmap(am.il(R.drawable.new_pic_emotion_08));
        } else if (this.bZE == NoDataViewFactory.ImgType.NODATA) {
            this.bZv.setImageBitmap(am.il(R.drawable.new_pic_emotion_05));
        } else if (this.bZE == NoDataViewFactory.ImgType.LOCAL) {
            this.bZv.setImageBitmap(am.il(this.bZF));
        } else if (this.bZE == NoDataViewFactory.ImgType.ANTI) {
            this.bZv.setImageBitmap(am.il(R.drawable.new_pic_emotion_05));
        } else if (this.bZE == NoDataViewFactory.ImgType.NETERROR) {
            this.bZv.setImageBitmap(am.il(R.drawable.new_pic_emotion_09));
        } else {
            this.bZv.setImageBitmap(am.il(this.bZC));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.bZy.setText(dVar.mTitle);
                this.bZy.setVisibility(0);
            } else {
                this.bZy.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.bGB)) {
                this.bZx.setVisibility(0);
                this.bZx.setText(dVar.bGB);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.bZN >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bZx.getLayoutParams();
                    layoutParams.topMargin = dVar.bZN;
                    this.bZx.setLayoutParams(layoutParams);
                }
                if (dVar.bZO != 0) {
                    setSubTitleCompoundDrawable(dVar.bZO);
                }
            } else {
                this.bZx.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.bZM)) {
                this.bZw.setText(dVar.bZM);
                this.bZw.setVisibility(0);
                return;
            }
            this.bZw.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.bZE = cVar.bZL;
            this.bZF = cVar.bZF;
            switch (cVar.bZL) {
                case CREATE:
                    this.bZC = R.drawable.new_pic_emotion_03;
                    break;
                case NODATA:
                    this.bZC = R.drawable.new_pic_emotion_05;
                    break;
                case FINDBAR:
                    this.bZC = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.bZC = R.drawable.new_pic_emotion_02;
                    break;
                case GIFT:
                    this.bZC = R.drawable.new_pic_emotion_07;
                    break;
                case SINGALL:
                    this.bZC = R.drawable.new_pic_emotion_06;
                    break;
                case WEBVIEW:
                    this.bZC = R.drawable.new_pic_emotion_08;
                    break;
                case ANTI:
                    this.bZC = R.drawable.new_pic_emotion_05;
                    break;
                case NETERROR:
                    this.bZC = R.drawable.new_pic_emotion_09;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bZv.getLayoutParams();
            if (cVar.aPm >= 0) {
                layoutParams.setMargins(0, cVar.aPm, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.bZv.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.bZz.setVisibility(8);
            this.bZD.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.bZI;
        NoDataViewFactory.a aVar2 = bVar.bZJ;
        if (aVar2 == null && aVar != null) {
            this.bZz.setOnClickListener(aVar.bZH);
            this.bZz.setText(aVar.amD);
            this.bZz.setVisibility(0);
            if (bVar.bZK >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bZz.getLayoutParams();
                layoutParams.topMargin = bVar.bZK;
                this.bZz.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.bZA = (EmotionButton) this.bZD.findViewById(R.id.btn_left);
            this.bZB = (EmotionButton) this.bZD.findViewById(R.id.btn_right);
            this.bZA.setOnClickListener(aVar.bZH);
            this.bZA.setText(aVar.amD);
            this.bZB.setOnClickListener(aVar2.bZH);
            this.bZB.setText(aVar2.amD);
            this.bZD.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void aku() {
        this.bZv.setImageDrawable(null);
        this.bZv.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.bZy != null) {
            am.f(this.bZy, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.bZx != null) {
            am.f(this.bZx, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.bZw != null) {
            am.f(this.bZw, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = am.getDrawable(i);
        int g = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds32);
        int g2 = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, g, g);
        this.bZx.setCompoundDrawablePadding(g2);
        this.bZx.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.bZy != null) {
            this.bZy.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.bZx;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }
}
