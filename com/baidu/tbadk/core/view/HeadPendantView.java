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
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantView extends RelativeLayout {
    private TbImageView ffS;
    private ImageView ffT;
    private HeadImageView ffU;
    private boolean ffV;
    private boolean ffW;
    private boolean ffX;
    private boolean ffY;
    private int ffZ;
    private int fga;
    private int fgb;
    private boolean fgc;
    private boolean fgd;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ffV = false;
        this.ffW = false;
        this.ffX = false;
        this.ffY = false;
        this.ffZ = R.drawable.ic_icon_mask_shen20_n;
        this.fga = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.fgb = 0;
        this.fgd = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ffV = false;
        this.ffW = false;
        this.ffX = false;
        this.ffY = false;
        this.ffZ = R.drawable.ic_icon_mask_shen20_n;
        this.fga = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.fgb = 0;
        this.fgd = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.ffV = false;
        this.ffW = false;
        this.ffX = false;
        this.ffY = false;
        this.ffZ = R.drawable.ic_icon_mask_shen20_n;
        this.fga = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.fgb = 0;
        this.fgd = true;
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.ffV = true;
    }

    public void setHasPendantStyle(boolean z) {
        if (this.ffV && !z && this.ffU != null) {
            ((RelativeLayout.LayoutParams) this.ffU.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.ffT != null) {
                ((RelativeLayout.LayoutParams) this.ffT.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (this.ffS != null) {
                this.ffS.setVisibility(8);
            }
            this.ffW = false;
            invalidate();
        } else if (!this.ffV && z && this.ffU != null) {
            int width = (int) (this.ffU.getWidth() * 0.13f);
            int height = (int) (this.ffU.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) this.ffU.getLayoutParams()).setMargins(width, height, width, height);
            if (this.ffT != null) {
                ((RelativeLayout.LayoutParams) this.ffT.getLayoutParams()).setMargins(width, height, width, height);
            }
            invalidate();
        }
        this.ffV = z;
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.ffX = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.ffV) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.ffU.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.ffT != null) {
                ((RelativeLayout.LayoutParams) this.ffT.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        if (this.ffX) {
            ((RelativeLayout.LayoutParams) this.ffU.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.ffT != null) {
                ((RelativeLayout.LayoutParams) this.ffT.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    public void Bz(String str) {
        if (this.ffS != null) {
            if (this.ffV && !StringUtils.isNull(str)) {
                this.ffW = true;
                this.ffS.setVisibility(0);
                this.ffS.setImageDrawable(null);
                this.ffS.startLoad(str, 10, false);
                return;
            }
            this.ffS.setVisibility(8);
            this.ffW = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.ffS.setAutoChangeStyle(z);
        this.ffU.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.fga = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        btP();
        btQ();
        btR();
    }

    private void btP() {
        this.ffU = new HeadImageView(this.mContext);
        this.ffU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ffU.setPlaceHolder(1);
        this.ffU.setDefaultResource(R.color.CAM_X0205);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.ffU.setLayoutParams(layoutParams);
        addView(this.ffU);
    }

    private void btQ() {
        this.ffS = new TbImageView(this.mContext);
        this.ffS.setPageId(this.mPageId);
        this.ffS.setDefaultBgResource(0);
        this.ffS.setDefaultResource(0);
        this.ffS.setImageDrawable(null);
        this.ffS.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.ffS.setVisibility(8);
        addView(this.ffS);
    }

    private void btR() {
        this.ffT = new ImageView(this.mContext);
        this.ffT.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.fga, this.fga);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.ffT.setLayoutParams(layoutParams);
        this.ffT.setVisibility(8);
        addView(this.ffT);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.ffU != null) {
            this.ffU.setPageId(bdUniqueId);
        }
        if (this.ffS != null) {
            this.ffS.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.ffS;
    }

    public HeadImageView getHeadView() {
        return this.ffU;
    }

    public ImageView getBigVIconView() {
        return this.ffT;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.fga = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        btS();
    }

    private void btS() {
        if (this.fga > 0 && this.ffT != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ffT.getLayoutParams();
            layoutParams.width = this.fga;
            layoutParams.height = this.fga;
            this.ffT.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.ffZ = i;
    }

    public void setAuthIconType(int i) {
        this.fgb = i;
    }

    public void setUrl(String str) {
        this.ffU.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.ffU.setDefaultResource(i);
    }

    public void BA(String str) {
        if (!StringUtils.isNull(str)) {
            String AV = r.AV(str);
            this.ffU.setImageBitmap(null);
            this.ffU.setUrl(AV);
            if (AV.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(AV, 10, false);
            } else {
                startLoad(AV, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.ffU.a(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String AV = r.AV(metaData.getAvater());
            setUrl(AV);
            if (AV.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(AV, 10, false);
            } else {
                startLoad(AV, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                Bz(metaData.getPendantData().getImgUrl());
            } else {
                Bz(null);
            }
            c(metaData);
        }
    }

    public void a(MetaData metaData, int i) {
        if (metaData != null) {
            this.fgb = i;
            b(metaData);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            if (this.fgc) {
                this.ffT.setVisibility(8);
                return;
            }
            this.ffU.setShowV(false);
            if (!UtilHelper.showOfficialIcon(this.ffT, metaData)) {
                if (metaData.isNewGod()) {
                    SvgManager.bsR().a(this.ffT, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
                    jY(true);
                    return;
                }
                jY(false);
                if (this.ffY || !UtilHelper.showHeadBazhuIcon(this.ffT, metaData, this.fgd)) {
                    UtilHelper.showHeadBjhBigVIcon(this.ffT, metaData, this.fgb);
                }
            }
        }
    }

    public void jY(boolean z) {
        if (this.ffT != null) {
            this.ffT.setVisibility(z ? 0 : 8);
        }
    }

    public void setIsclearmode(boolean z) {
        this.fgc = z;
    }

    public void setIsHomePage(boolean z) {
        this.ffY = z;
    }

    public void setShowSimpleIcon(boolean z) {
        this.fgd = z;
    }
}
