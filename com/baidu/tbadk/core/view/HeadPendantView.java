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
/* loaded from: classes2.dex */
public class HeadPendantView extends RelativeLayout {
    private TbImageView epL;
    private ImageView epM;
    private HeadImageView epN;
    private boolean epO;
    private boolean epP;
    private boolean epQ;
    private boolean epR;
    private int epS;
    private int epT;
    private int epU;
    private boolean epV;
    private boolean epW;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.epO = false;
        this.epP = false;
        this.epQ = false;
        this.epR = false;
        this.epS = R.drawable.ic_icon_mask_shen20_n;
        this.epT = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.epU = 0;
        this.epW = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.epO = false;
        this.epP = false;
        this.epQ = false;
        this.epR = false;
        this.epS = R.drawable.ic_icon_mask_shen20_n;
        this.epT = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.epU = 0;
        this.epW = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.epO = false;
        this.epP = false;
        this.epQ = false;
        this.epR = false;
        this.epS = R.drawable.ic_icon_mask_shen20_n;
        this.epT = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.epU = 0;
        this.epW = true;
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.epO = true;
    }

    public void setHasPendantStyle(boolean z) {
        if (this.epO && !z && this.epN != null) {
            ((RelativeLayout.LayoutParams) this.epN.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.epM != null) {
                ((RelativeLayout.LayoutParams) this.epM.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (this.epL != null) {
                this.epL.setVisibility(8);
            }
            this.epP = false;
            invalidate();
        } else if (!this.epO && z && this.epN != null) {
            int width = (int) (this.epN.getWidth() * 0.13f);
            int height = (int) (this.epN.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) this.epN.getLayoutParams()).setMargins(width, height, width, height);
            if (this.epM != null) {
                ((RelativeLayout.LayoutParams) this.epM.getLayoutParams()).setMargins(width, height, width, height);
            }
            invalidate();
        }
        this.epO = z;
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.epQ = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.epO) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.epN.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.epM != null) {
                ((RelativeLayout.LayoutParams) this.epM.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        if (this.epQ) {
            ((RelativeLayout.LayoutParams) this.epN.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.epM != null) {
                ((RelativeLayout.LayoutParams) this.epM.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    public void Az(String str) {
        if (this.epL != null) {
            if (this.epO && !StringUtils.isNull(str)) {
                this.epP = true;
                this.epL.setVisibility(0);
                this.epL.setImageDrawable(null);
                this.epL.startLoad(str, 10, false);
                return;
            }
            this.epL.setVisibility(8);
            this.epP = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.epL.setAutoChangeStyle(z);
        this.epN.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.epT = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        bkk();
        bkl();
        bkm();
    }

    private void bkk() {
        this.epN = new HeadImageView(this.mContext);
        this.epN.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.epN.setPlaceHolder(1);
        this.epN.setDefaultResource(R.color.cp_bg_line_e);
        this.epN.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.epN.setLayoutParams(layoutParams);
        addView(this.epN);
    }

    private void bkl() {
        this.epL = new TbImageView(this.mContext);
        this.epL.setPageId(this.mPageId);
        this.epL.setDefaultBgResource(0);
        this.epL.setDefaultResource(0);
        this.epL.setDefaultErrorResource(0);
        this.epL.setImageDrawable(null);
        this.epL.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.epL.setVisibility(8);
        addView(this.epL);
    }

    private void bkm() {
        this.epM = new ImageView(this.mContext);
        this.epM.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.epT, this.epT);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.epM.setLayoutParams(layoutParams);
        this.epM.setVisibility(8);
        addView(this.epM);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.epN != null) {
            this.epN.setPageId(bdUniqueId);
        }
        if (this.epL != null) {
            this.epL.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.epL;
    }

    public HeadImageView getHeadView() {
        return this.epN;
    }

    public ImageView getBigVIconView() {
        return this.epM;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.epT = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        bkn();
    }

    private void bkn() {
        if (this.epT > 0 && this.epM != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.epM.getLayoutParams();
            layoutParams.width = this.epT;
            layoutParams.height = this.epT;
            this.epM.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.epS = i;
    }

    public void setAuthIconType(int i) {
        this.epU = i;
    }

    public void setUrl(String str) {
        this.epN.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.epN.setDefaultResource(i);
    }

    public void AA(String str) {
        if (!StringUtils.isNull(str)) {
            String zV = q.zV(str);
            this.epN.setImageBitmap(null);
            this.epN.setUrl(zV);
            if (zV.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(zV, 10, false);
            } else {
                startLoad(zV, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.epN.a(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String zV = q.zV(metaData.getAvater());
            setUrl(zV);
            if (zV.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(zV, 10, false);
            } else {
                startLoad(zV, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                Az(metaData.getPendantData().bcA());
            } else {
                Az(null);
            }
            c(metaData);
        }
    }

    public void a(MetaData metaData, int i) {
        if (metaData != null) {
            this.epU = i;
            b(metaData);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            if (this.epV) {
                this.epM.setVisibility(8);
                return;
            }
            this.epN.setShowV(false);
            if (metaData.isNewGod()) {
                SvgManager.bjq().a(this.epM, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
                iu(true);
                return;
            }
            iu(false);
            if (this.epR || !UtilHelper.showHeadBazhuIcon(this.epM, metaData, this.epW)) {
                UtilHelper.showHeadBjhBigVIcon(this.epM, metaData, this.epU);
            }
        }
    }

    public void iu(boolean z) {
        if (this.epM != null) {
            this.epM.setVisibility(z ? 0 : 8);
        }
    }

    public void setIsclearmode(boolean z) {
        this.epV = z;
    }

    public void setIsHomePage(boolean z) {
        this.epR = z;
    }

    public void setShowSimpleIcon(boolean z) {
        this.epW = z;
    }
}
