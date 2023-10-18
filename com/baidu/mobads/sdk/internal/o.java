package com.baidu.mobads.sdk.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o implements NativeResponse.CustomizeMediaPlayer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "vstart";
    public static final String b = "vrepeatedplay";
    public static final String c = "vclose";
    public static final String d = "vreadyplay";
    public static final String e = "vplayfail";
    public static final String f = "vmute";
    public static final String g = "vfrozen";
    public static final String h = "vshow";
    public static final String i = "curTimeSec";
    public static final String j = "startTimeSec";
    public static final String k = "autoPlay";
    public static final String l = "reasonValue";
    public transient /* synthetic */ FieldHolder $fh;
    public final di m;
    public final a n;
    public boolean o;
    public int p;

    public o(di diVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {diVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = false;
        this.p = 0;
        this.m = diVar;
        this.n = aVar;
    }

    private void a(String str, JSONObject jSONObject) {
        a aVar;
        JSONObject T2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, this, str, jSONObject) == null) && this.m != null && (aVar = this.n) != null && (T2 = aVar.T()) != null) {
            try {
                T2.put("msg", "sendVideoThirdLog");
                T2.put("trackType", str);
                T2.put("trackInfo", jSONObject);
                this.m.a(T2);
            } catch (Throwable th) {
                br.a().d(th.getMessage());
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoMuteChange(int i2, boolean z) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            int i4 = this.p;
            boolean z2 = this.o;
            if (z) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            a(f, a(i4, i2, z2, i3));
        }
    }

    private JSONObject a(int i2, int i3, boolean z, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4)})) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(j, i2 / 1000);
                jSONObject.put(i, i3 / 1000);
                jSONObject.put(k, z);
                jSONObject.put(l, i4);
            } catch (Throwable th) {
                br.a().d(th.getMessage());
            }
            return jSONObject;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar = this.n;
            if (aVar != null) {
                return aVar.n();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayerReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a(d, a(0, 0, false, 0));
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoReplay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.p = 0;
            a(b, a(0, 0, this.o, 0));
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            a(h, a(0, 0, false, 7));
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayError(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            a(e, a(this.p, i2, this.o, 0));
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayFrozen(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            a(g, a(this.p, i2, this.o, 0));
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoResume(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.p = i2;
            a(a, a(i2, i2, this.o, 0));
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.p = 0;
            this.o = z;
            a(a, a(0, 0, z, 0));
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoPause(int i2, NativeResponse.VideoReason videoReason) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, videoReason) == null) {
            a(c, a(this.p, i2, this.o, videoReason.getCode()));
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoStop(int i2, NativeResponse.VideoReason videoReason) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, videoReason) == null) {
            a(c, a(this.p, i2, this.o, videoReason.getCode()));
        }
    }
}
