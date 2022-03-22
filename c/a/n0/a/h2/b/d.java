package c.a.n0.a.h2.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static d f4728e;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, b> a;

    /* renamed from: b  reason: collision with root package name */
    public AudioManager f4729b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4730c;

    /* renamed from: d  reason: collision with root package name */
    public BroadcastReceiver f4731d;

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (this.this$0.f4729b == null) {
                    this.this$0.f4729b = (AudioManager) c.a.n0.a.s0.a.c().getSystemService("audio");
                }
                for (Map.Entry entry : this.this$0.a.entrySet()) {
                    ((b) entry.getValue()).a(this.this$0.f4729b != null ? this.this$0.f4729b.getStreamVolume(3) : 0);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i);
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap<>();
        this.f4731d = new a(this);
    }

    public static d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f4728e == null) {
                synchronized (d.class) {
                    if (f4728e == null) {
                        f4728e = new d();
                    }
                }
            }
            return f4728e;
        }
        return (d) invokeV.objValue;
    }

    public static void h() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, null) == null) || (dVar = f4728e) == null) {
            return;
        }
        dVar.g();
    }

    private void registerReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            c.a.n0.a.s0.a.c().registerReceiver(this.f4731d, intentFilter);
            this.f4730c = true;
        }
    }

    private void unregisterReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            try {
                c.a.n0.a.s0.a.c().unregisterReceiver(this.f4731d);
                this.f4730c = false;
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
            if (!this.f4730c) {
                registerReceiver();
            }
            if (c.a.n0.a.a.a) {
                Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.a.size());
            }
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f4729b == null) {
                this.f4729b = (AudioManager) c.a.n0.a.s0.a.c().getSystemService("audio");
            }
            AudioManager audioManager = this.f4729b;
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
                this.f4729b = null;
                this.f4730c = false;
            }
            f4728e = null;
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
                if (this.a.size() == 0 && this.f4730c) {
                    unregisterReceiver();
                }
                if (c.a.n0.a.a.a && remove != null) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.a.size());
                }
                z = remove != null;
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
