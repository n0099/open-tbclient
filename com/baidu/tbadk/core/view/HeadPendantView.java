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
    private TbImageView bPq;
    private TbImageView bPr;
    private HeadImageView bPs;
    private boolean bPt;
    private boolean bPu;
    private int bPv;
    private int bPw;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bPt = false;
        this.bPu = false;
        this.bPv = d.f.pic_v_avatar;
        this.bPw = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), d.e.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bPt = false;
        this.bPu = false;
        this.bPv = d.f.pic_v_avatar;
        this.bPw = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), d.e.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.bPt = false;
        this.bPu = false;
        this.bPv = d.f.pic_v_avatar;
        this.bPw = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), d.e.tbds42);
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.bPt = true;
    }

    public void setHasPendantStyle(boolean z) {
        this.bPt = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.bPt) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.bPs.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.bPr != null) {
                ((RelativeLayout.LayoutParams) this.bPr.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        super.onMeasure(i, i2);
    }

    public void nm(String str) {
        if (this.bPq != null) {
            if (this.bPt && !StringUtils.isNull(str)) {
                this.bPu = true;
                this.bPq.setVisibility(0);
                this.bPq.setImageDrawable(null);
                this.bPq.startLoad(str, 10, false);
                return;
            }
            this.bPq.setVisibility(8);
            this.bPu = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.bPq.setAutoChangeStyle(z);
        this.bPs.setAutoChangeStyle(z);
        this.bPr.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.bPw = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds42);
        ael();
        aem();
        aen();
    }

    private void ael() {
        this.bPs = new HeadImageView(this.mContext);
        this.bPs.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.bPs.setDefaultResource(d.C0236d.cp_bg_line_e);
        this.bPs.setDefaultErrorResource(d.f.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.bPs.setLayoutParams(layoutParams);
        addView(this.bPs);
    }

    private void aem() {
        this.bPq = new TbImageView(this.mContext);
        this.bPq.setPageId(this.mPageId);
        this.bPq.setDefaultBgResource(0);
        this.bPq.setDefaultResource(0);
        this.bPq.setDefaultErrorResource(0);
        this.bPq.setImageDrawable(null);
        this.bPq.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.bPq.setVisibility(8);
        addView(this.bPq);
    }

    private void aen() {
        this.bPr = new TbImageView(this.mContext);
        this.bPr.setPageId(this.mPageId);
        this.bPr.setDefaultBgResource(0);
        this.bPr.setDefaultResource(0);
        this.bPr.setDefaultErrorResource(0);
        this.bPr.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bPw, this.bPw);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.bPr.setLayoutParams(layoutParams);
        this.bPr.setVisibility(8);
        addView(this.bPr);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.bPs != null) {
            this.bPs.setPageId(bdUniqueId);
        }
        if (this.bPq != null) {
            this.bPq.setPageId(bdUniqueId);
        }
        if (this.bPr != null) {
            this.bPr.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.bPq;
    }

    public HeadImageView getHeadView() {
        return this.bPs;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.bPw = com.baidu.adp.lib.util.l.h(getContext(), i);
        }
        aeo();
    }

    private void aeo() {
        if (this.bPw > 0 && this.bPr != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bPr.getLayoutParams();
            layoutParams.width = this.bPw;
            layoutParams.height = this.bPw;
            this.bPr.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.bPv = i;
    }

    public void aF(boolean z) {
        if (this.bPr != null) {
            if (z) {
                this.bPr.setImageDrawable(al.getDrawable(this.bPv));
                this.bPr.setVisibility(0);
                return;
            }
            this.bPr.setVisibility(8);
        }
    }

    public void setUrl(String str) {
        this.bPs.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.bPs.setDefaultResource(i);
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
            this.bPs.setImageBitmap(null);
            this.bPs.setUrl(ms);
            if (ms.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(ms, 10, false);
            } else {
                startLoad(ms, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.bPs.startLoad(str, i, 0, 0, z);
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
            this.bPs.setShowV(false);
            if (metaData.isBigV() || !StringUtils.isNull(metaData.getUserTbVipInfoData().getvipV_url())) {
                aF(true);
            } else {
                aF(false);
            }
        }
    }
}
