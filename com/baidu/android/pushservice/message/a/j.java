package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.message.PublicMsg;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class j {
    public static PublicMsg a(Context context, String str, String str2, byte[] bArr) {
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
                publicMsg.mIsSupportApp = jSONObject2.getInt("as_is_support") == 1;
                publicMsg.mSupportAppname = jSONObject2.getString("as_pkg_name");
            }
            if (!jSONObject.isNull(PushConstants.PACKAGE_NAME)) {
                publicMsg.mPkgName = jSONObject.getString(PushConstants.PACKAGE_NAME);
            }
            if (!jSONObject.isNull("pkg_vercode")) {
                publicMsg.mPkgVercode = jSONObject.getInt("pkg_vercode");
            }
            if (jSONObject.isNull("pkg_content")) {
                return publicMsg;
            }
            publicMsg.mPkgContent = jSONObject.getString("pkg_content");
            return publicMsg;
        } catch (JSONException e) {
            com.baidu.android.pushservice.g.a.a("PublicMsgParser", e, context.getApplicationContext());
            return null;
        }
    }

    public static com.baidu.android.pushservice.message.i a(Context context, String str) {
        com.baidu.android.pushservice.message.i iVar = new com.baidu.android.pushservice.message.i();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("msgContent")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("msgContent");
                if (!jSONObject2.isNull("adContent")) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("adContent");
                    iVar.e = jSONObject3.getString("notifyTitle");
                    iVar.f = jSONObject3.getString("content");
                    if (!jSONObject3.isNull("param")) {
                        JSONObject jSONObject4 = jSONObject3.getJSONObject("param");
                        if (!jSONObject4.isNull("url")) {
                            iVar.a = jSONObject4.getString("url");
                        }
                        if (!jSONObject4.isNull("intentUri")) {
                            iVar.c = jSONObject4.getString("intentUri");
                        } else if (!jSONObject4.isNull("acn")) {
                            iVar.c = jSONObject4.getString("acn");
                        }
                    }
                }
                if (!jSONObject2.isNull("psContent")) {
                    JSONObject jSONObject5 = jSONObject2.getJSONObject("psContent");
                    iVar.g = jSONObject5.getString("notifyTitle");
                    iVar.h = jSONObject5.getString("content");
                    if (!jSONObject5.isNull("param")) {
                        JSONObject jSONObject6 = jSONObject5.getJSONObject("param");
                        if (!jSONObject6.isNull("url")) {
                            iVar.b = jSONObject6.getString("url");
                        }
                        if (!jSONObject6.isNull("intentUri")) {
                            iVar.d = jSONObject6.getString("intentUri");
                        } else if (!jSONObject6.isNull("acn")) {
                            iVar.d = jSONObject6.getString("acn");
                        }
                    }
                }
                if (!jSONObject2.isNull("extras")) {
                    iVar.a(jSONObject2.getJSONArray("extras"));
                }
                if (TextUtils.isEmpty(iVar.l)) {
                    iVar.l = com.baidu.android.pushservice.k.f.a(str.getBytes(), false);
                }
            }
        } catch (Exception e) {
        }
        return iVar;
    }
}
