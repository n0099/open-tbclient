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
    private TbImageView ege;
    private ImageView egf;
    private HeadImageView egg;
    private boolean egh;
    private boolean egi;
    private boolean egj;
    private boolean egk;
    private int egl;
    private int egm;
    private int egn;
    private boolean ego;
    private boolean egp;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.egh = false;
        this.egi = false;
        this.egj = false;
        this.egk = false;
        this.egl = R.drawable.ic_icon_mask_shen20_n;
        this.egm = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.egn = 0;
        this.egp = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.egh = false;
        this.egi = false;
        this.egj = false;
        this.egk = false;
        this.egl = R.drawable.ic_icon_mask_shen20_n;
        this.egm = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.egn = 0;
        this.egp = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.egh = false;
        this.egi = false;
        this.egj = false;
        this.egk = false;
        this.egl = R.drawable.ic_icon_mask_shen20_n;
        this.egm = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.egn = 0;
        this.egp = true;
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.egh = true;
    }

    public void setHasPendantStyle(boolean z) {
        if (this.egh && !z && this.egg != null) {
            ((RelativeLayout.LayoutParams) this.egg.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.egf != null) {
                ((RelativeLayout.LayoutParams) this.egf.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (this.ege != null) {
                this.ege.setVisibility(8);
            }
            this.egi = false;
            invalidate();
        } else if (!this.egh && z && this.egg != null) {
            int width = (int) (this.egg.getWidth() * 0.13f);
            int height = (int) (this.egg.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) this.egg.getLayoutParams()).setMargins(width, height, width, height);
            if (this.egf != null) {
                ((RelativeLayout.LayoutParams) this.egf.getLayoutParams()).setMargins(width, height, width, height);
            }
            invalidate();
        }
        this.egh = z;
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.egj = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.egh) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.egg.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.egf != null) {
                ((RelativeLayout.LayoutParams) this.egf.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        if (this.egj) {
            ((RelativeLayout.LayoutParams) this.egg.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.egf != null) {
                ((RelativeLayout.LayoutParams) this.egf.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    public void yl(String str) {
        if (this.ege != null) {
            if (this.egh && !StringUtils.isNull(str)) {
                this.egi = true;
                this.ege.setVisibility(0);
                this.ege.setImageDrawable(null);
                this.ege.startLoad(str, 10, false);
                return;
            }
            this.ege.setVisibility(8);
            this.egi = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.ege.setAutoChangeStyle(z);
        this.egg.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.egm = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        bbO();
        bbP();
        bbQ();
    }

    private void bbO() {
        this.egg = new HeadImageView(this.mContext);
        this.egg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.egg.setPlaceHolder(1);
        this.egg.setDefaultResource(R.color.cp_bg_line_e);
        this.egg.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.egg.setLayoutParams(layoutParams);
        addView(this.egg);
    }

    private void bbP() {
        this.ege = new TbImageView(this.mContext);
        this.ege.setPageId(this.mPageId);
        this.ege.setDefaultBgResource(0);
        this.ege.setDefaultResource(0);
        this.ege.setDefaultErrorResource(0);
        this.ege.setImageDrawable(null);
        this.ege.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.ege.setVisibility(8);
        addView(this.ege);
    }

    private void bbQ() {
        this.egf = new ImageView(this.mContext);
        this.egf.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.egm, this.egm);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.egf.setLayoutParams(layoutParams);
        this.egf.setVisibility(8);
        addView(this.egf);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.egg != null) {
            this.egg.setPageId(bdUniqueId);
        }
        if (this.ege != null) {
            this.ege.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.ege;
    }

    public HeadImageView getHeadView() {
        return this.egg;
    }

    public ImageView getBigVIconView() {
        return this.egf;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.egm = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        bbR();
    }

    private void bbR() {
        if (this.egm > 0 && this.egf != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.egf.getLayoutParams();
            layoutParams.width = this.egm;
            layoutParams.height = this.egm;
            this.egf.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.egl = i;
    }

    public void setAuthIconType(int i) {
        this.egn = i;
    }

    public void setUrl(String str) {
        this.egg.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.egg.setDefaultResource(i);
    }

    public void ym(String str) {
        if (!StringUtils.isNull(str)) {
            String xH = q.xH(str);
            this.egg.setImageBitmap(null);
            this.egg.setUrl(xH);
            if (xH.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(xH, 10, false);
            } else {
                startLoad(xH, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.egg.a(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String xH = q.xH(metaData.getAvater());
            setUrl(xH);
            if (xH.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(xH, 10, false);
            } else {
                startLoad(xH, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                yl(metaData.getPendantData().aUh());
            } else {
                yl(null);
            }
            c(metaData);
        }
    }

    public void a(MetaData metaData, int i) {
        if (metaData != null) {
            this.egn = i;
            b(metaData);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            if (this.ego) {
                this.egf.setVisibility(8);
                return;
            }
            this.egg.setShowV(false);
            if (!UtilHelper.showHeadBjhBigVIcon(this.egf, metaData, this.egn)) {
                if (this.egk || !UtilHelper.showHeadBazhuIcon(this.egf, metaData, this.egp)) {
                    if (metaData.isNewGod()) {
                        SvgManager.baR().a(this.egf, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
                        hX(true);
                        return;
                    }
                    hX(false);
                }
            }
        }
    }

    public void hX(boolean z) {
        if (this.egf != null) {
            this.egf.setVisibility(z ? 0 : 8);
        }
    }

    public void setIsclearmode(boolean z) {
        this.ego = z;
    }

    public void setIsHomePage(boolean z) {
        this.egk = z;
    }

    public void setShowSimpleIcon(boolean z) {
        this.egp = z;
    }
}
