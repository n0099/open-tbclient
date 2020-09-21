package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.card.p;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes20.dex */
public class ShareSmartAppLayout extends LinearLayout implements p<AbsThreadDataSupport> {
    private AbsThreadDataSupport afq;
    private aa<AbsThreadDataSupport> ahd;
    private boolean ajR;
    public AppletsCellView alg;

    public ShareSmartAppLayout(Context context) {
        this(context, null);
    }

    public ShareSmartAppLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajR = true;
        this.afq = null;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.share_smart_app_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.alg = (AppletsCellView) findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setFromCDN(boolean z) {
        this.ajR = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport == null || absThreadDataSupport.bcY() == null || absThreadDataSupport.bcY().bgn() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.afq = absThreadDataSupport;
        bw bcY = absThreadDataSupport.bcY();
        this.alg.setData(bcY.bgn());
        this.alg.setForumId(String.valueOf(bcY.getFid()));
        AppletsCellView appletsCellView = this.alg;
        AppletsCellView appletsCellView2 = this.alg;
        appletsCellView.setFrom("frs_card");
    }

    public aa<AbsThreadDataSupport> getSubClickListener() {
        return this.ahd;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.ahd = aaVar;
    }
}
