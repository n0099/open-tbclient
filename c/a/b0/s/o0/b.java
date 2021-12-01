package c.a.b0.s.o0;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.media.AudioManager;
import c.a.b0.s.c0.p;
import c.a.b0.s.v0.h;
import c.a.b0.s.v0.k;
import c.a.b0.s.v0.s;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class b extends a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: j  reason: collision with root package name */
    public static boolean f2068j = false;

    /* renamed from: k  reason: collision with root package name */
    public static boolean f2069k = false;
    public static boolean l = false;
    public static boolean m = false;
    public static int n = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2070h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2071i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1923109488, "Lc/a/b0/s/o0/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1923109488, "Lc/a/b0/s/o0/b;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // c.a.b0.s.o0.a, c.a.b0.s.f0.j
    public void e(p event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (Intrinsics.areEqual(event.c(), PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                this.f2071i = false;
                boolean s = s();
                if (!s) {
                    n = k.c(getContext());
                }
                if (s != f2068j) {
                    f2068j = s;
                    if (!s && c.a.b0.s.e.T() && k.c(getContext()) > 0) {
                        h.b("HeadsetPlugin", "恢复操作,静音->非静音");
                        m = false;
                        c.a.b0.s.e j2 = j();
                        if (j2 != null) {
                            j2.s0(false);
                        }
                    }
                }
                c.a.b0.s.e j3 = j();
                this.f2070h = j3 != null ? j3.V() : false;
            }
        }
    }

    @Override // c.a.b0.s.f0.j
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new int[]{1, 4} : (int[]) invokeV.objValue;
    }

    @Override // c.a.b0.s.o0.a, c.a.b0.s.f0.j
    public void o(p event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (Intrinsics.areEqual(event.c(), SystemEvent.ACTION_HEADSET_PLUG)) {
                boolean d2 = event.d(3);
                l = d2;
                if (f2069k) {
                    return;
                }
                q(d2);
            } else if (Intrinsics.areEqual(event.c(), SystemEvent.ACTION_BLUETOOTH_HEADSET)) {
                boolean d3 = event.d(6);
                f2069k = d3;
                if (l) {
                    return;
                }
                q(d3);
            }
        }
    }

    public final void q(boolean z) {
        c.a.b0.s.e j2;
        c.a.b0.s.e j3;
        c.a.b0.s.e j4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("播放器是否静音isMute= ");
            c.a.b0.s.e j5 = j();
            sb.append(j5 != null ? Boolean.valueOf(j5.V()) : null);
            sb.append(',');
            sb.append(" 播放器是否全局静音sGlobalMute= ");
            sb.append(c.a.b0.s.e.T());
            sb.append(',');
            sb.append(" 播放器静音状态(业务复写的方法)isPlayerMute= ");
            c.a.b0.s.e j6 = j();
            sb.append(j6 != null ? Boolean.valueOf(j6.X()) : null);
            sb.append(',');
            sb.append(" 播放器耳机连接前的音量大小-> ");
            sb.append(n);
            sb.append(',');
            sb.append(" 播放器音量音量焦点-> ");
            c.a.b0.s.e j7 = j();
            sb.append(j7 != null ? Boolean.valueOf(j7.U()) : null);
            h.b("HeadsetPlugin", sb.toString());
            if (z) {
                f2068j = true;
                m = c.a.b0.s.e.T();
                c.a.b0.s.e j8 = j();
                this.f2070h = j8 != null ? j8.V() : false;
                h.b("HeadsetPlugin", "耳机连接>>> 静音状态,全局=" + m + ", 播放器=" + this.f2070h);
                boolean z2 = this.f2070h;
                if (!z2) {
                    c.a.b0.s.e j9 = j();
                    z2 = j9 != null && j9.V();
                }
                if (z2 && (j4 = j()) != null) {
                    j4.s0(false);
                }
                int c2 = k.c(getContext());
                if (c2 == 0) {
                    c2 = (int) (k.b(getContext()) * 0.35d);
                }
                k.d(getContext(), c2);
                if (s.k() && (j3 = j()) != null && j3.W() && this.f2071i) {
                    c.a.b0.s.e j10 = j();
                    int r = j10 != null ? j10.r() : 0;
                    c.a.b0.s.e j11 = j();
                    if (r > (j11 != null ? j11.C() : 0)) {
                        this.f2071i = false;
                        c.a.b0.s.e j12 = j();
                        if (j12 != null) {
                            j12.l0();
                        }
                    }
                }
            } else if (f2068j) {
                f2068j = false;
                if (s.k() && (j2 = j()) != null && j2.Y()) {
                    this.f2071i = true;
                    c.a.b0.s.e j13 = j();
                    if (j13 != null) {
                        j13.f0(4);
                    }
                }
                h.b("HeadsetPlugin", "耳机断开>>> 恢复之前静音状态,全局=" + m + ", 播放器=" + this.f2070h + StringUtil.ARRAY_ELEMENT_SEPARATOR + "声音=" + n);
                if (n == 0) {
                    k.d(getContext(), n);
                }
                c.a.b0.s.e j14 = j();
                if (j14 != null) {
                    j14.s0(m);
                }
                c.a.b0.s.e j15 = j();
                if (j15 != null) {
                    j15.w0(this.f2070h);
                }
            } else {
                c.a.b0.s.q0.b.c().d(c.a.b0.s.c0.f.w(LayerEvent.ACTION_MUTE_SYNC_TO_ALL_PLAYER));
            }
        }
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AudioManager a = k.a(getContext());
            boolean isWiredHeadsetOn = a != null ? a.isWiredHeadsetOn() : false;
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            boolean z = defaultAdapter != null && defaultAdapter.getProfileConnectionState(1) == 2;
            h.b("HeadsetPlugin", "当前耳机连接状态>>> 有线耳机=" + isWiredHeadsetOn + ", 蓝牙=" + z);
            return isWiredHeadsetOn || z;
        }
        return invokeV.booleanValue;
    }
}
