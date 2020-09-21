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
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantView extends RelativeLayout {
    private TbImageView erU;
    private ImageView erV;
    private HeadImageView erW;
    private boolean erX;
    private boolean erY;
    private boolean erZ;
    private boolean esa;
    private int esb;
    private int esc;
    private int esd;
    private boolean ese;
    private boolean esf;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.erX = false;
        this.erY = false;
        this.erZ = false;
        this.esa = false;
        this.esb = R.drawable.ic_icon_mask_shen20_n;
        this.esc = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.esd = 0;
        this.esf = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.erX = false;
        this.erY = false;
        this.erZ = false;
        this.esa = false;
        this.esb = R.drawable.ic_icon_mask_shen20_n;
        this.esc = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.esd = 0;
        this.esf = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.erX = false;
        this.erY = false;
        this.erZ = false;
        this.esa = false;
        this.esb = R.drawable.ic_icon_mask_shen20_n;
        this.esc = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.esd = 0;
        this.esf = true;
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.erX = true;
    }

    public void setHasPendantStyle(boolean z) {
        if (this.erX && !z && this.erW != null) {
            ((RelativeLayout.LayoutParams) this.erW.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.erV != null) {
                ((RelativeLayout.LayoutParams) this.erV.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (this.erU != null) {
                this.erU.setVisibility(8);
            }
            this.erY = false;
            invalidate();
        } else if (!this.erX && z && this.erW != null) {
            int width = (int) (this.erW.getWidth() * 0.13f);
            int height = (int) (this.erW.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) this.erW.getLayoutParams()).setMargins(width, height, width, height);
            if (this.erV != null) {
                ((RelativeLayout.LayoutParams) this.erV.getLayoutParams()).setMargins(width, height, width, height);
            }
            invalidate();
        }
        this.erX = z;
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.erZ = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.erX) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.erW.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.erV != null) {
                ((RelativeLayout.LayoutParams) this.erV.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        if (this.erZ) {
            ((RelativeLayout.LayoutParams) this.erW.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.erV != null) {
                ((RelativeLayout.LayoutParams) this.erV.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    public void AW(String str) {
        if (this.erU != null) {
            if (this.erX && !StringUtils.isNull(str)) {
                this.erY = true;
                this.erU.setVisibility(0);
                this.erU.setImageDrawable(null);
                this.erU.startLoad(str, 10, false);
                return;
            }
            this.erU.setVisibility(8);
            this.erY = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.erU.setAutoChangeStyle(z);
        this.erW.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.esc = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        blf();
        blg();
        blh();
    }

    private void blf() {
        this.erW = new HeadImageView(this.mContext);
        this.erW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.erW.setPlaceHolder(1);
        this.erW.setDefaultResource(R.color.cp_bg_line_e);
        this.erW.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.erW.setLayoutParams(layoutParams);
        addView(this.erW);
    }

    private void blg() {
        this.erU = new TbImageView(this.mContext);
        this.erU.setPageId(this.mPageId);
        this.erU.setDefaultBgResource(0);
        this.erU.setDefaultResource(0);
        this.erU.setDefaultErrorResource(0);
        this.erU.setImageDrawable(null);
        this.erU.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.erU.setVisibility(8);
        addView(this.erU);
    }

    private void blh() {
        this.erV = new ImageView(this.mContext);
        this.erV.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.esc, this.esc);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.erV.setLayoutParams(layoutParams);
        this.erV.setVisibility(8);
        addView(this.erV);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.erW != null) {
            this.erW.setPageId(bdUniqueId);
        }
        if (this.erU != null) {
            this.erU.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.erU;
    }

    public HeadImageView getHeadView() {
        return this.erW;
    }

    public ImageView getBigVIconView() {
        return this.erV;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.esc = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        bli();
    }

    private void bli() {
        if (this.esc > 0 && this.erV != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.erV.getLayoutParams();
            layoutParams.width = this.esc;
            layoutParams.height = this.esc;
            this.erV.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.esb = i;
    }

    public void setAuthIconType(int i) {
        this.esd = i;
    }

    public void setUrl(String str) {
        this.erW.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.erW.setDefaultResource(i);
    }

    public void AX(String str) {
        if (!StringUtils.isNull(str)) {
            String As = q.As(str);
            this.erW.setImageBitmap(null);
            this.erW.setUrl(As);
            if (As.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(As, 10, false);
            } else {
                startLoad(As, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.erW.a(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String As = q.As(metaData.getAvater());
            setUrl(As);
            if (As.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(As, 10, false);
            } else {
                startLoad(As, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                AW(metaData.getPendantData().bdu());
            } else {
                AW(null);
            }
            c(metaData);
        }
    }

    public void a(MetaData metaData, int i) {
        if (metaData != null) {
            this.esd = i;
            b(metaData);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            if (this.ese) {
                this.erV.setVisibility(8);
                return;
            }
            this.erW.setShowV(false);
            if (metaData.isNewGod()) {
                SvgManager.bkl().a(this.erV, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
                is(true);
                return;
            }
            is(false);
            if (this.esa || !UtilHelper.showHeadBazhuIcon(this.erV, metaData, this.esf)) {
                UtilHelper.showHeadBjhBigVIcon(this.erV, metaData, this.esd);
            }
        }
    }

    public void is(boolean z) {
        if (this.erV != null) {
            this.erV.setVisibility(z ? 0 : 8);
        }
    }

    public void setIsclearmode(boolean z) {
        this.ese = z;
    }

    public void setIsHomePage(boolean z) {
        this.esa = z;
    }

    public void setShowSimpleIcon(boolean z) {
        this.esf = z;
    }
}
