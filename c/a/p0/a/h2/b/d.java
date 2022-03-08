package c.a.p0.a.h2.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
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
    public static d f5586e;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, b> a;

    /* renamed from: b  reason: collision with root package name */
    public AudioManager f5587b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5588c;

    /* renamed from: d  reason: collision with root package name */
    public BroadcastReceiver f5589d;

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
                if (this.this$0.f5587b == null) {
                    this.this$0.f5587b = (AudioManager) c.a.p0.a.s0.a.c().getSystemService("audio");
                }
                for (Map.Entry entry : this.this$0.a.entrySet()) {
                    ((b) entry.getValue()).a(this.this$0.f5587b != null ? this.this$0.f5587b.getStreamVolume(3) : 0);
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
        this.f5589d = new a(this);
    }

    public static d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f5586e == null) {
                synchronized (d.class) {
                    if (f5586e == null) {
                        f5586e = new d();
                    }
                }
            }
            return f5586e;
        }
        return (d) invokeV.objValue;
    }

    public static void h() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, null) == null) || (dVar = f5586e) == null) {
            return;
        }
        dVar.g();
    }

    private void registerReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            c.a.p0.a.s0.a.c().registerReceiver(this.f5589d, intentFilter);
            this.f5588c = true;
        }
    }

    private void unregisterReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            try {
                c.a.p0.a.s0.a.c().unregisterReceiver(this.f5589d);
                this.f5588c = false;
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
            if (!this.f5588c) {
                registerReceiver();
            }
            if (c.a.p0.a.a.a) {
                String str2 = "Id = " + str + " listener added, listeners count: " + this.a.size();
            }
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f5587b == null) {
                this.f5587b = (AudioManager) c.a.p0.a.s0.a.c().getSystemService("audio");
            }
            AudioManager audioManager = this.f5587b;
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
                this.f5587b = null;
                this.f5588c = false;
            }
            f5586e = null;
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
                if (this.a.size() == 0 && this.f5588c) {
                    unregisterReceiver();
                }
                if (c.a.p0.a.a.a && remove != null) {
                    String str2 = "Id = " + str + " listener removed, listeners count: " + this.a.size();
                }
                z = remove != null;
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
