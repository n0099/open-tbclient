package c.a.b0.m;

import androidx.annotation.Nullable;
import c.a.b0.v.h0.n;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public interface d {

    /* loaded from: classes.dex */
    public interface a {
    }

    @Autowired
    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Singleton
        @Inject(force = false)
        public static d a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? n.a() : (d) invokeV.objValue;
        }
    }

    void a(@Nullable String str, @Nullable String str2, @Nullable a aVar);
}
