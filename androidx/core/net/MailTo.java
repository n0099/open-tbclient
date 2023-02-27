package androidx.core.net;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.baidu.android.common.others.lang.StringUtil;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.codec.net.RFC1522Codec;
/* loaded from: classes.dex */
public final class MailTo {
    public static final String BCC = "bcc";
    public static final String BODY = "body";
    public static final String CC = "cc";
    public static final String MAILTO = "mailto";
    public static final String MAILTO_SCHEME = "mailto:";
    public static final String SUBJECT = "subject";
    public static final String TO = "to";
    public HashMap<String, String> mHeaders = new HashMap<>();

    @Nullable
    public String getBcc() {
        return this.mHeaders.get(BCC);
    }

    @Nullable
    public String getBody() {
        return this.mHeaders.get("body");
    }

    @Nullable
    public String getCc() {
        return this.mHeaders.get(CC);
    }

    @Nullable
    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    @Nullable
    public String getSubject() {
        return this.mHeaders.get(SUBJECT);
    }

    @Nullable
    public String getTo() {
        return this.mHeaders.get("to");
    }

    public static boolean isMailTo(@Nullable Uri uri) {
        if (uri != null && MAILTO.equals(uri.getScheme())) {
            return true;
        }
        return false;
    }

    @NonNull
    public static MailTo parse(@NonNull Uri uri) throws ParseException {
        return parse(uri.toString());
    }

    public static boolean isMailTo(@Nullable String str) {
        if (str != null && str.startsWith("mailto:")) {
            return true;
        }
        return false;
    }

    @NonNull
    public static MailTo parse(@NonNull String str) throws ParseException {
        String decode;
        String substring;
        String str2;
        Preconditions.checkNotNull(str);
        if (isMailTo(str)) {
            int indexOf = str.indexOf(35);
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            int indexOf2 = str.indexOf(63);
            if (indexOf2 == -1) {
                decode = Uri.decode(str.substring(7));
                substring = null;
            } else {
                decode = Uri.decode(str.substring(7, indexOf2));
                substring = str.substring(indexOf2 + 1);
            }
            MailTo mailTo = new MailTo();
            if (substring != null) {
                for (String str3 : substring.split("&")) {
                    String[] split = str3.split("=", 2);
                    if (split.length != 0) {
                        String lowerCase = Uri.decode(split[0]).toLowerCase(Locale.ROOT);
                        if (split.length > 1) {
                            str2 = Uri.decode(split[1]);
                        } else {
                            str2 = null;
                        }
                        mailTo.mHeaders.put(lowerCase, str2);
                    }
                }
            }
            String to = mailTo.getTo();
            if (to != null) {
                decode = decode + StringUtil.ARRAY_ELEMENT_SEPARATOR + to;
            }
            mailTo.mHeaders.put("to", decode);
            return mailTo;
        }
        throw new ParseException("Not a mailto scheme");
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("mailto:");
        sb.append(RFC1522Codec.SEP);
        for (Map.Entry<String, String> entry : this.mHeaders.entrySet()) {
            sb.append(Uri.encode(entry.getKey()));
            sb.append('=');
            sb.append(Uri.encode(entry.getValue()));
            sb.append('&');
        }
        return sb.toString();
    }
}
