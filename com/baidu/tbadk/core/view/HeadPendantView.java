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
    private TbImageView cnm;
    private TbImageView cnn;
    private HeadImageView cno;
    private boolean cnp;
    private boolean cnq;
    private int cnr;
    private int cns;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cnp = false;
        this.cnq = false;
        this.cnr = R.drawable.pic_v_avatar;
        this.cns = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cnp = false;
        this.cnq = false;
        this.cnr = R.drawable.pic_v_avatar;
        this.cns = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.cnp = false;
        this.cnq = false;
        this.cnr = R.drawable.pic_v_avatar;
        this.cns = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds42);
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.cnp = true;
    }

    public void setHasPendantStyle(boolean z) {
        this.cnp = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.cnp) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.cno.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.cnn != null) {
                ((RelativeLayout.LayoutParams) this.cnn.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        super.onMeasure(i, i2);
    }

    public void ou(String str) {
        if (this.cnm != null) {
            if (this.cnp && !StringUtils.isNull(str)) {
                this.cnq = true;
                this.cnm.setVisibility(0);
                this.cnm.setImageDrawable(null);
                this.cnm.startLoad(str, 10, false);
                return;
            }
            this.cnm.setVisibility(8);
            this.cnq = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.cnm.setAutoChangeStyle(z);
        this.cno.setAutoChangeStyle(z);
        this.cnn.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.cns = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        any();
        anz();
        anA();
    }

    private void any() {
        this.cno = new HeadImageView(this.mContext);
        this.cno.setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
        this.cno.setDefaultResource(R.color.cp_bg_line_e);
        this.cno.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.cno.setLayoutParams(layoutParams);
        addView(this.cno);
    }

    private void anz() {
        this.cnm = new TbImageView(this.mContext);
        this.cnm.setPageId(this.mPageId);
        this.cnm.setDefaultBgResource(0);
        this.cnm.setDefaultResource(0);
        this.cnm.setDefaultErrorResource(0);
        this.cnm.setImageDrawable(null);
        this.cnm.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.cnm.setVisibility(8);
        addView(this.cnm);
    }

    private void anA() {
        this.cnn = new TbImageView(this.mContext);
        this.cnn.setPageId(this.mPageId);
        this.cnn.setDefaultBgResource(0);
        this.cnn.setDefaultResource(0);
        this.cnn.setDefaultErrorResource(0);
        this.cnn.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.cns, this.cns);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.cnn.setLayoutParams(layoutParams);
        this.cnn.setVisibility(8);
        addView(this.cnn);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.cno != null) {
            this.cno.setPageId(bdUniqueId);
        }
        if (this.cnm != null) {
            this.cnm.setPageId(bdUniqueId);
        }
        if (this.cnn != null) {
            this.cnn.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.cnm;
    }

    public HeadImageView getHeadView() {
        return this.cno;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.cns = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        anB();
    }

    private void anB() {
        if (this.cns > 0 && this.cnn != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cnn.getLayoutParams();
            layoutParams.width = this.cns;
            layoutParams.height = this.cns;
            this.cnn.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.cnr = i;
    }

    public void V(boolean z) {
        if (this.cnn != null) {
            if (z) {
                this.cnn.setImageDrawable(am.getDrawable(this.cnr));
                this.cnn.setVisibility(0);
                return;
            }
            this.cnn.setVisibility(8);
        }
    }

    public void setUrl(String str) {
        this.cno.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.cno.setDefaultResource(i);
    }

    public void a(MetaData metaData, int i, int i2) {
        if (metaData != null && metaData.getPendantData() != null && !TextUtils.isEmpty(metaData.getPendantData().ahd())) {
            setHasPendantStyle(true);
            setBigVDimenSize(i2);
        } else {
            setHasPendantStyle(false);
            setBigVDimenSize(i);
        }
        a(metaData);
    }

    public void ov(String str) {
        if (!StringUtils.isNull(str)) {
            String nK = o.nK(str);
            this.cno.setImageBitmap(null);
            this.cno.setUrl(nK);
            if (nK.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(nK, 10, false);
            } else {
                startLoad(nK, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.cno.a(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String nK = o.nK(metaData.getPortrait());
            setUrl(nK);
            if (nK.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(nK, 10, false);
            } else {
                startLoad(nK, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                ou(metaData.getPendantData().ahd());
            }
            c(metaData);
        }
    }

    public void c(MetaData metaData) {
        if (metaData != null) {
            this.cno.setShowV(false);
            if (metaData.isBigV() || !StringUtils.isNull(metaData.getUserTbVipInfoData().getvipV_url())) {
                V(true);
            } else {
                V(false);
            }
        }
    }
}
