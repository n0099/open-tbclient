package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.card.n;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes15.dex */
public class ShareSmartAppLayout extends LinearLayout implements n<AbsThreadDataSupport> {
    private AbsThreadDataSupport adQ;
    private aa<AbsThreadDataSupport> afy;
    private boolean aib;
    public AppletsCellView ajq;

    public ShareSmartAppLayout(Context context) {
        this(context, null);
    }

    public ShareSmartAppLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aib = true;
        this.adQ = null;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.share_smart_app_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ajq = (AppletsCellView) findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setFromCDN(boolean z) {
        this.aib = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport == null || absThreadDataSupport.aTN() == null || absThreadDataSupport.aTN().aXa() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.adQ = absThreadDataSupport;
        bv aTN = absThreadDataSupport.aTN();
        this.ajq.setData(aTN.aXa());
        this.ajq.setForumId(String.valueOf(aTN.getFid()));
        AppletsCellView appletsCellView = this.ajq;
        AppletsCellView appletsCellView2 = this.ajq;
        appletsCellView.setFrom("frs_card");
    }

    public aa<AbsThreadDataSupport> getSubClickListener() {
        return this.afy;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.afy = aaVar;
    }
}
