package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.customview.view.AbsSavedState;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DBG = false;
    public static final String IME_OPTION_NO_MICROPHONE = "nm";
    public static final String LOG_TAG = "SearchView";
    public static final PreQAutoCompleteTextViewReflector PRE_API_29_HIDDEN_METHOD_INVOKER;
    public transient /* synthetic */ FieldHolder $fh;
    public Bundle mAppSearchData;
    public boolean mClearingFocus;
    public final ImageView mCloseButton;
    public final ImageView mCollapsedIcon;
    public int mCollapsedImeOptions;
    public final CharSequence mDefaultQueryHint;
    public final View mDropDownAnchor;
    public boolean mExpandedInActionView;
    public final ImageView mGoButton;
    public boolean mIconified;
    public boolean mIconifiedByDefault;
    public int mMaxWidth;
    public CharSequence mOldQueryText;
    public final View.OnClickListener mOnClickListener;
    public OnCloseListener mOnCloseListener;
    public final TextView.OnEditorActionListener mOnEditorActionListener;
    public final AdapterView.OnItemClickListener mOnItemClickListener;
    public final AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    public OnQueryTextListener mOnQueryChangeListener;
    public View.OnFocusChangeListener mOnQueryTextFocusChangeListener;
    public View.OnClickListener mOnSearchClickListener;
    public OnSuggestionListener mOnSuggestionListener;
    public final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
    public CharSequence mQueryHint;
    public boolean mQueryRefinement;
    public Runnable mReleaseCursorRunnable;
    public final ImageView mSearchButton;
    public final View mSearchEditFrame;
    public final Drawable mSearchHintIcon;
    public final View mSearchPlate;
    public final SearchAutoComplete mSearchSrcTextView;
    public Rect mSearchSrcTextViewBounds;
    public Rect mSearchSrtTextViewBoundsExpanded;
    public SearchableInfo mSearchable;
    public final View mSubmitArea;
    public boolean mSubmitButtonEnabled;
    public final int mSuggestionCommitIconResId;
    public final int mSuggestionRowLayout;
    public CursorAdapter mSuggestionsAdapter;
    public int[] mTemp;
    public int[] mTemp2;
    public View.OnKeyListener mTextKeyListener;
    public TextWatcher mTextWatcher;
    public UpdatableTouchDelegate mTouchDelegate;
    public final Runnable mUpdateDrawableStateRunnable;
    public CharSequence mUserQuery;
    public final Intent mVoiceAppSearchIntent;
    public final ImageView mVoiceButton;
    public boolean mVoiceButtonEnabled;
    public final Intent mVoiceWebSearchIntent;

    /* loaded from: classes.dex */
    public interface OnCloseListener {
        boolean onClose();
    }

    /* loaded from: classes.dex */
    public interface OnQueryTextListener {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    /* loaded from: classes.dex */
    public interface OnSuggestionListener {
        boolean onSuggestionClick(int i2);

        boolean onSuggestionSelect(int i2);
    }

    /* loaded from: classes.dex */
    public static class PreQAutoCompleteTextViewReflector {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Method mDoAfterTextChanged;
        public Method mDoBeforeTextChanged;
        public Method mEnsureImeVisible;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        public PreQAutoCompleteTextViewReflector() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDoBeforeTextChanged = null;
            this.mDoAfterTextChanged = null;
            this.mEnsureImeVisible = null;
            preApi29Check();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.mDoBeforeTextChanged = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.mDoAfterTextChanged = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.mEnsureImeVisible = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        public static void preApi29Check() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65537, null) == null) && Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        public void doAfterTextChanged(AutoCompleteTextView autoCompleteTextView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, autoCompleteTextView) == null) {
                preApi29Check();
                Method method = this.mDoAfterTextChanged;
                if (method != null) {
                    try {
                        method.invoke(autoCompleteTextView, new Object[0]);
                    } catch (Exception unused) {
                    }
                }
            }
        }

        public void doBeforeTextChanged(AutoCompleteTextView autoCompleteTextView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, autoCompleteTextView) == null) {
                preApi29Check();
                Method method = this.mDoBeforeTextChanged;
                if (method != null) {
                    try {
                        method.invoke(autoCompleteTextView, new Object[0]);
                    } catch (Exception unused) {
                    }
                }
            }
        }

        public void ensureImeVisible(AutoCompleteTextView autoCompleteTextView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, autoCompleteTextView) == null) {
                preApi29Check();
                Method method = this.mEnsureImeVisible;
                if (method != null) {
                    try {
                        method.invoke(autoCompleteTextView, Boolean.TRUE);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isIconified;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-157069921, "Landroidx/appcompat/widget/SearchView$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-157069921, "Landroidx/appcompat/widget/SearchView$SavedState;");
                    return;
                }
            }
            CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.appcompat.widget.SearchView.SavedState.1
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
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048580, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, classLoader)) == null) ? new SavedState(parcel, classLoader) : (SavedState) invokeLL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel, null) : (SavedState) invokeL.objValue;
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

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.isIconified + "}";
            }
            return (String) invokeV.objValue;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                parcel.writeValue(Boolean.valueOf(this.isIconified));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel, classLoader};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Parcel) objArr2[0], (ClassLoader) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.isIconified = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mHasPendingShowSoftInputRequest;
        public final Runnable mRunShowSoftInputIfNecessary;
        public SearchView mSearchView;
        public int mThreshold;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public SearchAutoComplete(Context context) {
            this(context, null);
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
                    this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        private int getSearchViewTextMinWidthDp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
                Configuration configuration = getResources().getConfiguration();
                int i2 = configuration.screenWidthDp;
                int i3 = configuration.screenHeightDp;
                if (i2 < 960 || i3 < 720 || configuration.orientation != 2) {
                    if (i2 < 600) {
                        return (i2 < 640 || i3 < 480) ? 160 : 192;
                    }
                    return 192;
                }
                return 256;
            }
            return invokeV.intValue;
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mThreshold <= 0 || super.enoughToFilter() : invokeV.booleanValue;
        }

        public void ensureImeVisible() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    setInputMethodMode(1);
                    if (enoughToFilter()) {
                        showDropDown();
                        return;
                    }
                    return;
                }
                SearchView.PRE_API_29_HIDDEN_METHOD_INVOKER.ensureImeVisible(this);
            }
        }

        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TextUtils.getTrimmedLength(getText()) == 0 : invokeV.booleanValue;
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, editorInfo)) == null) {
                InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
                if (this.mHasPendingShowSoftInputRequest) {
                    removeCallbacks(this.mRunShowSoftInputIfNecessary);
                    post(this.mRunShowSoftInputIfNecessary);
                }
                return onCreateInputConnection;
            }
            return (InputConnection) invokeL.objValue;
        }

        @Override // android.view.View
        public void onFinishInflate() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onFinishInflate();
                setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean z, int i2, Rect rect) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), rect}) == null) {
                super.onFocusChanged(z, i2, rect);
                this.mSearchView.onTextFocusChanged();
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, keyEvent)) == null) {
                if (i2 == 4) {
                    if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                        KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                        }
                        return true;
                    } else if (keyEvent.getAction() == 1) {
                        KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                        if (keyDispatcherState2 != null) {
                            keyDispatcherState2.handleUpEvent(keyEvent);
                        }
                        if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                            this.mSearchView.clearFocus();
                            setImeVisibility(false);
                            return true;
                        }
                    }
                }
                return super.onKeyPreIme(i2, keyEvent);
            }
            return invokeIL.booleanValue;
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
                super.onWindowFocusChanged(z);
                if (z && this.mSearchView.hasFocus() && getVisibility() == 0) {
                    this.mHasPendingShowSoftInputRequest = true;
                    if (SearchView.isLandscapeMode(getContext())) {
                        ensureImeVisible();
                    }
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void replaceText(CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, charSequence) == null) {
            }
        }

        public void setImeVisibility(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
                InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
                if (!z) {
                    this.mHasPendingShowSoftInputRequest = false;
                    removeCallbacks(this.mRunShowSoftInputIfNecessary);
                    inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                } else if (inputMethodManager.isActive(this)) {
                    this.mHasPendingShowSoftInputRequest = false;
                    removeCallbacks(this.mRunShowSoftInputIfNecessary);
                    inputMethodManager.showSoftInput(this, 0);
                } else {
                    this.mHasPendingShowSoftInputRequest = true;
                }
            }
        }

        public void setSearchView(SearchView searchView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, searchView) == null) {
                this.mSearchView = searchView;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
                super.setThreshold(i2);
                this.mThreshold = i2;
            }
        }

        public void showSoftInputIfNecessary() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.mHasPendingShowSoftInputRequest) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.mHasPendingShowSoftInputRequest = false;
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
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
                    this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mRunShowSoftInputIfNecessary = new Runnable(this) { // from class: androidx.appcompat.widget.SearchView.SearchAutoComplete.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SearchAutoComplete this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr3 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i5 = newInitContext2.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
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
                        this.this$0.showSoftInputIfNecessary();
                    }
                }
            };
            this.mThreshold = getThreshold();
        }
    }

    /* loaded from: classes.dex */
    public static class UpdatableTouchDelegate extends TouchDelegate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Rect mActualBounds;
        public boolean mDelegateTargeted;
        public final View mDelegateView;
        public final int mSlop;
        public final Rect mSlopBounds;
        public final Rect mTargetBounds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdatableTouchDelegate(Rect rect, Rect rect2, View view) {
            super(rect, view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rect, rect2, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Rect) objArr2[0], (View) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.mTargetBounds = new Rect();
            this.mSlopBounds = new Rect();
            this.mActualBounds = new Rect();
            setBounds(rect, rect2);
            this.mDelegateView = view;
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int action = motionEvent.getAction();
                boolean z3 = true;
                if (action != 0) {
                    if (action == 1 || action == 2) {
                        z2 = this.mDelegateTargeted;
                        if (z2 && !this.mSlopBounds.contains(x, y)) {
                            z3 = z2;
                            z = false;
                        }
                    } else {
                        if (action == 3) {
                            z2 = this.mDelegateTargeted;
                            this.mDelegateTargeted = false;
                        }
                        z = true;
                        z3 = false;
                    }
                    z3 = z2;
                    z = true;
                } else {
                    if (this.mTargetBounds.contains(x, y)) {
                        this.mDelegateTargeted = true;
                        z = true;
                    }
                    z = true;
                    z3 = false;
                }
                if (z3) {
                    if (z && !this.mActualBounds.contains(x, y)) {
                        motionEvent.setLocation(this.mDelegateView.getWidth() / 2, this.mDelegateView.getHeight() / 2);
                    } else {
                        Rect rect = this.mActualBounds;
                        motionEvent.setLocation(x - rect.left, y - rect.top);
                    }
                    return this.mDelegateView.dispatchTouchEvent(motionEvent);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public void setBounds(Rect rect, Rect rect2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rect, rect2) == null) {
                this.mTargetBounds.set(rect);
                this.mSlopBounds.set(rect);
                Rect rect3 = this.mSlopBounds;
                int i2 = this.mSlop;
                rect3.inset(-i2, -i2);
                this.mActualBounds.set(rect2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(926928457, "Landroidx/appcompat/widget/SearchView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(926928457, "Landroidx/appcompat/widget/SearchView;");
                return;
            }
        }
        PRE_API_29_HIDDEN_METHOD_INVOKER = Build.VERSION.SDK_INT < 29 ? new PreQAutoCompleteTextViewReflector() : null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SearchView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private Intent createIntent(String str, Uri uri, String str2, String str3, int i2, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{str, uri, str2, str3, Integer.valueOf(i2), str4})) == null) {
            Intent intent = new Intent(str);
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            if (uri != null) {
                intent.setData(uri);
            }
            intent.putExtra("user_query", this.mUserQuery);
            if (str3 != null) {
                intent.putExtra("query", str3);
            }
            if (str2 != null) {
                intent.putExtra("intent_extra_data_key", str2);
            }
            Bundle bundle = this.mAppSearchData;
            if (bundle != null) {
                intent.putExtra("app_data", bundle);
            }
            if (i2 != 0) {
                intent.putExtra("action_key", i2);
                intent.putExtra("action_msg", str4);
            }
            intent.setComponent(this.mSearchable.getSearchActivity());
            return intent;
        }
        return (Intent) invokeCommon.objValue;
    }

    private Intent createIntentFromSuggestion(Cursor cursor, int i2, String str) {
        InterceptResult invokeLIL;
        int i3;
        String columnString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(AdIconUtil.AD_TEXT_ID, this, cursor, i2, str)) == null) {
            try {
                String columnString2 = SuggestionsAdapter.getColumnString(cursor, "suggest_intent_action");
                if (columnString2 == null) {
                    columnString2 = this.mSearchable.getSuggestIntentAction();
                }
                if (columnString2 == null) {
                    columnString2 = "android.intent.action.SEARCH";
                }
                String str2 = columnString2;
                String columnString3 = SuggestionsAdapter.getColumnString(cursor, "suggest_intent_data");
                if (columnString3 == null) {
                    columnString3 = this.mSearchable.getSuggestIntentData();
                }
                if (columnString3 != null && (columnString = SuggestionsAdapter.getColumnString(cursor, "suggest_intent_data_id")) != null) {
                    columnString3 = columnString3 + "/" + Uri.encode(columnString);
                }
                return createIntent(str2, columnString3 == null ? null : Uri.parse(columnString3), SuggestionsAdapter.getColumnString(cursor, "suggest_intent_extra_data"), SuggestionsAdapter.getColumnString(cursor, "suggest_intent_query"), i2, str);
            } catch (RuntimeException e2) {
                try {
                    i3 = cursor.getPosition();
                } catch (RuntimeException unused) {
                    i3 = -1;
                }
                Log.w(LOG_TAG, "Search suggestions cursor at row " + i3 + " returned exception.", e2);
                return null;
            }
        }
        return (Intent) invokeLIL.objValue;
    }

    private Intent createVoiceAppSearchIntent(Intent intent, SearchableInfo searchableInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, intent, searchableInfo)) == null) {
            ComponentName searchActivity = searchableInfo.getSearchActivity();
            Intent intent2 = new Intent("android.intent.action.SEARCH");
            intent2.setComponent(searchActivity);
            PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
            Bundle bundle = new Bundle();
            Bundle bundle2 = this.mAppSearchData;
            if (bundle2 != null) {
                bundle.putParcelable("app_data", bundle2);
            }
            Intent intent3 = new Intent(intent);
            Resources resources = getResources();
            String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
            String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
            String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
            int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
            intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
            intent3.putExtra("android.speech.extra.PROMPT", string2);
            intent3.putExtra("android.speech.extra.LANGUAGE", string3);
            intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
            intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
            intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
            intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
            return intent3;
        }
        return (Intent) invokeLL.objValue;
    }

    private Intent createVoiceWebSearchIntent(Intent intent, SearchableInfo searchableInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, intent, searchableInfo)) == null) {
            Intent intent2 = new Intent(intent);
            ComponentName searchActivity = searchableInfo.getSearchActivity();
            intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
            return intent2;
        }
        return (Intent) invokeLL.objValue;
    }

    private void dismissSuggestions() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.mSearchSrcTextView.dismissDropDown();
        }
    }

    private void getChildBoundsWithinSearchView(View view, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, view, rect) == null) {
            view.getLocationInWindow(this.mTemp);
            getLocationInWindow(this.mTemp2);
            int[] iArr = this.mTemp;
            int i2 = iArr[1];
            int[] iArr2 = this.mTemp2;
            int i3 = i2 - iArr2[1];
            int i4 = iArr[0] - iArr2[0];
            rect.set(i4, i3, view.getWidth() + i4, view.getHeight() + i3);
        }
    }

    private CharSequence getDecoratedHint(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, charSequence)) == null) {
            if (!this.mIconifiedByDefault || this.mSearchHintIcon == null) {
                return charSequence;
            }
            int textSize = (int) (this.mSearchSrcTextView.getTextSize() * 1.25d);
            this.mSearchHintIcon.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(this.mSearchHintIcon), 1, 2, 33);
            spannableStringBuilder.append(charSequence);
            return spannableStringBuilder;
        }
        return (CharSequence) invokeL.objValue;
    }

    private int getPreferredHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height) : invokeV.intValue;
    }

    private int getPreferredWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width) : invokeV.intValue;
    }

    private boolean hasVoiceSearch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            SearchableInfo searchableInfo = this.mSearchable;
            if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
                return false;
            }
            Intent intent = null;
            if (this.mSearchable.getVoiceSearchLaunchWebSearch()) {
                intent = this.mVoiceWebSearchIntent;
            } else if (this.mSearchable.getVoiceSearchLaunchRecognizer()) {
                intent = this.mVoiceAppSearchIntent;
            }
            return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isLandscapeMode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) ? context.getResources().getConfiguration().orientation == 2 : invokeL.booleanValue;
    }

    private boolean isSubmitAreaEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) ? (this.mSubmitButtonEnabled || this.mVoiceButtonEnabled) && !isIconified() : invokeV.booleanValue;
    }

    private void launchIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, this, intent) == null) || intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e2) {
            Log.e(LOG_TAG, "Failed launch activity: " + intent, e2);
        }
    }

    private boolean launchSuggestion(int i2, int i3, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65553, this, i2, i3, str)) == null) {
            Cursor cursor = this.mSuggestionsAdapter.getCursor();
            if (cursor == null || !cursor.moveToPosition(i2)) {
                return false;
            }
            launchIntent(createIntentFromSuggestion(cursor, i3, str));
            return true;
        }
        return invokeIIL.booleanValue;
    }

    private void postUpdateFocusedState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            post(this.mUpdateDrawableStateRunnable);
        }
    }

    private void rewriteQueryFromSuggestion(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65555, this, i2) == null) {
            Editable text = this.mSearchSrcTextView.getText();
            Cursor cursor = this.mSuggestionsAdapter.getCursor();
            if (cursor == null) {
                return;
            }
            if (cursor.moveToPosition(i2)) {
                CharSequence convertToString = this.mSuggestionsAdapter.convertToString(cursor);
                if (convertToString != null) {
                    setQuery(convertToString);
                    return;
                } else {
                    setQuery(text);
                    return;
                }
            }
            setQuery(text);
        }
    }

    private void updateCloseButton() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            boolean z = true;
            boolean z2 = !TextUtils.isEmpty(this.mSearchSrcTextView.getText());
            if (!z2 && (!this.mIconifiedByDefault || this.mExpandedInActionView)) {
                z = false;
            }
            this.mCloseButton.setVisibility(z ? 0 : 8);
            Drawable drawable = this.mCloseButton.getDrawable();
            if (drawable != null) {
                drawable.setState(z2 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
            }
        }
    }

    private void updateQueryHint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            CharSequence queryHint = getQueryHint();
            SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
            if (queryHint == null) {
                queryHint = "";
            }
            searchAutoComplete.setHint(getDecoratedHint(queryHint));
        }
    }

    private void updateSearchAutoComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            this.mSearchSrcTextView.setThreshold(this.mSearchable.getSuggestThreshold());
            this.mSearchSrcTextView.setImeOptions(this.mSearchable.getImeOptions());
            int inputType = this.mSearchable.getInputType();
            if ((inputType & 15) == 1) {
                inputType &= -65537;
                if (this.mSearchable.getSuggestAuthority() != null) {
                    inputType = inputType | 65536 | 524288;
                }
            }
            this.mSearchSrcTextView.setInputType(inputType);
            CursorAdapter cursorAdapter = this.mSuggestionsAdapter;
            if (cursorAdapter != null) {
                cursorAdapter.changeCursor(null);
            }
            if (this.mSearchable.getSuggestAuthority() != null) {
                SuggestionsAdapter suggestionsAdapter = new SuggestionsAdapter(getContext(), this, this.mSearchable, this.mOutsideDrawablesCache);
                this.mSuggestionsAdapter = suggestionsAdapter;
                this.mSearchSrcTextView.setAdapter(suggestionsAdapter);
                ((SuggestionsAdapter) this.mSuggestionsAdapter).setQueryRefinement(this.mQueryRefinement ? 2 : 1);
            }
        }
    }

    private void updateSubmitArea() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            this.mSubmitArea.setVisibility((isSubmitAreaEnabled() && (this.mGoButton.getVisibility() == 0 || this.mVoiceButton.getVisibility() == 0)) ? 0 : 8);
        }
    }

    private void updateSubmitButton(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65561, this, z) == null) {
            this.mGoButton.setVisibility((this.mSubmitButtonEnabled && isSubmitAreaEnabled() && hasFocus() && (z || !this.mVoiceButtonEnabled)) ? 0 : 8);
        }
    }

    private void updateViewsVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65562, this, z) == null) {
            this.mIconified = z;
            int i2 = 0;
            int i3 = z ? 0 : 8;
            boolean z2 = !TextUtils.isEmpty(this.mSearchSrcTextView.getText());
            this.mSearchButton.setVisibility(i3);
            updateSubmitButton(z2);
            this.mSearchEditFrame.setVisibility(z ? 8 : 0);
            this.mCollapsedIcon.setVisibility((this.mCollapsedIcon.getDrawable() == null || this.mIconifiedByDefault) ? 8 : 8);
            updateCloseButton();
            updateVoiceButton(!z2);
            updateSubmitArea();
        }
    }

    private void updateVoiceButton(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65563, this, z) == null) {
            int i2 = 8;
            if (this.mVoiceButtonEnabled && !isIconified() && z) {
                this.mGoButton.setVisibility(8);
                i2 = 0;
            }
            this.mVoiceButton.setVisibility(i2);
        }
    }

    public void adjustDropDownSizeAndPosition() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.mDropDownAnchor.getWidth() <= 1) {
            return;
        }
        Resources resources = getContext().getResources();
        int paddingLeft = this.mSearchPlate.getPaddingLeft();
        Rect rect = new Rect();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int dimensionPixelSize = this.mIconifiedByDefault ? resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) : 0;
        this.mSearchSrcTextView.getDropDownBackground().getPadding(rect);
        if (isLayoutRtl) {
            i2 = -rect.left;
        } else {
            i2 = paddingLeft - (rect.left + dimensionPixelSize);
        }
        this.mSearchSrcTextView.setDropDownHorizontalOffset(i2);
        this.mSearchSrcTextView.setDropDownWidth((((this.mDropDownAnchor.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mClearingFocus = true;
            super.clearFocus();
            this.mSearchSrcTextView.clearFocus();
            this.mSearchSrcTextView.setImeVisibility(false);
            this.mClearingFocus = false;
        }
    }

    public void forceSuggestionQuery() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.mSearchSrcTextView.refreshAutoCompleteResults();
                return;
            }
            PRE_API_29_HIDDEN_METHOD_INVOKER.doBeforeTextChanged(this.mSearchSrcTextView);
            PRE_API_29_HIDDEN_METHOD_INVOKER.doAfterTextChanged(this.mSearchSrcTextView);
        }
    }

    public int getImeOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mSearchSrcTextView.getImeOptions() : invokeV.intValue;
    }

    public int getInputType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mSearchSrcTextView.getInputType() : invokeV.intValue;
    }

    public int getMaxWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mMaxWidth : invokeV.intValue;
    }

    public CharSequence getQuery() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mSearchSrcTextView.getText() : (CharSequence) invokeV.objValue;
    }

    @Nullable
    public CharSequence getQueryHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            CharSequence charSequence = this.mQueryHint;
            if (charSequence != null) {
                return charSequence;
            }
            SearchableInfo searchableInfo = this.mSearchable;
            if (searchableInfo != null && searchableInfo.getHintId() != 0) {
                return getContext().getText(this.mSearchable.getHintId());
            }
            return this.mDefaultQueryHint;
        }
        return (CharSequence) invokeV.objValue;
    }

    public int getSuggestionCommitIconResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mSuggestionCommitIconResId : invokeV.intValue;
    }

    public int getSuggestionRowLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mSuggestionRowLayout : invokeV.intValue;
    }

    public CursorAdapter getSuggestionsAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mSuggestionsAdapter : (CursorAdapter) invokeV.objValue;
    }

    public boolean isIconfiedByDefault() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mIconifiedByDefault : invokeV.booleanValue;
    }

    public boolean isIconified() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mIconified : invokeV.booleanValue;
    }

    public boolean isQueryRefinementEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mQueryRefinement : invokeV.booleanValue;
    }

    public boolean isSubmitButtonEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mSubmitButtonEnabled : invokeV.booleanValue;
    }

    public void launchQuerySearch(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048591, this, i2, str, str2) == null) {
            getContext().startActivity(createIntent("android.intent.action.SEARCH", null, null, str2, i2, str));
        }
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewCollapsed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            setQuery("", false);
            clearFocus();
            updateViewsVisibility(true);
            this.mSearchSrcTextView.setImeOptions(this.mCollapsedImeOptions);
            this.mExpandedInActionView = false;
        }
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewExpanded() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.mExpandedInActionView) {
            return;
        }
        this.mExpandedInActionView = true;
        int imeOptions = this.mSearchSrcTextView.getImeOptions();
        this.mCollapsedImeOptions = imeOptions;
        this.mSearchSrcTextView.setImeOptions(imeOptions | 33554432);
        this.mSearchSrcTextView.setText("");
        setIconified(false);
    }

    public void onCloseClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (TextUtils.isEmpty(this.mSearchSrcTextView.getText())) {
                if (this.mIconifiedByDefault) {
                    OnCloseListener onCloseListener = this.mOnCloseListener;
                    if (onCloseListener == null || !onCloseListener.onClose()) {
                        clearFocus();
                        updateViewsVisibility(true);
                        return;
                    }
                    return;
                }
                return;
            }
            this.mSearchSrcTextView.setText("");
            this.mSearchSrcTextView.requestFocus();
            this.mSearchSrcTextView.setImeVisibility(true);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            removeCallbacks(this.mUpdateDrawableStateRunnable);
            post(this.mReleaseCursorRunnable);
            super.onDetachedFromWindow();
        }
    }

    public boolean onItemClicked(int i2, int i3, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048596, this, i2, i3, str)) == null) {
            OnSuggestionListener onSuggestionListener = this.mOnSuggestionListener;
            if (onSuggestionListener == null || !onSuggestionListener.onSuggestionClick(i2)) {
                launchSuggestion(i2, 0, null);
                this.mSearchSrcTextView.setImeVisibility(false);
                dismissSuggestions();
                return true;
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    public boolean onItemSelected(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            OnSuggestionListener onSuggestionListener = this.mOnSuggestionListener;
            if (onSuggestionListener == null || !onSuggestionListener.onSuggestionSelect(i2)) {
                rewriteQueryFromSuggestion(i2);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (z) {
                getChildBoundsWithinSearchView(this.mSearchSrcTextView, this.mSearchSrcTextViewBounds);
                Rect rect = this.mSearchSrtTextViewBoundsExpanded;
                Rect rect2 = this.mSearchSrcTextViewBounds;
                rect.set(rect2.left, 0, rect2.right, i5 - i3);
                UpdatableTouchDelegate updatableTouchDelegate = this.mTouchDelegate;
                if (updatableTouchDelegate == null) {
                    UpdatableTouchDelegate updatableTouchDelegate2 = new UpdatableTouchDelegate(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds, this.mSearchSrcTextView);
                    this.mTouchDelegate = updatableTouchDelegate2;
                    setTouchDelegate(updatableTouchDelegate2);
                    return;
                }
                updatableTouchDelegate.setBounds(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds);
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048599, this, i2, i3) == null) {
            if (isIconified()) {
                super.onMeasure(i2, i3);
                return;
            }
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode == Integer.MIN_VALUE) {
                int i5 = this.mMaxWidth;
                size = i5 > 0 ? Math.min(i5, size) : Math.min(getPreferredWidth(), size);
            } else if (mode == 0) {
                size = this.mMaxWidth;
                if (size <= 0) {
                    size = getPreferredWidth();
                }
            } else if (mode == 1073741824 && (i4 = this.mMaxWidth) > 0) {
                size = Math.min(i4, size);
            }
            int mode2 = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i3);
            if (mode2 == Integer.MIN_VALUE) {
                size2 = Math.min(getPreferredHeight(), size2);
            } else if (mode2 == 0) {
                size2 = getPreferredHeight();
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        }
    }

    public void onQueryRefine(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, charSequence) == null) {
            setQuery(charSequence);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, parcelable) == null) {
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(parcelable);
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            updateViewsVisibility(savedState.isIconified);
            requestLayout();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.isIconified = isIconified();
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    public void onSearchClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            updateViewsVisibility(false);
            this.mSearchSrcTextView.requestFocus();
            this.mSearchSrcTextView.setImeVisibility(true);
            View.OnClickListener onClickListener = this.mOnSearchClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(this);
            }
        }
    }

    public void onSubmitQuery() {
        Editable text;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (text = this.mSearchSrcTextView.getText()) == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        OnQueryTextListener onQueryTextListener = this.mOnQueryChangeListener;
        if (onQueryTextListener == null || !onQueryTextListener.onQueryTextSubmit(text.toString())) {
            if (this.mSearchable != null) {
                launchQuerySearch(0, null, text.toString());
            }
            this.mSearchSrcTextView.setImeVisibility(false);
            dismissSuggestions();
        }
    }

    public boolean onSuggestionsKey(View view, int i2, KeyEvent keyEvent) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048605, this, view, i2, keyEvent)) == null) {
            if (this.mSearchable != null && this.mSuggestionsAdapter != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
                if (i2 == 66 || i2 == 84 || i2 == 61) {
                    return onItemClicked(this.mSearchSrcTextView.getListSelection(), 0, null);
                }
                if (i2 != 21 && i2 != 22) {
                    if (i2 != 19 || this.mSearchSrcTextView.getListSelection() == 0) {
                        return false;
                    }
                } else {
                    this.mSearchSrcTextView.setSelection(i2 == 21 ? 0 : this.mSearchSrcTextView.length());
                    this.mSearchSrcTextView.setListSelection(0);
                    this.mSearchSrcTextView.clearListSelection();
                    this.mSearchSrcTextView.ensureImeVisible();
                    return true;
                }
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public void onTextChanged(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, charSequence) == null) {
            Editable text = this.mSearchSrcTextView.getText();
            this.mUserQuery = text;
            boolean z = !TextUtils.isEmpty(text);
            updateSubmitButton(z);
            updateVoiceButton(!z);
            updateCloseButton();
            updateSubmitArea();
            if (this.mOnQueryChangeListener != null && !TextUtils.equals(charSequence, this.mOldQueryText)) {
                this.mOnQueryChangeListener.onQueryTextChange(charSequence.toString());
            }
            this.mOldQueryText = charSequence.toString();
        }
    }

    public void onTextFocusChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            updateViewsVisibility(isIconified());
            postUpdateFocusedState();
            if (this.mSearchSrcTextView.hasFocus()) {
                forceSuggestionQuery();
            }
        }
    }

    public void onVoiceClicked() {
        SearchableInfo searchableInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (searchableInfo = this.mSearchable) == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(createVoiceWebSearchIntent(this.mVoiceWebSearchIntent, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(createVoiceAppSearchIntent(this.mVoiceAppSearchIntent, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w(LOG_TAG, "Could not find voice search activity");
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            super.onWindowFocusChanged(z);
            postUpdateFocusedState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i2, Rect rect) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048610, this, i2, rect)) == null) {
            if (!this.mClearingFocus && isFocusable()) {
                if (!isIconified()) {
                    boolean requestFocus = this.mSearchSrcTextView.requestFocus(i2, rect);
                    if (requestFocus) {
                        updateViewsVisibility(false);
                    }
                    return requestFocus;
                }
                return super.requestFocus(i2, rect);
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAppSearchData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bundle) == null) {
            this.mAppSearchData = bundle;
        }
    }

    public void setIconified(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            if (z) {
                onCloseClicked();
            } else {
                onSearchClicked();
            }
        }
    }

    public void setIconifiedByDefault(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048613, this, z) == null) || this.mIconifiedByDefault == z) {
            return;
        }
        this.mIconifiedByDefault = z;
        updateViewsVisibility(z);
        updateQueryHint();
    }

    public void setImeOptions(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.mSearchSrcTextView.setImeOptions(i2);
        }
    }

    public void setInputType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.mSearchSrcTextView.setInputType(i2);
        }
    }

    public void setMaxWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.mMaxWidth = i2;
            requestLayout();
        }
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, onCloseListener) == null) {
            this.mOnCloseListener = onCloseListener;
        }
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, onFocusChangeListener) == null) {
            this.mOnQueryTextFocusChangeListener = onFocusChangeListener;
        }
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, onQueryTextListener) == null) {
            this.mOnQueryChangeListener = onQueryTextListener;
        }
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, onClickListener) == null) {
            this.mOnSearchClickListener = onClickListener;
        }
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, onSuggestionListener) == null) {
            this.mOnSuggestionListener = onSuggestionListener;
        }
    }

    public void setQuery(CharSequence charSequence, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048622, this, charSequence, z) == null) {
            this.mSearchSrcTextView.setText(charSequence);
            if (charSequence != null) {
                SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
                searchAutoComplete.setSelection(searchAutoComplete.length());
                this.mUserQuery = charSequence;
            }
            if (!z || TextUtils.isEmpty(charSequence)) {
                return;
            }
            onSubmitQuery();
        }
    }

    public void setQueryHint(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, charSequence) == null) {
            this.mQueryHint = charSequence;
            updateQueryHint();
        }
    }

    public void setQueryRefinementEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.mQueryRefinement = z;
            CursorAdapter cursorAdapter = this.mSuggestionsAdapter;
            if (cursorAdapter instanceof SuggestionsAdapter) {
                ((SuggestionsAdapter) cursorAdapter).setQueryRefinement(z ? 2 : 1);
            }
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, searchableInfo) == null) {
            this.mSearchable = searchableInfo;
            if (searchableInfo != null) {
                updateSearchAutoComplete();
                updateQueryHint();
            }
            boolean hasVoiceSearch = hasVoiceSearch();
            this.mVoiceButtonEnabled = hasVoiceSearch;
            if (hasVoiceSearch) {
                this.mSearchSrcTextView.setPrivateImeOptions(IME_OPTION_NO_MICROPHONE);
            }
            updateViewsVisibility(isIconified());
        }
    }

    public void setSubmitButtonEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.mSubmitButtonEnabled = z;
            updateViewsVisibility(isIconified());
        }
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, cursorAdapter) == null) {
            this.mSuggestionsAdapter = cursorAdapter;
            this.mSearchSrcTextView.setAdapter(cursorAdapter);
        }
    }

    public void updateFocusedState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            int[] iArr = this.mSearchSrcTextView.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
            Drawable background = this.mSearchPlate.getBackground();
            if (background != null) {
                background.setState(iArr);
            }
            Drawable background2 = this.mSubmitArea.getBackground();
            if (background2 != null) {
                background2.setState(iArr);
            }
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mSearchSrcTextViewBounds = new Rect();
        this.mSearchSrtTextViewBoundsExpanded = new Rect();
        this.mTemp = new int[2];
        this.mTemp2 = new int[2];
        this.mUpdateDrawableStateRunnable = new Runnable(this) { // from class: androidx.appcompat.widget.SearchView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SearchView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
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
                    this.this$0.updateFocusedState();
                }
            }
        };
        this.mReleaseCursorRunnable = new Runnable(this) { // from class: androidx.appcompat.widget.SearchView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SearchView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
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
                    CursorAdapter cursorAdapter = this.this$0.mSuggestionsAdapter;
                    if (cursorAdapter instanceof SuggestionsAdapter) {
                        cursorAdapter.changeCursor(null);
                    }
                }
            }
        };
        this.mOutsideDrawablesCache = new WeakHashMap<>();
        this.mOnClickListener = new View.OnClickListener(this) { // from class: androidx.appcompat.widget.SearchView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SearchView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    SearchView searchView = this.this$0;
                    if (view == searchView.mSearchButton) {
                        searchView.onSearchClicked();
                    } else if (view == searchView.mCloseButton) {
                        searchView.onCloseClicked();
                    } else if (view == searchView.mGoButton) {
                        searchView.onSubmitQuery();
                    } else if (view == searchView.mVoiceButton) {
                        searchView.onVoiceClicked();
                    } else if (view == searchView.mSearchSrcTextView) {
                        searchView.forceSuggestionQuery();
                    }
                }
            }
        };
        this.mTextKeyListener = new View.OnKeyListener(this) { // from class: androidx.appcompat.widget.SearchView.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SearchView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i5, KeyEvent keyEvent) {
                InterceptResult invokeLIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, view, i5, keyEvent)) == null) {
                    SearchView searchView = this.this$0;
                    if (searchView.mSearchable == null) {
                        return false;
                    }
                    if (searchView.mSearchSrcTextView.isPopupShowing() && this.this$0.mSearchSrcTextView.getListSelection() != -1) {
                        return this.this$0.onSuggestionsKey(view, i5, keyEvent);
                    }
                    if (!this.this$0.mSearchSrcTextView.isEmpty() && keyEvent.hasNoModifiers() && keyEvent.getAction() == 1 && i5 == 66) {
                        view.cancelLongPress();
                        SearchView searchView2 = this.this$0;
                        searchView2.launchQuerySearch(0, null, searchView2.mSearchSrcTextView.getText().toString());
                        return true;
                    }
                    return false;
                }
                return invokeLIL.booleanValue;
            }
        };
        this.mOnEditorActionListener = new TextView.OnEditorActionListener(this) { // from class: androidx.appcompat.widget.SearchView.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SearchView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i5, KeyEvent keyEvent) {
                InterceptResult invokeLIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, textView, i5, keyEvent)) == null) {
                    this.this$0.onSubmitQuery();
                    return true;
                }
                return invokeLIL.booleanValue;
            }
        };
        this.mOnItemClickListener = new AdapterView.OnItemClickListener(this) { // from class: androidx.appcompat.widget.SearchView.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SearchView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i5), Long.valueOf(j)}) == null) {
                    this.this$0.onItemClicked(i5, 0, null);
                }
            }
        };
        this.mOnItemSelectedListener = new AdapterView.OnItemSelectedListener(this) { // from class: androidx.appcompat.widget.SearchView.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SearchView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i5, long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i5), Long.valueOf(j)}) == null) {
                    this.this$0.onItemSelected(i5);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adapterView) == null) {
                }
            }
        };
        this.mTextWatcher = new TextWatcher(this) { // from class: androidx.appcompat.widget.SearchView.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SearchView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i5, i6, i7) == null) {
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i5, i6, i7) == null) {
                    this.this$0.onTextChanged(charSequence);
                }
            }
        };
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.SearchView, i2, 0);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(R.styleable.SearchView_layout, R.layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.mSearchSrcTextView = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.mSearchEditFrame = findViewById(R.id.search_edit_frame);
        this.mSearchPlate = findViewById(R.id.search_plate);
        this.mSubmitArea = findViewById(R.id.submit_area);
        this.mSearchButton = (ImageView) findViewById(R.id.search_button);
        this.mGoButton = (ImageView) findViewById(R.id.search_go_btn);
        this.mCloseButton = (ImageView) findViewById(R.id.search_close_btn);
        this.mVoiceButton = (ImageView) findViewById(R.id.search_voice_btn);
        this.mCollapsedIcon = (ImageView) findViewById(R.id.search_mag_icon);
        ViewCompat.setBackground(this.mSearchPlate, obtainStyledAttributes.getDrawable(R.styleable.SearchView_queryBackground));
        ViewCompat.setBackground(this.mSubmitArea, obtainStyledAttributes.getDrawable(R.styleable.SearchView_submitBackground));
        this.mSearchButton.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_searchIcon));
        this.mGoButton.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_goIcon));
        this.mCloseButton.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_closeIcon));
        this.mVoiceButton.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_voiceIcon));
        this.mCollapsedIcon.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_searchIcon));
        this.mSearchHintIcon = obtainStyledAttributes.getDrawable(R.styleable.SearchView_searchHintIcon);
        TooltipCompat.setTooltipText(this.mSearchButton, getResources().getString(R.string.abc_searchview_description_search));
        this.mSuggestionRowLayout = obtainStyledAttributes.getResourceId(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
        this.mSuggestionCommitIconResId = obtainStyledAttributes.getResourceId(R.styleable.SearchView_commitIcon, 0);
        this.mSearchButton.setOnClickListener(this.mOnClickListener);
        this.mCloseButton.setOnClickListener(this.mOnClickListener);
        this.mGoButton.setOnClickListener(this.mOnClickListener);
        this.mVoiceButton.setOnClickListener(this.mOnClickListener);
        this.mSearchSrcTextView.setOnClickListener(this.mOnClickListener);
        this.mSearchSrcTextView.addTextChangedListener(this.mTextWatcher);
        this.mSearchSrcTextView.setOnEditorActionListener(this.mOnEditorActionListener);
        this.mSearchSrcTextView.setOnItemClickListener(this.mOnItemClickListener);
        this.mSearchSrcTextView.setOnItemSelectedListener(this.mOnItemSelectedListener);
        this.mSearchSrcTextView.setOnKeyListener(this.mTextKeyListener);
        this.mSearchSrcTextView.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: androidx.appcompat.widget.SearchView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SearchView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                SearchView searchView;
                View.OnFocusChangeListener onFocusChangeListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLZ(1048576, this, view, z) == null) || (onFocusChangeListener = (searchView = this.this$0).mOnQueryTextFocusChangeListener) == null) {
                    return;
                }
                onFocusChangeListener.onFocusChange(searchView, z);
            }
        });
        setIconifiedByDefault(obtainStyledAttributes.getBoolean(R.styleable.SearchView_iconifiedByDefault, true));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SearchView_android_maxWidth, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.mDefaultQueryHint = obtainStyledAttributes.getText(R.styleable.SearchView_defaultQueryHint);
        this.mQueryHint = obtainStyledAttributes.getText(R.styleable.SearchView_queryHint);
        int i5 = obtainStyledAttributes.getInt(R.styleable.SearchView_android_imeOptions, -1);
        if (i5 != -1) {
            setImeOptions(i5);
        }
        int i6 = obtainStyledAttributes.getInt(R.styleable.SearchView_android_inputType, -1);
        if (i6 != -1) {
            setInputType(i6);
        }
        setFocusable(obtainStyledAttributes.getBoolean(R.styleable.SearchView_android_focusable, true));
        obtainStyledAttributes.recycle();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.mVoiceWebSearchIntent = intent;
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        this.mVoiceWebSearchIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.mVoiceAppSearchIntent = intent2;
        intent2.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        View findViewById = findViewById(this.mSearchSrcTextView.getDropDownAnchor());
        this.mDropDownAnchor = findViewById;
        if (findViewById != null) {
            findViewById.addOnLayoutChangeListener(new View.OnLayoutChangeListener(this) { // from class: androidx.appcompat.widget.SearchView.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SearchView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr3 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i7 = newInitContext2.flag;
                        if ((i7 & 1) != 0) {
                            int i8 = i7 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14)}) == null) {
                        this.this$0.adjustDropDownSizeAndPosition();
                    }
                }
            });
        }
        updateViewsVisibility(this.mIconifiedByDefault);
        updateQueryHint();
    }

    private void setQuery(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, charSequence) == null) {
            this.mSearchSrcTextView.setText(charSequence);
            this.mSearchSrcTextView.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
        }
    }
}
