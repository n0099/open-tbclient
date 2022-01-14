package com.baidu.searchbox.pms.callback;

import com.baidu.searchbox.pms.bean.CheckData;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public interface IDataInterceptor {
    JSONObject getUploadData();

    CheckData onReceiveData(JSONObject jSONObject, int i2, int i3, String str);
}
