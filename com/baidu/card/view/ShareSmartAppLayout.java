package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.card.p;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes.dex */
public class ShareSmartAppLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a ahB;
    private ab<com.baidu.tbadk.core.data.a> ajy;
    private boolean amh;
    public AppletsCellView anz;

    public ShareSmartAppLayout(Context context) {
        this(context, null);
    }

    public ShareSmartAppLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amh = true;
        this.ahB = null;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.share_smart_app_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.anz = (AppletsCellView) findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setFromCDN(boolean z) {
        this.amh = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        if (aVar == null || aVar.blp() == null || aVar.blp().boG() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.ahB = aVar;
        cb blp = aVar.blp();
        this.anz.setData(blp.boG());
        this.anz.setForumId(String.valueOf(blp.getFid()));
        AppletsCellView appletsCellView = this.anz;
        AppletsCellView appletsCellView2 = this.anz;
        appletsCellView.setFrom("frs_card");
    }

    public ab<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.ajy;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.ajy = abVar;
    }
}
