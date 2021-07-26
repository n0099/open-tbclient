package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
/* loaded from: classes3.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f12667e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12668f;

    /* renamed from: g  reason: collision with root package name */
    public Context f12669g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12670h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12671i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;

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
        this.f12670h = false;
        this.f12671i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
            this.f12667e = (TextView) inflate.findViewById(R.id.thread_view_num);
            this.f12668f = (TextView) inflate.findViewById(R.id.thread_comment_num);
            this.f12669g = context;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.f12667e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f12668f, R.color.CAM_X0109);
        }
    }

    public final void c(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2Var) == null) || this.f12668f == null || b2Var == null || !this.f12671i) {
            return;
        }
        if (b2Var.Q0() >= 0) {
            this.f12668f.setVisibility(0);
            this.f12668f.setText(String.format(this.f12669g.getString(R.string.comment_num_tip), StringHelper.numberUniformFormat(b2Var.Q0())));
            return;
        }
        this.f12668f.setVisibility(8);
    }

    public final void d(b2 b2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, b2Var) == null) && this.f12668f != null && b2Var != null && this.l && b2Var.h2()) {
            this.f12668f.setVisibility(0);
            this.f12668f.setText(String.format(this.f12669g.getString(R.string.person_view_item_live_share_num), StringHelper.numberUniformFormat((b2Var.h1() == null || b2Var.h1().share_info == null) ? 0 : b2Var.h1().share_info.share_count)));
        }
    }

    public final void e(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, b2Var) == null) || this.f12667e == null || b2Var == null || !this.f12670h) {
            return;
        }
        if (b2Var.x1() >= 0) {
            this.f12667e.setVisibility(0);
            this.f12667e.setText(String.format(this.f12669g.getString(R.string.person_view_num), StringHelper.numberUniformFormat(b2Var.x1())));
            return;
        }
        this.f12667e.setVisibility(8);
    }

    public final void f(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, b2Var) == null) || this.f12667e == null || b2Var == null || !this.j || b2Var.h1() == null || !b2Var.h2()) {
            return;
        }
        this.f12667e.setVisibility(0);
        this.f12667e.setText(String.format(this.f12669g.getString(R.string.person_view_item_live_watch_num), StringHelper.numberUniformFormat(b2Var.h1().audience_count)));
    }

    public final void g(b2 b2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, b2Var) == null) && this.f12668f != null && b2Var != null && this.k && b2Var.h2()) {
            this.f12668f.setVisibility(0);
            this.f12668f.setText(String.format(this.f12669g.getString(R.string.person_view_item_live_zan_num), StringHelper.numberUniformFormat(b2Var.A())));
        }
    }

    public void setData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, b2Var) == null) {
            if (b2Var == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            f(b2Var);
            e(b2Var);
            c(b2Var);
            g(b2Var);
            d(b2Var);
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
            this.f12670h = z;
        }
    }

    public void setIsShowReplayNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f12671i = z;
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
        this.f12670h = false;
        this.f12671i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        a(context);
    }
}
