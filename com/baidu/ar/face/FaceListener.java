package com.baidu.ar.face;

import java.util.List;
/* loaded from: classes6.dex */
public interface FaceListener {
    void onFaceResult(Object obj);

    void onStickerLoadingFinished(List<String> list);

    void onTriggerFired(String str);
}
