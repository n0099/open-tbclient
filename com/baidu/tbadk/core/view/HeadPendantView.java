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
    private TbImageView eEf;
    private ImageView eEg;
    private HeadImageView eEh;
    private boolean eEi;
    private boolean eEj;
    private boolean eEk;
    private boolean eEl;
    private int eEm;
    private int eEn;
    private int eEo;
    private boolean eEp;
    private boolean eEq;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eEi = false;
        this.eEj = false;
        this.eEk = false;
        this.eEl = false;
        this.eEm = R.drawable.ic_icon_mask_shen20_n;
        this.eEn = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.eEo = 0;
        this.eEq = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eEi = false;
        this.eEj = false;
        this.eEk = false;
        this.eEl = false;
        this.eEm = R.drawable.ic_icon_mask_shen20_n;
        this.eEn = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.eEo = 0;
        this.eEq = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.eEi = false;
        this.eEj = false;
        this.eEk = false;
        this.eEl = false;
        this.eEm = R.drawable.ic_icon_mask_shen20_n;
        this.eEn = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.eEo = 0;
        this.eEq = true;
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.eEi = true;
    }

    public void setHasPendantStyle(boolean z) {
        if (this.eEi && !z && this.eEh != null) {
            ((RelativeLayout.LayoutParams) this.eEh.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.eEg != null) {
                ((RelativeLayout.LayoutParams) this.eEg.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (this.eEf != null) {
                this.eEf.setVisibility(8);
            }
            this.eEj = false;
            invalidate();
        } else if (!this.eEi && z && this.eEh != null) {
            int width = (int) (this.eEh.getWidth() * 0.13f);
            int height = (int) (this.eEh.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) this.eEh.getLayoutParams()).setMargins(width, height, width, height);
            if (this.eEg != null) {
                ((RelativeLayout.LayoutParams) this.eEg.getLayoutParams()).setMargins(width, height, width, height);
            }
            invalidate();
        }
        this.eEi = z;
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.eEk = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.eEi) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.eEh.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.eEg != null) {
                ((RelativeLayout.LayoutParams) this.eEg.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        if (this.eEk) {
            ((RelativeLayout.LayoutParams) this.eEh.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.eEg != null) {
                ((RelativeLayout.LayoutParams) this.eEg.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    public void BI(String str) {
        if (this.eEf != null) {
            if (this.eEi && !StringUtils.isNull(str)) {
                this.eEj = true;
                this.eEf.setVisibility(0);
                this.eEf.setImageDrawable(null);
                this.eEf.startLoad(str, 10, false);
                return;
            }
            this.eEf.setVisibility(8);
            this.eEj = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.eEf.setAutoChangeStyle(z);
        this.eEh.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.eEn = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        bnP();
        bnQ();
        bnR();
    }

    private void bnP() {
        this.eEh = new HeadImageView(this.mContext);
        this.eEh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eEh.setPlaceHolder(1);
        this.eEh.setDefaultResource(R.color.cp_bg_line_e);
        this.eEh.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.eEh.setLayoutParams(layoutParams);
        addView(this.eEh);
    }

    private void bnQ() {
        this.eEf = new TbImageView(this.mContext);
        this.eEf.setPageId(this.mPageId);
        this.eEf.setDefaultBgResource(0);
        this.eEf.setDefaultResource(0);
        this.eEf.setDefaultErrorResource(0);
        this.eEf.setImageDrawable(null);
        this.eEf.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.eEf.setVisibility(8);
        addView(this.eEf);
    }

    private void bnR() {
        this.eEg = new ImageView(this.mContext);
        this.eEg.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.eEn, this.eEn);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.eEg.setLayoutParams(layoutParams);
        this.eEg.setVisibility(8);
        addView(this.eEg);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.eEh != null) {
            this.eEh.setPageId(bdUniqueId);
        }
        if (this.eEf != null) {
            this.eEf.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.eEf;
    }

    public HeadImageView getHeadView() {
        return this.eEh;
    }

    public ImageView getBigVIconView() {
        return this.eEg;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.eEn = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        bnS();
    }

    private void bnS() {
        if (this.eEn > 0 && this.eEg != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eEg.getLayoutParams();
            layoutParams.width = this.eEn;
            layoutParams.height = this.eEn;
            this.eEg.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.eEm = i;
    }

    public void setAuthIconType(int i) {
        this.eEo = i;
    }

    public void setUrl(String str) {
        this.eEh.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.eEh.setDefaultResource(i);
    }

    public void BJ(String str) {
        if (!StringUtils.isNull(str)) {
            String Be = q.Be(str);
            this.eEh.setImageBitmap(null);
            this.eEh.setUrl(Be);
            if (Be.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(Be, 10, false);
            } else {
                startLoad(Be, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.eEh.a(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String Be = q.Be(metaData.getAvater());
            setUrl(Be);
            if (Be.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(Be, 10, false);
            } else {
                startLoad(Be, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                BI(metaData.getPendantData().bgd());
            } else {
                BI(null);
            }
            c(metaData);
        }
    }

    public void a(MetaData metaData, int i) {
        if (metaData != null) {
            this.eEo = i;
            b(metaData);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            if (this.eEp) {
                this.eEg.setVisibility(8);
                return;
            }
            this.eEh.setShowV(false);
            if (metaData.isNewGod()) {
                SvgManager.bmU().a(this.eEg, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
                iQ(true);
                return;
            }
            iQ(false);
            if (this.eEl || !UtilHelper.showHeadBazhuIcon(this.eEg, metaData, this.eEq)) {
                UtilHelper.showHeadBjhBigVIcon(this.eEg, metaData, this.eEo);
            }
        }
    }

    public void iQ(boolean z) {
        if (this.eEg != null) {
            this.eEg.setVisibility(z ? 0 : 8);
        }
    }

    public void setIsclearmode(boolean z) {
        this.eEp = z;
    }

    public void setIsHomePage(boolean z) {
        this.eEl = z;
    }

    public void setShowSimpleIcon(boolean z) {
        this.eEq = z;
    }
}
