package b.i.b.a.i0;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f32604a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f32605b;

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f32606c;

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, Integer> f32607d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-423693947, "Lb/i/b/a/i0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-423693947, "Lb/i/b/a/i0/d;");
                return;
            }
        }
        f32604a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        f32605b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        f32606c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
        HashMap hashMap = new HashMap();
        f32607d = hashMap;
        hashMap.put("aliceblue", -984833);
        f32607d.put("antiquewhite", -332841);
        f32607d.put("aqua", -16711681);
        f32607d.put("aquamarine", -8388652);
        f32607d.put("azure", -983041);
        f32607d.put("beige", -657956);
        f32607d.put("bisque", -6972);
        f32607d.put("black", -16777216);
        f32607d.put("blanchedalmond", -5171);
        f32607d.put("blue", Integer.valueOf((int) BaseAnimatedElement.DEBUG_PAINT_COLOR));
        f32607d.put("blueviolet", -7722014);
        f32607d.put("brown", -5952982);
        f32607d.put("burlywood", -2180985);
        f32607d.put("cadetblue", -10510688);
        f32607d.put("chartreuse", -8388864);
        f32607d.put("chocolate", -2987746);
        f32607d.put("coral", -32944);
        f32607d.put("cornflowerblue", -10185235);
        f32607d.put("cornsilk", -1828);
        f32607d.put("crimson", -2354116);
        f32607d.put("cyan", -16711681);
        f32607d.put("darkblue", -16777077);
        f32607d.put("darkcyan", -16741493);
        f32607d.put("darkgoldenrod", -4684277);
        f32607d.put("darkgray", -5658199);
        f32607d.put("darkgreen", -16751616);
        f32607d.put("darkgrey", -5658199);
        f32607d.put("darkkhaki", -4343957);
        f32607d.put("darkmagenta", -7667573);
        f32607d.put("darkolivegreen", -11179217);
        f32607d.put("darkorange", -29696);
        f32607d.put("darkorchid", -6737204);
        f32607d.put("darkred", -7667712);
        f32607d.put("darksalmon", -1468806);
        f32607d.put("darkseagreen", -7357297);
        f32607d.put("darkslateblue", -12042869);
        f32607d.put("darkslategray", -13676721);
        f32607d.put("darkslategrey", -13676721);
        f32607d.put("darkturquoise", -16724271);
        f32607d.put("darkviolet", -7077677);
        f32607d.put("deeppink", -60269);
        f32607d.put("deepskyblue", -16728065);
        f32607d.put("dimgray", -9868951);
        f32607d.put("dimgrey", -9868951);
        f32607d.put("dodgerblue", -14774017);
        f32607d.put("firebrick", -5103070);
        f32607d.put("floralwhite", -1296);
        f32607d.put("forestgreen", -14513374);
        f32607d.put("fuchsia", -65281);
        f32607d.put("gainsboro", -2302756);
        f32607d.put("ghostwhite", -460545);
        f32607d.put("gold", -10496);
        f32607d.put("goldenrod", -2448096);
        f32607d.put("gray", -8355712);
        f32607d.put("green", -16744448);
        f32607d.put("greenyellow", -5374161);
        f32607d.put("grey", -8355712);
        f32607d.put("honeydew", -983056);
        f32607d.put("hotpink", -38476);
        f32607d.put("indianred", -3318692);
        f32607d.put("indigo", -11861886);
        f32607d.put("ivory", -16);
        f32607d.put("khaki", -989556);
        f32607d.put("lavender", -1644806);
        f32607d.put("lavenderblush", -3851);
        f32607d.put("lawngreen", -8586240);
        f32607d.put("lemonchiffon", -1331);
        f32607d.put("lightblue", -5383962);
        f32607d.put("lightcoral", -1015680);
        f32607d.put("lightcyan", -2031617);
        f32607d.put("lightgoldenrodyellow", -329006);
        f32607d.put("lightgray", -2894893);
        f32607d.put("lightgreen", -7278960);
        f32607d.put("lightgrey", -2894893);
        f32607d.put("lightpink", -18751);
        f32607d.put("lightsalmon", -24454);
        f32607d.put("lightseagreen", -14634326);
        f32607d.put("lightskyblue", -7876870);
        f32607d.put("lightslategray", -8943463);
        f32607d.put("lightslategrey", -8943463);
        f32607d.put("lightsteelblue", -5192482);
        f32607d.put("lightyellow", -32);
        f32607d.put("lime", Integer.valueOf((int) DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK));
        f32607d.put("limegreen", -13447886);
        f32607d.put("linen", -331546);
        f32607d.put("magenta", -65281);
        f32607d.put("maroon", -8388608);
        f32607d.put("mediumaquamarine", -10039894);
        f32607d.put("mediumblue", -16777011);
        f32607d.put("mediumorchid", -4565549);
        f32607d.put("mediumpurple", -7114533);
        f32607d.put("mediumseagreen", -12799119);
        f32607d.put("mediumslateblue", -8689426);
        f32607d.put("mediumspringgreen", -16713062);
        f32607d.put("mediumturquoise", -12004916);
        f32607d.put("mediumvioletred", -3730043);
        f32607d.put("midnightblue", -15132304);
        f32607d.put("mintcream", -655366);
        f32607d.put("mistyrose", -6943);
        f32607d.put("moccasin", -6987);
        f32607d.put("navajowhite", -8531);
        f32607d.put("navy", -16777088);
        f32607d.put("oldlace", -133658);
        f32607d.put("olive", -8355840);
        f32607d.put("olivedrab", -9728477);
        f32607d.put("orange", -23296);
        f32607d.put("orangered", -47872);
        f32607d.put("orchid", -2461482);
        f32607d.put("palegoldenrod", -1120086);
        f32607d.put("palegreen", -6751336);
        f32607d.put("paleturquoise", -5247250);
        f32607d.put("palevioletred", -2396013);
        f32607d.put("papayawhip", -4139);
        f32607d.put("peachpuff", -9543);
        f32607d.put("peru", -3308225);
        f32607d.put("pink", -16181);
        f32607d.put("plum", -2252579);
        f32607d.put("powderblue", -5185306);
        f32607d.put("purple", -8388480);
        f32607d.put("rebeccapurple", -10079335);
        f32607d.put("red", -65536);
        f32607d.put("rosybrown", -4419697);
        f32607d.put("royalblue", -12490271);
        f32607d.put("saddlebrown", -7650029);
        f32607d.put("salmon", -360334);
        f32607d.put("sandybrown", -744352);
        f32607d.put("seagreen", -13726889);
        f32607d.put("seashell", -2578);
        f32607d.put("sienna", -6270419);
        f32607d.put("silver", -4144960);
        f32607d.put("skyblue", -7876885);
        f32607d.put("slateblue", -9807155);
        f32607d.put("slategray", -9404272);
        f32607d.put("slategrey", -9404272);
        f32607d.put("snow", -1286);
        f32607d.put("springgreen", -16711809);
        f32607d.put("steelblue", -12156236);
        f32607d.put("tan", -2968436);
        f32607d.put("teal", -16744320);
        f32607d.put("thistle", -2572328);
        f32607d.put("tomato", -40121);
        f32607d.put(OpenFlutter.EXTRA_TRANSPARANT, 0);
        f32607d.put("turquoise", -12525360);
        f32607d.put("violet", -1146130);
        f32607d.put("wheat", -663885);
        f32607d.put("white", -1);
        f32607d.put("whitesmoke", Integer.valueOf((int) BDEmotionPanelManager.COLOR_EMOTION_TYPE_LAYOUT));
        f32607d.put("yellow", -256);
        f32607d.put("yellowgreen", -6632142);
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
                Matcher matcher = (z ? f32606c : f32605b).matcher(replace);
                if (matcher.matches()) {
                    if (z) {
                        parseInt = (int) (Float.parseFloat(matcher.group(4)) * 255.0f);
                    } else {
                        parseInt = Integer.parseInt(matcher.group(4), 10);
                    }
                    return a(parseInt, Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
                }
            } else if (replace.startsWith("rgb")) {
                Matcher matcher2 = f32604a.matcher(replace);
                if (matcher2.matches()) {
                    return e(Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
                }
            } else {
                Integer num = f32607d.get(v.J(replace));
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
