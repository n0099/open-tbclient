package com.baidu.ala.alastatuploader;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.adp.lib.stats.AlaStatsItem;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaUploadStatItem {
    private Map<String, String> map = new HashMap();
    public AlaStatsItem statsItem;

    public static AlaUploadStatItem generate() {
        AlaUploadStatItem alaUploadStatItem = new AlaUploadStatItem();
        alaUploadStatItem.map.put("_net_type", String.valueOf(BdNetTypeUtil.netType()));
        alaUploadStatItem.map.put("clientTimestamp", Long.toString(System.currentTimeMillis()));
        alaUploadStatItem.map.put("deviceId", TbadkCoreApplication.getInst().getCuid());
        alaUploadStatItem.map.put("_cuid", TbadkCoreApplication.getInst().getCuid());
        alaUploadStatItem.map.put("_bdcuid", ExtraParamsManager.getBase64(ExtraParamsManager.getInstance().buildParamsExtra().getCuid()));
        alaUploadStatItem.map.put("_model", Build.MODEL);
        alaUploadStatItem.map.put("_brand", Build.BRAND);
        alaUploadStatItem.map.put("_os_type", "2");
        alaUploadStatItem.map.put("_os_ver", Build.VERSION.RELEASE);
        alaUploadStatItem.map.put("_app_ver", TbConfig.getVersion());
        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
            alaUploadStatItem.map.put("_subapp_type", TbConfig.getSubappType());
        }
        alaUploadStatItem.map.put("_subapp_version", String.valueOf(TbConfig.getSubappVersionCode()));
        alaUploadStatItem.map.put("_subapp_version_name", TbConfig.getSubappVersionName());
        alaUploadStatItem.map.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
        alaUploadStatItem.map.put("_uid", TbadkCoreApplication.getCurrentAccount());
        alaUploadStatItem.map.put("_uname", TbadkCoreApplication.getCurrentAccountName());
        return alaUploadStatItem;
    }

    public JSONObject toJsonObject() throws JSONException {
        Map<String, String> kvList;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, String> entry : this.map.entrySet()) {
            jSONObject2.putOpt(entry.getKey(), entry.getValue());
        }
        jSONObject.putOpt("baseInfo", jSONObject2);
        if (this.statsItem != null && (kvList = this.statsItem.getKvList()) != null) {
            JSONObject jSONObject3 = new JSONObject();
            for (Map.Entry<String, String> entry2 : kvList.entrySet()) {
                jSONObject3.putOpt(entry2.getKey(), entry2.getValue());
            }
            jSONObject3.putOpt("logid", Long.valueOf(this.statsItem.logID));
            jSONObject3.putOpt("type", this.statsItem.parentType);
            jSONObject3.putOpt("subtype", this.statsItem.childType);
            jSONObject.putOpt("debugInfo", jSONObject3);
        }
        return jSONObject;
    }
}
