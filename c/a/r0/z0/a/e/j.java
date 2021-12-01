package c.a.r0.z0.a.e;

import com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: NetworkInfoAuto.java */
/* loaded from: classes7.dex */
public final /* synthetic */ class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static /* synthetic */ void a(HashMap hashMap, BasicMessageChannel.Reply reply, NetworkInfoAuto.NetWorkAvailable netWorkAvailable) {
        hashMap.put("result", netWorkAvailable.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(HashMap hashMap, BasicMessageChannel.Reply reply, NetworkInfoAuto.NetWorkAvailable netWorkAvailable) {
        hashMap.put("result", netWorkAvailable.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void c(HashMap hashMap, BasicMessageChannel.Reply reply, NetworkInfoAuto.NetworkStatus networkStatus) {
        hashMap.put("result", networkStatus.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void d(HashMap hashMap, BasicMessageChannel.Reply reply, NetworkInfoAuto.DnsIpResult dnsIpResult) {
        hashMap.put("result", dnsIpResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void e(NetworkInfoAuto.HostNetworkInfo hostNetworkInfo, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostNetworkInfo.isNetWorkAvailable(new NetworkInfoAuto.Result() { // from class: c.a.r0.z0.a.e.c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        j.a(hashMap, reply, (NetworkInfoAuto.NetWorkAvailable) obj2);
                    }
                }
            });
        } catch (Exception e2) {
            wrapError = NetworkInfoAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void f(NetworkInfoAuto.HostNetworkInfo hostNetworkInfo, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostNetworkInfo.isNetworkAvailableForImmediately(new NetworkInfoAuto.Result() { // from class: c.a.r0.z0.a.e.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        j.b(hashMap, reply, (NetworkInfoAuto.NetWorkAvailable) obj2);
                    }
                }
            });
        } catch (Exception e2) {
            wrapError = NetworkInfoAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void g(NetworkInfoAuto.HostNetworkInfo hostNetworkInfo, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostNetworkInfo.getNetInfo(new NetworkInfoAuto.Result() { // from class: c.a.r0.z0.a.e.f
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        j.c(hashMap, reply, (NetworkInfoAuto.NetworkStatus) obj2);
                    }
                }
            });
        } catch (Exception e2) {
            wrapError = NetworkInfoAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void h(NetworkInfoAuto.HostNetworkInfo hostNetworkInfo, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostNetworkInfo.getDnsIp(NetworkInfoAuto.DnsUrl.fromMap((HashMap) obj), new NetworkInfoAuto.Result() { // from class: c.a.r0.z0.a.e.e
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        j.d(hashMap, reply, (NetworkInfoAuto.DnsIpResult) obj2);
                    }
                }
            });
        } catch (Exception e2) {
            wrapError = NetworkInfoAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static void i(BinaryMessenger binaryMessenger, final NetworkInfoAuto.HostNetworkInfo hostNetworkInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, binaryMessenger, hostNetworkInfo) == null) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostNetworkInfo.isNetWorkAvailable", new StandardMessageCodec());
            if (hostNetworkInfo != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: c.a.r0.z0.a.e.h
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            j.e(NetworkInfoAuto.HostNetworkInfo.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostNetworkInfo.isNetworkAvailableForImmediately", new StandardMessageCodec());
            if (hostNetworkInfo != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: c.a.r0.z0.a.e.i
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            j.f(NetworkInfoAuto.HostNetworkInfo.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostNetworkInfo.getNetInfo", new StandardMessageCodec());
            if (hostNetworkInfo != null) {
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: c.a.r0.z0.a.e.g
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            j.g(NetworkInfoAuto.HostNetworkInfo.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostNetworkInfo.getDnsIp", new StandardMessageCodec());
            if (hostNetworkInfo != null) {
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: c.a.r0.z0.a.e.d
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            j.h(NetworkInfoAuto.HostNetworkInfo.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
        }
    }
}
