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
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantView extends RelativeLayout {
    private TbImageView dZT;
    private ImageView dZU;
    private HeadImageView dZV;
    private boolean dZW;
    private boolean dZX;
    private boolean dZY;
    private boolean dZZ;
    private int eaa;
    private int eab;
    private int eac;
    private boolean ead;
    private boolean eae;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dZW = false;
        this.dZX = false;
        this.dZY = false;
        this.dZZ = false;
        this.eaa = R.drawable.ic_icon_mask_shen20_n;
        this.eab = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.eac = 0;
        this.eae = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dZW = false;
        this.dZX = false;
        this.dZY = false;
        this.dZZ = false;
        this.eaa = R.drawable.ic_icon_mask_shen20_n;
        this.eab = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.eac = 0;
        this.eae = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.dZW = false;
        this.dZX = false;
        this.dZY = false;
        this.dZZ = false;
        this.eaa = R.drawable.ic_icon_mask_shen20_n;
        this.eab = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.eac = 0;
        this.eae = true;
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.dZW = true;
    }

    public void setHasPendantStyle(boolean z) {
        if (this.dZW && !z && this.dZV != null) {
            ((RelativeLayout.LayoutParams) this.dZV.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.dZU != null) {
                ((RelativeLayout.LayoutParams) this.dZU.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (this.dZT != null) {
                this.dZT.setVisibility(8);
            }
            this.dZX = false;
            invalidate();
        } else if (!this.dZW && z && this.dZV != null) {
            int width = (int) (this.dZV.getWidth() * 0.13f);
            int height = (int) (this.dZV.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) this.dZV.getLayoutParams()).setMargins(width, height, width, height);
            if (this.dZU != null) {
                ((RelativeLayout.LayoutParams) this.dZU.getLayoutParams()).setMargins(width, height, width, height);
            }
            invalidate();
        }
        this.dZW = z;
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.dZY = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.dZW) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.dZV.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.dZU != null) {
                ((RelativeLayout.LayoutParams) this.dZU.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        if (this.dZY) {
            ((RelativeLayout.LayoutParams) this.dZV.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.dZU != null) {
                ((RelativeLayout.LayoutParams) this.dZU.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    public void xg(String str) {
        if (this.dZT != null) {
            if (this.dZW && !StringUtils.isNull(str)) {
                this.dZX = true;
                this.dZT.setVisibility(0);
                this.dZT.setImageDrawable(null);
                this.dZT.startLoad(str, 10, false);
                return;
            }
            this.dZT.setVisibility(8);
            this.dZX = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.dZT.setAutoChangeStyle(z);
        this.dZV.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.eab = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        aXO();
        aXP();
        aXQ();
    }

    private void aXO() {
        this.dZV = new HeadImageView(this.mContext);
        this.dZV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dZV.setPlaceHolder(1);
        this.dZV.setDefaultResource(R.color.cp_bg_line_e);
        this.dZV.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.dZV.setLayoutParams(layoutParams);
        addView(this.dZV);
    }

    private void aXP() {
        this.dZT = new TbImageView(this.mContext);
        this.dZT.setPageId(this.mPageId);
        this.dZT.setDefaultBgResource(0);
        this.dZT.setDefaultResource(0);
        this.dZT.setDefaultErrorResource(0);
        this.dZT.setImageDrawable(null);
        this.dZT.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.dZT.setVisibility(8);
        addView(this.dZT);
    }

    private void aXQ() {
        this.dZU = new ImageView(this.mContext);
        this.dZU.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.eab, this.eab);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.dZU.setLayoutParams(layoutParams);
        this.dZU.setVisibility(8);
        addView(this.dZU);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.dZV != null) {
            this.dZV.setPageId(bdUniqueId);
        }
        if (this.dZT != null) {
            this.dZT.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.dZT;
    }

    public HeadImageView getHeadView() {
        return this.dZV;
    }

    public ImageView getBigVIconView() {
        return this.dZU;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.eab = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        aXR();
    }

    private void aXR() {
        if (this.eab > 0 && this.dZU != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dZU.getLayoutParams();
            layoutParams.width = this.eab;
            layoutParams.height = this.eab;
            this.dZU.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.eaa = i;
    }

    public void setAuthIconType(int i) {
        this.eac = i;
    }

    public void setUrl(String str) {
        this.dZV.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.dZV.setDefaultResource(i);
    }

    public void xh(String str) {
        if (!StringUtils.isNull(str)) {
            String wz = p.wz(str);
            this.dZV.setImageBitmap(null);
            this.dZV.setUrl(wz);
            if (wz.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(wz, 10, false);
            } else {
                startLoad(wz, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.dZV.a(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String wz = p.wz(metaData.getAvater());
            setUrl(wz);
            if (wz.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(wz, 10, false);
            } else {
                startLoad(wz, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                xg(metaData.getPendantData().aQl());
            } else {
                xg(null);
            }
            c(metaData);
        }
    }

    public void a(MetaData metaData, int i) {
        if (metaData != null) {
            this.eac = i;
            b(metaData);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            if (this.ead) {
                this.dZU.setVisibility(8);
                return;
            }
            this.dZV.setShowV(false);
            if (!UtilHelper.showHeadBjhBigVIcon(this.dZU, metaData, this.eac)) {
                if (this.dZZ || !UtilHelper.showHeadBazhuIcon(this.dZU, metaData, this.eae)) {
                    if (metaData.isNewGod()) {
                        SvgManager.aWQ().a(this.dZU, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
                        hs(true);
                        return;
                    }
                    hs(false);
                }
            }
        }
    }

    public void hs(boolean z) {
        if (this.dZU != null) {
            this.dZU.setVisibility(z ? 0 : 8);
        }
    }

    public void setIsclearmode(boolean z) {
        this.ead = z;
    }

    public void setIsHomePage(boolean z) {
        this.dZZ = z;
    }

    public void setShowSimpleIcon(boolean z) {
        this.eae = z;
    }
}
