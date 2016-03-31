package com.baidu.adp.lib.stats.switchs;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.base.BdUploadStatMsgData;
import com.baidu.adp.lib.stats.switchs.BdStatisticsUploadConfig;
import com.baidu.adp.lib.stats.switchs.BdStatisticsWriteConfig;
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
        bdStatisticsWriteConfigItem3.type = "error";
        bdStatisticsWriteConfigItem3.isWrite = true;
        this.writeConfig.item.put(bdStatisticsWriteConfigItem3.type, bdStatisticsWriteConfigItem3);
        BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem3 = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
        bdStatisticsUploadConfigItem3.type = "error";
        this.uploadConfig.item.put(bdStatisticsUploadConfigItem3.type, bdStatisticsUploadConfigItem3);
        BdStatisticsWriteConfig.BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem4 = new BdStatisticsWriteConfig.BdStatisticsWriteConfigItem();
        bdStatisticsWriteConfigItem4.type = "pfmonitor";
        bdStatisticsWriteConfigItem4.isWrite = true;
        this.writeConfig.item.put(bdStatisticsWriteConfigItem4.type, bdStatisticsWriteConfigItem4);
        BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem4 = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
        bdStatisticsUploadConfigItem4.type = "pfmonitor";
        bdStatisticsUploadConfigItem4.isUpload = true;
        this.uploadConfig.item.put(bdStatisticsUploadConfigItem4.type, bdStatisticsUploadConfigItem4);
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
                    a(optJSONObject.optJSONArray("debug"), bdStatisticsWriteConfigItem, bdStatisticsUploadConfigItem);
                    BdStatisticsWriteConfig.BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem2 = new BdStatisticsWriteConfig.BdStatisticsWriteConfigItem();
                    bdStatisticsWriteConfigItem2.type = "stat";
                    this.writeConfig.item.put(bdStatisticsWriteConfigItem2.type, bdStatisticsWriteConfigItem2);
                    BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem2 = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
                    bdStatisticsUploadConfigItem2.type = "stat";
                    this.uploadConfig.item.put(bdStatisticsUploadConfigItem2.type, bdStatisticsUploadConfigItem2);
                    a(optJSONObject.optJSONArray("stat"), bdStatisticsWriteConfigItem2, bdStatisticsUploadConfigItem2);
                    BdStatisticsWriteConfig.BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem3 = new BdStatisticsWriteConfig.BdStatisticsWriteConfigItem();
                    bdStatisticsWriteConfigItem3.type = "error";
                    this.writeConfig.item.put(bdStatisticsWriteConfigItem3.type, bdStatisticsWriteConfigItem3);
                    BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem3 = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
                    bdStatisticsUploadConfigItem3.type = "error";
                    this.uploadConfig.item.put(bdStatisticsUploadConfigItem3.type, bdStatisticsUploadConfigItem3);
                    a(optJSONObject.optJSONArray("error"), bdStatisticsWriteConfigItem3, bdStatisticsUploadConfigItem3);
                    BdStatisticsWriteConfig.BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem4 = new BdStatisticsWriteConfig.BdStatisticsWriteConfigItem();
                    bdStatisticsWriteConfigItem4.type = "pfmonitor";
                    this.writeConfig.item.put(bdStatisticsWriteConfigItem4.type, bdStatisticsWriteConfigItem4);
                    BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem4 = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
                    bdStatisticsUploadConfigItem4.type = "pfmonitor";
                    this.uploadConfig.item.put(bdStatisticsUploadConfigItem4.type, bdStatisticsUploadConfigItem4);
                    a(optJSONObject.optJSONArray("performance"), bdStatisticsWriteConfigItem4, bdStatisticsUploadConfigItem4);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void a(JSONArray jSONArray, BdStatisticsWriteConfig.BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem, BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem) {
        if (jSONArray != null) {
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            ArrayList<String> arrayList = new ArrayList<>();
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("common");
            bdStatisticsWriteConfigItem.isWrite = optJSONObject2.optInt("is_write", 0) != 0;
            bdStatisticsWriteConfigItem.particleNum = optJSONObject2.optInt("particleNum");
            bdStatisticsWriteConfigItem.isExac = optJSONObject2.optInt("is_exact", 0) != 0;
            bdStatisticsUploadConfigItem.isUpload = optJSONObject2.optInt("is_upload", 0) != 0;
            bdStatisticsUploadConfigItem.isWifi = optJSONObject2.optInt("is_only_wifi", 0) != 0;
            JSONArray optJSONArray = optJSONObject.optJSONArray("children");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
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
                }
                this.mChildTypes.put(bdStatisticsWriteConfigItem.type, arrayList);
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
