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
    private TbImageView daH;
    private ImageView daI;
    private HeadImageView daJ;
    private boolean daK;
    private boolean daL;
    private boolean daM;
    private int daN;
    private int daO;
    private int daP;
    private boolean daQ;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.daK = false;
        this.daL = false;
        this.daM = false;
        this.daN = R.drawable.ic_icon_mask_shen20_n;
        this.daO = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.daP = 0;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.daK = false;
        this.daL = false;
        this.daM = false;
        this.daN = R.drawable.ic_icon_mask_shen20_n;
        this.daO = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.daP = 0;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.daK = false;
        this.daL = false;
        this.daM = false;
        this.daN = R.drawable.ic_icon_mask_shen20_n;
        this.daO = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.daP = 0;
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.daK = true;
    }

    public void setHasPendantStyle(boolean z) {
        if (this.daK && !z && this.daJ != null) {
            ((RelativeLayout.LayoutParams) this.daJ.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.daI != null) {
                ((RelativeLayout.LayoutParams) this.daI.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (this.daH != null) {
                this.daH.setVisibility(8);
            }
            this.daL = false;
            invalidate();
        } else if (!this.daK && z && this.daJ != null) {
            int width = (int) (this.daJ.getWidth() * 0.13f);
            int height = (int) (this.daJ.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) this.daJ.getLayoutParams()).setMargins(width, height, width, height);
            if (this.daI != null) {
                ((RelativeLayout.LayoutParams) this.daI.getLayoutParams()).setMargins(width, height, width, height);
            }
            invalidate();
        }
        this.daK = z;
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.daM = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.daK) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.daJ.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.daI != null) {
                ((RelativeLayout.LayoutParams) this.daI.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        if (this.daM) {
            ((RelativeLayout.LayoutParams) this.daJ.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.daI != null) {
                ((RelativeLayout.LayoutParams) this.daI.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    public void tC(String str) {
        if (this.daH != null) {
            if (this.daK && !StringUtils.isNull(str)) {
                this.daL = true;
                this.daH.setVisibility(0);
                this.daH.setImageDrawable(null);
                this.daH.startLoad(str, 10, false);
                return;
            }
            this.daH.setVisibility(8);
            this.daL = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.daH.setAutoChangeStyle(z);
        this.daJ.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.daO = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        aFh();
        aFi();
        aFj();
    }

    private void aFh() {
        this.daJ = new HeadImageView(this.mContext);
        this.daJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.daJ.setPlaceHolder(1);
        this.daJ.setDefaultResource(R.color.cp_bg_line_e);
        this.daJ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.daJ.setLayoutParams(layoutParams);
        addView(this.daJ);
    }

    private void aFi() {
        this.daH = new TbImageView(this.mContext);
        this.daH.setPageId(this.mPageId);
        this.daH.setDefaultBgResource(0);
        this.daH.setDefaultResource(0);
        this.daH.setDefaultErrorResource(0);
        this.daH.setImageDrawable(null);
        this.daH.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.daH.setVisibility(8);
        addView(this.daH);
    }

    private void aFj() {
        this.daI = new ImageView(this.mContext);
        this.daI.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.daO, this.daO);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.daI.setLayoutParams(layoutParams);
        this.daI.setVisibility(8);
        addView(this.daI);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.daJ != null) {
            this.daJ.setPageId(bdUniqueId);
        }
        if (this.daH != null) {
            this.daH.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.daH;
    }

    public HeadImageView getHeadView() {
        return this.daJ;
    }

    public ImageView getBigVIconView() {
        return this.daI;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.daO = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        aFk();
    }

    private void aFk() {
        if (this.daO > 0 && this.daI != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.daI.getLayoutParams();
            layoutParams.width = this.daO;
            layoutParams.height = this.daO;
            this.daI.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.daN = i;
    }

    public void setAuthIconType(int i) {
        this.daP = i;
    }

    public void setUrl(String str) {
        this.daJ.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.daJ.setDefaultResource(i);
    }

    public void tD(String str) {
        if (!StringUtils.isNull(str)) {
            String sX = o.sX(str);
            this.daJ.setImageBitmap(null);
            this.daJ.setUrl(sX);
            if (sX.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(sX, 10, false);
            } else {
                startLoad(sX, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.daJ.a(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String sX = o.sX(metaData.getAvater());
            setUrl(sX);
            if (sX.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(sX, 10, false);
            } else {
                startLoad(sX, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                tC(metaData.getPendantData().ayq());
            } else {
                tC(null);
            }
            c(metaData);
        }
    }

    public void a(MetaData metaData, int i) {
        if (metaData != null) {
            this.daP = i;
            b(metaData);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            if (this.daQ) {
                this.daI.setVisibility(8);
                return;
            }
            this.daJ.setShowV(false);
            if (!UtilHelper.showHeadBjhBigVIcon(this.daI, metaData, this.daP)) {
                if (metaData.isBigV() || !StringUtils.isNull(metaData.getUserTbVipInfoData().getvipV_url())) {
                    this.daI.setImageDrawable(UtilHelper.getBjhBigVIconDrawable(this.daN));
                    fJ(true);
                    return;
                }
                fJ(false);
            }
        }
    }

    public void fJ(boolean z) {
        if (this.daI != null) {
            this.daI.setVisibility(z ? 0 : 8);
        }
    }

    public void setIsclearmode(boolean z) {
        this.daQ = z;
    }
}
