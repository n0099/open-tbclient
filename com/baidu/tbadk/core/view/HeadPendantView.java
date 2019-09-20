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
    private TbImageView bZk;
    private TbImageView bZl;
    private HeadImageView bZm;
    private boolean bZn;
    private boolean bZo;
    private int bZp;
    private int bZq;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bZn = false;
        this.bZo = false;
        this.bZp = R.drawable.pic_v_avatar;
        this.bZq = com.baidu.adp.lib.util.l.g(TbadkApplication.getInst(), R.dimen.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bZn = false;
        this.bZo = false;
        this.bZp = R.drawable.pic_v_avatar;
        this.bZq = com.baidu.adp.lib.util.l.g(TbadkApplication.getInst(), R.dimen.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.bZn = false;
        this.bZo = false;
        this.bZp = R.drawable.pic_v_avatar;
        this.bZq = com.baidu.adp.lib.util.l.g(TbadkApplication.getInst(), R.dimen.tbds42);
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.bZn = true;
    }

    public void setHasPendantStyle(boolean z) {
        this.bZn = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.bZn) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.bZm.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.bZl != null) {
                ((RelativeLayout.LayoutParams) this.bZl.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        super.onMeasure(i, i2);
    }

    public void oV(String str) {
        if (this.bZk != null) {
            if (this.bZn && !StringUtils.isNull(str)) {
                this.bZo = true;
                this.bZk.setVisibility(0);
                this.bZk.setImageDrawable(null);
                this.bZk.startLoad(str, 10, false);
                return;
            }
            this.bZk.setVisibility(8);
            this.bZo = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.bZk.setAutoChangeStyle(z);
        this.bZm.setAutoChangeStyle(z);
        this.bZl.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.bZq = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds42);
        akz();
        akA();
        akB();
    }

    private void akz() {
        this.bZm = new HeadImageView(this.mContext);
        this.bZm.setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
        this.bZm.setDefaultResource(R.color.cp_bg_line_e);
        this.bZm.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.bZm.setLayoutParams(layoutParams);
        addView(this.bZm);
    }

    private void akA() {
        this.bZk = new TbImageView(this.mContext);
        this.bZk.setPageId(this.mPageId);
        this.bZk.setDefaultBgResource(0);
        this.bZk.setDefaultResource(0);
        this.bZk.setDefaultErrorResource(0);
        this.bZk.setImageDrawable(null);
        this.bZk.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.bZk.setVisibility(8);
        addView(this.bZk);
    }

    private void akB() {
        this.bZl = new TbImageView(this.mContext);
        this.bZl.setPageId(this.mPageId);
        this.bZl.setDefaultBgResource(0);
        this.bZl.setDefaultResource(0);
        this.bZl.setDefaultErrorResource(0);
        this.bZl.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bZq, this.bZq);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.bZl.setLayoutParams(layoutParams);
        this.bZl.setVisibility(8);
        addView(this.bZl);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.bZm != null) {
            this.bZm.setPageId(bdUniqueId);
        }
        if (this.bZk != null) {
            this.bZk.setPageId(bdUniqueId);
        }
        if (this.bZl != null) {
            this.bZl.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.bZk;
    }

    public HeadImageView getHeadView() {
        return this.bZm;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.bZq = com.baidu.adp.lib.util.l.g(getContext(), i);
        }
        akC();
    }

    private void akC() {
        if (this.bZq > 0 && this.bZl != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bZl.getLayoutParams();
            layoutParams.width = this.bZq;
            layoutParams.height = this.bZq;
            this.bZl.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.bZp = i;
    }

    public void aA(boolean z) {
        if (this.bZl != null) {
            if (z) {
                this.bZl.setImageDrawable(am.getDrawable(this.bZp));
                this.bZl.setVisibility(0);
                return;
            }
            this.bZl.setVisibility(8);
        }
    }

    public void setUrl(String str) {
        this.bZm.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.bZm.setDefaultResource(i);
    }

    public void a(MetaData metaData, int i, int i2) {
        if (metaData != null && metaData.getPendantData() != null && !TextUtils.isEmpty(metaData.getPendantData().acZ())) {
            setHasPendantStyle(true);
            setBigVDimenSize(i2);
        } else {
            setHasPendantStyle(false);
            setBigVDimenSize(i);
        }
        a(metaData);
    }

    public void oW(String str) {
        if (!StringUtils.isNull(str)) {
            String nO = o.nO(str);
            this.bZm.setImageBitmap(null);
            this.bZm.setUrl(nO);
            if (nO.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(nO, 10, false);
            } else {
                startLoad(nO, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.bZm.startLoad(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String nO = o.nO(metaData.getPortrait());
            setUrl(nO);
            if (nO.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(nO, 10, false);
            } else {
                startLoad(nO, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                oV(metaData.getPendantData().acZ());
            }
            c(metaData);
        }
    }

    public void c(MetaData metaData) {
        if (metaData != null) {
            this.bZm.setShowV(false);
            if (metaData.isBigV() || !StringUtils.isNull(metaData.getUserTbVipInfoData().getvipV_url())) {
                aA(true);
            } else {
                aA(false);
            }
        }
    }
}
