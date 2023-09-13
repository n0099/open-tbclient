package com.baidu.ala.liveroom.messages;

import alaim.AlaPushAlert.AlaPushAlertResIdl;
import alaim.AlaPushAlert.DataRes;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ALAPushAlertResponsedMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler mHandler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ALAPushAlertResponsedMessage() {
        super(AlaCmdConfigSocket.ALA_SOCKET_PUSH_ALERT);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            AlaPushAlertResIdl alaPushAlertResIdl = (AlaPushAlertResIdl) new Wire(new Class[0]).parseFrom(bArr, AlaPushAlertResIdl.class);
            DataRes dataRes = alaPushAlertResIdl.data;
            if (dataRes != null && dataRes.msgInfo != null && dataRes.ext != null) {
                Intent intent = new Intent(TbadkCoreApplication.getInst(), DealIntentService.class);
                intent.putExtra("class", 30);
                JSONObject jSONObject = new JSONObject(alaPushAlertResIdl.data.ext);
                String optString = jSONObject.optString("url");
                long optLong = jSONObject.optLong("live_auth_user_id", 0L);
                int optInt = jSONObject.optInt("ala_msg_type", 0);
                if (TextUtils.isEmpty(optString)) {
                    return alaPushAlertResIdl;
                }
                if (optInt == 126 && optLong <= 0) {
                    return alaPushAlertResIdl;
                }
                if (optInt == 127) {
                    intent.putExtra("class", 1);
                    int optInt2 = jSONObject.optInt("video_channel_id", 0);
                    intent.putExtra("video_channel_id", optInt2);
                    intent.putExtra("id", jSONObject.optString("tid"));
                    TiebaStatic.log(new StatisticItem("c11917").param("obj_id", optInt2));
                } else if (optInt == 126) {
                    TiebaStatic.log(new StatisticItem("c12100"));
                    intent.putExtra("is_live", 1);
                    intent.putExtra("is_live_lcs", 1);
                }
                intent.putExtra(BigdayActivityConfig.JUMP_URL, optString);
                PendingIntent service = PendingIntent.getService(TbadkCoreApplication.getInst().getApplicationContext(), 0, intent, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
                if (optInt == 126) {
                    String optString2 = jSONObject.optString("title");
                    String optString3 = jSONObject.optString("content");
                    String optString4 = jSONObject.optString("image");
                    if (StringUtils.isNull(optString3)) {
                        str2 = alaPushAlertResIdl.data.msgInfo.content;
                        str = "";
                    } else {
                        str = optString2;
                        str2 = optString3;
                    }
                    if (StringUtils.isNull(str2)) {
                        return alaPushAlertResIdl;
                    }
                    TbImageMemoryCache A = TbImageMemoryCache.A();
                    BdImage D = A.D(optString4 + 10);
                    if (D != null && D.getRawBitmap() != null) {
                        NotificationHelper.showLargeIconNotification(TbadkCoreApplication.getInst().getApplicationContext(), Long.valueOf(optLong).hashCode(), str, str2, str2, service, D.getRawBitmap(), false);
                    } else if (!StringUtils.isNull(optString4)) {
                        this.mHandler.post(new Runnable(this, optString4, optLong, str, str2, service) { // from class: com.baidu.ala.liveroom.messages.ALAPushAlertResponsedMessage.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ALAPushAlertResponsedMessage this$0;
                            public final /* synthetic */ String val$fContent;
                            public final /* synthetic */ PendingIntent val$fContentIntent;
                            public final /* synthetic */ String val$fImage;
                            public final /* synthetic */ String val$fTitle;
                            public final /* synthetic */ long val$uid;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, optString4, Long.valueOf(optLong), str, str2, service};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$fImage = optString4;
                                this.val$uid = optLong;
                                this.val$fTitle = str;
                                this.val$fContent = str2;
                                this.val$fContentIntent = service;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    BdResourceLoader.getInstance().loadResource(this.val$fImage, 10, new BdResourceCallback<BdImage>(this) { // from class: com.baidu.ala.liveroom.messages.ALAPushAlertResponsedMessage.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass1 this$1;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$1 = this;
                                        }

                                        /* JADX DEBUG: Method merged with bridge method */
                                        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
                                        public void onLoaded(BdImage bdImage, String str3, int i2) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeLLI(1048576, this, bdImage, str3, i2) == null) {
                                                super.onLoaded((C00061) bdImage, str3, i2);
                                                if (bdImage != null && bdImage.getRawBitmap() != null) {
                                                    Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
                                                    int hashCode = Long.valueOf(this.this$1.val$uid).hashCode();
                                                    AnonymousClass1 anonymousClass1 = this.this$1;
                                                    String str4 = anonymousClass1.val$fTitle;
                                                    String str5 = anonymousClass1.val$fContent;
                                                    NotificationHelper.showLargeIconNotification(applicationContext, hashCode, str4, str5, str5, anonymousClass1.val$fContentIntent, bdImage.getRawBitmap(), false);
                                                    return;
                                                }
                                                Context applicationContext2 = TbadkCoreApplication.getInst().getApplicationContext();
                                                int hashCode2 = Long.valueOf(this.this$1.val$uid).hashCode();
                                                AnonymousClass1 anonymousClass12 = this.this$1;
                                                String str6 = anonymousClass12.val$fTitle;
                                                String str7 = anonymousClass12.val$fContent;
                                                NotificationHelper.showNotification(applicationContext2, hashCode2, str6, str7, str7, anonymousClass12.val$fContentIntent, false);
                                            }
                                        }
                                    }, null);
                                }
                            }
                        });
                    } else {
                        NotificationHelper.showNotification(TbadkCoreApplication.getInst().getApplicationContext(), Long.valueOf(optLong).hashCode(), str, str2, str2, service, false);
                    }
                } else {
                    String str3 = alaPushAlertResIdl.data.msgInfo.content;
                    if (StringUtils.isNull(str3)) {
                        return alaPushAlertResIdl;
                    }
                    NotificationHelper.showNotification(TbadkCoreApplication.getInst().getApplicationContext(), Long.valueOf(optLong).hashCode(), "", str3, str3, service, false);
                }
                return alaPushAlertResIdl;
            }
            return alaPushAlertResIdl;
        }
        return invokeIL.objValue;
    }
}
