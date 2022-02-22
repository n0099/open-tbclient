package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.s.r.e2;
import c.a.u0.a4.d;
import c.a.u0.a4.g;
import c.a.u0.a4.h;
import c.a.u0.a4.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f40810e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f40811f;

    /* renamed from: g  reason: collision with root package name */
    public Context f40812g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f40813h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f40814i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f40815j;
    public boolean k;
    public boolean l;
    public int sourceFromForPb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f40813h = false;
        this.f40814i = false;
        this.f40815j = false;
        this.k = false;
        this.l = false;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(h.thread_comment_and_view_info_layout, (ViewGroup) this, true);
            this.f40810e = (TextView) inflate.findViewById(g.thread_view_num);
            this.f40811f = (TextView) inflate.findViewById(g.thread_comment_num);
            this.f40812g = context;
        }
    }

    public final void b(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2Var) == null) || this.f40811f == null || e2Var == null || !this.f40814i) {
            return;
        }
        if (e2Var.W0() >= 0) {
            this.f40811f.setVisibility(0);
            this.f40811f.setText(String.format(this.f40812g.getString(j.comment_num_tip), StringHelper.numberUniformFormat(e2Var.W0())));
            return;
        }
        this.f40811f.setVisibility(8);
    }

    public final void c(e2 e2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2Var) == null) && this.f40811f != null && e2Var != null && this.l && e2Var.x2()) {
            this.f40811f.setVisibility(0);
            this.f40811f.setText(String.format(this.f40812g.getString(j.person_view_item_live_share_num), StringHelper.numberUniformFormat((e2Var.p1() == null || e2Var.p1().share_info == null) ? 0 : e2Var.p1().share_info.share_count)));
        }
    }

    public final void d(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, e2Var) == null) || this.f40810e == null || e2Var == null || !this.f40813h) {
            return;
        }
        if (e2Var.F1() >= 0) {
            this.f40810e.setVisibility(0);
            this.f40810e.setText(String.format(this.f40812g.getString(j.person_view_num), StringHelper.numberUniformFormat(e2Var.F1())));
            return;
        }
        this.f40810e.setVisibility(8);
    }

    public final void e(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, e2Var) == null) || this.f40810e == null || e2Var == null || !this.f40815j || e2Var.p1() == null || !e2Var.x2()) {
            return;
        }
        this.f40810e.setVisibility(0);
        this.f40810e.setText(String.format(this.f40812g.getString(j.person_view_item_live_watch_num), StringHelper.numberUniformFormat(e2Var.p1().audience_count)));
    }

    public final void f(e2 e2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, e2Var) == null) && this.f40811f != null && e2Var != null && this.k && e2Var.x2()) {
            this.f40811f.setVisibility(0);
            this.f40811f.setText(String.format(this.f40812g.getString(j.person_view_item_live_zan_num), StringHelper.numberUniformFormat(e2Var.C())));
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SkinManager.setViewTextColor(this.f40810e, d.CAM_X0109);
            SkinManager.setViewTextColor(this.f40811f, d.CAM_X0109);
        }
    }

    public void setData(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, e2Var) == null) {
            if (e2Var == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            e(e2Var);
            d(e2Var);
            b(e2Var);
            f(e2Var);
            c(e2Var);
        }
    }

    public void setIsShowAudienceNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f40815j = z;
        }
    }

    public void setIsShowReadNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f40813h = z;
        }
    }

    public void setIsShowReplayNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f40814i = z;
        }
    }

    public void setIsShowShareNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.l = z;
        }
    }

    public void setIsShowZanNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.k = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f40813h = false;
        this.f40814i = false;
        this.f40815j = false;
        this.k = false;
        this.l = false;
        a(context);
    }
}
