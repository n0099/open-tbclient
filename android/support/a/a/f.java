package android.support.a.a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.support.a.a.c;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.apache.http.cookie.ClientCookie;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
@TargetApi(21)
/* loaded from: classes2.dex */
public class f extends android.support.a.a.e {
    static final PorterDuff.Mode tq = PorterDuff.Mode.SRC_IN;
    private final Matrix tA;
    private final Rect tB;
    private C0001f tr;
    private PorterDuffColorFilter ts;
    private ColorFilter tt;
    private boolean tu;

    /* renamed from: tv  reason: collision with root package name */
    private boolean f0tv;
    private Drawable.ConstantState tw;
    private final float[] tz;

    @Override // android.support.a.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.support.a.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.support.a.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    @Override // android.support.a.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.support.a.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // android.support.a.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.support.a.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // android.support.a.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // android.support.a.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.support.a.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.support.a.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // android.support.a.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // android.support.a.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // android.support.a.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    @Override // android.support.a.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // android.support.a.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    f() {
        this.f0tv = true;
        this.tz = new float[9];
        this.tA = new Matrix();
        this.tB = new Rect();
        this.tr = new C0001f();
    }

    f(C0001f c0001f) {
        this.f0tv = true;
        this.tz = new float[9];
        this.tA = new Matrix();
        this.tB = new Rect();
        this.tr = c0001f;
        this.ts = a(this.ts, c0001f.um, c0001f.uo);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.tp != null) {
            this.tp.mutate();
        } else if (!this.tu && super.mutate() == this) {
            this.tr = new C0001f(this.tr);
            this.tu = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object x(String str) {
        return this.tr.ul.uk.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.tp != null) {
            return new g(this.tp.getConstantState());
        }
        this.tr.tf = getChangingConfigurations();
        return this.tr;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.tp != null) {
            this.tp.draw(canvas);
            return;
        }
        copyBounds(this.tB);
        if (this.tB.width() > 0 && this.tB.height() > 0) {
            ColorFilter colorFilter = this.tt == null ? this.ts : this.tt;
            canvas.getMatrix(this.tA);
            this.tA.getValues(this.tz);
            float abs = Math.abs(this.tz[0]);
            float abs2 = Math.abs(this.tz[4]);
            float abs3 = Math.abs(this.tz[1]);
            float abs4 = Math.abs(this.tz[3]);
            if (abs3 != 0.0f || abs4 != 0.0f) {
                abs2 = 1.0f;
                abs = 1.0f;
            }
            int min = Math.min(2048, (int) (abs * this.tB.width()));
            int min2 = Math.min(2048, (int) (abs2 * this.tB.height()));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                canvas.translate(this.tB.left, this.tB.top);
                if (cN()) {
                    canvas.translate(this.tB.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.tB.offsetTo(0, 0);
                this.tr.s(min, min2);
                if (!this.f0tv) {
                    this.tr.r(min, min2);
                } else if (!this.tr.cT()) {
                    this.tr.r(min, min2);
                    this.tr.cU();
                }
                this.tr.a(canvas, colorFilter, this.tB);
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.tp != null ? DrawableCompat.getAlpha(this.tp) : this.tr.ul.cR();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.tp != null) {
            this.tp.setAlpha(i);
        } else if (this.tr.ul.cR() != i) {
            this.tr.ul.R(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.tp != null) {
            this.tp.setColorFilter(colorFilter);
            return;
        }
        this.tt = colorFilter;
        invalidateSelf();
    }

    PorterDuffColorFilter a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        if (this.tp != null) {
            DrawableCompat.setTint(this.tp, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.tp != null) {
            DrawableCompat.setTintList(this.tp, colorStateList);
            return;
        }
        C0001f c0001f = this.tr;
        if (c0001f.um != colorStateList) {
            c0001f.um = colorStateList;
            this.ts = a(this.ts, colorStateList, c0001f.uo);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.tp != null) {
            DrawableCompat.setTintMode(this.tp, mode);
            return;
        }
        C0001f c0001f = this.tr;
        if (c0001f.uo != mode) {
            c0001f.uo = mode;
            this.ts = a(this.ts, c0001f.um, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (this.tp != null) {
            return this.tp.isStateful();
        }
        return super.isStateful() || !(this.tr == null || this.tr.um == null || !this.tr.um.isStateful());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.tp != null) {
            return this.tp.setState(iArr);
        }
        C0001f c0001f = this.tr;
        if (c0001f.um != null && c0001f.uo != null) {
            this.ts = a(this.ts, c0001f.um, c0001f.uo);
            invalidateSelf();
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.tp != null) {
            return this.tp.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.tp != null ? this.tp.getIntrinsicWidth() : (int) this.tr.ul.ue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.tp != null ? this.tp.getIntrinsicHeight() : (int) this.tr.ul.uf;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.tp != null) {
            DrawableCompat.canApplyTheme(this.tp);
            return false;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.tp != null ? DrawableCompat.isAutoMirrored(this.tp) : this.tr.uq;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.tp != null) {
            DrawableCompat.setAutoMirrored(this.tp, z);
        } else {
            this.tr.uq = z;
        }
    }

    public static f a(Resources resources, int i, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            f fVar = new f();
            fVar.tp = ResourcesCompat.getDrawable(resources, i, theme);
            fVar.tw = new g(fVar.tp.getConstantState());
            return fVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            return a(resources, xml, asAttributeSet, theme);
        } catch (IOException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        } catch (XmlPullParserException e3) {
            Log.e("VectorDrawableCompat", "parser error", e3);
            return null;
        }
    }

    public static f a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        f fVar = new f();
        fVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return fVar;
    }

    static int d(int i, float f) {
        return (((int) (Color.alpha(i) * f)) << 24) | (16777215 & i);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (this.tp != null) {
            this.tp.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.tp != null) {
            DrawableCompat.inflate(this.tp, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0001f c0001f = this.tr;
        c0001f.ul = new e();
        TypedArray a2 = a(resources, theme, attributeSet, android.support.a.a.a.sV);
        a(a2, xmlPullParser);
        a2.recycle();
        c0001f.tf = getChangingConfigurations();
        c0001f.uw = true;
        b(resources, xmlPullParser, attributeSet, theme);
        this.ts = a(this.ts, c0001f.um, c0001f.uo);
    }

    private static PorterDuff.Mode b(int i, PorterDuff.Mode mode) {
        switch (i) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 4:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            default:
                return mode;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 9:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
        }
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) throws XmlPullParserException {
        C0001f c0001f = this.tr;
        e eVar = c0001f.ul;
        c0001f.uo = b(android.support.a.a.d.a(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            c0001f.um = colorStateList;
        }
        c0001f.uq = android.support.a.a.d.a(typedArray, xmlPullParser, "autoMirrored", 5, c0001f.uq);
        eVar.ug = android.support.a.a.d.a(typedArray, xmlPullParser, "viewportWidth", 7, eVar.ug);
        eVar.uh = android.support.a.a.d.a(typedArray, xmlPullParser, "viewportHeight", 8, eVar.uh);
        if (eVar.ug <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (eVar.uh <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        eVar.ue = typedArray.getDimension(3, eVar.ue);
        eVar.uf = typedArray.getDimension(2, eVar.uf);
        if (eVar.ue <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (eVar.uf <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        eVar.setAlpha(android.support.a.a.d.a(typedArray, xmlPullParser, "alpha", 4, eVar.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            eVar.uj = string;
            eVar.uk.put(string, eVar);
        }
    }

    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        boolean z;
        C0001f c0001f = this.tr;
        e eVar = c0001f.ul;
        Stack stack = new Stack();
        stack.push(eVar.ud);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z2 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                c cVar = (c) stack.peek();
                if (ClientCookie.PATH_ATTR.equals(name)) {
                    b bVar = new b();
                    bVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.tO.add(bVar);
                    if (bVar.cQ() != null) {
                        eVar.uk.put(bVar.cQ(), bVar);
                    }
                    z = false;
                    c0001f.tf = bVar.tf | c0001f.tf;
                } else if ("clip-path".equals(name)) {
                    a aVar = new a();
                    aVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.tO.add(aVar);
                    if (aVar.cQ() != null) {
                        eVar.uk.put(aVar.cQ(), aVar);
                    }
                    c0001f.tf |= aVar.tf;
                    z = z2;
                } else {
                    if ("group".equals(name)) {
                        c cVar2 = new c();
                        cVar2.a(resources, attributeSet, theme, xmlPullParser);
                        cVar.tO.add(cVar2);
                        stack.push(cVar2);
                        if (cVar2.getGroupName() != null) {
                            eVar.uk.put(cVar2.getGroupName(), cVar2);
                        }
                        c0001f.tf |= cVar2.tf;
                    }
                    z = z2;
                }
                z2 = z;
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                stack.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z2) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append(ClientCookie.PATH_ATTR);
            throw new XmlPullParserException("no " + ((Object) stringBuffer) + " defined");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(boolean z) {
        this.f0tv = z;
    }

    private boolean cN() {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 17) {
            return false;
        }
        if (!isAutoMirrored() || getLayoutDirection() != 1) {
            z = false;
        }
        return z;
    }

    @Override // android.support.a.a.e, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.tp != null) {
            this.tp.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.tp != null ? this.tp.getChangingConfigurations() : super.getChangingConfigurations() | this.tr.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.tp != null) {
            this.tp.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        if (this.tp != null) {
            this.tp.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return this.tp != null ? this.tp.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        if (this.tp != null) {
            this.tp.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* loaded from: classes2.dex */
    private static class g extends Drawable.ConstantState {
        private final Drawable.ConstantState ti;

        public g(Drawable.ConstantState constantState) {
            this.ti = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            f fVar = new f();
            fVar.tp = (VectorDrawable) this.ti.newDrawable();
            return fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            f fVar = new f();
            fVar.tp = (VectorDrawable) this.ti.newDrawable(resources);
            return fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            f fVar = new f();
            fVar.tp = (VectorDrawable) this.ti.newDrawable(resources, theme);
            return fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.ti.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.ti.getChangingConfigurations();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: android.support.a.a.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0001f extends Drawable.ConstantState {
        int tf;
        e ul;
        ColorStateList um;
        PorterDuff.Mode uo;
        boolean uq;
        Bitmap ur;
        ColorStateList us;
        PorterDuff.Mode ut;
        int uu;
        boolean uv;
        boolean uw;
        Paint ux;

        public C0001f(C0001f c0001f) {
            this.um = null;
            this.uo = f.tq;
            if (c0001f != null) {
                this.tf = c0001f.tf;
                this.ul = new e(c0001f.ul);
                if (c0001f.ul.ub != null) {
                    this.ul.ub = new Paint(c0001f.ul.ub);
                }
                if (c0001f.ul.mStrokePaint != null) {
                    this.ul.mStrokePaint = new Paint(c0001f.ul.mStrokePaint);
                }
                this.um = c0001f.um;
                this.uo = c0001f.uo;
                this.uq = c0001f.uq;
            }
        }

        public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.ur, (Rect) null, rect, a(colorFilter));
        }

        public boolean cS() {
            return this.ul.cR() < 255;
        }

        public Paint a(ColorFilter colorFilter) {
            if (!cS() && colorFilter == null) {
                return null;
            }
            if (this.ux == null) {
                this.ux = new Paint();
                this.ux.setFilterBitmap(true);
            }
            this.ux.setAlpha(this.ul.cR());
            this.ux.setColorFilter(colorFilter);
            return this.ux;
        }

        public void r(int i, int i2) {
            this.ur.eraseColor(0);
            this.ul.a(new Canvas(this.ur), i, i2, (ColorFilter) null);
        }

        public void s(int i, int i2) {
            if (this.ur == null || !t(i, i2)) {
                this.ur = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.uw = true;
            }
        }

        public boolean t(int i, int i2) {
            return i == this.ur.getWidth() && i2 == this.ur.getHeight();
        }

        public boolean cT() {
            return !this.uw && this.us == this.um && this.ut == this.uo && this.uv == this.uq && this.uu == this.ul.cR();
        }

        public void cU() {
            this.us = this.um;
            this.ut = this.uo;
            this.uu = this.ul.cR();
            this.uv = this.uq;
            this.uw = false;
        }

        public C0001f() {
            this.um = null;
            this.uo = f.tq;
            this.ul = new e();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new f(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new f(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.tf;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class e {
        private static final Matrix tY = new Matrix();
        private final Path mPath;
        private Paint mStrokePaint;
        private final Path tX;
        private final Matrix tZ;
        private int tf;
        private Paint ub;
        private PathMeasure uc;
        final c ud;
        float ue;
        float uf;
        float ug;
        float uh;
        int ui;
        String uj;
        final ArrayMap<String, Object> uk;

        public e() {
            this.tZ = new Matrix();
            this.ue = 0.0f;
            this.uf = 0.0f;
            this.ug = 0.0f;
            this.uh = 0.0f;
            this.ui = 255;
            this.uj = null;
            this.uk = new ArrayMap<>();
            this.ud = new c();
            this.mPath = new Path();
            this.tX = new Path();
        }

        public void R(int i) {
            this.ui = i;
        }

        public int cR() {
            return this.ui;
        }

        public void setAlpha(float f) {
            R((int) (255.0f * f));
        }

        public float getAlpha() {
            return cR() / 255.0f;
        }

        public e(e eVar) {
            this.tZ = new Matrix();
            this.ue = 0.0f;
            this.uf = 0.0f;
            this.ug = 0.0f;
            this.uh = 0.0f;
            this.ui = 255;
            this.uj = null;
            this.uk = new ArrayMap<>();
            this.ud = new c(eVar.ud, this.uk);
            this.mPath = new Path(eVar.mPath);
            this.tX = new Path(eVar.tX);
            this.ue = eVar.ue;
            this.uf = eVar.uf;
            this.ug = eVar.ug;
            this.uh = eVar.uh;
            this.tf = eVar.tf;
            this.ui = eVar.ui;
            this.uj = eVar.uj;
            if (eVar.uj != null) {
                this.uk.put(eVar.uj, this);
            }
        }

        private void a(c cVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            cVar.tN.set(matrix);
            cVar.tN.preConcat(cVar.tU);
            canvas.save();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < cVar.tO.size()) {
                    Object obj = cVar.tO.get(i4);
                    if (!(obj instanceof c)) {
                        if (obj instanceof d) {
                            a(cVar, (d) obj, canvas, i, i2, colorFilter);
                        }
                    } else {
                        a((c) obj, cVar.tN, canvas, i, i2, colorFilter);
                    }
                    i3 = i4 + 1;
                } else {
                    canvas.restore();
                    return;
                }
            }
        }

        public void a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            a(this.ud, tY, canvas, i, i2, colorFilter);
        }

        private void a(c cVar, d dVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = i / this.ug;
            float f2 = i2 / this.uh;
            float min = Math.min(f, f2);
            Matrix matrix = cVar.tN;
            this.tZ.set(matrix);
            this.tZ.postScale(f, f2);
            float a = a(matrix);
            if (a != 0.0f) {
                dVar.a(this.mPath);
                Path path = this.mPath;
                this.tX.reset();
                if (dVar.cO()) {
                    this.tX.addPath(path, this.tZ);
                    canvas.clipPath(this.tX);
                    return;
                }
                b bVar = (b) dVar;
                if (bVar.tH != 0.0f || bVar.tI != 1.0f) {
                    float f3 = (bVar.tH + bVar.tJ) % 1.0f;
                    float f4 = (bVar.tI + bVar.tJ) % 1.0f;
                    if (this.uc == null) {
                        this.uc = new PathMeasure();
                    }
                    this.uc.setPath(this.mPath, false);
                    float length = this.uc.getLength();
                    float f5 = f3 * length;
                    float f6 = f4 * length;
                    path.reset();
                    if (f5 > f6) {
                        this.uc.getSegment(f5, length, path, true);
                        this.uc.getSegment(0.0f, f6, path, true);
                    } else {
                        this.uc.getSegment(f5, f6, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.tX.addPath(path, this.tZ);
                if (bVar.tD != 0) {
                    if (this.ub == null) {
                        this.ub = new Paint();
                        this.ub.setStyle(Paint.Style.FILL);
                        this.ub.setAntiAlias(true);
                    }
                    Paint paint = this.ub;
                    paint.setColor(f.d(bVar.tD, bVar.tG));
                    paint.setColorFilter(colorFilter);
                    canvas.drawPath(this.tX, paint);
                }
                if (bVar.mStrokeColor != 0) {
                    if (this.mStrokePaint == null) {
                        this.mStrokePaint = new Paint();
                        this.mStrokePaint.setStyle(Paint.Style.STROKE);
                        this.mStrokePaint.setAntiAlias(true);
                    }
                    Paint paint2 = this.mStrokePaint;
                    if (bVar.tL != null) {
                        paint2.setStrokeJoin(bVar.tL);
                    }
                    if (bVar.tK != null) {
                        paint2.setStrokeCap(bVar.tK);
                    }
                    paint2.setStrokeMiter(bVar.tM);
                    paint2.setColor(f.d(bVar.mStrokeColor, bVar.tE));
                    paint2.setColorFilter(colorFilter);
                    paint2.setStrokeWidth(a * min * bVar.mStrokeWidth);
                    canvas.drawPath(this.tX, paint2);
                }
            }
        }

        private static float a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private float a(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot(fArr[2], fArr[3]);
            float a = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot(fArr[0], fArr[1]), hypot);
            if (max > 0.0f) {
                return Math.abs(a) / max;
            }
            return 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {
        private String mGroupName;
        private float mScaleX;
        private float mScaleY;
        private int[] tC;
        private final Matrix tN;
        final ArrayList<Object> tO;
        float tP;
        private float tQ;
        private float tR;
        private float tS;
        private float tT;
        private final Matrix tU;
        int tf;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v8, types: [android.support.a.a.f$b] */
        /* JADX WARN: Type inference failed for: r7v0, types: [android.support.v4.util.ArrayMap, android.support.v4.util.ArrayMap<java.lang.String, java.lang.Object>] */
        public c(c cVar, ArrayMap<String, Object> arrayMap) {
            a aVar;
            this.tN = new Matrix();
            this.tO = new ArrayList<>();
            this.tP = 0.0f;
            this.tQ = 0.0f;
            this.tR = 0.0f;
            this.mScaleX = 1.0f;
            this.mScaleY = 1.0f;
            this.tS = 0.0f;
            this.tT = 0.0f;
            this.tU = new Matrix();
            this.mGroupName = null;
            this.tP = cVar.tP;
            this.tQ = cVar.tQ;
            this.tR = cVar.tR;
            this.mScaleX = cVar.mScaleX;
            this.mScaleY = cVar.mScaleY;
            this.tS = cVar.tS;
            this.tT = cVar.tT;
            this.tC = cVar.tC;
            this.mGroupName = cVar.mGroupName;
            this.tf = cVar.tf;
            if (this.mGroupName != null) {
                arrayMap.put(this.mGroupName, this);
            }
            this.tU.set(cVar.tU);
            ArrayList<Object> arrayList = cVar.tO;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    Object obj = arrayList.get(i2);
                    if (obj instanceof c) {
                        this.tO.add(new c((c) obj, arrayMap));
                    } else {
                        if (obj instanceof b) {
                            aVar = new b((b) obj);
                        } else if (obj instanceof a) {
                            aVar = new a((a) obj);
                        } else {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        this.tO.add(aVar);
                        if (aVar.tW != null) {
                            arrayMap.put(aVar.tW, aVar);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        public c() {
            this.tN = new Matrix();
            this.tO = new ArrayList<>();
            this.tP = 0.0f;
            this.tQ = 0.0f;
            this.tR = 0.0f;
            this.mScaleX = 1.0f;
            this.mScaleY = 1.0f;
            this.tS = 0.0f;
            this.tT = 0.0f;
            this.tU = new Matrix();
            this.mGroupName = null;
        }

        public String getGroupName() {
            return this.mGroupName;
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a = android.support.a.a.e.a(resources, theme, attributeSet, android.support.a.a.a.sW);
            a(a, xmlPullParser);
            a.recycle();
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.tC = null;
            this.tP = android.support.a.a.d.a(typedArray, xmlPullParser, "rotation", 5, this.tP);
            this.tQ = typedArray.getFloat(1, this.tQ);
            this.tR = typedArray.getFloat(2, this.tR);
            this.mScaleX = android.support.a.a.d.a(typedArray, xmlPullParser, "scaleX", 3, this.mScaleX);
            this.mScaleY = android.support.a.a.d.a(typedArray, xmlPullParser, "scaleY", 4, this.mScaleY);
            this.tS = android.support.a.a.d.a(typedArray, xmlPullParser, "translateX", 6, this.tS);
            this.tT = android.support.a.a.d.a(typedArray, xmlPullParser, "translateY", 7, this.tT);
            String string = typedArray.getString(0);
            if (string != null) {
                this.mGroupName = string;
            }
            cP();
        }

        private void cP() {
            this.tU.reset();
            this.tU.postTranslate(-this.tQ, -this.tR);
            this.tU.postScale(this.mScaleX, this.mScaleY);
            this.tU.postRotate(this.tP, 0.0f, 0.0f);
            this.tU.postTranslate(this.tS + this.tQ, this.tT + this.tR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class d {
        protected c.b[] tV;
        String tW;
        int tf;

        public d() {
            this.tV = null;
        }

        public d(d dVar) {
            this.tV = null;
            this.tW = dVar.tW;
            this.tf = dVar.tf;
            this.tV = android.support.a.a.c.a(dVar.tV);
        }

        public void a(Path path) {
            path.reset();
            if (this.tV != null) {
                c.b.a(this.tV, path);
            }
        }

        public String cQ() {
            return this.tW;
        }

        public boolean cO() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends d {
        public a() {
        }

        public a(a aVar) {
            super(aVar);
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (android.support.a.a.d.a(xmlPullParser, "pathData")) {
                TypedArray a = android.support.a.a.e.a(resources, theme, attributeSet, android.support.a.a.a.sY);
                a(a);
                a.recycle();
            }
        }

        private void a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.tW = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.tV = android.support.a.a.c.r(string2);
            }
        }

        @Override // android.support.a.a.f.d
        public boolean cO() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b extends d {
        int mStrokeColor;
        float mStrokeWidth;
        private int[] tC;
        int tD;
        float tE;
        int tF;
        float tG;
        float tH;
        float tI;
        float tJ;
        Paint.Cap tK;
        Paint.Join tL;
        float tM;

        public b() {
            this.mStrokeColor = 0;
            this.mStrokeWidth = 0.0f;
            this.tD = 0;
            this.tE = 1.0f;
            this.tG = 1.0f;
            this.tH = 0.0f;
            this.tI = 1.0f;
            this.tJ = 0.0f;
            this.tK = Paint.Cap.BUTT;
            this.tL = Paint.Join.MITER;
            this.tM = 4.0f;
        }

        public b(b bVar) {
            super(bVar);
            this.mStrokeColor = 0;
            this.mStrokeWidth = 0.0f;
            this.tD = 0;
            this.tE = 1.0f;
            this.tG = 1.0f;
            this.tH = 0.0f;
            this.tI = 1.0f;
            this.tJ = 0.0f;
            this.tK = Paint.Cap.BUTT;
            this.tL = Paint.Join.MITER;
            this.tM = 4.0f;
            this.tC = bVar.tC;
            this.mStrokeColor = bVar.mStrokeColor;
            this.mStrokeWidth = bVar.mStrokeWidth;
            this.tE = bVar.tE;
            this.tD = bVar.tD;
            this.tF = bVar.tF;
            this.tG = bVar.tG;
            this.tH = bVar.tH;
            this.tI = bVar.tI;
            this.tJ = bVar.tJ;
            this.tK = bVar.tK;
            this.tL = bVar.tL;
            this.tM = bVar.tM;
        }

        private Paint.Cap a(int i, Paint.Cap cap) {
            switch (i) {
                case 0:
                    return Paint.Cap.BUTT;
                case 1:
                    return Paint.Cap.ROUND;
                case 2:
                    return Paint.Cap.SQUARE;
                default:
                    return cap;
            }
        }

        private Paint.Join a(int i, Paint.Join join) {
            switch (i) {
                case 0:
                    return Paint.Join.MITER;
                case 1:
                    return Paint.Join.ROUND;
                case 2:
                    return Paint.Join.BEVEL;
                default:
                    return join;
            }
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a = android.support.a.a.e.a(resources, theme, attributeSet, android.support.a.a.a.sX);
            a(a, xmlPullParser);
            a.recycle();
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.tC = null;
            if (android.support.a.a.d.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.tW = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.tV = android.support.a.a.c.r(string2);
                }
                this.tD = android.support.a.a.d.b(typedArray, xmlPullParser, "fillColor", 1, this.tD);
                this.tG = android.support.a.a.d.a(typedArray, xmlPullParser, "fillAlpha", 12, this.tG);
                this.tK = a(android.support.a.a.d.a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.tK);
                this.tL = a(android.support.a.a.d.a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.tL);
                this.tM = android.support.a.a.d.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.tM);
                this.mStrokeColor = android.support.a.a.d.b(typedArray, xmlPullParser, "strokeColor", 3, this.mStrokeColor);
                this.tE = android.support.a.a.d.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.tE);
                this.mStrokeWidth = android.support.a.a.d.a(typedArray, xmlPullParser, "strokeWidth", 4, this.mStrokeWidth);
                this.tI = android.support.a.a.d.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.tI);
                this.tJ = android.support.a.a.d.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.tJ);
                this.tH = android.support.a.a.d.a(typedArray, xmlPullParser, "trimPathStart", 5, this.tH);
            }
        }
    }
}
