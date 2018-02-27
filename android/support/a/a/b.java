package android.support.a.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.baidu.fsg.base.BaiduRimConstants;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
@TargetApi(21)
/* loaded from: classes2.dex */
public class b extends e implements Animatable {
    final Drawable.Callback mCallback;
    private Context mContext;
    private a tb;
    private ArgbEvaluator tc;
    C0000b td;

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

    b() {
        this(null, null, null);
    }

    private b(Context context) {
        this(context, null, null);
    }

    private b(Context context, a aVar, Resources resources) {
        this.tc = null;
        this.mCallback = new Drawable.Callback() { // from class: android.support.a.a.b.1
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                b.this.invalidateSelf();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                b.this.scheduleSelf(runnable, j);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                b.this.unscheduleSelf(runnable);
            }
        };
        this.mContext = context;
        if (aVar != null) {
            this.tb = aVar;
        } else {
            this.tb = new a(context, aVar, this.mCallback, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.tp != null) {
            this.tp.mutate();
            return this;
        }
        throw new IllegalStateException("Mutate() is not supported for older platform");
    }

    public static b d(Context context, int i) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            b bVar = new b(context);
            bVar.tp = ResourcesCompat.getDrawable(context.getResources(), i, context.getTheme());
            bVar.tp.setCallback(bVar.mCallback);
            bVar.td = new C0000b(bVar.tp.getConstantState());
            return bVar;
        }
        try {
            XmlResourceParser xml = context.getResources().getXml(i);
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
            return a(context, context.getResources(), xml, asAttributeSet, context.getTheme());
        } catch (IOException e) {
            Log.e("AnimatedVDCompat", "parser error", e);
            return null;
        } catch (XmlPullParserException e2) {
            Log.e("AnimatedVDCompat", "parser error", e2);
            return null;
        }
    }

    public static b a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        b bVar = new b(context);
        bVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return bVar;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.tp != null) {
            return new C0000b(this.tp.getConstantState());
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.tp != null ? this.tp.getChangingConfigurations() : super.getChangingConfigurations() | this.tb.tf;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.tp != null) {
            this.tp.draw(canvas);
            return;
        }
        this.tb.tg.draw(canvas);
        if (isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.support.a.a.e, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.tp != null) {
            this.tp.setBounds(rect);
        } else {
            this.tb.tg.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return this.tp != null ? this.tp.setState(iArr) : this.tb.tg.setState(iArr);
    }

    @Override // android.support.a.a.e, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.tp != null ? this.tp.setLevel(i) : this.tb.tg.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.tp != null ? DrawableCompat.getAlpha(this.tp) : this.tb.tg.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.tp != null) {
            this.tp.setAlpha(i);
        } else {
            this.tb.tg.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.tp != null) {
            this.tp.setColorFilter(colorFilter);
        } else {
            this.tb.tg.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        if (this.tp != null) {
            DrawableCompat.setTint(this.tp, i);
        } else {
            this.tb.tg.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.tp != null) {
            DrawableCompat.setTintList(this.tp, colorStateList);
        } else {
            this.tb.tg.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.tp != null) {
            DrawableCompat.setTintMode(this.tp, mode);
        } else {
            this.tb.tg.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.tp != null) {
            return this.tp.setVisible(z, z2);
        }
        this.tb.tg.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.tp != null ? this.tp.isStateful() : this.tb.tg.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.tp != null ? this.tp.getOpacity() : this.tb.tg.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.tp != null ? this.tp.getIntrinsicWidth() : this.tb.tg.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.tp != null ? this.tp.getIntrinsicHeight() : this.tb.tg.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.tp != null ? DrawableCompat.isAutoMirrored(this.tp) : this.tb.tg.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.tp != null) {
            this.tp.setAutoMirrored(z);
        } else {
            this.tb.tg.setAutoMirrored(z);
        }
    }

    static TypedArray a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.tp != null) {
            DrawableCompat.inflate(this.tp, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1) {
            if (xmlPullParser.getDepth() >= depth || eventType != 3) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if ("animated-vector".equals(name)) {
                        TypedArray a2 = a(resources, theme, attributeSet, android.support.a.a.a.sY);
                        int resourceId = a2.getResourceId(0, 0);
                        if (resourceId != 0) {
                            f a3 = f.a(resources, resourceId, theme);
                            a3.t(false);
                            a3.setCallback(this.mCallback);
                            if (this.tb.tg != null) {
                                this.tb.tg.setCallback(null);
                            }
                            this.tb.tg = a3;
                        }
                        a2.recycle();
                    } else if (BaiduRimConstants.ACTION_TARGET.equals(name)) {
                        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, android.support.a.a.a.sZ);
                        String string = obtainAttributes.getString(0);
                        int resourceId2 = obtainAttributes.getResourceId(1, 0);
                        if (resourceId2 != 0) {
                            if (this.mContext != null) {
                                a(string, AnimatorInflater.loadAnimator(this.mContext, resourceId2));
                            } else {
                                throw new IllegalStateException("Context can't be null when inflating animators");
                            }
                        }
                        obtainAttributes.recycle();
                    } else {
                        continue;
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                return;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // android.support.a.a.e, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        if (this.tp != null) {
            DrawableCompat.applyTheme(this.tp, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.tp != null) {
            return DrawableCompat.canApplyTheme(this.tp);
        }
        return false;
    }

    /* renamed from: android.support.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0000b extends Drawable.ConstantState {
        private final Drawable.ConstantState ti;

        public C0000b(Drawable.ConstantState constantState) {
            this.ti = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            b bVar = new b();
            bVar.tp = this.ti.newDrawable();
            bVar.tp.setCallback(bVar.mCallback);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            b bVar = new b();
            bVar.tp = this.ti.newDrawable(resources);
            bVar.tp.setCallback(bVar.mCallback);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            b bVar = new b();
            bVar.tp = this.ti.newDrawable(resources, theme);
            bVar.tp.setCallback(bVar.mCallback);
            return bVar;
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
    /* loaded from: classes2.dex */
    public static class a extends Drawable.ConstantState {
        ArrayList<Animator> mAnimators;
        int tf;
        f tg;
        ArrayMap<Animator, String> th;

        public a(Context context, a aVar, Drawable.Callback callback, Resources resources) {
            if (aVar != null) {
                this.tf = aVar.tf;
                if (aVar.tg != null) {
                    Drawable.ConstantState constantState = aVar.tg.getConstantState();
                    if (resources != null) {
                        this.tg = (f) constantState.newDrawable(resources);
                    } else {
                        this.tg = (f) constantState.newDrawable();
                    }
                    this.tg = (f) this.tg.mutate();
                    this.tg.setCallback(callback);
                    this.tg.setBounds(aVar.tg.getBounds());
                    this.tg.t(false);
                }
                if (aVar.mAnimators != null) {
                    int size = aVar.mAnimators.size();
                    this.mAnimators = new ArrayList<>(size);
                    this.th = new ArrayMap<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = aVar.mAnimators.get(i);
                        Animator clone = animator.clone();
                        String str = aVar.th.get(animator);
                        clone.setTarget(this.tg.x(str));
                        this.mAnimators.add(clone);
                        this.th.put(clone, str);
                    }
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.tf;
        }
    }

    private void a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childAnimations.size()) {
                    break;
                }
                a(childAnimations.get(i2));
                i = i2 + 1;
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.tc == null) {
                    this.tc = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.tc);
            }
        }
    }

    private void a(String str, Animator animator) {
        animator.setTarget(this.tb.tg.x(str));
        if (Build.VERSION.SDK_INT < 21) {
            a(animator);
        }
        if (this.tb.mAnimators == null) {
            this.tb.mAnimators = new ArrayList<>();
            this.tb.th = new ArrayMap<>();
        }
        this.tb.mAnimators.add(animator);
        this.tb.th.put(animator, str);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        if (this.tp != null) {
            return ((AnimatedVectorDrawable) this.tp).isRunning();
        }
        ArrayList<Animator> arrayList = this.tb.mAnimators;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).isRunning()) {
                return true;
            }
        }
        return false;
    }

    private boolean isStarted() {
        ArrayList<Animator> arrayList = this.tb.mAnimators;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).isRunning()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.tp != null) {
            ((AnimatedVectorDrawable) this.tp).start();
        } else if (!isStarted()) {
            ArrayList<Animator> arrayList = this.tb.mAnimators;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                arrayList.get(i).start();
            }
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.tp != null) {
            ((AnimatedVectorDrawable) this.tp).stop();
            return;
        }
        ArrayList<Animator> arrayList = this.tb.mAnimators;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get(i).end();
        }
    }
}
