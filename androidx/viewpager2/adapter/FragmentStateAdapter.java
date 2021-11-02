package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class FragmentStateAdapter extends RecyclerView.Adapter<FragmentViewHolder> implements StatefulAdapter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long GRACE_WINDOW_TIME_MS = 10000;
    public static final String KEY_PREFIX_FRAGMENT = "f#";
    public static final String KEY_PREFIX_STATE = "s#";
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentManager mFragmentManager;
    public FragmentMaxLifecycleEnforcer mFragmentMaxLifecycleEnforcer;
    public final LongSparseArray<Fragment> mFragments;
    public boolean mHasStaleFragments;
    public boolean mIsInGracePeriod;
    public final LongSparseArray<Integer> mItemIdToViewHolder;
    public final Lifecycle mLifecycle;
    public final LongSparseArray<Fragment.SavedState> mSavedStates;

    /* loaded from: classes.dex */
    public static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DataSetChangeObserver() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                onChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
                onChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048580, this, i2, i3, i4) == null) {
                onChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
                onChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i2, int i3, @Nullable Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj) == null) {
                onChanged();
            }
        }
    }

    /* loaded from: classes.dex */
    public class FragmentMaxLifecycleEnforcer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RecyclerView.AdapterDataObserver mDataObserver;
        public LifecycleEventObserver mLifecycleObserver;
        public ViewPager2.OnPageChangeCallback mPageChangeCallback;
        public long mPrimaryItemId;
        public ViewPager2 mViewPager;
        public final /* synthetic */ FragmentStateAdapter this$0;

        public FragmentMaxLifecycleEnforcer(FragmentStateAdapter fragmentStateAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragmentStateAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = fragmentStateAdapter;
            this.mPrimaryItemId = -1L;
        }

        @NonNull
        private ViewPager2 inferViewPager(@NonNull RecyclerView recyclerView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, recyclerView)) == null) {
                ViewParent parent = recyclerView.getParent();
                if (parent instanceof ViewPager2) {
                    return (ViewPager2) parent;
                }
                throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
            }
            return (ViewPager2) invokeL.objValue;
        }

        public void register(@NonNull RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, recyclerView) == null) {
                this.mViewPager = inferViewPager(recyclerView);
                ViewPager2.OnPageChangeCallback onPageChangeCallback = new ViewPager2.OnPageChangeCallback(this) { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FragmentMaxLifecycleEnforcer this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                    public void onPageScrollStateChanged(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            this.this$1.updateFragmentMaxLifecycle(false);
                        }
                    }

                    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                    public void onPageSelected(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                            this.this$1.updateFragmentMaxLifecycle(false);
                        }
                    }
                };
                this.mPageChangeCallback = onPageChangeCallback;
                this.mViewPager.registerOnPageChangeCallback(onPageChangeCallback);
                DataSetChangeObserver dataSetChangeObserver = new DataSetChangeObserver(this) { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FragmentMaxLifecycleEnforcer this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                AnonymousClass1 anonymousClass1 = (AnonymousClass1) newInitContext.callArgs[0];
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // androidx.viewpager2.adapter.FragmentStateAdapter.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                    public void onChanged() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$1.updateFragmentMaxLifecycle(true);
                        }
                    }
                };
                this.mDataObserver = dataSetChangeObserver;
                this.this$0.registerAdapterDataObserver(dataSetChangeObserver);
                LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver(this) { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FragmentMaxLifecycleEnforcer this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, lifecycleOwner, event) == null) {
                            this.this$1.updateFragmentMaxLifecycle(false);
                        }
                    }
                };
                this.mLifecycleObserver = lifecycleEventObserver;
                this.this$0.mLifecycle.addObserver(lifecycleEventObserver);
            }
        }

        public void unregister(@NonNull RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView) == null) {
                inferViewPager(recyclerView).unregisterOnPageChangeCallback(this.mPageChangeCallback);
                this.this$0.unregisterAdapterDataObserver(this.mDataObserver);
                this.this$0.mLifecycle.removeObserver(this.mLifecycleObserver);
                this.mViewPager = null;
            }
        }

        public void updateFragmentMaxLifecycle(boolean z) {
            int currentItem;
            Fragment fragment;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.this$0.shouldDelayFragmentTransactions() || this.mViewPager.getScrollState() != 0 || this.this$0.mFragments.isEmpty() || this.this$0.getItemCount() == 0 || (currentItem = this.mViewPager.getCurrentItem()) >= this.this$0.getItemCount()) {
                return;
            }
            long itemId = this.this$0.getItemId(currentItem);
            if ((itemId != this.mPrimaryItemId || z) && (fragment = this.this$0.mFragments.get(itemId)) != null && fragment.isAdded()) {
                this.mPrimaryItemId = itemId;
                FragmentTransaction beginTransaction = this.this$0.mFragmentManager.beginTransaction();
                Fragment fragment2 = null;
                for (int i2 = 0; i2 < this.this$0.mFragments.size(); i2++) {
                    long keyAt = this.this$0.mFragments.keyAt(i2);
                    Fragment valueAt = this.this$0.mFragments.valueAt(i2);
                    if (valueAt.isAdded()) {
                        if (keyAt != this.mPrimaryItemId) {
                            beginTransaction.setMaxLifecycle(valueAt, Lifecycle.State.STARTED);
                        } else {
                            fragment2 = valueAt;
                        }
                        valueAt.setMenuVisibility(keyAt == this.mPrimaryItemId);
                    }
                }
                if (fragment2 != null) {
                    beginTransaction.setMaxLifecycle(fragment2, Lifecycle.State.RESUMED);
                }
                if (beginTransaction.isEmpty()) {
                    return;
                }
                beginTransaction.commitNow();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        this(fragmentActivity.getSupportFragmentManager(), fragmentActivity.getLifecycle());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((FragmentManager) objArr2[0], (Lifecycle) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @NonNull
    public static String createKey(@NonNull String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, str, j)) == null) {
            return str + j;
        }
        return (String) invokeLJ.objValue;
    }

    private void ensureFragment(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) {
            long itemId = getItemId(i2);
            if (this.mFragments.containsKey(itemId)) {
                return;
            }
            Fragment createFragment = createFragment(i2);
            createFragment.setInitialSavedState(this.mSavedStates.get(itemId));
            this.mFragments.put(itemId, createFragment);
        }
    }

    private boolean isFragmentViewBound(long j) {
        InterceptResult invokeJ;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, this, j)) == null) {
            if (this.mItemIdToViewHolder.containsKey(j)) {
                return true;
            }
            Fragment fragment = this.mFragments.get(j);
            return (fragment == null || (view = fragment.getView()) == null || view.getParent() == null) ? false : true;
        }
        return invokeJ.booleanValue;
    }

    public static boolean isValidKey(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2)) == null) ? str.startsWith(str2) && str.length() > str2.length() : invokeLL.booleanValue;
    }

    private Long itemForViewHolder(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i2)) == null) {
            Long l = null;
            for (int i3 = 0; i3 < this.mItemIdToViewHolder.size(); i3++) {
                if (this.mItemIdToViewHolder.valueAt(i3).intValue() == i2) {
                    if (l == null) {
                        l = Long.valueOf(this.mItemIdToViewHolder.keyAt(i3));
                    } else {
                        throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                    }
                }
            }
            return l;
        }
        return (Long) invokeI.objValue;
    }

    public static long parseIdFromKey(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) ? Long.parseLong(str.substring(str2.length())) : invokeLL.longValue;
    }

    private void removeFragment(long j) {
        Fragment fragment;
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(65545, this, j) == null) || (fragment = this.mFragments.get(j)) == null) {
            return;
        }
        if (fragment.getView() != null && (parent = fragment.getView().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!containsItem(j)) {
            this.mSavedStates.remove(j);
        }
        if (!fragment.isAdded()) {
            this.mFragments.remove(j);
        } else if (shouldDelayFragmentTransactions()) {
            this.mHasStaleFragments = true;
        } else {
            if (fragment.isAdded() && containsItem(j)) {
                this.mSavedStates.put(j, this.mFragmentManager.saveFragmentInstanceState(fragment));
            }
            this.mFragmentManager.beginTransaction().remove(fragment).commitNow();
            this.mFragments.remove(j);
        }
    }

    private void scheduleGracePeriodEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            Runnable runnable = new Runnable(this) { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FragmentStateAdapter this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        FragmentStateAdapter fragmentStateAdapter = this.this$0;
                        fragmentStateAdapter.mIsInGracePeriod = false;
                        fragmentStateAdapter.gcFragments();
                    }
                }
            };
            this.mLifecycle.addObserver(new LifecycleEventObserver(this, handler, runnable) { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FragmentStateAdapter this$0;
                public final /* synthetic */ Handler val$handler;
                public final /* synthetic */ Runnable val$runnable;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, handler, runnable};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$handler = handler;
                    this.val$runnable = runnable;
                }

                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, lifecycleOwner, event) == null) && event == Lifecycle.Event.ON_DESTROY) {
                        this.val$handler.removeCallbacks(this.val$runnable);
                        lifecycleOwner.getLifecycle().removeObserver(this);
                    }
                }
            });
            handler.postDelayed(runnable, 10000L);
        }
    }

    private void scheduleViewAttach(Fragment fragment, @NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, this, fragment, frameLayout) == null) {
            this.mFragmentManager.registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks(this, fragment, frameLayout) { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FragmentStateAdapter this$0;
                public final /* synthetic */ FrameLayout val$container;
                public final /* synthetic */ Fragment val$fragment;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, fragment, frameLayout};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$fragment = fragment;
                    this.val$container = frameLayout;
                }

                @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
                public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment2, @NonNull View view, @Nullable Bundle bundle) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLLLL(1048576, this, fragmentManager, fragment2, view, bundle) == null) && fragment2 == this.val$fragment) {
                        fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                        this.this$0.addViewToContainer(view, this.val$container);
                    }
                }
            }, false);
        }
    }

    public void addViewToContainer(@NonNull View view, @NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, frameLayout) == null) {
            if (frameLayout.getChildCount() <= 1) {
                if (view.getParent() == frameLayout) {
                    return;
                }
                if (frameLayout.getChildCount() > 0) {
                    frameLayout.removeAllViews();
                }
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                frameLayout.addView(view);
                return;
            }
            throw new IllegalStateException("Design assumption violated.");
        }
    }

    public boolean containsItem(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? j >= 0 && j < ((long) getItemCount()) : invokeJ.booleanValue;
    }

    @NonNull
    public abstract Fragment createFragment(int i2);

    public void gcFragments() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.mHasStaleFragments && !shouldDelayFragmentTransactions()) {
            ArraySet<Long> arraySet = new ArraySet();
            for (int i2 = 0; i2 < this.mFragments.size(); i2++) {
                long keyAt = this.mFragments.keyAt(i2);
                if (!containsItem(keyAt)) {
                    arraySet.add(Long.valueOf(keyAt));
                    this.mItemIdToViewHolder.remove(keyAt);
                }
            }
            if (!this.mIsInGracePeriod) {
                this.mHasStaleFragments = false;
                for (int i3 = 0; i3 < this.mFragments.size(); i3++) {
                    long keyAt2 = this.mFragments.keyAt(i3);
                    if (!isFragmentViewBound(keyAt2)) {
                        arraySet.add(Long.valueOf(keyAt2));
                    }
                }
            }
            for (Long l : arraySet) {
                removeFragment(l.longValue());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, recyclerView) == null) {
            Preconditions.checkArgument(this.mFragmentMaxLifecycleEnforcer == null);
            FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer(this);
            this.mFragmentMaxLifecycleEnforcer = fragmentMaxLifecycleEnforcer;
            fragmentMaxLifecycleEnforcer.register(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, recyclerView) == null) {
            this.mFragmentMaxLifecycleEnforcer.unregister(recyclerView);
            this.mFragmentMaxLifecycleEnforcer = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(@NonNull FragmentViewHolder fragmentViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, fragmentViewHolder)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void placeFragmentInViewHolder(@NonNull FragmentViewHolder fragmentViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, fragmentViewHolder) == null) {
            Fragment fragment = this.mFragments.get(fragmentViewHolder.getItemId());
            if (fragment != null) {
                FrameLayout container = fragmentViewHolder.getContainer();
                View view = fragment.getView();
                if (!fragment.isAdded() && view != null) {
                    throw new IllegalStateException("Design assumption violated.");
                }
                if (fragment.isAdded() && view == null) {
                    scheduleViewAttach(fragment, container);
                    return;
                } else if (fragment.isAdded() && view.getParent() != null) {
                    if (view.getParent() != container) {
                        addViewToContainer(view, container);
                        return;
                    }
                    return;
                } else if (fragment.isAdded()) {
                    addViewToContainer(view, container);
                    return;
                } else if (!shouldDelayFragmentTransactions()) {
                    scheduleViewAttach(fragment, container);
                    FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
                    beginTransaction.add(fragment, "f" + fragmentViewHolder.getItemId()).setMaxLifecycle(fragment, Lifecycle.State.STARTED).commitNow();
                    this.mFragmentMaxLifecycleEnforcer.updateFragmentMaxLifecycle(false);
                    return;
                } else if (this.mFragmentManager.isDestroyed()) {
                    return;
                } else {
                    this.mLifecycle.addObserver(new LifecycleEventObserver(this, fragmentViewHolder) { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ FragmentStateAdapter this$0;
                        public final /* synthetic */ FragmentViewHolder val$holder;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, fragmentViewHolder};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$holder = fragmentViewHolder;
                        }

                        @Override // androidx.lifecycle.LifecycleEventObserver
                        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, lifecycleOwner, event) == null) || this.this$0.shouldDelayFragmentTransactions()) {
                                return;
                            }
                            lifecycleOwner.getLifecycle().removeObserver(this);
                            if (ViewCompat.isAttachedToWindow(this.val$holder.getContainer())) {
                                this.this$0.placeFragmentInViewHolder(this.val$holder);
                            }
                        }
                    });
                    return;
                }
            }
            throw new IllegalStateException("Design assumption violated.");
        }
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final void restoreState(@NonNull Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, parcelable) == null) {
            if (this.mSavedStates.isEmpty() && this.mFragments.isEmpty()) {
                Bundle bundle = (Bundle) parcelable;
                if (bundle.getClassLoader() == null) {
                    bundle.setClassLoader(FragmentStateAdapter.class.getClassLoader());
                }
                for (String str : bundle.keySet()) {
                    if (isValidKey(str, KEY_PREFIX_FRAGMENT)) {
                        this.mFragments.put(parseIdFromKey(str, KEY_PREFIX_FRAGMENT), this.mFragmentManager.getFragment(bundle, str));
                    } else if (isValidKey(str, KEY_PREFIX_STATE)) {
                        long parseIdFromKey = parseIdFromKey(str, KEY_PREFIX_STATE);
                        Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(str);
                        if (containsItem(parseIdFromKey)) {
                            this.mSavedStates.put(parseIdFromKey, savedState);
                        }
                    } else {
                        throw new IllegalArgumentException("Unexpected key in savedState: " + str);
                    }
                }
                if (this.mFragments.isEmpty()) {
                    return;
                }
                this.mHasStaleFragments = true;
                this.mIsInGracePeriod = true;
                gcFragments();
                scheduleGracePeriodEnd();
                return;
            }
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    @NonNull
    public final Parcelable saveState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            Bundle bundle = new Bundle(this.mFragments.size() + this.mSavedStates.size());
            for (int i2 = 0; i2 < this.mFragments.size(); i2++) {
                long keyAt = this.mFragments.keyAt(i2);
                Fragment fragment = this.mFragments.get(keyAt);
                if (fragment != null && fragment.isAdded()) {
                    this.mFragmentManager.putFragment(bundle, createKey(KEY_PREFIX_FRAGMENT, keyAt), fragment);
                }
            }
            for (int i3 = 0; i3 < this.mSavedStates.size(); i3++) {
                long keyAt2 = this.mSavedStates.keyAt(i3);
                if (containsItem(keyAt2)) {
                    bundle.putParcelable(createKey(KEY_PREFIX_STATE, keyAt2), this.mSavedStates.get(keyAt2));
                }
            }
            return bundle;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
        }
    }

    public boolean shouldDelayFragmentTransactions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mFragmentManager.isStateSaved() : invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FragmentStateAdapter(@NonNull Fragment fragment) {
        this(fragment.getChildFragmentManager(), fragment.getLifecycle());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((FragmentManager) objArr2[0], (Lifecycle) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(@NonNull FragmentViewHolder fragmentViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, fragmentViewHolder, i2) == null) {
            long itemId = fragmentViewHolder.getItemId();
            int id = fragmentViewHolder.getContainer().getId();
            Long itemForViewHolder = itemForViewHolder(id);
            if (itemForViewHolder != null && itemForViewHolder.longValue() != itemId) {
                removeFragment(itemForViewHolder.longValue());
                this.mItemIdToViewHolder.remove(itemForViewHolder.longValue());
            }
            this.mItemIdToViewHolder.put(itemId, Integer.valueOf(id));
            ensureFragment(i2);
            FrameLayout container = fragmentViewHolder.getContainer();
            if (ViewCompat.isAttachedToWindow(container)) {
                if (container.getParent() == null) {
                    container.addOnLayoutChangeListener(new View.OnLayoutChangeListener(this, container, fragmentViewHolder) { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ FragmentStateAdapter this$0;
                        public final /* synthetic */ FrameLayout val$container;
                        public final /* synthetic */ FragmentViewHolder val$holder;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, container, fragmentViewHolder};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$container = container;
                            this.val$holder = fragmentViewHolder;
                        }

                        @Override // android.view.View.OnLayoutChangeListener
                        public void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10)}) == null) || this.val$container.getParent() == null) {
                                return;
                            }
                            this.val$container.removeOnLayoutChangeListener(this);
                            this.this$0.placeFragmentInViewHolder(this.val$holder);
                        }
                    });
                } else {
                    throw new IllegalStateException("Design assumption violated.");
                }
            }
            gcFragments();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final FragmentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, viewGroup, i2)) == null) ? FragmentViewHolder.create(viewGroup) : (FragmentViewHolder) invokeLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(@NonNull FragmentViewHolder fragmentViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, fragmentViewHolder) == null) {
            placeFragmentInViewHolder(fragmentViewHolder);
            gcFragments();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(@NonNull FragmentViewHolder fragmentViewHolder) {
        Long itemForViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, fragmentViewHolder) == null) || (itemForViewHolder = itemForViewHolder(fragmentViewHolder.getContainer().getId())) == null) {
            return;
        }
        removeFragment(itemForViewHolder.longValue());
        this.mItemIdToViewHolder.remove(itemForViewHolder.longValue());
    }

    public FragmentStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentManager, lifecycle};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mFragments = new LongSparseArray<>();
        this.mSavedStates = new LongSparseArray<>();
        this.mItemIdToViewHolder = new LongSparseArray<>();
        this.mIsInGracePeriod = false;
        this.mHasStaleFragments = false;
        this.mFragmentManager = fragmentManager;
        this.mLifecycle = lifecycle;
        super.setHasStableIds(true);
    }
}
