package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
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
    public static final TreeMap<Integer, RoomSQLiteQuery> sQueryPool = new TreeMap<>();
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

    public RoomSQLiteQuery(int i2) {
        this.mCapacity = i2;
        int i3 = i2 + 1;
        this.mBindingTypes = new int[i3];
        this.mLongBindings = new long[i3];
        this.mDoubleBindings = new double[i3];
        this.mStringBindings = new String[i3];
        this.mBlobBindings = new byte[i3];
    }

    public static RoomSQLiteQuery acquire(String str, int i2) {
        synchronized (sQueryPool) {
            Map.Entry<Integer, RoomSQLiteQuery> ceilingEntry = sQueryPool.ceilingEntry(Integer.valueOf(i2));
            if (ceilingEntry != null) {
                sQueryPool.remove(ceilingEntry.getKey());
                RoomSQLiteQuery value = ceilingEntry.getValue();
                value.init(str, i2);
                return value;
            }
            RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i2);
            roomSQLiteQuery.init(str, i2);
            return roomSQLiteQuery;
        }
    }

    public static RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
        RoomSQLiteQuery acquire = acquire(supportSQLiteQuery.getSql(), supportSQLiteQuery.getArgCount());
        supportSQLiteQuery.bindTo(new SupportSQLiteProgram() { // from class: androidx.room.RoomSQLiteQuery.1
            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindBlob(int i2, byte[] bArr) {
                RoomSQLiteQuery.this.bindBlob(i2, bArr);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindDouble(int i2, double d2) {
                RoomSQLiteQuery.this.bindDouble(i2, d2);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindLong(int i2, long j) {
                RoomSQLiteQuery.this.bindLong(i2, j);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindNull(int i2) {
                RoomSQLiteQuery.this.bindNull(i2);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindString(int i2, String str) {
                RoomSQLiteQuery.this.bindString(i2, str);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void clearBindings() {
                RoomSQLiteQuery.this.clearBindings();
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        });
        return acquire;
    }

    public static void prunePoolLocked() {
        if (sQueryPool.size() <= 15) {
            return;
        }
        int size = sQueryPool.size() - 10;
        Iterator<Integer> it = sQueryPool.descendingKeySet().iterator();
        while (true) {
            int i2 = size - 1;
            if (size <= 0) {
                return;
            }
            it.next();
            it.remove();
            size = i2;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i2, byte[] bArr) {
        this.mBindingTypes[i2] = 5;
        this.mBlobBindings[i2] = bArr;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i2, double d2) {
        this.mBindingTypes[i2] = 3;
        this.mDoubleBindings[i2] = d2;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i2, long j) {
        this.mBindingTypes[i2] = 2;
        this.mLongBindings[i2] = j;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i2) {
        this.mBindingTypes[i2] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i2, String str) {
        this.mBindingTypes[i2] = 4;
        this.mStringBindings[i2] = str;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        for (int i2 = 1; i2 <= this.mArgCount; i2++) {
            int i3 = this.mBindingTypes[i2];
            if (i3 == 1) {
                supportSQLiteProgram.bindNull(i2);
            } else if (i3 == 2) {
                supportSQLiteProgram.bindLong(i2, this.mLongBindings[i2]);
            } else if (i3 == 3) {
                supportSQLiteProgram.bindDouble(i2, this.mDoubleBindings[i2]);
            } else if (i3 == 4) {
                supportSQLiteProgram.bindString(i2, this.mStringBindings[i2]);
            } else if (i3 == 5) {
                supportSQLiteProgram.bindBlob(i2, this.mBlobBindings[i2]);
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        Arrays.fill(this.mBindingTypes, 1);
        Arrays.fill(this.mStringBindings, (Object) null);
        Arrays.fill(this.mBlobBindings, (Object) null);
        this.mQuery = null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public void copyArgumentsFrom(RoomSQLiteQuery roomSQLiteQuery) {
        int argCount = roomSQLiteQuery.getArgCount() + 1;
        System.arraycopy(roomSQLiteQuery.mBindingTypes, 0, this.mBindingTypes, 0, argCount);
        System.arraycopy(roomSQLiteQuery.mLongBindings, 0, this.mLongBindings, 0, argCount);
        System.arraycopy(roomSQLiteQuery.mStringBindings, 0, this.mStringBindings, 0, argCount);
        System.arraycopy(roomSQLiteQuery.mBlobBindings, 0, this.mBlobBindings, 0, argCount);
        System.arraycopy(roomSQLiteQuery.mDoubleBindings, 0, this.mDoubleBindings, 0, argCount);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        return this.mArgCount;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.mQuery;
    }

    public void init(String str, int i2) {
        this.mQuery = str;
        this.mArgCount = i2;
    }

    public void release() {
        synchronized (sQueryPool) {
            sQueryPool.put(Integer.valueOf(this.mCapacity), this);
            prunePoolLocked();
        }
    }
}
