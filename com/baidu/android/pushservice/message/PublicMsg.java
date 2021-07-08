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
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PublicMsg implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<PublicMsg> CREATOR;
    public static final int FLAG_NEED_CLEAR = 1;
    public static final int FLAG_NEED_SOUND = 4;
    public static final int FLAG_NEED_VIBRATE = 2;
    public static final String TAG = "PublicMsg";
    public transient /* synthetic */ FieldHolder $fh;
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1561350547, "Lcom/baidu/android/pushservice/message/PublicMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1561350547, "Lcom/baidu/android/pushservice/message/PublicMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<PublicMsg>() { // from class: com.baidu.android.pushservice.message.PublicMsg.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public PublicMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new PublicMsg(parcel) : (PublicMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public PublicMsg[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new PublicMsg[i2] : (PublicMsg[]) invokeI.objValue;
            }
        };
    }

    public PublicMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPkgVercode = 0;
        this.mNetType = 0;
        this.mNotificationBuilder = 0;
        this.mOpenType = 0;
        this.mNotificationBasicStyle = 7;
        this.mIsSupportApp = true;
        this.mUserConfirm = 0;
    }

    public PublicMsg(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
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

    private void addCustomContentToIntent(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, this, context, intent) == null) || this.mCustomContent == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mCustomContent);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                intent.putExtra(next, jSONObject.getString(next));
            }
            intent.putExtra("extra_extra_custom_content", this.mCustomContent);
        } catch (JSONException e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
        }
    }

    private void sendResult(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, this, context, str, i2) == null) {
            String a2 = com.baidu.android.pushservice.k.a(context).a();
            String b2 = com.baidu.android.pushservice.k.a(context).b();
            if (TextUtils.isEmpty(a2) || TextUtils.isEmpty(b2)) {
                com.baidu.android.pushservice.g.a.b(TAG, "Fail Send Public msg result. Token invalid!", context.getApplicationContext());
                return;
            }
            com.baidu.android.pushservice.g.a.a(TAG, "Send Linkhit, msgId = " + str + ", resultCode = " + i2, context.getApplicationContext());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("msgid", str);
                jSONObject.put("result_code", i2);
            } catch (JSONException e2) {
                com.baidu.android.pushservice.g.a.b(TAG, e2.getMessage(), context.getApplicationContext());
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            }
            com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c(this, "PushService-linkhit", (short) 90, context, b2, jSONObject.toString(), a2) { // from class: com.baidu.android.pushservice.message.PublicMsg.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f3517a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f3518b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f3519c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f3520d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ PublicMsg f3521e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, Short.valueOf(r10), context, b2, r13, a2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Short) objArr2[1]).shortValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f3521e = this;
                    this.f3517a = context;
                    this.f3518b = b2;
                    this.f3519c = r13;
                    this.f3520d = a2;
                }

                @Override // com.baidu.android.pushservice.h.c
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            HashMap hashMap = new HashMap();
                            com.baidu.android.pushservice.d.b.a(this.f3517a, hashMap);
                            hashMap.put("method", "linkhit");
                            hashMap.put("channel_token", this.f3518b);
                            hashMap.put("data", this.f3519c);
                            if (com.baidu.android.pushservice.e.c.a(this.f3517a, com.baidu.android.pushservice.h.e() + this.f3520d, "POST", hashMap).b() == 200) {
                                com.baidu.android.pushservice.g.a.c(PublicMsg.TAG, "<<< public msg send result return OK!", this.f3517a.getApplicationContext());
                            }
                        } catch (Exception e3) {
                            com.baidu.android.pushservice.g.a.b(PublicMsg.TAG, "error : " + e3.getMessage(), this.f3517a.getApplicationContext());
                            new b.c(this.f3517a).a(Log.getStackTraceString(e3)).a();
                        }
                    }
                }
            });
        }
    }

    private void startApplicationLauncher(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, context, str, str2) == null) {
            try {
                Intent parseUri = this.mPkgContent != null ? Intent.parseUri(this.mPkgContent, 0) : new Intent();
                String launcherActivityName = getLauncherActivityName(context, str);
                if (launcherActivityName != null) {
                    parseUri.setClassName(str, launcherActivityName);
                    parseUri.setFlags(parseUri.getFlags() | Label.FORWARD_REFERENCE_TYPE_SHORT);
                    parseUri.putExtra("open_type", 1);
                    parseUri.putExtra("msgid", str2);
                    context.startActivity(parseUri);
                }
            } catch (URISyntaxException e2) {
                com.baidu.android.pushservice.g.a.b(TAG, "error " + e2.getMessage(), context.getApplicationContext());
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public String getLauncherActivityName(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
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
        return (String) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handle(Context context, String str, String str2) {
        b.c cVar;
        PackageManager.NameNotFoundException nameNotFoundException;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2) == null) {
            com.baidu.android.pushservice.g.a.a(TAG, "--handle--", context.getApplicationContext());
            if ("com.baidu.pushservice.action.publicmsg.DELETE_V2".equals(str)) {
                com.baidu.android.pushservice.g.a.a(TAG, "Public msg deleted by user", context.getApplicationContext());
                sendResult(context, str2, 2);
                return;
            }
            PackageManager packageManager = context.getPackageManager();
            int i2 = 0;
            try {
                if (packageManager.getPackageInfo(this.mPkgName, 0).versionCode >= this.mPkgVercode) {
                    Intent parseUri = Intent.parseUri(this.mPkgContent, 0);
                    parseUri.setPackage(this.mPkgName);
                    if (packageManager.queryBroadcastReceivers(parseUri, 0).size() > 0) {
                        context.sendBroadcast(parseUri);
                    } else if (packageManager.queryIntentActivities(parseUri, 0).size() > 0) {
                        parseUri.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                        context.startActivity(parseUri);
                    }
                    i2 = 1;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                com.baidu.android.pushservice.g.a.b(TAG, "package not exist \r\n" + e2.getMessage(), context);
                cVar = new b.c(context);
                nameNotFoundException = e2;
                cVar.a(Log.getStackTraceString(nameNotFoundException)).a();
                if (i2 == 0) {
                }
                sendResult(context, str2, i2);
            } catch (URISyntaxException e3) {
                com.baidu.android.pushservice.g.a.b(TAG, "uri to intent fail \r\n" + e3.getMessage(), context);
                cVar = new b.c(context);
                nameNotFoundException = e3;
                cVar.a(Log.getStackTraceString(nameNotFoundException)).a();
                if (i2 == 0) {
                }
                sendResult(context, str2, i2);
            } catch (Exception e4) {
                com.baidu.android.pushservice.g.a.b(TAG, "parse customize action error\r\n" + e4.getMessage(), context);
                cVar = new b.c(context);
                nameNotFoundException = e4;
                cVar.a(Log.getStackTraceString(nameNotFoundException)).a();
                if (i2 == 0) {
                }
                sendResult(context, str2, i2);
            }
            if (i2 == 0) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(this.mUrl));
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                try {
                    context.startActivity(intent);
                } catch (ActivityNotFoundException e5) {
                    com.baidu.android.pushservice.g.a.b(TAG, ">>> Url cann't be deal! \r\n" + e5.getMessage(), context);
                    new b.c(context).a(Log.getStackTraceString(e5)).a();
                }
            }
            sendResult(context, str2, i2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v5, resolved type: android.content.pm.PackageManager$NameNotFoundException */
    /* JADX WARN: Multi-variable type inference failed */
    public void handlePrivateNotification(Context context, String str, String str2, String str3, byte[] bArr, byte[] bArr2) {
        b.c cVar;
        URISyntaxException uRISyntaxException;
        ActivityInfo activityInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, str, str2, str3, bArr, bArr2}) == null) {
            com.baidu.android.pushservice.g.a.a(TAG, "=== Handle private notification: " + str, context);
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
                    addCustomContentToIntent(context, intent);
                    com.baidu.android.pushservice.frequency.b.a().a(context, false, 0, intent.getStringExtra("extra_extra_custom_content"));
                    m.b(context, intent, "com.baidu.android.pushservice.action.notification.CLICK", this.mPkgName);
                    if (this.mOpenType == 1 && this.mUrl != null) {
                        Intent intent2 = new Intent();
                        intent2.setAction("android.intent.action.VIEW");
                        intent2.setData(Uri.parse(this.mUrl));
                        intent2.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
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
                                    parseUri.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                                    parseUri.putExtra("open_type", 1);
                                    parseUri.putExtra("msgid", str2);
                                    context.startActivity(parseUri);
                                }
                            }
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException e2) {
                com.baidu.android.pushservice.g.a.b(TAG, "package not exist \r\n" + e2.getMessage(), context);
                cVar = new b.c(context);
                uRISyntaxException = e2;
                cVar.a(Log.getStackTraceString(uRISyntaxException)).a();
            } catch (URISyntaxException e3) {
                com.baidu.android.pushservice.g.a.b(TAG, "uri to intent fail \r\n" + e3.getMessage(), context);
                cVar = new b.c(context);
                uRISyntaxException = e3;
                cVar.a(Log.getStackTraceString(uRISyntaxException)).a();
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "\r\n mMsgId = " + this.mMsgId + "\r\n mAppId = " + this.mAppId + "\r\n mTitle = " + this.mTitle + "\r\n mDescription = " + this.mDescription + "\r\n mUrl = " + this.mUrl + "\r\n mNetType = " + this.mNetType + "\r\n mSupportAppname = " + this.mSupportAppname + "\r\n mIsSupportApp = " + this.mIsSupportApp + "\r\n mPkgName = " + this.mPkgName + "\r\n mPlgVercode = " + this.mPkgVercode + "\r\n mNotificationBuilder = " + this.mNotificationBuilder + "\r\n mNotificationBasicStyle = " + this.mNotificationBasicStyle + "\r\n mOpenType = " + this.mOpenType + "\r\n mCustomContent = " + this.mCustomContent + "\r\n mIntent = " + this.mPkgContent + Part.CRLF;
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, parcel, i2) == null) {
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
}
