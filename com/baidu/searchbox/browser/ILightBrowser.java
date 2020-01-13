package com.baidu.searchbox.browser;

import android.content.Context;
import com.baidu.pyramid.runtime.service.d;
/* loaded from: classes12.dex */
public interface ILightBrowser {
    public static final d SERVICE_REFERENCE = new d("browser", "light");

    void open(Context context, String str);
}
