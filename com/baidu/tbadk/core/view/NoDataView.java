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
    private TbImageView dgl;
    private LinearLayout dgm;
    private TextView dgn;
    private TextView dgo;
    private TextView dgp;
    private TBSpecificationBtn dgq;
    private TBSpecificationBtn dgr;
    private TBSpecificationBtn dgs;
    private int dgt;
    private View dgu;
    private NoDataViewFactory.ImgType dgv;
    private int dgw;
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
        this.dgl = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.dgl.setDefaultBgResource(0);
        this.dgl.setDefaultResource(0);
        this.dgl.setDefaultErrorResource(0);
        this.dgm = (LinearLayout) this.mRootView.findViewById(R.id.title_container);
        this.dgn = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.dgo = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.dgp = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.dgq = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_func);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.dgq.setTextSize(R.dimen.tbds42);
        this.dgq.setConfig(bVar);
        this.dgu = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        aHF();
    }

    private void aHF() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.dgl.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.dgl.setLayoutParams(marginLayoutParams);
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
        if (this.dgq != null) {
            this.dgq.aHS();
        }
        if (this.dgr != null) {
            this.dgr.aHS();
        }
        if (this.dgs != null) {
            this.dgs.aHS();
        }
        if (this.dgv == NoDataViewFactory.ImgType.WEBVIEW) {
            this.dgl.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.dgv == NoDataViewFactory.ImgType.NODATA) {
            this.dgl.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.dgv == NoDataViewFactory.ImgType.LOCAL) {
            this.dgl.setImageBitmap(am.getBitmap565Quality(this.dgw));
        } else if (this.dgv == NoDataViewFactory.ImgType.ANTI) {
            this.dgl.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.dgv == NoDataViewFactory.ImgType.NETERROR) {
            this.dgl.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else {
            this.dgl.setImageBitmap(am.getBitmap565Quality(this.dgt));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.dgp.setText(dVar.mTitle);
                this.dgp.setVisibility(0);
            } else {
                this.dgp.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.dgo.setVisibility(0);
                this.dgo.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.dgE >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dgo.getLayoutParams();
                    layoutParams.topMargin = dVar.dgE;
                    this.dgo.setLayoutParams(layoutParams);
                }
                if (dVar.mDrawableId != 0) {
                    setSubTitleCompoundDrawable(dVar.mDrawableId);
                }
            } else {
                this.dgo.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.dgD)) {
                this.dgn.setText(dVar.dgD);
                this.dgn.setVisibility(0);
                return;
            }
            this.dgn.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.dgv = cVar.dgC;
            this.dgw = cVar.dgw;
            switch (cVar.dgC) {
                case FINDBAR:
                    this.dgt = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.dgt = R.drawable.new_pic_emotion_02;
                    break;
                case CREATE:
                    this.dgt = R.drawable.new_pic_emotion_03;
                    break;
                case COLLECTION:
                    this.dgt = R.drawable.new_pic_emotion_04;
                    break;
                case NODATA:
                    this.dgt = R.drawable.new_pic_emotion_05;
                    break;
                case ANTI:
                    this.dgt = R.drawable.new_pic_emotion_05;
                    break;
                case SINGALL:
                    this.dgt = R.drawable.new_pic_emotion_06;
                    break;
                case GIFT:
                    this.dgt = R.drawable.new_pic_emotion_07;
                    break;
                case WEBVIEW:
                    this.dgt = R.drawable.new_pic_emotion_08;
                    break;
                case NETERROR:
                    this.dgt = R.drawable.new_pic_emotion_08;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dgl.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.dgl.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.dgq.setVisibility(8);
            this.dgu.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.dgz;
        NoDataViewFactory.a aVar2 = bVar.dgA;
        if (aVar2 == null && aVar != null) {
            this.dgq.setOnClickListener(aVar.dgy);
            this.dgq.setText(aVar.mText);
            this.dgq.setVisibility(0);
            if (bVar.dgB >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dgq.getLayoutParams();
                layoutParams.topMargin = bVar.dgB;
                this.dgq.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.dgr = (TBSpecificationBtn) this.dgu.findViewById(R.id.btn_left);
            this.dgs = (TBSpecificationBtn) this.dgu.findViewById(R.id.btn_right);
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            this.dgr.setTextSize(R.dimen.ds32);
            this.dgr.setConfig(bVar2);
            this.dgs.setTextSize(R.dimen.ds32);
            this.dgs.setConfig(bVar2);
            this.dgr.setOnClickListener(aVar.dgy);
            this.dgr.setText(aVar.mText);
            this.dgs.setOnClickListener(aVar2.dgy);
            this.dgs.setText(aVar2.mText);
            this.dgu.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void aHG() {
        this.dgl.setImageDrawable(null);
        this.dgl.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.dgp != null) {
            am.setViewTextColor(this.dgp, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.dgo != null) {
            am.setViewTextColor(this.dgo, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.dgn != null) {
            am.setViewTextColor(this.dgn, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = am.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.dgo.setCompoundDrawablePadding(dimens2);
        this.dgo.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.dgo != null) {
            this.dgo.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.dgo;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTitleContainerMargin(@DimenRes int i, @DimenRes int i2) {
        if (this.dgm != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dgm.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i2);
        }
    }
}
