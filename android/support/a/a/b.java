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
    private a tc;
    private ArgbEvaluator td;
    C0000b te;

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
        this.td = null;
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
            this.tc = aVar;
        } else {
            this.tc = new a(context, aVar, this.mCallback, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.tq != null) {
            this.tq.mutate();
            return this;
        }
        throw new IllegalStateException("Mutate() is not supported for older platform");
    }

    public static b d(Context context, int i) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            b bVar = new b(context);
            bVar.tq = ResourcesCompat.getDrawable(context.getResources(), i, context.getTheme());
            bVar.tq.setCallback(bVar.mCallback);
            bVar.te = new C0000b(bVar.tq.getConstantState());
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
        if (this.tq != null) {
            return new C0000b(this.tq.getConstantState());
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.tq != null ? this.tq.getChangingConfigurations() : super.getChangingConfigurations() | this.tc.tg;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.tq != null) {
            this.tq.draw(canvas);
            return;
        }
        this.tc.th.draw(canvas);
        if (isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.support.a.a.e, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.tq != null) {
            this.tq.setBounds(rect);
        } else {
            this.tc.th.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return this.tq != null ? this.tq.setState(iArr) : this.tc.th.setState(iArr);
    }

    @Override // android.support.a.a.e, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.tq != null ? this.tq.setLevel(i) : this.tc.th.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.tq != null ? DrawableCompat.getAlpha(this.tq) : this.tc.th.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.tq != null) {
            this.tq.setAlpha(i);
        } else {
            this.tc.th.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.tq != null) {
            this.tq.setColorFilter(colorFilter);
        } else {
            this.tc.th.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        if (this.tq != null) {
            DrawableCompat.setTint(this.tq, i);
        } else {
            this.tc.th.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.tq != null) {
            DrawableCompat.setTintList(this.tq, colorStateList);
        } else {
            this.tc.th.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.tq != null) {
            DrawableCompat.setTintMode(this.tq, mode);
        } else {
            this.tc.th.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.tq != null) {
            return this.tq.setVisible(z, z2);
        }
        this.tc.th.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.tq != null ? this.tq.isStateful() : this.tc.th.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.tq != null ? this.tq.getOpacity() : this.tc.th.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.tq != null ? this.tq.getIntrinsicWidth() : this.tc.th.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.tq != null ? this.tq.getIntrinsicHeight() : this.tc.th.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.tq != null ? DrawableCompat.isAutoMirrored(this.tq) : this.tc.th.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.tq != null) {
            this.tq.setAutoMirrored(z);
        } else {
            this.tc.th.setAutoMirrored(z);
        }
    }

    static TypedArray a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.tq != null) {
            DrawableCompat.inflate(this.tq, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1) {
            if (xmlPullParser.getDepth() >= depth || eventType != 3) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if ("animated-vector".equals(name)) {
                        TypedArray a2 = a(resources, theme, attributeSet, android.support.a.a.a.sZ);
                        int resourceId = a2.getResourceId(0, 0);
                        if (resourceId != 0) {
                            f a3 = f.a(resources, resourceId, theme);
                            a3.t(false);
                            a3.setCallback(this.mCallback);
                            if (this.tc.th != null) {
                                this.tc.th.setCallback(null);
                            }
                            this.tc.th = a3;
                        }
                        a2.recycle();
                    } else if (BaiduRimConstants.ACTION_TARGET.equals(name)) {
                        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, android.support.a.a.a.tb);
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
        if (this.tq != null) {
            DrawableCompat.applyTheme(this.tq, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.tq != null) {
            return DrawableCompat.canApplyTheme(this.tq);
        }
        return false;
    }

    /* renamed from: android.support.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0000b extends Drawable.ConstantState {
        private final Drawable.ConstantState tj;

        public C0000b(Drawable.ConstantState constantState) {
            this.tj = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            b bVar = new b();
            bVar.tq = this.tj.newDrawable();
            bVar.tq.setCallback(bVar.mCallback);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            b bVar = new b();
            bVar.tq = this.tj.newDrawable(resources);
            bVar.tq.setCallback(bVar.mCallback);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            b bVar = new b();
            bVar.tq = this.tj.newDrawable(resources, theme);
            bVar.tq.setCallback(bVar.mCallback);
            return bVar;
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
    /* loaded from: classes2.dex */
    public static class a extends Drawable.ConstantState {
        ArrayList<Animator> mAnimators;
        int tg;
        f th;
        ArrayMap<Animator, String> ti;

        public a(Context context, a aVar, Drawable.Callback callback, Resources resources) {
            if (aVar != null) {
                this.tg = aVar.tg;
                if (aVar.th != null) {
                    Drawable.ConstantState constantState = aVar.th.getConstantState();
                    if (resources != null) {
                        this.th = (f) constantState.newDrawable(resources);
                    } else {
                        this.th = (f) constantState.newDrawable();
                    }
                    this.th = (f) this.th.mutate();
                    this.th.setCallback(callback);
                    this.th.setBounds(aVar.th.getBounds());
                    this.th.t(false);
                }
                if (aVar.mAnimators != null) {
                    int size = aVar.mAnimators.size();
                    this.mAnimators = new ArrayList<>(size);
                    this.ti = new ArrayMap<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = aVar.mAnimators.get(i);
                        Animator clone = animator.clone();
                        String str = aVar.ti.get(animator);
                        clone.setTarget(this.th.x(str));
                        this.mAnimators.add(clone);
                        this.ti.put(clone, str);
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
            return this.tg;
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
                if (this.td == null) {
                    this.td = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.td);
            }
        }
    }

    private void a(String str, Animator animator) {
        animator.setTarget(this.tc.th.x(str));
        if (Build.VERSION.SDK_INT < 21) {
            a(animator);
        }
        if (this.tc.mAnimators == null) {
            this.tc.mAnimators = new ArrayList<>();
            this.tc.ti = new ArrayMap<>();
        }
        this.tc.mAnimators.add(animator);
        this.tc.ti.put(animator, str);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        if (this.tq != null) {
            return ((AnimatedVectorDrawable) this.tq).isRunning();
        }
        ArrayList<Animator> arrayList = this.tc.mAnimators;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).isRunning()) {
                return true;
            }
        }
        return false;
    }

    private boolean isStarted() {
        ArrayList<Animator> arrayList = this.tc.mAnimators;
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
        if (this.tq != null) {
            ((AnimatedVectorDrawable) this.tq).start();
        } else if (!isStarted()) {
            ArrayList<Animator> arrayList = this.tc.mAnimators;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                arrayList.get(i).start();
            }
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.tq != null) {
            ((AnimatedVectorDrawable) this.tq).stop();
            return;
        }
        ArrayList<Animator> arrayList = this.tc.mAnimators;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get(i).end();
        }
    }
}
