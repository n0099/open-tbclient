package com.baidu.searchbox.dns.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.searchbox.dns.d.a.a w;
    public com.baidu.searchbox.dns.d.a x;
    public int y;

    /* renamed from: com.baidu.searchbox.dns.c.a$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.searchbox.dns.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1707a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long A;
        public int B;
        public String C;
        public long D;
        public final com.baidu.searchbox.dns.d.a x;
        public final com.baidu.searchbox.dns.d.a.a z;

        public C1707a(long j2, com.baidu.searchbox.dns.d.a aVar, com.baidu.searchbox.dns.d.a.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.B = -1;
            this.D = -1L;
            this.A = j2;
            this.z = aVar2;
            this.x = aVar;
            if (aVar2 != null) {
                this.B = aVar2.B;
                this.C = aVar2.C;
                this.D = aVar2.D;
            }
        }

        public a k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.z == null) {
                    return new a(this.x, null, 1002, null);
                }
                if (TextUtils.isEmpty(this.C)) {
                    return new a(this.x, null, 1005, null);
                }
                if (this.C.equals("ok")) {
                    int i2 = this.B;
                    if (i2 >= 0) {
                        long j2 = this.D;
                        if (j2 > 0) {
                            long j3 = this.A;
                            if (j3 - j2 > i2) {
                                return new a(this.x, null, 1003, null);
                            }
                            if (j3 - j2 >= 180000) {
                                com.baidu.searchbox.dns.d.a aVar = this.x;
                                if (aVar != null) {
                                    return new a(aVar, this.z, 1001, null);
                                }
                                return new a(null, this.z, 2001, null);
                            }
                            return new a(null, this.z, 2001, null);
                        }
                    }
                    if (this.B < 0) {
                        long j4 = this.D;
                        if (j4 > 0) {
                            if (this.A - j4 > 60000) {
                                return new a(this.x, null, 1007, null);
                            }
                            return new a(null, this.z, 2003, null);
                        }
                    }
                    return new a(this.x, null, 1008, null);
                } else if (this.C.equals("warning")) {
                    if (this.A - this.D >= 60000) {
                        return new a(this.x, null, 1004, null);
                    }
                    return new a(null, null, 2, null);
                } else if (this.C.equals(IntentConfig.STOP)) {
                    if (this.A - this.D >= 300000) {
                        return new a(this.x, null, 1004, null);
                    }
                    return new a(null, null, 2, null);
                } else {
                    return new a(this.x, null, 1004, null);
                }
            }
            return (a) invokeV.objValue;
        }
    }

    public /* synthetic */ a(com.baidu.searchbox.dns.d.a aVar, com.baidu.searchbox.dns.d.a.a aVar2, int i2, AnonymousClass1 anonymousClass1) {
        this(aVar, aVar2, i2);
    }

    public com.baidu.searchbox.dns.d.a.a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.w : (com.baidu.searchbox.dns.d.a.a) invokeV.objValue;
    }

    public com.baidu.searchbox.dns.d.a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.x : (com.baidu.searchbox.dns.d.a) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.y : invokeV.intValue;
    }

    public a(com.baidu.searchbox.dns.d.a aVar, com.baidu.searchbox.dns.d.a.a aVar2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, aVar2, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = aVar;
        this.w = aVar2;
        this.y = i2;
    }
}
