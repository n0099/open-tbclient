package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
@Keep
/* loaded from: classes5.dex */
public class MediaInstanceState {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INSTANCE_STATE_ACTIVE = 1;
    public static final int INSTANCE_STATE_INACTIVE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> A;
    public int B;
    public String C;
    public String D;

    /* renamed from: a  reason: collision with root package name */
    public CyberPlayerManager.OnPreparedListener f38869a;

    /* renamed from: b  reason: collision with root package name */
    public CyberPlayerManager.OnCompletionListener f38870b;

    /* renamed from: c  reason: collision with root package name */
    public CyberPlayerManager.OnBufferingUpdateListener f38871c;

    /* renamed from: d  reason: collision with root package name */
    public CyberPlayerManager.OnSeekCompleteListener f38872d;

    /* renamed from: e  reason: collision with root package name */
    public CyberPlayerManager.OnVideoSizeChangedListener f38873e;

    /* renamed from: f  reason: collision with root package name */
    public CyberPlayerManager.OnInfoListener f38874f;

    /* renamed from: g  reason: collision with root package name */
    public CyberPlayerManager.OnMediaSourceChangedListener f38875g;

    /* renamed from: h  reason: collision with root package name */
    public Surface f38876h;

    /* renamed from: i  reason: collision with root package name */
    public CyberPlayerManager.HttpDNS f38877i;

    /* renamed from: j  reason: collision with root package name */
    public int f38878j;
    public int k;
    public float l;
    public float m;
    public long n;
    public long o;
    public int p;
    public Context q;
    public boolean r;
    public boolean s;
    public boolean t;
    public int u;
    public boolean v;
    public int w;
    public int x;
    public int y;
    public Uri z;

    public MediaInstanceState() {
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
        this.f38878j = -1;
        this.k = 0;
        this.l = -1.0f;
        this.m = -1.0f;
        this.n = 0L;
        this.o = 0L;
        this.p = 0;
        this.q = null;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = 0;
        this.v = false;
        this.w = -1;
        this.x = 0;
        this.y = 0;
        this.B = Integer.MIN_VALUE;
        this.C = null;
        this.D = null;
    }

    public CyberPlayerManager.HttpDNS dns() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38877i : (CyberPlayerManager.HttpDNS) invokeV.objValue;
    }

    public String getClarityInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.C : (String) invokeV.objValue;
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f38878j : invokeV.intValue;
    }

    public int getDecoderMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.p : invokeV.intValue;
    }

    public long getDownLoadSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.o : invokeV.longValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : invokeV.intValue;
    }

    public Context getInstanceContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q : (Context) invokeV.objValue;
    }

    public Map<String, String> getInstanceHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.A : (Map) invokeV.objValue;
    }

    public int getInstanceStaticsCount(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            if (z) {
                int i2 = this.x + 1;
                this.x = i2;
                return i2;
            }
            int i3 = this.y + 1;
            this.y = i3;
            return i3;
        }
        return invokeZ.intValue;
    }

    public Surface getInstanceSurface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f38876h : (Surface) invokeV.objValue;
    }

    public Uri getInstanceUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.z : (Uri) invokeV.objValue;
    }

    public float getLRVolume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            float f2 = this.l;
            float f3 = this.m;
            return f2 > f3 ? f2 : f3;
        }
        return invokeV.floatValue;
    }

    public int getMediaSourceRank() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.B : invokeV.intValue;
    }

    public CyberPlayerManager.OnBufferingUpdateListener getOnBufferingUpdateListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f38871c : (CyberPlayerManager.OnBufferingUpdateListener) invokeV.objValue;
    }

    public CyberPlayerManager.OnCompletionListener getOnCompletionListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f38870b : (CyberPlayerManager.OnCompletionListener) invokeV.objValue;
    }

    public CyberPlayerManager.OnInfoListener getOnInfoListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f38874f : (CyberPlayerManager.OnInfoListener) invokeV.objValue;
    }

    public CyberPlayerManager.OnMediaSourceChangedListener getOnMediaSourceChangedListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f38875g : (CyberPlayerManager.OnMediaSourceChangedListener) invokeV.objValue;
    }

    public CyberPlayerManager.OnPreparedListener getOnPreparedListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f38869a : (CyberPlayerManager.OnPreparedListener) invokeV.objValue;
    }

    public CyberPlayerManager.OnSeekCompleteListener getOnSeekCompleteListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f38872d : (CyberPlayerManager.OnSeekCompleteListener) invokeV.objValue;
    }

    public CyberPlayerManager.OnVideoSizeChangedListener getOnVideoSizeChangedListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f38873e : (CyberPlayerManager.OnVideoSizeChangedListener) invokeV.objValue;
    }

    public String getPlayJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.D : (String) invokeV.objValue;
    }

    public boolean getPlayStateByType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            if (i2 == 0) {
                return this.r;
            }
            if (i2 == 1) {
                return this.s;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public long getPlayedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.n : invokeV.longValue;
    }

    public boolean getPlayingStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public boolean isRemote() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.v : invokeV.booleanValue;
    }

    public boolean needActiveInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.w == 0 : invokeV.booleanValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.f38869a = null;
            this.f38874f = null;
            this.f38872d = null;
            this.f38871c = null;
            this.f38873e = null;
            this.f38869a = null;
            this.f38875g = null;
            this.f38876h = null;
            this.f38877i = null;
            this.A = null;
            this.z = null;
        }
    }

    public void setClarityInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.C = str;
        }
    }

    public void setMediaSourceRank(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.B = i2;
        }
    }

    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onBufferingUpdateListener) == null) {
            this.f38871c = onBufferingUpdateListener;
        }
    }

    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onCompletionListener) == null) {
            this.f38870b = onCompletionListener;
        }
    }

    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, onInfoListener) == null) {
            this.f38874f = onInfoListener;
        }
    }

    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onMediaSourceChangedListener) == null) {
            this.f38875g = onMediaSourceChangedListener;
        }
    }

    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, onPreparedListener) == null) {
            this.f38869a = onPreparedListener;
        }
    }

    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, onSeekCompleteListener) == null) {
            this.f38872d = onSeekCompleteListener;
        }
    }

    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, onVideoSizeChangedListener) == null) {
            this.f38873e = onVideoSizeChangedListener;
        }
    }

    public void setPlayJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.D = str;
        }
    }

    public void updateDataSource(Context context, Uri uri, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048613, this, context, uri, map) == null) {
            this.q = context;
            this.z = uri;
            this.A = map;
        }
    }

    public void updateDecoderMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.p = i2;
        }
    }

    public void updateDns(CyberPlayerManager.HttpDNS httpDNS) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, httpDNS) == null) {
            this.f38877i = httpDNS;
        }
    }

    public void updateDownLoadSpeed(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048616, this, j2) == null) {
            this.o = j2;
        }
    }

    public void updateInstanceDecodeMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.p = i2;
        }
    }

    public void updateInstanceState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.w = i2;
        }
    }

    public void updatePlayStateByType(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 == 0) {
                this.r = z;
            } else if (i2 == 1) {
                this.s = z;
            }
        }
    }

    public void updatePlayedTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048620, this, j2) == null) {
            this.n = j2;
        }
    }

    public void updatePlayingStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.t = z;
        }
    }

    public void updateRemote(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.v = z;
        }
    }

    public void updateSeekPos(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048623, this, i2, i3) == null) {
            if (i2 >= i3 - 100) {
                i2 = 0;
            }
            this.f38878j = i2;
            this.k = i3;
        }
    }

    public void updateSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, surface) == null) {
            this.f38876h = surface;
        }
    }
}
