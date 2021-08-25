package c.a.q0.r0.a.h;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.flutter.plugin.progressHUD.ProgressHUDAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: ProgressHUDAuto.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static /* synthetic */ void a(ProgressHUDAuto.HostProgressHUD hostProgressHUD, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostProgressHUD.showWithImg(ProgressHUDAuto.ImageParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = ProgressHUDAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(ProgressHUDAuto.HostProgressHUD hostProgressHUD, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostProgressHUD.showErrorWithStatus(ProgressHUDAuto.StringParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = ProgressHUDAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void c(ProgressHUDAuto.HostProgressHUD hostProgressHUD, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostProgressHUD.showSuccessWithStatus(ProgressHUDAuto.StringParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = ProgressHUDAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void d(ProgressHUDAuto.HostProgressHUD hostProgressHUD, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostProgressHUD.showAttentionWithStatus(ProgressHUDAuto.StringParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = ProgressHUDAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void e(ProgressHUDAuto.HostProgressHUD hostProgressHUD, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostProgressHUD.showAttentionWithStatusForTime(ProgressHUDAuto.AttentionTimeParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = ProgressHUDAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static void f(BinaryMessenger binaryMessenger, final ProgressHUDAuto.HostProgressHUD hostProgressHUD) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, binaryMessenger, hostProgressHUD) == null) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostProgressHUD.showWithImg", new StandardMessageCodec());
            if (hostProgressHUD != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: c.a.q0.r0.a.h.c
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            f.a(ProgressHUDAuto.HostProgressHUD.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostProgressHUD.showErrorWithStatus", new StandardMessageCodec());
            if (hostProgressHUD != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: c.a.q0.r0.a.h.b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            f.b(ProgressHUDAuto.HostProgressHUD.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostProgressHUD.showSuccessWithStatus", new StandardMessageCodec());
            if (hostProgressHUD != null) {
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: c.a.q0.r0.a.h.e
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            f.c(ProgressHUDAuto.HostProgressHUD.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostProgressHUD.showAttentionWithStatus", new StandardMessageCodec());
            if (hostProgressHUD != null) {
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: c.a.q0.r0.a.h.a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            f.d(ProgressHUDAuto.HostProgressHUD.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostProgressHUD.showAttentionWithStatusForTime", new StandardMessageCodec());
            if (hostProgressHUD != null) {
                basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: c.a.q0.r0.a.h.d
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            f.e(ProgressHUDAuto.HostProgressHUD.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel5.setMessageHandler(null);
            }
        }
    }
}
