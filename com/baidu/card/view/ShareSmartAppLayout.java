package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.card.p;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes.dex */
public class ShareSmartAppLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a agr;
    private aa<com.baidu.tbadk.core.data.a> ais;
    private boolean akY;
    public AppletsCellView amr;

    public ShareSmartAppLayout(Context context) {
        this(context, null);
    }

    public ShareSmartAppLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akY = true;
        this.agr = null;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.share_smart_app_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.amr = (AppletsCellView) findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setFromCDN(boolean z) {
        this.akY = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        if (aVar == null || aVar.bkV() == null || aVar.bkV().bom() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.agr = aVar;
        bz bkV = aVar.bkV();
        this.amr.setData(bkV.bom());
        this.amr.setForumId(String.valueOf(bkV.getFid()));
        AppletsCellView appletsCellView = this.amr;
        AppletsCellView appletsCellView2 = this.amr;
        appletsCellView.setFrom("frs_card");
    }

    public aa<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.ais;
    }

    public void setSubClickListener(aa<com.baidu.tbadk.core.data.a> aaVar) {
        this.ais = aaVar;
    }
}
