package androidx.core.util;

import android.util.SparseLongArray;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001c\u0010\t\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0087\b¢\u0006\u0004\b\t\u0010\n\u001aL\u0010\u0010\u001a\u00020\u000e*\u00020\u000026\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0087\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a$\u0010\u0013\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0007H\u0087\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a*\u0010\u0016\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015H\u0087\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0014\u0010\u001a\u001a\u00020\u0003*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u001a\u0010\u0019\u001a\u0013\u0010\u001c\u001a\u00020\u001b*\u00020\u0000H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u001f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u001f\u0010 \u001a\u001b\u0010!\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H\u0007¢\u0006\u0004\b!\u0010\"\u001a#\u0010#\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b#\u0010$\u001a$\u0010%\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\b%\u0010&\u001a\u0013\u0010(\u001a\u00020'*\u00020\u0000H\u0007¢\u0006\u0004\b(\u0010)\"\u0018\u0010,\u001a\u00020\u0001*\u00020\u00008Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"Landroid/util/SparseLongArray;", "", "key", "", "contains", "(Landroid/util/SparseLongArray;I)Z", "containsKey", "", "value", "containsValue", "(Landroid/util/SparseLongArray;J)Z", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "action", "forEach", "(Landroid/util/SparseLongArray;Lkotlin/Function2;)V", "defaultValue", "getOrDefault", "(Landroid/util/SparseLongArray;IJ)J", "Lkotlin/Function0;", "getOrElse", "(Landroid/util/SparseLongArray;ILkotlin/Function0;)J", "isEmpty", "(Landroid/util/SparseLongArray;)Z", "isNotEmpty", "Lkotlin/collections/IntIterator;", "keyIterator", "(Landroid/util/SparseLongArray;)Lkotlin/collections/IntIterator;", "other", "plus", "(Landroid/util/SparseLongArray;Landroid/util/SparseLongArray;)Landroid/util/SparseLongArray;", "putAll", "(Landroid/util/SparseLongArray;Landroid/util/SparseLongArray;)V", "remove", "(Landroid/util/SparseLongArray;IJ)Z", "set", "(Landroid/util/SparseLongArray;IJ)V", "Lkotlin/collections/LongIterator;", "valueIterator", "(Landroid/util/SparseLongArray;)Lkotlin/collections/LongIterator;", "getSize", "(Landroid/util/SparseLongArray;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class SparseLongArrayKt {
    @RequiresApi(18)
    public static final boolean contains(SparseLongArray sparseLongArray, int i2) {
        return sparseLongArray.indexOfKey(i2) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsKey(SparseLongArray sparseLongArray, int i2) {
        return sparseLongArray.indexOfKey(i2) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsValue(SparseLongArray sparseLongArray, long j) {
        return sparseLongArray.indexOfValue(j) >= 0;
    }

    @RequiresApi(18)
    public static final void forEach(SparseLongArray sparseLongArray, Function2<? super Integer, ? super Long, Unit> function2) {
        int size = sparseLongArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            function2.invoke(Integer.valueOf(sparseLongArray.keyAt(i2)), Long.valueOf(sparseLongArray.valueAt(i2)));
        }
    }

    @RequiresApi(18)
    public static final long getOrDefault(SparseLongArray sparseLongArray, int i2, long j) {
        return sparseLongArray.get(i2, j);
    }

    @RequiresApi(18)
    public static final long getOrElse(SparseLongArray sparseLongArray, int i2, Function0<Long> function0) {
        int indexOfKey = sparseLongArray.indexOfKey(i2);
        return indexOfKey >= 0 ? sparseLongArray.valueAt(indexOfKey) : function0.invoke().longValue();
    }

    @RequiresApi(18)
    public static final int getSize(SparseLongArray sparseLongArray) {
        return sparseLongArray.size();
    }

    @RequiresApi(18)
    public static final boolean isEmpty(SparseLongArray sparseLongArray) {
        return sparseLongArray.size() == 0;
    }

    @RequiresApi(18)
    public static final boolean isNotEmpty(SparseLongArray sparseLongArray) {
        return sparseLongArray.size() != 0;
    }

    @RequiresApi(18)
    public static final IntIterator keyIterator(final SparseLongArray sparseLongArray) {
        return new IntIterator() { // from class: androidx.core.util.SparseLongArrayKt$keyIterator$1
            public int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // kotlin.collections.IntIterator
            public int nextInt() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseLongArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    @RequiresApi(18)
    public static final SparseLongArray plus(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        SparseLongArray sparseLongArray3 = new SparseLongArray(sparseLongArray.size() + sparseLongArray2.size());
        putAll(sparseLongArray3, sparseLongArray);
        putAll(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    @RequiresApi(18)
    public static final void putAll(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        int size = sparseLongArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseLongArray.put(sparseLongArray2.keyAt(i2), sparseLongArray2.valueAt(i2));
        }
    }

    @RequiresApi(18)
    public static final boolean remove(SparseLongArray sparseLongArray, int i2, long j) {
        int indexOfKey = sparseLongArray.indexOfKey(i2);
        if (indexOfKey < 0 || j != sparseLongArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(indexOfKey);
        return true;
    }

    @RequiresApi(18)
    public static final void set(SparseLongArray sparseLongArray, int i2, long j) {
        sparseLongArray.put(i2, j);
    }

    @RequiresApi(18)
    public static final LongIterator valueIterator(final SparseLongArray sparseLongArray) {
        return new LongIterator() { // from class: androidx.core.util.SparseLongArrayKt$valueIterator$1
            public int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // kotlin.collections.LongIterator
            public long nextLong() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseLongArray2.valueAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }
}
