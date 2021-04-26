package androidx.room.util;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.Room;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class StringUtil {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    public static void appendPlaceholders(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("?");
            if (i3 < i2 - 1) {
                sb.append(",");
            }
        }
    }

    @Nullable
    public static String joinIntoString(@Nullable List<Integer> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        if (size == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(Integer.toString(list.get(i2).intValue()));
            if (i2 < size - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    @Nullable
    public static List<Integer> splitToIntList(@Nullable String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        while (stringTokenizer.hasMoreElements()) {
            try {
                arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
            } catch (NumberFormatException e2) {
                Log.e(Room.LOG_TAG, "Malformed integer list", e2);
            }
        }
        return arrayList;
    }
}
