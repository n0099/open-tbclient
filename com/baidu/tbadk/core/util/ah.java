package com.baidu.tbadk.core.util;

import android.view.ViewGroup;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.tbadk.imageManager.d {
    private final /* synthetic */ ListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ListView listView) {
        this.a = listView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && str != null) {
            br.a((ViewGroup) this.a, false, (bt) new ai(this, str));
        }
    }
}
