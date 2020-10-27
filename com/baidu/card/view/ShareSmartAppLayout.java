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
import com.baidu.tieba.card.ab;
/* loaded from: classes21.dex */
public class ShareSmartAppLayout extends LinearLayout implements p<AbsThreadDataSupport> {
    private AbsThreadDataSupport afI;
    private ab<AbsThreadDataSupport> ahv;
    private boolean akk;
    public AppletsCellView alA;

    public ShareSmartAppLayout(Context context) {
        this(context, null);
    }

    public ShareSmartAppLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akk = true;
        this.afI = null;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.share_smart_app_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.alA = (AppletsCellView) findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setFromCDN(boolean z) {
        this.akk = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport == null || absThreadDataSupport.bhz() == null || absThreadDataSupport.bhz().bkP() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.afI = absThreadDataSupport;
        bw bhz = absThreadDataSupport.bhz();
        this.alA.setData(bhz.bkP());
        this.alA.setForumId(String.valueOf(bhz.getFid()));
        AppletsCellView appletsCellView = this.alA;
        AppletsCellView appletsCellView2 = this.alA;
        appletsCellView.setFrom("frs_card");
    }

    public ab<AbsThreadDataSupport> getSubClickListener() {
        return this.ahv;
    }

    public void setSubClickListener(ab<AbsThreadDataSupport> abVar) {
        this.ahv = abVar;
    }
}
