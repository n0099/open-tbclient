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
    private TbImageView eMB;
    private ImageView eMC;
    private HeadImageView eMD;
    private boolean eME;
    private boolean eMF;
    private boolean eMG;
    private boolean eMH;
    private int eMI;
    private int eMJ;
    private int eMK;
    private boolean eML;
    private boolean eMM;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eME = false;
        this.eMF = false;
        this.eMG = false;
        this.eMH = false;
        this.eMI = R.drawable.ic_icon_mask_shen20_n;
        this.eMJ = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.eMK = 0;
        this.eMM = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eME = false;
        this.eMF = false;
        this.eMG = false;
        this.eMH = false;
        this.eMI = R.drawable.ic_icon_mask_shen20_n;
        this.eMJ = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.eMK = 0;
        this.eMM = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.eME = false;
        this.eMF = false;
        this.eMG = false;
        this.eMH = false;
        this.eMI = R.drawable.ic_icon_mask_shen20_n;
        this.eMJ = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.eMK = 0;
        this.eMM = true;
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.eME = true;
    }

    public void setHasPendantStyle(boolean z) {
        if (this.eME && !z && this.eMD != null) {
            ((RelativeLayout.LayoutParams) this.eMD.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.eMC != null) {
                ((RelativeLayout.LayoutParams) this.eMC.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (this.eMB != null) {
                this.eMB.setVisibility(8);
            }
            this.eMF = false;
            invalidate();
        } else if (!this.eME && z && this.eMD != null) {
            int width = (int) (this.eMD.getWidth() * 0.13f);
            int height = (int) (this.eMD.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) this.eMD.getLayoutParams()).setMargins(width, height, width, height);
            if (this.eMC != null) {
                ((RelativeLayout.LayoutParams) this.eMC.getLayoutParams()).setMargins(width, height, width, height);
            }
            invalidate();
        }
        this.eME = z;
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.eMG = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.eME) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.eMD.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.eMC != null) {
                ((RelativeLayout.LayoutParams) this.eMC.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        if (this.eMG) {
            ((RelativeLayout.LayoutParams) this.eMD.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.eMC != null) {
                ((RelativeLayout.LayoutParams) this.eMC.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    public void Cb(String str) {
        if (this.eMB != null) {
            if (this.eME && !StringUtils.isNull(str)) {
                this.eMF = true;
                this.eMB.setVisibility(0);
                this.eMB.setImageDrawable(null);
                this.eMB.startLoad(str, 10, false);
                return;
            }
            this.eMB.setVisibility(8);
            this.eMF = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.eMB.setAutoChangeStyle(z);
        this.eMD.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.eMJ = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        bpI();
        bpJ();
        bpK();
    }

    private void bpI() {
        this.eMD = new HeadImageView(this.mContext);
        this.eMD.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eMD.setPlaceHolder(1);
        this.eMD.setDefaultResource(R.color.cp_bg_line_e);
        this.eMD.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.eMD.setLayoutParams(layoutParams);
        addView(this.eMD);
    }

    private void bpJ() {
        this.eMB = new TbImageView(this.mContext);
        this.eMB.setPageId(this.mPageId);
        this.eMB.setDefaultBgResource(0);
        this.eMB.setDefaultResource(0);
        this.eMB.setDefaultErrorResource(0);
        this.eMB.setImageDrawable(null);
        this.eMB.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.eMB.setVisibility(8);
        addView(this.eMB);
    }

    private void bpK() {
        this.eMC = new ImageView(this.mContext);
        this.eMC.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.eMJ, this.eMJ);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.eMC.setLayoutParams(layoutParams);
        this.eMC.setVisibility(8);
        addView(this.eMC);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.eMD != null) {
            this.eMD.setPageId(bdUniqueId);
        }
        if (this.eMB != null) {
            this.eMB.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.eMB;
    }

    public HeadImageView getHeadView() {
        return this.eMD;
    }

    public ImageView getBigVIconView() {
        return this.eMC;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.eMJ = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        bpL();
    }

    private void bpL() {
        if (this.eMJ > 0 && this.eMC != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eMC.getLayoutParams();
            layoutParams.width = this.eMJ;
            layoutParams.height = this.eMJ;
            this.eMC.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.eMI = i;
    }

    public void setAuthIconType(int i) {
        this.eMK = i;
    }

    public void setUrl(String str) {
        this.eMD.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.eMD.setDefaultResource(i);
    }

    public void Cc(String str) {
        if (!StringUtils.isNull(str)) {
            String Bx = q.Bx(str);
            this.eMD.setImageBitmap(null);
            this.eMD.setUrl(Bx);
            if (Bx.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(Bx, 10, false);
            } else {
                startLoad(Bx, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.eMD.a(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String Bx = q.Bx(metaData.getAvater());
            setUrl(Bx);
            if (Bx.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(Bx, 10, false);
            } else {
                startLoad(Bx, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                Cb(metaData.getPendantData().bhW());
            } else {
                Cb(null);
            }
            c(metaData);
        }
    }

    public void a(MetaData metaData, int i) {
        if (metaData != null) {
            this.eMK = i;
            b(metaData);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            if (this.eML) {
                this.eMC.setVisibility(8);
                return;
            }
            this.eMD.setShowV(false);
            if (metaData.isNewGod()) {
                SvgManager.boN().a(this.eMC, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
                jd(true);
                return;
            }
            jd(false);
            if (this.eMH || !UtilHelper.showHeadBazhuIcon(this.eMC, metaData, this.eMM)) {
                UtilHelper.showHeadBjhBigVIcon(this.eMC, metaData, this.eMK);
            }
        }
    }

    public void jd(boolean z) {
        if (this.eMC != null) {
            this.eMC.setVisibility(z ? 0 : 8);
        }
    }

    public void setIsclearmode(boolean z) {
        this.eML = z;
    }

    public void setIsHomePage(boolean z) {
        this.eMH = z;
    }

    public void setShowSimpleIcon(boolean z) {
        this.eMM = z;
    }
}
