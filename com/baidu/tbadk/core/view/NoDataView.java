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
import com.baidu.tieba.R;
import com.baidu.tieba.view.EmotionButton;
/* loaded from: classes.dex */
public class NoDataView extends LinearLayout {
    private View bYA;
    private NoDataViewFactory.ImgType bYB;
    private int bYC;
    private TbImageView bYs;
    private TextView bYt;
    private TextView bYu;
    private TextView bYv;
    private EmotionButton bYw;
    private EmotionButton bYx;
    private EmotionButton bYy;
    private int bYz;
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
        this.bYs = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.bYs.setDefaultBgResource(0);
        this.bYs.setDefaultResource(0);
        this.bYs.setDefaultErrorResource(0);
        this.bYt = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.bYu = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.bYv = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.bYw = (EmotionButton) this.mRootView.findViewById(R.id.btn_func);
        this.bYA = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        ajp();
    }

    private void ajp() {
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
        if (ah > 0) {
            int i = (int) (ah * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.bYs.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bYs.setLayoutParams(marginLayoutParams);
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
        if (this.bYB == NoDataViewFactory.ImgType.WEBVIEW) {
            this.bYs.setImageBitmap(al.m19if(R.drawable.new_pic_emotion_08));
        } else if (this.bYB == NoDataViewFactory.ImgType.NODATA) {
            this.bYs.setImageBitmap(al.m19if(R.drawable.new_pic_emotion_05));
        } else if (this.bYB == NoDataViewFactory.ImgType.LOCAL) {
            this.bYs.setImageBitmap(al.m19if(this.bYC));
        } else if (this.bYB == NoDataViewFactory.ImgType.ANTI) {
            this.bYs.setImageBitmap(al.m19if(R.drawable.new_pic_emotion_05));
        } else if (this.bYB == NoDataViewFactory.ImgType.NETERROR) {
            this.bYs.setImageBitmap(al.m19if(R.drawable.new_pic_emotion_09));
        } else {
            this.bYs.setImageBitmap(al.m19if(this.bYz));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.bYv.setText(dVar.mTitle);
                this.bYv.setVisibility(0);
            } else {
                this.bYv.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.bFz)) {
                this.bYu.setVisibility(0);
                this.bYu.setText(dVar.bFz);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.bYK >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bYu.getLayoutParams();
                    layoutParams.topMargin = dVar.bYK;
                    this.bYu.setLayoutParams(layoutParams);
                }
                if (dVar.bYL != 0) {
                    setSubTitleCompoundDrawable(dVar.bYL);
                }
            } else {
                this.bYu.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.bYJ)) {
                this.bYt.setText(dVar.bYJ);
                this.bYt.setVisibility(0);
                return;
            }
            this.bYt.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.bYB = cVar.bYI;
            this.bYC = cVar.bYC;
            switch (cVar.bYI) {
                case CREATE:
                    this.bYz = R.drawable.new_pic_emotion_03;
                    break;
                case NODATA:
                    this.bYz = R.drawable.new_pic_emotion_05;
                    break;
                case FINDBAR:
                    this.bYz = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.bYz = R.drawable.new_pic_emotion_02;
                    break;
                case GIFT:
                    this.bYz = R.drawable.new_pic_emotion_07;
                    break;
                case SINGALL:
                    this.bYz = R.drawable.new_pic_emotion_06;
                    break;
                case WEBVIEW:
                    this.bYz = R.drawable.new_pic_emotion_08;
                    break;
                case ANTI:
                    this.bYz = R.drawable.new_pic_emotion_05;
                    break;
                case NETERROR:
                    this.bYz = R.drawable.new_pic_emotion_09;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bYs.getLayoutParams();
            if (cVar.aOC >= 0) {
                layoutParams.setMargins(0, cVar.aOC, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.bYs.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.bYw.setVisibility(8);
            this.bYA.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.bYF;
        NoDataViewFactory.a aVar2 = bVar.bYG;
        if (aVar2 == null && aVar != null) {
            this.bYw.setOnClickListener(aVar.bYE);
            this.bYw.setText(aVar.ama);
            this.bYw.setVisibility(0);
            if (bVar.bYH >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bYw.getLayoutParams();
                layoutParams.topMargin = bVar.bYH;
                this.bYw.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.bYx = (EmotionButton) this.bYA.findViewById(R.id.btn_left);
            this.bYy = (EmotionButton) this.bYA.findViewById(R.id.btn_right);
            this.bYx.setOnClickListener(aVar.bYE);
            this.bYx.setText(aVar.ama);
            this.bYy.setOnClickListener(aVar2.bYE);
            this.bYy.setText(aVar2.ama);
            this.bYA.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.bYs.setImageDrawable(null);
        this.bYs.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.bYv != null) {
            al.f(this.bYv, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.bYu != null) {
            al.f(this.bYu, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.bYt != null) {
            al.f(this.bYt, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = al.getDrawable(i);
        int g = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds32);
        int g2 = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, g, g);
        this.bYu.setCompoundDrawablePadding(g2);
        this.bYu.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.bYv != null) {
            this.bYv.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.bYu;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }
}
