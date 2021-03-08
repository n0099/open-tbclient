package com.baidu.searchbox.v8engine;

import android.util.Xml;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
@NotProguard
/* loaded from: classes14.dex */
public class FontParser {
    static final String DEFAULT_FALLBACK = "/system/fonts/DroidSansFallback.ttf";
    static final String DEFAULT_FONTS = "/system/fonts/DroidSans.ttf";
    static final String DEFAULT_FONTS_KEY1 = "zh-Hant/normal/400";
    static final String DEFAULT_FONTS_KEY2 = "sans-serif/normal/400";
    static final String FONTS_CONFIG = "/system/etc/fonts.xml";
    static final String FONTS_PAD_FALLBACK_XML = "/system/etc/fallback_fonts.xml";
    static final String FONTS_PAD_FONTS_XML = "/system/etc/system_fonts.xml";
    static final String TAG = "FontParser";
    static final String sFontStyleDefault = "normal";
    static final String sFontWeightDefault = "400";
    static boolean mIsAndroidPad = false;
    static Map<String, String> sSystemFontMap = new HashMap();
    static ArrayList<String> sFallbackFonts = new ArrayList<>();
    static boolean first = true;
    private static final Pattern FILENAME_WHITESPACE_PATTERN = Pattern.compile("^[ \\n\\r\\t]+|[ \\n\\r\\t]+$");
    private static final Pattern TAG_PATTERN = Pattern.compile("[\\x00-\\xFF]{4}");
    private static final Pattern STYLE_VALUE_PATTERN = Pattern.compile("-?(([0-9]+(\\.[0-9]+)?)|(\\.[0-9]+))");

    /* loaded from: classes14.dex */
    public static class Alias {
        public String name;
        public String toName;
        public int weight;
    }

    /* loaded from: classes14.dex */
    public static class Config {
        public List<Family> families = new ArrayList();
        public List<Alias> aliases = new ArrayList();

        Config() {
        }
    }

    /* loaded from: classes14.dex */
    public static class Axis {
        public final float styleValue;
        public final int tag;

        Axis(int i, float f) {
            this.tag = i;
            this.styleValue = f;
        }
    }

    /* loaded from: classes14.dex */
    public static class Font {
        public final List<Axis> axes;
        public String fontName;
        public boolean isItalic;
        public int ttcIndex;
        public int weight;

        Font(String str, int i, List<Axis> list, int i2, boolean z) {
            this.fontName = str;
            this.ttcIndex = i;
            this.axes = list;
            this.weight = i2;
            this.isItalic = z;
        }
    }

    /* loaded from: classes14.dex */
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

    public static Config parse(InputStream inputStream) throws XmlPullParserException, IOException {
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(inputStream, null);
            newPullParser.nextTag();
            return readFamilies(newPullParser);
        } finally {
            inputStream.close();
        }
    }

    private static Config readFamilies(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Config config = new Config();
        xmlPullParser.require(2, null, "familyset");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("family")) {
                    config.families.add(readFamily(xmlPullParser));
                } else if (name.equals(CommandMessage.TYPE_ALIAS)) {
                    config.aliases.add(readAlias(xmlPullParser));
                } else {
                    skip(xmlPullParser);
                }
            }
        }
        return config;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0096, code lost:
        if (r2.equals("zh") != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009f, code lost:
        if (r2.equals("zh-Hant") != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a8, code lost:
        if (r2.equals("zh-Hans") == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00aa, code lost:
        r6 = new java.lang.StringBuilder().append(r2).append("/");
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00bc, code lost:
        if (r5.isItalic == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00be, code lost:
        r0 = "italic";
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c1, code lost:
        com.baidu.searchbox.v8engine.FontParser.sSystemFontMap.put(r6.append(r0).append("/").append(r5.weight).toString(), r5.fontName);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0100, code lost:
        r0 = "normal";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Family readFamily(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String lowerCase;
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "lang");
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "variant");
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    Font readFont = readFont(xmlPullParser);
                    arrayList.add(readFont);
                    if (first && readFont.weight == 400 && !readFont.isItalic) {
                        first = false;
                        sFallbackFonts.add(readFont.fontName);
                        sSystemFontMap.put(attributeValue2 + "/" + (readFont.isItalic ? "italic" : "normal") + "/" + readFont.weight, readFont.fontName);
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

    private static Font readFont(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
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

    private static Axis readAxis(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "tag");
        if (attributeValue != null && TAG_PATTERN.matcher(attributeValue).matches()) {
            int charAt = attributeValue.charAt(3) + (attributeValue.charAt(0) << 24) + (attributeValue.charAt(1) << 16) + (attributeValue.charAt(2) << '\b');
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

    private static Alias readAlias(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
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

    private static void skip(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            switch (xmlPullParser.next()) {
                case 2:
                    i++;
                    break;
                case 3:
                    i--;
                    break;
            }
        }
    }
}
