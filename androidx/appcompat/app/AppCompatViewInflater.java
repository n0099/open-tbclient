package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class AppCompatViewInflater {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TAG = "AppCompatViewInflater";
    public static final String[] sClassPrefixList;
    public static final SimpleArrayMap<String, Constructor<? extends View>> sConstructorMap;
    public static final Class<?>[] sConstructorSignature;
    public static final int[] sOnClickAttrs;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object[] mConstructorArgs;

    /* loaded from: classes.dex */
    public static class DeclaredOnClickListener implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final View mHostView;
        public final String mMethodName;
        public Context mResolvedContext;
        public Method mResolvedMethod;

        public DeclaredOnClickListener(@NonNull View view2, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mHostView = view2;
            this.mMethodName = str;
        }

        private void resolveMethod(@Nullable Context context) {
            int id;
            String str;
            Method method;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, context) == null) {
                while (context != null) {
                    try {
                        if (!context.isRestricted() && (method = context.getClass().getMethod(this.mMethodName, View.class)) != null) {
                            this.mResolvedMethod = method;
                            this.mResolvedContext = context;
                            return;
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                    context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
                }
                if (this.mHostView.getId() == -1) {
                    str = "";
                } else {
                    str = " with id '" + this.mHostView.getContext().getResources().getResourceEntryName(id) + "'";
                }
                throw new IllegalStateException("Could not find method " + this.mMethodName + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.mHostView.getClass() + str);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NonNull View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.mResolvedMethod == null) {
                    resolveMethod(this.mHostView.getContext());
                }
                try {
                    this.mResolvedMethod.invoke(this.mResolvedContext, view2);
                } catch (IllegalAccessException e) {
                    throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
                } catch (InvocationTargetException e2) {
                    throw new IllegalStateException("Could not execute method for android:onClick", e2);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-394626308, "Landroidx/appcompat/app/AppCompatViewInflater;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-394626308, "Landroidx/appcompat/app/AppCompatViewInflater;");
                return;
            }
        }
        sConstructorSignature = new Class[]{Context.class, AttributeSet.class};
        sOnClickAttrs = new int[]{16843375};
        sClassPrefixList = new String[]{"android.widget.", "android.view.", "android.webkit."};
        sConstructorMap = new SimpleArrayMap<>();
    }

    public AppCompatViewInflater() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mConstructorArgs = new Object[2];
    }

    private void checkOnClickListener(View view2, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, view2, attributeSet) == null) {
            Context context = view2.getContext();
            if (context instanceof ContextWrapper) {
                if (Build.VERSION.SDK_INT < 15 || ViewCompat.hasOnClickListeners(view2)) {
                    TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, sOnClickAttrs);
                    String string = obtainStyledAttributes.getString(0);
                    if (string != null) {
                        view2.setOnClickListener(new DeclaredOnClickListener(view2, string));
                    }
                    obtainStyledAttributes.recycle();
                }
            }
        }
    }

    private View createViewByPrefix(Context context, String str, String str2) throws ClassNotFoundException, InflateException {
        InterceptResult invokeLLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, context, str, str2)) == null) {
            Constructor<? extends View> constructor = sConstructorMap.get(str);
            if (constructor == null) {
                if (str2 != null) {
                    try {
                        str3 = str2 + str;
                    } catch (Exception unused) {
                        return null;
                    }
                } else {
                    str3 = str;
                }
                constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(sConstructorSignature);
                sConstructorMap.put(str, constructor);
            }
            constructor.setAccessible(true);
            return constructor.newInstance(this.mConstructorArgs);
        }
        return (View) invokeLLL.objValue;
    }

    private View createViewFromTag(Context context, String str, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, str, attributeSet)) == null) {
            if (str.equals(NativeConstants.TYPE_VIEW)) {
                str = attributeSet.getAttributeValue(null, DealIntentService.KEY_CLASS);
            }
            try {
                this.mConstructorArgs[0] = context;
                this.mConstructorArgs[1] = attributeSet;
                if (-1 == str.indexOf(46)) {
                    for (int i = 0; i < sClassPrefixList.length; i++) {
                        View createViewByPrefix = createViewByPrefix(context, str, sClassPrefixList[i]);
                        if (createViewByPrefix != null) {
                            return createViewByPrefix;
                        }
                    }
                    return null;
                }
                return createViewByPrefix(context, str, null);
            } catch (Exception unused) {
                return null;
            } finally {
                Object[] objArr = this.mConstructorArgs;
                objArr[0] = null;
                objArr[1] = null;
            }
        }
        return (View) invokeLLL.objValue;
    }

    public static Context themifyContext(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, attributeSet, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.View, 0, 0);
            int resourceId = z ? obtainStyledAttributes.getResourceId(0, 0) : 0;
            if (z2 && resourceId == 0 && (resourceId = obtainStyledAttributes.getResourceId(63, 0)) != 0) {
                Log.i(LOG_TAG, "app:theme is now deprecated. Please move to using android:theme instead.");
            }
            obtainStyledAttributes.recycle();
            return resourceId != 0 ? ((context instanceof ContextThemeWrapper) && ((ContextThemeWrapper) context).getThemeResId() == resourceId) ? context : new ContextThemeWrapper(context, resourceId) : context;
        }
        return (Context) invokeCommon.objValue;
    }

    private void verifyNotNull(View view2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, this, view2, str) == null) && view2 == null) {
            throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
        }
    }

    @NonNull
    public AppCompatAutoCompleteTextView createAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, attributeSet)) == null) ? new AppCompatAutoCompleteTextView(context, attributeSet) : (AppCompatAutoCompleteTextView) invokeLL.objValue;
    }

    @NonNull
    public AppCompatButton createButton(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, attributeSet)) == null) ? new AppCompatButton(context, attributeSet) : (AppCompatButton) invokeLL.objValue;
    }

    @NonNull
    public AppCompatCheckBox createCheckBox(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, attributeSet)) == null) ? new AppCompatCheckBox(context, attributeSet) : (AppCompatCheckBox) invokeLL.objValue;
    }

    @NonNull
    public AppCompatCheckedTextView createCheckedTextView(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, attributeSet)) == null) ? new AppCompatCheckedTextView(context, attributeSet) : (AppCompatCheckedTextView) invokeLL.objValue;
    }

    @NonNull
    public AppCompatEditText createEditText(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, attributeSet)) == null) ? new AppCompatEditText(context, attributeSet) : (AppCompatEditText) invokeLL.objValue;
    }

    @NonNull
    public AppCompatImageButton createImageButton(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, context, attributeSet)) == null) ? new AppCompatImageButton(context, attributeSet) : (AppCompatImageButton) invokeLL.objValue;
    }

    @NonNull
    public AppCompatImageView createImageView(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, context, attributeSet)) == null) ? new AppCompatImageView(context, attributeSet) : (AppCompatImageView) invokeLL.objValue;
    }

    @NonNull
    public AppCompatMultiAutoCompleteTextView createMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, context, attributeSet)) == null) ? new AppCompatMultiAutoCompleteTextView(context, attributeSet) : (AppCompatMultiAutoCompleteTextView) invokeLL.objValue;
    }

    @NonNull
    public AppCompatRadioButton createRadioButton(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, attributeSet)) == null) ? new AppCompatRadioButton(context, attributeSet) : (AppCompatRadioButton) invokeLL.objValue;
    }

    @NonNull
    public AppCompatRatingBar createRatingBar(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, context, attributeSet)) == null) ? new AppCompatRatingBar(context, attributeSet) : (AppCompatRatingBar) invokeLL.objValue;
    }

    @NonNull
    public AppCompatSeekBar createSeekBar(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, context, attributeSet)) == null) ? new AppCompatSeekBar(context, attributeSet) : (AppCompatSeekBar) invokeLL.objValue;
    }

    @NonNull
    public AppCompatSpinner createSpinner(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, context, attributeSet)) == null) ? new AppCompatSpinner(context, attributeSet) : (AppCompatSpinner) invokeLL.objValue;
    }

    @NonNull
    public AppCompatTextView createTextView(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, context, attributeSet)) == null) ? new AppCompatTextView(context, attributeSet) : (AppCompatTextView) invokeLL.objValue;
    }

    @NonNull
    public AppCompatToggleButton createToggleButton(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, context, attributeSet)) == null) ? new AppCompatToggleButton(context, attributeSet) : (AppCompatToggleButton) invokeLL.objValue;
    }

    @Nullable
    public View createView(Context context, String str, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, context, str, attributeSet)) == null) {
            return null;
        }
        return (View) invokeLLL.objValue;
    }

    public final View createView(View view2, String str, @NonNull Context context, @NonNull AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        View createTextView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{view2, str, context, attributeSet, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            Context context2 = (!z || view2 == null) ? context : view2.getContext();
            if (z2 || z3) {
                context2 = themifyContext(context2, attributeSet, z2, z3);
            }
            if (z4) {
                context2 = TintContextWrapper.wrap(context2);
            }
            char c = 65535;
            switch (str.hashCode()) {
                case -1946472170:
                    if (str.equals("RatingBar")) {
                        c = 11;
                        break;
                    }
                    break;
                case -1455429095:
                    if (str.equals("CheckedTextView")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -1346021293:
                    if (str.equals("MultiAutoCompleteTextView")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -938935918:
                    if (str.equals("TextView")) {
                        c = 0;
                        break;
                    }
                    break;
                case -937446323:
                    if (str.equals("ImageButton")) {
                        c = 5;
                        break;
                    }
                    break;
                case -658531749:
                    if (str.equals("SeekBar")) {
                        c = '\f';
                        break;
                    }
                    break;
                case -339785223:
                    if (str.equals("Spinner")) {
                        c = 4;
                        break;
                    }
                    break;
                case 776382189:
                    if (str.equals("RadioButton")) {
                        c = 7;
                        break;
                    }
                    break;
                case 799298502:
                    if (str.equals("ToggleButton")) {
                        c = '\r';
                        break;
                    }
                    break;
                case 1125864064:
                    if (str.equals("ImageView")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1413872058:
                    if (str.equals("AutoCompleteTextView")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 1601505219:
                    if (str.equals("CheckBox")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1666676343:
                    if (str.equals("EditText")) {
                        c = 3;
                        break;
                    }
                    break;
                case 2001146706:
                    if (str.equals("Button")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    createTextView = createTextView(context2, attributeSet);
                    verifyNotNull(createTextView, str);
                    break;
                case 1:
                    createTextView = createImageView(context2, attributeSet);
                    verifyNotNull(createTextView, str);
                    break;
                case 2:
                    createTextView = createButton(context2, attributeSet);
                    verifyNotNull(createTextView, str);
                    break;
                case 3:
                    createTextView = createEditText(context2, attributeSet);
                    verifyNotNull(createTextView, str);
                    break;
                case 4:
                    createTextView = createSpinner(context2, attributeSet);
                    verifyNotNull(createTextView, str);
                    break;
                case 5:
                    createTextView = createImageButton(context2, attributeSet);
                    verifyNotNull(createTextView, str);
                    break;
                case 6:
                    createTextView = createCheckBox(context2, attributeSet);
                    verifyNotNull(createTextView, str);
                    break;
                case 7:
                    createTextView = createRadioButton(context2, attributeSet);
                    verifyNotNull(createTextView, str);
                    break;
                case '\b':
                    createTextView = createCheckedTextView(context2, attributeSet);
                    verifyNotNull(createTextView, str);
                    break;
                case '\t':
                    createTextView = createAutoCompleteTextView(context2, attributeSet);
                    verifyNotNull(createTextView, str);
                    break;
                case '\n':
                    createTextView = createMultiAutoCompleteTextView(context2, attributeSet);
                    verifyNotNull(createTextView, str);
                    break;
                case 11:
                    createTextView = createRatingBar(context2, attributeSet);
                    verifyNotNull(createTextView, str);
                    break;
                case '\f':
                    createTextView = createSeekBar(context2, attributeSet);
                    verifyNotNull(createTextView, str);
                    break;
                case '\r':
                    createTextView = createToggleButton(context2, attributeSet);
                    verifyNotNull(createTextView, str);
                    break;
                default:
                    createTextView = createView(context2, str, attributeSet);
                    break;
            }
            if (createTextView == null && context != context2) {
                createTextView = createViewFromTag(context2, str, attributeSet);
            }
            if (createTextView != null) {
                checkOnClickListener(createTextView, attributeSet);
            }
            return createTextView;
        }
        return (View) invokeCommon.objValue;
    }
}
