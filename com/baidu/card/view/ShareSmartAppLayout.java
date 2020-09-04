package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.card.o;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes15.dex */
public class ShareSmartAppLayout extends LinearLayout implements o<AbsThreadDataSupport> {
    private AbsThreadDataSupport aeY;
    private aa<AbsThreadDataSupport> agK;
    private boolean ajt;
    public AppletsCellView akH;

    public ShareSmartAppLayout(Context context) {
        this(context, null);
    }

    public ShareSmartAppLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajt = true;
        this.aeY = null;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.share_smart_app_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.akH = (AppletsCellView) findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setFromCDN(boolean z) {
        this.ajt = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport == null || absThreadDataSupport.bce() == null || absThreadDataSupport.bce().bft() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.aeY = absThreadDataSupport;
        bw bce = absThreadDataSupport.bce();
        this.akH.setData(bce.bft());
        this.akH.setForumId(String.valueOf(bce.getFid()));
        AppletsCellView appletsCellView = this.akH;
        AppletsCellView appletsCellView2 = this.akH;
        appletsCellView.setFrom("frs_card");
    }

    public aa<AbsThreadDataSupport> getSubClickListener() {
        return this.agK;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.agK = aaVar;
    }
}
