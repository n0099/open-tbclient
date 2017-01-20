package com.baidu.tbadk.core.d;

import com.baidu.tbadk.core.d.h;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h.a WM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h.a aVar) {
        this.WM = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar;
        List<Long> ty;
        h.b bVar;
        lVar = this.WM.WL;
        ty = this.WM.ty();
        lVar.l(ty);
        bVar = this.WM.WK;
        bVar.destroy();
        this.WM.destroy();
    }
}
