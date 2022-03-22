package androidx.recyclerview.widget;

import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
/* loaded from: classes.dex */
public class TileList<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Tile<T> mLastAccessedTile;
    public final int mTileSize;
    public final SparseArray<Tile<T>> mTiles;

    /* loaded from: classes.dex */
    public static class Tile<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mItemCount;
        public final T[] mItems;
        public Tile<T> mNext;
        public int mStartPosition;

        public Tile(Class<T> cls, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mItems = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
        }

        public boolean containsPosition(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                int i2 = this.mStartPosition;
                return i2 <= i && i < i2 + this.mItemCount;
            }
            return invokeI.booleanValue;
        }

        public T getByPosition(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? this.mItems[i - this.mStartPosition] : (T) invokeI.objValue;
        }
    }

    public TileList(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTiles = new SparseArray<>(10);
        this.mTileSize = i;
    }

    public Tile<T> addOrReplace(Tile<T> tile) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tile)) == null) {
            int indexOfKey = this.mTiles.indexOfKey(tile.mStartPosition);
            if (indexOfKey < 0) {
                this.mTiles.put(tile.mStartPosition, tile);
                return null;
            }
            Tile<T> valueAt = this.mTiles.valueAt(indexOfKey);
            this.mTiles.setValueAt(indexOfKey, tile);
            if (this.mLastAccessedTile == valueAt) {
                this.mLastAccessedTile = tile;
            }
            return valueAt;
        }
        return (Tile) invokeL.objValue;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mTiles.clear();
        }
    }

    public Tile<T> getAtIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? this.mTiles.valueAt(i) : (Tile) invokeI.objValue;
    }

    public T getItemAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            Tile<T> tile = this.mLastAccessedTile;
            if (tile == null || !tile.containsPosition(i)) {
                int indexOfKey = this.mTiles.indexOfKey(i - (i % this.mTileSize));
                if (indexOfKey < 0) {
                    return null;
                }
                this.mLastAccessedTile = this.mTiles.valueAt(indexOfKey);
            }
            return this.mLastAccessedTile.getByPosition(i);
        }
        return (T) invokeI.objValue;
    }

    public Tile<T> removeAtPos(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            Tile<T> tile = this.mTiles.get(i);
            if (this.mLastAccessedTile == tile) {
                this.mLastAccessedTile = null;
            }
            this.mTiles.delete(i);
            return tile;
        }
        return (Tile) invokeI.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mTiles.size() : invokeV.intValue;
    }
}
