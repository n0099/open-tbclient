package com.baidu.bdhttpdns;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class BDHttpDnsResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ResolveType a;
    public final ResolveStatus b;
    public ArrayList<String> c;
    public ArrayList<String> d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class ResolveStatus {
        public static final /* synthetic */ ResolveStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ResolveStatus BDHttpDnsInputError;
        public static final ResolveStatus BDHttpDnsResolveErrorCacheMiss;
        public static final ResolveStatus BDHttpDnsResolveErrorDnsResolve;
        public static final ResolveStatus BDHttpDnsResolveOK;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-836801821, "Lcom/baidu/bdhttpdns/BDHttpDnsResult$ResolveStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-836801821, "Lcom/baidu/bdhttpdns/BDHttpDnsResult$ResolveStatus;");
                    return;
                }
            }
            BDHttpDnsResolveOK = new ResolveStatus("BDHttpDnsResolveOK", 0);
            BDHttpDnsInputError = new ResolveStatus("BDHttpDnsInputError", 1);
            BDHttpDnsResolveErrorCacheMiss = new ResolveStatus("BDHttpDnsResolveErrorCacheMiss", 2);
            ResolveStatus resolveStatus = new ResolveStatus("BDHttpDnsResolveErrorDnsResolve", 3);
            BDHttpDnsResolveErrorDnsResolve = resolveStatus;
            $VALUES = new ResolveStatus[]{BDHttpDnsResolveOK, BDHttpDnsInputError, BDHttpDnsResolveErrorCacheMiss, resolveStatus};
        }

        public ResolveStatus(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ResolveStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (ResolveStatus) Enum.valueOf(ResolveStatus.class, str);
            }
            return (ResolveStatus) invokeL.objValue;
        }

        public static ResolveStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (ResolveStatus[]) $VALUES.clone();
            }
            return (ResolveStatus[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class ResolveType {
        public static final /* synthetic */ ResolveType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ResolveType RESOLVE_FROM_DNS;
        public static final ResolveType RESOLVE_FROM_DNS_CACHE;
        public static final ResolveType RESOLVE_FROM_HTTPDNS_CACHE;
        public static final ResolveType RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE;
        public static final ResolveType RESOLVE_NONE;
        public static final ResolveType RESOLVE_NONEED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2042240229, "Lcom/baidu/bdhttpdns/BDHttpDnsResult$ResolveType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2042240229, "Lcom/baidu/bdhttpdns/BDHttpDnsResult$ResolveType;");
                    return;
                }
            }
            RESOLVE_NONE = new ResolveType("RESOLVE_NONE", 0);
            RESOLVE_NONEED = new ResolveType("RESOLVE_NONEED", 1);
            RESOLVE_FROM_HTTPDNS_CACHE = new ResolveType("RESOLVE_FROM_HTTPDNS_CACHE", 2);
            RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE = new ResolveType("RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE", 3);
            RESOLVE_FROM_DNS_CACHE = new ResolveType("RESOLVE_FROM_DNS_CACHE", 4);
            ResolveType resolveType = new ResolveType("RESOLVE_FROM_DNS", 5);
            RESOLVE_FROM_DNS = resolveType;
            $VALUES = new ResolveType[]{RESOLVE_NONE, RESOLVE_NONEED, RESOLVE_FROM_HTTPDNS_CACHE, RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE, RESOLVE_FROM_DNS_CACHE, resolveType};
        }

        public ResolveType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ResolveType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (ResolveType) Enum.valueOf(ResolveType.class, str);
            }
            return (ResolveType) invokeL.objValue;
        }

        public static ResolveType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (ResolveType[]) $VALUES.clone();
            }
            return (ResolveType[]) invokeV.objValue;
        }
    }

    public BDHttpDnsResult(ResolveStatus resolveStatus) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {resolveStatus};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ResolveType.RESOLVE_NONE;
        this.b = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {resolveType, resolveStatus, arrayList, arrayList2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = ResolveType.RESOLVE_NONE;
        this.a = resolveType;
        this.b = resolveStatus;
        this.c = arrayList;
        this.d = arrayList2;
    }

    public ArrayList<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ArrayList<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ResolveStatus c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (ResolveStatus) invokeV.objValue;
    }

    public ResolveType d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (ResolveType) invokeV.objValue;
    }
}
