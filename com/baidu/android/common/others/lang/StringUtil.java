package com.baidu.android.common.others.lang;

import android.util.Log;
import com.baidu.android.common.others.IStringUtil;
import com.google.zxing.client.result.ResultParser;
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
@Deprecated
/* loaded from: classes.dex */
public final class StringUtil implements IStringUtil {
    public static final String ARRAY_ELEMENT_SEPARATOR = ", ";
    public static final String ARRAY_END = "}";
    public static final String ARRAY_START = "{";
    public static final String EMPTY_ARRAY = "{}";
    public static final String EMPTY_STRING = "";
    public static final String NULL_STRING = "null";
    public static String TAG = "StringUtil";

    @Deprecated
    public static String[] addStringToArray(String[] strArr, String str) {
        if (isObjectArrayEmpty(strArr)) {
            return new String[]{str};
        }
        String[] strArr2 = new String[strArr.length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr.length] = str;
        return strArr2;
    }

    @Deprecated
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

    @Deprecated
    public static String arrayToCommaDelimitedString(Object[] objArr) {
        return arrayToDelimitedString(objArr, ",");
    }

    @Deprecated
    public static String arrayToDelimitedString(Object[] objArr, String str) {
        if (isObjectArrayEmpty(objArr)) {
            return "";
        }
        if (objArr.length == 1) {
            return nullSafeToString(objArr[0]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (i2 > 0) {
                sb.append(str);
            }
            sb.append(objArr[i2]);
        }
        return sb.toString();
    }

    @Deprecated
    public static String capitalize(String str) {
        return changeFirstCharacterCase(str, true);
    }

    public static String changeFirstCharacterCase(String str, boolean z) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        if (z) {
            sb.append(Character.toUpperCase(str.charAt(0)));
        } else {
            sb.append(Character.toLowerCase(str.charAt(0)));
        }
        sb.append(str.substring(1));
        return sb.toString();
    }

    @Deprecated
    public static String cleanPath(String str) {
        if (str == null) {
            return null;
        }
        String replace = replace(str, IStringUtil.WINDOWS_FOLDER_SEPARATOR, "/");
        int indexOf = replace.indexOf(":");
        String str2 = "";
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            String substring = replace.substring(0, i2);
            if (!substring.contains("/")) {
                replace = replace.substring(i2);
                str2 = substring;
            }
        }
        if (replace.startsWith("/")) {
            str2 = str2 + "/";
            replace = replace.substring(1);
        }
        String[] delimitedListToStringArray = delimitedListToStringArray(replace, "/");
        LinkedList linkedList = new LinkedList();
        int i3 = 0;
        for (int length = delimitedListToStringArray.length - 1; length >= 0; length--) {
            String str3 = delimitedListToStringArray[length];
            if (!".".equals(str3)) {
                if (IStringUtil.TOP_PATH.equals(str3)) {
                    i3++;
                } else if (i3 > 0) {
                    i3--;
                } else {
                    linkedList.add(0, str3);
                }
            }
        }
        for (int i4 = 0; i4 < i3; i4++) {
            linkedList.add(0, IStringUtil.TOP_PATH);
        }
        return str2 + collectionToDelimitedString(linkedList, "/");
    }

    public static boolean collectionIsEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    @Deprecated
    public static String collectionToCommaDelimitedString(Collection<?> collection) {
        return collectionToDelimitedString(collection, ",");
    }

    @Deprecated
    public static String collectionToDelimitedString(Collection<?> collection, String str, String str2, String str3) {
        if (collectionIsEmpty(collection)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(str2);
            sb.append(it.next());
            sb.append(str3);
            if (it.hasNext()) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    @Deprecated
    public static Set<String> commaDelimitedListToSet(String str) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str2 : commaDelimitedListToStringArray(str)) {
            linkedHashSet.add(str2);
        }
        return linkedHashSet;
    }

    @Deprecated
    public static String[] commaDelimitedListToStringArray(String str) {
        return delimitedListToStringArray(str, ",");
    }

    @Deprecated
    public static String[] concatenateStringArrays(String[] strArr, String[] strArr2) {
        if (isObjectArrayEmpty(strArr)) {
            return strArr2;
        }
        if (isObjectArrayEmpty(strArr2)) {
            return strArr;
        }
        String[] strArr3 = new String[strArr.length + strArr2.length];
        System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }

    @Deprecated
    public static boolean containsEmoji(String str) {
        return EmojionUtils.containsEmoji(str);
    }

    @Deprecated
    public static boolean containsWhitespace(CharSequence charSequence) {
        return StringUtils.containsWhitespace(charSequence);
    }

    @Deprecated
    public static int countOccurrencesOf(String str, String str2) {
        return StringUtils.getRepetitions(str, str2);
    }

    @Deprecated
    public static int countWordsLength(String str) {
        return StringUtils.length(str, true) / 2;
    }

    @Deprecated
    public static float countWordsLengthForFloat(String str) {
        return StringUtils.length(str, true) / 2.0f;
    }

    @Deprecated
    public static int countWordsRealLength(String str) {
        return StringUtils.length(str, false) / 2;
    }

    @Deprecated
    public static String delete(String str, String str2) {
        return replace(str, str2, "");
    }

    @Deprecated
    public static String deleteAny(String str, String str2) {
        if (hasLength(str) && hasLength(str2)) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (str2.indexOf(charAt) == -1) {
                    sb.append(charAt);
                }
            }
            return sb.toString();
        }
        return str;
    }

    @Deprecated
    public static String[] delimitedListToStringArray(String str, String str2) {
        return delimitedListToStringArray(str, str2, null);
    }

    @Deprecated
    public static boolean endsWithIgnoreCase(String str, String str2) {
        return StringUtils.endsWith(str, str2, true);
    }

    @Deprecated
    public static byte[] getByteFromInputStream(InputStream inputStream) {
        int i2;
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                i2 = inputStream.read(bArr, 0, 1024);
            } catch (IOException e2) {
                Log.e(TAG, e2.toString());
                i2 = 0;
            }
            if (i2 == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e3) {
            Log.e(TAG, e3.toString());
        }
        return byteArray;
    }

    @Deprecated
    public static String getFilename(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf("/");
        return lastIndexOf != -1 ? str.substring(lastIndexOf + 1) : str;
    }

    @Deprecated
    public static String getFilenameExtension(String str) {
        int lastIndexOf;
        if (str == null || (lastIndexOf = str.lastIndexOf(46)) == -1 || str.lastIndexOf("/") > lastIndexOf) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    @Deprecated
    public static String getStringFromInput(InputStream inputStream) {
        try {
            try {
                try {
                    byte[] byteFromInputStream = getByteFromInputStream(inputStream);
                    if (byteFromInputStream != null) {
                        String str = new String(byteFromInputStream);
                        if (str.startsWith(ResultParser.BYTE_ORDER_MARK)) {
                            str = str.substring(1);
                        }
                        return str;
                    } else if (inputStream != null) {
                        inputStream.close();
                        return null;
                    } else {
                        return null;
                    }
                } catch (Exception e2) {
                    Log.e(TAG, e2.toString());
                    return null;
                }
            } catch (Exception e3) {
                Log.e(TAG, " getStringFromInput exception: ", e3);
                if (inputStream != null) {
                    inputStream.close();
                    return null;
                }
                return null;
            }
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e4) {
                    Log.e(TAG, e4.toString());
                }
            }
        }
    }

    @Deprecated
    public static boolean hasLength(CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0;
    }

    @Deprecated
    public static boolean hasLowerLetter(String str) {
        return Pattern.compile("[a-z]+").matcher(str).find();
    }

    @Deprecated
    public static boolean hasNumber(String str) {
        return Pattern.compile("[0-9]+").matcher(str).find();
    }

    @Deprecated
    public static boolean hasText(CharSequence charSequence) {
        return !StringUtils.isBlank(charSequence);
    }

    @Deprecated
    public static boolean hasUpLetter(String str) {
        return Pattern.compile("[A-Z]+").matcher(str).find();
    }

    public static boolean isBlank(CharSequence charSequence) {
        return StringUtils.isBlank(charSequence);
    }

    @Deprecated
    public static boolean isEmail(String str) {
        return Pattern.matches(IStringUtil.REGEX_EMAIL, str);
    }

    public static boolean isEmpty(Object obj) {
        return obj == null || "".equals(obj);
    }

    @Deprecated
    public static boolean isLetterDigitOrChinese(String str) {
        return str.matches("^[a-z0-9A-Z一-龥]+$");
    }

    @Deprecated
    public static boolean isNotBlank(CharSequence charSequence) {
        return !isBlank(charSequence);
    }

    @Deprecated
    public static boolean isNumbers(String str) {
        return Pattern.matches(IStringUtil.REGEX_NUM, str);
    }

    public static boolean isObjectArrayEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    @Deprecated
    public static boolean lenghtEnought(String str, int i2) {
        return i2 >= 0 && !isEmpty(str) && str.length() >= i2;
    }

    @Deprecated
    public static String[] mergeStringArrays(String[] strArr, String[] strArr2) {
        if (isObjectArrayEmpty(strArr)) {
            return strArr2;
        }
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

    public static String nullSafeToString(Object obj) {
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
        return obj2 != null ? obj2 : "";
    }

    @Deprecated
    public static Locale parseLocaleString(String str) {
        String[] strArr = tokenizeToStringArray(str, "_ ", false, false);
        if (strArr == null) {
            return null;
        }
        String str2 = "";
        String str3 = strArr.length > 0 ? strArr[0] : "";
        String str4 = strArr.length > 1 ? strArr[1] : "";
        validateLocalePart(str3);
        validateLocalePart(str4);
        if (strArr.length > 2) {
            str2 = trimLeadingWhitespace(str.substring(str.indexOf(str4, str3.length()) + str4.length()));
            if (str2.startsWith("_")) {
                str2 = trimLeadingCharacter(str2, '_');
            }
        }
        if (str3.length() > 0) {
            return new Locale(str3, str4, str2);
        }
        return null;
    }

    @Deprecated
    public static boolean pathEquals(String str, String str2) {
        return cleanPath(str).equals(cleanPath(str2));
    }

    @Deprecated
    public static String quote(String str) {
        if (str != null) {
            return "'" + str + "'";
        }
        return null;
    }

    @Deprecated
    public static Object quoteIfString(Object obj) {
        return obj instanceof String ? quote((String) obj) : obj;
    }

    @Deprecated
    public static String[] removeDuplicateStrings(String[] strArr) {
        if (isObjectArrayEmpty(strArr)) {
            return strArr;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : strArr) {
            linkedHashSet.add(str);
        }
        return toStringArray(linkedHashSet);
    }

    @Deprecated
    public static String removeEmoji(String str) {
        return EmojionUtils.removeEmoji(str);
    }

    @Deprecated
    public static String replace(String str, String str2, String str3) {
        if (hasLength(str) && hasLength(str2) && str3 != null) {
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            while (indexOf >= 0) {
                sb.append(str.substring(i2, indexOf));
                sb.append(str3);
                i2 = indexOf + length;
                indexOf = str.indexOf(str2, i2);
            }
            sb.append(str.substring(i2));
            return sb.toString();
        }
        return str;
    }

    @Deprecated
    public static String[] sortStringArray(String[] strArr) {
        if (isObjectArrayEmpty(strArr)) {
            return new String[0];
        }
        Arrays.sort(strArr);
        return strArr;
    }

    @Deprecated
    public static String[] split(String str, String str2) {
        int indexOf;
        if (hasLength(str) && hasLength(str2) && (indexOf = str.indexOf(str2)) >= 0) {
            return new String[]{str.substring(0, indexOf), str.substring(indexOf + str2.length())};
        }
        return null;
    }

    @Deprecated
    public static Properties splitArrayElementsIntoProperties(String[] strArr, String str) {
        return splitArrayElementsIntoProperties(strArr, str, null);
    }

    @Deprecated
    public static boolean startsWithIgnoreCase(String str, String str2) {
        return StringUtils.startsWith(str, str2, true);
    }

    @Deprecated
    public static String stripFilenameExtension(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf != -1 && str.lastIndexOf("/") <= lastIndexOf) ? str.substring(0, lastIndexOf) : str;
    }

    @Deprecated
    public static boolean substringMatch(CharSequence charSequence, int i2, CharSequence charSequence2) {
        for (int i3 = 0; i3 < charSequence2.length(); i3++) {
            int i4 = i2 + i3;
            if (i4 >= charSequence.length() || charSequence.charAt(i4) != charSequence2.charAt(i3)) {
                return false;
            }
        }
        return true;
    }

    @Deprecated
    public static String toLanguageTag(Locale locale) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(locale.getLanguage());
        if (hasText(locale.getCountry())) {
            str = "-" + locale.getCountry();
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    @Deprecated
    public static String[] toStringArray(Collection<String> collection) {
        if (collection == null) {
            return null;
        }
        return (String[]) collection.toArray(new String[collection.size()]);
    }

    @Deprecated
    public static String[] tokenizeToStringArray(String str, String str2) {
        return tokenizeToStringArray(str, str2, true, true);
    }

    @Deprecated
    public static String trimAllWhitespace(String str) {
        if (hasLength(str)) {
            int length = str.length();
            StringBuilder sb = new StringBuilder(length);
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (!Character.isWhitespace(charAt)) {
                    sb.append(charAt);
                }
            }
            return sb.toString();
        }
        return str;
    }

    @Deprecated
    public static String[] trimArrayElements(String[] strArr) {
        if (isObjectArrayEmpty(strArr)) {
            return new String[0];
        }
        String[] strArr2 = new String[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str = strArr[i2];
            strArr2[i2] = str != null ? str.trim() : null;
        }
        return strArr2;
    }

    @Deprecated
    public static String trimLeadingCharacter(String str, char c2) {
        if (hasLength(str)) {
            StringBuilder sb = new StringBuilder(str);
            while (sb.length() > 0 && sb.charAt(0) == c2) {
                sb.deleteCharAt(0);
            }
            return sb.toString();
        }
        return str;
    }

    @Deprecated
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

    @Deprecated
    public static String trimTrailingCharacter(String str, char c2) {
        if (hasLength(str)) {
            StringBuilder sb = new StringBuilder(str);
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) == c2) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
        return str;
    }

    @Deprecated
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

    @Deprecated
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

    @Deprecated
    public static String uncapitalize(String str) {
        return changeFirstCharacterCase(str, false);
    }

    @Deprecated
    public static String unqualify(String str) {
        return unqualify(str, IStringUtil.EXTENSION_SEPARATOR);
    }

    public static void validateLocalePart(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt != '_' && charAt != ' ' && !Character.isLetterOrDigit(charAt)) {
                throw new IllegalArgumentException("Locale part \"" + str + "\" contains invalid characters");
            }
        }
    }

    @Deprecated
    public static boolean containsWhitespace(String str) {
        return containsWhitespace((CharSequence) str);
    }

    @Deprecated
    public static String[] delimitedListToStringArray(String str, String str2, String str3) {
        int i2 = 0;
        if (str == null) {
            return new String[0];
        }
        if (str2 == null) {
            return new String[]{str};
        }
        ArrayList arrayList = new ArrayList();
        if ("".equals(str2)) {
            while (i2 < str.length()) {
                int i3 = i2 + 1;
                arrayList.add(deleteAny(str.substring(i2, i3), str3));
                i2 = i3;
            }
        } else {
            while (true) {
                int indexOf = str.indexOf(str2, i2);
                if (indexOf == -1) {
                    break;
                }
                arrayList.add(deleteAny(str.substring(i2, indexOf), str3));
                i2 = str2.length() + indexOf;
            }
            if (str.length() > 0 && i2 <= str.length()) {
                arrayList.add(deleteAny(str.substring(i2), str3));
            }
        }
        return toStringArray(arrayList);
    }

    @Deprecated
    public static boolean hasLength(String str) {
        return hasLength((CharSequence) str);
    }

    @Deprecated
    public static boolean hasText(String str) {
        return hasText((CharSequence) str);
    }

    @Deprecated
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

    @Deprecated
    public static String[] toStringArray(Enumeration<String> enumeration) {
        if (enumeration == null) {
            return null;
        }
        ArrayList list = Collections.list(enumeration);
        return (String[]) list.toArray(new String[list.size()]);
    }

    @Deprecated
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

    @Deprecated
    public static String unqualify(String str, char c2) {
        return str.substring(str.lastIndexOf(c2) + 1);
    }

    @Deprecated
    public static String collectionToDelimitedString(Collection<?> collection, String str) {
        return collectionToDelimitedString(collection, str, "", "");
    }

    public static String nullSafeToString(Object[] objArr) {
        if (objArr == null) {
            return NULL_STRING;
        }
        int length = objArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 == 0) {
                sb.append(ARRAY_START);
            } else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(String.valueOf(objArr[i2]));
        }
        sb.append("}");
        return sb.toString();
    }

    public static String nullSafeToString(boolean[] zArr) {
        if (zArr == null) {
            return NULL_STRING;
        }
        int length = zArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 == 0) {
                sb.append(ARRAY_START);
            } else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(zArr[i2]);
        }
        sb.append("}");
        return sb.toString();
    }

    public static String nullSafeToString(byte[] bArr) {
        if (bArr == null) {
            return NULL_STRING;
        }
        int length = bArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 == 0) {
                sb.append(ARRAY_START);
            } else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append((int) bArr[i2]);
        }
        sb.append("}");
        return sb.toString();
    }

    public static String nullSafeToString(char[] cArr) {
        if (cArr == null) {
            return NULL_STRING;
        }
        int length = cArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 == 0) {
                sb.append(ARRAY_START);
            } else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("'");
            sb.append(cArr[i2]);
            sb.append("'");
        }
        sb.append("}");
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
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 == 0) {
                sb.append(ARRAY_START);
            } else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(dArr[i2]);
        }
        sb.append("}");
        return sb.toString();
    }

    public static String nullSafeToString(float[] fArr) {
        if (fArr == null) {
            return NULL_STRING;
        }
        int length = fArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 == 0) {
                sb.append(ARRAY_START);
            } else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(fArr[i2]);
        }
        sb.append("}");
        return sb.toString();
    }

    public static String nullSafeToString(int[] iArr) {
        if (iArr == null) {
            return NULL_STRING;
        }
        int length = iArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 == 0) {
                sb.append(ARRAY_START);
            } else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(iArr[i2]);
        }
        sb.append("}");
        return sb.toString();
    }

    public static String nullSafeToString(long[] jArr) {
        if (jArr == null) {
            return NULL_STRING;
        }
        int length = jArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 == 0) {
                sb.append(ARRAY_START);
            } else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(jArr[i2]);
        }
        sb.append("}");
        return sb.toString();
    }

    public static String nullSafeToString(short[] sArr) {
        if (sArr == null) {
            return NULL_STRING;
        }
        int length = sArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 == 0) {
                sb.append(ARRAY_START);
            } else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append((int) sArr[i2]);
        }
        sb.append("}");
        return sb.toString();
    }
}
