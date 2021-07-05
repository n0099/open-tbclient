package com.baidu.fsg.base.widget;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class k implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f5530a;

    public k(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5530a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow;
        SafeScrollView safeScrollView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (safeKeyBoardPopupWindow = this.f5530a.f5529a.mPopupWindow) != null && safeKeyBoardPopupWindow.isShowing()) {
            safeScrollView = this.f5530a.f5529a.f5505e;
            if (safeScrollView.hasWindowFocus()) {
                this.f5530a.f5529a.a();
            }
        }
    }
}
