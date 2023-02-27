package com.baidu.searchbox.v8engine;

import android.util.Xml;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
@NotProguard
/* loaded from: classes3.dex */
public class FontParser {
    public static final String DEFAULT_FALLBACK = "/system/fonts/DroidSansFallback.ttf";
    public static final String DEFAULT_FONTS = "/system/fonts/DroidSans.ttf";
    public static final String DEFAULT_FONTS_KEY1 = "zh-Hant/normal/400";
    public static final String DEFAULT_FONTS_KEY2 = "sans-serif/normal/400";
    public static final String FONTS_CONFIG = "/system/etc/fonts.xml";
    public static final String FONTS_PAD_FALLBACK_XML = "/system/etc/fallback_fonts.xml";
    public static final String FONTS_PAD_FONTS_XML = "/system/etc/system_fonts.xml";
    public static final String TAG = "FontParser";
    public static boolean mIsAndroidPad = false;
    public static final String sFontStyleDefault = "normal";
    public static final String sFontWeightDefault = "400";
    public static Map<String, String> sSystemFontMap = new HashMap();
    public static ArrayList<String> sFallbackFonts = new ArrayList<>();
    public static boolean first = true;
    public static final Pattern FILENAME_WHITESPACE_PATTERN = Pattern.compile("^[ \\n\\r\\t]+|[ \\n\\r\\t]+$");
    public static final Pattern TAG_PATTERN = Pattern.compile("[\\x00-\\xFF]{4}");
    public static final Pattern STYLE_VALUE_PATTERN = Pattern.compile("-?(([0-9]+(\\.[0-9]+)?)|(\\.[0-9]+))");

    /* loaded from: classes3.dex */
    public static class Alias {
        public String name;
        public String toName;
        public int weight;
    }

    /* loaded from: classes3.dex */
    public static class Config {
        public List<Family> families = new ArrayList();
        public List<Alias> aliases = new ArrayList();
    }

    /* loaded from: classes3.dex */
    public static class Axis {
        public final float styleValue;
        public final int tag;

        public Axis(int i, float f) {
            this.tag = i;
            this.styleValue = f;
        }
    }

    /* loaded from: classes3.dex */
    public static class Family {
        public List<Font> fonts;
        public String lang;
        public String name;
        public String variant;

        public Family(String str, List<Font> list, String str2, String str3) {
            this.name = str;
            this.fonts = list;
            this.lang = str2;
            this.variant = str3;
        }
    }

    /* loaded from: classes3.dex */
    public static class Font {
        public final List<Axis> axes;
        public String fontName;
        public boolean isItalic;
        public int ttcIndex;
        public int weight;

        public Font(String str, int i, List<Axis> list, int i2, boolean z) {
            this.fontName = str;
            this.ttcIndex = i;
            this.axes = list;
            this.weight = i2;
            this.isItalic = z;
        }
    }

    public static Config parse(InputStream inputStream) {
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(inputStream, null);
            newPullParser.nextTag();
            return readFamilies(newPullParser);
        } finally {
            inputStream.close();
        }
    }

    public static void skip(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next != 2) {
                if (next == 3) {
                    i--;
                }
            } else {
                i++;
            }
        }
    }

    public static Alias readAlias(XmlPullParser xmlPullParser) {
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

    public static Axis readAxis(XmlPullParser xmlPullParser) {
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

    public static Font readFont(XmlPullParser xmlPullParser) {
        int parseInt;
        int parseInt2;
        String attributeValue = xmlPullParser.getAttributeValue(null, "index");
        if (attributeValue == null) {
            parseInt = 0;
        } else {
            parseInt = Integer.parseInt(attributeValue);
        }
        ArrayList arrayList = new ArrayList();
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "weight");
        if (attributeValue2 == null) {
            parseInt2 = 400;
        } else {
            parseInt2 = Integer.parseInt(attributeValue2);
        }
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

    public static Config readFamilies(XmlPullParser xmlPullParser) {
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

    /* JADX WARN: Code restructure failed: missing block: B:23:0x008a, code lost:
        if (r2.equals("zh") != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0093, code lost:
        if (r2.equals("zh-Hant") != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009c, code lost:
        if (r2.equals("zh-Hans") == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009e, code lost:
        r5 = new java.lang.StringBuilder();
        r5.append(r2);
        r5.append("/");
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ab, code lost:
        if (r4.isItalic == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ae, code lost:
        r6 = "normal";
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00af, code lost:
        r5.append(r6);
        r5.append("/");
        r5.append(r4.weight);
        com.baidu.searchbox.v8engine.FontParser.sSystemFontMap.put(r5.toString(), r4.fontName);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Family readFamily(XmlPullParser xmlPullParser) {
        String lowerCase;
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        String attributeValue2 = xmlPullParser.getAttributeValue(null, WebvttCueParser.TAG_LANG);
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "variant");
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    Font readFont = readFont(xmlPullParser);
                    arrayList.add(readFont);
                    String str = "italic";
                    if (first && readFont.weight == 400 && !readFont.isItalic) {
                        first = false;
                        sFallbackFonts.add(readFont.fontName);
                        StringBuilder sb = new StringBuilder();
                        sb.append(attributeValue2);
                        sb.append("/");
                        if (!readFont.isItalic) {
                            str = "normal";
                        }
                        sb.append(str);
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
}
