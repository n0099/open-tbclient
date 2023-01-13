package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.ActionProvider;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup implements ActivityChooserModel.ActivityChooserModelClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View mActivityChooserContent;
    public final Drawable mActivityChooserContentBackground;
    public final ActivityChooserViewAdapter mAdapter;
    public final Callbacks mCallbacks;
    public int mDefaultActionButtonContentDescription;
    public final FrameLayout mDefaultActivityButton;
    public final ImageView mDefaultActivityButtonImage;
    public final FrameLayout mExpandActivityOverflowButton;
    public final ImageView mExpandActivityOverflowButtonImage;
    public int mInitialActivityCount;
    public boolean mIsAttachedToWindow;
    public boolean mIsSelectingDefaultActivity;
    public final int mListPopupMaxWidth;
    public ListPopupWindow mListPopupWindow;
    public final DataSetObserver mModelDataSetObserver;
    public PopupWindow.OnDismissListener mOnDismissListener;
    public final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    public ActionProvider mProvider;

    /* loaded from: classes.dex */
    public class ActivityChooserViewAdapter extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ITEM_VIEW_TYPE_ACTIVITY = 0;
        public static final int ITEM_VIEW_TYPE_COUNT = 3;
        public static final int ITEM_VIEW_TYPE_FOOTER = 1;
        public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
        public static final int MAX_ACTIVITY_COUNT_UNLIMITED = Integer.MAX_VALUE;
        public transient /* synthetic */ FieldHolder $fh;
        public ActivityChooserModel mDataModel;
        public boolean mHighlightDefaultActivity;
        public int mMaxActivityCount;
        public boolean mShowDefaultActivity;
        public boolean mShowFooterView;
        public final /* synthetic */ ActivityChooserView this$0;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i : invokeI.longValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        public ActivityChooserViewAdapter(ActivityChooserView activityChooserView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activityChooserView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = activityChooserView;
            this.mMaxActivityCount = 4;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                if (this.mShowFooterView && i == getCount() - 1) {
                    return 1;
                }
                return 0;
            }
            return invokeI.intValue;
        }

        public void setMaxActivityCount(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048589, this, i) == null) && this.mMaxActivityCount != i) {
                this.mMaxActivityCount = i;
                notifyDataSetChanged();
            }
        }

        public void setShowFooterView(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && this.mShowFooterView != z) {
                this.mShowFooterView = z;
                notifyDataSetChanged();
            }
        }

        public int getActivityCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mDataModel.getActivityCount();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int activityCount = this.mDataModel.getActivityCount();
                if (!this.mShowDefaultActivity && this.mDataModel.getDefaultActivity() != null) {
                    activityCount--;
                }
                int min = Math.min(activityCount, this.mMaxActivityCount);
                if (this.mShowFooterView) {
                    return min + 1;
                }
                return min;
            }
            return invokeV.intValue;
        }

        public ActivityChooserModel getDataModel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mDataModel;
            }
            return (ActivityChooserModel) invokeV.objValue;
        }

        public ResolveInfo getDefaultActivity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mDataModel.getDefaultActivity();
            }
            return (ResolveInfo) invokeV.objValue;
        }

        public int getHistorySize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mDataModel.getHistorySize();
            }
            return invokeV.intValue;
        }

        public boolean getShowDefaultActivity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.mShowDefaultActivity;
            }
            return invokeV.booleanValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                int itemViewType = getItemViewType(i);
                if (itemViewType != 0) {
                    if (itemViewType == 1) {
                        return null;
                    }
                    throw new IllegalArgumentException();
                }
                if (!this.mShowDefaultActivity && this.mDataModel.getDefaultActivity() != null) {
                    i++;
                }
                return this.mDataModel.getActivity(i);
            }
            return invokeI.objValue;
        }

        public void setDataModel(ActivityChooserModel activityChooserModel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, activityChooserModel) == null) {
                ActivityChooserModel dataModel = this.this$0.mAdapter.getDataModel();
                if (dataModel != null && this.this$0.isShown()) {
                    dataModel.unregisterObserver(this.this$0.mModelDataSetObserver);
                }
                this.mDataModel = activityChooserModel;
                if (activityChooserModel != null && this.this$0.isShown()) {
                    activityChooserModel.registerObserver(this.this$0.mModelDataSetObserver);
                }
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view2, viewGroup)) == null) {
                int itemViewType = getItemViewType(i);
                if (itemViewType != 0) {
                    if (itemViewType == 1) {
                        if (view2 == null || view2.getId() != 1) {
                            View inflate = LayoutInflater.from(this.this$0.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0007, viewGroup, false);
                            inflate.setId(1);
                            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0922ff)).setText(this.this$0.getContext().getString(R.string.obfuscated_res_0x7f0f003f));
                            return inflate;
                        }
                        return view2;
                    }
                    throw new IllegalArgumentException();
                }
                if (view2 == null || view2.getId() != R.id.obfuscated_res_0x7f0913cc) {
                    view2 = LayoutInflater.from(this.this$0.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0007, viewGroup, false);
                }
                PackageManager packageManager = this.this$0.getContext().getPackageManager();
                ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                ((ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ea0)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922ff)).setText(resolveInfo.loadLabel(packageManager));
                if (this.mShowDefaultActivity && i == 0 && this.mHighlightDefaultActivity) {
                    view2.setActivated(true);
                } else {
                    view2.setActivated(false);
                }
                return view2;
            }
            return (View) invokeILL.objValue;
        }

        public int measureContentWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                int i = this.mMaxActivityCount;
                this.mMaxActivityCount = Integer.MAX_VALUE;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                int count = getCount();
                View view2 = null;
                int i2 = 0;
                for (int i3 = 0; i3 < count; i3++) {
                    view2 = getView(i3, view2, null);
                    view2.measure(makeMeasureSpec, makeMeasureSpec2);
                    i2 = Math.max(i2, view2.getMeasuredWidth());
                }
                this.mMaxActivityCount = i;
                return i2;
            }
            return invokeV.intValue;
        }

        public void setShowDefaultActivity(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (this.mShowDefaultActivity != z || this.mHighlightDefaultActivity != z2) {
                    this.mShowDefaultActivity = z;
                    this.mHighlightDefaultActivity = z2;
                    notifyDataSetChanged();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Callbacks implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ActivityChooserView this$0;

        public Callbacks(ActivityChooserView activityChooserView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activityChooserView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = activityChooserView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) {
                ActivityChooserView activityChooserView = this.this$0;
                if (view2 == activityChooserView.mDefaultActivityButton) {
                    if (activityChooserView.mAdapter.getCount() > 0) {
                        ActivityChooserView activityChooserView2 = this.this$0;
                        activityChooserView2.mIsSelectingDefaultActivity = true;
                        activityChooserView2.showPopupUnchecked(activityChooserView2.mInitialActivityCount);
                    }
                    return true;
                }
                throw new IllegalArgumentException();
            }
            return invokeL.booleanValue;
        }

        private void notifyOnDismissListener() {
            PopupWindow.OnDismissListener onDismissListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65537, this) == null) && (onDismissListener = this.this$0.mOnDismissListener) != null) {
                onDismissListener.onDismiss();
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                notifyOnDismissListener();
                ActionProvider actionProvider = this.this$0.mProvider;
                if (actionProvider != null) {
                    actionProvider.subUiVisibilityChanged(false);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ActivityChooserView activityChooserView = this.this$0;
                if (view2 == activityChooserView.mDefaultActivityButton) {
                    activityChooserView.dismissPopup();
                    Intent chooseActivity = this.this$0.mAdapter.getDataModel().chooseActivity(this.this$0.mAdapter.getDataModel().getActivityIndex(this.this$0.mAdapter.getDefaultActivity()));
                    if (chooseActivity != null) {
                        chooseActivity.addFlags(524288);
                        this.this$0.getContext().startActivity(chooseActivity);
                    }
                } else if (view2 == activityChooserView.mExpandActivityOverflowButton) {
                    activityChooserView.mIsSelectingDefaultActivity = false;
                    activityChooserView.showPopupUnchecked(activityChooserView.mInitialActivityCount);
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                int itemViewType = ((ActivityChooserViewAdapter) adapterView.getAdapter()).getItemViewType(i);
                if (itemViewType != 0) {
                    if (itemViewType == 1) {
                        this.this$0.showPopupUnchecked(Integer.MAX_VALUE);
                        return;
                    }
                    throw new IllegalArgumentException();
                }
                this.this$0.dismissPopup();
                ActivityChooserView activityChooserView = this.this$0;
                if (activityChooserView.mIsSelectingDefaultActivity) {
                    if (i > 0) {
                        activityChooserView.mAdapter.getDataModel().setDefaultActivity(i);
                        return;
                    }
                    return;
                }
                if (!activityChooserView.mAdapter.getShowDefaultActivity()) {
                    i++;
                }
                Intent chooseActivity = this.this$0.mAdapter.getDataModel().chooseActivity(i);
                if (chooseActivity != null) {
                    chooseActivity.addFlags(524288);
                    this.this$0.getContext().startActivity(chooseActivity);
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public static class InnerLayout extends LinearLayout {
        public static /* synthetic */ Interceptable $ic;
        public static final int[] TINT_ATTRS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(273116947, "Landroidx/appcompat/widget/ActivityChooserView$InnerLayout;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(273116947, "Landroidx/appcompat/widget/ActivityChooserView$InnerLayout;");
                    return;
                }
            }
            TINT_ATTRS = new int[]{16842964};
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, TINT_ATTRS);
            setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActivityChooserView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActivityChooserView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityChooserView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mModelDataSetObserver = new DataSetObserver(this) { // from class: androidx.appcompat.widget.ActivityChooserView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ActivityChooserView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.onChanged();
                    this.this$0.mAdapter.notifyDataSetChanged();
                }
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.onInvalidated();
                    this.this$0.mAdapter.notifyDataSetInvalidated();
                }
            }
        };
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: androidx.appcompat.widget.ActivityChooserView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ActivityChooserView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.isShowingPopup()) {
                    if (!this.this$0.isShown()) {
                        this.this$0.getListPopupWindow().dismiss();
                        return;
                    }
                    this.this$0.getListPopupWindow().show();
                    ActionProvider actionProvider = this.this$0.mProvider;
                    if (actionProvider != null) {
                        actionProvider.subUiVisibilityChanged(true);
                    }
                }
            }
        };
        this.mInitialActivityCount = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.ActivityChooserView, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, androidx.appcompat.R.styleable.ActivityChooserView, attributeSet, obtainStyledAttributes, i, 0);
        this.mInitialActivityCount = obtainStyledAttributes.getInt(1, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0006, (ViewGroup) this, true);
        this.mCallbacks = new Callbacks(this);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f090074);
        this.mActivityChooserContent = findViewById;
        this.mActivityChooserContentBackground = findViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0907b1);
        this.mDefaultActivityButton = frameLayout;
        frameLayout.setOnClickListener(this.mCallbacks);
        this.mDefaultActivityButton.setOnLongClickListener(this.mCallbacks);
        this.mDefaultActivityButtonImage = (ImageView) this.mDefaultActivityButton.findViewById(R.id.obfuscated_res_0x7f090f20);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09098a);
        frameLayout2.setOnClickListener(this.mCallbacks);
        frameLayout2.setAccessibilityDelegate(new View.AccessibilityDelegate(this) { // from class: androidx.appcompat.widget.ActivityChooserView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ActivityChooserView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfo accessibilityNodeInfo) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, view2, accessibilityNodeInfo) == null) {
                    super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfo);
                    AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCanOpenPopup(true);
                }
            }
        });
        frameLayout2.setOnTouchListener(new ForwardingListener(this, frameLayout2) { // from class: androidx.appcompat.widget.ActivityChooserView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ActivityChooserView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(frameLayout2);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this, frameLayout2};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super((View) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            public ShowableListMenu getPopup() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return this.this$0.getListPopupWindow();
                }
                return (ShowableListMenu) invokeV.objValue;
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            public boolean onForwardingStarted() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    this.this$0.showPopup();
                    return true;
                }
                return invokeV.booleanValue;
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            public boolean onForwardingStopped() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    this.this$0.dismissPopup();
                    return true;
                }
                return invokeV.booleanValue;
            }
        });
        this.mExpandActivityOverflowButton = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(R.id.obfuscated_res_0x7f090f20);
        this.mExpandActivityOverflowButtonImage = imageView;
        imageView.setImageDrawable(drawable);
        ActivityChooserViewAdapter activityChooserViewAdapter = new ActivityChooserViewAdapter(this);
        this.mAdapter = activityChooserViewAdapter;
        activityChooserViewAdapter.registerDataSetObserver(new DataSetObserver(this) { // from class: androidx.appcompat.widget.ActivityChooserView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ActivityChooserView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.onChanged();
                    this.this$0.updateAppearance();
                }
            }
        });
        Resources resources = context.getResources();
        this.mListPopupMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700a2));
    }

    public boolean dismissPopup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (isShowingPopup()) {
                getListPopupWindow().dismiss();
                ViewTreeObserver viewTreeObserver = getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
                    return true;
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public ActivityChooserModel getDataModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mAdapter.getDataModel();
        }
        return (ActivityChooserModel) invokeV.objValue;
    }

    public boolean isShowingPopup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return getListPopupWindow().isShowing();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            ActivityChooserModel dataModel = this.mAdapter.getDataModel();
            if (dataModel != null) {
                dataModel.registerObserver(this.mModelDataSetObserver);
            }
            this.mIsAttachedToWindow = true;
        }
    }

    public boolean showPopup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (isShowingPopup() || !this.mIsAttachedToWindow) {
                return false;
            }
            this.mIsSelectingDefaultActivity = false;
            showPopupUnchecked(this.mInitialActivityCount);
            return true;
        }
        return invokeV.booleanValue;
    }

    public ListPopupWindow getListPopupWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mListPopupWindow == null) {
                ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
                this.mListPopupWindow = listPopupWindow;
                listPopupWindow.setAdapter(this.mAdapter);
                this.mListPopupWindow.setAnchorView(this);
                this.mListPopupWindow.setModal(true);
                this.mListPopupWindow.setOnItemClickListener(this.mCallbacks);
                this.mListPopupWindow.setOnDismissListener(this.mCallbacks);
            }
            return this.mListPopupWindow;
        }
        return (ListPopupWindow) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            ActivityChooserModel dataModel = this.mAdapter.getDataModel();
            if (dataModel != null) {
                dataModel.unregisterObserver(this.mModelDataSetObserver);
            }
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
            }
            if (isShowingPopup()) {
                dismissPopup();
            }
            this.mIsAttachedToWindow = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.mActivityChooserContent.layout(0, 0, i3 - i, i4 - i2);
            if (!isShowingPopup()) {
                dismissPopup();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
            View view2 = this.mActivityChooserContent;
            if (this.mDefaultActivityButton.getVisibility() != 0) {
                i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
            }
            measureChild(view2, i, i2);
            setMeasuredDimension(view2.getMeasuredWidth(), view2.getMeasuredHeight());
        }
    }

    @Override // androidx.appcompat.widget.ActivityChooserModel.ActivityChooserModelClient
    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activityChooserModel) == null) {
            this.mAdapter.setDataModel(activityChooserModel);
            if (isShowingPopup()) {
                dismissPopup();
                showPopup();
            }
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.mDefaultActionButtonContentDescription = i;
        }
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.mExpandActivityOverflowButtonImage.setContentDescription(getContext().getString(i));
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, drawable) == null) {
            this.mExpandActivityOverflowButtonImage.setImageDrawable(drawable);
        }
    }

    public void setInitialActivityCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.mInitialActivityCount = i;
        }
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onDismissListener) == null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setProvider(ActionProvider actionProvider) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, actionProvider) == null) {
            this.mProvider = actionProvider;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v7, resolved type: androidx.appcompat.widget.ActivityChooserView$ActivityChooserViewAdapter */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int, boolean] */
    public void showPopupUnchecked(int i) {
        ?? r0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            if (this.mAdapter.getDataModel() != null) {
                getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
                if (this.mDefaultActivityButton.getVisibility() == 0) {
                    r0 = 1;
                } else {
                    r0 = 0;
                }
                int activityCount = this.mAdapter.getActivityCount();
                if (i != Integer.MAX_VALUE && activityCount > i + r0) {
                    this.mAdapter.setShowFooterView(true);
                    this.mAdapter.setMaxActivityCount(i - 1);
                } else {
                    this.mAdapter.setShowFooterView(false);
                    this.mAdapter.setMaxActivityCount(i);
                }
                ListPopupWindow listPopupWindow = getListPopupWindow();
                if (!listPopupWindow.isShowing()) {
                    if (!this.mIsSelectingDefaultActivity && r0 != 0) {
                        this.mAdapter.setShowDefaultActivity(false, false);
                    } else {
                        this.mAdapter.setShowDefaultActivity(true, r0);
                    }
                    listPopupWindow.setContentWidth(Math.min(this.mAdapter.measureContentWidth(), this.mListPopupMaxWidth));
                    listPopupWindow.show();
                    ActionProvider actionProvider = this.mProvider;
                    if (actionProvider != null) {
                        actionProvider.subUiVisibilityChanged(true);
                    }
                    listPopupWindow.getListView().setContentDescription(getContext().getString(R.string.obfuscated_res_0x7f0f0040));
                    listPopupWindow.getListView().setSelector(new ColorDrawable(0));
                    return;
                }
                return;
            }
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
    }

    public void updateAppearance() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.mAdapter.getCount() > 0) {
                this.mExpandActivityOverflowButton.setEnabled(true);
            } else {
                this.mExpandActivityOverflowButton.setEnabled(false);
            }
            int activityCount = this.mAdapter.getActivityCount();
            int historySize = this.mAdapter.getHistorySize();
            if (activityCount != 1 && (activityCount <= 1 || historySize <= 0)) {
                this.mDefaultActivityButton.setVisibility(8);
            } else {
                this.mDefaultActivityButton.setVisibility(0);
                ResolveInfo defaultActivity = this.mAdapter.getDefaultActivity();
                PackageManager packageManager = getContext().getPackageManager();
                this.mDefaultActivityButtonImage.setImageDrawable(defaultActivity.loadIcon(packageManager));
                if (this.mDefaultActionButtonContentDescription != 0) {
                    this.mDefaultActivityButton.setContentDescription(getContext().getString(this.mDefaultActionButtonContentDescription, defaultActivity.loadLabel(packageManager)));
                }
            }
            if (this.mDefaultActivityButton.getVisibility() == 0) {
                this.mActivityChooserContent.setBackgroundDrawable(this.mActivityChooserContentBackground);
            } else {
                this.mActivityChooserContent.setBackgroundDrawable(null);
            }
        }
    }
}
