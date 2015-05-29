package com.baidu.sapi2.share;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.common.security.Base64;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.L;
import java.util.zip.CRC32;
/* loaded from: classes.dex */
public class CnctReceiver extends BroadcastReceiver {
    private static final String a = "baidu.intent.action.account.B2C_SYNC";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction() != null) {
            try {
                if (a.equals(intent.getAction())) {
                    a(intent);
                }
            } catch (Throwable th) {
                L.e(th);
            }
        }
    }

    private void a(Intent intent) {
        String stringExtra = intent.getStringExtra("SYNC");
        String stringExtra2 = intent.getStringExtra("SN");
        String stringExtra3 = intent.getStringExtra("CHECKSUM");
        String stringExtra4 = intent.getStringExtra("TIME");
        String stringExtra5 = intent.getStringExtra("TYPE");
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra3) && !TextUtils.isEmpty(stringExtra4) && !TextUtils.isEmpty(stringExtra5)) {
            CRC32 crc32 = new CRC32();
            byte[] decode = Base64.decode(stringExtra.getBytes());
            crc32.update(decode, 0, decode.length);
            if (stringExtra3.equals(String.valueOf(crc32.getValue()))) {
                if (SapiAccountManager.getReceiveShareListener() != null) {
                    SapiAccountManager.getReceiveShareListener().onReceiveShare();
                }
                if (a() && SapiAccountManager.getInstance().getSapiConfiguration().b2cSyncEnabled()) {
                    SapiAccountManager.getInstance().getAccountService().verifyOtp(stringExtra2, stringExtra, stringExtra5);
                }
            }
        }
    }

    private boolean a() {
        try {
            SapiAccountManager.getInstance().getSapiConfiguration();
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }
}
