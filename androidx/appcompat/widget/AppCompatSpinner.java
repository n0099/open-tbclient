package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AppCompatSpinner extends Spinner implements TintableBackgroundView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] ATTRS_ANDROID_SPINNERMODE;
    public static final int MAX_ITEMS_MEASURED = 15;
    public static final int MODE_DIALOG = 0;
    public static final int MODE_DROPDOWN = 1;
    public static final int MODE_THEME = -1;
    public static final String TAG = "AppCompatSpinner";
    public transient /* synthetic */ FieldHolder $fh;
    public final AppCompatBackgroundHelper mBackgroundTintHelper;
    public int mDropDownWidth;
    public ForwardingListener mForwardingListener;
    public SpinnerPopup mPopup;
    public final Context mPopupContext;
    public final boolean mPopupSet;
    public SpinnerAdapter mTempAdapter;
    public final Rect mTempRect;

    @VisibleForTesting
    /* loaded from: classes.dex */
    public class DialogPopup implements SpinnerPopup, DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ListAdapter mListAdapter;
        @VisibleForTesting
        public AlertDialog mPopup;
        public CharSequence mPrompt;
        public final /* synthetic */ AppCompatSpinner this$0;

        public DialogPopup(AppCompatSpinner appCompatSpinner) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appCompatSpinner};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = appCompatSpinner;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void dismiss() {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (alertDialog = this.mPopup) == null) {
                return;
            }
            alertDialog.dismiss();
            this.mPopup = null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public Drawable getBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (Drawable) invokeV.objValue;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public CharSequence getHintText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPrompt : (CharSequence) invokeV.objValue;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getHorizontalOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getHorizontalOriginalOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getVerticalOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public boolean isShowing() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                AlertDialog alertDialog = this.mPopup;
                if (alertDialog != null) {
                    return alertDialog.isShowing();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, dialogInterface, i) == null) {
                this.this$0.setSelection(i);
                if (this.this$0.getOnItemClickListener() != null) {
                    this.this$0.performItemClick(null, i, this.mListAdapter.getItemId(i));
                }
                dismiss();
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setAdapter(ListAdapter listAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, listAdapter) == null) {
                this.mListAdapter = listAdapter;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setBackgroundDrawable(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, drawable) == null) {
                Log.e(AppCompatSpinner.TAG, "Cannot set popup background for MODE_DIALOG, ignoring");
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setHorizontalOffset(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
                Log.e(AppCompatSpinner.TAG, "Cannot set horizontal offset for MODE_DIALOG, ignoring");
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setHorizontalOriginalOffset(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
                Log.e(AppCompatSpinner.TAG, "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setPromptText(CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, charSequence) == null) {
                this.mPrompt = charSequence;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setVerticalOffset(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
                Log.e(AppCompatSpinner.TAG, "Cannot set vertical offset for MODE_DIALOG, ignoring");
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void show(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048590, this, i, i2) == null) || this.mListAdapter == null) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this.this$0.getPopupContext());
            CharSequence charSequence = this.mPrompt;
            if (charSequence != null) {
                builder.setTitle(charSequence);
            }
            AlertDialog create = builder.setSingleChoiceItems(this.mListAdapter, this.this$0.getSelectedItemPosition(), this).create();
            this.mPopup = create;
            ListView listView = create.getListView();
            if (Build.VERSION.SDK_INT >= 17) {
                listView.setTextDirection(i);
                listView.setTextAlignment(i2);
            }
            this.mPopup.show();
        }
    }

    /* loaded from: classes.dex */
    public static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SpinnerAdapter mAdapter;
        public ListAdapter mListAdapter;

        public DropDownAdapter(@Nullable SpinnerAdapter spinnerAdapter, @Nullable Resources.Theme theme) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spinnerAdapter, theme};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mAdapter = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.mListAdapter = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof android.widget.ThemedSpinnerAdapter)) {
                    android.widget.ThemedSpinnerAdapter themedSpinnerAdapter = (android.widget.ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                    }
                } else if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                    ThemedSpinnerAdapter themedSpinnerAdapter2 = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter2.getDropDownViewTheme() == null) {
                        themedSpinnerAdapter2.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ListAdapter listAdapter = this.mListAdapter;
                if (listAdapter != null) {
                    return listAdapter.areAllItemsEnabled();
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                SpinnerAdapter spinnerAdapter = this.mAdapter;
                if (spinnerAdapter == null) {
                    return 0;
                }
                return spinnerAdapter.getCount();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, view2, viewGroup)) == null) {
                SpinnerAdapter spinnerAdapter = this.mAdapter;
                if (spinnerAdapter == null) {
                    return null;
                }
                return spinnerAdapter.getDropDownView(i, view2, viewGroup);
            }
            return (View) invokeILL.objValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                SpinnerAdapter spinnerAdapter = this.mAdapter;
                if (spinnerAdapter == null) {
                    return null;
                }
                return spinnerAdapter.getItem(i);
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                SpinnerAdapter spinnerAdapter = this.mAdapter;
                if (spinnerAdapter == null) {
                    return -1L;
                }
                return spinnerAdapter.getItemId(i);
            }
            return invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                return 0;
            }
            return invokeI.intValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) ? getDropDownView(i, view2, viewGroup) : (View) invokeILL.objValue;
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                SpinnerAdapter spinnerAdapter = this.mAdapter;
                return spinnerAdapter != null && spinnerAdapter.hasStableIds();
            }
            return invokeV.booleanValue;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? getCount() == 0 : invokeV.booleanValue;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
                ListAdapter listAdapter = this.mListAdapter;
                if (listAdapter != null) {
                    return listAdapter.isEnabled(i);
                }
                return true;
            }
            return invokeI.booleanValue;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, dataSetObserver) == null) || (spinnerAdapter = this.mAdapter) == null) {
                return;
            }
            spinnerAdapter.registerDataSetObserver(dataSetObserver);
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, dataSetObserver) == null) || (spinnerAdapter = this.mAdapter) == null) {
                return;
            }
            spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ListAdapter mAdapter;
        public CharSequence mHintText;
        public int mOriginalHorizontalOffset;
        public final Rect mVisibleRect;
        public final /* synthetic */ AppCompatSpinner this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DropdownPopup(AppCompatSpinner appCompatSpinner, Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appCompatSpinner, context, attributeSet, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = appCompatSpinner;
            this.mVisibleRect = new Rect();
            setAnchorView(appCompatSpinner);
            setModal(true);
            setPromptPosition(0);
            setOnItemClickListener(new AdapterView.OnItemClickListener(this, appCompatSpinner) { // from class: androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DropdownPopup this$1;
                public final /* synthetic */ AppCompatSpinner val$this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr3 = {this, appCompatSpinner};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$1 = this;
                    this.val$this$0 = appCompatSpinner;
                }

                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view2, int i4, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i4), Long.valueOf(j)}) == null) {
                        this.this$1.this$0.setSelection(i4);
                        if (this.this$1.this$0.getOnItemClickListener() != null) {
                            DropdownPopup dropdownPopup = this.this$1;
                            dropdownPopup.this$0.performItemClick(view2, i4, dropdownPopup.mAdapter.getItemId(i4));
                        }
                        this.this$1.dismiss();
                    }
                }
            });
        }

        public void computeContentWidth() {
            int horizontalOriginalOffset;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Drawable background = getBackground();
                int i = 0;
                if (background != null) {
                    background.getPadding(this.this$0.mTempRect);
                    i = ViewUtils.isLayoutRtl(this.this$0) ? this.this$0.mTempRect.right : -this.this$0.mTempRect.left;
                } else {
                    Rect rect = this.this$0.mTempRect;
                    rect.right = 0;
                    rect.left = 0;
                }
                int paddingLeft = this.this$0.getPaddingLeft();
                int paddingRight = this.this$0.getPaddingRight();
                int width = this.this$0.getWidth();
                AppCompatSpinner appCompatSpinner = this.this$0;
                int i2 = appCompatSpinner.mDropDownWidth;
                if (i2 == -2) {
                    int compatMeasureContentWidth = appCompatSpinner.compatMeasureContentWidth((SpinnerAdapter) this.mAdapter, getBackground());
                    int i3 = this.this$0.getContext().getResources().getDisplayMetrics().widthPixels;
                    Rect rect2 = this.this$0.mTempRect;
                    int i4 = (i3 - rect2.left) - rect2.right;
                    if (compatMeasureContentWidth > i4) {
                        compatMeasureContentWidth = i4;
                    }
                    setContentWidth(Math.max(compatMeasureContentWidth, (width - paddingLeft) - paddingRight));
                } else if (i2 == -1) {
                    setContentWidth((width - paddingLeft) - paddingRight);
                } else {
                    setContentWidth(i2);
                }
                if (ViewUtils.isLayoutRtl(this.this$0)) {
                    horizontalOriginalOffset = i + (((width - paddingRight) - getWidth()) - getHorizontalOriginalOffset());
                } else {
                    horizontalOriginalOffset = i + paddingLeft + getHorizontalOriginalOffset();
                }
                setHorizontalOffset(horizontalOriginalOffset);
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public CharSequence getHintText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mHintText : (CharSequence) invokeV.objValue;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getHorizontalOriginalOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mOriginalHorizontalOffset : invokeV.intValue;
        }

        public boolean isVisibleToUser(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) ? ViewCompat.isAttachedToWindow(view2) && view2.getGlobalVisibleRect(this.mVisibleRect) : invokeL.booleanValue;
        }

        @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setAdapter(ListAdapter listAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, listAdapter) == null) {
                super.setAdapter(listAdapter);
                this.mAdapter = listAdapter;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setHorizontalOriginalOffset(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                this.mOriginalHorizontalOffset = i;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setPromptText(CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, charSequence) == null) {
                this.mHintText = charSequence;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void show(int i, int i2) {
            ViewTreeObserver viewTreeObserver;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
                boolean isShowing = isShowing();
                computeContentWidth();
                setInputMethodMode(2);
                super.show();
                ListView listView = getListView();
                listView.setChoiceMode(1);
                if (Build.VERSION.SDK_INT >= 17) {
                    listView.setTextDirection(i);
                    listView.setTextAlignment(i2);
                }
                setSelection(this.this$0.getSelectedItemPosition());
                if (isShowing || (viewTreeObserver = this.this$0.getViewTreeObserver()) == null) {
                    return;
                }
                ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DropdownPopup this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            DropdownPopup dropdownPopup = this.this$1;
                            if (!dropdownPopup.isVisibleToUser(dropdownPopup.this$0)) {
                                this.this$1.dismiss();
                                return;
                            }
                            this.this$1.computeContentWidth();
                            DropdownPopup.super.show();
                        }
                    }
                };
                viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
                setOnDismissListener(new PopupWindow.OnDismissListener(this, onGlobalLayoutListener) { // from class: androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DropdownPopup this$1;
                    public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener val$layoutListener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, onGlobalLayoutListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$layoutListener = onGlobalLayoutListener;
                    }

                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        ViewTreeObserver viewTreeObserver2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (viewTreeObserver2 = this.this$1.this$0.getViewTreeObserver()) == null) {
                            return;
                        }
                        viewTreeObserver2.removeGlobalOnLayoutListener(this.val$layoutListener);
                    }
                });
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mShowDropdown;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1834697608, "Landroidx/appcompat/widget/AppCompatSpinner$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1834697608, "Landroidx/appcompat/widget/AppCompatSpinner$SavedState;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.appcompat.widget.AppCompatSpinner.SavedState.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                public SavedState[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? new SavedState[i] : (SavedState[]) invokeI.objValue;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i) == null) {
                super.writeToParcel(parcel, i);
                parcel.writeByte(this.mShowDropdown ? (byte) 1 : (byte) 0);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mShowDropdown = parcel.readByte() != 0;
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public interface SpinnerPopup {
        void dismiss();

        Drawable getBackground();

        CharSequence getHintText();

        int getHorizontalOffset();

        int getHorizontalOriginalOffset();

        int getVerticalOffset();

        boolean isShowing();

        void setAdapter(ListAdapter listAdapter);

        void setBackgroundDrawable(Drawable drawable);

        void setHorizontalOffset(int i);

        void setHorizontalOriginalOffset(int i);

        void setPromptText(CharSequence charSequence);

        void setVerticalOffset(int i);

        void show(int i, int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1237741568, "Landroidx/appcompat/widget/AppCompatSpinner;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1237741568, "Landroidx/appcompat/widget/AppCompatSpinner;");
                return;
            }
        }
        ATTRS_ANDROID_SPINNERMODE = new int[]{16843505};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppCompatSpinner(@NonNull Context context) {
        this(context, (AttributeSet) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public int compatMeasureContentWidth(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, spinnerAdapter, drawable)) == null) {
            int i = 0;
            if (spinnerAdapter == null) {
                return 0;
            }
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
            int max = Math.max(0, getSelectedItemPosition());
            int min = Math.min(spinnerAdapter.getCount(), max + 15);
            View view2 = null;
            int i2 = 0;
            for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
                int itemViewType = spinnerAdapter.getItemViewType(max2);
                if (itemViewType != i) {
                    view2 = null;
                    i = itemViewType;
                }
                view2 = spinnerAdapter.getView(max2, view2, this);
                if (view2.getLayoutParams() == null) {
                    view2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                }
                view2.measure(makeMeasureSpec, makeMeasureSpec2);
                i2 = Math.max(i2, view2.getMeasuredWidth());
            }
            if (drawable != null) {
                drawable.getPadding(this.mTempRect);
                Rect rect = this.mTempRect;
                return i2 + rect.left + rect.right;
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.drawableStateChanged();
            AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
            if (appCompatBackgroundHelper != null) {
                appCompatBackgroundHelper.applySupportBackgroundTint();
            }
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SpinnerPopup spinnerPopup = this.mPopup;
            if (spinnerPopup != null) {
                return spinnerPopup.getHorizontalOffset();
            }
            if (Build.VERSION.SDK_INT >= 16) {
                return super.getDropDownHorizontalOffset();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            SpinnerPopup spinnerPopup = this.mPopup;
            if (spinnerPopup != null) {
                return spinnerPopup.getVerticalOffset();
            }
            if (Build.VERSION.SDK_INT >= 16) {
                return super.getDropDownVerticalOffset();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mPopup != null) {
                return this.mDropDownWidth;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                return super.getDropDownWidth();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @VisibleForTesting
    public final SpinnerPopup getInternalPopup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mPopup : (SpinnerPopup) invokeV.objValue;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            SpinnerPopup spinnerPopup = this.mPopup;
            if (spinnerPopup != null) {
                return spinnerPopup.getBackground();
            }
            if (Build.VERSION.SDK_INT >= 16) {
                return super.getPopupBackground();
            }
            return null;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mPopupContext : (Context) invokeV.objValue;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SpinnerPopup spinnerPopup = this.mPopup;
            return spinnerPopup != null ? spinnerPopup.getHintText() : super.getPrompt();
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
            if (appCompatBackgroundHelper != null) {
                return appCompatBackgroundHelper.getSupportBackgroundTintList();
            }
            return null;
        }
        return (ColorStateList) invokeV.objValue;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
            if (appCompatBackgroundHelper != null) {
                return appCompatBackgroundHelper.getSupportBackgroundTintMode();
            }
            return null;
        }
        return (PorterDuff.Mode) invokeV.objValue;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDetachedFromWindow();
            SpinnerPopup spinnerPopup = this.mPopup;
            if (spinnerPopup == null || !spinnerPopup.isShowing()) {
                return;
            }
            this.mPopup.dismiss();
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
            super.onMeasure(i, i2);
            if (this.mPopup == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
                return;
            }
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, parcelable) == null) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (!savedState.mShowDropdown || (viewTreeObserver = getViewTreeObserver()) == null) {
                return;
            }
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: androidx.appcompat.widget.AppCompatSpinner.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AppCompatSpinner this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!this.this$0.getInternalPopup().isShowing()) {
                            this.this$0.showPopup();
                        }
                        ViewTreeObserver viewTreeObserver2 = this.this$0.getViewTreeObserver();
                        if (viewTreeObserver2 != null) {
                            if (Build.VERSION.SDK_INT >= 16) {
                                viewTreeObserver2.removeOnGlobalLayoutListener(this);
                            } else {
                                viewTreeObserver2.removeGlobalOnLayoutListener(this);
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            SpinnerPopup spinnerPopup = this.mPopup;
            savedState.mShowDropdown = spinnerPopup != null && spinnerPopup.isShowing();
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, motionEvent)) == null) {
            ForwardingListener forwardingListener = this.mForwardingListener;
            if (forwardingListener == null || !forwardingListener.onTouch(this, motionEvent)) {
                return super.onTouchEvent(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            SpinnerPopup spinnerPopup = this.mPopup;
            if (spinnerPopup != null) {
                if (spinnerPopup.isShowing()) {
                    return true;
                }
                showPopup();
                return true;
            }
            return super.performClick();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, drawable) == null) {
            super.setBackgroundDrawable(drawable);
            AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
            if (appCompatBackgroundHelper != null) {
                appCompatBackgroundHelper.onSetBackgroundDrawable(drawable);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            super.setBackgroundResource(i);
            AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
            if (appCompatBackgroundHelper != null) {
                appCompatBackgroundHelper.onSetBackgroundResource(i);
            }
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            SpinnerPopup spinnerPopup = this.mPopup;
            if (spinnerPopup != null) {
                spinnerPopup.setHorizontalOriginalOffset(i);
                this.mPopup.setHorizontalOffset(i);
            } else if (Build.VERSION.SDK_INT >= 16) {
                super.setDropDownHorizontalOffset(i);
            }
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            SpinnerPopup spinnerPopup = this.mPopup;
            if (spinnerPopup != null) {
                spinnerPopup.setVerticalOffset(i);
            } else if (Build.VERSION.SDK_INT >= 16) {
                super.setDropDownVerticalOffset(i);
            }
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            if (this.mPopup != null) {
                this.mDropDownWidth = i;
            } else if (Build.VERSION.SDK_INT >= 16) {
                super.setDropDownWidth(i);
            }
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, drawable) == null) {
            SpinnerPopup spinnerPopup = this.mPopup;
            if (spinnerPopup != null) {
                spinnerPopup.setBackgroundDrawable(drawable);
            } else if (Build.VERSION.SDK_INT >= 16) {
                super.setPopupBackgroundDrawable(drawable);
            }
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            setPopupBackgroundDrawable(AppCompatResources.getDrawable(getPopupContext(), i));
        }
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, charSequence) == null) {
            SpinnerPopup spinnerPopup = this.mPopup;
            if (spinnerPopup != null) {
                spinnerPopup.setPromptText(charSequence);
            } else {
                super.setPrompt(charSequence);
            }
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, colorStateList) == null) || (appCompatBackgroundHelper = this.mBackgroundTintHelper) == null) {
            return;
        }
        appCompatBackgroundHelper.setSupportBackgroundTintList(colorStateList);
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, mode) == null) || (appCompatBackgroundHelper = this.mBackgroundTintHelper) == null) {
            return;
        }
        appCompatBackgroundHelper.setSupportBackgroundTintMode(mode);
    }

    public void showPopup() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                this.mPopup.show(getTextDirection(), getTextAlignment());
            } else {
                this.mPopup.show(-1, -1);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppCompatSpinner(@NonNull Context context, int i) {
        this(context, null, R.attr.obfuscated_res_0x7f040647, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, spinnerAdapter) == null) {
            if (!this.mPopupSet) {
                this.mTempAdapter = spinnerAdapter;
                return;
            }
            super.setAdapter(spinnerAdapter);
            if (this.mPopup != null) {
                Context context = this.mPopupContext;
                if (context == null) {
                    context = getContext();
                }
                this.mPopup.setAdapter(new DropDownAdapter(spinnerAdapter, context.getTheme()));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppCompatSpinner(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f040647);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppCompatSpinner(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppCompatSpinner(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65541, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (Resources.Theme) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
        if (r13 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0054, code lost:
        r13.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0065, code lost:
        if (r13 == null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AppCompatSpinner(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2, Resources.Theme theme) {
        super(context, attributeSet, i);
        TypedArray typedArray;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2), theme};
            interceptable.invokeUnInit(65542, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
        this.mTempRect = new Rect();
        ThemeUtils.checkAppCompatTheme(this, getContext());
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, androidx.appcompat.R.styleable.Spinner, i, 0);
        this.mBackgroundTintHelper = new AppCompatBackgroundHelper(this);
        if (theme != null) {
            this.mPopupContext = new ContextThemeWrapper(context, theme);
        } else {
            int resourceId = obtainStyledAttributes.getResourceId(4, 0);
            if (resourceId != 0) {
                this.mPopupContext = new ContextThemeWrapper(context, resourceId);
            } else {
                this.mPopupContext = context;
            }
        }
        TypedArray typedArray2 = null;
        try {
            if (i2 == -1) {
                try {
                    typedArray = context.obtainStyledAttributes(attributeSet, ATTRS_ANDROID_SPINNERMODE, i, 0);
                    try {
                        i2 = typedArray.hasValue(0) ? typedArray.getInt(0, 0) : i2;
                    } catch (Exception e) {
                        e = e;
                        Log.i(TAG, "Could not read android:spinnerMode", e);
                    }
                } catch (Exception e2) {
                    e = e2;
                    typedArray = null;
                } catch (Throwable th) {
                    th = th;
                    if (typedArray2 != null) {
                        typedArray2.recycle();
                    }
                    throw th;
                }
            }
            if (i2 == 0) {
                DialogPopup dialogPopup = new DialogPopup(this);
                this.mPopup = dialogPopup;
                dialogPopup.setPromptText(obtainStyledAttributes.getString(2));
            } else if (i2 == 1) {
                DropdownPopup dropdownPopup = new DropdownPopup(this, this.mPopupContext, attributeSet, i);
                TintTypedArray obtainStyledAttributes2 = TintTypedArray.obtainStyledAttributes(this.mPopupContext, attributeSet, androidx.appcompat.R.styleable.Spinner, i, 0);
                this.mDropDownWidth = obtainStyledAttributes2.getLayoutDimension(3, -2);
                dropdownPopup.setBackgroundDrawable(obtainStyledAttributes2.getDrawable(1));
                dropdownPopup.setPromptText(obtainStyledAttributes.getString(2));
                obtainStyledAttributes2.recycle();
                this.mPopup = dropdownPopup;
                this.mForwardingListener = new ForwardingListener(this, this, dropdownPopup) { // from class: androidx.appcompat.widget.AppCompatSpinner.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AppCompatSpinner this$0;
                    public final /* synthetic */ DropdownPopup val$popup;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(this);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext2 = TitanRuntime.newInitContext();
                            newInitContext2.initArgs = r2;
                            Object[] objArr3 = {this, this, dropdownPopup};
                            interceptable2.invokeUnInit(65536, newInitContext2);
                            int i5 = newInitContext2.flag;
                            if ((i5 & 1) != 0) {
                                int i6 = i5 & 2;
                                super((View) newInitContext2.callArgs[0]);
                                newInitContext2.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext2);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$popup = dropdownPopup;
                    }

                    @Override // androidx.appcompat.widget.ForwardingListener
                    public ShowableListMenu getPopup() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.val$popup : (ShowableListMenu) invokeV.objValue;
                    }

                    @Override // androidx.appcompat.widget.ForwardingListener
                    @SuppressLint({"SyntheticAccessor"})
                    public boolean onForwardingStarted() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            if (this.this$0.getInternalPopup().isShowing()) {
                                return true;
                            }
                            this.this$0.showPopup();
                            return true;
                        }
                        return invokeV.booleanValue;
                    }
                };
            }
            CharSequence[] textArray = obtainStyledAttributes.getTextArray(0);
            if (textArray != null) {
                ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
                arrayAdapter.setDropDownViewResource(R.layout.obfuscated_res_0x7f0d0808);
                setAdapter((SpinnerAdapter) arrayAdapter);
            }
            obtainStyledAttributes.recycle();
            this.mPopupSet = true;
            SpinnerAdapter spinnerAdapter = this.mTempAdapter;
            if (spinnerAdapter != null) {
                setAdapter(spinnerAdapter);
                this.mTempAdapter = null;
            }
            this.mBackgroundTintHelper.loadFromAttributes(attributeSet, i);
        } catch (Throwable th2) {
            th = th2;
            typedArray2 = -1;
        }
    }
}
