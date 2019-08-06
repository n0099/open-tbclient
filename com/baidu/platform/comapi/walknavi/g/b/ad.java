package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class ad extends b {
    private RelativeLayout a;
    private TextView b;
    private TextView c;

    public ad(Context context, View view) {
        this.b = null;
        this.c = null;
        this.a = (RelativeLayout) view.findViewById(R.raw.sapi_camera_blink);
        this.b = (TextView) this.a.findViewById(R.raw.sapi_camera_found_face);
        this.c = (TextView) this.a.findViewById(R.raw.sapi_camera_nod);
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
