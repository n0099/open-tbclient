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
    private TbImageView aZS;
    private TextView aZT;
    private TextView aZU;
    private TextView aZV;
    private TextView aZW;
    private TextView aZX;
    private TextView aZY;
    private String aZZ;
    private String baa;
    private View bab;
    private NoDataViewFactory.ImgType bac;
    private int bad;
    private Context mContext;
    private View mRootView;

    public h(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.no_data_view, this);
        this.aZS = (TbImageView) this.mRootView.findViewById(d.g.iv_no_data_img);
        this.aZS.setDefaultBgResource(0);
        this.aZS.setDefaultResource(0);
        this.aZS.setDefaultErrorResource(0);
        this.aZT = (TextView) this.mRootView.findViewById(d.g.tv_text_reamrk);
        this.aZU = (TextView) this.mRootView.findViewById(d.g.tv_subtitle);
        this.aZV = (TextView) this.mRootView.findViewById(d.g.tv_title);
        this.aZW = (TextView) this.mRootView.findViewById(d.g.btn_func);
        this.bab = (LinearLayout) this.mRootView.findViewById(d.g.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().aN(i == 1);
            ((TbPageContext) eVar).getLayoutMode().aM(this);
        }
        if (this.bac == NoDataViewFactory.ImgType.WEBVIEW) {
            this.aZS.setImageBitmap(aj.fQ(d.f.pic_emotion08));
        } else if (this.bac == NoDataViewFactory.ImgType.NODATA) {
            this.aZS.setImageBitmap(aj.fQ(d.f.no_data_image));
        } else if (this.bac == NoDataViewFactory.ImgType.LOCAL) {
            this.aZS.setImageBitmap(aj.fQ(this.bad));
        } else if (i == 1) {
            this.aZS.startLoad(this.baa, 29, false);
        } else {
            this.aZS.startLoad(this.aZZ, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.aZV.setText(dVar.mTitle);
                this.aZV.setVisibility(0);
            } else {
                this.aZV.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.aKQ)) {
                this.aZU.setText(dVar.aKQ);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.aZU.setTextSize(0, getResources().getDimension(d.e.fontsize28));
                    if (dVar.ban >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aZU.getLayoutParams();
                        layoutParams.topMargin = dVar.ban;
                        this.aZU.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.bao != 0) {
                    setSubTitleCompoundDrawable(dVar.bao);
                }
            } else {
                this.aZU.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.bam)) {
                this.aZT.setText(dVar.bam);
                this.aZT.setVisibility(0);
                return;
            }
            this.aZT.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.bac = cVar.baj;
            this.bad = cVar.bad;
            switch (cVar.baj) {
                case CREATE:
                    this.aZZ = com.baidu.tbadk.util.b.Oq().gW("pic_emotion03.png");
                    this.baa = com.baidu.tbadk.util.b.Oq().gW("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.aZZ = com.baidu.tbadk.util.b.Oq().gW("pic_emotion05.png");
                    this.baa = com.baidu.tbadk.util.b.Oq().gW("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.aZZ = com.baidu.tbadk.util.b.Oq().gW("pic_emotion01.png");
                    this.baa = com.baidu.tbadk.util.b.Oq().gW("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.aZZ = com.baidu.tbadk.util.b.Oq().gW("pic_emotion02.png");
                    this.baa = com.baidu.tbadk.util.b.Oq().gW("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.aZZ = com.baidu.tbadk.util.b.Oq().gW("pic_emotion07.png");
                    this.baa = com.baidu.tbadk.util.b.Oq().gW("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.aZZ = com.baidu.tbadk.util.b.Oq().gW("pic_emotion06.png");
                    this.baa = com.baidu.tbadk.util.b.Oq().gW("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.aZZ = com.baidu.tbadk.util.b.Oq().gW("pic_emotion08.png");
                    this.baa = com.baidu.tbadk.util.b.Oq().gW("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aZS.getLayoutParams();
            if (cVar.bak >= 0) {
                layoutParams.setMargins(0, cVar.bak, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.aZS.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.aZW.setVisibility(8);
            this.bab.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.bag;
        NoDataViewFactory.a aVar2 = bVar.bah;
        if (aVar2 == null && aVar != null) {
            this.aZW.setOnClickListener(aVar.baf);
            this.aZW.setText(aVar.aTs);
            this.aZW.setVisibility(0);
            if (bVar.bai >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aZW.getLayoutParams();
                layoutParams.topMargin = bVar.bai;
                this.aZW.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.aZX = (TextView) this.bab.findViewById(d.g.btn_left);
            this.aZY = (TextView) this.bab.findViewById(d.g.btn_right);
            this.aZX.setOnClickListener(aVar.baf);
            this.aZX.setText(aVar.aTs);
            this.aZY.setOnClickListener(aVar2.baf);
            this.aZY.setText(aVar2.aTs);
            this.bab.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.aZS.setImageDrawable(null);
        this.aZS.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.aZV != null) {
            aj.e(this.aZV, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.aZU != null) {
            aj.e(this.aZU, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.aZT != null) {
            aj.e(this.aZT, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = aj.getDrawable(i);
        int s = com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds32);
        int s2 = com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds8);
        drawable.setBounds(0, 0, s, s);
        this.aZU.setCompoundDrawablePadding(s2);
        this.aZU.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.aZU;
    }
}
