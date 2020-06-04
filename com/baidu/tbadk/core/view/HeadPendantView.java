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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantView extends RelativeLayout {
    private TbImageView dTa;
    private ImageView dTb;
    private HeadImageView dTc;
    private boolean dTd;
    private boolean dTe;
    private boolean dTf;
    private int dTg;
    private int dTh;
    private int dTi;
    private boolean dTj;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dTd = false;
        this.dTe = false;
        this.dTf = false;
        this.dTg = R.drawable.ic_icon_mask_shen20_n;
        this.dTh = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.dTi = 0;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dTd = false;
        this.dTe = false;
        this.dTf = false;
        this.dTg = R.drawable.ic_icon_mask_shen20_n;
        this.dTh = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.dTi = 0;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.dTd = false;
        this.dTe = false;
        this.dTf = false;
        this.dTg = R.drawable.ic_icon_mask_shen20_n;
        this.dTh = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.dTi = 0;
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.dTd = true;
    }

    public void setHasPendantStyle(boolean z) {
        if (this.dTd && !z && this.dTc != null) {
            ((RelativeLayout.LayoutParams) this.dTc.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.dTb != null) {
                ((RelativeLayout.LayoutParams) this.dTb.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (this.dTa != null) {
                this.dTa.setVisibility(8);
            }
            this.dTe = false;
            invalidate();
        } else if (!this.dTd && z && this.dTc != null) {
            int width = (int) (this.dTc.getWidth() * 0.13f);
            int height = (int) (this.dTc.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) this.dTc.getLayoutParams()).setMargins(width, height, width, height);
            if (this.dTb != null) {
                ((RelativeLayout.LayoutParams) this.dTb.getLayoutParams()).setMargins(width, height, width, height);
            }
            invalidate();
        }
        this.dTd = z;
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.dTf = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.dTd) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.dTc.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.dTb != null) {
                ((RelativeLayout.LayoutParams) this.dTb.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        if (this.dTf) {
            ((RelativeLayout.LayoutParams) this.dTc.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.dTb != null) {
                ((RelativeLayout.LayoutParams) this.dTb.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    public void wP(String str) {
        if (this.dTa != null) {
            if (this.dTd && !StringUtils.isNull(str)) {
                this.dTe = true;
                this.dTa.setVisibility(0);
                this.dTa.setImageDrawable(null);
                this.dTa.startLoad(str, 10, false);
                return;
            }
            this.dTa.setVisibility(8);
            this.dTe = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.dTa.setAutoChangeStyle(z);
        this.dTc.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.dTh = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        aVU();
        aVV();
        aVW();
    }

    private void aVU() {
        this.dTc = new HeadImageView(this.mContext);
        this.dTc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dTc.setPlaceHolder(1);
        this.dTc.setDefaultResource(R.color.cp_bg_line_e);
        this.dTc.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.dTc.setLayoutParams(layoutParams);
        addView(this.dTc);
    }

    private void aVV() {
        this.dTa = new TbImageView(this.mContext);
        this.dTa.setPageId(this.mPageId);
        this.dTa.setDefaultBgResource(0);
        this.dTa.setDefaultResource(0);
        this.dTa.setDefaultErrorResource(0);
        this.dTa.setImageDrawable(null);
        this.dTa.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.dTa.setVisibility(8);
        addView(this.dTa);
    }

    private void aVW() {
        this.dTb = new ImageView(this.mContext);
        this.dTb.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.dTh, this.dTh);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.dTb.setLayoutParams(layoutParams);
        this.dTb.setVisibility(8);
        addView(this.dTb);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.dTc != null) {
            this.dTc.setPageId(bdUniqueId);
        }
        if (this.dTa != null) {
            this.dTa.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.dTa;
    }

    public HeadImageView getHeadView() {
        return this.dTc;
    }

    public ImageView getBigVIconView() {
        return this.dTb;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.dTh = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        aVX();
    }

    private void aVX() {
        if (this.dTh > 0 && this.dTb != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dTb.getLayoutParams();
            layoutParams.width = this.dTh;
            layoutParams.height = this.dTh;
            this.dTb.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.dTg = i;
    }

    public void setAuthIconType(int i) {
        this.dTi = i;
    }

    public void setUrl(String str) {
        this.dTc.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.dTc.setDefaultResource(i);
    }

    public void wQ(String str) {
        if (!StringUtils.isNull(str)) {
            String wj = o.wj(str);
            this.dTc.setImageBitmap(null);
            this.dTc.setUrl(wj);
            if (wj.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(wj, 10, false);
            } else {
                startLoad(wj, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.dTc.a(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String wj = o.wj(metaData.getAvater());
            setUrl(wj);
            if (wj.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(wj, 10, false);
            } else {
                startLoad(wj, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                wP(metaData.getPendantData().aOP());
            } else {
                wP(null);
            }
            c(metaData);
        }
    }

    public void a(MetaData metaData, int i) {
        if (metaData != null) {
            this.dTi = i;
            b(metaData);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            if (this.dTj) {
                this.dTb.setVisibility(8);
                return;
            }
            this.dTc.setShowV(false);
            if (!UtilHelper.showHeadBjhBigVIcon(this.dTb, metaData, this.dTi)) {
                if (metaData.isNewGod() && this.dTi != 4) {
                    SvgManager.aUW().a(this.dTb, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
                    hj(true);
                    return;
                }
                hj(false);
            }
        }
    }

    public void hj(boolean z) {
        if (this.dTb != null) {
            this.dTb.setVisibility(z ? 0 : 8);
        }
    }

    public void setIsclearmode(boolean z) {
        this.dTj = z;
    }
}
