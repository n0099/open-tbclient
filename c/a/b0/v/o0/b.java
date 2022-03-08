package c.a.b0.v.o0;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.media.AudioManager;
import c.a.b0.v.c0.p;
import c.a.b0.v.v0.h;
import c.a.b0.v.v0.k;
import c.a.b0.v.v0.r;
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
    public static boolean f2224j = false;
    public static boolean k = false;
    public static boolean l = false;
    public static boolean m = false;
    public static int n = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2225h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2226i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(739401555, "Lc/a/b0/v/o0/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(739401555, "Lc/a/b0/v/o0/b;");
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

    @Override // c.a.b0.v.o0.a, c.a.b0.v.f0.j
    public void d(p event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (Intrinsics.areEqual(event.c(), PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                this.f2226i = false;
                boolean r = r();
                if (!r) {
                    n = k.c(getContext());
                }
                if (r != f2224j) {
                    f2224j = r;
                    if (!r && c.a.b0.v.e.T() && k.c(getContext()) > 0) {
                        h.b("HeadsetPlugin", "恢复操作,静音->非静音");
                        m = false;
                        c.a.b0.v.e i2 = i();
                        if (i2 != null) {
                            i2.s0(false);
                        }
                    }
                }
                c.a.b0.v.e i3 = i();
                this.f2225h = i3 != null ? i3.V() : false;
            }
        }
    }

    @Override // c.a.b0.v.f0.j
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new int[]{1, 4} : (int[]) invokeV.objValue;
    }

    @Override // c.a.b0.v.o0.a, c.a.b0.v.f0.j
    public void n(p event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (Intrinsics.areEqual(event.c(), SystemEvent.ACTION_HEADSET_PLUG)) {
                boolean d2 = event.d(3);
                l = d2;
                if (k) {
                    return;
                }
                p(d2);
            } else if (Intrinsics.areEqual(event.c(), SystemEvent.ACTION_BLUETOOTH_HEADSET)) {
                boolean d3 = event.d(6);
                k = d3;
                if (l) {
                    return;
                }
                p(d3);
            }
        }
    }

    public final void p(boolean z) {
        c.a.b0.v.e i2;
        c.a.b0.v.e i3;
        c.a.b0.v.e i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("播放器是否静音isMute= ");
            c.a.b0.v.e i5 = i();
            sb.append(i5 != null ? Boolean.valueOf(i5.V()) : null);
            sb.append(',');
            sb.append(" 播放器是否全局静音sGlobalMute= ");
            sb.append(c.a.b0.v.e.T());
            sb.append(',');
            sb.append(" 播放器静音状态(业务复写的方法)isPlayerMute= ");
            c.a.b0.v.e i6 = i();
            sb.append(i6 != null ? Boolean.valueOf(i6.X()) : null);
            sb.append(',');
            sb.append(" 播放器耳机连接前的音量大小-> ");
            sb.append(n);
            sb.append(',');
            sb.append(" 播放器音量音量焦点-> ");
            c.a.b0.v.e i7 = i();
            sb.append(i7 != null ? Boolean.valueOf(i7.U()) : null);
            h.b("HeadsetPlugin", sb.toString());
            if (z) {
                f2224j = true;
                m = c.a.b0.v.e.T();
                c.a.b0.v.e i8 = i();
                this.f2225h = i8 != null ? i8.V() : false;
                h.b("HeadsetPlugin", "耳机连接>>> 静音状态,全局=" + m + ", 播放器=" + this.f2225h);
                boolean z2 = this.f2225h;
                if (!z2) {
                    c.a.b0.v.e i9 = i();
                    z2 = i9 != null && i9.V();
                }
                if (z2 && (i4 = i()) != null) {
                    i4.s0(false);
                }
                int c2 = k.c(getContext());
                if (c2 == 0) {
                    c2 = (int) (k.b(getContext()) * 0.35d);
                }
                k.d(getContext(), c2);
                if (r.k() && (i3 = i()) != null && i3.W() && this.f2226i) {
                    c.a.b0.v.e i10 = i();
                    int r = i10 != null ? i10.r() : 0;
                    c.a.b0.v.e i11 = i();
                    if (r > (i11 != null ? i11.C() : 0)) {
                        this.f2226i = false;
                        c.a.b0.v.e i12 = i();
                        if (i12 != null) {
                            i12.l0();
                        }
                    }
                }
            } else if (f2224j) {
                f2224j = false;
                if (r.k() && (i2 = i()) != null && i2.Y()) {
                    this.f2226i = true;
                    c.a.b0.v.e i13 = i();
                    if (i13 != null) {
                        i13.f0(4);
                    }
                }
                h.b("HeadsetPlugin", "耳机断开>>> 恢复之前静音状态,全局=" + m + ", 播放器=" + this.f2225h + StringUtil.ARRAY_ELEMENT_SEPARATOR + "声音=" + n);
                if (n == 0) {
                    k.d(getContext(), n);
                }
                c.a.b0.v.e i14 = i();
                if (i14 != null) {
                    i14.s0(m);
                }
                c.a.b0.v.e i15 = i();
                if (i15 != null) {
                    i15.w0(this.f2225h);
                }
            } else {
                c.a.b0.v.q0.b.c().d(c.a.b0.v.c0.f.w(LayerEvent.ACTION_MUTE_SYNC_TO_ALL_PLAYER));
            }
        }
    }

    public final boolean r() {
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
