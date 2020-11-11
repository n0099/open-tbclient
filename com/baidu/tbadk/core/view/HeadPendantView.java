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
    private boolean eSA;
    private boolean eSB;
    private TbImageView eSq;
    private ImageView eSr;
    private HeadImageView eSs;
    private boolean eSt;
    private boolean eSu;
    private boolean eSv;
    private boolean eSw;
    private int eSx;
    private int eSy;
    private int eSz;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eSt = false;
        this.eSu = false;
        this.eSv = false;
        this.eSw = false;
        this.eSx = R.drawable.ic_icon_mask_shen20_n;
        this.eSy = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.eSz = 0;
        this.eSB = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eSt = false;
        this.eSu = false;
        this.eSv = false;
        this.eSw = false;
        this.eSx = R.drawable.ic_icon_mask_shen20_n;
        this.eSy = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.eSz = 0;
        this.eSB = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.eSt = false;
        this.eSu = false;
        this.eSv = false;
        this.eSw = false;
        this.eSx = R.drawable.ic_icon_mask_shen20_n;
        this.eSy = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.eSz = 0;
        this.eSB = true;
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.eSt = true;
    }

    public void setHasPendantStyle(boolean z) {
        if (this.eSt && !z && this.eSs != null) {
            ((RelativeLayout.LayoutParams) this.eSs.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.eSr != null) {
                ((RelativeLayout.LayoutParams) this.eSr.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (this.eSq != null) {
                this.eSq.setVisibility(8);
            }
            this.eSu = false;
            invalidate();
        } else if (!this.eSt && z && this.eSs != null) {
            int width = (int) (this.eSs.getWidth() * 0.13f);
            int height = (int) (this.eSs.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) this.eSs.getLayoutParams()).setMargins(width, height, width, height);
            if (this.eSr != null) {
                ((RelativeLayout.LayoutParams) this.eSr.getLayoutParams()).setMargins(width, height, width, height);
            }
            invalidate();
        }
        this.eSt = z;
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.eSv = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.eSt) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.eSs.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.eSr != null) {
                ((RelativeLayout.LayoutParams) this.eSr.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        if (this.eSv) {
            ((RelativeLayout.LayoutParams) this.eSs.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.eSr != null) {
                ((RelativeLayout.LayoutParams) this.eSr.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    public void Cp(String str) {
        if (this.eSq != null) {
            if (this.eSt && !StringUtils.isNull(str)) {
                this.eSu = true;
                this.eSq.setVisibility(0);
                this.eSq.setImageDrawable(null);
                this.eSq.startLoad(str, 10, false);
                return;
            }
            this.eSq.setVisibility(8);
            this.eSu = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.eSq.setAutoChangeStyle(z);
        this.eSs.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.eSy = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        bsi();
        bsj();
        bsk();
    }

    private void bsi() {
        this.eSs = new HeadImageView(this.mContext);
        this.eSs.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eSs.setPlaceHolder(1);
        this.eSs.setDefaultResource(R.color.cp_bg_line_e);
        this.eSs.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.eSs.setLayoutParams(layoutParams);
        addView(this.eSs);
    }

    private void bsj() {
        this.eSq = new TbImageView(this.mContext);
        this.eSq.setPageId(this.mPageId);
        this.eSq.setDefaultBgResource(0);
        this.eSq.setDefaultResource(0);
        this.eSq.setDefaultErrorResource(0);
        this.eSq.setImageDrawable(null);
        this.eSq.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.eSq.setVisibility(8);
        addView(this.eSq);
    }

    private void bsk() {
        this.eSr = new ImageView(this.mContext);
        this.eSr.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.eSy, this.eSy);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.eSr.setLayoutParams(layoutParams);
        this.eSr.setVisibility(8);
        addView(this.eSr);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.eSs != null) {
            this.eSs.setPageId(bdUniqueId);
        }
        if (this.eSq != null) {
            this.eSq.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.eSq;
    }

    public HeadImageView getHeadView() {
        return this.eSs;
    }

    public ImageView getBigVIconView() {
        return this.eSr;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.eSy = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        bsl();
    }

    private void bsl() {
        if (this.eSy > 0 && this.eSr != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eSr.getLayoutParams();
            layoutParams.width = this.eSy;
            layoutParams.height = this.eSy;
            this.eSr.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.eSx = i;
    }

    public void setAuthIconType(int i) {
        this.eSz = i;
    }

    public void setUrl(String str) {
        this.eSs.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.eSs.setDefaultResource(i);
    }

    public void Cq(String str) {
        if (!StringUtils.isNull(str)) {
            String BL = q.BL(str);
            this.eSs.setImageBitmap(null);
            this.eSs.setUrl(BL);
            if (BL.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(BL, 10, false);
            } else {
                startLoad(BL, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.eSs.a(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String BL = q.BL(metaData.getAvater());
            setUrl(BL);
            if (BL.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(BL, 10, false);
            } else {
                startLoad(BL, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                Cp(metaData.getPendantData().bkw());
            } else {
                Cp(null);
            }
            c(metaData);
        }
    }

    public void a(MetaData metaData, int i) {
        if (metaData != null) {
            this.eSz = i;
            b(metaData);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            if (this.eSA) {
                this.eSr.setVisibility(8);
                return;
            }
            this.eSs.setShowV(false);
            if (metaData.isNewGod()) {
                SvgManager.brn().a(this.eSr, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
                jm(true);
                return;
            }
            jm(false);
            if (this.eSw || !UtilHelper.showHeadBazhuIcon(this.eSr, metaData, this.eSB)) {
                UtilHelper.showHeadBjhBigVIcon(this.eSr, metaData, this.eSz);
            }
        }
    }

    public void jm(boolean z) {
        if (this.eSr != null) {
            this.eSr.setVisibility(z ? 0 : 8);
        }
    }

    public void setIsclearmode(boolean z) {
        this.eSA = z;
    }

    public void setIsHomePage(boolean z) {
        this.eSw = z;
    }

    public void setShowSimpleIcon(boolean z) {
        this.eSB = z;
    }
}
