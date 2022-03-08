package c.a.r0.z0.a.k;

import com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityAbtestAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: TiebaUtilityAbtestAuto.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class v2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static /* synthetic */ void a(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityAbtestAuto.ExperimentType experimentType) {
        hashMap.put("result", experimentType.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(TiebaUtilityAbtestAuto.HostUtilityABTest hostUtilityABTest, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityABTest.experimentTypeForBarEntry(new TiebaUtilityAbtestAuto.Result() { // from class: c.a.r0.z0.a.k.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityAbtestAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        v2.a(hashMap, reply, (TiebaUtilityAbtestAuto.ExperimentType) obj2);
                    }
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityAbtestAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static void c(BinaryMessenger binaryMessenger, final TiebaUtilityAbtestAuto.HostUtilityABTest hostUtilityABTest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, binaryMessenger, hostUtilityABTest) == null) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityABTest.experimentTypeForBarEntry", new StandardMessageCodec());
            if (hostUtilityABTest != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: c.a.r0.z0.a.k.b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            v2.b(TiebaUtilityAbtestAuto.HostUtilityABTest.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
        }
    }
}
