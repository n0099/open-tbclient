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
    private a VI;
    private ab<a> WN;
    public AppletsCellView YV;
    private boolean Yd;

    public ShareSmartAppLayout(Context context) {
        this(context, null);
    }

    public ShareSmartAppLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Yd = true;
        this.VI = null;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.share_smart_app_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.YV = (AppletsCellView) findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(a aVar) {
        if (aVar == null || aVar.acC() == null || aVar.acC().afo() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.VI = aVar;
        bh acC = aVar.acC();
        this.YV.setData(acC.afo());
        this.YV.setForumId(String.valueOf(acC.getFid()));
        AppletsCellView appletsCellView = this.YV;
        AppletsCellView appletsCellView2 = this.YV;
        appletsCellView.setFrom("frs_card");
    }

    public ab<a> getSubClickListener() {
        return this.WN;
    }

    public void setSubClickListener(ab<a> abVar) {
        this.WN = abVar;
    }
}
