package com.baidu.sapi2.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sapi2.NoProguard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
/* loaded from: classes5.dex */
public class SoftKeyBoardListener implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f44797a;

    /* renamed from: b  reason: collision with root package name */
    public int f44798b;

    /* renamed from: c  reason: collision with root package name */
    public OnSoftKeyBoardChangeListener f44799c;

    /* loaded from: classes5.dex */
    public interface OnSoftKeyBoardChangeListener extends NoProguard {
        void keyBoardHide(int i2);

        void keyBoardShow(int i2);
    }

    /* loaded from: classes5.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SoftKeyBoardListener f44800a;

        public a(SoftKeyBoardListener softKeyBoardListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {softKeyBoardListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44800a = softKeyBoardListener;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.f44800a.f44797a.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                PrintStream printStream = System.out;
                printStream.println("" + height);
                SoftKeyBoardListener softKeyBoardListener = this.f44800a;
                int i2 = softKeyBoardListener.f44798b;
                if (i2 == 0) {
                    softKeyBoardListener.f44798b = height;
                } else if (i2 == height) {
                } else {
                    if (i2 - height > 200) {
                        if (softKeyBoardListener.f44799c != null) {
                            this.f44800a.f44799c.keyBoardShow(this.f44800a.f44798b - height);
                        }
                        this.f44800a.f44798b = height;
                    } else if (height - i2 > 200) {
                        if (softKeyBoardListener.f44799c != null) {
                            this.f44800a.f44799c.keyBoardHide(height - this.f44800a.f44798b);
                        }
                        this.f44800a.f44798b = height;
                    }
                }
            }
        }
    }

    public SoftKeyBoardListener(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View decorView = activity.getWindow().getDecorView();
        this.f44797a = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public static void setListener(Activity activity, OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, onSoftKeyBoardChangeListener) == null) {
            new SoftKeyBoardListener(activity).a(onSoftKeyBoardChangeListener);
        }
    }

    private void a(OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, onSoftKeyBoardChangeListener) == null) {
            this.f44799c = onSoftKeyBoardChangeListener;
        }
    }
}
