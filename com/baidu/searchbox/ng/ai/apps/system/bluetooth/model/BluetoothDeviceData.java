package com.baidu.searchbox.ng.ai.apps.system.bluetooth.model;

import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.searchbox.ng.ai.apps.system.bluetooth.utils.AiAppsBluetoothConstants;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BluetoothDeviceData {
    private static final boolean DEBUG = false;
    private static final String TAG = "BluetoothDevice";
    public BluetoothDevice device;
    public String deviceId;
    public String localName;
    public List<byte[]> manufacturerSpecificData;
    public String name = "";
    public int rssi;
    public Map<ParcelUuid, byte[]> serviceData;
    public List<ParcelUuid> serviceUuids;

    public boolean isRightDevice(UUID[] uuidArr) {
        boolean z;
        if (uuidArr != null && (r5 = uuidArr.length) != 0) {
            if (this.serviceUuids == null) {
                return false;
            }
            int size = this.serviceUuids.size();
            for (UUID uuid : uuidArr) {
                int i = 0;
                while (true) {
                    if (i >= size) {
                        z = false;
                        break;
                    }
                    ParcelUuid parcelUuid = this.serviceUuids.get(i);
                    if (uuid != null && parcelUuid != null && parcelUuid.getUuid() != null && parcelUuid.getUuid().equals(uuid)) {
                        z = true;
                        break;
                    }
                    i++;
                }
                if (!z) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public JSONObject toJson() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("name", this.name);
            jSONObject.putOpt("deviceId", this.deviceId);
            jSONObject.putOpt(AiAppsBluetoothConstants.DEVICE_RSSI, Integer.valueOf(this.rssi));
            JSONArray jSONArray = new JSONArray();
            if (this.manufacturerSpecificData != null) {
                int size = this.manufacturerSpecificData.size();
                int i = 0;
                byte[] bArr = new byte[0];
                while (i < size) {
                    byte[] bArr2 = this.manufacturerSpecificData.get(i);
                    byte[] bArr3 = new byte[bArr2.length + bArr.length];
                    System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
                    System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
                    i++;
                    bArr = bArr3;
                }
                try {
                    str = Base64.encodeToString(bArr, 2);
                } catch (AssertionError e) {
                    str = "";
                }
                if (!TextUtils.isEmpty(str)) {
                    jSONArray.put(str);
                }
            }
            jSONObject.putOpt(AiAppsBluetoothConstants.DEVICE_ADVERTISE_DATA, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            if (this.serviceUuids != null) {
                int size2 = this.serviceUuids.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ParcelUuid parcelUuid = this.serviceUuids.get(i2);
                    if (parcelUuid != null && !TextUtils.isEmpty(parcelUuid.toString())) {
                        jSONArray2.put(parcelUuid.toString());
                    }
                }
            }
            jSONObject.putOpt(AiAppsBluetoothConstants.DEVICE_ADVERTISE_SERVICE_UUIDS, jSONArray2);
            jSONObject.putOpt(AiAppsBluetoothConstants.DEVICE_LOCAL_NAME, this.localName);
            JSONObject jSONObject2 = new JSONObject();
            if (this.serviceData != null) {
                for (Map.Entry<ParcelUuid, byte[]> entry : this.serviceData.entrySet()) {
                    if ((entry.getValue() instanceof byte[]) && (entry.getKey() instanceof ParcelUuid)) {
                        byte[] value = entry.getValue();
                        ParcelUuid key = entry.getKey();
                        try {
                            String encodeToString = Base64.encodeToString(value, 2);
                            if (!TextUtils.isEmpty(encodeToString)) {
                                jSONObject2.putOpt(key.toString(), encodeToString);
                            }
                        } catch (AssertionError e2) {
                        }
                    }
                }
            }
            jSONObject.putOpt(AiAppsBluetoothConstants.DEVICE_SERVICE_DATA, jSONObject2);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return jSONObject;
    }

    public JSONObject toSimpleJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("name", this.name);
            jSONObject.putOpt("deviceId", this.deviceId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
