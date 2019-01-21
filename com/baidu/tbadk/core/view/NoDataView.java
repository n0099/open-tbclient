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
    private TbImageView aIf;
    private TextView aIg;
    private TextView aIh;
    private TextView aIi;
    private TextView aIj;
    private TextView aIk;
    private TextView aIl;
    private String aIm;
    private String aIn;
    private View aIo;
    private NoDataViewFactory.ImgType aIp;
    private int aIq;
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
        this.aIf = (TbImageView) this.mRootView.findViewById(e.g.iv_no_data_img);
        this.aIf.setDefaultBgResource(0);
        this.aIf.setDefaultResource(0);
        this.aIf.setDefaultErrorResource(0);
        this.aIg = (TextView) this.mRootView.findViewById(e.g.tv_text_reamrk);
        this.aIh = (TextView) this.mRootView.findViewById(e.g.tv_subtitle);
        this.aIi = (TextView) this.mRootView.findViewById(e.g.tv_title);
        this.aIj = (TextView) this.mRootView.findViewById(e.g.btn_func);
        this.aIo = (LinearLayout) this.mRootView.findViewById(e.g.two_button_layout);
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
        if (this.aIp == NoDataViewFactory.ImgType.WEBVIEW) {
            this.aIf.setImageBitmap(al.dQ(e.f.pic_emotion08));
        } else if (this.aIp == NoDataViewFactory.ImgType.NODATA) {
            this.aIf.setImageBitmap(al.dQ(e.f.no_data_image));
        } else if (this.aIp == NoDataViewFactory.ImgType.LOCAL) {
            this.aIf.setImageBitmap(al.dQ(this.aIq));
        } else if (this.aIp == NoDataViewFactory.ImgType.ANTI) {
            this.aIf.setImageBitmap(al.dQ(e.f.pic_emotion05));
        } else if (i == 1) {
            this.aIf.startLoad(this.aIn, 29, false);
        } else {
            this.aIf.startLoad(this.aIm, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.aIi.setText(dVar.mTitle);
                this.aIi.setVisibility(0);
            } else {
                this.aIi.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.aru)) {
                this.aIh.setText(dVar.aru);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.aIh.setTextSize(0, getResources().getDimension(e.C0210e.fontsize28));
                    if (dVar.aIy >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aIh.getLayoutParams();
                        layoutParams.topMargin = dVar.aIy;
                        this.aIh.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.aIz != 0) {
                    setSubTitleCompoundDrawable(dVar.aIz);
                }
            } else {
                this.aIh.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.aIx)) {
                this.aIg.setText(dVar.aIx);
                this.aIg.setVisibility(0);
                return;
            }
            this.aIg.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.aIp = cVar.aIw;
            this.aIq = cVar.aIq;
            switch (cVar.aIw) {
                case CREATE:
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion03.png");
                    this.aIn = com.baidu.tbadk.util.c.Qf().iN("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion05.png");
                    this.aIn = com.baidu.tbadk.util.c.Qf().iN("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion01.png");
                    this.aIn = com.baidu.tbadk.util.c.Qf().iN("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion02.png");
                    this.aIn = com.baidu.tbadk.util.c.Qf().iN("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion07.png");
                    this.aIn = com.baidu.tbadk.util.c.Qf().iN("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion06.png");
                    this.aIn = com.baidu.tbadk.util.c.Qf().iN("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion08.png");
                    this.aIn = com.baidu.tbadk.util.c.Qf().iN("pic_emotion08_1.png");
                    break;
                case ANTI:
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion05.png");
                    this.aIn = com.baidu.tbadk.util.c.Qf().iN("pic_emotion05_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aIf.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.aIf.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.aIj.setVisibility(8);
            this.aIo.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.aIt;
        NoDataViewFactory.a aVar2 = bVar.aIu;
        if (aVar2 == null && aVar != null) {
            this.aIj.setOnClickListener(aVar.aIs);
            this.aIj.setText(aVar.mText);
            this.aIj.setVisibility(0);
            if (bVar.aIv >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aIj.getLayoutParams();
                layoutParams.topMargin = bVar.aIv;
                this.aIj.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.aIk = (TextView) this.aIo.findViewById(e.g.btn_left);
            this.aIl = (TextView) this.aIo.findViewById(e.g.btn_right);
            this.aIk.setOnClickListener(aVar.aIs);
            this.aIk.setText(aVar.mText);
            this.aIl.setOnClickListener(aVar2.aIs);
            this.aIl.setText(aVar2.mText);
            this.aIo.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.aIf.setImageDrawable(null);
        this.aIf.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.aIi != null) {
            al.c(this.aIi, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.aIh != null) {
            al.c(this.aIh, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.aIg != null) {
            al.c(this.aIg, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = al.getDrawable(i);
        int h = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds32);
        int h2 = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds8);
        drawable.setBounds(0, 0, h, h);
        this.aIh.setCompoundDrawablePadding(h2);
        this.aIh.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.aIi != null) {
            this.aIi.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.aIh;
    }
}
