package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ViewPropertyAnimatorCompatSet {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<ViewPropertyAnimatorCompat> mAnimators;
    public long mDuration;
    public Interpolator mInterpolator;
    public boolean mIsStarted;
    public ViewPropertyAnimatorListener mListener;
    public final ViewPropertyAnimatorListenerAdapter mProxyListener;

    public ViewPropertyAnimatorCompatSet() {
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
        this.mDuration = -1L;
        this.mProxyListener = new ViewPropertyAnimatorListenerAdapter(this) { // from class: androidx.appcompat.view.ViewPropertyAnimatorCompatSet.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int mProxyEndCount;
            public boolean mProxyStarted;
            public final /* synthetic */ ViewPropertyAnimatorCompatSet this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
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
                this.mProxyStarted = false;
                this.mProxyEndCount = 0;
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    int i4 = this.mProxyEndCount + 1;
                    this.mProxyEndCount = i4;
                    if (i4 == this.this$0.mAnimators.size()) {
                        ViewPropertyAnimatorListener viewPropertyAnimatorListener = this.this$0.mListener;
                        if (viewPropertyAnimatorListener != null) {
                            viewPropertyAnimatorListener.onAnimationEnd(null);
                        }
                        onEnd();
                    }
                }
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationStart(View view) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.mProxyStarted) {
                    return;
                }
                this.mProxyStarted = true;
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = this.this$0.mListener;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationStart(null);
                }
            }

            public void onEnd() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.mProxyEndCount = 0;
                    this.mProxyStarted = false;
                    this.this$0.onAnimationsEnded();
                }
            }
        };
        this.mAnimators = new ArrayList<>();
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.mIsStarted) {
            Iterator<ViewPropertyAnimatorCompat> it = this.mAnimators.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.mIsStarted = false;
        }
    }

    public void onAnimationsEnded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mIsStarted = false;
        }
    }

    public ViewPropertyAnimatorCompatSet play(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewPropertyAnimatorCompat)) == null) {
            if (!this.mIsStarted) {
                this.mAnimators.add(viewPropertyAnimatorCompat);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompatSet) invokeL.objValue;
    }

    public ViewPropertyAnimatorCompatSet playSequentially(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewPropertyAnimatorCompat, viewPropertyAnimatorCompat2)) == null) {
            this.mAnimators.add(viewPropertyAnimatorCompat);
            viewPropertyAnimatorCompat2.setStartDelay(viewPropertyAnimatorCompat.getDuration());
            this.mAnimators.add(viewPropertyAnimatorCompat2);
            return this;
        }
        return (ViewPropertyAnimatorCompatSet) invokeLL.objValue;
    }

    public ViewPropertyAnimatorCompatSet setDuration(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            if (!this.mIsStarted) {
                this.mDuration = j;
            }
            return this;
        }
        return (ViewPropertyAnimatorCompatSet) invokeJ.objValue;
    }

    public ViewPropertyAnimatorCompatSet setInterpolator(Interpolator interpolator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, interpolator)) == null) {
            if (!this.mIsStarted) {
                this.mInterpolator = interpolator;
            }
            return this;
        }
        return (ViewPropertyAnimatorCompatSet) invokeL.objValue;
    }

    public ViewPropertyAnimatorCompatSet setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewPropertyAnimatorListener)) == null) {
            if (!this.mIsStarted) {
                this.mListener = viewPropertyAnimatorListener;
            }
            return this;
        }
        return (ViewPropertyAnimatorCompatSet) invokeL.objValue;
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.mIsStarted) {
            return;
        }
        Iterator<ViewPropertyAnimatorCompat> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            ViewPropertyAnimatorCompat next = it.next();
            long j = this.mDuration;
            if (j >= 0) {
                next.setDuration(j);
            }
            Interpolator interpolator = this.mInterpolator;
            if (interpolator != null) {
                next.setInterpolator(interpolator);
            }
            if (this.mListener != null) {
                next.setListener(this.mProxyListener);
            }
            next.start();
        }
        this.mIsStarted = true;
    }
}
