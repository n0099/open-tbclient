package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import com.baidu.mapsdkplatform.comapi.map.r;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001c\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001c\u0010\u0002\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\f¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0007\u0010\b\u001a\u0014\u0010\u0007\u001a\u00020\t*\u00020\u0004H\u0086\n¢\u0006\u0004\b\u0007\u0010\n\u001a\u0014\u0010\u000b\u001a\u00020\u0006*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u000b\u0010\b\u001a\u0014\u0010\u000b\u001a\u00020\t*\u00020\u0004H\u0086\n¢\u0006\u0004\b\u000b\u0010\n\u001a\u0014\u0010\f\u001a\u00020\u0006*\u00020\u0000H\u0086\n¢\u0006\u0004\b\f\u0010\b\u001a\u0014\u0010\f\u001a\u00020\t*\u00020\u0004H\u0086\n¢\u0006\u0004\b\f\u0010\n\u001a\u0014\u0010\r\u001a\u00020\u0006*\u00020\u0000H\u0086\n¢\u0006\u0004\b\r\u0010\b\u001a\u0014\u0010\r\u001a\u00020\t*\u00020\u0004H\u0086\n¢\u0006\u0004\b\r\u0010\n\u001a\u001c\u0010\u0011\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0086\n¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001c\u0010\u0011\u001a\u00020\u0010*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0013H\u0086\n¢\u0006\u0004\b\u0011\u0010\u0014\u001a\u001c\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u000eH\u0086\n¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001c\u0010\u0016\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0016\u0010\u0019\u001a\u001c\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006H\u0086\n¢\u0006\u0004\b\u0016\u0010\u001a\u001a\u001c\u0010\u0016\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0013H\u0086\n¢\u0006\u0004\b\u0016\u0010\u001b\u001a\u001c\u0010\u0016\u001a\u00020\u0018*\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\n¢\u0006\u0004\b\u0016\u0010\u001c\u001a\u001c\u0010\u0016\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0015\u001a\u00020\tH\u0086\n¢\u0006\u0004\b\u0016\u0010\u001d\u001a\u001c\u0010\u001e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\f¢\u0006\u0004\b\u001e\u0010\u0003\u001a\u001c\u0010\u001e\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\f¢\u0006\u0004\b\u001e\u0010\u0005\u001a\u001c\u0010\u001f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u000eH\u0086\n¢\u0006\u0004\b\u001f\u0010\u0017\u001a\u001c\u0010\u001f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u001f\u0010\u0003\u001a\u001c\u0010\u001f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006H\u0086\n¢\u0006\u0004\b\u001f\u0010\u001a\u001a\u001c\u0010\u001f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0013H\u0086\n¢\u0006\u0004\b\u001f\u0010\u001b\u001a\u001c\u0010\u001f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\n¢\u0006\u0004\b\u001f\u0010\u0005\u001a\u001c\u0010\u001f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0015\u001a\u00020\tH\u0086\n¢\u0006\u0004\b\u001f\u0010\u001d\u001a\u001c\u0010!\u001a\u00020\u0000*\u00020\u00002\u0006\u0010 \u001a\u00020\u0006H\u0086\n¢\u0006\u0004\b!\u0010\u001a\u001a\u001c\u0010!\u001a\u00020\u0004*\u00020\u00042\u0006\u0010 \u001a\u00020\tH\u0086\n¢\u0006\u0004\b!\u0010\u001d\u001a\u001c\u0010!\u001a\u00020\u0004*\u00020\u00042\u0006\u0010 \u001a\u00020\u0006H\u0086\n¢\u0006\u0004\b!\u0010\"\u001a\u0014\u0010#\u001a\u00020\u0000*\u00020\u0004H\u0086\b¢\u0006\u0004\b#\u0010$\u001a\u0014\u0010%\u001a\u00020\u0004*\u00020\u0000H\u0086\b¢\u0006\u0004\b%\u0010&\u001a\u0014\u0010'\u001a\u00020\u0018*\u00020\u0000H\u0086\b¢\u0006\u0004\b'\u0010(\u001a\u0014\u0010'\u001a\u00020\u0018*\u00020\u0004H\u0086\b¢\u0006\u0004\b'\u0010)\u001a\u001c\u0010,\u001a\u00020\u0004*\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0086\b¢\u0006\u0004\b,\u0010-\u001a\u001c\u0010.\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\f¢\u0006\u0004\b.\u0010\u0019\u001a\u001c\u0010.\u001a\u00020\u0018*\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\f¢\u0006\u0004\b.\u0010\u001c¨\u0006/"}, d2 = {"Landroid/graphics/Rect;", r.f7772a, "and", "(Landroid/graphics/Rect;Landroid/graphics/Rect;)Landroid/graphics/Rect;", "Landroid/graphics/RectF;", "(Landroid/graphics/RectF;Landroid/graphics/RectF;)Landroid/graphics/RectF;", "", "component1", "(Landroid/graphics/Rect;)I", "", "(Landroid/graphics/RectF;)F", "component2", "component3", "component4", "Landroid/graphics/Point;", "p", "", "contains", "(Landroid/graphics/Rect;Landroid/graphics/Point;)Z", "Landroid/graphics/PointF;", "(Landroid/graphics/RectF;Landroid/graphics/PointF;)Z", "xy", "minus", "(Landroid/graphics/Rect;Landroid/graphics/Point;)Landroid/graphics/Rect;", "Landroid/graphics/Region;", "(Landroid/graphics/Rect;Landroid/graphics/Rect;)Landroid/graphics/Region;", "(Landroid/graphics/Rect;I)Landroid/graphics/Rect;", "(Landroid/graphics/RectF;Landroid/graphics/PointF;)Landroid/graphics/RectF;", "(Landroid/graphics/RectF;Landroid/graphics/RectF;)Landroid/graphics/Region;", "(Landroid/graphics/RectF;F)Landroid/graphics/RectF;", "or", "plus", "factor", "times", "(Landroid/graphics/RectF;I)Landroid/graphics/RectF;", "toRect", "(Landroid/graphics/RectF;)Landroid/graphics/Rect;", "toRectF", "(Landroid/graphics/Rect;)Landroid/graphics/RectF;", "toRegion", "(Landroid/graphics/Rect;)Landroid/graphics/Region;", "(Landroid/graphics/RectF;)Landroid/graphics/Region;", "Landroid/graphics/Matrix;", "m", "transform", "(Landroid/graphics/RectF;Landroid/graphics/Matrix;)Landroid/graphics/RectF;", "xor", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class RectKt {
    @SuppressLint({"CheckResult"})
    public static final Rect and(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        return rect3;
    }

    public static final int component1(Rect rect) {
        return rect.left;
    }

    public static final int component2(Rect rect) {
        return rect.top;
    }

    public static final int component3(Rect rect) {
        return rect.right;
    }

    public static final int component4(Rect rect) {
        return rect.bottom;
    }

    public static final boolean contains(Rect rect, Point point) {
        return rect.contains(point.x, point.y);
    }

    public static final Region minus(Rect rect, Rect rect2) {
        Region region = new Region(rect);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    public static final Rect or(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    public static final Rect plus(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    public static final Rect times(Rect rect, int i2) {
        Rect rect2 = new Rect(rect);
        rect2.top *= i2;
        rect2.left *= i2;
        rect2.right *= i2;
        rect2.bottom *= i2;
        return rect2;
    }

    public static final Rect toRect(RectF rectF) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return rect;
    }

    public static final RectF toRectF(Rect rect) {
        return new RectF(rect);
    }

    public static final Region toRegion(Rect rect) {
        return new Region(rect);
    }

    public static final RectF transform(RectF rectF, Matrix matrix) {
        matrix.mapRect(rectF);
        return rectF;
    }

    public static final Region xor(Rect rect, Rect rect2) {
        Region region = new Region(rect);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    public static final float component1(RectF rectF) {
        return rectF.left;
    }

    public static final float component2(RectF rectF) {
        return rectF.top;
    }

    public static final float component3(RectF rectF) {
        return rectF.right;
    }

    public static final float component4(RectF rectF) {
        return rectF.bottom;
    }

    public static final boolean contains(RectF rectF, PointF pointF) {
        return rectF.contains(pointF.x, pointF.y);
    }

    public static final Region toRegion(RectF rectF) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return new Region(rect);
    }

    @SuppressLint({"CheckResult"})
    public static final RectF and(RectF rectF, RectF rectF2) {
        RectF rectF3 = new RectF(rectF);
        rectF3.intersect(rectF2);
        return rectF3;
    }

    public static final Rect minus(Rect rect, int i2) {
        Rect rect2 = new Rect(rect);
        int i3 = -i2;
        rect2.offset(i3, i3);
        return rect2;
    }

    public static final RectF or(RectF rectF, RectF rectF2) {
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    public static final RectF plus(RectF rectF, RectF rectF2) {
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    public static final Region xor(RectF rectF, RectF rectF2) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    public static final RectF minus(RectF rectF, float f2) {
        RectF rectF2 = new RectF(rectF);
        float f3 = -f2;
        rectF2.offset(f3, f3);
        return rectF2;
    }

    public static final Rect plus(Rect rect, int i2) {
        Rect rect2 = new Rect(rect);
        rect2.offset(i2, i2);
        return rect2;
    }

    public static final RectF times(RectF rectF, float f2) {
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f2;
        rectF2.left *= f2;
        rectF2.right *= f2;
        rectF2.bottom *= f2;
        return rectF2;
    }

    public static final Rect minus(Rect rect, Point point) {
        Rect rect2 = new Rect(rect);
        rect2.offset(-point.x, -point.y);
        return rect2;
    }

    public static final RectF plus(RectF rectF, float f2) {
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(f2, f2);
        return rectF2;
    }

    public static final RectF minus(RectF rectF, PointF pointF) {
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(-pointF.x, -pointF.y);
        return rectF2;
    }

    public static final Rect plus(Rect rect, Point point) {
        Rect rect2 = new Rect(rect);
        rect2.offset(point.x, point.y);
        return rect2;
    }

    public static final Region minus(RectF rectF, RectF rectF2) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    public static final RectF plus(RectF rectF, PointF pointF) {
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(pointF.x, pointF.y);
        return rectF2;
    }

    public static final RectF times(RectF rectF, int i2) {
        float f2 = i2;
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f2;
        rectF2.left *= f2;
        rectF2.right *= f2;
        rectF2.bottom *= f2;
        return rectF2;
    }
}
