package androidx.core.view;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.view.accessibility.AccessibilityClickableSpanCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class AccessibilityDelegateCompat {
    public static /* synthetic */ Interceptable $ic;
    public static final View.AccessibilityDelegate DEFAULT_DELEGATE;
    public transient /* synthetic */ FieldHolder $fh;
    public final View.AccessibilityDelegate mBridge;
    public final View.AccessibilityDelegate mOriginalDelegate;

    /* loaded from: classes.dex */
    public static final class AccessibilityDelegateAdapter extends View.AccessibilityDelegate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AccessibilityDelegateCompat mCompat;

        public AccessibilityDelegateAdapter(AccessibilityDelegateCompat accessibilityDelegateCompat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accessibilityDelegateCompat};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCompat = accessibilityDelegateCompat;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, accessibilityEvent)) == null) ? this.mCompat.dispatchPopulateAccessibilityEvent(view, accessibilityEvent) : invokeLL.booleanValue;
        }

        @Override // android.view.View.AccessibilityDelegate
        @RequiresApi(16)
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
                AccessibilityNodeProviderCompat accessibilityNodeProvider = this.mCompat.getAccessibilityNodeProvider(view);
                if (accessibilityNodeProvider != null) {
                    return (AccessibilityNodeProvider) accessibilityNodeProvider.getProvider();
                }
                return null;
            }
            return (AccessibilityNodeProvider) invokeL.objValue;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, accessibilityEvent) == null) {
                this.mCompat.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, view, accessibilityNodeInfo) == null) {
                AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
                wrap.setScreenReaderFocusable(ViewCompat.isScreenReaderFocusable(view));
                wrap.setHeading(ViewCompat.isAccessibilityHeading(view));
                wrap.setPaneTitle(ViewCompat.getAccessibilityPaneTitle(view));
                this.mCompat.onInitializeAccessibilityNodeInfo(view, wrap);
                wrap.addSpansToExtras(accessibilityNodeInfo.getText(), view);
                List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = AccessibilityDelegateCompat.getActionList(view);
                for (int i2 = 0; i2 < actionList.size(); i2++) {
                    wrap.addAction(actionList.get(i2));
                }
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, view, accessibilityEvent) == null) {
                this.mCompat.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, viewGroup, view, accessibilityEvent)) == null) ? this.mCompat.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent) : invokeLLL.booleanValue;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048582, this, view, i2, bundle)) == null) ? this.mCompat.performAccessibilityAction(view, i2, bundle) : invokeLIL.booleanValue;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, view, i2) == null) {
                this.mCompat.sendAccessibilityEvent(view, i2);
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, accessibilityEvent) == null) {
                this.mCompat.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1872493446, "Landroidx/core/view/AccessibilityDelegateCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1872493446, "Landroidx/core/view/AccessibilityDelegateCompat;");
                return;
            }
        }
        DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AccessibilityDelegateCompat() {
        this(DEFAULT_DELEGATE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((View.AccessibilityDelegate) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view)) == null) {
            List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> list = (List) view.getTag(R.id.tag_accessibility_actions);
            return list == null ? Collections.emptyList() : list;
        }
        return (List) invokeL.objValue;
    }

    private boolean isSpanStillValid(ClickableSpan clickableSpan, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, this, clickableSpan, view)) == null) {
            if (clickableSpan != null) {
                ClickableSpan[] clickableSpans = AccessibilityNodeInfoCompat.getClickableSpans(view.createAccessibilityNodeInfo().getText());
                for (int i2 = 0; clickableSpans != null && i2 < clickableSpans.length; i2++) {
                    if (clickableSpan.equals(clickableSpans[i2])) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private boolean performClickableSpanAction(int i2, View view) {
        InterceptResult invokeIL;
        WeakReference weakReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, this, i2, view)) == null) {
            SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
            if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i2)) == null) {
                return false;
            }
            ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
            if (isSpanStillValid(clickableSpan, view)) {
                clickableSpan.onClick(view);
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, accessibilityEvent)) == null) ? this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent) : invokeLL.booleanValue;
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        InterceptResult invokeL;
        AccessibilityNodeProvider accessibilityNodeProvider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
            if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = this.mOriginalDelegate.getAccessibilityNodeProvider(view)) == null) {
                return null;
            }
            return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
        }
        return (AccessibilityNodeProviderCompat) invokeL.objValue;
    }

    public View.AccessibilityDelegate getBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBridge : (View.AccessibilityDelegate) invokeV.objValue;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view, accessibilityEvent) == null) {
            this.mOriginalDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view, accessibilityNodeInfoCompat) == null) {
            this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.unwrap());
        }
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view, accessibilityEvent) == null) {
            this.mOriginalDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, viewGroup, view, accessibilityEvent)) == null) ? this.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent) : invokeLLL.booleanValue;
    }

    public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048583, this, view, i2, bundle)) == null) {
            List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = getActionList(view);
            boolean z = false;
            int i3 = 0;
            while (true) {
                if (i3 >= actionList.size()) {
                    break;
                }
                AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = actionList.get(i3);
                if (accessibilityActionCompat.getId() == i2) {
                    z = accessibilityActionCompat.perform(view, bundle);
                    break;
                }
                i3++;
            }
            if (!z && Build.VERSION.SDK_INT >= 16) {
                z = this.mOriginalDelegate.performAccessibilityAction(view, i2, bundle);
            }
            return (z || i2 != R.id.accessibility_action_clickable_span) ? z : performClickableSpanAction(bundle.getInt(AccessibilityClickableSpanCompat.SPAN_ID, -1), view);
        }
        return invokeLIL.booleanValue;
    }

    public void sendAccessibilityEvent(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, i2) == null) {
            this.mOriginalDelegate.sendAccessibilityEvent(view, i2);
        }
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, view, accessibilityEvent) == null) {
            this.mOriginalDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public AccessibilityDelegateCompat(View.AccessibilityDelegate accessibilityDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {accessibilityDelegate};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mOriginalDelegate = accessibilityDelegate;
        this.mBridge = new AccessibilityDelegateAdapter(this);
    }
}
