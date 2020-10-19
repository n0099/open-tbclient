package com.baidu.android.common.others.lang;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public final class StringUtil implements IStringUtil {
    private static final String ARRAY_ELEMENT_SEPARATOR = ", ";
    private static final String ARRAY_END = "}";
    private static final String ARRAY_START = "{";
    private static final String EMPTY_ARRAY = "{}";
    private static final String EMPTY_STRING = "";
    private static final String NULL_STRING = "null";
    private static boolean DEBUG = false;
    private static String TAG = "StringUtil";

    public static boolean isEmpty(Object obj) {
        return obj == null || "".equals(obj);
    }

    public static boolean hasLength(CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0;
    }

    public static boolean hasLength(String str) {
        return hasLength((CharSequence) str);
    }

    public static boolean hasText(CharSequence charSequence) {
        if (hasLength(charSequence)) {
            int length = charSequence.length();
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(charSequence.charAt(i))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean hasText(String str) {
        return hasText((CharSequence) str);
    }

    public static boolean containsWhitespace(CharSequence charSequence) {
        if (hasLength(charSequence)) {
            int length = charSequence.length();
            for (int i = 0; i < length; i++) {
                if (Character.isWhitespace(charSequence.charAt(i))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean containsWhitespace(String str) {
        return containsWhitespace((CharSequence) str);
    }

    public static String trimWhitespace(String str) {
        if (hasLength(str)) {
            StringBuilder sb = new StringBuilder(str);
            while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
                sb.deleteCharAt(0);
            }
            while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
        return str;
    }

    public static String trimAllWhitespace(String str) {
        if (hasLength(str)) {
            int length = str.length();
            StringBuilder sb = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (!Character.isWhitespace(charAt)) {
                    sb.append(charAt);
                }
            }
            return sb.toString();
        }
        return str;
    }

    public static String trimLeadingWhitespace(String str) {
        if (hasLength(str)) {
            StringBuilder sb = new StringBuilder(str);
            while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
                sb.deleteCharAt(0);
            }
            return sb.toString();
        }
        return str;
    }

    public static String trimTrailingWhitespace(String str) {
        if (hasLength(str)) {
            StringBuilder sb = new StringBuilder(str);
            while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
        return str;
    }

    public static String trimLeadingCharacter(String str, char c) {
        if (hasLength(str)) {
            StringBuilder sb = new StringBuilder(str);
            while (sb.length() > 0 && sb.charAt(0) == c) {
                sb.deleteCharAt(0);
            }
            return sb.toString();
        }
        return str;
    }

    public static String trimTrailingCharacter(String str, char c) {
        if (hasLength(str)) {
            StringBuilder sb = new StringBuilder(str);
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
        return str;
    }

    public static boolean startsWithIgnoreCase(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        if (str.startsWith(str2)) {
            return true;
        }
        if (str.length() >= str2.length()) {
            return str.substring(0, str2.length()).toLowerCase().equals(str2.toLowerCase());
        }
        return false;
    }

    public static boolean endsWithIgnoreCase(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        if (str.endsWith(str2)) {
            return true;
        }
        if (str.length() >= str2.length()) {
            return str.substring(str.length() - str2.length()).toLowerCase().equals(str2.toLowerCase());
        }
        return false;
    }

    public static boolean substringMatch(CharSequence charSequence, int i, CharSequence charSequence2) {
        for (int i2 = 0; i2 < charSequence2.length(); i2++) {
            int i3 = i + i2;
            if (i3 >= charSequence.length() || charSequence.charAt(i3) != charSequence2.charAt(i2)) {
                return false;
            }
        }
        return true;
    }

    public static int countOccurrencesOf(String str, String str2) {
        int i = 0;
        if (str == null || str2 == null || str.length() == 0 || str2.length() == 0) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int indexOf = str.indexOf(str2, i);
            if (indexOf != -1) {
                i2++;
                i = indexOf + str2.length();
            } else {
                return i2;
            }
        }
    }

    public static String replace(String str, String str2, String str3) {
        if (hasLength(str) && hasLength(str2) && str3 != null) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            while (indexOf >= 0) {
                sb.append(str.substring(i, indexOf));
                sb.append(str3);
                i = indexOf + length;
                indexOf = str.indexOf(str2, i);
            }
            sb.append(str.substring(i));
            return sb.toString();
        }
        return str;
    }

    public static String delete(String str, String str2) {
        return replace(str, str2, "");
    }

    public static String deleteAny(String str, String str2) {
        if (hasLength(str) && hasLength(str2)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (str2.indexOf(charAt) == -1) {
                    sb.append(charAt);
                }
            }
            return sb.toString();
        }
        return str;
    }

    public static String quote(String str) {
        if (str != null) {
            return "'" + str + "'";
        }
        return null;
    }

    public static Object quoteIfString(Object obj) {
        return obj instanceof String ? quote((String) obj) : obj;
    }

    public static String unqualify(String str) {
        return unqualify(str, '.');
    }

    public static String unqualify(String str, char c) {
        return str.substring(str.lastIndexOf(c) + 1);
    }

    public static String capitalize(String str) {
        return changeFirstCharacterCase(str, true);
    }

    public static String uncapitalize(String str) {
        return changeFirstCharacterCase(str, false);
    }

    private static String changeFirstCharacterCase(String str, boolean z) {
        if (str != null && str.length() != 0) {
            StringBuilder sb = new StringBuilder(str.length());
            if (z) {
                sb.append(Character.toUpperCase(str.charAt(0)));
            } else {
                sb.append(Character.toLowerCase(str.charAt(0)));
            }
            sb.append(str.substring(1));
            return sb.toString();
        }
        return str;
    }

    public static String getFilename(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf("/");
        return lastIndexOf != -1 ? str.substring(lastIndexOf + 1) : str;
    }

    public static String getFilenameExtension(String str) {
        int lastIndexOf;
        if (str == null || (lastIndexOf = str.lastIndexOf(46)) == -1 || str.lastIndexOf("/") > lastIndexOf) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    public static String stripFilenameExtension(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || str.lastIndexOf("/") > lastIndexOf) ? str : str.substring(0, lastIndexOf);
    }

    public static String applyRelativePath(String str, String str2) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            String substring = str.substring(0, lastIndexOf);
            if (!str2.startsWith("/")) {
                substring = substring + "/";
            }
            return substring + str2;
        }
        return str2;
    }

    public static String cleanPath(String str) {
        if (str == null) {
            return null;
        }
        String replace = replace(str, IStringUtil.WINDOWS_FOLDER_SEPARATOR, "/");
        int indexOf = replace.indexOf(":");
        String str2 = "";
        if (indexOf != -1) {
            str2 = replace.substring(0, indexOf + 1);
            if (str2.contains("/")) {
                str2 = "";
            } else {
                replace = replace.substring(indexOf + 1);
            }
        }
        if (replace.startsWith("/")) {
            str2 = str2 + "/";
            replace = replace.substring(1);
        }
        String[] delimitedListToStringArray = delimitedListToStringArray(replace, "/");
        LinkedList linkedList = new LinkedList();
        int i = 0;
        for (int length = delimitedListToStringArray.length - 1; length >= 0; length--) {
            String str3 = delimitedListToStringArray[length];
            if (!".".equals(str3)) {
                if (IStringUtil.TOP_PATH.equals(str3)) {
                    i++;
                } else if (i > 0) {
                    i--;
                } else {
                    linkedList.add(0, str3);
                }
            }
        }
        for (int i2 = 0; i2 < i; i2++) {
            linkedList.add(0, IStringUtil.TOP_PATH);
        }
        return str2 + collectionToDelimitedString(linkedList, "/");
    }

    public static boolean pathEquals(String str, String str2) {
        return cleanPath(str).equals(cleanPath(str2));
    }

    public static Locale parseLocaleString(String str) {
        String[] strArr = tokenizeToStringArray(str, "_ ", false, false);
        String str2 = strArr.length > 0 ? strArr[0] : "";
        String str3 = strArr.length > 1 ? strArr[1] : "";
        validateLocalePart(str2);
        validateLocalePart(str3);
        String str4 = "";
        if (strArr.length > 2) {
            str4 = trimLeadingWhitespace(str.substring(str.indexOf(str3, str2.length()) + str3.length()));
            if (str4.startsWith(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
                str4 = trimLeadingCharacter(str4, '_');
            }
        }
        if (str2.length() > 0) {
            return new Locale(str2, str3, str4);
        }
        return null;
    }

    private static void validateLocalePart(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt != '_' && charAt != ' ' && !Character.isLetterOrDigit(charAt)) {
                throw new IllegalArgumentException("Locale part \"" + str + "\" contains invalid characters");
            }
        }
    }

    public static String toLanguageTag(Locale locale) {
        return locale.getLanguage() + (hasText(locale.getCountry()) ? Constants.ACCEPT_TIME_SEPARATOR_SERVER + locale.getCountry() : "");
    }

    public static String[] addStringToArray(String[] strArr, String str) {
        if (isObjectArrayEmpty(strArr)) {
            return new String[]{str};
        }
        String[] strArr2 = new String[strArr.length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr.length] = str;
        return strArr2;
    }

    private static boolean isObjectArrayEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static String[] concatenateStringArrays(String[] strArr, String[] strArr2) {
        if (!isObjectArrayEmpty(strArr)) {
            if (isObjectArrayEmpty(strArr2)) {
                return strArr;
            }
            String[] strArr3 = new String[strArr.length + strArr2.length];
            System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
            System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
            return strArr3;
        }
        return strArr2;
    }

    public static String[] mergeStringArrays(String[] strArr, String[] strArr2) {
        if (!isObjectArrayEmpty(strArr)) {
            if (isObjectArrayEmpty(strArr2)) {
                return strArr;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(Arrays.asList(strArr));
            for (String str : strArr2) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
            return toStringArray(arrayList);
        }
        return strArr2;
    }

    public static String[] sortStringArray(String[] strArr) {
        if (isObjectArrayEmpty(strArr)) {
            return new String[0];
        }
        Arrays.sort(strArr);
        return strArr;
    }

    public static String[] toStringArray(Collection<String> collection) {
        if (collection == null) {
            return null;
        }
        return (String[]) collection.toArray(new String[collection.size()]);
    }

    public static String[] toStringArray(Enumeration<String> enumeration) {
        if (enumeration == null) {
            return null;
        }
        ArrayList list = Collections.list(enumeration);
        return (String[]) list.toArray(new String[list.size()]);
    }

    public static String[] trimArrayElements(String[] strArr) {
        if (isObjectArrayEmpty(strArr)) {
            return new String[0];
        }
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            strArr2[i] = str != null ? str.trim() : null;
        }
        return strArr2;
    }

    public static String[] removeDuplicateStrings(String[] strArr) {
        if (!isObjectArrayEmpty(strArr)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (String str : strArr) {
                linkedHashSet.add(str);
            }
            return toStringArray(linkedHashSet);
        }
        return strArr;
    }

    public static String[] split(String str, String str2) {
        int indexOf;
        if (hasLength(str) && hasLength(str2) && (indexOf = str.indexOf(str2)) >= 0) {
            return new String[]{str.substring(0, indexOf), str.substring(str2.length() + indexOf)};
        }
        return null;
    }

    public static Properties splitArrayElementsIntoProperties(String[] strArr, String str) {
        return splitArrayElementsIntoProperties(strArr, str, null);
    }

    public static Properties splitArrayElementsIntoProperties(String[] strArr, String str, String str2) {
        if (isObjectArrayEmpty(strArr)) {
            return null;
        }
        Properties properties = new Properties();
        for (String str3 : strArr) {
            if (str2 != null) {
                str3 = deleteAny(str3, str2);
            }
            String[] split = split(str3, str);
            if (split != null) {
                properties.setProperty(split[0].trim(), split[1].trim());
            }
        }
        return properties;
    }

    public static String[] tokenizeToStringArray(String str, String str2) {
        return tokenizeToStringArray(str, str2, true, true);
    }

    public static String[] tokenizeToStringArray(String str, String str2, boolean z, boolean z2) {
        if (str == null) {
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (z) {
                nextToken = nextToken.trim();
            }
            if (!z2 || nextToken.length() > 0) {
                arrayList.add(nextToken);
            }
        }
        return toStringArray(arrayList);
    }

    public static String[] delimitedListToStringArray(String str, String str2) {
        return delimitedListToStringArray(str, str2, null);
    }

    public static String[] delimitedListToStringArray(String str, String str2, String str3) {
        int i = 0;
        if (str == null) {
            return new String[0];
        }
        if (str2 == null) {
            return new String[]{str};
        }
        ArrayList arrayList = new ArrayList();
        if ("".equals(str2)) {
            while (i < str.length()) {
                arrayList.add(deleteAny(str.substring(i, i + 1), str3));
                i++;
            }
        } else {
            while (true) {
                int indexOf = str.indexOf(str2, i);
                if (indexOf == -1) {
                    break;
                }
                arrayList.add(deleteAny(str.substring(i, indexOf), str3));
                i = str2.length() + indexOf;
            }
            if (str.length() > 0 && i <= str.length()) {
                arrayList.add(deleteAny(str.substring(i), str3));
            }
        }
        return toStringArray(arrayList);
    }

    public static String[] commaDelimitedListToStringArray(String str) {
        return delimitedListToStringArray(str, Constants.ACCEPT_TIME_SEPARATOR_SP);
    }

    public static Set<String> commaDelimitedListToSet(String str) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str2 : commaDelimitedListToStringArray(str)) {
            linkedHashSet.add(str2);
        }
        return linkedHashSet;
    }

    public static String collectionToDelimitedString(Collection<?> collection, String str, String str2, String str3) {
        if (collectionIsEmpty(collection)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(str2).append(it.next()).append(str3);
            if (it.hasNext()) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    private static boolean collectionIsEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static String collectionToDelimitedString(Collection<?> collection, String str) {
        return collectionToDelimitedString(collection, str, "", "");
    }

    public static String collectionToCommaDelimitedString(Collection<?> collection) {
        return collectionToDelimitedString(collection, Constants.ACCEPT_TIME_SEPARATOR_SP);
    }

    public static String arrayToDelimitedString(Object[] objArr, String str) {
        if (isObjectArrayEmpty(objArr)) {
            return "";
        }
        if (objArr.length == 1) {
            return nullSafeToString(objArr[0]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objArr.length; i++) {
            if (i > 0) {
                sb.append(str);
            }
            sb.append(objArr[i]);
        }
        return sb.toString();
    }

    public static String arrayToCommaDelimitedString(Object[] objArr) {
        return arrayToDelimitedString(objArr, Constants.ACCEPT_TIME_SEPARATOR_SP);
    }

    private static String nullSafeToString(Object obj) {
        if (obj == null) {
            return NULL_STRING;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Object[]) {
            return nullSafeToString((Object[]) obj);
        }
        if (obj instanceof boolean[]) {
            return nullSafeToString((boolean[]) obj);
        }
        if (obj instanceof byte[]) {
            return nullSafeToString((byte[]) obj);
        }
        if (obj instanceof char[]) {
            return nullSafeToString((char[]) obj);
        }
        if (obj instanceof double[]) {
            return nullSafeToString((double[]) obj);
        }
        if (obj instanceof float[]) {
            return nullSafeToString((float[]) obj);
        }
        if (obj instanceof int[]) {
            return nullSafeToString((int[]) obj);
        }
        if (obj instanceof long[]) {
            return nullSafeToString((long[]) obj);
        }
        if (obj instanceof short[]) {
            return nullSafeToString((short[]) obj);
        }
        String obj2 = obj.toString();
        if (obj2 == null) {
            obj2 = "";
        }
        return obj2;
    }

    private static String nullSafeToString(Object[] objArr) {
        if (objArr == null) {
            return NULL_STRING;
        }
        int length = objArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                sb.append(ARRAY_START);
            } else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(String.valueOf(objArr[i]));
        }
        sb.append(ARRAY_END);
        return sb.toString();
    }

    private static String nullSafeToString(boolean[] zArr) {
        if (zArr == null) {
            return NULL_STRING;
        }
        int length = zArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                sb.append(ARRAY_START);
            } else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(zArr[i]);
        }
        sb.append(ARRAY_END);
        return sb.toString();
    }

    private static String nullSafeToString(byte[] bArr) {
        if (bArr == null) {
            return NULL_STRING;
        }
        int length = bArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                sb.append(ARRAY_START);
            } else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append((int) bArr[i]);
        }
        sb.append(ARRAY_END);
        return sb.toString();
    }

    private static String nullSafeToString(char[] cArr) {
        if (cArr == null) {
            return NULL_STRING;
        }
        int length = cArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                sb.append(ARRAY_START);
            } else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("'").append(cArr[i]).append("'");
        }
        sb.append(ARRAY_END);
        return sb.toString();
    }

    public static String nullSafeToString(double[] dArr) {
        if (dArr == null) {
            return NULL_STRING;
        }
        int length = dArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                sb.append(ARRAY_START);
            } else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(dArr[i]);
        }
        sb.append(ARRAY_END);
        return sb.toString();
    }

    private static String nullSafeToString(float[] fArr) {
        if (fArr == null) {
            return NULL_STRING;
        }
        int length = fArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                sb.append(ARRAY_START);
            } else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(fArr[i]);
        }
        sb.append(ARRAY_END);
        return sb.toString();
    }

    private static String nullSafeToString(int[] iArr) {
        if (iArr == null) {
            return NULL_STRING;
        }
        int length = iArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                sb.append(ARRAY_START);
            } else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(iArr[i]);
        }
        sb.append(ARRAY_END);
        return sb.toString();
    }

    private static String nullSafeToString(long[] jArr) {
        if (jArr == null) {
            return NULL_STRING;
        }
        int length = jArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                sb.append(ARRAY_START);
            } else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(jArr[i]);
        }
        sb.append(ARRAY_END);
        return sb.toString();
    }

    private static String nullSafeToString(short[] sArr) {
        if (sArr == null) {
            return NULL_STRING;
        }
        int length = sArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                sb.append(ARRAY_START);
            } else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append((int) sArr[i]);
        }
        sb.append(ARRAY_END);
        return sb.toString();
    }

    public static String removeEmoji(String str) {
        return isEmpty(str) ? "" : str.trim().replaceAll("([\ue000-\ue5ff])", "");
    }

    public static boolean isEmail(String str) {
        return Pattern.matches(IStringUtil.REGEX_EMAIL, str);
    }

    public static boolean isNumbers(String str) {
        return Pattern.matches(IStringUtil.REGEX_NUM, str);
    }

    public static boolean hasLowerLetter(String str) {
        return Pattern.compile("[a-z]+").matcher(str).find();
    }

    public static boolean hasUpLetter(String str) {
        return Pattern.compile("[A-Z]+").matcher(str).find();
    }

    public static boolean hasNumber(String str) {
        return Pattern.compile(EditTextPasteFilterUtils.REGX_NUMBER).matcher(str).find();
    }

    public static boolean lenghtEnought(String str, int i) {
        return i >= 0 && !isEmpty(str) && str.length() >= i;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1760=4, 1756=4, 1757=4, 1759=4] */
    public static String getStringFromInput(InputStream inputStream) {
        byte[] byteFromInputStream;
        try {
            try {
                byteFromInputStream = getByteFromInputStream(inputStream);
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            if (DEBUG) {
                Log.e(TAG, " getStringFromInput exception: ", e2);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        if (byteFromInputStream == null) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            return null;
        }
        String str = new String(byteFromInputStream);
        if (str != null && str.startsWith("\ufeff")) {
            str = str.substring(1);
        }
        if (inputStream != null) {
            try {
                inputStream.close();
                return str;
            } catch (Exception e5) {
                e5.printStackTrace();
                return str;
            }
        }
        return str;
    }

    public static byte[] getByteFromInputStream(InputStream inputStream) {
        int i;
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                i = inputStream.read(bArr, 0, bArr.length);
            } catch (IOException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                i = 0;
            }
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (IOException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                        return byteArray;
                    }
                    return byteArray;
                }
            }
        }
    }

    public static boolean containsEmoji(String str) {
        return !TextUtils.isEmpty(str) && Pattern.compile("[🀀-🏿]|[🐀-\u1f7ff]|[☀-⟿]", 66).matcher(str).find();
    }

    public static int countWordsLength(String str) {
        char[] charArray;
        if (TextUtils.isEmpty(str)) {
            return (int) 0.0f;
        }
        float f = 0.0f;
        for (char c : str.toCharArray()) {
            if (c > 0 && c < 127) {
                f = (float) (f + 0.5d);
            } else {
                f += 1.0f;
            }
        }
        return (int) f;
    }

    public static float countWordsLengthForFloat(String str) {
        char[] charArray;
        if (TextUtils.isEmpty(str)) {
            return (int) 0.0f;
        }
        float f = 0.0f;
        for (char c : str.toCharArray()) {
            if (c > 0 && c < 127) {
                f = (float) (f + 0.5d);
            } else {
                f += 1.0f;
            }
        }
        return f;
    }

    public static int countWordsRealLength(String str) {
        char[] charArray;
        int i = 0;
        if (!TextUtils.isEmpty(str)) {
            for (char c : str.toCharArray()) {
                if (c <= 0 || c < 127) {
                    i++;
                } else {
                    i++;
                }
            }
        }
        return i;
    }

    public static boolean isLetterDigitOrChinese(String str) {
        return str.matches("^[a-z0-9A-Z一-龥]+$");
    }

    public static boolean isBlank(CharSequence charSequence) {
        int length;
        if (charSequence == null || (length = charSequence.length()) == 0) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(CharSequence charSequence) {
        int length;
        if (charSequence == null || (length = charSequence.length()) == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
