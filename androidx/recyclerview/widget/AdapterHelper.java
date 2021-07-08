package androidx.recyclerview.widget;

import androidx.core.util.Pools;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.OpReorderer;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
        RecyclerView.ViewHolder findViewHolder(int i2);

        void markViewHoldersUpdated(int i2, int i3, Object obj);

        void offsetPositionsForAdd(int i2, int i3);

        void offsetPositionsForMove(int i2, int i3);

        void offsetPositionsForRemovingInvisible(int i2, int i3);

        void offsetPositionsForRemovingLaidOutOrNewView(int i2, int i3);

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

        public UpdateOp(int i2, int i3, int i4, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.cmd = i2;
            this.positionStart = i3;
            this.itemCount = i4;
            this.payload = obj;
        }

        public String cmdToString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.cmd;
                return i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? "??" : "mv" : "up" : "rm" : "add";
            }
            return (String) invokeV.objValue;
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
                int i2 = this.cmd;
                if (i2 != updateOp.cmd) {
                    return false;
                }
                if (i2 == 8 && Math.abs(this.itemCount - this.positionStart) == 1 && this.itemCount == updateOp.positionStart && this.positionStart == updateOp.itemCount) {
                    return true;
                }
                if (this.itemCount == updateOp.itemCount && this.positionStart == updateOp.positionStart) {
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
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (((this.cmd * 31) + this.positionStart) * 31) + this.itemCount : invokeV.intValue;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Callback) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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

    private void applyRemove(UpdateOp updateOp) {
        boolean z;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, updateOp) == null) {
            int i2 = updateOp.positionStart;
            int i3 = updateOp.itemCount + i2;
            char c3 = 65535;
            int i4 = i2;
            int i5 = 0;
            while (i4 < i3) {
                if (this.mCallback.findViewHolder(i4) != null || canFindInPreLayout(i4)) {
                    if (c3 == 0) {
                        dispatchAndUpdateViewHolders(obtainUpdateOp(2, i2, i5, null));
                        z = true;
                    } else {
                        z = false;
                    }
                    c2 = 1;
                } else {
                    if (c3 == 1) {
                        postponeAndUpdateViewHolders(obtainUpdateOp(2, i2, i5, null));
                        z = true;
                    } else {
                        z = false;
                    }
                    c2 = 0;
                }
                if (z) {
                    i4 -= i5;
                    i3 -= i5;
                    i5 = 1;
                } else {
                    i5++;
                }
                i4++;
                c3 = c2;
            }
            if (i5 != updateOp.itemCount) {
                recycleUpdateOp(updateOp);
                updateOp = obtainUpdateOp(2, i2, i5, null);
            }
            if (c3 == 0) {
                dispatchAndUpdateViewHolders(updateOp);
            } else {
                postponeAndUpdateViewHolders(updateOp);
            }
        }
    }

    private void applyUpdate(UpdateOp updateOp) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, updateOp) == null) {
            int i2 = updateOp.positionStart;
            int i3 = updateOp.itemCount + i2;
            int i4 = i2;
            char c2 = 65535;
            int i5 = 0;
            while (i2 < i3) {
                if (this.mCallback.findViewHolder(i2) != null || canFindInPreLayout(i2)) {
                    if (c2 == 0) {
                        dispatchAndUpdateViewHolders(obtainUpdateOp(4, i4, i5, updateOp.payload));
                        i4 = i2;
                        i5 = 0;
                    }
                    c2 = 1;
                } else {
                    if (c2 == 1) {
                        postponeAndUpdateViewHolders(obtainUpdateOp(4, i4, i5, updateOp.payload));
                        i4 = i2;
                        i5 = 0;
                    }
                    c2 = 0;
                }
                i5++;
                i2++;
            }
            if (i5 != updateOp.itemCount) {
                Object obj = updateOp.payload;
                recycleUpdateOp(updateOp);
                updateOp = obtainUpdateOp(4, i4, i5, obj);
            }
            if (c2 == 0) {
                dispatchAndUpdateViewHolders(updateOp);
            } else {
                postponeAndUpdateViewHolders(updateOp);
            }
        }
    }

    private boolean canFindInPreLayout(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, this, i2)) == null) {
            int size = this.mPostponedList.size();
            for (int i3 = 0; i3 < size; i3++) {
                UpdateOp updateOp = this.mPostponedList.get(i3);
                int i4 = updateOp.cmd;
                if (i4 == 8) {
                    if (findPositionOffset(updateOp.itemCount, i3 + 1) == i2) {
                        return true;
                    }
                } else if (i4 == 1) {
                    int i5 = updateOp.positionStart;
                    int i6 = updateOp.itemCount + i5;
                    while (i5 < i6) {
                        if (findPositionOffset(i5, i3 + 1) == i2) {
                            return true;
                        }
                        i5++;
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

    private void dispatchAndUpdateViewHolders(UpdateOp updateOp) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, updateOp) == null) {
            int i3 = updateOp.cmd;
            if (i3 != 1 && i3 != 8) {
                int updatePositionWithPostponed = updatePositionWithPostponed(updateOp.positionStart, i3);
                int i4 = updateOp.positionStart;
                int i5 = updateOp.cmd;
                if (i5 == 2) {
                    i2 = 0;
                } else if (i5 != 4) {
                    throw new IllegalArgumentException("op should be remove or update." + updateOp);
                } else {
                    i2 = 1;
                }
                int i6 = 1;
                for (int i7 = 1; i7 < updateOp.itemCount; i7++) {
                    int updatePositionWithPostponed2 = updatePositionWithPostponed(updateOp.positionStart + (i2 * i7), updateOp.cmd);
                    int i8 = updateOp.cmd;
                    if (i8 == 2 ? updatePositionWithPostponed2 == updatePositionWithPostponed : i8 == 4 && updatePositionWithPostponed2 == updatePositionWithPostponed + 1) {
                        i6++;
                    } else {
                        UpdateOp obtainUpdateOp = obtainUpdateOp(updateOp.cmd, updatePositionWithPostponed, i6, updateOp.payload);
                        dispatchFirstPassAndUpdateViewHolders(obtainUpdateOp, i4);
                        recycleUpdateOp(obtainUpdateOp);
                        if (updateOp.cmd == 4) {
                            i4 += i6;
                        }
                        updatePositionWithPostponed = updatePositionWithPostponed2;
                        i6 = 1;
                    }
                }
                Object obj = updateOp.payload;
                recycleUpdateOp(updateOp);
                if (i6 > 0) {
                    UpdateOp obtainUpdateOp2 = obtainUpdateOp(updateOp.cmd, updatePositionWithPostponed, i6, obj);
                    dispatchFirstPassAndUpdateViewHolders(obtainUpdateOp2, i4);
                    recycleUpdateOp(obtainUpdateOp2);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
    }

    private void postponeAndUpdateViewHolders(UpdateOp updateOp) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, updateOp) == null) {
            this.mPostponedList.add(updateOp);
            int i2 = updateOp.cmd;
            if (i2 == 1) {
                this.mCallback.offsetPositionsForAdd(updateOp.positionStart, updateOp.itemCount);
            } else if (i2 == 2) {
                this.mCallback.offsetPositionsForRemovingLaidOutOrNewView(updateOp.positionStart, updateOp.itemCount);
            } else if (i2 == 4) {
                this.mCallback.markViewHoldersUpdated(updateOp.positionStart, updateOp.itemCount, updateOp.payload);
            } else if (i2 == 8) {
                this.mCallback.offsetPositionsForMove(updateOp.positionStart, updateOp.itemCount);
            } else {
                throw new IllegalArgumentException("Unknown update op type for " + updateOp);
            }
        }
    }

    private int updatePositionWithPostponed(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65545, this, i2, i3)) == null) {
            for (int size = this.mPostponedList.size() - 1; size >= 0; size--) {
                UpdateOp updateOp = this.mPostponedList.get(size);
                int i4 = updateOp.cmd;
                if (i4 == 8) {
                    int i5 = updateOp.positionStart;
                    int i6 = updateOp.itemCount;
                    if (i5 >= i6) {
                        i6 = i5;
                        i5 = i6;
                    }
                    if (i2 >= i5 && i2 <= i6) {
                        int i7 = updateOp.positionStart;
                        if (i5 == i7) {
                            if (i3 == 1) {
                                updateOp.itemCount++;
                            } else if (i3 == 2) {
                                updateOp.itemCount--;
                            }
                            i2++;
                        } else {
                            if (i3 == 1) {
                                updateOp.positionStart = i7 + 1;
                            } else if (i3 == 2) {
                                updateOp.positionStart = i7 - 1;
                            }
                            i2--;
                        }
                    } else {
                        int i8 = updateOp.positionStart;
                        if (i2 < i8) {
                            if (i3 == 1) {
                                updateOp.positionStart = i8 + 1;
                                updateOp.itemCount++;
                            } else if (i3 == 2) {
                                updateOp.positionStart = i8 - 1;
                                updateOp.itemCount--;
                            }
                        }
                    }
                } else {
                    int i9 = updateOp.positionStart;
                    if (i9 <= i2) {
                        if (i4 == 1) {
                            i2 -= updateOp.itemCount;
                        } else if (i4 == 2) {
                            i2 += updateOp.itemCount;
                        }
                    } else if (i3 == 1) {
                        updateOp.positionStart = i9 + 1;
                    } else if (i3 == 2) {
                        updateOp.positionStart = i9 - 1;
                    }
                }
            }
            for (int size2 = this.mPostponedList.size() - 1; size2 >= 0; size2--) {
                UpdateOp updateOp2 = this.mPostponedList.get(size2);
                if (updateOp2.cmd == 8) {
                    int i10 = updateOp2.itemCount;
                    if (i10 == updateOp2.positionStart || i10 < 0) {
                        this.mPostponedList.remove(size2);
                        recycleUpdateOp(updateOp2);
                    }
                } else if (updateOp2.itemCount <= 0) {
                    this.mPostponedList.remove(size2);
                    recycleUpdateOp(updateOp2);
                }
            }
            return i2;
        }
        return invokeII.intValue;
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

    public int applyPendingUpdatesToPosition(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            int size = this.mPendingUpdates.size();
            for (int i3 = 0; i3 < size; i3++) {
                UpdateOp updateOp = this.mPendingUpdates.get(i3);
                int i4 = updateOp.cmd;
                if (i4 != 1) {
                    if (i4 == 2) {
                        int i5 = updateOp.positionStart;
                        if (i5 <= i2) {
                            int i6 = updateOp.itemCount;
                            if (i5 + i6 > i2) {
                                return -1;
                            }
                            i2 -= i6;
                        } else {
                            continue;
                        }
                    } else if (i4 == 8) {
                        int i7 = updateOp.positionStart;
                        if (i7 == i2) {
                            i2 = updateOp.itemCount;
                        } else {
                            if (i7 < i2) {
                                i2--;
                            }
                            if (updateOp.itemCount <= i2) {
                                i2++;
                            }
                        }
                    }
                } else if (updateOp.positionStart <= i2) {
                    i2 += updateOp.itemCount;
                }
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public void consumePostponedUpdates() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int size = this.mPostponedList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mCallback.onDispatchSecondPass(this.mPostponedList.get(i2));
            }
            recycleUpdateOpsAndClearList(this.mPostponedList);
            this.mExistingUpdateTypes = 0;
        }
    }

    public void consumeUpdatesInOnePass() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            consumePostponedUpdates();
            int size = this.mPendingUpdates.size();
            for (int i2 = 0; i2 < size; i2++) {
                UpdateOp updateOp = this.mPendingUpdates.get(i2);
                int i3 = updateOp.cmd;
                if (i3 == 1) {
                    this.mCallback.onDispatchSecondPass(updateOp);
                    this.mCallback.offsetPositionsForAdd(updateOp.positionStart, updateOp.itemCount);
                } else if (i3 == 2) {
                    this.mCallback.onDispatchSecondPass(updateOp);
                    this.mCallback.offsetPositionsForRemovingInvisible(updateOp.positionStart, updateOp.itemCount);
                } else if (i3 == 4) {
                    this.mCallback.onDispatchSecondPass(updateOp);
                    this.mCallback.markViewHoldersUpdated(updateOp.positionStart, updateOp.itemCount, updateOp.payload);
                } else if (i3 == 8) {
                    this.mCallback.onDispatchSecondPass(updateOp);
                    this.mCallback.offsetPositionsForMove(updateOp.positionStart, updateOp.itemCount);
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

    public void dispatchFirstPassAndUpdateViewHolders(UpdateOp updateOp, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, updateOp, i2) == null) {
            this.mCallback.onDispatchFirstPass(updateOp);
            int i3 = updateOp.cmd;
            if (i3 == 2) {
                this.mCallback.offsetPositionsForRemovingInvisible(i2, updateOp.itemCount);
            } else if (i3 == 4) {
                this.mCallback.markViewHoldersUpdated(i2, updateOp.itemCount, updateOp.payload);
            } else {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
        }
    }

    public int findPositionOffset(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? findPositionOffset(i2, 0) : invokeI.intValue;
    }

    public boolean hasAnyUpdateTypes(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? (i2 & this.mExistingUpdateTypes) != 0 : invokeI.booleanValue;
    }

    public boolean hasPendingUpdates() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mPendingUpdates.size() > 0 : invokeV.booleanValue;
    }

    public boolean hasUpdates() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (this.mPostponedList.isEmpty() || this.mPendingUpdates.isEmpty()) ? false : true : invokeV.booleanValue;
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public UpdateOp obtainUpdateOp(int i2, int i3, int i4, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), obj})) == null) {
            UpdateOp acquire = this.mUpdateOpPool.acquire();
            if (acquire == null) {
                return new UpdateOp(i2, i3, i4, obj);
            }
            acquire.cmd = i2;
            acquire.positionStart = i3;
            acquire.itemCount = i4;
            acquire.payload = obj;
            return acquire;
        }
        return (UpdateOp) invokeCommon.objValue;
    }

    public boolean onItemRangeChanged(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048587, this, i2, i3, obj)) == null) {
            if (i3 < 1) {
                return false;
            }
            this.mPendingUpdates.add(obtainUpdateOp(4, i2, i3, obj));
            this.mExistingUpdateTypes |= 4;
            return this.mPendingUpdates.size() == 1;
        }
        return invokeIIL.booleanValue;
    }

    public boolean onItemRangeInserted(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048588, this, i2, i3)) == null) {
            if (i3 < 1) {
                return false;
            }
            this.mPendingUpdates.add(obtainUpdateOp(1, i2, i3, null));
            this.mExistingUpdateTypes |= 1;
            return this.mPendingUpdates.size() == 1;
        }
        return invokeII.booleanValue;
    }

    public boolean onItemRangeMoved(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048589, this, i2, i3, i4)) == null) {
            if (i2 == i3) {
                return false;
            }
            if (i4 == 1) {
                this.mPendingUpdates.add(obtainUpdateOp(8, i2, i3, null));
                this.mExistingUpdateTypes |= 8;
                return this.mPendingUpdates.size() == 1;
            }
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        return invokeIII.booleanValue;
    }

    public boolean onItemRangeRemoved(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048590, this, i2, i3)) == null) {
            if (i3 < 1) {
                return false;
            }
            this.mPendingUpdates.add(obtainUpdateOp(2, i2, i3, null));
            this.mExistingUpdateTypes |= 2;
            return this.mPendingUpdates.size() == 1;
        }
        return invokeII.booleanValue;
    }

    public void preProcess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.mOpReorderer.reorderOps(this.mPendingUpdates);
            int size = this.mPendingUpdates.size();
            for (int i2 = 0; i2 < size; i2++) {
                UpdateOp updateOp = this.mPendingUpdates.get(i2);
                int i3 = updateOp.cmd;
                if (i3 == 1) {
                    applyAdd(updateOp);
                } else if (i3 == 2) {
                    applyRemove(updateOp);
                } else if (i3 == 4) {
                    applyUpdate(updateOp);
                } else if (i3 == 8) {
                    applyMove(updateOp);
                }
                Runnable runnable = this.mOnItemProcessedCallback;
                if (runnable != null) {
                    runnable.run();
                }
            }
            this.mPendingUpdates.clear();
        }
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public void recycleUpdateOp(UpdateOp updateOp) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, updateOp) == null) || this.mDisableRecycler) {
            return;
        }
        updateOp.payload = null;
        this.mUpdateOpPool.release(updateOp);
    }

    public void recycleUpdateOpsAndClearList(List<UpdateOp> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                recycleUpdateOp(list.get(i2));
            }
            list.clear();
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            recycleUpdateOpsAndClearList(this.mPendingUpdates);
            recycleUpdateOpsAndClearList(this.mPostponedList);
            this.mExistingUpdateTypes = 0;
        }
    }

    public AdapterHelper(Callback callback, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callback, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public int findPositionOffset(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i2, i3)) == null) {
            int size = this.mPostponedList.size();
            while (i3 < size) {
                UpdateOp updateOp = this.mPostponedList.get(i3);
                int i4 = updateOp.cmd;
                if (i4 == 8) {
                    int i5 = updateOp.positionStart;
                    if (i5 == i2) {
                        i2 = updateOp.itemCount;
                    } else {
                        if (i5 < i2) {
                            i2--;
                        }
                        if (updateOp.itemCount <= i2) {
                            i2++;
                        }
                    }
                } else {
                    int i6 = updateOp.positionStart;
                    if (i6 > i2) {
                        continue;
                    } else if (i4 == 2) {
                        int i7 = updateOp.itemCount;
                        if (i2 < i6 + i7) {
                            return -1;
                        }
                        i2 -= i7;
                    } else if (i4 == 1) {
                        i2 += updateOp.itemCount;
                    }
                }
                i3++;
            }
            return i2;
        }
        return invokeII.intValue;
    }
}
