package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.d2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f45463e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f45464f;

    /* renamed from: g  reason: collision with root package name */
    public Context f45465g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f45466h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f45467i;
    public boolean j;
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
        this.f45466h = false;
        this.f45467i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
            this.f45463e = (TextView) inflate.findViewById(R.id.thread_view_num);
            this.f45464f = (TextView) inflate.findViewById(R.id.thread_comment_num);
            this.f45465g = context;
        }
    }

    public final void b(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) || this.f45464f == null || d2Var == null || !this.f45467i) {
            return;
        }
        if (d2Var.U0() >= 0) {
            this.f45464f.setVisibility(0);
            this.f45464f.setText(String.format(this.f45465g.getString(R.string.comment_num_tip), StringHelper.numberUniformFormat(d2Var.U0())));
            return;
        }
        this.f45464f.setVisibility(8);
    }

    public final void c(d2 d2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var) == null) && this.f45464f != null && d2Var != null && this.l && d2Var.t2()) {
            this.f45464f.setVisibility(0);
            this.f45464f.setText(String.format(this.f45465g.getString(R.string.person_view_item_live_share_num), StringHelper.numberUniformFormat((d2Var.l1() == null || d2Var.l1().share_info == null) ? 0 : d2Var.l1().share_info.share_count)));
        }
    }

    public final void d(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, d2Var) == null) || this.f45463e == null || d2Var == null || !this.f45466h) {
            return;
        }
        if (d2Var.C1() >= 0) {
            this.f45463e.setVisibility(0);
            this.f45463e.setText(String.format(this.f45465g.getString(R.string.person_view_num), StringHelper.numberUniformFormat(d2Var.C1())));
            return;
        }
        this.f45463e.setVisibility(8);
    }

    public final void e(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, d2Var) == null) || this.f45463e == null || d2Var == null || !this.j || d2Var.l1() == null || !d2Var.t2()) {
            return;
        }
        this.f45463e.setVisibility(0);
        this.f45463e.setText(String.format(this.f45465g.getString(R.string.person_view_item_live_watch_num), StringHelper.numberUniformFormat(d2Var.l1().audience_count)));
    }

    public final void f(d2 d2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, d2Var) == null) && this.f45464f != null && d2Var != null && this.k && d2Var.t2()) {
            this.f45464f.setVisibility(0);
            this.f45464f.setText(String.format(this.f45465g.getString(R.string.person_view_item_live_zan_num), StringHelper.numberUniformFormat(d2Var.C())));
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SkinManager.setViewTextColor(this.f45463e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f45464f, R.color.CAM_X0109);
        }
    }

    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, d2Var) == null) {
            if (d2Var == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            e(d2Var);
            d(d2Var);
            b(d2Var);
            f(d2Var);
            c(d2Var);
        }
    }

    public void setIsShowAudienceNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.j = z;
        }
    }

    public void setIsShowReadNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f45466h = z;
        }
    }

    public void setIsShowReplayNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f45467i = z;
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
        this.f45466h = false;
        this.f45467i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        a(context);
    }
}
