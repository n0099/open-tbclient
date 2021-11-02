package com.baidu.searchbox.ui.animview.praise.data;

import android.graphics.Rect;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ComboPraiseConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect mBaseRect;
    public boolean mFirstPraiseAnimEnabled;
    public boolean mInterceptTouchEvent;
    public boolean mIsH5OrHNCall;
    public boolean mIsNAOrWebCall;
    public boolean mNightMode;
    public String mPraiseId;
    public String mPraiseSource;
    public ComboPraiseUBC mUBC;

    public ComboPraiseConfig() {
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
        this.mBaseRect = new Rect();
        this.mFirstPraiseAnimEnabled = false;
    }
}
