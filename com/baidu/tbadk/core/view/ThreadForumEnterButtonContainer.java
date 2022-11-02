package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ThreadForumEnterButtonContainer extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public ThreadForumEnterButton b;
    public ThreadForumEnterButton c;
    public ThreadForumEnterButton d;
    public View e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = xi.g(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0899, this);
        this.b = (ThreadForumEnterButton) findViewById(R.id.obfuscated_res_0x7f090a85);
        this.c = (ThreadForumEnterButton) findViewById(R.id.obfuscated_res_0x7f090a87);
        this.d = (ThreadForumEnterButton) findViewById(R.id.obfuscated_res_0x7f090a86);
        this.e = findViewById(R.id.obfuscated_res_0x7f09040b);
        int l = (((xi.l(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.a) / 2;
        int l2 = (((xi.l(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.a * 2)) / 3;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ThreadForumEnterButton threadForumEnterButton = this.b;
            if (threadForumEnterButton != null) {
                threadForumEnterButton.e();
            }
            ThreadForumEnterButton threadForumEnterButton2 = this.c;
            if (threadForumEnterButton2 != null) {
                threadForumEnterButton2.e();
            }
            ThreadForumEnterButton threadForumEnterButton3 = this.d;
            if (threadForumEnterButton3 != null) {
                threadForumEnterButton3.e();
            }
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            ThreadForumEnterButton threadForumEnterButton = this.b;
            if (threadForumEnterButton != null) {
                threadForumEnterButton.setAfterClickListener(onClickListener);
            }
            ThreadForumEnterButton threadForumEnterButton2 = this.c;
            if (threadForumEnterButton2 != null) {
                threadForumEnterButton2.setAfterClickListener(onClickListener);
            }
            ThreadForumEnterButton threadForumEnterButton3 = this.d;
            if (threadForumEnterButton3 != null) {
                threadForumEnterButton3.setAfterClickListener(onClickListener);
            }
        }
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            View view2 = this.e;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            ThreadForumEnterButton threadForumEnterButton = this.b;
            if (threadForumEnterButton != null) {
                threadForumEnterButton.setFrom(i);
            }
            ThreadForumEnterButton threadForumEnterButton2 = this.c;
            if (threadForumEnterButton2 != null) {
                threadForumEnterButton2.setFrom(i);
            }
            ThreadForumEnterButton threadForumEnterButton3 = this.d;
            if (threadForumEnterButton3 != null) {
                threadForumEnterButton3.setFrom(i);
            }
        }
    }
}
