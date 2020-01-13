package com.baidu.live.k;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static Handler handler = new Handler() { // from class: com.baidu.live.k.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            switch (message.what) {
                case 1:
                    String[] strArr = (String[]) message.obj;
                    String str2 = strArr[0];
                    String str3 = strArr[1];
                    if (strArr.length <= 2) {
                        str = "";
                    } else {
                        str = strArr[2];
                    }
                    HttpMessage httpMessage = new HttpMessage(1021128);
                    httpMessage.addParam("live_id", str2);
                    httpMessage.addParam("content_type", str3);
                    if (!TextUtils.isEmpty(str)) {
                        httpMessage.addParam("ext", str);
                    }
                    MessageManager.getInstance().sendMessage(httpMessage);
                    return;
                default:
                    return;
            }
        }
    };

    public static void U(String str, String str2) {
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
    }
}
