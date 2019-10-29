package com.baidu.live.f;

import android.os.Handler;
import android.os.Message;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes6.dex */
public class a {
    private static Handler handler = new Handler() { // from class: com.baidu.live.f.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    String[] strArr = (String[]) message.obj;
                    String str = strArr[0];
                    String str2 = strArr[1];
                    HttpMessage httpMessage = new HttpMessage(1021128);
                    httpMessage.addParam("live_id", str);
                    httpMessage.addParam("content_type", str2);
                    MessageManager.getInstance().sendMessage(httpMessage);
                    return;
                default:
                    return;
            }
        }
    };

    public static void N(String str, String str2) {
        Message message = new Message();
        message.what = 1;
        message.obj = new String[]{str, str2};
        handler.sendMessage(message);
    }

    public static void init() {
    }
}
