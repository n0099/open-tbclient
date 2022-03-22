package com.baidu.searchbox.pms.callback;

import com.baidu.searchbox.pms.bean.CheckData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface IDataInterceptor {
    JSONObject getUploadData();

    CheckData onReceiveData(JSONObject jSONObject, int i, int i2, String str);
}
