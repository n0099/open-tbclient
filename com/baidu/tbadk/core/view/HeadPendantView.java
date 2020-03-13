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
    private TbImageView dfa;
    private ImageView dfb;
    private HeadImageView dfc;
    private boolean dfd;
    private boolean dfe;
    private boolean dff;
    private int dfg;
    private int dfh;
    private int dfi;
    private boolean dfj;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dfd = false;
        this.dfe = false;
        this.dff = false;
        this.dfg = R.drawable.ic_icon_mask_shen20_n;
        this.dfh = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.dfi = 0;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dfd = false;
        this.dfe = false;
        this.dff = false;
        this.dfg = R.drawable.ic_icon_mask_shen20_n;
        this.dfh = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.dfi = 0;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.dfd = false;
        this.dfe = false;
        this.dff = false;
        this.dfg = R.drawable.ic_icon_mask_shen20_n;
        this.dfh = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.dfi = 0;
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.dfd = true;
    }

    public void setHasPendantStyle(boolean z) {
        if (this.dfd && !z && this.dfc != null) {
            ((RelativeLayout.LayoutParams) this.dfc.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.dfb != null) {
                ((RelativeLayout.LayoutParams) this.dfb.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (this.dfa != null) {
                this.dfa.setVisibility(8);
            }
            this.dfe = false;
            invalidate();
        } else if (!this.dfd && z && this.dfc != null) {
            int width = (int) (this.dfc.getWidth() * 0.13f);
            int height = (int) (this.dfc.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) this.dfc.getLayoutParams()).setMargins(width, height, width, height);
            if (this.dfb != null) {
                ((RelativeLayout.LayoutParams) this.dfb.getLayoutParams()).setMargins(width, height, width, height);
            }
            invalidate();
        }
        this.dfd = z;
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.dff = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.dfd) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.dfc.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.dfb != null) {
                ((RelativeLayout.LayoutParams) this.dfb.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        if (this.dff) {
            ((RelativeLayout.LayoutParams) this.dfc.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.dfb != null) {
                ((RelativeLayout.LayoutParams) this.dfb.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    public void tT(String str) {
        if (this.dfa != null) {
            if (this.dfd && !StringUtils.isNull(str)) {
                this.dfe = true;
                this.dfa.setVisibility(0);
                this.dfa.setImageDrawable(null);
                this.dfa.startLoad(str, 10, false);
                return;
            }
            this.dfa.setVisibility(8);
            this.dfe = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.dfa.setAutoChangeStyle(z);
        this.dfc.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.dfh = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        aHw();
        aHx();
        aHy();
    }

    private void aHw() {
        this.dfc = new HeadImageView(this.mContext);
        this.dfc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dfc.setPlaceHolder(1);
        this.dfc.setDefaultResource(R.color.cp_bg_line_e);
        this.dfc.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.dfc.setLayoutParams(layoutParams);
        addView(this.dfc);
    }

    private void aHx() {
        this.dfa = new TbImageView(this.mContext);
        this.dfa.setPageId(this.mPageId);
        this.dfa.setDefaultBgResource(0);
        this.dfa.setDefaultResource(0);
        this.dfa.setDefaultErrorResource(0);
        this.dfa.setImageDrawable(null);
        this.dfa.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.dfa.setVisibility(8);
        addView(this.dfa);
    }

    private void aHy() {
        this.dfb = new ImageView(this.mContext);
        this.dfb.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.dfh, this.dfh);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.dfb.setLayoutParams(layoutParams);
        this.dfb.setVisibility(8);
        addView(this.dfb);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.dfc != null) {
            this.dfc.setPageId(bdUniqueId);
        }
        if (this.dfa != null) {
            this.dfa.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.dfa;
    }

    public HeadImageView getHeadView() {
        return this.dfc;
    }

    public ImageView getBigVIconView() {
        return this.dfb;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.dfh = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        aHz();
    }

    private void aHz() {
        if (this.dfh > 0 && this.dfb != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dfb.getLayoutParams();
            layoutParams.width = this.dfh;
            layoutParams.height = this.dfh;
            this.dfb.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.dfg = i;
    }

    public void setAuthIconType(int i) {
        this.dfi = i;
    }

    public void setUrl(String str) {
        this.dfc.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.dfc.setDefaultResource(i);
    }

    public void tU(String str) {
        if (!StringUtils.isNull(str)) {
            String tn = o.tn(str);
            this.dfc.setImageBitmap(null);
            this.dfc.setUrl(tn);
            if (tn.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(tn, 10, false);
            } else {
                startLoad(tn, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.dfc.a(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String tn = o.tn(metaData.getAvater());
            setUrl(tn);
            if (tn.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(tn, 10, false);
            } else {
                startLoad(tn, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                tT(metaData.getPendantData().aAG());
            } else {
                tT(null);
            }
            c(metaData);
        }
    }

    public void a(MetaData metaData, int i) {
        if (metaData != null) {
            this.dfi = i;
            b(metaData);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            if (this.dfj) {
                this.dfb.setVisibility(8);
                return;
            }
            this.dfc.setShowV(false);
            if (!UtilHelper.showHeadBjhBigVIcon(this.dfb, metaData, this.dfi)) {
                if (metaData.isBigV() || !StringUtils.isNull(metaData.getUserTbVipInfoData().getvipV_url())) {
                    this.dfb.setImageDrawable(UtilHelper.getBjhBigVIconDrawable(this.dfg));
                    fQ(true);
                    return;
                }
                fQ(false);
            }
        }
    }

    public void fQ(boolean z) {
        if (this.dfb != null) {
            this.dfb.setVisibility(z ? 0 : 8);
        }
    }

    public void setIsclearmode(boolean z) {
        this.dfj = z;
    }
}
