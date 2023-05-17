package com.baidu.spswitch.utils;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class EmoAlphaChangeHelper extends RecyclerView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DELAY_TIME = 150;
    public static final String TAG = "EmoAlphaChangeHelper";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public Rect mDelBtLocRect;
    public View mDelBtn;
    public int mSpanCount;
    public int mState;
    public boolean mTempEnableIdleAlpha;

    public EmoAlphaChangeHelper(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTempEnableIdleAlpha = true;
        this.mState = 0;
        this.mContext = context;
    }

    public void setDelBtn(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            this.mDelBtn = view2;
        }
    }

    public void setSpanCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.mSpanCount = i;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
            super.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
            super.onScrolled(recyclerView, i, i2);
            enableIdleAlphaTemporarily();
        }
    }

    private void enableIdleAlphaTemporarily() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) != null) || this.mTempEnableIdleAlpha) {
            return;
        }
        this.mTempEnableIdleAlpha = true;
        UiThreadUtils.getMainHandler().postDelayed(new Runnable(this) { // from class: com.baidu.spswitch.utils.EmoAlphaChangeHelper.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ EmoAlphaChangeHelper this$0;

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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                    return;
                }
                this.this$0.mTempEnableIdleAlpha = false;
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getIconAlpha(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, this, viewGroup, i)) == null) {
            int[] iArr = new int[2];
            this.mDelBtn.getLocationOnScreen(iArr);
            boolean z = false;
            this.mDelBtLocRect = new Rect(iArr[0], iArr[1], iArr[0] + this.mDelBtn.getWidth(), iArr[1] + this.mDelBtn.getHeight());
            int[] iArr2 = new int[2];
            viewGroup.getLocationOnScreen(iArr2);
            Rect rect = new Rect(iArr2[0], iArr2[1], iArr2[0] + viewGroup.getWidth(), iArr2[1] + viewGroup.getHeight());
            int dp2px = (int) UIUtils.dp2px(this.mContext, 10.0f);
            int height = viewGroup.getHeight();
            int i2 = (rect.right - this.mDelBtLocRect.left) - dp2px;
            float centerY = rect.centerY() - this.mDelBtLocRect.centerY();
            if (AppConfig.isDebug()) {
                Log.d(TAG, "getIconAlpha: pos " + i + " mState " + this.mState + " diff " + i2 + " changeZone " + dp2px + " ic " + rect + " de " + this.mDelBtLocRect);
            }
            if ((rect.top > this.mDelBtLocRect.top - dp2px || Math.abs(centerY) < dp2px) && i2 > 0) {
                viewGroup.setEnabled(false);
                return 0.0f;
            }
            if (i2 > 0) {
                if (Math.abs(centerY) < ((this.mDelBtn.getHeight() + height) + dp2px) / 2.0f) {
                    float abs = Math.abs(centerY) / (height * 2);
                    if (abs > 0.2f) {
                        z = true;
                    }
                    viewGroup.setEnabled(z);
                    return abs;
                }
            }
            viewGroup.setEnabled(true);
            return 1.0f;
        }
        return invokeLI.floatValue;
    }

    public void processAlpha(ViewGroup viewGroup, int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i) != null) || viewGroup == null || (view2 = this.mDelBtn) == null || view2.getVisibility() != 0 || i % this.mSpanCount != 0) {
            return;
        }
        if (viewGroup.getTag() != null && (viewGroup.getTag() instanceof ViewTreeObserver.OnPreDrawListener)) {
            return;
        }
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener(this, viewGroup, i) { // from class: com.baidu.spswitch.utils.EmoAlphaChangeHelper.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ EmoAlphaChangeHelper this$0;
            public final /* synthetic */ ViewGroup val$itemView;
            public final /* synthetic */ int val$position;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, viewGroup, Integer.valueOf(i)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$itemView = viewGroup;
                this.val$position = i;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    if (!this.this$0.mTempEnableIdleAlpha) {
                        return true;
                    }
                    float iconAlpha = this.this$0.getIconAlpha(this.val$itemView, this.val$position);
                    if (iconAlpha >= 0.0f) {
                        this.val$itemView.setAlpha(iconAlpha);
                    }
                    return true;
                }
                return invokeV.booleanValue;
            }
        };
        viewGroup.setTag(onPreDrawListener);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(onPreDrawListener);
    }
}
