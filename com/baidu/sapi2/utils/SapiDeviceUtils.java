package com.baidu.sapi2.utils;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.ServiceManager;
import com.baidu.webkit.internal.ETAG;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.util.Collections;
/* loaded from: classes5.dex */
public class SapiDeviceUtils {

    /* loaded from: classes5.dex */
    public static class DeviceCrypto implements com.baidu.sapi2.c {
        public static String base64Encode(byte[] bArr) {
            int i;
            StringBuilder sb = new StringBuilder();
            int length = bArr.length * 8;
            byte b = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 6;
            int i5 = 0;
            do {
                if (i5 <= 0 || i4 <= 0) {
                    if (i5 == 0) {
                        b = (byte) ((bArr[i3] & 255) >> (8 - i4));
                        i5 = 2;
                        i4 = 4;
                    } else if (i4 == 0) {
                        b = (byte) (bArr[i3] & 63);
                        i4 = 6;
                        i5 = 0;
                    }
                } else {
                    i5 = 8 - i4;
                    b = (byte) (((byte) (((bArr[i3] & 255) << i4) | ((bArr[i3 + 1] & 255) >> i5))) & 63);
                    i4 = 6 - i5;
                }
                sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(b));
                i2 += 6;
                i3 = i2 / 8;
                i = length - i2;
            } while (i >= 6);
            if (i > 0) {
                sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((byte) ((bArr[bArr.length - 1] << (6 - i)) & 63)));
            }
            int i6 = length % 3;
            for (int i7 = 0; i7 < i6; i7++) {
                sb.append(ETAG.EQUAL);
            }
            return sb.toString();
        }
    }

    public static String b(Context context) {
        try {
            if (ServiceManager.getInstance().getIsAccountManager().getConfignation().isAgreeDangerousProtocol()) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                return deviceId == null ? "" : deviceId;
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    public static String c(Context context) {
        try {
        } catch (Exception e) {
            Log.e(e);
        }
        if (ServiceManager.getInstance().getIsAccountManager().getConfignation().isAgreeDangerousProtocol()) {
            if (Build.VERSION.SDK_INT >= 23) {
                for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        if (hardwareAddress == null) {
                            return "";
                        }
                        StringBuilder sb = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i = 0; i < length; i++) {
                            sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString().toLowerCase();
                    }
                }
                return Config.DEF_MAC_ID;
            }
            return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        }
        return Config.DEF_MAC_ID;
    }

    public static String b() {
        try {
            return URLEncoder.encode(TextUtils.isEmpty(Build.BRAND) ? "" : Build.BRAND, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [9=4, 12=4] */
    public static boolean a(android.content.Context r7) {
        /*
            r4 = 1
            r3 = 0
            if (r7 != 0) goto L6
            r0 = r3
        L5:
            return r0
        L6:
            r2 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L56
            java.lang.String r0 = "/system/etc/hosts"
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L56
            int r0 = r1.available()     // Catch: java.lang.Throwable -> L99
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L99
            r1.read(r0)     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Throwable -> L99
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L99
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L99
            if (r0 != 0) goto L41
            java.lang.String r0 = "passport.baidu.com"
            boolean r0 = r2.contains(r0)     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto L41
            r1.close()     // Catch: java.lang.Exception -> L31
        L2f:
            r0 = r4
            goto L5
        L31:
            r0 = move-exception
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r0 = r0.toString()
            r1[r3] = r0
            java.lang.String r0 = "SAPI"
            com.baidu.sapi2.utils.Log.e(r0, r1)
            goto L2f
        L41:
            r1.close()     // Catch: java.lang.Exception -> L46
        L44:
            r0 = r3
            goto L5
        L46:
            r0 = move-exception
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r0 = r0.toString()
            r1[r3] = r0
            java.lang.String r0 = "SAPI"
            com.baidu.sapi2.utils.Log.e(r0, r1)
            goto L44
        L56:
            r0 = move-exception
            r1 = r2
        L58:
            java.lang.String r2 = "SAPI"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L97
            r6 = 0
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L97
            r5[r6] = r0     // Catch: java.lang.Throwable -> L97
            com.baidu.sapi2.utils.Log.e(r2, r5)     // Catch: java.lang.Throwable -> L97
            if (r1 == 0) goto L6d
            r1.close()     // Catch: java.lang.Exception -> L6f
        L6d:
            r0 = r3
            goto L5
        L6f:
            r0 = move-exception
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r0 = r0.toString()
            r1[r3] = r0
            java.lang.String r0 = "SAPI"
            com.baidu.sapi2.utils.Log.e(r0, r1)
            goto L6d
        L7f:
            r0 = move-exception
            r1 = r2
        L81:
            if (r1 == 0) goto L86
            r1.close()     // Catch: java.lang.Exception -> L87
        L86:
            throw r0
        L87:
            r1 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r4]
            java.lang.String r1 = r1.toString()
            r2[r3] = r1
            java.lang.String r1 = "SAPI"
            com.baidu.sapi2.utils.Log.e(r1, r2)
            goto L86
        L97:
            r0 = move-exception
            goto L81
        L99:
            r0 = move-exception
            goto L58
        L9b:
            r0 = move-exception
            goto L81
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.utils.SapiDeviceUtils.a(android.content.Context):boolean");
    }

    public static String a() {
        try {
            return URLEncoder.encode(TextUtils.isEmpty(Build.MODEL) ? "" : Build.MODEL, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }
}
