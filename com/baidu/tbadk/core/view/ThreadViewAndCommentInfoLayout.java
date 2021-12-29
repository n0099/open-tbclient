package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.d2;
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
    public TextView f42012e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f42013f;

    /* renamed from: g  reason: collision with root package name */
    public Context f42014g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42015h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f42016i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f42017j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f42018k;
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
        this.f42015h = false;
        this.f42016i = false;
        this.f42017j = false;
        this.f42018k = false;
        this.l = false;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
            this.f42012e = (TextView) inflate.findViewById(R.id.thread_view_num);
            this.f42013f = (TextView) inflate.findViewById(R.id.thread_comment_num);
            this.f42014g = context;
        }
    }

    public final void b(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) || this.f42013f == null || d2Var == null || !this.f42016i) {
            return;
        }
        if (d2Var.V0() >= 0) {
            this.f42013f.setVisibility(0);
            this.f42013f.setText(String.format(this.f42014g.getString(R.string.comment_num_tip), StringHelper.numberUniformFormat(d2Var.V0())));
            return;
        }
        this.f42013f.setVisibility(8);
    }

    public final void c(d2 d2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var) == null) && this.f42013f != null && d2Var != null && this.l && d2Var.w2()) {
            this.f42013f.setVisibility(0);
            this.f42013f.setText(String.format(this.f42014g.getString(R.string.person_view_item_live_share_num), StringHelper.numberUniformFormat((d2Var.o1() == null || d2Var.o1().share_info == null) ? 0 : d2Var.o1().share_info.share_count)));
        }
    }

    public final void d(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, d2Var) == null) || this.f42012e == null || d2Var == null || !this.f42015h) {
            return;
        }
        if (d2Var.E1() >= 0) {
            this.f42012e.setVisibility(0);
            this.f42012e.setText(String.format(this.f42014g.getString(R.string.person_view_num), StringHelper.numberUniformFormat(d2Var.E1())));
            return;
        }
        this.f42012e.setVisibility(8);
    }

    public final void e(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, d2Var) == null) || this.f42012e == null || d2Var == null || !this.f42017j || d2Var.o1() == null || !d2Var.w2()) {
            return;
        }
        this.f42012e.setVisibility(0);
        this.f42012e.setText(String.format(this.f42014g.getString(R.string.person_view_item_live_watch_num), StringHelper.numberUniformFormat(d2Var.o1().audience_count)));
    }

    public final void f(d2 d2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, d2Var) == null) && this.f42013f != null && d2Var != null && this.f42018k && d2Var.w2()) {
            this.f42013f.setVisibility(0);
            this.f42013f.setText(String.format(this.f42014g.getString(R.string.person_view_item_live_zan_num), StringHelper.numberUniformFormat(d2Var.C())));
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SkinManager.setViewTextColor(this.f42012e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f42013f, R.color.CAM_X0109);
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
            this.f42017j = z;
        }
    }

    public void setIsShowReadNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f42015h = z;
        }
    }

    public void setIsShowReplayNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f42016i = z;
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
            this.f42018k = z;
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
        this.f42015h = false;
        this.f42016i = false;
        this.f42017j = false;
        this.f42018k = false;
        this.l = false;
        a(context);
    }
}
