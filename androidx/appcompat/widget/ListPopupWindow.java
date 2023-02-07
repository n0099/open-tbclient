package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.PopupWindowCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class ListPopupWindow implements ShowableListMenu {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    public static final String TAG = "ListPopupWindow";
    public static final int WRAP_CONTENT = -2;
    public static Method sGetMaxAvailableHeightMethod;
    public static Method sSetClipToWindowEnabledMethod;
    public static Method sSetEpicenterBoundsMethod;
    public transient /* synthetic */ FieldHolder $fh;
    public ListAdapter mAdapter;
    public Context mContext;
    public boolean mDropDownAlwaysVisible;
    public View mDropDownAnchorView;
    public int mDropDownGravity;
    public int mDropDownHeight;
    public int mDropDownHorizontalOffset;
    public DropDownListView mDropDownList;
    public Drawable mDropDownListHighlight;
    public int mDropDownVerticalOffset;
    public boolean mDropDownVerticalOffsetSet;
    public int mDropDownWidth;
    public int mDropDownWindowLayoutType;
    public Rect mEpicenterBounds;
    public boolean mForceIgnoreOutsideTouch;
    public final Handler mHandler;
    public final ListSelectorHider mHideSelector;
    public AdapterView.OnItemClickListener mItemClickListener;
    public AdapterView.OnItemSelectedListener mItemSelectedListener;
    public int mListItemExpandMaximum;
    public boolean mModal;
    public DataSetObserver mObserver;
    public boolean mOverlapAnchor;
    public boolean mOverlapAnchorSet;
    public PopupWindow mPopup;
    public int mPromptPosition;
    public View mPromptView;
    public final ResizePopupRunnable mResizePopupRunnable;
    public final PopupScrollListener mScrollListener;
    public Runnable mShowDropDownRunnable;
    public final Rect mTempRect;
    public final PopupTouchInterceptor mTouchInterceptor;

    public static boolean isConfirmKey(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) ? i == 66 || i == 23 : invokeI.booleanValue;
    }

    /* loaded from: classes.dex */
    public class ListSelectorHider implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ListPopupWindow this$0;

        public ListSelectorHider(ListPopupWindow listPopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {listPopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = listPopupWindow;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.clearListSelection();
            }
        }
    }

    /* loaded from: classes.dex */
    public class PopupDataSetObserver extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ListPopupWindow this$0;

        public PopupDataSetObserver(ListPopupWindow listPopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {listPopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = listPopupWindow;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.this$0.isShowing()) {
                this.this$0.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.this$0.dismiss();
            }
        }
    }

    /* loaded from: classes.dex */
    public class PopupScrollListener implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ListPopupWindow this$0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
            }
        }

        public PopupScrollListener(ListPopupWindow listPopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {listPopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = listPopupWindow;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) && i == 1 && !this.this$0.isInputMethodNotNeeded() && this.this$0.mPopup.getContentView() != null) {
                ListPopupWindow listPopupWindow = this.this$0;
                listPopupWindow.mHandler.removeCallbacks(listPopupWindow.mResizePopupRunnable);
                this.this$0.mResizePopupRunnable.run();
            }
        }
    }

    /* loaded from: classes.dex */
    public class PopupTouchInterceptor implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ListPopupWindow this$0;

        public PopupTouchInterceptor(ListPopupWindow listPopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {listPopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = listPopupWindow;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PopupWindow popupWindow;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (action == 0 && (popupWindow = this.this$0.mPopup) != null && popupWindow.isShowing() && x >= 0 && x < this.this$0.mPopup.getWidth() && y >= 0 && y < this.this$0.mPopup.getHeight()) {
                    ListPopupWindow listPopupWindow = this.this$0;
                    listPopupWindow.mHandler.postDelayed(listPopupWindow.mResizePopupRunnable, 250L);
                    return false;
                } else if (action == 1) {
                    ListPopupWindow listPopupWindow2 = this.this$0;
                    listPopupWindow2.mHandler.removeCallbacks(listPopupWindow2.mResizePopupRunnable);
                    return false;
                } else {
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class ResizePopupRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ListPopupWindow this$0;

        public ResizePopupRunnable(ListPopupWindow listPopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {listPopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = listPopupWindow;
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView dropDownListView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (dropDownListView = this.this$0.mDropDownList) != null && ViewCompat.isAttachedToWindow(dropDownListView) && this.this$0.mDropDownList.getCount() > this.this$0.mDropDownList.getChildCount()) {
                int childCount = this.this$0.mDropDownList.getChildCount();
                ListPopupWindow listPopupWindow = this.this$0;
                if (childCount <= listPopupWindow.mListItemExpandMaximum) {
                    listPopupWindow.mPopup.setInputMethodMode(2);
                    this.this$0.show();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-412121150, "Landroidx/appcompat/widget/ListPopupWindow;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-412121150, "Landroidx/appcompat/widget/ListPopupWindow;");
                return;
            }
        }
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                sSetClipToWindowEnabledMethod = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i(TAG, "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                sSetEpicenterBoundsMethod = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i(TAG, "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                sGetMaxAvailableHeightMethod = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i(TAG, "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ListPopupWindow(@NonNull Context context) {
        this(context, null, R.attr.obfuscated_res_0x7f04043e);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f04043e);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public boolean onKeyPreIme(int i, @NonNull KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048601, this, i, keyEvent)) == null) {
            if (i == 4 && isShowing()) {
                View view2 = this.mDropDownAnchorView;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = view2.getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = view2.getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        dismiss();
                        return true;
                    }
                    return false;
                } else {
                    return false;
                }
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        this(context, attributeSet, i, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.mDropDownHeight = -2;
        this.mDropDownWidth = -2;
        this.mDropDownWindowLayoutType = 1002;
        this.mDropDownGravity = 0;
        this.mDropDownAlwaysVisible = false;
        this.mForceIgnoreOutsideTouch = false;
        this.mListItemExpandMaximum = Integer.MAX_VALUE;
        this.mPromptPosition = 0;
        this.mResizePopupRunnable = new ResizePopupRunnable(this);
        this.mTouchInterceptor = new PopupTouchInterceptor(this);
        this.mScrollListener = new PopupScrollListener(this);
        this.mHideSelector = new ListSelectorHider(this);
        this.mTempRect = new Rect();
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.ListPopupWindow, i, i2);
        this.mDropDownHorizontalOffset = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.mDropDownVerticalOffset = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.mDropDownVerticalOffsetSet = true;
        }
        obtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i, i2);
        this.mPopup = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v3, resolved type: android.widget.LinearLayout */
    /* JADX WARN: Multi-variable type inference failed */
    private int buildDropDown() {
        InterceptResult invokeV;
        int i;
        int i2;
        int makeMeasureSpec;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            boolean z = true;
            if (this.mDropDownList == null) {
                Context context = this.mContext;
                this.mShowDropDownRunnable = new Runnable(this) { // from class: androidx.appcompat.widget.ListPopupWindow.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ListPopupWindow this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        View anchorView;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && (anchorView = this.this$0.getAnchorView()) != null && anchorView.getWindowToken() != null) {
                            this.this$0.show();
                        }
                    }
                };
                DropDownListView createDropDownListView = createDropDownListView(context, !this.mModal);
                this.mDropDownList = createDropDownListView;
                Drawable drawable = this.mDropDownListHighlight;
                if (drawable != null) {
                    createDropDownListView.setSelector(drawable);
                }
                this.mDropDownList.setAdapter(this.mAdapter);
                this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
                this.mDropDownList.setFocusable(true);
                this.mDropDownList.setFocusableInTouchMode(true);
                this.mDropDownList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(this) { // from class: androidx.appcompat.widget.ListPopupWindow.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ListPopupWindow this$0;

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adapterView) == null) {
                        }
                    }

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> adapterView, View view2, int i4, long j) {
                        DropDownListView dropDownListView;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i4), Long.valueOf(j)}) == null) && i4 != -1 && (dropDownListView = this.this$0.mDropDownList) != null) {
                            dropDownListView.setListSelectionHidden(false);
                        }
                    }
                });
                this.mDropDownList.setOnScrollListener(this.mScrollListener);
                AdapterView.OnItemSelectedListener onItemSelectedListener = this.mItemSelectedListener;
                if (onItemSelectedListener != null) {
                    this.mDropDownList.setOnItemSelectedListener(onItemSelectedListener);
                }
                DropDownListView dropDownListView = this.mDropDownList;
                View view2 = this.mPromptView;
                if (view2 != null) {
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setOrientation(1);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                    int i4 = this.mPromptPosition;
                    if (i4 != 0) {
                        if (i4 != 1) {
                            Log.e(TAG, "Invalid hint position " + this.mPromptPosition);
                        } else {
                            linearLayout.addView(dropDownListView, layoutParams);
                            linearLayout.addView(view2);
                        }
                    } else {
                        linearLayout.addView(view2);
                        linearLayout.addView(dropDownListView, layoutParams);
                    }
                    int i5 = this.mDropDownWidth;
                    if (i5 >= 0) {
                        i3 = Integer.MIN_VALUE;
                    } else {
                        i5 = 0;
                        i3 = 0;
                    }
                    view2.measure(View.MeasureSpec.makeMeasureSpec(i5, i3), 0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    i = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                    dropDownListView = linearLayout;
                } else {
                    i = 0;
                }
                this.mPopup.setContentView(dropDownListView);
            } else {
                ViewGroup viewGroup = (ViewGroup) this.mPopup.getContentView();
                View view3 = this.mPromptView;
                if (view3 != null) {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                    i = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
                } else {
                    i = 0;
                }
            }
            Drawable background = this.mPopup.getBackground();
            if (background != null) {
                background.getPadding(this.mTempRect);
                Rect rect = this.mTempRect;
                int i6 = rect.top;
                i2 = rect.bottom + i6;
                if (!this.mDropDownVerticalOffsetSet) {
                    this.mDropDownVerticalOffset = -i6;
                }
            } else {
                this.mTempRect.setEmpty();
                i2 = 0;
            }
            if (this.mPopup.getInputMethodMode() != 2) {
                z = false;
            }
            int maxAvailableHeight = getMaxAvailableHeight(getAnchorView(), this.mDropDownVerticalOffset, z);
            if (!this.mDropDownAlwaysVisible && this.mDropDownHeight != -1) {
                int i7 = this.mDropDownWidth;
                if (i7 != -2) {
                    if (i7 != -1) {
                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                    } else {
                        int i8 = this.mContext.getResources().getDisplayMetrics().widthPixels;
                        Rect rect2 = this.mTempRect;
                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8 - (rect2.left + rect2.right), 1073741824);
                    }
                } else {
                    int i9 = this.mContext.getResources().getDisplayMetrics().widthPixels;
                    Rect rect3 = this.mTempRect;
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - (rect3.left + rect3.right), Integer.MIN_VALUE);
                }
                int measureHeightOfChildrenCompat = this.mDropDownList.measureHeightOfChildrenCompat(makeMeasureSpec, 0, -1, maxAvailableHeight - i, -1);
                if (measureHeightOfChildrenCompat > 0) {
                    i += i2 + this.mDropDownList.getPaddingTop() + this.mDropDownList.getPaddingBottom();
                }
                return measureHeightOfChildrenCompat + i;
            }
            return maxAvailableHeight + i2;
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            int buildDropDown = buildDropDown();
            boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
            PopupWindowCompat.setWindowLayoutType(this.mPopup, this.mDropDownWindowLayoutType);
            boolean z2 = true;
            if (this.mPopup.isShowing()) {
                if (!ViewCompat.isAttachedToWindow(getAnchorView())) {
                    return;
                }
                int i5 = this.mDropDownWidth;
                if (i5 == -1) {
                    i5 = -1;
                } else if (i5 == -2) {
                    i5 = getAnchorView().getWidth();
                }
                int i6 = this.mDropDownHeight;
                if (i6 == -1) {
                    if (!isInputMethodNotNeeded) {
                        buildDropDown = -1;
                    }
                    if (isInputMethodNotNeeded) {
                        PopupWindow popupWindow = this.mPopup;
                        if (this.mDropDownWidth == -1) {
                            i4 = -1;
                        } else {
                            i4 = 0;
                        }
                        popupWindow.setWidth(i4);
                        this.mPopup.setHeight(0);
                    } else {
                        PopupWindow popupWindow2 = this.mPopup;
                        if (this.mDropDownWidth == -1) {
                            i3 = -1;
                        } else {
                            i3 = 0;
                        }
                        popupWindow2.setWidth(i3);
                        this.mPopup.setHeight(-1);
                    }
                } else if (i6 != -2) {
                    buildDropDown = i6;
                }
                this.mPopup.setOutsideTouchable((this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) ? false : false);
                PopupWindow popupWindow3 = this.mPopup;
                View anchorView = getAnchorView();
                int i7 = this.mDropDownHorizontalOffset;
                int i8 = this.mDropDownVerticalOffset;
                if (i5 < 0) {
                    i = -1;
                } else {
                    i = i5;
                }
                if (buildDropDown < 0) {
                    i2 = -1;
                } else {
                    i2 = buildDropDown;
                }
                popupWindow3.update(anchorView, i7, i8, i, i2);
                return;
            }
            int i9 = this.mDropDownWidth;
            if (i9 == -1) {
                i9 = -1;
            } else if (i9 == -2) {
                i9 = getAnchorView().getWidth();
            }
            int i10 = this.mDropDownHeight;
            if (i10 == -1) {
                buildDropDown = -1;
            } else if (i10 != -2) {
                buildDropDown = i10;
            }
            this.mPopup.setWidth(i9);
            this.mPopup.setHeight(buildDropDown);
            setPopupClipToScreenEnabled(true);
            PopupWindow popupWindow4 = this.mPopup;
            if (!this.mForceIgnoreOutsideTouch && !this.mDropDownAlwaysVisible) {
                z = true;
            } else {
                z = false;
            }
            popupWindow4.setOutsideTouchable(z);
            this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
            if (this.mOverlapAnchorSet) {
                PopupWindowCompat.setOverlapAnchor(this.mPopup, this.mOverlapAnchor);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = sSetEpicenterBoundsMethod;
                if (method != null) {
                    try {
                        method.invoke(this.mPopup, this.mEpicenterBounds);
                    } catch (Exception e) {
                        Log.e(TAG, "Could not invoke setEpicenterBounds on PopupWindow", e);
                    }
                }
            } else {
                this.mPopup.setEpicenterBounds(this.mEpicenterBounds);
            }
            PopupWindowCompat.showAsDropDown(this.mPopup, getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
            this.mDropDownList.setSelection(-1);
            if (!this.mModal || this.mDropDownList.isInTouchMode()) {
                clearListSelection();
            }
            if (!this.mModal) {
                this.mHandler.post(this.mHideSelector);
            }
        }
    }

    private int getMaxAvailableHeight(View view2, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (Build.VERSION.SDK_INT <= 23) {
                Method method = sGetMaxAvailableHeightMethod;
                if (method != null) {
                    try {
                        return ((Integer) method.invoke(this.mPopup, view2, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
                    } catch (Exception unused) {
                        Log.i(TAG, "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                    }
                }
                return this.mPopup.getMaxAvailableHeight(view2, i);
            }
            return this.mPopup.getMaxAvailableHeight(view2, i, z);
        }
        return invokeCommon.intValue;
    }

    private void removePromptView() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65544, this) == null) && (view2 = this.mPromptView) != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.mPromptView);
            }
        }
    }

    public void clearListSelection() {
        DropDownListView dropDownListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (dropDownListView = this.mDropDownList) != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mPopup.dismiss();
            removePromptView();
            this.mPopup.setContentView(null);
            this.mDropDownList = null;
            this.mHandler.removeCallbacks(this.mResizePopupRunnable);
        }
    }

    @Nullable
    public View getAnchorView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mDropDownAnchorView;
        }
        return (View) invokeV.objValue;
    }

    @StyleRes
    public int getAnimationStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mPopup.getAnimationStyle();
        }
        return invokeV.intValue;
    }

    @Nullable
    public Drawable getBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mPopup.getBackground();
        }
        return (Drawable) invokeV.objValue;
    }

    @Nullable
    public Rect getEpicenterBounds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.mEpicenterBounds != null) {
                return new Rect(this.mEpicenterBounds);
            }
            return null;
        }
        return (Rect) invokeV.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mDropDownHeight;
        }
        return invokeV.intValue;
    }

    public int getHorizontalOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mDropDownHorizontalOffset;
        }
        return invokeV.intValue;
    }

    public int getInputMethodMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mPopup.getInputMethodMode();
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    @Nullable
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mDropDownList;
        }
        return (ListView) invokeV.objValue;
    }

    public int getPromptPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mPromptPosition;
        }
        return invokeV.intValue;
    }

    @Nullable
    public Object getSelectedItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!isShowing()) {
                return null;
            }
            return this.mDropDownList.getSelectedItem();
        }
        return invokeV.objValue;
    }

    public long getSelectedItemId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (!isShowing()) {
                return Long.MIN_VALUE;
            }
            return this.mDropDownList.getSelectedItemId();
        }
        return invokeV.longValue;
    }

    public int getSelectedItemPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (!isShowing()) {
                return -1;
            }
            return this.mDropDownList.getSelectedItemPosition();
        }
        return invokeV.intValue;
    }

    @Nullable
    public View getSelectedView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!isShowing()) {
                return null;
            }
            return this.mDropDownList.getSelectedView();
        }
        return (View) invokeV.objValue;
    }

    public int getSoftInputMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mPopup.getSoftInputMode();
        }
        return invokeV.intValue;
    }

    public int getVerticalOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (!this.mDropDownVerticalOffsetSet) {
                return 0;
            }
            return this.mDropDownVerticalOffset;
        }
        return invokeV.intValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mDropDownWidth;
        }
        return invokeV.intValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isDropDownAlwaysVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mDropDownAlwaysVisible;
        }
        return invokeV.booleanValue;
    }

    public boolean isInputMethodNotNeeded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.mPopup.getInputMethodMode() == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isModal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mModal;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mPopup.isShowing();
        }
        return invokeV.booleanValue;
    }

    public void postShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.mHandler.post(this.mShowDropDownRunnable);
        }
    }

    private void setPopupClipToScreenEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, this, z) == null) {
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = sSetClipToWindowEnabledMethod;
                if (method != null) {
                    try {
                        method.invoke(this.mPopup, Boolean.valueOf(z));
                        return;
                    } catch (Exception unused) {
                        Log.i(TAG, "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                        return;
                    }
                }
                return;
            }
            this.mPopup.setIsClippedToScreen(z);
        }
    }

    public boolean performItemClick(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
            if (isShowing()) {
                if (this.mItemClickListener != null) {
                    DropDownListView dropDownListView = this.mDropDownList;
                    this.mItemClickListener.onItemClick(dropDownListView, dropDownListView.getChildAt(i - dropDownListView.getFirstVisiblePosition()), i, dropDownListView.getAdapter().getItemId(i));
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void setAdapter(@Nullable ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, listAdapter) == null) {
            DataSetObserver dataSetObserver = this.mObserver;
            if (dataSetObserver == null) {
                this.mObserver = new PopupDataSetObserver(this);
            } else {
                ListAdapter listAdapter2 = this.mAdapter;
                if (listAdapter2 != null) {
                    listAdapter2.unregisterDataSetObserver(dataSetObserver);
                }
            }
            this.mAdapter = listAdapter;
            if (listAdapter != null) {
                listAdapter.registerDataSetObserver(this.mObserver);
            }
            DropDownListView dropDownListView = this.mDropDownList;
            if (dropDownListView != null) {
                dropDownListView.setAdapter(this.mAdapter);
            }
        }
    }

    public View.OnTouchListener createDragToOpenListener(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            return new ForwardingListener(this, view2) { // from class: androidx.appcompat.widget.ListPopupWindow.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ListPopupWindow this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(view2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, view2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((View) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.appcompat.widget.ForwardingListener
                public ListPopupWindow getPopup() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return this.this$0;
                    }
                    return (ListPopupWindow) invokeV.objValue;
                }
            };
        }
        return (View.OnTouchListener) invokeL.objValue;
    }

    public void setAnchorView(@Nullable View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, view2) == null) {
            this.mDropDownAnchorView = view2;
        }
    }

    public void setAnimationStyle(@StyleRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.mPopup.setAnimationStyle(i);
        }
    }

    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, drawable) == null) {
            this.mPopup.setBackgroundDrawable(drawable);
        }
    }

    public void setContentWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            Drawable background = this.mPopup.getBackground();
            if (background != null) {
                background.getPadding(this.mTempRect);
                Rect rect = this.mTempRect;
                this.mDropDownWidth = rect.left + rect.right + i;
                return;
            }
            setWidth(i);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setDropDownAlwaysVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.mDropDownAlwaysVisible = z;
        }
    }

    public void setDropDownGravity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.mDropDownGravity = i;
        }
    }

    public void setEpicenterBounds(@Nullable Rect rect) {
        Rect rect2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, rect) == null) {
            if (rect != null) {
                rect2 = new Rect(rect);
            } else {
                rect2 = null;
            }
            this.mEpicenterBounds = rect2;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setForceIgnoreOutsideTouch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.mForceIgnoreOutsideTouch = z;
        }
    }

    public void setHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            if (i < 0 && -2 != i && -1 != i) {
                throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
            }
            this.mDropDownHeight = i;
        }
    }

    public void setHorizontalOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.mDropDownHorizontalOffset = i;
        }
    }

    public void setInputMethodMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            this.mPopup.setInputMethodMode(i);
        }
    }

    public void setListItemExpandMax(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            this.mListItemExpandMaximum = i;
        }
    }

    public void setListSelector(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, drawable) == null) {
            this.mDropDownListHighlight = drawable;
        }
    }

    public void setModal(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.mModal = z;
            this.mPopup.setFocusable(z);
        }
    }

    public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, onDismissListener) == null) {
            this.mPopup.setOnDismissListener(onDismissListener);
        }
    }

    public void setOnItemClickListener(@Nullable AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, onItemClickListener) == null) {
            this.mItemClickListener = onItemClickListener;
        }
    }

    public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener onItemSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, onItemSelectedListener) == null) {
            this.mItemSelectedListener = onItemSelectedListener;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOverlapAnchor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.mOverlapAnchorSet = true;
            this.mOverlapAnchor = z;
        }
    }

    public void setPromptPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i) == null) {
            this.mPromptPosition = i;
        }
    }

    public void setPromptView(@Nullable View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, view2) == null) {
            boolean isShowing = isShowing();
            if (isShowing) {
                removePromptView();
            }
            this.mPromptView = view2;
            if (isShowing) {
                show();
            }
        }
    }

    public void setSelection(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i) == null) {
            DropDownListView dropDownListView = this.mDropDownList;
            if (isShowing() && dropDownListView != null) {
                dropDownListView.setListSelectionHidden(false);
                dropDownListView.setSelection(i);
                if (dropDownListView.getChoiceMode() != 0) {
                    dropDownListView.setItemChecked(i, true);
                }
            }
        }
    }

    public void setSoftInputMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i) == null) {
            this.mPopup.setSoftInputMode(i);
        }
    }

    public void setVerticalOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i) == null) {
            this.mDropDownVerticalOffset = i;
            this.mDropDownVerticalOffsetSet = true;
        }
    }

    public void setWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i) == null) {
            this.mDropDownWidth = i;
        }
    }

    public void setWindowLayoutType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i) == null) {
            this.mDropDownWindowLayoutType = i;
        }
    }

    @NonNull
    public DropDownListView createDropDownListView(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, context, z)) == null) {
            return new DropDownListView(context, z);
        }
        return (DropDownListView) invokeLZ.objValue;
    }

    public boolean onKeyDown(int i, @NonNull KeyEvent keyEvent) {
        InterceptResult invokeIL;
        int lookForSelectablePosition;
        int lookForSelectablePosition2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048600, this, i, keyEvent)) == null) {
            if (isShowing() && i != 62 && (this.mDropDownList.getSelectedItemPosition() >= 0 || !isConfirmKey(i))) {
                int selectedItemPosition = this.mDropDownList.getSelectedItemPosition();
                boolean z = !this.mPopup.isAboveAnchor();
                ListAdapter listAdapter = this.mAdapter;
                int i2 = Integer.MAX_VALUE;
                int i3 = Integer.MIN_VALUE;
                if (listAdapter != null) {
                    boolean areAllItemsEnabled = listAdapter.areAllItemsEnabled();
                    if (areAllItemsEnabled) {
                        lookForSelectablePosition = 0;
                    } else {
                        lookForSelectablePosition = this.mDropDownList.lookForSelectablePosition(0, true);
                    }
                    if (areAllItemsEnabled) {
                        lookForSelectablePosition2 = listAdapter.getCount() - 1;
                    } else {
                        lookForSelectablePosition2 = this.mDropDownList.lookForSelectablePosition(listAdapter.getCount() - 1, false);
                    }
                    i2 = lookForSelectablePosition;
                    i3 = lookForSelectablePosition2;
                }
                if ((z && i == 19 && selectedItemPosition <= i2) || (!z && i == 20 && selectedItemPosition >= i3)) {
                    clearListSelection();
                    this.mPopup.setInputMethodMode(1);
                    show();
                    return true;
                }
                this.mDropDownList.setListSelectionHidden(false);
                if (this.mDropDownList.onKeyDown(i, keyEvent)) {
                    this.mPopup.setInputMethodMode(2);
                    this.mDropDownList.requestFocusFromTouch();
                    show();
                    if (i == 19 || i == 20 || i == 23 || i == 66) {
                        return true;
                    }
                } else if (z && i == 20) {
                    if (selectedItemPosition == i3) {
                        return true;
                    }
                } else if (!z && i == 19 && selectedItemPosition == i2) {
                    return true;
                }
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public boolean onKeyUp(int i, @NonNull KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i, keyEvent)) == null) {
            if (isShowing() && this.mDropDownList.getSelectedItemPosition() >= 0) {
                boolean onKeyUp = this.mDropDownList.onKeyUp(i, keyEvent);
                if (onKeyUp && isConfirmKey(i)) {
                    dismiss();
                }
                return onKeyUp;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }
}
