package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.card.n;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes8.dex */
public class ShareSmartAppLayout extends LinearLayout implements n<AbsThreadDataSupport> {
    private AbsThreadDataSupport aea;
    private aa<AbsThreadDataSupport> afH;
    private boolean aik;
    public AppletsCellView ajv;

    public ShareSmartAppLayout(Context context) {
        this(context, null);
    }

    public ShareSmartAppLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aik = true;
        this.aea = null;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.share_smart_app_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ajv = (AppletsCellView) findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setFromCDN(boolean z) {
        this.aik = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport == null || absThreadDataSupport.aPS() == null || absThreadDataSupport.aPS().aTe() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.aea = absThreadDataSupport;
        bu aPS = absThreadDataSupport.aPS();
        this.ajv.setData(aPS.aTe());
        this.ajv.setForumId(String.valueOf(aPS.getFid()));
        AppletsCellView appletsCellView = this.ajv;
        AppletsCellView appletsCellView2 = this.ajv;
        appletsCellView.setFrom("frs_card");
    }

    public aa<AbsThreadDataSupport> getSubClickListener() {
        return this.afH;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.afH = aaVar;
    }
}
