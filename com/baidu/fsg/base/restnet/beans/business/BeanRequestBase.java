package com.baidu.fsg.base.restnet.beans.business;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public abstract class BeanRequestBase {
    private static final String TAG = "BeanRequestBase";
    protected boolean mBelongPaySdk = false;

    public abstract boolean checkRequestValidity();

    public abstract String getRequestId();

    @SuppressLint({"DefaultLocale"})
    public String getSinalParam(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            for (String str3 : str.split(ETAG.ITEM_SEPARATOR)) {
                String[] split = str3.split(ETAG.EQUAL);
                if (split != null && !TextUtils.isEmpty(split[0]) && str2.equals(split[0].toUpperCase()) && split.length > 1) {
                    return URLDecoder.decode(split[1]);
                }
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    protected void setBelongPaySdk() {
        this.mBelongPaySdk = true;
    }
}
