package com.baidu.live.im.b;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.live.data.br;
/* loaded from: classes7.dex */
public interface b {
    @NonNull
    View getView();

    void release();

    void setPreview();

    void setUIInfo(br brVar, boolean z);
}
