package c.a.n0.n;

import android.util.SparseArray;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<g> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(109997178, "Lc/a/n0/n/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(109997178, "Lc/a/n0/n/i;");
                return;
            }
        }
        SparseArray<g> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new g(5, R.string.obfuscated_res_0x7f0f00f1, R.drawable.obfuscated_res_0x7f0800f5, true));
        a.put(35, new g(35, R.string.obfuscated_res_0x7f0f00e4, R.drawable.obfuscated_res_0x7f0800d5, true));
        a.put(39, new g(39, R.string.obfuscated_res_0x7f0f00eb, R.drawable.obfuscated_res_0x7f0800f8, true));
        a.put(4, new g(4, R.string.obfuscated_res_0x7f0f00f2, R.drawable.obfuscated_res_0x7f0800fb, true));
        a.put(37, new g(37, R.string.obfuscated_res_0x7f0f00e6, R.drawable.obfuscated_res_0x7f0800d8, true));
        a.put(38, new g(38, R.string.obfuscated_res_0x7f0f00ef, R.drawable.obfuscated_res_0x7f0800d4, true));
        a.put(42, new g(42, R.string.obfuscated_res_0x7f0f00e7, R.drawable.obfuscated_res_0x7f0800f8, true));
        a.put(49, new g(49, R.string.obfuscated_res_0x7f0f121c, R.drawable.obfuscated_res_0x7f081119, true));
        a.put(50, new g(50, R.string.obfuscated_res_0x7f0f12a0, R.drawable.obfuscated_res_0x7f081118, true));
        a.put(43, new g(43, R.string.obfuscated_res_0x7f0f00e5, R.drawable.obfuscated_res_0x7f0800d9, true));
        a.put(9, new g(9, R.string.obfuscated_res_0x7f0f00f0, R.drawable.obfuscated_res_0x7f0800e5, true));
        a.put(46, new g(46, R.string.obfuscated_res_0x7f0f00e8, R.drawable.obfuscated_res_0x7f0800ea, true));
        a.put(47, new g(47, R.string.obfuscated_res_0x7f0f00e9, R.drawable.obfuscated_res_0x7f0800ed, true));
    }

    public static g a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? g.k(a.get(i)) : (g) invokeI.objValue;
    }

    public static List<g> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(g.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(g.k(a.get(38)));
                                arrayList.add(g.k(a.get(4)));
                                arrayList.add(g.k(a.get(39)));
                                arrayList.add(g.k(a.get(35)));
                                arrayList.add(g.k(a.get(5)));
                                arrayList.add(g.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(g.l(a.get(38), false));
                                arrayList.add(g.l(a.get(4), false));
                                arrayList.add(g.k(a.get(39)));
                                arrayList.add(g.l(a.get(35), false));
                                arrayList.add(g.k(a.get(5)));
                                arrayList.add(g.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(g.k(a.get(38)));
                                arrayList.add(g.k(a.get(4)));
                                arrayList.add(g.k(a.get(39)));
                                arrayList.add(g.k(a.get(35)));
                                arrayList.add(g.k(a.get(5)));
                                arrayList.add(g.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(g.k(a.get(43)));
                    }
                }
                arrayList.add(g.k(a.get(38)));
                arrayList.add(g.k(a.get(4)));
                arrayList.add(g.k(a.get(39)));
                arrayList.add(g.k(a.get(35)));
                arrayList.add(g.k(a.get(5)));
                arrayList.add(g.k(a.get(49)));
            } else {
                arrayList.add(g.k(a.get(38)));
                arrayList.add(g.k(a.get(5)));
                arrayList.add(g.k(a.get(4)));
                arrayList.add(g.k(a.get(35)));
                arrayList.add(g.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}
