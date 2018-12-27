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
    private TbImageView aGG;
    private TbImageView aGH;
    private HeadImageView aGI;
    private boolean aGJ;
    private boolean aGK;
    private int aGL;
    private int aGM;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGJ = false;
        this.aGK = false;
        this.aGL = e.f.pic_v_avatar;
        this.aGM = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), e.C0210e.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGJ = false;
        this.aGK = false;
        this.aGL = e.f.pic_v_avatar;
        this.aGM = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), e.C0210e.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.aGJ = false;
        this.aGK = false;
        this.aGL = e.f.pic_v_avatar;
        this.aGM = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), e.C0210e.tbds42);
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.aGJ = true;
    }

    public void setHasPendantStyle(boolean z) {
        this.aGJ = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.aGJ) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.aGI.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.aGH != null) {
                ((RelativeLayout.LayoutParams) this.aGH.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        super.onMeasure(i, i2);
    }

    public void gm(String str) {
        if (this.aGG != null) {
            if (this.aGJ && !StringUtils.isNull(str)) {
                this.aGK = true;
                this.aGG.setVisibility(0);
                this.aGG.setImageDrawable(null);
                this.aGG.startLoad(str, 10, false);
                return;
            }
            this.aGG.setVisibility(8);
            this.aGK = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.aGG.setAutoChangeStyle(z);
        this.aGI.setAutoChangeStyle(z);
        this.aGH.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.aGM = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds42);
        EM();
        EN();
        EO();
    }

    private void EM() {
        this.aGI = new HeadImageView(this.mContext);
        this.aGI.setDefaultBgResource(e.f.transparent_bg);
        this.aGI.setDefaultResource(e.d.cp_bg_line_e);
        this.aGI.setDefaultErrorResource(e.f.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.aGI.setLayoutParams(layoutParams);
        addView(this.aGI);
    }

    private void EN() {
        this.aGG = new TbImageView(this.mContext);
        this.aGG.setPageId(this.mPageId);
        this.aGG.setDefaultBgResource(0);
        this.aGG.setDefaultResource(0);
        this.aGG.setDefaultErrorResource(0);
        this.aGG.setImageDrawable(null);
        this.aGG.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aGG.setVisibility(8);
        addView(this.aGG);
    }

    private void EO() {
        this.aGH = new TbImageView(this.mContext);
        this.aGH.setPageId(this.mPageId);
        this.aGH.setDefaultBgResource(0);
        this.aGH.setDefaultResource(0);
        this.aGH.setDefaultErrorResource(0);
        this.aGH.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.aGM, this.aGM);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.aGH.setLayoutParams(layoutParams);
        this.aGH.setVisibility(8);
        addView(this.aGH);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.aGI != null) {
            this.aGI.setPageId(bdUniqueId);
        }
        if (this.aGG != null) {
            this.aGG.setPageId(bdUniqueId);
        }
        if (this.aGH != null) {
            this.aGH.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.aGG;
    }

    public HeadImageView getHeadView() {
        return this.aGI;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.aGM = com.baidu.adp.lib.util.l.h(getContext(), i);
        }
        EP();
    }

    private void EP() {
        if (this.aGM > 0 && this.aGH != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aGH.getLayoutParams();
            layoutParams.width = this.aGM;
            layoutParams.height = this.aGM;
            this.aGH.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.aGL = i;
    }

    public void bD(boolean z) {
        if (this.aGH != null) {
            if (z) {
                this.aGH.setImageDrawable(al.getDrawable(this.aGL));
                this.aGH.setVisibility(0);
                return;
            }
            this.aGH.setVisibility(8);
        }
    }

    public void setUrl(String str) {
        this.aGI.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.aGI.setDefaultResource(i);
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

    public void gn(String str) {
        if (!StringUtils.isNull(str)) {
            String fu = com.baidu.tbadk.core.util.o.fu(str);
            this.aGI.setImageBitmap(null);
            this.aGI.setUrl(fu);
            if (fu.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(fu, 10, false);
            } else {
                startLoad(fu, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.aGI.startLoad(str, i, 0, 0, z);
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
                gm(metaData.getPendantData().ys());
            }
            c(metaData);
        }
    }

    public void c(MetaData metaData) {
        if (metaData != null) {
            this.aGI.setShowV(false);
            if (metaData.isBigV() || !StringUtils.isNull(metaData.getUserTbVipInfoData().getvipV_url())) {
                bD(true);
            } else {
                bD(false);
            }
        }
    }
}
