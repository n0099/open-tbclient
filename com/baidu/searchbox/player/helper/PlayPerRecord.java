package com.baidu.searchbox.player.helper;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.utils.BdVideoLog;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class PlayPerRecord {
    public static final List<PerRecord> sRecords = new ArrayList();

    /* loaded from: classes2.dex */
    public static class PerRecord {
        public long duration;
        public long endTime;
        public String from;
        public String page;
        public long startTime;

        public PerRecord(long j, long j2, String str, String str2) {
            this.startTime = j;
            this.endTime = j2;
            this.from = str;
            this.page = str2;
            this.duration = j2 - j;
        }

        public long getDuration() {
            return this.duration;
        }

        public String toString() {
            return "PerRecord{startTime=" + this.startTime + ", endTime=" + this.endTime + ", from='" + this.from + "', page='" + this.page + "', duration=" + this.duration + '}';
        }
    }

    public static void clear() {
        sRecords.clear();
    }

    public static synchronized void putRecord(@NonNull PerRecord perRecord) {
        synchronized (PlayPerRecord.class) {
            BdVideoLog.d("add play speed record =>" + perRecord);
            sRecords.add(perRecord);
        }
    }
}
