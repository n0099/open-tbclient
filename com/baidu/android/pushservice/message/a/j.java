package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.message.CrossPushMessage;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
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
                if (!jSONObject.isNull("pkg_name")) {
                    publicMsg.mPkgName = jSONObject.getString("pkg_name");
                }
                if (!jSONObject.isNull("pkg_vercode")) {
                    publicMsg.mPkgVercode = jSONObject.getInt("pkg_vercode");
                }
                if (jSONObject.isNull("pkg_content")) {
                    return publicMsg;
                }
                publicMsg.mPkgContent = jSONObject.getString("pkg_content");
                return publicMsg;
            } catch (JSONException e2) {
                com.baidu.android.pushservice.g.a.a("PublicMsgParser", e2, context.getApplicationContext());
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return null;
            }
        }
        return (PublicMsg) invokeLLLL.objValue;
    }

    public static com.baidu.android.pushservice.message.i a(Context context, String str) {
        InterceptResult invokeLL;
        String string;
        String string2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            com.baidu.android.pushservice.message.i iVar = new com.baidu.android.pushservice.message.i();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("msgContent")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("msgContent");
                    if (!jSONObject2.isNull("adContent")) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("adContent");
                        iVar.f35801e = jSONObject3.getString("notifyTitle");
                        iVar.f35802f = jSONObject3.getString("content");
                        if (!jSONObject3.isNull("param")) {
                            JSONObject jSONObject4 = jSONObject3.getJSONObject("param");
                            if (!jSONObject4.isNull("url")) {
                                iVar.f35797a = jSONObject4.getString("url");
                            }
                            if (!jSONObject4.isNull("intentUri")) {
                                string2 = jSONObject4.getString("intentUri");
                            } else if (!jSONObject4.isNull("acn")) {
                                string2 = jSONObject4.getString("acn");
                            }
                            iVar.f35799c = string2;
                        }
                    }
                    if (!jSONObject2.isNull("psContent")) {
                        JSONObject jSONObject5 = jSONObject2.getJSONObject("psContent");
                        iVar.f35803g = jSONObject5.getString("notifyTitle");
                        iVar.f35804h = jSONObject5.getString("content");
                        if (!jSONObject5.isNull("param")) {
                            JSONObject jSONObject6 = jSONObject5.getJSONObject("param");
                            if (!jSONObject6.isNull("url")) {
                                iVar.f35798b = jSONObject6.getString("url");
                            }
                            if (!jSONObject6.isNull("intentUri")) {
                                string = jSONObject6.getString("intentUri");
                            } else if (!jSONObject6.isNull("acn")) {
                                string = jSONObject6.getString("acn");
                            }
                            iVar.f35800d = string;
                        }
                    }
                    if (!jSONObject2.isNull("extras")) {
                        iVar.a(context, jSONObject2.getJSONArray("extras"));
                    }
                    if (TextUtils.isEmpty(iVar.j)) {
                        iVar.j = com.baidu.android.pushservice.j.f.a(str.getBytes(), false);
                    }
                }
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            }
            return iVar;
        }
        return (com.baidu.android.pushservice.message.i) invokeLL.objValue;
    }

    public static CrossPushMessage b(Context context, String str, String str2, byte[] bArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, str, str2, bArr)) == null) {
            CrossPushMessage crossPushMessage = new CrossPushMessage();
            crossPushMessage.mMsgId = str;
            crossPushMessage.mAppId = str2;
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                if (!jSONObject.isNull("title")) {
                    crossPushMessage.mTitle = jSONObject.getString("title");
                }
                if (!jSONObject.isNull("description")) {
                    crossPushMessage.mDescription = jSONObject.getString("description");
                }
                if (!jSONObject.isNull("open_type")) {
                    crossPushMessage.mOpenType = jSONObject.getInt("open_type");
                }
                if (!jSONObject.isNull("custom_content")) {
                    crossPushMessage.mCustomContent = jSONObject.getString("custom_content");
                }
                if (!jSONObject.isNull("pkg_name")) {
                    crossPushMessage.mPkgName = jSONObject.getString("pkg_name");
                }
                if (!jSONObject.isNull("pkg_content")) {
                    crossPushMessage.mPkgContent = jSONObject.getString("pkg_content");
                }
                if (!jSONObject.isNull("dest_pkg")) {
                    crossPushMessage.f35744a = jSONObject.getString("dest_pkg");
                }
                if (!jSONObject.isNull("dest_icon")) {
                    crossPushMessage.f35745b = jSONObject.getString("dest_icon");
                }
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            }
            return crossPushMessage;
        }
        return (CrossPushMessage) invokeLLLL.objValue;
    }
}
