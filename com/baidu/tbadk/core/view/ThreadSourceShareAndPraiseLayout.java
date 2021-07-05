package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.b2;
/* loaded from: classes4.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f12587e;

    /* renamed from: f  reason: collision with root package name */
    public ThreadCommentAndPraiseInfoLayout f12588f;

    /* renamed from: g  reason: collision with root package name */
    public b2 f12589g;

    /* renamed from: h  reason: collision with root package name */
    public Context f12590h;

    /* renamed from: i  reason: collision with root package name */
    public String f12591i;
    public View.OnClickListener j;
    public boolean k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadSourceShareAndPraiseLayout f12592e;

        public a(ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadSourceShareAndPraiseLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12592e = threadSourceShareAndPraiseLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f12592e.f12589g == null || StringUtils.isNull(this.f12592e.f12589g.W())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f12592e.f12590h).createNormalCfg(this.f12592e.f12589g.W(), this.f12592e.f12591i)));
            if (this.f12592e.j != null) {
                this.f12592e.j.onClick(view);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadSourceShareAndPraiseLayout(Context context) {
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
        e(context);
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || context == null) {
            return;
        }
        this.f12590h = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_praise_read_info_layout, (ViewGroup) this, true);
        this.f12587e = (TextView) inflate.findViewById(R.id.view_forum_source);
        this.f12588f = (ThreadCommentAndPraiseInfoLayout) inflate.findViewById(R.id.layout_share_and_praise);
        this.f12587e.setOnClickListener(new a(this));
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.k) {
                SkinManager.setViewTextColor(this.f12587e, R.color.CAM_X0109);
                SkinManager.setBackgroundResource(this.f12587e, R.drawable.bg_forum_source_gray);
            }
            if (this.f12588f.getVisibility() == 0) {
                this.f12588f.onChangeSkinType();
            }
        }
    }

    public boolean g(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2Var)) == null) {
            if (b2Var == null) {
                setVisibility(8);
                return false;
            }
            this.f12589g = b2Var;
            if (!StringUtils.isNull(b2Var.W()) && !this.k) {
                TextView textView = this.f12587e;
                textView.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.f12589g.W(), 10, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
                this.f12587e.setVisibility(0);
            } else {
                this.f12587e.setVisibility(8);
            }
            this.f12588f.setData(this.f12589g);
            setVisibility(0);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f12588f.setForumAfterClickListener(onClickListener);
            this.j = onClickListener;
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f12588f.setFrom(i2);
        }
    }

    public void setHideBarName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.k = z;
        }
    }

    public void setShareReportFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f12588f.setShareReportFrom(i2);
        }
    }

    public void setSourceFromForPb(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f12588f.R = i2;
        }
    }

    public void setStType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f12591i = str;
            this.f12588f.setStType(str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadSourceShareAndPraiseLayout(Context context, AttributeSet attributeSet) {
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
        e(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadSourceShareAndPraiseLayout(Context context, AttributeSet attributeSet, int i2) {
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
        e(context);
    }
}
