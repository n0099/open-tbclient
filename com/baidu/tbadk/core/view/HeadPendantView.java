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
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantView extends RelativeLayout {
    private TbImageView aHj;
    private TbImageView aHk;
    private HeadImageView aHl;
    private boolean aHm;
    private boolean aHn;
    private int aHo;
    private int aHp;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aHm = false;
        this.aHn = false;
        this.aHo = e.f.pic_v_avatar;
        this.aHp = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), e.C0210e.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aHm = false;
        this.aHn = false;
        this.aHo = e.f.pic_v_avatar;
        this.aHp = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), e.C0210e.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.aHm = false;
        this.aHn = false;
        this.aHo = e.f.pic_v_avatar;
        this.aHp = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), e.C0210e.tbds42);
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.aHm = true;
    }

    public void setHasPendantStyle(boolean z) {
        this.aHm = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.aHm) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.aHl.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.aHk != null) {
                ((RelativeLayout.LayoutParams) this.aHk.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        super.onMeasure(i, i2);
    }

    public void gA(String str) {
        if (this.aHj != null) {
            if (this.aHm && !StringUtils.isNull(str)) {
                this.aHn = true;
                this.aHj.setVisibility(0);
                this.aHj.setImageDrawable(null);
                this.aHj.startLoad(str, 10, false);
                return;
            }
            this.aHj.setVisibility(8);
            this.aHn = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.aHj.setAutoChangeStyle(z);
        this.aHl.setAutoChangeStyle(z);
        this.aHk.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.aHp = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds42);
        EZ();
        Fa();
        Fb();
    }

    private void EZ() {
        this.aHl = new HeadImageView(this.mContext);
        this.aHl.setDefaultBgResource(e.f.transparent_bg);
        this.aHl.setDefaultResource(e.d.cp_bg_line_e);
        this.aHl.setDefaultErrorResource(e.f.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.aHl.setLayoutParams(layoutParams);
        addView(this.aHl);
    }

    private void Fa() {
        this.aHj = new TbImageView(this.mContext);
        this.aHj.setPageId(this.mPageId);
        this.aHj.setDefaultBgResource(0);
        this.aHj.setDefaultResource(0);
        this.aHj.setDefaultErrorResource(0);
        this.aHj.setImageDrawable(null);
        this.aHj.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aHj.setVisibility(8);
        addView(this.aHj);
    }

    private void Fb() {
        this.aHk = new TbImageView(this.mContext);
        this.aHk.setPageId(this.mPageId);
        this.aHk.setDefaultBgResource(0);
        this.aHk.setDefaultResource(0);
        this.aHk.setDefaultErrorResource(0);
        this.aHk.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.aHp, this.aHp);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.aHk.setLayoutParams(layoutParams);
        this.aHk.setVisibility(8);
        addView(this.aHk);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.aHl != null) {
            this.aHl.setPageId(bdUniqueId);
        }
        if (this.aHj != null) {
            this.aHj.setPageId(bdUniqueId);
        }
        if (this.aHk != null) {
            this.aHk.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.aHj;
    }

    public HeadImageView getHeadView() {
        return this.aHl;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.aHp = com.baidu.adp.lib.util.l.h(getContext(), i);
        }
        Fc();
    }

    private void Fc() {
        if (this.aHp > 0 && this.aHk != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aHk.getLayoutParams();
            layoutParams.width = this.aHp;
            layoutParams.height = this.aHp;
            this.aHk.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.aHo = i;
    }

    public void bE(boolean z) {
        if (this.aHk != null) {
            if (z) {
                this.aHk.setImageDrawable(al.getDrawable(this.aHo));
                this.aHk.setVisibility(0);
                return;
            }
            this.aHk.setVisibility(8);
        }
    }

    public void setUrl(String str) {
        this.aHl.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.aHl.setDefaultResource(i);
    }

    public void a(MetaData metaData, int i, int i2) {
        if (metaData != null && metaData.getPendantData() != null && !TextUtils.isEmpty(metaData.getPendantData().yF())) {
            setHasPendantStyle(true);
            setBigVDimenSize(i2);
        } else {
            setHasPendantStyle(false);
            setBigVDimenSize(i);
        }
        a(metaData);
    }

    public void gB(String str) {
        if (!StringUtils.isNull(str)) {
            String fH = com.baidu.tbadk.core.util.o.fH(str);
            this.aHl.setImageBitmap(null);
            this.aHl.setUrl(fH);
            if (fH.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(fH, 10, false);
            } else {
                startLoad(fH, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.aHl.startLoad(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String fH = com.baidu.tbadk.core.util.o.fH(metaData.getPortrait());
            setUrl(fH);
            if (fH.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(fH, 10, false);
            } else {
                startLoad(fH, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                gA(metaData.getPendantData().yF());
            }
            c(metaData);
        }
    }

    public void c(MetaData metaData) {
        if (metaData != null) {
            this.aHl.setShowV(false);
            if (metaData.isBigV() || !StringUtils.isNull(metaData.getUserTbVipInfoData().getvipV_url())) {
                bE(true);
            } else {
                bE(false);
            }
        }
    }
}
