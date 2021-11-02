package b.a.p0.a.n2.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.player.event.VideoReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static d f6981e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f6982a;

    /* renamed from: b  reason: collision with root package name */
    public AudioManager f6983b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6984c;

    /* renamed from: d  reason: collision with root package name */
    public BroadcastReceiver f6985d;

    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d this$0;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (this.this$0.f6983b == null) {
                    this.this$0.f6983b = (AudioManager) b.a.p0.a.c1.a.b().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                }
                for (Map.Entry entry : this.this$0.f6982a.entrySet()) {
                    ((b) entry.getValue()).a(this.this$0.f6983b != null ? this.this$0.f6983b.getStreamVolume(3) : 0);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i2);
    }

    public d() {
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
        this.f6982a = new ConcurrentHashMap<>();
        this.f6985d = new a(this);
    }

    public static d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f6981e == null) {
                synchronized (d.class) {
                    if (f6981e == null) {
                        f6981e = new d();
                    }
                }
            }
            return f6981e;
        }
        return (d) invokeV.objValue;
    }

    public static void h() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) || (dVar = f6981e) == null) {
            return;
        }
        dVar.g();
    }

    private void registerReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
            b.a.p0.a.c1.a.b().registerReceiver(this.f6985d, intentFilter);
            this.f6984c = true;
        }
    }

    private void unregisterReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            try {
                b.a.p0.a.c1.a.b().unregisterReceiver(this.f6985d);
                this.f6984c = false;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void d(@NonNull String str, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, bVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this) {
            this.f6982a.put(str, bVar);
            if (!this.f6984c) {
                registerReceiver();
            }
            if (k.f6397a) {
                String str2 = "Id = " + str + " listener added, listeners count: " + this.f6982a.size();
            }
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f6983b == null) {
                this.f6983b = (AudioManager) b.a.p0.a.c1.a.b().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            }
            AudioManager audioManager = this.f6983b;
            if (audioManager != null) {
                return audioManager.getStreamMaxVolume(3);
            }
            return 100;
        }
        return invokeV.intValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f6982a.clear();
                this.f6983b = null;
                this.f6984c = false;
            }
            f6981e = null;
        }
    }

    public boolean i(@NonNull String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            synchronized (this) {
                b remove = this.f6982a.remove(str);
                if (this.f6982a.size() == 0 && this.f6984c) {
                    unregisterReceiver();
                }
                if (k.f6397a && remove != null) {
                    String str2 = "Id = " + str + " listener removed, listeners count: " + this.f6982a.size();
                }
                z = remove != null;
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
