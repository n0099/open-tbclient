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
    private EmotionButton caA;
    private int caB;
    private View caC;
    private NoDataViewFactory.ImgType caD;
    private int caE;
    private TbImageView cau;
    private TextView cav;
    private TextView caw;
    private TextView cax;
    private EmotionButton cay;
    private EmotionButton caz;
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
        this.cau = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.cau.setDefaultBgResource(0);
        this.cau.setDefaultResource(0);
        this.cau.setDefaultErrorResource(0);
        this.cav = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.caw = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.cax = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.cay = (EmotionButton) this.mRootView.findViewById(R.id.btn_func);
        this.caC = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        akH();
    }

    private void akH() {
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
        if (ah > 0) {
            int i = (int) (ah * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.cau.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.cau.setLayoutParams(marginLayoutParams);
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
        if (this.caD == NoDataViewFactory.ImgType.WEBVIEW) {
            this.cau.setImageBitmap(am.il(R.drawable.new_pic_emotion_08));
        } else if (this.caD == NoDataViewFactory.ImgType.NODATA) {
            this.cau.setImageBitmap(am.il(R.drawable.new_pic_emotion_05));
        } else if (this.caD == NoDataViewFactory.ImgType.LOCAL) {
            this.cau.setImageBitmap(am.il(this.caE));
        } else if (this.caD == NoDataViewFactory.ImgType.ANTI) {
            this.cau.setImageBitmap(am.il(R.drawable.new_pic_emotion_05));
        } else if (this.caD == NoDataViewFactory.ImgType.NETERROR) {
            this.cau.setImageBitmap(am.il(R.drawable.new_pic_emotion_09));
        } else {
            this.cau.setImageBitmap(am.il(this.caB));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.cax.setText(dVar.mTitle);
                this.cax.setVisibility(0);
            } else {
                this.cax.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.bHa)) {
                this.caw.setVisibility(0);
                this.caw.setText(dVar.bHa);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.caM >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caw.getLayoutParams();
                    layoutParams.topMargin = dVar.caM;
                    this.caw.setLayoutParams(layoutParams);
                }
                if (dVar.caN != 0) {
                    setSubTitleCompoundDrawable(dVar.caN);
                }
            } else {
                this.caw.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.caL)) {
                this.cav.setText(dVar.caL);
                this.cav.setVisibility(0);
                return;
            }
            this.cav.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.caD = cVar.caK;
            this.caE = cVar.caE;
            switch (cVar.caK) {
                case CREATE:
                    this.caB = R.drawable.new_pic_emotion_03;
                    break;
                case NODATA:
                    this.caB = R.drawable.new_pic_emotion_05;
                    break;
                case FINDBAR:
                    this.caB = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.caB = R.drawable.new_pic_emotion_02;
                    break;
                case GIFT:
                    this.caB = R.drawable.new_pic_emotion_07;
                    break;
                case SINGALL:
                    this.caB = R.drawable.new_pic_emotion_06;
                    break;
                case WEBVIEW:
                    this.caB = R.drawable.new_pic_emotion_08;
                    break;
                case ANTI:
                    this.caB = R.drawable.new_pic_emotion_05;
                    break;
                case NETERROR:
                    this.caB = R.drawable.new_pic_emotion_09;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cau.getLayoutParams();
            if (cVar.aPK >= 0) {
                layoutParams.setMargins(0, cVar.aPK, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.cau.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.cay.setVisibility(8);
            this.caC.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.caH;
        NoDataViewFactory.a aVar2 = bVar.caI;
        if (aVar2 == null && aVar != null) {
            this.cay.setOnClickListener(aVar.caG);
            this.cay.setText(aVar.anb);
            this.cay.setVisibility(0);
            if (bVar.caJ >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cay.getLayoutParams();
                layoutParams.topMargin = bVar.caJ;
                this.cay.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.caz = (EmotionButton) this.caC.findViewById(R.id.btn_left);
            this.caA = (EmotionButton) this.caC.findViewById(R.id.btn_right);
            this.caz.setOnClickListener(aVar.caG);
            this.caz.setText(aVar.anb);
            this.caA.setOnClickListener(aVar2.caG);
            this.caA.setText(aVar2.anb);
            this.caC.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void akI() {
        this.cau.setImageDrawable(null);
        this.cau.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.cax != null) {
            am.f(this.cax, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.caw != null) {
            am.f(this.caw, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.cav != null) {
            am.f(this.cav, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = am.getDrawable(i);
        int g = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds32);
        int g2 = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, g, g);
        this.caw.setCompoundDrawablePadding(g2);
        this.caw.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.cax != null) {
            this.cax.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.caw;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }
}
