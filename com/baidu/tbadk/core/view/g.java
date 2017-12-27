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
public class g extends LinearLayout {
    private TbImageView aZL;
    private TextView aZM;
    private TextView aZN;
    private TextView aZO;
    private TextView aZP;
    private TextView aZQ;
    private TextView aZR;
    private String aZS;
    private String aZT;
    private View aZU;
    private NoDataViewFactory.ImgType aZV;
    private int aZW;
    private Context mContext;
    private View mRootView;

    public g(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.no_data_view, this);
        this.aZL = (TbImageView) this.mRootView.findViewById(d.g.iv_no_data_img);
        this.aZL.setDefaultBgResource(0);
        this.aZL.setDefaultResource(0);
        this.aZL.setDefaultErrorResource(0);
        this.aZM = (TextView) this.mRootView.findViewById(d.g.tv_text_reamrk);
        this.aZN = (TextView) this.mRootView.findViewById(d.g.tv_subtitle);
        this.aZO = (TextView) this.mRootView.findViewById(d.g.tv_title);
        this.aZP = (TextView) this.mRootView.findViewById(d.g.btn_func);
        this.aZU = (LinearLayout) this.mRootView.findViewById(d.g.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().aM(i == 1);
            ((TbPageContext) eVar).getLayoutMode().aM(this);
        }
        if (this.aZV == NoDataViewFactory.ImgType.WEBVIEW) {
            this.aZL.setImageBitmap(aj.fS(d.f.pic_emotion08));
        } else if (this.aZV == NoDataViewFactory.ImgType.NODATA) {
            this.aZL.setImageBitmap(aj.fS(d.f.no_data_image));
        } else if (this.aZV == NoDataViewFactory.ImgType.LOCAL) {
            this.aZL.setImageBitmap(aj.fS(this.aZW));
        } else if (i == 1) {
            this.aZL.startLoad(this.aZT, 29, false);
        } else {
            this.aZL.startLoad(this.aZS, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.aZO.setText(dVar.mTitle);
                this.aZO.setVisibility(0);
            } else {
                this.aZO.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.aKP)) {
                this.aZN.setText(dVar.aKP);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.aZN.setTextSize(0, getResources().getDimension(d.e.fontsize28));
                    if (dVar.bag >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aZN.getLayoutParams();
                        layoutParams.topMargin = dVar.bag;
                        this.aZN.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.bah != 0) {
                    setSubTitleCompoundDrawable(dVar.bah);
                }
            } else {
                this.aZN.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.baf)) {
                this.aZM.setText(dVar.baf);
                this.aZM.setVisibility(0);
                return;
            }
            this.aZM.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.aZV = cVar.bac;
            this.aZW = cVar.aZW;
            switch (cVar.bac) {
                case CREATE:
                    this.aZS = com.baidu.tbadk.util.b.OA().gN("pic_emotion03.png");
                    this.aZT = com.baidu.tbadk.util.b.OA().gN("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.aZS = com.baidu.tbadk.util.b.OA().gN("pic_emotion05.png");
                    this.aZT = com.baidu.tbadk.util.b.OA().gN("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.aZS = com.baidu.tbadk.util.b.OA().gN("pic_emotion01.png");
                    this.aZT = com.baidu.tbadk.util.b.OA().gN("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.aZS = com.baidu.tbadk.util.b.OA().gN("pic_emotion02.png");
                    this.aZT = com.baidu.tbadk.util.b.OA().gN("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.aZS = com.baidu.tbadk.util.b.OA().gN("pic_emotion07.png");
                    this.aZT = com.baidu.tbadk.util.b.OA().gN("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.aZS = com.baidu.tbadk.util.b.OA().gN("pic_emotion06.png");
                    this.aZT = com.baidu.tbadk.util.b.OA().gN("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.aZS = com.baidu.tbadk.util.b.OA().gN("pic_emotion08.png");
                    this.aZT = com.baidu.tbadk.util.b.OA().gN("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aZL.getLayoutParams();
            if (cVar.bad >= 0) {
                layoutParams.setMargins(0, cVar.bad, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.aZL.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.aZP.setVisibility(8);
            this.aZU.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.aZZ;
        NoDataViewFactory.a aVar2 = bVar.baa;
        if (aVar2 == null && aVar != null) {
            this.aZP.setOnClickListener(aVar.aZY);
            this.aZP.setText(aVar.aTq);
            this.aZP.setVisibility(0);
            if (bVar.bab >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aZP.getLayoutParams();
                layoutParams.topMargin = bVar.bab;
                this.aZP.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.aZQ = (TextView) this.aZU.findViewById(d.g.btn_left);
            this.aZR = (TextView) this.aZU.findViewById(d.g.btn_right);
            this.aZQ.setOnClickListener(aVar.aZY);
            this.aZQ.setText(aVar.aTq);
            this.aZR.setOnClickListener(aVar2.aZY);
            this.aZR.setText(aVar2.aTq);
            this.aZU.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.aZL.setImageDrawable(null);
        this.aZL.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.aZO != null) {
            aj.e(this.aZO, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.aZN != null) {
            aj.e(this.aZN, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.aZM != null) {
            aj.e(this.aZM, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = aj.getDrawable(i);
        int s = com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds32);
        int s2 = com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds8);
        drawable.setBounds(0, 0, s, s);
        this.aZN.setCompoundDrawablePadding(s2);
        this.aZN.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.aZN;
    }
}
