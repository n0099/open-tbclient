package androidx.customview.widget;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes.dex */
public class FocusStrategy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface BoundsAdapter<T> {
        void obtainBounds(T t, Rect rect);
    }

    /* loaded from: classes.dex */
    public interface CollectionAdapter<T, V> {
        V get(T t, int i2);

        int size(T t);
    }

    /* loaded from: classes.dex */
    public static class SequentialComparator<T> implements Comparator<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BoundsAdapter<T> mAdapter;
        public final boolean mIsLayoutRtl;
        public final Rect mTemp1;
        public final Rect mTemp2;

        public SequentialComparator(boolean z, BoundsAdapter<T> boundsAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), boundsAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTemp1 = new Rect();
            this.mTemp2 = new Rect();
            this.mIsLayoutRtl = z;
            this.mAdapter = boundsAdapter;
        }

        @Override // java.util.Comparator
        public int compare(T t, T t2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, t, t2)) == null) {
                Rect rect = this.mTemp1;
                Rect rect2 = this.mTemp2;
                this.mAdapter.obtainBounds(t, rect);
                this.mAdapter.obtainBounds(t2, rect2);
                int i2 = rect.top;
                int i3 = rect2.top;
                if (i2 < i3) {
                    return -1;
                }
                if (i2 > i3) {
                    return 1;
                }
                int i4 = rect.left;
                int i5 = rect2.left;
                if (i4 < i5) {
                    return this.mIsLayoutRtl ? 1 : -1;
                } else if (i4 > i5) {
                    return this.mIsLayoutRtl ? -1 : 1;
                } else {
                    int i6 = rect.bottom;
                    int i7 = rect2.bottom;
                    if (i6 < i7) {
                        return -1;
                    }
                    if (i6 > i7) {
                        return 1;
                    }
                    int i8 = rect.right;
                    int i9 = rect2.right;
                    if (i8 < i9) {
                        return this.mIsLayoutRtl ? 1 : -1;
                    } else if (i8 > i9) {
                        return this.mIsLayoutRtl ? -1 : 1;
                    } else {
                        return 0;
                    }
                }
            }
            return invokeLL.intValue;
        }
    }

    public FocusStrategy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean beamBeats(int i2, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), rect, rect2, rect3})) == null) {
            boolean beamsOverlap = beamsOverlap(i2, rect, rect2);
            if (beamsOverlap(i2, rect, rect3) || !beamsOverlap) {
                return false;
            }
            return !isToDirectionOf(i2, rect, rect3) || i2 == 17 || i2 == 66 || majorAxisDistance(i2, rect, rect2) < majorAxisDistanceToFarEdge(i2, rect, rect3);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean beamsOverlap(int i2, @NonNull Rect rect, @NonNull Rect rect2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65538, null, i2, rect, rect2)) == null) {
            if (i2 != 17) {
                if (i2 != 33) {
                    if (i2 != 66) {
                        if (i2 != 130) {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                    }
                }
                return rect2.right >= rect.left && rect2.left <= rect.right;
            }
            return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
        }
        return invokeILL.booleanValue;
    }

    public static <L, T> T findNextFocusInAbsoluteDirection(@NonNull L l, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, @Nullable T t, @NonNull Rect rect, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{l, collectionAdapter, boundsAdapter, t, rect, Integer.valueOf(i2)})) == null) {
            Rect rect2 = new Rect(rect);
            if (i2 == 17) {
                rect2.offset(rect.width() + 1, 0);
            } else if (i2 == 33) {
                rect2.offset(0, rect.height() + 1);
            } else if (i2 == 66) {
                rect2.offset(-(rect.width() + 1), 0);
            } else if (i2 == 130) {
                rect2.offset(0, -(rect.height() + 1));
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            T t2 = null;
            int size = collectionAdapter.size(l);
            Rect rect3 = new Rect();
            for (int i3 = 0; i3 < size; i3++) {
                T t3 = collectionAdapter.get(l, i3);
                if (t3 != t) {
                    boundsAdapter.obtainBounds(t3, rect3);
                    if (isBetterCandidate(i2, rect, rect3, rect2)) {
                        rect2.set(rect3);
                        t2 = t3;
                    }
                }
            }
            return t2;
        }
        return (T) invokeCommon.objValue;
    }

    public static <L, T> T findNextFocusInRelativeDirection(@NonNull L l, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, @Nullable T t, int i2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{l, collectionAdapter, boundsAdapter, t, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int size = collectionAdapter.size(l);
            ArrayList arrayList = new ArrayList(size);
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(collectionAdapter.get(l, i3));
            }
            Collections.sort(arrayList, new SequentialComparator(z, boundsAdapter));
            if (i2 != 1) {
                if (i2 == 2) {
                    return (T) getNextFocusable(t, arrayList, z2);
                }
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
            }
            return (T) getPreviousFocusable(t, arrayList, z2);
        }
        return (T) invokeCommon.objValue;
    }

    public static <T> T getNextFocusable(T t, ArrayList<T> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(AdIconUtil.AD_TEXT_ID, null, t, arrayList, z)) == null) {
            int size = arrayList.size();
            int lastIndexOf = (t == null ? -1 : arrayList.lastIndexOf(t)) + 1;
            if (lastIndexOf < size) {
                return arrayList.get(lastIndexOf);
            }
            if (!z || size <= 0) {
                return null;
            }
            return arrayList.get(0);
        }
        return (T) invokeLLZ.objValue;
    }

    public static <T> T getPreviousFocusable(T t, ArrayList<T> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(AdIconUtil.BAIDU_LOGO_ID, null, t, arrayList, z)) == null) {
            int size = arrayList.size();
            int indexOf = (t == null ? size : arrayList.indexOf(t)) - 1;
            if (indexOf >= 0) {
                return arrayList.get(indexOf);
            }
            if (!z || size <= 0) {
                return null;
            }
            return arrayList.get(size - 1);
        }
        return (T) invokeLLZ.objValue;
    }

    public static int getWeightedDistanceFor(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65543, null, i2, i3)) == null) ? (i2 * 13 * i2) + (i3 * i3) : invokeII.intValue;
    }

    public static boolean isBetterCandidate(int i2, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i2), rect, rect2, rect3})) == null) {
            if (isCandidate(rect, rect2, i2)) {
                if (isCandidate(rect, rect3, i2) && !beamBeats(i2, rect, rect2, rect3)) {
                    return !beamBeats(i2, rect, rect3, rect2) && getWeightedDistanceFor(majorAxisDistance(i2, rect, rect2), minorAxisDistance(i2, rect, rect2)) < getWeightedDistanceFor(majorAxisDistance(i2, rect, rect3), minorAxisDistance(i2, rect, rect3));
                }
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isCandidate(@NonNull Rect rect, @NonNull Rect rect2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65545, null, rect, rect2, i2)) == null) {
            if (i2 == 17) {
                int i3 = rect.right;
                int i4 = rect2.right;
                return (i3 > i4 || rect.left >= i4) && rect.left > rect2.left;
            } else if (i2 == 33) {
                int i5 = rect.bottom;
                int i6 = rect2.bottom;
                return (i5 > i6 || rect.top >= i6) && rect.top > rect2.top;
            } else if (i2 == 66) {
                int i7 = rect.left;
                int i8 = rect2.left;
                return (i7 < i8 || rect.right <= i8) && rect.right < rect2.right;
            } else if (i2 == 130) {
                int i9 = rect.top;
                int i10 = rect2.top;
                return (i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom;
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
        }
        return invokeLLI.booleanValue;
    }

    public static boolean isToDirectionOf(int i2, @NonNull Rect rect, @NonNull Rect rect2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65546, null, i2, rect, rect2)) == null) {
            if (i2 == 17) {
                return rect.left >= rect2.right;
            } else if (i2 == 33) {
                return rect.top >= rect2.bottom;
            } else if (i2 == 66) {
                return rect.right <= rect2.left;
            } else if (i2 == 130) {
                return rect.bottom <= rect2.top;
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
        }
        return invokeILL.booleanValue;
    }

    public static int majorAxisDistance(int i2, @NonNull Rect rect, @NonNull Rect rect2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(65547, null, i2, rect, rect2)) == null) ? Math.max(0, majorAxisDistanceRaw(i2, rect, rect2)) : invokeILL.intValue;
    }

    public static int majorAxisDistanceRaw(int i2, @NonNull Rect rect, @NonNull Rect rect2) {
        InterceptResult invokeILL;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65548, null, i2, rect, rect2)) == null) {
            if (i2 == 17) {
                i3 = rect.left;
                i4 = rect2.right;
            } else if (i2 == 33) {
                i3 = rect.top;
                i4 = rect2.bottom;
            } else if (i2 == 66) {
                i3 = rect2.left;
                i4 = rect.right;
            } else if (i2 == 130) {
                i3 = rect2.top;
                i4 = rect.bottom;
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            return i3 - i4;
        }
        return invokeILL.intValue;
    }

    public static int majorAxisDistanceToFarEdge(int i2, @NonNull Rect rect, @NonNull Rect rect2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(65549, null, i2, rect, rect2)) == null) ? Math.max(1, majorAxisDistanceToFarEdgeRaw(i2, rect, rect2)) : invokeILL.intValue;
    }

    public static int majorAxisDistanceToFarEdgeRaw(int i2, @NonNull Rect rect, @NonNull Rect rect2) {
        InterceptResult invokeILL;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65550, null, i2, rect, rect2)) == null) {
            if (i2 == 17) {
                i3 = rect.left;
                i4 = rect2.left;
            } else if (i2 == 33) {
                i3 = rect.top;
                i4 = rect2.top;
            } else if (i2 == 66) {
                i3 = rect2.right;
                i4 = rect.right;
            } else if (i2 == 130) {
                i3 = rect2.bottom;
                i4 = rect.bottom;
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            return i3 - i4;
        }
        return invokeILL.intValue;
    }

    public static int minorAxisDistance(int i2, @NonNull Rect rect, @NonNull Rect rect2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65551, null, i2, rect, rect2)) == null) {
            if (i2 != 17) {
                if (i2 != 33) {
                    if (i2 != 66) {
                        if (i2 != 130) {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                    }
                }
                return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
            }
            return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
        }
        return invokeILL.intValue;
    }
}
