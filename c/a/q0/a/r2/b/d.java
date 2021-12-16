package c.a.q0.a.r2.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.k;
import com.baidu.android.imsdk.internal.Constants;
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
    public static d f8075e;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, b> a;

    /* renamed from: b  reason: collision with root package name */
    public AudioManager f8076b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8077c;

    /* renamed from: d  reason: collision with root package name */
    public BroadcastReceiver f8078d;

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
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && "android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (this.this$0.f8076b == null) {
                    this.this$0.f8076b = (AudioManager) c.a.q0.a.c1.a.c().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                }
                for (Map.Entry entry : this.this$0.a.entrySet()) {
                    ((b) entry.getValue()).a(this.this$0.f8076b != null ? this.this$0.f8076b.getStreamVolume(3) : 0);
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
        this.a = new ConcurrentHashMap<>();
        this.f8078d = new a(this);
    }

    public static d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f8075e == null) {
                synchronized (d.class) {
                    if (f8075e == null) {
                        f8075e = new d();
                    }
                }
            }
            return f8075e;
        }
        return (d) invokeV.objValue;
    }

    public static void h() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, null) == null) || (dVar = f8075e) == null) {
            return;
        }
        dVar.g();
    }

    private void registerReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            c.a.q0.a.c1.a.c().registerReceiver(this.f8078d, intentFilter);
            this.f8077c = true;
        }
    }

    private void unregisterReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            try {
                c.a.q0.a.c1.a.c().unregisterReceiver(this.f8078d);
                this.f8077c = false;
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
            this.a.put(str, bVar);
            if (!this.f8077c) {
                registerReceiver();
            }
            if (k.a) {
                String str2 = "Id = " + str + " listener added, listeners count: " + this.a.size();
            }
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f8076b == null) {
                this.f8076b = (AudioManager) c.a.q0.a.c1.a.c().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            }
            AudioManager audioManager = this.f8076b;
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
                this.a.clear();
                this.f8076b = null;
                this.f8077c = false;
            }
            f8075e = null;
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
                b remove = this.a.remove(str);
                if (this.a.size() == 0 && this.f8077c) {
                    unregisterReceiver();
                }
                if (k.a && remove != null) {
                    String str2 = "Id = " + str + " listener removed, listeners count: " + this.a.size();
                }
                z = remove != null;
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
