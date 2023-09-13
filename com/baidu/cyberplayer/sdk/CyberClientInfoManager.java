package com.baidu.cyberplayer.sdk;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public class CyberClientInfoManager {
    public ArrayList<VideoClientInfoItem> mItemsList = new ArrayList<>();

    /* loaded from: classes3.dex */
    public static class VideoClientInfoItem {
        public Object mData;
        public String mKey;

        public VideoClientInfoItem(String str, Object obj) {
            this.mKey = str;
            this.mData = obj;
        }

        public Object getData() {
            return this.mData;
        }

        public String getKey() {
            return this.mKey;
        }

        public void setData(Object obj) {
            this.mData = obj;
        }
    }

    public void clear() {
        this.mItemsList.clear();
    }

    public ArrayList<VideoClientInfoItem> getItemsList() {
        return this.mItemsList;
    }

    public void setExternalInfo(String str, Object obj) {
        int size = this.mItemsList.size();
        for (int i = 0; i < size; i++) {
            VideoClientInfoItem videoClientInfoItem = this.mItemsList.get(i);
            if (videoClientInfoItem != null && videoClientInfoItem.getKey() != null && videoClientInfoItem.getKey().equals(str)) {
                videoClientInfoItem.setData(obj);
                return;
            }
        }
        this.mItemsList.add(new VideoClientInfoItem(str, obj));
    }
}
