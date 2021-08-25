package c.a.o0.q.f;

import android.text.TextUtils;
import c.a.o0.q.d;
import com.baidu.android.ddmlib.tools.perflib.vmtrace.utils.Strings;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bumptech.glide.load.engine.GlideException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Map<String, Integer> a(Set<String> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, set)) == null) {
            HashMap hashMap = new HashMap();
            int i2 = 0;
            for (String str : set) {
                hashMap.put(str, Integer.valueOf(i2));
                i2++;
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static StringBuilder b(StringBuilder... sbArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sbArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (StringBuilder sb2 : sbArr) {
                sb.append((CharSequence) sb2);
            }
            return sb;
        }
        return (StringBuilder) invokeL.objValue;
    }

    public static String c(List<c.a.o0.q.a> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, list, str)) == null) {
            Set<String> d2 = d.b().d();
            int size = d2.size();
            Map<String, Integer> a2 = a(d2);
            StringBuilder[] sbArr = new StringBuilder[size];
            for (int i2 = 0; i2 < size; i2++) {
                sbArr[i2] = new StringBuilder();
            }
            for (c.a.o0.q.a aVar : list) {
                Integer num = a2.get(aVar.f());
                if (num != null) {
                    sbArr[num.intValue()].append(Strings.repeat(GlideException.IndentedAppendable.INDENT, aVar.d()));
                    sbArr[num.intValue()].append("- ");
                    StringBuilder sb = sbArr[num.intValue()];
                    sb.append(aVar.b() / 1000);
                    sb.append("ms");
                    sbArr[num.intValue()].append("   ");
                    sbArr[num.intValue()].append(aVar.f());
                    sbArr[num.intValue()].append("   ");
                    sbArr[num.intValue()].append(aVar.c().getFullName());
                    sbArr[num.intValue()].append(StringUtils.LF);
                }
            }
            String sb2 = b(sbArr).toString();
            d(sb2, str);
            return sb2;
        }
        return (String) invokeLL.objValue;
    }

    public static void d(String str, String str2) {
        FileWriter fileWriter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        FileWriter fileWriter2 = null;
        try {
            try {
                try {
                    File parentFile = new File(str2).getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    fileWriter = new FileWriter(str2);
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e4) {
            e = e4;
            fileWriter2 = fileWriter;
            e.printStackTrace();
            if (fileWriter2 != null) {
                fileWriter2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            if (fileWriter2 != null) {
                try {
                    fileWriter2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }
}
