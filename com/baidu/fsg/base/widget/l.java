package com.baidu.fsg.base.widget;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class l implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ SafeKeyBoardUtil a;

    public l(SafeKeyBoardUtil safeKeyBoardUtil) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {safeKeyBoardUtil};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = safeKeyBoardUtil;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i2;
        int i3;
        SafeKeyBoardEditText safeKeyBoardEditText;
        int i4;
        SafeScrollView safeScrollView;
        int i5;
        SafeScrollView safeScrollView2;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int[] iArr = new int[2];
            view = this.a.f33986f;
            view.getLocationOnScreen(iArr);
            SafeKeyBoardUtil safeKeyBoardUtil = this.a;
            int i7 = iArr[1];
            view2 = safeKeyBoardUtil.f33986f;
            int height = i7 + view2.getHeight();
            i2 = this.a.f33987g;
            i3 = this.a.f33990j;
            int i8 = height - (i2 - i3);
            safeKeyBoardEditText = this.a.f33983c;
            safeKeyBoardUtil.f33989i = i8 + safeKeyBoardEditText.getGap();
            i4 = this.a.f33989i;
            if (i4 > 0) {
                safeScrollView2 = this.a.f33985e;
                i6 = this.a.f33989i;
                safeScrollView2.smoothScrollBy(0, i6);
            }
            safeScrollView = this.a.f33985e;
            i5 = this.a.f33990j;
            safeScrollView.notifyShowKeyBoard(i5);
        }
    }
}
