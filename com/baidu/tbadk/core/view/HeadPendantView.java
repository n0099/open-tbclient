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
    private TbImageView deM;
    private ImageView deN;
    private HeadImageView deO;
    private boolean deP;
    private boolean deQ;
    private boolean deR;
    private int deS;
    private int deT;
    private int deU;
    private boolean deV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.deP = false;
        this.deQ = false;
        this.deR = false;
        this.deS = R.drawable.ic_icon_mask_shen20_n;
        this.deT = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.deU = 0;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.deP = false;
        this.deQ = false;
        this.deR = false;
        this.deS = R.drawable.ic_icon_mask_shen20_n;
        this.deT = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.deU = 0;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.deP = false;
        this.deQ = false;
        this.deR = false;
        this.deS = R.drawable.ic_icon_mask_shen20_n;
        this.deT = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.deU = 0;
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.deP = true;
    }

    public void setHasPendantStyle(boolean z) {
        if (this.deP && !z && this.deO != null) {
            ((RelativeLayout.LayoutParams) this.deO.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.deN != null) {
                ((RelativeLayout.LayoutParams) this.deN.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (this.deM != null) {
                this.deM.setVisibility(8);
            }
            this.deQ = false;
            invalidate();
        } else if (!this.deP && z && this.deO != null) {
            int width = (int) (this.deO.getWidth() * 0.13f);
            int height = (int) (this.deO.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) this.deO.getLayoutParams()).setMargins(width, height, width, height);
            if (this.deN != null) {
                ((RelativeLayout.LayoutParams) this.deN.getLayoutParams()).setMargins(width, height, width, height);
            }
            invalidate();
        }
        this.deP = z;
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.deR = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.deP) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.deO.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.deN != null) {
                ((RelativeLayout.LayoutParams) this.deN.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        if (this.deR) {
            ((RelativeLayout.LayoutParams) this.deO.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.deN != null) {
                ((RelativeLayout.LayoutParams) this.deN.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    public void tS(String str) {
        if (this.deM != null) {
            if (this.deP && !StringUtils.isNull(str)) {
                this.deQ = true;
                this.deM.setVisibility(0);
                this.deM.setImageDrawable(null);
                this.deM.startLoad(str, 10, false);
                return;
            }
            this.deM.setVisibility(8);
            this.deQ = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.deM.setAutoChangeStyle(z);
        this.deO.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.deT = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        aHt();
        aHu();
        aHv();
    }

    private void aHt() {
        this.deO = new HeadImageView(this.mContext);
        this.deO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.deO.setPlaceHolder(1);
        this.deO.setDefaultResource(R.color.cp_bg_line_e);
        this.deO.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.deO.setLayoutParams(layoutParams);
        addView(this.deO);
    }

    private void aHu() {
        this.deM = new TbImageView(this.mContext);
        this.deM.setPageId(this.mPageId);
        this.deM.setDefaultBgResource(0);
        this.deM.setDefaultResource(0);
        this.deM.setDefaultErrorResource(0);
        this.deM.setImageDrawable(null);
        this.deM.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.deM.setVisibility(8);
        addView(this.deM);
    }

    private void aHv() {
        this.deN = new ImageView(this.mContext);
        this.deN.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.deT, this.deT);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.deN.setLayoutParams(layoutParams);
        this.deN.setVisibility(8);
        addView(this.deN);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.deO != null) {
            this.deO.setPageId(bdUniqueId);
        }
        if (this.deM != null) {
            this.deM.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.deM;
    }

    public HeadImageView getHeadView() {
        return this.deO;
    }

    public ImageView getBigVIconView() {
        return this.deN;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.deT = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        aHw();
    }

    private void aHw() {
        if (this.deT > 0 && this.deN != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.deN.getLayoutParams();
            layoutParams.width = this.deT;
            layoutParams.height = this.deT;
            this.deN.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.deS = i;
    }

    public void setAuthIconType(int i) {
        this.deU = i;
    }

    public void setUrl(String str) {
        this.deO.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.deO.setDefaultResource(i);
    }

    public void tT(String str) {
        if (!StringUtils.isNull(str)) {
            String tn = o.tn(str);
            this.deO.setImageBitmap(null);
            this.deO.setUrl(tn);
            if (tn.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(tn, 10, false);
            } else {
                startLoad(tn, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.deO.a(str, i, 0, 0, z);
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
                tS(metaData.getPendantData().aAE());
            } else {
                tS(null);
            }
            c(metaData);
        }
    }

    public void a(MetaData metaData, int i) {
        if (metaData != null) {
            this.deU = i;
            b(metaData);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            if (this.deV) {
                this.deN.setVisibility(8);
                return;
            }
            this.deO.setShowV(false);
            if (!UtilHelper.showHeadBjhBigVIcon(this.deN, metaData, this.deU)) {
                if (metaData.isBigV() || !StringUtils.isNull(metaData.getUserTbVipInfoData().getvipV_url())) {
                    this.deN.setImageDrawable(UtilHelper.getBjhBigVIconDrawable(this.deS));
                    fQ(true);
                    return;
                }
                fQ(false);
            }
        }
    }

    public void fQ(boolean z) {
        if (this.deN != null) {
            this.deN.setVisibility(z ? 0 : 8);
        }
    }

    public void setIsclearmode(boolean z) {
        this.deV = z;
    }
}
