package com.baidu.browser.core.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.baidu.cyberplayer.sdk.internal.HttpUtils;
/* loaded from: classes.dex */
public class BdNetReceiver extends BroadcastReceiver {
    private static final Uri URI_PREFER_APN = Uri.parse("content://telephony/carriers/preferapn");
    private boolean mIsCmwap = false;
    private String mWapApnUrl;

    public boolean isCmwap() {
        return this.mIsCmwap;
    }

    public String getWapApnUrl() {
        return this.mWapApnUrl;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            checkApnType(context);
        }
    }

    public void checkApnType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && !"wifi".equals(activeNetworkInfo.getTypeName().toLowerCase())) {
            checkApnType(context, activeNetworkInfo);
        }
    }

    public void checkApnType(Context context, NetworkInfo networkInfo) {
        if (networkInfo.getExtraInfo() != null) {
            String lowerCase = networkInfo.getExtraInfo().toLowerCase();
            if (lowerCase != null) {
                if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
                    this.mIsCmwap = true;
                    this.mWapApnUrl = "10.0.0.172:80";
                    return;
                } else if (lowerCase.startsWith("ctwap")) {
                    this.mIsCmwap = true;
                    this.mWapApnUrl = "10.0.0.200:80";
                } else if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                    this.mIsCmwap = false;
                    return;
                }
            }
            Cursor query = context.getContentResolver().query(URI_PREFER_APN, new String[]{"_id", "apn", "proxy", "user"}, null, null, null);
            if (query != null) {
                query.moveToFirst();
                if (!query.isAfterLast()) {
                    String string = query.getString(1);
                    String string2 = query.getString(2);
                    String string3 = query.getString(3);
                    if (string2 != null && string2.length() > 0) {
                        if ("10.0.0.172".equals(string2.trim())) {
                            this.mIsCmwap = true;
                            this.mWapApnUrl = "10.0.0.172:80";
                        } else if (HttpUtils.IP_CTWAP.equals(string2.trim())) {
                            this.mIsCmwap = true;
                            this.mWapApnUrl = "10.0.0.200:80";
                        } else {
                            this.mIsCmwap = false;
                        }
                    } else if (string != null && string.length() > 0) {
                        String upperCase = string.toUpperCase();
                        if (upperCase.equals("CMWAP") || upperCase.equals("UNIWAP") || upperCase.equals("3GWAP")) {
                            this.mIsCmwap = true;
                            this.mWapApnUrl = "10.0.0.172:80";
                        } else if (upperCase.equals("CTWAP")) {
                            this.mIsCmwap = true;
                            this.mWapApnUrl = "10.0.0.200:80";
                        } else if (string3 != null) {
                            if (string3.toUpperCase().startsWith("CMWAP")) {
                                this.mIsCmwap = true;
                            } else {
                                this.mIsCmwap = false;
                            }
                        } else {
                            this.mIsCmwap = false;
                        }
                    } else {
                        this.mIsCmwap = false;
                    }
                }
                if (query != null) {
                    query.close();
                }
            }
        }
    }
}
