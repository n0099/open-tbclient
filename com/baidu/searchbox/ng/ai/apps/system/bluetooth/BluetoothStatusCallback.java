package com.baidu.searchbox.ng.ai.apps.system.bluetooth;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BluetoothStatusCallback {
    public static final String CREATE_BLE_CONNECTION = "createConnection";
    private static final boolean DEBUG = false;
    public static final String ON_CHARACTERISTIC_VALUE_CHANGE = "characteristicValueChange";
    public static final String ON_CONNECTION_STATE_CHANGE = "connectionStateChange";
    private static final String TAG = "BluetoothStatusCallback";
    public String characteristicValueChangeCallback;
    public String connectionStateChangeCallback;
    public String createBLEConnectionCallback;
    public String deviceFoundCallback;
    private UnitedSchemeEntity mEntity;
    private CallbackHandler mHandler;
    public String stateChangeCallback;
    public String writeBLECharacteristicValueCallback;

    public BluetoothStatusCallback(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
        this.mHandler = callbackHandler;
        this.mEntity = unitedSchemeEntity;
        this.stateChangeCallback = str;
    }

    public void dispatchCallback(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str)) {
            UnitedSchemeUtility.safeCallback(this.mHandler, this.mEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
        }
    }
}
