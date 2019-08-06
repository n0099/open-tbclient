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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantView extends RelativeLayout {
    private TbImageView bYr;
    private TbImageView bYs;
    private HeadImageView bYt;
    private boolean bYu;
    private boolean bYv;
    private int bYw;
    private int bYx;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bYu = false;
        this.bYv = false;
        this.bYw = R.drawable.pic_v_avatar;
        this.bYx = com.baidu.adp.lib.util.l.g(TbadkApplication.getInst(), R.dimen.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bYu = false;
        this.bYv = false;
        this.bYw = R.drawable.pic_v_avatar;
        this.bYx = com.baidu.adp.lib.util.l.g(TbadkApplication.getInst(), R.dimen.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.bYu = false;
        this.bYv = false;
        this.bYw = R.drawable.pic_v_avatar;
        this.bYx = com.baidu.adp.lib.util.l.g(TbadkApplication.getInst(), R.dimen.tbds42);
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.bYu = true;
    }

    public void setHasPendantStyle(boolean z) {
        this.bYu = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.bYu) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.bYt.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.bYs != null) {
                ((RelativeLayout.LayoutParams) this.bYs.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        super.onMeasure(i, i2);
    }

    public void oN(String str) {
        if (this.bYr != null) {
            if (this.bYu && !StringUtils.isNull(str)) {
                this.bYv = true;
                this.bYr.setVisibility(0);
                this.bYr.setImageDrawable(null);
                this.bYr.startLoad(str, 10, false);
                return;
            }
            this.bYr.setVisibility(8);
            this.bYv = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.bYr.setAutoChangeStyle(z);
        this.bYt.setAutoChangeStyle(z);
        this.bYs.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.bYx = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds42);
        akn();
        ako();
        akp();
    }

    private void akn() {
        this.bYt = new HeadImageView(this.mContext);
        this.bYt.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
        this.bYt.setDefaultResource(R.color.cp_bg_line_e);
        this.bYt.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.bYt.setLayoutParams(layoutParams);
        addView(this.bYt);
    }

    private void ako() {
        this.bYr = new TbImageView(this.mContext);
        this.bYr.setPageId(this.mPageId);
        this.bYr.setDefaultBgResource(0);
        this.bYr.setDefaultResource(0);
        this.bYr.setDefaultErrorResource(0);
        this.bYr.setImageDrawable(null);
        this.bYr.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.bYr.setVisibility(8);
        addView(this.bYr);
    }

    private void akp() {
        this.bYs = new TbImageView(this.mContext);
        this.bYs.setPageId(this.mPageId);
        this.bYs.setDefaultBgResource(0);
        this.bYs.setDefaultResource(0);
        this.bYs.setDefaultErrorResource(0);
        this.bYs.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bYx, this.bYx);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.bYs.setLayoutParams(layoutParams);
        this.bYs.setVisibility(8);
        addView(this.bYs);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.bYt != null) {
            this.bYt.setPageId(bdUniqueId);
        }
        if (this.bYr != null) {
            this.bYr.setPageId(bdUniqueId);
        }
        if (this.bYs != null) {
            this.bYs.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.bYr;
    }

    public HeadImageView getHeadView() {
        return this.bYt;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.bYx = com.baidu.adp.lib.util.l.g(getContext(), i);
        }
        akq();
    }

    private void akq() {
        if (this.bYx > 0 && this.bYs != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bYs.getLayoutParams();
            layoutParams.width = this.bYx;
            layoutParams.height = this.bYx;
            this.bYs.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.bYw = i;
    }

    public void aA(boolean z) {
        if (this.bYs != null) {
            if (z) {
                this.bYs.setImageDrawable(am.getDrawable(this.bYw));
                this.bYs.setVisibility(0);
                return;
            }
            this.bYs.setVisibility(8);
        }
    }

    public void setUrl(String str) {
        this.bYt.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.bYt.setDefaultResource(i);
    }

    public void a(MetaData metaData, int i, int i2) {
        if (metaData != null && metaData.getPendantData() != null && !TextUtils.isEmpty(metaData.getPendantData().acV())) {
            setHasPendantStyle(true);
            setBigVDimenSize(i2);
        } else {
            setHasPendantStyle(false);
            setBigVDimenSize(i);
        }
        a(metaData);
    }

    public void oO(String str) {
        if (!StringUtils.isNull(str)) {
            String nM = o.nM(str);
            this.bYt.setImageBitmap(null);
            this.bYt.setUrl(nM);
            if (nM.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(nM, 10, false);
            } else {
                startLoad(nM, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.bYt.startLoad(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String nM = o.nM(metaData.getPortrait());
            setUrl(nM);
            if (nM.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(nM, 10, false);
            } else {
                startLoad(nM, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                oN(metaData.getPendantData().acV());
            }
            c(metaData);
        }
    }

    public void c(MetaData metaData) {
        if (metaData != null) {
            this.bYt.setShowV(false);
            if (metaData.isBigV() || !StringUtils.isNull(metaData.getUserTbVipInfoData().getvipV_url())) {
                aA(true);
            } else {
                aA(false);
            }
        }
    }
}
