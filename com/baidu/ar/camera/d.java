package com.baidu.ar.camera;

import android.hardware.Camera;
import java.util.Comparator;
/* loaded from: classes3.dex */
class d implements Comparator<Camera.Size> {
    private boolean a;

    public d(boolean z) {
        this.a = true;
        this.a = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Camera.Size size, Camera.Size size2) {
        return this.a ? size.width - size2.width : size2.width - size.width;
    }
}
