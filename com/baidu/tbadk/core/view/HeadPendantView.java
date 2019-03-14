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
    private TbImageView bPr;
    private TbImageView bPs;
    private HeadImageView bPt;
    private boolean bPu;
    private boolean bPv;
    private int bPw;
    private int bPx;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bPu = false;
        this.bPv = false;
        this.bPw = d.f.pic_v_avatar;
        this.bPx = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), d.e.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bPu = false;
        this.bPv = false;
        this.bPw = d.f.pic_v_avatar;
        this.bPx = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), d.e.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.bPu = false;
        this.bPv = false;
        this.bPw = d.f.pic_v_avatar;
        this.bPx = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), d.e.tbds42);
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.bPu = true;
    }

    public void setHasPendantStyle(boolean z) {
        this.bPu = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.bPu) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.bPt.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.bPs != null) {
                ((RelativeLayout.LayoutParams) this.bPs.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        super.onMeasure(i, i2);
    }

    public void nm(String str) {
        if (this.bPr != null) {
            if (this.bPu && !StringUtils.isNull(str)) {
                this.bPv = true;
                this.bPr.setVisibility(0);
                this.bPr.setImageDrawable(null);
                this.bPr.startLoad(str, 10, false);
                return;
            }
            this.bPr.setVisibility(8);
            this.bPv = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.bPr.setAutoChangeStyle(z);
        this.bPt.setAutoChangeStyle(z);
        this.bPs.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.bPx = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds42);
        ael();
        aem();
        aen();
    }

    private void ael() {
        this.bPt = new HeadImageView(this.mContext);
        this.bPt.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.bPt.setDefaultResource(d.C0277d.cp_bg_line_e);
        this.bPt.setDefaultErrorResource(d.f.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.bPt.setLayoutParams(layoutParams);
        addView(this.bPt);
    }

    private void aem() {
        this.bPr = new TbImageView(this.mContext);
        this.bPr.setPageId(this.mPageId);
        this.bPr.setDefaultBgResource(0);
        this.bPr.setDefaultResource(0);
        this.bPr.setDefaultErrorResource(0);
        this.bPr.setImageDrawable(null);
        this.bPr.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.bPr.setVisibility(8);
        addView(this.bPr);
    }

    private void aen() {
        this.bPs = new TbImageView(this.mContext);
        this.bPs.setPageId(this.mPageId);
        this.bPs.setDefaultBgResource(0);
        this.bPs.setDefaultResource(0);
        this.bPs.setDefaultErrorResource(0);
        this.bPs.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bPx, this.bPx);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.bPs.setLayoutParams(layoutParams);
        this.bPs.setVisibility(8);
        addView(this.bPs);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.bPt != null) {
            this.bPt.setPageId(bdUniqueId);
        }
        if (this.bPr != null) {
            this.bPr.setPageId(bdUniqueId);
        }
        if (this.bPs != null) {
            this.bPs.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.bPr;
    }

    public HeadImageView getHeadView() {
        return this.bPt;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.bPx = com.baidu.adp.lib.util.l.h(getContext(), i);
        }
        aeo();
    }

    private void aeo() {
        if (this.bPx > 0 && this.bPs != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bPs.getLayoutParams();
            layoutParams.width = this.bPx;
            layoutParams.height = this.bPx;
            this.bPs.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.bPw = i;
    }

    public void aF(boolean z) {
        if (this.bPs != null) {
            if (z) {
                this.bPs.setImageDrawable(al.getDrawable(this.bPw));
                this.bPs.setVisibility(0);
                return;
            }
            this.bPs.setVisibility(8);
        }
    }

    public void setUrl(String str) {
        this.bPt.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.bPt.setDefaultResource(i);
    }

    public void a(MetaData metaData, int i, int i2) {
        if (metaData != null && metaData.getPendantData() != null && !TextUtils.isEmpty(metaData.getPendantData().Xn())) {
            setHasPendantStyle(true);
            setBigVDimenSize(i2);
        } else {
            setHasPendantStyle(false);
            setBigVDimenSize(i);
        }
        a(metaData);
    }

    public void nn(String str) {
        if (!StringUtils.isNull(str)) {
            String ms = o.ms(str);
            this.bPt.setImageBitmap(null);
            this.bPt.setUrl(ms);
            if (ms.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(ms, 10, false);
            } else {
                startLoad(ms, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.bPt.startLoad(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String ms = o.ms(metaData.getPortrait());
            setUrl(ms);
            if (ms.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(ms, 10, false);
            } else {
                startLoad(ms, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                nm(metaData.getPendantData().Xn());
            }
            c(metaData);
        }
    }

    public void c(MetaData metaData) {
        if (metaData != null) {
            this.bPt.setShowV(false);
            if (metaData.isBigV() || !StringUtils.isNull(metaData.getUserTbVipInfoData().getvipV_url())) {
                aF(true);
            } else {
                aF(false);
            }
        }
    }
}
