package c.a.a0.s;

import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public static final a i;
    public transient /* synthetic */ FieldHolder $fh;
    @JvmField
    public int a;
    @JvmField

    /* renamed from: b  reason: collision with root package name */
    public String f1537b;
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public String f1538c;
    @JvmField

    /* renamed from: d  reason: collision with root package name */
    public List<h> f1539d;
    @JvmField

    /* renamed from: e  reason: collision with root package name */
    public c f1540e;
    @JvmField

    /* renamed from: f  reason: collision with root package name */
    public f f1541f;
    @JvmField

    /* renamed from: g  reason: collision with root package name */
    public t f1542g;
    @JvmField

    /* renamed from: h  reason: collision with root package name */
    public String f1543h;

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
        public final g a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                if (jSONObject != null) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("convert");
                    if (optJSONObject == null) {
                        optJSONObject = c.a.a0.x.b.b(jSONObject.optString("convert"));
                    }
                    if (optJSONObject != null) {
                        g gVar = new g();
                        gVar.f1537b = optJSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
                        gVar.f1538c = optJSONObject.optString("button_icon");
                        optJSONObject.optString("textColor");
                        optJSONObject.optInt("buttonShineType");
                        optJSONObject.optString("background_color");
                        gVar.f1543h = optJSONObject.optString("button_scheme");
                        ArrayList arrayList = new ArrayList();
                        JSONArray optJSONArray = optJSONObject.optJSONArray(AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i = 0; i < length; i++) {
                                h a = h.f1544d.a(optJSONArray.optJSONObject(i));
                                if (a != null) {
                                    arrayList.add(a);
                                }
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                        gVar.f1539d = arrayList;
                        return gVar;
                    }
                    return null;
                }
                return null;
            }
            return (g) invokeL.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1457500106, "Lc/a/a0/s/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1457500106, "Lc/a/a0/s/g;");
                return;
            }
        }
        i = new a(null);
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 1;
    }

    @JvmStatic
    public static final g a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) ? i.a(jSONObject) : (g) invokeL.objValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.a == 2 && this.f1540e == null) ? false : true : invokeV.booleanValue;
    }
}
