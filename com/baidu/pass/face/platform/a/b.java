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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "b";
    public transient /* synthetic */ FieldHolder $fh;
    public Context b;
    public FaceStatusNewEnum c;
    public volatile long d;
    public volatile long e;
    public volatile boolean f;
    public volatile boolean g;
    public HashMap<Integer, Long> h;

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
        this.d = 0L;
        this.e = 0L;
        this.f = false;
        this.g = true;
        this.h = new HashMap<>();
        this.b = context;
    }

    private long a(int i) {
        InterceptResult invokeI;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
            if (this.h.containsKey(Integer.valueOf(i))) {
                return this.h.get(Integer.valueOf(i)).longValue();
            }
            System.currentTimeMillis();
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(this.b, Uri.parse("android.resource://" + this.b.getPackageName() + "/" + i));
                j = Long.valueOf(mediaMetadataRetriever.extractMetadata(9)).longValue() + 0;
            } catch (IllegalArgumentException e) {
                e = e;
                j = 600;
            } catch (IllegalStateException e2) {
                e = e2;
                j = 600;
            } catch (Exception e3) {
                e = e3;
                j = 600;
            }
            try {
                this.h.put(Integer.valueOf(i), Long.valueOf(j));
                return j;
            } catch (IllegalArgumentException e4) {
                e = e4;
                e.printStackTrace();
                return j;
            } catch (IllegalStateException e5) {
                e = e5;
                e.printStackTrace();
                return j;
            } catch (Exception e6) {
                e = e6;
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
            this.d = 0L;
            this.e = 0L;
            this.b = null;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.g = z;
        }
    }

    public boolean a(FaceStatusNewEnum faceStatusNewEnum) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, faceStatusNewEnum)) == null) {
            if (!this.g) {
                com.baidu.pass.face.platform.utils.b.a();
            }
            this.f = System.currentTimeMillis() - com.baidu.pass.face.platform.utils.b.a < this.d;
            if (this.f || (this.c == faceStatusNewEnum && System.currentTimeMillis() - this.e < FaceEnvironment.TIME_TIPS_REPEAT)) {
                return false;
            }
            this.f = true;
            this.c = faceStatusNewEnum;
            this.d = 0L;
            this.e = System.currentTimeMillis();
            int soundId = FaceEnvironment.getSoundId(faceStatusNewEnum);
            if (soundId > 0) {
                this.d = a(soundId);
                com.baidu.pass.face.platform.utils.b.a = System.currentTimeMillis();
                if (this.g) {
                    com.baidu.pass.face.platform.utils.b.a(this.b, soundId);
                }
            }
            return this.f;
        }
        return invokeL.booleanValue;
    }
}
