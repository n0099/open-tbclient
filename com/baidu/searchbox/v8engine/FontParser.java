package com.baidu.searchbox.v8engine;

import android.util.Xml;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
@NotProguard
/* loaded from: classes5.dex */
public class FontParser {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_FALLBACK = "/system/fonts/DroidSansFallback.ttf";
    public static final String DEFAULT_FONTS = "/system/fonts/DroidSans.ttf";
    public static final String DEFAULT_FONTS_KEY1 = "zh-Hant/normal/400";
    public static final String DEFAULT_FONTS_KEY2 = "sans-serif/normal/400";
    public static final Pattern FILENAME_WHITESPACE_PATTERN;
    public static final String FONTS_CONFIG = "/system/etc/fonts.xml";
    public static final String FONTS_PAD_FALLBACK_XML = "/system/etc/fallback_fonts.xml";
    public static final String FONTS_PAD_FONTS_XML = "/system/etc/system_fonts.xml";
    public static final Pattern STYLE_VALUE_PATTERN;
    public static final String TAG = "FontParser";
    public static final Pattern TAG_PATTERN;
    public static boolean first = false;
    public static boolean mIsAndroidPad = false;
    public static ArrayList<String> sFallbackFonts = null;
    public static final String sFontStyleDefault = "normal";
    public static final String sFontWeightDefault = "400";
    public static Map<String, String> sSystemFontMap;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class Alias {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String name;
        public String toName;
        public int weight;

        public Alias() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class Axis {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final float styleValue;
        public final int tag;

        public Axis(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.tag = i2;
            this.styleValue = f2;
        }
    }

    /* loaded from: classes5.dex */
    public static class Config {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<Alias> aliases;
        public List<Family> families;

        public Config() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.families = new ArrayList();
            this.aliases = new ArrayList();
        }
    }

    /* loaded from: classes5.dex */
    public static class Family {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<Font> fonts;
        public String lang;
        public String name;
        public String variant;

        public Family(String str, List<Font> list, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, list, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.name = str;
            this.fonts = list;
            this.lang = str2;
            this.variant = str3;
        }
    }

    /* loaded from: classes5.dex */
    public static class Font {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<Axis> axes;
        public String fontName;
        public boolean isItalic;
        public int ttcIndex;
        public int weight;

        public Font(String str, int i2, List<Axis> list, int i3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), list, Integer.valueOf(i3), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.fontName = str;
            this.ttcIndex = i2;
            this.axes = list;
            this.weight = i3;
            this.isItalic = z;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-77963204, "Lcom/baidu/searchbox/v8engine/FontParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-77963204, "Lcom/baidu/searchbox/v8engine/FontParser;");
                return;
            }
        }
        sSystemFontMap = new HashMap();
        sFallbackFonts = new ArrayList<>();
        first = true;
        FILENAME_WHITESPACE_PATTERN = Pattern.compile("^[ \\n\\r\\t]+|[ \\n\\r\\t]+$");
        TAG_PATTERN = Pattern.compile("[\\x00-\\xFF]{4}");
        STYLE_VALUE_PATTERN = Pattern.compile("-?(([0-9]+(\\.[0-9]+)?)|(\\.[0-9]+))");
    }

    public FontParser() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Config parse(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, inputStream)) == null) {
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(inputStream, null);
                newPullParser.nextTag();
                return readFamilies(newPullParser);
            } finally {
                inputStream.close();
            }
        }
        return (Config) invokeL.objValue;
    }

    public static Alias readAlias(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, xmlPullParser)) == null) {
            Alias alias = new Alias();
            alias.name = xmlPullParser.getAttributeValue(null, "name");
            alias.toName = xmlPullParser.getAttributeValue(null, "to");
            String attributeValue = xmlPullParser.getAttributeValue(null, "weight");
            if (attributeValue == null) {
                alias.weight = 400;
            } else {
                alias.weight = Integer.parseInt(attributeValue);
            }
            skip(xmlPullParser);
            String str = sSystemFontMap.get(alias.toName + "/normal/" + alias.weight);
            if (str != null) {
                sSystemFontMap.put(alias.name + "/normal/" + sFontWeightDefault, str);
            }
            return alias;
        }
        return (Alias) invokeL.objValue;
    }

    public static Axis readAxis(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, xmlPullParser)) == null) {
            String attributeValue = xmlPullParser.getAttributeValue(null, "tag");
            if (attributeValue != null && TAG_PATTERN.matcher(attributeValue).matches()) {
                int charAt = (attributeValue.charAt(0) << 24) + (attributeValue.charAt(1) << 16) + (attributeValue.charAt(2) << '\b') + attributeValue.charAt(3);
                String attributeValue2 = xmlPullParser.getAttributeValue(null, "stylevalue");
                if (attributeValue2 != null && STYLE_VALUE_PATTERN.matcher(attributeValue2).matches()) {
                    float parseFloat = Float.parseFloat(attributeValue2);
                    skip(xmlPullParser);
                    return new Axis(charAt, parseFloat);
                }
                throw new XmlPullParserException("Invalid styleValue attribute value.", xmlPullParser, null);
            }
            throw new XmlPullParserException("Invalid tag attribute value.", xmlPullParser, null);
        }
        return (Axis) invokeL.objValue;
    }

    public static Config readFamilies(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, xmlPullParser)) == null) {
            Config config = new Config();
            xmlPullParser.require(2, null, "familyset");
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equals("family")) {
                        config.families.add(readFamily(xmlPullParser));
                    } else if (name.equals("alias")) {
                        config.aliases.add(readAlias(xmlPullParser));
                    } else {
                        skip(xmlPullParser);
                    }
                }
            }
            return config;
        }
        return (Config) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x008e, code lost:
        if (r2.equals("zh") != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0097, code lost:
        if (r2.equals("zh-Hant") != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a0, code lost:
        if (r2.equals("zh-Hans") == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a2, code lost:
        r5 = new java.lang.StringBuilder();
        r5.append(r2);
        r5.append("/");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00af, code lost:
        if (r4.isItalic == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b2, code lost:
        r6 = "normal";
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b3, code lost:
        r5.append(r6);
        r5.append("/");
        r5.append(r4.weight);
        com.baidu.searchbox.v8engine.FontParser.sSystemFontMap.put(r5.toString(), r4.fontName);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Family readFamily(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        String str;
        String lowerCase;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, xmlPullParser)) == null) {
            String attributeValue = xmlPullParser.getAttributeValue(null, "name");
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "lang");
            String attributeValue3 = xmlPullParser.getAttributeValue(null, "variant");
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        Font readFont = readFont(xmlPullParser);
                        arrayList.add(readFont);
                        str = "italic";
                        if (first && readFont.weight == 400 && !readFont.isItalic) {
                            first = false;
                            sFallbackFonts.add(readFont.fontName);
                            StringBuilder sb = new StringBuilder();
                            sb.append(attributeValue2);
                            sb.append("/");
                            sb.append(readFont.isItalic ? "italic" : "normal");
                            sb.append("/");
                            sb.append(readFont.weight);
                            sSystemFontMap.put(sb.toString(), readFont.fontName);
                        } else if (readFont.weight == 400 && !readFont.isItalic && (lowerCase = readFont.fontName.toLowerCase()) != null && lowerCase.indexOf("fallback") != -1) {
                            sFallbackFonts.add(readFont.fontName);
                        }
                    } else {
                        skip(xmlPullParser);
                    }
                }
            }
            return new Family(attributeValue, arrayList, attributeValue2, attributeValue3);
        }
        return (Family) invokeL.objValue;
    }

    public static Font readFont(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, xmlPullParser)) == null) {
            String attributeValue = xmlPullParser.getAttributeValue(null, "index");
            int parseInt = attributeValue == null ? 0 : Integer.parseInt(attributeValue);
            ArrayList arrayList = new ArrayList();
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "weight");
            int parseInt2 = attributeValue2 == null ? 400 : Integer.parseInt(attributeValue2);
            boolean equals = "italic".equals(xmlPullParser.getAttributeValue(null, "style"));
            StringBuilder sb = new StringBuilder();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 4) {
                    sb.append(xmlPullParser.getText());
                }
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("axis")) {
                        arrayList.add(readAxis(xmlPullParser));
                    } else {
                        skip(xmlPullParser);
                    }
                }
            }
            return new Font("/system/fonts/" + FILENAME_WHITESPACE_PATTERN.matcher(sb).replaceAll(""), parseInt, arrayList, parseInt2, equals);
        }
        return (Font) invokeL.objValue;
    }

    public static void skip(XmlPullParser xmlPullParser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, xmlPullParser) == null) {
            int i2 = 1;
            while (i2 > 0) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    i2++;
                } else if (next == 3) {
                    i2--;
                }
            }
        }
    }
}
