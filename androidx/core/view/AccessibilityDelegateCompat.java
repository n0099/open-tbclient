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
import androidx.core.view.accessibility.AccessibilityClickableSpanCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCompat = accessibilityDelegateCompat;
        }

        @Override // android.view.View.AccessibilityDelegate
        @RequiresApi(16)
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
                AccessibilityNodeProviderCompat accessibilityNodeProvider = this.mCompat.getAccessibilityNodeProvider(view2);
                if (accessibilityNodeProvider != null) {
                    return (AccessibilityNodeProvider) accessibilityNodeProvider.getProvider();
                }
                return null;
            }
            return (AccessibilityNodeProvider) invokeL.objValue;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, accessibilityEvent)) == null) {
                return this.mCompat.dispatchPopulateAccessibilityEvent(view2, accessibilityEvent);
            }
            return invokeLL.booleanValue;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, accessibilityEvent) == null) {
                this.mCompat.onInitializeAccessibilityEvent(view2, accessibilityEvent);
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, view2, accessibilityEvent) == null) {
                this.mCompat.onPopulateAccessibilityEvent(view2, accessibilityEvent);
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, view2, i) == null) {
                this.mCompat.sendAccessibilityEvent(view2, i);
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view2, AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, accessibilityEvent) == null) {
                this.mCompat.sendAccessibilityEventUnchecked(view2, accessibilityEvent);
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfo accessibilityNodeInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, view2, accessibilityNodeInfo) == null) {
                AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
                wrap.setScreenReaderFocusable(ViewCompat.isScreenReaderFocusable(view2));
                wrap.setHeading(ViewCompat.isAccessibilityHeading(view2));
                wrap.setPaneTitle(ViewCompat.getAccessibilityPaneTitle(view2));
                wrap.setStateDescription(ViewCompat.getStateDescription(view2));
                this.mCompat.onInitializeAccessibilityNodeInfo(view2, wrap);
                wrap.addSpansToExtras(accessibilityNodeInfo.getText(), view2);
                List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = AccessibilityDelegateCompat.getActionList(view2);
                for (int i = 0; i < actionList.size(); i++) {
                    wrap.addAction(actionList.get(i));
                }
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view2, AccessibilityEvent accessibilityEvent) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, viewGroup, view2, accessibilityEvent)) == null) {
                return this.mCompat.onRequestSendAccessibilityEvent(viewGroup, view2, accessibilityEvent);
            }
            return invokeLLL.booleanValue;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view2, int i, Bundle bundle) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048582, this, view2, i, bundle)) == null) {
                return this.mCompat.performAccessibilityAction(view2, i, bundle);
            }
            return invokeLIL.booleanValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((View.AccessibilityDelegate) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public View.AccessibilityDelegate getBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mBridge;
        }
        return (View.AccessibilityDelegate) invokeV.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public AccessibilityDelegateCompat(View.AccessibilityDelegate accessibilityDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {accessibilityDelegate};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mOriginalDelegate = accessibilityDelegate;
        this.mBridge = new AccessibilityDelegateAdapter(this);
    }

    public static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view2)) == null) {
            List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> list = (List) view2.getTag(R.id.obfuscated_res_0x7f09217d);
            if (list == null) {
                return Collections.emptyList();
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view2) {
        InterceptResult invokeL;
        AccessibilityNodeProvider accessibilityNodeProvider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 16 && (accessibilityNodeProvider = this.mOriginalDelegate.getAccessibilityNodeProvider(view2)) != null) {
                return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
            }
            return null;
        }
        return (AccessibilityNodeProviderCompat) invokeL.objValue;
    }

    private boolean isSpanStillValid(ClickableSpan clickableSpan, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, clickableSpan, view2)) == null) {
            if (clickableSpan != null) {
                ClickableSpan[] clickableSpans = AccessibilityNodeInfoCompat.getClickableSpans(view2.createAccessibilityNodeInfo().getText());
                for (int i = 0; clickableSpans != null && i < clickableSpans.length; i++) {
                    if (clickableSpan.equals(clickableSpans[i])) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private boolean performClickableSpanAction(int i, View view2) {
        InterceptResult invokeIL;
        WeakReference weakReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65541, this, i, view2)) == null) {
            SparseArray sparseArray = (SparseArray) view2.getTag(R.id.obfuscated_res_0x7f09217e);
            if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i)) != null) {
                ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
                if (isSpanStillValid(clickableSpan, view2)) {
                    clickableSpan.onClick(view2);
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public boolean dispatchPopulateAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, accessibilityEvent)) == null) {
            return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(view2, accessibilityEvent);
        }
        return invokeLL.booleanValue;
    }

    public void onInitializeAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view2, accessibilityEvent) == null) {
            this.mOriginalDelegate.onInitializeAccessibilityEvent(view2, accessibilityEvent);
        }
    }

    public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, accessibilityNodeInfoCompat) == null) {
            this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat.unwrap());
        }
    }

    public void onPopulateAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, accessibilityEvent) == null) {
            this.mOriginalDelegate.onPopulateAccessibilityEvent(view2, accessibilityEvent);
        }
    }

    public void sendAccessibilityEvent(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, i) == null) {
            this.mOriginalDelegate.sendAccessibilityEvent(view2, i);
        }
    }

    public void sendAccessibilityEventUnchecked(View view2, AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, view2, accessibilityEvent) == null) {
            this.mOriginalDelegate.sendAccessibilityEventUnchecked(view2, accessibilityEvent);
        }
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view2, AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, viewGroup, view2, accessibilityEvent)) == null) {
            return this.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view2, accessibilityEvent);
        }
        return invokeLLL.booleanValue;
    }

    public boolean performAccessibilityAction(View view2, int i, Bundle bundle) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048583, this, view2, i, bundle)) == null) {
            List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = getActionList(view2);
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= actionList.size()) {
                    break;
                }
                AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = actionList.get(i2);
                if (accessibilityActionCompat.getId() == i) {
                    z = accessibilityActionCompat.perform(view2, bundle);
                    break;
                }
                i2++;
            }
            if (!z && Build.VERSION.SDK_INT >= 16) {
                z = this.mOriginalDelegate.performAccessibilityAction(view2, i, bundle);
            }
            if (!z && i == R.id.obfuscated_res_0x7f090030) {
                return performClickableSpanAction(bundle.getInt(AccessibilityClickableSpanCompat.SPAN_ID, -1), view2);
            }
            return z;
        }
        return invokeLIL.booleanValue;
    }
}
