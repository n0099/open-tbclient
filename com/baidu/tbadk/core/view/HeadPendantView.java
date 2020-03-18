package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantView extends RelativeLayout {
    private TbImageView dfn;
    private ImageView dfo;
    private HeadImageView dfp;
    private boolean dfq;
    private boolean dfr;
    private boolean dfs;
    private int dft;
    private int dfu;
    private int dfv;
    private boolean dfw;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dfq = false;
        this.dfr = false;
        this.dfs = false;
        this.dft = R.drawable.ic_icon_mask_shen20_n;
        this.dfu = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.dfv = 0;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dfq = false;
        this.dfr = false;
        this.dfs = false;
        this.dft = R.drawable.ic_icon_mask_shen20_n;
        this.dfu = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.dfv = 0;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.dfq = false;
        this.dfr = false;
        this.dfs = false;
        this.dft = R.drawable.ic_icon_mask_shen20_n;
        this.dfu = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.dfv = 0;
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.dfq = true;
    }

    public void setHasPendantStyle(boolean z) {
        if (this.dfq && !z && this.dfp != null) {
            ((RelativeLayout.LayoutParams) this.dfp.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.dfo != null) {
                ((RelativeLayout.LayoutParams) this.dfo.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (this.dfn != null) {
                this.dfn.setVisibility(8);
            }
            this.dfr = false;
            invalidate();
        } else if (!this.dfq && z && this.dfp != null) {
            int width = (int) (this.dfp.getWidth() * 0.13f);
            int height = (int) (this.dfp.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) this.dfp.getLayoutParams()).setMargins(width, height, width, height);
            if (this.dfo != null) {
                ((RelativeLayout.LayoutParams) this.dfo.getLayoutParams()).setMargins(width, height, width, height);
            }
            invalidate();
        }
        this.dfq = z;
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.dfs = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.dfq) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.dfp.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.dfo != null) {
                ((RelativeLayout.LayoutParams) this.dfo.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        if (this.dfs) {
            ((RelativeLayout.LayoutParams) this.dfp.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.dfo != null) {
                ((RelativeLayout.LayoutParams) this.dfo.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    public void tS(String str) {
        if (this.dfn != null) {
            if (this.dfq && !StringUtils.isNull(str)) {
                this.dfr = true;
                this.dfn.setVisibility(0);
                this.dfn.setImageDrawable(null);
                this.dfn.startLoad(str, 10, false);
                return;
            }
            this.dfn.setVisibility(8);
            this.dfr = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.dfn.setAutoChangeStyle(z);
        this.dfp.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.dfu = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        aHA();
        aHB();
        aHC();
    }

    private void aHA() {
        this.dfp = new HeadImageView(this.mContext);
        this.dfp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dfp.setPlaceHolder(1);
        this.dfp.setDefaultResource(R.color.cp_bg_line_e);
        this.dfp.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.dfp.setLayoutParams(layoutParams);
        addView(this.dfp);
    }

    private void aHB() {
        this.dfn = new TbImageView(this.mContext);
        this.dfn.setPageId(this.mPageId);
        this.dfn.setDefaultBgResource(0);
        this.dfn.setDefaultResource(0);
        this.dfn.setDefaultErrorResource(0);
        this.dfn.setImageDrawable(null);
        this.dfn.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.dfn.setVisibility(8);
        addView(this.dfn);
    }

    private void aHC() {
        this.dfo = new ImageView(this.mContext);
        this.dfo.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.dfu, this.dfu);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.dfo.setLayoutParams(layoutParams);
        this.dfo.setVisibility(8);
        addView(this.dfo);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.dfp != null) {
            this.dfp.setPageId(bdUniqueId);
        }
        if (this.dfn != null) {
            this.dfn.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.dfn;
    }

    public HeadImageView getHeadView() {
        return this.dfp;
    }

    public ImageView getBigVIconView() {
        return this.dfo;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.dfu = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        aHD();
    }

    private void aHD() {
        if (this.dfu > 0 && this.dfo != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dfo.getLayoutParams();
            layoutParams.width = this.dfu;
            layoutParams.height = this.dfu;
            this.dfo.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.dft = i;
    }

    public void setAuthIconType(int i) {
        this.dfv = i;
    }

    public void setUrl(String str) {
        this.dfp.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.dfp.setDefaultResource(i);
    }

    public void tT(String str) {
        if (!StringUtils.isNull(str)) {
            String tm = o.tm(str);
            this.dfp.setImageBitmap(null);
            this.dfp.setUrl(tm);
            if (tm.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(tm, 10, false);
            } else {
                startLoad(tm, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.dfp.a(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String tm = o.tm(metaData.getAvater());
            setUrl(tm);
            if (tm.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(tm, 10, false);
            } else {
                startLoad(tm, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                tS(metaData.getPendantData().aAJ());
            } else {
                tS(null);
            }
            c(metaData);
        }
    }

    public void a(MetaData metaData, int i) {
        if (metaData != null) {
            this.dfv = i;
            b(metaData);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            if (this.dfw) {
                this.dfo.setVisibility(8);
                return;
            }
            this.dfp.setShowV(false);
            if (!UtilHelper.showHeadBjhBigVIcon(this.dfo, metaData, this.dfv)) {
                if (metaData.isBigV() || !StringUtils.isNull(metaData.getUserTbVipInfoData().getvipV_url())) {
                    this.dfo.setImageDrawable(UtilHelper.getBjhBigVIconDrawable(this.dft));
                    fR(true);
                    return;
                }
                fR(false);
            }
        }
    }

    public void fR(boolean z) {
        if (this.dfo != null) {
            this.dfo.setVisibility(z ? 0 : 8);
        }
    }

    public void setIsclearmode(boolean z) {
        this.dfw = z;
    }
}
