package c.a.p0.w2.p;

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
import c.a.p0.w2.i.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
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
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f20424b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f20425c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f20426d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f20427e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20428f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f20429g;

    /* renamed from: h  reason: collision with root package name */
    public PbVideoFullUserInfoLikeButton f20430h;
    public d i;
    public View.OnClickListener j;
    public LinearLayout k;
    public View.OnClickListener l;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.a.f20425c || view == this.a.f20426d || view == this.a.f20429g) {
                    this.a.l(view);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
        this.a = tbPageContext;
        this.f20424b = g(tbPageContext);
        h();
        frameLayout.addView(this.f20424b);
    }

    public final void e(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
            this.f20429g.setVisibility(8);
            this.f20425c.setUserId(postData.s().getUserId());
            this.f20425c.setUserName(postData.s().getUserName());
            this.f20425c.setIsBigV(postData.s().isBigV());
            this.f20426d.setText(postData.s().getName_show());
            this.f20426d.setTag(postData.s().getUserId());
            this.f20425c.J(postData.s().getAvater(), 28, false);
            this.i.n(postData.s());
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20427e : (View) invokeV.objValue;
    }

    public final View g(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext)) == null) {
            if (tbPageContext == null) {
                return null;
            }
            return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d088c, (ViewGroup) null);
        }
        return (View) invokeL.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f20427e = (RelativeLayout) this.f20424b.findViewById(R.id.obfuscated_res_0x7f091688);
            HeadImageView headImageView = (HeadImageView) this.f20424b.findViewById(R.id.obfuscated_res_0x7f091687);
            this.f20425c = headImageView;
            headImageView.setOnClickListener(this.l);
            LinearLayout linearLayout = (LinearLayout) this.f20424b.findViewById(R.id.obfuscated_res_0x7f091686);
            this.k = linearLayout;
            SkinManager.setBackgroundResource(linearLayout, R.drawable.video_author_bg);
            TextView textView = (TextView) this.f20424b.findViewById(R.id.obfuscated_res_0x7f091689);
            this.f20426d = textView;
            textView.setOnClickListener(this.l);
            TextView textView2 = (TextView) this.f20424b.findViewById(R.id.obfuscated_res_0x7f091683);
            this.f20428f = textView2;
            textView2.setOnClickListener(this.l);
            this.f20429g = (ImageView) this.f20424b.findViewById(R.id.obfuscated_res_0x7f091684);
            PbVideoFullUserInfoLikeButton pbVideoFullUserInfoLikeButton = (PbVideoFullUserInfoLikeButton) this.f20424b.findViewById(R.id.obfuscated_res_0x7f091685);
            this.f20430h = pbVideoFullUserInfoLikeButton;
            pbVideoFullUserInfoLikeButton.setTextSize(0, n.f(this.a.getPageActivity(), R.dimen.tbds30));
            this.i = new d(this.a, this.f20430h);
            this.f20425c.setRadius(n.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070225));
        }
    }

    public final boolean i(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, threadData)) == null) {
            if (threadData == null || threadData.getAuthor() == null || threadData.getAuthor().getUserId() == null) {
                return false;
            }
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), threadData.getAuthor().getUserId());
        }
        return invokeL.booleanValue;
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            PbVideoFullUserInfoLikeButton pbVideoFullUserInfoLikeButton = this.f20430h;
            if (pbVideoFullUserInfoLikeButton != null) {
                pbVideoFullUserInfoLikeButton.g(i);
            }
            SkinManager.setViewTextColor(this.f20428f, (int) R.color.CAM_X0101);
            TextView textView = this.f20426d;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            }
            ImageView imageView = this.f20429g;
            if (imageView != null) {
                SkinManager.setBackgroundResource(imageView, R.drawable.obfuscated_res_0x7f080ae6);
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

    public void m(PostData postData, ThreadData threadData, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, postData, threadData, sVar) == null) {
            this.f20430h.setVisibility(0);
            this.f20428f.setVisibility(8);
            e(postData);
            if (i(threadData)) {
                this.f20428f.setVisibility(8);
                this.f20430h.setVisibility(8);
            }
        }
    }

    public void n(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            this.f20427e.setAlpha(f2);
        }
    }

    public void o(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.j = onClickListener;
        }
    }
}
