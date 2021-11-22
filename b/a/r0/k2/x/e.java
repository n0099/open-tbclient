package b.a.r0.k2.x;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.l;
import b.a.q0.s.q.d2;
import b.a.r0.k2.h;
import b.a.r0.k2.i;
import b.a.r0.k2.j;
import b.a.r0.k2.r.r;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.pb.video.PbVideoFullUserInfoLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f21214a;

    /* renamed from: b  reason: collision with root package name */
    public View f21215b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f21216c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21217d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f21218e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21219f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f21220g;

    /* renamed from: h  reason: collision with root package name */
    public PbVideoFullUserInfoLikeButton f21221h;

    /* renamed from: i  reason: collision with root package name */
    public d f21222i;
    public View.OnClickListener j;
    public LinearLayout k;
    public View.OnClickListener l;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f21223e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21223e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f21223e.f21216c || view == this.f21223e.f21217d || view == this.f21223e.f21220g) {
                    this.f21223e.l(view);
                }
            }
        }
    }

    public e(TbPageContext tbPageContext, FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, frameLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
        this.f21214a = tbPageContext;
        this.f21215b = g(tbPageContext);
        h();
        frameLayout.addView(this.f21215b);
    }

    public final void e(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
            this.f21220g.setVisibility(8);
            this.f21216c.setUserId(postData.t().getUserId());
            this.f21216c.setUserName(postData.t().getUserName());
            this.f21216c.setIsBigV(postData.t().isBigV());
            this.f21217d.setText(postData.t().getName_show());
            this.f21217d.setTag(postData.t().getUserId());
            this.f21216c.startLoad(postData.t().getAvater(), 28, false);
            this.f21222i.n(postData.t());
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21218e : (View) invokeV.objValue;
    }

    public final View g(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext)) == null) {
            if (tbPageContext == null) {
                return null;
            }
            return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(j.video_pb_full_user_info_layout, (ViewGroup) null);
        }
        return (View) invokeL.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f21218e = (RelativeLayout) this.f21215b.findViewById(i.pbVideoFullUserInfoPanel);
            HeadImageView headImageView = (HeadImageView) this.f21215b.findViewById(i.pbVideoFullPhoto);
            this.f21216c = headImageView;
            headImageView.setOnClickListener(this.l);
            LinearLayout linearLayout = (LinearLayout) this.f21215b.findViewById(i.pbVideoFullNameLayout);
            this.k = linearLayout;
            SkinManager.setBackgroundResource(linearLayout, h.video_author_bg);
            TextView textView = (TextView) this.f21215b.findViewById(i.pbVideoFullUserName);
            this.f21217d = textView;
            textView.setOnClickListener(this.l);
            TextView textView2 = (TextView) this.f21215b.findViewById(i.pbVideoFullAttention);
            this.f21219f = textView2;
            textView2.setOnClickListener(this.l);
            this.f21220g = (ImageView) this.f21215b.findViewById(i.pbVideoFullChannelIcon);
            PbVideoFullUserInfoLikeButton pbVideoFullUserInfoLikeButton = (PbVideoFullUserInfoLikeButton) this.f21215b.findViewById(i.pbVideoFullLikeButton);
            this.f21221h = pbVideoFullUserInfoLikeButton;
            pbVideoFullUserInfoLikeButton.setTextSize(0, l.g(this.f21214a.getPageActivity(), b.a.r0.k2.g.tbds30));
            this.f21222i = new d(this.f21214a, this.f21221h);
            this.f21216c.setRadius(l.g(this.f21214a.getPageActivity(), b.a.r0.k2.g.ds40));
        }
    }

    public final boolean i(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, d2Var)) == null) {
            if (d2Var == null || d2Var.J() == null || d2Var.J().getUserId() == null) {
                return false;
            }
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), d2Var.J().getUserId());
        }
        return invokeL.booleanValue;
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            PbVideoFullUserInfoLikeButton pbVideoFullUserInfoLikeButton = this.f21221h;
            if (pbVideoFullUserInfoLikeButton != null) {
                pbVideoFullUserInfoLikeButton.onChangeSkinType(i2);
            }
            SkinManager.setViewTextColor(this.f21219f, b.a.r0.k2.f.CAM_X0101);
            TextView textView = this.f21217d;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, b.a.r0.k2.f.CAM_X0101);
            }
            ImageView imageView = this.f21220g;
            if (imageView != null) {
                SkinManager.setBackgroundResource(imageView, h.icon_weiba);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public final void l(View view) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || (onClickListener = this.j) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    public void m(PostData postData, d2 d2Var, r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, postData, d2Var, rVar) == null) {
            this.f21221h.setVisibility(0);
            this.f21219f.setVisibility(8);
            e(postData);
            if (i(d2Var)) {
                this.f21219f.setVisibility(8);
                this.f21221h.setVisibility(8);
            }
        }
    }

    public void n(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            this.f21218e.setAlpha(f2);
        }
    }

    public void o(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.j = onClickListener;
        }
    }
}
