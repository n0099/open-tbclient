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
    private TbImageView dFI;
    private LinearLayout dFJ;
    private TextView dFK;
    private TextView dFL;
    private TextView dFM;
    private TBSpecificationBtn dFN;
    private TBSpecificationBtn dFO;
    private TBSpecificationBtn dFP;
    private int dFQ;
    private View dFR;
    private NoDataViewFactory.ImgType dFS;
    private int dFT;
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
        this.dFI = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.dFI.setDefaultBgResource(0);
        this.dFI.setDefaultResource(0);
        this.dFI.setDefaultErrorResource(0);
        this.dFJ = (LinearLayout) this.mRootView.findViewById(R.id.title_container);
        this.dFK = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.dFL = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.dFM = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.dFN = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_func);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.dFN.setTextSize(R.dimen.tbds42);
        this.dFN.setConfig(bVar);
        this.dFR = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        aPX();
    }

    private void aPX() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.dFI.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.dFI.setLayoutParams(marginLayoutParams);
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
        if (this.dFN != null) {
            this.dFN.aQp();
        }
        if (this.dFO != null) {
            this.dFO.aQp();
        }
        if (this.dFP != null) {
            this.dFP.aQp();
        }
        if (this.dFS == NoDataViewFactory.ImgType.WEBVIEW) {
            this.dFI.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.dFS == NoDataViewFactory.ImgType.NODATA) {
            this.dFI.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.dFS == NoDataViewFactory.ImgType.LOCAL) {
            this.dFI.setImageBitmap(am.getBitmap565Quality(this.dFT));
        } else if (this.dFS == NoDataViewFactory.ImgType.ANTI) {
            this.dFI.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.dFS == NoDataViewFactory.ImgType.NETERROR) {
            this.dFI.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else {
            this.dFI.setImageBitmap(am.getBitmap565Quality(this.dFQ));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.dFM.setText(dVar.mTitle);
                this.dFM.setVisibility(0);
            } else {
                this.dFM.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.dFL.setVisibility(0);
                this.dFL.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.dGb >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dFL.getLayoutParams();
                    layoutParams.topMargin = dVar.dGb;
                    this.dFL.setLayoutParams(layoutParams);
                }
                if (dVar.mDrawableId != 0) {
                    setSubTitleCompoundDrawable(dVar.mDrawableId);
                }
            } else {
                this.dFL.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.dGa)) {
                this.dFK.setText(dVar.dGa);
                this.dFK.setVisibility(0);
                return;
            }
            this.dFK.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.dFS = cVar.dFZ;
            this.dFT = cVar.dFT;
            switch (cVar.dFZ) {
                case FINDBAR:
                    this.dFQ = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.dFQ = R.drawable.new_pic_emotion_02;
                    break;
                case CREATE:
                    this.dFQ = R.drawable.new_pic_emotion_03;
                    break;
                case COLLECTION:
                    this.dFQ = R.drawable.new_pic_emotion_04;
                    break;
                case NODATA:
                    this.dFQ = R.drawable.new_pic_emotion_05;
                    break;
                case ANTI:
                    this.dFQ = R.drawable.new_pic_emotion_05;
                    break;
                case SINGALL:
                    this.dFQ = R.drawable.new_pic_emotion_06;
                    break;
                case GIFT:
                    this.dFQ = R.drawable.new_pic_emotion_07;
                    break;
                case WEBVIEW:
                    this.dFQ = R.drawable.new_pic_emotion_08;
                    break;
                case NETERROR:
                    this.dFQ = R.drawable.new_pic_emotion_08;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dFI.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.dFI.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.dFN.setVisibility(8);
            this.dFR.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.dFW;
        NoDataViewFactory.a aVar2 = bVar.dFX;
        if (aVar2 == null && aVar != null) {
            this.dFN.setOnClickListener(aVar.dFV);
            this.dFN.setText(aVar.mText);
            this.dFN.setVisibility(0);
            if (bVar.dFY >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dFN.getLayoutParams();
                layoutParams.topMargin = bVar.dFY;
                this.dFN.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.dFO = (TBSpecificationBtn) this.dFR.findViewById(R.id.btn_left);
            this.dFP = (TBSpecificationBtn) this.dFR.findViewById(R.id.btn_right);
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            this.dFO.setTextSize(R.dimen.ds32);
            this.dFO.setConfig(bVar2);
            this.dFP.setTextSize(R.dimen.ds32);
            this.dFP.setConfig(bVar2);
            this.dFO.setOnClickListener(aVar.dFV);
            this.dFO.setText(aVar.mText);
            this.dFP.setOnClickListener(aVar2.dFV);
            this.dFP.setText(aVar2.mText);
            this.dFR.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void aPY() {
        this.dFI.setImageDrawable(null);
        this.dFI.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.dFM != null) {
            am.setViewTextColor(this.dFM, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.dFL != null) {
            am.setViewTextColor(this.dFL, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.dFK != null) {
            am.setViewTextColor(this.dFK, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = am.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.dFL.setCompoundDrawablePadding(dimens2);
        this.dFL.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.dFL != null) {
            this.dFL.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.dFL;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTitleContainerMargin(@DimenRes int i, @DimenRes int i2) {
        if (this.dFJ != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dFJ.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i2);
        }
    }
}
