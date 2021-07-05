package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MIN_DELAY = 500;
    public static final int MIN_SHOW_TIME = 500;
    public transient /* synthetic */ FieldHolder $fh;
    public final Runnable mDelayedHide;
    public final Runnable mDelayedShow;
    public boolean mDismissed;
    public boolean mPostedHide;
    public boolean mPostedShow;
    public long mStartTime;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContentLoadingProgressBar(@NonNull Context context) {
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

    private void removeCallbacks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            removeCallbacks(this.mDelayedHide);
            removeCallbacks(this.mDelayedShow);
        }
    }

    public synchronized void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.mDismissed = true;
                removeCallbacks(this.mDelayedShow);
                this.mPostedShow = false;
                long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
                if (currentTimeMillis < 500 && this.mStartTime != -1) {
                    if (!this.mPostedHide) {
                        postDelayed(this.mDelayedHide, 500 - currentTimeMillis);
                        this.mPostedHide = true;
                    }
                }
                setVisibility(8);
            }
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onAttachedToWindow();
            removeCallbacks();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDetachedFromWindow();
            removeCallbacks();
        }
    }

    public synchronized void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.mStartTime = -1L;
                this.mDismissed = false;
                removeCallbacks(this.mDelayedHide);
                this.mPostedHide = false;
                if (!this.mPostedShow) {
                    postDelayed(this.mDelayedShow, 500L);
                    this.mPostedShow = true;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentLoadingProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mStartTime = -1L;
        this.mPostedHide = false;
        this.mPostedShow = false;
        this.mDismissed = false;
        this.mDelayedHide = new Runnable(this) { // from class: androidx.core.widget.ContentLoadingProgressBar.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ContentLoadingProgressBar this$0;

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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    ContentLoadingProgressBar contentLoadingProgressBar = this.this$0;
                    contentLoadingProgressBar.mPostedHide = false;
                    contentLoadingProgressBar.mStartTime = -1L;
                    contentLoadingProgressBar.setVisibility(8);
                }
            }
        };
        this.mDelayedShow = new Runnable(this) { // from class: androidx.core.widget.ContentLoadingProgressBar.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ContentLoadingProgressBar this$0;

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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    ContentLoadingProgressBar contentLoadingProgressBar = this.this$0;
                    contentLoadingProgressBar.mPostedShow = false;
                    if (contentLoadingProgressBar.mDismissed) {
                        return;
                    }
                    contentLoadingProgressBar.mStartTime = System.currentTimeMillis();
                    this.this$0.setVisibility(0);
                }
            }
        };
    }
}
