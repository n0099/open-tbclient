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
    private TbImageView dfY;
    private LinearLayout dfZ;
    private TextView dga;
    private TextView dgb;
    private TextView dgc;
    private TBSpecificationBtn dgd;
    private TBSpecificationBtn dge;
    private TBSpecificationBtn dgf;
    private int dgg;
    private View dgh;
    private NoDataViewFactory.ImgType dgi;
    private int dgj;
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
        this.dfY = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.dfY.setDefaultBgResource(0);
        this.dfY.setDefaultResource(0);
        this.dfY.setDefaultErrorResource(0);
        this.dfZ = (LinearLayout) this.mRootView.findViewById(R.id.title_container);
        this.dga = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.dgb = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.dgc = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.dgd = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_func);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.dgd.setTextSize(R.dimen.tbds42);
        this.dgd.setConfig(bVar);
        this.dgh = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        aHB();
    }

    private void aHB() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.dfY.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.dfY.setLayoutParams(marginLayoutParams);
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
        if (this.dgd != null) {
            this.dgd.aHO();
        }
        if (this.dge != null) {
            this.dge.aHO();
        }
        if (this.dgf != null) {
            this.dgf.aHO();
        }
        if (this.dgi == NoDataViewFactory.ImgType.WEBVIEW) {
            this.dfY.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.dgi == NoDataViewFactory.ImgType.NODATA) {
            this.dfY.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.dgi == NoDataViewFactory.ImgType.LOCAL) {
            this.dfY.setImageBitmap(am.getBitmap565Quality(this.dgj));
        } else if (this.dgi == NoDataViewFactory.ImgType.ANTI) {
            this.dfY.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.dgi == NoDataViewFactory.ImgType.NETERROR) {
            this.dfY.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else {
            this.dfY.setImageBitmap(am.getBitmap565Quality(this.dgg));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.dgc.setText(dVar.mTitle);
                this.dgc.setVisibility(0);
            } else {
                this.dgc.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.dgb.setVisibility(0);
                this.dgb.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.dgr >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dgb.getLayoutParams();
                    layoutParams.topMargin = dVar.dgr;
                    this.dgb.setLayoutParams(layoutParams);
                }
                if (dVar.mDrawableId != 0) {
                    setSubTitleCompoundDrawable(dVar.mDrawableId);
                }
            } else {
                this.dgb.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.dgq)) {
                this.dga.setText(dVar.dgq);
                this.dga.setVisibility(0);
                return;
            }
            this.dga.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.dgi = cVar.dgp;
            this.dgj = cVar.dgj;
            switch (cVar.dgp) {
                case FINDBAR:
                    this.dgg = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.dgg = R.drawable.new_pic_emotion_02;
                    break;
                case CREATE:
                    this.dgg = R.drawable.new_pic_emotion_03;
                    break;
                case COLLECTION:
                    this.dgg = R.drawable.new_pic_emotion_04;
                    break;
                case NODATA:
                    this.dgg = R.drawable.new_pic_emotion_05;
                    break;
                case ANTI:
                    this.dgg = R.drawable.new_pic_emotion_05;
                    break;
                case SINGALL:
                    this.dgg = R.drawable.new_pic_emotion_06;
                    break;
                case GIFT:
                    this.dgg = R.drawable.new_pic_emotion_07;
                    break;
                case WEBVIEW:
                    this.dgg = R.drawable.new_pic_emotion_08;
                    break;
                case NETERROR:
                    this.dgg = R.drawable.new_pic_emotion_08;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dfY.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.dfY.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.dgd.setVisibility(8);
            this.dgh.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.dgm;
        NoDataViewFactory.a aVar2 = bVar.dgn;
        if (aVar2 == null && aVar != null) {
            this.dgd.setOnClickListener(aVar.dgl);
            this.dgd.setText(aVar.mText);
            this.dgd.setVisibility(0);
            if (bVar.dgo >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dgd.getLayoutParams();
                layoutParams.topMargin = bVar.dgo;
                this.dgd.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.dge = (TBSpecificationBtn) this.dgh.findViewById(R.id.btn_left);
            this.dgf = (TBSpecificationBtn) this.dgh.findViewById(R.id.btn_right);
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            this.dge.setTextSize(R.dimen.ds32);
            this.dge.setConfig(bVar2);
            this.dgf.setTextSize(R.dimen.ds32);
            this.dgf.setConfig(bVar2);
            this.dge.setOnClickListener(aVar.dgl);
            this.dge.setText(aVar.mText);
            this.dgf.setOnClickListener(aVar2.dgl);
            this.dgf.setText(aVar2.mText);
            this.dgh.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void aHC() {
        this.dfY.setImageDrawable(null);
        this.dfY.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.dgc != null) {
            am.setViewTextColor(this.dgc, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.dgb != null) {
            am.setViewTextColor(this.dgb, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.dga != null) {
            am.setViewTextColor(this.dga, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = am.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.dgb.setCompoundDrawablePadding(dimens2);
        this.dgb.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.dgb != null) {
            this.dgb.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.dgb;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTitleContainerMargin(@DimenRes int i, @DimenRes int i2) {
        if (this.dfZ != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dfZ.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i2);
        }
    }
}
