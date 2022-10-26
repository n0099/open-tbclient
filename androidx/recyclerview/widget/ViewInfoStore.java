package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ViewInfoStore {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG = false;
    public transient /* synthetic */ FieldHolder $fh;
    public final SimpleArrayMap<RecyclerView.ViewHolder, InfoRecord> mLayoutHolderMap;
    public final LongSparseArray<RecyclerView.ViewHolder> mOldChangedHolders;

    /* loaded from: classes.dex */
    public interface ProcessCallback {
        void processAppeared(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void processDisappeared(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void processPersistent(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void unused(RecyclerView.ViewHolder viewHolder);
    }

    /* loaded from: classes.dex */
    public static class InfoRecord {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int FLAG_APPEAR = 2;
        public static final int FLAG_APPEAR_AND_DISAPPEAR = 3;
        public static final int FLAG_APPEAR_PRE_AND_POST = 14;
        public static final int FLAG_DISAPPEARED = 1;
        public static final int FLAG_POST = 8;
        public static final int FLAG_PRE = 4;
        public static final int FLAG_PRE_AND_POST = 12;
        public static Pools.Pool<InfoRecord> sPool;
        public transient /* synthetic */ FieldHolder $fh;
        public int flags;
        public RecyclerView.ItemAnimator.ItemHolderInfo postInfo;
        public RecyclerView.ItemAnimator.ItemHolderInfo preInfo;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-550790612, "Landroidx/recyclerview/widget/ViewInfoStore$InfoRecord;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-550790612, "Landroidx/recyclerview/widget/ViewInfoStore$InfoRecord;");
                    return;
                }
            }
            sPool = new Pools.SimplePool(20);
        }

        public InfoRecord() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static void drainCache() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, null) == null) {
                do {
                } while (sPool.acquire() != null);
            }
        }

        public static InfoRecord obtain() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                InfoRecord infoRecord = (InfoRecord) sPool.acquire();
                if (infoRecord == null) {
                    return new InfoRecord();
                }
                return infoRecord;
            }
            return (InfoRecord) invokeV.objValue;
        }

        public static void recycle(InfoRecord infoRecord) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, infoRecord) == null) {
                infoRecord.flags = 0;
                infoRecord.preInfo = null;
                infoRecord.postInfo = null;
                sPool.release(infoRecord);
            }
        }
    }

    public ViewInfoStore() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLayoutHolderMap = new SimpleArrayMap<>();
        this.mOldChangedHolders = new LongSparseArray<>();
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mLayoutHolderMap.clear();
            this.mOldChangedHolders.clear();
        }
    }

    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            InfoRecord.drainCache();
        }
    }

    private RecyclerView.ItemAnimator.ItemHolderInfo popFromLayoutStep(RecyclerView.ViewHolder viewHolder, int i) {
        InterceptResult invokeLI;
        InfoRecord valueAt;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, this, viewHolder, i)) == null) {
            int indexOfKey = this.mLayoutHolderMap.indexOfKey(viewHolder);
            if (indexOfKey >= 0 && (valueAt = this.mLayoutHolderMap.valueAt(indexOfKey)) != null) {
                int i2 = valueAt.flags;
                if ((i2 & i) != 0) {
                    valueAt.flags = (~i) & i2;
                    if (i == 4) {
                        itemHolderInfo = valueAt.preInfo;
                    } else if (i == 8) {
                        itemHolderInfo = valueAt.postInfo;
                    } else {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    if ((valueAt.flags & 12) == 0) {
                        this.mLayoutHolderMap.removeAt(indexOfKey);
                        InfoRecord.recycle(valueAt);
                    }
                    return itemHolderInfo;
                }
            }
            return null;
        }
        return (RecyclerView.ItemAnimator.ItemHolderInfo) invokeLI.objValue;
    }

    public void addToAppearedInPreLayoutHolders(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewHolder, itemHolderInfo) == null) {
            InfoRecord infoRecord = this.mLayoutHolderMap.get(viewHolder);
            if (infoRecord == null) {
                infoRecord = InfoRecord.obtain();
                this.mLayoutHolderMap.put(viewHolder, infoRecord);
            }
            infoRecord.flags |= 2;
            infoRecord.preInfo = itemHolderInfo;
        }
    }

    public void addToOldChangeHolders(long j, RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, viewHolder) == null) {
            this.mOldChangedHolders.put(j, viewHolder);
        }
    }

    public void addToPostLayout(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, viewHolder, itemHolderInfo) == null) {
            InfoRecord infoRecord = this.mLayoutHolderMap.get(viewHolder);
            if (infoRecord == null) {
                infoRecord = InfoRecord.obtain();
                this.mLayoutHolderMap.put(viewHolder, infoRecord);
            }
            infoRecord.postInfo = itemHolderInfo;
            infoRecord.flags |= 8;
        }
    }

    public void addToPreLayout(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, viewHolder, itemHolderInfo) == null) {
            InfoRecord infoRecord = this.mLayoutHolderMap.get(viewHolder);
            if (infoRecord == null) {
                infoRecord = InfoRecord.obtain();
                this.mLayoutHolderMap.put(viewHolder, infoRecord);
            }
            infoRecord.preInfo = itemHolderInfo;
            infoRecord.flags |= 4;
        }
    }

    public void addToDisappearedInLayout(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder) == null) {
            InfoRecord infoRecord = this.mLayoutHolderMap.get(viewHolder);
            if (infoRecord == null) {
                infoRecord = InfoRecord.obtain();
                this.mLayoutHolderMap.put(viewHolder, infoRecord);
            }
            infoRecord.flags |= 1;
        }
    }

    public RecyclerView.ViewHolder getFromOldChangeHolders(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            return this.mOldChangedHolders.get(j);
        }
        return (RecyclerView.ViewHolder) invokeJ.objValue;
    }

    public boolean isDisappearing(RecyclerView.ViewHolder viewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewHolder)) == null) {
            InfoRecord infoRecord = this.mLayoutHolderMap.get(viewHolder);
            if (infoRecord != null && (infoRecord.flags & 1) != 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean isInPreLayout(RecyclerView.ViewHolder viewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewHolder)) == null) {
            InfoRecord infoRecord = this.mLayoutHolderMap.get(viewHolder);
            if (infoRecord != null && (infoRecord.flags & 4) != 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void onViewDetached(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, viewHolder) == null) {
            removeFromDisappearedInLayout(viewHolder);
        }
    }

    public RecyclerView.ItemAnimator.ItemHolderInfo popFromPostLayout(RecyclerView.ViewHolder viewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, viewHolder)) == null) {
            return popFromLayoutStep(viewHolder, 8);
        }
        return (RecyclerView.ItemAnimator.ItemHolderInfo) invokeL.objValue;
    }

    public RecyclerView.ItemAnimator.ItemHolderInfo popFromPreLayout(RecyclerView.ViewHolder viewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, viewHolder)) == null) {
            return popFromLayoutStep(viewHolder, 4);
        }
        return (RecyclerView.ItemAnimator.ItemHolderInfo) invokeL.objValue;
    }

    public void removeFromDisappearedInLayout(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, viewHolder) != null) || (infoRecord = this.mLayoutHolderMap.get(viewHolder)) == null) {
            return;
        }
        infoRecord.flags &= -2;
    }

    public void process(ProcessCallback processCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, processCallback) == null) {
            for (int size = this.mLayoutHolderMap.size() - 1; size >= 0; size--) {
                RecyclerView.ViewHolder keyAt = this.mLayoutHolderMap.keyAt(size);
                InfoRecord removeAt = this.mLayoutHolderMap.removeAt(size);
                int i = removeAt.flags;
                if ((i & 3) == 3) {
                    processCallback.unused(keyAt);
                } else if ((i & 1) != 0) {
                    RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo = removeAt.preInfo;
                    if (itemHolderInfo == null) {
                        processCallback.unused(keyAt);
                    } else {
                        processCallback.processDisappeared(keyAt, itemHolderInfo, removeAt.postInfo);
                    }
                } else if ((i & 14) == 14) {
                    processCallback.processAppeared(keyAt, removeAt.preInfo, removeAt.postInfo);
                } else if ((i & 12) == 12) {
                    processCallback.processPersistent(keyAt, removeAt.preInfo, removeAt.postInfo);
                } else if ((i & 4) != 0) {
                    processCallback.processDisappeared(keyAt, removeAt.preInfo, null);
                } else if ((i & 8) != 0) {
                    processCallback.processAppeared(keyAt, removeAt.preInfo, removeAt.postInfo);
                }
                InfoRecord.recycle(removeAt);
            }
        }
    }

    public void removeViewHolder(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, viewHolder) == null) {
            int size = this.mOldChangedHolders.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                } else if (viewHolder == this.mOldChangedHolders.valueAt(size)) {
                    this.mOldChangedHolders.removeAt(size);
                    break;
                } else {
                    size--;
                }
            }
            InfoRecord remove = this.mLayoutHolderMap.remove(viewHolder);
            if (remove != null) {
                InfoRecord.recycle(remove);
            }
        }
    }
}
