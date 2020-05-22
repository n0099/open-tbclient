package com.baidu.swan.apps.component.components.c;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.swan.apps.component.d.b;
/* loaded from: classes11.dex */
public final class a extends com.baidu.swan.apps.component.b.a<CameraPreview, com.baidu.swan.apps.camera.d.a> {
    public a(@NonNull Context context, @NonNull com.baidu.swan.apps.camera.d.a aVar) {
        super(context, aVar);
        es(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: bx */
    public CameraPreview aY(@NonNull Context context) {
        return new CameraPreview(context, Vj());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    public void a(@NonNull CameraPreview cameraPreview, @NonNull com.baidu.swan.apps.camera.d.a aVar, @NonNull b bVar) {
        super.a((a) cameraPreview, (CameraPreview) aVar, bVar);
        if (Vn()) {
            cameraPreview.b(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    public void onRemove() {
        super.onRemove();
        CameraPreview view = getView();
        if (view != null) {
            view.onRelease();
        }
    }
}
