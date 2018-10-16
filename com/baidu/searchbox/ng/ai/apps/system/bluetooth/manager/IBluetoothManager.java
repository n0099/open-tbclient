package com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.system.bluetooth.BluetoothStatusCallback;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public interface IBluetoothManager {
    JSONObject closeBLEConnection(String str);

    JSONObject closeBluetoothAdapter();

    void createBLEConnection(String str, long j);

    JSONObject getBLEDeviceCharacteristics(String str, String str2);

    JSONObject getBLEDeviceServices(String str);

    JSONObject getBluetoothAdapterState();

    JSONObject getBluetoothDevices();

    JSONObject getConnectedBluetoothDevices(UUID[] uuidArr);

    JSONObject notifyBLECharacteristicValueChange(String str, String str2, String str3, boolean z);

    JSONObject openBluetoothAdapter(Context context, BluetoothStatusCallback bluetoothStatusCallback);

    JSONObject readBLECharacteristicValue(String str, String str2, String str3);

    JSONObject startBluetoothDevicesDiscovery(UUID[] uuidArr, boolean z, int i);

    JSONObject stopBluetoothDevicesDiscovery();

    void writeBLECharacteristicValue(String str, String str2, String str3, byte[] bArr);
}
