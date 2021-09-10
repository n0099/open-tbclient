package c.a.j0.a.c;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
/* loaded from: classes.dex */
public class c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public T f3577a;

    public c(T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3577a = t;
    }

    public T a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3577a : (T) invokeV.objValue;
    }

    public byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            T t = this.f3577a;
            if (t instanceof Bitmap) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ((Bitmap) this.f3577a).compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            } else if (t instanceof File) {
                return c.a.j0.a.k.d.a((File) t);
            } else {
                if (t instanceof byte[]) {
                    return (byte[]) t;
                }
                return null;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    public Class<?> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f3577a.getClass() : (Class) invokeV.objValue;
    }

    public boolean d(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) ? (this.f3577a instanceof File) && System.currentTimeMillis() - ((File) this.f3577a).lastModified() > j2 : invokeJ.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        boolean delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            T t = this.f3577a;
            if (t instanceof Bitmap) {
                if (!((Bitmap) t).isRecycled()) {
                    ((Bitmap) this.f3577a).recycle();
                }
            } else if (t instanceof File) {
                delete = ((File) t).delete();
                this.f3577a = null;
                return delete;
            }
            delete = true;
            this.f3577a = null;
            return delete;
        }
        return invokeV.booleanValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            T t = this.f3577a;
            if (t instanceof Bitmap) {
                return ((Bitmap) t).getByteCount();
            }
            if (t instanceof File) {
                return (int) ((File) t).length();
            }
            if (t instanceof byte[]) {
                return ((byte[]) t).length;
            }
            return 1;
        }
        return invokeV.intValue;
    }
}
