package c.a.v.i;

import android.content.Context;
import android.graphics.Color;
import c.a.v.f.g.j;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class e extends b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, String[]> f21518b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1013599045, "Lc/a/v/i/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1013599045, "Lc/a/v/i/e;");
                return;
            }
        }
        f21518b = new HashMap<>();
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        f21518b.put("color_1F1F1F", new String[]{"#141414", "#BFFFFFFF", "#E6FFFFFF", ""});
        f21518b.put("color_white1", new String[]{"#FFFFFF", "#141414", "#000000", ""});
        f21518b.put("color_white2", new String[]{"#F5F5F5", "#272729", "#141414", ""});
        f21518b.put("color_white3", new String[]{"#FFFFFF", "#D9FFFFFF", "#FFFFFF", ""});
        f21518b.put("color_F5F5F51", new String[]{"#F2F2F5", "#141414", "#000000", ""});
        f21518b.put("color_F5F5F52", new String[]{"#F7F7FA", "#1E1D1F", "#1AFFFFFF", ""});
        f21518b.put("color_F5F5F53", new String[]{"#0D000000", "#0DFFFFFF", "#1AFFFFFF", ""});
        f21518b.put("color_FF33551", new String[]{"#FF3355", "#D42A46", "#FF3355", ""});
        f21518b.put("color_FF33552", new String[]{"#1AFF3355", "#1AD42A46", "#1AFF3355", ""});
        f21518b.put("color_858585", new String[]{"#858585", "#59FFFFFF", "#80FFFFFF", ""});
        f21518b.put("color_525252", new String[]{"#525252", "#555555", "#99FFFFFF", ""});
        f21518b.put("color_FF3333", new String[]{"#FF3333", "#FF3333", "#FF3333", ""});
        f21518b.put("color_768CAE", new String[]{"#768CAE", "#768CAE", "#768CAE", ""});
        f21518b.put("color_4E6EF2", new String[]{"#4E6EF2", "#4E6EF2", "#4E6EF2", ""});
        f21518b.put("color_8585852", new String[]{"#858585", "#444444", "#80FFFFFF", ""});
        f21518b.put("color_5252522", new String[]{"#525252", "#555555", "#99FFFFFF", ""});
        f21518b.put("color_btn_stroke", new String[]{"#00000000", "#00000000", "#00000000", ""});
        f21518b.put("color_btn_fill", new String[]{"#F7F7FA", "#1E1D1F", "#000000", ""});
    }

    @Override // c.a.v.i.b
    public int a(Context context, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, Boolean.valueOf(z), str})) == null) {
            if (f21518b.containsKey(str)) {
                String str2 = f21518b.get(str)[0];
                if (z) {
                    str2 = f21518b.get(str)[3];
                } else {
                    String str3 = this.a;
                    if (SkinManager.SKIN_TYPE_STR_NIGHT == str3) {
                        str2 = f21518b.get(str)[1];
                    } else if (SkinManager.SKIN_TYPE_STR_DARK == str3) {
                        str2 = f21518b.get(str)[2];
                    }
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
