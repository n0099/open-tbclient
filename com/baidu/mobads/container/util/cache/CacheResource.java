package com.baidu.mobads.container.util.cache;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.FileUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
/* loaded from: classes2.dex */
public class CacheResource<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T resource;

    public CacheResource(T t) {
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
        this.resource = t;
    }

    public T get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.resource : (T) invokeV.objValue;
    }

    public byte[] getByte() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            T t = this.resource;
            if (t instanceof Bitmap) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ((Bitmap) this.resource).compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            } else if (t instanceof File) {
                return FileUtils.readFileToByteArray((File) t);
            } else {
                if (t instanceof byte[]) {
                    return (byte[]) t;
                }
                return null;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    public Class<?> getResourceClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.resource.getClass() : (Class) invokeV.objValue;
    }

    public boolean isExpired(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) ? (this.resource instanceof File) && System.currentTimeMillis() - ((File) this.resource).lastModified() > j : invokeJ.booleanValue;
    }

    public boolean recycle() {
        InterceptResult invokeV;
        boolean delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            T t = this.resource;
            if (t instanceof Bitmap) {
                if (!((Bitmap) t).isRecycled()) {
                    ((Bitmap) this.resource).recycle();
                }
            } else if (t instanceof File) {
                delete = ((File) t).delete();
                this.resource = null;
                return delete;
            }
            delete = true;
            this.resource = null;
            return delete;
        }
        return invokeV.booleanValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            T t = this.resource;
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
