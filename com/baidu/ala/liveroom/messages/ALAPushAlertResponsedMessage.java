package com.baidu.ala.liveroom.messages;

import alaim.AlaPushAlert.AlaPushAlertResIdl;
import alaim.AlaPushAlert.DataRes;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.squareup.wire.Wire;
import d.a.c.e.l.d;
import d.a.c.k.d.a;
import d.a.n0.a0.c;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ALAPushAlertResponsedMessage extends SocketResponsedMessage {
    public Handler mHandler;

    public ALAPushAlertResponsedMessage() {
        super(AlaCmdConfigSocket.ALA_SOCKET_PUSH_ALERT);
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        String str;
        String str2;
        AlaPushAlertResIdl alaPushAlertResIdl = (AlaPushAlertResIdl) new Wire(new Class[0]).parseFrom(bArr, AlaPushAlertResIdl.class);
        DataRes dataRes = alaPushAlertResIdl.data;
        if (dataRes == null || dataRes.msgInfo == null || dataRes.ext == null) {
            return;
        }
        Intent intent = new Intent(TbadkCoreApplication.getInst(), DealIntentService.class);
        intent.putExtra(DealIntentService.KEY_CLASS, 30);
        JSONObject jSONObject = new JSONObject(alaPushAlertResIdl.data.ext);
        String optString = jSONObject.optString("url");
        final long optLong = jSONObject.optLong("live_auth_user_id", 0L);
        int optInt = jSONObject.optInt("ala_msg_type", 0);
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        if (optInt != 126 || optLong > 0) {
            if (optInt == 127) {
                intent.putExtra(DealIntentService.KEY_CLASS, 1);
                int optInt2 = jSONObject.optInt("video_channel_id", 0);
                intent.putExtra("video_channel_id", optInt2);
                intent.putExtra("id", jSONObject.optString("tid"));
                TiebaStatic.log(new StatisticItem("c11917").param("obj_id", optInt2));
            } else if (optInt == 126) {
                TiebaStatic.log(new StatisticItem("c12100"));
                intent.putExtra("is_live", 1);
                intent.putExtra("is_live_lcs", 1);
            }
            intent.putExtra("jump_url", optString);
            final PendingIntent service = PendingIntent.getService(TbadkCoreApplication.getInst().getApplicationContext(), 0, intent, 134217728);
            if (optInt == 126) {
                String optString2 = jSONObject.optString("title");
                String optString3 = jSONObject.optString("content");
                final String optString4 = jSONObject.optString("image");
                if (StringUtils.isNull(optString3)) {
                    str2 = alaPushAlertResIdl.data.msgInfo.content;
                    str = "";
                } else {
                    str = optString2;
                    str2 = optString3;
                }
                if (StringUtils.isNull(str2)) {
                    return;
                }
                c k = c.k();
                a m = k.m(optString4 + 10);
                if (m != null && m.p() != null) {
                    NotificationHelper.showLargeIconNotification(TbadkCoreApplication.getInst().getApplicationContext(), Long.valueOf(optLong).hashCode(), str, str2, str2, service, m.p(), false);
                    return;
                } else if (!StringUtils.isNull(optString4)) {
                    final String str3 = str;
                    final String str4 = str2;
                    this.mHandler.post(new Runnable() { // from class: com.baidu.ala.liveroom.messages.ALAPushAlertResponsedMessage.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.h().m(optString4, 10, new d.a.c.e.l.c<a>() { // from class: com.baidu.ala.liveroom.messages.ALAPushAlertResponsedMessage.1.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // d.a.c.e.l.c
                                public void onLoaded(a aVar, String str5, int i3) {
                                    super.onLoaded((C00231) aVar, str5, i3);
                                    if (aVar != null && aVar.p() != null) {
                                        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
                                        int hashCode = Long.valueOf(optLong).hashCode();
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        String str6 = str3;
                                        String str7 = str4;
                                        NotificationHelper.showLargeIconNotification(applicationContext, hashCode, str6, str7, str7, service, aVar.p(), false);
                                        return;
                                    }
                                    Context applicationContext2 = TbadkCoreApplication.getInst().getApplicationContext();
                                    int hashCode2 = Long.valueOf(optLong).hashCode();
                                    AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                    String str8 = str3;
                                    String str9 = str4;
                                    NotificationHelper.showNotification(applicationContext2, hashCode2, str8, str9, str9, service, false);
                                }
                            }, null);
                        }
                    });
                    return;
                } else {
                    NotificationHelper.showNotification(TbadkCoreApplication.getInst().getApplicationContext(), Long.valueOf(optLong).hashCode(), str, str2, str2, service, false);
                    return;
                }
            }
            String str5 = alaPushAlertResIdl.data.msgInfo.content;
            if (StringUtils.isNull(str5)) {
                return;
            }
            NotificationHelper.showNotification(TbadkCoreApplication.getInst().getApplicationContext(), Long.valueOf(optLong).hashCode(), "", str5, str5, service, false);
        }
    }
}
