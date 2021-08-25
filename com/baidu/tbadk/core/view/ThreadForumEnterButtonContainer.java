package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import c.a.e.e.m.b;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.y1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class ThreadForumEnterButtonContainer extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f47690e;

    /* renamed from: f  reason: collision with root package name */
    public ThreadForumEnterButton f47691f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadForumEnterButton f47692g;

    /* renamed from: h  reason: collision with root package name */
    public ThreadForumEnterButton f47693h;

    /* renamed from: i  reason: collision with root package name */
    public View f47694i;

    /* renamed from: j  reason: collision with root package name */
    public int f47695j;
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

    public void bindMultiForumsThreadData(c2 c2Var, List<y1> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, c2Var, list) == null) || c2Var == null) {
            return;
        }
        if (list != null && list.size() > 1) {
            if (list.size() == 2) {
                if (this.f47691f != null && list.get(0) != null && !k.isEmpty(list.get(0).getForumName())) {
                    c2 c2Var2 = new c2();
                    c2Var2.H3(c2Var.f0());
                    c2Var2.B3(list.get(0).getForumName());
                    c2Var2.x3(b.f(list.get(0).getForumId(), 0L));
                    this.f47691f.bindData(c2Var2, this.f47695j);
                }
                if (this.f47692g != null && list.get(1) != null && !k.isEmpty(list.get(1).getForumName())) {
                    c2 c2Var3 = new c2();
                    c2Var3.H3(c2Var.f0());
                    c2Var3.B3(list.get(1).getForumName());
                    c2Var3.x3(b.f(list.get(1).getForumId(), 0L));
                    this.f47692g.bindData(c2Var3, this.f47695j);
                }
                ThreadForumEnterButton threadForumEnterButton = this.f47693h;
                if (threadForumEnterButton != null) {
                    threadForumEnterButton.setVisibility(8);
                }
                setVisibility(0);
                return;
            }
            if (this.f47691f != null && list.get(0) != null && !k.isEmpty(list.get(0).getForumName())) {
                c2 c2Var4 = new c2();
                c2Var4.H3(c2Var.f0());
                c2Var4.B3(list.get(0).getForumName());
                c2Var4.x3(b.f(list.get(0).getForumId(), 0L));
                this.f47691f.bindData(c2Var4, this.k);
            }
            if (this.f47692g != null && list.get(1) != null && !k.isEmpty(list.get(1).getForumName())) {
                c2 c2Var5 = new c2();
                c2Var5.H3(c2Var.f0());
                c2Var5.B3(list.get(1).getForumName());
                c2Var5.x3(b.f(list.get(1).getForumId(), 0L));
                this.f47692g.bindData(c2Var5, this.k);
            }
            if (this.f47693h != null && list.get(2) != null && !k.isEmpty(list.get(2).getForumName())) {
                c2 c2Var6 = new c2();
                c2Var6.H3(c2Var.f0());
                c2Var6.B3(list.get(2).getForumName());
                c2Var6.x3(b.f(list.get(2).getForumId(), 0L));
                this.f47693h.bindData(c2Var6, this.k);
            }
            setVisibility(0);
            return;
        }
        bindSingleForumThreadData(c2Var);
    }

    public void bindSingleForumThreadData(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c2Var) == null) || c2Var == null || k.isEmpty(c2Var.Z())) {
            return;
        }
        ThreadForumEnterButton threadForumEnterButton = this.f47691f;
        if (threadForumEnterButton != null) {
            threadForumEnterButton.bindData(c2Var);
            setVisibility(0);
        }
        ThreadForumEnterButton threadForumEnterButton2 = this.f47692g;
        if (threadForumEnterButton2 != null) {
            threadForumEnterButton2.setVisibility(8);
        }
        ThreadForumEnterButton threadForumEnterButton3 = this.f47693h;
        if (threadForumEnterButton3 != null) {
            threadForumEnterButton3.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ThreadForumEnterButton threadForumEnterButton = this.f47691f;
            if (threadForumEnterButton != null) {
                threadForumEnterButton.onChangeSkinType();
            }
            ThreadForumEnterButton threadForumEnterButton2 = this.f47692g;
            if (threadForumEnterButton2 != null) {
                threadForumEnterButton2.onChangeSkinType();
            }
            ThreadForumEnterButton threadForumEnterButton3 = this.f47693h;
            if (threadForumEnterButton3 != null) {
                threadForumEnterButton3.onChangeSkinType();
            }
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            ThreadForumEnterButton threadForumEnterButton = this.f47691f;
            if (threadForumEnterButton != null) {
                threadForumEnterButton.setAfterClickListener(onClickListener);
            }
            ThreadForumEnterButton threadForumEnterButton2 = this.f47692g;
            if (threadForumEnterButton2 != null) {
                threadForumEnterButton2.setAfterClickListener(onClickListener);
            }
            ThreadForumEnterButton threadForumEnterButton3 = this.f47693h;
            if (threadForumEnterButton3 != null) {
                threadForumEnterButton3.setAfterClickListener(onClickListener);
            }
        }
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f47694i.setVisibility(z ? 0 : 8);
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            ThreadForumEnterButton threadForumEnterButton = this.f47691f;
            if (threadForumEnterButton != null) {
                threadForumEnterButton.setFrom(i2);
            }
            ThreadForumEnterButton threadForumEnterButton2 = this.f47692g;
            if (threadForumEnterButton2 != null) {
                threadForumEnterButton2.setFrom(i2);
            }
            ThreadForumEnterButton threadForumEnterButton3 = this.f47693h;
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
        this.f47690e = l.g(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.f47691f = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.f47692g = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.f47693h = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.f47694i = findViewById(R.id.bottom_placeholder);
        this.f47695j = (((l.k(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.f47690e) / 2;
        this.k = (((l.k(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.f47690e * 2)) / 3;
    }
}
