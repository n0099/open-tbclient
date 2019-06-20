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
    private TbImageView bXj;
    private TbImageView bXk;
    private HeadImageView bXl;
    private boolean bXm;
    private boolean bXn;
    private int bXo;
    private int bXp;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bXm = false;
        this.bXn = false;
        this.bXo = R.drawable.pic_v_avatar;
        this.bXp = com.baidu.adp.lib.util.l.g(TbadkApplication.getInst(), R.dimen.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bXm = false;
        this.bXn = false;
        this.bXo = R.drawable.pic_v_avatar;
        this.bXp = com.baidu.adp.lib.util.l.g(TbadkApplication.getInst(), R.dimen.tbds42);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.bXm = false;
        this.bXn = false;
        this.bXo = R.drawable.pic_v_avatar;
        this.bXp = com.baidu.adp.lib.util.l.g(TbadkApplication.getInst(), R.dimen.tbds42);
        this.mContext = context;
        init();
    }

    public void setHasPendantStyle() {
        this.bXm = true;
    }

    public void setHasPendantStyle(boolean z) {
        this.bXm = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.bXm) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.bXl.getLayoutParams()).setMargins(i3, size2, i3, size2);
            if (this.bXk != null) {
                ((RelativeLayout.LayoutParams) this.bXk.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        super.onMeasure(i, i2);
    }

    public void ow(String str) {
        if (this.bXj != null) {
            if (this.bXm && !StringUtils.isNull(str)) {
                this.bXn = true;
                this.bXj.setVisibility(0);
                this.bXj.setImageDrawable(null);
                this.bXj.startLoad(str, 10, false);
                return;
            }
            this.bXj.setVisibility(8);
            this.bXn = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.bXj.setAutoChangeStyle(z);
        this.bXl.setAutoChangeStyle(z);
        this.bXk.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.bXp = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds42);
        ajh();
        aji();
        ajj();
    }

    private void ajh() {
        this.bXl = new HeadImageView(this.mContext);
        this.bXl.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.bXl.setDefaultResource(R.color.cp_bg_line_e);
        this.bXl.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.bXl.setLayoutParams(layoutParams);
        addView(this.bXl);
    }

    private void aji() {
        this.bXj = new TbImageView(this.mContext);
        this.bXj.setPageId(this.mPageId);
        this.bXj.setDefaultBgResource(0);
        this.bXj.setDefaultResource(0);
        this.bXj.setDefaultErrorResource(0);
        this.bXj.setImageDrawable(null);
        this.bXj.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.bXj.setVisibility(8);
        addView(this.bXj);
    }

    private void ajj() {
        this.bXk = new TbImageView(this.mContext);
        this.bXk.setPageId(this.mPageId);
        this.bXk.setDefaultBgResource(0);
        this.bXk.setDefaultResource(0);
        this.bXk.setDefaultErrorResource(0);
        this.bXk.setImageDrawable(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bXp, this.bXp);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.bXk.setLayoutParams(layoutParams);
        this.bXk.setVisibility(8);
        addView(this.bXk);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.bXl != null) {
            this.bXl.setPageId(bdUniqueId);
        }
        if (this.bXj != null) {
            this.bXj.setPageId(bdUniqueId);
        }
        if (this.bXk != null) {
            this.bXk.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.bXj;
    }

    public HeadImageView getHeadView() {
        return this.bXl;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.bXp = com.baidu.adp.lib.util.l.g(getContext(), i);
        }
        ajk();
    }

    private void ajk() {
        if (this.bXp > 0 && this.bXk != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bXk.getLayoutParams();
            layoutParams.width = this.bXp;
            layoutParams.height = this.bXp;
            this.bXk.setLayoutParams(layoutParams);
        }
    }

    public void setBigVIconResId(int i) {
        this.bXo = i;
    }

    public void ax(boolean z) {
        if (this.bXk != null) {
            if (z) {
                this.bXk.setImageDrawable(al.getDrawable(this.bXo));
                this.bXk.setVisibility(0);
                return;
            }
            this.bXk.setVisibility(8);
        }
    }

    public void setUrl(String str) {
        this.bXl.setUrl(str);
    }

    public void setDefalutResid(int i) {
        this.bXl.setDefaultResource(i);
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

    public void ox(String str) {
        if (!StringUtils.isNull(str)) {
            String nA = o.nA(str);
            this.bXl.setImageBitmap(null);
            this.bXl.setUrl(nA);
            if (nA.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(nA, 10, false);
            } else {
                startLoad(nA, 25, false);
            }
        }
    }

    public void startLoad(String str, int i, boolean z) {
        this.bXl.startLoad(str, i, 0, 0, z);
    }

    public void a(MetaData metaData) {
        if (metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String nA = o.nA(metaData.getPortrait());
            setUrl(nA);
            if (nA.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(nA, 10, false);
            } else {
                startLoad(nA, 25, false);
            }
            b(metaData);
        }
    }

    public void b(MetaData metaData) {
        if (metaData != null) {
            if (metaData.getPendantData() != null) {
                ow(metaData.getPendantData().abS());
            }
            c(metaData);
        }
    }

    public void c(MetaData metaData) {
        if (metaData != null) {
            this.bXl.setShowV(false);
            if (metaData.isBigV() || !StringUtils.isNull(metaData.getUserTbVipInfoData().getvipV_url())) {
                ax(true);
            } else {
                ax(false);
            }
        }
    }
}
