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
    private TextView bQB;
    private EmotionButton bQC;
    private EmotionButton bQD;
    private EmotionButton bQE;
    private int bQF;
    private View bQG;
    private NoDataViewFactory.ImgType bQH;
    private int bQI;
    private TbImageView bQy;
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
        this.bQy = (TbImageView) this.mRootView.findViewById(d.g.iv_no_data_img);
        this.bQy.setDefaultBgResource(0);
        this.bQy.setDefaultResource(0);
        this.bQy.setDefaultErrorResource(0);
        this.bQz = (TextView) this.mRootView.findViewById(d.g.tv_text_reamrk);
        this.bQA = (TextView) this.mRootView.findViewById(d.g.tv_subtitle);
        this.bQB = (TextView) this.mRootView.findViewById(d.g.tv_title);
        this.bQC = (EmotionButton) this.mRootView.findViewById(d.g.btn_func);
        this.bQG = (LinearLayout) this.mRootView.findViewById(d.g.two_button_layout);
        aet();
    }

    private void aet() {
        int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst());
        if (aQ > 0) {
            int i = (int) (aQ * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.bQy.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bQy.setLayoutParams(marginLayoutParams);
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
        if (this.bQH == NoDataViewFactory.ImgType.WEBVIEW) {
            this.bQy.setImageBitmap(al.hs(d.f.new_pic_emotion_08));
        } else if (this.bQH == NoDataViewFactory.ImgType.NODATA) {
            this.bQy.setImageBitmap(al.hs(d.f.new_pic_emotion_05));
        } else if (this.bQH == NoDataViewFactory.ImgType.LOCAL) {
            this.bQy.setImageBitmap(al.hs(this.bQI));
        } else if (this.bQH == NoDataViewFactory.ImgType.ANTI) {
            this.bQy.setImageBitmap(al.hs(d.f.new_pic_emotion_05));
        } else if (this.bQH == NoDataViewFactory.ImgType.NETERROR) {
            this.bQy.setImageBitmap(al.hs(d.f.new_pic_emotion_09));
        } else {
            this.bQy.setImageBitmap(al.hs(this.bQF));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.bQB.setText(dVar.mTitle);
                this.bQB.setVisibility(0);
            } else {
                this.bQB.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.byk)) {
                this.bQA.setVisibility(0);
                this.bQA.setText(dVar.byk);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.bQQ >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bQA.getLayoutParams();
                    layoutParams.topMargin = dVar.bQQ;
                    this.bQA.setLayoutParams(layoutParams);
                }
                if (dVar.bQR != 0) {
                    setSubTitleCompoundDrawable(dVar.bQR);
                }
            } else {
                this.bQA.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.bQP)) {
                this.bQz.setText(dVar.bQP);
                this.bQz.setVisibility(0);
                return;
            }
            this.bQz.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.bQH = cVar.bQO;
            this.bQI = cVar.bQI;
            switch (cVar.bQO) {
                case CREATE:
                    this.bQF = d.f.new_pic_emotion_03;
                    break;
                case NODATA:
                    this.bQF = d.f.new_pic_emotion_05;
                    break;
                case FINDBAR:
                    this.bQF = d.f.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.bQF = d.f.new_pic_emotion_02;
                    break;
                case GIFT:
                    this.bQF = d.f.new_pic_emotion_07;
                    break;
                case SINGALL:
                    this.bQF = d.f.new_pic_emotion_06;
                    break;
                case WEBVIEW:
                    this.bQF = d.f.new_pic_emotion_08;
                    break;
                case ANTI:
                    this.bQF = d.f.new_pic_emotion_05;
                    break;
                case NETERROR:
                    this.bQF = d.f.new_pic_emotion_09;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bQy.getLayoutParams();
            if (cVar.aMB >= 0) {
                layoutParams.setMargins(0, cVar.aMB, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.bQy.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.bQC.setVisibility(8);
            this.bQG.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.bQL;
        NoDataViewFactory.a aVar2 = bVar.bQM;
        if (aVar2 == null && aVar != null) {
            this.bQC.setOnClickListener(aVar.bQK);
            this.bQC.setText(aVar.alJ);
            this.bQC.setVisibility(0);
            if (bVar.bQN >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bQC.getLayoutParams();
                layoutParams.topMargin = bVar.bQN;
                this.bQC.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.bQD = (EmotionButton) this.bQG.findViewById(d.g.btn_left);
            this.bQE = (EmotionButton) this.bQG.findViewById(d.g.btn_right);
            this.bQD.setOnClickListener(aVar.bQK);
            this.bQD.setText(aVar.alJ);
            this.bQE.setOnClickListener(aVar2.bQK);
            this.bQE.setText(aVar2.alJ);
            this.bQG.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.bQy.setImageDrawable(null);
        this.bQy.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.bQB != null) {
            al.d(this.bQB, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.bQA != null) {
            al.d(this.bQA, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.bQz != null) {
            al.d(this.bQz, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = al.getDrawable(i);
        int h = com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds32);
        int h2 = com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds8);
        drawable.setBounds(0, 0, h, h);
        this.bQA.setCompoundDrawablePadding(h2);
        this.bQA.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.bQB != null) {
            this.bQB.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.bQA;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }
}
