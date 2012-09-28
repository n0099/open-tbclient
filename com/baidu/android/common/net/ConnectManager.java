package com.baidu.android.common.net;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
/* loaded from: classes.dex */
public class ConnectManager {
    private static final boolean DEBUG = false;
    private String mApn;
    private String mPort;
    private String mProxy;
    private boolean mUseWap;
    private static final String TAG = ConnectManager.class.getSimpleName();
    public static final Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");

    public ConnectManager(Context context) {
        checkNetworkType(context);
    }

    private void checkApn(Context context) {
        Cursor query = context.getContentResolver().query(PREFERRED_APN_URI, new String[]{"_id", "apn", "proxy", "port"}, null, null, null);
        if (query != null) {
            if (query.moveToFirst()) {
                int columnIndex = query.getColumnIndex("apn");
                int columnIndex2 = query.getColumnIndex("proxy");
                int columnIndex3 = query.getColumnIndex("port");
                this.mApn = query.getString(columnIndex);
                this.mProxy = query.getString(columnIndex2);
                this.mPort = query.getString(columnIndex3);
                if (this.mProxy == null || this.mProxy.length() <= 0) {
                    if (this.mApn != null) {
                        String upperCase = this.mApn.toUpperCase();
                        if (upperCase.equals("CMWAP") || upperCase.equals("UNIWAP") || upperCase.equals("3GWAP")) {
                            this.mUseWap = true;
                            this.mProxy = "10.0.0.172";
                            this.mPort = "80";
                        } else if (upperCase.equals("CTWAP")) {
                            this.mUseWap = true;
                            this.mProxy = "10.0.0.200";
                            this.mPort = "80";
                        }
                    } else {
                        this.mUseWap = false;
                    }
                } else if ("10.0.0.172".equals(this.mProxy.trim())) {
                    this.mUseWap = true;
                    this.mPort = "80";
                } else if ("10.0.0.200".equals(this.mProxy.trim())) {
                    this.mUseWap = true;
                    this.mPort = "80";
                } else {
                    this.mUseWap = false;
                }
            }
            query.close();
        }
    }

    private void checkNetworkType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if ("wifi".equals(activeNetworkInfo.getTypeName().toLowerCase())) {
                this.mUseWap = false;
            } else {
                checkApn(context);
            }
        }
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnectedOrConnecting();
        }
        return false;
    }

    public String getApn() {
        return this.mApn;
    }

    public String getProxy() {
        return this.mProxy;
    }

    public String getProxyPort() {
        return this.mPort;
    }

    public boolean isWapNetwork() {
        return this.mUseWap;
    }
}
