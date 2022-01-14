package c.i.b.a.i0;

import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f29694b;

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f29695c;

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, Integer> f29696d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-717096954, "Lc/i/b/a/i0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-717096954, "Lc/i/b/a/i0/d;");
                return;
            }
        }
        a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        f29694b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        f29695c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
        HashMap hashMap = new HashMap();
        f29696d = hashMap;
        hashMap.put("aliceblue", -984833);
        f29696d.put("antiquewhite", -332841);
        f29696d.put("aqua", -16711681);
        f29696d.put("aquamarine", -8388652);
        f29696d.put("azure", -983041);
        f29696d.put("beige", -657956);
        f29696d.put("bisque", -6972);
        f29696d.put("black", -16777216);
        f29696d.put("blanchedalmond", -5171);
        f29696d.put("blue", -16776961);
        f29696d.put("blueviolet", -7722014);
        f29696d.put("brown", -5952982);
        f29696d.put("burlywood", -2180985);
        f29696d.put("cadetblue", -10510688);
        f29696d.put("chartreuse", -8388864);
        f29696d.put("chocolate", -2987746);
        f29696d.put("coral", -32944);
        f29696d.put("cornflowerblue", -10185235);
        f29696d.put("cornsilk", -1828);
        f29696d.put("crimson", -2354116);
        f29696d.put("cyan", -16711681);
        f29696d.put("darkblue", -16777077);
        f29696d.put("darkcyan", -16741493);
        f29696d.put("darkgoldenrod", -4684277);
        f29696d.put("darkgray", -5658199);
        f29696d.put("darkgreen", -16751616);
        f29696d.put("darkgrey", -5658199);
        f29696d.put("darkkhaki", -4343957);
        f29696d.put("darkmagenta", -7667573);
        f29696d.put("darkolivegreen", -11179217);
        f29696d.put("darkorange", -29696);
        f29696d.put("darkorchid", -6737204);
        f29696d.put("darkred", -7667712);
        f29696d.put("darksalmon", -1468806);
        f29696d.put("darkseagreen", -7357297);
        f29696d.put("darkslateblue", -12042869);
        f29696d.put("darkslategray", -13676721);
        f29696d.put("darkslategrey", -13676721);
        f29696d.put("darkturquoise", -16724271);
        f29696d.put("darkviolet", -7077677);
        f29696d.put("deeppink", -60269);
        f29696d.put("deepskyblue", -16728065);
        f29696d.put("dimgray", -9868951);
        f29696d.put("dimgrey", -9868951);
        f29696d.put("dodgerblue", -14774017);
        f29696d.put("firebrick", -5103070);
        f29696d.put("floralwhite", -1296);
        f29696d.put("forestgreen", -14513374);
        f29696d.put("fuchsia", -65281);
        f29696d.put("gainsboro", -2302756);
        f29696d.put("ghostwhite", -460545);
        f29696d.put("gold", -10496);
        f29696d.put("goldenrod", -2448096);
        f29696d.put("gray", -8355712);
        f29696d.put("green", -16744448);
        f29696d.put("greenyellow", -5374161);
        f29696d.put("grey", -8355712);
        f29696d.put("honeydew", -983056);
        f29696d.put("hotpink", -38476);
        f29696d.put("indianred", -3318692);
        f29696d.put("indigo", -11861886);
        f29696d.put("ivory", -16);
        f29696d.put("khaki", -989556);
        f29696d.put("lavender", -1644806);
        f29696d.put("lavenderblush", -3851);
        f29696d.put("lawngreen", -8586240);
        f29696d.put("lemonchiffon", -1331);
        f29696d.put("lightblue", -5383962);
        f29696d.put("lightcoral", -1015680);
        f29696d.put("lightcyan", -2031617);
        f29696d.put("lightgoldenrodyellow", -329006);
        f29696d.put("lightgray", -2894893);
        f29696d.put("lightgreen", -7278960);
        f29696d.put("lightgrey", -2894893);
        f29696d.put("lightpink", -18751);
        f29696d.put("lightsalmon", -24454);
        f29696d.put("lightseagreen", -14634326);
        f29696d.put("lightskyblue", -7876870);
        f29696d.put("lightslategray", -8943463);
        f29696d.put("lightslategrey", -8943463);
        f29696d.put("lightsteelblue", -5192482);
        f29696d.put("lightyellow", -32);
        f29696d.put("lime", -16711936);
        f29696d.put("limegreen", -13447886);
        f29696d.put("linen", -331546);
        f29696d.put("magenta", -65281);
        f29696d.put("maroon", -8388608);
        f29696d.put("mediumaquamarine", -10039894);
        f29696d.put("mediumblue", -16777011);
        f29696d.put("mediumorchid", -4565549);
        f29696d.put("mediumpurple", -7114533);
        f29696d.put("mediumseagreen", -12799119);
        f29696d.put("mediumslateblue", -8689426);
        f29696d.put("mediumspringgreen", -16713062);
        f29696d.put("mediumturquoise", -12004916);
        f29696d.put("mediumvioletred", -3730043);
        f29696d.put("midnightblue", -15132304);
        f29696d.put("mintcream", -655366);
        f29696d.put("mistyrose", -6943);
        f29696d.put("moccasin", -6987);
        f29696d.put("navajowhite", -8531);
        f29696d.put("navy", -16777088);
        f29696d.put("oldlace", -133658);
        f29696d.put("olive", -8355840);
        f29696d.put("olivedrab", -9728477);
        f29696d.put("orange", -23296);
        f29696d.put("orangered", -47872);
        f29696d.put("orchid", -2461482);
        f29696d.put("palegoldenrod", -1120086);
        f29696d.put("palegreen", -6751336);
        f29696d.put("paleturquoise", -5247250);
        f29696d.put("palevioletred", -2396013);
        f29696d.put("papayawhip", -4139);
        f29696d.put("peachpuff", -9543);
        f29696d.put("peru", -3308225);
        f29696d.put("pink", -16181);
        f29696d.put("plum", -2252579);
        f29696d.put("powderblue", -5185306);
        f29696d.put("purple", -8388480);
        f29696d.put("rebeccapurple", -10079335);
        f29696d.put("red", Integer.valueOf((int) SupportMenu.CATEGORY_MASK));
        f29696d.put("rosybrown", -4419697);
        f29696d.put("royalblue", -12490271);
        f29696d.put("saddlebrown", -7650029);
        f29696d.put("salmon", -360334);
        f29696d.put("sandybrown", -744352);
        f29696d.put("seagreen", -13726889);
        f29696d.put("seashell", -2578);
        f29696d.put("sienna", -6270419);
        f29696d.put("silver", -4144960);
        f29696d.put("skyblue", -7876885);
        f29696d.put("slateblue", -9807155);
        f29696d.put("slategray", -9404272);
        f29696d.put("slategrey", -9404272);
        f29696d.put("snow", -1286);
        f29696d.put("springgreen", -16711809);
        f29696d.put("steelblue", -12156236);
        f29696d.put("tan", -2968436);
        f29696d.put("teal", -16744320);
        f29696d.put("thistle", -2572328);
        f29696d.put("tomato", -40121);
        f29696d.put(OpenFlutter.EXTRA_TRANSPARANT, 0);
        f29696d.put("turquoise", -12525360);
        f29696d.put("violet", -1146130);
        f29696d.put("wheat", -663885);
        f29696d.put("white", -1);
        f29696d.put("whitesmoke", Integer.valueOf((int) BDEmotionPanelManager.COLOR_EMOTION_TYPE_LAYOUT));
        f29696d.put("yellow", -256);
        f29696d.put("yellowgreen", -6632142);
    }

    public static int a(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(65537, null, i2, i3, i4, i5)) == null) ? (i2 << 24) | (i3 << 16) | (i4 << 8) | i5 : invokeIIII.intValue;
    }

    public static int b(String str, boolean z) {
        InterceptResult invokeLZ;
        int parseInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, str, z)) == null) {
            a.a(!TextUtils.isEmpty(str));
            String replace = str.replace(" ", "");
            if (replace.charAt(0) == '#') {
                int parseLong = (int) Long.parseLong(replace.substring(1), 16);
                if (replace.length() == 7) {
                    return (-16777216) | parseLong;
                }
                if (replace.length() == 9) {
                    return ((parseLong & 255) << 24) | (parseLong >>> 8);
                }
                throw new IllegalArgumentException();
            }
            if (replace.startsWith("rgba")) {
                Matcher matcher = (z ? f29695c : f29694b).matcher(replace);
                if (matcher.matches()) {
                    if (z) {
                        parseInt = (int) (Float.parseFloat(matcher.group(4)) * 255.0f);
                    } else {
                        parseInt = Integer.parseInt(matcher.group(4), 10);
                    }
                    return a(parseInt, Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
                }
            } else if (replace.startsWith("rgb")) {
                Matcher matcher2 = a.matcher(replace);
                if (matcher2.matches()) {
                    return e(Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
                }
            } else {
                Integer num = f29696d.get(v.J(replace));
                if (num != null) {
                    return num.intValue();
                }
            }
            throw new IllegalArgumentException();
        }
        return invokeLZ.intValue;
    }

    public static int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? b(str, true) : invokeL.intValue;
    }

    public static int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? b(str, false) : invokeL.intValue;
    }

    public static int e(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65541, null, i2, i3, i4)) == null) ? a(255, i2, i3, i4) : invokeIII.intValue;
    }
}
