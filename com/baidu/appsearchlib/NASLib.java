package com.baidu.appsearchlib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class NASLib extends Activity {
    public static NASCallBack callback;

    /* loaded from: classes.dex */
    public interface NASCallBack {
        void callback(String str, String str2);
    }

    private void load_uri() {
        Uri data = getIntent().getData();
        if (data != null) {
            parseRequest(data.toString(), true, getApplicationContext());
        }
    }

    public static void onAppStart(Context context) {
        Logger.onClientBoot(context);
    }

    public static void onAppStop(Context context) {
        Logger.onClientExit(context);
    }

    private String parseRequest(String str, boolean z, Context context) {
        String str2;
        String str3 = null;
        try {
            if (str.contains(Info.kUrlSecStart)) {
                String trim = Encryption.desEncrypt(URLDecoder.decode(str.substring(str.indexOf(Info.kUrlSecStart) + 7), "utf-8")).trim();
                if (trim.contains(Info.kUrlLogStart)) {
                    String[] split = trim.split(Info.kUrlLogStart);
                    trim = split[0];
                    str2 = split[1];
                } else {
                    str2 = null;
                }
                Logger.onCallUp();
                if (str2 != null) {
                    Logger.recordServerAction(context, "%s", str2);
                }
                if (trim != null) {
                    try {
                        if (callback != null) {
                            callback.callback(str, trim);
                        } else if (z) {
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(trim)));
                        }
                        return trim;
                    } catch (Exception e2) {
                        e = e2;
                        str3 = trim;
                        e.printStackTrace();
                        return str3;
                    }
                }
                return null;
            }
            return null;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static void recordCustomAction(Context context, String str) {
        Logger.recordCustomAction(context, str);
    }

    public static void setCallBack(NASCallBack nASCallBack) {
        callback = nASCallBack;
    }

    public static void setLooperDisabled(boolean z) {
        Logger.looperDisabled = z;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 2048);
        load_uri();
        onAppStart(getApplicationContext());
        finish();
    }

    public String parseUri(Context context, Uri uri) {
        if (uri != null) {
            return parseRequest(uri.toString(), false, context);
        }
        return null;
    }
}
