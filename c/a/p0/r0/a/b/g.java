package c.a.p0.r0.a.b;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.flutter.plugin.globalStateSync.GlobalStateSyncAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: GlobalStateSyncAuto.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static /* synthetic */ void a(HashMap hashMap, BasicMessageChannel.Reply reply, GlobalStateSyncAuto.AllStateData allStateData) {
        hashMap.put("result", allStateData.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(HashMap hashMap, BasicMessageChannel.Reply reply, GlobalStateSyncAuto.SingleTypeStateData singleTypeStateData) {
        hashMap.put("result", singleTypeStateData.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void c(GlobalStateSyncAuto.HostGlobalStateSync hostGlobalStateSync, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostGlobalStateSync.readAllState(new GlobalStateSyncAuto.Result() { // from class: c.a.p0.r0.a.b.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.globalStateSync.GlobalStateSyncAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        g.a(hashMap, reply, (GlobalStateSyncAuto.AllStateData) obj2);
                    }
                }
            });
        } catch (Exception e2) {
            wrapError = GlobalStateSyncAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void d(GlobalStateSyncAuto.HostGlobalStateSync hostGlobalStateSync, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostGlobalStateSync.readStateForType(GlobalStateSyncAuto.readParam.fromMap((HashMap) obj), new GlobalStateSyncAuto.Result() { // from class: c.a.p0.r0.a.b.c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.globalStateSync.GlobalStateSyncAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        g.b(hashMap, reply, (GlobalStateSyncAuto.SingleTypeStateData) obj2);
                    }
                }
            });
        } catch (Exception e2) {
            wrapError = GlobalStateSyncAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void e(GlobalStateSyncAuto.HostGlobalStateSync hostGlobalStateSync, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostGlobalStateSync.write(GlobalStateSyncAuto.SingleTypeStateData.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = GlobalStateSyncAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static void f(BinaryMessenger binaryMessenger, final GlobalStateSyncAuto.HostGlobalStateSync hostGlobalStateSync) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, binaryMessenger, hostGlobalStateSync) == null) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostGlobalStateSync.readAllState", new StandardMessageCodec());
            if (hostGlobalStateSync != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: c.a.p0.r0.a.b.e
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            g.c(GlobalStateSyncAuto.HostGlobalStateSync.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostGlobalStateSync.readStateForType", new StandardMessageCodec());
            if (hostGlobalStateSync != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: c.a.p0.r0.a.b.d
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            g.d(GlobalStateSyncAuto.HostGlobalStateSync.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostGlobalStateSync.write", new StandardMessageCodec());
            if (hostGlobalStateSync != null) {
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: c.a.p0.r0.a.b.f
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            g.e(GlobalStateSyncAuto.HostGlobalStateSync.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
        }
    }
}
