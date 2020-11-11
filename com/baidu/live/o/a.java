package com.baidu.live.o;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private static Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.live.o.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            String str2;
            switch (message.what) {
                case 1:
                    String[] strArr = (String[]) message.obj;
                    String str3 = strArr[0];
                    String str4 = strArr[1];
                    if (strArr.length <= 2) {
                        str2 = "";
                    } else {
                        str2 = strArr[2];
                    }
                    a.m(str3, str4, str2, null);
                    return;
                case 2:
                    String[] strArr2 = (String[]) message.obj;
                    String str5 = strArr2[0];
                    String str6 = strArr2[1];
                    if (strArr2.length <= 2) {
                        str = "";
                    } else {
                        str = strArr2[2];
                    }
                    a.m(str5, str6, null, str);
                    return;
                default:
                    return;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(String str, String str2, String str3, String str4) {
        HttpMessage httpMessage = new HttpMessage(1021128);
        httpMessage.addParam("live_id", str);
        httpMessage.addParam("content_type", str2);
        if (!TextUtils.isEmpty(str4)) {
            httpMessage.addParam("ext_data", str4);
        } else if (!TextUtils.isEmpty(str3)) {
            httpMessage.addParam("ext", str3);
        }
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public static void aD(String str, String str2) {
        Message message = new Message();
        message.what = 1;
        message.obj = new String[]{str, str2};
        handler.sendMessage(message);
    }

    public static void a(String str, long j, long j2, String str2) {
        Message message = new Message();
        message.what = 1;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("live_id", str);
            jSONObject.put("red_packet_id", j + "");
            jSONObject.put("anchor_id", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put(LogConfig.LOG_AMOUNT, j2 + "");
        } catch (JSONException e) {
        }
        TbadkCoreApplication.getCurrentAccount();
        message.obj = new String[]{str, str2, Base64.encodeToString(jSONObject.toString().getBytes(), 0)};
        handler.sendMessage(message);
    }

    public static void init() {
        Log.d("NoticeHelper", "@@ init");
    }
}
