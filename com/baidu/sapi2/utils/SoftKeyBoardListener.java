package com.baidu.sapi2.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.sapi2.NoProguard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
/* loaded from: classes3.dex */
public class SoftKeyBoardListener implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f9984a;

    /* renamed from: b  reason: collision with root package name */
    public int f9985b;

    /* renamed from: c  reason: collision with root package name */
    public OnSoftKeyBoardChangeListener f9986c;

    /* loaded from: classes3.dex */
    public interface OnSoftKeyBoardChangeListener extends NoProguard {
        void keyBoardHide(int i2);

        void keyBoardShow(int i2);
    }

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SoftKeyBoardListener f9987a;

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
            this.f9987a = softKeyBoardListener;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.f9987a.f9984a.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                PrintStream printStream = System.out;
                printStream.println("" + height);
                SoftKeyBoardListener softKeyBoardListener = this.f9987a;
                int i2 = softKeyBoardListener.f9985b;
                if (i2 == 0) {
                    softKeyBoardListener.f9985b = height;
                } else if (i2 == height) {
                } else {
                    if (i2 - height > 200) {
                        if (softKeyBoardListener.f9986c != null) {
                            this.f9987a.f9986c.keyBoardShow(this.f9987a.f9985b - height);
                        }
                        this.f9987a.f9985b = height;
                    } else if (height - i2 > 200) {
                        if (softKeyBoardListener.f9986c != null) {
                            this.f9987a.f9986c.keyBoardHide(height - this.f9987a.f9985b);
                        }
                        this.f9987a.f9985b = height;
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
        this.f9984a = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public static void setListener(Activity activity, OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65540, null, activity, onSoftKeyBoardChangeListener) == null) {
            new SoftKeyBoardListener(activity).a(onSoftKeyBoardChangeListener);
        }
    }

    private void a(OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, onSoftKeyBoardChangeListener) == null) {
            this.f9986c = onSoftKeyBoardChangeListener;
        }
    }
}
