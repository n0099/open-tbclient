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
    private TbImageView fdD;
    private ImageView fdE;
    private HeadImageView fdF;
    private boolean fdG;
    private boolean fdH;
    private boolean fdI;
    private boolean fdJ;
    private int fdK;
    private int fdL;
    private int fdM;
    private boolean fdN;
    private boolean fdO;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fdG = false;
        this.fdH = false;
        this.fdI = false;
        this.fdJ = false;
        this.fdK = R.drawable.ic_icon_mask_shen20_n;
        this.fdL = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.fdM = 0;
        this.fdO = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fdG = false;
        this.fdH = false;
        this.fdI = false;
        this.fdJ = false;
        this.fdK = R.drawable.ic_icon_mask_shen20_n;
        this.fdL = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.fdM = 0;
        this.fdO = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.fdG = false;
        this.fdH = false;
        this.fdI = false;
        this.fdJ = false;
        this.fdK = R.drawable.ic_icon_mask_shen20_n;
        this.fdL = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.fdM = 0;
        this.fdO = true;
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.fdG = true;
    }

    public void setHasPendantStyle(boolean z) {
        if (this.fdG && !z && this.fdF != null) {
            ((RelativeLayout.LayoutParams) this.fdF.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.fdE != null) {
                ((RelativeLayout.LayoutParams) this.fdE.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (this.fdD != null) {
                this.fdD.setVisibility(8);
            }
            this.fdH = false;
            invalidate();
        } else if (!this.fdG && z && this.fdF != null) {
            int width = (int) (this.fdF.getWidth() * 0.13f);
            int height = (int) (this.fdF.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) this.fdF.getLayoutParams()).setMargins(width, height, width, height);
            if (this.fdE != null) {
                ((RelativeLayout.LayoutParams) this.fdE.getLayoutParams()).setMargins(width, height, width, height);
            }
            invalidate();
        }
        this.fdG = z;
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.fdI = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.fdG) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.fdF.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.fdE != null) {
                ((RelativeLayout.LayoutParams) this.fdE.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        if (this.fdI) {
            ((RelativeLayout.LayoutParams) this.fdF.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.fdE != null) {
                ((RelativeLayout.LayoutParams) this.fdE.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    public void Bi(String str) {
        if (this.fdD != null) {
            if (this.fdG && !StringUtils.isNull(str)) {
                this.fdH = true;
                this.fdD.setVisibility(0);
                this.fdD.setImageDrawable(null);
                this.fdD.startLoad(str, 10, false);
                return;
            }
            this.fdD.setVisibility(8);
            this.fdH = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.fdD.setAutoChangeStyle(z);
        this.fdF.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.fdL = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        btv();
        btw();
        btx();
    }

    private void btv() {
        this.fdF = new HeadImageView(this.mContext);
        this.fdF.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fdF.setPlaceHolder(1);
        this.fdF.setDefaultResource(R.color.CAM_X0205);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.fdF.setLayoutParams(layoutParams);
        addView(this.fdF);
    }

    private void btw() {
        this.fdD = new TbImageView(this.mContext);
        this.fdD.setPageId(this.mPageId);
        this.fdD.setDefaultBgResource(0);
        this.fdD.setDefaultResource(0);
        this.fdD.setImageDrawable(null);
        this.fdD.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.fdD.setVisibility(8);
        addView(this.fdD);
    }

    private void btx() {
        this.fdE = new ImageView(this.mContext);
        this.fdE.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.fdL, this.fdL);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.fdE.setLayoutParams(layoutParams);
        this.fdE.setVisibility(8);
        addView(this.fdE);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.fdF != null) {
            this.fdF.setPageId(bdUniqueId);
        }
        if (this.fdD != null) {
            this.fdD.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.fdD;
    }

    public HeadImageView getHeadView() {
        return this.fdF;
    }

    public ImageView getBigVIconView() {
        return this.fdE;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.fdL = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        bty();
    }

    private void bty() {
        if (this.fdL > 0 && this.fdE != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fdE.getLayoutParams();
            layoutParams.width = this.fdL;
            layoutParams.height = this.fdL;
            this.fdE.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.fdK = i;
    }

    public void setAuthIconType(int i) {
        this.fdM = i;
    }

    public void setUrl(String str) {
        this.fdF.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.fdF.setDefaultResource(i);
    }

    public void Bj(String str) {
        if (!StringUtils.isNull(str)) {
            String AE = q.AE(str);
            this.fdF.setImageBitmap(null);
            this.fdF.setUrl(AE);
            if (AE.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(AE, 10, false);
            } else {
                startLoad(AE, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.fdF.a(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String AE = q.AE(metaData.getAvater());
            setUrl(AE);
            if (AE.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(AE, 10, false);
            } else {
                startLoad(AE, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                Bi(metaData.getPendantData().getImgUrl());
            } else {
                Bi(null);
            }
            c(metaData);
        }
    }

    public void a(MetaData metaData, int i) {
        if (metaData != null) {
            this.fdM = i;
            b(metaData);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            if (this.fdN) {
                this.fdE.setVisibility(8);
                return;
            }
            this.fdF.setShowV(false);
            if (!UtilHelper.showOfficialIcon(this.fdE, metaData)) {
                if (metaData.isNewGod()) {
                    SvgManager.bsx().a(this.fdE, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
                    jV(true);
                    return;
                }
                jV(false);
                if (this.fdJ || !UtilHelper.showHeadBazhuIcon(this.fdE, metaData, this.fdO)) {
                    UtilHelper.showHeadBjhBigVIcon(this.fdE, metaData, this.fdM);
                }
            }
        }
    }

    public void jV(boolean z) {
        if (this.fdE != null) {
            this.fdE.setVisibility(z ? 0 : 8);
        }
    }

    public void setIsclearmode(boolean z) {
        this.fdN = z;
    }

    public void setIsHomePage(boolean z) {
        this.fdJ = z;
    }

    public void setShowSimpleIcon(boolean z) {
        this.fdO = z;
    }
}
