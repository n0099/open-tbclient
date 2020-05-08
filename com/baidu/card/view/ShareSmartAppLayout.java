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
    private com.baidu.tbadk.core.data.a ade;
    private z<com.baidu.tbadk.core.data.a> aeC;
    private boolean agw;
    public AppletsCellView ahv;

    public ShareSmartAppLayout(Context context) {
        this(context, null);
    }

    public ShareSmartAppLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agw = true;
        this.ade = null;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.share_smart_app_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ahv = (AppletsCellView) findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setFromCDN(boolean z) {
        this.agw = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void B(com.baidu.tbadk.core.data.a aVar) {
        if (aVar == null || aVar.aIu() == null || aVar.aIu().aLo() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.ade = aVar;
        bj aIu = aVar.aIu();
        this.ahv.setData(aIu.aLo());
        this.ahv.setForumId(String.valueOf(aIu.getFid()));
        AppletsCellView appletsCellView = this.ahv;
        AppletsCellView appletsCellView2 = this.ahv;
        appletsCellView.setFrom("frs_card");
    }

    public z<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.aeC;
    }

    public void setSubClickListener(z<com.baidu.tbadk.core.data.a> zVar) {
        this.aeC = zVar;
    }
}
