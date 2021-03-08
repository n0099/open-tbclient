package com.baidu.appsearchlib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.net.URLDecoder;
/* loaded from: classes14.dex */
public class NASLib extends Activity {
    private static NASCallBack callback;

    /* loaded from: classes14.dex */
    public interface NASCallBack {
        void callback(String str, String str2);
    }

    public static void onAppStart(Context context) {
        Logger.onClientBoot(context);
    }

    public static void onAppStop(Context context) {
        Logger.onClientExit(context);
    }

    public static void setLooperDisabled(boolean z) {
        Logger.looperDisabled = z;
    }

    public static void recordCustomAction(Context context, String str) {
        Logger.recordCustomAction(context, str);
    }

    public static void setCallBack(NASCallBack nASCallBack) {
        callback = nASCallBack;
    }

    public String parseUri(Context context, Uri uri) {
        if (uri != null) {
            return parseRequest(uri.toString(), false, context);
        }
        return null;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 2048);
        load_uri();
        onAppStart(getApplicationContext());
        finish();
    }

    private String parseRequest(String str, boolean z, Context context) {
        String str2;
        String str3;
        try {
        } catch (Exception e) {
            e = e;
            str2 = null;
        }
        if (str.contains(Info.kUrlSecStart)) {
            str2 = Encryption.desEncrypt(URLDecoder.decode(str.substring(str.indexOf(Info.kUrlSecStart) + Info.kUrlSecStart.length()), "utf-8")).trim();
            if (str2.contains(Info.kUrlLogStart)) {
                String[] split = str2.split(Info.kUrlLogStart);
                str2 = split[0];
                str3 = split[1];
            } else {
                str3 = null;
            }
            Logger.onCallUp();
            if (str3 != null) {
                Logger.recordServerAction(context, "%s", str3);
            }
            if (str2 != null) {
                try {
                    if (callback != null) {
                        callback.callback(str, str2);
                    } else if (z) {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return str2;
                }
            } else {
                str2 = null;
            }
            return str2;
        }
        return null;
    }

    private void load_uri() {
        Uri data = getIntent().getData();
        if (data != null) {
            parseRequest(data.toString(), true, getApplicationContext());
        }
    }
}
