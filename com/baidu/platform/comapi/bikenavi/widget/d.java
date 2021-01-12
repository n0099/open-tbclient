package com.baidu.platform.comapi.bikenavi.widget;

import android.widget.ImageView;
import com.baidu.platform.comapi.bikenavi.widget.CustomScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class d implements CustomScrollView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4171a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.f4171a = aVar;
    }

    @Override // com.baidu.platform.comapi.bikenavi.widget.CustomScrollView.b
    public void a(com.baidu.platform.comapi.wnplatform.n.b bVar, com.baidu.platform.comapi.wnplatform.n.b bVar2) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        if (bVar != bVar2) {
            switch (bVar2) {
                case TOP:
                    imageView3 = this.f4171a.t;
                    imageView3.setVisibility(8);
                    imageView4 = this.f4171a.u;
                    imageView4.setVisibility(0);
                    this.f4171a.b(true);
                    return;
                case BOTTOM:
                    imageView = this.f4171a.t;
                    imageView.setVisibility(0);
                    imageView2 = this.f4171a.u;
                    imageView2.setVisibility(8);
                    this.f4171a.b(false);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.platform.comapi.bikenavi.widget.CustomScrollView.b
    public void a(int i) {
    }
}
