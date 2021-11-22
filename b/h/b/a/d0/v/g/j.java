package b.h.b.a.d0.v.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes6.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String[] f33001a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f33002b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f33003c;

    /* renamed from: d  reason: collision with root package name */
    public final int f33004d;

    public j(String[] strArr, int[] iArr, String[] strArr2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strArr, iArr, strArr2, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33001a = strArr;
        this.f33002b = iArr;
        this.f33003c = strArr2;
        this.f33004d = i2;
    }

    public static j b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String[] strArr = new String[5];
            int[] iArr = new int[4];
            String[] strArr2 = new String[4];
            return new j(strArr, iArr, strArr2, c(str, strArr, iArr, strArr2));
        }
        return (j) invokeL.objValue;
    }

    public static int c(String str, String[] strArr, int[] iArr, String[] strArr2) {
        InterceptResult invokeLLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, str, strArr, iArr, strArr2)) == null) {
            strArr[0] = "";
            int i2 = 0;
            int i3 = 0;
            while (i2 < str.length()) {
                int indexOf = str.indexOf("$", i2);
                char c2 = 65535;
                if (indexOf == -1) {
                    strArr[i3] = strArr[i3] + str.substring(i2);
                    i2 = str.length();
                } else if (indexOf != i2) {
                    strArr[i3] = strArr[i3] + str.substring(i2, indexOf);
                    i2 = indexOf;
                } else if (str.startsWith("$$", i2)) {
                    strArr[i3] = strArr[i3] + "$";
                    i2 += 2;
                } else {
                    int i4 = i2 + 1;
                    int indexOf2 = str.indexOf("$", i4);
                    String substring = str.substring(i4, indexOf2);
                    if (substring.equals("RepresentationID")) {
                        iArr[i3] = 1;
                    } else {
                        int indexOf3 = substring.indexOf("%0");
                        if (indexOf3 != -1) {
                            str2 = substring.substring(indexOf3);
                            if (!str2.endsWith("d")) {
                                str2 = str2 + "d";
                            }
                            substring = substring.substring(0, indexOf3);
                        } else {
                            str2 = "%01d";
                        }
                        int hashCode = substring.hashCode();
                        if (hashCode != -1950496919) {
                            if (hashCode != 2606829) {
                                if (hashCode == 38199441 && substring.equals("Bandwidth")) {
                                    c2 = 1;
                                }
                            } else if (substring.equals("Time")) {
                                c2 = 2;
                            }
                        } else if (substring.equals("Number")) {
                            c2 = 0;
                        }
                        if (c2 == 0) {
                            iArr[i3] = 2;
                        } else if (c2 == 1) {
                            iArr[i3] = 3;
                        } else if (c2 == 2) {
                            iArr[i3] = 4;
                        } else {
                            throw new IllegalArgumentException("Invalid template: " + str);
                        }
                        strArr2[i3] = str2;
                    }
                    i3++;
                    strArr[i3] = "";
                    i2 = indexOf2 + 1;
                }
            }
            return i3;
        }
        return invokeLLLL.intValue;
    }

    public String a(String str, int i2, int i3, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)})) != null) {
            return (String) invokeCommon.objValue;
        }
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        while (true) {
            int i5 = this.f33004d;
            if (i4 < i5) {
                sb.append(this.f33001a[i4]);
                int[] iArr = this.f33002b;
                if (iArr[i4] == 1) {
                    sb.append(str);
                } else if (iArr[i4] == 2) {
                    sb.append(String.format(Locale.US, this.f33003c[i4], Integer.valueOf(i2)));
                } else if (iArr[i4] == 3) {
                    sb.append(String.format(Locale.US, this.f33003c[i4], Integer.valueOf(i3)));
                } else if (iArr[i4] == 4) {
                    sb.append(String.format(Locale.US, this.f33003c[i4], Long.valueOf(j)));
                }
                i4++;
            } else {
                sb.append(this.f33001a[i5]);
                return sb.toString();
            }
        }
    }
}
