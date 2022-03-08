package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import c.a.d.f.m.b;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.q0.r.r.a2;
import c.a.q0.r.r.e2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class ThreadForumEnterButtonContainer extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f39161e;

    /* renamed from: f  reason: collision with root package name */
    public ThreadForumEnterButton f39162f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadForumEnterButton f39163g;

    /* renamed from: h  reason: collision with root package name */
    public ThreadForumEnterButton f39164h;

    /* renamed from: i  reason: collision with root package name */
    public View f39165i;

    /* renamed from: j  reason: collision with root package name */
    public int f39166j;
    public int k;

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

    public void bindMultiForumsThreadData(e2 e2Var, List<a2> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, e2Var, list) == null) || e2Var == null) {
            return;
        }
        if (list != null && list.size() > 1) {
            if (list.size() == 2) {
                if (this.f39162f != null && list.get(0) != null && !m.isEmpty(list.get(0).getForumName())) {
                    e2 e2Var2 = new e2();
                    e2Var2.T3(e2Var.h0());
                    e2Var2.N3(list.get(0).getForumName());
                    e2Var2.J3(b.g(list.get(0).getForumId(), 0L));
                    this.f39162f.bindData(e2Var2, this.f39166j);
                }
                if (this.f39163g != null && list.get(1) != null && !m.isEmpty(list.get(1).getForumName())) {
                    e2 e2Var3 = new e2();
                    e2Var3.T3(e2Var.h0());
                    e2Var3.N3(list.get(1).getForumName());
                    e2Var3.J3(b.g(list.get(1).getForumId(), 0L));
                    this.f39163g.bindData(e2Var3, this.f39166j);
                }
                ThreadForumEnterButton threadForumEnterButton = this.f39164h;
                if (threadForumEnterButton != null) {
                    threadForumEnterButton.setVisibility(8);
                }
                setVisibility(0);
                return;
            }
            if (this.f39162f != null && list.get(0) != null && !m.isEmpty(list.get(0).getForumName())) {
                e2 e2Var4 = new e2();
                e2Var4.T3(e2Var.h0());
                e2Var4.N3(list.get(0).getForumName());
                e2Var4.J3(b.g(list.get(0).getForumId(), 0L));
                this.f39162f.bindData(e2Var4, this.k);
            }
            if (this.f39163g != null && list.get(1) != null && !m.isEmpty(list.get(1).getForumName())) {
                e2 e2Var5 = new e2();
                e2Var5.T3(e2Var.h0());
                e2Var5.N3(list.get(1).getForumName());
                e2Var5.J3(b.g(list.get(1).getForumId(), 0L));
                this.f39163g.bindData(e2Var5, this.k);
            }
            if (this.f39164h != null && list.get(2) != null && !m.isEmpty(list.get(2).getForumName())) {
                e2 e2Var6 = new e2();
                e2Var6.T3(e2Var.h0());
                e2Var6.N3(list.get(2).getForumName());
                e2Var6.J3(b.g(list.get(2).getForumId(), 0L));
                this.f39164h.bindData(e2Var6, this.k);
            }
            setVisibility(0);
            return;
        }
        bindSingleForumThreadData(e2Var);
    }

    public void bindSingleForumThreadData(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2Var) == null) || e2Var == null || m.isEmpty(e2Var.b0())) {
            return;
        }
        ThreadForumEnterButton threadForumEnterButton = this.f39162f;
        if (threadForumEnterButton != null) {
            threadForumEnterButton.bindData(e2Var);
            setVisibility(0);
        }
        ThreadForumEnterButton threadForumEnterButton2 = this.f39163g;
        if (threadForumEnterButton2 != null) {
            threadForumEnterButton2.setVisibility(8);
        }
        ThreadForumEnterButton threadForumEnterButton3 = this.f39164h;
        if (threadForumEnterButton3 != null) {
            threadForumEnterButton3.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ThreadForumEnterButton threadForumEnterButton = this.f39162f;
            if (threadForumEnterButton != null) {
                threadForumEnterButton.onChangeSkinType();
            }
            ThreadForumEnterButton threadForumEnterButton2 = this.f39163g;
            if (threadForumEnterButton2 != null) {
                threadForumEnterButton2.onChangeSkinType();
            }
            ThreadForumEnterButton threadForumEnterButton3 = this.f39164h;
            if (threadForumEnterButton3 != null) {
                threadForumEnterButton3.onChangeSkinType();
            }
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            ThreadForumEnterButton threadForumEnterButton = this.f39162f;
            if (threadForumEnterButton != null) {
                threadForumEnterButton.setAfterClickListener(onClickListener);
            }
            ThreadForumEnterButton threadForumEnterButton2 = this.f39163g;
            if (threadForumEnterButton2 != null) {
                threadForumEnterButton2.setAfterClickListener(onClickListener);
            }
            ThreadForumEnterButton threadForumEnterButton3 = this.f39164h;
            if (threadForumEnterButton3 != null) {
                threadForumEnterButton3.setAfterClickListener(onClickListener);
            }
        }
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f39165i.setVisibility(z ? 0 : 8);
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            ThreadForumEnterButton threadForumEnterButton = this.f39162f;
            if (threadForumEnterButton != null) {
                threadForumEnterButton.setFrom(i2);
            }
            ThreadForumEnterButton threadForumEnterButton2 = this.f39163g;
            if (threadForumEnterButton2 != null) {
                threadForumEnterButton2.setFrom(i2);
            }
            ThreadForumEnterButton threadForumEnterButton3 = this.f39164h;
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
        this.f39161e = n.f(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.f39162f = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.f39163g = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.f39164h = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.f39165i = findViewById(R.id.bottom_placeholder);
        this.f39166j = (((n.k(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.f39161e) / 2;
        this.k = (((n.k(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.f39161e * 2)) / 3;
    }
}
