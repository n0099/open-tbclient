package c.a.a0.s;

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
    public static final a f1595h;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f1596b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f1597c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f1598d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1599e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1600f;

    /* renamed from: g  reason: collision with root package name */
    public int f1601g;

    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1457500540, "Lc/a/a0/s/u;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1457500540, "Lc/a/a0/s/u;");
                return;
            }
        }
        f1595h = new a(null);
    }

    public u(boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = z;
        this.f1596b = z2;
        this.f1597c = z3;
        this.f1598d = z4;
        this.f1599e = i;
        this.f1600f = i2;
        this.f1601g = i3;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof u) {
                    u uVar = (u) obj;
                    return this.a == uVar.a && this.f1596b == uVar.f1596b && this.f1597c == uVar.f1597c && this.f1598d == uVar.f1598d && this.f1599e == uVar.f1599e && this.f1600f == uVar.f1600f && this.f1601g == uVar.f1601g;
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
            int i = r0 * 31;
            ?? r2 = this.f1596b;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            ?? r22 = this.f1597c;
            int i4 = r22;
            if (r22 != 0) {
                i4 = 1;
            }
            int i5 = (i3 + i4) * 31;
            boolean z2 = this.f1598d;
            return ((((((i5 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.f1599e) * 31) + this.f1600f) * 31) + this.f1601g;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "CmdPolicy(showTailFrame=" + this.a + ", interactiveOptimizationSwitch=" + this.f1596b + ", unmountLandingUrl=" + this.f1597c + ", isDoubleLayer=" + this.f1598d + ", guideArrowShowTime=" + this.f1599e + ", guideArrowType=" + this.f1600f + ", autoScrollLoopCount=" + this.f1601g + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
