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
    private int eRA;
    private int eRB;
    private boolean eRC;
    private boolean eRD;
    private TbImageView eRs;
    private ImageView eRt;
    private HeadImageView eRu;
    private boolean eRv;
    private boolean eRw;
    private boolean eRx;
    private boolean eRy;
    private int eRz;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eRv = false;
        this.eRw = false;
        this.eRx = false;
        this.eRy = false;
        this.eRz = R.drawable.ic_icon_mask_shen20_n;
        this.eRA = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.eRB = 0;
        this.eRD = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eRv = false;
        this.eRw = false;
        this.eRx = false;
        this.eRy = false;
        this.eRz = R.drawable.ic_icon_mask_shen20_n;
        this.eRA = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.eRB = 0;
        this.eRD = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.eRv = false;
        this.eRw = false;
        this.eRx = false;
        this.eRy = false;
        this.eRz = R.drawable.ic_icon_mask_shen20_n;
        this.eRA = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.eRB = 0;
        this.eRD = true;
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.eRv = true;
    }

    public void setHasPendantStyle(boolean z) {
        if (this.eRv && !z && this.eRu != null) {
            ((RelativeLayout.LayoutParams) this.eRu.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.eRt != null) {
                ((RelativeLayout.LayoutParams) this.eRt.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (this.eRs != null) {
                this.eRs.setVisibility(8);
            }
            this.eRw = false;
            invalidate();
        } else if (!this.eRv && z && this.eRu != null) {
            int width = (int) (this.eRu.getWidth() * 0.13f);
            int height = (int) (this.eRu.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) this.eRu.getLayoutParams()).setMargins(width, height, width, height);
            if (this.eRt != null) {
                ((RelativeLayout.LayoutParams) this.eRt.getLayoutParams()).setMargins(width, height, width, height);
            }
            invalidate();
        }
        this.eRv = z;
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.eRx = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.eRv) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.eRu.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.eRt != null) {
                ((RelativeLayout.LayoutParams) this.eRt.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        if (this.eRx) {
            ((RelativeLayout.LayoutParams) this.eRu.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.eRt != null) {
                ((RelativeLayout.LayoutParams) this.eRt.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    public void BO(String str) {
        if (this.eRs != null) {
            if (this.eRv && !StringUtils.isNull(str)) {
                this.eRw = true;
                this.eRs.setVisibility(0);
                this.eRs.setImageDrawable(null);
                this.eRs.startLoad(str, 10, false);
                return;
            }
            this.eRs.setVisibility(8);
            this.eRw = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.eRs.setAutoChangeStyle(z);
        this.eRu.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.eRA = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        brw();
        brx();
        bry();
    }

    private void brw() {
        this.eRu = new HeadImageView(this.mContext);
        this.eRu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eRu.setPlaceHolder(1);
        this.eRu.setDefaultResource(R.color.CAM_X0205);
        this.eRu.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.eRu.setLayoutParams(layoutParams);
        addView(this.eRu);
    }

    private void brx() {
        this.eRs = new TbImageView(this.mContext);
        this.eRs.setPageId(this.mPageId);
        this.eRs.setDefaultBgResource(0);
        this.eRs.setDefaultResource(0);
        this.eRs.setDefaultErrorResource(0);
        this.eRs.setImageDrawable(null);
        this.eRs.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.eRs.setVisibility(8);
        addView(this.eRs);
    }

    private void bry() {
        this.eRt = new ImageView(this.mContext);
        this.eRt.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.eRA, this.eRA);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.eRt.setLayoutParams(layoutParams);
        this.eRt.setVisibility(8);
        addView(this.eRt);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.eRu != null) {
            this.eRu.setPageId(bdUniqueId);
        }
        if (this.eRs != null) {
            this.eRs.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.eRs;
    }

    public HeadImageView getHeadView() {
        return this.eRu;
    }

    public ImageView getBigVIconView() {
        return this.eRt;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.eRA = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        brz();
    }

    private void brz() {
        if (this.eRA > 0 && this.eRt != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRt.getLayoutParams();
            layoutParams.width = this.eRA;
            layoutParams.height = this.eRA;
            this.eRt.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.eRz = i;
    }

    public void setAuthIconType(int i) {
        this.eRB = i;
    }

    public void setUrl(String str) {
        this.eRu.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.eRu.setDefaultResource(i);
    }

    public void BP(String str) {
        if (!StringUtils.isNull(str)) {
            String Bk = q.Bk(str);
            this.eRu.setImageBitmap(null);
            this.eRu.setUrl(Bk);
            if (Bk.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(Bk, 10, false);
            } else {
                startLoad(Bk, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.eRu.a(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String Bk = q.Bk(metaData.getAvater());
            setUrl(Bk);
            if (Bk.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(Bk, 10, false);
            } else {
                startLoad(Bk, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                BO(metaData.getPendantData().bjy());
            } else {
                BO(null);
            }
            c(metaData);
        }
    }

    public void a(MetaData metaData, int i) {
        if (metaData != null) {
            this.eRB = i;
            b(metaData);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            if (this.eRC) {
                this.eRt.setVisibility(8);
                return;
            }
            this.eRu.setShowV(false);
            if (metaData.isNewGod()) {
                SvgManager.bqB().a(this.eRt, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
                jn(true);
                return;
            }
            jn(false);
            if (this.eRy || !UtilHelper.showHeadBazhuIcon(this.eRt, metaData, this.eRD)) {
                UtilHelper.showHeadBjhBigVIcon(this.eRt, metaData, this.eRB);
            }
        }
    }

    public void jn(boolean z) {
        if (this.eRt != null) {
            this.eRt.setVisibility(z ? 0 : 8);
        }
    }

    public void setIsclearmode(boolean z) {
        this.eRC = z;
    }

    public void setIsHomePage(boolean z) {
        this.eRy = z;
    }

    public void setShowSimpleIcon(boolean z) {
        this.eRD = z;
    }
}
