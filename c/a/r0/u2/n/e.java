package c.a.r0.u2.n;

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
import c.a.d.f.p.n;
import c.a.q0.r.r.e2;
import c.a.r0.u2.h.r;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.video.PbVideoFullUserInfoLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f23907b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f23908c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f23909d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f23910e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f23911f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f23912g;

    /* renamed from: h  reason: collision with root package name */
    public PbVideoFullUserInfoLikeButton f23913h;

    /* renamed from: i  reason: collision with root package name */
    public d f23914i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f23915j;
    public LinearLayout k;
    public View.OnClickListener l;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f23916e;

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
            this.f23916e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f23916e.f23908c || view == this.f23916e.f23909d || view == this.f23916e.f23912g) {
                    this.f23916e.l(view);
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
        this.f23907b = g(tbPageContext);
        h();
        frameLayout.addView(this.f23907b);
    }

    public final void e(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
            this.f23912g.setVisibility(8);
            this.f23908c.setUserId(postData.t().getUserId());
            this.f23908c.setUserName(postData.t().getUserName());
            this.f23908c.setIsBigV(postData.t().isBigV());
            this.f23909d.setText(postData.t().getName_show());
            this.f23909d.setTag(postData.t().getUserId());
            this.f23908c.startLoad(postData.t().getAvater(), 28, false);
            this.f23914i.n(postData.t());
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23910e : (View) invokeV.objValue;
    }

    public final View g(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext)) == null) {
            if (tbPageContext == null) {
                return null;
            }
            return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
        }
        return (View) invokeL.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f23910e = (RelativeLayout) this.f23907b.findViewById(R.id.pbVideoFullUserInfoPanel);
            HeadImageView headImageView = (HeadImageView) this.f23907b.findViewById(R.id.pbVideoFullPhoto);
            this.f23908c = headImageView;
            headImageView.setOnClickListener(this.l);
            LinearLayout linearLayout = (LinearLayout) this.f23907b.findViewById(R.id.pbVideoFullNameLayout);
            this.k = linearLayout;
            SkinManager.setBackgroundResource(linearLayout, R.drawable.video_author_bg);
            TextView textView = (TextView) this.f23907b.findViewById(R.id.pbVideoFullUserName);
            this.f23909d = textView;
            textView.setOnClickListener(this.l);
            TextView textView2 = (TextView) this.f23907b.findViewById(R.id.pbVideoFullAttention);
            this.f23911f = textView2;
            textView2.setOnClickListener(this.l);
            this.f23912g = (ImageView) this.f23907b.findViewById(R.id.pbVideoFullChannelIcon);
            PbVideoFullUserInfoLikeButton pbVideoFullUserInfoLikeButton = (PbVideoFullUserInfoLikeButton) this.f23907b.findViewById(R.id.pbVideoFullLikeButton);
            this.f23913h = pbVideoFullUserInfoLikeButton;
            pbVideoFullUserInfoLikeButton.setTextSize(0, n.f(this.a.getPageActivity(), R.dimen.tbds30));
            this.f23914i = new d(this.a, this.f23913h);
            this.f23908c.setRadius(n.f(this.a.getPageActivity(), R.dimen.ds40));
        }
    }

    public final boolean i(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, e2Var)) == null) {
            if (e2Var == null || e2Var.J() == null || e2Var.J().getUserId() == null) {
                return false;
            }
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), e2Var.J().getUserId());
        }
        return invokeL.booleanValue;
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            PbVideoFullUserInfoLikeButton pbVideoFullUserInfoLikeButton = this.f23913h;
            if (pbVideoFullUserInfoLikeButton != null) {
                pbVideoFullUserInfoLikeButton.onChangeSkinType(i2);
            }
            SkinManager.setViewTextColor(this.f23911f, (int) R.color.CAM_X0101);
            TextView textView = this.f23909d;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            }
            ImageView imageView = this.f23912g;
            if (imageView != null) {
                SkinManager.setBackgroundResource(imageView, R.drawable.icon_weiba);
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
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || (onClickListener = this.f23915j) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    public void m(PostData postData, e2 e2Var, r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, postData, e2Var, rVar) == null) {
            this.f23913h.setVisibility(0);
            this.f23911f.setVisibility(8);
            e(postData);
            if (i(e2Var)) {
                this.f23911f.setVisibility(8);
                this.f23913h.setVisibility(8);
            }
        }
    }

    public void n(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            this.f23910e.setAlpha(f2);
        }
    }

    public void o(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.f23915j = onClickListener;
        }
    }
}
