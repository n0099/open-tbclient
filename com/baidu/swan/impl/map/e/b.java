package com.baidu.swan.impl.map.e;

import android.graphics.Color;
import com.baidu.mapapi.map.BaiduMap;
/* loaded from: classes25.dex */
public class b extends a {
    private static final int efr = Color.parseColor("#26c56c");

    public b(BaiduMap baiduMap) {
        super(baiduMap);
    }

    @Override // com.baidu.swan.impl.map.e.a
    public int getLineColor() {
        return efr;
    }
}
