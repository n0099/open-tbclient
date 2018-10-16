package com.baidu.searchbox.ng.ai.apps.system.bluetooth.action;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.system.bluetooth.BluetoothStatusCallback;
import com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager.AiAppsBluetoothManager;
import com.baidu.searchbox.ng.ai.apps.system.bluetooth.utils.AiAppsBluetoothConstants;
import com.baidu.searchbox.ng.ai.apps.system.bluetooth.utils.BluetoothUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BluetoothAction extends AiAppAction {
    public static final String ACTION_CLOSE = "/swan/bluetooth/close";
    public static final String ACTION_CLOSE_BLE_CONNECTION = "/swan/bluetooth/closeBLEConnection";
    public static final String ACTION_CREATE_BLE_CONNECTION = "/swan/bluetooth/createBLEConnection";
    public static final String ACTION_GET_BLE_DEVICES_CHARACTERISTICS = "/swan/bluetooth/getBLEDeviceCharacteristics";
    public static final String ACTION_GET_BLE_DEVICES_SERVICES = "/swan/bluetooth/getBLEDeviceServices";
    public static final String ACTION_GET_CONNECTED_DEVICES = "/swan/bluetooth/getConnectedDevices";
    public static final String ACTION_GET_DEVICES = "/swan/bluetooth/getDevices";
    public static final String ACTION_GET_STATE = "/swan/bluetooth/getState";
    public static final String ACTION_NOTIFY_BLE_CHARACTERISTICS = "/swan/bluetooth/notifyBLECharacteristicValueChange";
    public static final String ACTION_OPEN = "/swan/bluetooth/open";
    public static final String ACTION_READ_BLE_CHARACTERISTICS = "/swan/bluetooth/readBLECharacteristicValue";
    public static final String ACTION_START_DEVICES_DISCOVERY = "/swan/bluetooth/startDevicesDiscovery";
    public static final String ACTION_STOP_DEVICES_DISCOVERY = "/swan/bluetooth/stopDevicesDiscovery";
    public static final String ACTION_WRITE_BLE_CHARACTERISTICS = "/swan/bluetooth/writeBLECharacteristicValue";
    private static final boolean DEBUG = false;
    private static final String MODULE_NAME = "/swan/bluetooth";
    private static final String MODULE_PATH = "/swan/bluetooth/";
    private static final String MODULE_TAG = "bluetooth";
    private static final String TAG = "BluetoothAction";

    public BluetoothAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, MODULE_NAME);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handleSubAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, AiApp aiApp) {
        if (context == null) {
            AiAppsLog.e(MODULE_TAG, "context is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none context");
            return false;
        }
        return dispatchSubAction(str, context, unitedSchemeEntity, callbackHandler, UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
    }

    private boolean dispatchSubAction(String str, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1011994423:
                if (str.equals(ACTION_GET_BLE_DEVICES_SERVICES)) {
                    c = '\t';
                    break;
                }
                break;
            case -752957048:
                if (str.equals(ACTION_CLOSE)) {
                    c = 1;
                    break;
                }
                break;
            case -637840531:
                if (str.equals(ACTION_GET_BLE_DEVICES_CHARACTERISTICS)) {
                    c = '\n';
                    break;
                }
                break;
            case -408294006:
                if (str.equals(ACTION_WRITE_BLE_CHARACTERISTICS)) {
                    c = '\f';
                    break;
                }
                break;
            case -8240655:
                if (str.equals(ACTION_CLOSE_BLE_CONNECTION)) {
                    c = '\b';
                    break;
                }
                break;
            case 12972389:
                if (str.equals(ACTION_START_DEVICES_DISCOVERY)) {
                    c = 3;
                    break;
                }
                break;
            case 658113828:
                if (str.equals(ACTION_NOTIFY_BLE_CHARACTERISTICS)) {
                    c = '\r';
                    break;
                }
                break;
            case 859674253:
                if (str.equals(ACTION_CREATE_BLE_CONNECTION)) {
                    c = 7;
                    break;
                }
                break;
            case 1206831841:
                if (str.equals(ACTION_READ_BLE_CHARACTERISTICS)) {
                    c = 11;
                    break;
                }
                break;
            case 1361545402:
                if (str.equals(ACTION_OPEN)) {
                    c = 0;
                    break;
                }
                break;
            case 1411820517:
                if (str.equals(ACTION_STOP_DEVICES_DISCOVERY)) {
                    c = 4;
                    break;
                }
                break;
            case 1449155738:
                if (str.equals(ACTION_GET_CONNECTED_DEVICES)) {
                    c = 6;
                    break;
                }
                break;
            case 1893840663:
                if (str.equals(ACTION_GET_DEVICES)) {
                    c = 5;
                    break;
                }
                break;
            case 2143622475:
                if (str.equals(ACTION_GET_STATE)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return openAdapter(context, unitedSchemeEntity, callbackHandler, jSONObject);
            case 1:
                return closeAdapter(unitedSchemeEntity, callbackHandler);
            case 2:
                return getBluetoothAdapterState(unitedSchemeEntity, callbackHandler);
            case 3:
                return startDiscovery(unitedSchemeEntity, callbackHandler, jSONObject);
            case 4:
                return stopDiscovery(unitedSchemeEntity, callbackHandler);
            case 5:
                return getBluetoothDevices(unitedSchemeEntity, callbackHandler);
            case 6:
                return getConnectedBluetoothDevices(unitedSchemeEntity, callbackHandler, jSONObject);
            case 7:
                return createConnection(unitedSchemeEntity, callbackHandler, jSONObject);
            case '\b':
                return closeConnection(unitedSchemeEntity, callbackHandler, jSONObject);
            case '\t':
                return getDeviceServices(unitedSchemeEntity, callbackHandler, jSONObject);
            case '\n':
                return getCharacteristicValue(unitedSchemeEntity, callbackHandler, jSONObject);
            case 11:
                return readCharacteristicValue(unitedSchemeEntity, callbackHandler, jSONObject);
            case '\f':
                return writeCharacteristicValue(unitedSchemeEntity, callbackHandler, jSONObject);
            case '\r':
                return notifyCharacteristicValueChange(unitedSchemeEntity, callbackHandler, jSONObject);
            default:
                return false;
        }
    }

    private boolean openAdapter(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (jSONObject == null) {
            AiAppsLog.e(MODULE_TAG, "none params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            AiAppsLog.e(MODULE_TAG, "wrong cb");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        AiAppsLog.i(MODULE_TAG, "open adapter");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(AiAppsBluetoothManager.getInstance().openBluetoothAdapter(context, new BluetoothStatusCallback(callbackHandler, unitedSchemeEntity, optString)), 0));
        return true;
    }

    private boolean closeAdapter(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        AiAppsLog.i(MODULE_TAG, "close adapter");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(AiAppsBluetoothManager.getInstance().closeBluetoothAdapter(), 0));
        return true;
    }

    private boolean getBluetoothAdapterState(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        AiAppsLog.i(MODULE_TAG, "getBluetoothAdapterState");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(AiAppsBluetoothManager.getInstance().getBluetoothAdapterState(), 0));
        return true;
    }

    private boolean startDiscovery(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (jSONObject == null) {
            AiAppsLog.e(MODULE_TAG, "none params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            AiAppsLog.e(MODULE_TAG, "wrong cb");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        AiAppsLog.i(MODULE_TAG, "start discover");
        AiAppsBluetoothManager.getInstance().setDeviceFoundCallback(optString);
        JSONArray optJSONArray = jSONObject.optJSONArray(AiAppsBluetoothConstants.KEY_SERVICES);
        UUID[] uuidArr = null;
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                String transUUid = BluetoothUtils.transUUid(optJSONArray.optString(i));
                if (!TextUtils.isEmpty(transUUid)) {
                    arrayList.add(UUID.fromString(transUUid));
                }
            }
            int size = arrayList.size();
            if (size > 0) {
                uuidArr = new UUID[size];
                arrayList.toArray(uuidArr);
            }
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(AiAppsBluetoothManager.getInstance().startBluetoothDevicesDiscovery(uuidArr, jSONObject.optBoolean(AiAppsBluetoothConstants.KEY_ALLOW_DUPLICATES, false), jSONObject.optInt(AiAppsBluetoothConstants.KEY_INTERVAL, 0)), 0));
        return true;
    }

    private boolean stopDiscovery(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        AiAppsLog.i(MODULE_TAG, "stop discover");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(AiAppsBluetoothManager.getInstance().stopBluetoothDevicesDiscovery(), 0));
        return true;
    }

    private boolean getBluetoothDevices(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        AiAppsLog.i(MODULE_TAG, "get bluetooth devices");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(AiAppsBluetoothManager.getInstance().getBluetoothDevices(), 0));
        return true;
    }

    private boolean getConnectedBluetoothDevices(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (jSONObject == null) {
            AiAppsLog.e(MODULE_TAG, "none params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        AiAppsLog.i(MODULE_TAG, "get connected bluetooth devices");
        JSONArray optJSONArray = jSONObject.optJSONArray(AiAppsBluetoothConstants.KEY_SERVICES);
        UUID[] uuidArr = null;
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                String transUUid = BluetoothUtils.transUUid(optJSONArray.optString(i));
                if (!TextUtils.isEmpty(transUUid)) {
                    arrayList.add(UUID.fromString(transUUid));
                }
            }
            int size = arrayList.size();
            if (size > 0) {
                uuidArr = new UUID[size];
                arrayList.toArray(uuidArr);
            }
        }
        if (uuidArr == null || uuidArr.length == 0) {
            AiAppsLog.e(MODULE_TAG, "wrong uuid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(AiAppsBluetoothManager.getInstance().getConnectedBluetoothDevices(uuidArr), 0));
        return true;
    }

    private boolean createConnection(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (jSONObject == null) {
            AiAppsLog.e(MODULE_TAG, "none params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("cb");
        if (optJSONObject == null) {
            AiAppsLog.e(MODULE_TAG, "none cb");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = optJSONObject.optString(BluetoothStatusCallback.ON_CONNECTION_STATE_CHANGE);
        String optString2 = optJSONObject.optString(BluetoothStatusCallback.CREATE_BLE_CONNECTION);
        String optString3 = optJSONObject.optString(BluetoothStatusCallback.ON_CHARACTERISTIC_VALUE_CHANGE);
        String optString4 = jSONObject.optString("deviceId");
        long optLong = jSONObject.optLong(AiAppsBluetoothConstants.KEY_TIME_OUT, 0L);
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString4) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
            AiAppsLog.e(MODULE_TAG, "illegal parameter");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        AiAppsLog.i(MODULE_TAG, "create connection");
        AiAppsBluetoothManager.getInstance().setConnectionStateChangeCallback(optString);
        AiAppsBluetoothManager.getInstance().setCreateConnectionCallback(optString2);
        AiAppsBluetoothManager.getInstance().setCharacteristicChangeCallback(optString3);
        AiAppsBluetoothManager.getInstance().createBLEConnection(optString4, optLong);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private boolean closeConnection(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (jSONObject == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = jSONObject.optString("deviceId");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        AiAppsLog.i(MODULE_TAG, "close connection");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(AiAppsBluetoothManager.getInstance().closeBLEConnection(optString), 0));
        return true;
    }

    private boolean getDeviceServices(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (jSONObject == null) {
            AiAppsLog.e(MODULE_TAG, "none params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = jSONObject.optString("deviceId");
        if (TextUtils.isEmpty(optString)) {
            AiAppsLog.e(MODULE_TAG, "illegal parameter");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        AiAppsLog.i(MODULE_TAG, "get device services");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(AiAppsBluetoothManager.getInstance().getBLEDeviceServices(optString), 0));
        return true;
    }

    private boolean getCharacteristicValue(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (jSONObject == null) {
            AiAppsLog.e(MODULE_TAG, "none params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = jSONObject.optString("deviceId");
        String transUUid = BluetoothUtils.transUUid(jSONObject.optString(AiAppsBluetoothConstants.KEY_SERVICE_ID));
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(transUUid)) {
            AiAppsLog.e(MODULE_TAG, "illegal params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        AiAppsLog.i(MODULE_TAG, "get characteristic value");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(AiAppsBluetoothManager.getInstance().getBLEDeviceCharacteristics(optString, transUUid), 0));
        return true;
    }

    private boolean readCharacteristicValue(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (jSONObject == null) {
            AiAppsLog.e(MODULE_TAG, "none params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = jSONObject.optString("deviceId");
        String transUUid = BluetoothUtils.transUUid(jSONObject.optString(AiAppsBluetoothConstants.KEY_SERVICE_ID));
        String transUUid2 = BluetoothUtils.transUUid(jSONObject.optString(AiAppsBluetoothConstants.KEY_CHARACTERISTIC_ID));
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(transUUid) || TextUtils.isEmpty(transUUid2)) {
            AiAppsLog.e(MODULE_TAG, "illegal params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        AiAppsLog.i(MODULE_TAG, "read characteristic value");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(AiAppsBluetoothManager.getInstance().readBLECharacteristicValue(optString, transUUid, transUUid2), 0));
        return true;
    }

    private boolean writeCharacteristicValue(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (jSONObject == null) {
            AiAppsLog.e(MODULE_TAG, "none params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = jSONObject.optString("cb");
        String optString2 = jSONObject.optString("deviceId");
        String transUUid = BluetoothUtils.transUUid(jSONObject.optString(AiAppsBluetoothConstants.KEY_SERVICE_ID));
        String transUUid2 = BluetoothUtils.transUUid(jSONObject.optString(AiAppsBluetoothConstants.KEY_CHARACTERISTIC_ID));
        try {
            byte[] decode = Base64.decode(jSONObject.optString("value"), 10);
            if (TextUtils.isEmpty(optString2) || TextUtils.isEmpty(transUUid) || TextUtils.isEmpty(transUUid2) || TextUtils.isEmpty(optString) || decode == null || decode.length == 0) {
                AiAppsLog.e(MODULE_TAG, "illegal params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            AiAppsBluetoothManager.getInstance().setWriteBLECharacteristicValue(optString);
            AiAppsLog.i(MODULE_TAG, "write characteristic value");
            AiAppsBluetoothManager.getInstance().writeBLECharacteristicValue(optString2, transUUid, transUUid2, decode);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        } catch (IllegalArgumentException e) {
            AiAppsLog.e(MODULE_TAG, "error params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
    }

    private boolean notifyCharacteristicValueChange(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (jSONObject == null) {
            AiAppsLog.e(MODULE_TAG, "none params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = jSONObject.optString("deviceId");
        String transUUid = BluetoothUtils.transUUid(jSONObject.optString(AiAppsBluetoothConstants.KEY_SERVICE_ID));
        String transUUid2 = BluetoothUtils.transUUid(jSONObject.optString(AiAppsBluetoothConstants.KEY_CHARACTERISTIC_ID));
        boolean optBoolean = jSONObject.optBoolean("state");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(transUUid) || TextUtils.isEmpty(transUUid2)) {
            AiAppsLog.e(MODULE_TAG, "illegal params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        AiAppsLog.i(MODULE_TAG, "notify characteristic value change");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(AiAppsBluetoothManager.getInstance().notifyBLECharacteristicValueChange(optString, transUUid, transUUid2, optBoolean), 0));
        return true;
    }
}
