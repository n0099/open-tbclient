package com.baidu.searchbox.ng.ai.apps.ar.camera;

import android.hardware.Camera;
import java.util.Comparator;
/* loaded from: classes2.dex */
class CameraSizeComparator implements Comparator<Camera.Size> {
    private boolean mOrderByASC;

    public CameraSizeComparator(boolean z) {
        this.mOrderByASC = true;
        this.mOrderByASC = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(Camera.Size size, Camera.Size size2) {
        return this.mOrderByASC ? size.width - size2.width : size2.width - size.width;
    }
}
