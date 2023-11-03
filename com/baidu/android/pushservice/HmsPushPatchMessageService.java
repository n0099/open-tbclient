package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.util.Utility;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class HmsPushPatchMessageService extends HmsMessageService {

    /* loaded from: classes.dex */
    public class a extends com.baidu.android.pushservice.z.c {
        public final /* synthetic */ String c;

        /* renamed from: com.baidu.android.pushservice.HmsPushPatchMessageService$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0022a extends com.baidu.android.pushservice.z.c {
            public C0022a() {
            }

            @Override // com.baidu.android.pushservice.z.c
            public void a() {
                com.baidu.android.pushservice.o.a.a(HmsPushPatchMessageService.this.getApplicationContext()).b(a.this.c);
            }
        }

        public a(String str) {
            this.c = str;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            if (!PushSettings.i(HmsPushPatchMessageService.this.getApplicationContext()) || Build.VERSION.SDK_INT >= 29) {
                try {
                    if (com.baidu.android.pushservice.l.d.m(HmsPushPatchMessageService.this.getApplicationContext()) && !TextUtils.isEmpty(this.c)) {
                        e.a(HmsPushPatchMessageService.this.getApplicationContext(), this.c, 5);
                    }
                    if (com.baidu.android.pushservice.l.d.l(HmsPushPatchMessageService.this.getApplicationContext())) {
                        com.baidu.android.pushservice.z.e.a().a(new C0022a());
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public final void a(Context context, RemoteMessage remoteMessage) {
        try {
            String data = remoteMessage.getData();
            TextUtils.isEmpty(data);
            Map<String, String> dataOfMap = remoteMessage.getDataOfMap();
            if (TextUtils.isEmpty(data) && dataOfMap != null && !dataOfMap.isEmpty()) {
                data = new JSONObject(dataOfMap).toString();
            }
            if (TextUtils.isEmpty(data)) {
                return;
            }
            Intent intent = new Intent("com.huawei.android.push.intent.RECEIVE");
            intent.putExtra("IS_HMS_PASS_MSG_KEY", true);
            intent.putExtra("HMS_PASS_MSG_VALUE_KEY", data);
            Utility.a(intent, context.getApplicationContext());
        } catch (Exception unused) {
        }
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onDeletedMessages() {
        super.onDeletedMessages();
    }

    @Override // com.huawei.hms.push.HmsMessageService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        if (!PushSettings.i(getApplicationContext()) || Build.VERSION.SDK_INT >= 29) {
            a(this, remoteMessage);
        }
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onMessageSent(String str) {
        super.onMessageSent(str);
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onNewToken(String str) {
        super.onNewToken(str);
        com.baidu.android.pushservice.z.e.a().a(new a(str));
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onSendError(String str, Exception exc) {
        super.onSendError(str, exc);
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onTokenError(Exception exc) {
        super.onTokenError(exc);
    }
}
