package com.baidu.live.im.b;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.live.data.cg;
/* loaded from: classes4.dex */
public interface b {
    @NonNull
    View getView();

    void release();

    void setPreview();

    void setUIInfo(cg cgVar, boolean z);
}
