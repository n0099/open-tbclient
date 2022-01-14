package c.a.c0.v.v0;

import androidx.core.view.InputDeviceCompat;
import c.a.c0.m.e;
import c.a.c0.v.w.a;
import com.baidu.nadcore.player.helper.NetUtils;
import com.baidu.nadcore.video.plugin.videoplayer.model.ClarityUrlList;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Pair;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
@JvmName(name = "VideoClarity")
/* loaded from: classes.dex */
public final class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final Pair<Integer, Integer> a(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65536, null, i2, i3, i4)) == null) {
            if (i2 <= 0) {
                return new Pair<>(0, Integer.valueOf(i3));
            }
            if (i2 >= i4) {
                return new Pair<>(Integer.valueOf(i4 - 1), Integer.valueOf(i3));
            }
            return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3));
        }
        return (Pair) invokeIII.objValue;
    }

    public static final Pair<Integer, Integer> b(int i2, Pair<Integer, Integer> pair, int i3, int i4, double d2, ClarityUrlList clarityUrlList, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), pair, Integer.valueOf(i3), Integer.valueOf(i4), Double.valueOf(d2), clarityUrlList, Integer.valueOf(i5)})) == null) {
            if (i2 < 0) {
                return c(pair, i3, i4, d2);
            }
            return e(clarityUrlList.size(), i2, i5, i3);
        }
        return (Pair) invokeCommon.objValue;
    }

    public static final Pair<Integer, Integer> c(Pair<Integer, Integer> defaultClarity, int i2, int i3, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{defaultClarity, Integer.valueOf(i2), Integer.valueOf(i3), Double.valueOf(d2)})) == null) {
            Intrinsics.checkNotNullParameter(defaultClarity, "defaultClarity");
            if (!NetUtils.c()) {
                return a(defaultClarity.getFirst().intValue(), 2, i2);
            }
            return d(i3, i2, d2, defaultClarity.getSecond().intValue());
        }
        return (Pair) invokeCommon.objValue;
    }

    public static final Pair<Integer, Integer> d(int i2, int i3, double d2, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Double.valueOf(d2), Integer.valueOf(i4)})) == null) {
            if (!c.a.c0.v.w.b.g()) {
                return a(i4, 4, i3);
            }
            c.a.c0.m.e a = e.a.a();
            Intrinsics.checkNotNullExpressionValue(a, "IPlayerSpeedScoreManager.Impl.getInstance()");
            float staticDeviceScore = a.getStaticDeviceScore();
            boolean z = false;
            if (staticDeviceScore > 0 && staticDeviceScore < 0.3d) {
                z = true;
            }
            if (z) {
                return a(i2, 3, i3);
            }
            if (d2 > 5.6f) {
                return a(i2, 6, i3);
            }
            return a(i4, 4, i3);
        }
        return (Pair) invokeCommon.objValue;
    }

    public static final Pair<Integer, Integer> e(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3, i4, i5)) == null) {
            if (i2 <= i3) {
                return a(i4, 4, i5);
            }
            return a((i5 - i3) - 1, 1, i5);
        }
        return (Pair) invokeIIII.objValue;
    }

    public static final int f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i2)) == null) ? (i2 == -2 && Intrinsics.areEqual(c.a.c0.v.w.b.c(), a.C0101a.a)) ? p.f() : i2 : invokeI.intValue;
    }

    public static final c.a.c0.v.m0.c g(ClarityUrlList list, int i2, double d2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{list, Integer.valueOf(i2), Double.valueOf(d2), Boolean.valueOf(z)})) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            Pair<Integer, Integer> a = c.a.c0.v.w.b.a(list);
            int size = list.size();
            Pair<Integer, Integer> h2 = h(z, list, b(i2, a, size, size - 1, d2, list, 0));
            c.a.c0.v.m0.c cVar = new c.a.c0.v.m0.c();
            cVar.a = h2.getFirst().intValue();
            cVar.f2466b = h2.getSecond().intValue();
            return cVar;
        }
        return (c.a.c0.v.m0.c) invokeCommon.objValue;
    }

    public static final Pair<Integer, Integer> h(boolean z, ClarityUrlList list, Pair<Integer, Integer> selectedClarity) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), list, selectedClarity})) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(selectedClarity, "selectedClarity");
            if (z) {
                return selectedClarity;
            }
            ClarityUrlList.c cVar = list.get(selectedClarity.getFirst().intValue());
            Intrinsics.checkNotNullExpressionValue(cVar, "list[result.first]");
            String selectKey = cVar.c();
            String d2 = c.a.c0.v.w.b.d();
            Intrinsics.checkNotNullExpressionValue(selectKey, "selectKey");
            if (StringsKt__StringsKt.contains$default((CharSequence) d2, (CharSequence) selectKey, false, 2, (Object) null)) {
                int i2 = 0;
                for (ClarityUrlList.c entity : list) {
                    String d3 = c.a.c0.v.w.b.d();
                    Intrinsics.checkNotNullExpressionValue(entity, "entity");
                    String c2 = entity.c();
                    Intrinsics.checkNotNullExpressionValue(c2, "entity.key");
                    if (!StringsKt__StringsKt.contains$default((CharSequence) d3, (CharSequence) c2, false, 2, (Object) null)) {
                        return new Pair<>(Integer.valueOf(i2), 0);
                    }
                    i2++;
                }
                return selectedClarity;
            }
            return selectedClarity;
        }
        return (Pair) invokeCommon.objValue;
    }
}
