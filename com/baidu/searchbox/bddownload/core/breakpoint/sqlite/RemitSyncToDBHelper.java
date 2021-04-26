package com.baidu.searchbox.bddownload.core.breakpoint.sqlite;

import androidx.annotation.NonNull;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.RemitSyncExecutor;
/* loaded from: classes2.dex */
public class RemitSyncToDBHelper {
    public long delayMillis;
    public final RemitSyncExecutor executor;

    public RemitSyncToDBHelper(@NonNull RemitSyncExecutor.RemitAgent remitAgent) {
        this(new RemitSyncExecutor(remitAgent));
    }

    public void discard(int i2) {
        this.executor.removePostWithId(i2);
        this.executor.postRemoveInfo(i2);
    }

    public void endAndEnsureToDB(int i2) {
        this.executor.removePostWithId(i2);
        try {
            if (this.executor.isFreeToDatabase(i2)) {
                return;
            }
            this.executor.postSync(i2);
        } finally {
            this.executor.postRemoveFreeId(i2);
        }
    }

    public boolean isNotFreeToDatabase(int i2) {
        return !this.executor.isFreeToDatabase(i2);
    }

    public void onTaskStart(int i2) {
        this.executor.removePostWithId(i2);
        this.executor.postSyncInfoDelay(i2, this.delayMillis);
    }

    public void shutdown() {
        this.executor.shutdown();
    }

    public RemitSyncToDBHelper(@NonNull RemitSyncExecutor remitSyncExecutor) {
        this.executor = remitSyncExecutor;
        this.delayMillis = 1500L;
    }
}
