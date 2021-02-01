package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ad extends b {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f4295a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f4296b;
    private TextView c;

    public ad(Context context, View view) {
        this.f4296b = null;
        this.c = null;
        this.f4295a = (RelativeLayout) view.findViewById(R.dimen.M_W_X011);
        this.f4296b = (TextView) this.f4295a.findViewById(R.dimen.M_W_X012);
        this.c = (TextView) this.f4295a.findViewById(R.dimen.M_W_X013);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.platform.comapi.walknavi.g.b.b
    public void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.platform.comapi.walknavi.g.b.b
    public void b() {
    }

    public void c() {
    }
}
