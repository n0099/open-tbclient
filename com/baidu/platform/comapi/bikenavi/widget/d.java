package com.baidu.platform.comapi.bikenavi.widget;

import android.widget.ImageView;
import com.baidu.platform.comapi.bikenavi.widget.CustomScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class d implements CustomScrollView.b {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
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
                    imageView3 = this.a.t;
                    imageView3.setVisibility(8);
                    imageView4 = this.a.u;
                    imageView4.setVisibility(0);
                    this.a.b(true);
                    return;
                case BOTTOM:
                    imageView = this.a.t;
                    imageView.setVisibility(0);
                    imageView2 = this.a.u;
                    imageView2.setVisibility(8);
                    this.a.b(false);
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
