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
    static final PorterDuff.Mode tr = PorterDuff.Mode.SRC_IN;
    private final float[] tA;
    private final Matrix tB;
    private final Rect tC;
    private C0001f ts;
    private PorterDuffColorFilter tt;
    private ColorFilter tu;

    /* renamed from: tv  reason: collision with root package name */
    private boolean f0tv;
    private boolean tw;
    private Drawable.ConstantState tz;

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
        this.tw = true;
        this.tA = new float[9];
        this.tB = new Matrix();
        this.tC = new Rect();
        this.ts = new C0001f();
    }

    f(C0001f c0001f) {
        this.tw = true;
        this.tA = new float[9];
        this.tB = new Matrix();
        this.tC = new Rect();
        this.ts = c0001f;
        this.tt = a(this.tt, c0001f.uo, c0001f.uq);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.tq != null) {
            this.tq.mutate();
        } else if (!this.f0tv && super.mutate() == this) {
            this.ts = new C0001f(this.ts);
            this.f0tv = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object x(String str) {
        return this.ts.um.ul.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.tq != null) {
            return new g(this.tq.getConstantState());
        }
        this.ts.tg = getChangingConfigurations();
        return this.ts;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.tq != null) {
            this.tq.draw(canvas);
            return;
        }
        copyBounds(this.tC);
        if (this.tC.width() > 0 && this.tC.height() > 0) {
            ColorFilter colorFilter = this.tu == null ? this.tt : this.tu;
            canvas.getMatrix(this.tB);
            this.tB.getValues(this.tA);
            float abs = Math.abs(this.tA[0]);
            float abs2 = Math.abs(this.tA[4]);
            float abs3 = Math.abs(this.tA[1]);
            float abs4 = Math.abs(this.tA[3]);
            if (abs3 != 0.0f || abs4 != 0.0f) {
                abs2 = 1.0f;
                abs = 1.0f;
            }
            int min = Math.min(2048, (int) (abs * this.tC.width()));
            int min2 = Math.min(2048, (int) (abs2 * this.tC.height()));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                canvas.translate(this.tC.left, this.tC.top);
                if (cN()) {
                    canvas.translate(this.tC.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.tC.offsetTo(0, 0);
                this.ts.s(min, min2);
                if (!this.tw) {
                    this.ts.r(min, min2);
                } else if (!this.ts.cT()) {
                    this.ts.r(min, min2);
                    this.ts.cU();
                }
                this.ts.a(canvas, colorFilter, this.tC);
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.tq != null ? DrawableCompat.getAlpha(this.tq) : this.ts.um.cR();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.tq != null) {
            this.tq.setAlpha(i);
        } else if (this.ts.um.cR() != i) {
            this.ts.um.R(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.tq != null) {
            this.tq.setColorFilter(colorFilter);
            return;
        }
        this.tu = colorFilter;
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
        if (this.tq != null) {
            DrawableCompat.setTint(this.tq, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.tq != null) {
            DrawableCompat.setTintList(this.tq, colorStateList);
            return;
        }
        C0001f c0001f = this.ts;
        if (c0001f.uo != colorStateList) {
            c0001f.uo = colorStateList;
            this.tt = a(this.tt, colorStateList, c0001f.uq);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.tq != null) {
            DrawableCompat.setTintMode(this.tq, mode);
            return;
        }
        C0001f c0001f = this.ts;
        if (c0001f.uq != mode) {
            c0001f.uq = mode;
            this.tt = a(this.tt, c0001f.uo, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (this.tq != null) {
            return this.tq.isStateful();
        }
        return super.isStateful() || !(this.ts == null || this.ts.uo == null || !this.ts.uo.isStateful());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.tq != null) {
            return this.tq.setState(iArr);
        }
        C0001f c0001f = this.ts;
        if (c0001f.uo != null && c0001f.uq != null) {
            this.tt = a(this.tt, c0001f.uo, c0001f.uq);
            invalidateSelf();
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.tq != null) {
            return this.tq.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.tq != null ? this.tq.getIntrinsicWidth() : (int) this.ts.um.uf;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.tq != null ? this.tq.getIntrinsicHeight() : (int) this.ts.um.ug;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.tq != null) {
            DrawableCompat.canApplyTheme(this.tq);
            return false;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.tq != null ? DrawableCompat.isAutoMirrored(this.tq) : this.ts.ur;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.tq != null) {
            DrawableCompat.setAutoMirrored(this.tq, z);
        } else {
            this.ts.ur = z;
        }
    }

    public static f a(Resources resources, int i, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            f fVar = new f();
            fVar.tq = ResourcesCompat.getDrawable(resources, i, theme);
            fVar.tz = new g(fVar.tq.getConstantState());
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
        if (this.tq != null) {
            this.tq.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.tq != null) {
            DrawableCompat.inflate(this.tq, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0001f c0001f = this.ts;
        c0001f.um = new e();
        TypedArray a2 = a(resources, theme, attributeSet, android.support.a.a.a.sV);
        a(a2, xmlPullParser);
        a2.recycle();
        c0001f.tg = getChangingConfigurations();
        c0001f.ux = true;
        b(resources, xmlPullParser, attributeSet, theme);
        this.tt = a(this.tt, c0001f.uo, c0001f.uq);
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
        C0001f c0001f = this.ts;
        e eVar = c0001f.um;
        c0001f.uq = b(android.support.a.a.d.a(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            c0001f.uo = colorStateList;
        }
        c0001f.ur = android.support.a.a.d.a(typedArray, xmlPullParser, "autoMirrored", 5, c0001f.ur);
        eVar.uh = android.support.a.a.d.a(typedArray, xmlPullParser, "viewportWidth", 7, eVar.uh);
        eVar.ui = android.support.a.a.d.a(typedArray, xmlPullParser, "viewportHeight", 8, eVar.ui);
        if (eVar.uh <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (eVar.ui <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        eVar.uf = typedArray.getDimension(3, eVar.uf);
        eVar.ug = typedArray.getDimension(2, eVar.ug);
        if (eVar.uf <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (eVar.ug <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        eVar.setAlpha(android.support.a.a.d.a(typedArray, xmlPullParser, "alpha", 4, eVar.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            eVar.uk = string;
            eVar.ul.put(string, eVar);
        }
    }

    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        boolean z;
        C0001f c0001f = this.ts;
        e eVar = c0001f.um;
        Stack stack = new Stack();
        stack.push(eVar.ue);
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
                    cVar.tP.add(bVar);
                    if (bVar.cQ() != null) {
                        eVar.ul.put(bVar.cQ(), bVar);
                    }
                    z = false;
                    c0001f.tg = bVar.tg | c0001f.tg;
                } else if ("clip-path".equals(name)) {
                    a aVar = new a();
                    aVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.tP.add(aVar);
                    if (aVar.cQ() != null) {
                        eVar.ul.put(aVar.cQ(), aVar);
                    }
                    c0001f.tg |= aVar.tg;
                    z = z2;
                } else {
                    if ("group".equals(name)) {
                        c cVar2 = new c();
                        cVar2.a(resources, attributeSet, theme, xmlPullParser);
                        cVar.tP.add(cVar2);
                        stack.push(cVar2);
                        if (cVar2.getGroupName() != null) {
                            eVar.ul.put(cVar2.getGroupName(), cVar2);
                        }
                        c0001f.tg |= cVar2.tg;
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
    public void t(boolean z) {
        this.tw = z;
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
        if (this.tq != null) {
            this.tq.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.tq != null ? this.tq.getChangingConfigurations() : super.getChangingConfigurations() | this.ts.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.tq != null) {
            this.tq.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        if (this.tq != null) {
            this.tq.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return this.tq != null ? this.tq.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        if (this.tq != null) {
            this.tq.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class g extends Drawable.ConstantState {
        private final Drawable.ConstantState tj;

        public g(Drawable.ConstantState constantState) {
            this.tj = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            f fVar = new f();
            fVar.tq = (VectorDrawable) this.tj.newDrawable();
            return fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            f fVar = new f();
            fVar.tq = (VectorDrawable) this.tj.newDrawable(resources);
            return fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            f fVar = new f();
            fVar.tq = (VectorDrawable) this.tj.newDrawable(resources, theme);
            return fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.tj.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.tj.getChangingConfigurations();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: android.support.a.a.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0001f extends Drawable.ConstantState {
        int tg;
        e um;
        ColorStateList uo;
        PorterDuff.Mode uq;
        boolean ur;
        Bitmap us;
        ColorStateList ut;
        PorterDuff.Mode uu;
        int uv;
        boolean uw;
        boolean ux;
        Paint uy;

        public C0001f(C0001f c0001f) {
            this.uo = null;
            this.uq = f.tr;
            if (c0001f != null) {
                this.tg = c0001f.tg;
                this.um = new e(c0001f.um);
                if (c0001f.um.uc != null) {
                    this.um.uc = new Paint(c0001f.um.uc);
                }
                if (c0001f.um.mStrokePaint != null) {
                    this.um.mStrokePaint = new Paint(c0001f.um.mStrokePaint);
                }
                this.uo = c0001f.uo;
                this.uq = c0001f.uq;
                this.ur = c0001f.ur;
            }
        }

        public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.us, (Rect) null, rect, a(colorFilter));
        }

        public boolean cS() {
            return this.um.cR() < 255;
        }

        public Paint a(ColorFilter colorFilter) {
            if (!cS() && colorFilter == null) {
                return null;
            }
            if (this.uy == null) {
                this.uy = new Paint();
                this.uy.setFilterBitmap(true);
            }
            this.uy.setAlpha(this.um.cR());
            this.uy.setColorFilter(colorFilter);
            return this.uy;
        }

        public void r(int i, int i2) {
            this.us.eraseColor(0);
            this.um.a(new Canvas(this.us), i, i2, null);
        }

        public void s(int i, int i2) {
            if (this.us == null || !t(i, i2)) {
                this.us = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.ux = true;
            }
        }

        public boolean t(int i, int i2) {
            return i == this.us.getWidth() && i2 == this.us.getHeight();
        }

        public boolean cT() {
            return !this.ux && this.ut == this.uo && this.uu == this.uq && this.uw == this.ur && this.uv == this.um.cR();
        }

        public void cU() {
            this.ut = this.uo;
            this.uu = this.uq;
            this.uv = this.um.cR();
            this.uw = this.ur;
            this.ux = false;
        }

        public C0001f() {
            this.uo = null;
            this.uq = f.tr;
            this.um = new e();
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
            return this.tg;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class e {
        private static final Matrix tZ = new Matrix();
        private final Path mPath;
        private Paint mStrokePaint;
        private final Path tY;
        private int tg;
        private final Matrix ub;
        private Paint uc;
        private PathMeasure ud;
        final c ue;
        float uf;
        float ug;
        float uh;
        float ui;
        int uj;
        String uk;
        final ArrayMap<String, Object> ul;

        public e() {
            this.ub = new Matrix();
            this.uf = 0.0f;
            this.ug = 0.0f;
            this.uh = 0.0f;
            this.ui = 0.0f;
            this.uj = 255;
            this.uk = null;
            this.ul = new ArrayMap<>();
            this.ue = new c();
            this.mPath = new Path();
            this.tY = new Path();
        }

        public void R(int i) {
            this.uj = i;
        }

        public int cR() {
            return this.uj;
        }

        public void setAlpha(float f) {
            R((int) (255.0f * f));
        }

        public float getAlpha() {
            return cR() / 255.0f;
        }

        public e(e eVar) {
            this.ub = new Matrix();
            this.uf = 0.0f;
            this.ug = 0.0f;
            this.uh = 0.0f;
            this.ui = 0.0f;
            this.uj = 255;
            this.uk = null;
            this.ul = new ArrayMap<>();
            this.ue = new c(eVar.ue, this.ul);
            this.mPath = new Path(eVar.mPath);
            this.tY = new Path(eVar.tY);
            this.uf = eVar.uf;
            this.ug = eVar.ug;
            this.uh = eVar.uh;
            this.ui = eVar.ui;
            this.tg = eVar.tg;
            this.uj = eVar.uj;
            this.uk = eVar.uk;
            if (eVar.uk != null) {
                this.ul.put(eVar.uk, this);
            }
        }

        private void a(c cVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            cVar.tO.set(matrix);
            cVar.tO.preConcat(cVar.tV);
            canvas.save();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < cVar.tP.size()) {
                    Object obj = cVar.tP.get(i4);
                    if (!(obj instanceof c)) {
                        if (obj instanceof d) {
                            a(cVar, (d) obj, canvas, i, i2, colorFilter);
                        }
                    } else {
                        a((c) obj, cVar.tO, canvas, i, i2, colorFilter);
                    }
                    i3 = i4 + 1;
                } else {
                    canvas.restore();
                    return;
                }
            }
        }

        public void a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            a(this.ue, tZ, canvas, i, i2, colorFilter);
        }

        private void a(c cVar, d dVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = i / this.uh;
            float f2 = i2 / this.ui;
            float min = Math.min(f, f2);
            Matrix matrix = cVar.tO;
            this.ub.set(matrix);
            this.ub.postScale(f, f2);
            float a = a(matrix);
            if (a != 0.0f) {
                dVar.a(this.mPath);
                Path path = this.mPath;
                this.tY.reset();
                if (dVar.cO()) {
                    this.tY.addPath(path, this.ub);
                    canvas.clipPath(this.tY);
                    return;
                }
                b bVar = (b) dVar;
                if (bVar.tI != 0.0f || bVar.tJ != 1.0f) {
                    float f3 = (bVar.tI + bVar.tK) % 1.0f;
                    float f4 = (bVar.tJ + bVar.tK) % 1.0f;
                    if (this.ud == null) {
                        this.ud = new PathMeasure();
                    }
                    this.ud.setPath(this.mPath, false);
                    float length = this.ud.getLength();
                    float f5 = f3 * length;
                    float f6 = f4 * length;
                    path.reset();
                    if (f5 > f6) {
                        this.ud.getSegment(f5, length, path, true);
                        this.ud.getSegment(0.0f, f6, path, true);
                    } else {
                        this.ud.getSegment(f5, f6, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.tY.addPath(path, this.ub);
                if (bVar.tE != 0) {
                    if (this.uc == null) {
                        this.uc = new Paint();
                        this.uc.setStyle(Paint.Style.FILL);
                        this.uc.setAntiAlias(true);
                    }
                    Paint paint = this.uc;
                    paint.setColor(f.d(bVar.tE, bVar.tH));
                    paint.setColorFilter(colorFilter);
                    canvas.drawPath(this.tY, paint);
                }
                if (bVar.mStrokeColor != 0) {
                    if (this.mStrokePaint == null) {
                        this.mStrokePaint = new Paint();
                        this.mStrokePaint.setStyle(Paint.Style.STROKE);
                        this.mStrokePaint.setAntiAlias(true);
                    }
                    Paint paint2 = this.mStrokePaint;
                    if (bVar.tM != null) {
                        paint2.setStrokeJoin(bVar.tM);
                    }
                    if (bVar.tL != null) {
                        paint2.setStrokeCap(bVar.tL);
                    }
                    paint2.setStrokeMiter(bVar.tN);
                    paint2.setColor(f.d(bVar.mStrokeColor, bVar.tF));
                    paint2.setColorFilter(colorFilter);
                    paint2.setStrokeWidth(a * min * bVar.mStrokeWidth);
                    canvas.drawPath(this.tY, paint2);
                }
            }
        }

        private static float b(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private float a(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot(fArr[2], fArr[3]);
            float b = b(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot(fArr[0], fArr[1]), hypot);
            if (max > 0.0f) {
                return Math.abs(b) / max;
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
        private int[] tD;
        private final Matrix tO;
        final ArrayList<Object> tP;
        float tQ;
        private float tR;
        private float tS;
        private float tT;
        private float tU;
        private final Matrix tV;
        int tg;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v8, types: [android.support.a.a.f$b] */
        /* JADX WARN: Type inference failed for: r7v0, types: [android.support.v4.util.ArrayMap, android.support.v4.util.ArrayMap<java.lang.String, java.lang.Object>] */
        public c(c cVar, ArrayMap<String, Object> arrayMap) {
            a aVar;
            this.tO = new Matrix();
            this.tP = new ArrayList<>();
            this.tQ = 0.0f;
            this.tR = 0.0f;
            this.tS = 0.0f;
            this.mScaleX = 1.0f;
            this.mScaleY = 1.0f;
            this.tT = 0.0f;
            this.tU = 0.0f;
            this.tV = new Matrix();
            this.mGroupName = null;
            this.tQ = cVar.tQ;
            this.tR = cVar.tR;
            this.tS = cVar.tS;
            this.mScaleX = cVar.mScaleX;
            this.mScaleY = cVar.mScaleY;
            this.tT = cVar.tT;
            this.tU = cVar.tU;
            this.tD = cVar.tD;
            this.mGroupName = cVar.mGroupName;
            this.tg = cVar.tg;
            if (this.mGroupName != null) {
                arrayMap.put(this.mGroupName, this);
            }
            this.tV.set(cVar.tV);
            ArrayList<Object> arrayList = cVar.tP;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    Object obj = arrayList.get(i2);
                    if (obj instanceof c) {
                        this.tP.add(new c((c) obj, arrayMap));
                    } else {
                        if (obj instanceof b) {
                            aVar = new b((b) obj);
                        } else if (obj instanceof a) {
                            aVar = new a((a) obj);
                        } else {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        this.tP.add(aVar);
                        if (aVar.tX != null) {
                            arrayMap.put(aVar.tX, aVar);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        public c() {
            this.tO = new Matrix();
            this.tP = new ArrayList<>();
            this.tQ = 0.0f;
            this.tR = 0.0f;
            this.tS = 0.0f;
            this.mScaleX = 1.0f;
            this.mScaleY = 1.0f;
            this.tT = 0.0f;
            this.tU = 0.0f;
            this.tV = new Matrix();
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
            this.tD = null;
            this.tQ = android.support.a.a.d.a(typedArray, xmlPullParser, "rotation", 5, this.tQ);
            this.tR = typedArray.getFloat(1, this.tR);
            this.tS = typedArray.getFloat(2, this.tS);
            this.mScaleX = android.support.a.a.d.a(typedArray, xmlPullParser, "scaleX", 3, this.mScaleX);
            this.mScaleY = android.support.a.a.d.a(typedArray, xmlPullParser, "scaleY", 4, this.mScaleY);
            this.tT = android.support.a.a.d.a(typedArray, xmlPullParser, "translateX", 6, this.tT);
            this.tU = android.support.a.a.d.a(typedArray, xmlPullParser, "translateY", 7, this.tU);
            String string = typedArray.getString(0);
            if (string != null) {
                this.mGroupName = string;
            }
            cP();
        }

        private void cP() {
            this.tV.reset();
            this.tV.postTranslate(-this.tR, -this.tS);
            this.tV.postScale(this.mScaleX, this.mScaleY);
            this.tV.postRotate(this.tQ, 0.0f, 0.0f);
            this.tV.postTranslate(this.tT + this.tR, this.tU + this.tS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class d {
        protected c.b[] tW;
        String tX;
        int tg;

        public d() {
            this.tW = null;
        }

        public d(d dVar) {
            this.tW = null;
            this.tX = dVar.tX;
            this.tg = dVar.tg;
            this.tW = android.support.a.a.c.a(dVar.tW);
        }

        public void a(Path path) {
            path.reset();
            if (this.tW != null) {
                c.b.a(this.tW, path);
            }
        }

        public String cQ() {
            return this.tX;
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
                this.tX = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.tW = android.support.a.a.c.r(string2);
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
        private int[] tD;
        int tE;
        float tF;
        int tG;
        float tH;
        float tI;
        float tJ;
        float tK;
        Paint.Cap tL;
        Paint.Join tM;
        float tN;

        public b() {
            this.mStrokeColor = 0;
            this.mStrokeWidth = 0.0f;
            this.tE = 0;
            this.tF = 1.0f;
            this.tH = 1.0f;
            this.tI = 0.0f;
            this.tJ = 1.0f;
            this.tK = 0.0f;
            this.tL = Paint.Cap.BUTT;
            this.tM = Paint.Join.MITER;
            this.tN = 4.0f;
        }

        public b(b bVar) {
            super(bVar);
            this.mStrokeColor = 0;
            this.mStrokeWidth = 0.0f;
            this.tE = 0;
            this.tF = 1.0f;
            this.tH = 1.0f;
            this.tI = 0.0f;
            this.tJ = 1.0f;
            this.tK = 0.0f;
            this.tL = Paint.Cap.BUTT;
            this.tM = Paint.Join.MITER;
            this.tN = 4.0f;
            this.tD = bVar.tD;
            this.mStrokeColor = bVar.mStrokeColor;
            this.mStrokeWidth = bVar.mStrokeWidth;
            this.tF = bVar.tF;
            this.tE = bVar.tE;
            this.tG = bVar.tG;
            this.tH = bVar.tH;
            this.tI = bVar.tI;
            this.tJ = bVar.tJ;
            this.tK = bVar.tK;
            this.tL = bVar.tL;
            this.tM = bVar.tM;
            this.tN = bVar.tN;
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
            this.tD = null;
            if (android.support.a.a.d.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.tX = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.tW = android.support.a.a.c.r(string2);
                }
                this.tE = android.support.a.a.d.b(typedArray, xmlPullParser, "fillColor", 1, this.tE);
                this.tH = android.support.a.a.d.a(typedArray, xmlPullParser, "fillAlpha", 12, this.tH);
                this.tL = a(android.support.a.a.d.a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.tL);
                this.tM = a(android.support.a.a.d.a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.tM);
                this.tN = android.support.a.a.d.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.tN);
                this.mStrokeColor = android.support.a.a.d.b(typedArray, xmlPullParser, "strokeColor", 3, this.mStrokeColor);
                this.tF = android.support.a.a.d.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.tF);
                this.mStrokeWidth = android.support.a.a.d.a(typedArray, xmlPullParser, "strokeWidth", 4, this.mStrokeWidth);
                this.tJ = android.support.a.a.d.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.tJ);
                this.tK = android.support.a.a.d.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.tK);
                this.tI = android.support.a.a.d.a(typedArray, xmlPullParser, "trimPathStart", 5, this.tI);
            }
        }
    }
}
