package com.baidu.searchbox.log.config;

import com.baidu.pyramid.runtime.service.d;
import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public interface APerfConfigManager {
    public static final d SERVICE_REFERENCE = new d(TbConfig.TMP_LOG_DIR_NAME, "APerfConfig");

    void registerConfig(JSONObject jSONObject);

    void registerConfig(JSONObject jSONObject, boolean z);

    void registerConfig(JSONObject jSONObject, boolean z, IAPerfStatisticCallback iAPerfStatisticCallback);

    void registerFetch(JSONObject jSONObject);

    void registerFetch(JSONObject jSONObject, IAPerfStatisticCallback iAPerfStatisticCallback);
}
