package com.baidu.ar.face;

import java.util.List;
/* loaded from: classes12.dex */
public interface FaceListener {
    void onFaceResult(Object obj);

    void onStickerLoadingFinished(List<String> list);

    void onTriggerFired(String str);
}
