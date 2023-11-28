package com.baidu.nadcore.video.videoplayer.ui.full;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.jx0;
/* loaded from: classes3.dex */
public class BdVideoNewCacheView extends BdVideoCacheView {
    public BdVideoNewCacheView(@NonNull Context context) {
        super(context);
    }

    @Override // com.baidu.nadcore.video.videoplayer.ui.full.BdVideoCacheView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        jx0.b("BdVideoNewCacheView", "onWindowVisibilityChanged(" + i + SmallTailInfo.EMOTION_SUFFIX);
        if (i != 0) {
            setVisibility(4);
        } else if (this.b.b()) {
            setVisibility(0);
        }
        super.onWindowVisibilityChanged(i);
    }
}
