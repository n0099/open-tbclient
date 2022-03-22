package com.baidu.pass.face.platform.a;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.FaceEnvironment;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "b";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f28065b;

    /* renamed from: c  reason: collision with root package name */
    public FaceStatusNewEnum f28066c;

    /* renamed from: d  reason: collision with root package name */
    public volatile long f28067d;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f28068e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f28069f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f28070g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<Integer, Long> f28071h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-360335263, "Lcom/baidu/pass/face/platform/a/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-360335263, "Lcom/baidu/pass/face/platform/a/b;");
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28067d = 0L;
        this.f28068e = 0L;
        this.f28069f = false;
        this.f28070g = true;
        this.f28071h = new HashMap<>();
        this.f28065b = context;
    }

    private long a(int i) {
        InterceptResult invokeI;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
            if (this.f28071h.containsKey(Integer.valueOf(i))) {
                return this.f28071h.get(Integer.valueOf(i)).longValue();
            }
            System.currentTimeMillis();
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(this.f28065b, Uri.parse("android.resource://" + this.f28065b.getPackageName() + "/" + i));
                j = Long.valueOf(mediaMetadataRetriever.extractMetadata(9)).longValue() + 0;
            } catch (IllegalArgumentException e2) {
                e = e2;
                j = 600;
            } catch (IllegalStateException e3) {
                e = e3;
                j = 600;
            } catch (Exception e4) {
                e = e4;
                j = 600;
            }
            try {
                this.f28071h.put(Integer.valueOf(i), Long.valueOf(j));
                return j;
            } catch (IllegalArgumentException e5) {
                e = e5;
                e.printStackTrace();
                return j;
            } catch (IllegalStateException e6) {
                e = e6;
                e.printStackTrace();
                return j;
            } catch (Exception e7) {
                e = e7;
                e.printStackTrace();
                return j;
            }
        }
        return invokeI.longValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.baidu.pass.face.platform.utils.b.a();
            this.f28067d = 0L;
            this.f28068e = 0L;
            this.f28065b = null;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f28070g = z;
        }
    }

    public boolean a(FaceStatusNewEnum faceStatusNewEnum) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, faceStatusNewEnum)) == null) {
            if (!this.f28070g) {
                com.baidu.pass.face.platform.utils.b.a();
            }
            this.f28069f = System.currentTimeMillis() - com.baidu.pass.face.platform.utils.b.a < this.f28067d;
            if (this.f28069f || (this.f28066c == faceStatusNewEnum && System.currentTimeMillis() - this.f28068e < FaceEnvironment.TIME_TIPS_REPEAT)) {
                return false;
            }
            this.f28069f = true;
            this.f28066c = faceStatusNewEnum;
            this.f28067d = 0L;
            this.f28068e = System.currentTimeMillis();
            int soundId = FaceEnvironment.getSoundId(faceStatusNewEnum);
            if (soundId > 0) {
                this.f28067d = a(soundId);
                com.baidu.pass.face.platform.utils.b.a = System.currentTimeMillis();
                if (this.f28070g) {
                    com.baidu.pass.face.platform.utils.b.a(this.f28065b, soundId);
                }
            }
            return this.f28069f;
        }
        return invokeL.booleanValue;
    }
}
