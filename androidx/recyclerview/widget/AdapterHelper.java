package androidx.recyclerview.widget;

import androidx.core.util.Pools;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.OpReorderer;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class AdapterHelper implements OpReorderer.Callback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int POSITION_TYPE_INVISIBLE = 0;
    public static final int POSITION_TYPE_NEW_OR_LAID_OUT = 1;
    public static final String TAG = "AHT";
    public transient /* synthetic */ FieldHolder $fh;
    public final Callback mCallback;
    public final boolean mDisableRecycler;
    public int mExistingUpdateTypes;
    public Runnable mOnItemProcessedCallback;
    public final OpReorderer mOpReorderer;
    public final ArrayList<UpdateOp> mPendingUpdates;
    public final ArrayList<UpdateOp> mPostponedList;
    public Pools.Pool<UpdateOp> mUpdateOpPool;

    /* loaded from: classes.dex */
    public interface Callback {
        RecyclerView.ViewHolder findViewHolder(int i);

        void markViewHoldersUpdated(int i, int i2, Object obj);

        void offsetPositionsForAdd(int i, int i2);

        void offsetPositionsForMove(int i, int i2);

        void offsetPositionsForRemovingInvisible(int i, int i2);

        void offsetPositionsForRemovingLaidOutOrNewView(int i, int i2);

        void onDispatchFirstPass(UpdateOp updateOp);

        void onDispatchSecondPass(UpdateOp updateOp);
    }

    /* loaded from: classes.dex */
    public static class UpdateOp {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ADD = 1;
        public static final int MOVE = 8;
        public static final int POOL_SIZE = 30;
        public static final int REMOVE = 2;
        public static final int UPDATE = 4;
        public transient /* synthetic */ FieldHolder $fh;
        public int cmd;
        public int itemCount;
        public Object payload;
        public int positionStart;

        public UpdateOp(int i, int i2, int i3, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.cmd = i;
            this.positionStart = i2;
            this.itemCount = i3;
            this.payload = obj;
        }

        public String cmdToString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i = this.cmd;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 4) {
                            if (i != 8) {
                                return "??";
                            }
                            return "mv";
                        }
                        return MapBundleKey.OfflineMapKey.OFFLINE_UPDATE;
                    }
                    return u.B;
                }
                return "add";
            }
            return (String) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return (((this.cmd * 31) + this.positionStart) * 31) + this.itemCount;
            }
            return invokeV.intValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || UpdateOp.class != obj.getClass()) {
                    return false;
                }
                UpdateOp updateOp = (UpdateOp) obj;
                int i = this.cmd;
                if (i != updateOp.cmd) {
                    return false;
                }
                if (i == 8 && Math.abs(this.itemCount - this.positionStart) == 1 && this.itemCount == updateOp.positionStart && this.positionStart == updateOp.itemCount) {
                    return true;
                }
                if (this.itemCount != updateOp.itemCount || this.positionStart != updateOp.positionStart) {
                    return false;
                }
                Object obj2 = this.payload;
                if (obj2 != null) {
                    if (!obj2.equals(updateOp.payload)) {
                        return false;
                    }
                } else if (updateOp.payload != null) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return Integer.toHexString(System.identityHashCode(this)) + PreferencesUtil.LEFT_MOUNT + cmdToString() + ",s:" + this.positionStart + "c:" + this.itemCount + ",p:" + this.payload + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdapterHelper(Callback callback) {
        this(callback, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Callback) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public AdapterHelper(Callback callback, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callback, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUpdateOpPool = new Pools.SimplePool(30);
        this.mPendingUpdates = new ArrayList<>();
        this.mPostponedList = new ArrayList<>();
        this.mExistingUpdateTypes = 0;
        this.mCallback = callback;
        this.mDisableRecycler = z;
        this.mOpReorderer = new OpReorderer(this);
    }

    public int findPositionOffset(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i, i2)) == null) {
            int size = this.mPostponedList.size();
            while (i2 < size) {
                UpdateOp updateOp = this.mPostponedList.get(i2);
                int i3 = updateOp.cmd;
                if (i3 == 8) {
                    int i4 = updateOp.positionStart;
                    if (i4 == i) {
                        i = updateOp.itemCount;
                    } else {
                        if (i4 < i) {
                            i--;
                        }
                        if (updateOp.itemCount <= i) {
                            i++;
                        }
                    }
                } else {
                    int i5 = updateOp.positionStart;
                    if (i5 > i) {
                        continue;
                    } else if (i3 == 2) {
                        int i6 = updateOp.itemCount;
                        if (i < i5 + i6) {
                            return -1;
                        }
                        i -= i6;
                    } else if (i3 == 1) {
                        i += updateOp.itemCount;
                    }
                }
                i2++;
            }
            return i;
        }
        return invokeII.intValue;
    }

    private void applyAdd(UpdateOp updateOp) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, updateOp) == null) {
            postponeAndUpdateViewHolders(updateOp);
        }
    }

    private void applyMove(UpdateOp updateOp) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, updateOp) == null) {
            postponeAndUpdateViewHolders(updateOp);
        }
    }

    public AdapterHelper addUpdateOp(UpdateOp... updateOpArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, updateOpArr)) == null) {
            Collections.addAll(this.mPendingUpdates, updateOpArr);
            return this;
        }
        return (AdapterHelper) invokeL.objValue;
    }

    public int findPositionOffset(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return findPositionOffset(i, 0);
        }
        return invokeI.intValue;
    }

    public boolean hasAnyUpdateTypes(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if ((i & this.mExistingUpdateTypes) != 0) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public void recycleUpdateOp(UpdateOp updateOp) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, updateOp) == null) && !this.mDisableRecycler) {
            updateOp.payload = null;
            this.mUpdateOpPool.release(updateOp);
        }
    }

    public void recycleUpdateOpsAndClearList(List<UpdateOp> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                recycleUpdateOp(list.get(i));
            }
            list.clear();
        }
    }

    private void applyRemove(UpdateOp updateOp) {
        boolean z;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, updateOp) == null) {
            int i = updateOp.positionStart;
            int i2 = updateOp.itemCount + i;
            char c2 = 65535;
            int i3 = i;
            int i4 = 0;
            while (i3 < i2) {
                if (this.mCallback.findViewHolder(i3) == null && !canFindInPreLayout(i3)) {
                    if (c2 == 1) {
                        postponeAndUpdateViewHolders(obtainUpdateOp(2, i, i4, null));
                        z = true;
                    } else {
                        z = false;
                    }
                    c = 0;
                } else {
                    if (c2 == 0) {
                        dispatchAndUpdateViewHolders(obtainUpdateOp(2, i, i4, null));
                        z = true;
                    } else {
                        z = false;
                    }
                    c = 1;
                }
                if (z) {
                    i3 -= i4;
                    i2 -= i4;
                    i4 = 1;
                } else {
                    i4++;
                }
                i3++;
                c2 = c;
            }
            if (i4 != updateOp.itemCount) {
                recycleUpdateOp(updateOp);
                updateOp = obtainUpdateOp(2, i, i4, null);
            }
            if (c2 == 0) {
                dispatchAndUpdateViewHolders(updateOp);
            } else {
                postponeAndUpdateViewHolders(updateOp);
            }
        }
    }

    private void applyUpdate(UpdateOp updateOp) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, updateOp) == null) {
            int i = updateOp.positionStart;
            int i2 = updateOp.itemCount + i;
            int i3 = i;
            char c = 65535;
            int i4 = 0;
            while (i < i2) {
                if (this.mCallback.findViewHolder(i) == null && !canFindInPreLayout(i)) {
                    if (c == 1) {
                        postponeAndUpdateViewHolders(obtainUpdateOp(4, i3, i4, updateOp.payload));
                        i3 = i;
                        i4 = 0;
                    }
                    c = 0;
                } else {
                    if (c == 0) {
                        dispatchAndUpdateViewHolders(obtainUpdateOp(4, i3, i4, updateOp.payload));
                        i3 = i;
                        i4 = 0;
                    }
                    c = 1;
                }
                i4++;
                i++;
            }
            if (i4 != updateOp.itemCount) {
                Object obj = updateOp.payload;
                recycleUpdateOp(updateOp);
                updateOp = obtainUpdateOp(4, i3, i4, obj);
            }
            if (c == 0) {
                dispatchAndUpdateViewHolders(updateOp);
            } else {
                postponeAndUpdateViewHolders(updateOp);
            }
        }
    }

    private boolean canFindInPreLayout(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, this, i)) == null) {
            int size = this.mPostponedList.size();
            for (int i2 = 0; i2 < size; i2++) {
                UpdateOp updateOp = this.mPostponedList.get(i2);
                int i3 = updateOp.cmd;
                if (i3 == 8) {
                    if (findPositionOffset(updateOp.itemCount, i2 + 1) == i) {
                        return true;
                    }
                } else if (i3 == 1) {
                    int i4 = updateOp.positionStart;
                    int i5 = updateOp.itemCount + i4;
                    while (i4 < i5) {
                        if (findPositionOffset(i4, i2 + 1) == i) {
                            return true;
                        }
                        i4++;
                    }
                    continue;
                } else {
                    continue;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    private void postponeAndUpdateViewHolders(UpdateOp updateOp) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, updateOp) == null) {
            this.mPostponedList.add(updateOp);
            int i = updateOp.cmd;
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        if (i == 8) {
                            this.mCallback.offsetPositionsForMove(updateOp.positionStart, updateOp.itemCount);
                            return;
                        }
                        throw new IllegalArgumentException("Unknown update op type for " + updateOp);
                    }
                    this.mCallback.markViewHoldersUpdated(updateOp.positionStart, updateOp.itemCount, updateOp.payload);
                    return;
                }
                this.mCallback.offsetPositionsForRemovingLaidOutOrNewView(updateOp.positionStart, updateOp.itemCount);
                return;
            }
            this.mCallback.offsetPositionsForAdd(updateOp.positionStart, updateOp.itemCount);
        }
    }

    public int applyPendingUpdatesToPosition(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            int size = this.mPendingUpdates.size();
            for (int i2 = 0; i2 < size; i2++) {
                UpdateOp updateOp = this.mPendingUpdates.get(i2);
                int i3 = updateOp.cmd;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 8) {
                            int i4 = updateOp.positionStart;
                            if (i4 == i) {
                                i = updateOp.itemCount;
                            } else {
                                if (i4 < i) {
                                    i--;
                                }
                                if (updateOp.itemCount <= i) {
                                    i++;
                                }
                            }
                        }
                    } else {
                        int i5 = updateOp.positionStart;
                        if (i5 <= i) {
                            int i6 = updateOp.itemCount;
                            if (i5 + i6 > i) {
                                return -1;
                            }
                            i -= i6;
                        } else {
                            continue;
                        }
                    }
                } else if (updateOp.positionStart <= i) {
                    i += updateOp.itemCount;
                }
            }
            return i;
        }
        return invokeI.intValue;
    }

    private void dispatchAndUpdateViewHolders(UpdateOp updateOp) {
        int i;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, updateOp) == null) {
            int i2 = updateOp.cmd;
            if (i2 != 1 && i2 != 8) {
                int updatePositionWithPostponed = updatePositionWithPostponed(updateOp.positionStart, i2);
                int i3 = updateOp.positionStart;
                int i4 = updateOp.cmd;
                if (i4 != 2) {
                    if (i4 == 4) {
                        i = 1;
                    } else {
                        throw new IllegalArgumentException("op should be remove or update." + updateOp);
                    }
                } else {
                    i = 0;
                }
                int i5 = 1;
                for (int i6 = 1; i6 < updateOp.itemCount; i6++) {
                    int updatePositionWithPostponed2 = updatePositionWithPostponed(updateOp.positionStart + (i * i6), updateOp.cmd);
                    int i7 = updateOp.cmd;
                    if (i7 == 2 ? updatePositionWithPostponed2 != updatePositionWithPostponed : i7 != 4 || updatePositionWithPostponed2 != updatePositionWithPostponed + 1) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        i5++;
                    } else {
                        UpdateOp obtainUpdateOp = obtainUpdateOp(updateOp.cmd, updatePositionWithPostponed, i5, updateOp.payload);
                        dispatchFirstPassAndUpdateViewHolders(obtainUpdateOp, i3);
                        recycleUpdateOp(obtainUpdateOp);
                        if (updateOp.cmd == 4) {
                            i3 += i5;
                        }
                        updatePositionWithPostponed = updatePositionWithPostponed2;
                        i5 = 1;
                    }
                }
                Object obj = updateOp.payload;
                recycleUpdateOp(updateOp);
                if (i5 > 0) {
                    UpdateOp obtainUpdateOp2 = obtainUpdateOp(updateOp.cmd, updatePositionWithPostponed, i5, obj);
                    dispatchFirstPassAndUpdateViewHolders(obtainUpdateOp2, i3);
                    recycleUpdateOp(obtainUpdateOp2);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
    }

    private int updatePositionWithPostponed(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65545, this, i, i2)) == null) {
            for (int size = this.mPostponedList.size() - 1; size >= 0; size--) {
                UpdateOp updateOp = this.mPostponedList.get(size);
                int i3 = updateOp.cmd;
                if (i3 == 8) {
                    int i4 = updateOp.positionStart;
                    int i5 = updateOp.itemCount;
                    if (i4 >= i5) {
                        i5 = i4;
                        i4 = i5;
                    }
                    if (i >= i4 && i <= i5) {
                        int i6 = updateOp.positionStart;
                        if (i4 == i6) {
                            if (i2 == 1) {
                                updateOp.itemCount++;
                            } else if (i2 == 2) {
                                updateOp.itemCount--;
                            }
                            i++;
                        } else {
                            if (i2 == 1) {
                                updateOp.positionStart = i6 + 1;
                            } else if (i2 == 2) {
                                updateOp.positionStart = i6 - 1;
                            }
                            i--;
                        }
                    } else {
                        int i7 = updateOp.positionStart;
                        if (i < i7) {
                            if (i2 == 1) {
                                updateOp.positionStart = i7 + 1;
                                updateOp.itemCount++;
                            } else if (i2 == 2) {
                                updateOp.positionStart = i7 - 1;
                                updateOp.itemCount--;
                            }
                        }
                    }
                } else {
                    int i8 = updateOp.positionStart;
                    if (i8 <= i) {
                        if (i3 == 1) {
                            i -= updateOp.itemCount;
                        } else if (i3 == 2) {
                            i += updateOp.itemCount;
                        }
                    } else if (i2 == 1) {
                        updateOp.positionStart = i8 + 1;
                    } else if (i2 == 2) {
                        updateOp.positionStart = i8 - 1;
                    }
                }
            }
            for (int size2 = this.mPostponedList.size() - 1; size2 >= 0; size2--) {
                UpdateOp updateOp2 = this.mPostponedList.get(size2);
                if (updateOp2.cmd == 8) {
                    int i9 = updateOp2.itemCount;
                    if (i9 == updateOp2.positionStart || i9 < 0) {
                        this.mPostponedList.remove(size2);
                        recycleUpdateOp(updateOp2);
                    }
                } else if (updateOp2.itemCount <= 0) {
                    this.mPostponedList.remove(size2);
                    recycleUpdateOp(updateOp2);
                }
            }
            return i;
        }
        return invokeII.intValue;
    }

    public void consumePostponedUpdates() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int size = this.mPostponedList.size();
            for (int i = 0; i < size; i++) {
                this.mCallback.onDispatchSecondPass(this.mPostponedList.get(i));
            }
            recycleUpdateOpsAndClearList(this.mPostponedList);
            this.mExistingUpdateTypes = 0;
        }
    }

    public boolean hasPendingUpdates() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.mPendingUpdates.size() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasUpdates() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!this.mPostponedList.isEmpty() && !this.mPendingUpdates.isEmpty()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            recycleUpdateOpsAndClearList(this.mPendingUpdates);
            recycleUpdateOpsAndClearList(this.mPostponedList);
            this.mExistingUpdateTypes = 0;
        }
    }

    public void consumeUpdatesInOnePass() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            consumePostponedUpdates();
            int size = this.mPendingUpdates.size();
            for (int i = 0; i < size; i++) {
                UpdateOp updateOp = this.mPendingUpdates.get(i);
                int i2 = updateOp.cmd;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 4) {
                            if (i2 == 8) {
                                this.mCallback.onDispatchSecondPass(updateOp);
                                this.mCallback.offsetPositionsForMove(updateOp.positionStart, updateOp.itemCount);
                            }
                        } else {
                            this.mCallback.onDispatchSecondPass(updateOp);
                            this.mCallback.markViewHoldersUpdated(updateOp.positionStart, updateOp.itemCount, updateOp.payload);
                        }
                    } else {
                        this.mCallback.onDispatchSecondPass(updateOp);
                        this.mCallback.offsetPositionsForRemovingInvisible(updateOp.positionStart, updateOp.itemCount);
                    }
                } else {
                    this.mCallback.onDispatchSecondPass(updateOp);
                    this.mCallback.offsetPositionsForAdd(updateOp.positionStart, updateOp.itemCount);
                }
                Runnable runnable = this.mOnItemProcessedCallback;
                if (runnable != null) {
                    runnable.run();
                }
            }
            recycleUpdateOpsAndClearList(this.mPendingUpdates);
            this.mExistingUpdateTypes = 0;
        }
    }

    public void dispatchFirstPassAndUpdateViewHolders(UpdateOp updateOp, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, updateOp, i) == null) {
            this.mCallback.onDispatchFirstPass(updateOp);
            int i2 = updateOp.cmd;
            if (i2 != 2) {
                if (i2 == 4) {
                    this.mCallback.markViewHoldersUpdated(i, updateOp.itemCount, updateOp.payload);
                    return;
                }
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.mCallback.offsetPositionsForRemovingInvisible(i, updateOp.itemCount);
        }
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public UpdateOp obtainUpdateOp(int i, int i2, int i3, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), obj})) == null) {
            UpdateOp acquire = this.mUpdateOpPool.acquire();
            if (acquire == null) {
                return new UpdateOp(i, i2, i3, obj);
            }
            acquire.cmd = i;
            acquire.positionStart = i2;
            acquire.itemCount = i3;
            acquire.payload = obj;
            return acquire;
        }
        return (UpdateOp) invokeCommon.objValue;
    }

    public boolean onItemRangeChanged(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048587, this, i, i2, obj)) == null) {
            if (i2 < 1) {
                return false;
            }
            this.mPendingUpdates.add(obtainUpdateOp(4, i, i2, obj));
            this.mExistingUpdateTypes |= 4;
            if (this.mPendingUpdates.size() != 1) {
                return false;
            }
            return true;
        }
        return invokeIIL.booleanValue;
    }

    public boolean onItemRangeInserted(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048588, this, i, i2)) == null) {
            if (i2 < 1) {
                return false;
            }
            this.mPendingUpdates.add(obtainUpdateOp(1, i, i2, null));
            this.mExistingUpdateTypes |= 1;
            if (this.mPendingUpdates.size() != 1) {
                return false;
            }
            return true;
        }
        return invokeII.booleanValue;
    }

    public boolean onItemRangeRemoved(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048590, this, i, i2)) == null) {
            if (i2 < 1) {
                return false;
            }
            this.mPendingUpdates.add(obtainUpdateOp(2, i, i2, null));
            this.mExistingUpdateTypes |= 2;
            if (this.mPendingUpdates.size() != 1) {
                return false;
            }
            return true;
        }
        return invokeII.booleanValue;
    }

    public boolean onItemRangeMoved(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048589, this, i, i2, i3)) == null) {
            if (i == i2) {
                return false;
            }
            if (i3 == 1) {
                this.mPendingUpdates.add(obtainUpdateOp(8, i, i2, null));
                this.mExistingUpdateTypes |= 8;
                if (this.mPendingUpdates.size() != 1) {
                    return false;
                }
                return true;
            }
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        return invokeIII.booleanValue;
    }

    public void preProcess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.mOpReorderer.reorderOps(this.mPendingUpdates);
            int size = this.mPendingUpdates.size();
            for (int i = 0; i < size; i++) {
                UpdateOp updateOp = this.mPendingUpdates.get(i);
                int i2 = updateOp.cmd;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 4) {
                            if (i2 == 8) {
                                applyMove(updateOp);
                            }
                        } else {
                            applyUpdate(updateOp);
                        }
                    } else {
                        applyRemove(updateOp);
                    }
                } else {
                    applyAdd(updateOp);
                }
                Runnable runnable = this.mOnItemProcessedCallback;
                if (runnable != null) {
                    runnable.run();
                }
            }
            this.mPendingUpdates.clear();
        }
    }
}
