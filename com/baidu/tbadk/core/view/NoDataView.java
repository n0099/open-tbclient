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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NoDataView extends LinearLayout {
    private LinearLayout ehA;
    private TextView ehB;
    private TextView ehC;
    private TextView ehD;
    private TBSpecificationBtn ehE;
    private TBSpecificationBtn ehF;
    private TBSpecificationBtn ehG;
    private int ehH;
    private View ehI;
    private NoDataViewFactory.ImgType ehJ;
    private int ehK;
    private TbImageView ehz;
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
        this.ehz = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.ehz.setDefaultBgResource(0);
        this.ehz.setDefaultResource(0);
        this.ehz.setDefaultErrorResource(0);
        this.ehA = (LinearLayout) this.mRootView.findViewById(R.id.title_container);
        this.ehB = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.ehC = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.ehD = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.ehE = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_func);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.ehE.setTextSize(R.dimen.tbds42);
        this.ehE.setConfig(bVar);
        this.ehI = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        bbT();
    }

    private void bbT() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.ehz.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.ehz.setLayoutParams(marginLayoutParams);
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
        if (this.ehE != null) {
            this.ehE.bci();
        }
        if (this.ehF != null) {
            this.ehF.bci();
        }
        if (this.ehG != null) {
            this.ehG.bci();
        }
        if (this.ehJ == NoDataViewFactory.ImgType.WEBVIEW) {
            this.ehz.setImageBitmap(ao.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.ehJ == NoDataViewFactory.ImgType.NODATA) {
            this.ehz.setImageBitmap(ao.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.ehJ == NoDataViewFactory.ImgType.LOCAL) {
            this.ehz.setImageBitmap(ao.getBitmap565Quality(this.ehK));
        } else if (this.ehJ == NoDataViewFactory.ImgType.ANTI) {
            this.ehz.setImageBitmap(ao.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.ehJ == NoDataViewFactory.ImgType.NETERROR) {
            this.ehz.setImageBitmap(ao.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else {
            this.ehz.setImageBitmap(ao.getBitmap565Quality(this.ehH));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.ehD.setText(dVar.mTitle);
                this.ehD.setVisibility(0);
            } else {
                this.ehD.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.ehC.setVisibility(0);
                this.ehC.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.ehS >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ehC.getLayoutParams();
                    layoutParams.topMargin = dVar.ehS;
                    this.ehC.setLayoutParams(layoutParams);
                }
                if (dVar.mDrawableId != 0) {
                    setSubTitleCompoundDrawable(dVar.mDrawableId);
                }
            } else {
                this.ehC.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.ehR)) {
                this.ehB.setText(dVar.ehR);
                this.ehB.setVisibility(0);
                return;
            }
            this.ehB.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.ehJ = cVar.ehQ;
            this.ehK = cVar.ehK;
            switch (cVar.ehQ) {
                case FINDBAR:
                    this.ehH = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.ehH = R.drawable.new_pic_emotion_02;
                    break;
                case CREATE:
                    this.ehH = R.drawable.new_pic_emotion_03;
                    break;
                case COLLECTION:
                    this.ehH = R.drawable.new_pic_emotion_04;
                    break;
                case NODATA:
                    this.ehH = R.drawable.new_pic_emotion_05;
                    break;
                case ANTI:
                    this.ehH = R.drawable.new_pic_emotion_05;
                    break;
                case SINGALL:
                    this.ehH = R.drawable.new_pic_emotion_06;
                    break;
                case GIFT:
                    this.ehH = R.drawable.new_pic_emotion_07;
                    break;
                case WEBVIEW:
                    this.ehH = R.drawable.new_pic_emotion_08;
                    break;
                case NETERROR:
                    this.ehH = R.drawable.new_pic_emotion_08;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ehz.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.ehz.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.ehE.setVisibility(8);
            this.ehI.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.ehN;
        NoDataViewFactory.a aVar2 = bVar.ehO;
        if (aVar2 == null && aVar != null) {
            this.ehE.setOnClickListener(aVar.ehM);
            this.ehE.setText(aVar.mText);
            this.ehE.setVisibility(0);
            if (bVar.ehP >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ehE.getLayoutParams();
                layoutParams.topMargin = bVar.ehP;
                this.ehE.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.ehF = (TBSpecificationBtn) this.ehI.findViewById(R.id.btn_left);
            this.ehG = (TBSpecificationBtn) this.ehI.findViewById(R.id.btn_right);
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            this.ehF.setTextSize(R.dimen.ds32);
            this.ehF.setConfig(bVar2);
            this.ehG.setTextSize(R.dimen.ds32);
            this.ehG.setConfig(bVar2);
            this.ehF.setOnClickListener(aVar.ehM);
            this.ehF.setText(aVar.mText);
            this.ehG.setOnClickListener(aVar2.ehM);
            this.ehG.setText(aVar2.mText);
            this.ehI.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void bbU() {
        this.ehz.setImageDrawable(null);
        this.ehz.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.ehD != null) {
            ao.setViewTextColor(this.ehD, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.ehC != null) {
            ao.setViewTextColor(this.ehC, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.ehB != null) {
            ao.setViewTextColor(this.ehB, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = ao.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.ehC.setCompoundDrawablePadding(dimens2);
        this.ehC.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.ehC != null) {
            this.ehC.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.ehC;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTitleContainerMargin(@DimenRes int i, @DimenRes int i2) {
        if (this.ehA != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ehA.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i2);
        }
    }
}
