package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantView extends RelativeLayout {
    private int bPA;
    private TbImageView bPu;
    private TbImageView bPv;
    private HeadImageView bPw;
    private boolean bPx;
    private boolean bPy;
    private int bPz;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bPx = false;
        this.bPy = false;
        this.bPz = d.f.pic_v_avatar;
        this.bPA = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), d.e.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bPx = false;
        this.bPy = false;
        this.bPz = d.f.pic_v_avatar;
        this.bPA = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), d.e.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.bPx = false;
        this.bPy = false;
        this.bPz = d.f.pic_v_avatar;
        this.bPA = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), d.e.tbds42);
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.bPx = true;
    }

    public void setHasPendantStyle(boolean z) {
        this.bPx = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.bPx) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.bPw.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.bPv != null) {
                ((RelativeLayout.LayoutParams) this.bPv.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        super.onMeasure(i, i2);
    }

    public void nn(String str) {
        if (this.bPu != null) {
            if (this.bPx && !StringUtils.isNull(str)) {
                this.bPy = true;
                this.bPu.setVisibility(0);
                this.bPu.setImageDrawable(null);
                this.bPu.startLoad(str, 10, false);
                return;
            }
            this.bPu.setVisibility(8);
            this.bPy = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.bPu.setAutoChangeStyle(z);
        this.bPw.setAutoChangeStyle(z);
        this.bPv.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.bPA = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds42);
        aei();
        aej();
        aek();
    }

    private void aei() {
        this.bPw = new HeadImageView(this.mContext);
        this.bPw.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.bPw.setDefaultResource(d.C0277d.cp_bg_line_e);
        this.bPw.setDefaultErrorResource(d.f.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.bPw.setLayoutParams(layoutParams);
        addView(this.bPw);
    }

    private void aej() {
        this.bPu = new TbImageView(this.mContext);
        this.bPu.setPageId(this.mPageId);
        this.bPu.setDefaultBgResource(0);
        this.bPu.setDefaultResource(0);
        this.bPu.setDefaultErrorResource(0);
        this.bPu.setImageDrawable(null);
        this.bPu.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.bPu.setVisibility(8);
        addView(this.bPu);
    }

    private void aek() {
        this.bPv = new TbImageView(this.mContext);
        this.bPv.setPageId(this.mPageId);
        this.bPv.setDefaultBgResource(0);
        this.bPv.setDefaultResource(0);
        this.bPv.setDefaultErrorResource(0);
        this.bPv.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bPA, this.bPA);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.bPv.setLayoutParams(layoutParams);
        this.bPv.setVisibility(8);
        addView(this.bPv);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.bPw != null) {
            this.bPw.setPageId(bdUniqueId);
        }
        if (this.bPu != null) {
            this.bPu.setPageId(bdUniqueId);
        }
        if (this.bPv != null) {
            this.bPv.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.bPu;
    }

    public HeadImageView getHeadView() {
        return this.bPw;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.bPA = com.baidu.adp.lib.util.l.h(getContext(), i);
        }
        ael();
    }

    private void ael() {
        if (this.bPA > 0 && this.bPv != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bPv.getLayoutParams();
            layoutParams.width = this.bPA;
            layoutParams.height = this.bPA;
            this.bPv.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.bPz = i;
    }

    public void aF(boolean z) {
        if (this.bPv != null) {
            if (z) {
                this.bPv.setImageDrawable(al.getDrawable(this.bPz));
                this.bPv.setVisibility(0);
                return;
            }
            this.bPv.setVisibility(8);
        }
    }

    public void setUrl(String str) {
        this.bPw.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.bPw.setDefaultResource(i);
    }

    public void a(MetaData metaData, int i, int i2) {
        if (metaData != null && metaData.getPendantData() != null && !TextUtils.isEmpty(metaData.getPendantData().Xk())) {
            setHasPendantStyle(true);
            setBigVDimenSize(i2);
        } else {
            setHasPendantStyle(false);
            setBigVDimenSize(i);
        }
        a(metaData);
    }

    public void no(String str) {
        if (!StringUtils.isNull(str)) {
            String mt = o.mt(str);
            this.bPw.setImageBitmap(null);
            this.bPw.setUrl(mt);
            if (mt.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(mt, 10, false);
            } else {
                startLoad(mt, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.bPw.startLoad(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String mt = o.mt(metaData.getPortrait());
            setUrl(mt);
            if (mt.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(mt, 10, false);
            } else {
                startLoad(mt, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                nn(metaData.getPendantData().Xk());
            }
            c(metaData);
        }
    }

    public void c(MetaData metaData) {
        if (metaData != null) {
            this.bPw.setShowV(false);
            if (metaData.isBigV() || !StringUtils.isNull(metaData.getUserTbVipInfoData().getvipV_url())) {
                aF(true);
            } else {
                aF(false);
            }
        }
    }
}
