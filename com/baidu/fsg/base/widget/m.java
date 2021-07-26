package com.baidu.fsg.base.widget;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class m implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeScrollView f5575a;

    public m(SafeScrollView safeScrollView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {safeScrollView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5575a = safeScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeKeyBoardUtil safeKeyBoardUtil;
        Context context;
        SafeKeyBoardEditText safeKeyBoardEditText;
        SafeKeyBoardUtil safeKeyBoardUtil2;
        SafeKeyBoardEditText safeKeyBoardEditText2;
        SafeKeyBoardEditText safeKeyBoardEditText3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            safeKeyBoardUtil = this.f5575a.f5559g;
            context = this.f5575a.f5557e;
            safeKeyBoardEditText = this.f5575a.f5558f;
            safeKeyBoardUtil.init(context, safeKeyBoardEditText.getViewGroup(), this.f5575a);
            safeKeyBoardUtil2 = this.f5575a.f5559g;
            safeKeyBoardEditText2 = this.f5575a.f5558f;
            safeKeyBoardEditText3 = this.f5575a.f5558f;
            safeKeyBoardUtil2.showSoftKeyBoard(safeKeyBoardEditText2, safeKeyBoardEditText3.getVisibleView());
        }
    }
}
