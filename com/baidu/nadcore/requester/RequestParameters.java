package com.baidu.nadcore.requester;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.tieba.cq0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.util.Map;
/* loaded from: classes2.dex */
public class RequestParameters {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final int b;
    public final String c;
    public final String d;
    @Nullable
    public final cq0 e;
    @NonNull
    public final RefreshType f;
    public final String g;
    public final String h;
    public final String i;
    public final SlotType j;
    @Nullable
    public final Map<String, String> k;
    @Nullable
    public final Map<String, String> l;
    public final boolean m;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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
            NONE = new RefreshType(HlsPlaylistParser.METHOD_NONE, 0, null);
            PULL_UP = new RefreshType("PULL_UP", 1, "3");
            RefreshType refreshType = new RefreshType("PULL_DOWN", 2, "4");
            PULL_DOWN = refreshType;
            $VALUES = new RefreshType[]{NONE, PULL_UP, refreshType};
        }

        public RefreshType(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (RefreshType) Enum.valueOf(RefreshType.class, str);
            }
            return (RefreshType) invokeL.objValue;
        }

        public static RefreshType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (RefreshType[]) $VALUES.clone();
            }
            return (RefreshType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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

        public SlotType(String str, int i) {
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

        public static SlotType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (SlotType) Enum.valueOf(SlotType.class, str);
            }
            return (SlotType) invokeL.objValue;
        }

        public static SlotType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (SlotType[]) $VALUES.clone();
            }
            return (SlotType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public String c;
        public String d;
        public cq0 e;
        public RefreshType f;
        public String g;
        public SlotType h;
        public String i;
        public String j;
        public Map<String, String> k;
        public Map<String, String> l;
        public boolean m;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = 1;
            this.f = RefreshType.NONE;
            this.h = SlotType.DEFAULT;
            this.m = false;
        }

        public RequestParameters o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new RequestParameters(this, null);
            }
            return (RequestParameters) invokeV.objValue;
        }

        public b n(@NonNull Map<String, String> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
                this.l = map;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b p(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.b = (i <= 0 || i >= 10) ? 2 : 2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b q(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.a = str;
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    public RequestParameters(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.d;
        this.d = bVar.c;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.i;
        this.i = bVar.j;
        this.j = bVar.h;
        this.k = bVar.k;
        this.m = bVar.m;
        this.l = bVar.l;
    }

    public /* synthetic */ RequestParameters(b bVar, a aVar) {
        this(bVar);
    }
}
