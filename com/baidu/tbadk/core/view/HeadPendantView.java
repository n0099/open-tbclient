package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantView extends RelativeLayout {
    private TbImageView bXi;
    private TbImageView bXj;
    private HeadImageView bXk;
    private boolean bXl;
    private boolean bXm;
    private int bXn;
    private int bXo;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bXl = false;
        this.bXm = false;
        this.bXn = R.drawable.pic_v_avatar;
        this.bXo = com.baidu.adp.lib.util.l.g(TbadkApplication.getInst(), R.dimen.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bXl = false;
        this.bXm = false;
        this.bXn = R.drawable.pic_v_avatar;
        this.bXo = com.baidu.adp.lib.util.l.g(TbadkApplication.getInst(), R.dimen.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.bXl = false;
        this.bXm = false;
        this.bXn = R.drawable.pic_v_avatar;
        this.bXo = com.baidu.adp.lib.util.l.g(TbadkApplication.getInst(), R.dimen.tbds42);
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.bXl = true;
    }

    public void setHasPendantStyle(boolean z) {
        this.bXl = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.bXl) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.bXk.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.bXj != null) {
                ((RelativeLayout.LayoutParams) this.bXj.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        super.onMeasure(i, i2);
    }

    public void ox(String str) {
        if (this.bXi != null) {
            if (this.bXl && !StringUtils.isNull(str)) {
                this.bXm = true;
                this.bXi.setVisibility(0);
                this.bXi.setImageDrawable(null);
                this.bXi.startLoad(str, 10, false);
                return;
            }
            this.bXi.setVisibility(8);
            this.bXm = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.bXi.setAutoChangeStyle(z);
        this.bXk.setAutoChangeStyle(z);
        this.bXj.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.bXo = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds42);
        ajh();
        aji();
        ajj();
    }

    private void ajh() {
        this.bXk = new HeadImageView(this.mContext);
        this.bXk.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.bXk.setDefaultResource(R.color.cp_bg_line_e);
        this.bXk.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.bXk.setLayoutParams(layoutParams);
        addView(this.bXk);
    }

    private void aji() {
        this.bXi = new TbImageView(this.mContext);
        this.bXi.setPageId(this.mPageId);
        this.bXi.setDefaultBgResource(0);
        this.bXi.setDefaultResource(0);
        this.bXi.setDefaultErrorResource(0);
        this.bXi.setImageDrawable(null);
        this.bXi.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.bXi.setVisibility(8);
        addView(this.bXi);
    }

    private void ajj() {
        this.bXj = new TbImageView(this.mContext);
        this.bXj.setPageId(this.mPageId);
        this.bXj.setDefaultBgResource(0);
        this.bXj.setDefaultResource(0);
        this.bXj.setDefaultErrorResource(0);
        this.bXj.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bXo, this.bXo);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.bXj.setLayoutParams(layoutParams);
        this.bXj.setVisibility(8);
        addView(this.bXj);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.bXk != null) {
            this.bXk.setPageId(bdUniqueId);
        }
        if (this.bXi != null) {
            this.bXi.setPageId(bdUniqueId);
        }
        if (this.bXj != null) {
            this.bXj.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.bXi;
    }

    public HeadImageView getHeadView() {
        return this.bXk;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.bXo = com.baidu.adp.lib.util.l.g(getContext(), i);
        }
        ajk();
    }

    private void ajk() {
        if (this.bXo > 0 && this.bXj != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bXj.getLayoutParams();
            layoutParams.width = this.bXo;
            layoutParams.height = this.bXo;
            this.bXj.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.bXn = i;
    }

    public void ax(boolean z) {
        if (this.bXj != null) {
            if (z) {
                this.bXj.setImageDrawable(al.getDrawable(this.bXn));
                this.bXj.setVisibility(0);
                return;
            }
            this.bXj.setVisibility(8);
        }
    }

    public void setUrl(String str) {
        this.bXk.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.bXk.setDefaultResource(i);
    }

    public void a(MetaData metaData, int i, int i2) {
        if (metaData != null && metaData.getPendantData() != null && !TextUtils.isEmpty(metaData.getPendantData().abS())) {
            setHasPendantStyle(true);
            setBigVDimenSize(i2);
        } else {
            setHasPendantStyle(false);
            setBigVDimenSize(i);
        }
        a(metaData);
    }

    public void oy(String str) {
        if (!StringUtils.isNull(str)) {
            String nB = o.nB(str);
            this.bXk.setImageBitmap(null);
            this.bXk.setUrl(nB);
            if (nB.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(nB, 10, false);
            } else {
                startLoad(nB, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.bXk.startLoad(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String nB = o.nB(metaData.getPortrait());
            setUrl(nB);
            if (nB.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(nB, 10, false);
            } else {
                startLoad(nB, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                ox(metaData.getPendantData().abS());
            }
            c(metaData);
        }
    }

    public void c(MetaData metaData) {
        if (metaData != null) {
            this.bXk.setShowV(false);
            if (metaData.isBigV() || !StringUtils.isNull(metaData.getUserTbVipInfoData().getvipV_url())) {
                ax(true);
            } else {
                ax(false);
            }
        }
    }
}
