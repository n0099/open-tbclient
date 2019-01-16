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
    private TbImageView aHi;
    private TbImageView aHj;
    private HeadImageView aHk;
    private boolean aHl;
    private boolean aHm;
    private int aHn;
    private int aHo;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aHl = false;
        this.aHm = false;
        this.aHn = e.f.pic_v_avatar;
        this.aHo = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), e.C0210e.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aHl = false;
        this.aHm = false;
        this.aHn = e.f.pic_v_avatar;
        this.aHo = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), e.C0210e.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.aHl = false;
        this.aHm = false;
        this.aHn = e.f.pic_v_avatar;
        this.aHo = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), e.C0210e.tbds42);
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.aHl = true;
    }

    public void setHasPendantStyle(boolean z) {
        this.aHl = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.aHl) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.aHk.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.aHj != null) {
                ((RelativeLayout.LayoutParams) this.aHj.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        super.onMeasure(i, i2);
    }

    public void gA(String str) {
        if (this.aHi != null) {
            if (this.aHl && !StringUtils.isNull(str)) {
                this.aHm = true;
                this.aHi.setVisibility(0);
                this.aHi.setImageDrawable(null);
                this.aHi.startLoad(str, 10, false);
                return;
            }
            this.aHi.setVisibility(8);
            this.aHm = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.aHi.setAutoChangeStyle(z);
        this.aHk.setAutoChangeStyle(z);
        this.aHj.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.aHo = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds42);
        EZ();
        Fa();
        Fb();
    }

    private void EZ() {
        this.aHk = new HeadImageView(this.mContext);
        this.aHk.setDefaultBgResource(e.f.transparent_bg);
        this.aHk.setDefaultResource(e.d.cp_bg_line_e);
        this.aHk.setDefaultErrorResource(e.f.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.aHk.setLayoutParams(layoutParams);
        addView(this.aHk);
    }

    private void Fa() {
        this.aHi = new TbImageView(this.mContext);
        this.aHi.setPageId(this.mPageId);
        this.aHi.setDefaultBgResource(0);
        this.aHi.setDefaultResource(0);
        this.aHi.setDefaultErrorResource(0);
        this.aHi.setImageDrawable(null);
        this.aHi.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aHi.setVisibility(8);
        addView(this.aHi);
    }

    private void Fb() {
        this.aHj = new TbImageView(this.mContext);
        this.aHj.setPageId(this.mPageId);
        this.aHj.setDefaultBgResource(0);
        this.aHj.setDefaultResource(0);
        this.aHj.setDefaultErrorResource(0);
        this.aHj.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.aHo, this.aHo);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.aHj.setLayoutParams(layoutParams);
        this.aHj.setVisibility(8);
        addView(this.aHj);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.aHk != null) {
            this.aHk.setPageId(bdUniqueId);
        }
        if (this.aHi != null) {
            this.aHi.setPageId(bdUniqueId);
        }
        if (this.aHj != null) {
            this.aHj.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.aHi;
    }

    public HeadImageView getHeadView() {
        return this.aHk;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.aHo = com.baidu.adp.lib.util.l.h(getContext(), i);
        }
        Fc();
    }

    private void Fc() {
        if (this.aHo > 0 && this.aHj != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aHj.getLayoutParams();
            layoutParams.width = this.aHo;
            layoutParams.height = this.aHo;
            this.aHj.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.aHn = i;
    }

    public void bE(boolean z) {
        if (this.aHj != null) {
            if (z) {
                this.aHj.setImageDrawable(al.getDrawable(this.aHn));
                this.aHj.setVisibility(0);
                return;
            }
            this.aHj.setVisibility(8);
        }
    }

    public void setUrl(String str) {
        this.aHk.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.aHk.setDefaultResource(i);
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
            this.aHk.setImageBitmap(null);
            this.aHk.setUrl(fH);
            if (fH.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(fH, 10, false);
            } else {
                startLoad(fH, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.aHk.startLoad(str, i, 0, 0, z);
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
            this.aHk.setShowV(false);
            if (metaData.isBigV() || !StringUtils.isNull(metaData.getUserTbVipInfoData().getvipV_url())) {
                bE(true);
            } else {
                bE(false);
            }
        }
    }
}
