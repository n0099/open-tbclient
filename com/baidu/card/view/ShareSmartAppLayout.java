package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.card.i;
import com.baidu.tbadk.core.data.a;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes3.dex */
public class ShareSmartAppLayout extends LinearLayout implements i<a> {
    private a EX;
    private ab<a> Gd;
    private boolean Hx;
    public AppletsCellView Ir;

    public ShareSmartAppLayout(Context context) {
        this(context, null);
    }

    public ShareSmartAppLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hx = true;
        this.EX = null;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.share_smart_app_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Ir = (AppletsCellView) findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setFromCDN(boolean z) {
        this.Hx = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(a aVar) {
        if (aVar == null || aVar.agG() == null || aVar.agG().ajq() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.EX = aVar;
        bh agG = aVar.agG();
        this.Ir.setData(agG.ajq());
        this.Ir.setForumId(String.valueOf(agG.getFid()));
        AppletsCellView appletsCellView = this.Ir;
        AppletsCellView appletsCellView2 = this.Ir;
        appletsCellView.setFrom("frs_card");
    }

    public ab<a> getSubClickListener() {
        return this.Gd;
    }

    public void setSubClickListener(ab<a> abVar) {
        this.Gd = abVar;
    }
}
