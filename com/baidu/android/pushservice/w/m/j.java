package com.baidu.android.pushservice.w.m;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.push.constant.RemoteMessageConst;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static PublicMsg a(Context context, String str, String str2, byte[] bArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, context, str, str2, bArr)) == null) {
            PublicMsg publicMsg = new PublicMsg();
            publicMsg.mMsgId = str;
            publicMsg.mAppId = str2;
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                if (!jSONObject.isNull("title")) {
                    publicMsg.mTitle = jSONObject.getString("title");
                }
                if (!jSONObject.isNull("description")) {
                    publicMsg.mDescription = jSONObject.getString("description");
                }
                if (!jSONObject.isNull("img")) {
                    publicMsg.mImgUrl = jSONObject.getString("img");
                }
                if (!jSONObject.isNull("summary")) {
                    publicMsg.mSummary = jSONObject.getString("summary");
                }
                if (!jSONObject.isNull("builder_res")) {
                    publicMsg.mBuilderRes = jSONObject.getString("builder_res");
                }
                if (!jSONObject.isNull("url")) {
                    publicMsg.mUrl = jSONObject.getString("url");
                }
                if (!jSONObject.isNull("notification_builder_id")) {
                    publicMsg.mNotificationBuilder = jSONObject.getInt("notification_builder_id");
                }
                if (!jSONObject.isNull("open_type")) {
                    publicMsg.mOpenType = jSONObject.getInt("open_type");
                }
                if (!jSONObject.isNull("notification_basic_style")) {
                    publicMsg.mNotificationBasicStyle = jSONObject.getInt("notification_basic_style");
                }
                if (!jSONObject.isNull("custom_content")) {
                    publicMsg.mCustomContent = jSONObject.getString("custom_content");
                }
                if (!jSONObject.isNull("net_support")) {
                    publicMsg.mNetType = jSONObject.getInt("net_support");
                }
                if (!jSONObject.isNull("app_situation")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("app_situation");
                    boolean z = true;
                    if (jSONObject2.getInt("as_is_support") != 1) {
                        z = false;
                    }
                    publicMsg.mIsSupportApp = z;
                    publicMsg.mSupportAppname = jSONObject2.getString("as_pkg_name");
                }
                if (!jSONObject.isNull(EmotionResourceInfo.JSON_KEY_PKG_NAME)) {
                    publicMsg.mPkgName = jSONObject.getString(EmotionResourceInfo.JSON_KEY_PKG_NAME);
                }
                if (!jSONObject.isNull("pkg_vercode")) {
                    publicMsg.mPkgVercode = jSONObject.getInt("pkg_vercode");
                }
                if (!jSONObject.isNull("pkg_content")) {
                    publicMsg.mPkgContent = jSONObject.getString("pkg_content");
                }
                if (jSONObject.isNull("group") || jSONObject.isNull("group_notifyid")) {
                    return publicMsg;
                }
                publicMsg.mGroup = jSONObject.getString("group");
                publicMsg.mGroupNotifyId = jSONObject.getInt("group_notifyid");
                return publicMsg;
            } catch (JSONException e) {
                com.baidu.android.pushservice.u.a.a("PublicMsgParser", e, context.getApplicationContext());
                return null;
            }
        }
        return (PublicMsg) invokeLLLL.objValue;
    }

    public static com.baidu.android.pushservice.w.i a(Context context, String str) {
        InterceptResult invokeLL;
        String string;
        String string2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            com.baidu.android.pushservice.w.i iVar = new com.baidu.android.pushservice.w.i();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull(RemoteMessageConst.MessageBody.MSG_CONTENT)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
                    if (!jSONObject2.isNull("adContent")) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("adContent");
                        iVar.e = jSONObject3.getString(RemoteMessageConst.Notification.NOTIFY_TITLE);
                        iVar.f = jSONObject3.getString("content");
                        if (!jSONObject3.isNull("param")) {
                            JSONObject jSONObject4 = jSONObject3.getJSONObject("param");
                            if (!jSONObject4.isNull("url")) {
                                iVar.a = jSONObject4.getString("url");
                            }
                            if (!jSONObject4.isNull(RemoteMessageConst.Notification.INTENT_URI)) {
                                string2 = jSONObject4.getString(RemoteMessageConst.Notification.INTENT_URI);
                            } else if (!jSONObject4.isNull(RemoteMessageConst.Notification.CLICK_ACTION)) {
                                string2 = jSONObject4.getString(RemoteMessageConst.Notification.CLICK_ACTION);
                            }
                            iVar.c = string2;
                        }
                    }
                    if (!jSONObject2.isNull(RemoteMessageConst.MessageBody.PS_CONTENT)) {
                        JSONObject jSONObject5 = jSONObject2.getJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
                        iVar.g = jSONObject5.getString(RemoteMessageConst.Notification.NOTIFY_TITLE);
                        iVar.h = jSONObject5.getString("content");
                        if (!jSONObject5.isNull("param")) {
                            JSONObject jSONObject6 = jSONObject5.getJSONObject("param");
                            if (!jSONObject6.isNull("url")) {
                                iVar.b = jSONObject6.getString("url");
                            }
                            if (!jSONObject6.isNull(RemoteMessageConst.Notification.INTENT_URI)) {
                                string = jSONObject6.getString(RemoteMessageConst.Notification.INTENT_URI);
                            } else if (!jSONObject6.isNull(RemoteMessageConst.Notification.CLICK_ACTION)) {
                                string = jSONObject6.getString(RemoteMessageConst.Notification.CLICK_ACTION);
                            }
                            iVar.d = string;
                        }
                    }
                    if (!jSONObject2.isNull("extras")) {
                        iVar.a(context, jSONObject2.getJSONArray("extras"));
                    }
                    if (TextUtils.isEmpty(iVar.j)) {
                        iVar.j = com.baidu.android.pushservice.a0.f.a(str.getBytes(), false);
                    }
                }
            } catch (Exception unused) {
            }
            return iVar;
        }
        return (com.baidu.android.pushservice.w.i) invokeLL.objValue;
    }
}
