package com.baidu.searchbox.widget.toucharea;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class BdTouchDelegate extends TouchDelegate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<View, ExpandBounds> mDelegateViewExpandMap;

    /* loaded from: classes7.dex */
    public class ExpandBounds {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Rect bounds;
        public int expandBottom;
        public int expandLeft;
        public int expandRight;
        public int expandTop;
        public boolean isDelegateTarget;
        public int slop;
        public Rect slopBounds;
        public final /* synthetic */ BdTouchDelegate this$0;

        public ExpandBounds(BdTouchDelegate bdTouchDelegate, Rect rect, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTouchDelegate, rect, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bdTouchDelegate;
            this.expandLeft = i2;
            this.bounds = rect;
            this.expandTop = i3;
            this.expandRight = i4;
            this.expandBottom = i5;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdTouchDelegate(View view, int i2, int i3, int i4, int i5) {
        super(null, view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Rect) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDelegateViewExpandMap = new HashMap();
        addExpandChild(view, i2, i3, i4, i5);
    }

    private void initArea() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            for (Map.Entry<View, ExpandBounds> entry : this.mDelegateViewExpandMap.entrySet()) {
                View key = entry.getKey();
                ExpandBounds value = entry.getValue();
                key.getGlobalVisibleRect(value.bounds);
                Rect rect = value.bounds;
                rect.left -= value.expandLeft;
                rect.right += value.expandRight;
                rect.top -= value.expandTop;
                rect.bottom += value.expandBottom;
                value.slop = ViewConfiguration.get(key.getContext()).getScaledTouchSlop();
                Rect rect2 = new Rect(value.bounds);
                value.slopBounds = rect2;
                int i2 = value.slop;
                rect2.inset(-i2, -i2);
            }
        }
    }

    public void addExpandChild(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            this.mDelegateViewExpandMap.put(view, new ExpandBounds(this, new Rect(), i2, i3, i4, i5));
        }
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            initArea();
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = true;
            for (Map.Entry<View, ExpandBounds> entry : this.mDelegateViewExpandMap.entrySet()) {
                View key = entry.getKey();
                if (key.getVisibility() == 0) {
                    ExpandBounds value = entry.getValue();
                    int action = motionEvent.getAction();
                    if (action != 0) {
                        if (action == 1 || action == 2) {
                            z2 = value.isDelegateTarget;
                            if (z2 && !value.slopBounds.contains(rawX, rawY)) {
                                z3 = false;
                            }
                        } else if (action == 3) {
                            z2 = value.isDelegateTarget;
                            value.isDelegateTarget = false;
                        }
                    } else if (value.bounds.contains(rawX, rawY)) {
                        value.isDelegateTarget = true;
                        z2 = true;
                    } else {
                        value.isDelegateTarget = false;
                        z2 = false;
                    }
                    if (z2) {
                        if (z3) {
                            motionEvent.setLocation(key.getWidth() / 2, key.getHeight() / 2);
                        } else {
                            float f2 = -(value.slop * 2);
                            motionEvent.setLocation(f2, f2);
                        }
                        z = key.dispatchTouchEvent(motionEvent);
                    }
                    if (z) {
                        break;
                    }
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
