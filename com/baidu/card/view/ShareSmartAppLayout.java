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
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes3.dex */
public class ShareSmartAppLayout extends LinearLayout implements i<a> {
    private a Vp;
    private ab<a> Wt;
    private boolean XI;
    public AppletsCellView YA;

    public ShareSmartAppLayout(Context context) {
        this(context, null);
    }

    public ShareSmartAppLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.XI = true;
        this.Vp = null;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.share_smart_app_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.YA = (AppletsCellView) findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setFromCDN(boolean z) {
        this.XI = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(a aVar) {
        if (aVar == null || aVar.abv() == null || aVar.abv().aeh() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.Vp = aVar;
        bg abv = aVar.abv();
        this.YA.setData(abv.aeh());
        this.YA.setForumId(String.valueOf(abv.getFid()));
        AppletsCellView appletsCellView = this.YA;
        AppletsCellView appletsCellView2 = this.YA;
        appletsCellView.setFrom("frs_card");
    }

    public ab<a> getSubClickListener() {
        return this.Wt;
    }

    public void setSubClickListener(ab<a> abVar) {
        this.Wt = abVar;
    }
}
