package androidx.customview.widget;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
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
        V get(T t, int i);

        int size(T t);
    }

    public static int getWeightedDistanceFor(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65543, null, i, i2)) == null) ? (i * 13 * i) + (i2 * i2) : invokeII.intValue;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                int i = rect.top;
                int i2 = rect2.top;
                if (i < i2) {
                    return -1;
                }
                if (i > i2) {
                    return 1;
                }
                int i3 = rect.left;
                int i4 = rect2.left;
                if (i3 < i4) {
                    if (!this.mIsLayoutRtl) {
                        return -1;
                    }
                    return 1;
                } else if (i3 > i4) {
                    if (this.mIsLayoutRtl) {
                        return -1;
                    }
                    return 1;
                } else {
                    int i5 = rect.bottom;
                    int i6 = rect2.bottom;
                    if (i5 < i6) {
                        return -1;
                    }
                    if (i5 > i6) {
                        return 1;
                    }
                    int i7 = rect.right;
                    int i8 = rect2.right;
                    if (i7 < i8) {
                        if (!this.mIsLayoutRtl) {
                            return -1;
                        }
                        return 1;
                    } else if (i7 > i8) {
                        if (this.mIsLayoutRtl) {
                            return -1;
                        }
                        return 1;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean beamBeats(int i, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), rect, rect2, rect3})) == null) {
            boolean beamsOverlap = beamsOverlap(i, rect, rect2);
            if (beamsOverlap(i, rect, rect3) || !beamsOverlap) {
                return false;
            }
            if (isToDirectionOf(i, rect, rect3) && i != 17 && i != 66 && majorAxisDistance(i, rect, rect2) >= majorAxisDistanceToFarEdge(i, rect, rect3)) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isBetterCandidate(int i, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i), rect, rect2, rect3})) == null) {
            if (!isCandidate(rect, rect2, i)) {
                return false;
            }
            if (!isCandidate(rect, rect3, i) || beamBeats(i, rect, rect2, rect3)) {
                return true;
            }
            if (beamBeats(i, rect, rect3, rect2) || getWeightedDistanceFor(majorAxisDistance(i, rect, rect2), minorAxisDistance(i, rect, rect2)) >= getWeightedDistanceFor(majorAxisDistance(i, rect, rect3), minorAxisDistance(i, rect, rect3))) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean beamsOverlap(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65538, null, i, rect, rect2)) == null) {
            if (i != 17) {
                if (i != 33) {
                    if (i != 66) {
                        if (i != 130) {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                    }
                }
                if (rect2.right >= rect.left && rect2.left <= rect.right) {
                    return true;
                }
                return false;
            }
            if (rect2.bottom >= rect.top && rect2.top <= rect.bottom) {
                return true;
            }
            return false;
        }
        return invokeILL.booleanValue;
    }

    public static boolean isToDirectionOf(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65546, null, i, rect, rect2)) == null) {
            if (i != 17) {
                if (i != 33) {
                    if (i != 66) {
                        if (i == 130) {
                            if (rect.bottom <= rect2.top) {
                                return true;
                            }
                            return false;
                        }
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    } else if (rect.right <= rect2.left) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (rect.top >= rect2.bottom) {
                    return true;
                } else {
                    return false;
                }
            } else if (rect.left >= rect2.right) {
                return true;
            } else {
                return false;
            }
        }
        return invokeILL.booleanValue;
    }

    public static int minorAxisDistance(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65551, null, i, rect, rect2)) == null) {
            if (i != 17) {
                if (i != 33) {
                    if (i != 66) {
                        if (i != 130) {
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

    public static <L, T> T findNextFocusInAbsoluteDirection(@NonNull L l, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, @Nullable T t, @NonNull Rect rect, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{l, collectionAdapter, boundsAdapter, t, rect, Integer.valueOf(i)})) == null) {
            Rect rect2 = new Rect(rect);
            if (i != 17) {
                if (i != 33) {
                    if (i != 66) {
                        if (i == 130) {
                            rect2.offset(0, -(rect.height() + 1));
                        } else {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                    } else {
                        rect2.offset(-(rect.width() + 1), 0);
                    }
                } else {
                    rect2.offset(0, rect.height() + 1);
                }
            } else {
                rect2.offset(rect.width() + 1, 0);
            }
            T t2 = null;
            int size = collectionAdapter.size(l);
            Rect rect3 = new Rect();
            for (int i2 = 0; i2 < size; i2++) {
                T t3 = collectionAdapter.get(l, i2);
                if (t3 != t) {
                    boundsAdapter.obtainBounds(t3, rect3);
                    if (isBetterCandidate(i, rect, rect3, rect2)) {
                        rect2.set(rect3);
                        t2 = t3;
                    }
                }
            }
            return t2;
        }
        return (T) invokeCommon.objValue;
    }

    public static <L, T> T findNextFocusInRelativeDirection(@NonNull L l, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, @Nullable T t, int i, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{l, collectionAdapter, boundsAdapter, t, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int size = collectionAdapter.size(l);
            ArrayList arrayList = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(collectionAdapter.get(l, i2));
            }
            Collections.sort(arrayList, new SequentialComparator(z, boundsAdapter));
            if (i != 1) {
                if (i == 2) {
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
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, t, arrayList, z)) == null) {
            int size = arrayList.size();
            if (t == null) {
                lastIndexOf = -1;
            } else {
                lastIndexOf = arrayList.lastIndexOf(t);
            }
            int i = lastIndexOf + 1;
            if (i < size) {
                return arrayList.get(i);
            }
            if (z && size > 0) {
                return arrayList.get(0);
            }
            return null;
        }
        return (T) invokeLLZ.objValue;
    }

    public static <T> T getPreviousFocusable(T t, ArrayList<T> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65542, null, t, arrayList, z)) == null) {
            int size = arrayList.size();
            if (t == null) {
                indexOf = size;
            } else {
                indexOf = arrayList.indexOf(t);
            }
            int i = indexOf - 1;
            if (i >= 0) {
                return arrayList.get(i);
            }
            if (z && size > 0) {
                return arrayList.get(size - 1);
            }
            return null;
        }
        return (T) invokeLLZ.objValue;
    }

    public static int majorAxisDistanceRaw(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        InterceptResult invokeILL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65548, null, i, rect, rect2)) == null) {
            if (i != 17) {
                if (i != 33) {
                    if (i != 66) {
                        if (i == 130) {
                            i2 = rect2.top;
                            i3 = rect.bottom;
                        } else {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                    } else {
                        i2 = rect2.left;
                        i3 = rect.right;
                    }
                } else {
                    i2 = rect.top;
                    i3 = rect2.bottom;
                }
            } else {
                i2 = rect.left;
                i3 = rect2.right;
            }
            return i2 - i3;
        }
        return invokeILL.intValue;
    }

    public static int majorAxisDistanceToFarEdgeRaw(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        InterceptResult invokeILL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65550, null, i, rect, rect2)) == null) {
            if (i != 17) {
                if (i != 33) {
                    if (i != 66) {
                        if (i == 130) {
                            i2 = rect2.bottom;
                            i3 = rect.bottom;
                        } else {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                    } else {
                        i2 = rect2.right;
                        i3 = rect.right;
                    }
                } else {
                    i2 = rect.top;
                    i3 = rect2.top;
                }
            } else {
                i2 = rect.left;
                i3 = rect2.left;
            }
            return i2 - i3;
        }
        return invokeILL.intValue;
    }

    public static boolean isCandidate(@NonNull Rect rect, @NonNull Rect rect2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65545, null, rect, rect2, i)) == null) {
            if (i != 17) {
                if (i != 33) {
                    if (i != 66) {
                        if (i == 130) {
                            int i2 = rect.top;
                            int i3 = rect2.top;
                            if ((i2 < i3 || rect.bottom <= i3) && rect.bottom < rect2.bottom) {
                                return true;
                            }
                            return false;
                        }
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                    int i4 = rect.left;
                    int i5 = rect2.left;
                    if ((i4 < i5 || rect.right <= i5) && rect.right < rect2.right) {
                        return true;
                    }
                    return false;
                }
                int i6 = rect.bottom;
                int i7 = rect2.bottom;
                if ((i6 > i7 || rect.top >= i7) && rect.top > rect2.top) {
                    return true;
                }
                return false;
            }
            int i8 = rect.right;
            int i9 = rect2.right;
            if ((i8 > i9 || rect.left >= i9) && rect.left > rect2.left) {
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static int majorAxisDistance(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65547, null, i, rect, rect2)) == null) {
            return Math.max(0, majorAxisDistanceRaw(i, rect, rect2));
        }
        return invokeILL.intValue;
    }

    public static int majorAxisDistanceToFarEdge(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65549, null, i, rect, rect2)) == null) {
            return Math.max(1, majorAxisDistanceToFarEdgeRaw(i, rect, rect2));
        }
        return invokeILL.intValue;
    }
}
