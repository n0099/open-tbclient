package aegon.chrome.url;

import aegon.chrome.base.annotations.CalledByNative;
import java.net.IDN;
/* loaded from: classes5.dex */
public class IDNStringUtil {
    @CalledByNative
    public static String idnToASCII(String str) {
        try {
            return IDN.toASCII(str, 2);
        } catch (Exception e) {
            return null;
        }
    }
}
