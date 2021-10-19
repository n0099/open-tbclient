package c.a.w.i;

import android.content.Context;
import android.graphics.Color;
import c.a.w.e.g.j;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class d extends b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, String[]> f30610b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-984969925, "Lc/a/w/i/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-984969925, "Lc/a/w/i/d;");
                return;
            }
        }
        f30610b = new HashMap<>();
    }

    public d() {
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
        f30610b.put("color_1F1F1F", new String[]{"#1F1F1F", "", "", ""});
        f30610b.put("color_white1", new String[]{"#FFFFFF", "", "", ""});
        f30610b.put("color_white2", new String[]{"#FFFFFF", "", "", ""});
        f30610b.put("color_white3", new String[]{"#FFFFFF", "", "", ""});
        f30610b.put("color_F5F5F51", new String[]{"#F5F5F5", "", "", ""});
        f30610b.put("color_F5F5F52", new String[]{"#F5F5F5", "", "", ""});
        f30610b.put("color_F5F5F53", new String[]{"#F5F5F5", "", "", ""});
        f30610b.put("color_FF33551", new String[]{"#FF3355", "", "", ""});
        f30610b.put("color_FF33552", new String[]{"#1AFF3355", "", "", ""});
        f30610b.put("color_858585", new String[]{"#858585", "", "", ""});
        f30610b.put("color_525252", new String[]{"#525252", "", "", ""});
        f30610b.put("color_FF3333", new String[]{"#FF3333", "", "", ""});
        f30610b.put("color_768CAE", new String[]{"#768CAE", "", "", ""});
        f30610b.put("color_4E6EF2", new String[]{"#4E6EF2", "", "", ""});
        f30610b.put("color_8585852", new String[]{"#858585", "", "", ""});
        f30610b.put("color_5252522", new String[]{"#525252", "", "", ""});
        f30610b.put("color_btn_stroke", new String[]{"#EEEEEE", "", "", ""});
        f30610b.put("color_btn_fill", new String[]{"#00000000", "", "", ""});
    }

    @Override // c.a.w.i.b
    public int a(Context context, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, Boolean.valueOf(z), str})) == null) {
            if (f30610b.containsKey(str)) {
                String str2 = f30610b.get(str)[0];
                if (z) {
                    str2 = f30610b.get(str)[3];
                }
                if (j.a(str2)) {
                    return -16777216;
                }
                try {
                    return Color.parseColor(str2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return -16777216;
                }
            }
            return -16777216;
        }
        return invokeCommon.intValue;
    }
}
