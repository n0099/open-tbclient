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
    private TbImageView eYK;
    private ImageView eYL;
    private HeadImageView eYM;
    private boolean eYN;
    private boolean eYO;
    private boolean eYP;
    private boolean eYQ;
    private int eYR;
    private int eYS;
    private int eYT;
    private boolean eYU;
    private boolean eYV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eYN = false;
        this.eYO = false;
        this.eYP = false;
        this.eYQ = false;
        this.eYR = R.drawable.ic_icon_mask_shen20_n;
        this.eYS = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.eYT = 0;
        this.eYV = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eYN = false;
        this.eYO = false;
        this.eYP = false;
        this.eYQ = false;
        this.eYR = R.drawable.ic_icon_mask_shen20_n;
        this.eYS = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.eYT = 0;
        this.eYV = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.eYN = false;
        this.eYO = false;
        this.eYP = false;
        this.eYQ = false;
        this.eYR = R.drawable.ic_icon_mask_shen20_n;
        this.eYS = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.eYT = 0;
        this.eYV = true;
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.eYN = true;
    }

    public void setHasPendantStyle(boolean z) {
        if (this.eYN && !z && this.eYM != null) {
            ((RelativeLayout.LayoutParams) this.eYM.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.eYL != null) {
                ((RelativeLayout.LayoutParams) this.eYL.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (this.eYK != null) {
                this.eYK.setVisibility(8);
            }
            this.eYO = false;
            invalidate();
        } else if (!this.eYN && z && this.eYM != null) {
            int width = (int) (this.eYM.getWidth() * 0.13f);
            int height = (int) (this.eYM.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) this.eYM.getLayoutParams()).setMargins(width, height, width, height);
            if (this.eYL != null) {
                ((RelativeLayout.LayoutParams) this.eYL.getLayoutParams()).setMargins(width, height, width, height);
            }
            invalidate();
        }
        this.eYN = z;
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.eYP = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.eYN) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.eYM.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.eYL != null) {
                ((RelativeLayout.LayoutParams) this.eYL.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        if (this.eYP) {
            ((RelativeLayout.LayoutParams) this.eYM.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.eYL != null) {
                ((RelativeLayout.LayoutParams) this.eYL.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    public void Cw(String str) {
        if (this.eYK != null) {
            if (this.eYN && !StringUtils.isNull(str)) {
                this.eYO = true;
                this.eYK.setVisibility(0);
                this.eYK.setImageDrawable(null);
                this.eYK.startLoad(str, 10, false);
                return;
            }
            this.eYK.setVisibility(8);
            this.eYO = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.eYK.setAutoChangeStyle(z);
        this.eYM.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.eYS = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        buT();
        buU();
        buV();
    }

    private void buT() {
        this.eYM = new HeadImageView(this.mContext);
        this.eYM.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eYM.setPlaceHolder(1);
        this.eYM.setDefaultResource(R.color.CAM_X0205);
        this.eYM.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.eYM.setLayoutParams(layoutParams);
        addView(this.eYM);
    }

    private void buU() {
        this.eYK = new TbImageView(this.mContext);
        this.eYK.setPageId(this.mPageId);
        this.eYK.setDefaultBgResource(0);
        this.eYK.setDefaultResource(0);
        this.eYK.setDefaultErrorResource(0);
        this.eYK.setImageDrawable(null);
        this.eYK.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.eYK.setVisibility(8);
        addView(this.eYK);
    }

    private void buV() {
        this.eYL = new ImageView(this.mContext);
        this.eYL.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.eYS, this.eYS);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.eYL.setLayoutParams(layoutParams);
        this.eYL.setVisibility(8);
        addView(this.eYL);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.eYM != null) {
            this.eYM.setPageId(bdUniqueId);
        }
        if (this.eYK != null) {
            this.eYK.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.eYK;
    }

    public HeadImageView getHeadView() {
        return this.eYM;
    }

    public ImageView getBigVIconView() {
        return this.eYL;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.eYS = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        buW();
    }

    private void buW() {
        if (this.eYS > 0 && this.eYL != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eYL.getLayoutParams();
            layoutParams.width = this.eYS;
            layoutParams.height = this.eYS;
            this.eYL.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.eYR = i;
    }

    public void setAuthIconType(int i) {
        this.eYT = i;
    }

    public void setUrl(String str) {
        this.eYM.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.eYM.setDefaultResource(i);
    }

    public void Cx(String str) {
        if (!StringUtils.isNull(str)) {
            String BR = q.BR(str);
            this.eYM.setImageBitmap(null);
            this.eYM.setUrl(BR);
            if (BR.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(BR, 10, false);
            } else {
                startLoad(BR, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.eYM.a(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String BR = q.BR(metaData.getAvater());
            setUrl(BR);
            if (BR.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(BR, 10, false);
            } else {
                startLoad(BR, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                Cw(metaData.getPendantData().bmL());
            } else {
                Cw(null);
            }
            c(metaData);
        }
    }

    public void a(MetaData metaData, int i) {
        if (metaData != null) {
            this.eYT = i;
            b(metaData);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            if (this.eYU) {
                this.eYL.setVisibility(8);
                return;
            }
            this.eYM.setShowV(false);
            if (!UtilHelper.showOfficialIcon(this.eYL, metaData)) {
                if (metaData.isNewGod()) {
                    SvgManager.btW().a(this.eYL, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
                    jD(true);
                    return;
                }
                jD(false);
                if (this.eYQ || !UtilHelper.showHeadBazhuIcon(this.eYL, metaData, this.eYV)) {
                    UtilHelper.showHeadBjhBigVIcon(this.eYL, metaData, this.eYT);
                }
            }
        }
    }

    public void jD(boolean z) {
        if (this.eYL != null) {
            this.eYL.setVisibility(z ? 0 : 8);
        }
    }

    public void setIsclearmode(boolean z) {
        this.eYU = z;
    }

    public void setIsHomePage(boolean z) {
        this.eYQ = z;
    }

    public void setShowSimpleIcon(boolean z) {
        this.eYV = z;
    }
}
