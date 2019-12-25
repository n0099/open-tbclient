package com.baidu.adp.lib.stats.switchs;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.base.BdUploadStatMsgData;
import com.baidu.adp.lib.stats.switchs.BdStatisticsUploadConfig;
import com.baidu.adp.lib.stats.switchs.BdStatisticsWriteConfig;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BdStatSwitchData implements Serializable {
    private static final long serialVersionUID = 1;
    private final BdStatisticsWriteConfig writeConfig = new BdStatisticsWriteConfig();
    private final BdStatisticsUploadConfig uploadConfig = new BdStatisticsUploadConfig();
    private final HashMap<String, BdUploadStatMsgData> tmpSwitchConfDataHashMap = new HashMap<>();
    private HashMap<String, ArrayList<String>> mChildTypes = new HashMap<>();

    public BdStatSwitchData() {
        BdStatisticsWriteConfig.BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem = new BdStatisticsWriteConfig.BdStatisticsWriteConfigItem();
        bdStatisticsWriteConfigItem.type = "dbg";
        bdStatisticsWriteConfigItem.isWrite = true;
        this.writeConfig.item.put(bdStatisticsWriteConfigItem.type, bdStatisticsWriteConfigItem);
        BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
        bdStatisticsUploadConfigItem.type = "dbg";
        this.uploadConfig.item.put(bdStatisticsUploadConfigItem.type, bdStatisticsUploadConfigItem);
        BdStatisticsWriteConfig.BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem2 = new BdStatisticsWriteConfig.BdStatisticsWriteConfigItem();
        bdStatisticsWriteConfigItem2.type = "stat";
        bdStatisticsWriteConfigItem2.isWrite = true;
        bdStatisticsWriteConfigItem2.isExac = true;
        this.writeConfig.item.put(bdStatisticsWriteConfigItem2.type, bdStatisticsWriteConfigItem2);
        BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem2 = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
        bdStatisticsUploadConfigItem2.type = "stat";
        bdStatisticsUploadConfigItem2.isUpload = true;
        bdStatisticsUploadConfigItem2.isWifi = false;
        this.uploadConfig.item.put(bdStatisticsUploadConfigItem2.type, bdStatisticsUploadConfigItem2);
        BdStatisticsWriteConfig.BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem3 = new BdStatisticsWriteConfig.BdStatisticsWriteConfigItem();
        bdStatisticsWriteConfigItem3.type = BdStatsConstant.StatsType.ERROR;
        bdStatisticsWriteConfigItem3.isWrite = true;
        this.writeConfig.item.put(bdStatisticsWriteConfigItem3.type, bdStatisticsWriteConfigItem3);
        BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem3 = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
        bdStatisticsUploadConfigItem3.type = BdStatsConstant.StatsType.ERROR;
        bdStatisticsUploadConfigItem3.isUpload = true;
        this.uploadConfig.item.put(bdStatisticsUploadConfigItem3.type, bdStatisticsUploadConfigItem3);
        BdStatisticsWriteConfig.BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem4 = new BdStatisticsWriteConfig.BdStatisticsWriteConfigItem();
        bdStatisticsWriteConfigItem4.type = BdStatsConstant.StatsType.PERFORMANCE;
        bdStatisticsWriteConfigItem4.isWrite = true;
        this.writeConfig.item.put(bdStatisticsWriteConfigItem4.type, bdStatisticsWriteConfigItem4);
        BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem4 = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
        bdStatisticsUploadConfigItem4.type = BdStatsConstant.StatsType.PERFORMANCE;
        bdStatisticsUploadConfigItem4.isUpload = true;
        this.uploadConfig.item.put(bdStatisticsUploadConfigItem4.type, bdStatisticsUploadConfigItem4);
        BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem5 = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
        bdStatisticsUploadConfigItem5.type = "alert";
        bdStatisticsUploadConfigItem5.isUpload = true;
        bdStatisticsUploadConfigItem5.isWifi = false;
        this.uploadConfig.item.put(bdStatisticsUploadConfigItem5.type, bdStatisticsUploadConfigItem5);
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                if (optJSONObject != null) {
                    BdStatisticsWriteConfig.BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem = new BdStatisticsWriteConfig.BdStatisticsWriteConfigItem();
                    bdStatisticsWriteConfigItem.type = "dbg";
                    this.writeConfig.item.put(bdStatisticsWriteConfigItem.type, bdStatisticsWriteConfigItem);
                    BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
                    bdStatisticsUploadConfigItem.type = "dbg";
                    this.uploadConfig.item.put(bdStatisticsUploadConfigItem.type, bdStatisticsUploadConfigItem);
                    parserCommonData(optJSONObject.optJSONArray("debug"), bdStatisticsWriteConfigItem, bdStatisticsUploadConfigItem);
                    BdStatisticsWriteConfig.BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem2 = new BdStatisticsWriteConfig.BdStatisticsWriteConfigItem();
                    bdStatisticsWriteConfigItem2.type = "stat";
                    this.writeConfig.item.put(bdStatisticsWriteConfigItem2.type, bdStatisticsWriteConfigItem2);
                    BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem2 = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
                    bdStatisticsUploadConfigItem2.type = "stat";
                    this.uploadConfig.item.put(bdStatisticsUploadConfigItem2.type, bdStatisticsUploadConfigItem2);
                    parserCommonData(optJSONObject.optJSONArray("stat"), bdStatisticsWriteConfigItem2, bdStatisticsUploadConfigItem2);
                    BdStatisticsWriteConfig.BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem3 = new BdStatisticsWriteConfig.BdStatisticsWriteConfigItem();
                    bdStatisticsWriteConfigItem3.type = BdStatsConstant.StatsType.ERROR;
                    this.writeConfig.item.put(bdStatisticsWriteConfigItem3.type, bdStatisticsWriteConfigItem3);
                    BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem3 = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
                    bdStatisticsUploadConfigItem3.type = BdStatsConstant.StatsType.ERROR;
                    this.uploadConfig.item.put(bdStatisticsUploadConfigItem3.type, bdStatisticsUploadConfigItem3);
                    parserCommonData(optJSONObject.optJSONArray(BdStatsConstant.StatsType.ERROR), bdStatisticsWriteConfigItem3, bdStatisticsUploadConfigItem3);
                    BdStatisticsWriteConfig.BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem4 = new BdStatisticsWriteConfig.BdStatisticsWriteConfigItem();
                    bdStatisticsWriteConfigItem4.type = BdStatsConstant.StatsType.PERFORMANCE;
                    this.writeConfig.item.put(bdStatisticsWriteConfigItem4.type, bdStatisticsWriteConfigItem4);
                    BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem4 = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
                    bdStatisticsUploadConfigItem4.type = BdStatsConstant.StatsType.PERFORMANCE;
                    this.uploadConfig.item.put(bdStatisticsUploadConfigItem4.type, bdStatisticsUploadConfigItem4);
                    parserCommonData(optJSONObject.optJSONArray("performance"), bdStatisticsWriteConfigItem4, bdStatisticsUploadConfigItem4);
                    BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem5 = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
                    bdStatisticsUploadConfigItem5.type = "alert";
                    this.uploadConfig.item.put(bdStatisticsUploadConfigItem5.type, bdStatisticsUploadConfigItem5);
                    parserCommonData(optJSONObject.optJSONArray("alert"), null, bdStatisticsUploadConfigItem5);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void parserCommonData(JSONArray jSONArray, BdStatisticsWriteConfig.BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem, BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem) {
        if (jSONArray != null) {
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            ArrayList<String> arrayList = new ArrayList<>();
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("common");
            if (bdStatisticsWriteConfigItem != null) {
                bdStatisticsWriteConfigItem.isWrite = optJSONObject2.optInt("is_write", 0) != 0;
                bdStatisticsWriteConfigItem.particleNum = optJSONObject2.optInt("particleNum");
                bdStatisticsWriteConfigItem.isExac = optJSONObject2.optInt("is_exact", 0) != 0;
            }
            bdStatisticsUploadConfigItem.isUpload = optJSONObject2.optInt("is_upload", 0) != 0;
            bdStatisticsUploadConfigItem.isWifi = optJSONObject2.optInt("is_only_wifi", 0) != 0;
            JSONArray optJSONArray = optJSONObject.optJSONArray("children");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    if (bdStatisticsWriteConfigItem != null) {
                        BdStatisticsWriteConfig.BdStatisticsWriteChildItem bdStatisticsWriteChildItem = new BdStatisticsWriteConfig.BdStatisticsWriteChildItem();
                        bdStatisticsWriteChildItem.subType = optJSONObject3.optString("type");
                        bdStatisticsWriteChildItem.isWrite = optJSONObject3.optInt("is_write", 0) != 0;
                        bdStatisticsWriteConfigItem.childItem.put(bdStatisticsWriteChildItem.subType, bdStatisticsWriteChildItem);
                        BdStatisticsUploadConfig.BdStatistisUploadChilidItem bdStatistisUploadChilidItem = new BdStatisticsUploadConfig.BdStatistisUploadChilidItem();
                        bdStatistisUploadChilidItem.subType = optJSONObject3.optString("type");
                        bdStatistisUploadChilidItem.isUpload = optJSONObject3.optInt("is_upload", 0) != 0;
                        bdStatistisUploadChilidItem.isWifi = optJSONObject3.optInt("is_only_wifi", 0) != 0;
                        bdStatistisUploadChilidItem.percent = optJSONObject3.optInt("percent");
                        bdStatisticsUploadConfigItem.childItem.put(bdStatistisUploadChilidItem.subType, bdStatistisUploadChilidItem);
                        arrayList.add(bdStatistisUploadChilidItem.subType);
                        this.mChildTypes.put(bdStatisticsWriteConfigItem.type, arrayList);
                    } else {
                        BdStatisticsUploadConfig.BdStatistisUploadChilidItem bdStatistisUploadChilidItem2 = new BdStatisticsUploadConfig.BdStatistisUploadChilidItem();
                        bdStatistisUploadChilidItem2.subType = optJSONObject3.optString("type");
                        bdStatistisUploadChilidItem2.isUpload = optJSONObject3.optInt("is_upload", 0) != 0;
                        bdStatistisUploadChilidItem2.maxAlertCount = optJSONObject3.optInt("alert_count");
                        bdStatistisUploadChilidItem2.uploadCycle = optJSONObject3.optInt("upload_cycle");
                        bdStatisticsUploadConfigItem.childItem.put(bdStatistisUploadChilidItem2.subType, bdStatistisUploadChilidItem2);
                    }
                }
            }
        }
    }

    public ArrayList<String> getChiledTypes(String str) {
        return this.mChildTypes.get(str);
    }

    public boolean isWrite(String str, String str2) {
        BdUploadStatMsgData bdUploadStatMsgData;
        String str3 = TextUtils.isEmpty(str2) ? str : str2;
        if (!TextUtils.isEmpty(str3) && (bdUploadStatMsgData = this.tmpSwitchConfDataHashMap.get(str3)) != null) {
            if (System.currentTimeMillis() < bdUploadStatMsgData.deadLineTime) {
                return true;
            }
            this.tmpSwitchConfDataHashMap.remove(str3);
        }
        return this.writeConfig.isWrite(str, str2);
    }

    public boolean isUpload(String str, String str2) {
        BdUploadStatMsgData bdUploadStatMsgData;
        String str3 = TextUtils.isEmpty(str2) ? str : str2;
        if (!TextUtils.isEmpty(str3) && (bdUploadStatMsgData = this.tmpSwitchConfDataHashMap.get(str3)) != null) {
            if (System.currentTimeMillis() < bdUploadStatMsgData.deadLineTime) {
                return true;
            }
            this.tmpSwitchConfDataHashMap.remove(str3);
        }
        return this.uploadConfig.isUpload(str, str2);
    }

    public boolean onlyWifiUpload(String str, String str2) {
        BdUploadStatMsgData bdUploadStatMsgData;
        String str3 = TextUtils.isEmpty(str2) ? str : str2;
        if (!TextUtils.isEmpty(str3) && (bdUploadStatMsgData = this.tmpSwitchConfDataHashMap.get(str3)) != null) {
            if (System.currentTimeMillis() < bdUploadStatMsgData.deadLineTime) {
                return bdUploadStatMsgData.isWifi;
            }
            this.tmpSwitchConfDataHashMap.remove(str3);
        }
        return this.uploadConfig.onlyWifiUpload(str, str2);
    }

    public boolean isExactWriteFile(String str) {
        return this.writeConfig.isExactWriteFile(str);
    }

    public int getMaxAlertCount(String str, int i) {
        return this.uploadConfig.getMaxAlertCount(str, i);
    }

    public int geUploadCycle(String str, int i) {
        return this.uploadConfig.geUploadCycle(str, i);
    }

    public boolean smallFlowUpload(String str, String str2) {
        BdUploadStatMsgData bdUploadStatMsgData = this.tmpSwitchConfDataHashMap.get(str2);
        if (bdUploadStatMsgData != null) {
            if (System.currentTimeMillis() < bdUploadStatMsgData.deadLineTime) {
                return true;
            }
            this.tmpSwitchConfDataHashMap.remove(str2);
        }
        return this.uploadConfig.smallFlowUpload(str, str2);
    }

    public void putTmpSwitchConfData(String str, BdUploadStatMsgData bdUploadStatMsgData) {
        this.tmpSwitchConfDataHashMap.put(str, bdUploadStatMsgData);
    }

    public BdUploadStatMsgData getTmpSwitchConfData(String str) {
        return this.tmpSwitchConfDataHashMap.get(str);
    }

    public void rmTmpSwitchConfData(String str) {
        this.tmpSwitchConfDataHashMap.remove(str);
    }
}
