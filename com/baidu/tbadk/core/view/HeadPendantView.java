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
    private TbImageView epP;
    private ImageView epQ;
    private HeadImageView epR;
    private boolean epS;
    private boolean epT;
    private boolean epU;
    private boolean epV;
    private int epW;
    private int epX;
    private int epY;
    private boolean epZ;
    private boolean eqa;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.epS = false;
        this.epT = false;
        this.epU = false;
        this.epV = false;
        this.epW = R.drawable.ic_icon_mask_shen20_n;
        this.epX = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.epY = 0;
        this.eqa = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.epS = false;
        this.epT = false;
        this.epU = false;
        this.epV = false;
        this.epW = R.drawable.ic_icon_mask_shen20_n;
        this.epX = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.epY = 0;
        this.eqa = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.epS = false;
        this.epT = false;
        this.epU = false;
        this.epV = false;
        this.epW = R.drawable.ic_icon_mask_shen20_n;
        this.epX = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.epY = 0;
        this.eqa = true;
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.epS = true;
    }

    public void setHasPendantStyle(boolean z) {
        if (this.epS && !z && this.epR != null) {
            ((RelativeLayout.LayoutParams) this.epR.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.epQ != null) {
                ((RelativeLayout.LayoutParams) this.epQ.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (this.epP != null) {
                this.epP.setVisibility(8);
            }
            this.epT = false;
            invalidate();
        } else if (!this.epS && z && this.epR != null) {
            int width = (int) (this.epR.getWidth() * 0.13f);
            int height = (int) (this.epR.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) this.epR.getLayoutParams()).setMargins(width, height, width, height);
            if (this.epQ != null) {
                ((RelativeLayout.LayoutParams) this.epQ.getLayoutParams()).setMargins(width, height, width, height);
            }
            invalidate();
        }
        this.epS = z;
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.epU = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.epS) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.epR.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.epQ != null) {
                ((RelativeLayout.LayoutParams) this.epQ.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        if (this.epU) {
            ((RelativeLayout.LayoutParams) this.epR.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.epQ != null) {
                ((RelativeLayout.LayoutParams) this.epQ.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    public void AA(String str) {
        if (this.epP != null) {
            if (this.epS && !StringUtils.isNull(str)) {
                this.epT = true;
                this.epP.setVisibility(0);
                this.epP.setImageDrawable(null);
                this.epP.startLoad(str, 10, false);
                return;
            }
            this.epP.setVisibility(8);
            this.epT = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.epP.setAutoChangeStyle(z);
        this.epR.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.epX = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        bkk();
        bkl();
        bkm();
    }

    private void bkk() {
        this.epR = new HeadImageView(this.mContext);
        this.epR.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.epR.setPlaceHolder(1);
        this.epR.setDefaultResource(R.color.cp_bg_line_e);
        this.epR.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.epR.setLayoutParams(layoutParams);
        addView(this.epR);
    }

    private void bkl() {
        this.epP = new TbImageView(this.mContext);
        this.epP.setPageId(this.mPageId);
        this.epP.setDefaultBgResource(0);
        this.epP.setDefaultResource(0);
        this.epP.setDefaultErrorResource(0);
        this.epP.setImageDrawable(null);
        this.epP.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.epP.setVisibility(8);
        addView(this.epP);
    }

    private void bkm() {
        this.epQ = new ImageView(this.mContext);
        this.epQ.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.epX, this.epX);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.epQ.setLayoutParams(layoutParams);
        this.epQ.setVisibility(8);
        addView(this.epQ);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.epR != null) {
            this.epR.setPageId(bdUniqueId);
        }
        if (this.epP != null) {
            this.epP.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.epP;
    }

    public HeadImageView getHeadView() {
        return this.epR;
    }

    public ImageView getBigVIconView() {
        return this.epQ;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.epX = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        bkn();
    }

    private void bkn() {
        if (this.epX > 0 && this.epQ != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.epQ.getLayoutParams();
            layoutParams.width = this.epX;
            layoutParams.height = this.epX;
            this.epQ.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.epW = i;
    }

    public void setAuthIconType(int i) {
        this.epY = i;
    }

    public void setUrl(String str) {
        this.epR.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.epR.setDefaultResource(i);
    }

    public void AB(String str) {
        if (!StringUtils.isNull(str)) {
            String zW = q.zW(str);
            this.epR.setImageBitmap(null);
            this.epR.setUrl(zW);
            if (zW.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(zW, 10, false);
            } else {
                startLoad(zW, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.epR.a(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String zW = q.zW(metaData.getAvater());
            setUrl(zW);
            if (zW.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(zW, 10, false);
            } else {
                startLoad(zW, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                AA(metaData.getPendantData().bcA());
            } else {
                AA(null);
            }
            c(metaData);
        }
    }

    public void a(MetaData metaData, int i) {
        if (metaData != null) {
            this.epY = i;
            b(metaData);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            if (this.epZ) {
                this.epQ.setVisibility(8);
                return;
            }
            this.epR.setShowV(false);
            if (metaData.isNewGod()) {
                SvgManager.bjq().a(this.epQ, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
                iv(true);
                return;
            }
            iv(false);
            if (this.epV || !UtilHelper.showHeadBazhuIcon(this.epQ, metaData, this.eqa)) {
                UtilHelper.showHeadBjhBigVIcon(this.epQ, metaData, this.epY);
            }
        }
    }

    public void iv(boolean z) {
        if (this.epQ != null) {
            this.epQ.setVisibility(z ? 0 : 8);
        }
    }

    public void setIsclearmode(boolean z) {
        this.epZ = z;
    }

    public void setIsHomePage(boolean z) {
        this.epV = z;
    }

    public void setShowSimpleIcon(boolean z) {
        this.eqa = z;
    }
}
