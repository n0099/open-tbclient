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
    private TbImageView dfK;
    private LinearLayout dfL;
    private TextView dfM;
    private TextView dfN;
    private TextView dfO;
    private TBSpecificationBtn dfP;
    private TBSpecificationBtn dfQ;
    private TBSpecificationBtn dfR;
    private int dfS;
    private View dfT;
    private NoDataViewFactory.ImgType dfU;
    private int dfV;
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
        this.dfK = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.dfK.setDefaultBgResource(0);
        this.dfK.setDefaultResource(0);
        this.dfK.setDefaultErrorResource(0);
        this.dfL = (LinearLayout) this.mRootView.findViewById(R.id.title_container);
        this.dfM = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.dfN = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.dfO = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.dfP = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_func);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.dfP.setTextSize(R.dimen.tbds42);
        this.dfP.setConfig(bVar);
        this.dfT = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        aHy();
    }

    private void aHy() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.dfK.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.dfK.setLayoutParams(marginLayoutParams);
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
        if (this.dfP != null) {
            this.dfP.aHL();
        }
        if (this.dfQ != null) {
            this.dfQ.aHL();
        }
        if (this.dfR != null) {
            this.dfR.aHL();
        }
        if (this.dfU == NoDataViewFactory.ImgType.WEBVIEW) {
            this.dfK.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.dfU == NoDataViewFactory.ImgType.NODATA) {
            this.dfK.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.dfU == NoDataViewFactory.ImgType.LOCAL) {
            this.dfK.setImageBitmap(am.getBitmap565Quality(this.dfV));
        } else if (this.dfU == NoDataViewFactory.ImgType.ANTI) {
            this.dfK.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.dfU == NoDataViewFactory.ImgType.NETERROR) {
            this.dfK.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else {
            this.dfK.setImageBitmap(am.getBitmap565Quality(this.dfS));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.dfO.setText(dVar.mTitle);
                this.dfO.setVisibility(0);
            } else {
                this.dfO.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.dfN.setVisibility(0);
                this.dfN.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.dgd >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dfN.getLayoutParams();
                    layoutParams.topMargin = dVar.dgd;
                    this.dfN.setLayoutParams(layoutParams);
                }
                if (dVar.mDrawableId != 0) {
                    setSubTitleCompoundDrawable(dVar.mDrawableId);
                }
            } else {
                this.dfN.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.dgc)) {
                this.dfM.setText(dVar.dgc);
                this.dfM.setVisibility(0);
                return;
            }
            this.dfM.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.dfU = cVar.dgb;
            this.dfV = cVar.dfV;
            switch (cVar.dgb) {
                case FINDBAR:
                    this.dfS = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.dfS = R.drawable.new_pic_emotion_02;
                    break;
                case CREATE:
                    this.dfS = R.drawable.new_pic_emotion_03;
                    break;
                case COLLECTION:
                    this.dfS = R.drawable.new_pic_emotion_04;
                    break;
                case NODATA:
                    this.dfS = R.drawable.new_pic_emotion_05;
                    break;
                case ANTI:
                    this.dfS = R.drawable.new_pic_emotion_05;
                    break;
                case SINGALL:
                    this.dfS = R.drawable.new_pic_emotion_06;
                    break;
                case GIFT:
                    this.dfS = R.drawable.new_pic_emotion_07;
                    break;
                case WEBVIEW:
                    this.dfS = R.drawable.new_pic_emotion_08;
                    break;
                case NETERROR:
                    this.dfS = R.drawable.new_pic_emotion_08;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dfK.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.dfK.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.dfP.setVisibility(8);
            this.dfT.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.dfY;
        NoDataViewFactory.a aVar2 = bVar.dfZ;
        if (aVar2 == null && aVar != null) {
            this.dfP.setOnClickListener(aVar.dfX);
            this.dfP.setText(aVar.mText);
            this.dfP.setVisibility(0);
            if (bVar.dga >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dfP.getLayoutParams();
                layoutParams.topMargin = bVar.dga;
                this.dfP.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.dfQ = (TBSpecificationBtn) this.dfT.findViewById(R.id.btn_left);
            this.dfR = (TBSpecificationBtn) this.dfT.findViewById(R.id.btn_right);
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            this.dfQ.setTextSize(R.dimen.ds32);
            this.dfQ.setConfig(bVar2);
            this.dfR.setTextSize(R.dimen.ds32);
            this.dfR.setConfig(bVar2);
            this.dfQ.setOnClickListener(aVar.dfX);
            this.dfQ.setText(aVar.mText);
            this.dfR.setOnClickListener(aVar2.dfX);
            this.dfR.setText(aVar2.mText);
            this.dfT.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void aHz() {
        this.dfK.setImageDrawable(null);
        this.dfK.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.dfO != null) {
            am.setViewTextColor(this.dfO, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.dfN != null) {
            am.setViewTextColor(this.dfN, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.dfM != null) {
            am.setViewTextColor(this.dfM, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = am.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.dfN.setCompoundDrawablePadding(dimens2);
        this.dfN.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.dfN != null) {
            this.dfN.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.dfN;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTitleContainerMargin(@DimenRes int i, @DimenRes int i2) {
        if (this.dfL != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dfL.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i2);
        }
    }
}
