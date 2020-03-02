package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.card.m;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
/* loaded from: classes8.dex */
public class ShareSmartAppLayout extends LinearLayout implements m<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a Kc;
    private z<com.baidu.tbadk.core.data.a> LD;
    private boolean NJ;
    public AppletsCellView OO;

    public ShareSmartAppLayout(Context context) {
        this(context, null);
    }

    public ShareSmartAppLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NJ = true;
        this.Kc = null;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.share_smart_app_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.OO = (AppletsCellView) findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setFromCDN(boolean z) {
        this.NJ = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        if (aVar == null || aVar.aAg() == null || aVar.aAg().aDa() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.Kc = aVar;
        bj aAg = aVar.aAg();
        this.OO.setData(aAg.aDa());
        this.OO.setForumId(String.valueOf(aAg.getFid()));
        AppletsCellView appletsCellView = this.OO;
        AppletsCellView appletsCellView2 = this.OO;
        appletsCellView.setFrom("frs_card");
    }

    public z<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.LD;
    }

    public void setSubClickListener(z<com.baidu.tbadk.core.data.a> zVar) {
        this.LD = zVar;
    }
}
