package c.a.d0.s;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class u {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final a f3148h;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f3149b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f3150c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f3151d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3152e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3153f;

    /* renamed from: g  reason: collision with root package name */
    public int f3154g;

    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @JvmStatic
        public final u a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                if (jSONObject != null) {
                    return new u(jSONObject.optInt("show_tail_frame", 0) == 1, jSONObject.optInt("interactive_optimization_switch", 0) == 1, jSONObject.optInt("unmount_lp_url") == 1, jSONObject.optInt("is_double_layers") == 1, jSONObject.optInt("ad_immersive_video_tip_delay", -1), jSONObject.optInt("ad_immersive_video_tip_type", 0), jSONObject.optInt("auto_scroll_loop", 0));
                }
                return null;
            }
            return (u) invokeL.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-174955713, "Lc/a/d0/s/u;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-174955713, "Lc/a/d0/s/u;");
                return;
            }
        }
        f3148h = new a(null);
    }

    public u(boolean z, boolean z2, boolean z3, boolean z4, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = z;
        this.f3149b = z2;
        this.f3150c = z3;
        this.f3151d = z4;
        this.f3152e = i2;
        this.f3153f = i3;
        this.f3154g = i4;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof u) {
                    u uVar = (u) obj;
                    return this.a == uVar.a && this.f3149b == uVar.f3149b && this.f3150c == uVar.f3150c && this.f3151d == uVar.f3151d && this.f3152e == uVar.f3152e && this.f3153f == uVar.f3153f && this.f3154g == uVar.f3154g;
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            boolean z = this.a;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int i2 = r0 * 31;
            ?? r2 = this.f3149b;
            int i3 = r2;
            if (r2 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            ?? r22 = this.f3150c;
            int i5 = r22;
            if (r22 != 0) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            boolean z2 = this.f3151d;
            return ((((((i6 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.f3152e) * 31) + this.f3153f) * 31) + this.f3154g;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "CmdPolicy(showTailFrame=" + this.a + ", interactiveOptimizationSwitch=" + this.f3149b + ", unmountLandingUrl=" + this.f3150c + ", isDoubleLayer=" + this.f3151d + ", guideArrowShowTime=" + this.f3152e + ", guideArrowType=" + this.f3153f + ", autoScrollLoopCount=" + this.f3154g + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
