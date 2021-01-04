package com.baidu.searchbox.v8engine.util;

import com.baidu.searchbox.v8engine.bean.ImageBitmapBean;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class BitmapReferenceMap {
    private static final boolean DEBUG = false;
    private static final String TAG = "BitmapReferenceMap";
    private final HashMap<String, ImageBitmapBean> map = new HashMap<>();

    public ImageBitmapBean get(String str) {
        return this.map.get(str);
    }

    public ImageBitmapBean put(String str, ImageBitmapBean imageBitmapBean) {
        return this.map.put(str, imageBitmapBean);
    }

    public ImageBitmapBean remove(String str) {
        return this.map.remove(str);
    }

    public ImageBitmapBean decrease(String str) {
        ImageBitmapBean imageBitmapBean = this.map.get(str);
        if (imageBitmapBean != null && imageBitmapBean.getBitmap() != null) {
            imageBitmapBean.decreaseRefCount();
            if (imageBitmapBean.getRefCount() <= 0) {
                return this.map.remove(str);
            }
        }
        return null;
    }
}
