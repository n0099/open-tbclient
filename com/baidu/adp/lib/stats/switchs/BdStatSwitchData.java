package com.baidu.adp.lib.stats.switchs;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.stats.base.BdUploadStatMsgData;
import com.baidu.adp.lib.stats.switchs.BdStatisticsUploadConfig;
import com.baidu.adp.lib.stats.switchs.BdStatisticsWriteConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BdStatSwitchData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, ArrayList<String>> mChildTypes;
    public final HashMap<String, BdUploadStatMsgData> tmpSwitchConfDataHashMap;
    public final BdStatisticsUploadConfig uploadConfig;
    public final BdStatisticsWriteConfig writeConfig;

    public BdStatSwitchData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.writeConfig = new BdStatisticsWriteConfig();
        this.uploadConfig = new BdStatisticsUploadConfig();
        this.tmpSwitchConfDataHashMap = new HashMap<>();
        this.mChildTypes = new HashMap<>();
        BdStatisticsWriteConfig.BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem = new BdStatisticsWriteConfig.BdStatisticsWriteConfigItem();
        bdStatisticsWriteConfigItem.type = "dbg";
        bdStatisticsWriteConfigItem.isWrite = true;
        this.writeConfig.item.put("dbg", bdStatisticsWriteConfigItem);
        BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
        bdStatisticsUploadConfigItem.type = "dbg";
        this.uploadConfig.item.put("dbg", bdStatisticsUploadConfigItem);
        BdStatisticsWriteConfig.BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem2 = new BdStatisticsWriteConfig.BdStatisticsWriteConfigItem();
        bdStatisticsWriteConfigItem2.type = "stat";
        bdStatisticsWriteConfigItem2.isWrite = true;
        bdStatisticsWriteConfigItem2.isExac = true;
        this.writeConfig.item.put("stat", bdStatisticsWriteConfigItem2);
        BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem2 = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
        bdStatisticsUploadConfigItem2.type = "stat";
        bdStatisticsUploadConfigItem2.isUpload = true;
        bdStatisticsUploadConfigItem2.isWifi = false;
        this.uploadConfig.item.put("stat", bdStatisticsUploadConfigItem2);
        BdStatisticsWriteConfig.BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem3 = new BdStatisticsWriteConfig.BdStatisticsWriteConfigItem();
        bdStatisticsWriteConfigItem3.type = "error";
        bdStatisticsWriteConfigItem3.isWrite = true;
        this.writeConfig.item.put("error", bdStatisticsWriteConfigItem3);
        BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem3 = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
        bdStatisticsUploadConfigItem3.type = "error";
        bdStatisticsUploadConfigItem3.isUpload = true;
        this.uploadConfig.item.put("error", bdStatisticsUploadConfigItem3);
        BdStatisticsWriteConfig.BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem4 = new BdStatisticsWriteConfig.BdStatisticsWriteConfigItem();
        bdStatisticsWriteConfigItem4.type = "pfmonitor";
        bdStatisticsWriteConfigItem4.isWrite = true;
        this.writeConfig.item.put("pfmonitor", bdStatisticsWriteConfigItem4);
        BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem4 = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
        bdStatisticsUploadConfigItem4.type = "pfmonitor";
        bdStatisticsUploadConfigItem4.isUpload = true;
        this.uploadConfig.item.put("pfmonitor", bdStatisticsUploadConfigItem4);
        BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem5 = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
        bdStatisticsUploadConfigItem5.type = "alert";
        bdStatisticsUploadConfigItem5.isUpload = true;
        bdStatisticsUploadConfigItem5.isWifi = false;
        this.uploadConfig.item.put("alert", bdStatisticsUploadConfigItem5);
    }

    private void parserCommonData(JSONArray jSONArray, BdStatisticsWriteConfig.BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem, BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, this, jSONArray, bdStatisticsWriteConfigItem, bdStatisticsUploadConfigItem) == null) || jSONArray == null) {
            return;
        }
        JSONObject optJSONObject = jSONArray.optJSONObject(0);
        ArrayList<String> arrayList = new ArrayList<>();
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("common");
        if (bdStatisticsWriteConfigItem != null) {
            bdStatisticsWriteConfigItem.isWrite = optJSONObject2.optInt(MemberPayActivityConfig.IS_WRITE, 0) != 0;
            bdStatisticsWriteConfigItem.particleNum = optJSONObject2.optInt("particleNum");
            bdStatisticsWriteConfigItem.isExac = optJSONObject2.optInt("is_exact", 0) != 0;
        }
        bdStatisticsUploadConfigItem.isUpload = optJSONObject2.optInt("is_upload", 0) != 0;
        bdStatisticsUploadConfigItem.isWifi = optJSONObject2.optInt("is_only_wifi", 0) != 0;
        JSONArray optJSONArray = optJSONObject.optJSONArray(CriusAttrConstants.CHILDREN);
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
            if (bdStatisticsWriteConfigItem != null) {
                BdStatisticsWriteConfig.BdStatisticsWriteChildItem bdStatisticsWriteChildItem = new BdStatisticsWriteConfig.BdStatisticsWriteChildItem();
                bdStatisticsWriteChildItem.subType = optJSONObject3.optString("type");
                bdStatisticsWriteChildItem.isWrite = optJSONObject3.optInt(MemberPayActivityConfig.IS_WRITE, 0) != 0;
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

    public int geUploadCycle(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) ? this.uploadConfig.geUploadCycle(str, i) : invokeLI.intValue;
    }

    public ArrayList<String> getChiledTypes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.mChildTypes.get(str) : (ArrayList) invokeL.objValue;
    }

    public int getMaxAlertCount(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i)) == null) ? this.uploadConfig.getMaxAlertCount(str, i) : invokeLI.intValue;
    }

    public BdUploadStatMsgData getTmpSwitchConfData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.tmpSwitchConfDataHashMap.get(str) : (BdUploadStatMsgData) invokeL.objValue;
    }

    public boolean isExactWriteFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.writeConfig.isExactWriteFile(str) : invokeL.booleanValue;
    }

    public boolean isUpload(String str, String str2) {
        InterceptResult invokeLL;
        BdUploadStatMsgData bdUploadStatMsgData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            String str3 = TextUtils.isEmpty(str2) ? str : str2;
            if (!TextUtils.isEmpty(str3) && (bdUploadStatMsgData = this.tmpSwitchConfDataHashMap.get(str3)) != null) {
                if (System.currentTimeMillis() < bdUploadStatMsgData.deadLineTime) {
                    return true;
                }
                this.tmpSwitchConfDataHashMap.remove(str3);
            }
            return this.uploadConfig.isUpload(str, str2);
        }
        return invokeLL.booleanValue;
    }

    public boolean isWrite(String str, String str2) {
        InterceptResult invokeLL;
        BdUploadStatMsgData bdUploadStatMsgData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            String str3 = TextUtils.isEmpty(str2) ? str : str2;
            if (!TextUtils.isEmpty(str3) && (bdUploadStatMsgData = this.tmpSwitchConfDataHashMap.get(str3)) != null) {
                if (System.currentTimeMillis() < bdUploadStatMsgData.deadLineTime) {
                    return true;
                }
                this.tmpSwitchConfDataHashMap.remove(str3);
            }
            return this.writeConfig.isWrite(str, str2);
        }
        return invokeLL.booleanValue;
    }

    public boolean onlyWifiUpload(String str, String str2) {
        InterceptResult invokeLL;
        BdUploadStatMsgData bdUploadStatMsgData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            String str3 = TextUtils.isEmpty(str2) ? str : str2;
            if (!TextUtils.isEmpty(str3) && (bdUploadStatMsgData = this.tmpSwitchConfDataHashMap.get(str3)) != null) {
                if (System.currentTimeMillis() < bdUploadStatMsgData.deadLineTime) {
                    return bdUploadStatMsgData.isWifi;
                }
                this.tmpSwitchConfDataHashMap.remove(str3);
            }
            return this.uploadConfig.onlyWifiUpload(str, str2);
        }
        return invokeLL.booleanValue;
    }

    public void parserJson(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || str == null) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
            if (optJSONObject != null) {
                BdStatisticsWriteConfig.BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem = new BdStatisticsWriteConfig.BdStatisticsWriteConfigItem();
                bdStatisticsWriteConfigItem.type = "dbg";
                this.writeConfig.item.put("dbg", bdStatisticsWriteConfigItem);
                BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
                bdStatisticsUploadConfigItem.type = "dbg";
                this.uploadConfig.item.put("dbg", bdStatisticsUploadConfigItem);
                parserCommonData(optJSONObject.optJSONArray("debug"), bdStatisticsWriteConfigItem, bdStatisticsUploadConfigItem);
                BdStatisticsWriteConfig.BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem2 = new BdStatisticsWriteConfig.BdStatisticsWriteConfigItem();
                bdStatisticsWriteConfigItem2.type = "stat";
                this.writeConfig.item.put("stat", bdStatisticsWriteConfigItem2);
                BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem2 = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
                bdStatisticsUploadConfigItem2.type = "stat";
                this.uploadConfig.item.put("stat", bdStatisticsUploadConfigItem2);
                parserCommonData(optJSONObject.optJSONArray("stat"), bdStatisticsWriteConfigItem2, bdStatisticsUploadConfigItem2);
                BdStatisticsWriteConfig.BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem3 = new BdStatisticsWriteConfig.BdStatisticsWriteConfigItem();
                bdStatisticsWriteConfigItem3.type = "error";
                this.writeConfig.item.put("error", bdStatisticsWriteConfigItem3);
                BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem3 = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
                bdStatisticsUploadConfigItem3.type = "error";
                this.uploadConfig.item.put("error", bdStatisticsUploadConfigItem3);
                parserCommonData(optJSONObject.optJSONArray("error"), bdStatisticsWriteConfigItem3, bdStatisticsUploadConfigItem3);
                BdStatisticsWriteConfig.BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem4 = new BdStatisticsWriteConfig.BdStatisticsWriteConfigItem();
                bdStatisticsWriteConfigItem4.type = "pfmonitor";
                this.writeConfig.item.put("pfmonitor", bdStatisticsWriteConfigItem4);
                BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem4 = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
                bdStatisticsUploadConfigItem4.type = "pfmonitor";
                this.uploadConfig.item.put("pfmonitor", bdStatisticsUploadConfigItem4);
                parserCommonData(optJSONObject.optJSONArray("performance"), bdStatisticsWriteConfigItem4, bdStatisticsUploadConfigItem4);
                BdStatisticsUploadConfig.BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem5 = new BdStatisticsUploadConfig.BdStatisticsUploadConfigItem();
                bdStatisticsUploadConfigItem5.type = "alert";
                this.uploadConfig.item.put("alert", bdStatisticsUploadConfigItem5);
                parserCommonData(optJSONObject.optJSONArray("alert"), null, bdStatisticsUploadConfigItem5);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void putTmpSwitchConfData(String str, BdUploadStatMsgData bdUploadStatMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, bdUploadStatMsgData) == null) {
            this.tmpSwitchConfDataHashMap.put(str, bdUploadStatMsgData);
        }
    }

    public void rmTmpSwitchConfData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.tmpSwitchConfDataHashMap.remove(str);
        }
    }

    public boolean smallFlowUpload(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            BdUploadStatMsgData bdUploadStatMsgData = this.tmpSwitchConfDataHashMap.get(str2);
            if (bdUploadStatMsgData != null) {
                if (System.currentTimeMillis() < bdUploadStatMsgData.deadLineTime) {
                    return true;
                }
                this.tmpSwitchConfDataHashMap.remove(str2);
            }
            return this.uploadConfig.smallFlowUpload(str, str2);
        }
        return invokeLL.booleanValue;
    }
}
