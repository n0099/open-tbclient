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
    private int bYA;
    private View bYB;
    private NoDataViewFactory.ImgType bYC;
    private int bYD;
    private TbImageView bYt;
    private TextView bYu;
    private TextView bYv;
    private TextView bYw;
    private EmotionButton bYx;
    private EmotionButton bYy;
    private EmotionButton bYz;
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
        this.bYt = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.bYt.setDefaultBgResource(0);
        this.bYt.setDefaultResource(0);
        this.bYt.setDefaultErrorResource(0);
        this.bYu = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.bYv = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.bYw = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.bYx = (EmotionButton) this.mRootView.findViewById(R.id.btn_func);
        this.bYB = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        ajp();
    }

    private void ajp() {
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
        if (ah > 0) {
            int i = (int) (ah * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.bYt.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bYt.setLayoutParams(marginLayoutParams);
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
        if (this.bYC == NoDataViewFactory.ImgType.WEBVIEW) {
            this.bYt.setImageBitmap(al.m19if(R.drawable.new_pic_emotion_08));
        } else if (this.bYC == NoDataViewFactory.ImgType.NODATA) {
            this.bYt.setImageBitmap(al.m19if(R.drawable.new_pic_emotion_05));
        } else if (this.bYC == NoDataViewFactory.ImgType.LOCAL) {
            this.bYt.setImageBitmap(al.m19if(this.bYD));
        } else if (this.bYC == NoDataViewFactory.ImgType.ANTI) {
            this.bYt.setImageBitmap(al.m19if(R.drawable.new_pic_emotion_05));
        } else if (this.bYC == NoDataViewFactory.ImgType.NETERROR) {
            this.bYt.setImageBitmap(al.m19if(R.drawable.new_pic_emotion_09));
        } else {
            this.bYt.setImageBitmap(al.m19if(this.bYA));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.bYw.setText(dVar.mTitle);
                this.bYw.setVisibility(0);
            } else {
                this.bYw.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.bFA)) {
                this.bYv.setVisibility(0);
                this.bYv.setText(dVar.bFA);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.bYL >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bYv.getLayoutParams();
                    layoutParams.topMargin = dVar.bYL;
                    this.bYv.setLayoutParams(layoutParams);
                }
                if (dVar.bYM != 0) {
                    setSubTitleCompoundDrawable(dVar.bYM);
                }
            } else {
                this.bYv.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.bYK)) {
                this.bYu.setText(dVar.bYK);
                this.bYu.setVisibility(0);
                return;
            }
            this.bYu.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.bYC = cVar.bYJ;
            this.bYD = cVar.bYD;
            switch (cVar.bYJ) {
                case CREATE:
                    this.bYA = R.drawable.new_pic_emotion_03;
                    break;
                case NODATA:
                    this.bYA = R.drawable.new_pic_emotion_05;
                    break;
                case FINDBAR:
                    this.bYA = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.bYA = R.drawable.new_pic_emotion_02;
                    break;
                case GIFT:
                    this.bYA = R.drawable.new_pic_emotion_07;
                    break;
                case SINGALL:
                    this.bYA = R.drawable.new_pic_emotion_06;
                    break;
                case WEBVIEW:
                    this.bYA = R.drawable.new_pic_emotion_08;
                    break;
                case ANTI:
                    this.bYA = R.drawable.new_pic_emotion_05;
                    break;
                case NETERROR:
                    this.bYA = R.drawable.new_pic_emotion_09;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bYt.getLayoutParams();
            if (cVar.aOC >= 0) {
                layoutParams.setMargins(0, cVar.aOC, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.bYt.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.bYx.setVisibility(8);
            this.bYB.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.bYG;
        NoDataViewFactory.a aVar2 = bVar.bYH;
        if (aVar2 == null && aVar != null) {
            this.bYx.setOnClickListener(aVar.bYF);
            this.bYx.setText(aVar.ama);
            this.bYx.setVisibility(0);
            if (bVar.bYI >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bYx.getLayoutParams();
                layoutParams.topMargin = bVar.bYI;
                this.bYx.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.bYy = (EmotionButton) this.bYB.findViewById(R.id.btn_left);
            this.bYz = (EmotionButton) this.bYB.findViewById(R.id.btn_right);
            this.bYy.setOnClickListener(aVar.bYF);
            this.bYy.setText(aVar.ama);
            this.bYz.setOnClickListener(aVar2.bYF);
            this.bYz.setText(aVar2.ama);
            this.bYB.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.bYt.setImageDrawable(null);
        this.bYt.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.bYw != null) {
            al.f(this.bYw, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.bYv != null) {
            al.f(this.bYv, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.bYu != null) {
            al.f(this.bYu, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = al.getDrawable(i);
        int g = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds32);
        int g2 = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, g, g);
        this.bYv.setCompoundDrawablePadding(g2);
        this.bYv.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.bYw != null) {
            this.bYw.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.bYv;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }
}
