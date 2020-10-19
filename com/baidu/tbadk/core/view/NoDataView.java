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
    private TbImageView eFJ;
    private LinearLayout eFK;
    private TextView eFL;
    private TextView eFM;
    private TextView eFN;
    private TBSpecificationBtn eFO;
    private TBSpecificationBtn eFP;
    private TBSpecificationBtn eFQ;
    private int eFR;
    private View eFS;
    private NoDataViewFactory.ImgType eFT;
    private int eFU;
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
        this.eFJ = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.eFJ.setDefaultBgResource(0);
        this.eFJ.setDefaultResource(0);
        this.eFJ.setDefaultErrorResource(0);
        this.eFK = (LinearLayout) this.mRootView.findViewById(R.id.title_container);
        this.eFL = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.eFM = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.eFN = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.eFO = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_func);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.eFO.setTextSize(R.dimen.tbds42);
        this.eFO.setConfig(aVar);
        this.eFS = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        bnU();
    }

    private void bnU() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.eFJ.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.eFJ.setLayoutParams(marginLayoutParams);
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
        if (this.eFO != null) {
            this.eFO.bok();
        }
        if (this.eFP != null) {
            this.eFP.bok();
        }
        if (this.eFQ != null) {
            this.eFQ.bok();
        }
        if (this.eFT == NoDataViewFactory.ImgType.WEBVIEW) {
            this.eFJ.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.eFT == NoDataViewFactory.ImgType.NODATA) {
            this.eFJ.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.eFT == NoDataViewFactory.ImgType.LOCAL) {
            this.eFJ.setImageBitmap(ap.getBitmap565Quality(this.eFU));
        } else if (this.eFT == NoDataViewFactory.ImgType.ANTI) {
            this.eFJ.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.eFT == NoDataViewFactory.ImgType.NETERROR) {
            this.eFJ.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else {
            this.eFJ.setImageBitmap(ap.getBitmap565Quality(this.eFR));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.eFN.setText(dVar.mTitle);
                this.eFN.setVisibility(0);
            } else {
                this.eFN.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.eFM.setVisibility(0);
                this.eFM.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.eGc >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eFM.getLayoutParams();
                    layoutParams.topMargin = dVar.eGc;
                    this.eFM.setLayoutParams(layoutParams);
                }
                if (dVar.mDrawableId != 0) {
                    setSubTitleCompoundDrawable(dVar.mDrawableId);
                }
            } else {
                this.eFM.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.eGb)) {
                this.eFL.setText(dVar.eGb);
                this.eFL.setVisibility(0);
                return;
            }
            this.eFL.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.eFT = cVar.eGa;
            this.eFU = cVar.eFU;
            switch (cVar.eGa) {
                case FINDBAR:
                    this.eFR = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.eFR = R.drawable.new_pic_emotion_02;
                    break;
                case CREATE:
                    this.eFR = R.drawable.new_pic_emotion_03;
                    break;
                case COLLECTION:
                    this.eFR = R.drawable.new_pic_emotion_04;
                    break;
                case NODATA:
                    this.eFR = R.drawable.new_pic_emotion_05;
                    break;
                case ANTI:
                    this.eFR = R.drawable.new_pic_emotion_05;
                    break;
                case SINGALL:
                    this.eFR = R.drawable.new_pic_emotion_06;
                    break;
                case GIFT:
                    this.eFR = R.drawable.new_pic_emotion_07;
                    break;
                case WEBVIEW:
                    this.eFR = R.drawable.new_pic_emotion_08;
                    break;
                case NETERROR:
                    this.eFR = R.drawable.new_pic_emotion_08;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eFJ.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.eFJ.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.eFO.setVisibility(8);
            this.eFS.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.eFX;
        NoDataViewFactory.a aVar2 = bVar.eFY;
        if (aVar2 == null && aVar != null) {
            this.eFO.setOnClickListener(aVar.eFW);
            this.eFO.setText(aVar.mText);
            this.eFO.setVisibility(0);
            if (bVar.eFZ >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eFO.getLayoutParams();
                layoutParams.topMargin = bVar.eFZ;
                this.eFO.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.eFP = (TBSpecificationBtn) this.eFS.findViewById(R.id.btn_left);
            this.eFQ = (TBSpecificationBtn) this.eFS.findViewById(R.id.btn_right);
            com.baidu.tbadk.core.view.commonBtn.a aVar3 = new com.baidu.tbadk.core.view.commonBtn.a();
            this.eFP.setTextSize(R.dimen.ds32);
            this.eFP.setConfig(aVar3);
            this.eFQ.setTextSize(R.dimen.ds32);
            this.eFQ.setConfig(aVar3);
            this.eFP.setOnClickListener(aVar.eFW);
            this.eFP.setText(aVar.mText);
            this.eFQ.setOnClickListener(aVar2.eFW);
            this.eFQ.setText(aVar2.mText);
            this.eFS.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void bnV() {
        this.eFJ.setImageDrawable(null);
        this.eFJ.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.eFN != null) {
            ap.setViewTextColor(this.eFN, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.eFM != null) {
            ap.setViewTextColor(this.eFM, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.eFL != null) {
            ap.setViewTextColor(this.eFL, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = ap.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.eFM.setCompoundDrawablePadding(dimens2);
        this.eFM.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.eFM != null) {
            this.eFM.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.eFM;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTitleContainerMargin(@DimenRes int i, @DimenRes int i2) {
        if (this.eFK != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eFK.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i2);
        }
    }
}
