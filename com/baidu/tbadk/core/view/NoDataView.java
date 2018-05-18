package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class NoDataView extends LinearLayout {
    private TbImageView amV;
    private TextView amW;
    private TextView amX;
    private TextView amY;
    private TextView amZ;
    private TextView ana;
    private TextView anb;
    private String anc;
    private String and;
    private View ane;
    private NoDataViewFactory.ImgType anf;
    private int ang;
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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.no_data_view, this);
        this.amV = (TbImageView) this.mRootView.findViewById(d.g.iv_no_data_img);
        this.amV.setDefaultBgResource(0);
        this.amV.setDefaultResource(0);
        this.amV.setDefaultErrorResource(0);
        this.amW = (TextView) this.mRootView.findViewById(d.g.tv_text_reamrk);
        this.amX = (TextView) this.mRootView.findViewById(d.g.tv_subtitle);
        this.amY = (TextView) this.mRootView.findViewById(d.g.tv_title);
        this.amZ = (TextView) this.mRootView.findViewById(d.g.btn_func);
        this.ane = (LinearLayout) this.mRootView.findViewById(d.g.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().setNightMode(i == 1);
            ((TbPageContext) eVar).getLayoutMode().u(this);
        }
        if (this.anf == NoDataViewFactory.ImgType.WEBVIEW) {
            this.amV.setImageBitmap(ak.cQ(d.f.pic_emotion08));
        } else if (this.anf == NoDataViewFactory.ImgType.NODATA) {
            this.amV.setImageBitmap(ak.cQ(d.f.no_data_image));
        } else if (this.anf == NoDataViewFactory.ImgType.LOCAL) {
            this.amV.setImageBitmap(ak.cQ(this.ang));
        } else if (this.anf == NoDataViewFactory.ImgType.ANTI) {
            this.amV.setImageBitmap(ak.cQ(d.f.pic_emotion05));
        } else if (i == 1) {
            this.amV.startLoad(this.and, 29, false);
        } else {
            this.amV.startLoad(this.anc, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.amY.setText(dVar.mTitle);
                this.amY.setVisibility(0);
            } else {
                this.amY.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.Xw)) {
                this.amX.setText(dVar.Xw);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.amX.setTextSize(0, getResources().getDimension(d.e.fontsize28));
                    if (dVar.anp >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amX.getLayoutParams();
                        layoutParams.topMargin = dVar.anp;
                        this.amX.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.anq != 0) {
                    setSubTitleCompoundDrawable(dVar.anq);
                }
            } else {
                this.amX.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.ano)) {
                this.amW.setText(dVar.ano);
                this.amW.setVisibility(0);
                return;
            }
            this.amW.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.anf = cVar.anm;
            this.ang = cVar.ang;
            switch (cVar.anm) {
                case CREATE:
                    this.anc = com.baidu.tbadk.util.b.Hw().gX("pic_emotion03.png");
                    this.and = com.baidu.tbadk.util.b.Hw().gX("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.anc = com.baidu.tbadk.util.b.Hw().gX("pic_emotion05.png");
                    this.and = com.baidu.tbadk.util.b.Hw().gX("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.anc = com.baidu.tbadk.util.b.Hw().gX("pic_emotion01.png");
                    this.and = com.baidu.tbadk.util.b.Hw().gX("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.anc = com.baidu.tbadk.util.b.Hw().gX("pic_emotion02.png");
                    this.and = com.baidu.tbadk.util.b.Hw().gX("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.anc = com.baidu.tbadk.util.b.Hw().gX("pic_emotion07.png");
                    this.and = com.baidu.tbadk.util.b.Hw().gX("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.anc = com.baidu.tbadk.util.b.Hw().gX("pic_emotion06.png");
                    this.and = com.baidu.tbadk.util.b.Hw().gX("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.anc = com.baidu.tbadk.util.b.Hw().gX("pic_emotion08.png");
                    this.and = com.baidu.tbadk.util.b.Hw().gX("pic_emotion08_1.png");
                    break;
                case ANTI:
                    this.anc = com.baidu.tbadk.util.b.Hw().gX("pic_emotion05.png");
                    this.and = com.baidu.tbadk.util.b.Hw().gX("pic_emotion05_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amV.getLayoutParams();
            if (cVar.ann >= 0) {
                layoutParams.setMargins(0, cVar.ann, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.amV.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.amZ.setVisibility(8);
            this.ane.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.anj;
        NoDataViewFactory.a aVar2 = bVar.ank;
        if (aVar2 == null && aVar != null) {
            this.amZ.setOnClickListener(aVar.ani);
            this.amZ.setText(aVar.agh);
            this.amZ.setVisibility(0);
            if (bVar.anl >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amZ.getLayoutParams();
                layoutParams.topMargin = bVar.anl;
                this.amZ.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.ana = (TextView) this.ane.findViewById(d.g.btn_left);
            this.anb = (TextView) this.ane.findViewById(d.g.btn_right);
            this.ana.setOnClickListener(aVar.ani);
            this.ana.setText(aVar.agh);
            this.anb.setOnClickListener(aVar2.ani);
            this.anb.setText(aVar2.agh);
            this.ane.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.amV.setImageDrawable(null);
        this.amV.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.amY != null) {
            ak.c(this.amY, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.amX != null) {
            ak.c(this.amX, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.amW != null) {
            ak.c(this.amW, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = ak.getDrawable(i);
        int e = l.e(this.mContext, d.e.ds32);
        int e2 = l.e(this.mContext, d.e.ds8);
        drawable.setBounds(0, 0, e, e);
        this.amX.setCompoundDrawablePadding(e2);
        this.amX.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.amX;
    }
}
