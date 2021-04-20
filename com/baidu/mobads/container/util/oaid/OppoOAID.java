package com.baidu.mobads.container.util.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.DeviceUtils;
import java.security.MessageDigest;
/* loaded from: classes2.dex */
public class OppoOAID {
    public static void getOppoOaid(final Context context) {
        UniqueIdUtils.sendSDKTypeLog(context, "oppo-start", "");
        try {
            final ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.baidu.mobads.container.util.oaid.OppoOAID.1
                /* JADX WARN: Can't wrap try/catch for region: R(6:(4:8|9|10|(9:12|(1:14)|15|16|17|18|19|20|(2:22|23)(2:25|26)))|18|19|20|(0)(0)|(2:(1:30)|(0))) */
                /* JADX WARN: Code restructure failed: missing block: B:27:0x008d, code lost:
                    r12 = move-exception;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:28:0x008e, code lost:
                    r12.printStackTrace();
                 */
                /* JADX WARN: Removed duplicated region for block: B:31:0x009d  */
                /* JADX WARN: Removed duplicated region for block: B:32:0x00ad  */
                @Override // android.content.ServiceConnection
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    Signature[] signatureArr;
                    String str;
                    Parcel obtain;
                    Parcel obtain2;
                    MessageDigest messageDigest;
                    UniqueIdUtils.sendSDKTypeLog(context, "oppo-connect", "");
                    iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
                    String packageName = context.getPackageName();
                    String str2 = null;
                    try {
                        signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        signatureArr = null;
                    }
                    try {
                        if (signatureArr != null && signatureArr.length > 0) {
                            byte[] byteArray = signatureArr[0].toByteArray();
                            try {
                                messageDigest = MessageDigest.getInstance("SHA1");
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            if (messageDigest != null) {
                                byte[] digest = messageDigest.digest(byteArray);
                                StringBuilder sb = new StringBuilder();
                                for (byte b2 : digest) {
                                    sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                                }
                                str = sb.toString();
                                obtain = Parcel.obtain();
                                obtain2 = Parcel.obtain();
                                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                                obtain.writeString(packageName);
                                obtain.writeString(str);
                                obtain.writeString("OUID");
                                iBinder.transact(1, obtain, obtain2, 0);
                                obtain2.readException();
                                str2 = obtain2.readString();
                                obtain.recycle();
                                obtain2.recycle();
                                if (TextUtils.isEmpty(str2)) {
                                    UniqueIdUtils.miitOAID = str2;
                                    UniqueIdUtils.sendSDKTypeLog(context, "oppo-valid", str2);
                                    UniqueIdUtils.update(604800000L, str2);
                                    return;
                                }
                                UniqueIdUtils.sendSDKTypeLog(context, "oppo-empty", "");
                                return;
                            }
                        }
                        obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                        obtain.writeString(packageName);
                        obtain.writeString(str);
                        obtain.writeString("OUID");
                        iBinder.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        str2 = obtain2.readString();
                        obtain.recycle();
                        obtain2.recycle();
                        if (TextUtils.isEmpty(str2)) {
                        }
                    } catch (Throwable th) {
                        obtain.recycle();
                        obtain2.recycle();
                        throw th;
                    }
                    str = null;
                    obtain = Parcel.obtain();
                    obtain2 = Parcel.obtain();
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }
            };
            TaskScheduler.getInstance().submit(new BaseTask() { // from class: com.baidu.mobads.container.util.oaid.OppoOAID.2
                @Override // com.baidu.mobads.container.executor.BaseTask
                public Object doInBackground() {
                    try {
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                        context.bindService(intent, serviceConnection, 1);
                        return null;
                    } catch (Throwable unused) {
                        return null;
                    }
                }
            });
        } catch (Throwable th) {
            UniqueIdUtils.sendSDKTypeLog(context, "oppo-error" + th.getMessage(), "");
        }
    }

    public static boolean isOppoBrand() {
        try {
            String phoneOSBrand = DeviceUtils.getInstance().getPhoneOSBrand();
            boolean equalsIgnoreCase = !TextUtils.isEmpty(phoneOSBrand) ? phoneOSBrand.equalsIgnoreCase(RomUtils.MANUFACTURER_OPPO) : false;
            try {
                if (Build.VERSION.SDK_INT < 28) {
                    return false;
                }
            } catch (Throwable unused) {
            }
            return equalsIgnoreCase;
        } catch (Throwable unused2) {
            return false;
        }
    }
}
