package com.baidu.swan.apps.aj.c.b;

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
    public int brf;
    public List<byte[]> brg;
    public List<ParcelUuid> brh;
    public String bri;
    public Map<ParcelUuid, byte[]> brj;
    public BluetoothDevice brk;
    public String deviceId;
    public String name = "";

    public JSONObject toJson() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("name", this.name);
            jSONObject.putOpt("deviceId", this.deviceId);
            jSONObject.putOpt("RSSI", Integer.valueOf(this.brf));
            JSONArray jSONArray = new JSONArray();
            if (this.brg != null) {
                int size = this.brg.size();
                int i = 0;
                byte[] bArr = new byte[0];
                while (i < size) {
                    byte[] bArr2 = this.brg.get(i);
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
            if (this.brh != null) {
                int size2 = this.brh.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ParcelUuid parcelUuid = this.brh.get(i2);
                    if (parcelUuid != null && !TextUtils.isEmpty(parcelUuid.toString())) {
                        jSONArray2.put(parcelUuid.toString());
                    }
                }
            }
            jSONObject.putOpt("advertiseServiceUUIDs", jSONArray2);
            jSONObject.putOpt("localName", this.bri);
            JSONObject jSONObject2 = new JSONObject();
            if (this.brj != null) {
                for (Map.Entry<ParcelUuid, byte[]> entry : this.brj.entrySet()) {
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
