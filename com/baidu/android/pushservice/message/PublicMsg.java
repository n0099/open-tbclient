package com.baidu.android.pushservice.message;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.y;
import java.net.URISyntaxException;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PublicMsg implements Parcelable {
    public static final Parcelable.Creator CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    public String f588a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public int g;
    public String h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public String n;
    public String o;
    public boolean p;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PublicMsg() {
        this.g = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 7;
        this.p = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PublicMsg(Parcel parcel) {
        this.g = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 7;
        this.p = true;
        this.f588a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readInt();
        this.j = parcel.readInt();
        this.m = parcel.readInt();
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.n = parcel.readString();
        this.h = parcel.readString();
    }

    private void a(Intent intent) {
        if (this.n != null) {
            try {
                JSONObject jSONObject = new JSONObject(this.n);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    intent.putExtra(next, jSONObject.getString(next));
                }
                intent.putExtra(PushConstants.EXTRA_EXTRA, this.n);
            } catch (JSONException e) {
                Log.w("PublicMsg", "Custom content to JSONObject exception::" + e.getMessage());
            }
        }
    }

    private String b(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
            if (resolveInfo.activityInfo != null) {
                return resolveInfo.activityInfo.name;
            }
        }
        return null;
    }

    private void b(Context context, String str, String str2) {
        try {
            Intent parseUri = this.h != null ? Intent.parseUri(this.h, 0) : new Intent();
            String b = b(context, str);
            if (b != null) {
                parseUri.setClassName(str, b);
                parseUri.setFlags(parseUri.getFlags() | 268435456);
                parseUri.putExtra(PushConstants.EXTRA_OPENTYPE, 1);
                parseUri.putExtra(PushConstants.EXTRA_MSGID, str2);
                context.startActivity(parseUri);
            }
        } catch (Exception e) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.e("PublicMsg", "startApplicationLauncher fail. \r\n" + e.getMessage());
            }
        }
    }

    public void a(Context context, String str) {
        if (com.baidu.android.pushservice.b.a()) {
            Log.d("PublicMsg", "=== Handle rich media notification: " + str + " title = " + this.c);
        }
        if ("com.baidu.android.pushservice.action.media.DELETE".equals(str)) {
            a(context, this.f588a, this.b, 2);
            return;
        }
        Intent intent = new Intent("com.baidu.android.pushservice.action.media.CLICK");
        intent.setPackage(this.f);
        intent.putExtra("public_msg", this);
        context.sendBroadcast(intent);
        a(context, this.f588a, this.b, 1);
    }

    void a(Context context, String str, int i) {
        String c = y.a().c();
        String d = y.a().d();
        if (TextUtils.isEmpty(c) || TextUtils.isEmpty(d)) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.e("PublicMsg", "Fail Send Public msg result. Token invalid!");
                return;
            }
            return;
        }
        if (com.baidu.android.pushservice.b.a()) {
            Log.d("PublicMsg", "Send Linkhit, msgId = " + str + ", resultCode = " + i);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConstants.EXTRA_MSGID, str);
            jSONObject.put("result_code", i);
        } catch (JSONException e) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.d("PublicMsg", e.getMessage());
            }
        }
        Thread thread = new Thread(new g(this, context, c, d, jSONObject.toString()));
        thread.setName("PushService-linkhit");
        thread.start();
    }

    public void a(Context context, String str, String str2) {
        int i = 1;
        int i2 = 0;
        if (com.baidu.android.pushservice.b.a()) {
            Log.d("PublicMsg", "=== Handle msg: " + toString());
        }
        if ("com.baidu.pushservice.action.publicmsg.DELETE_V2".equals(str)) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.d("PublicMsg", "Public msg deleted by user, title = " + this.c);
            }
            a(context, str2, 2);
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            int i3 = packageManager.getPackageInfo(this.f, 0).versionCode;
            if (i3 >= this.g) {
                Intent parseUri = Intent.parseUri(this.h, 0);
                parseUri.setPackage(this.f);
                if (packageManager.queryBroadcastReceivers(parseUri, 0).size() > 0) {
                    if (com.baidu.android.pushservice.b.a()) {
                        Log.d("PublicMsg", "Intent broadcasted to app! ===> " + parseUri.toURI());
                    }
                    context.sendBroadcast(parseUri);
                } else if (packageManager.queryIntentActivities(parseUri, 0).size() > 0) {
                    if (com.baidu.android.pushservice.b.a()) {
                        Log.d("PublicMsg", "Intent sent to actvity! ===> " + parseUri.toURI());
                    }
                    parseUri.addFlags(268435456);
                    context.startActivity(parseUri);
                } else {
                    if (com.baidu.android.pushservice.b.a()) {
                        Log.d("PublicMsg", "No app component can deal, so start " + this.f + " launcher activity!");
                    }
                    i = 0;
                }
                i2 = i;
            } else if (com.baidu.android.pushservice.b.a()) {
                Log.d("PublicMsg", "Version code is too low! ===> app ver: " + i3 + ", request ver:" + this.g);
            }
        } catch (PackageManager.NameNotFoundException e) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.e("PublicMsg", "package not exist \r\n" + e.getMessage());
            }
        } catch (URISyntaxException e2) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.e("PublicMsg", "uri to intent fail \r\n" + e2.getMessage());
            }
        } catch (Exception e3) {
            Log.e("PublicMsg", "parse customize action error\r\n" + e3.getMessage());
        }
        if (i2 == 0) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.e));
            intent.addFlags(268435456);
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException e4) {
                if (com.baidu.android.pushservice.b.a()) {
                    Log.e("PublicMsg", ">>> Url cann't be deal! \r\n" + e4.getMessage());
                }
            }
        }
        a(context, str2, i2);
    }

    void a(Context context, String str, String str2, int i) {
        String c = y.a().c();
        String d = y.a().d();
        if (TextUtils.isEmpty(c) || TextUtils.isEmpty(d)) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.e("PublicMsg", "Fail Send Private Notification msg result. Token invalid!");
                return;
            }
            return;
        }
        if (com.baidu.android.pushservice.b.a()) {
            Log.d("PublicMsg", "Send feedback, msgId = " + str + ", resultCode = " + i);
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        jSONArray.put(jSONObject);
        try {
            jSONObject.put(PushConstants.EXTRA_MSGID, str);
            jSONObject.put("appid", str2);
            jSONObject.put("resultCode", i);
        } catch (JSONException e) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.d("PublicMsg", e.getMessage());
            }
        }
        Thread thread = new Thread(new h(this, context, c, d, jSONArray.toString(), str2, str, i));
        thread.setName("PushService-feedback");
        thread.start();
    }

    public void a(Context context, String str, String str2, String str3) {
        if (com.baidu.android.pushservice.b.a()) {
            Log.d("PublicMsg", "=== Handle private notification: " + str);
        }
        if ("com.baidu.android.pushservice.action.privatenotification.DELETE".equals(str)) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.d("PublicMsg", "private notification deleted by user, title = " + this.c);
            }
            a(context, str2, str3, 2);
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(this.f, 0);
            int i = packageInfo.versionCode;
            if (i >= this.g) {
                Intent intent = new Intent(PushConstants.ACTION_RECEIVER_NOTIFICATION_CLICK);
                intent.setPackage(this.f);
                intent.putExtra(PushConstants.EXTRA_NOTIFICATION_TITLE, this.c);
                intent.putExtra(PushConstants.EXTRA_NOTIFICATION_CONTENT, this.d);
                a(intent);
                context.sendBroadcast(intent);
                if (this.k != 1 || this.e == null) {
                    if (this.k == 2) {
                        if (this.h != null) {
                            Intent parseUri = Intent.parseUri(this.h, 0);
                            parseUri.setPackage(this.f);
                            if (packageManager.queryBroadcastReceivers(parseUri, 0).size() > 0) {
                                if (com.baidu.android.pushservice.b.a()) {
                                    Log.d("PublicMsg", "Intent broadcasted to app! ===> " + parseUri.toURI());
                                }
                                context.sendBroadcast(parseUri);
                            } else if (packageManager.queryIntentActivities(parseUri, 0).size() > 0) {
                                if (com.baidu.android.pushservice.b.a()) {
                                    Log.d("PublicMsg", "Intent sent to actvity! ===> " + parseUri.toURI());
                                }
                                parseUri.addFlags(268435456);
                                parseUri.putExtra(PushConstants.EXTRA_OPENTYPE, 1);
                                parseUri.putExtra(PushConstants.EXTRA_MSGID, str2);
                                context.startActivity(parseUri);
                            }
                        } else {
                            b(context, this.f, str2);
                        }
                    }
                } else if (this.l == 1) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("提示");
                    builder.setMessage(((Object) packageInfo.applicationInfo.loadLabel(packageManager)) + "请求访问:" + this.e + " ?");
                    builder.setPositiveButton("允许", new e(this, context));
                    builder.setNeutralButton("拒绝", new f(this));
                    AlertDialog create = builder.create();
                    create.getWindow().setType(2003);
                    create.setCanceledOnTouchOutside(false);
                    create.show();
                } else {
                    Intent intent2 = new Intent();
                    intent2.setAction("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(this.e));
                    intent2.addFlags(268435456);
                    context.startActivity(intent2);
                }
            } else if (com.baidu.android.pushservice.b.a()) {
                Log.d("PublicMsg", "Version code is too low! ===> app ver: " + i + ", request ver:" + this.g);
            }
        } catch (Exception e) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.e("PublicMsg", "handlePrivateNotification fail. \r\n" + e.getMessage());
            }
        }
        a(context, str2, str3, 1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "\r\n mMsgId = " + this.f588a + "\r\n mAppId = " + this.b + "\r\n mTitle = " + this.c + "\r\n mDescription = " + this.d + "\r\n mUrl = " + this.e + "\r\n mNetType = " + this.i + "\r\n mSupportAppname = " + this.o + "\r\n mIsSupportApp = " + this.p + "\r\n mPkgName = " + this.f + "\r\n mPlgVercode = " + this.g + "\r\n mNotificationBuilder = " + this.j + "\r\n mNotificationBasicStyle = " + this.m + "\r\n mOpenType = " + this.k + "\r\n mUserConfirm = " + this.l + "\r\n mCustomContent = " + this.n + "\r\n mIntent = " + this.h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f588a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.j);
        parcel.writeInt(this.m);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeString(this.n);
        parcel.writeString(this.h);
    }
}
