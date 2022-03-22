package c.a.v.i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import c.a.v.f.g.j;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class c extends b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, String[]> f21516b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1013599107, "Lc/a/v/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1013599107, "Lc/a/v/i/c;");
                return;
            }
        }
        f21516b = new HashMap<>();
    }

    public c() {
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
        f21516b.put("color_1F1F1F", new String[]{"#1F1F1F", "", "", ""});
        f21516b.put("color_white1", new String[]{"#FFFFFF", "", "", ""});
        f21516b.put("color_white2", new String[]{"#FFFFFF", "", "", ""});
        f21516b.put("color_white3", new String[]{"#FFFFFF", "", "", ""});
        f21516b.put("color_F5F5F51", new String[]{"#F4F5F6", "", "", ""});
        f21516b.put("color_F5F5F52", new String[]{"#F4F5F6", "", "", ""});
        f21516b.put("color_F5F5F53", new String[]{"#F4F5F6", "", "", ""});
        f21516b.put("color_FF33551", new String[]{"#FF3355", "", "", ""});
        f21516b.put("color_FF33552", new String[]{"#1AFF3355", "", "", ""});
        f21516b.put("color_858585", new String[]{"#858585", "", "", ""});
        f21516b.put("color_525252", new String[]{"#525252", "", "", ""});
        f21516b.put("color_FF3333", new String[]{"#FF3333", "", "", ""});
        f21516b.put("color_768CAE", new String[]{"#768CAE", "", "", ""});
        f21516b.put("color_4E6EF2", new String[]{"#4E6EF2", "", "", ""});
        f21516b.put("color_8585852", new String[]{"#858585", "", "", ""});
        f21516b.put("color_5252522", new String[]{"#525252", "", "", ""});
        f21516b.put("color_btn_stroke", new String[]{"#EEEEEE", "", "", ""});
        f21516b.put("color_btn_fill", new String[]{"#00000000", "", "", ""});
        f21516b.put("color_222222", new String[]{"#222222", "", "", ""});
        f21516b.put("color_888888", new String[]{"#888888", "", "", ""});
    }

    @Override // c.a.v.i.b
    @SuppressLint({"Range"})
    public int a(Context context, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, Boolean.valueOf(z), str})) == null) {
            if (f21516b.containsKey(str)) {
                String str2 = "";
                try {
                    str2 = f21516b.get(str)[0];
                    if (z) {
                        str2 = f21516b.get(str)[3];
                    }
                } catch (Exception e2) {
                    LiveFeedPageSdk.m("getColor Exception: " + e2.getMessage());
                }
                if (j.a(str2)) {
                    return -16777216;
                }
                try {
                    return Color.parseColor(str2);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return -16777216;
                }
            }
            return -16777216;
        }
        return invokeCommon.intValue;
    }
}
