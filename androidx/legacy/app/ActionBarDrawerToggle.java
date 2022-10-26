package androidx.legacy.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
@Deprecated
/* loaded from: classes.dex */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ID_HOME = 16908332;
    public static final String TAG = "ActionBarDrawerToggle";
    public static final int[] THEME_ATTRS;
    public static final float TOGGLE_DRAWABLE_OFFSET = 0.33333334f;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity mActivity;
    public final Delegate mActivityImpl;
    public final int mCloseDrawerContentDescRes;
    public Drawable mDrawerImage;
    public final int mDrawerImageResource;
    public boolean mDrawerIndicatorEnabled;
    public final DrawerLayout mDrawerLayout;
    public boolean mHasCustomUpIndicator;
    public Drawable mHomeAsUpIndicator;
    public final int mOpenDrawerContentDescRes;
    public SetIndicatorInfo mSetIndicatorInfo;
    public SlideDrawable mSlider;

    @Deprecated
    /* loaded from: classes.dex */
    public interface Delegate {
        Drawable getThemeUpIndicator();

        void setActionBarDescription(int i);

        void setActionBarUpIndicator(Drawable drawable, int i);
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface DelegateProvider {
        Delegate getDrawerToggleDelegate();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
        }
    }

    /* loaded from: classes.dex */
    public static class SetIndicatorInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Method mSetHomeActionContentDescription;
        public Method mSetHomeAsUpIndicator;
        public ImageView mUpIndicatorView;

        public SetIndicatorInfo(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            try {
                this.mSetHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
                this.mSetHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
            } catch (NoSuchMethodException unused) {
                View findViewById = activity.findViewById(ActionBarDrawerToggle.ID_HOME);
                if (findViewById == null) {
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                if (viewGroup.getChildCount() != 2) {
                    return;
                }
                View childAt = viewGroup.getChildAt(0);
                childAt = childAt.getId() == 16908332 ? viewGroup.getChildAt(1) : childAt;
                if (childAt instanceof ImageView) {
                    this.mUpIndicatorView = (ImageView) childAt;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class SlideDrawable extends InsetDrawable implements Drawable.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean mHasMirroring;
        public float mOffset;
        public float mPosition;
        public final Rect mTmpRect;
        public final /* synthetic */ ActionBarDrawerToggle this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SlideDrawable(ActionBarDrawerToggle actionBarDrawerToggle, Drawable drawable) {
            super(drawable, 0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {actionBarDrawerToggle, drawable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Drawable) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = actionBarDrawerToggle;
            this.mHasMirroring = Build.VERSION.SDK_INT > 18;
            this.mTmpRect = new Rect();
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
                copyBounds(this.mTmpRect);
                canvas.save();
                int i = 1;
                if (ViewCompat.getLayoutDirection(this.this$0.mActivity.getWindow().getDecorView()) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    i = -1;
                }
                float width = this.mTmpRect.width();
                canvas.translate((-this.mOffset) * width * this.mPosition * i, 0.0f);
                if (z && !this.mHasMirroring) {
                    canvas.translate(width, 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                super.draw(canvas);
                canvas.restore();
            }
        }

        public float getPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mPosition;
            }
            return invokeV.floatValue;
        }

        public void setOffset(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f) == null) {
                this.mOffset = f;
                invalidateSelf();
            }
        }

        public void setPosition(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
                this.mPosition = f;
                invalidateSelf();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-900065101, "Landroidx/legacy/app/ActionBarDrawerToggle;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-900065101, "Landroidx/legacy/app/ActionBarDrawerToggle;");
                return;
            }
        }
        THEME_ATTRS = new int[]{16843531};
    }

    public boolean isDrawerIndicatorEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mDrawerIndicatorEnabled;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, int i, int i2, int i3) {
        this(activity, drawerLayout, !assumeMaterial(activity), i, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, drawerLayout, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Activity) objArr2[0], (DrawerLayout) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Integer) objArr2[5]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, boolean z, int i, int i2, int i3) {
        float f;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, drawerLayout, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
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
        SlideDrawable slideDrawable = new SlideDrawable(this, this.mDrawerImage);
        this.mSlider = slideDrawable;
        if (z) {
            f = 0.33333334f;
        } else {
            f = 0.0f;
        }
        slideDrawable.setOffset(f);
    }

    public static boolean assumeMaterial(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context.getApplicationInfo().targetSdkVersion >= 21 && Build.VERSION.SDK_INT >= 21) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, configuration) == null) {
            if (!this.mHasCustomUpIndicator) {
                this.mHomeAsUpIndicator = getThemeUpIndicator();
            }
            this.mDrawerImage = ContextCompat.getDrawable(this.mActivity, this.mDrawerImageResource);
            syncState();
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            this.mSlider.setPosition(0.0f);
            if (this.mDrawerIndicatorEnabled) {
                setActionBarDescription(this.mOpenDrawerContentDescRes);
            }
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            this.mSlider.setPosition(1.0f);
            if (this.mDrawerIndicatorEnabled) {
                setActionBarDescription(this.mCloseDrawerContentDescRes);
            }
        }
    }

    public void setHomeAsUpIndicator(int i) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            if (i != 0) {
                drawable = ContextCompat.getDrawable(this.mActivity, i);
            } else {
                drawable = null;
            }
            setHomeAsUpIndicator(drawable);
        }
    }

    private Drawable getThemeUpIndicator() {
        InterceptResult invokeV;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            Delegate delegate = this.mActivityImpl;
            if (delegate != null) {
                return delegate.getThemeUpIndicator();
            }
            if (Build.VERSION.SDK_INT >= 18) {
                ActionBar actionBar = this.mActivity.getActionBar();
                if (actionBar != null) {
                    context = actionBar.getThemedContext();
                } else {
                    context = this.mActivity;
                }
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, THEME_ATTRS, 16843470, 0);
                Drawable drawable = obtainStyledAttributes.getDrawable(0);
                obtainStyledAttributes.recycle();
                return drawable;
            }
            TypedArray obtainStyledAttributes2 = this.mActivity.obtainStyledAttributes(THEME_ATTRS);
            Drawable drawable2 = obtainStyledAttributes2.getDrawable(0);
            obtainStyledAttributes2.recycle();
            return drawable2;
        }
        return (Drawable) invokeV.objValue;
    }

    private void setActionBarDescription(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, this, i) == null) {
            Delegate delegate = this.mActivityImpl;
            if (delegate != null) {
                delegate.setActionBarDescription(i);
            } else if (Build.VERSION.SDK_INT >= 18) {
                ActionBar actionBar = this.mActivity.getActionBar();
                if (actionBar != null) {
                    actionBar.setHomeActionContentDescription(i);
                }
            } else {
                if (this.mSetIndicatorInfo == null) {
                    this.mSetIndicatorInfo = new SetIndicatorInfo(this.mActivity);
                }
                if (this.mSetIndicatorInfo.mSetHomeAsUpIndicator != null) {
                    try {
                        ActionBar actionBar2 = this.mActivity.getActionBar();
                        this.mSetIndicatorInfo.mSetHomeActionContentDescription.invoke(actionBar2, Integer.valueOf(i));
                        actionBar2.setSubtitle(actionBar2.getSubtitle());
                    } catch (Exception e) {
                        Log.w(TAG, "Couldn't set content description via JB-MR2 API", e);
                    }
                }
            }
        }
    }

    private void setActionBarUpIndicator(Drawable drawable, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, this, drawable, i) == null) {
            Delegate delegate = this.mActivityImpl;
            if (delegate != null) {
                delegate.setActionBarUpIndicator(drawable, i);
            } else if (Build.VERSION.SDK_INT >= 18) {
                ActionBar actionBar = this.mActivity.getActionBar();
                if (actionBar != null) {
                    actionBar.setHomeAsUpIndicator(drawable);
                    actionBar.setHomeActionContentDescription(i);
                }
            } else {
                if (this.mSetIndicatorInfo == null) {
                    this.mSetIndicatorInfo = new SetIndicatorInfo(this.mActivity);
                }
                SetIndicatorInfo setIndicatorInfo = this.mSetIndicatorInfo;
                if (setIndicatorInfo.mSetHomeAsUpIndicator != null) {
                    try {
                        ActionBar actionBar2 = this.mActivity.getActionBar();
                        this.mSetIndicatorInfo.mSetHomeAsUpIndicator.invoke(actionBar2, drawable);
                        this.mSetIndicatorInfo.mSetHomeActionContentDescription.invoke(actionBar2, Integer.valueOf(i));
                        return;
                    } catch (Exception e) {
                        Log.w(TAG, "Couldn't set home-as-up indicator via JB-MR2 API", e);
                        return;
                    }
                }
                ImageView imageView = setIndicatorInfo.mUpIndicatorView;
                if (imageView != null) {
                    imageView.setImageDrawable(drawable);
                } else {
                    Log.w(TAG, "Couldn't set home-as-up indicator");
                }
            }
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View view2, float f) {
        float min;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048580, this, view2, f) == null) {
            float position = this.mSlider.getPosition();
            if (f > 0.5f) {
                min = Math.max(position, Math.max(0.0f, f - 0.5f) * 2.0f);
            } else {
                min = Math.min(position, f * 2.0f);
            }
            this.mSlider.setPosition(min);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, menuItem)) == null) {
            if (menuItem != null && menuItem.getItemId() == 16908332 && this.mDrawerIndicatorEnabled) {
                if (this.mDrawerLayout.isDrawerVisible(GravityCompat.START)) {
                    this.mDrawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                }
                this.mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setDrawerIndicatorEnabled(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && z != this.mDrawerIndicatorEnabled) {
            if (z) {
                SlideDrawable slideDrawable = this.mSlider;
                if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    i = this.mCloseDrawerContentDescRes;
                } else {
                    i = this.mOpenDrawerContentDescRes;
                }
                setActionBarUpIndicator(slideDrawable, i);
            } else {
                setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
            }
            this.mDrawerIndicatorEnabled = z;
        }
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, drawable) == null) {
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
    }

    public void syncState() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                this.mSlider.setPosition(1.0f);
            } else {
                this.mSlider.setPosition(0.0f);
            }
            if (this.mDrawerIndicatorEnabled) {
                SlideDrawable slideDrawable = this.mSlider;
                if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    i = this.mCloseDrawerContentDescRes;
                } else {
                    i = this.mOpenDrawerContentDescRes;
                }
                setActionBarUpIndicator(slideDrawable, i);
            }
        }
    }
}
