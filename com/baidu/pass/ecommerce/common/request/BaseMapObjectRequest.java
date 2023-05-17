package com.baidu.pass.ecommerce.common.request;

import com.baidu.pass.ecommerce.common.MapObject;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class BaseMapObjectRequest extends BaseRequest {
    public String relativeUrl;

    public BaseMapObjectRequest(String str, MapObject mapObject) {
        this.relativeUrl = str;
        if (mapObject != null) {
            Iterator<String> keyIterator = mapObject.keyIterator();
            while (keyIterator.hasNext()) {
                String next = keyIterator.next();
                addParams(next, "" + mapObject.getObjValue(next));
            }
        }
    }

    @Override // com.baidu.pass.ecommerce.common.request.BaseRequest
    public String getRelativeUrl() {
        return this.relativeUrl;
    }
}
