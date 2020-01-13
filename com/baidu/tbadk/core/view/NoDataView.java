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
    private TbImageView dbF;
    private LinearLayout dbG;
    private TextView dbH;
    private TextView dbI;
    private TextView dbJ;
    private TBSpecificationBtn dbK;
    private TBSpecificationBtn dbL;
    private TBSpecificationBtn dbM;
    private int dbN;
    private View dbO;
    private NoDataViewFactory.ImgType dbP;
    private int dbQ;
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
        this.dbF = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.dbF.setDefaultBgResource(0);
        this.dbF.setDefaultResource(0);
        this.dbF.setDefaultErrorResource(0);
        this.dbG = (LinearLayout) this.mRootView.findViewById(R.id.title_container);
        this.dbH = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.dbI = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.dbJ = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.dbK = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_func);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.dbK.setTextSize(R.dimen.tbds42);
        this.dbK.setConfig(bVar);
        this.dbO = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        aFm();
    }

    private void aFm() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.dbF.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.dbF.setLayoutParams(marginLayoutParams);
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
        if (this.dbK != null) {
            this.dbK.aFw();
        }
        if (this.dbL != null) {
            this.dbL.aFw();
        }
        if (this.dbM != null) {
            this.dbM.aFw();
        }
        if (this.dbP == NoDataViewFactory.ImgType.WEBVIEW) {
            this.dbF.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.dbP == NoDataViewFactory.ImgType.NODATA) {
            this.dbF.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.dbP == NoDataViewFactory.ImgType.LOCAL) {
            this.dbF.setImageBitmap(am.getBitmap565Quality(this.dbQ));
        } else if (this.dbP == NoDataViewFactory.ImgType.ANTI) {
            this.dbF.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.dbP == NoDataViewFactory.ImgType.NETERROR) {
            this.dbF.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else {
            this.dbF.setImageBitmap(am.getBitmap565Quality(this.dbN));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.dbJ.setText(dVar.mTitle);
                this.dbJ.setVisibility(0);
            } else {
                this.dbJ.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.dbI.setVisibility(0);
                this.dbI.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.dbY >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dbI.getLayoutParams();
                    layoutParams.topMargin = dVar.dbY;
                    this.dbI.setLayoutParams(layoutParams);
                }
                if (dVar.mDrawableId != 0) {
                    setSubTitleCompoundDrawable(dVar.mDrawableId);
                }
            } else {
                this.dbI.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.dbX)) {
                this.dbH.setText(dVar.dbX);
                this.dbH.setVisibility(0);
                return;
            }
            this.dbH.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.dbP = cVar.dbW;
            this.dbQ = cVar.dbQ;
            switch (cVar.dbW) {
                case FINDBAR:
                    this.dbN = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.dbN = R.drawable.new_pic_emotion_02;
                    break;
                case CREATE:
                    this.dbN = R.drawable.new_pic_emotion_03;
                    break;
                case COLLECTION:
                    this.dbN = R.drawable.new_pic_emotion_04;
                    break;
                case NODATA:
                    this.dbN = R.drawable.new_pic_emotion_05;
                    break;
                case ANTI:
                    this.dbN = R.drawable.new_pic_emotion_05;
                    break;
                case SINGALL:
                    this.dbN = R.drawable.new_pic_emotion_06;
                    break;
                case GIFT:
                    this.dbN = R.drawable.new_pic_emotion_07;
                    break;
                case WEBVIEW:
                    this.dbN = R.drawable.new_pic_emotion_08;
                    break;
                case NETERROR:
                    this.dbN = R.drawable.new_pic_emotion_08;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dbF.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.dbF.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.dbK.setVisibility(8);
            this.dbO.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.dbT;
        NoDataViewFactory.a aVar2 = bVar.dbU;
        if (aVar2 == null && aVar != null) {
            this.dbK.setOnClickListener(aVar.dbS);
            this.dbK.setText(aVar.mText);
            this.dbK.setVisibility(0);
            if (bVar.dbV >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dbK.getLayoutParams();
                layoutParams.topMargin = bVar.dbV;
                this.dbK.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.dbL = (TBSpecificationBtn) this.dbO.findViewById(R.id.btn_left);
            this.dbM = (TBSpecificationBtn) this.dbO.findViewById(R.id.btn_right);
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            this.dbL.setTextSize(R.dimen.ds32);
            this.dbL.setConfig(bVar2);
            this.dbM.setTextSize(R.dimen.ds32);
            this.dbM.setConfig(bVar2);
            this.dbL.setOnClickListener(aVar.dbS);
            this.dbL.setText(aVar.mText);
            this.dbM.setOnClickListener(aVar2.dbS);
            this.dbM.setText(aVar2.mText);
            this.dbO.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void aFn() {
        this.dbF.setImageDrawable(null);
        this.dbF.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.dbJ != null) {
            am.setViewTextColor(this.dbJ, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.dbI != null) {
            am.setViewTextColor(this.dbI, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.dbH != null) {
            am.setViewTextColor(this.dbH, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = am.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.dbI.setCompoundDrawablePadding(dimens2);
        this.dbI.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.dbI != null) {
            this.dbI.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.dbI;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTitleContainerMargin(@DimenRes int i, @DimenRes int i2) {
        if (this.dbG != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dbG.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i2);
        }
    }
}
