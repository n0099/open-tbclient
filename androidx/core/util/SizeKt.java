package androidx.core.util;

import android.util.Size;
import android.util.SizeF;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0005*\u00020\u0004H\u0087\n¢\u0006\u0004\b\u0002\u0010\u0006\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0014\u0010\u0007\u001a\u00020\u0005*\u00020\u0004H\u0087\n¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Landroid/util/Size;", "", "component1", "(Landroid/util/Size;)I", "Landroid/util/SizeF;", "", "(Landroid/util/SizeF;)F", "component2", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class SizeKt {
    @RequiresApi(21)
    public static final int component1(Size size) {
        return size.getWidth();
    }

    @RequiresApi(21)
    public static final int component2(Size size) {
        return size.getHeight();
    }

    @RequiresApi(21)
    public static final float component1(SizeF sizeF) {
        return sizeF.getWidth();
    }

    @RequiresApi(21)
    public static final float component2(SizeF sizeF) {
        return sizeF.getHeight();
    }
}
