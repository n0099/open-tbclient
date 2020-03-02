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
    private TbImageView dfL;
    private LinearLayout dfM;
    private TextView dfN;
    private TextView dfO;
    private TextView dfP;
    private TBSpecificationBtn dfQ;
    private TBSpecificationBtn dfR;
    private TBSpecificationBtn dfS;
    private int dfT;
    private View dfU;
    private NoDataViewFactory.ImgType dfV;
    private int dfW;
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
        this.dfL = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.dfL.setDefaultBgResource(0);
        this.dfL.setDefaultResource(0);
        this.dfL.setDefaultErrorResource(0);
        this.dfM = (LinearLayout) this.mRootView.findViewById(R.id.title_container);
        this.dfN = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.dfO = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.dfP = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.dfQ = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_func);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.dfQ.setTextSize(R.dimen.tbds42);
        this.dfQ.setConfig(bVar);
        this.dfU = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        aHA();
    }

    private void aHA() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.dfL.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.dfL.setLayoutParams(marginLayoutParams);
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
        if (this.dfQ != null) {
            this.dfQ.aHN();
        }
        if (this.dfR != null) {
            this.dfR.aHN();
        }
        if (this.dfS != null) {
            this.dfS.aHN();
        }
        if (this.dfV == NoDataViewFactory.ImgType.WEBVIEW) {
            this.dfL.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.dfV == NoDataViewFactory.ImgType.NODATA) {
            this.dfL.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.dfV == NoDataViewFactory.ImgType.LOCAL) {
            this.dfL.setImageBitmap(am.getBitmap565Quality(this.dfW));
        } else if (this.dfV == NoDataViewFactory.ImgType.ANTI) {
            this.dfL.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.dfV == NoDataViewFactory.ImgType.NETERROR) {
            this.dfL.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else {
            this.dfL.setImageBitmap(am.getBitmap565Quality(this.dfT));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.dfP.setText(dVar.mTitle);
                this.dfP.setVisibility(0);
            } else {
                this.dfP.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.dfO.setVisibility(0);
                this.dfO.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.dge >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dfO.getLayoutParams();
                    layoutParams.topMargin = dVar.dge;
                    this.dfO.setLayoutParams(layoutParams);
                }
                if (dVar.mDrawableId != 0) {
                    setSubTitleCompoundDrawable(dVar.mDrawableId);
                }
            } else {
                this.dfO.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.dgd)) {
                this.dfN.setText(dVar.dgd);
                this.dfN.setVisibility(0);
                return;
            }
            this.dfN.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.dfV = cVar.dgc;
            this.dfW = cVar.dfW;
            switch (cVar.dgc) {
                case FINDBAR:
                    this.dfT = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.dfT = R.drawable.new_pic_emotion_02;
                    break;
                case CREATE:
                    this.dfT = R.drawable.new_pic_emotion_03;
                    break;
                case COLLECTION:
                    this.dfT = R.drawable.new_pic_emotion_04;
                    break;
                case NODATA:
                    this.dfT = R.drawable.new_pic_emotion_05;
                    break;
                case ANTI:
                    this.dfT = R.drawable.new_pic_emotion_05;
                    break;
                case SINGALL:
                    this.dfT = R.drawable.new_pic_emotion_06;
                    break;
                case GIFT:
                    this.dfT = R.drawable.new_pic_emotion_07;
                    break;
                case WEBVIEW:
                    this.dfT = R.drawable.new_pic_emotion_08;
                    break;
                case NETERROR:
                    this.dfT = R.drawable.new_pic_emotion_08;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dfL.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.dfL.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.dfQ.setVisibility(8);
            this.dfU.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.dfZ;
        NoDataViewFactory.a aVar2 = bVar.dga;
        if (aVar2 == null && aVar != null) {
            this.dfQ.setOnClickListener(aVar.dfY);
            this.dfQ.setText(aVar.mText);
            this.dfQ.setVisibility(0);
            if (bVar.dgb >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dfQ.getLayoutParams();
                layoutParams.topMargin = bVar.dgb;
                this.dfQ.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.dfR = (TBSpecificationBtn) this.dfU.findViewById(R.id.btn_left);
            this.dfS = (TBSpecificationBtn) this.dfU.findViewById(R.id.btn_right);
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            this.dfR.setTextSize(R.dimen.ds32);
            this.dfR.setConfig(bVar2);
            this.dfS.setTextSize(R.dimen.ds32);
            this.dfS.setConfig(bVar2);
            this.dfR.setOnClickListener(aVar.dfY);
            this.dfR.setText(aVar.mText);
            this.dfS.setOnClickListener(aVar2.dfY);
            this.dfS.setText(aVar2.mText);
            this.dfU.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void aHB() {
        this.dfL.setImageDrawable(null);
        this.dfL.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.dfP != null) {
            am.setViewTextColor(this.dfP, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.dfO != null) {
            am.setViewTextColor(this.dfO, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.dfN != null) {
            am.setViewTextColor(this.dfN, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = am.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.dfO.setCompoundDrawablePadding(dimens2);
        this.dfO.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.dfO != null) {
            this.dfO.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.dfO;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTitleContainerMargin(@DimenRes int i, @DimenRes int i2) {
        if (this.dfM != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dfM.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i2);
        }
    }
}
