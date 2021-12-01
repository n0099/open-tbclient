package c.a.r0.q2.x;

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
import c.a.d.f.p.l;
import c.a.q0.s.q.d2;
import c.a.r0.q2.h;
import c.a.r0.q2.i;
import c.a.r0.q2.j;
import c.a.r0.q2.r.r;
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
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f22357b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f22358c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22359d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f22360e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22361f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f22362g;

    /* renamed from: h  reason: collision with root package name */
    public PbVideoFullUserInfoLikeButton f22363h;

    /* renamed from: i  reason: collision with root package name */
    public d f22364i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f22365j;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f22366k;
    public View.OnClickListener l;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f22367e;

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
            this.f22367e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f22367e.f22358c || view == this.f22367e.f22359d || view == this.f22367e.f22362g) {
                    this.f22367e.l(view);
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
        this.a = tbPageContext;
        this.f22357b = g(tbPageContext);
        h();
        frameLayout.addView(this.f22357b);
    }

    public final void e(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
            this.f22362g.setVisibility(8);
            this.f22358c.setUserId(postData.t().getUserId());
            this.f22358c.setUserName(postData.t().getUserName());
            this.f22358c.setIsBigV(postData.t().isBigV());
            this.f22359d.setText(postData.t().getName_show());
            this.f22359d.setTag(postData.t().getUserId());
            this.f22358c.startLoad(postData.t().getAvater(), 28, false);
            this.f22364i.n(postData.t());
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22360e : (View) invokeV.objValue;
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
            this.f22360e = (RelativeLayout) this.f22357b.findViewById(i.pbVideoFullUserInfoPanel);
            HeadImageView headImageView = (HeadImageView) this.f22357b.findViewById(i.pbVideoFullPhoto);
            this.f22358c = headImageView;
            headImageView.setOnClickListener(this.l);
            LinearLayout linearLayout = (LinearLayout) this.f22357b.findViewById(i.pbVideoFullNameLayout);
            this.f22366k = linearLayout;
            SkinManager.setBackgroundResource(linearLayout, h.video_author_bg);
            TextView textView = (TextView) this.f22357b.findViewById(i.pbVideoFullUserName);
            this.f22359d = textView;
            textView.setOnClickListener(this.l);
            TextView textView2 = (TextView) this.f22357b.findViewById(i.pbVideoFullAttention);
            this.f22361f = textView2;
            textView2.setOnClickListener(this.l);
            this.f22362g = (ImageView) this.f22357b.findViewById(i.pbVideoFullChannelIcon);
            PbVideoFullUserInfoLikeButton pbVideoFullUserInfoLikeButton = (PbVideoFullUserInfoLikeButton) this.f22357b.findViewById(i.pbVideoFullLikeButton);
            this.f22363h = pbVideoFullUserInfoLikeButton;
            pbVideoFullUserInfoLikeButton.setTextSize(0, l.f(this.a.getPageActivity(), c.a.r0.q2.g.tbds30));
            this.f22364i = new d(this.a, this.f22363h);
            this.f22358c.setRadius(l.f(this.a.getPageActivity(), c.a.r0.q2.g.ds40));
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
            PbVideoFullUserInfoLikeButton pbVideoFullUserInfoLikeButton = this.f22363h;
            if (pbVideoFullUserInfoLikeButton != null) {
                pbVideoFullUserInfoLikeButton.onChangeSkinType(i2);
            }
            SkinManager.setViewTextColor(this.f22361f, c.a.r0.q2.f.CAM_X0101);
            TextView textView = this.f22359d;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, c.a.r0.q2.f.CAM_X0101);
            }
            ImageView imageView = this.f22362g;
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
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || (onClickListener = this.f22365j) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    public void m(PostData postData, d2 d2Var, r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, postData, d2Var, rVar) == null) {
            this.f22363h.setVisibility(0);
            this.f22361f.setVisibility(8);
            e(postData);
            if (i(d2Var)) {
                this.f22361f.setVisibility(8);
                this.f22363h.setVisibility(8);
            }
        }
    }

    public void n(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            this.f22360e.setAlpha(f2);
        }
    }

    public void o(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.f22365j = onClickListener;
        }
    }
}
