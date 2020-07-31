package android.support.v4.os;

import android.support.annotation.RestrictTo;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes18.dex */
final class LocaleHelper {
    LocaleHelper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Locale forLanguageTag(String str) {
        if (str.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            String[] split2 = str.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        } else {
            return new Locale(str);
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toLanguageTag(Locale locale) {
        StringBuilder sb = new StringBuilder();
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country != null && !country.isEmpty()) {
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(locale.getCountry());
        }
        return sb.toString();
    }
}
