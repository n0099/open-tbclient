package com.baidu.android.pushservice.message;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.pushservice.g;
import com.baidu.android.pushservice.j;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.android.pushservice.z.c;
import com.baidu.android.pushservice.z.e;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PublicMsg implements Parcelable {
    public static final Parcelable.Creator<PublicMsg> CREATOR = new b();
    public static final int FLAG_NEED_CLEAR = 1;
    public static final int FLAG_NEED_SOUND = 4;
    public static final int FLAG_NEED_VIBRATE = 2;
    public static final String TAG = "PublicMsg";
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
    public String mBuilderRes;
    public String mCustomContent;
    public String mDescription;
    public String mGroup;
    public int mGroupNotifyId;
    public String mImgUrl;
    public boolean mIsSupportApp;
    public String mMsgId;
    public int mNetType;
    public int mNotificationBasicStyle;
    public int mNotificationBuilder;
    public int mOpenType;
    public String mPkgContent;
    public String mPkgName;
    public int mPkgVercode;
    public String mSummary;
    public String mSupportAppname;
    public String mTitle;
    public String mUrl;
    public int mUserConfirm;

    /* loaded from: classes.dex */
    public class a extends c {
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PublicMsg publicMsg, String str, short s, Context context, String str2, String str3, String str4) {
            super(str, s);
            this.c = context;
            this.d = str2;
            this.e = str3;
            this.f = str4;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            try {
                HashMap hashMap = new HashMap();
                com.baidu.android.pushservice.p.b.a(this.c, hashMap);
                hashMap.put("method", "linkhit");
                hashMap.put("channel_token", this.d);
                hashMap.put("data", this.e);
                if (com.baidu.android.pushservice.q.c.a(this.c, g.a() + this.f, "POST", hashMap).a() == 200) {
                    com.baidu.android.pushservice.u.a.c(PublicMsg.TAG, "<<< public msg send result return OK!", this.c.getApplicationContext());
                }
            } catch (Exception e) {
                com.baidu.android.pushservice.u.a.b(PublicMsg.TAG, "error : " + e.getMessage(), this.c.getApplicationContext());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Parcelable.Creator<PublicMsg> {
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
    }

    public PublicMsg() {
        this.mPkgVercode = 0;
        this.mNetType = 0;
        this.mNotificationBuilder = 0;
        this.mOpenType = 0;
        this.mNotificationBasicStyle = 7;
        this.mIsSupportApp = true;
        this.mUserConfirm = 0;
    }

    public PublicMsg(Parcel parcel) {
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
        this.mImgUrl = parcel.readString();
        this.mSummary = parcel.readString();
        this.mBuilderRes = parcel.readString();
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
        this.mGroup = parcel.readString();
        this.mGroupNotifyId = parcel.readInt();
    }

    private void addCustomContentToIntent(Context context, Intent intent) {
        if (this.mCustomContent != null) {
            try {
                JSONObject jSONObject = new JSONObject(this.mCustomContent);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    intent.putExtra(next, jSONObject.getString(next));
                }
                intent.putExtra("extra_extra_custom_content", this.mCustomContent);
            } catch (JSONException unused) {
            }
        }
    }

    private void sendResult(Context context, String str, int i) {
        String a2 = j.a(context).a();
        String b2 = j.a(context).b();
        if (TextUtils.isEmpty(a2) || TextUtils.isEmpty(b2)) {
            com.baidu.android.pushservice.u.a.b(TAG, "Fail Send Public msg result. Token invalid!", context.getApplicationContext());
            return;
        }
        com.baidu.android.pushservice.u.a.a(TAG, "Send Linkhit, msgId = " + str + ", resultCode = " + i, context.getApplicationContext());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msgid", str);
            jSONObject.put("result_code", i);
        } catch (JSONException e) {
            com.baidu.android.pushservice.u.a.b(TAG, e.getMessage(), context.getApplicationContext());
        }
        e.a().a(new a(this, "PushService-linkhit", (short) 90, context, b2, jSONObject.toString(), a2));
    }

    private void startApplicationLauncher(Context context, String str, String str2) {
        try {
            Intent parseUri = this.mPkgContent != null ? Intent.parseUri(this.mPkgContent, 0) : new Intent();
            String launcherActivityName = getLauncherActivityName(context, str);
            if (launcherActivityName != null) {
                parseUri.setClassName(str, launcherActivityName);
                parseUri.setFlags(parseUri.getFlags() | LaunchTaskConstants.OTHER_PROCESS);
                parseUri.putExtra("open_type", 1);
                parseUri.putExtra("msgid", str2);
                context.startActivity(parseUri);
            }
        } catch (URISyntaxException e) {
            com.baidu.android.pushservice.u.a.b(TAG, "error " + e.getMessage(), context.getApplicationContext());
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
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo != null) {
                return activityInfo.name;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handle(Context context, String str, String str2) {
        StringBuilder sb;
        String message;
        com.baidu.android.pushservice.u.a.a(TAG, "--handle--", context.getApplicationContext());
        if ("com.baidu.pushservice.action.publicmsg.DELETE_V2".equals(str)) {
            com.baidu.android.pushservice.u.a.a(TAG, "Public msg deleted by user", context.getApplicationContext());
            sendResult(context, str2, 2);
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        int i = 0;
        try {
            if (packageManager.getPackageInfo(this.mPkgName, 0).versionCode >= this.mPkgVercode) {
                Intent parseUri = Intent.parseUri(this.mPkgContent, 0);
                parseUri.setPackage(this.mPkgName);
                if (packageManager.queryBroadcastReceivers(parseUri, 0).size() > 0) {
                    context.sendBroadcast(parseUri);
                } else if (packageManager.queryIntentActivities(parseUri, 0).size() > 0) {
                    parseUri.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                    context.startActivity(parseUri);
                }
                i = 1;
            }
        } catch (PackageManager.NameNotFoundException e) {
            sb = new StringBuilder();
            sb.append("package not exist \r\n");
            message = e.getMessage();
            sb.append(message);
            com.baidu.android.pushservice.u.a.b(TAG, sb.toString(), context);
            if (i == 0) {
            }
            sendResult(context, str2, i);
        } catch (URISyntaxException e2) {
            sb = new StringBuilder();
            sb.append("uri to intent fail \r\n");
            message = e2.getMessage();
            sb.append(message);
            com.baidu.android.pushservice.u.a.b(TAG, sb.toString(), context);
            if (i == 0) {
            }
            sendResult(context, str2, i);
        } catch (Exception e3) {
            sb = new StringBuilder();
            sb.append("parse customize action error\r\n");
            message = e3.getMessage();
            sb.append(message);
            com.baidu.android.pushservice.u.a.b(TAG, sb.toString(), context);
            if (i == 0) {
            }
            sendResult(context, str2, i);
        }
        if (i == 0) {
            Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER);
            intent.setData(Uri.parse(this.mUrl));
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException e4) {
                com.baidu.android.pushservice.u.a.b(TAG, ">>> Url cann't be deal! \r\n" + e4.getMessage(), context);
            }
        }
        sendResult(context, str2, i);
    }

    public void handlePrivateNotification(Context context, String str, String str2, String str3, byte[] bArr, byte[] bArr2, int i, String str4) {
        StringBuilder sb;
        String message;
        ActivityInfo activityInfo;
        com.baidu.android.pushservice.u.a.a(TAG, "=== Handle private notification: " + str, context);
        if ("com.baidu.android.pushservice.action.privatenotification.DELETE".equals(str)) {
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager.getPackageInfo(this.mPkgName, 0).versionCode >= this.mPkgVercode) {
                Intent intent = new Intent();
                intent.putExtra("msgid", str2);
                intent.putExtra("notification_title", this.mTitle);
                intent.putExtra("notification_content", this.mDescription);
                intent.putExtra("com.baidu.pushservice.app_id", str3);
                intent.putExtra("baidu_message_secur_info", bArr);
                intent.putExtra("baidu_message_body", bArr2);
                intent.putExtra("extra_extra_custom_content", this.mCustomContent);
                intent.putExtra("notification_log_ext", str4);
                intent.putExtra("float_window_show_type", i);
                com.baidu.android.pushservice.n.c.a().a(context, false, 0, " ", intent.getStringExtra("extra_extra_custom_content"), str4);
                Utility.c(context, intent, "com.baidu.android.pushservice.action.notification.CLICK", this.mPkgName);
                if (this.mOpenType == 1 && this.mUrl != null) {
                    Intent intent2 = new Intent();
                    intent2.setAction(IntentConstants.ACTION_BOX_BROWSER);
                    intent2.setData(Uri.parse(this.mUrl));
                    intent2.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                    context.startActivity(intent2);
                } else if (this.mOpenType == 2) {
                    if (TextUtils.isEmpty(this.mPkgContent)) {
                        startApplicationLauncher(context, this.mPkgName, str2);
                    } else {
                        Intent parseUri = Intent.parseUri(this.mPkgContent, 0);
                        parseUri.setPackage(this.mPkgName);
                        if (packageManager.queryBroadcastReceivers(parseUri, 0).size() > 0) {
                            String action = parseUri.getAction();
                            if (action != null && action.startsWith("com.baidu.android.pushservice.action")) {
                                context.sendBroadcast(parseUri);
                            }
                        } else {
                            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(parseUri, 0);
                            if (queryIntentActivities != null && queryIntentActivities.size() > 0 && (activityInfo = queryIntentActivities.get(0).activityInfo) != null && activityInfo.exported) {
                                parseUri.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                                parseUri.putExtra("open_type", 1);
                                parseUri.putExtra("msgid", str2);
                                context.startActivity(parseUri);
                            }
                        }
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            sb = new StringBuilder();
            sb.append("package not exist \r\n");
            message = e.getMessage();
            sb.append(message);
            com.baidu.android.pushservice.u.a.b(TAG, sb.toString(), context);
            com.baidu.android.pushservice.v.c.a().d(context);
        } catch (URISyntaxException e2) {
            sb = new StringBuilder();
            sb.append("uri to intent fail \r\n");
            message = e2.getMessage();
            sb.append(message);
            com.baidu.android.pushservice.u.a.b(TAG, sb.toString(), context);
            com.baidu.android.pushservice.v.c.a().d(context);
        }
        com.baidu.android.pushservice.v.c.a().d(context);
    }

    public String toString() {
        return "\r\n mMsgId = " + this.mMsgId + "\r\n mAppId = " + this.mAppId + "\r\n mTitle = " + this.mTitle + "\r\n mDescription = " + this.mDescription + "\r\n mUrl = " + this.mUrl + "\r\n mNetType = " + this.mNetType + "\r\n mSupportAppname = " + this.mSupportAppname + "\r\n mIsSupportApp = " + this.mIsSupportApp + "\r\n mPkgName = " + this.mPkgName + "\r\n mPlgVercode = " + this.mPkgVercode + "\r\n mNotificationBuilder = " + this.mNotificationBuilder + "\r\n mNotificationBasicStyle = " + this.mNotificationBasicStyle + "\r\n mOpenType = " + this.mOpenType + "\r\n mCustomContent = " + this.mCustomContent + "\r\n mIntent = " + this.mPkgContent + "\r\nmResBuilder = " + this.mBuilderRes + "\r\nmGroup = " + this.mGroup + "\r\nmSummaryNotifyId = " + this.mGroupNotifyId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mMsgId);
        parcel.writeString(this.mAppId);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mDescription);
        parcel.writeString(this.mUrl);
        parcel.writeString(this.mImgUrl);
        parcel.writeString(this.mSummary);
        parcel.writeString(this.mBuilderRes);
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
        parcel.writeString(this.mGroup);
        parcel.writeInt(this.mGroupNotifyId);
    }
}
