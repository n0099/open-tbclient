package com.baidu.mapapi;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import cn.jingling.lib.file.Shared;
import com.baidu.mapapi.Overlay;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class ItemizedOverlay extends Overlay implements Overlay.Snappable {
    private static int d = -1;
    private Drawable b;
    private Drawable c;
    private boolean a = true;
    private a e = null;
    private OnFocusChangeListener f = null;
    private int g = -1;
    private int h = -1;

    /* loaded from: classes.dex */
    public interface OnFocusChangeListener {
        void onFocusChanged(ItemizedOverlay itemizedOverlay, OverlayItem overlayItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Comparator {
        private ArrayList b;
        private ArrayList c;
        private ItemizedOverlay d;

        public a() {
            this.d = ItemizedOverlay.this;
            int size = ItemizedOverlay.this.size();
            this.b = new ArrayList(size);
            this.c = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                this.c.add(Integer.valueOf(i));
                this.b.add(ItemizedOverlay.this.createItem(i));
            }
            Collections.sort(this.c, this);
        }

        private Point a(OverlayItem overlayItem, Projection projection, Point point) {
            Point pixels = projection.toPixels(overlayItem.getPoint(), null);
            return new Point(point.x - pixels.x, point.y - pixels.y);
        }

        public final int a() {
            return this.b.size();
        }

        public final int a(OverlayItem overlayItem) {
            if (overlayItem != null) {
                for (int i = 0; i < this.b.size(); i++) {
                    if (overlayItem.equals(this.b.get(i))) {
                        return i;
                    }
                }
                return -1;
            }
            return -1;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Integer num, Integer num2) {
            GeoPoint point = ((OverlayItem) this.b.get(num.intValue())).getPoint();
            GeoPoint point2 = ((OverlayItem) this.b.get(num2.intValue())).getPoint();
            if (point.getLatitudeE6() > point2.getLatitudeE6()) {
                return -1;
            }
            if (point.getLatitudeE6() >= point2.getLatitudeE6()) {
                if (point.getLongitudeE6() < point2.getLongitudeE6()) {
                    return -1;
                }
                return point.getLongitudeE6() == point2.getLongitudeE6() ? 0 : 1;
            }
            return 1;
        }

        public final int a(boolean z) {
            if (this.b.size() == 0) {
                return 0;
            }
            int i = Shared.INFINITY;
            Iterator it = this.b.iterator();
            int i2 = Integer.MIN_VALUE;
            while (true) {
                int i3 = i;
                if (!it.hasNext()) {
                    return i2 - i3;
                }
                GeoPoint point = ((OverlayItem) it.next()).getPoint();
                i = z ? point.getLatitudeE6() : point.getLongitudeE6();
                if (i > i2) {
                    i2 = i;
                }
                if (i >= i3) {
                    i = i3;
                }
            }
        }

        public final OverlayItem a(int i) {
            return (OverlayItem) this.b.get(i);
        }

        public final boolean a(GeoPoint geoPoint, MapView mapView) {
            int i;
            Projection projection = mapView.getProjection();
            Point pixels = projection.toPixels(geoPoint, null);
            int size = this.b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                OverlayItem overlayItem = (OverlayItem) this.b.get(i2);
                Point a = a(overlayItem, projection, pixels);
                Drawable drawable = overlayItem.mMarker;
                if (drawable == null) {
                    drawable = ItemizedOverlay.a(this.d);
                }
                double d = this.d.hitTest(overlayItem, drawable, a.x, a.y) ? (a.x * a.x) + (a.y * a.y) : -1.0d;
                if (d >= 0.0d && d < Double.MAX_VALUE) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (-1 != i) {
                return this.d.onTap(i);
            }
            this.d.setFocus(null);
            return false;
        }

        public final int b(int i) {
            return ((Integer) this.c.get(i)).intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum b {
        Normal("Normal", 0),
        Center("Center", 1),
        CenterBottom("CenterBottom", 2);

        b(String str, int i) {
        }
    }

    public ItemizedOverlay(Drawable drawable) {
        this.b = drawable;
        if (this.b != null) {
            this.c = new r().a(this.b);
            if (d == 0) {
                a(this.b, b.CenterBottom);
            }
        }
    }

    private static Drawable a(Drawable drawable, b bVar) {
        int i = 0;
        if (drawable == null || b.Normal == bVar) {
            return null;
        }
        Rect bounds = drawable.getBounds();
        if (bounds.height() == 0 || bounds.width() == 0) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        Rect bounds2 = drawable.getBounds();
        int width = bounds2.width() / 2;
        int i2 = -bounds2.height();
        if (bVar == b.Center) {
            i2 /= 2;
            i = -i2;
        }
        drawable.setBounds(-width, i2, width, i);
        return drawable;
    }

    static Drawable a(ItemizedOverlay itemizedOverlay) {
        return itemizedOverlay.b;
    }

    private void a(Canvas canvas, MapView mapView, boolean z, OverlayItem overlayItem, int i) {
        Drawable marker = overlayItem.getMarker(i);
        if (marker == null && this.b == null) {
            return;
        }
        boolean equals = marker != null ? this.b == null ? false : marker.equals(this.b) : true;
        if (equals) {
            if (z) {
                marker = this.c;
                this.c.setBounds(this.b.copyBounds());
                r.a(this.c, this.b);
            } else {
                marker = this.b;
            }
        }
        Point pixels = mapView.getProjection().toPixels(overlayItem.getPoint(), null);
        if (equals) {
            Overlay.a(canvas, marker, pixels.x, pixels.y);
        } else {
            Overlay.drawAt(canvas, marker, pixels.x, pixels.y, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Drawable boundCenter(Drawable drawable) {
        d = 2;
        return a(drawable, b.Center);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Drawable boundCenterBottom(Drawable drawable) {
        d = 1;
        return a(drawable, b.CenterBottom);
    }

    protected abstract OverlayItem createItem(int i);

    @Override // com.baidu.mapapi.Overlay
    public void draw(Canvas canvas, MapView mapView, boolean z) {
        OverlayItem focus;
        if (this.e != null) {
            int a2 = this.e.a();
            for (int i = 0; i < a2; i++) {
                int indexToDraw = getIndexToDraw(i);
                if (indexToDraw != this.h) {
                    OverlayItem item = getItem(indexToDraw);
                    Point pixels = mapView.getProjection().toPixels(item.getPoint(), null);
                    int left = mapView.getLeft();
                    int right = mapView.getRight();
                    int top = mapView.getTop();
                    int bottom = mapView.getBottom();
                    pixels.x += left;
                    pixels.y += top;
                    if (pixels.x >= left && pixels.y >= top && pixels.x <= right && pixels.y <= bottom) {
                        a(canvas, mapView, z, item, 0);
                    }
                }
            }
        }
        if (!this.a || (focus = getFocus()) == null) {
            return;
        }
        a(canvas, mapView, false, focus, 4);
    }

    public GeoPoint getCenter() {
        return getItem(getIndexToDraw(0)).getPoint();
    }

    public OverlayItem getFocus() {
        if (this.h != -1) {
            return this.e.a(this.h);
        }
        return null;
    }

    protected int getIndexToDraw(int i) {
        return this.e.b(i);
    }

    public final OverlayItem getItem(int i) {
        return this.e.a(i);
    }

    public final int getLastFocusedIndex() {
        return this.g;
    }

    public int getLatSpanE6() {
        return this.e.a(true);
    }

    public int getLonSpanE6() {
        return this.e.a(false);
    }

    protected boolean hitTest(OverlayItem overlayItem, Drawable drawable, int i, int i2) {
        Rect bounds = drawable.getBounds();
        bounds.left -= 10;
        bounds.right += 10;
        bounds.bottom += 10;
        bounds.top -= 10;
        boolean contains = bounds.contains(i, i2);
        bounds.left += 10;
        bounds.right -= 10;
        bounds.bottom -= 10;
        bounds.top = 10 + bounds.top;
        return contains;
    }

    public OverlayItem nextFocus(boolean z) {
        if (this.e.a() == 0) {
            return null;
        }
        if (this.g == -1) {
            if (this.h != -1) {
                return this.e.a(0);
            }
            return null;
        }
        int i = this.h != -1 ? this.h : this.g;
        if (z) {
            if (i != this.e.a() - 1) {
                return this.e.a(i + 1);
            }
            return null;
        } else if (i != 0) {
            return this.e.a(i - 1);
        } else {
            return null;
        }
    }

    @Override // com.baidu.mapapi.Overlay
    public boolean onKeyUp(int i, KeyEvent keyEvent, MapView mapView) {
        return false;
    }

    @Override // com.baidu.mapapi.Overlay.Snappable
    public boolean onSnapToItem(int i, int i2, Point point, MapView mapView) {
        if (this.e.a() > 0) {
            Point point2 = new Point();
            OverlayItem a2 = this.e.a(0);
            mapView.getProjection().toPixels(a2.getPoint(), point2);
            if (hitTest(a2, a2.mMarker, i - point2.x, i2 - point2.y)) {
                point.x = point2.x;
                point.y = point2.y;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onTap(int i) {
        if (i != this.h) {
            setFocus(getItem(i));
            return false;
        }
        return false;
    }

    @Override // com.baidu.mapapi.Overlay
    public boolean onTap(GeoPoint geoPoint, MapView mapView) {
        if (this.e != null) {
            return this.e.a(geoPoint, mapView);
        }
        return false;
    }

    @Override // com.baidu.mapapi.Overlay
    public boolean onTouchEvent(MotionEvent motionEvent, MapView mapView) {
        return false;
    }

    @Override // com.baidu.mapapi.Overlay
    public boolean onTrackballEvent(MotionEvent motionEvent, MapView mapView) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void populate() {
        this.e = new a();
        this.g = -1;
        this.h = -1;
    }

    public void setDrawFocusedItem(boolean z) {
        this.a = z;
    }

    public void setFocus(OverlayItem overlayItem) {
        if (overlayItem == null || this.h != this.e.a(overlayItem)) {
            if (overlayItem == null && this.h != -1) {
                if (this.f != null) {
                    this.f.onFocusChanged(this, overlayItem);
                }
                this.h = -1;
                return;
            }
            this.h = this.e.a(overlayItem);
            if (this.h != -1) {
                setLastFocusedIndex(this.h);
                if (this.f != null) {
                    this.f.onFocusChanged(this, overlayItem);
                }
            }
        }
    }

    protected void setLastFocusedIndex(int i) {
        this.g = i;
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f = onFocusChangeListener;
    }

    public abstract int size();
}
