package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import c.a.d.f.m.b;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.r0.s.r.d2;
import c.a.r0.s.r.z1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes11.dex */
public class ThreadForumEnterButtonContainer extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f41785e;

    /* renamed from: f  reason: collision with root package name */
    public ThreadForumEnterButton f41786f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadForumEnterButton f41787g;

    /* renamed from: h  reason: collision with root package name */
    public ThreadForumEnterButton f41788h;

    /* renamed from: i  reason: collision with root package name */
    public View f41789i;

    /* renamed from: j  reason: collision with root package name */
    public int f41790j;

    /* renamed from: k  reason: collision with root package name */
    public int f41791k;

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

    public void bindMultiForumsThreadData(d2 d2Var, List<z1> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, d2Var, list) == null) || d2Var == null) {
            return;
        }
        if (list != null && list.size() > 1) {
            if (list.size() == 2) {
                if (this.f41786f != null && list.get(0) != null && !l.isEmpty(list.get(0).getForumName())) {
                    d2 d2Var2 = new d2();
                    d2Var2.S3(d2Var.g0());
                    d2Var2.M3(list.get(0).getForumName());
                    d2Var2.I3(b.g(list.get(0).getForumId(), 0L));
                    this.f41786f.bindData(d2Var2, this.f41790j);
                }
                if (this.f41787g != null && list.get(1) != null && !l.isEmpty(list.get(1).getForumName())) {
                    d2 d2Var3 = new d2();
                    d2Var3.S3(d2Var.g0());
                    d2Var3.M3(list.get(1).getForumName());
                    d2Var3.I3(b.g(list.get(1).getForumId(), 0L));
                    this.f41787g.bindData(d2Var3, this.f41790j);
                }
                ThreadForumEnterButton threadForumEnterButton = this.f41788h;
                if (threadForumEnterButton != null) {
                    threadForumEnterButton.setVisibility(8);
                }
                setVisibility(0);
                return;
            }
            if (this.f41786f != null && list.get(0) != null && !l.isEmpty(list.get(0).getForumName())) {
                d2 d2Var4 = new d2();
                d2Var4.S3(d2Var.g0());
                d2Var4.M3(list.get(0).getForumName());
                d2Var4.I3(b.g(list.get(0).getForumId(), 0L));
                this.f41786f.bindData(d2Var4, this.f41791k);
            }
            if (this.f41787g != null && list.get(1) != null && !l.isEmpty(list.get(1).getForumName())) {
                d2 d2Var5 = new d2();
                d2Var5.S3(d2Var.g0());
                d2Var5.M3(list.get(1).getForumName());
                d2Var5.I3(b.g(list.get(1).getForumId(), 0L));
                this.f41787g.bindData(d2Var5, this.f41791k);
            }
            if (this.f41788h != null && list.get(2) != null && !l.isEmpty(list.get(2).getForumName())) {
                d2 d2Var6 = new d2();
                d2Var6.S3(d2Var.g0());
                d2Var6.M3(list.get(2).getForumName());
                d2Var6.I3(b.g(list.get(2).getForumId(), 0L));
                this.f41788h.bindData(d2Var6, this.f41791k);
            }
            setVisibility(0);
            return;
        }
        bindSingleForumThreadData(d2Var);
    }

    public void bindSingleForumThreadData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) || d2Var == null || l.isEmpty(d2Var.a0())) {
            return;
        }
        ThreadForumEnterButton threadForumEnterButton = this.f41786f;
        if (threadForumEnterButton != null) {
            threadForumEnterButton.bindData(d2Var);
            setVisibility(0);
        }
        ThreadForumEnterButton threadForumEnterButton2 = this.f41787g;
        if (threadForumEnterButton2 != null) {
            threadForumEnterButton2.setVisibility(8);
        }
        ThreadForumEnterButton threadForumEnterButton3 = this.f41788h;
        if (threadForumEnterButton3 != null) {
            threadForumEnterButton3.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ThreadForumEnterButton threadForumEnterButton = this.f41786f;
            if (threadForumEnterButton != null) {
                threadForumEnterButton.onChangeSkinType();
            }
            ThreadForumEnterButton threadForumEnterButton2 = this.f41787g;
            if (threadForumEnterButton2 != null) {
                threadForumEnterButton2.onChangeSkinType();
            }
            ThreadForumEnterButton threadForumEnterButton3 = this.f41788h;
            if (threadForumEnterButton3 != null) {
                threadForumEnterButton3.onChangeSkinType();
            }
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            ThreadForumEnterButton threadForumEnterButton = this.f41786f;
            if (threadForumEnterButton != null) {
                threadForumEnterButton.setAfterClickListener(onClickListener);
            }
            ThreadForumEnterButton threadForumEnterButton2 = this.f41787g;
            if (threadForumEnterButton2 != null) {
                threadForumEnterButton2.setAfterClickListener(onClickListener);
            }
            ThreadForumEnterButton threadForumEnterButton3 = this.f41788h;
            if (threadForumEnterButton3 != null) {
                threadForumEnterButton3.setAfterClickListener(onClickListener);
            }
        }
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f41789i.setVisibility(z ? 0 : 8);
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            ThreadForumEnterButton threadForumEnterButton = this.f41786f;
            if (threadForumEnterButton != null) {
                threadForumEnterButton.setFrom(i2);
            }
            ThreadForumEnterButton threadForumEnterButton2 = this.f41787g;
            if (threadForumEnterButton2 != null) {
                threadForumEnterButton2.setFrom(i2);
            }
            ThreadForumEnterButton threadForumEnterButton3 = this.f41788h;
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
        this.f41785e = m.f(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.f41786f = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.f41787g = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.f41788h = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.f41789i = findViewById(R.id.bottom_placeholder);
        this.f41790j = (((m.k(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.f41785e) / 2;
        this.f41791k = (((m.k(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.f41785e * 2)) / 3;
    }
}
