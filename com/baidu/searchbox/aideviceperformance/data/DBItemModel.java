package com.baidu.searchbox.aideviceperformance.data;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class DBItemModel {

    /* loaded from: classes2.dex */
    public static class UserStickinessItemModel {
        public static final int DEFAULT_COUNT = 0;
        public static final long DEFAULT_FIRST_TIME = 0;
        public HashMap<String, ItemDetailModel> mIdToItemDetailMap;
        public long timeStamp;

        /* loaded from: classes2.dex */
        public static class ItemDetailModel {
            public int count;
            public long firstTime;

            public ItemDetailModel(int i, long j) {
                this.count = i;
                this.firstTime = j;
            }

            public String toString() {
                return "count: " + this.count + " firstTime: " + this.firstTime;
            }
        }

        public UserStickinessItemModel(long j) {
            this.mIdToItemDetailMap = new HashMap<>();
            this.timeStamp = j;
        }

        public UserStickinessItemModel(String str, int i, long j, long j2) {
            HashMap<String, ItemDetailModel> hashMap = new HashMap<>();
            this.mIdToItemDetailMap = hashMap;
            this.timeStamp = j2;
            hashMap.put(str, new ItemDetailModel(i, j));
        }

        public HashMap<String, ItemDetailModel> getIdToItemDetailMap() {
            return this.mIdToItemDetailMap;
        }

        public void putIdToItemDetailMap(String str, ItemDetailModel itemDetailModel) {
            this.mIdToItemDetailMap.put(str, itemDetailModel);
        }

        public String toString() {
            String str = "timeStamp: " + this.timeStamp;
            for (Map.Entry<String, ItemDetailModel> entry : this.mIdToItemDetailMap.entrySet()) {
                ItemDetailModel value = entry.getValue();
                str = str + " id: " + entry.getKey() + " count: " + value.count + " firstTime: " + value.firstTime;
            }
            return str;
        }
    }

    /* loaded from: classes2.dex */
    public static class LaunchTimeItemModel {
        public long launchTime;
        public long timeStamp;

        public LaunchTimeItemModel(long j, long j2) {
            this.launchTime = j;
            this.timeStamp = j2;
        }
    }
}
