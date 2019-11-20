package com.baidu.ala.liveroom.messages;

import alaim.AlaPushAlert.AlaPushAlertResIdl;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.a;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.imageManager.c;
import com.squareup.wire.Wire;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ALAPushAlertResponsedMessage extends SocketResponsedMessage {
    private Handler mHandler;

    public ALAPushAlertResponsedMessage() {
        super(AlaCmdConfigSocket.ALA_SOCKET_PUSH_ALERT);
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        AlaPushAlertResIdl alaPushAlertResIdl = (AlaPushAlertResIdl) new Wire(new Class[0]).parseFrom(bArr, AlaPushAlertResIdl.class);
        if (alaPushAlertResIdl.data != null && alaPushAlertResIdl.data.msgInfo != null && alaPushAlertResIdl.data.ext != null) {
            Intent intent = new Intent(TbadkCoreApplication.getInst(), DealIntentService.class);
            intent.putExtra(DealIntentService.KEY_CLASS, 30);
            JSONObject jSONObject = new JSONObject(alaPushAlertResIdl.data.ext);
            String optString = jSONObject.optString("url");
            final long optLong = jSONObject.optLong("live_auth_user_id", 0L);
            int optInt = jSONObject.optInt("ala_msg_type", 0);
            if (!TextUtils.isEmpty(optString)) {
                if (optInt != 126 || optLong > 0) {
                    if (optInt == 127) {
                        intent.putExtra(DealIntentService.KEY_CLASS, 1);
                        int optInt2 = jSONObject.optInt("video_channel_id", 0);
                        intent.putExtra("video_channel_id", optInt2);
                        intent.putExtra("id", jSONObject.optString("tid"));
                        TiebaStatic.log(new an("c11917").O("obj_id", optInt2));
                    } else if (optInt == 126) {
                        TiebaStatic.log(new an("c12100"));
                        intent.putExtra("is_live", 1);
                        intent.putExtra("is_live_lcs", 1);
                    }
                    intent.putExtra(BigdayActivityConfig.JUMP_URL, optString);
                    final PendingIntent service = PendingIntent.getService(TbadkCoreApplication.getInst().getApplicationContext(), 0, intent, 134217728);
                    if (optInt == 126) {
                        String optString2 = jSONObject.optString("title");
                        String optString3 = jSONObject.optString("content");
                        final String optString4 = jSONObject.optString("image");
                        if (StringUtils.isNull(optString3)) {
                            optString3 = alaPushAlertResIdl.data.msgInfo.content;
                            optString2 = "";
                        }
                        if (!StringUtils.isNull(optString3)) {
                            a pY = c.avs().pY(optString4 + 10);
                            if (pY != null && pY.getRawBitmap() != null) {
                                NotificationHelper.showLargeIconNotification(TbadkCoreApplication.getInst().getApplicationContext(), Long.valueOf(optLong).hashCode(), optString2, optString3, optString3, service, pY.getRawBitmap(), false);
                                return;
                            } else if (!StringUtils.isNull(optString4)) {
                                final String str = optString2;
                                final String str2 = optString3;
                                this.mHandler.post(new Runnable() { // from class: com.baidu.ala.liveroom.messages.ALAPushAlertResponsedMessage.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.baidu.adp.lib.f.c.fT().a(optString4, 10, new b<a>() { // from class: com.baidu.ala.liveroom.messages.ALAPushAlertResponsedMessage.1.1
                                            /* JADX DEBUG: Method merged with bridge method */
                                            /* JADX INFO: Access modifiers changed from: protected */
                                            @Override // com.baidu.adp.lib.f.b
                                            public void onLoaded(a aVar, String str3, int i2) {
                                                super.onLoaded((C00301) aVar, str3, i2);
                                                if (aVar != null && aVar.getRawBitmap() != null) {
                                                    NotificationHelper.showLargeIconNotification(TbadkCoreApplication.getInst().getApplicationContext(), Long.valueOf(optLong).hashCode(), str, str2, str2, service, aVar.getRawBitmap(), false);
                                                } else {
                                                    NotificationHelper.showNotification(TbadkCoreApplication.getInst().getApplicationContext(), Long.valueOf(optLong).hashCode(), str, str2, str2, service, false);
                                                }
                                            }
                                        }, null);
                                    }
                                });
                                return;
                            } else {
                                NotificationHelper.showNotification(TbadkCoreApplication.getInst().getApplicationContext(), Long.valueOf(optLong).hashCode(), optString2, optString3, optString3, service, false);
                                return;
                            }
                        }
                        return;
                    }
                    String str3 = alaPushAlertResIdl.data.msgInfo.content;
                    if (!StringUtils.isNull(str3)) {
                        NotificationHelper.showNotification(TbadkCoreApplication.getInst().getApplicationContext(), Long.valueOf(optLong).hashCode(), "", str3, str3, service, false);
                    }
                }
            }
        }
    }
}
