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
    private TextView bQA;
    private EmotionButton bQB;
    private EmotionButton bQC;
    private EmotionButton bQD;
    private int bQE;
    private View bQF;
    private NoDataViewFactory.ImgType bQG;
    private int bQH;
    private TbImageView bQx;
    private TextView bQy;
    private TextView bQz;
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
        this.bQx = (TbImageView) this.mRootView.findViewById(d.g.iv_no_data_img);
        this.bQx.setDefaultBgResource(0);
        this.bQx.setDefaultResource(0);
        this.bQx.setDefaultErrorResource(0);
        this.bQy = (TextView) this.mRootView.findViewById(d.g.tv_text_reamrk);
        this.bQz = (TextView) this.mRootView.findViewById(d.g.tv_subtitle);
        this.bQA = (TextView) this.mRootView.findViewById(d.g.tv_title);
        this.bQB = (EmotionButton) this.mRootView.findViewById(d.g.btn_func);
        this.bQF = (LinearLayout) this.mRootView.findViewById(d.g.two_button_layout);
        aet();
    }

    private void aet() {
        int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst());
        if (aQ > 0) {
            int i = (int) (aQ * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.bQx.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bQx.setLayoutParams(marginLayoutParams);
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
        if (this.bQG == NoDataViewFactory.ImgType.WEBVIEW) {
            this.bQx.setImageBitmap(al.hs(d.f.new_pic_emotion_08));
        } else if (this.bQG == NoDataViewFactory.ImgType.NODATA) {
            this.bQx.setImageBitmap(al.hs(d.f.new_pic_emotion_05));
        } else if (this.bQG == NoDataViewFactory.ImgType.LOCAL) {
            this.bQx.setImageBitmap(al.hs(this.bQH));
        } else if (this.bQG == NoDataViewFactory.ImgType.ANTI) {
            this.bQx.setImageBitmap(al.hs(d.f.new_pic_emotion_05));
        } else if (this.bQG == NoDataViewFactory.ImgType.NETERROR) {
            this.bQx.setImageBitmap(al.hs(d.f.new_pic_emotion_09));
        } else {
            this.bQx.setImageBitmap(al.hs(this.bQE));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.bQA.setText(dVar.mTitle);
                this.bQA.setVisibility(0);
            } else {
                this.bQA.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.byi)) {
                this.bQz.setVisibility(0);
                this.bQz.setText(dVar.byi);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.bQP >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bQz.getLayoutParams();
                    layoutParams.topMargin = dVar.bQP;
                    this.bQz.setLayoutParams(layoutParams);
                }
                if (dVar.bQQ != 0) {
                    setSubTitleCompoundDrawable(dVar.bQQ);
                }
            } else {
                this.bQz.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.bQO)) {
                this.bQy.setText(dVar.bQO);
                this.bQy.setVisibility(0);
                return;
            }
            this.bQy.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.bQG = cVar.bQN;
            this.bQH = cVar.bQH;
            switch (cVar.bQN) {
                case CREATE:
                    this.bQE = d.f.new_pic_emotion_03;
                    break;
                case NODATA:
                    this.bQE = d.f.new_pic_emotion_05;
                    break;
                case FINDBAR:
                    this.bQE = d.f.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.bQE = d.f.new_pic_emotion_02;
                    break;
                case GIFT:
                    this.bQE = d.f.new_pic_emotion_07;
                    break;
                case SINGALL:
                    this.bQE = d.f.new_pic_emotion_06;
                    break;
                case WEBVIEW:
                    this.bQE = d.f.new_pic_emotion_08;
                    break;
                case ANTI:
                    this.bQE = d.f.new_pic_emotion_05;
                    break;
                case NETERROR:
                    this.bQE = d.f.new_pic_emotion_09;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bQx.getLayoutParams();
            if (cVar.aMA >= 0) {
                layoutParams.setMargins(0, cVar.aMA, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.bQx.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.bQB.setVisibility(8);
            this.bQF.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.bQK;
        NoDataViewFactory.a aVar2 = bVar.bQL;
        if (aVar2 == null && aVar != null) {
            this.bQB.setOnClickListener(aVar.bQJ);
            this.bQB.setText(aVar.alI);
            this.bQB.setVisibility(0);
            if (bVar.bQM >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bQB.getLayoutParams();
                layoutParams.topMargin = bVar.bQM;
                this.bQB.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.bQC = (EmotionButton) this.bQF.findViewById(d.g.btn_left);
            this.bQD = (EmotionButton) this.bQF.findViewById(d.g.btn_right);
            this.bQC.setOnClickListener(aVar.bQJ);
            this.bQC.setText(aVar.alI);
            this.bQD.setOnClickListener(aVar2.bQJ);
            this.bQD.setText(aVar2.alI);
            this.bQF.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.bQx.setImageDrawable(null);
        this.bQx.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.bQA != null) {
            al.d(this.bQA, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.bQz != null) {
            al.d(this.bQz, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.bQy != null) {
            al.d(this.bQy, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = al.getDrawable(i);
        int h = com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds32);
        int h2 = com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds8);
        drawable.setBounds(0, 0, h, h);
        this.bQz.setCompoundDrawablePadding(h2);
        this.bQz.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.bQA != null) {
            this.bQA.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.bQz;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }
}
