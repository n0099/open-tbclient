package c.a.p.a;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.flutter.cyberplayer.FlutterCyberView;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.view.TextureRegistry;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class c implements CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnVideoSizeChangedListener, CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnMediaSourceChangedListener, MethodChannel.MethodCallHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextureRegistry.SurfaceTextureEntry f14920e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<Context> f14921f;

    /* renamed from: g  reason: collision with root package name */
    public String f14922g;

    /* renamed from: h  reason: collision with root package name */
    public Context f14923h;

    /* renamed from: i  reason: collision with root package name */
    public FlutterCyberView f14924i;

    /* renamed from: j  reason: collision with root package name */
    public Surface f14925j;
    public CyberPlayer k;
    public long l;
    public MethodChannel m;
    public a n;

    /* loaded from: classes3.dex */
    public interface a {
        void a(long j2);
    }

    public c(Context context, BinaryMessenger binaryMessenger, TextureRegistry.SurfaceTextureEntry surfaceTextureEntry, HashMap<String, String> hashMap, String str, String str2, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, binaryMessenger, surfaceTextureEntry, hashMap, str, str2, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14921f = new WeakReference<>(context);
        this.f14920e = surfaceTextureEntry;
        this.f14922g = str;
        this.f14923h = context;
        FlutterCyberView flutterCyberView = new FlutterCyberView(context);
        this.f14924i = flutterCyberView;
        flutterCyberView.setOnPreparedListener(this);
        this.f14924i.setOnCompletionListener(this);
        this.f14924i.setOnErrorListener(this);
        this.f14924i.setOnInfoListener(this);
        this.f14924i.setOnBufferingUpdateListener(this);
        this.f14924i.setOnSeekCompleteListener(this);
        this.f14924i.setOnMediaSourceChangedListener(this);
        if (hashMap != null) {
            g(hashMap);
        }
        if (str2 != null) {
            this.f14924i.setClarityInfo(str2);
        }
        if (i2 != -1) {
            this.f14924i.switchMediaSource(i2);
        }
        this.f14924i.setVideoPath(str);
        this.f14924i.setLooping(z);
        this.f14924i.setContinuePlayEnable(true);
        this.f14925j = new Surface(surfaceTextureEntry.surfaceTexture());
        CyberPlayer cyberPlayer = this.f14924i.getCyberPlayer();
        this.k = cyberPlayer;
        cyberPlayer.setSurface(this.f14925j);
        this.l = surfaceTextureEntry.id();
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "bd_video_player_" + this.l);
        this.m = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MethodChannel methodChannel = this.m;
            if (methodChannel != null) {
                methodChannel.setMethodCallHandler(null);
                this.m = null;
            }
            FlutterCyberView flutterCyberView = this.f14924i;
            if (flutterCyberView != null) {
                flutterCyberView.stop();
            }
            Surface surface = this.f14925j;
            if (surface != null) {
                surface.release();
            }
            TextureRegistry.SurfaceTextureEntry surfaceTextureEntry = this.f14920e;
            if (surfaceTextureEntry != null) {
                surfaceTextureEntry.release();
            }
            a aVar = this.n;
            if (aVar != null) {
                aVar.a(this.l);
            }
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && isPlaying()) {
            this.m.invokeMethod("onHeadSetPlugged", Boolean.valueOf(z));
        }
    }

    public void c(MethodCall methodCall, @NonNull MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, methodCall, result) == null) {
            if (methodCall.method.equals("contentURL")) {
                this.f14924i.setVideoPath((String) methodCall.arguments);
                result.success(Boolean.TRUE);
            } else if (methodCall.method.equals("scalModel")) {
                this.f14924i.setVideoScalingMode(((Integer) methodCall.arguments).intValue());
                result.success(Boolean.TRUE);
            } else if (methodCall.method.equals("setVideoRotation")) {
                this.f14924i.setVideoRotation(((Integer) methodCall.arguments).intValue());
                result.success(Boolean.TRUE);
            } else if (methodCall.method.equals("setVideoDecodeMode")) {
                this.f14924i.setDecodeMode(((Integer) methodCall.arguments).intValue());
                result.success(Boolean.TRUE);
            } else if (methodCall.method.equals("getNaturalSize")) {
                int videoWidth = this.k.getVideoWidth();
                int videoHeight = this.k.getVideoHeight();
                HashMap hashMap = new HashMap();
                hashMap.put("width", Integer.valueOf(videoWidth));
                hashMap.put("height", Integer.valueOf(videoHeight));
                result.success(hashMap);
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f14924i.pause();
        }
    }

    public void e(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.n = aVar;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                this.k.setVolume(0.0f, 0.0f);
                b.a(this.f14921f, true);
                return;
            }
            this.k.setVolume(1.0f, 1.0f);
            b.a(this.f14921f, false);
        }
    }

    public void g(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hashMap) == null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                this.f14924i.setOption(entry.getKey(), entry.getValue());
            }
        }
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f14924i.isPlaying() : invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.m.invokeMethod("onBufferingUpdate", Integer.valueOf(i2));
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d.b().c(this.f14922g);
            this.m.invokeMethod("onCompletion", "");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i2, i3, obj)) == null) {
            this.m.invokeMethod("onError", Integer.valueOf(i2));
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048587, this, i2, i3, obj)) == null) {
            this.m.invokeMethod("onInfo", Integer.valueOf(i2));
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048588, this, i2, i3, obj)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("result", Integer.valueOf(i2));
            hashMap.put("rank", Integer.valueOf(i3));
            this.m.invokeMethod("onMediaSourceChanged", hashMap);
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, methodCall, result) == null) {
            if (methodCall.method.equals("play")) {
                startPlay();
                result.success(Boolean.TRUE);
            } else if (methodCall.method.equals("pause")) {
                d();
                result.success(Boolean.TRUE);
            } else if (methodCall.method.equals(IntentConfig.STOP)) {
                a();
                result.success(Boolean.TRUE);
            } else if (methodCall.method.equals("reset")) {
                this.f14924i.reset();
                result.success(Boolean.TRUE);
            } else if (methodCall.method.equals("setMute")) {
                f(((Boolean) methodCall.arguments).booleanValue());
                result.success(Boolean.TRUE);
            } else if (methodCall.method.equals("getDuration")) {
                result.success(Double.valueOf(this.k.getDuration() / 1000));
            } else if (methodCall.method.equals("getCurrentDuration")) {
                result.success(Double.valueOf(this.k.getCurrentPositionSync() / 1000));
            } else if (methodCall.method.equals("getPlayedTime")) {
                result.success(Long.valueOf(this.k.getPlayedTime()));
            } else if (methodCall.method.equals("playbackRate")) {
                this.k.setSpeed((float) ((Double) methodCall.arguments).doubleValue());
                result.success(Boolean.TRUE);
            } else if (methodCall.method.equals("playbackVolume")) {
                float doubleValue = (float) ((Double) methodCall.arguments).doubleValue();
                this.k.setVolume(doubleValue, doubleValue);
                result.success(Boolean.TRUE);
            } else if (methodCall.method.equals("seek")) {
                int doubleValue2 = ((int) ((Double) methodCall.arguments).doubleValue()) * 1000;
                int duration = this.k.getDuration();
                if (doubleValue2 > duration) {
                    doubleValue2 = duration;
                }
                this.f14924i.seekTo(doubleValue2);
                result.success(Boolean.TRUE);
            } else if (methodCall.method.equals("setEnableLooping")) {
                this.f14924i.setLooping(((Boolean) methodCall.arguments).booleanValue());
                result.success(Boolean.TRUE);
            } else if (methodCall.method.equals("getDownloadSpeed")) {
                result.success(Long.valueOf(this.f14924i.getDownloadSpeed()));
            } else if (methodCall.method.equals("setDecodeMode")) {
                this.f14924i.setDecodeMode(((Integer) methodCall.arguments).intValue());
                result.success(Boolean.TRUE);
            } else if (methodCall.method.equals("setExternalInfo")) {
                this.f14924i.setExternalInfo((String) methodCall.argument("what"), (HashMap) methodCall.argument("info"));
                result.success(Boolean.TRUE);
            } else if (methodCall.method.equals("setClarityInfo")) {
                this.f14924i.setClarityInfo((String) methodCall.arguments);
                result.success(Boolean.TRUE);
            } else if (methodCall.method.equals("setPlayJson")) {
                this.f14924i.setPlayJson((String) methodCall.arguments);
                result.success(Boolean.TRUE);
            } else if (methodCall.method.equals("switchMediaSource")) {
                this.f14924i.switchMediaSource(((Integer) methodCall.arguments).intValue());
                result.success(Boolean.TRUE);
            } else {
                c(methodCall, result);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.m.invokeMethod("onPrepared", "");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.m.invokeMethod("onSeekComplete", "");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048592, this, i2, i3, i4, i5) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("width", Integer.valueOf(i2));
            hashMap.put("height", Integer.valueOf(i3));
            this.m.invokeMethod("onVideoSizeChanged", hashMap);
        }
    }

    public final void startPlay() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || isPlaying()) {
            return;
        }
        this.f14924i.start();
    }
}
