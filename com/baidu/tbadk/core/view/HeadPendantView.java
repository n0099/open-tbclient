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
    private TbImageView deN;
    private ImageView deO;
    private HeadImageView deP;
    private boolean deQ;
    private boolean deR;
    private boolean deS;
    private int deT;
    private int deU;
    private int deV;
    private boolean deW;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.deQ = false;
        this.deR = false;
        this.deS = false;
        this.deT = R.drawable.ic_icon_mask_shen20_n;
        this.deU = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.deV = 0;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.deQ = false;
        this.deR = false;
        this.deS = false;
        this.deT = R.drawable.ic_icon_mask_shen20_n;
        this.deU = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.deV = 0;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.deQ = false;
        this.deR = false;
        this.deS = false;
        this.deT = R.drawable.ic_icon_mask_shen20_n;
        this.deU = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.deV = 0;
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.deQ = true;
    }

    public void setHasPendantStyle(boolean z) {
        if (this.deQ && !z && this.deP != null) {
            ((RelativeLayout.LayoutParams) this.deP.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.deO != null) {
                ((RelativeLayout.LayoutParams) this.deO.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (this.deN != null) {
                this.deN.setVisibility(8);
            }
            this.deR = false;
            invalidate();
        } else if (!this.deQ && z && this.deP != null) {
            int width = (int) (this.deP.getWidth() * 0.13f);
            int height = (int) (this.deP.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) this.deP.getLayoutParams()).setMargins(width, height, width, height);
            if (this.deO != null) {
                ((RelativeLayout.LayoutParams) this.deO.getLayoutParams()).setMargins(width, height, width, height);
            }
            invalidate();
        }
        this.deQ = z;
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.deS = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.deQ) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.deP.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.deO != null) {
                ((RelativeLayout.LayoutParams) this.deO.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        if (this.deS) {
            ((RelativeLayout.LayoutParams) this.deP.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.deO != null) {
                ((RelativeLayout.LayoutParams) this.deO.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    public void tS(String str) {
        if (this.deN != null) {
            if (this.deQ && !StringUtils.isNull(str)) {
                this.deR = true;
                this.deN.setVisibility(0);
                this.deN.setImageDrawable(null);
                this.deN.startLoad(str, 10, false);
                return;
            }
            this.deN.setVisibility(8);
            this.deR = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.deN.setAutoChangeStyle(z);
        this.deP.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.deU = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        aHv();
        aHw();
        aHx();
    }

    private void aHv() {
        this.deP = new HeadImageView(this.mContext);
        this.deP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.deP.setPlaceHolder(1);
        this.deP.setDefaultResource(R.color.cp_bg_line_e);
        this.deP.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.deP.setLayoutParams(layoutParams);
        addView(this.deP);
    }

    private void aHw() {
        this.deN = new TbImageView(this.mContext);
        this.deN.setPageId(this.mPageId);
        this.deN.setDefaultBgResource(0);
        this.deN.setDefaultResource(0);
        this.deN.setDefaultErrorResource(0);
        this.deN.setImageDrawable(null);
        this.deN.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.deN.setVisibility(8);
        addView(this.deN);
    }

    private void aHx() {
        this.deO = new ImageView(this.mContext);
        this.deO.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.deU, this.deU);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.deO.setLayoutParams(layoutParams);
        this.deO.setVisibility(8);
        addView(this.deO);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.deP != null) {
            this.deP.setPageId(bdUniqueId);
        }
        if (this.deN != null) {
            this.deN.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.deN;
    }

    public HeadImageView getHeadView() {
        return this.deP;
    }

    public ImageView getBigVIconView() {
        return this.deO;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.deU = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        aHy();
    }

    private void aHy() {
        if (this.deU > 0 && this.deO != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.deO.getLayoutParams();
            layoutParams.width = this.deU;
            layoutParams.height = this.deU;
            this.deO.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.deT = i;
    }

    public void setAuthIconType(int i) {
        this.deV = i;
    }

    public void setUrl(String str) {
        this.deP.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.deP.setDefaultResource(i);
    }

    public void tT(String str) {
        if (!StringUtils.isNull(str)) {
            String tn = o.tn(str);
            this.deP.setImageBitmap(null);
            this.deP.setUrl(tn);
            if (tn.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(tn, 10, false);
            } else {
                startLoad(tn, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.deP.a(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String tn = o.tn(metaData.getAvater());
            setUrl(tn);
            if (tn.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(tn, 10, false);
            } else {
                startLoad(tn, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                tS(metaData.getPendantData().aAG());
            } else {
                tS(null);
            }
            c(metaData);
        }
    }

    public void a(MetaData metaData, int i) {
        if (metaData != null) {
            this.deV = i;
            b(metaData);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            if (this.deW) {
                this.deO.setVisibility(8);
                return;
            }
            this.deP.setShowV(false);
            if (!UtilHelper.showHeadBjhBigVIcon(this.deO, metaData, this.deV)) {
                if (metaData.isBigV() || !StringUtils.isNull(metaData.getUserTbVipInfoData().getvipV_url())) {
                    this.deO.setImageDrawable(UtilHelper.getBjhBigVIconDrawable(this.deT));
                    fQ(true);
                    return;
                }
                fQ(false);
            }
        }
    }

    public void fQ(boolean z) {
        if (this.deO != null) {
            this.deO.setVisibility(z ? 0 : 8);
        }
    }

    public void setIsclearmode(boolean z) {
        this.deW = z;
    }
}
