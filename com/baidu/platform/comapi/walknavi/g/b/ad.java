package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ad extends b {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f10080a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f10081b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f10082c;

    public ad(Context context, View view) {
        this.f10081b = null;
        this.f10082c = null;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.dimen.M_W_X011);
        this.f10080a = relativeLayout;
        this.f10081b = (TextView) relativeLayout.findViewById(R.dimen.M_W_X012);
        this.f10082c = (TextView) this.f10080a.findViewById(R.dimen.M_W_X013);
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
