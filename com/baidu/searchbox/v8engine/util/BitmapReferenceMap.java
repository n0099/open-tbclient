package com.baidu.searchbox.v8engine.util;

import com.baidu.searchbox.v8engine.bean.ImageBean;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class BitmapReferenceMap {
    private final HashMap<String, ImageBean.ImageBitmapBean> map = new HashMap<>();

    public ImageBean.ImageBitmapBean get(String str) {
        return this.map.get(str.trim());
    }

    public ImageBean.ImageBitmapBean put(String str, ImageBean.ImageBitmapBean imageBitmapBean) {
        return this.map.put(str.trim(), imageBitmapBean);
    }

    public ImageBean.ImageBitmapBean remove(String str) {
        return this.map.remove(str.trim());
    }

    public ImageBean.ImageBitmapBean decrease(String str) {
        ImageBean.ImageBitmapBean imageBitmapBean = this.map.get(str.trim());
        if (imageBitmapBean != null && imageBitmapBean.getBitmap() != null) {
            imageBitmapBean.decreaseRefCount();
            if (imageBitmapBean.getRefCount() <= 0) {
                return this.map.remove(str.trim());
            }
        }
        return null;
    }
}
