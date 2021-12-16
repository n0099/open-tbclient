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
    public static final Pattern f30578b;

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f30579c;

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, Integer> f30580d;
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
        f30578b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        f30579c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
        HashMap hashMap = new HashMap();
        f30580d = hashMap;
        hashMap.put("aliceblue", -984833);
        f30580d.put("antiquewhite", -332841);
        f30580d.put("aqua", -16711681);
        f30580d.put("aquamarine", -8388652);
        f30580d.put("azure", -983041);
        f30580d.put("beige", -657956);
        f30580d.put("bisque", -6972);
        f30580d.put("black", -16777216);
        f30580d.put("blanchedalmond", -5171);
        f30580d.put("blue", -16776961);
        f30580d.put("blueviolet", -7722014);
        f30580d.put("brown", -5952982);
        f30580d.put("burlywood", -2180985);
        f30580d.put("cadetblue", -10510688);
        f30580d.put("chartreuse", -8388864);
        f30580d.put("chocolate", -2987746);
        f30580d.put("coral", -32944);
        f30580d.put("cornflowerblue", -10185235);
        f30580d.put("cornsilk", -1828);
        f30580d.put("crimson", -2354116);
        f30580d.put("cyan", -16711681);
        f30580d.put("darkblue", -16777077);
        f30580d.put("darkcyan", -16741493);
        f30580d.put("darkgoldenrod", -4684277);
        f30580d.put("darkgray", -5658199);
        f30580d.put("darkgreen", -16751616);
        f30580d.put("darkgrey", -5658199);
        f30580d.put("darkkhaki", -4343957);
        f30580d.put("darkmagenta", -7667573);
        f30580d.put("darkolivegreen", -11179217);
        f30580d.put("darkorange", -29696);
        f30580d.put("darkorchid", -6737204);
        f30580d.put("darkred", -7667712);
        f30580d.put("darksalmon", -1468806);
        f30580d.put("darkseagreen", -7357297);
        f30580d.put("darkslateblue", -12042869);
        f30580d.put("darkslategray", -13676721);
        f30580d.put("darkslategrey", -13676721);
        f30580d.put("darkturquoise", -16724271);
        f30580d.put("darkviolet", -7077677);
        f30580d.put("deeppink", -60269);
        f30580d.put("deepskyblue", -16728065);
        f30580d.put("dimgray", -9868951);
        f30580d.put("dimgrey", -9868951);
        f30580d.put("dodgerblue", -14774017);
        f30580d.put("firebrick", -5103070);
        f30580d.put("floralwhite", -1296);
        f30580d.put("forestgreen", -14513374);
        f30580d.put("fuchsia", -65281);
        f30580d.put("gainsboro", -2302756);
        f30580d.put("ghostwhite", -460545);
        f30580d.put("gold", -10496);
        f30580d.put("goldenrod", -2448096);
        f30580d.put("gray", -8355712);
        f30580d.put("green", -16744448);
        f30580d.put("greenyellow", -5374161);
        f30580d.put("grey", -8355712);
        f30580d.put("honeydew", -983056);
        f30580d.put("hotpink", -38476);
        f30580d.put("indianred", -3318692);
        f30580d.put("indigo", -11861886);
        f30580d.put("ivory", -16);
        f30580d.put("khaki", -989556);
        f30580d.put("lavender", -1644806);
        f30580d.put("lavenderblush", -3851);
        f30580d.put("lawngreen", -8586240);
        f30580d.put("lemonchiffon", -1331);
        f30580d.put("lightblue", -5383962);
        f30580d.put("lightcoral", -1015680);
        f30580d.put("lightcyan", -2031617);
        f30580d.put("lightgoldenrodyellow", -329006);
        f30580d.put("lightgray", -2894893);
        f30580d.put("lightgreen", -7278960);
        f30580d.put("lightgrey", -2894893);
        f30580d.put("lightpink", -18751);
        f30580d.put("lightsalmon", -24454);
        f30580d.put("lightseagreen", -14634326);
        f30580d.put("lightskyblue", -7876870);
        f30580d.put("lightslategray", -8943463);
        f30580d.put("lightslategrey", -8943463);
        f30580d.put("lightsteelblue", -5192482);
        f30580d.put("lightyellow", -32);
        f30580d.put("lime", -16711936);
        f30580d.put("limegreen", -13447886);
        f30580d.put("linen", -331546);
        f30580d.put("magenta", -65281);
        f30580d.put("maroon", -8388608);
        f30580d.put("mediumaquamarine", -10039894);
        f30580d.put("mediumblue", -16777011);
        f30580d.put("mediumorchid", -4565549);
        f30580d.put("mediumpurple", -7114533);
        f30580d.put("mediumseagreen", -12799119);
        f30580d.put("mediumslateblue", -8689426);
        f30580d.put("mediumspringgreen", -16713062);
        f30580d.put("mediumturquoise", -12004916);
        f30580d.put("mediumvioletred", -3730043);
        f30580d.put("midnightblue", -15132304);
        f30580d.put("mintcream", -655366);
        f30580d.put("mistyrose", -6943);
        f30580d.put("moccasin", -6987);
        f30580d.put("navajowhite", -8531);
        f30580d.put("navy", -16777088);
        f30580d.put("oldlace", -133658);
        f30580d.put("olive", -8355840);
        f30580d.put("olivedrab", -9728477);
        f30580d.put("orange", -23296);
        f30580d.put("orangered", -47872);
        f30580d.put("orchid", -2461482);
        f30580d.put("palegoldenrod", -1120086);
        f30580d.put("palegreen", -6751336);
        f30580d.put("paleturquoise", -5247250);
        f30580d.put("palevioletred", -2396013);
        f30580d.put("papayawhip", -4139);
        f30580d.put("peachpuff", -9543);
        f30580d.put("peru", -3308225);
        f30580d.put("pink", -16181);
        f30580d.put("plum", -2252579);
        f30580d.put("powderblue", -5185306);
        f30580d.put("purple", -8388480);
        f30580d.put("rebeccapurple", -10079335);
        f30580d.put("red", Integer.valueOf((int) SupportMenu.CATEGORY_MASK));
        f30580d.put("rosybrown", -4419697);
        f30580d.put("royalblue", -12490271);
        f30580d.put("saddlebrown", -7650029);
        f30580d.put("salmon", -360334);
        f30580d.put("sandybrown", -744352);
        f30580d.put("seagreen", -13726889);
        f30580d.put("seashell", -2578);
        f30580d.put("sienna", -6270419);
        f30580d.put("silver", -4144960);
        f30580d.put("skyblue", -7876885);
        f30580d.put("slateblue", -9807155);
        f30580d.put("slategray", -9404272);
        f30580d.put("slategrey", -9404272);
        f30580d.put("snow", -1286);
        f30580d.put("springgreen", -16711809);
        f30580d.put("steelblue", -12156236);
        f30580d.put("tan", -2968436);
        f30580d.put("teal", -16744320);
        f30580d.put("thistle", -2572328);
        f30580d.put("tomato", -40121);
        f30580d.put(OpenFlutter.EXTRA_TRANSPARANT, 0);
        f30580d.put("turquoise", -12525360);
        f30580d.put("violet", -1146130);
        f30580d.put("wheat", -663885);
        f30580d.put("white", -1);
        f30580d.put("whitesmoke", Integer.valueOf((int) BDEmotionPanelManager.COLOR_EMOTION_TYPE_LAYOUT));
        f30580d.put("yellow", -256);
        f30580d.put("yellowgreen", -6632142);
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
                Matcher matcher = (z ? f30579c : f30578b).matcher(replace);
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
                Integer num = f30580d.get(v.J(replace));
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
