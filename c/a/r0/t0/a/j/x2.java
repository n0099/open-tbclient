package c.a.r0.t0.a.j;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityAppInfoAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: TiebaUtilityAppInfoAuto.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class x2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static /* synthetic */ void a(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityAppInfoAuto.AppInfoStringResult appInfoStringResult) {
        hashMap.put("result", appInfoStringResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityAppInfoAuto.AppInfoStringResult appInfoStringResult) {
        hashMap.put("result", appInfoStringResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void c(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityAppInfoAuto.ChannelTab channelTab) {
        hashMap.put("result", channelTab.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void d(TiebaUtilityAppInfoAuto.HostUtilityAppInfo hostUtilityAppInfo, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityAppInfo.getAppVersion(new TiebaUtilityAppInfoAuto.Result() { // from class: c.a.r0.t0.a.j.m
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityAppInfoAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        x2.a(hashMap, reply, (TiebaUtilityAppInfoAuto.AppInfoStringResult) obj2);
                    }
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityAppInfoAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void e(TiebaUtilityAppInfoAuto.HostUtilityAppInfo hostUtilityAppInfo, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityAppInfo.getWebViewUserAgent(new TiebaUtilityAppInfoAuto.Result() { // from class: c.a.r0.t0.a.j.i
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityAppInfoAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        x2.b(hashMap, reply, (TiebaUtilityAppInfoAuto.AppInfoStringResult) obj2);
                    }
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityAppInfoAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void f(TiebaUtilityAppInfoAuto.HostUtilityAppInfo hostUtilityAppInfo, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityAppInfo.getChannelTabInfo(new TiebaUtilityAppInfoAuto.Result() { // from class: c.a.r0.t0.a.j.l
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityAppInfoAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        x2.c(hashMap, reply, (TiebaUtilityAppInfoAuto.ChannelTab) obj2);
                    }
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityAppInfoAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static void g(BinaryMessenger binaryMessenger, final TiebaUtilityAppInfoAuto.HostUtilityAppInfo hostUtilityAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, binaryMessenger, hostUtilityAppInfo) == null) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityAppInfo.getAppVersion", new StandardMessageCodec());
            if (hostUtilityAppInfo != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: c.a.r0.t0.a.j.k
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            x2.d(TiebaUtilityAppInfoAuto.HostUtilityAppInfo.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityAppInfo.getWebViewUserAgent", new StandardMessageCodec());
            if (hostUtilityAppInfo != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: c.a.r0.t0.a.j.j
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            x2.e(TiebaUtilityAppInfoAuto.HostUtilityAppInfo.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityAppInfo.getChannelTabInfo", new StandardMessageCodec());
            if (hostUtilityAppInfo != null) {
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: c.a.r0.t0.a.j.n
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            x2.f(TiebaUtilityAppInfoAuto.HostUtilityAppInfo.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
        }
    }
}
