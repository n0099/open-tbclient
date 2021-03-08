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
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantView extends RelativeLayout {
    private int fhA;
    private boolean fhB;
    private boolean fhC;
    private TbImageView fhr;
    private ImageView fhs;
    private HeadImageView fht;
    private boolean fhu;
    private boolean fhv;
    private boolean fhw;
    private boolean fhx;
    private int fhy;
    private int fhz;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fhu = false;
        this.fhv = false;
        this.fhw = false;
        this.fhx = false;
        this.fhy = R.drawable.ic_icon_mask_shen20_n;
        this.fhz = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.fhA = 0;
        this.fhC = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fhu = false;
        this.fhv = false;
        this.fhw = false;
        this.fhx = false;
        this.fhy = R.drawable.ic_icon_mask_shen20_n;
        this.fhz = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.fhA = 0;
        this.fhC = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.fhu = false;
        this.fhv = false;
        this.fhw = false;
        this.fhx = false;
        this.fhy = R.drawable.ic_icon_mask_shen20_n;
        this.fhz = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.fhA = 0;
        this.fhC = true;
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.fhu = true;
    }

    public void setHasPendantStyle(boolean z) {
        if (this.fhu && !z && this.fht != null) {
            ((RelativeLayout.LayoutParams) this.fht.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.fhs != null) {
                ((RelativeLayout.LayoutParams) this.fhs.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (this.fhr != null) {
                this.fhr.setVisibility(8);
            }
            this.fhv = false;
            invalidate();
        } else if (!this.fhu && z && this.fht != null) {
            int width = (int) (this.fht.getWidth() * 0.13f);
            int height = (int) (this.fht.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) this.fht.getLayoutParams()).setMargins(width, height, width, height);
            if (this.fhs != null) {
                ((RelativeLayout.LayoutParams) this.fhs.getLayoutParams()).setMargins(width, height, width, height);
            }
            invalidate();
        }
        this.fhu = z;
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.fhw = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.fhu) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.fht.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.fhs != null) {
                ((RelativeLayout.LayoutParams) this.fhs.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        if (this.fhw) {
            ((RelativeLayout.LayoutParams) this.fht.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.fhs != null) {
                ((RelativeLayout.LayoutParams) this.fhs.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    public void BG(String str) {
        if (this.fhr != null) {
            if (this.fhu && !StringUtils.isNull(str)) {
                this.fhv = true;
                this.fhr.setVisibility(0);
                this.fhr.setImageDrawable(null);
                this.fhr.startLoad(str, 10, false);
                return;
            }
            this.fhr.setVisibility(8);
            this.fhv = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.fhr.setAutoChangeStyle(z);
        this.fht.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.fhz = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        btS();
        btT();
        btU();
    }

    private void btS() {
        this.fht = new HeadImageView(this.mContext);
        this.fht.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fht.setPlaceHolder(1);
        this.fht.setDefaultResource(R.color.CAM_X0205);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.fht.setLayoutParams(layoutParams);
        addView(this.fht);
    }

    private void btT() {
        this.fhr = new TbImageView(this.mContext);
        this.fhr.setPageId(this.mPageId);
        this.fhr.setDefaultBgResource(0);
        this.fhr.setDefaultResource(0);
        this.fhr.setImageDrawable(null);
        this.fhr.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.fhr.setVisibility(8);
        addView(this.fhr);
    }

    private void btU() {
        this.fhs = new ImageView(this.mContext);
        this.fhs.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.fhz, this.fhz);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.fhs.setLayoutParams(layoutParams);
        this.fhs.setVisibility(8);
        addView(this.fhs);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.fht != null) {
            this.fht.setPageId(bdUniqueId);
        }
        if (this.fhr != null) {
            this.fhr.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.fhr;
    }

    public HeadImageView getHeadView() {
        return this.fht;
    }

    public ImageView getBigVIconView() {
        return this.fhs;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.fhz = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        btV();
    }

    private void btV() {
        if (this.fhz > 0 && this.fhs != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fhs.getLayoutParams();
            layoutParams.width = this.fhz;
            layoutParams.height = this.fhz;
            this.fhs.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.fhy = i;
    }

    public void setAuthIconType(int i) {
        this.fhA = i;
    }

    public void setUrl(String str) {
        this.fht.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.fht.setDefaultResource(i);
    }

    public void BH(String str) {
        if (!StringUtils.isNull(str)) {
            String Bc = r.Bc(str);
            this.fht.setImageBitmap(null);
            this.fht.setUrl(Bc);
            if (Bc.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(Bc, 10, false);
            } else {
                startLoad(Bc, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.fht.a(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String Bc = r.Bc(metaData.getAvater());
            setUrl(Bc);
            if (Bc.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(Bc, 10, false);
            } else {
                startLoad(Bc, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                BG(metaData.getPendantData().getImgUrl());
            } else {
                BG(null);
            }
            c(metaData);
        }
    }

    public void a(MetaData metaData, int i) {
        if (metaData != null) {
            this.fhA = i;
            b(metaData);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            if (this.fhB) {
                this.fhs.setVisibility(8);
                return;
            }
            this.fht.setShowV(false);
            if (!UtilHelper.showOfficialIcon(this.fhs, metaData)) {
                if (metaData.isNewGod()) {
                    SvgManager.bsU().a(this.fhs, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
                    jY(true);
                    return;
                }
                jY(false);
                if (this.fhx || !UtilHelper.showHeadBazhuIcon(this.fhs, metaData, this.fhC)) {
                    UtilHelper.showHeadBjhBigVIcon(this.fhs, metaData, this.fhA);
                }
            }
        }
    }

    public void jY(boolean z) {
        if (this.fhs != null) {
            this.fhs.setVisibility(z ? 0 : 8);
        }
    }

    public void setIsclearmode(boolean z) {
        this.fhB = z;
    }

    public void setIsHomePage(boolean z) {
        this.fhx = z;
    }

    public void setShowSimpleIcon(boolean z) {
        this.fhC = z;
    }
}
