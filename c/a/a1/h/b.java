package c.a.a1.h;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.a1.i.i;
import c.a.a1.i.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.utils.FileUtils;
import java.io.IOException;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static int f1129g = 2;

    /* renamed from: h  reason: collision with root package name */
    public static int f1130h = 4;

    /* renamed from: i  reason: collision with root package name */
    public static int f1131i = 8;

    /* renamed from: j  reason: collision with root package name */
    public static int f1132j = 16;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f1133b;

    /* renamed from: c  reason: collision with root package name */
    public int f1134c;

    /* renamed from: d  reason: collision with root package name */
    public int f1135d;

    /* renamed from: e  reason: collision with root package name */
    public long f1136e;

    /* renamed from: f  reason: collision with root package name */
    public String f1137f;

    /* loaded from: classes.dex */
    public class a implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean[] f1138e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f1139f;

        public a(b bVar, boolean[] zArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, zArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1139f = bVar;
            this.f1138e = zArr;
        }

        @Override // c.a.a1.i.j
        public void a(MediaFormat mediaFormat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaFormat) == null) {
                this.f1138e[0] = true;
                this.f1139f.l(mediaFormat);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1485801401, "Lc/a/a1/h/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1485801401, "Lc/a/a1/h/b;");
        }
    }

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        j(str);
    }

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            b bVar = new b("");
            bVar.f1134c = 2;
            bVar.f1137f = "audio/mp4a-latm";
            bVar.f1133b = 44100;
            bVar.f1135d = 16;
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1135d : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1134c : invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1136e / 1000 : invokeV.longValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? (obj instanceof b) && k((b) obj) == 0 : invokeL.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1137f : (String) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1133b : invokeV.intValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i2 = this.f1135d + this.f1133b + this.f1134c;
            String str = this.f1137f;
            return i2 + (str != null ? str.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (TextUtils.isEmpty(this.f1137f) || this.f1133b == 0 || this.f1134c == 0 || this.f1135d == 0 || this.f1136e == 0) ? false : true : invokeV.booleanValue;
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            try {
                if (m(str)) {
                    boolean[] zArr = {false};
                    i iVar = new i(str);
                    iVar.k(new a(this, zArr));
                    while (!zArr[0]) {
                        if (iVar.c()) {
                            zArr[0] = true;
                        }
                    }
                    iVar.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public int k(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bVar)) == null) {
            if (bVar == null) {
                return 0;
            }
            int i2 = bVar.f1135d != this.f1135d ? 0 | f1129g : 0;
            if (bVar.f1133b != this.f1133b) {
                i2 |= f1130h;
            }
            if (bVar.f1134c != this.f1134c) {
                i2 |= f1131i;
            }
            return !TextUtils.equals(bVar.f1137f, this.f1137f) ? i2 | f1132j : i2;
        }
        return invokeL.intValue;
    }

    public final boolean l(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, mediaFormat)) == null) {
            try {
                this.f1133b = mediaFormat.getInteger("sample-rate");
                this.f1134c = mediaFormat.getInteger("channel-count");
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            boolean z = false;
            if (FileUtils.isExists(str)) {
                MediaExtractor mediaExtractor = new MediaExtractor();
                try {
                    mediaExtractor.setDataSource(str);
                    MediaFormat mediaFormat = null;
                    for (int i2 = 0; i2 < mediaExtractor.getTrackCount(); i2++) {
                        MediaFormat trackFormat = mediaExtractor.getTrackFormat(i2);
                        if (trackFormat.getString("mime").startsWith("audio/")) {
                            mediaExtractor.selectTrack(i2);
                            mediaFormat = trackFormat;
                            break;
                        }
                    }
                    try {
                        if (mediaFormat == null) {
                            return false;
                        }
                        this.f1137f = mediaFormat.getString("mime");
                        this.f1133b = mediaFormat.getInteger("sample-rate");
                        this.f1134c = mediaFormat.getInteger("channel-count");
                        this.f1136e = mediaFormat.getLong("durationUs");
                        if (mediaFormat.containsKey("bit-width")) {
                            this.f1135d = mediaFormat.getInteger("bit-width");
                        } else {
                            this.f1135d = 16;
                        }
                        if (mediaFormat.containsKey("aac-profile")) {
                            if (mediaFormat.getInteger("aac-profile") != 2) {
                                z = true;
                            }
                        }
                        return z;
                    } catch (Exception e2) {
                        c.a.a1.t.c.e("VideoMuxer", "initAudioProperty error:" + e2.getMessage());
                        return false;
                    } finally {
                        mediaExtractor.release();
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
