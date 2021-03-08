package com.baidu.live.im.b;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.live.data.cr;
/* loaded from: classes10.dex */
public interface b {
    @NonNull
    View getView();

    void release();

    void setPreview();

    void setUIInfo(cr crVar, boolean z);
}
