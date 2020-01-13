package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.card.m;
import com.baidu.tbadk.core.data.a;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
/* loaded from: classes6.dex */
public class ShareSmartAppLayout extends LinearLayout implements m<a> {
    private a JH;
    private z<a> Lh;
    private boolean Nj;
    public AppletsCellView Om;

    public ShareSmartAppLayout(Context context) {
        this(context, null);
    }

    public ShareSmartAppLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Nj = true;
        this.JH = null;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.share_smart_app_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Om = (AppletsCellView) findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setFromCDN(boolean z) {
        this.Nj = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(a aVar) {
        if (aVar == null || aVar.axQ() == null || aVar.axQ().aAJ() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.JH = aVar;
        bj axQ = aVar.axQ();
        this.Om.setData(axQ.aAJ());
        this.Om.setForumId(String.valueOf(axQ.getFid()));
        AppletsCellView appletsCellView = this.Om;
        AppletsCellView appletsCellView2 = this.Om;
        appletsCellView.setFrom("frs_card");
    }

    public z<a> getSubClickListener() {
        return this.Lh;
    }

    public void setSubClickListener(z<a> zVar) {
        this.Lh = zVar;
    }
}
