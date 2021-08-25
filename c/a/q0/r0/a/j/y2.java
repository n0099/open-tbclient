package c.a.q0.r0.a.j;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityLocationAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: TiebaUtilityLocationAuto.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class y2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static /* synthetic */ void a(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityLocationAuto.DistanceResult distanceResult) {
        hashMap.put("result", distanceResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityLocationAuto.AppPosInfoResult appPosInfoResult) {
        hashMap.put("result", appPosInfoResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void c(TiebaUtilityLocationAuto.HostUtilityLocation hostUtilityLocation, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityLocation.requestDistance(TiebaUtilityLocationAuto.LocationParam.fromMap((HashMap) obj), new TiebaUtilityLocationAuto.Result() { // from class: c.a.q0.r0.a.j.j0
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityLocationAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        y2.a(hashMap, reply, (TiebaUtilityLocationAuto.DistanceResult) obj2);
                    }
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityLocationAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void d(TiebaUtilityLocationAuto.HostUtilityLocation hostUtilityLocation, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityLocation.getAppPosInfo(new TiebaUtilityLocationAuto.Result() { // from class: c.a.q0.r0.a.j.k0
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityLocationAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        y2.b(hashMap, reply, (TiebaUtilityLocationAuto.AppPosInfoResult) obj2);
                    }
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityLocationAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static void e(BinaryMessenger binaryMessenger, final TiebaUtilityLocationAuto.HostUtilityLocation hostUtilityLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, binaryMessenger, hostUtilityLocation) == null) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityLocation.requestDistance", new StandardMessageCodec());
            if (hostUtilityLocation != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: c.a.q0.r0.a.j.i0
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            y2.c(TiebaUtilityLocationAuto.HostUtilityLocation.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityLocation.getAppPosInfo", new StandardMessageCodec());
            if (hostUtilityLocation != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: c.a.q0.r0.a.j.h0
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            y2.d(TiebaUtilityLocationAuto.HostUtilityLocation.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
        }
    }
}
