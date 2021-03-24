package aegon.chrome.base;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class PiiElider {
    public static final String[] APP_NAMESPACE;
    public static final String[] SYSTEM_NAMESPACE;
    public static final Pattern IP_ADDRESS = Pattern.compile("((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))");
    public static final Pattern DOMAIN_NAME = Pattern.compile("(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}|" + IP_ADDRESS + SmallTailInfo.EMOTION_SUFFIX);
    public static final Pattern LIKELY_EXCEPTION_LOG = Pattern.compile("\\sat\\sorg\\.chromium\\.[^ ]+.");
    public static final Pattern WEB_URL = Pattern.compile("(?:\\b|^)((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:" + DOMAIN_NAME + ")(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)");

    static {
        Pattern.compile("([0-9a-fA-F]{2}[-:]+){5}[0-9a-fA-F]{2}");
        Pattern.compile("\\[\\w*:CONSOLE.*\\].*");
        APP_NAMESPACE = new String[]{"aegon.chrome.", "com.google."};
        SYSTEM_NAMESPACE = new String[]{"android.accessibilityservice", "android.accounts", "android.animation", "android.annotation", "android.app", "android.appwidget", "android.bluetooth", "android.content", "android.database", "android.databinding", "android.drm", "android.gesture", "android.graphics", "android.hardware", "android.inputmethodservice", "android.location", "android.media", "android.mtp", "android.net", "android.nfc", "android.opengl", "android.os", "android.preference", "android.print", "android.printservice", "android.provider", "android.renderscript", "android.sax", "android.security", "android.service", "android.speech", "android.support", "android.system", "android.telecom", "android.telephony", "android.test", NotificationCompat.EXTRA_TEXT, "android.transition", "android.util", "android.view", "android.webkit", "android.widget", "com.android.", "dalvik.", "java.", "javax.", "org.apache.", "org.json.", "org.w3c.dom.", "org.xml.", "org.xmlpull."};
    }

    public static String elideUrl(String str) {
        boolean z;
        boolean z2;
        if (LIKELY_EXCEPTION_LOG.matcher(str).find()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        Matcher matcher = WEB_URL.matcher(sb);
        int i = 0;
        while (matcher.find(i)) {
            int start = matcher.start();
            int end = matcher.end();
            String substring = sb.substring(start, end);
            String[] strArr = APP_NAMESPACE;
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                z = true;
                if (i2 >= length) {
                    z2 = false;
                    break;
                } else if (substring.startsWith(strArr[i2])) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (!z2) {
                String[] strArr2 = SYSTEM_NAMESPACE;
                int length2 = strArr2.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        z = false;
                        break;
                    } else if (substring.startsWith(strArr2[i3])) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (!z) {
                    sb.replace(start, end, "HTTP://WEBADDRESS.ELIDED");
                    i = start + 24;
                    matcher = WEB_URL.matcher(sb);
                }
            }
            i = end;
        }
        return sb.toString();
    }

    public static String sanitizeStacktrace(String str) {
        String[] split = str.split("\\n");
        split[0] = elideUrl(split[0]);
        for (int i = 1; i < split.length; i++) {
            if (split[i].startsWith("Caused by:")) {
                split[i] = elideUrl(split[i]);
            }
        }
        return TextUtils.join("\n", split);
    }
}
