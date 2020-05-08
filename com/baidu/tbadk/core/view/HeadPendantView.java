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
    private TbImageView dEO;
    private ImageView dEP;
    private HeadImageView dEQ;
    private boolean dER;
    private boolean dES;
    private boolean dET;
    private int dEU;
    private int dEV;
    private int dEW;
    private boolean dEX;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dER = false;
        this.dES = false;
        this.dET = false;
        this.dEU = R.drawable.ic_icon_mask_shen20_n;
        this.dEV = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.dEW = 0;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dER = false;
        this.dES = false;
        this.dET = false;
        this.dEU = R.drawable.ic_icon_mask_shen20_n;
        this.dEV = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.dEW = 0;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.dER = false;
        this.dES = false;
        this.dET = false;
        this.dEU = R.drawable.ic_icon_mask_shen20_n;
        this.dEV = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.dEW = 0;
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.dER = true;
    }

    public void setHasPendantStyle(boolean z) {
        if (this.dER && !z && this.dEQ != null) {
            ((RelativeLayout.LayoutParams) this.dEQ.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.dEP != null) {
                ((RelativeLayout.LayoutParams) this.dEP.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (this.dEO != null) {
                this.dEO.setVisibility(8);
            }
            this.dES = false;
            invalidate();
        } else if (!this.dER && z && this.dEQ != null) {
            int width = (int) (this.dEQ.getWidth() * 0.13f);
            int height = (int) (this.dEQ.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) this.dEQ.getLayoutParams()).setMargins(width, height, width, height);
            if (this.dEP != null) {
                ((RelativeLayout.LayoutParams) this.dEP.getLayoutParams()).setMargins(width, height, width, height);
            }
            invalidate();
        }
        this.dER = z;
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.dET = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.dER) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.dEQ.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.dEP != null) {
                ((RelativeLayout.LayoutParams) this.dEP.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        if (this.dET) {
            ((RelativeLayout.LayoutParams) this.dEQ.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.dEP != null) {
                ((RelativeLayout.LayoutParams) this.dEP.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    public void vj(String str) {
        if (this.dEO != null) {
            if (this.dER && !StringUtils.isNull(str)) {
                this.dES = true;
                this.dEO.setVisibility(0);
                this.dEO.setImageDrawable(null);
                this.dEO.startLoad(str, 10, false);
                return;
            }
            this.dEO.setVisibility(8);
            this.dES = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.dEO.setAutoChangeStyle(z);
        this.dEQ.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.dEV = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        aPP();
        aPQ();
        aPR();
    }

    private void aPP() {
        this.dEQ = new HeadImageView(this.mContext);
        this.dEQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dEQ.setPlaceHolder(1);
        this.dEQ.setDefaultResource(R.color.cp_bg_line_e);
        this.dEQ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.dEQ.setLayoutParams(layoutParams);
        addView(this.dEQ);
    }

    private void aPQ() {
        this.dEO = new TbImageView(this.mContext);
        this.dEO.setPageId(this.mPageId);
        this.dEO.setDefaultBgResource(0);
        this.dEO.setDefaultResource(0);
        this.dEO.setDefaultErrorResource(0);
        this.dEO.setImageDrawable(null);
        this.dEO.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.dEO.setVisibility(8);
        addView(this.dEO);
    }

    private void aPR() {
        this.dEP = new ImageView(this.mContext);
        this.dEP.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.dEV, this.dEV);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.dEP.setLayoutParams(layoutParams);
        this.dEP.setVisibility(8);
        addView(this.dEP);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.dEQ != null) {
            this.dEQ.setPageId(bdUniqueId);
        }
        if (this.dEO != null) {
            this.dEO.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.dEO;
    }

    public HeadImageView getHeadView() {
        return this.dEQ;
    }

    public ImageView getBigVIconView() {
        return this.dEP;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.dEV = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        aPS();
    }

    private void aPS() {
        if (this.dEV > 0 && this.dEP != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dEP.getLayoutParams();
            layoutParams.width = this.dEV;
            layoutParams.height = this.dEV;
            this.dEP.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.dEU = i;
    }

    public void setAuthIconType(int i) {
        this.dEW = i;
    }

    public void setUrl(String str) {
        this.dEQ.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.dEQ.setDefaultResource(i);
    }

    public void vk(String str) {
        if (!StringUtils.isNull(str)) {
            String uD = o.uD(str);
            this.dEQ.setImageBitmap(null);
            this.dEQ.setUrl(uD);
            if (uD.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(uD, 10, false);
            } else {
                startLoad(uD, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.dEQ.a(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String uD = o.uD(metaData.getAvater());
            setUrl(uD);
            if (uD.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(uD, 10, false);
            } else {
                startLoad(uD, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                vj(metaData.getPendantData().aIU());
            } else {
                vj(null);
            }
            c(metaData);
        }
    }

    public void a(MetaData metaData, int i) {
        if (metaData != null) {
            this.dEW = i;
            b(metaData);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            if (this.dEX) {
                this.dEP.setVisibility(8);
                return;
            }
            this.dEQ.setShowV(false);
            if (!UtilHelper.showHeadBjhBigVIcon(this.dEP, metaData, this.dEW)) {
                if (metaData.isBigV() || !StringUtils.isNull(metaData.getUserTbVipInfoData().getvipV_url())) {
                    this.dEP.setImageDrawable(UtilHelper.getBjhBigVIconDrawable(this.dEU));
                    gP(true);
                    return;
                }
                gP(false);
            }
        }
    }

    public void gP(boolean z) {
        if (this.dEP != null) {
            this.dEP.setVisibility(z ? 0 : 8);
        }
    }

    public void setIsclearmode(boolean z) {
        this.dEX = z;
    }
}
