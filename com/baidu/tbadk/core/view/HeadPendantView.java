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
    private TbImageView dEK;
    private ImageView dEL;
    private HeadImageView dEM;
    private boolean dEN;
    private boolean dEO;
    private boolean dEP;
    private int dEQ;
    private int dER;
    private int dES;
    private boolean dET;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dEN = false;
        this.dEO = false;
        this.dEP = false;
        this.dEQ = R.drawable.ic_icon_mask_shen20_n;
        this.dER = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.dES = 0;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dEN = false;
        this.dEO = false;
        this.dEP = false;
        this.dEQ = R.drawable.ic_icon_mask_shen20_n;
        this.dER = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.dES = 0;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.dEN = false;
        this.dEO = false;
        this.dEP = false;
        this.dEQ = R.drawable.ic_icon_mask_shen20_n;
        this.dER = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.dES = 0;
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.dEN = true;
    }

    public void setHasPendantStyle(boolean z) {
        if (this.dEN && !z && this.dEM != null) {
            ((RelativeLayout.LayoutParams) this.dEM.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.dEL != null) {
                ((RelativeLayout.LayoutParams) this.dEL.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (this.dEK != null) {
                this.dEK.setVisibility(8);
            }
            this.dEO = false;
            invalidate();
        } else if (!this.dEN && z && this.dEM != null) {
            int width = (int) (this.dEM.getWidth() * 0.13f);
            int height = (int) (this.dEM.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) this.dEM.getLayoutParams()).setMargins(width, height, width, height);
            if (this.dEL != null) {
                ((RelativeLayout.LayoutParams) this.dEL.getLayoutParams()).setMargins(width, height, width, height);
            }
            invalidate();
        }
        this.dEN = z;
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.dEP = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.dEN) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.dEM.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.dEL != null) {
                ((RelativeLayout.LayoutParams) this.dEL.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        if (this.dEP) {
            ((RelativeLayout.LayoutParams) this.dEM.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.dEL != null) {
                ((RelativeLayout.LayoutParams) this.dEL.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    public void vg(String str) {
        if (this.dEK != null) {
            if (this.dEN && !StringUtils.isNull(str)) {
                this.dEO = true;
                this.dEK.setVisibility(0);
                this.dEK.setImageDrawable(null);
                this.dEK.startLoad(str, 10, false);
                return;
            }
            this.dEK.setVisibility(8);
            this.dEO = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.dEK.setAutoChangeStyle(z);
        this.dEM.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.dER = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        aPS();
        aPT();
        aPU();
    }

    private void aPS() {
        this.dEM = new HeadImageView(this.mContext);
        this.dEM.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dEM.setPlaceHolder(1);
        this.dEM.setDefaultResource(R.color.cp_bg_line_e);
        this.dEM.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.dEM.setLayoutParams(layoutParams);
        addView(this.dEM);
    }

    private void aPT() {
        this.dEK = new TbImageView(this.mContext);
        this.dEK.setPageId(this.mPageId);
        this.dEK.setDefaultBgResource(0);
        this.dEK.setDefaultResource(0);
        this.dEK.setDefaultErrorResource(0);
        this.dEK.setImageDrawable(null);
        this.dEK.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.dEK.setVisibility(8);
        addView(this.dEK);
    }

    private void aPU() {
        this.dEL = new ImageView(this.mContext);
        this.dEL.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.dER, this.dER);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.dEL.setLayoutParams(layoutParams);
        this.dEL.setVisibility(8);
        addView(this.dEL);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.dEM != null) {
            this.dEM.setPageId(bdUniqueId);
        }
        if (this.dEK != null) {
            this.dEK.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.dEK;
    }

    public HeadImageView getHeadView() {
        return this.dEM;
    }

    public ImageView getBigVIconView() {
        return this.dEL;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.dER = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        aPV();
    }

    private void aPV() {
        if (this.dER > 0 && this.dEL != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dEL.getLayoutParams();
            layoutParams.width = this.dER;
            layoutParams.height = this.dER;
            this.dEL.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.dEQ = i;
    }

    public void setAuthIconType(int i) {
        this.dES = i;
    }

    public void setUrl(String str) {
        this.dEM.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.dEM.setDefaultResource(i);
    }

    public void vh(String str) {
        if (!StringUtils.isNull(str)) {
            String uA = o.uA(str);
            this.dEM.setImageBitmap(null);
            this.dEM.setUrl(uA);
            if (uA.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(uA, 10, false);
            } else {
                startLoad(uA, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.dEM.a(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String uA = o.uA(metaData.getAvater());
            setUrl(uA);
            if (uA.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(uA, 10, false);
            } else {
                startLoad(uA, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                vg(metaData.getPendantData().aIW());
            } else {
                vg(null);
            }
            c(metaData);
        }
    }

    public void a(MetaData metaData, int i) {
        if (metaData != null) {
            this.dES = i;
            b(metaData);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            if (this.dET) {
                this.dEL.setVisibility(8);
                return;
            }
            this.dEM.setShowV(false);
            if (!UtilHelper.showHeadBjhBigVIcon(this.dEL, metaData, this.dES)) {
                if (metaData.isBigV() || !StringUtils.isNull(metaData.getUserTbVipInfoData().getvipV_url())) {
                    this.dEL.setImageDrawable(UtilHelper.getBjhBigVIconDrawable(this.dEQ));
                    gP(true);
                    return;
                }
                gP(false);
            }
        }
    }

    public void gP(boolean z) {
        if (this.dEL != null) {
            this.dEL.setVisibility(z ? 0 : 8);
        }
    }

    public void setIsclearmode(boolean z) {
        this.dET = z;
    }
}
