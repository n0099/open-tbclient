package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class ThreadForumEnterButtonContainer extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f12552e;

    /* renamed from: f  reason: collision with root package name */
    public ThreadForumEnterButton f12553f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadForumEnterButton f12554g;

    /* renamed from: h  reason: collision with root package name */
    public ThreadForumEnterButton f12555h;

    /* renamed from: i  reason: collision with root package name */
    public View f12556i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ThreadForumEnterButton threadForumEnterButton = this.f12553f;
            if (threadForumEnterButton != null) {
                threadForumEnterButton.d();
            }
            ThreadForumEnterButton threadForumEnterButton2 = this.f12554g;
            if (threadForumEnterButton2 != null) {
                threadForumEnterButton2.d();
            }
            ThreadForumEnterButton threadForumEnterButton3 = this.f12555h;
            if (threadForumEnterButton3 != null) {
                threadForumEnterButton3.d();
            }
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            ThreadForumEnterButton threadForumEnterButton = this.f12553f;
            if (threadForumEnterButton != null) {
                threadForumEnterButton.setAfterClickListener(onClickListener);
            }
            ThreadForumEnterButton threadForumEnterButton2 = this.f12554g;
            if (threadForumEnterButton2 != null) {
                threadForumEnterButton2.setAfterClickListener(onClickListener);
            }
            ThreadForumEnterButton threadForumEnterButton3 = this.f12555h;
            if (threadForumEnterButton3 != null) {
                threadForumEnterButton3.setAfterClickListener(onClickListener);
            }
        }
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f12556i.setVisibility(z ? 0 : 8);
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            ThreadForumEnterButton threadForumEnterButton = this.f12553f;
            if (threadForumEnterButton != null) {
                threadForumEnterButton.setFrom(i2);
            }
            ThreadForumEnterButton threadForumEnterButton2 = this.f12554g;
            if (threadForumEnterButton2 != null) {
                threadForumEnterButton2.setFrom(i2);
            }
            ThreadForumEnterButton threadForumEnterButton3 = this.f12555h;
            if (threadForumEnterButton3 != null) {
                threadForumEnterButton3.setFrom(i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f12552e = l.g(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.f12553f = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.f12554g = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.f12555h = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.f12556i = findViewById(R.id.bottom_placeholder);
        int k = (((l.k(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.f12552e) / 2;
        int k2 = (((l.k(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.f12552e * 2)) / 3;
    }
}
