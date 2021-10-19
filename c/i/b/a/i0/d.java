package c.i.b.a.i0;

import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes4.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f33807a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f33808b;

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f33809c;

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, Integer> f33810d;
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
        f33807a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        f33808b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        f33809c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
        HashMap hashMap = new HashMap();
        f33810d = hashMap;
        hashMap.put("aliceblue", -984833);
        f33810d.put("antiquewhite", -332841);
        f33810d.put("aqua", -16711681);
        f33810d.put("aquamarine", -8388652);
        f33810d.put("azure", -983041);
        f33810d.put("beige", -657956);
        f33810d.put("bisque", -6972);
        f33810d.put("black", -16777216);
        f33810d.put("blanchedalmond", -5171);
        f33810d.put("blue", -16776961);
        f33810d.put("blueviolet", -7722014);
        f33810d.put("brown", -5952982);
        f33810d.put("burlywood", -2180985);
        f33810d.put("cadetblue", -10510688);
        f33810d.put("chartreuse", -8388864);
        f33810d.put("chocolate", -2987746);
        f33810d.put("coral", -32944);
        f33810d.put("cornflowerblue", -10185235);
        f33810d.put("cornsilk", -1828);
        f33810d.put("crimson", -2354116);
        f33810d.put("cyan", -16711681);
        f33810d.put("darkblue", -16777077);
        f33810d.put("darkcyan", -16741493);
        f33810d.put("darkgoldenrod", -4684277);
        f33810d.put("darkgray", -5658199);
        f33810d.put("darkgreen", -16751616);
        f33810d.put("darkgrey", -5658199);
        f33810d.put("darkkhaki", -4343957);
        f33810d.put("darkmagenta", -7667573);
        f33810d.put("darkolivegreen", -11179217);
        f33810d.put("darkorange", -29696);
        f33810d.put("darkorchid", -6737204);
        f33810d.put("darkred", -7667712);
        f33810d.put("darksalmon", -1468806);
        f33810d.put("darkseagreen", -7357297);
        f33810d.put("darkslateblue", -12042869);
        f33810d.put("darkslategray", -13676721);
        f33810d.put("darkslategrey", -13676721);
        f33810d.put("darkturquoise", -16724271);
        f33810d.put("darkviolet", -7077677);
        f33810d.put("deeppink", -60269);
        f33810d.put("deepskyblue", -16728065);
        f33810d.put("dimgray", -9868951);
        f33810d.put("dimgrey", -9868951);
        f33810d.put("dodgerblue", -14774017);
        f33810d.put("firebrick", -5103070);
        f33810d.put("floralwhite", -1296);
        f33810d.put("forestgreen", -14513374);
        f33810d.put("fuchsia", -65281);
        f33810d.put("gainsboro", -2302756);
        f33810d.put("ghostwhite", -460545);
        f33810d.put("gold", -10496);
        f33810d.put("goldenrod", -2448096);
        f33810d.put("gray", -8355712);
        f33810d.put("green", -16744448);
        f33810d.put("greenyellow", -5374161);
        f33810d.put("grey", -8355712);
        f33810d.put("honeydew", -983056);
        f33810d.put("hotpink", -38476);
        f33810d.put("indianred", -3318692);
        f33810d.put("indigo", -11861886);
        f33810d.put("ivory", -16);
        f33810d.put("khaki", -989556);
        f33810d.put("lavender", -1644806);
        f33810d.put("lavenderblush", -3851);
        f33810d.put("lawngreen", -8586240);
        f33810d.put("lemonchiffon", -1331);
        f33810d.put("lightblue", -5383962);
        f33810d.put("lightcoral", -1015680);
        f33810d.put("lightcyan", -2031617);
        f33810d.put("lightgoldenrodyellow", -329006);
        f33810d.put("lightgray", -2894893);
        f33810d.put("lightgreen", -7278960);
        f33810d.put("lightgrey", -2894893);
        f33810d.put("lightpink", -18751);
        f33810d.put("lightsalmon", -24454);
        f33810d.put("lightseagreen", -14634326);
        f33810d.put("lightskyblue", -7876870);
        f33810d.put("lightslategray", -8943463);
        f33810d.put("lightslategrey", -8943463);
        f33810d.put("lightsteelblue", -5192482);
        f33810d.put("lightyellow", -32);
        f33810d.put("lime", -16711936);
        f33810d.put("limegreen", -13447886);
        f33810d.put("linen", -331546);
        f33810d.put("magenta", -65281);
        f33810d.put("maroon", -8388608);
        f33810d.put("mediumaquamarine", -10039894);
        f33810d.put("mediumblue", -16777011);
        f33810d.put("mediumorchid", -4565549);
        f33810d.put("mediumpurple", -7114533);
        f33810d.put("mediumseagreen", -12799119);
        f33810d.put("mediumslateblue", -8689426);
        f33810d.put("mediumspringgreen", -16713062);
        f33810d.put("mediumturquoise", -12004916);
        f33810d.put("mediumvioletred", -3730043);
        f33810d.put("midnightblue", -15132304);
        f33810d.put("mintcream", -655366);
        f33810d.put("mistyrose", -6943);
        f33810d.put("moccasin", -6987);
        f33810d.put("navajowhite", -8531);
        f33810d.put("navy", -16777088);
        f33810d.put("oldlace", -133658);
        f33810d.put("olive", -8355840);
        f33810d.put("olivedrab", -9728477);
        f33810d.put("orange", -23296);
        f33810d.put("orangered", -47872);
        f33810d.put("orchid", -2461482);
        f33810d.put("palegoldenrod", -1120086);
        f33810d.put("palegreen", -6751336);
        f33810d.put("paleturquoise", -5247250);
        f33810d.put("palevioletred", -2396013);
        f33810d.put("papayawhip", -4139);
        f33810d.put("peachpuff", -9543);
        f33810d.put("peru", -3308225);
        f33810d.put("pink", -16181);
        f33810d.put("plum", -2252579);
        f33810d.put("powderblue", -5185306);
        f33810d.put("purple", -8388480);
        f33810d.put("rebeccapurple", -10079335);
        f33810d.put("red", Integer.valueOf((int) SupportMenu.CATEGORY_MASK));
        f33810d.put("rosybrown", -4419697);
        f33810d.put("royalblue", -12490271);
        f33810d.put("saddlebrown", -7650029);
        f33810d.put("salmon", -360334);
        f33810d.put("sandybrown", -744352);
        f33810d.put("seagreen", -13726889);
        f33810d.put("seashell", -2578);
        f33810d.put("sienna", -6270419);
        f33810d.put("silver", -4144960);
        f33810d.put("skyblue", -7876885);
        f33810d.put("slateblue", -9807155);
        f33810d.put("slategray", -9404272);
        f33810d.put("slategrey", -9404272);
        f33810d.put("snow", -1286);
        f33810d.put("springgreen", -16711809);
        f33810d.put("steelblue", -12156236);
        f33810d.put("tan", -2968436);
        f33810d.put("teal", -16744320);
        f33810d.put("thistle", -2572328);
        f33810d.put("tomato", -40121);
        f33810d.put(OpenFlutter.EXTRA_TRANSPARANT, 0);
        f33810d.put("turquoise", -12525360);
        f33810d.put("violet", -1146130);
        f33810d.put("wheat", -663885);
        f33810d.put("white", -1);
        f33810d.put("whitesmoke", Integer.valueOf((int) BDEmotionPanelManager.COLOR_EMOTION_TYPE_LAYOUT));
        f33810d.put("yellow", -256);
        f33810d.put("yellowgreen", -6632142);
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
                Matcher matcher = (z ? f33809c : f33808b).matcher(replace);
                if (matcher.matches()) {
                    if (z) {
                        parseInt = (int) (Float.parseFloat(matcher.group(4)) * 255.0f);
                    } else {
                        parseInt = Integer.parseInt(matcher.group(4), 10);
                    }
                    return a(parseInt, Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
                }
            } else if (replace.startsWith("rgb")) {
                Matcher matcher2 = f33807a.matcher(replace);
                if (matcher2.matches()) {
                    return e(Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
                }
            } else {
                Integer num = f33810d.get(v.J(replace));
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
        return (interceptable == null || (invokeIII = interceptable.invokeIII(AdIconUtil.AD_TEXT_ID, null, i2, i3, i4)) == null) ? a(255, i2, i3, i4) : invokeIII.intValue;
    }
}
