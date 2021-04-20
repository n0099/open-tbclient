package com.baidu.mobads.container.util.oaid;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.DeviceUtils;
/* loaded from: classes2.dex */
public class VivoOAID {
    public static void getVivoOaid(final Context context) {
        if (context == null) {
            return;
        }
        try {
            TaskScheduler.getInstance().submit(new BaseTask() { // from class: com.baidu.mobads.container.util.oaid.VivoOAID.1
                @Override // com.baidu.mobads.container.executor.BaseTask
                public Object doInBackground() {
                    String str;
                    try {
                        UniqueIdUtils.sendSDKTypeLog(context, "vivo-start", "");
                        Cursor query = context.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
                        if (query != null) {
                            str = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
                            query.close();
                        } else {
                            str = null;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            UniqueIdUtils.miitOAID = str;
                            UniqueIdUtils.sendSDKTypeLog(context, "vivo-valid", str);
                            UniqueIdUtils.update(604800000L, str);
                        } else {
                            UniqueIdUtils.sendSDKTypeLog(context, "vivo-empty", "");
                        }
                    } catch (Throwable unused) {
                    }
                    return null;
                }
            });
        } catch (Throwable th) {
            UniqueIdUtils.sendSDKTypeLog(context, "vivo-errror" + th.getMessage(), "");
        }
    }

    public static boolean isVivoBrand() {
        try {
            String phoneOSBrand = DeviceUtils.getInstance().getPhoneOSBrand();
            boolean equalsIgnoreCase = !TextUtils.isEmpty(phoneOSBrand) ? phoneOSBrand.equalsIgnoreCase(RomUtils.MANUFACTURER_VIVO) : false;
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
