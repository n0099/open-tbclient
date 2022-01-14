package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.e2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f40553e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f40554f;

    /* renamed from: g  reason: collision with root package name */
    public Context f40555g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f40556h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f40557i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f40558j;
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
        this.f40556h = false;
        this.f40557i = false;
        this.f40558j = false;
        this.k = false;
        this.l = false;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
            this.f40553e = (TextView) inflate.findViewById(R.id.thread_view_num);
            this.f40554f = (TextView) inflate.findViewById(R.id.thread_comment_num);
            this.f40555g = context;
        }
    }

    public final void b(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2Var) == null) || this.f40554f == null || e2Var == null || !this.f40557i) {
            return;
        }
        if (e2Var.V0() >= 0) {
            this.f40554f.setVisibility(0);
            this.f40554f.setText(String.format(this.f40555g.getString(R.string.comment_num_tip), StringHelper.numberUniformFormat(e2Var.V0())));
            return;
        }
        this.f40554f.setVisibility(8);
    }

    public final void c(e2 e2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2Var) == null) && this.f40554f != null && e2Var != null && this.l && e2Var.w2()) {
            this.f40554f.setVisibility(0);
            this.f40554f.setText(String.format(this.f40555g.getString(R.string.person_view_item_live_share_num), StringHelper.numberUniformFormat((e2Var.o1() == null || e2Var.o1().share_info == null) ? 0 : e2Var.o1().share_info.share_count)));
        }
    }

    public final void d(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, e2Var) == null) || this.f40553e == null || e2Var == null || !this.f40556h) {
            return;
        }
        if (e2Var.E1() >= 0) {
            this.f40553e.setVisibility(0);
            this.f40553e.setText(String.format(this.f40555g.getString(R.string.person_view_num), StringHelper.numberUniformFormat(e2Var.E1())));
            return;
        }
        this.f40553e.setVisibility(8);
    }

    public final void e(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, e2Var) == null) || this.f40553e == null || e2Var == null || !this.f40558j || e2Var.o1() == null || !e2Var.w2()) {
            return;
        }
        this.f40553e.setVisibility(0);
        this.f40553e.setText(String.format(this.f40555g.getString(R.string.person_view_item_live_watch_num), StringHelper.numberUniformFormat(e2Var.o1().audience_count)));
    }

    public final void f(e2 e2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, e2Var) == null) && this.f40554f != null && e2Var != null && this.k && e2Var.w2()) {
            this.f40554f.setVisibility(0);
            this.f40554f.setText(String.format(this.f40555g.getString(R.string.person_view_item_live_zan_num), StringHelper.numberUniformFormat(e2Var.C())));
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SkinManager.setViewTextColor(this.f40553e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f40554f, R.color.CAM_X0109);
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
            this.f40558j = z;
        }
    }

    public void setIsShowReadNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f40556h = z;
        }
    }

    public void setIsShowReplayNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f40557i = z;
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
        this.f40556h = false;
        this.f40557i = false;
        this.f40558j = false;
        this.k = false;
        this.l = false;
        a(context);
    }
}
