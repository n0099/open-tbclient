package com.baidu.searchbox.bddownload.core.breakpoint;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.DownloadTask;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class KeyToIdMap {
    @NonNull
    public final SparseArray<String> idToKeyMap;
    @NonNull
    public final HashMap<String, Integer> keyToIdMap;

    public KeyToIdMap() {
        this(new HashMap(), new SparseArray());
    }

    public void add(@NonNull DownloadTask downloadTask, int i2) {
        String generateKey = generateKey(downloadTask);
        this.keyToIdMap.put(generateKey, Integer.valueOf(i2));
        this.idToKeyMap.put(i2, generateKey);
    }

    public String generateKey(@NonNull DownloadTask downloadTask) {
        return downloadTask.getUrl() + downloadTask.getUri() + downloadTask.getFilename();
    }

    @Nullable
    public Integer get(@NonNull DownloadTask downloadTask) {
        Integer num = this.keyToIdMap.get(generateKey(downloadTask));
        if (num != null) {
            return num;
        }
        return null;
    }

    public void remove(int i2) {
        String str = this.idToKeyMap.get(i2);
        if (str != null) {
            this.keyToIdMap.remove(str);
            this.idToKeyMap.remove(i2);
        }
    }

    public KeyToIdMap(@NonNull HashMap<String, Integer> hashMap, @NonNull SparseArray<String> sparseArray) {
        this.keyToIdMap = hashMap;
        this.idToKeyMap = sparseArray;
    }
}
