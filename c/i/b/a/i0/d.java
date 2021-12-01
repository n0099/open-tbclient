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
/* loaded from: classes7.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f30208b;

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f30209c;

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, Integer> f30210d;
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
        f30208b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        f30209c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
        HashMap hashMap = new HashMap();
        f30210d = hashMap;
        hashMap.put("aliceblue", -984833);
        f30210d.put("antiquewhite", -332841);
        f30210d.put("aqua", -16711681);
        f30210d.put("aquamarine", -8388652);
        f30210d.put("azure", -983041);
        f30210d.put("beige", -657956);
        f30210d.put("bisque", -6972);
        f30210d.put("black", -16777216);
        f30210d.put("blanchedalmond", -5171);
        f30210d.put("blue", -16776961);
        f30210d.put("blueviolet", -7722014);
        f30210d.put("brown", -5952982);
        f30210d.put("burlywood", -2180985);
        f30210d.put("cadetblue", -10510688);
        f30210d.put("chartreuse", -8388864);
        f30210d.put("chocolate", -2987746);
        f30210d.put("coral", -32944);
        f30210d.put("cornflowerblue", -10185235);
        f30210d.put("cornsilk", -1828);
        f30210d.put("crimson", -2354116);
        f30210d.put("cyan", -16711681);
        f30210d.put("darkblue", -16777077);
        f30210d.put("darkcyan", -16741493);
        f30210d.put("darkgoldenrod", -4684277);
        f30210d.put("darkgray", -5658199);
        f30210d.put("darkgreen", -16751616);
        f30210d.put("darkgrey", -5658199);
        f30210d.put("darkkhaki", -4343957);
        f30210d.put("darkmagenta", -7667573);
        f30210d.put("darkolivegreen", -11179217);
        f30210d.put("darkorange", -29696);
        f30210d.put("darkorchid", -6737204);
        f30210d.put("darkred", -7667712);
        f30210d.put("darksalmon", -1468806);
        f30210d.put("darkseagreen", -7357297);
        f30210d.put("darkslateblue", -12042869);
        f30210d.put("darkslategray", -13676721);
        f30210d.put("darkslategrey", -13676721);
        f30210d.put("darkturquoise", -16724271);
        f30210d.put("darkviolet", -7077677);
        f30210d.put("deeppink", -60269);
        f30210d.put("deepskyblue", -16728065);
        f30210d.put("dimgray", -9868951);
        f30210d.put("dimgrey", -9868951);
        f30210d.put("dodgerblue", -14774017);
        f30210d.put("firebrick", -5103070);
        f30210d.put("floralwhite", -1296);
        f30210d.put("forestgreen", -14513374);
        f30210d.put("fuchsia", -65281);
        f30210d.put("gainsboro", -2302756);
        f30210d.put("ghostwhite", -460545);
        f30210d.put("gold", -10496);
        f30210d.put("goldenrod", -2448096);
        f30210d.put("gray", -8355712);
        f30210d.put("green", -16744448);
        f30210d.put("greenyellow", -5374161);
        f30210d.put("grey", -8355712);
        f30210d.put("honeydew", -983056);
        f30210d.put("hotpink", -38476);
        f30210d.put("indianred", -3318692);
        f30210d.put("indigo", -11861886);
        f30210d.put("ivory", -16);
        f30210d.put("khaki", -989556);
        f30210d.put("lavender", -1644806);
        f30210d.put("lavenderblush", -3851);
        f30210d.put("lawngreen", -8586240);
        f30210d.put("lemonchiffon", -1331);
        f30210d.put("lightblue", -5383962);
        f30210d.put("lightcoral", -1015680);
        f30210d.put("lightcyan", -2031617);
        f30210d.put("lightgoldenrodyellow", -329006);
        f30210d.put("lightgray", -2894893);
        f30210d.put("lightgreen", -7278960);
        f30210d.put("lightgrey", -2894893);
        f30210d.put("lightpink", -18751);
        f30210d.put("lightsalmon", -24454);
        f30210d.put("lightseagreen", -14634326);
        f30210d.put("lightskyblue", -7876870);
        f30210d.put("lightslategray", -8943463);
        f30210d.put("lightslategrey", -8943463);
        f30210d.put("lightsteelblue", -5192482);
        f30210d.put("lightyellow", -32);
        f30210d.put("lime", -16711936);
        f30210d.put("limegreen", -13447886);
        f30210d.put("linen", -331546);
        f30210d.put("magenta", -65281);
        f30210d.put("maroon", -8388608);
        f30210d.put("mediumaquamarine", -10039894);
        f30210d.put("mediumblue", -16777011);
        f30210d.put("mediumorchid", -4565549);
        f30210d.put("mediumpurple", -7114533);
        f30210d.put("mediumseagreen", -12799119);
        f30210d.put("mediumslateblue", -8689426);
        f30210d.put("mediumspringgreen", -16713062);
        f30210d.put("mediumturquoise", -12004916);
        f30210d.put("mediumvioletred", -3730043);
        f30210d.put("midnightblue", -15132304);
        f30210d.put("mintcream", -655366);
        f30210d.put("mistyrose", -6943);
        f30210d.put("moccasin", -6987);
        f30210d.put("navajowhite", -8531);
        f30210d.put("navy", -16777088);
        f30210d.put("oldlace", -133658);
        f30210d.put("olive", -8355840);
        f30210d.put("olivedrab", -9728477);
        f30210d.put("orange", -23296);
        f30210d.put("orangered", -47872);
        f30210d.put("orchid", -2461482);
        f30210d.put("palegoldenrod", -1120086);
        f30210d.put("palegreen", -6751336);
        f30210d.put("paleturquoise", -5247250);
        f30210d.put("palevioletred", -2396013);
        f30210d.put("papayawhip", -4139);
        f30210d.put("peachpuff", -9543);
        f30210d.put("peru", -3308225);
        f30210d.put("pink", -16181);
        f30210d.put("plum", -2252579);
        f30210d.put("powderblue", -5185306);
        f30210d.put("purple", -8388480);
        f30210d.put("rebeccapurple", -10079335);
        f30210d.put("red", Integer.valueOf((int) SupportMenu.CATEGORY_MASK));
        f30210d.put("rosybrown", -4419697);
        f30210d.put("royalblue", -12490271);
        f30210d.put("saddlebrown", -7650029);
        f30210d.put("salmon", -360334);
        f30210d.put("sandybrown", -744352);
        f30210d.put("seagreen", -13726889);
        f30210d.put("seashell", -2578);
        f30210d.put("sienna", -6270419);
        f30210d.put("silver", -4144960);
        f30210d.put("skyblue", -7876885);
        f30210d.put("slateblue", -9807155);
        f30210d.put("slategray", -9404272);
        f30210d.put("slategrey", -9404272);
        f30210d.put("snow", -1286);
        f30210d.put("springgreen", -16711809);
        f30210d.put("steelblue", -12156236);
        f30210d.put("tan", -2968436);
        f30210d.put("teal", -16744320);
        f30210d.put("thistle", -2572328);
        f30210d.put("tomato", -40121);
        f30210d.put(OpenFlutter.EXTRA_TRANSPARANT, 0);
        f30210d.put("turquoise", -12525360);
        f30210d.put("violet", -1146130);
        f30210d.put("wheat", -663885);
        f30210d.put("white", -1);
        f30210d.put("whitesmoke", Integer.valueOf((int) BDEmotionPanelManager.COLOR_EMOTION_TYPE_LAYOUT));
        f30210d.put("yellow", -256);
        f30210d.put("yellowgreen", -6632142);
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
                Matcher matcher = (z ? f30209c : f30208b).matcher(replace);
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
                Integer num = f30210d.get(v.J(replace));
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
