package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BLOB = 5;
    @VisibleForTesting
    public static final int DESIRED_POOL_SIZE = 10;
    public static final int DOUBLE = 3;
    public static final int LONG = 2;
    public static final int NULL = 1;
    @VisibleForTesting
    public static final int POOL_LIMIT = 15;
    public static final int STRING = 4;
    @VisibleForTesting
    public static final TreeMap<Integer, RoomSQLiteQuery> sQueryPool;
    public transient /* synthetic */ FieldHolder $fh;
    @VisibleForTesting
    public int mArgCount;
    public final int[] mBindingTypes;
    @VisibleForTesting
    public final byte[][] mBlobBindings;
    @VisibleForTesting
    public final int mCapacity;
    @VisibleForTesting
    public final double[] mDoubleBindings;
    @VisibleForTesting
    public final long[] mLongBindings;
    public volatile String mQuery;
    @VisibleForTesting
    public final String[] mStringBindings;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1646101356, "Landroidx/room/RoomSQLiteQuery;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1646101356, "Landroidx/room/RoomSQLiteQuery;");
                return;
            }
        }
        sQueryPool = new TreeMap<>();
    }

    public RoomSQLiteQuery(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCapacity = i;
        int i4 = i + 1;
        this.mBindingTypes = new int[i4];
        this.mLongBindings = new long[i4];
        this.mDoubleBindings = new double[i4];
        this.mStringBindings = new String[i4];
        this.mBlobBindings = new byte[i4];
    }

    public static RoomSQLiteQuery acquire(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (sQueryPool) {
                Map.Entry<Integer, RoomSQLiteQuery> ceilingEntry = sQueryPool.ceilingEntry(Integer.valueOf(i));
                if (ceilingEntry != null) {
                    sQueryPool.remove(ceilingEntry.getKey());
                    RoomSQLiteQuery value = ceilingEntry.getValue();
                    value.init(str, i);
                    return value;
                }
                RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i);
                roomSQLiteQuery.init(str, i);
                return roomSQLiteQuery;
            }
        }
        return (RoomSQLiteQuery) invokeLI.objValue;
    }

    public static RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, supportSQLiteQuery)) == null) {
            RoomSQLiteQuery acquire = acquire(supportSQLiteQuery.getSql(), supportSQLiteQuery.getArgCount());
            supportSQLiteQuery.bindTo(new SupportSQLiteProgram(acquire) { // from class: androidx.room.RoomSQLiteQuery.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RoomSQLiteQuery val$query;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {acquire};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$query = acquire;
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindBlob(int i, byte[] bArr) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, bArr) == null) {
                        this.val$query.bindBlob(i, bArr);
                    }
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindDouble(int i, double d) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Double.valueOf(d)}) == null) {
                        this.val$query.bindDouble(i, d);
                    }
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindLong(int i, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
                        this.val$query.bindLong(i, j);
                    }
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindNull(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048579, this, i) == null) {
                        this.val$query.bindNull(i);
                    }
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindString(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048580, this, i, str) == null) {
                        this.val$query.bindString(i, str);
                    }
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void clearBindings() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                        this.val$query.clearBindings();
                    }
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                    }
                }
            });
            return acquire;
        }
        return (RoomSQLiteQuery) invokeL.objValue;
    }

    public static void prunePoolLocked() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || sQueryPool.size() <= 15) {
            return;
        }
        int size = sQueryPool.size() - 10;
        Iterator<Integer> it = sQueryPool.descendingKeySet().iterator();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            it.next();
            it.remove();
            size = i;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, bArr) == null) {
            this.mBindingTypes[i] = 5;
            this.mBlobBindings[i] = bArr;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i, double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Double.valueOf(d)}) == null) {
            this.mBindingTypes[i] = 3;
            this.mDoubleBindings[i] = d;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            this.mBindingTypes[i] = 2;
            this.mLongBindings[i] = j;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.mBindingTypes[i] = 1;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
            this.mBindingTypes[i] = 4;
            this.mStringBindings[i] = str;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, supportSQLiteProgram) == null) {
            for (int i = 1; i <= this.mArgCount; i++) {
                int i2 = this.mBindingTypes[i];
                if (i2 == 1) {
                    supportSQLiteProgram.bindNull(i);
                } else if (i2 == 2) {
                    supportSQLiteProgram.bindLong(i, this.mLongBindings[i]);
                } else if (i2 == 3) {
                    supportSQLiteProgram.bindDouble(i, this.mDoubleBindings[i]);
                } else if (i2 == 4) {
                    supportSQLiteProgram.bindString(i, this.mStringBindings[i]);
                } else if (i2 == 5) {
                    supportSQLiteProgram.bindBlob(i, this.mBlobBindings[i]);
                }
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Arrays.fill(this.mBindingTypes, 1);
            Arrays.fill(this.mStringBindings, (Object) null);
            Arrays.fill(this.mBlobBindings, (Object) null);
            this.mQuery = null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public void copyArgumentsFrom(RoomSQLiteQuery roomSQLiteQuery) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, roomSQLiteQuery) == null) {
            int argCount = roomSQLiteQuery.getArgCount() + 1;
            System.arraycopy(roomSQLiteQuery.mBindingTypes, 0, this.mBindingTypes, 0, argCount);
            System.arraycopy(roomSQLiteQuery.mLongBindings, 0, this.mLongBindings, 0, argCount);
            System.arraycopy(roomSQLiteQuery.mStringBindings, 0, this.mStringBindings, 0, argCount);
            System.arraycopy(roomSQLiteQuery.mBlobBindings, 0, this.mBlobBindings, 0, argCount);
            System.arraycopy(roomSQLiteQuery.mDoubleBindings, 0, this.mDoubleBindings, 0, argCount);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mArgCount : invokeV.intValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mQuery : (String) invokeV.objValue;
    }

    public void init(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, str, i) == null) {
            this.mQuery = str;
            this.mArgCount = i;
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (sQueryPool) {
                sQueryPool.put(Integer.valueOf(this.mCapacity), this);
                prunePoolLocked();
            }
        }
    }
}
