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
    private TbImageView aGF;
    private TbImageView aGG;
    private HeadImageView aGH;
    private boolean aGI;
    private boolean aGJ;
    private int aGK;
    private int aGL;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGI = false;
        this.aGJ = false;
        this.aGK = e.f.pic_v_avatar;
        this.aGL = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), e.C0210e.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGI = false;
        this.aGJ = false;
        this.aGK = e.f.pic_v_avatar;
        this.aGL = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), e.C0210e.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.aGI = false;
        this.aGJ = false;
        this.aGK = e.f.pic_v_avatar;
        this.aGL = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), e.C0210e.tbds42);
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.aGI = true;
    }

    public void setHasPendantStyle(boolean z) {
        this.aGI = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.aGI) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.aGH.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.aGG != null) {
                ((RelativeLayout.LayoutParams) this.aGG.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        super.onMeasure(i, i2);
    }

    public void gl(String str) {
        if (this.aGF != null) {
            if (this.aGI && !StringUtils.isNull(str)) {
                this.aGJ = true;
                this.aGF.setVisibility(0);
                this.aGF.setImageDrawable(null);
                this.aGF.startLoad(str, 10, false);
                return;
            }
            this.aGF.setVisibility(8);
            this.aGJ = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.aGF.setAutoChangeStyle(z);
        this.aGH.setAutoChangeStyle(z);
        this.aGG.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.aGL = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds42);
        EM();
        EN();
        EO();
    }

    private void EM() {
        this.aGH = new HeadImageView(this.mContext);
        this.aGH.setDefaultBgResource(e.f.transparent_bg);
        this.aGH.setDefaultResource(e.d.cp_bg_line_e);
        this.aGH.setDefaultErrorResource(e.f.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.aGH.setLayoutParams(layoutParams);
        addView(this.aGH);
    }

    private void EN() {
        this.aGF = new TbImageView(this.mContext);
        this.aGF.setPageId(this.mPageId);
        this.aGF.setDefaultBgResource(0);
        this.aGF.setDefaultResource(0);
        this.aGF.setDefaultErrorResource(0);
        this.aGF.setImageDrawable(null);
        this.aGF.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aGF.setVisibility(8);
        addView(this.aGF);
    }

    private void EO() {
        this.aGG = new TbImageView(this.mContext);
        this.aGG.setPageId(this.mPageId);
        this.aGG.setDefaultBgResource(0);
        this.aGG.setDefaultResource(0);
        this.aGG.setDefaultErrorResource(0);
        this.aGG.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.aGL, this.aGL);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.aGG.setLayoutParams(layoutParams);
        this.aGG.setVisibility(8);
        addView(this.aGG);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.aGH != null) {
            this.aGH.setPageId(bdUniqueId);
        }
        if (this.aGF != null) {
            this.aGF.setPageId(bdUniqueId);
        }
        if (this.aGG != null) {
            this.aGG.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.aGF;
    }

    public HeadImageView getHeadView() {
        return this.aGH;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.aGL = com.baidu.adp.lib.util.l.h(getContext(), i);
        }
        EP();
    }

    private void EP() {
        if (this.aGL > 0 && this.aGG != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aGG.getLayoutParams();
            layoutParams.width = this.aGL;
            layoutParams.height = this.aGL;
            this.aGG.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.aGK = i;
    }

    public void bD(boolean z) {
        if (this.aGG != null) {
            if (z) {
                this.aGG.setImageDrawable(al.getDrawable(this.aGK));
                this.aGG.setVisibility(0);
                return;
            }
            this.aGG.setVisibility(8);
        }
    }

    public void setUrl(String str) {
        this.aGH.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.aGH.setDefaultResource(i);
    }

    public void a(MetaData metaData, int i, int i2) {
        if (metaData != null && metaData.getPendantData() != null && !TextUtils.isEmpty(metaData.getPendantData().ys())) {
            setHasPendantStyle(true);
            setBigVDimenSize(i2);
        } else {
            setHasPendantStyle(false);
            setBigVDimenSize(i);
        }
        a(metaData);
    }

    public void gm(String str) {
        if (!StringUtils.isNull(str)) {
            String fu = com.baidu.tbadk.core.util.o.fu(str);
            this.aGH.setImageBitmap(null);
            this.aGH.setUrl(fu);
            if (fu.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(fu, 10, false);
            } else {
                startLoad(fu, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.aGH.startLoad(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String fu = com.baidu.tbadk.core.util.o.fu(metaData.getPortrait());
            setUrl(fu);
            if (fu.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(fu, 10, false);
            } else {
                startLoad(fu, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                gl(metaData.getPendantData().ys());
            }
            c(metaData);
        }
    }

    public void c(MetaData metaData) {
        if (metaData != null) {
            this.aGH.setShowV(false);
            if (metaData.isBigV() || !StringUtils.isNull(metaData.getUserTbVipInfoData().getvipV_url())) {
                bD(true);
            } else {
                bD(false);
            }
        }
    }
}
