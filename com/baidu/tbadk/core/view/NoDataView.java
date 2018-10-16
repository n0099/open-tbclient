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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class NoDataView extends LinearLayout {
    private TbImageView aDl;
    private TextView aDm;
    private TextView aDn;
    private TextView aDo;
    private TextView aDp;
    private TextView aDq;
    private TextView aDr;
    private String aDs;
    private String aDt;
    private View aDu;
    private NoDataViewFactory.ImgType aDv;
    private int aDw;
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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.no_data_view, this);
        this.aDl = (TbImageView) this.mRootView.findViewById(e.g.iv_no_data_img);
        this.aDl.setDefaultBgResource(0);
        this.aDl.setDefaultResource(0);
        this.aDl.setDefaultErrorResource(0);
        this.aDm = (TextView) this.mRootView.findViewById(e.g.tv_text_reamrk);
        this.aDn = (TextView) this.mRootView.findViewById(e.g.tv_subtitle);
        this.aDo = (TextView) this.mRootView.findViewById(e.g.tv_title);
        this.aDp = (TextView) this.mRootView.findViewById(e.g.btn_func);
        this.aDu = (LinearLayout) this.mRootView.findViewById(e.g.two_button_layout);
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
        if (this.aDv == NoDataViewFactory.ImgType.WEBVIEW) {
            this.aDl.setImageBitmap(al.m17do(e.f.pic_emotion08));
        } else if (this.aDv == NoDataViewFactory.ImgType.NODATA) {
            this.aDl.setImageBitmap(al.m17do(e.f.no_data_image));
        } else if (this.aDv == NoDataViewFactory.ImgType.LOCAL) {
            this.aDl.setImageBitmap(al.m17do(this.aDw));
        } else if (this.aDv == NoDataViewFactory.ImgType.ANTI) {
            this.aDl.setImageBitmap(al.m17do(e.f.pic_emotion05));
        } else if (i == 1) {
            this.aDl.startLoad(this.aDt, 29, false);
        } else {
            this.aDl.startLoad(this.aDs, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.aDo.setText(dVar.mTitle);
                this.aDo.setVisibility(0);
            } else {
                this.aDo.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.amD)) {
                this.aDn.setText(dVar.amD);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.aDn.setTextSize(0, getResources().getDimension(e.C0175e.fontsize28));
                    if (dVar.aDE >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aDn.getLayoutParams();
                        layoutParams.topMargin = dVar.aDE;
                        this.aDn.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.aDF != 0) {
                    setSubTitleCompoundDrawable(dVar.aDF);
                }
            } else {
                this.aDn.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.aDD)) {
                this.aDm.setText(dVar.aDD);
                this.aDm.setVisibility(0);
                return;
            }
            this.aDm.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.aDv = cVar.aDC;
            this.aDw = cVar.aDw;
            switch (cVar.aDC) {
                case CREATE:
                    this.aDs = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion03.png");
                    this.aDt = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.aDs = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion05.png");
                    this.aDt = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.aDs = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion01.png");
                    this.aDt = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.aDs = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion02.png");
                    this.aDt = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.aDs = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion07.png");
                    this.aDt = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.aDs = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion06.png");
                    this.aDt = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.aDs = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion08.png");
                    this.aDt = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion08_1.png");
                    break;
                case ANTI:
                    this.aDs = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion05.png");
                    this.aDt = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion05_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aDl.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.aDl.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.aDp.setVisibility(8);
            this.aDu.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.aDz;
        NoDataViewFactory.a aVar2 = bVar.aDA;
        if (aVar2 == null && aVar != null) {
            this.aDp.setOnClickListener(aVar.aDy);
            this.aDp.setText(aVar.mText);
            this.aDp.setVisibility(0);
            if (bVar.aDB >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aDp.getLayoutParams();
                layoutParams.topMargin = bVar.aDB;
                this.aDp.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.aDq = (TextView) this.aDu.findViewById(e.g.btn_left);
            this.aDr = (TextView) this.aDu.findViewById(e.g.btn_right);
            this.aDq.setOnClickListener(aVar.aDy);
            this.aDq.setText(aVar.mText);
            this.aDr.setOnClickListener(aVar2.aDy);
            this.aDr.setText(aVar2.mText);
            this.aDu.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.aDl.setImageDrawable(null);
        this.aDl.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.aDo != null) {
            al.c(this.aDo, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.aDn != null) {
            al.c(this.aDn, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.aDm != null) {
            al.c(this.aDm, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = al.getDrawable(i);
        int h = com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds32);
        int h2 = com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds8);
        drawable.setBounds(0, 0, h, h);
        this.aDn.setCompoundDrawablePadding(h2);
        this.aDn.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.aDo != null) {
            this.aDo.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.aDn;
    }
}
