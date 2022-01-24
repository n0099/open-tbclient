package com.baidu.swan.webcompat.impl;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015R\u001f\u0010\u0006\u001a\u0004\u0018\u00010\u00018F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005R\u001d\u0010\t\u001a\u00020\u00018F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0013\u001a\u00020\u000f8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/baidu/swan/webcompat/impl/FilePathInfo;", "", "filesPath$delegate", "Lkotlin/Lazy;", "getFilesPath", "()Ljava/lang/String;", "filesPath", "filesUrl$delegate", "getFilesUrl", "filesUrl", "Ljava/io/File;", "root", "Ljava/io/File;", "getRoot", "()Ljava/io/File;", "Landroid/net/Uri;", "uri$delegate", "getUri", "()Landroid/net/Uri;", "uri", "<init>", "(Ljava/io/File;)V", "webcompat-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes11.dex */
public final class FilePathInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;

    /* renamed from: b  reason: collision with root package name */
    public final Lazy f40066b;

    /* renamed from: c  reason: collision with root package name */
    public final Lazy f40067c;

    /* renamed from: d  reason: collision with root package name */
    public final File f40068d;

    public FilePathInfo(File root) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {root};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(root, "root");
        this.f40068d = root;
        this.a = LazyKt__LazyJVMKt.lazy(new FilePathInfo$uri$2(this));
        this.f40066b = LazyKt__LazyJVMKt.lazy(new FilePathInfo$filesUrl$2(this));
        this.f40067c = LazyKt__LazyJVMKt.lazy(new FilePathInfo$filesPath$2(this));
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (String) this.f40067c.getValue() : (String) invokeV.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (String) this.f40066b.getValue() : (String) invokeV.objValue;
    }

    public final File c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f40068d : (File) invokeV.objValue;
    }

    public final Uri d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (Uri) this.a.getValue() : (Uri) invokeV.objValue;
    }
}
