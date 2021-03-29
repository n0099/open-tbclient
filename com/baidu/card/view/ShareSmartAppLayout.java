package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tieba.R;
import d.b.h0.r.q.a;
import d.b.h0.r.q.a2;
import d.b.i.p;
import d.b.i0.x.b0;
/* loaded from: classes.dex */
public class ShareSmartAppLayout extends LinearLayout implements p<a> {

    /* renamed from: e  reason: collision with root package name */
    public AppletsCellView f4520e;

    /* renamed from: f  reason: collision with root package name */
    public b0<a> f4521f;

    public ShareSmartAppLayout(Context context) {
        this(context, null);
    }

    public final void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.share_smart_app_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f4520e = (AppletsCellView) findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: c */
    public void a(a aVar) {
        if (aVar != null && aVar.n() != null && aVar.n().j1() != null) {
            setVisibility(0);
            a2 n = aVar.n();
            this.f4520e.setData(n.j1());
            this.f4520e.setForumId(String.valueOf(n.c0()));
            this.f4520e.setFrom("frs_card");
            return;
        }
        setVisibility(8);
    }

    public b0<a> getSubClickListener() {
        return this.f4521f;
    }

    public void setFromCDN(boolean z) {
    }

    public void setSubClickListener(b0<a> b0Var) {
        this.f4521f = b0Var;
    }

    public ShareSmartAppLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }
}
