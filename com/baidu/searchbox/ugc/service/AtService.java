package com.baidu.searchbox.ugc.service;

import android.content.Context;
import com.baidu.pyramid.runtime.service.d;
import com.baidu.searchbox.ugc.model.AtUserInfoItem;
/* loaded from: classes5.dex */
public interface AtService {
    public static final d SERVICE_REFERENCE = new d("publisher", "at");

    void open(Context context);

    void postAtSelectEvent(AtUserInfoItem atUserInfoItem);
}
