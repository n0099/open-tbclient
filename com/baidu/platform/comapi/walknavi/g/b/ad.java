package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ad extends b {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f9638a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f9639b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f9640c;

    public ad(Context context, View view) {
        this.f9639b = null;
        this.f9640c = null;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.dimen.M_W_X011);
        this.f9638a = relativeLayout;
        this.f9639b = (TextView) relativeLayout.findViewById(R.dimen.M_W_X012);
        this.f9640c = (TextView) this.f9638a.findViewById(R.dimen.M_W_X013);
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.b
    public void a() {
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.b
    public void b() {
    }

    public void c() {
    }
}
