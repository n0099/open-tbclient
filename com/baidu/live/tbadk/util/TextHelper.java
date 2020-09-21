package com.baidu.live.tbadk.util;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
/* loaded from: classes4.dex */
public class TextHelper {
    public static int getTextLength(EditText editText) {
        if (editText == null) {
            return 0;
        }
        return getTextLength(editText.getText());
    }

    public static int getTextLength(Editable editable) {
        if (editable == null) {
            return 0;
        }
        return getTextLength(editable.toString());
    }

    public static int getCharLength(char c) {
        if (isCharacter(c)) {
            return 1;
        }
        return 2;
    }

    public static boolean isCharacter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || ((c >= '0' && c <= '9') || c == ' ');
    }

    public static int getTextLength(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (isCharacter(str.charAt(i2))) {
                i++;
            } else {
                i += 2;
            }
        }
        return i;
    }

    public static int getTextLengthWithEmoji(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int codePointCount = str.codePointCount(0, str.length());
        int i = 0;
        for (int i2 = 1; i2 <= codePointCount; i2++) {
            String substring = str.substring(str.offsetByCodePoints(0, i2 - 1), str.offsetByCodePoints(0, i2));
            if (substring.length() >= 2) {
                i += 2;
            } else {
                i += getTextLength(substring);
            }
        }
        return i;
    }

    public static int getTextLengthAllOne(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int codePointCount = str.codePointCount(0, str.length());
        int i = 0;
        for (int i2 = 1; i2 <= codePointCount; i2++) {
            if (str.substring(str.offsetByCodePoints(0, i2 - 1), str.offsetByCodePoints(0, i2)).length() >= 2) {
            }
            i++;
        }
        return i;
    }

    public static String subStringWithAllOne(String str, int i) {
        int codePointCount = str.codePointCount(0, str.length());
        int i2 = 1;
        String str2 = str;
        while (i2 <= codePointCount) {
            String substring = str.substring(0, str.offsetByCodePoints(0, i2));
            if (getTextLengthAllOne(substring) > i) {
                break;
            }
            i2++;
            str2 = substring;
        }
        return str2;
    }

    public static int getTrimmedTextLength(EditText editText) {
        Editable text;
        if (editText == null || (text = editText.getText()) == null) {
            return 0;
        }
        String obj = text.toString();
        if (TextUtils.isEmpty(obj)) {
            return 0;
        }
        String trim = obj.trim();
        if (TextUtils.isEmpty(trim)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < trim.length(); i2++) {
            if (isCharacter(trim.charAt(i2))) {
                i++;
            } else {
                i += 2;
            }
        }
        return i;
    }

    public static boolean checkText(EditText editText) {
        String obj = editText.getText().toString();
        int length = obj.length();
        String trim = obj.trim();
        int length2 = trim.length();
        if (length2 < length) {
            editText.setText(trim);
            editText.setSelection(length2);
            return false;
        }
        return true;
    }

    public static String getFormatString(int i) {
        if (i >= 100000000) {
            return (i / 100000000) + "亿+";
        }
        if (i >= 10000) {
            return (i / 10000) + "万+";
        }
        return "" + i;
    }

    public static String interceptString(String str, int i) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (getTextLength(str) > i) {
            return subString(str, 0, i - 2) + StringHelper.STRING_MORE;
        }
        return str;
    }

    public static String interceptStringWithNoEndSign(String str, int i) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (getTextLength(str) > i) {
            return subString(str, 0, i);
        }
        return str;
    }

    public static String subString(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str) || i > i2) {
            return sb.toString();
        }
        if (i >= 0 && i2 >= 0) {
            int i3 = 0;
            for (int i4 = 0; i4 < str.length(); i4++) {
                char charAt = str.charAt(i4);
                if (i3 >= i2) {
                    if (i3 == i2) {
                        return sb.toString();
                    }
                    return sb.deleteCharAt(sb.length() - 1).toString();
                }
                if (i3 >= i) {
                    sb.append(charAt);
                }
                if (isCharacter(charAt)) {
                    i3++;
                } else {
                    i3 += 2;
                }
            }
        }
        return sb.toString();
    }

    public static boolean EndwithChar(String str, int i, int i2) {
        if (TextUtils.isEmpty(str) || i > i2 || i < 0 || i2 < 0) {
            return false;
        }
        int i3 = 0;
        boolean z = false;
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if (i3 >= i2) {
                return z;
            }
            if (isCharacter(charAt)) {
                i3++;
                z = true;
            } else {
                i3 += 2;
                z = false;
            }
        }
        return false;
    }

    public static boolean isCharacterExceptCapital(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == ' ';
    }

    public static String subString(String str, int i) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            return sb.toString();
        }
        if (i > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < str.length(); i3++) {
                char charAt = str.charAt(i3);
                if (i2 >= i) {
                    if (i2 == i) {
                        return sb.toString();
                    }
                    return sb.deleteCharAt(sb.length() - 1).toString();
                }
                if (i2 >= 0) {
                    sb.append(charAt);
                }
                if (isCharacterExceptCapital(charAt)) {
                    i2++;
                } else {
                    i2 += 2;
                }
            }
        }
        return sb.toString();
    }

    public static String subStringWithEmoji(String str, int i) {
        int codePointCount = str.codePointCount(0, str.length());
        int i2 = 1;
        String str2 = str;
        while (i2 <= codePointCount) {
            String substring = str.substring(0, str.offsetByCodePoints(0, i2));
            if (getTextLengthWithEmoji(substring) > i) {
                break;
            }
            i2++;
            str2 = substring;
        }
        return str2;
    }
}
