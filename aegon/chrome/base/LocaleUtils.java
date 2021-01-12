package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import com.baidu.mobstat.Config;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes4.dex */
public class LocaleUtils {
    @CalledByNative
    public static String getDefaultCountryCode() {
        CommandLine commandLine = CommandLine.getInstance();
        return commandLine.hasSwitch("default-country-code") ? commandLine.getSwitchValue("default-country-code") : Locale.getDefault().getCountry();
    }

    @CalledByNative
    public static String getDefaultLocaleString() {
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        char c = 65535;
        int hashCode = language.hashCode();
        if (hashCode != 3365) {
            if (hashCode != 3374) {
                if (hashCode != 3391) {
                    if (hashCode == 3704 && language.equals("tl")) {
                        c = 3;
                    }
                } else if (language.equals("ji")) {
                    c = 1;
                }
            } else if (language.equals("iw")) {
                c = 0;
            }
        } else if (language.equals("in")) {
            c = 2;
        }
        switch (c) {
            case 0:
                language = Config.HEADER_PART;
                break;
            case 1:
                language = "yi";
                break;
            case 2:
                language = "id";
                break;
            case 3:
                language = "fil";
                break;
        }
        String country = locale.getCountry();
        return (language.equals("no") && country.equals("NO") && locale.getVariant().equals("NY")) ? "nn-NO" : !country.isEmpty() ? language + Constants.ACCEPT_TIME_SEPARATOR_SERVER + country : language;
    }
}
