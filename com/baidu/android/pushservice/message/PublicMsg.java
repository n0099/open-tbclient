package com.baidu.android.pushservice.message;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.pushservice.y;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PublicMsg implements Parcelable {
    public static final Parcelable.Creator CREATOR = new f();
    public String a;
    public String b;
    public String c;
    public String d;
    public int e;
    public String f;
    public int g;
    public String h;
    public boolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PublicMsg() {
        this.e = 0;
        this.g = 0;
        this.i = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PublicMsg(Parcel parcel) {
        this.e = 0;
        this.g = 0;
        this.i = true;
        this.a = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readString();
    }

    void a(Context context, String str, int i) {
        String b = y.a().b();
        String c = y.a().c();
        if (TextUtils.isEmpty(b) || TextUtils.isEmpty(c)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msgid", str);
            jSONObject.put("result_code", i);
        } catch (JSONException e) {
        }
        Thread thread = new Thread(new e(this, context, b, c, jSONObject.toString()));
        thread.setName("PushService-linkhit");
        thread.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, String str, String str2) {
        int i = 1;
        int i2 = 0;
        if ("com.baidu.pushservice.action.publicmsg.DELETE".equals(str)) {
            a(context, str2, 2);
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager.getPackageInfo(this.d, 0).versionCode >= this.e) {
            Intent parseUri = Intent.parseUri(this.f, 0);
            parseUri.setPackage(this.d);
            if (packageManager.queryBroadcastReceivers(parseUri, 0).size() > 0) {
                context.sendBroadcast(parseUri);
            } else if (packageManager.queryIntentActivities(parseUri, 0).size() > 0) {
                parseUri.addFlags(268435456);
                context.startActivity(parseUri);
            }
            i2 = i;
            if (i2 == 0) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(this.c));
                intent.addFlags(268435456);
                try {
                    context.startActivity(intent);
                } catch (ActivityNotFoundException e) {
                }
            }
            a(context, str2, i2);
        }
        i = 0;
        i2 = i;
        if (i2 == 0) {
        }
        a(context, str2, i2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "\r\n mTitle = " + this.a + "\r\n mDescription = " + this.b + "\r\n mUrl = " + this.c + "\r\n mNetType = " + this.g + "\r\n mSupportAppname = " + this.h + "\r\n mIsSupportApp = " + this.i + "\r\n mPkgName = " + this.d + "\r\n mPlgVercode = " + this.e + "\r\n mIntent = " + this.f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
    }
}
