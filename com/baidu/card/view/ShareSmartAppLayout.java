package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.card.n;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes8.dex */
public class ShareSmartAppLayout extends LinearLayout implements n<AbsThreadDataSupport> {
    private AbsThreadDataSupport adw;
    private aa<AbsThreadDataSupport> aeY;
    public AppletsCellView ahY;
    private boolean aha;

    public ShareSmartAppLayout(Context context) {
        this(context, null);
    }

    public ShareSmartAppLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aha = true;
        this.adw = null;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.share_smart_app_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ahY = (AppletsCellView) findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setFromCDN(boolean z) {
        this.aha = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport == null || absThreadDataSupport.aOi() == null || absThreadDataSupport.aOi().aRn() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.adw = absThreadDataSupport;
        bk aOi = absThreadDataSupport.aOi();
        this.ahY.setData(aOi.aRn());
        this.ahY.setForumId(String.valueOf(aOi.getFid()));
        AppletsCellView appletsCellView = this.ahY;
        AppletsCellView appletsCellView2 = this.ahY;
        appletsCellView.setFrom("frs_card");
    }

    public aa<AbsThreadDataSupport> getSubClickListener() {
        return this.aeY;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.aeY = aaVar;
    }
}
