package com.baidu.tbadk.core.util;

import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class am implements com.baidu.tbadk.imageManager.d {
    private final /* synthetic */ ListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ListView listView) {
        this.a = listView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null) {
            ImageView imageView = (ImageView) this.a.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                imageView.setImageBitmap(aVar.h());
                imageView = (ImageView) this.a.findViewWithTag(str);
            }
        }
    }
}
