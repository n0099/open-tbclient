package aegon.chrome.base;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class PiiElider {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] APP_NAMESPACE;
    public static final Pattern DOMAIN_NAME;
    public static final Pattern IP_ADDRESS;
    public static final Pattern LIKELY_EXCEPTION_LOG;
    public static final String[] SYSTEM_NAMESPACE;
    public static final Pattern WEB_URL;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1100134434, "Laegon/chrome/base/PiiElider;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1100134434, "Laegon/chrome/base/PiiElider;");
                return;
            }
        }
        IP_ADDRESS = Pattern.compile("((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))");
        DOMAIN_NAME = Pattern.compile("(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}|" + IP_ADDRESS + SmallTailInfo.EMOTION_SUFFIX);
        LIKELY_EXCEPTION_LOG = Pattern.compile("\\sat\\sorg\\.chromium\\.[^ ]+.");
        WEB_URL = Pattern.compile("(?:\\b|^)((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:" + DOMAIN_NAME + ")(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)");
        Pattern.compile("([0-9a-fA-F]{2}[-:]+){5}[0-9a-fA-F]{2}");
        Pattern.compile("\\[\\w*:CONSOLE.*\\].*");
        APP_NAMESPACE = new String[]{"aegon.chrome.", "com.google."};
        SYSTEM_NAMESPACE = new String[]{"android.accessibilityservice", "android.accounts", "android.animation", "android.annotation", "android.app", "android.appwidget", "android.bluetooth", "android.content", "android.database", "android.databinding", "android.drm", "android.gesture", "android.graphics", "android.hardware", "android.inputmethodservice", "android.location", "android.media", "android.mtp", "android.net", "android.nfc", "android.opengl", "android.os", "android.preference", "android.print", "android.printservice", "android.provider", "android.renderscript", "android.sax", "android.security", "android.service", "android.speech", "android.support", "android.system", "android.telecom", "android.telephony", "android.test", NotificationCompat.EXTRA_TEXT, "android.transition", "android.util", "android.view", "android.webkit", "android.widget", "com.android.", "dalvik.", "java.", "javax.", "org.apache.", "org.json.", "org.w3c.dom.", "org.xml.", "org.xmlpull."};
    }

    public PiiElider() {
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

    public static String elideUrl(String str) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (LIKELY_EXCEPTION_LOG.matcher(str).find()) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str);
            Matcher matcher = WEB_URL.matcher(sb);
            int i2 = 0;
            while (matcher.find(i2)) {
                int start = matcher.start();
                int end = matcher.end();
                String substring = sb.substring(start, end);
                String[] strArr = APP_NAMESPACE;
                int length = strArr.length;
                int i3 = 0;
                while (true) {
                    z = true;
                    if (i3 >= length) {
                        z2 = false;
                        break;
                    } else if (substring.startsWith(strArr[i3])) {
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (!z2) {
                    String[] strArr2 = SYSTEM_NAMESPACE;
                    int length2 = strArr2.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length2) {
                            z = false;
                            break;
                        } else if (substring.startsWith(strArr2[i4])) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (!z) {
                        sb.replace(start, end, "HTTP://WEBADDRESS.ELIDED");
                        i2 = start + 24;
                        matcher = WEB_URL.matcher(sb);
                    }
                }
                i2 = end;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String sanitizeStacktrace(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            String[] split = str.split("\\n");
            split[0] = elideUrl(split[0]);
            for (int i2 = 1; i2 < split.length; i2++) {
                if (split[i2].startsWith("Caused by:")) {
                    split[i2] = elideUrl(split[i2]);
                }
            }
            return TextUtils.join("\n", split);
        }
        return (String) invokeL.objValue;
    }
}
