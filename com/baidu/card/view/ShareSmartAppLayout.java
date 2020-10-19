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
/* loaded from: classes21.dex */
public class ShareSmartAppLayout extends LinearLayout implements p<AbsThreadDataSupport> {
    private AbsThreadDataSupport afH;
    private aa<AbsThreadDataSupport> ahu;
    private boolean akj;
    public AppletsCellView alz;

    public ShareSmartAppLayout(Context context) {
        this(context, null);
    }

    public ShareSmartAppLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akj = true;
        this.afH = null;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.share_smart_app_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.alz = (AppletsCellView) findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setFromCDN(boolean z) {
        this.akj = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport == null || absThreadDataSupport.bfG() == null || absThreadDataSupport.bfG().biW() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.afH = absThreadDataSupport;
        bw bfG = absThreadDataSupport.bfG();
        this.alz.setData(bfG.biW());
        this.alz.setForumId(String.valueOf(bfG.getFid()));
        AppletsCellView appletsCellView = this.alz;
        AppletsCellView appletsCellView2 = this.alz;
        appletsCellView.setFrom("frs_card");
    }

    public aa<AbsThreadDataSupport> getSubClickListener() {
        return this.ahu;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.ahu = aaVar;
    }
}
