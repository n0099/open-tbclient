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
    private TbImageView bYl;
    private TbImageView bYm;
    private HeadImageView bYn;
    private boolean bYo;
    private boolean bYp;
    private int bYq;
    private int bYr;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bYo = false;
        this.bYp = false;
        this.bYq = R.drawable.pic_v_avatar;
        this.bYr = com.baidu.adp.lib.util.l.g(TbadkApplication.getInst(), R.dimen.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bYo = false;
        this.bYp = false;
        this.bYq = R.drawable.pic_v_avatar;
        this.bYr = com.baidu.adp.lib.util.l.g(TbadkApplication.getInst(), R.dimen.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.bYo = false;
        this.bYp = false;
        this.bYq = R.drawable.pic_v_avatar;
        this.bYr = com.baidu.adp.lib.util.l.g(TbadkApplication.getInst(), R.dimen.tbds42);
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.bYo = true;
    }

    public void setHasPendantStyle(boolean z) {
        this.bYo = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.bYo) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.bYn.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.bYm != null) {
                ((RelativeLayout.LayoutParams) this.bYm.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        super.onMeasure(i, i2);
    }

    public void oN(String str) {
        if (this.bYl != null) {
            if (this.bYo && !StringUtils.isNull(str)) {
                this.bYp = true;
                this.bYl.setVisibility(0);
                this.bYl.setImageDrawable(null);
                this.bYl.startLoad(str, 10, false);
                return;
            }
            this.bYl.setVisibility(8);
            this.bYp = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.bYl.setAutoChangeStyle(z);
        this.bYn.setAutoChangeStyle(z);
        this.bYm.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.bYr = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds42);
        akl();
        akm();
        akn();
    }

    private void akl() {
        this.bYn = new HeadImageView(this.mContext);
        this.bYn.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
        this.bYn.setDefaultResource(R.color.cp_bg_line_e);
        this.bYn.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.bYn.setLayoutParams(layoutParams);
        addView(this.bYn);
    }

    private void akm() {
        this.bYl = new TbImageView(this.mContext);
        this.bYl.setPageId(this.mPageId);
        this.bYl.setDefaultBgResource(0);
        this.bYl.setDefaultResource(0);
        this.bYl.setDefaultErrorResource(0);
        this.bYl.setImageDrawable(null);
        this.bYl.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.bYl.setVisibility(8);
        addView(this.bYl);
    }

    private void akn() {
        this.bYm = new TbImageView(this.mContext);
        this.bYm.setPageId(this.mPageId);
        this.bYm.setDefaultBgResource(0);
        this.bYm.setDefaultResource(0);
        this.bYm.setDefaultErrorResource(0);
        this.bYm.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bYr, this.bYr);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.bYm.setLayoutParams(layoutParams);
        this.bYm.setVisibility(8);
        addView(this.bYm);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.bYn != null) {
            this.bYn.setPageId(bdUniqueId);
        }
        if (this.bYl != null) {
            this.bYl.setPageId(bdUniqueId);
        }
        if (this.bYm != null) {
            this.bYm.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.bYl;
    }

    public HeadImageView getHeadView() {
        return this.bYn;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.bYr = com.baidu.adp.lib.util.l.g(getContext(), i);
        }
        ako();
    }

    private void ako() {
        if (this.bYr > 0 && this.bYm != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bYm.getLayoutParams();
            layoutParams.width = this.bYr;
            layoutParams.height = this.bYr;
            this.bYm.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.bYq = i;
    }

    public void aA(boolean z) {
        if (this.bYm != null) {
            if (z) {
                this.bYm.setImageDrawable(am.getDrawable(this.bYq));
                this.bYm.setVisibility(0);
                return;
            }
            this.bYm.setVisibility(8);
        }
    }

    public void setUrl(String str) {
        this.bYn.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.bYn.setDefaultResource(i);
    }

    public void a(MetaData metaData, int i, int i2) {
        if (metaData != null && metaData.getPendantData() != null && !TextUtils.isEmpty(metaData.getPendantData().acU())) {
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
            this.bYn.setImageBitmap(null);
            this.bYn.setUrl(nM);
            if (nM.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(nM, 10, false);
            } else {
                startLoad(nM, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.bYn.startLoad(str, i, 0, 0, z);
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
                oN(metaData.getPendantData().acU());
            }
            c(metaData);
        }
    }

    public void c(MetaData metaData) {
        if (metaData != null) {
            this.bYn.setShowV(false);
            if (metaData.isBigV() || !StringUtils.isNull(metaData.getUserTbVipInfoData().getvipV_url())) {
                aA(true);
            } else {
                aA(false);
            }
        }
    }
}
