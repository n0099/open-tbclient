package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.R$id;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class AccessibilityNodeInfoCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final String ACTION_ARGUMENT_COLUMN_INT = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_X = "ACTION_ARGUMENT_MOVE_WINDOW_X";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_Y = "ACTION_ARGUMENT_MOVE_WINDOW_Y";
    public static final String ACTION_ARGUMENT_PROGRESS_VALUE = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
    public static final String ACTION_ARGUMENT_ROW_INT = "android.view.accessibility.action.ARGUMENT_ROW_INT";
    public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COLLAPSE = 524288;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 65536;
    public static final int ACTION_DISMISS = 1048576;
    public static final int ACTION_EXPAND = 262144;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PASTE = 32768;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 131072;
    public static final int ACTION_SET_TEXT = 2097152;
    public static final int BOOLEAN_PROPERTY_IS_HEADING = 2;
    public static final int BOOLEAN_PROPERTY_IS_SHOWING_HINT = 4;
    public static final int BOOLEAN_PROPERTY_IS_TEXT_ENTRY_KEY = 8;
    public static final String BOOLEAN_PROPERTY_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";
    public static final int BOOLEAN_PROPERTY_SCREEN_READER_FOCUSABLE = 1;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    public static final String HINT_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY";
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    public static final String PANE_TITLE_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY";
    public static final String ROLE_DESCRIPTION_KEY = "AccessibilityNodeInfo.roleDescription";
    public static final String SPANS_ACTION_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY";
    public static final String SPANS_END_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY";
    public static final String SPANS_FLAGS_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY";
    public static final String SPANS_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY";
    public static final String SPANS_START_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY";
    public static final String TOOLTIP_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY";
    public static int sClickableSpanId;
    public transient /* synthetic */ FieldHolder $fh;
    public final AccessibilityNodeInfo mInfo;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int mParentVirtualDescendantId;
    public int mVirtualDescendantId;

    /* loaded from: classes.dex */
    public static class AccessibilityActionCompat {
        public static /* synthetic */ Interceptable $ic = null;
        public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS;
        public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS;
        public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS;
        public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION;
        public static final AccessibilityActionCompat ACTION_CLICK;
        public static final AccessibilityActionCompat ACTION_COLLAPSE;
        public static final AccessibilityActionCompat ACTION_CONTEXT_CLICK;
        public static final AccessibilityActionCompat ACTION_COPY;
        public static final AccessibilityActionCompat ACTION_CUT;
        public static final AccessibilityActionCompat ACTION_DISMISS;
        public static final AccessibilityActionCompat ACTION_EXPAND;
        public static final AccessibilityActionCompat ACTION_FOCUS;
        public static final AccessibilityActionCompat ACTION_HIDE_TOOLTIP;
        public static final AccessibilityActionCompat ACTION_LONG_CLICK;
        public static final AccessibilityActionCompat ACTION_MOVE_WINDOW;
        public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
        public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT;
        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_DOWN;
        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_LEFT;
        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_RIGHT;
        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_UP;
        public static final AccessibilityActionCompat ACTION_PASTE;
        public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY;
        public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT;
        public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD;
        public static final AccessibilityActionCompat ACTION_SCROLL_DOWN;
        public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD;
        public static final AccessibilityActionCompat ACTION_SCROLL_LEFT;
        public static final AccessibilityActionCompat ACTION_SCROLL_RIGHT;
        public static final AccessibilityActionCompat ACTION_SCROLL_TO_POSITION;
        public static final AccessibilityActionCompat ACTION_SCROLL_UP;
        public static final AccessibilityActionCompat ACTION_SELECT;
        public static final AccessibilityActionCompat ACTION_SET_PROGRESS;
        public static final AccessibilityActionCompat ACTION_SET_SELECTION;
        public static final AccessibilityActionCompat ACTION_SET_TEXT;
        public static final AccessibilityActionCompat ACTION_SHOW_ON_SCREEN;
        public static final AccessibilityActionCompat ACTION_SHOW_TOOLTIP;
        public static final String TAG = "A11yActionCompat";
        public transient /* synthetic */ FieldHolder $fh;
        public final Object mAction;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final AccessibilityViewCommand mCommand;
        public final int mId;
        public final Class<? extends AccessibilityViewCommand.CommandArguments> mViewCommandArgumentClass;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(943572462, "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat$AccessibilityActionCompat;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(943572462, "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat$AccessibilityActionCompat;");
                    return;
                }
            }
            ACTION_FOCUS = new AccessibilityActionCompat(1, null);
            ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, null);
            ACTION_SELECT = new AccessibilityActionCompat(4, null);
            ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8, null);
            ACTION_CLICK = new AccessibilityActionCompat(16, null);
            ACTION_LONG_CLICK = new AccessibilityActionCompat(32, null);
            ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(64, null);
            ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(128, null);
            ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(256, (CharSequence) null, AccessibilityViewCommand.MoveAtGranularityArguments.class);
            ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(512, (CharSequence) null, AccessibilityViewCommand.MoveAtGranularityArguments.class);
            ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(1024, (CharSequence) null, AccessibilityViewCommand.MoveHtmlArguments.class);
            ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(2048, (CharSequence) null, AccessibilityViewCommand.MoveHtmlArguments.class);
            ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096, null);
            ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(8192, null);
            ACTION_COPY = new AccessibilityActionCompat(16384, null);
            ACTION_PASTE = new AccessibilityActionCompat(32768, null);
            ACTION_CUT = new AccessibilityActionCompat(65536, null);
            ACTION_SET_SELECTION = new AccessibilityActionCompat(131072, (CharSequence) null, AccessibilityViewCommand.SetSelectionArguments.class);
            ACTION_EXPAND = new AccessibilityActionCompat(262144, null);
            ACTION_COLLAPSE = new AccessibilityActionCompat(524288, null);
            ACTION_DISMISS = new AccessibilityActionCompat(1048576, null);
            ACTION_SET_TEXT = new AccessibilityActionCompat(2097152, (CharSequence) null, AccessibilityViewCommand.SetTextArguments.class);
            ACTION_SHOW_ON_SCREEN = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, 16908342, null, null, null);
            ACTION_SCROLL_TO_POSITION = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, 16908343, null, null, AccessibilityViewCommand.ScrollToPositionArguments.class);
            ACTION_SCROLL_UP = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, null, null, null);
            ACTION_SCROLL_LEFT = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, 16908345, null, null, null);
            ACTION_SCROLL_DOWN = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, null, null, null);
            ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, 16908347, null, null, null);
            ACTION_PAGE_UP = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, 16908358, null, null, null);
            ACTION_PAGE_DOWN = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, 16908359, null, null, null);
            ACTION_PAGE_LEFT = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, 16908360, null, null, null);
            ACTION_PAGE_RIGHT = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, 16908361, null, null, null);
            ACTION_CONTEXT_CLICK = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, 16908348, null, null, null);
            ACTION_SET_PROGRESS = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, 16908349, null, null, AccessibilityViewCommand.SetProgressArguments.class);
            ACTION_MOVE_WINDOW = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, 16908354, null, null, AccessibilityViewCommand.MoveWindowArguments.class);
            ACTION_SHOW_TOOLTIP = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, 16908356, null, null, null);
            ACTION_HIDE_TOOLTIP = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, 16908357, null, null, null);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public AccessibilityActionCompat(int i, CharSequence charSequence) {
            this(null, i, charSequence, null, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), charSequence};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(objArr2[0], ((Integer) objArr2[1]).intValue(), (CharSequence) objArr2[2], (AccessibilityViewCommand) objArr2[3], (Class) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public AccessibilityActionCompat createReplacementAction(CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, charSequence, accessibilityViewCommand)) == null) ? new AccessibilityActionCompat(null, this.mId, charSequence, accessibilityViewCommand, this.mViewCommandArgumentClass) : (AccessibilityActionCompat) invokeLL.objValue;
        }

        public boolean equals(@Nullable Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj != null && (obj instanceof AccessibilityActionCompat)) {
                    AccessibilityActionCompat accessibilityActionCompat = (AccessibilityActionCompat) obj;
                    Object obj2 = this.mAction;
                    return obj2 == null ? accessibilityActionCompat.mAction == null : obj2.equals(accessibilityActionCompat.mAction);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int getId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    return ((AccessibilityNodeInfo.AccessibilityAction) this.mAction).getId();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        public CharSequence getLabel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    return ((AccessibilityNodeInfo.AccessibilityAction) this.mAction).getLabel();
                }
                return null;
            }
            return (CharSequence) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.mAction;
                if (obj != null) {
                    return obj.hashCode();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean perform(View view, Bundle bundle) {
            InterceptResult invokeLL;
            AccessibilityViewCommand.CommandArguments newInstance;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view, bundle)) == null) {
                if (this.mCommand != null) {
                    AccessibilityViewCommand.CommandArguments commandArguments = null;
                    Class<? extends AccessibilityViewCommand.CommandArguments> cls = this.mViewCommandArgumentClass;
                    if (cls != null) {
                        try {
                            newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        } catch (Exception e2) {
                            e = e2;
                        }
                        try {
                            newInstance.setBundle(bundle);
                            commandArguments = newInstance;
                        } catch (Exception e3) {
                            e = e3;
                            commandArguments = newInstance;
                            Class<? extends AccessibilityViewCommand.CommandArguments> cls2 = this.mViewCommandArgumentClass;
                            String name = cls2 == null ? StringUtil.NULL_STRING : cls2.getName();
                            Log.e(TAG, "Failed to execute command with argument class ViewCommandArgument: " + name, e);
                            return this.mCommand.perform(view, commandArguments);
                        }
                    }
                    return this.mCommand.perform(view, commandArguments);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public AccessibilityActionCompat(int i, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            this(null, i, charSequence, accessibilityViewCommand, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), charSequence, accessibilityViewCommand};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(objArr2[0], ((Integer) objArr2[1]).intValue(), (CharSequence) objArr2[2], (AccessibilityViewCommand) objArr2[3], (Class) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public AccessibilityActionCompat(Object obj) {
            this(obj, 0, null, null, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(objArr2[0], ((Integer) objArr2[1]).intValue(), (CharSequence) objArr2[2], (AccessibilityViewCommand) objArr2[3], (Class) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public AccessibilityActionCompat(int i, CharSequence charSequence, Class<? extends AccessibilityViewCommand.CommandArguments> cls) {
            this(null, i, charSequence, null, cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), charSequence, cls};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(objArr2[0], ((Integer) objArr2[1]).intValue(), (CharSequence) objArr2[2], (AccessibilityViewCommand) objArr2[3], (Class) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }

        public AccessibilityActionCompat(Object obj, int i, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand, Class<? extends AccessibilityViewCommand.CommandArguments> cls) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, Integer.valueOf(i), charSequence, accessibilityViewCommand, cls};
                interceptable.invokeUnInit(65541, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65541, newInitContext);
                    return;
                }
            }
            this.mId = i;
            this.mCommand = accessibilityViewCommand;
            if (Build.VERSION.SDK_INT >= 21 && obj == null) {
                this.mAction = new AccessibilityNodeInfo.AccessibilityAction(i, charSequence);
            } else {
                this.mAction = obj;
            }
            this.mViewCommandArgumentClass = cls;
        }
    }

    /* loaded from: classes.dex */
    public static class RangeInfoCompat {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object mInfo;

        public RangeInfoCompat(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mInfo = obj;
        }

        public static RangeInfoCompat obtain(int i, float f2, float f3, float f4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    return new RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain(i, f2, f3, f4));
                }
                return new RangeInfoCompat(null);
            }
            return (RangeInfoCompat) invokeCommon.objValue;
        }

        public float getCurrent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getCurrent();
                }
                return 0.0f;
            }
            return invokeV.floatValue;
        }

        public float getMax() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getMax();
                }
                return 0.0f;
            }
            return invokeV.floatValue;
        }

        public float getMin() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getMin();
                }
                return 0.0f;
            }
            return invokeV.floatValue;
        }

        public int getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getType();
                }
                return 0;
            }
            return invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1171117072, "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1171117072, "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;");
        }
    }

    @Deprecated
    public AccessibilityNodeInfoCompat(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mParentVirtualDescendantId = -1;
        this.mVirtualDescendantId = -1;
        this.mInfo = (AccessibilityNodeInfo) obj;
    }

    private void addSpanLocationToExtras(ClickableSpan clickableSpan, Spanned spanned, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, this, clickableSpan, spanned, i) == null) {
            extrasIntList(SPANS_START_KEY).add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
            extrasIntList(SPANS_END_KEY).add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
            extrasIntList(SPANS_FLAGS_KEY).add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
            extrasIntList(SPANS_ID_KEY).add(Integer.valueOf(i));
        }
    }

    private void clearExtrasSpans() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.mInfo.getExtras().remove(SPANS_START_KEY);
        this.mInfo.getExtras().remove(SPANS_END_KEY);
        this.mInfo.getExtras().remove(SPANS_FLAGS_KEY);
        this.mInfo.getExtras().remove(SPANS_ID_KEY);
    }

    private List<Integer> extrasIntList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            if (Build.VERSION.SDK_INT < 19) {
                return new ArrayList();
            }
            ArrayList<Integer> integerArrayList = this.mInfo.getExtras().getIntegerArrayList(str);
            if (integerArrayList == null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                this.mInfo.getExtras().putIntegerArrayList(str, arrayList);
                return arrayList;
            }
            return integerArrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String getActionSymbolicName(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    switch (i) {
                        case 4:
                            return "ACTION_SELECT";
                        case 8:
                            return "ACTION_CLEAR_SELECTION";
                        case 16:
                            return "ACTION_CLICK";
                        case 32:
                            return "ACTION_LONG_CLICK";
                        case 64:
                            return "ACTION_ACCESSIBILITY_FOCUS";
                        case 128:
                            return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                        case 256:
                            return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                        case 512:
                            return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                        case 1024:
                            return "ACTION_NEXT_HTML_ELEMENT";
                        case 2048:
                            return "ACTION_PREVIOUS_HTML_ELEMENT";
                        case 4096:
                            return "ACTION_SCROLL_FORWARD";
                        case 8192:
                            return "ACTION_SCROLL_BACKWARD";
                        case 16384:
                            return "ACTION_COPY";
                        case 32768:
                            return "ACTION_PASTE";
                        case 65536:
                            return "ACTION_CUT";
                        case 131072:
                            return "ACTION_SET_SELECTION";
                        case 262144:
                            return "ACTION_EXPAND";
                        case 524288:
                            return "ACTION_COLLAPSE";
                        case 2097152:
                            return "ACTION_SET_TEXT";
                        case 16908354:
                            return "ACTION_MOVE_WINDOW";
                        default:
                            switch (i) {
                                case 16908342:
                                    return "ACTION_SHOW_ON_SCREEN";
                                case 16908343:
                                    return "ACTION_SCROLL_TO_POSITION";
                                case 16908344:
                                    return "ACTION_SCROLL_UP";
                                case 16908345:
                                    return "ACTION_SCROLL_LEFT";
                                case 16908346:
                                    return "ACTION_SCROLL_DOWN";
                                case 16908347:
                                    return "ACTION_SCROLL_RIGHT";
                                case 16908348:
                                    return "ACTION_CONTEXT_CLICK";
                                case 16908349:
                                    return "ACTION_SET_PROGRESS";
                                default:
                                    switch (i) {
                                        case 16908356:
                                            return "ACTION_SHOW_TOOLTIP";
                                        case 16908357:
                                            return "ACTION_HIDE_TOOLTIP";
                                        case 16908358:
                                            return "ACTION_PAGE_UP";
                                        case 16908359:
                                            return "ACTION_PAGE_DOWN";
                                        case 16908360:
                                            return "ACTION_PAGE_LEFT";
                                        case 16908361:
                                            return "ACTION_PAGE_RIGHT";
                                        default:
                                            return "ACTION_UNKNOWN";
                                    }
                            }
                    }
                }
                return "ACTION_CLEAR_FOCUS";
            }
            return "ACTION_FOCUS";
        }
        return (String) invokeI.objValue;
    }

    private boolean getBooleanProperty(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i)) == null) {
            Bundle extras = getExtras();
            return extras != null && (extras.getInt(BOOLEAN_PROPERTY_KEY, 0) & i) == i;
        }
        return invokeI.booleanValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ClickableSpan[] getClickableSpans(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, charSequence)) == null) {
            if (charSequence instanceof Spanned) {
                return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
            }
            return null;
        }
        return (ClickableSpan[]) invokeL.objValue;
    }

    private SparseArray<WeakReference<ClickableSpan>> getOrCreateSpansFromViewTags(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, view)) == null) {
            SparseArray<WeakReference<ClickableSpan>> spansFromViewTags = getSpansFromViewTags(view);
            if (spansFromViewTags == null) {
                SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
                view.setTag(R$id.tag_accessibility_clickable_spans, sparseArray);
                return sparseArray;
            }
            return spansFromViewTags;
        }
        return (SparseArray) invokeL.objValue;
    }

    private SparseArray<WeakReference<ClickableSpan>> getSpansFromViewTags(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, this, view)) == null) ? (SparseArray) view.getTag(R$id.tag_accessibility_clickable_spans) : (SparseArray) invokeL.objValue;
    }

    private boolean hasSpans() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? !extrasIntList(SPANS_START_KEY).isEmpty() : invokeV.booleanValue;
    }

    private int idForClickableSpan(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, clickableSpan, sparseArray)) == null) {
            if (sparseArray != null) {
                for (int i = 0; i < sparseArray.size(); i++) {
                    if (clickableSpan.equals(sparseArray.valueAt(i).get())) {
                        return sparseArray.keyAt(i);
                    }
                }
            }
            int i2 = sClickableSpanId;
            sClickableSpanId = i2 + 1;
            return i2;
        }
        return invokeLL.intValue;
    }

    public static AccessibilityNodeInfoCompat obtain(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, view)) == null) ? wrap(AccessibilityNodeInfo.obtain(view)) : (AccessibilityNodeInfoCompat) invokeL.objValue;
    }

    private void removeCollectedSpans(View view) {
        SparseArray<WeakReference<ClickableSpan>> spansFromViewTags;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65553, this, view) == null) || (spansFromViewTags = getSpansFromViewTags(view)) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < spansFromViewTags.size(); i++) {
            if (spansFromViewTags.valueAt(i).get() == null) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            spansFromViewTags.remove(((Integer) arrayList.get(i2)).intValue());
        }
    }

    private void setBooleanProperty(int i, boolean z) {
        Bundle extras;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65554, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) || (extras = getExtras()) == null) {
            return;
        }
        int i2 = extras.getInt(BOOLEAN_PROPERTY_KEY, 0) & (~i);
        if (!z) {
            i = 0;
        }
        extras.putInt(BOOLEAN_PROPERTY_KEY, i | i2);
    }

    public static AccessibilityNodeInfoCompat wrap(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, accessibilityNodeInfo)) == null) ? new AccessibilityNodeInfoCompat(accessibilityNodeInfo) : (AccessibilityNodeInfoCompat) invokeL.objValue;
    }

    public static AccessibilityNodeInfoCompat wrapNonNullInstance(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, obj)) == null) {
            if (obj != null) {
                return new AccessibilityNodeInfoCompat(obj);
            }
            return null;
        }
        return (AccessibilityNodeInfoCompat) invokeL.objValue;
    }

    public void addAction(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.mInfo.addAction(i);
        }
    }

    public void addChild(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            this.mInfo.addChild(view);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addSpansToExtras(CharSequence charSequence, View view) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, charSequence, view) == null) || (i = Build.VERSION.SDK_INT) < 19 || i >= 26) {
            return;
        }
        clearExtrasSpans();
        removeCollectedSpans(view);
        ClickableSpan[] clickableSpans = getClickableSpans(charSequence);
        if (clickableSpans == null || clickableSpans.length <= 0) {
            return;
        }
        getExtras().putInt(SPANS_ACTION_ID_KEY, R$id.accessibility_action_clickable_span);
        SparseArray<WeakReference<ClickableSpan>> orCreateSpansFromViewTags = getOrCreateSpansFromViewTags(view);
        for (int i2 = 0; clickableSpans != null && i2 < clickableSpans.length; i2++) {
            int idForClickableSpan = idForClickableSpan(clickableSpans[i2], orCreateSpansFromViewTags);
            orCreateSpansFromViewTags.put(idForClickableSpan, new WeakReference<>(clickableSpans[i2]));
            addSpanLocationToExtras(clickableSpans[i2], (Spanned) charSequence, idForClickableSpan);
        }
    }

    public boolean canOpenPopup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return this.mInfo.canOpenPopup();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof AccessibilityNodeInfoCompat)) {
                AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
                AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
                if (accessibilityNodeInfo == null) {
                    if (accessibilityNodeInfoCompat.mInfo != null) {
                        return false;
                    }
                } else if (!accessibilityNodeInfo.equals(accessibilityNodeInfoCompat.mInfo)) {
                    return false;
                }
                return this.mVirtualDescendantId == accessibilityNodeInfoCompat.mVirtualDescendantId && this.mParentVirtualDescendantId == accessibilityNodeInfoCompat.mParentVirtualDescendantId;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = this.mInfo.findAccessibilityNodeInfosByText(str);
            int size = findAccessibilityNodeInfosByText.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(wrap(findAccessibilityNodeInfosByText.get(i)));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId = this.mInfo.findAccessibilityNodeInfosByViewId(str);
                ArrayList arrayList = new ArrayList();
                for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByViewId) {
                    arrayList.add(wrap(accessibilityNodeInfo));
                }
                return arrayList;
            }
            return Collections.emptyList();
        }
        return (List) invokeL.objValue;
    }

    public AccessibilityNodeInfoCompat findFocus(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return wrapNonNullInstance(this.mInfo.findFocus(i));
            }
            return null;
        }
        return (AccessibilityNodeInfoCompat) invokeI.objValue;
    }

    public AccessibilityNodeInfoCompat focusSearch(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return wrapNonNullInstance(this.mInfo.focusSearch(i));
            }
            return null;
        }
        return (AccessibilityNodeInfoCompat) invokeI.objValue;
    }

    public List<AccessibilityActionCompat> getActionList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.mInfo.getActionList() : null;
            if (actionList != null) {
                ArrayList arrayList = new ArrayList();
                int size = actionList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.add(new AccessibilityActionCompat(actionList.get(i)));
                }
                return arrayList;
            }
            return Collections.emptyList();
        }
        return (List) invokeV.objValue;
    }

    public int getActions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mInfo.getActions() : invokeV.intValue;
    }

    @Deprecated
    public void getBoundsInParent(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, rect) == null) {
            this.mInfo.getBoundsInParent(rect);
        }
    }

    public void getBoundsInScreen(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, rect) == null) {
            this.mInfo.getBoundsInScreen(rect);
        }
    }

    public AccessibilityNodeInfoCompat getChild(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) ? wrapNonNullInstance(this.mInfo.getChild(i)) : (AccessibilityNodeInfoCompat) invokeI.objValue;
    }

    public int getChildCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mInfo.getChildCount() : invokeV.intValue;
    }

    public CharSequence getClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mInfo.getClassName() : (CharSequence) invokeV.objValue;
    }

    public CollectionInfoCompat getCollectionInfo() {
        InterceptResult invokeV;
        AccessibilityNodeInfo.CollectionInfo collectionInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (Build.VERSION.SDK_INT < 19 || (collectionInfo = this.mInfo.getCollectionInfo()) == null) {
                return null;
            }
            return new CollectionInfoCompat(collectionInfo);
        }
        return (CollectionInfoCompat) invokeV.objValue;
    }

    public CollectionItemInfoCompat getCollectionItemInfo() {
        InterceptResult invokeV;
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (Build.VERSION.SDK_INT < 19 || (collectionItemInfo = this.mInfo.getCollectionItemInfo()) == null) {
                return null;
            }
            return new CollectionItemInfoCompat(collectionItemInfo);
        }
        return (CollectionItemInfoCompat) invokeV.objValue;
    }

    public CharSequence getContentDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mInfo.getContentDescription() : (CharSequence) invokeV.objValue;
    }

    public int getDrawingOrder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return this.mInfo.getDrawingOrder();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public CharSequence getError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return this.mInfo.getError();
            }
            return null;
        }
        return (CharSequence) invokeV.objValue;
    }

    public Bundle getExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return this.mInfo.getExtras();
            }
            return new Bundle();
        }
        return (Bundle) invokeV.objValue;
    }

    @Nullable
    public CharSequence getHintText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                return this.mInfo.getHintText();
            }
            if (i >= 19) {
                return this.mInfo.getExtras().getCharSequence(HINT_TEXT_KEY);
            }
            return null;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Deprecated
    public Object getInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mInfo : invokeV.objValue;
    }

    public int getInputType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return this.mInfo.getInputType();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public AccessibilityNodeInfoCompat getLabelFor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return wrapNonNullInstance(this.mInfo.getLabelFor());
            }
            return null;
        }
        return (AccessibilityNodeInfoCompat) invokeV.objValue;
    }

    public AccessibilityNodeInfoCompat getLabeledBy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return wrapNonNullInstance(this.mInfo.getLabeledBy());
            }
            return null;
        }
        return (AccessibilityNodeInfoCompat) invokeV.objValue;
    }

    public int getLiveRegion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return this.mInfo.getLiveRegion();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getMaxTextLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return this.mInfo.getMaxTextLength();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public int getMovementGranularities() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return this.mInfo.getMovementGranularities();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public CharSequence getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mInfo.getPackageName() : (CharSequence) invokeV.objValue;
    }

    @Nullable
    public CharSequence getPaneTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                return this.mInfo.getPaneTitle();
            }
            if (i >= 19) {
                return this.mInfo.getExtras().getCharSequence(PANE_TITLE_KEY);
            }
            return null;
        }
        return (CharSequence) invokeV.objValue;
    }

    public AccessibilityNodeInfoCompat getParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? wrapNonNullInstance(this.mInfo.getParent()) : (AccessibilityNodeInfoCompat) invokeV.objValue;
    }

    public RangeInfoCompat getRangeInfo() {
        InterceptResult invokeV;
        AccessibilityNodeInfo.RangeInfo rangeInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (Build.VERSION.SDK_INT < 19 || (rangeInfo = this.mInfo.getRangeInfo()) == null) {
                return null;
            }
            return new RangeInfoCompat(rangeInfo);
        }
        return (RangeInfoCompat) invokeV.objValue;
    }

    @Nullable
    public CharSequence getRoleDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return this.mInfo.getExtras().getCharSequence(ROLE_DESCRIPTION_KEY);
            }
            return null;
        }
        return (CharSequence) invokeV.objValue;
    }

    public CharSequence getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (hasSpans()) {
                List<Integer> extrasIntList = extrasIntList(SPANS_START_KEY);
                List<Integer> extrasIntList2 = extrasIntList(SPANS_END_KEY);
                List<Integer> extrasIntList3 = extrasIntList(SPANS_FLAGS_KEY);
                List<Integer> extrasIntList4 = extrasIntList(SPANS_ID_KEY);
                SpannableString spannableString = new SpannableString(TextUtils.substring(this.mInfo.getText(), 0, this.mInfo.getText().length()));
                for (int i = 0; i < extrasIntList.size(); i++) {
                    spannableString.setSpan(new AccessibilityClickableSpanCompat(extrasIntList4.get(i).intValue(), this, getExtras().getInt(SPANS_ACTION_ID_KEY)), extrasIntList.get(i).intValue(), extrasIntList2.get(i).intValue(), extrasIntList3.get(i).intValue());
                }
                return spannableString;
            }
            return this.mInfo.getText();
        }
        return (CharSequence) invokeV.objValue;
    }

    public int getTextSelectionEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                return this.mInfo.getTextSelectionEnd();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public int getTextSelectionStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                return this.mInfo.getTextSelectionStart();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Nullable
    public CharSequence getTooltipText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                return this.mInfo.getTooltipText();
            }
            if (i >= 19) {
                return this.mInfo.getExtras().getCharSequence(TOOLTIP_TEXT_KEY);
            }
            return null;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Nullable
    public TouchDelegateInfoCompat getTouchDelegateInfo() {
        InterceptResult invokeV;
        AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (Build.VERSION.SDK_INT < 29 || (touchDelegateInfo = this.mInfo.getTouchDelegateInfo()) == null) {
                return null;
            }
            return new TouchDelegateInfoCompat(touchDelegateInfo);
        }
        return (TouchDelegateInfoCompat) invokeV.objValue;
    }

    public AccessibilityNodeInfoCompat getTraversalAfter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (Build.VERSION.SDK_INT >= 22) {
                return wrapNonNullInstance(this.mInfo.getTraversalAfter());
            }
            return null;
        }
        return (AccessibilityNodeInfoCompat) invokeV.objValue;
    }

    public AccessibilityNodeInfoCompat getTraversalBefore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (Build.VERSION.SDK_INT >= 22) {
                return wrapNonNullInstance(this.mInfo.getTraversalBefore());
            }
            return null;
        }
        return (AccessibilityNodeInfoCompat) invokeV.objValue;
    }

    public String getViewIdResourceName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                return this.mInfo.getViewIdResourceName();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public AccessibilityWindowInfoCompat getWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return AccessibilityWindowInfoCompat.wrapNonNullInstance(this.mInfo.getWindow());
            }
            return null;
        }
        return (AccessibilityWindowInfoCompat) invokeV.objValue;
    }

    public int getWindowId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.mInfo.getWindowId() : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            if (accessibilityNodeInfo == null) {
                return 0;
            }
            return accessibilityNodeInfo.hashCode();
        }
        return invokeV.intValue;
    }

    public boolean isAccessibilityFocused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return this.mInfo.isAccessibilityFocused();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isCheckable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.mInfo.isCheckable() : invokeV.booleanValue;
    }

    public boolean isChecked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.mInfo.isChecked() : invokeV.booleanValue;
    }

    public boolean isClickable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.mInfo.isClickable() : invokeV.booleanValue;
    }

    public boolean isContentInvalid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return this.mInfo.isContentInvalid();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isContextClickable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return this.mInfo.isContextClickable();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isDismissable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return this.mInfo.isDismissable();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isEditable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                return this.mInfo.isEditable();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.mInfo.isEnabled() : invokeV.booleanValue;
    }

    public boolean isFocusable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.mInfo.isFocusable() : invokeV.booleanValue;
    }

    public boolean isFocused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.mInfo.isFocused() : invokeV.booleanValue;
    }

    public boolean isHeading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return this.mInfo.isHeading();
            }
            if (getBooleanProperty(2)) {
                return true;
            }
            CollectionItemInfoCompat collectionItemInfo = getCollectionItemInfo();
            return collectionItemInfo != null && collectionItemInfo.isHeading();
        }
        return invokeV.booleanValue;
    }

    public boolean isImportantForAccessibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return this.mInfo.isImportantForAccessibility();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isLongClickable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.mInfo.isLongClickable() : invokeV.booleanValue;
    }

    public boolean isMultiLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return this.mInfo.isMultiLine();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isPassword() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.mInfo.isPassword() : invokeV.booleanValue;
    }

    public boolean isScreenReaderFocusable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return this.mInfo.isScreenReaderFocusable();
            }
            return getBooleanProperty(1);
        }
        return invokeV.booleanValue;
    }

    public boolean isScrollable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.mInfo.isScrollable() : invokeV.booleanValue;
    }

    public boolean isSelected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.mInfo.isSelected() : invokeV.booleanValue;
    }

    public boolean isShowingHintText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return this.mInfo.isShowingHintText();
            }
            return getBooleanProperty(4);
        }
        return invokeV.booleanValue;
    }

    public boolean isTextEntryKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                return this.mInfo.isTextEntryKey();
            }
            return getBooleanProperty(8);
        }
        return invokeV.booleanValue;
    }

    public boolean isVisibleToUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return this.mInfo.isVisibleToUser();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean performAction(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048646, this, i)) == null) ? this.mInfo.performAction(i) : invokeI.booleanValue;
    }

    public void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            this.mInfo.recycle();
        }
    }

    public boolean refresh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                return this.mInfo.refresh();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean removeAction(AccessibilityActionCompat accessibilityActionCompat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, accessibilityActionCompat)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return this.mInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.mAction);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean removeChild(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048651, this, view)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return this.mInfo.removeChild(view);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setAccessibilityFocused(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048653, this, z) == null) || Build.VERSION.SDK_INT < 16) {
            return;
        }
        this.mInfo.setAccessibilityFocused(z);
    }

    @Deprecated
    public void setBoundsInParent(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, rect) == null) {
            this.mInfo.setBoundsInParent(rect);
        }
    }

    public void setBoundsInScreen(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, rect) == null) {
            this.mInfo.setBoundsInScreen(rect);
        }
    }

    public void setCanOpenPopup(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048656, this, z) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.mInfo.setCanOpenPopup(z);
    }

    public void setCheckable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048657, this, z) == null) {
            this.mInfo.setCheckable(z);
        }
    }

    public void setChecked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048658, this, z) == null) {
            this.mInfo.setChecked(z);
        }
    }

    public void setClassName(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, charSequence) == null) {
            this.mInfo.setClassName(charSequence);
        }
    }

    public void setClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048660, this, z) == null) {
            this.mInfo.setClickable(z);
        }
    }

    public void setCollectionInfo(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048661, this, obj) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.mInfo.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((CollectionInfoCompat) obj).mInfo);
    }

    public void setCollectionItemInfo(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048662, this, obj) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.mInfo.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((CollectionItemInfoCompat) obj).mInfo);
    }

    public void setContentDescription(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, charSequence) == null) {
            this.mInfo.setContentDescription(charSequence);
        }
    }

    public void setContentInvalid(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048664, this, z) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.mInfo.setContentInvalid(z);
    }

    public void setContextClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048665, this, z) == null) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        this.mInfo.setContextClickable(z);
    }

    public void setDismissable(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048666, this, z) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.mInfo.setDismissable(z);
    }

    public void setDrawingOrder(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048667, this, i) == null) || Build.VERSION.SDK_INT < 24) {
            return;
        }
        this.mInfo.setDrawingOrder(i);
    }

    public void setEditable(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048668, this, z) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.mInfo.setEditable(z);
    }

    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048669, this, z) == null) {
            this.mInfo.setEnabled(z);
        }
    }

    public void setError(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048670, this, charSequence) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        this.mInfo.setError(charSequence);
    }

    public void setFocusable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048671, this, z) == null) {
            this.mInfo.setFocusable(z);
        }
    }

    public void setFocused(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048672, this, z) == null) {
            this.mInfo.setFocused(z);
        }
    }

    public void setHeading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048673, this, z) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.mInfo.setHeading(z);
            } else {
                setBooleanProperty(2, z);
            }
        }
    }

    public void setHintText(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, charSequence) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                this.mInfo.setHintText(charSequence);
            } else if (i >= 19) {
                this.mInfo.getExtras().putCharSequence(HINT_TEXT_KEY, charSequence);
            }
        }
    }

    public void setImportantForAccessibility(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048675, this, z) == null) || Build.VERSION.SDK_INT < 24) {
            return;
        }
        this.mInfo.setImportantForAccessibility(z);
    }

    public void setInputType(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048676, this, i) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.mInfo.setInputType(i);
    }

    public void setLabelFor(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048677, this, view) == null) || Build.VERSION.SDK_INT < 17) {
            return;
        }
        this.mInfo.setLabelFor(view);
    }

    public void setLabeledBy(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048679, this, view) == null) || Build.VERSION.SDK_INT < 17) {
            return;
        }
        this.mInfo.setLabeledBy(view);
    }

    public void setLiveRegion(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048681, this, i) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.mInfo.setLiveRegion(i);
    }

    public void setLongClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048682, this, z) == null) {
            this.mInfo.setLongClickable(z);
        }
    }

    public void setMaxTextLength(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048683, this, i) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        this.mInfo.setMaxTextLength(i);
    }

    public void setMovementGranularities(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048684, this, i) == null) || Build.VERSION.SDK_INT < 16) {
            return;
        }
        this.mInfo.setMovementGranularities(i);
    }

    public void setMultiLine(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048685, this, z) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.mInfo.setMultiLine(z);
    }

    public void setPackageName(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048686, this, charSequence) == null) {
            this.mInfo.setPackageName(charSequence);
        }
    }

    public void setPaneTitle(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, charSequence) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                this.mInfo.setPaneTitle(charSequence);
            } else if (i >= 19) {
                this.mInfo.getExtras().putCharSequence(PANE_TITLE_KEY, charSequence);
            }
        }
    }

    public void setParent(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, view) == null) {
            this.mParentVirtualDescendantId = -1;
            this.mInfo.setParent(view);
        }
    }

    public void setPassword(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048690, this, z) == null) {
            this.mInfo.setPassword(z);
        }
    }

    public void setRangeInfo(RangeInfoCompat rangeInfoCompat) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048691, this, rangeInfoCompat) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.mInfo.setRangeInfo((AccessibilityNodeInfo.RangeInfo) rangeInfoCompat.mInfo);
    }

    public void setRoleDescription(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048692, this, charSequence) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.mInfo.getExtras().putCharSequence(ROLE_DESCRIPTION_KEY, charSequence);
    }

    public void setScreenReaderFocusable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048693, this, z) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.mInfo.setScreenReaderFocusable(z);
            } else {
                setBooleanProperty(1, z);
            }
        }
    }

    public void setScrollable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048694, this, z) == null) {
            this.mInfo.setScrollable(z);
        }
    }

    public void setSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048695, this, z) == null) {
            this.mInfo.setSelected(z);
        }
    }

    public void setShowingHintText(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048696, this, z) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mInfo.setShowingHintText(z);
            } else {
                setBooleanProperty(4, z);
            }
        }
    }

    public void setSource(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, view) == null) {
            this.mVirtualDescendantId = -1;
            this.mInfo.setSource(view);
        }
    }

    public void setText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, charSequence) == null) {
            this.mInfo.setText(charSequence);
        }
    }

    public void setTextEntryKey(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048700, this, z) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.mInfo.setTextEntryKey(z);
            } else {
                setBooleanProperty(8, z);
            }
        }
    }

    public void setTextSelection(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048701, this, i, i2) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.mInfo.setTextSelection(i, i2);
    }

    public void setTooltipText(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048702, this, charSequence) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                this.mInfo.setTooltipText(charSequence);
            } else if (i >= 19) {
                this.mInfo.getExtras().putCharSequence(TOOLTIP_TEXT_KEY, charSequence);
            }
        }
    }

    public void setTouchDelegateInfo(@NonNull TouchDelegateInfoCompat touchDelegateInfoCompat) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048703, this, touchDelegateInfoCompat) == null) || Build.VERSION.SDK_INT < 29) {
            return;
        }
        this.mInfo.setTouchDelegateInfo(touchDelegateInfoCompat.mInfo);
    }

    public void setTraversalAfter(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048704, this, view) == null) || Build.VERSION.SDK_INT < 22) {
            return;
        }
        this.mInfo.setTraversalAfter(view);
    }

    public void setTraversalBefore(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048706, this, view) == null) || Build.VERSION.SDK_INT < 22) {
            return;
        }
        this.mInfo.setTraversalBefore(view);
    }

    public void setViewIdResourceName(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048708, this, str) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.mInfo.setViewIdResourceName(str);
    }

    public void setVisibleToUser(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048709, this, z) == null) || Build.VERSION.SDK_INT < 16) {
            return;
        }
        this.mInfo.setVisibleToUser(z);
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            Rect rect = new Rect();
            getBoundsInParent(rect);
            sb.append("; boundsInParent: " + rect);
            getBoundsInScreen(rect);
            sb.append("; boundsInScreen: " + rect);
            sb.append("; packageName: ");
            sb.append(getPackageName());
            sb.append("; className: ");
            sb.append(getClassName());
            sb.append("; text: ");
            sb.append(getText());
            sb.append("; contentDescription: ");
            sb.append(getContentDescription());
            sb.append("; viewId: ");
            sb.append(getViewIdResourceName());
            sb.append("; checkable: ");
            sb.append(isCheckable());
            sb.append("; checked: ");
            sb.append(isChecked());
            sb.append("; focusable: ");
            sb.append(isFocusable());
            sb.append("; focused: ");
            sb.append(isFocused());
            sb.append("; selected: ");
            sb.append(isSelected());
            sb.append("; clickable: ");
            sb.append(isClickable());
            sb.append("; longClickable: ");
            sb.append(isLongClickable());
            sb.append("; enabled: ");
            sb.append(isEnabled());
            sb.append("; password: ");
            sb.append(isPassword());
            sb.append("; scrollable: " + isScrollable());
            sb.append("; [");
            if (Build.VERSION.SDK_INT >= 21) {
                List<AccessibilityActionCompat> actionList = getActionList();
                for (int i = 0; i < actionList.size(); i++) {
                    AccessibilityActionCompat accessibilityActionCompat = actionList.get(i);
                    String actionSymbolicName = getActionSymbolicName(accessibilityActionCompat.getId());
                    if (actionSymbolicName.equals("ACTION_UNKNOWN") && accessibilityActionCompat.getLabel() != null) {
                        actionSymbolicName = accessibilityActionCompat.getLabel().toString();
                    }
                    sb.append(actionSymbolicName);
                    if (i != actionList.size() - 1) {
                        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    }
                }
            } else {
                int actions = getActions();
                while (actions != 0) {
                    int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(actions);
                    actions &= ~numberOfTrailingZeros;
                    sb.append(getActionSymbolicName(numberOfTrailingZeros));
                    if (actions != 0) {
                        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    }
                }
            }
            sb.append(PreferencesUtil.RIGHT_MOUNT);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public AccessibilityNodeInfo unwrap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) ? this.mInfo : (AccessibilityNodeInfo) invokeV.objValue;
    }

    public static AccessibilityNodeInfoCompat obtain(View view, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, view, i)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return wrapNonNullInstance(AccessibilityNodeInfo.obtain(view, i));
            }
            return null;
        }
        return (AccessibilityNodeInfoCompat) invokeLI.objValue;
    }

    public void addAction(AccessibilityActionCompat accessibilityActionCompat) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, accessibilityActionCompat) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        this.mInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.mAction);
    }

    public void addChild(View view, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, view, i) == null) || Build.VERSION.SDK_INT < 16) {
            return;
        }
        this.mInfo.addChild(view, i);
    }

    public boolean performAction(int i, Bundle bundle) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048647, this, i, bundle)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return this.mInfo.performAction(i, bundle);
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public boolean removeChild(View view, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048652, this, view, i)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return this.mInfo.removeChild(view, i);
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public void setLabelFor(View view, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048678, this, view, i) == null) || Build.VERSION.SDK_INT < 17) {
            return;
        }
        this.mInfo.setLabelFor(view, i);
    }

    public void setLabeledBy(View view, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048680, this, view, i) == null) || Build.VERSION.SDK_INT < 17) {
            return;
        }
        this.mInfo.setLabeledBy(view, i);
    }

    public void setParent(View view, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048689, this, view, i) == null) {
            this.mParentVirtualDescendantId = i;
            if (Build.VERSION.SDK_INT >= 16) {
                this.mInfo.setParent(view, i);
            }
        }
    }

    public void setSource(View view, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048698, this, view, i) == null) {
            this.mVirtualDescendantId = i;
            if (Build.VERSION.SDK_INT >= 16) {
                this.mInfo.setSource(view, i);
            }
        }
    }

    public void setTraversalAfter(View view, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048705, this, view, i) == null) || Build.VERSION.SDK_INT < 22) {
            return;
        }
        this.mInfo.setTraversalAfter(view, i);
    }

    public void setTraversalBefore(View view, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048707, this, view, i) == null) || Build.VERSION.SDK_INT < 22) {
            return;
        }
        this.mInfo.setTraversalBefore(view, i);
    }

    /* loaded from: classes.dex */
    public static class CollectionInfoCompat {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object mInfo;

        public CollectionInfoCompat(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mInfo = obj;
        }

        public static CollectionInfoCompat obtain(int i, int i2, boolean z, int i3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)})) == null) {
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= 21) {
                    return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
                }
                if (i4 >= 19) {
                    return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
                }
                return new CollectionInfoCompat(null);
            }
            return (CollectionInfoCompat) invokeCommon.objValue;
        }

        public int getColumnCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getColumnCount();
                }
                return -1;
            }
            return invokeV.intValue;
        }

        public int getRowCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getRowCount();
                }
                return -1;
            }
            return invokeV.intValue;
        }

        public int getSelectionMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getSelectionMode();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        public boolean isHierarchical() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).isHierarchical();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static CollectionInfoCompat obtain(int i, int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
                }
                return new CollectionInfoCompat(null);
            }
            return (CollectionInfoCompat) invokeCommon.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class CollectionItemInfoCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object mInfo;

        public CollectionItemInfoCompat(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mInfo = obj;
        }

        public static CollectionItemInfoCompat obtain(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                int i5 = Build.VERSION.SDK_INT;
                if (i5 >= 21) {
                    return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
                }
                if (i5 >= 19) {
                    return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z));
                }
                return new CollectionItemInfoCompat(null);
            }
            return (CollectionItemInfoCompat) invokeCommon.objValue;
        }

        public int getColumnIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getColumnIndex();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        public int getColumnSpan() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getColumnSpan();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        public int getRowIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getRowIndex();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        public int getRowSpan() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getRowSpan();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Deprecated
        public boolean isHeading() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).isHeading();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean isSelected() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).isSelected();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static CollectionItemInfoCompat obtain(int i, int i2, int i3, int i4, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)})) == null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z));
                }
                return new CollectionItemInfoCompat(null);
            }
            return (CollectionItemInfoCompat) invokeCommon.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class TouchDelegateInfoCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AccessibilityNodeInfo.TouchDelegateInfo mInfo;

        public TouchDelegateInfoCompat(@NonNull Map<Region, View> map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                this.mInfo = new AccessibilityNodeInfo.TouchDelegateInfo(map);
            } else {
                this.mInfo = null;
            }
        }

        @Nullable
        public Region getRegionAt(@IntRange(from = 0) int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    return this.mInfo.getRegionAt(i);
                }
                return null;
            }
            return (Region) invokeI.objValue;
        }

        @IntRange(from = 0)
        public int getRegionCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    return this.mInfo.getRegionCount();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Nullable
        public AccessibilityNodeInfoCompat getTargetForRegion(@NonNull Region region) {
            InterceptResult invokeL;
            AccessibilityNodeInfo targetForRegion;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, region)) == null) {
                if (Build.VERSION.SDK_INT < 29 || (targetForRegion = this.mInfo.getTargetForRegion(region)) == null) {
                    return null;
                }
                return AccessibilityNodeInfoCompat.wrap(targetForRegion);
            }
            return (AccessibilityNodeInfoCompat) invokeL.objValue;
        }

        public TouchDelegateInfoCompat(@NonNull AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {touchDelegateInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mInfo = touchDelegateInfo;
        }
    }

    public AccessibilityNodeInfoCompat(AccessibilityNodeInfo accessibilityNodeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {accessibilityNodeInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mParentVirtualDescendantId = -1;
        this.mVirtualDescendantId = -1;
        this.mInfo = accessibilityNodeInfo;
    }

    public static AccessibilityNodeInfoCompat obtain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? wrap(AccessibilityNodeInfo.obtain()) : (AccessibilityNodeInfoCompat) invokeV.objValue;
    }

    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, accessibilityNodeInfoCompat)) == null) ? wrap(AccessibilityNodeInfo.obtain(accessibilityNodeInfoCompat.mInfo)) : (AccessibilityNodeInfoCompat) invokeL.objValue;
    }
}
