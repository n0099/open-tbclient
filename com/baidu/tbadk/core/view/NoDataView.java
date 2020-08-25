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
/* loaded from: classes2.dex */
public class NoDataView extends LinearLayout {
    private NoDataViewFactory.ImgType erA;
    private int erB;
    private TbImageView erp;
    private LinearLayout erq;
    private TextView ers;
    private TextView ert;
    private TextView eru;
    private TBSpecificationBtn erv;
    private TBSpecificationBtn erw;
    private TBSpecificationBtn erx;
    private int ery;
    private View erz;
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
        this.erp = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.erp.setDefaultBgResource(0);
        this.erp.setDefaultResource(0);
        this.erp.setDefaultErrorResource(0);
        this.erq = (LinearLayout) this.mRootView.findViewById(R.id.title_container);
        this.ers = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.ert = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.eru = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.erv = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_func);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.erv.setTextSize(R.dimen.tbds42);
        this.erv.setConfig(aVar);
        this.erz = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        bkp();
    }

    private void bkp() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.erp.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.erp.setLayoutParams(marginLayoutParams);
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
        if (this.erv != null) {
            this.erv.bkF();
        }
        if (this.erw != null) {
            this.erw.bkF();
        }
        if (this.erx != null) {
            this.erx.bkF();
        }
        if (this.erA == NoDataViewFactory.ImgType.WEBVIEW) {
            this.erp.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.erA == NoDataViewFactory.ImgType.NODATA) {
            this.erp.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.erA == NoDataViewFactory.ImgType.LOCAL) {
            this.erp.setImageBitmap(ap.getBitmap565Quality(this.erB));
        } else if (this.erA == NoDataViewFactory.ImgType.ANTI) {
            this.erp.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.erA == NoDataViewFactory.ImgType.NETERROR) {
            this.erp.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else {
            this.erp.setImageBitmap(ap.getBitmap565Quality(this.ery));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.eru.setText(dVar.mTitle);
                this.eru.setVisibility(0);
            } else {
                this.eru.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.ert.setVisibility(0);
                this.ert.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.erJ >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ert.getLayoutParams();
                    layoutParams.topMargin = dVar.erJ;
                    this.ert.setLayoutParams(layoutParams);
                }
                if (dVar.mDrawableId != 0) {
                    setSubTitleCompoundDrawable(dVar.mDrawableId);
                }
            } else {
                this.ert.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.erI)) {
                this.ers.setText(dVar.erI);
                this.ers.setVisibility(0);
                return;
            }
            this.ers.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.erA = cVar.erH;
            this.erB = cVar.erB;
            switch (cVar.erH) {
                case FINDBAR:
                    this.ery = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.ery = R.drawable.new_pic_emotion_02;
                    break;
                case CREATE:
                    this.ery = R.drawable.new_pic_emotion_03;
                    break;
                case COLLECTION:
                    this.ery = R.drawable.new_pic_emotion_04;
                    break;
                case NODATA:
                    this.ery = R.drawable.new_pic_emotion_05;
                    break;
                case ANTI:
                    this.ery = R.drawable.new_pic_emotion_05;
                    break;
                case SINGALL:
                    this.ery = R.drawable.new_pic_emotion_06;
                    break;
                case GIFT:
                    this.ery = R.drawable.new_pic_emotion_07;
                    break;
                case WEBVIEW:
                    this.ery = R.drawable.new_pic_emotion_08;
                    break;
                case NETERROR:
                    this.ery = R.drawable.new_pic_emotion_08;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.erp.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.erp.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.erv.setVisibility(8);
            this.erz.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.erE;
        NoDataViewFactory.a aVar2 = bVar.erF;
        if (aVar2 == null && aVar != null) {
            this.erv.setOnClickListener(aVar.erD);
            this.erv.setText(aVar.mText);
            this.erv.setVisibility(0);
            if (bVar.erG >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.erv.getLayoutParams();
                layoutParams.topMargin = bVar.erG;
                this.erv.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.erw = (TBSpecificationBtn) this.erz.findViewById(R.id.btn_left);
            this.erx = (TBSpecificationBtn) this.erz.findViewById(R.id.btn_right);
            com.baidu.tbadk.core.view.commonBtn.a aVar3 = new com.baidu.tbadk.core.view.commonBtn.a();
            this.erw.setTextSize(R.dimen.ds32);
            this.erw.setConfig(aVar3);
            this.erx.setTextSize(R.dimen.ds32);
            this.erx.setConfig(aVar3);
            this.erw.setOnClickListener(aVar.erD);
            this.erw.setText(aVar.mText);
            this.erx.setOnClickListener(aVar2.erD);
            this.erx.setText(aVar2.mText);
            this.erz.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void bkq() {
        this.erp.setImageDrawable(null);
        this.erp.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.eru != null) {
            ap.setViewTextColor(this.eru, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.ert != null) {
            ap.setViewTextColor(this.ert, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.ers != null) {
            ap.setViewTextColor(this.ers, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = ap.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.ert.setCompoundDrawablePadding(dimens2);
        this.ert.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.ert != null) {
            this.ert.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.ert;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTitleContainerMargin(@DimenRes int i, @DimenRes int i2) {
        if (this.erq != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.erq.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i2);
        }
    }
}
