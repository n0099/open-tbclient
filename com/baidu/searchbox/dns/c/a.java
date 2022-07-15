package com.baidu.searchbox.dns.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.rp.service.Service;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.searchbox.dns.d.a.a w;
    public com.baidu.searchbox.dns.d.a x;
    public int y;

    /* renamed from: com.baidu.searchbox.dns.c.a$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.searchbox.dns.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0141a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long A;
        public int B;
        public String C;
        public long D;
        public final com.baidu.searchbox.dns.d.a x;
        public final com.baidu.searchbox.dns.d.a.a z;

        public C0141a(long j, com.baidu.searchbox.dns.d.a aVar, com.baidu.searchbox.dns.d.a.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.B = -1;
            this.D = -1L;
            this.A = j;
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
                    int i = this.B;
                    if (i >= 0) {
                        long j = this.D;
                        if (j > 0) {
                            long j2 = this.A;
                            if (j2 - j > i) {
                                return new a(this.x, null, 1003, null);
                            }
                            if (j2 - j >= Service.TRIGGER_INTERVAL) {
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
                        long j3 = this.D;
                        if (j3 > 0) {
                            if (this.A - j3 > 60000) {
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

    public /* synthetic */ a(com.baidu.searchbox.dns.d.a aVar, com.baidu.searchbox.dns.d.a.a aVar2, int i, AnonymousClass1 anonymousClass1) {
        this(aVar, aVar2, i);
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

    public a(com.baidu.searchbox.dns.d.a aVar, com.baidu.searchbox.dns.d.a.a aVar2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, aVar2, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = aVar;
        this.w = aVar2;
        this.y = i;
    }
}
