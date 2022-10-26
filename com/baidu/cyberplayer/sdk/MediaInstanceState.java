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
/* loaded from: classes2.dex */
public class MediaInstanceState {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INSTANCE_STATE_ACTIVE = 1;
    public static final int INSTANCE_STATE_INACTIVE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public Map B;
    public int C;
    public String D;
    public String E;
    public CyberPlayerManager.OnPreparedListener a;
    public CyberPlayerManager.OnCompletionListener b;
    public CyberPlayerManager.OnBufferingUpdateListener c;
    public CyberPlayerManager.OnSeekCompleteListener d;
    public CyberPlayerManager.OnVideoSizeChangedListener e;
    public CyberPlayerManager.OnInfoListener f;
    public CyberPlayerManager.OnMediaSourceChangedListener g;
    public Surface h;
    public CyberPlayerManager.HttpDNS i;
    public int j;
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
    public boolean u;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = -1;
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
        this.u = false;
        this.v = false;
        this.w = -1;
        this.x = 0;
        this.y = 0;
        this.z = null;
        this.A = null;
        this.C = Integer.MIN_VALUE;
        this.D = null;
        this.E = null;
    }

    public CyberPlayerManager.HttpDNS dns() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.i : (CyberPlayerManager.HttpDNS) invokeV.objValue;
    }

    public String getClarityInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.D : (String) invokeV.objValue;
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : invokeV.intValue;
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

    public Map getInstanceHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.B : (Map) invokeV.objValue;
    }

    public int getInstanceStaticsCount(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            if (z) {
                int i = this.x + 1;
                this.x = i;
                return i;
            }
            int i2 = this.y + 1;
            this.y = i2;
            return i2;
        }
        return invokeZ.intValue;
    }

    public Surface getInstanceSurface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.h : (Surface) invokeV.objValue;
    }

    public Uri getInstanceUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.z : (Uri) invokeV.objValue;
    }

    public String getInstanceUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.A : (String) invokeV.objValue;
    }

    public float getLRVolume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            float f = this.l;
            float f2 = this.m;
            return f > f2 ? f : f2;
        }
        return invokeV.floatValue;
    }

    public int getMediaSourceRank() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.C : invokeV.intValue;
    }

    public CyberPlayerManager.OnBufferingUpdateListener getOnBufferingUpdateListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.c : (CyberPlayerManager.OnBufferingUpdateListener) invokeV.objValue;
    }

    public CyberPlayerManager.OnCompletionListener getOnCompletionListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.b : (CyberPlayerManager.OnCompletionListener) invokeV.objValue;
    }

    public CyberPlayerManager.OnInfoListener getOnInfoListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f : (CyberPlayerManager.OnInfoListener) invokeV.objValue;
    }

    public CyberPlayerManager.OnMediaSourceChangedListener getOnMediaSourceChangedListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.g : (CyberPlayerManager.OnMediaSourceChangedListener) invokeV.objValue;
    }

    public CyberPlayerManager.OnPreparedListener getOnPreparedListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.a : (CyberPlayerManager.OnPreparedListener) invokeV.objValue;
    }

    public CyberPlayerManager.OnSeekCompleteListener getOnSeekCompleteListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.d : (CyberPlayerManager.OnSeekCompleteListener) invokeV.objValue;
    }

    public CyberPlayerManager.OnVideoSizeChangedListener getOnVideoSizeChangedListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.e : (CyberPlayerManager.OnVideoSizeChangedListener) invokeV.objValue;
    }

    public String getPlayJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.E : (String) invokeV.objValue;
    }

    public boolean getPlayStateByType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            if (i == 0) {
                return this.r;
            }
            if (i == 1) {
                return this.s;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public long getPlayedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.n : invokeV.longValue;
    }

    public boolean getPlayingStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public boolean isProcessDied() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public boolean isRemote() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.v : invokeV.booleanValue;
    }

    public boolean needActiveInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.w == 0 : invokeV.booleanValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.a = null;
            this.f = null;
            this.d = null;
            this.c = null;
            this.e = null;
            this.a = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.B = null;
            this.z = null;
        }
    }

    public void setClarityInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.D = str;
        }
    }

    public void setMediaSourceRank(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.C = i;
        }
    }

    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, onBufferingUpdateListener) == null) {
            this.c = onBufferingUpdateListener;
        }
    }

    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onCompletionListener) == null) {
            this.b = onCompletionListener;
        }
    }

    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, onInfoListener) == null) {
            this.f = onInfoListener;
        }
    }

    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, onMediaSourceChangedListener) == null) {
            this.g = onMediaSourceChangedListener;
        }
    }

    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, onPreparedListener) == null) {
            this.a = onPreparedListener;
        }
    }

    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, onSeekCompleteListener) == null) {
            this.d = onSeekCompleteListener;
        }
    }

    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, onVideoSizeChangedListener) == null) {
            this.e = onVideoSizeChangedListener;
        }
    }

    public void setPlayJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.E = str;
        }
    }

    public void setProcessDied(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.u = z;
        }
    }

    public void updateDataSource(Context context, Uri uri, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048616, this, context, uri, map) == null) {
            this.q = context;
            this.z = uri;
            this.B = map;
        }
    }

    public void updateDataSource(String str, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, str, map) == null) {
            this.A = str;
            this.B = map;
        }
    }

    public void updateDecoderMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.p = i;
        }
    }

    public void updateDns(CyberPlayerManager.HttpDNS httpDNS) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, httpDNS) == null) {
            this.i = httpDNS;
        }
    }

    public void updateDownLoadSpeed(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048620, this, j) == null) {
            this.o = j;
        }
    }

    public void updateInstanceState(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.w = i;
        }
    }

    public void updatePlayStateByType(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (i == 0) {
                this.r = z;
            } else if (i == 1) {
                this.s = z;
            }
        }
    }

    public void updatePlayedTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048623, this, j) == null) {
            this.n = j;
        }
    }

    public void updatePlayingStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.t = z;
        }
    }

    public void updateRemote(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.v = z;
        }
    }

    public void updateSeekPos(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048626, this, i, i2) == null) {
            if (i >= i2 - 100) {
                i = 0;
            }
            this.j = i;
            this.k = i2;
        }
    }

    public void updateSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, surface) == null) {
            this.h = surface;
        }
    }
}
