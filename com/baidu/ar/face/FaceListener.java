package com.baidu.ar.face;

import java.util.List;
/* loaded from: classes.dex */
public interface FaceListener {
    void onFaceResult(Object obj);

    void onStickerLoadingFinished(List list);

    void onTriggerFired(String str);
}
