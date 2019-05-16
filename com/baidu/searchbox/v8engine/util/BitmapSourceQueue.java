package com.baidu.searchbox.v8engine.util;

import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.searchbox.v8engine.bean.ImageBean;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes2.dex */
public class BitmapSourceQueue {
    private static final int CLEAR_BITMAP_THRESHOLD = 500;
    private static final boolean DEBUG = false;
    public static final int MAX_QUEUE_CAPACITY = 50;
    private static final String TAG = "BitmapSourceQueue";
    private int putsCount = 0;
    private String[] sources = new String[50];
    private int index = 0;

    public void puts(String str) {
        Integer num;
        String[] strArr;
        String str2 = this.sources[this.index];
        this.sources[this.index] = str;
        if (WebGLImageLoader.sContinuousRefMap.get(str2) != null) {
            WebGLImageLoader.sContinuousRefMap.put(str2, Integer.valueOf(num.intValue() - 1));
        }
        int i = this.index + 1;
        this.index = i;
        this.index = i % 50;
        this.putsCount++;
        if (this.putsCount % 500 == 0) {
            HashSet hashSet = new HashSet();
            for (String str3 : this.sources) {
                if (str3 != null) {
                    hashSet.add(str3);
                }
            }
            for (Map.Entry<String, ImageBean.ImageBitmapBean> entry : WebGLImageLoader.sBitmapLruCache.snapshot().entrySet()) {
                String key = entry.getKey();
                if (key != null && !hashSet.contains(key)) {
                    WebGLImageLoader.sBitmapLruCache.remove(key);
                }
            }
        }
    }
}
