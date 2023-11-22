package com.baidu.android.pushservice.honorproxy;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.l.d;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.android.pushservice.z.c;
import com.baidu.android.pushservice.z.e;
import com.baidu.tieba.s4c;
import com.hihonor.push.sdk.HonorMessageService;
/* loaded from: classes.dex */
public class MyHonorMsgService extends HonorMessageService {

    /* loaded from: classes.dex */
    public class a extends c {
        public final /* synthetic */ String c;

        public a(String str) {
            this.c = str;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            if (!TextUtils.isEmpty(this.c) && d.l(MyHonorMsgService.this.getApplicationContext())) {
                com.baidu.android.pushservice.o.a.a(MyHonorMsgService.this.getApplicationContext()).a(this.c);
            }
        }
    }

    @Override // com.hihonor.push.sdk.HonorMessageService
    public void onMessageReceived(s4c s4cVar) {
        super.onMessageReceived(s4cVar);
        Intent intent = new Intent("com.honor.android.push.intent.RECEIVE");
        intent.putExtra("honor_pass_msg_content", s4cVar.a());
        intent.putExtra("honor_pass_msg_id", s4cVar.b());
        Utility.a(intent, getApplicationContext());
    }

    @Override // com.hihonor.push.sdk.HonorMessageService
    public void onNewToken(String str) {
        super.onNewToken(str);
        e.a().a(new a(str));
    }
}
