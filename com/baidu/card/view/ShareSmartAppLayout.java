package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.card.i;
import com.baidu.tbadk.core.data.a;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ShareSmartAppLayout extends LinearLayout implements i<a> {
    private a Xy;
    private ab<a> YB;
    private boolean ZQ;
    public AppletsCellView aaI;

    public ShareSmartAppLayout(Context context) {
        this(context, null);
    }

    public ShareSmartAppLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZQ = true;
        this.Xy = null;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.h.share_smart_app_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.aaI = (AppletsCellView) findViewById(d.g.card_home_page_normal_thread_share_info);
    }

    public void setFromCDN(boolean z) {
        this.ZQ = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(a aVar) {
        if (aVar == null || aVar.WO() == null || aVar.WO().ZA() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.Xy = aVar;
        bg WO = aVar.WO();
        this.aaI.setData(WO.ZA());
        this.aaI.setForumId(String.valueOf(WO.getFid()));
        AppletsCellView appletsCellView = this.aaI;
        AppletsCellView appletsCellView2 = this.aaI;
        appletsCellView.setFrom("frs_card");
    }

    public ab<a> getSubClickListener() {
        return this.YB;
    }

    public void setSubClickListener(ab<a> abVar) {
        this.YB = abVar;
    }
}
