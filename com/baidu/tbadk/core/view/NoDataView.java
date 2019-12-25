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
    private TBSpecificationBtn dbA;
    private TBSpecificationBtn dbB;
    private int dbC;
    private View dbD;
    private NoDataViewFactory.ImgType dbE;
    private int dbF;
    private TbImageView dbu;
    private LinearLayout dbv;
    private TextView dbw;
    private TextView dbx;
    private TextView dby;
    private TBSpecificationBtn dbz;
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
        this.dbu = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.dbu.setDefaultBgResource(0);
        this.dbu.setDefaultResource(0);
        this.dbu.setDefaultErrorResource(0);
        this.dbv = (LinearLayout) this.mRootView.findViewById(R.id.title_container);
        this.dbw = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.dbx = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.dby = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.dbz = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_func);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.dbz.setTextSize(R.dimen.tbds42);
        this.dbz.setConfig(bVar);
        this.dbD = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        aET();
    }

    private void aET() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.dbu.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.dbu.setLayoutParams(marginLayoutParams);
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
        if (this.dbz != null) {
            this.dbz.aFd();
        }
        if (this.dbA != null) {
            this.dbA.aFd();
        }
        if (this.dbB != null) {
            this.dbB.aFd();
        }
        if (this.dbE == NoDataViewFactory.ImgType.WEBVIEW) {
            this.dbu.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.dbE == NoDataViewFactory.ImgType.NODATA) {
            this.dbu.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.dbE == NoDataViewFactory.ImgType.LOCAL) {
            this.dbu.setImageBitmap(am.getBitmap565Quality(this.dbF));
        } else if (this.dbE == NoDataViewFactory.ImgType.ANTI) {
            this.dbu.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.dbE == NoDataViewFactory.ImgType.NETERROR) {
            this.dbu.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else {
            this.dbu.setImageBitmap(am.getBitmap565Quality(this.dbC));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.dby.setText(dVar.mTitle);
                this.dby.setVisibility(0);
            } else {
                this.dby.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.dbx.setVisibility(0);
                this.dbx.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.dbN >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dbx.getLayoutParams();
                    layoutParams.topMargin = dVar.dbN;
                    this.dbx.setLayoutParams(layoutParams);
                }
                if (dVar.dbO != 0) {
                    setSubTitleCompoundDrawable(dVar.dbO);
                }
            } else {
                this.dbx.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.dbM)) {
                this.dbw.setText(dVar.dbM);
                this.dbw.setVisibility(0);
                return;
            }
            this.dbw.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.dbE = cVar.dbL;
            this.dbF = cVar.dbF;
            switch (cVar.dbL) {
                case FINDBAR:
                    this.dbC = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.dbC = R.drawable.new_pic_emotion_02;
                    break;
                case CREATE:
                    this.dbC = R.drawable.new_pic_emotion_03;
                    break;
                case COLLECTION:
                    this.dbC = R.drawable.new_pic_emotion_04;
                    break;
                case NODATA:
                    this.dbC = R.drawable.new_pic_emotion_05;
                    break;
                case ANTI:
                    this.dbC = R.drawable.new_pic_emotion_05;
                    break;
                case SINGALL:
                    this.dbC = R.drawable.new_pic_emotion_06;
                    break;
                case GIFT:
                    this.dbC = R.drawable.new_pic_emotion_07;
                    break;
                case WEBVIEW:
                    this.dbC = R.drawable.new_pic_emotion_08;
                    break;
                case NETERROR:
                    this.dbC = R.drawable.new_pic_emotion_08;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dbu.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.dbu.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.dbz.setVisibility(8);
            this.dbD.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.dbI;
        NoDataViewFactory.a aVar2 = bVar.dbJ;
        if (aVar2 == null && aVar != null) {
            this.dbz.setOnClickListener(aVar.dbH);
            this.dbz.setText(aVar.mText);
            this.dbz.setVisibility(0);
            if (bVar.dbK >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dbz.getLayoutParams();
                layoutParams.topMargin = bVar.dbK;
                this.dbz.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.dbA = (TBSpecificationBtn) this.dbD.findViewById(R.id.btn_left);
            this.dbB = (TBSpecificationBtn) this.dbD.findViewById(R.id.btn_right);
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            this.dbA.setTextSize(R.dimen.ds32);
            this.dbA.setConfig(bVar2);
            this.dbB.setTextSize(R.dimen.ds32);
            this.dbB.setConfig(bVar2);
            this.dbA.setOnClickListener(aVar.dbH);
            this.dbA.setText(aVar.mText);
            this.dbB.setOnClickListener(aVar2.dbH);
            this.dbB.setText(aVar2.mText);
            this.dbD.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void aEU() {
        this.dbu.setImageDrawable(null);
        this.dbu.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.dby != null) {
            am.setViewTextColor(this.dby, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.dbx != null) {
            am.setViewTextColor(this.dbx, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.dbw != null) {
            am.setViewTextColor(this.dbw, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = am.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.dbx.setCompoundDrawablePadding(dimens2);
        this.dbx.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.dbx != null) {
            this.dbx.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.dbx;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTitleContainerMargin(@DimenRes int i, @DimenRes int i2) {
        if (this.dbv != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dbv.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i2);
        }
    }
}
