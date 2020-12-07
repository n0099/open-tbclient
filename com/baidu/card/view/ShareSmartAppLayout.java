package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.card.p;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes21.dex */
public class ShareSmartAppLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a agJ;
    private ab<com.baidu.tbadk.core.data.a> aix;
    private boolean alo;
    public AppletsCellView amE;

    public ShareSmartAppLayout(Context context) {
        this(context, null);
    }

    public ShareSmartAppLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alo = true;
        this.agJ = null;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.share_smart_app_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.amE = (AppletsCellView) findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setFromCDN(boolean z) {
        this.alo = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        if (aVar == null || aVar.bmn() == null || aVar.bmn().bpE() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.agJ = aVar;
        by bmn = aVar.bmn();
        this.amE.setData(bmn.bpE());
        this.amE.setForumId(String.valueOf(bmn.getFid()));
        AppletsCellView appletsCellView = this.amE;
        AppletsCellView appletsCellView2 = this.amE;
        appletsCellView.setFrom("frs_card");
    }

    public ab<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.aix;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.aix = abVar;
    }
}
