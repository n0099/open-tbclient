package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
@Deprecated
/* loaded from: classes2.dex */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
    private static final ActionBarDrawerToggleImpl IMPL;
    final Activity mActivity;
    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private Drawable mDrawerImage;
    private final int mDrawerImageResource;
    private boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private Object mSetIndicatorInfo;
    private SlideDrawable mSlider;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface ActionBarDrawerToggleImpl {
        Drawable getThemeUpIndicator(Activity activity);

        Object setActionBarDescription(Object obj, Activity activity, int i);

        Object setActionBarUpIndicator(Object obj, Activity activity, Drawable drawable, int i);
    }

    /* loaded from: classes2.dex */
    public interface Delegate {
        Drawable getThemeUpIndicator();

        void setActionBarDescription(int i);

        void setActionBarUpIndicator(Drawable drawable, int i);
    }

    /* loaded from: classes2.dex */
    public interface DelegateProvider {
        Delegate getDrawerToggleDelegate();
    }

    /* loaded from: classes2.dex */
    private static class ActionBarDrawerToggleImplBase implements ActionBarDrawerToggleImpl {
        ActionBarDrawerToggleImplBase() {
        }

        @Override // android.support.v4.app.ActionBarDrawerToggle.ActionBarDrawerToggleImpl
        public Drawable getThemeUpIndicator(Activity activity) {
            return null;
        }

        @Override // android.support.v4.app.ActionBarDrawerToggle.ActionBarDrawerToggleImpl
        public Object setActionBarUpIndicator(Object obj, Activity activity, Drawable drawable, int i) {
            return obj;
        }

        @Override // android.support.v4.app.ActionBarDrawerToggle.ActionBarDrawerToggleImpl
        public Object setActionBarDescription(Object obj, Activity activity, int i) {
            return obj;
        }
    }

    /* loaded from: classes2.dex */
    private static class ActionBarDrawerToggleImplHC implements ActionBarDrawerToggleImpl {
        ActionBarDrawerToggleImplHC() {
        }

        @Override // android.support.v4.app.ActionBarDrawerToggle.ActionBarDrawerToggleImpl
        public Drawable getThemeUpIndicator(Activity activity) {
            return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(activity);
        }

        @Override // android.support.v4.app.ActionBarDrawerToggle.ActionBarDrawerToggleImpl
        public Object setActionBarUpIndicator(Object obj, Activity activity, Drawable drawable, int i) {
            return ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(obj, activity, drawable, i);
        }

        @Override // android.support.v4.app.ActionBarDrawerToggle.ActionBarDrawerToggleImpl
        public Object setActionBarDescription(Object obj, Activity activity, int i) {
            return ActionBarDrawerToggleHoneycomb.setActionBarDescription(obj, activity, i);
        }
    }

    /* loaded from: classes2.dex */
    private static class ActionBarDrawerToggleImplJellybeanMR2 implements ActionBarDrawerToggleImpl {
        ActionBarDrawerToggleImplJellybeanMR2() {
        }

        @Override // android.support.v4.app.ActionBarDrawerToggle.ActionBarDrawerToggleImpl
        public Drawable getThemeUpIndicator(Activity activity) {
            return ActionBarDrawerToggleJellybeanMR2.getThemeUpIndicator(activity);
        }

        @Override // android.support.v4.app.ActionBarDrawerToggle.ActionBarDrawerToggleImpl
        public Object setActionBarUpIndicator(Object obj, Activity activity, Drawable drawable, int i) {
            return ActionBarDrawerToggleJellybeanMR2.setActionBarUpIndicator(obj, activity, drawable, i);
        }

        @Override // android.support.v4.app.ActionBarDrawerToggle.ActionBarDrawerToggleImpl
        public Object setActionBarDescription(Object obj, Activity activity, int i) {
            return ActionBarDrawerToggleJellybeanMR2.setActionBarDescription(obj, activity, i);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 18) {
            IMPL = new ActionBarDrawerToggleImplJellybeanMR2();
        } else if (i >= 11) {
            IMPL = new ActionBarDrawerToggleImplHC();
        } else {
            IMPL = new ActionBarDrawerToggleImplBase();
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, int i, int i2, int i3) {
        this(activity, drawerLayout, !assumeMaterial(activity), i, i2, i3);
    }

    private static boolean assumeMaterial(Context context) {
        return context.getApplicationInfo().targetSdkVersion >= 21 && Build.VERSION.SDK_INT >= 21;
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, boolean z, int i, int i2, int i3) {
        this.mDrawerIndicatorEnabled = true;
        this.mActivity = activity;
        if (activity instanceof DelegateProvider) {
            this.mActivityImpl = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.mActivityImpl = null;
        }
        this.mDrawerLayout = drawerLayout;
        this.mDrawerImageResource = i;
        this.mOpenDrawerContentDescRes = i2;
        this.mCloseDrawerContentDescRes = i3;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        this.mDrawerImage = ContextCompat.getDrawable(activity, i);
        this.mSlider = new SlideDrawable(this.mDrawerImage);
        this.mSlider.setOffset(z ? 0.33333334f : 0.0f);
    }

    public void syncState() {
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.mSlider.setPosition(1.0f);
        } else {
            this.mSlider.setPosition(0.0f);
        }
        if (this.mDrawerIndicatorEnabled) {
            setActionBarUpIndicator(this.mSlider, this.mDrawerLayout.isDrawerOpen(GravityCompat.START) ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes);
        }
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        if (drawable == null) {
            this.mHomeAsUpIndicator = getThemeUpIndicator();
            this.mHasCustomUpIndicator = false;
        } else {
            this.mHomeAsUpIndicator = drawable;
            this.mHasCustomUpIndicator = true;
        }
        if (!this.mDrawerIndicatorEnabled) {
            setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        }
    }

    public void setHomeAsUpIndicator(int i) {
        Drawable drawable = null;
        if (i != 0) {
            drawable = ContextCompat.getDrawable(this.mActivity, i);
        }
        setHomeAsUpIndicator(drawable);
    }

    public void setDrawerIndicatorEnabled(boolean z) {
        if (z != this.mDrawerIndicatorEnabled) {
            if (z) {
                setActionBarUpIndicator(this.mSlider, this.mDrawerLayout.isDrawerOpen(GravityCompat.START) ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes);
            } else {
                setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
            }
            this.mDrawerIndicatorEnabled = z;
        }
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.mHasCustomUpIndicator) {
            this.mHomeAsUpIndicator = getThemeUpIndicator();
        }
        this.mDrawerImage = ContextCompat.getDrawable(this.mActivity, this.mDrawerImageResource);
        syncState();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem != null && menuItem.getItemId() == 16908332 && this.mDrawerIndicatorEnabled) {
            if (this.mDrawerLayout.isDrawerVisible(GravityCompat.START)) {
                this.mDrawerLayout.closeDrawer(GravityCompat.START);
            } else {
                this.mDrawerLayout.openDrawer(GravityCompat.START);
            }
            return true;
        }
        return false;
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View view, float f) {
        float min;
        float position = this.mSlider.getPosition();
        if (f > 0.5f) {
            min = Math.max(position, Math.max(0.0f, f - 0.5f) * 2.0f);
        } else {
            min = Math.min(position, f * 2.0f);
        }
        this.mSlider.setPosition(min);
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View view) {
        this.mSlider.setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled) {
            setActionBarDescription(this.mCloseDrawerContentDescRes);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View view) {
        this.mSlider.setPosition(0.0f);
        if (this.mDrawerIndicatorEnabled) {
            setActionBarDescription(this.mOpenDrawerContentDescRes);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i) {
    }

    Drawable getThemeUpIndicator() {
        return this.mActivityImpl != null ? this.mActivityImpl.getThemeUpIndicator() : IMPL.getThemeUpIndicator(this.mActivity);
    }

    void setActionBarUpIndicator(Drawable drawable, int i) {
        if (this.mActivityImpl != null) {
            this.mActivityImpl.setActionBarUpIndicator(drawable, i);
        } else {
            this.mSetIndicatorInfo = IMPL.setActionBarUpIndicator(this.mSetIndicatorInfo, this.mActivity, drawable, i);
        }
    }

    void setActionBarDescription(int i) {
        if (this.mActivityImpl != null) {
            this.mActivityImpl.setActionBarDescription(i);
        } else {
            this.mSetIndicatorInfo = IMPL.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class SlideDrawable extends InsetDrawable implements Drawable.Callback {
        private final boolean mHasMirroring;
        private float mOffset;
        private float mPosition;
        private final Rect mTmpRect;

        SlideDrawable(Drawable drawable) {
            super(drawable, 0);
            this.mHasMirroring = Build.VERSION.SDK_INT > 18;
            this.mTmpRect = new Rect();
        }

        public void setPosition(float f) {
            this.mPosition = f;
            invalidateSelf();
        }

        public float getPosition() {
            return this.mPosition;
        }

        public void setOffset(float f) {
            this.mOffset = f;
            invalidateSelf();
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            copyBounds(this.mTmpRect);
            canvas.save();
            boolean z = ViewCompat.getLayoutDirection(ActionBarDrawerToggle.this.mActivity.getWindow().getDecorView()) == 1;
            int i = z ? -1 : 1;
            int width = this.mTmpRect.width();
            canvas.translate(i * (-this.mOffset) * width * this.mPosition, 0.0f);
            if (z && !this.mHasMirroring) {
                canvas.translate(width, 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            super.draw(canvas);
            canvas.restore();
        }
    }
}
