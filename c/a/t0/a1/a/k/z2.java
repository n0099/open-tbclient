package c.a.t0.a1.a.k;

import com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityDataAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: TiebaUtilityDataAuto.java */
/* loaded from: classes6.dex */
public final /* synthetic */ class z2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static /* synthetic */ void a(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityDataAuto.LottieResult lottieResult) {
        hashMap.put("result", lottieResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(TiebaUtilityDataAuto.HostUtilityData hostUtilityData, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityData.getLottieBytes(TiebaUtilityDataAuto.GetLottieParam.fromMap((HashMap) obj), new TiebaUtilityDataAuto.Result() { // from class: c.a.t0.a1.a.k.f0
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityDataAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        z2.a(hashMap, reply, (TiebaUtilityDataAuto.LottieResult) obj2);
                    }
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityDataAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static void c(BinaryMessenger binaryMessenger, final TiebaUtilityDataAuto.HostUtilityData hostUtilityData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, binaryMessenger, hostUtilityData) == null) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityData.getLottieBytes", new StandardMessageCodec());
            if (hostUtilityData != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: c.a.t0.a1.a.k.g0
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            z2.b(TiebaUtilityDataAuto.HostUtilityData.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
        }
    }
}
