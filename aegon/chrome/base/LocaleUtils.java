package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import com.baidu.mobstat.Config;
import java.util.Locale;
/* loaded from: classes.dex */
public class LocaleUtils {
    @CalledByNative
    public static String getDefaultCountryCode() {
        CommandLine commandLine = CommandLine.getInstance();
        return commandLine.hasSwitch("default-country-code") ? commandLine.getSwitchValue("default-country-code") : Locale.getDefault().getCountry();
    }

    @CalledByNative
    public static String getDefaultLocaleString() {
        char c2;
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        int hashCode = language.hashCode();
        if (hashCode == 3365) {
            if (language.equals("in")) {
                c2 = 2;
            }
            c2 = 65535;
        } else if (hashCode == 3374) {
            if (language.equals("iw")) {
                c2 = 0;
            }
            c2 = 65535;
        } else if (hashCode != 3391) {
            if (hashCode == 3704 && language.equals("tl")) {
                c2 = 3;
            }
            c2 = 65535;
        } else {
            if (language.equals("ji")) {
                c2 = 1;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            language = Config.HEADER_PART;
        } else if (c2 == 1) {
            language = "yi";
        } else if (c2 == 2) {
            language = "id";
        } else if (c2 == 3) {
            language = "fil";
        }
        String country = locale.getCountry();
        if (language.equals("no") && country.equals("NO") && locale.getVariant().equals("NY")) {
            return "nn-NO";
        }
        if (country.isEmpty()) {
            return language;
        }
        return language + "-" + country;
    }
}
