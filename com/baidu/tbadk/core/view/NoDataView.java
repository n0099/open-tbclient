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
    private TbImageView coY;
    private TextView coZ;
    private TextView cpa;
    private TextView cpb;
    private EmotionButton cpc;
    private EmotionButton cpd;
    private EmotionButton cpe;
    private int cpf;
    private View cpg;
    private NoDataViewFactory.ImgType cph;
    private int cpi;
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
        this.coY = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.coY.setDefaultBgResource(0);
        this.coY.setDefaultResource(0);
        this.coY.setDefaultErrorResource(0);
        this.coZ = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.cpa = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.cpb = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.cpc = (EmotionButton) this.mRootView.findViewById(R.id.btn_func);
        this.cpg = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        anF();
    }

    private void anF() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.coY.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.coY.setLayoutParams(marginLayoutParams);
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
        if (this.cph == NoDataViewFactory.ImgType.WEBVIEW) {
            this.coY.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.cph == NoDataViewFactory.ImgType.NODATA) {
            this.coY.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.cph == NoDataViewFactory.ImgType.LOCAL) {
            this.coY.setImageBitmap(am.getBitmap565Quality(this.cpi));
        } else if (this.cph == NoDataViewFactory.ImgType.ANTI) {
            this.coY.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.cph == NoDataViewFactory.ImgType.NETERROR) {
            this.coY.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_09));
        } else {
            this.coY.setImageBitmap(am.getBitmap565Quality(this.cpf));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.cpb.setText(dVar.mTitle);
                this.cpb.setVisibility(0);
            } else {
                this.cpb.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.bYL)) {
                this.cpa.setVisibility(0);
                this.cpa.setText(dVar.bYL);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.cpq >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cpa.getLayoutParams();
                    layoutParams.topMargin = dVar.cpq;
                    this.cpa.setLayoutParams(layoutParams);
                }
                if (dVar.cpr != 0) {
                    setSubTitleCompoundDrawable(dVar.cpr);
                }
            } else {
                this.cpa.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.cpp)) {
                this.coZ.setText(dVar.cpp);
                this.coZ.setVisibility(0);
                return;
            }
            this.coZ.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.cph = cVar.cpo;
            this.cpi = cVar.cpi;
            switch (cVar.cpo) {
                case CREATE:
                    this.cpf = R.drawable.new_pic_emotion_03;
                    break;
                case NODATA:
                    this.cpf = R.drawable.new_pic_emotion_05;
                    break;
                case FINDBAR:
                    this.cpf = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.cpf = R.drawable.new_pic_emotion_02;
                    break;
                case GIFT:
                    this.cpf = R.drawable.new_pic_emotion_07;
                    break;
                case SINGALL:
                    this.cpf = R.drawable.new_pic_emotion_06;
                    break;
                case WEBVIEW:
                    this.cpf = R.drawable.new_pic_emotion_08;
                    break;
                case ANTI:
                    this.cpf = R.drawable.new_pic_emotion_05;
                    break;
                case NETERROR:
                    this.cpf = R.drawable.new_pic_emotion_09;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.coY.getLayoutParams();
            if (cVar.biT >= 0) {
                layoutParams.setMargins(0, cVar.biT, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.coY.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.cpc.setVisibility(8);
            this.cpg.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.cpl;
        NoDataViewFactory.a aVar2 = bVar.cpm;
        if (aVar2 == null && aVar != null) {
            this.cpc.setOnClickListener(aVar.cpk);
            this.cpc.setText(aVar.mText);
            this.cpc.setVisibility(0);
            if (bVar.cpn >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cpc.getLayoutParams();
                layoutParams.topMargin = bVar.cpn;
                this.cpc.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.cpd = (EmotionButton) this.cpg.findViewById(R.id.btn_left);
            this.cpe = (EmotionButton) this.cpg.findViewById(R.id.btn_right);
            this.cpd.setOnClickListener(aVar.cpk);
            this.cpd.setText(aVar.mText);
            this.cpe.setOnClickListener(aVar2.cpk);
            this.cpe.setText(aVar2.mText);
            this.cpg.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void anG() {
        this.coY.setImageDrawable(null);
        this.coY.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.cpb != null) {
            am.setViewTextColor(this.cpb, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.cpa != null) {
            am.setViewTextColor(this.cpa, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.coZ != null) {
            am.setViewTextColor(this.coZ, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = am.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.cpa.setCompoundDrawablePadding(dimens2);
        this.cpa.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.cpb != null) {
            this.cpb.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.cpa;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }
}
