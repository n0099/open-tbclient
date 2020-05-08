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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NoDataView extends LinearLayout {
    private TbImageView dFM;
    private LinearLayout dFN;
    private TextView dFO;
    private TextView dFP;
    private TextView dFQ;
    private TBSpecificationBtn dFR;
    private TBSpecificationBtn dFS;
    private TBSpecificationBtn dFT;
    private int dFU;
    private View dFV;
    private NoDataViewFactory.ImgType dFW;
    private int dFX;
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
        this.dFM = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.dFM.setDefaultBgResource(0);
        this.dFM.setDefaultResource(0);
        this.dFM.setDefaultErrorResource(0);
        this.dFN = (LinearLayout) this.mRootView.findViewById(R.id.title_container);
        this.dFO = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.dFP = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.dFQ = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.dFR = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_func);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.dFR.setTextSize(R.dimen.tbds42);
        this.dFR.setConfig(bVar);
        this.dFV = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        aPU();
    }

    private void aPU() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.dFM.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.dFM.setLayoutParams(marginLayoutParams);
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
        if (this.dFR != null) {
            this.dFR.aQm();
        }
        if (this.dFS != null) {
            this.dFS.aQm();
        }
        if (this.dFT != null) {
            this.dFT.aQm();
        }
        if (this.dFW == NoDataViewFactory.ImgType.WEBVIEW) {
            this.dFM.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.dFW == NoDataViewFactory.ImgType.NODATA) {
            this.dFM.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.dFW == NoDataViewFactory.ImgType.LOCAL) {
            this.dFM.setImageBitmap(am.getBitmap565Quality(this.dFX));
        } else if (this.dFW == NoDataViewFactory.ImgType.ANTI) {
            this.dFM.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.dFW == NoDataViewFactory.ImgType.NETERROR) {
            this.dFM.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else {
            this.dFM.setImageBitmap(am.getBitmap565Quality(this.dFU));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.dFQ.setText(dVar.mTitle);
                this.dFQ.setVisibility(0);
            } else {
                this.dFQ.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.dFP.setVisibility(0);
                this.dFP.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.dGf >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dFP.getLayoutParams();
                    layoutParams.topMargin = dVar.dGf;
                    this.dFP.setLayoutParams(layoutParams);
                }
                if (dVar.mDrawableId != 0) {
                    setSubTitleCompoundDrawable(dVar.mDrawableId);
                }
            } else {
                this.dFP.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.dGe)) {
                this.dFO.setText(dVar.dGe);
                this.dFO.setVisibility(0);
                return;
            }
            this.dFO.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.dFW = cVar.dGd;
            this.dFX = cVar.dFX;
            switch (cVar.dGd) {
                case FINDBAR:
                    this.dFU = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.dFU = R.drawable.new_pic_emotion_02;
                    break;
                case CREATE:
                    this.dFU = R.drawable.new_pic_emotion_03;
                    break;
                case COLLECTION:
                    this.dFU = R.drawable.new_pic_emotion_04;
                    break;
                case NODATA:
                    this.dFU = R.drawable.new_pic_emotion_05;
                    break;
                case ANTI:
                    this.dFU = R.drawable.new_pic_emotion_05;
                    break;
                case SINGALL:
                    this.dFU = R.drawable.new_pic_emotion_06;
                    break;
                case GIFT:
                    this.dFU = R.drawable.new_pic_emotion_07;
                    break;
                case WEBVIEW:
                    this.dFU = R.drawable.new_pic_emotion_08;
                    break;
                case NETERROR:
                    this.dFU = R.drawable.new_pic_emotion_08;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dFM.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.dFM.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.dFR.setVisibility(8);
            this.dFV.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.dGa;
        NoDataViewFactory.a aVar2 = bVar.dGb;
        if (aVar2 == null && aVar != null) {
            this.dFR.setOnClickListener(aVar.dFZ);
            this.dFR.setText(aVar.mText);
            this.dFR.setVisibility(0);
            if (bVar.dGc >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dFR.getLayoutParams();
                layoutParams.topMargin = bVar.dGc;
                this.dFR.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.dFS = (TBSpecificationBtn) this.dFV.findViewById(R.id.btn_left);
            this.dFT = (TBSpecificationBtn) this.dFV.findViewById(R.id.btn_right);
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            this.dFS.setTextSize(R.dimen.ds32);
            this.dFS.setConfig(bVar2);
            this.dFT.setTextSize(R.dimen.ds32);
            this.dFT.setConfig(bVar2);
            this.dFS.setOnClickListener(aVar.dFZ);
            this.dFS.setText(aVar.mText);
            this.dFT.setOnClickListener(aVar2.dFZ);
            this.dFT.setText(aVar2.mText);
            this.dFV.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void aPV() {
        this.dFM.setImageDrawable(null);
        this.dFM.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.dFQ != null) {
            am.setViewTextColor(this.dFQ, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.dFP != null) {
            am.setViewTextColor(this.dFP, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.dFO != null) {
            am.setViewTextColor(this.dFO, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = am.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.dFP.setCompoundDrawablePadding(dimens2);
        this.dFP.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.dFP != null) {
            this.dFP.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.dFP;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTitleContainerMargin(@DimenRes int i, @DimenRes int i2) {
        if (this.dFN != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dFN.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i2);
        }
    }
}
