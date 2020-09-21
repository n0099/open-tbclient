package com.baidu.searchbox.player.event;

import com.baidu.searchbox.player.pool.SynchronizedFixSizePool;
/* loaded from: classes8.dex */
public class VideoEventPool extends SynchronizedFixSizePool<VideoEvent> {
    public VideoEventPool() {
        super(10);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.pool.FixSizePool
    public VideoEvent createItem() {
        return new VideoEvent();
    }
}
