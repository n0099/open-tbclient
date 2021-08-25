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
    public static final Pattern f33671a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f33672b;

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f33673c;

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, Integer> f33674d;
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
        f33671a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        f33672b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        f33673c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
        HashMap hashMap = new HashMap();
        f33674d = hashMap;
        hashMap.put("aliceblue", -984833);
        f33674d.put("antiquewhite", -332841);
        f33674d.put("aqua", -16711681);
        f33674d.put("aquamarine", -8388652);
        f33674d.put("azure", -983041);
        f33674d.put("beige", -657956);
        f33674d.put("bisque", -6972);
        f33674d.put("black", -16777216);
        f33674d.put("blanchedalmond", -5171);
        f33674d.put("blue", -16776961);
        f33674d.put("blueviolet", -7722014);
        f33674d.put("brown", -5952982);
        f33674d.put("burlywood", -2180985);
        f33674d.put("cadetblue", -10510688);
        f33674d.put("chartreuse", -8388864);
        f33674d.put("chocolate", -2987746);
        f33674d.put("coral", -32944);
        f33674d.put("cornflowerblue", -10185235);
        f33674d.put("cornsilk", -1828);
        f33674d.put("crimson", -2354116);
        f33674d.put("cyan", -16711681);
        f33674d.put("darkblue", -16777077);
        f33674d.put("darkcyan", -16741493);
        f33674d.put("darkgoldenrod", -4684277);
        f33674d.put("darkgray", -5658199);
        f33674d.put("darkgreen", -16751616);
        f33674d.put("darkgrey", -5658199);
        f33674d.put("darkkhaki", -4343957);
        f33674d.put("darkmagenta", -7667573);
        f33674d.put("darkolivegreen", -11179217);
        f33674d.put("darkorange", -29696);
        f33674d.put("darkorchid", -6737204);
        f33674d.put("darkred", -7667712);
        f33674d.put("darksalmon", -1468806);
        f33674d.put("darkseagreen", -7357297);
        f33674d.put("darkslateblue", -12042869);
        f33674d.put("darkslategray", -13676721);
        f33674d.put("darkslategrey", -13676721);
        f33674d.put("darkturquoise", -16724271);
        f33674d.put("darkviolet", -7077677);
        f33674d.put("deeppink", -60269);
        f33674d.put("deepskyblue", -16728065);
        f33674d.put("dimgray", -9868951);
        f33674d.put("dimgrey", -9868951);
        f33674d.put("dodgerblue", -14774017);
        f33674d.put("firebrick", -5103070);
        f33674d.put("floralwhite", -1296);
        f33674d.put("forestgreen", -14513374);
        f33674d.put("fuchsia", -65281);
        f33674d.put("gainsboro", -2302756);
        f33674d.put("ghostwhite", -460545);
        f33674d.put("gold", -10496);
        f33674d.put("goldenrod", -2448096);
        f33674d.put("gray", -8355712);
        f33674d.put("green", -16744448);
        f33674d.put("greenyellow", -5374161);
        f33674d.put("grey", -8355712);
        f33674d.put("honeydew", -983056);
        f33674d.put("hotpink", -38476);
        f33674d.put("indianred", -3318692);
        f33674d.put("indigo", -11861886);
        f33674d.put("ivory", -16);
        f33674d.put("khaki", -989556);
        f33674d.put("lavender", -1644806);
        f33674d.put("lavenderblush", -3851);
        f33674d.put("lawngreen", -8586240);
        f33674d.put("lemonchiffon", -1331);
        f33674d.put("lightblue", -5383962);
        f33674d.put("lightcoral", -1015680);
        f33674d.put("lightcyan", -2031617);
        f33674d.put("lightgoldenrodyellow", -329006);
        f33674d.put("lightgray", -2894893);
        f33674d.put("lightgreen", -7278960);
        f33674d.put("lightgrey", -2894893);
        f33674d.put("lightpink", -18751);
        f33674d.put("lightsalmon", -24454);
        f33674d.put("lightseagreen", -14634326);
        f33674d.put("lightskyblue", -7876870);
        f33674d.put("lightslategray", -8943463);
        f33674d.put("lightslategrey", -8943463);
        f33674d.put("lightsteelblue", -5192482);
        f33674d.put("lightyellow", -32);
        f33674d.put("lime", -16711936);
        f33674d.put("limegreen", -13447886);
        f33674d.put("linen", -331546);
        f33674d.put("magenta", -65281);
        f33674d.put("maroon", -8388608);
        f33674d.put("mediumaquamarine", -10039894);
        f33674d.put("mediumblue", -16777011);
        f33674d.put("mediumorchid", -4565549);
        f33674d.put("mediumpurple", -7114533);
        f33674d.put("mediumseagreen", -12799119);
        f33674d.put("mediumslateblue", -8689426);
        f33674d.put("mediumspringgreen", -16713062);
        f33674d.put("mediumturquoise", -12004916);
        f33674d.put("mediumvioletred", -3730043);
        f33674d.put("midnightblue", -15132304);
        f33674d.put("mintcream", -655366);
        f33674d.put("mistyrose", -6943);
        f33674d.put("moccasin", -6987);
        f33674d.put("navajowhite", -8531);
        f33674d.put("navy", -16777088);
        f33674d.put("oldlace", -133658);
        f33674d.put("olive", -8355840);
        f33674d.put("olivedrab", -9728477);
        f33674d.put("orange", -23296);
        f33674d.put("orangered", -47872);
        f33674d.put("orchid", -2461482);
        f33674d.put("palegoldenrod", -1120086);
        f33674d.put("palegreen", -6751336);
        f33674d.put("paleturquoise", -5247250);
        f33674d.put("palevioletred", -2396013);
        f33674d.put("papayawhip", -4139);
        f33674d.put("peachpuff", -9543);
        f33674d.put("peru", -3308225);
        f33674d.put("pink", -16181);
        f33674d.put("plum", -2252579);
        f33674d.put("powderblue", -5185306);
        f33674d.put("purple", -8388480);
        f33674d.put("rebeccapurple", -10079335);
        f33674d.put("red", Integer.valueOf((int) SupportMenu.CATEGORY_MASK));
        f33674d.put("rosybrown", -4419697);
        f33674d.put("royalblue", -12490271);
        f33674d.put("saddlebrown", -7650029);
        f33674d.put("salmon", -360334);
        f33674d.put("sandybrown", -744352);
        f33674d.put("seagreen", -13726889);
        f33674d.put("seashell", -2578);
        f33674d.put("sienna", -6270419);
        f33674d.put("silver", -4144960);
        f33674d.put("skyblue", -7876885);
        f33674d.put("slateblue", -9807155);
        f33674d.put("slategray", -9404272);
        f33674d.put("slategrey", -9404272);
        f33674d.put("snow", -1286);
        f33674d.put("springgreen", -16711809);
        f33674d.put("steelblue", -12156236);
        f33674d.put("tan", -2968436);
        f33674d.put("teal", -16744320);
        f33674d.put("thistle", -2572328);
        f33674d.put("tomato", -40121);
        f33674d.put(OpenFlutter.EXTRA_TRANSPARANT, 0);
        f33674d.put("turquoise", -12525360);
        f33674d.put("violet", -1146130);
        f33674d.put("wheat", -663885);
        f33674d.put("white", -1);
        f33674d.put("whitesmoke", Integer.valueOf((int) BDEmotionPanelManager.COLOR_EMOTION_TYPE_LAYOUT));
        f33674d.put("yellow", -256);
        f33674d.put("yellowgreen", -6632142);
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
                Matcher matcher = (z ? f33673c : f33672b).matcher(replace);
                if (matcher.matches()) {
                    if (z) {
                        parseInt = (int) (Float.parseFloat(matcher.group(4)) * 255.0f);
                    } else {
                        parseInt = Integer.parseInt(matcher.group(4), 10);
                    }
                    return a(parseInt, Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
                }
            } else if (replace.startsWith("rgb")) {
                Matcher matcher2 = f33671a.matcher(replace);
                if (matcher2.matches()) {
                    return e(Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
                }
            } else {
                Integer num = f33674d.get(v.J(replace));
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
