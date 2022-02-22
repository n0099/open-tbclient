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
    public static final Pattern f29928b;

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f29929c;

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, Integer> f29930d;
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
        f29928b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        f29929c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
        HashMap hashMap = new HashMap();
        f29930d = hashMap;
        hashMap.put("aliceblue", -984833);
        f29930d.put("antiquewhite", -332841);
        f29930d.put("aqua", -16711681);
        f29930d.put("aquamarine", -8388652);
        f29930d.put("azure", -983041);
        f29930d.put("beige", -657956);
        f29930d.put("bisque", -6972);
        f29930d.put("black", -16777216);
        f29930d.put("blanchedalmond", -5171);
        f29930d.put("blue", -16776961);
        f29930d.put("blueviolet", -7722014);
        f29930d.put("brown", -5952982);
        f29930d.put("burlywood", -2180985);
        f29930d.put("cadetblue", -10510688);
        f29930d.put("chartreuse", -8388864);
        f29930d.put("chocolate", -2987746);
        f29930d.put("coral", -32944);
        f29930d.put("cornflowerblue", -10185235);
        f29930d.put("cornsilk", -1828);
        f29930d.put("crimson", -2354116);
        f29930d.put("cyan", -16711681);
        f29930d.put("darkblue", -16777077);
        f29930d.put("darkcyan", -16741493);
        f29930d.put("darkgoldenrod", -4684277);
        f29930d.put("darkgray", -5658199);
        f29930d.put("darkgreen", -16751616);
        f29930d.put("darkgrey", -5658199);
        f29930d.put("darkkhaki", -4343957);
        f29930d.put("darkmagenta", -7667573);
        f29930d.put("darkolivegreen", -11179217);
        f29930d.put("darkorange", -29696);
        f29930d.put("darkorchid", -6737204);
        f29930d.put("darkred", -7667712);
        f29930d.put("darksalmon", -1468806);
        f29930d.put("darkseagreen", -7357297);
        f29930d.put("darkslateblue", -12042869);
        f29930d.put("darkslategray", -13676721);
        f29930d.put("darkslategrey", -13676721);
        f29930d.put("darkturquoise", -16724271);
        f29930d.put("darkviolet", -7077677);
        f29930d.put("deeppink", -60269);
        f29930d.put("deepskyblue", -16728065);
        f29930d.put("dimgray", -9868951);
        f29930d.put("dimgrey", -9868951);
        f29930d.put("dodgerblue", -14774017);
        f29930d.put("firebrick", -5103070);
        f29930d.put("floralwhite", -1296);
        f29930d.put("forestgreen", -14513374);
        f29930d.put("fuchsia", -65281);
        f29930d.put("gainsboro", -2302756);
        f29930d.put("ghostwhite", -460545);
        f29930d.put("gold", -10496);
        f29930d.put("goldenrod", -2448096);
        f29930d.put("gray", -8355712);
        f29930d.put("green", -16744448);
        f29930d.put("greenyellow", -5374161);
        f29930d.put("grey", -8355712);
        f29930d.put("honeydew", -983056);
        f29930d.put("hotpink", -38476);
        f29930d.put("indianred", -3318692);
        f29930d.put("indigo", -11861886);
        f29930d.put("ivory", -16);
        f29930d.put("khaki", -989556);
        f29930d.put("lavender", -1644806);
        f29930d.put("lavenderblush", -3851);
        f29930d.put("lawngreen", -8586240);
        f29930d.put("lemonchiffon", -1331);
        f29930d.put("lightblue", -5383962);
        f29930d.put("lightcoral", -1015680);
        f29930d.put("lightcyan", -2031617);
        f29930d.put("lightgoldenrodyellow", -329006);
        f29930d.put("lightgray", -2894893);
        f29930d.put("lightgreen", -7278960);
        f29930d.put("lightgrey", -2894893);
        f29930d.put("lightpink", -18751);
        f29930d.put("lightsalmon", -24454);
        f29930d.put("lightseagreen", -14634326);
        f29930d.put("lightskyblue", -7876870);
        f29930d.put("lightslategray", -8943463);
        f29930d.put("lightslategrey", -8943463);
        f29930d.put("lightsteelblue", -5192482);
        f29930d.put("lightyellow", -32);
        f29930d.put("lime", -16711936);
        f29930d.put("limegreen", -13447886);
        f29930d.put("linen", -331546);
        f29930d.put("magenta", -65281);
        f29930d.put("maroon", -8388608);
        f29930d.put("mediumaquamarine", -10039894);
        f29930d.put("mediumblue", -16777011);
        f29930d.put("mediumorchid", -4565549);
        f29930d.put("mediumpurple", -7114533);
        f29930d.put("mediumseagreen", -12799119);
        f29930d.put("mediumslateblue", -8689426);
        f29930d.put("mediumspringgreen", -16713062);
        f29930d.put("mediumturquoise", -12004916);
        f29930d.put("mediumvioletred", -3730043);
        f29930d.put("midnightblue", -15132304);
        f29930d.put("mintcream", -655366);
        f29930d.put("mistyrose", -6943);
        f29930d.put("moccasin", -6987);
        f29930d.put("navajowhite", -8531);
        f29930d.put("navy", -16777088);
        f29930d.put("oldlace", -133658);
        f29930d.put("olive", -8355840);
        f29930d.put("olivedrab", -9728477);
        f29930d.put("orange", -23296);
        f29930d.put("orangered", -47872);
        f29930d.put("orchid", -2461482);
        f29930d.put("palegoldenrod", -1120086);
        f29930d.put("palegreen", -6751336);
        f29930d.put("paleturquoise", -5247250);
        f29930d.put("palevioletred", -2396013);
        f29930d.put("papayawhip", -4139);
        f29930d.put("peachpuff", -9543);
        f29930d.put("peru", -3308225);
        f29930d.put("pink", -16181);
        f29930d.put("plum", -2252579);
        f29930d.put("powderblue", -5185306);
        f29930d.put("purple", -8388480);
        f29930d.put("rebeccapurple", -10079335);
        f29930d.put("red", Integer.valueOf((int) SupportMenu.CATEGORY_MASK));
        f29930d.put("rosybrown", -4419697);
        f29930d.put("royalblue", -12490271);
        f29930d.put("saddlebrown", -7650029);
        f29930d.put("salmon", -360334);
        f29930d.put("sandybrown", -744352);
        f29930d.put("seagreen", -13726889);
        f29930d.put("seashell", -2578);
        f29930d.put("sienna", -6270419);
        f29930d.put("silver", -4144960);
        f29930d.put("skyblue", -7876885);
        f29930d.put("slateblue", -9807155);
        f29930d.put("slategray", -9404272);
        f29930d.put("slategrey", -9404272);
        f29930d.put("snow", -1286);
        f29930d.put("springgreen", -16711809);
        f29930d.put("steelblue", -12156236);
        f29930d.put("tan", -2968436);
        f29930d.put("teal", -16744320);
        f29930d.put("thistle", -2572328);
        f29930d.put("tomato", -40121);
        f29930d.put(OpenFlutter.EXTRA_TRANSPARANT, 0);
        f29930d.put("turquoise", -12525360);
        f29930d.put("violet", -1146130);
        f29930d.put("wheat", -663885);
        f29930d.put("white", -1);
        f29930d.put("whitesmoke", Integer.valueOf((int) BDEmotionPanelManager.COLOR_EMOTION_TYPE_LAYOUT));
        f29930d.put("yellow", -256);
        f29930d.put("yellowgreen", -6632142);
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
                Matcher matcher = (z ? f29929c : f29928b).matcher(replace);
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
                Integer num = f29930d.get(v.J(replace));
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
