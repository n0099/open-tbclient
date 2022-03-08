package com.baidu.nadcore.requester;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.b0.s.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes4.dex */
public class RequestParameters {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final int f35753b;

    /* renamed from: c  reason: collision with root package name */
    public final String f35754c;

    /* renamed from: d  reason: collision with root package name */
    public final String f35755d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final s f35756e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final RefreshType f35757f;

    /* renamed from: g  reason: collision with root package name */
    public final String f35758g;

    /* renamed from: h  reason: collision with root package name */
    public final String f35759h;

    /* renamed from: i  reason: collision with root package name */
    public final String f35760i;

    /* renamed from: j  reason: collision with root package name */
    public final SlotType f35761j;
    public final Map<String, String> k;
    public final boolean l;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class RefreshType {
        public static final /* synthetic */ RefreshType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RefreshType NONE;
        public static final RefreshType PULL_DOWN;
        public static final RefreshType PULL_UP;
        public transient /* synthetic */ FieldHolder $fh;
        public final String value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1443753553, "Lcom/baidu/nadcore/requester/RequestParameters$RefreshType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1443753553, "Lcom/baidu/nadcore/requester/RequestParameters$RefreshType;");
                    return;
                }
            }
            NONE = new RefreshType("NONE", 0, null);
            PULL_UP = new RefreshType("PULL_UP", 1, "3");
            RefreshType refreshType = new RefreshType("PULL_DOWN", 2, "4");
            PULL_DOWN = refreshType;
            $VALUES = new RefreshType[]{NONE, PULL_UP, refreshType};
        }

        public RefreshType(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = str2;
        }

        public static RefreshType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RefreshType) Enum.valueOf(RefreshType.class, str) : (RefreshType) invokeL.objValue;
        }

        public static RefreshType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RefreshType[]) $VALUES.clone() : (RefreshType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class SlotType {
        public static final /* synthetic */ SlotType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SlotType BANNER;
        public static final SlotType DEFAULT;
        public static final SlotType DRAW;
        public static final SlotType FEED;
        public static final SlotType REWARD;
        public static final SlotType SPLASH;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(875916440, "Lcom/baidu/nadcore/requester/RequestParameters$SlotType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(875916440, "Lcom/baidu/nadcore/requester/RequestParameters$SlotType;");
                    return;
                }
            }
            DEFAULT = new SlotType(EngineName.DEFAULT_ENGINE, 0);
            SPLASH = new SlotType("SPLASH", 1);
            FEED = new SlotType("FEED", 2);
            BANNER = new SlotType("BANNER", 3);
            DRAW = new SlotType("DRAW", 4);
            SlotType slotType = new SlotType("REWARD", 5);
            REWARD = slotType;
            $VALUES = new SlotType[]{DEFAULT, SPLASH, FEED, BANNER, DRAW, slotType};
        }

        public SlotType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SlotType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SlotType) Enum.valueOf(SlotType.class, str) : (SlotType) invokeL.objValue;
        }

        public static SlotType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SlotType[]) $VALUES.clone() : (SlotType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public int f35762b;

        /* renamed from: c  reason: collision with root package name */
        public String f35763c;

        /* renamed from: d  reason: collision with root package name */
        public String f35764d;

        /* renamed from: e  reason: collision with root package name */
        public s f35765e;

        /* renamed from: f  reason: collision with root package name */
        public RefreshType f35766f;

        /* renamed from: g  reason: collision with root package name */
        public String f35767g;

        /* renamed from: h  reason: collision with root package name */
        public SlotType f35768h;

        /* renamed from: i  reason: collision with root package name */
        public String f35769i;

        /* renamed from: j  reason: collision with root package name */
        public String f35770j;
        public Map<String, String> k;
        public boolean l;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35762b = 1;
            this.f35766f = RefreshType.NONE;
            this.f35768h = SlotType.DEFAULT;
            this.l = false;
        }

        public RequestParameters m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new RequestParameters(this, null) : (RequestParameters) invokeV.objValue;
        }

        public b n(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                this.f35762b = (i2 <= 0 || i2 >= 10) ? 2 : 2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b o(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.a = str;
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    public /* synthetic */ RequestParameters(b bVar, a aVar) {
        this(bVar);
    }

    public RequestParameters(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bVar.a;
        this.f35753b = bVar.f35762b;
        this.f35754c = bVar.f35764d;
        this.f35755d = bVar.f35763c;
        this.f35756e = bVar.f35765e;
        this.f35757f = bVar.f35766f;
        this.f35758g = bVar.f35767g;
        this.f35759h = bVar.f35769i;
        this.f35760i = bVar.f35770j;
        this.f35761j = bVar.f35768h;
        this.k = bVar.k;
        this.l = bVar.l;
    }
}
