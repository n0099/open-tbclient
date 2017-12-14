package com.baidu.android.pushservice.message;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.j.p;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PublicMsg implements Parcelable {
    public static final Parcelable.Creator<PublicMsg> CREATOR = new Parcelable.Creator<PublicMsg>() { // from class: com.baidu.android.pushservice.message.PublicMsg.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PublicMsg createFromParcel(Parcel parcel) {
            return new PublicMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PublicMsg[] newArray(int i) {
            return new PublicMsg[i];
        }
    };
    public static final int FLAG_NEED_CLEAR = 1;
    public static final int FLAG_NEED_SOUND = 4;
    public static final int FLAG_NEED_VIBRATE = 2;
    private static final String TAG = "PublicMsg";
    public String mAdvertiseBigPictureClickUrl;
    public String mAdvertiseBigPictureContent;
    public String mAdvertiseBigPictureTitle;
    public String mAdvertiseBigPictureUrl;
    public String mAdvertiseClickUrl;
    public String mAdvertiseDetailClickUrl;
    public String mAdvertiseDownloadClickUrl;
    public String mAdvertiseLargeIconUrl;
    public String mAdvertiseSmallIconUrl;
    public int mAdvertiseStyle;
    public String mAppId;
    public String mCustomContent;
    public String mDescription;
    public boolean mIsSupportApp;
    public String mMsgId;
    public int mNetType;
    public int mNotificationBasicStyle;
    public int mNotificationBuilder;
    public int mOpenType;
    public String mPkgContent;
    public String mPkgName;
    public int mPkgVercode;
    public String mSupportAppname;
    public String mTitle;
    public String mUrl;
    public int mUserConfirm;

    public PublicMsg() {
        this.mPkgVercode = 0;
        this.mNetType = 0;
        this.mNotificationBuilder = 0;
        this.mOpenType = 0;
        this.mNotificationBasicStyle = 7;
        this.mIsSupportApp = true;
        this.mUserConfirm = 0;
    }

    PublicMsg(Parcel parcel) {
        this.mPkgVercode = 0;
        this.mNetType = 0;
        this.mNotificationBuilder = 0;
        this.mOpenType = 0;
        this.mNotificationBasicStyle = 7;
        this.mIsSupportApp = true;
        this.mUserConfirm = 0;
        this.mMsgId = parcel.readString();
        this.mAppId = parcel.readString();
        this.mTitle = parcel.readString();
        this.mDescription = parcel.readString();
        this.mUrl = parcel.readString();
        this.mPkgName = parcel.readString();
        this.mPkgVercode = parcel.readInt();
        this.mNotificationBuilder = parcel.readInt();
        this.mNotificationBasicStyle = parcel.readInt();
        this.mOpenType = parcel.readInt();
        this.mUserConfirm = parcel.readInt();
        this.mCustomContent = parcel.readString();
        this.mPkgContent = parcel.readString();
        this.mAdvertiseStyle = parcel.readInt();
        this.mAdvertiseSmallIconUrl = parcel.readString();
        this.mAdvertiseLargeIconUrl = parcel.readString();
        this.mAdvertiseClickUrl = parcel.readString();
        this.mAdvertiseBigPictureUrl = parcel.readString();
        this.mAdvertiseBigPictureClickUrl = parcel.readString();
        this.mAdvertiseDownloadClickUrl = parcel.readString();
        this.mAdvertiseDetailClickUrl = parcel.readString();
        this.mAdvertiseBigPictureTitle = parcel.readString();
        this.mAdvertiseBigPictureContent = parcel.readString();
    }

    private void addCustomContentToIntent(Intent intent) {
        if (this.mCustomContent != null) {
            try {
                JSONObject jSONObject = new JSONObject(this.mCustomContent);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    intent.putExtra(next, jSONObject.getString(next));
                }
                intent.putExtra("extra_extra_custom_content", this.mCustomContent);
            } catch (JSONException e) {
                com.baidu.android.pushservice.g.a.e(TAG, "Custom content to JSONObject exception::" + e.getMessage());
            }
        }
    }

    private void insertBehavior(Context context, com.baidu.android.pushservice.b.f fVar, com.baidu.android.pushservice.h.j jVar, com.baidu.android.pushservice.h.i iVar) {
        if (fVar != null) {
            iVar.b(fVar.c());
            com.baidu.android.pushservice.h.i a = p.a(iVar, context, fVar.c());
            jVar.j = fVar.c();
            try {
                com.baidu.android.pushservice.h.p.a(context, jVar);
                com.baidu.android.pushservice.h.p.a(context, a);
            } catch (Exception e) {
                com.baidu.android.pushservice.g.a.b(TAG, "PM insert db exception");
            }
        }
    }

    private void insertNotiBehavior(Context context, String str, String str2, String str3) {
        com.baidu.android.pushservice.h.j jVar = new com.baidu.android.pushservice.h.j();
        jVar.d = str3;
        jVar.a = str;
        jVar.e = System.currentTimeMillis();
        jVar.f = com.baidu.android.pushservice.h.a.b.b(context);
        jVar.c = com.baidu.android.pushservice.message.a.l.MSG_TYPE_MULTI_PRIVATE_NOTIFICATION.a();
        jVar.h = str2;
        com.baidu.android.pushservice.b.f d = com.baidu.android.pushservice.b.b.a(context).d(str2);
        if (d != null) {
            insertBehavior(context, d, jVar, new com.baidu.android.pushservice.h.i(str2));
        }
    }

    private void sendResult(final Context context, String str, int i) {
        final String a = com.baidu.android.pushservice.j.a(context).a();
        final String b = com.baidu.android.pushservice.j.a(context).b();
        if (TextUtils.isEmpty(a) || TextUtils.isEmpty(b)) {
            com.baidu.android.pushservice.g.b.b(TAG, "Fail Send Public msg result. Token invalid!", context.getApplicationContext());
            return;
        }
        com.baidu.android.pushservice.g.b.a(TAG, "Send Linkhit, msgId = " + str + ", resultCode = " + i, context.getApplicationContext());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msgid", str);
            jSONObject.put("result_code", i);
        } catch (JSONException e) {
            com.baidu.android.pushservice.g.b.b(TAG, e.getMessage(), context.getApplicationContext());
        }
        final String jSONObject2 = jSONObject.toString();
        com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("PushService-linkhit", (short) 90) { // from class: com.baidu.android.pushservice.message.PublicMsg.1
            @Override // com.baidu.android.pushservice.i.c
            public void a() {
                try {
                    HashMap hashMap = new HashMap();
                    com.baidu.android.pushservice.e.b.b(hashMap);
                    hashMap.put(PushConstants.EXTRA_METHOD, "linkhit");
                    hashMap.put("channel_token", b);
                    hashMap.put("data", jSONObject2);
                    com.baidu.android.pushservice.g.a.c(PublicMsg.TAG, "linkhit param -- " + com.baidu.android.pushservice.e.b.a(hashMap));
                    com.baidu.android.pushservice.f.a a2 = com.baidu.android.pushservice.f.b.a(com.baidu.android.pushservice.h.e() + a, "POST", hashMap);
                    if (a2.b() == 200) {
                        com.baidu.android.pushservice.g.b.c(PublicMsg.TAG, "<<< public msg send result return OK!", context.getApplicationContext());
                    } else {
                        com.baidu.android.pushservice.g.a.e(PublicMsg.TAG, "networkRegister request failed, code=" + a2.b() + ", err=" + com.baidu.android.pushservice.h.a.b.a(a2.a()));
                    }
                } catch (Exception e2) {
                    com.baidu.android.pushservice.g.b.b(PublicMsg.TAG, "error : " + e2.getMessage(), context.getApplicationContext());
                }
            }
        });
    }

    private void startApplicationLauncher(Context context, String str, String str2) {
        try {
            Intent parseUri = this.mPkgContent != null ? Intent.parseUri(this.mPkgContent, 0) : new Intent();
            String launcherActivityName = getLauncherActivityName(context, str);
            if (launcherActivityName != null) {
                parseUri.setClassName(str, launcherActivityName);
                parseUri.setFlags(parseUri.getFlags() | 268435456);
                parseUri.putExtra("open_type", 1);
                parseUri.putExtra("msgid", str2);
                context.startActivity(parseUri);
            }
        } catch (URISyntaxException e) {
            com.baidu.android.pushservice.g.b.b(TAG, "error " + e.getMessage(), context.getApplicationContext());
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getLauncherActivityName(Context context, String str) {
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

    /* JADX WARN: Removed duplicated region for block: B:14:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handle(Context context, String str, String str2) {
        int i;
        int i2 = 1;
        int i3 = 0;
        com.baidu.android.pushservice.g.a.c(TAG, "=== Handle msg: " + toString());
        com.baidu.android.pushservice.g.b.a(TAG, "--handle--", context.getApplicationContext());
        if ("com.baidu.pushservice.action.publicmsg.DELETE_V2".equals(str)) {
            com.baidu.android.pushservice.g.a.c(TAG, "Public msg deleted by user, title = " + this.mTitle);
            com.baidu.android.pushservice.g.b.a(TAG, "Public msg deleted by user", context.getApplicationContext());
            sendResult(context, str2, 2);
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            i = packageManager.getPackageInfo(this.mPkgName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            com.baidu.android.pushservice.g.b.b(TAG, "package not exist \r\n" + e.getMessage(), context);
        } catch (URISyntaxException e2) {
            com.baidu.android.pushservice.g.b.b(TAG, "uri to intent fail \r\n" + e2.getMessage(), context);
        } catch (Exception e3) {
            com.baidu.android.pushservice.g.b.b(TAG, "parse customize action error\r\n" + e3.getMessage(), context);
        }
        if (i >= this.mPkgVercode) {
            Intent parseUri = Intent.parseUri(this.mPkgContent, 0);
            parseUri.setPackage(this.mPkgName);
            if (packageManager.queryBroadcastReceivers(parseUri, 0).size() > 0) {
                com.baidu.android.pushservice.g.a.c(TAG, "Intent broadcasted to app! ===> " + parseUri.toUri(0));
                context.sendBroadcast(parseUri);
            } else if (packageManager.queryIntentActivities(parseUri, 0).size() > 0) {
                com.baidu.android.pushservice.g.a.c(TAG, "Intent sent to actvity! ===> " + parseUri.toUri(0));
                parseUri.addFlags(268435456);
                context.startActivity(parseUri);
            } else {
                com.baidu.android.pushservice.g.a.c(TAG, "No app component can deal, so start " + this.mPkgName + " launcher activity!");
            }
            i3 = i2;
            if (i3 == 0) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(this.mUrl));
                intent.addFlags(268435456);
                try {
                    context.startActivity(intent);
                } catch (ActivityNotFoundException e4) {
                    com.baidu.android.pushservice.g.b.b(TAG, ">>> Url cann't be deal! \r\n" + e4.getMessage(), context);
                }
            }
            sendResult(context, str2, i3);
        }
        com.baidu.android.pushservice.g.a.c(TAG, "Version code is too low! ===> app ver: " + i + ", request ver:" + this.mPkgVercode);
        i2 = 0;
        i3 = i2;
        if (i3 == 0) {
        }
        sendResult(context, str2, i3);
    }

    public void handleAlarmMessage(Context context, String str, String str2, String str3) {
        com.baidu.android.pushservice.g.a.c(TAG, "handle AlarmMessage ");
        insertNotiBehavior(context, str2, str3, str);
    }

    public void handlePrivateNotification(Context context, String str, String str2, String str3) {
        com.baidu.android.pushservice.g.b.a(TAG, "=== Handle private notification: " + str, context);
        if ("com.baidu.android.pushservice.action.privatenotification.DELETE".equals(str)) {
            com.baidu.android.pushservice.g.a.c(TAG, "private notification deleted by user, title = " + this.mTitle);
            insertNotiBehavior(context, str2, str3, "010202");
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            int i = packageManager.getPackageInfo(this.mPkgName, 0).versionCode;
            if (i >= this.mPkgVercode) {
                Intent intent = new Intent();
                intent.putExtra("notification_title", this.mTitle);
                intent.putExtra("notification_content", this.mDescription);
                intent.putExtra("com.baidu.pushservice.app_id", str3);
                addCustomContentToIntent(intent);
                p.b(context, intent, "com.baidu.android.pushservice.action.notification.CLICK", this.mPkgName);
                insertNotiBehavior(context, str2, str3, "010201");
                if (this.mOpenType == 1 && this.mUrl != null) {
                    Intent intent2 = new Intent();
                    intent2.setAction("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(this.mUrl));
                    intent2.addFlags(268435456);
                    context.startActivity(intent2);
                } else if (this.mOpenType == 2) {
                    if (TextUtils.isEmpty(this.mPkgContent)) {
                        startApplicationLauncher(context, this.mPkgName, str2);
                    } else {
                        Intent parseUri = Intent.parseUri(this.mPkgContent, 0);
                        parseUri.setPackage(this.mPkgName);
                        if (packageManager.queryBroadcastReceivers(parseUri, 0).size() > 0) {
                            com.baidu.android.pushservice.g.a.c(TAG, "Intent broadcasted to app! ===> " + parseUri.toUri(0));
                            context.sendBroadcast(parseUri);
                        } else if (packageManager.queryIntentActivities(parseUri, 0).size() > 0) {
                            com.baidu.android.pushservice.g.a.c(TAG, "Intent sent to actvity! ===> " + parseUri.toUri(0));
                            parseUri.addFlags(268435456);
                            parseUri.putExtra("open_type", 1);
                            parseUri.putExtra("msgid", str2);
                            context.startActivity(parseUri);
                        }
                    }
                }
            } else {
                com.baidu.android.pushservice.g.a.c(TAG, "Version code is too low! ===> app ver: " + i + ", request ver:" + this.mPkgVercode);
            }
        } catch (PackageManager.NameNotFoundException e) {
            com.baidu.android.pushservice.g.b.b(TAG, "package not exist \r\n" + e.getMessage(), context);
        } catch (URISyntaxException e2) {
            com.baidu.android.pushservice.g.b.b(TAG, "uri to intent fail \r\n" + e2.getMessage(), context);
        }
    }

    public void handleRichMediaNotification(Context context, String str, String str2) {
        com.baidu.android.pushservice.g.b.a(TAG, "Handle rich media notification", context);
        com.baidu.android.pushservice.g.a.c(TAG, "=== Handle rich media notification: " + str + " title = " + this.mTitle);
        com.baidu.android.pushservice.h.j jVar = new com.baidu.android.pushservice.h.j();
        if ("com.baidu.android.pushservice.action.media.DELETE".equals(str)) {
            com.baidu.android.pushservice.g.a.c(TAG, "rich media notification deleted by user, title = " + this.mTitle);
            jVar.d = "010402";
        } else {
            Intent intent = new Intent("com.baidu.android.pushservice.action.media.CLICK");
            intent.setPackage(this.mPkgName);
            intent.putExtra("public_msg", this);
            context.sendBroadcast(intent);
            jVar.d = "010401";
        }
        jVar.a = this.mMsgId;
        jVar.c = com.baidu.android.pushservice.message.a.l.MSG_TYPE_RICH_MEDIA.a();
        jVar.e = System.currentTimeMillis();
        jVar.g = 0;
        jVar.f = com.baidu.android.pushservice.h.a.b.b(context);
        jVar.h = str2;
        com.baidu.android.pushservice.b.f d = com.baidu.android.pushservice.b.b.a(context).d(str2);
        if (d != null) {
            insertBehavior(context, d, jVar, new com.baidu.android.pushservice.h.i(str2));
        }
    }

    public String toString() {
        return "\r\n mMsgId = " + this.mMsgId + "\r\n mAppId = " + this.mAppId + "\r\n mTitle = " + this.mTitle + "\r\n mDescription = " + this.mDescription + "\r\n mUrl = " + this.mUrl + "\r\n mNetType = " + this.mNetType + "\r\n mSupportAppname = " + this.mSupportAppname + "\r\n mIsSupportApp = " + this.mIsSupportApp + "\r\n mPkgName = " + this.mPkgName + "\r\n mPlgVercode = " + this.mPkgVercode + "\r\n mNotificationBuilder = " + this.mNotificationBuilder + "\r\n mNotificationBasicStyle = " + this.mNotificationBasicStyle + "\r\n mOpenType = " + this.mOpenType + "\r\n mCustomContent = " + this.mCustomContent + "\r\n mIntent = " + this.mPkgContent + "\r\n";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mMsgId);
        parcel.writeString(this.mAppId);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mDescription);
        parcel.writeString(this.mUrl);
        parcel.writeString(this.mPkgName);
        parcel.writeInt(this.mPkgVercode);
        parcel.writeInt(this.mNotificationBuilder);
        parcel.writeInt(this.mNotificationBasicStyle);
        parcel.writeInt(this.mOpenType);
        parcel.writeInt(this.mUserConfirm);
        parcel.writeString(this.mCustomContent);
        parcel.writeString(this.mPkgContent);
        parcel.writeInt(this.mAdvertiseStyle);
        parcel.writeString(this.mAdvertiseSmallIconUrl);
        parcel.writeString(this.mAdvertiseLargeIconUrl);
        parcel.writeString(this.mAdvertiseClickUrl);
        parcel.writeString(this.mAdvertiseBigPictureUrl);
        parcel.writeString(this.mAdvertiseBigPictureClickUrl);
        parcel.writeString(this.mAdvertiseDownloadClickUrl);
        parcel.writeString(this.mAdvertiseDetailClickUrl);
        parcel.writeString(this.mAdvertiseBigPictureTitle);
        parcel.writeString(this.mAdvertiseBigPictureContent);
    }
}
