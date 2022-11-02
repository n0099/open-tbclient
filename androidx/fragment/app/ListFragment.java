package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ListFragment extends Fragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INTERNAL_EMPTY_ID = 16711681;
    public static final int INTERNAL_LIST_CONTAINER_ID = 16711683;
    public static final int INTERNAL_PROGRESS_CONTAINER_ID = 16711682;
    public transient /* synthetic */ FieldHolder $fh;
    public ListAdapter mAdapter;
    public CharSequence mEmptyText;
    public View mEmptyView;
    public final Handler mHandler;
    public ListView mList;
    public View mListContainer;
    public boolean mListShown;
    public final AdapterView.OnItemClickListener mOnClickListener;
    public View mProgressContainer;
    public final Runnable mRequestFocus;
    public TextView mStandardEmptyView;

    public void onListItemClick(@NonNull ListView listView, @NonNull View view2, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{listView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
        }
    }

    public ListFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHandler = new Handler();
        this.mRequestFocus = new Runnable(this) { // from class: androidx.fragment.app.ListFragment.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ListFragment this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    ListView listView = this.this$0.mList;
                    listView.focusableViewAvailable(listView);
                }
            }
        };
        this.mOnClickListener = new AdapterView.OnItemClickListener(this) { // from class: androidx.fragment.app.ListFragment.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ListFragment this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i3, long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i3), Long.valueOf(j)}) == null) {
                    this.this$0.onListItemClick((ListView) adapterView, view2, i3, j);
                }
            }
        };
    }

    @NonNull
    public final ListAdapter requireListAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ListAdapter listAdapter = getListAdapter();
            if (listAdapter != null) {
                return listAdapter;
            }
            throw new IllegalStateException("ListFragment " + this + " does not have a ListAdapter.");
        }
        return (ListAdapter) invokeV.objValue;
    }

    private void ensureList() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65537, this) != null) || this.mList != null) {
            return;
        }
        View view2 = getView();
        if (view2 != null) {
            if (view2 instanceof ListView) {
                this.mList = (ListView) view2;
            } else {
                TextView textView = (TextView) view2.findViewById(INTERNAL_EMPTY_ID);
                this.mStandardEmptyView = textView;
                if (textView == null) {
                    this.mEmptyView = view2.findViewById(16908292);
                } else {
                    textView.setVisibility(8);
                }
                this.mProgressContainer = view2.findViewById(INTERNAL_PROGRESS_CONTAINER_ID);
                this.mListContainer = view2.findViewById(INTERNAL_LIST_CONTAINER_ID);
                View findViewById = view2.findViewById(16908298);
                if (!(findViewById instanceof ListView)) {
                    if (findViewById == null) {
                        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                    }
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
                ListView listView = (ListView) findViewById;
                this.mList = listView;
                View view3 = this.mEmptyView;
                if (view3 != null) {
                    listView.setEmptyView(view3);
                } else {
                    CharSequence charSequence = this.mEmptyText;
                    if (charSequence != null) {
                        this.mStandardEmptyView.setText(charSequence);
                        this.mList.setEmptyView(this.mStandardEmptyView);
                    }
                }
            }
            this.mListShown = true;
            this.mList.setOnItemClickListener(this.mOnClickListener);
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                this.mAdapter = null;
                setListAdapter(listAdapter);
            } else if (this.mProgressContainer != null) {
                setListShown(false, false);
            }
            this.mHandler.post(this.mRequestFocus);
            return;
        }
        throw new IllegalStateException("Content view not yet created");
    }

    private void setListShown(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ensureList();
            View view2 = this.mProgressContainer;
            if (view2 != null) {
                if (this.mListShown == z) {
                    return;
                }
                this.mListShown = z;
                if (z) {
                    if (z2) {
                        view2.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
                        this.mListContainer.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                    } else {
                        view2.clearAnimation();
                        this.mListContainer.clearAnimation();
                    }
                    this.mProgressContainer.setVisibility(8);
                    this.mListContainer.setVisibility(0);
                    return;
                }
                if (z2) {
                    view2.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                    this.mListContainer.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
                } else {
                    view2.clearAnimation();
                    this.mListContainer.clearAnimation();
                }
                this.mProgressContainer.setVisibility(0);
                this.mListContainer.setVisibility(8);
                return;
            }
            throw new IllegalStateException("Can't be used with a custom content view");
        }
    }

    @Nullable
    public ListAdapter getListAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mAdapter;
        }
        return (ListAdapter) invokeV.objValue;
    }

    @NonNull
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ensureList();
            return this.mList;
        }
        return (ListView) invokeV.objValue;
    }

    public long getSelectedItemId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ensureList();
            return this.mList.getSelectedItemId();
        }
        return invokeV.longValue;
    }

    public int getSelectedItemPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ensureList();
            return this.mList.getSelectedItemPosition();
        }
        return invokeV.intValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mHandler.removeCallbacks(this.mRequestFocus);
            this.mList = null;
            this.mListShown = false;
            this.mListContainer = null;
            this.mProgressContainer = null;
            this.mEmptyView = null;
            this.mStandardEmptyView = null;
            super.onDestroyView();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            Context requireContext = requireContext();
            FrameLayout frameLayout = new FrameLayout(requireContext);
            LinearLayout linearLayout = new LinearLayout(requireContext);
            linearLayout.setId(INTERNAL_PROGRESS_CONTAINER_ID);
            linearLayout.setOrientation(1);
            linearLayout.setVisibility(8);
            linearLayout.setGravity(17);
            linearLayout.addView(new ProgressBar(requireContext, null, 16842874), new FrameLayout.LayoutParams(-2, -2));
            frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout frameLayout2 = new FrameLayout(requireContext);
            frameLayout2.setId(INTERNAL_LIST_CONTAINER_ID);
            TextView textView = new TextView(requireContext);
            textView.setId(INTERNAL_EMPTY_ID);
            textView.setGravity(17);
            frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
            ListView listView = new ListView(requireContext);
            listView.setId(16908298);
            listView.setDrawSelectorOnTop(false);
            frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return frameLayout;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            ensureList();
        }
    }

    public void setEmptyText(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, charSequence) == null) {
            ensureList();
            TextView textView = this.mStandardEmptyView;
            if (textView != null) {
                textView.setText(charSequence);
                if (this.mEmptyText == null) {
                    this.mList.setEmptyView(this.mStandardEmptyView);
                }
                this.mEmptyText = charSequence;
                return;
            }
            throw new IllegalStateException("Can't be used with a custom content view");
        }
    }

    public void setListShown(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            setListShown(z, true);
        }
    }

    public void setListShownNoAnimation(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            setListShown(z, false);
        }
    }

    public void setSelection(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            ensureList();
            this.mList.setSelection(i);
        }
    }

    public void setListAdapter(@Nullable ListAdapter listAdapter) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, listAdapter) == null) {
            boolean z2 = false;
            if (this.mAdapter != null) {
                z = true;
            } else {
                z = false;
            }
            this.mAdapter = listAdapter;
            ListView listView = this.mList;
            if (listView != null) {
                listView.setAdapter(listAdapter);
                if (!this.mListShown && !z) {
                    if (requireView().getWindowToken() != null) {
                        z2 = true;
                    }
                    setListShown(true, z2);
                }
            }
        }
    }
}
