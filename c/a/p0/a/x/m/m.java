package c.a.p0.a.x.m;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009e, code lost:
        if (r10.equals("1") != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            char c2 = 0;
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            int hashCode = str.hashCode();
            switch (hashCode) {
                case 49:
                    break;
                case 50:
                    if (str.equals("2")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 51:
                    if (str.equals("3")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 52:
                    if (str.equals("4")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 53:
                    if (str.equals("5")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 54:
                    if (str.equals("6")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 55:
                    if (str.equals("7")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 56:
                    if (str.equals("8")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 57:
                    if (str.equals("9")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    switch (hashCode) {
                        case 1567:
                            if (str.equals("10")) {
                                c2 = '\t';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1568:
                            if (str.equals("11")) {
                                c2 = '\n';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1569:
                            if (str.equals("12")) {
                                c2 = 11;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
            }
            switch (c2) {
                case 0:
                    return 6;
                case 1:
                    return 5;
                case 2:
                    return 8;
                case 3:
                    return 9;
                case 4:
                    return 10;
                case 5:
                    return 11;
                case 6:
                    return 12;
                case 7:
                    return 13;
                case '\b':
                    return 14;
                case '\t':
                    return 15;
                case '\n':
                    return 11;
                case 11:
                    return 12;
                default:
                    return 7;
            }
        }
        return invokeL.intValue;
    }
}
