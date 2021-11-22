package b.h.b.a.e0.p;

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
/* loaded from: classes6.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f33240a;

    /* renamed from: b  reason: collision with root package name */
    public final String f33241b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f33242c;

    /* renamed from: d  reason: collision with root package name */
    public final long f33243d;

    /* renamed from: e  reason: collision with root package name */
    public final long f33244e;

    /* renamed from: f  reason: collision with root package name */
    public final e f33245f;

    /* renamed from: g  reason: collision with root package name */
    public final String f33246g;

    /* renamed from: h  reason: collision with root package name */
    public final String[] f33247h;

    /* renamed from: i  reason: collision with root package name */
    public final HashMap<String, Integer> f33248i;
    public final HashMap<String, Integer> j;
    public List<b> k;

    public b(String str, String str2, long j, long j2, e eVar, String[] strArr, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Long.valueOf(j), Long.valueOf(j2), eVar, strArr, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33240a = str;
        this.f33241b = str2;
        this.f33245f = eVar;
        this.f33247h = strArr;
        this.f33242c = str2 != null;
        this.f33243d = j;
        this.f33244e = j2;
        b.h.b.a.i0.a.e(str3);
        this.f33246g = str3;
        this.f33248i = new HashMap<>();
        this.j = new HashMap<>();
    }

    public static b c(String str, long j, long j2, e eVar, String[] strArr, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), eVar, strArr, str2})) == null) ? new b(str, null, j, j2, eVar, strArr, str2) : (b) invokeCommon.objValue;
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
            if (this.k == null) {
                this.k = new ArrayList();
            }
            this.k.add(bVar);
        }
    }

    public final void b(Map<String, e> map, SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
        e d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, spannableStringBuilder, i2, i3) == null) || i2 == i3 || (d2 = d.d(this.f33245f, this.f33247h, map)) == null) {
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
            List<b> list = this.k;
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
            List<b> list = this.k;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public List<b.h.b.a.e0.b> h(long j, Map<String, e> map, Map<String, c> map2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), map, map2})) == null) {
            TreeMap treeMap = new TreeMap();
            n(j, false, this.f33246g, treeMap);
            m(map, treeMap);
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : treeMap.entrySet()) {
                c cVar = map2.get(entry.getKey());
                SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) entry.getValue();
                e(spannableStringBuilder);
                arrayList.add(new b.h.b.a.e0.b(spannableStringBuilder, null, cVar.f33251c, cVar.f33252d, cVar.f33253e, cVar.f33250b, Integer.MIN_VALUE, cVar.f33254f));
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public final void i(TreeSet<Long> treeSet, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, treeSet, z) == null) {
            boolean equals = "p".equals(this.f33240a);
            if (z || equals) {
                long j = this.f33243d;
                if (j != -9223372036854775807L) {
                    treeSet.add(Long.valueOf(j));
                }
                long j2 = this.f33244e;
                if (j2 != -9223372036854775807L) {
                    treeSet.add(Long.valueOf(j2));
                }
            }
            if (this.k == null) {
                return;
            }
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                this.k.get(i2).i(treeSet, z || equals);
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

    public boolean l(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) ? (this.f33243d == -9223372036854775807L && this.f33244e == -9223372036854775807L) || (this.f33243d <= j && this.f33244e == -9223372036854775807L) || ((this.f33243d == -9223372036854775807L && j < this.f33244e) || (this.f33243d <= j && j < this.f33244e)) : invokeJ.booleanValue;
    }

    public final void m(Map<String, e> map, Map<String, SpannableStringBuilder> map2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, map, map2) == null) {
            for (Map.Entry<String, Integer> entry : this.j.entrySet()) {
                String key = entry.getKey();
                b(map, map2.get(key), this.f33248i.containsKey(key) ? this.f33248i.get(key).intValue() : 0, entry.getValue().intValue());
                for (int i2 = 0; i2 < g(); i2++) {
                    f(i2).m(map, map2);
                }
            }
        }
    }

    public final void n(long j, boolean z, String str, Map<String, SpannableStringBuilder> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), str, map}) == null) {
            this.f33248i.clear();
            this.j.clear();
            String str2 = this.f33246g;
            if (!"".equals(str2)) {
                str = str2;
            }
            if (this.f33242c && z) {
                k(str, map).append((CharSequence) this.f33241b);
            } else if ("br".equals(this.f33240a) && z) {
                k(str, map).append('\n');
            } else if (!"metadata".equals(this.f33240a) && l(j)) {
                boolean equals = "p".equals(this.f33240a);
                for (Map.Entry<String, SpannableStringBuilder> entry : map.entrySet()) {
                    this.f33248i.put(entry.getKey(), Integer.valueOf(entry.getValue().length()));
                }
                for (int i2 = 0; i2 < g(); i2++) {
                    f(i2).n(j, z || equals, str, map);
                }
                if (equals) {
                    d.c(k(str, map));
                }
                for (Map.Entry<String, SpannableStringBuilder> entry2 : map.entrySet()) {
                    this.j.put(entry2.getKey(), Integer.valueOf(entry2.getValue().length()));
                }
            }
        }
    }
}
