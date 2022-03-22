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
/* loaded from: classes4.dex */
public class SoftKeyBoardListener implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public int f28532b;

    /* renamed from: c  reason: collision with root package name */
    public OnSoftKeyBoardChangeListener f28533c;

    /* loaded from: classes4.dex */
    public interface OnSoftKeyBoardChangeListener extends NoProguard {
        void keyBoardHide(int i);

        void keyBoardShow(int i);
    }

    /* loaded from: classes4.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SoftKeyBoardListener a;

        public a(SoftKeyBoardListener softKeyBoardListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {softKeyBoardListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = softKeyBoardListener;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.a.a.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                PrintStream printStream = System.out;
                printStream.println("" + height);
                SoftKeyBoardListener softKeyBoardListener = this.a;
                int i = softKeyBoardListener.f28532b;
                if (i == 0) {
                    softKeyBoardListener.f28532b = height;
                } else if (i == height) {
                } else {
                    if (i - height > 200) {
                        if (softKeyBoardListener.f28533c != null) {
                            this.a.f28533c.keyBoardShow(this.a.f28532b - height);
                        }
                        this.a.f28532b = height;
                    } else if (height - i > 200) {
                        if (softKeyBoardListener.f28533c != null) {
                            this.a.f28533c.keyBoardHide(height - this.a.f28532b);
                        }
                        this.a.f28532b = height;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View decorView = activity.getWindow().getDecorView();
        this.a = decorView;
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
            this.f28533c = onSoftKeyBoardChangeListener;
        }
    }
}
