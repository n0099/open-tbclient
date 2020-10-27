package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DimenRes;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NoDataView extends LinearLayout {
    private TbImageView eOf;
    private LinearLayout eOg;
    private TextView eOh;
    private TextView eOi;
    private TextView eOj;
    private TBSpecificationBtn eOk;
    private TBSpecificationBtn eOl;
    private TBSpecificationBtn eOm;
    private int eOn;
    private View eOo;
    private NoDataViewFactory.ImgType eOp;
    private int eOq;
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
        this.eOf = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.eOf.setDefaultBgResource(0);
        this.eOf.setDefaultResource(0);
        this.eOf.setDefaultErrorResource(0);
        this.eOg = (LinearLayout) this.mRootView.findViewById(R.id.title_container);
        this.eOh = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.eOi = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.eOj = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.eOk = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_func);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.eOk.setTextSize(R.dimen.tbds42);
        this.eOk.setConfig(aVar);
        this.eOo = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        bpN();
    }

    private void bpN() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.eOf.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.eOf.setLayoutParams(marginLayoutParams);
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
        if (this.eOk != null) {
            this.eOk.bqd();
        }
        if (this.eOl != null) {
            this.eOl.bqd();
        }
        if (this.eOm != null) {
            this.eOm.bqd();
        }
        if (this.eOp == NoDataViewFactory.ImgType.WEBVIEW) {
            this.eOf.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.eOp == NoDataViewFactory.ImgType.NODATA) {
            this.eOf.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.eOp == NoDataViewFactory.ImgType.LOCAL) {
            this.eOf.setImageBitmap(ap.getBitmap565Quality(this.eOq));
        } else if (this.eOp == NoDataViewFactory.ImgType.ANTI) {
            this.eOf.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.eOp == NoDataViewFactory.ImgType.NETERROR) {
            this.eOf.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else {
            this.eOf.setImageBitmap(ap.getBitmap565Quality(this.eOn));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.eOj.setText(dVar.mTitle);
                this.eOj.setVisibility(0);
            } else {
                this.eOj.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.eOi.setVisibility(0);
                this.eOi.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.eOy >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eOi.getLayoutParams();
                    layoutParams.topMargin = dVar.eOy;
                    this.eOi.setLayoutParams(layoutParams);
                }
                if (dVar.mDrawableId != 0) {
                    setSubTitleCompoundDrawable(dVar.mDrawableId);
                }
            } else {
                this.eOi.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.eOx)) {
                this.eOh.setText(dVar.eOx);
                this.eOh.setVisibility(0);
                return;
            }
            this.eOh.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.eOp = cVar.eOw;
            this.eOq = cVar.eOq;
            switch (cVar.eOw) {
                case FINDBAR:
                    this.eOn = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.eOn = R.drawable.new_pic_emotion_02;
                    break;
                case CREATE:
                    this.eOn = R.drawable.new_pic_emotion_03;
                    break;
                case COLLECTION:
                    this.eOn = R.drawable.new_pic_emotion_04;
                    break;
                case NODATA:
                    this.eOn = R.drawable.new_pic_emotion_05;
                    break;
                case ANTI:
                    this.eOn = R.drawable.new_pic_emotion_05;
                    break;
                case SINGALL:
                    this.eOn = R.drawable.new_pic_emotion_06;
                    break;
                case GIFT:
                    this.eOn = R.drawable.new_pic_emotion_07;
                    break;
                case WEBVIEW:
                    this.eOn = R.drawable.new_pic_emotion_08;
                    break;
                case NETERROR:
                    this.eOn = R.drawable.new_pic_emotion_08;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eOf.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.eOf.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.eOk.setVisibility(8);
            this.eOo.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.eOt;
        NoDataViewFactory.a aVar2 = bVar.eOu;
        if (aVar2 == null && aVar != null) {
            this.eOk.setOnClickListener(aVar.eOs);
            this.eOk.setText(aVar.mText);
            this.eOk.setVisibility(0);
            if (bVar.eOv >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eOk.getLayoutParams();
                layoutParams.topMargin = bVar.eOv;
                this.eOk.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.eOl = (TBSpecificationBtn) this.eOo.findViewById(R.id.btn_left);
            this.eOm = (TBSpecificationBtn) this.eOo.findViewById(R.id.btn_right);
            com.baidu.tbadk.core.view.commonBtn.a aVar3 = new com.baidu.tbadk.core.view.commonBtn.a();
            this.eOl.setTextSize(R.dimen.ds32);
            this.eOl.setConfig(aVar3);
            this.eOm.setTextSize(R.dimen.ds32);
            this.eOm.setConfig(aVar3);
            this.eOl.setOnClickListener(aVar.eOs);
            this.eOl.setText(aVar.mText);
            this.eOm.setOnClickListener(aVar2.eOs);
            this.eOm.setText(aVar2.mText);
            this.eOo.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void bpO() {
        this.eOf.setImageDrawable(null);
        this.eOf.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.eOj != null) {
            ap.setViewTextColor(this.eOj, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.eOi != null) {
            ap.setViewTextColor(this.eOi, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.eOh != null) {
            ap.setViewTextColor(this.eOh, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = ap.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.eOi.setCompoundDrawablePadding(dimens2);
        this.eOi.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.eOi != null) {
            this.eOi.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.eOi;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTitleContainerMargin(@DimenRes int i, @DimenRes int i2) {
        if (this.eOg != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eOg.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i2);
        }
    }
}
