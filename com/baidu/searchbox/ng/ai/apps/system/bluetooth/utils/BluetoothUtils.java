package com.baidu.searchbox.ng.ai.apps.system.bluetooth.utils;

import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.searchbox.ng.ai.apps.system.bluetooth.model.BluetoothDeviceData;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes2.dex */
public class BluetoothUtils {
    public static final ParcelUuid BASE_UUID = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    private static final int DATA_TYPE_FLAGS = 1;
    private static final int DATA_TYPE_LOCAL_NAME_COMPLETE = 9;
    private static final int DATA_TYPE_LOCAL_NAME_SHORT = 8;
    private static final int DATA_TYPE_MANUFACTURER_SPECIFIC_DATA = 255;
    private static final int DATA_TYPE_SERVICE_DATA_128_BIT = 33;
    private static final int DATA_TYPE_SERVICE_DATA_16_BIT = 22;
    private static final int DATA_TYPE_SERVICE_DATA_32_BIT = 32;
    private static final int DATA_TYPE_SERVICE_UUIDS_128_BIT_COMPLETE = 7;
    private static final int DATA_TYPE_SERVICE_UUIDS_128_BIT_PARTIAL = 6;
    private static final int DATA_TYPE_SERVICE_UUIDS_16_BIT_COMPLETE = 3;
    private static final int DATA_TYPE_SERVICE_UUIDS_16_BIT_PARTIAL = 2;
    private static final int DATA_TYPE_SERVICE_UUIDS_32_BIT_COMPLETE = 5;
    private static final int DATA_TYPE_SERVICE_UUIDS_32_BIT_PARTIAL = 4;
    private static final int DATA_TYPE_TX_POWER_LEVEL = 10;
    private static final String TRANS_UUID_PREFIX = "0000";
    private static final String TRANS_UUID_SUFFIX = "-0000-1000-8000-00805F9B34FB";
    private static final String UUID_SPLIT = "-";

    public static BluetoothDeviceData createDeviceData(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        BluetoothDeviceData bluetoothDeviceData = new BluetoothDeviceData();
        if (bluetoothDevice != null && bArr != null) {
            bluetoothDeviceData.device = bluetoothDevice;
            bluetoothDeviceData.rssi = i;
            bluetoothDeviceData.name = bluetoothDevice.getName();
            bluetoothDeviceData.deviceId = bluetoothDevice.getAddress();
            return parseFromBytes(bluetoothDeviceData, bArr);
        }
        return bluetoothDeviceData;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static BluetoothDeviceData parseFromBytes(BluetoothDeviceData bluetoothDeviceData, byte[] bArr) {
        int i;
        if (bArr != null && bluetoothDeviceData != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayMap arrayMap = new ArrayMap();
            int i2 = 0;
            String str = null;
            while (i2 < bArr.length) {
                try {
                    int i3 = i2 + 1;
                    int i4 = bArr[i2] & 255;
                    if (i4 != 0) {
                        int i5 = i4 - 1;
                        int i6 = i3 + 1;
                        int i7 = bArr[i3] & 255;
                        switch (i7) {
                            case 1:
                                int i8 = bArr[i6] & 255;
                                break;
                            case 2:
                            case 3:
                                parseServiceUuid(bArr, i6, i5, 2, arrayList);
                                break;
                            case 4:
                            case 5:
                                parseServiceUuid(bArr, i6, i5, 4, arrayList);
                                break;
                            case 6:
                            case 7:
                                parseServiceUuid(bArr, i6, i5, 16, arrayList);
                                break;
                            case 8:
                            case 9:
                                str = new String(extractBytes(bArr, i6, i5));
                                break;
                            case 10:
                                byte b = bArr[i6];
                                break;
                            case 22:
                            case 32:
                            case 33:
                                if (i7 == 32) {
                                    i = 4;
                                } else {
                                    i = i7 == 33 ? 16 : 2;
                                }
                                ParcelUuid parseUuidFrom = parseUuidFrom(extractBytes(bArr, i6, i));
                                if (parseUuidFrom == null) {
                                    break;
                                } else {
                                    arrayMap.put(parseUuidFrom, extractBytes(bArr, i6 + i, i5 - i));
                                    break;
                                }
                            case 255:
                                arrayList2.add(extractBytes(bArr, i6, i5));
                                break;
                        }
                        i2 = i6 + i5;
                    } else {
                        if (arrayList.isEmpty()) {
                            arrayList = null;
                        }
                        bluetoothDeviceData.manufacturerSpecificData = arrayList2;
                        bluetoothDeviceData.serviceUuids = arrayList;
                        bluetoothDeviceData.localName = str;
                        bluetoothDeviceData.serviceData = arrayMap;
                        return bluetoothDeviceData;
                    }
                } catch (Exception e) {
                    return null;
                }
            }
            if (arrayList.isEmpty()) {
            }
            bluetoothDeviceData.manufacturerSpecificData = arrayList2;
            bluetoothDeviceData.serviceUuids = arrayList;
            bluetoothDeviceData.localName = str;
            bluetoothDeviceData.serviceData = arrayMap;
            return bluetoothDeviceData;
        }
        return bluetoothDeviceData;
    }

    private static int parseServiceUuid(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        int i4 = i2;
        int i5 = i;
        while (i4 > 0) {
            ParcelUuid parseUuidFrom = parseUuidFrom(extractBytes(bArr, i5, i3));
            if (parseUuidFrom != null) {
                list.add(parseUuidFrom);
                i4 -= i3;
                i5 += i3;
            }
        }
        return i5;
    }

    private static byte[] extractBytes(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static ParcelUuid parseUuidFrom(byte[] bArr) {
        long j;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        if (length == 2 || length == 4 || length == 16) {
            if (length == 16) {
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
            }
            if (length == 2) {
                j = (bArr[0] & 255) + ((bArr[1] & 255) << 8);
            } else {
                j = (bArr[0] & 255) + ((bArr[1] & 255) << 8) + ((bArr[2] & 255) << 16) + ((bArr[3] & 255) << 24);
            }
            return new ParcelUuid(new UUID(BASE_UUID.getUuid().getMostSignificantBits() + (j << 32), BASE_UUID.getUuid().getLeastSignificantBits()));
        }
        return null;
    }

    public static String transUUid(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length();
        int length2 = str.split("-").length;
        switch (length) {
            case 4:
                if (length2 != 1) {
                    return null;
                }
                return TRANS_UUID_PREFIX + str + TRANS_UUID_SUFFIX;
            case 8:
                if (length2 != 1) {
                    return null;
                }
                return str + TRANS_UUID_SUFFIX;
            case 36:
                if (length2 != 5) {
                    return null;
                }
                return str;
            default:
                return null;
        }
    }

    public static byte[] intToBytes(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255)};
    }
}
