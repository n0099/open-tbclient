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
/* loaded from: classes5.dex */
public class ShareSmartAppLayout extends LinearLayout implements m<a> {
    private a JB;
    private z<a> Lb;
    private boolean Nf;
    public AppletsCellView Oi;

    public ShareSmartAppLayout(Context context) {
        this(context, null);
    }

    public ShareSmartAppLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Nf = true;
        this.JB = null;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.share_smart_app_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Oi = (AppletsCellView) findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setFromCDN(boolean z) {
        this.Nf = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(a aVar) {
        if (aVar == null || aVar.axx() == null || aVar.axx().aAq() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.JB = aVar;
        bj axx = aVar.axx();
        this.Oi.setData(axx.aAq());
        this.Oi.setForumId(String.valueOf(axx.getFid()));
        AppletsCellView appletsCellView = this.Oi;
        AppletsCellView appletsCellView2 = this.Oi;
        appletsCellView.setFrom("frs_card");
    }

    public z<a> getSubClickListener() {
        return this.Lb;
    }

    public void setSubClickListener(z<a> zVar) {
        this.Lb = zVar;
    }
}
