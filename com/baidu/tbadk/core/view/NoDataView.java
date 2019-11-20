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
    private TbImageView coh;
    private TextView coi;
    private TextView coj;
    private TextView cok;
    private EmotionButton col;

    /* renamed from: com  reason: collision with root package name */
    private EmotionButton f954com;
    private EmotionButton con;
    private int coo;
    private View cop;
    private NoDataViewFactory.ImgType coq;
    private int cor;
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
        this.coh = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.coh.setDefaultBgResource(0);
        this.coh.setDefaultResource(0);
        this.coh.setDefaultErrorResource(0);
        this.coi = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.coj = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.cok = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.col = (EmotionButton) this.mRootView.findViewById(R.id.btn_func);
        this.cop = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        anD();
    }

    private void anD() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.coh.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.coh.setLayoutParams(marginLayoutParams);
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
        if (this.coq == NoDataViewFactory.ImgType.WEBVIEW) {
            this.coh.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.coq == NoDataViewFactory.ImgType.NODATA) {
            this.coh.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.coq == NoDataViewFactory.ImgType.LOCAL) {
            this.coh.setImageBitmap(am.getBitmap565Quality(this.cor));
        } else if (this.coq == NoDataViewFactory.ImgType.ANTI) {
            this.coh.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.coq == NoDataViewFactory.ImgType.NETERROR) {
            this.coh.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_09));
        } else {
            this.coh.setImageBitmap(am.getBitmap565Quality(this.coo));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.cok.setText(dVar.mTitle);
                this.cok.setVisibility(0);
            } else {
                this.cok.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.bXU)) {
                this.coj.setVisibility(0);
                this.coj.setText(dVar.bXU);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.coz >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.coj.getLayoutParams();
                    layoutParams.topMargin = dVar.coz;
                    this.coj.setLayoutParams(layoutParams);
                }
                if (dVar.coA != 0) {
                    setSubTitleCompoundDrawable(dVar.coA);
                }
            } else {
                this.coj.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.coy)) {
                this.coi.setText(dVar.coy);
                this.coi.setVisibility(0);
                return;
            }
            this.coi.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.coq = cVar.cox;
            this.cor = cVar.cor;
            switch (cVar.cox) {
                case CREATE:
                    this.coo = R.drawable.new_pic_emotion_03;
                    break;
                case NODATA:
                    this.coo = R.drawable.new_pic_emotion_05;
                    break;
                case FINDBAR:
                    this.coo = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.coo = R.drawable.new_pic_emotion_02;
                    break;
                case GIFT:
                    this.coo = R.drawable.new_pic_emotion_07;
                    break;
                case SINGALL:
                    this.coo = R.drawable.new_pic_emotion_06;
                    break;
                case WEBVIEW:
                    this.coo = R.drawable.new_pic_emotion_08;
                    break;
                case ANTI:
                    this.coo = R.drawable.new_pic_emotion_05;
                    break;
                case NETERROR:
                    this.coo = R.drawable.new_pic_emotion_09;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.coh.getLayoutParams();
            if (cVar.biB >= 0) {
                layoutParams.setMargins(0, cVar.biB, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.coh.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.col.setVisibility(8);
            this.cop.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.cou;
        NoDataViewFactory.a aVar2 = bVar.cov;
        if (aVar2 == null && aVar != null) {
            this.col.setOnClickListener(aVar.cot);
            this.col.setText(aVar.mText);
            this.col.setVisibility(0);
            if (bVar.cow >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.col.getLayoutParams();
                layoutParams.topMargin = bVar.cow;
                this.col.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.f954com = (EmotionButton) this.cop.findViewById(R.id.btn_left);
            this.con = (EmotionButton) this.cop.findViewById(R.id.btn_right);
            this.f954com.setOnClickListener(aVar.cot);
            this.f954com.setText(aVar.mText);
            this.con.setOnClickListener(aVar2.cot);
            this.con.setText(aVar2.mText);
            this.cop.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void anE() {
        this.coh.setImageDrawable(null);
        this.coh.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.cok != null) {
            am.setViewTextColor(this.cok, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.coj != null) {
            am.setViewTextColor(this.coj, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.coi != null) {
            am.setViewTextColor(this.coi, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = am.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.coj.setCompoundDrawablePadding(dimens2);
        this.coj.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.cok != null) {
            this.cok.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.coj;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }
}
