package c.i.b.a.e0.p;

import android.text.SpannableStringBuilder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f29999b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f30000c;

    /* renamed from: d  reason: collision with root package name */
    public final long f30001d;

    /* renamed from: e  reason: collision with root package name */
    public final long f30002e;

    /* renamed from: f  reason: collision with root package name */
    public final e f30003f;

    /* renamed from: g  reason: collision with root package name */
    public final String f30004g;

    /* renamed from: h  reason: collision with root package name */
    public final String[] f30005h;

    /* renamed from: i  reason: collision with root package name */
    public final HashMap<String, Integer> f30006i;

    /* renamed from: j  reason: collision with root package name */
    public final HashMap<String, Integer> f30007j;

    /* renamed from: k  reason: collision with root package name */
    public List<b> f30008k;

    public b(String str, String str2, long j2, long j3, e eVar, String[] strArr, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Long.valueOf(j2), Long.valueOf(j3), eVar, strArr, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f29999b = str2;
        this.f30003f = eVar;
        this.f30005h = strArr;
        this.f30000c = str2 != null;
        this.f30001d = j2;
        this.f30002e = j3;
        c.i.b.a.i0.a.e(str3);
        this.f30004g = str3;
        this.f30006i = new HashMap<>();
        this.f30007j = new HashMap<>();
    }

    public static b c(String str, long j2, long j3, e eVar, String[] strArr, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3), eVar, strArr, str2})) == null) ? new b(str, null, j2, j3, eVar, strArr, str2) : (b) invokeCommon.objValue;
    }

    public static b d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? new b(null, d.b(str), -9223372036854775807L, -9223372036854775807L, null, null, "") : (b) invokeL.objValue;
    }

    public static SpannableStringBuilder k(String str, Map<String, SpannableStringBuilder> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, map)) == null) {
            if (!map.containsKey(str)) {
                map.put(str, new SpannableStringBuilder());
            }
            return map.get(str);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            if (this.f30008k == null) {
                this.f30008k = new ArrayList();
            }
            this.f30008k.add(bVar);
        }
    }

    public final void b(Map<String, e> map, SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
        e d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, spannableStringBuilder, i2, i3) == null) || i2 == i3 || (d2 = d.d(this.f30003f, this.f30005h, map)) == null) {
            return;
        }
        d.a(spannableStringBuilder, i2, i3, d2);
    }

    public final SpannableStringBuilder e(SpannableStringBuilder spannableStringBuilder) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, spannableStringBuilder)) == null) {
            int length = spannableStringBuilder.length();
            int i4 = 0;
            for (int i5 = 0; i5 < length; i5++) {
                if (spannableStringBuilder.charAt(i5) == ' ') {
                    int i6 = i5 + 1;
                    int i7 = i6;
                    while (i7 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i7) == ' ') {
                        i7++;
                    }
                    int i8 = i7 - i6;
                    if (i8 > 0) {
                        spannableStringBuilder.delete(i5, i5 + i8);
                        length -= i8;
                    }
                }
            }
            if (length > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
                length--;
            }
            int i9 = 0;
            while (true) {
                i2 = length - 1;
                if (i9 >= i2) {
                    break;
                }
                if (spannableStringBuilder.charAt(i9) == '\n') {
                    int i10 = i9 + 1;
                    if (spannableStringBuilder.charAt(i10) == ' ') {
                        spannableStringBuilder.delete(i10, i9 + 2);
                        length--;
                    }
                }
                i9++;
            }
            if (length > 0 && spannableStringBuilder.charAt(i2) == ' ') {
                spannableStringBuilder.delete(i2, length);
                length--;
            }
            while (true) {
                i3 = length - 1;
                if (i4 >= i3) {
                    break;
                }
                if (spannableStringBuilder.charAt(i4) == ' ') {
                    int i11 = i4 + 1;
                    if (spannableStringBuilder.charAt(i11) == '\n') {
                        spannableStringBuilder.delete(i4, i11);
                        length--;
                    }
                }
                i4++;
            }
            if (length > 0 && spannableStringBuilder.charAt(i3) == '\n') {
                spannableStringBuilder.delete(i3, length);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public b f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            List<b> list = this.f30008k;
            if (list != null) {
                return list.get(i2);
            }
            throw new IndexOutOfBoundsException();
        }
        return (b) invokeI.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<b> list = this.f30008k;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public List<c.i.b.a.e0.b> h(long j2, Map<String, e> map, Map<String, c> map2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j2), map, map2})) == null) {
            TreeMap treeMap = new TreeMap();
            n(j2, false, this.f30004g, treeMap);
            m(map, treeMap);
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : treeMap.entrySet()) {
                c cVar = map2.get(entry.getKey());
                SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) entry.getValue();
                e(spannableStringBuilder);
                arrayList.add(new c.i.b.a.e0.b(spannableStringBuilder, null, cVar.f30010c, cVar.f30011d, cVar.f30012e, cVar.f30009b, Integer.MIN_VALUE, cVar.f30013f));
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public final void i(TreeSet<Long> treeSet, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, treeSet, z) == null) {
            boolean equals = "p".equals(this.a);
            if (z || equals) {
                long j2 = this.f30001d;
                if (j2 != -9223372036854775807L) {
                    treeSet.add(Long.valueOf(j2));
                }
                long j3 = this.f30002e;
                if (j3 != -9223372036854775807L) {
                    treeSet.add(Long.valueOf(j3));
                }
            }
            if (this.f30008k == null) {
                return;
            }
            for (int i2 = 0; i2 < this.f30008k.size(); i2++) {
                this.f30008k.get(i2).i(treeSet, z || equals);
            }
        }
    }

    public long[] j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            TreeSet<Long> treeSet = new TreeSet<>();
            int i2 = 0;
            i(treeSet, false);
            long[] jArr = new long[treeSet.size()];
            Iterator<Long> it = treeSet.iterator();
            while (it.hasNext()) {
                jArr[i2] = it.next().longValue();
                i2++;
            }
            return jArr;
        }
        return (long[]) invokeV.objValue;
    }

    public boolean l(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) ? (this.f30001d == -9223372036854775807L && this.f30002e == -9223372036854775807L) || (this.f30001d <= j2 && this.f30002e == -9223372036854775807L) || ((this.f30001d == -9223372036854775807L && j2 < this.f30002e) || (this.f30001d <= j2 && j2 < this.f30002e)) : invokeJ.booleanValue;
    }

    public final void m(Map<String, e> map, Map<String, SpannableStringBuilder> map2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, map, map2) == null) {
            for (Map.Entry<String, Integer> entry : this.f30007j.entrySet()) {
                String key = entry.getKey();
                b(map, map2.get(key), this.f30006i.containsKey(key) ? this.f30006i.get(key).intValue() : 0, entry.getValue().intValue());
                for (int i2 = 0; i2 < g(); i2++) {
                    f(i2).m(map, map2);
                }
            }
        }
    }

    public final void n(long j2, boolean z, String str, Map<String, SpannableStringBuilder> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), str, map}) == null) {
            this.f30006i.clear();
            this.f30007j.clear();
            String str2 = this.f30004g;
            if (!"".equals(str2)) {
                str = str2;
            }
            if (this.f30000c && z) {
                k(str, map).append((CharSequence) this.f29999b);
            } else if ("br".equals(this.a) && z) {
                k(str, map).append('\n');
            } else if (!"metadata".equals(this.a) && l(j2)) {
                boolean equals = "p".equals(this.a);
                for (Map.Entry<String, SpannableStringBuilder> entry : map.entrySet()) {
                    this.f30006i.put(entry.getKey(), Integer.valueOf(entry.getValue().length()));
                }
                for (int i2 = 0; i2 < g(); i2++) {
                    f(i2).n(j2, z || equals, str, map);
                }
                if (equals) {
                    d.c(k(str, map));
                }
                for (Map.Entry<String, SpannableStringBuilder> entry2 : map.entrySet()) {
                    this.f30007j.put(entry2.getKey(), Integer.valueOf(entry2.getValue().length()));
                }
            }
        }
    }
}
