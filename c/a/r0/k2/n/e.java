package c.a.r0.k2.n;

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
import c.a.e.e.p.l;
import c.a.q0.s.q.d2;
import c.a.r0.k2.h.p;
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
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f20694a;

    /* renamed from: b  reason: collision with root package name */
    public View f20695b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f20696c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f20697d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f20698e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20699f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f20700g;

    /* renamed from: h  reason: collision with root package name */
    public PbVideoFullUserInfoLikeButton f20701h;

    /* renamed from: i  reason: collision with root package name */
    public d f20702i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f20703j;
    public LinearLayout k;
    public View.OnClickListener l;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f20704e;

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
            this.f20704e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f20704e.f20696c || view == this.f20704e.f20697d || view == this.f20704e.f20700g) {
                    this.f20704e.l(view);
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
        this.f20694a = tbPageContext;
        this.f20695b = g(tbPageContext);
        h();
        frameLayout.addView(this.f20695b);
    }

    public final void e(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
            this.f20700g.setVisibility(8);
            this.f20696c.setUserId(postData.t().getUserId());
            this.f20696c.setUserName(postData.t().getUserName());
            this.f20696c.setIsBigV(postData.t().isBigV());
            this.f20697d.setText(postData.t().getName_show());
            this.f20697d.setTag(postData.t().getUserId());
            this.f20696c.startLoad(postData.t().getAvater(), 28, false);
            this.f20702i.n(postData.t());
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20698e : (View) invokeV.objValue;
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
            this.f20698e = (RelativeLayout) this.f20695b.findViewById(R.id.pbVideoFullUserInfoPanel);
            HeadImageView headImageView = (HeadImageView) this.f20695b.findViewById(R.id.pbVideoFullPhoto);
            this.f20696c = headImageView;
            headImageView.setOnClickListener(this.l);
            LinearLayout linearLayout = (LinearLayout) this.f20695b.findViewById(R.id.pbVideoFullNameLayout);
            this.k = linearLayout;
            SkinManager.setBackgroundResource(linearLayout, R.drawable.video_author_bg);
            TextView textView = (TextView) this.f20695b.findViewById(R.id.pbVideoFullUserName);
            this.f20697d = textView;
            textView.setOnClickListener(this.l);
            TextView textView2 = (TextView) this.f20695b.findViewById(R.id.pbVideoFullAttention);
            this.f20699f = textView2;
            textView2.setOnClickListener(this.l);
            this.f20700g = (ImageView) this.f20695b.findViewById(R.id.pbVideoFullChannelIcon);
            PbVideoFullUserInfoLikeButton pbVideoFullUserInfoLikeButton = (PbVideoFullUserInfoLikeButton) this.f20695b.findViewById(R.id.pbVideoFullLikeButton);
            this.f20701h = pbVideoFullUserInfoLikeButton;
            pbVideoFullUserInfoLikeButton.setTextSize(0, l.g(this.f20694a.getPageActivity(), R.dimen.tbds30));
            this.f20702i = new d(this.f20694a, this.f20701h);
            this.f20696c.setRadius(l.g(this.f20694a.getPageActivity(), R.dimen.ds40));
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
            PbVideoFullUserInfoLikeButton pbVideoFullUserInfoLikeButton = this.f20701h;
            if (pbVideoFullUserInfoLikeButton != null) {
                pbVideoFullUserInfoLikeButton.onChangeSkinType(i2);
            }
            SkinManager.setViewTextColor(this.f20699f, R.color.CAM_X0101);
            TextView textView = this.f20697d;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
            }
            ImageView imageView = this.f20700g;
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
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || (onClickListener = this.f20703j) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    public void m(PostData postData, d2 d2Var, p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, postData, d2Var, pVar) == null) {
            this.f20701h.setVisibility(0);
            this.f20699f.setVisibility(8);
            e(postData);
            if (i(d2Var)) {
                this.f20699f.setVisibility(8);
                this.f20701h.setVisibility(8);
            }
        }
    }

    public void n(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            this.f20698e.setAlpha(f2);
        }
    }

    public void o(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.f20703j = onClickListener;
        }
    }
}
