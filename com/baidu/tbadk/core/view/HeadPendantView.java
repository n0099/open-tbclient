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
    private TbImageView coe;
    private TbImageView cof;
    private HeadImageView cog;
    private boolean coh;
    private boolean coi;
    private int coj;
    private int cok;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.coh = false;
        this.coi = false;
        this.coj = R.drawable.pic_v_avatar;
        this.cok = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.coh = false;
        this.coi = false;
        this.coj = R.drawable.pic_v_avatar;
        this.cok = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.coh = false;
        this.coi = false;
        this.coj = R.drawable.pic_v_avatar;
        this.cok = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds42);
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.coh = true;
    }

    public void setHasPendantStyle(boolean z) {
        this.coh = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.coh) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.cog.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.cof != null) {
                ((RelativeLayout.LayoutParams) this.cof.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        super.onMeasure(i, i2);
    }

    public void ou(String str) {
        if (this.coe != null) {
            if (this.coh && !StringUtils.isNull(str)) {
                this.coi = true;
                this.coe.setVisibility(0);
                this.coe.setImageDrawable(null);
                this.coe.startLoad(str, 10, false);
                return;
            }
            this.coe.setVisibility(8);
            this.coi = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.coe.setAutoChangeStyle(z);
        this.cog.setAutoChangeStyle(z);
        this.cof.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.cok = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        anA();
        anB();
        anC();
    }

    private void anA() {
        this.cog = new HeadImageView(this.mContext);
        this.cog.setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
        this.cog.setDefaultResource(R.color.cp_bg_line_e);
        this.cog.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.cog.setLayoutParams(layoutParams);
        addView(this.cog);
    }

    private void anB() {
        this.coe = new TbImageView(this.mContext);
        this.coe.setPageId(this.mPageId);
        this.coe.setDefaultBgResource(0);
        this.coe.setDefaultResource(0);
        this.coe.setDefaultErrorResource(0);
        this.coe.setImageDrawable(null);
        this.coe.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.coe.setVisibility(8);
        addView(this.coe);
    }

    private void anC() {
        this.cof = new TbImageView(this.mContext);
        this.cof.setPageId(this.mPageId);
        this.cof.setDefaultBgResource(0);
        this.cof.setDefaultResource(0);
        this.cof.setDefaultErrorResource(0);
        this.cof.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.cok, this.cok);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.cof.setLayoutParams(layoutParams);
        this.cof.setVisibility(8);
        addView(this.cof);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.cog != null) {
            this.cog.setPageId(bdUniqueId);
        }
        if (this.coe != null) {
            this.coe.setPageId(bdUniqueId);
        }
        if (this.cof != null) {
            this.cof.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.coe;
    }

    public HeadImageView getHeadView() {
        return this.cog;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.cok = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        anD();
    }

    private void anD() {
        if (this.cok > 0 && this.cof != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cof.getLayoutParams();
            layoutParams.width = this.cok;
            layoutParams.height = this.cok;
            this.cof.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.coj = i;
    }

    public void V(boolean z) {
        if (this.cof != null) {
            if (z) {
                this.cof.setImageDrawable(am.getDrawable(this.coj));
                this.cof.setVisibility(0);
                return;
            }
            this.cof.setVisibility(8);
        }
    }

    public void setUrl(String str) {
        this.cog.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.cog.setDefaultResource(i);
    }

    public void a(MetaData metaData, int i, int i2) {
        if (metaData != null && metaData.getPendantData() != null && !TextUtils.isEmpty(metaData.getPendantData().ahf())) {
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
            this.cog.setImageBitmap(null);
            this.cog.setUrl(nK);
            if (nK.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(nK, 10, false);
            } else {
                startLoad(nK, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.cog.a(str, i, 0, 0, z);
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
                ou(metaData.getPendantData().ahf());
            }
            c(metaData);
        }
    }

    public void c(MetaData metaData) {
        if (metaData != null) {
            this.cog.setShowV(false);
            if (metaData.isBigV() || !StringUtils.isNull(metaData.getUserTbVipInfoData().getvipV_url())) {
                V(true);
            } else {
                V(false);
            }
        }
    }
}
