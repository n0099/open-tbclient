package com.baidu.platform.comapi.bikenavi.widget;

import android.widget.ImageView;
import com.baidu.platform.comapi.bikenavi.widget.CustomScrollView;
/* loaded from: classes2.dex */
public class d implements CustomScrollView.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f9786a;

    public d(a aVar) {
        this.f9786a = aVar;
    }

    @Override // com.baidu.platform.comapi.bikenavi.widget.CustomScrollView.b
    public void a(int i2) {
    }

    @Override // com.baidu.platform.comapi.bikenavi.widget.CustomScrollView.b
    public void a(com.baidu.platform.comapi.wnplatform.n.b bVar, com.baidu.platform.comapi.wnplatform.n.b bVar2) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        if (bVar == bVar2) {
            return;
        }
        int i2 = e.f9787a[bVar2.ordinal()];
        if (i2 == 1) {
            imageView = this.f9786a.t;
            imageView.setVisibility(8);
            imageView2 = this.f9786a.u;
            imageView2.setVisibility(0);
            this.f9786a.b(true);
        } else if (i2 != 2) {
        } else {
            imageView3 = this.f9786a.t;
            imageView3.setVisibility(0);
            imageView4 = this.f9786a.u;
            imageView4.setVisibility(8);
            this.f9786a.b(false);
        }
    }
}
