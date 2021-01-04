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
    private TbImageView fim;
    private ImageView fin;
    private HeadImageView fio;
    private boolean fiq;
    private boolean fir;
    private boolean fis;
    private boolean fit;
    private int fiu;
    private int fiv;
    private int fiw;
    private boolean fiy;
    private boolean fiz;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fiq = false;
        this.fir = false;
        this.fis = false;
        this.fit = false;
        this.fiu = R.drawable.ic_icon_mask_shen20_n;
        this.fiv = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.fiw = 0;
        this.fiz = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fiq = false;
        this.fir = false;
        this.fis = false;
        this.fit = false;
        this.fiu = R.drawable.ic_icon_mask_shen20_n;
        this.fiv = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.fiw = 0;
        this.fiz = true;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.fiq = false;
        this.fir = false;
        this.fis = false;
        this.fit = false;
        this.fiu = R.drawable.ic_icon_mask_shen20_n;
        this.fiv = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
        this.fiw = 0;
        this.fiz = true;
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.fiq = true;
    }

    public void setHasPendantStyle(boolean z) {
        if (this.fiq && !z && this.fio != null) {
            ((RelativeLayout.LayoutParams) this.fio.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.fin != null) {
                ((RelativeLayout.LayoutParams) this.fin.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (this.fim != null) {
                this.fim.setVisibility(8);
            }
            this.fir = false;
            invalidate();
        } else if (!this.fiq && z && this.fio != null) {
            int width = (int) (this.fio.getWidth() * 0.13f);
            int height = (int) (this.fio.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) this.fio.getLayoutParams()).setMargins(width, height, width, height);
            if (this.fin != null) {
                ((RelativeLayout.LayoutParams) this.fin.getLayoutParams()).setMargins(width, height, width, height);
            }
            invalidate();
        }
        this.fiq = z;
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.fis = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.fiq) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.fio.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.fin != null) {
                ((RelativeLayout.LayoutParams) this.fin.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        if (this.fis) {
            ((RelativeLayout.LayoutParams) this.fio.getLayoutParams()).setMargins(0, 0, 0, 0);
            if (this.fin != null) {
                ((RelativeLayout.LayoutParams) this.fin.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    public void Cu(String str) {
        if (this.fim != null) {
            if (this.fiq && !StringUtils.isNull(str)) {
                this.fir = true;
                this.fim.setVisibility(0);
                this.fim.setImageDrawable(null);
                this.fim.startLoad(str, 10, false);
                return;
            }
            this.fim.setVisibility(8);
            this.fir = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.fim.setAutoChangeStyle(z);
        this.fio.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.fiv = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        bxo();
        bxp();
        bxq();
    }

    private void bxo() {
        this.fio = new HeadImageView(this.mContext);
        this.fio.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fio.setPlaceHolder(1);
        this.fio.setDefaultResource(R.color.CAM_X0205);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.fio.setLayoutParams(layoutParams);
        addView(this.fio);
    }

    private void bxp() {
        this.fim = new TbImageView(this.mContext);
        this.fim.setPageId(this.mPageId);
        this.fim.setDefaultBgResource(0);
        this.fim.setDefaultResource(0);
        this.fim.setImageDrawable(null);
        this.fim.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.fim.setVisibility(8);
        addView(this.fim);
    }

    private void bxq() {
        this.fin = new ImageView(this.mContext);
        this.fin.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.fiv, this.fiv);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.fin.setLayoutParams(layoutParams);
        this.fin.setVisibility(8);
        addView(this.fin);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.fio != null) {
            this.fio.setPageId(bdUniqueId);
        }
        if (this.fim != null) {
            this.fim.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.fim;
    }

    public HeadImageView getHeadView() {
        return this.fio;
    }

    public ImageView getBigVIconView() {
        return this.fin;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.fiv = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        bxr();
    }

    private void bxr() {
        if (this.fiv > 0 && this.fin != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fin.getLayoutParams();
            layoutParams.width = this.fiv;
            layoutParams.height = this.fiv;
            this.fin.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.fiu = i;
    }

    public void setAuthIconType(int i) {
        this.fiw = i;
    }

    public void setUrl(String str) {
        this.fio.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.fio.setDefaultResource(i);
    }

    public void Cv(String str) {
        if (!StringUtils.isNull(str)) {
            String BQ = q.BQ(str);
            this.fio.setImageBitmap(null);
            this.fio.setUrl(BQ);
            if (BQ.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(BQ, 10, false);
            } else {
                startLoad(BQ, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.fio.a(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String BQ = q.BQ(metaData.getAvater());
            setUrl(BQ);
            if (BQ.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(BQ, 10, false);
            } else {
                startLoad(BQ, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                Cu(metaData.getPendantData().getImgUrl());
            } else {
                Cu(null);
            }
            c(metaData);
        }
    }

    public void a(MetaData metaData, int i) {
        if (metaData != null) {
            this.fiw = i;
            b(metaData);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            if (this.fiy) {
                this.fin.setVisibility(8);
                return;
            }
            this.fio.setShowV(false);
            if (!UtilHelper.showOfficialIcon(this.fin, metaData)) {
                if (metaData.isNewGod()) {
                    SvgManager.bwq().a(this.fin, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
                    jZ(true);
                    return;
                }
                jZ(false);
                if (this.fit || !UtilHelper.showHeadBazhuIcon(this.fin, metaData, this.fiz)) {
                    UtilHelper.showHeadBjhBigVIcon(this.fin, metaData, this.fiw);
                }
            }
        }
    }

    public void jZ(boolean z) {
        if (this.fin != null) {
            this.fin.setVisibility(z ? 0 : 8);
        }
    }

    public void setIsclearmode(boolean z) {
        this.fiy = z;
    }

    public void setIsHomePage(boolean z) {
        this.fit = z;
    }

    public void setShowSimpleIcon(boolean z) {
        this.fiz = z;
    }
}
