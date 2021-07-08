package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes.dex */
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAttached;
    public int mContainerId;
    public Context mContext;
    public FragmentManager mFragmentManager;
    public TabInfo mLastTab;
    public TabHost.OnTabChangeListener mOnTabChangeListener;
    public FrameLayout mRealTabContent;
    public final ArrayList<TabInfo> mTabs;

    /* loaded from: classes.dex */
    public static class DummyTabFactory implements TabHost.TabContentFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context mContext;

        public DummyTabFactory(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mContext = context;
        }

        @Override // android.widget.TabHost.TabContentFactory
        public View createTabContent(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                View view = new View(this.mContext);
                view.setMinimumWidth(0);
                view.setMinimumHeight(0);
                return view;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public String curTab;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-566899417, "Landroidx/fragment/app/FragmentTabHost$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-566899417, "Landroidx/fragment/app/FragmentTabHost$SavedState;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.fragment.app.FragmentTabHost.SavedState.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel) : (SavedState) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
                }
            };
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable parcelable) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.curTab + "}";
            }
            return (String) invokeV.objValue;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                parcel.writeString(this.curTab);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel) {
            super(parcel);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.curTab = parcel.readString();
        }
    }

    /* loaded from: classes.dex */
    public static final class TabInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public final Bundle args;
        @NonNull
        public final Class<?> clss;
        public Fragment fragment;
        @NonNull
        public final String tag;

        public TabInfo(@NonNull String str, @NonNull Class<?> cls, @Nullable Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, cls, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.tag = str;
            this.clss = cls;
            this.args = bundle;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public FragmentTabHost(@NonNull Context context) {
        super(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTabs = new ArrayList<>();
        initFragmentTabHost(context, null);
    }

    @Nullable
    private FragmentTransaction doTabChanged(@Nullable String str, @Nullable FragmentTransaction fragmentTransaction) {
        InterceptResult invokeLL;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, fragmentTransaction)) == null) {
            TabInfo tabInfoForTag = getTabInfoForTag(str);
            if (this.mLastTab != tabInfoForTag) {
                if (fragmentTransaction == null) {
                    fragmentTransaction = this.mFragmentManager.beginTransaction();
                }
                TabInfo tabInfo = this.mLastTab;
                if (tabInfo != null && (fragment = tabInfo.fragment) != null) {
                    fragmentTransaction.detach(fragment);
                }
                if (tabInfoForTag != null) {
                    Fragment fragment2 = tabInfoForTag.fragment;
                    if (fragment2 == null) {
                        Fragment instantiate = this.mFragmentManager.getFragmentFactory().instantiate(this.mContext.getClassLoader(), tabInfoForTag.clss.getName());
                        tabInfoForTag.fragment = instantiate;
                        instantiate.setArguments(tabInfoForTag.args);
                        fragmentTransaction.add(this.mContainerId, tabInfoForTag.fragment, tabInfoForTag.tag);
                    } else {
                        fragmentTransaction.attach(fragment2);
                    }
                }
                this.mLastTab = tabInfoForTag;
            }
            return fragmentTransaction;
        }
        return (FragmentTransaction) invokeLL.objValue;
    }

    private void ensureContent() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.mRealTabContent == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(this.mContainerId);
            this.mRealTabContent = frameLayout;
            if (frameLayout != null) {
                return;
            }
            throw new IllegalStateException("No tab content FrameLayout found for id " + this.mContainerId);
        }
    }

    private void ensureHierarchy(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) && findViewById(16908307) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(16908307);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(16908305);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, 0.0f));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.mRealTabContent = frameLayout2;
            frameLayout2.setId(this.mContainerId);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    @Nullable
    private TabInfo getTabInfoForTag(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str)) == null) {
            int size = this.mTabs.size();
            for (int i2 = 0; i2 < size; i2++) {
                TabInfo tabInfo = this.mTabs.get(i2);
                if (tabInfo.tag.equals(str)) {
                    return tabInfo;
                }
            }
            return null;
        }
        return (TabInfo) invokeL.objValue;
    }

    private void initFragmentTabHost(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
            this.mContainerId = obtainStyledAttributes.getResourceId(0, 0);
            obtainStyledAttributes.recycle();
            super.setOnTabChangedListener(this);
        }
    }

    @Deprecated
    public void addTab(@NonNull TabHost.TabSpec tabSpec, @NonNull Class<?> cls, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, tabSpec, cls, bundle) == null) {
            tabSpec.setContent(new DummyTabFactory(this.mContext));
            String tag = tabSpec.getTag();
            TabInfo tabInfo = new TabInfo(tag, cls, bundle);
            if (this.mAttached) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(tag);
                tabInfo.fragment = findFragmentByTag;
                if (findFragmentByTag != null && !findFragmentByTag.isDetached()) {
                    FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
                    beginTransaction.detach(tabInfo.fragment);
                    beginTransaction.commit();
                }
            }
            this.mTabs.add(tabInfo);
            addTab(tabSpec);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onAttachedToWindow();
            String currentTabTag = getCurrentTabTag();
            int size = this.mTabs.size();
            FragmentTransaction fragmentTransaction = null;
            for (int i2 = 0; i2 < size; i2++) {
                TabInfo tabInfo = this.mTabs.get(i2);
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(tabInfo.tag);
                tabInfo.fragment = findFragmentByTag;
                if (findFragmentByTag != null && !findFragmentByTag.isDetached()) {
                    if (tabInfo.tag.equals(currentTabTag)) {
                        this.mLastTab = tabInfo;
                    } else {
                        if (fragmentTransaction == null) {
                            fragmentTransaction = this.mFragmentManager.beginTransaction();
                        }
                        fragmentTransaction.detach(tabInfo.fragment);
                    }
                }
            }
            this.mAttached = true;
            FragmentTransaction doTabChanged = doTabChanged(currentTabTag, fragmentTransaction);
            if (doTabChanged != null) {
                doTabChanged.commit();
                this.mFragmentManager.executePendingTransactions();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDetachedFromWindow();
            this.mAttached = false;
        }
    }

    @Override // android.view.View
    @Deprecated
    public void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, parcelable) == null) {
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(parcelable);
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setCurrentTabByTag(savedState.curTab);
        }
    }

    @Override // android.view.View
    @NonNull
    @Deprecated
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.curTab = getCurrentTabTag();
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(@Nullable String str) {
        FragmentTransaction doTabChanged;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (this.mAttached && (doTabChanged = doTabChanged(str, null)) != null) {
                doTabChanged.commit();
            }
            TabHost.OnTabChangeListener onTabChangeListener = this.mOnTabChangeListener;
            if (onTabChangeListener != null) {
                onTabChangeListener.onTabChanged(str);
            }
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(@Nullable TabHost.OnTabChangeListener onTabChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onTabChangeListener) == null) {
            this.mOnTabChangeListener = onTabChangeListener;
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
        }
    }

    @Deprecated
    public void setup(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, fragmentManager) == null) {
            ensureHierarchy(context);
            super.setup();
            this.mContext = context;
            this.mFragmentManager = fragmentManager;
            ensureContent();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public FragmentTabHost(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTabs = new ArrayList<>();
        initFragmentTabHost(context, attributeSet);
    }

    @Deprecated
    public void setup(@NonNull Context context, @NonNull FragmentManager fragmentManager, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048585, this, context, fragmentManager, i2) == null) {
            ensureHierarchy(context);
            super.setup();
            this.mContext = context;
            this.mFragmentManager = fragmentManager;
            this.mContainerId = i2;
            ensureContent();
            this.mRealTabContent.setId(i2);
            if (getId() == -1) {
                setId(16908306);
            }
        }
    }
}
