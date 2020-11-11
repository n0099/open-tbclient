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
    private TbImageView eTU;
    private LinearLayout eTV;
    private TextView eTW;
    private TextView eTX;
    private TextView eTY;
    private TBSpecificationBtn eTZ;
    private TBSpecificationBtn eUa;
    private TBSpecificationBtn eUb;
    private int eUc;
    private View eUd;
    private NoDataViewFactory.ImgType eUe;
    private int eUf;
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
        this.eTU = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.eTU.setDefaultBgResource(0);
        this.eTU.setDefaultResource(0);
        this.eTU.setDefaultErrorResource(0);
        this.eTV = (LinearLayout) this.mRootView.findViewById(R.id.title_container);
        this.eTW = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.eTX = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.eTY = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.eTZ = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_func);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.eTZ.setTextSize(R.dimen.tbds42);
        this.eTZ.setConfig(aVar);
        this.eUd = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        bsn();
    }

    private void bsn() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.eTU.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.eTU.setLayoutParams(marginLayoutParams);
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
        if (this.eTZ != null) {
            this.eTZ.bsD();
        }
        if (this.eUa != null) {
            this.eUa.bsD();
        }
        if (this.eUb != null) {
            this.eUb.bsD();
        }
        if (this.eUe == NoDataViewFactory.ImgType.WEBVIEW) {
            this.eTU.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.eUe == NoDataViewFactory.ImgType.NODATA) {
            this.eTU.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.eUe == NoDataViewFactory.ImgType.LOCAL) {
            this.eTU.setImageBitmap(ap.getBitmap565Quality(this.eUf));
        } else if (this.eUe == NoDataViewFactory.ImgType.ANTI) {
            this.eTU.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.eUe == NoDataViewFactory.ImgType.NETERROR) {
            this.eTU.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else {
            this.eTU.setImageBitmap(ap.getBitmap565Quality(this.eUc));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.eTY.setText(dVar.mTitle);
                this.eTY.setVisibility(0);
            } else {
                this.eTY.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.eTX.setVisibility(0);
                this.eTX.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.eUn >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eTX.getLayoutParams();
                    layoutParams.topMargin = dVar.eUn;
                    this.eTX.setLayoutParams(layoutParams);
                }
                if (dVar.mDrawableId != 0) {
                    setSubTitleCompoundDrawable(dVar.mDrawableId);
                }
            } else {
                this.eTX.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.eUm)) {
                this.eTW.setText(dVar.eUm);
                this.eTW.setVisibility(0);
                return;
            }
            this.eTW.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.eUe = cVar.eUl;
            this.eUf = cVar.eUf;
            switch (cVar.eUl) {
                case FINDBAR:
                    this.eUc = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.eUc = R.drawable.new_pic_emotion_02;
                    break;
                case CREATE:
                    this.eUc = R.drawable.new_pic_emotion_03;
                    break;
                case COLLECTION:
                    this.eUc = R.drawable.new_pic_emotion_04;
                    break;
                case NODATA:
                    this.eUc = R.drawable.new_pic_emotion_05;
                    break;
                case ANTI:
                    this.eUc = R.drawable.new_pic_emotion_05;
                    break;
                case SINGALL:
                    this.eUc = R.drawable.new_pic_emotion_06;
                    break;
                case GIFT:
                    this.eUc = R.drawable.new_pic_emotion_07;
                    break;
                case WEBVIEW:
                    this.eUc = R.drawable.new_pic_emotion_08;
                    break;
                case NETERROR:
                    this.eUc = R.drawable.new_pic_emotion_08;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eTU.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.eTU.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.eTZ.setVisibility(8);
            this.eUd.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.eUi;
        NoDataViewFactory.a aVar2 = bVar.eUj;
        if (aVar2 == null && aVar != null) {
            this.eTZ.setOnClickListener(aVar.eUh);
            this.eTZ.setText(aVar.mText);
            this.eTZ.setVisibility(0);
            if (bVar.eUk >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eTZ.getLayoutParams();
                layoutParams.topMargin = bVar.eUk;
                this.eTZ.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.eUa = (TBSpecificationBtn) this.eUd.findViewById(R.id.btn_left);
            this.eUb = (TBSpecificationBtn) this.eUd.findViewById(R.id.btn_right);
            com.baidu.tbadk.core.view.commonBtn.a aVar3 = new com.baidu.tbadk.core.view.commonBtn.a();
            this.eUa.setTextSize(R.dimen.ds32);
            this.eUa.setConfig(aVar3);
            this.eUb.setTextSize(R.dimen.ds32);
            this.eUb.setConfig(aVar3);
            this.eUa.setOnClickListener(aVar.eUh);
            this.eUa.setText(aVar.mText);
            this.eUb.setOnClickListener(aVar2.eUh);
            this.eUb.setText(aVar2.mText);
            this.eUd.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void bso() {
        this.eTU.setImageDrawable(null);
        this.eTU.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.eTY != null) {
            ap.setViewTextColor(this.eTY, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.eTX != null) {
            ap.setViewTextColor(this.eTX, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.eTW != null) {
            ap.setViewTextColor(this.eTW, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = ap.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.eTX.setCompoundDrawablePadding(dimens2);
        this.eTX.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.eTX != null) {
            this.eTX.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.eTX;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTitleContainerMargin(@DimenRes int i, @DimenRes int i2) {
        if (this.eTV != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eTV.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i2);
        }
    }
}
