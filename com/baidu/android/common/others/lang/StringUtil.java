package com.baidu.android.common.others.lang;

import android.annotation.SuppressLint;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes10.dex */
public final class StringUtil implements IStringUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ARRAY_ELEMENT_SEPARATOR = ", ";
    public static final String ARRAY_END = "}";
    public static final String ARRAY_START = "{";
    public static final String EMPTY_ARRAY = "{}";
    public static final String EMPTY_STRING = "";
    public static final String NULL_STRING = "null";
    public static String TAG = "StringUtil";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1465209181, "Lcom/baidu/android/common/others/lang/StringUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1465209181, "Lcom/baidu/android/common/others/lang/StringUtil;");
        }
    }

    public StringUtil() {
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

    @Deprecated
    public static String[] addStringToArray(String[] strArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, strArr, str)) == null) {
            if (isObjectArrayEmpty(strArr)) {
                return new String[]{str};
            }
            String[] strArr2 = new String[strArr.length + 1];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            strArr2[strArr.length] = str;
            return strArr2;
        }
        return (String[]) invokeLL.objValue;
    }

    @Deprecated
    public static String applyRelativePath(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
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
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public static String arrayToCommaDelimitedString(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, objArr)) == null) ? arrayToDelimitedString(objArr, ",") : (String) invokeL.objValue;
    }

    @Deprecated
    public static String arrayToDelimitedString(Object[] objArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, objArr, str)) == null) {
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
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public static String capitalize(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? changeFirstCharacterCase(str, true) : (String) invokeL.objValue;
    }

    public static String changeFirstCharacterCase(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, null, str, z)) == null) {
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
        return (String) invokeLZ.objValue;
    }

    @Deprecated
    public static String cleanPath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static boolean collectionIsEmpty(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, collection)) == null) ? collection == null || collection.isEmpty() : invokeL.booleanValue;
    }

    @Deprecated
    public static String collectionToCommaDelimitedString(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, collection)) == null) ? collectionToDelimitedString(collection, ",") : (String) invokeL.objValue;
    }

    @Deprecated
    public static String collectionToDelimitedString(Collection<?> collection, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, collection, str, str2, str3)) == null) {
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
        return (String) invokeLLLL.objValue;
    }

    @Deprecated
    public static Set<String> commaDelimitedListToSet(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (String str2 : commaDelimitedListToStringArray(str)) {
                linkedHashSet.add(str2);
            }
            return linkedHashSet;
        }
        return (Set) invokeL.objValue;
    }

    @Deprecated
    public static String[] commaDelimitedListToStringArray(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) ? delimitedListToStringArray(str, ",") : (String[]) invokeL.objValue;
    }

    @Deprecated
    public static String[] concatenateStringArrays(String[] strArr, String[] strArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, strArr, strArr2)) == null) {
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
        return (String[]) invokeLL.objValue;
    }

    @Deprecated
    public static boolean containsEmoji(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) ? EmojionUtils.containsEmoji(str) : invokeL.booleanValue;
    }

    @Deprecated
    public static boolean containsWhitespace(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, charSequence)) == null) ? StringUtils.containsWhitespace(charSequence) : invokeL.booleanValue;
    }

    @Deprecated
    public static int countOccurrencesOf(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, str, str2)) == null) ? StringUtils.getRepetitions(str, str2) : invokeLL.intValue;
    }

    @Deprecated
    public static int countWordsLength(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) ? StringUtils.length(str, true) / 2 : invokeL.intValue;
    }

    @Deprecated
    public static float countWordsLengthForFloat(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) ? StringUtils.length(str, true) / 2.0f : invokeL.floatValue;
    }

    @Deprecated
    public static int countWordsRealLength(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) ? StringUtils.length(str, false) / 2 : invokeL.intValue;
    }

    @Deprecated
    public static String delete(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, str, str2)) == null) ? replace(str, str2, "") : (String) invokeLL.objValue;
    }

    @Deprecated
    public static String deleteAny(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, str, str2)) == null) {
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
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public static String[] delimitedListToStringArray(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, str, str2)) == null) ? delimitedListToStringArray(str, str2, null) : (String[]) invokeLL.objValue;
    }

    @Deprecated
    public static boolean endsWithIgnoreCase(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, str, str2)) == null) ? StringUtils.endsWith(str, str2, true) : invokeLL.booleanValue;
    }

    @Deprecated
    public static byte[] getByteFromInputStream(InputStream inputStream) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, inputStream)) == null) {
            if (inputStream == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    i2 = inputStream.read(bArr, 0, 1024);
                } catch (IOException e2) {
                    e2.toString();
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
                e3.toString();
            }
            return byteArray;
        }
        return (byte[]) invokeL.objValue;
    }

    @Deprecated
    public static String getFilename(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) {
            if (str == null) {
                return null;
            }
            int lastIndexOf = str.lastIndexOf("/");
            return lastIndexOf != -1 ? str.substring(lastIndexOf + 1) : str;
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static String getFilenameExtension(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            if (str == null || (lastIndexOf = str.lastIndexOf(46)) == -1 || str.lastIndexOf("/") > lastIndexOf) {
                return null;
            }
            return str.substring(lastIndexOf + 1);
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static String getStringFromInput(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, inputStream)) == null) {
            try {
                try {
                    byte[] byteFromInputStream = getByteFromInputStream(inputStream);
                    if (byteFromInputStream == null) {
                        if (inputStream != null) {
                            inputStream.close();
                            return null;
                        }
                        return null;
                    }
                    String str = new String(byteFromInputStream);
                    if (str.startsWith(ResultParser.BYTE_ORDER_MARK)) {
                        str = str.substring(1);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e2) {
                            e2.toString();
                        }
                    }
                    return str;
                } catch (Exception e3) {
                    e3.toString();
                    return null;
                }
            } catch (Exception unused) {
                if (inputStream != null) {
                    inputStream.close();
                    return null;
                }
                return null;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e4) {
                        e4.toString();
                    }
                }
                throw th;
            }
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static boolean hasLength(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65568, null, charSequence)) == null) ? charSequence != null && charSequence.length() > 0 : invokeL.booleanValue;
    }

    @Deprecated
    public static boolean hasLowerLetter(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65570, null, str)) == null) ? Pattern.compile("[a-z]+").matcher(str).find() : invokeL.booleanValue;
    }

    @Deprecated
    public static boolean hasNumber(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65571, null, str)) == null) ? Pattern.compile("[0-9]+").matcher(str).find() : invokeL.booleanValue;
    }

    @Deprecated
    public static boolean hasText(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65572, null, charSequence)) == null) ? !StringUtils.isBlank(charSequence) : invokeL.booleanValue;
    }

    @Deprecated
    public static boolean hasUpLetter(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65574, null, str)) == null) ? Pattern.compile("[A-Z]+").matcher(str).find() : invokeL.booleanValue;
    }

    public static boolean isBlank(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65575, null, charSequence)) == null) ? StringUtils.isBlank(charSequence) : invokeL.booleanValue;
    }

    @Deprecated
    public static boolean isEmail(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65576, null, str)) == null) ? Pattern.matches(IStringUtil.REGEX_EMAIL, str) : invokeL.booleanValue;
    }

    public static boolean isEmpty(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65577, null, obj)) == null) ? obj == null || "".equals(obj) : invokeL.booleanValue;
    }

    @Deprecated
    public static boolean isLetterDigitOrChinese(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65578, null, str)) == null) ? str.matches("^[a-z0-9A-Z一-龥]+$") : invokeL.booleanValue;
    }

    @Deprecated
    public static boolean isNotBlank(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65579, null, charSequence)) == null) ? !isBlank(charSequence) : invokeL.booleanValue;
    }

    @Deprecated
    public static boolean isNumbers(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65580, null, str)) == null) ? Pattern.matches(IStringUtil.REGEX_NUM, str) : invokeL.booleanValue;
    }

    public static boolean isObjectArrayEmpty(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65581, null, objArr)) == null) ? objArr == null || objArr.length == 0 : invokeL.booleanValue;
    }

    @Deprecated
    public static boolean lenghtEnought(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65582, null, str, i2)) == null) ? i2 >= 0 && !isEmpty(str) && str.length() >= i2 : invokeLI.booleanValue;
    }

    @Deprecated
    public static String[] mergeStringArrays(String[] strArr, String[] strArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65583, null, strArr, strArr2)) == null) {
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
        return (String[]) invokeLL.objValue;
    }

    public static String nullSafeToString(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, obj)) == null) {
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
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static Locale parseLocaleString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65594, null, str)) == null) {
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
        return (Locale) invokeL.objValue;
    }

    @Deprecated
    public static boolean pathEquals(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65595, null, str, str2)) == null) ? cleanPath(str).equals(cleanPath(str2)) : invokeLL.booleanValue;
    }

    @Deprecated
    public static String quote(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65596, null, str)) == null) {
            if (str != null) {
                return "'" + str + "'";
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static Object quoteIfString(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65597, null, obj)) == null) ? obj instanceof String ? quote((String) obj) : obj : invokeL.objValue;
    }

    @Deprecated
    public static String[] removeDuplicateStrings(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65598, null, strArr)) == null) {
            if (isObjectArrayEmpty(strArr)) {
                return strArr;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (String str : strArr) {
                linkedHashSet.add(str);
            }
            return toStringArray(linkedHashSet);
        }
        return (String[]) invokeL.objValue;
    }

    @Deprecated
    public static String removeEmoji(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65599, null, str)) == null) ? EmojionUtils.removeEmoji(str) : (String) invokeL.objValue;
    }

    @Deprecated
    public static String replace(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65600, null, str, str2, str3)) == null) {
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
        return (String) invokeLLL.objValue;
    }

    @Deprecated
    public static String[] sortStringArray(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65601, null, strArr)) == null) {
            if (isObjectArrayEmpty(strArr)) {
                return new String[0];
            }
            Arrays.sort(strArr);
            return strArr;
        }
        return (String[]) invokeL.objValue;
    }

    @Deprecated
    public static String[] split(String str, String str2) {
        InterceptResult invokeLL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65602, null, str, str2)) == null) {
            if (hasLength(str) && hasLength(str2) && (indexOf = str.indexOf(str2)) >= 0) {
                return new String[]{str.substring(0, indexOf), str.substring(indexOf + str2.length())};
            }
            return null;
        }
        return (String[]) invokeLL.objValue;
    }

    @Deprecated
    public static Properties splitArrayElementsIntoProperties(String[] strArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65603, null, strArr, str)) == null) ? splitArrayElementsIntoProperties(strArr, str, null) : (Properties) invokeLL.objValue;
    }

    @Deprecated
    public static boolean startsWithIgnoreCase(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65605, null, str, str2)) == null) ? StringUtils.startsWith(str, str2, true) : invokeLL.booleanValue;
    }

    @Deprecated
    public static String stripFilenameExtension(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65606, null, str)) == null) {
            if (str == null) {
                return null;
            }
            int lastIndexOf = str.lastIndexOf(46);
            return (lastIndexOf != -1 && str.lastIndexOf("/") <= lastIndexOf) ? str.substring(0, lastIndexOf) : str;
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static boolean substringMatch(CharSequence charSequence, int i2, CharSequence charSequence2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65607, null, charSequence, i2, charSequence2)) == null) {
            for (int i3 = 0; i3 < charSequence2.length(); i3++) {
                int i4 = i2 + i3;
                if (i4 >= charSequence.length() || charSequence.charAt(i4) != charSequence2.charAt(i3)) {
                    return false;
                }
            }
            return true;
        }
        return invokeLIL.booleanValue;
    }

    @Deprecated
    public static String toLanguageTag(Locale locale) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65608, null, locale)) == null) {
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
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static String[] toStringArray(Collection<String> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65609, null, collection)) == null) {
            if (collection == null) {
                return null;
            }
            return (String[]) collection.toArray(new String[collection.size()]);
        }
        return (String[]) invokeL.objValue;
    }

    @Deprecated
    public static String[] tokenizeToStringArray(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65611, null, str, str2)) == null) ? tokenizeToStringArray(str, str2, true, true) : (String[]) invokeLL.objValue;
    }

    @Deprecated
    public static String trimAllWhitespace(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65613, null, str)) == null) {
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
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static String[] trimArrayElements(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65614, null, strArr)) == null) {
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
        return (String[]) invokeL.objValue;
    }

    @Deprecated
    public static String trimLeadingCharacter(String str, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65615, null, new Object[]{str, Character.valueOf(c2)})) == null) {
            if (hasLength(str)) {
                StringBuilder sb = new StringBuilder(str);
                while (sb.length() > 0 && sb.charAt(0) == c2) {
                    sb.deleteCharAt(0);
                }
                return sb.toString();
            }
            return str;
        }
        return (String) invokeCommon.objValue;
    }

    @Deprecated
    public static String trimLeadingWhitespace(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65616, null, str)) == null) {
            if (hasLength(str)) {
                StringBuilder sb = new StringBuilder(str);
                while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
                    sb.deleteCharAt(0);
                }
                return sb.toString();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static String trimTrailingCharacter(String str, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65617, null, new Object[]{str, Character.valueOf(c2)})) == null) {
            if (hasLength(str)) {
                StringBuilder sb = new StringBuilder(str);
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) == c2) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                return sb.toString();
            }
            return str;
        }
        return (String) invokeCommon.objValue;
    }

    @Deprecated
    public static String trimTrailingWhitespace(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65618, null, str)) == null) {
            if (hasLength(str)) {
                StringBuilder sb = new StringBuilder(str);
                while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                return sb.toString();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static String trimWhitespace(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65619, null, str)) == null) {
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
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static String uncapitalize(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65620, null, str)) == null) ? changeFirstCharacterCase(str, false) : (String) invokeL.objValue;
    }

    @Deprecated
    public static String unqualify(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65621, null, str)) == null) ? unqualify(str, '.') : (String) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static void validateLocalePart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65623, null, str) == null) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (charAt != '_' && charAt != ' ' && !Character.isLetterOrDigit(charAt)) {
                    throw new IllegalArgumentException("Locale part \"" + str + "\" contains invalid characters");
                }
            }
        }
    }

    @Deprecated
    public static boolean containsWhitespace(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) ? containsWhitespace((CharSequence) str) : invokeL.booleanValue;
    }

    @Deprecated
    public static String[] delimitedListToStringArray(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65562, null, str, str2, str3)) == null) {
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
        return (String[]) invokeLLL.objValue;
    }

    @Deprecated
    public static boolean hasLength(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65569, null, str)) == null) ? hasLength((CharSequence) str) : invokeL.booleanValue;
    }

    @Deprecated
    public static boolean hasText(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65573, null, str)) == null) ? hasText((CharSequence) str) : invokeL.booleanValue;
    }

    @Deprecated
    public static Properties splitArrayElementsIntoProperties(String[] strArr, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65604, null, strArr, str, str2)) == null) {
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
        return (Properties) invokeLLL.objValue;
    }

    @Deprecated
    public static String[] toStringArray(Enumeration<String> enumeration) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65610, null, enumeration)) == null) {
            if (enumeration == null) {
                return null;
            }
            ArrayList list = Collections.list(enumeration);
            return (String[]) list.toArray(new String[list.size()]);
        }
        return (String[]) invokeL.objValue;
    }

    @Deprecated
    public static String[] tokenizeToStringArray(String str, String str2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65612, null, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
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
        return (String[]) invokeCommon.objValue;
    }

    @Deprecated
    public static String unqualify(String str, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65622, null, new Object[]{str, Character.valueOf(c2)})) == null) ? str.substring(str.lastIndexOf(c2) + 1) : (String) invokeCommon.objValue;
    }

    @Deprecated
    public static String collectionToDelimitedString(Collection<?> collection, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, collection, str)) == null) ? collectionToDelimitedString(collection, str, "", "") : (String) invokeLL.objValue;
    }

    public static String nullSafeToString(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, objArr)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static String nullSafeToString(boolean[] zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65593, null, zArr)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static String nullSafeToString(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, bArr)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static String nullSafeToString(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, cArr)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static String nullSafeToString(double[] dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65587, null, dArr)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static String nullSafeToString(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, fArr)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static String nullSafeToString(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, iArr)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static String nullSafeToString(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65590, null, jArr)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static String nullSafeToString(short[] sArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, null, sArr)) == null) {
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
        return (String) invokeL.objValue;
    }
}
