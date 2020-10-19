package com.baidu.platform.comapi.bikenavi.widget;

import android.widget.ImageView;
import com.baidu.platform.comapi.bikenavi.widget.CustomScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class e implements CustomScrollView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f2848a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.f2848a = aVar;
    }

    @Override // com.baidu.platform.comapi.bikenavi.widget.CustomScrollView.b
    public void a(com.baidu.platform.comapi.wnplatform.o.b bVar, com.baidu.platform.comapi.wnplatform.o.b bVar2) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        if (bVar != bVar2) {
            switch (bVar2) {
                case TOP:
                    imageView3 = this.f2848a.t;
                    imageView3.setVisibility(8);
                    imageView4 = this.f2848a.u;
                    imageView4.setVisibility(0);
                    this.f2848a.b(true);
                    return;
                case BOTTOM:
                    imageView = this.f2848a.t;
                    imageView.setVisibility(0);
                    imageView2 = this.f2848a.u;
                    imageView2.setVisibility(8);
                    this.f2848a.b(false);
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
