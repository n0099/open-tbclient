package b.a.r0.t0.a.k;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityPreferenceAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: TiebaUtilityPreferenceAuto.java */
/* loaded from: classes5.dex */
public final /* synthetic */ class e3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static /* synthetic */ void a(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityPreferenceAuto.KVResult kVResult) {
        hashMap.put("result", kVResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityPreferenceAuto.SuccessResult successResult) {
        hashMap.put("result", successResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void c(TiebaUtilityPreferenceAuto.HostUtilityPreference hostUtilityPreference, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityPreference.preferenceGetValues(TiebaUtilityPreferenceAuto.GetPreferenceParam.fromMap((HashMap) obj), new TiebaUtilityPreferenceAuto.Result() { // from class: b.a.r0.t0.a.k.q1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityPreferenceAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        e3.a(hashMap, reply, (TiebaUtilityPreferenceAuto.KVResult) obj2);
                    }
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityPreferenceAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void d(TiebaUtilityPreferenceAuto.HostUtilityPreference hostUtilityPreference, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityPreference.preferenceSetValues(TiebaUtilityPreferenceAuto.SetPreferenceParam.fromMap((HashMap) obj), new TiebaUtilityPreferenceAuto.Result() { // from class: b.a.r0.t0.a.k.t1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityPreferenceAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        e3.b(hashMap, reply, (TiebaUtilityPreferenceAuto.SuccessResult) obj2);
                    }
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityPreferenceAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static void e(BinaryMessenger binaryMessenger, final TiebaUtilityPreferenceAuto.HostUtilityPreference hostUtilityPreference) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, binaryMessenger, hostUtilityPreference) == null) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityPreference.preferenceGetValues", new StandardMessageCodec());
            if (hostUtilityPreference != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: b.a.r0.t0.a.k.s1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            e3.c(TiebaUtilityPreferenceAuto.HostUtilityPreference.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityPreference.preferenceSetValues", new StandardMessageCodec());
            if (hostUtilityPreference != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: b.a.r0.t0.a.k.r1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            e3.d(TiebaUtilityPreferenceAuto.HostUtilityPreference.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
        }
    }
}
