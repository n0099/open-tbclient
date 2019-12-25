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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantView extends RelativeLayout {
    private boolean daA;
    private boolean daB;
    private boolean daC;
    private int daD;
    private int daE;
    private int daF;
    private TbImageView daw;
    private ImageView dax;
    private HeadImageView daz;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.daA = false;
        this.daB = false;
        this.daC = false;
        this.daD = R.drawable.ic_icon_mask_shen20_n;
        this.daE = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.daF = 0;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.daA = false;
        this.daB = false;
        this.daC = false;
        this.daD = R.drawable.ic_icon_mask_shen20_n;
        this.daE = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.daF = 0;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.daA = false;
        this.daB = false;
        this.daC = false;
        this.daD = R.drawable.ic_icon_mask_shen20_n;
        this.daE = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.daF = 0;
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.daA = true;
    }

    public void setHasPendantStyle(boolean z) {
        if (this.daA && !z && this.daz != null) {
            ((RelativeLayout.LayoutParams) this.daz.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.dax != null) {
                ((RelativeLayout.LayoutParams) this.dax.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (this.daw != null) {
                this.daw.setVisibility(8);
            }
            this.daB = false;
            invalidate();
        } else if (!this.daA && z && this.daz != null) {
            int width = (int) (this.daz.getWidth() * 0.13f);
            int height = (int) (this.daz.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) this.daz.getLayoutParams()).setMargins(width, height, width, height);
            if (this.dax != null) {
                ((RelativeLayout.LayoutParams) this.dax.getLayoutParams()).setMargins(width, height, width, height);
            }
            invalidate();
        }
        this.daA = z;
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.daC = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.daA) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.daz.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.dax != null) {
                ((RelativeLayout.LayoutParams) this.dax.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        if (this.daC) {
            ((RelativeLayout.LayoutParams) this.daz.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.dax != null) {
                ((RelativeLayout.LayoutParams) this.dax.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    public void ty(String str) {
        if (this.daw != null) {
            if (this.daA && !StringUtils.isNull(str)) {
                this.daB = true;
                this.daw.setVisibility(0);
                this.daw.setImageDrawable(null);
                this.daw.startLoad(str, 10, false);
                return;
            }
            this.daw.setVisibility(8);
            this.daB = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.daw.setAutoChangeStyle(z);
        this.daz.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.daE = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        aEO();
        aEP();
        aEQ();
    }

    private void aEO() {
        this.daz = new HeadImageView(this.mContext);
        this.daz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.daz.setPlaceHolder(1);
        this.daz.setDefaultResource(R.color.cp_bg_line_e);
        this.daz.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.daz.setLayoutParams(layoutParams);
        addView(this.daz);
    }

    private void aEP() {
        this.daw = new TbImageView(this.mContext);
        this.daw.setPageId(this.mPageId);
        this.daw.setDefaultBgResource(0);
        this.daw.setDefaultResource(0);
        this.daw.setDefaultErrorResource(0);
        this.daw.setImageDrawable(null);
        this.daw.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.daw.setVisibility(8);
        addView(this.daw);
    }

    private void aEQ() {
        this.dax = new ImageView(this.mContext);
        this.dax.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.daE, this.daE);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.dax.setLayoutParams(layoutParams);
        this.dax.setVisibility(8);
        addView(this.dax);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.daz != null) {
            this.daz.setPageId(bdUniqueId);
        }
        if (this.daw != null) {
            this.daw.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.daw;
    }

    public HeadImageView getHeadView() {
        return this.daz;
    }

    public ImageView getBigVIconView() {
        return this.dax;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.daE = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        aER();
    }

    private void aER() {
        if (this.daE > 0 && this.dax != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dax.getLayoutParams();
            layoutParams.width = this.daE;
            layoutParams.height = this.daE;
            this.dax.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.daD = i;
    }

    public void setAuthIconType(int i) {
        this.daF = i;
    }

    public void setUrl(String str) {
        this.daz.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.daz.setDefaultResource(i);
    }

    public void tz(String str) {
        if (!StringUtils.isNull(str)) {
            String sU = o.sU(str);
            this.daz.setImageBitmap(null);
            this.daz.setUrl(sU);
            if (sU.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(sU, 10, false);
            } else {
                startLoad(sU, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.daz.a(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String sU = o.sU(metaData.getAvater());
            setUrl(sU);
            if (sU.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(sU, 10, false);
            } else {
                startLoad(sU, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                ty(metaData.getPendantData().axX());
            } else {
                ty(null);
            }
            c(metaData);
        }
    }

    public void a(MetaData metaData, int i) {
        if (metaData != null) {
            this.daF = i;
            b(metaData);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            this.daz.setShowV(false);
            if (!UtilHelper.showHeadBjhBigVIcon(this.dax, metaData, this.daF)) {
                if (metaData.isBigV() || !StringUtils.isNull(metaData.getUserTbVipInfoData().getvipV_url())) {
                    this.dax.setImageDrawable(UtilHelper.getBjhBigVIconDrawable(this.daD));
                    fE(true);
                    return;
                }
                fE(false);
            }
        }
    }

    public void fE(boolean z) {
        if (this.dax != null) {
            this.dax.setVisibility(z ? 0 : 8);
        }
    }
}
