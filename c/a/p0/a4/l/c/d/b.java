package c.a.p0.a4.l.c.d;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.utils.FileUtils;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f15504a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f15505b;

    /* renamed from: c  reason: collision with root package name */
    public final HandlerThread f15506c;

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15504a = str;
        HandlerThread handlerThread = new HandlerThread("VideoFrameDiskCacheSaveTask");
        this.f15506c = handlerThread;
        handlerThread.start();
    }

    public Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String c2 = a.c(this.f15504a, str);
            if (FileUtils.isExists(c2)) {
                Bitmap f2 = c.a.v0.t.d.f(c2);
                if (f2 != null) {
                    i.f().g().b(str, f2);
                }
                return f2;
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15504a : (String) invokeV.objValue;
    }

    public void c(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bitmap) == null) {
            if (this.f15505b == null) {
                this.f15505b = new Handler(this.f15506c.getLooper());
            }
            this.f15505b.post(new j(this.f15504a, str, bitmap));
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f15504a = str;
        }
    }
}
