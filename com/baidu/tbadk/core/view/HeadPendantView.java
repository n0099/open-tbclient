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
    private TbImageView bPt;
    private TbImageView bPu;
    private HeadImageView bPv;
    private boolean bPw;
    private boolean bPx;
    private int bPy;
    private int bPz;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bPw = false;
        this.bPx = false;
        this.bPy = d.f.pic_v_avatar;
        this.bPz = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), d.e.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bPw = false;
        this.bPx = false;
        this.bPy = d.f.pic_v_avatar;
        this.bPz = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), d.e.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.bPw = false;
        this.bPx = false;
        this.bPy = d.f.pic_v_avatar;
        this.bPz = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), d.e.tbds42);
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.bPw = true;
    }

    public void setHasPendantStyle(boolean z) {
        this.bPw = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.bPw) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.bPv.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.bPu != null) {
                ((RelativeLayout.LayoutParams) this.bPu.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        super.onMeasure(i, i2);
    }

    public void nn(String str) {
        if (this.bPt != null) {
            if (this.bPw && !StringUtils.isNull(str)) {
                this.bPx = true;
                this.bPt.setVisibility(0);
                this.bPt.setImageDrawable(null);
                this.bPt.startLoad(str, 10, false);
                return;
            }
            this.bPt.setVisibility(8);
            this.bPx = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.bPt.setAutoChangeStyle(z);
        this.bPv.setAutoChangeStyle(z);
        this.bPu.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.bPz = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds42);
        aei();
        aej();
        aek();
    }

    private void aei() {
        this.bPv = new HeadImageView(this.mContext);
        this.bPv.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.bPv.setDefaultResource(d.C0277d.cp_bg_line_e);
        this.bPv.setDefaultErrorResource(d.f.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.bPv.setLayoutParams(layoutParams);
        addView(this.bPv);
    }

    private void aej() {
        this.bPt = new TbImageView(this.mContext);
        this.bPt.setPageId(this.mPageId);
        this.bPt.setDefaultBgResource(0);
        this.bPt.setDefaultResource(0);
        this.bPt.setDefaultErrorResource(0);
        this.bPt.setImageDrawable(null);
        this.bPt.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.bPt.setVisibility(8);
        addView(this.bPt);
    }

    private void aek() {
        this.bPu = new TbImageView(this.mContext);
        this.bPu.setPageId(this.mPageId);
        this.bPu.setDefaultBgResource(0);
        this.bPu.setDefaultResource(0);
        this.bPu.setDefaultErrorResource(0);
        this.bPu.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bPz, this.bPz);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.bPu.setLayoutParams(layoutParams);
        this.bPu.setVisibility(8);
        addView(this.bPu);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.bPv != null) {
            this.bPv.setPageId(bdUniqueId);
        }
        if (this.bPt != null) {
            this.bPt.setPageId(bdUniqueId);
        }
        if (this.bPu != null) {
            this.bPu.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.bPt;
    }

    public HeadImageView getHeadView() {
        return this.bPv;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.bPz = com.baidu.adp.lib.util.l.h(getContext(), i);
        }
        ael();
    }

    private void ael() {
        if (this.bPz > 0 && this.bPu != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bPu.getLayoutParams();
            layoutParams.width = this.bPz;
            layoutParams.height = this.bPz;
            this.bPu.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.bPy = i;
    }

    public void aF(boolean z) {
        if (this.bPu != null) {
            if (z) {
                this.bPu.setImageDrawable(al.getDrawable(this.bPy));
                this.bPu.setVisibility(0);
                return;
            }
            this.bPu.setVisibility(8);
        }
    }

    public void setUrl(String str) {
        this.bPv.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.bPv.setDefaultResource(i);
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
            this.bPv.setImageBitmap(null);
            this.bPv.setUrl(mt);
            if (mt.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(mt, 10, false);
            } else {
                startLoad(mt, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.bPv.startLoad(str, i, 0, 0, z);
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
            this.bPv.setShowV(false);
            if (metaData.isBigV() || !StringUtils.isNull(metaData.getUserTbVipInfoData().getvipV_url())) {
                aF(true);
            } else {
                aF(false);
            }
        }
    }
}
