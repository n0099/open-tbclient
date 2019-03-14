package com.baidu.swan.apps.aj.b.b;

import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.swan.apps.b;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    public int aUa;
    public List<byte[]> aUb;
    public List<ParcelUuid> aUc;
    public String aUd;
    public Map<ParcelUuid, byte[]> aUe;
    public BluetoothDevice aUf;
    public String deviceId;
    public String name = "";

    public JSONObject toJson() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("name", this.name);
            jSONObject.putOpt("deviceId", this.deviceId);
            jSONObject.putOpt("RSSI", Integer.valueOf(this.aUa));
            JSONArray jSONArray = new JSONArray();
            if (this.aUb != null) {
                int size = this.aUb.size();
                int i = 0;
                byte[] bArr = new byte[0];
                while (i < size) {
                    byte[] bArr2 = this.aUb.get(i);
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
            jSONObject.putOpt("advertiseData", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            if (this.aUc != null) {
                int size2 = this.aUc.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ParcelUuid parcelUuid = this.aUc.get(i2);
                    if (parcelUuid != null && !TextUtils.isEmpty(parcelUuid.toString())) {
                        jSONArray2.put(parcelUuid.toString());
                    }
                }
            }
            jSONObject.putOpt("advertiseServiceUUIDs", jSONArray2);
            jSONObject.putOpt("localName", this.aUd);
            JSONObject jSONObject2 = new JSONObject();
            if (this.aUe != null) {
                for (Map.Entry<ParcelUuid, byte[]> entry : this.aUe.entrySet()) {
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
            jSONObject.putOpt("serviceData", jSONObject2);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return jSONObject;
    }
}
