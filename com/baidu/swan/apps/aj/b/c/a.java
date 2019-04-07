package com.baidu.swan.apps.aj.b.c;

import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;
import android.util.ArrayMap;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes2.dex */
public class a {
    public static final ParcelUuid aUj = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");

    public static com.baidu.swan.apps.aj.b.b.a a(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        com.baidu.swan.apps.aj.b.b.a aVar = new com.baidu.swan.apps.aj.b.b.a();
        if (bluetoothDevice != null && bArr != null) {
            aVar.aUi = bluetoothDevice;
            aVar.aUd = i;
            aVar.name = bluetoothDevice.getName();
            aVar.deviceId = bluetoothDevice.getAddress();
            return a(aVar, bArr);
        }
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.baidu.swan.apps.aj.b.b.a a(com.baidu.swan.apps.aj.b.b.a aVar, byte[] bArr) {
        int i;
        if (bArr != null && aVar != null) {
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
                                a(bArr, i6, i5, 2, arrayList);
                                break;
                            case 4:
                            case 5:
                                a(bArr, i6, i5, 4, arrayList);
                                break;
                            case 6:
                            case 7:
                                a(bArr, i6, i5, 16, arrayList);
                                break;
                            case 8:
                            case 9:
                                str = new String(j(bArr, i6, i5));
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
                                ParcelUuid I = I(j(bArr, i6, i));
                                if (I == null) {
                                    break;
                                } else {
                                    arrayMap.put(I, j(bArr, i6 + i, i5 - i));
                                    break;
                                }
                            case 255:
                                arrayList2.add(j(bArr, i6, i5));
                                break;
                        }
                        i2 = i6 + i5;
                    } else {
                        if (arrayList.isEmpty()) {
                            arrayList = null;
                        }
                        aVar.aUe = arrayList2;
                        aVar.aUf = arrayList;
                        aVar.aUg = str;
                        aVar.aUh = arrayMap;
                        return aVar;
                    }
                } catch (Exception e) {
                    return null;
                }
            }
            if (arrayList.isEmpty()) {
            }
            aVar.aUe = arrayList2;
            aVar.aUf = arrayList;
            aVar.aUg = str;
            aVar.aUh = arrayMap;
            return aVar;
        }
        return aVar;
    }

    private static int a(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        int i4 = i2;
        int i5 = i;
        while (i4 > 0) {
            ParcelUuid I = I(j(bArr, i5, i3));
            if (I != null) {
                list.add(I);
                i4 -= i3;
                i5 += i3;
            }
        }
        return i5;
    }

    private static byte[] j(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static ParcelUuid I(byte[] bArr) {
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
            return new ParcelUuid(new UUID(aUj.getUuid().getMostSignificantBits() + (j << 32), aUj.getUuid().getLeastSignificantBits()));
        }
        return null;
    }

    public static byte[] ec(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255)};
    }
}
