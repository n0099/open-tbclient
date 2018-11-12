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
    private TbImageView aDf;
    private TbImageView aDg;
    private HeadImageView aDh;
    private boolean aDi;
    private boolean aDj;
    private int aDk;
    private int aDl;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDi = false;
        this.aDj = false;
        this.aDk = e.f.pic_v_avatar;
        this.aDl = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), e.C0200e.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDi = false;
        this.aDj = false;
        this.aDk = e.f.pic_v_avatar;
        this.aDl = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), e.C0200e.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.aDi = false;
        this.aDj = false;
        this.aDk = e.f.pic_v_avatar;
        this.aDl = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), e.C0200e.tbds42);
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.aDi = true;
    }

    public void setHasPendantStyle(boolean z) {
        this.aDi = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.aDi) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.aDh.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.aDg != null) {
                ((RelativeLayout.LayoutParams) this.aDg.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        super.onMeasure(i, i2);
    }

    public void fT(String str) {
        if (this.aDf != null) {
            if (this.aDi && !StringUtils.isNull(str)) {
                this.aDj = true;
                this.aDf.setVisibility(0);
                this.aDf.setImageDrawable(null);
                this.aDf.startLoad(str, 10, false);
                return;
            }
            this.aDf.setVisibility(8);
            this.aDj = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.aDf.setAutoChangeStyle(z);
        this.aDh.setAutoChangeStyle(z);
        this.aDg.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.aDl = com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.tbds42);
        DI();
        DJ();
        DK();
    }

    private void DI() {
        this.aDh = new HeadImageView(this.mContext);
        this.aDh.setDefaultBgResource(e.f.transparent_bg);
        this.aDh.setDefaultResource(e.d.cp_bg_line_e);
        this.aDh.setDefaultErrorResource(e.f.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.aDh.setLayoutParams(layoutParams);
        addView(this.aDh);
    }

    private void DJ() {
        this.aDf = new TbImageView(this.mContext);
        this.aDf.setPageId(this.mPageId);
        this.aDf.setDefaultBgResource(0);
        this.aDf.setDefaultResource(0);
        this.aDf.setDefaultErrorResource(0);
        this.aDf.setImageDrawable(null);
        this.aDf.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aDf.setVisibility(8);
        addView(this.aDf);
    }

    private void DK() {
        this.aDg = new TbImageView(this.mContext);
        this.aDg.setPageId(this.mPageId);
        this.aDg.setDefaultBgResource(0);
        this.aDg.setDefaultResource(0);
        this.aDg.setDefaultErrorResource(0);
        this.aDg.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.aDl, this.aDl);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.aDg.setLayoutParams(layoutParams);
        this.aDg.setVisibility(8);
        addView(this.aDg);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.aDh != null) {
            this.aDh.setPageId(bdUniqueId);
        }
        if (this.aDf != null) {
            this.aDf.setPageId(bdUniqueId);
        }
        if (this.aDg != null) {
            this.aDg.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.aDf;
    }

    public HeadImageView getHeadView() {
        return this.aDh;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.aDl = com.baidu.adp.lib.util.l.h(getContext(), i);
        }
        DL();
    }

    private void DL() {
        if (this.aDl > 0 && this.aDg != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aDg.getLayoutParams();
            layoutParams.width = this.aDl;
            layoutParams.height = this.aDl;
            this.aDg.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.aDk = i;
    }

    public void bC(boolean z) {
        if (this.aDg != null) {
            if (z) {
                this.aDg.setImageDrawable(al.getDrawable(this.aDk));
                this.aDg.setVisibility(0);
                return;
            }
            this.aDg.setVisibility(8);
        }
    }

    public void setUrl(String str) {
        this.aDh.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.aDh.setDefaultResource(i);
    }

    public void a(MetaData metaData, int i, int i2) {
        if (metaData != null && metaData.getPendantData() != null && !TextUtils.isEmpty(metaData.getPendantData().xn())) {
            setHasPendantStyle(true);
            setBigVDimenSize(i2);
        } else {
            setHasPendantStyle(false);
            setBigVDimenSize(i);
        }
        a(metaData);
    }

    public void fU(String str) {
        if (!StringUtils.isNull(str)) {
            String fc = com.baidu.tbadk.core.util.o.fc(str);
            this.aDh.setImageBitmap(null);
            this.aDh.setUrl(fc);
            if (fc.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(fc, 10, false);
            } else {
                startLoad(fc, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.aDh.startLoad(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String fc = com.baidu.tbadk.core.util.o.fc(metaData.getPortrait());
            setUrl(fc);
            if (fc.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(fc, 10, false);
            } else {
                startLoad(fc, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                fT(metaData.getPendantData().xn());
            }
            c(metaData);
        }
    }

    public void c(MetaData metaData) {
        if (metaData != null) {
            this.aDh.setShowV(false);
            if (metaData.isBigV() || !StringUtils.isNull(metaData.getUserTbVipInfoData().getvipV_url())) {
                bC(true);
            } else {
                bC(false);
            }
        }
    }
}
