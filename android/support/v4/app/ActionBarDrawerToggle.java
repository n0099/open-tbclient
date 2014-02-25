package android.support.v4.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
/* loaded from: classes.dex */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
    private static final int ID_HOME = 16908332;
    private static final ActionBarDrawerToggleImpl IMPL;
    private final Activity mActivity;
    private final int mCloseDrawerContentDescRes;
    private Drawable mDrawerImage;
    private final int mDrawerImageResource;
    private boolean mDrawerIndicatorEnabled = true;
    private final DrawerLayout mDrawerLayout;
    private final int mOpenDrawerContentDescRes;
    private Object mSetIndicatorInfo;
    private SlideDrawable mSlider;
    private Drawable mThemeImage;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface ActionBarDrawerToggleImpl {
        Drawable getThemeUpIndicator(Activity activity);

        Object setActionBarDescription(Object obj, Activity activity, int i);

        Object setActionBarUpIndicator(Object obj, Activity activity, Drawable drawable, int i);
    }

    /* loaded from: classes.dex */
    class ActionBarDrawerToggleImplBase implements ActionBarDrawerToggleImpl {
        private ActionBarDrawerToggleImplBase() {
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

    /* loaded from: classes.dex */
    class ActionBarDrawerToggleImplHC implements ActionBarDrawerToggleImpl {
        private ActionBarDrawerToggleImplHC() {
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

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new ActionBarDrawerToggleImplHC();
        } else {
            IMPL = new ActionBarDrawerToggleImplBase();
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, int i, int i2, int i3) {
        this.mActivity = activity;
        this.mDrawerLayout = drawerLayout;
        this.mDrawerImageResource = i;
        this.mOpenDrawerContentDescRes = i2;
        this.mCloseDrawerContentDescRes = i3;
        this.mThemeImage = IMPL.getThemeUpIndicator(activity);
        this.mDrawerImage = activity.getResources().getDrawable(i);
        this.mSlider = new SlideDrawable(this.mDrawerImage);
        this.mSlider.setOffsetBy(0.33333334f);
    }

    public void syncState() {
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.mSlider.setOffset(1.0f);
        } else {
            this.mSlider.setOffset(0.0f);
        }
        if (this.mDrawerIndicatorEnabled) {
            this.mSetIndicatorInfo = IMPL.setActionBarUpIndicator(this.mSetIndicatorInfo, this.mActivity, this.mSlider, this.mDrawerLayout.isDrawerOpen(GravityCompat.START) ? this.mOpenDrawerContentDescRes : this.mCloseDrawerContentDescRes);
        }
    }

    public void setDrawerIndicatorEnabled(boolean z) {
        if (z != this.mDrawerIndicatorEnabled) {
            if (z) {
                this.mSetIndicatorInfo = IMPL.setActionBarUpIndicator(this.mSetIndicatorInfo, this.mActivity, this.mSlider, this.mDrawerLayout.isDrawerOpen(GravityCompat.START) ? this.mOpenDrawerContentDescRes : this.mCloseDrawerContentDescRes);
            } else {
                this.mSetIndicatorInfo = IMPL.setActionBarUpIndicator(this.mSetIndicatorInfo, this.mActivity, this.mThemeImage, 0);
            }
            this.mDrawerIndicatorEnabled = z;
        }
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mThemeImage = IMPL.getThemeUpIndicator(this.mActivity);
        this.mDrawerImage = this.mActivity.getResources().getDrawable(this.mDrawerImageResource);
        syncState();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem != null && menuItem.getItemId() == ID_HOME && this.mDrawerIndicatorEnabled) {
            if (this.mDrawerLayout.isDrawerVisible(GravityCompat.START)) {
                this.mDrawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
            this.mDrawerLayout.openDrawer(GravityCompat.START);
            return false;
        }
        return false;
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View view, float f) {
        float min;
        float offset = this.mSlider.getOffset();
        if (f > 0.5f) {
            min = Math.max(offset, Math.max(0.0f, f - 0.5f) * 2.0f);
        } else {
            min = Math.min(offset, f * 2.0f);
        }
        this.mSlider.setOffset(min);
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View view) {
        this.mSlider.setOffset(1.0f);
        if (this.mDrawerIndicatorEnabled) {
            this.mSetIndicatorInfo = IMPL.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, this.mOpenDrawerContentDescRes);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View view) {
        this.mSlider.setOffset(0.0f);
        if (this.mDrawerIndicatorEnabled) {
            this.mSetIndicatorInfo = IMPL.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, this.mCloseDrawerContentDescRes);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class SlideDrawable extends Drawable implements Drawable.Callback {
        private float mOffset;
        private float mOffsetBy;
        private final Rect mTmpRect = new Rect();
        private Drawable mWrapped;

        public SlideDrawable(Drawable drawable) {
            this.mWrapped = drawable;
        }

        public void setOffset(float f) {
            this.mOffset = f;
            invalidateSelf();
        }

        public float getOffset() {
            return this.mOffset;
        }

        public void setOffsetBy(float f) {
            this.mOffsetBy = f;
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            this.mWrapped.copyBounds(this.mTmpRect);
            canvas.save();
            canvas.translate(this.mOffsetBy * this.mTmpRect.width() * (-this.mOffset), 0.0f);
            this.mWrapped.draw(canvas);
            canvas.restore();
        }

        @Override // android.graphics.drawable.Drawable
        public void setChangingConfigurations(int i) {
            this.mWrapped.setChangingConfigurations(i);
        }

        @Override // android.graphics.drawable.Drawable
        public int getChangingConfigurations() {
            return this.mWrapped.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable
        public void setDither(boolean z) {
            this.mWrapped.setDither(z);
        }

        @Override // android.graphics.drawable.Drawable
        public void setFilterBitmap(boolean z) {
            this.mWrapped.setFilterBitmap(z);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            this.mWrapped.setAlpha(i);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.mWrapped.setColorFilter(colorFilter);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(int i, PorterDuff.Mode mode) {
            this.mWrapped.setColorFilter(i, mode);
        }

        @Override // android.graphics.drawable.Drawable
        public void clearColorFilter() {
            this.mWrapped.clearColorFilter();
        }

        @Override // android.graphics.drawable.Drawable
        public boolean isStateful() {
            return this.mWrapped.isStateful();
        }

        @Override // android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            return this.mWrapped.setState(iArr);
        }

        @Override // android.graphics.drawable.Drawable
        public int[] getState() {
            return this.mWrapped.getState();
        }

        @Override // android.graphics.drawable.Drawable
        public Drawable getCurrent() {
            return this.mWrapped.getCurrent();
        }

        @Override // android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            return super.setVisible(z, z2);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return this.mWrapped.getOpacity();
        }

        @Override // android.graphics.drawable.Drawable
        public Region getTransparentRegion() {
            return this.mWrapped.getTransparentRegion();
        }

        @Override // android.graphics.drawable.Drawable
        protected boolean onStateChange(int[] iArr) {
            this.mWrapped.setState(iArr);
            return super.onStateChange(iArr);
        }

        @Override // android.graphics.drawable.Drawable
        protected void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            this.mWrapped.setBounds(rect);
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return this.mWrapped.getIntrinsicWidth();
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return this.mWrapped.getIntrinsicHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return this.mWrapped.getMinimumWidth();
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return this.mWrapped.getMinimumHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return this.mWrapped.getPadding(rect);
        }

        @Override // android.graphics.drawable.Drawable
        public Drawable.ConstantState getConstantState() {
            return super.getConstantState();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (drawable == this.mWrapped) {
                invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (drawable == this.mWrapped) {
                scheduleSelf(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (drawable == this.mWrapped) {
                unscheduleSelf(runnable);
            }
        }
    }
}
