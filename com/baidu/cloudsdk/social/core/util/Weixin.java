package com.baidu.cloudsdk.social.core.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.common.util.Validator;
import com.tencent.mm.sdk.constants.Build;
import com.tencent.mm.sdk.constants.ConstantsAPI;
/* loaded from: classes.dex */
public class Weixin {
    private static final String[] a = {"_id", "key", "type", "value"};
    private static boolean e = false;
    private Context b;
    private String c;
    private int d = -1;

    /* loaded from: classes.dex */
    public interface IWXResponseHandler {
        public static final int ERR_AUTH_DENIED = -4;
        public static final int ERR_COMM = -1;
        public static final int ERR_OK = 0;
        public static final int ERR_SENT_FAILED = -3;
        public static final int ERR_UNSUPPORT = -5;
        public static final int ERR_USER_CANCEL = -2;

        void onResponse(int i, String str, String str2);
    }

    public Weixin(Context context, String str) {
        Validator.notNull(context, "context");
        Validator.notNullOrEmpty(str, "clientId");
        this.b = context;
        this.c = str;
    }

    private static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr == null && bArr2 == null) {
            return true;
        }
        if (bArr != null || bArr2 == null) {
            if ((bArr == null || bArr2 != null) && bArr.length == bArr2.length) {
                for (int i = 0; i < bArr.length; i++) {
                    if (bArr[i] != bArr2[i]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private static byte[] a(String str, String str2, int i) {
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        sb.append(i).append(str2).append("mMcShCsTr");
        return Utils.md5(sb.toString().substring(1, 9)).getBytes();
    }

    public static void addBaseRequestParams(Bundle bundle, String str, boolean z) {
        Validator.notNull(bundle, "bundle");
        bundle.putInt("_wxapi_command_type", 2);
        bundle.putString("_wxapi_basereq_transaction", str);
        bundle.putInt("_wxapi_sendmessagetowx_req_scene", z ? 1 : 0);
    }

    public static boolean handleIntent(Intent intent, IWXResponseHandler iWXResponseHandler) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return false;
        }
        String string = extras.getString(ConstantsAPI.Token.WX_TOKEN_KEY);
        String string2 = extras.getString(ConstantsAPI.CONTENT);
        String string3 = extras.getString(ConstantsAPI.APP_PACKAGE);
        int i = extras.getInt(ConstantsAPI.SDK_VERSION, 0);
        byte[] byteArray = extras.getByteArray(ConstantsAPI.CHECK_SUM);
        if (ConstantsAPI.Token.WX_TOKEN_VALUE_MSG.equals(string) && a(byteArray, a(string2, string3, i))) {
            switch (extras.getInt("_wxapi_command_type", 0)) {
                case 2:
                    int i2 = extras.getInt("_wxapi_baseresp_errcode");
                    String string4 = extras.getString("_wxapi_baseresp_errstr");
                    String string5 = extras.getString("_wxapi_baseresp_transaction");
                    if (iWXResponseHandler != null) {
                        iWXResponseHandler.onResponse(i2, string4, string5);
                        return true;
                    }
                    return false;
                default:
                    return false;
            }
        }
        return false;
    }

    public int getSdkVersion() {
        if (this.d != -1) {
            return this.d;
        }
        this.d = 0;
        Cursor query = this.b.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref"), a, "key = ?", new String[]{"_build_info_sdk_int_"}, null);
        if (query == null) {
            return this.d;
        }
        int columnIndex = query.getColumnIndex("type");
        int columnIndex2 = query.getColumnIndex("value");
        if (query.moveToFirst()) {
            int i = query.getInt(columnIndex);
            String string = query.getString(columnIndex2);
            if (i == 1) {
                this.d = Integer.valueOf(string).intValue();
            }
        }
        return this.d;
    }

    public boolean isAppInstalled() {
        try {
            for (Signature signature : this.b.getPackageManager().getPackageInfo(ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME, 64).signatures) {
                if ("aaa953dc012b1c3c46aafd140ec024d4".equals(Utils.md5(signature.toCharsString()))) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        }
    }

    public boolean isTimelineSupported() {
        return getSdkVersion() >= 553779201;
    }

    public synchronized void registerApp() {
        if (!e) {
            sendBroadcast(ConstantsAPI.ACTION_HANDLE_APP_REGISTER, "weixin://registerapp?appid=" + this.c, null);
            e = true;
        }
    }

    public void sendBroadcast(String str, String str2, Bundle bundle) {
        Validator.notNullOrEmpty(str, "action");
        Validator.notNullOrEmpty(str2, "uri");
        String packageName = this.b.getPackageName();
        Intent intent = new Intent(str);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra(ConstantsAPI.SDK_VERSION, Build.EMOJI_SUPPORTED_SDK_INT);
        intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
        intent.putExtra(ConstantsAPI.CONTENT, str2);
        intent.putExtra(ConstantsAPI.CHECK_SUM, a(str2, packageName, Build.EMOJI_SUPPORTED_SDK_INT));
        this.b.sendBroadcast(intent, ConstantsAPI.WXApp.WXAPP_BROADCAST_PERMISSION);
    }

    public boolean sendRequest(Bundle bundle) {
        String packageName = this.b.getPackageName();
        String str = "weixin://sendreq?appid=" + this.c;
        Intent intent = new Intent();
        intent.setClassName(ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME, ConstantsAPI.WXApp.WXAPP_MSG_ENTRY_CLASSNAME);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra(ConstantsAPI.SDK_VERSION, Build.EMOJI_SUPPORTED_SDK_INT);
        intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
        intent.putExtra(ConstantsAPI.CONTENT, str);
        intent.putExtra(ConstantsAPI.CHECK_SUM, a(str, packageName, Build.EMOJI_SUPPORTED_SDK_INT));
        intent.addFlags(402653184);
        try {
            this.b.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e2) {
            return false;
        }
    }

    public synchronized void unregisterApp() {
        if (e) {
            sendBroadcast(ConstantsAPI.ACTION_HANDLE_APP_UNREGISTER, "weixin://unregisterapp?appid=" + this.c, null);
        }
    }
}
