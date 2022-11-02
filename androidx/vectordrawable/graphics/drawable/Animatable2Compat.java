package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public interface Animatable2Compat extends Animatable {
    void clearAnimationCallbacks();

    void registerAnimationCallback(@NonNull AnimationCallback animationCallback);

    boolean unregisterAnimationCallback(@NonNull AnimationCallback animationCallback);

    /* loaded from: classes.dex */
    public static abstract class AnimationCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Animatable2.AnimationCallback mPlatformCallback;

        public void onAnimationEnd(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable) == null) {
            }
        }

        public void onAnimationStart(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, drawable) == null) {
            }
        }

        public AnimationCallback() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @RequiresApi(23)
        public Animatable2.AnimationCallback getPlatformCallback() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.mPlatformCallback == null) {
                    this.mPlatformCallback = new Animatable2.AnimationCallback(this) { // from class: androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnimationCallback this$0;

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

                        @Override // android.graphics.drawable.Animatable2.AnimationCallback
                        public void onAnimationEnd(Drawable drawable) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, drawable) == null) {
                                this.this$0.onAnimationEnd(drawable);
                            }
                        }

                        @Override // android.graphics.drawable.Animatable2.AnimationCallback
                        public void onAnimationStart(Drawable drawable) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable) == null) {
                                this.this$0.onAnimationStart(drawable);
                            }
                        }
                    };
                }
                return this.mPlatformCallback;
            }
            return (Animatable2.AnimationCallback) invokeV.objValue;
        }
    }
}
