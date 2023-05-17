package com.baidu.searchbox.player.helper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.BDVideoPlayer;
/* loaded from: classes3.dex */
public class SimpleKernelReuseHelper extends AbsKernelReuseHelper {
    @Override // com.baidu.searchbox.player.helper.AbsKernelReuseHelper
    public boolean performAutoDetachCache(@NonNull BDVideoPlayer bDVideoPlayer, @Nullable String str) {
        return false;
    }
}
