package c.a.r0.z0.a.k;

import com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilitySettingsAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: TiebaUtilitySettingsAuto.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class f3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static /* synthetic */ void a(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilitySettingsAuto.PhotoHostResult photoHostResult) {
        hashMap.put("result", photoHostResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilitySettingsAuto.PhotoHostResult photoHostResult) {
        hashMap.put("result", photoHostResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void c(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilitySettingsAuto.PrivateStatResult privateStatResult) {
        hashMap.put("result", privateStatResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void d(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilitySettingsAuto.PrivateStatResult privateStatResult) {
        hashMap.put("result", privateStatResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void e(TiebaUtilitySettingsAuto.HostUtilitySettings hostUtilitySettings, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilitySettings.getUserSmallPhotoHost(new TiebaUtilitySettingsAuto.Result() { // from class: c.a.r0.z0.a.k.x1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilitySettingsAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        f3.a(hashMap, reply, (TiebaUtilitySettingsAuto.PhotoHostResult) obj2);
                    }
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilitySettingsAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void f(TiebaUtilitySettingsAuto.HostUtilitySettings hostUtilitySettings, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilitySettings.getUserBigPhotoHost(new TiebaUtilitySettingsAuto.Result() { // from class: c.a.r0.z0.a.k.v1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilitySettingsAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        f3.b(hashMap, reply, (TiebaUtilitySettingsAuto.PhotoHostResult) obj2);
                    }
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilitySettingsAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void g(TiebaUtilitySettingsAuto.HostUtilitySettings hostUtilitySettings, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilitySettings.getMyPrivateStat(TiebaUtilitySettingsAuto.GetPrivateStatParam.fromMap((HashMap) obj), new TiebaUtilitySettingsAuto.Result() { // from class: c.a.r0.z0.a.k.u1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilitySettingsAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        f3.c(hashMap, reply, (TiebaUtilitySettingsAuto.PrivateStatResult) obj2);
                    }
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilitySettingsAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void h(TiebaUtilitySettingsAuto.HostUtilitySettings hostUtilitySettings, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilitySettings.setMyPrivateStat(TiebaUtilitySettingsAuto.SetPrivateStatParam.fromMap((HashMap) obj), new TiebaUtilitySettingsAuto.Result() { // from class: c.a.r0.z0.a.k.a2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilitySettingsAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        f3.d(hashMap, reply, (TiebaUtilitySettingsAuto.PrivateStatResult) obj2);
                    }
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilitySettingsAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static void i(BinaryMessenger binaryMessenger, final TiebaUtilitySettingsAuto.HostUtilitySettings hostUtilitySettings) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, binaryMessenger, hostUtilitySettings) == null) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilitySettings.getUserSmallPhotoHost", new StandardMessageCodec());
            if (hostUtilitySettings != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: c.a.r0.z0.a.k.y1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            f3.e(TiebaUtilitySettingsAuto.HostUtilitySettings.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilitySettings.getUserBigPhotoHost", new StandardMessageCodec());
            if (hostUtilitySettings != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: c.a.r0.z0.a.k.b2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            f3.f(TiebaUtilitySettingsAuto.HostUtilitySettings.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilitySettings.getMyPrivateStat", new StandardMessageCodec());
            if (hostUtilitySettings != null) {
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: c.a.r0.z0.a.k.z1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            f3.g(TiebaUtilitySettingsAuto.HostUtilitySettings.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilitySettings.setMyPrivateStat", new StandardMessageCodec());
            if (hostUtilitySettings != null) {
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: c.a.r0.z0.a.k.w1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            f3.h(TiebaUtilitySettingsAuto.HostUtilitySettings.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
        }
    }
}
