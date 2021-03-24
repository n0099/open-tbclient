package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ad extends b {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f10079a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f10080b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f10081c;

    public ad(Context context, View view) {
        this.f10080b = null;
        this.f10081c = null;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.dimen.M_W_X011);
        this.f10079a = relativeLayout;
        this.f10080b = (TextView) relativeLayout.findViewById(R.dimen.M_W_X012);
        this.f10081c = (TextView) this.f10079a.findViewById(R.dimen.M_W_X013);
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
