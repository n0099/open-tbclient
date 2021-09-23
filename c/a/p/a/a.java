package c.a.p.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import c.a.p.a.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.flutter.cyberplayer.CyberRemotePlayerService;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.view.TextureRegistry;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MethodChannel f4357e;

    /* renamed from: f  reason: collision with root package name */
    public Context f4358f;

    /* renamed from: g  reason: collision with root package name */
    public d f4359g;

    /* renamed from: h  reason: collision with root package name */
    public LongSparseArray<c.a.p.a.c> f4360h;

    /* renamed from: i  reason: collision with root package name */
    public final BroadcastReceiver f4361i;

    /* renamed from: c.a.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0112a implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f4362a;

        public C0112a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4362a = aVar;
        }

        @Override // c.a.p.a.c.a
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                this.f4362a.f4360h.delete(j2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements CyberPlayerManager.OnDeleteListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f4363a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4363a = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnDeleteListener
        public void onDeleteComplete(int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("result", Integer.valueOf(i2));
                hashMap.put("freeSpaceSize", Long.valueOf(j2));
                this.f4363a.f4357e.invokeMethod("onDeleteComplete", hashMap);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a this$0;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = aVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent.getAction().equals("android.intent.action.HEADSET_PLUG") && intent.hasExtra("state")) {
                int intExtra = intent.getIntExtra("state", 0);
                boolean z = true;
                z = (intExtra == 0 || intExtra != 1) ? false : false;
                for (int i2 = 0; i2 < this.this$0.f4360h.size(); i2++) {
                    c.a.p.a.c valueAt = this.this$0.f4360h.valueAt(i2);
                    if (valueAt != null) {
                        valueAt.b(z);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Context f4364a;

        /* renamed from: b  reason: collision with root package name */
        public final BinaryMessenger f4365b;

        /* renamed from: c  reason: collision with root package name */
        public final TextureRegistry f4366c;

        public d(Context context, BinaryMessenger binaryMessenger, TextureRegistry textureRegistry) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, binaryMessenger, textureRegistry};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4364a = context;
            this.f4365b = binaryMessenger;
            this.f4366c = textureRegistry;
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f4361i = new c(this);
    }

    public void b(String str, int i2, HashMap hashMap, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048576, this, str, i2, hashMap, str2) == null) || CyberPlayerManager.isCoreLoaded(1)) {
            return;
        }
        try {
            CyberPlayerManager.install(this.f4358f, str, str2, i2, CyberRemotePlayerService.class, hashMap, (CyberPlayerManager.InstallListener) null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
            CyberPlayerManager.prefetch(str, null, null, i2, null);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, flutterPluginBinding) == null) {
            this.f4359g = new d(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getTextureRegistry());
            MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "cyberplayer");
            this.f4357e = methodChannel;
            methodChannel.setMethodCallHandler(this);
            this.f4358f = flutterPluginBinding.getApplicationContext();
            this.f4360h = new LongSparseArray<>();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            this.f4358f.registerReceiver(this.f4361i, intentFilter);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, flutterPluginBinding) == null) {
            this.f4357e.setMethodCallHandler(null);
            this.f4358f.unregisterReceiver(this.f4361i);
            for (int i2 = 0; i2 < this.f4360h.size(); i2++) {
                c.a.p.a.c valueAt = this.f4360h.valueAt(i2);
                if (valueAt != null) {
                    valueAt.a();
                }
            }
        }
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, methodCall, result) == null) {
            if (methodCall.method.equals("create")) {
                String str = (String) methodCall.argument("url");
                boolean booleanValue = ((Boolean) methodCall.argument("isLoop")).booleanValue();
                String str2 = (String) methodCall.argument("clarityInfo");
                int intValue = ((Integer) methodCall.argument("switchMediaSource")).intValue();
                HashMap hashMap = (HashMap) methodCall.argument("options");
                TextureRegistry.SurfaceTextureEntry createSurfaceTexture = this.f4359g.f4366c.createSurfaceTexture();
                c.a.p.a.c cVar = new c.a.p.a.c(this.f4359g.f4364a, this.f4359g.f4365b, createSurfaceTexture, hashMap, str, str2, intValue, booleanValue);
                cVar.e(new C0112a(this));
                this.f4360h.put(createSurfaceTexture.id(), cVar);
                result.success(Long.valueOf(createSurfaceTexture.id()));
            } else if (methodCall.method.equals("init")) {
                HashMap hashMap2 = (HashMap) methodCall.arguments;
                b((String) hashMap2.get("clientId"), ((Integer) hashMap2.get("installType")).intValue(), (HashMap) hashMap2.get("opt"), (String) hashMap2.get("downloadCoreServer"));
            } else if (methodCall.method.equals("startPreload")) {
                HashMap hashMap3 = (HashMap) methodCall.arguments;
                c((String) hashMap3.get("url"), ((Integer) hashMap3.get(CloudStabilityUBCUtils.KEY_LENGTH)).intValue());
            } else if (methodCall.method.equals("stopPreload")) {
                CyberPlayerManager.stopPrefetch((String) methodCall.arguments);
            } else if (methodCall.method.equals("hasCacheFile")) {
                CyberPlayerManager.hasCacheFile((String) methodCall.arguments);
            } else if (methodCall.method.equals("deleteVideoCache")) {
                CyberPlayerManager.deleteVideoCache(new b(this));
            } else if (methodCall.method.equals("getDevicePlayQualityScore")) {
                CyberPlayerManager.getDevicePlayQualityScore((String) methodCall.argument("mimeType"), ((Integer) methodCall.argument("decodeMode")).intValue(), ((Integer) methodCall.argument("width")).intValue(), ((Integer) methodCall.argument("height")).intValue(), (HashMap) methodCall.argument("options"));
            } else {
                result.notImplemented();
            }
        }
    }
}
