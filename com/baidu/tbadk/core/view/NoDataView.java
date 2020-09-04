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
    private TBSpecificationBtn erA;
    private TBSpecificationBtn erB;
    private int erC;
    private View erD;
    private NoDataViewFactory.ImgType erE;
    private int erF;
    private TbImageView eru;
    private LinearLayout erv;
    private TextView erw;
    private TextView erx;
    private TextView ery;
    private TBSpecificationBtn erz;
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
        this.eru = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.eru.setDefaultBgResource(0);
        this.eru.setDefaultResource(0);
        this.eru.setDefaultErrorResource(0);
        this.erv = (LinearLayout) this.mRootView.findViewById(R.id.title_container);
        this.erw = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.erx = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.ery = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.erz = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_func);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.erz.setTextSize(R.dimen.tbds42);
        this.erz.setConfig(aVar);
        this.erD = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        bkp();
    }

    private void bkp() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.eru.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.eru.setLayoutParams(marginLayoutParams);
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
        if (this.erz != null) {
            this.erz.bkF();
        }
        if (this.erA != null) {
            this.erA.bkF();
        }
        if (this.erB != null) {
            this.erB.bkF();
        }
        if (this.erE == NoDataViewFactory.ImgType.WEBVIEW) {
            this.eru.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.erE == NoDataViewFactory.ImgType.NODATA) {
            this.eru.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.erE == NoDataViewFactory.ImgType.LOCAL) {
            this.eru.setImageBitmap(ap.getBitmap565Quality(this.erF));
        } else if (this.erE == NoDataViewFactory.ImgType.ANTI) {
            this.eru.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.erE == NoDataViewFactory.ImgType.NETERROR) {
            this.eru.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else {
            this.eru.setImageBitmap(ap.getBitmap565Quality(this.erC));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.ery.setText(dVar.mTitle);
                this.ery.setVisibility(0);
            } else {
                this.ery.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.erx.setVisibility(0);
                this.erx.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.erN >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.erx.getLayoutParams();
                    layoutParams.topMargin = dVar.erN;
                    this.erx.setLayoutParams(layoutParams);
                }
                if (dVar.mDrawableId != 0) {
                    setSubTitleCompoundDrawable(dVar.mDrawableId);
                }
            } else {
                this.erx.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.erM)) {
                this.erw.setText(dVar.erM);
                this.erw.setVisibility(0);
                return;
            }
            this.erw.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.erE = cVar.erL;
            this.erF = cVar.erF;
            switch (cVar.erL) {
                case FINDBAR:
                    this.erC = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.erC = R.drawable.new_pic_emotion_02;
                    break;
                case CREATE:
                    this.erC = R.drawable.new_pic_emotion_03;
                    break;
                case COLLECTION:
                    this.erC = R.drawable.new_pic_emotion_04;
                    break;
                case NODATA:
                    this.erC = R.drawable.new_pic_emotion_05;
                    break;
                case ANTI:
                    this.erC = R.drawable.new_pic_emotion_05;
                    break;
                case SINGALL:
                    this.erC = R.drawable.new_pic_emotion_06;
                    break;
                case GIFT:
                    this.erC = R.drawable.new_pic_emotion_07;
                    break;
                case WEBVIEW:
                    this.erC = R.drawable.new_pic_emotion_08;
                    break;
                case NETERROR:
                    this.erC = R.drawable.new_pic_emotion_08;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eru.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.eru.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.erz.setVisibility(8);
            this.erD.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.erI;
        NoDataViewFactory.a aVar2 = bVar.erJ;
        if (aVar2 == null && aVar != null) {
            this.erz.setOnClickListener(aVar.erH);
            this.erz.setText(aVar.mText);
            this.erz.setVisibility(0);
            if (bVar.erK >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.erz.getLayoutParams();
                layoutParams.topMargin = bVar.erK;
                this.erz.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.erA = (TBSpecificationBtn) this.erD.findViewById(R.id.btn_left);
            this.erB = (TBSpecificationBtn) this.erD.findViewById(R.id.btn_right);
            com.baidu.tbadk.core.view.commonBtn.a aVar3 = new com.baidu.tbadk.core.view.commonBtn.a();
            this.erA.setTextSize(R.dimen.ds32);
            this.erA.setConfig(aVar3);
            this.erB.setTextSize(R.dimen.ds32);
            this.erB.setConfig(aVar3);
            this.erA.setOnClickListener(aVar.erH);
            this.erA.setText(aVar.mText);
            this.erB.setOnClickListener(aVar2.erH);
            this.erB.setText(aVar2.mText);
            this.erD.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void bkq() {
        this.eru.setImageDrawable(null);
        this.eru.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.ery != null) {
            ap.setViewTextColor(this.ery, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.erx != null) {
            ap.setViewTextColor(this.erx, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.erw != null) {
            ap.setViewTextColor(this.erw, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = ap.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.erx.setCompoundDrawablePadding(dimens2);
        this.erx.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.erx != null) {
            this.erx.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.erx;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTitleContainerMargin(@DimenRes int i, @DimenRes int i2) {
        if (this.erv != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.erv.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i2);
        }
    }
}
