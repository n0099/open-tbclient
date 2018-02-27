package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h extends LinearLayout {
    private TextView bbA;
    private TextView bbB;
    private TextView bbC;
    private TextView bbD;
    private TextView bbE;
    private TextView bbF;
    private String bbG;
    private String bbH;
    private View bbI;
    private NoDataViewFactory.ImgType bbJ;
    private int bbK;
    private TbImageView bbz;
    private Context mContext;
    private View mRootView;

    public h(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.no_data_view, this);
        this.bbz = (TbImageView) this.mRootView.findViewById(d.g.iv_no_data_img);
        this.bbz.setDefaultBgResource(0);
        this.bbz.setDefaultResource(0);
        this.bbz.setDefaultErrorResource(0);
        this.bbA = (TextView) this.mRootView.findViewById(d.g.tv_text_reamrk);
        this.bbB = (TextView) this.mRootView.findViewById(d.g.tv_subtitle);
        this.bbC = (TextView) this.mRootView.findViewById(d.g.tv_title);
        this.bbD = (TextView) this.mRootView.findViewById(d.g.btn_func);
        this.bbI = (LinearLayout) this.mRootView.findViewById(d.g.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().aQ(i == 1);
            ((TbPageContext) eVar).getLayoutMode().aM(this);
        }
        if (this.bbJ == NoDataViewFactory.ImgType.WEBVIEW) {
            this.bbz.setImageBitmap(aj.fQ(d.f.pic_emotion08));
        } else if (this.bbJ == NoDataViewFactory.ImgType.NODATA) {
            this.bbz.setImageBitmap(aj.fQ(d.f.no_data_image));
        } else if (this.bbJ == NoDataViewFactory.ImgType.LOCAL) {
            this.bbz.setImageBitmap(aj.fQ(this.bbK));
        } else if (i == 1) {
            this.bbz.startLoad(this.bbH, 29, false);
        } else {
            this.bbz.startLoad(this.bbG, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.bbC.setText(dVar.mTitle);
                this.bbC.setVisibility(0);
            } else {
                this.bbC.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.aLZ)) {
                this.bbB.setText(dVar.aLZ);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.bbB.setTextSize(0, getResources().getDimension(d.e.fontsize28));
                    if (dVar.bbU >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbB.getLayoutParams();
                        layoutParams.topMargin = dVar.bbU;
                        this.bbB.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.bbV != 0) {
                    setSubTitleCompoundDrawable(dVar.bbV);
                }
            } else {
                this.bbB.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.bbT)) {
                this.bbA.setText(dVar.bbT);
                this.bbA.setVisibility(0);
                return;
            }
            this.bbA.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.bbJ = cVar.bbQ;
            this.bbK = cVar.bbK;
            switch (cVar.bbQ) {
                case CREATE:
                    this.bbG = com.baidu.tbadk.util.b.OU().hf("pic_emotion03.png");
                    this.bbH = com.baidu.tbadk.util.b.OU().hf("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.bbG = com.baidu.tbadk.util.b.OU().hf("pic_emotion05.png");
                    this.bbH = com.baidu.tbadk.util.b.OU().hf("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.bbG = com.baidu.tbadk.util.b.OU().hf("pic_emotion01.png");
                    this.bbH = com.baidu.tbadk.util.b.OU().hf("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.bbG = com.baidu.tbadk.util.b.OU().hf("pic_emotion02.png");
                    this.bbH = com.baidu.tbadk.util.b.OU().hf("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.bbG = com.baidu.tbadk.util.b.OU().hf("pic_emotion07.png");
                    this.bbH = com.baidu.tbadk.util.b.OU().hf("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.bbG = com.baidu.tbadk.util.b.OU().hf("pic_emotion06.png");
                    this.bbH = com.baidu.tbadk.util.b.OU().hf("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.bbG = com.baidu.tbadk.util.b.OU().hf("pic_emotion08.png");
                    this.bbH = com.baidu.tbadk.util.b.OU().hf("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbz.getLayoutParams();
            if (cVar.bbR >= 0) {
                layoutParams.setMargins(0, cVar.bbR, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.bbz.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.bbD.setVisibility(8);
            this.bbI.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.bbN;
        NoDataViewFactory.a aVar2 = bVar.bbO;
        if (aVar2 == null && aVar != null) {
            this.bbD.setOnClickListener(aVar.bbM);
            this.bbD.setText(aVar.aUL);
            this.bbD.setVisibility(0);
            if (bVar.bbP >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbD.getLayoutParams();
                layoutParams.topMargin = bVar.bbP;
                this.bbD.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.bbE = (TextView) this.bbI.findViewById(d.g.btn_left);
            this.bbF = (TextView) this.bbI.findViewById(d.g.btn_right);
            this.bbE.setOnClickListener(aVar.bbM);
            this.bbE.setText(aVar.aUL);
            this.bbF.setOnClickListener(aVar2.bbM);
            this.bbF.setText(aVar2.aUL);
            this.bbI.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.bbz.setImageDrawable(null);
        this.bbz.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.bbC != null) {
            aj.e(this.bbC, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.bbB != null) {
            aj.e(this.bbB, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.bbA != null) {
            aj.e(this.bbA, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = aj.getDrawable(i);
        int t = com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds32);
        int t2 = com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds8);
        drawable.setBounds(0, 0, t, t);
        this.bbB.setCompoundDrawablePadding(t2);
        this.bbB.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.bbB;
    }
}
