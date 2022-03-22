package c.a.p0.c1.d.b;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.d;
import c.a.d.a.f;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.GetLevelInfo.DataRes;
import tbclient.LevelInfo;
/* loaded from: classes2.dex */
public class a extends d<TbTitleActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbTitleActivity a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f13444b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f13445c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f13446d;

    /* renamed from: e  reason: collision with root package name */
    public ScrollView f13447e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f13448f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13449g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f13450h;
    public TextView i;
    public TextView j;
    public LinearLayout k;
    public View l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public RelativeLayout s;
    public View.OnClickListener t;
    public List<LevelInfo> u;
    public DataRes v;
    public b w;

    /* renamed from: c.a.p0.c1.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1014a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public View$OnClickListenerC1014a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.a.getPageContext().getContext()).createNormalCfg(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f13b8), "from")));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View.OnClickListener a;

        public b(a aVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = onClickListener;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.onClick(view);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(SkinManager.getColor(R.color.CAM_X0302));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbTitleActivity, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = new b(this, new View$OnClickListenerC1014a(this));
        this.a = tbTitleActivity;
        this.t = onClickListener;
        k();
    }

    public void d(DataRes dataRes) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
            this.v = dataRes;
            if (dataRes == null) {
                return;
            }
            if (dataRes.is_like.intValue() == 1 && (linearLayout = this.k) != null) {
                linearLayout.setVisibility(8);
            }
            if (this.f13449g != null) {
                if (StringUtils.isNull(this.v.level_name, true)) {
                    this.f13449g.setText(this.v.level_name);
                } else {
                    this.f13449g.setVisibility(8);
                }
            }
            if (this.f13450h != null) {
                if (this.v.user_level.intValue() > 0 && this.v.user_level.intValue() <= 18) {
                    SkinManager.setImageResource(this.f13450h, BitmapHelper.getGradeResourceIdNew(this.v.user_level.intValue()));
                } else {
                    this.f13450h.setVisibility(8);
                }
            }
        }
    }

    public void g(List<LevelInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.u = list;
            if (this.f13448f == null || list == null || list.size() == 0) {
                return;
            }
            this.f13448f.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.a.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d081b, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091e5c);
                TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091e5e);
                TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091e5f);
                View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f091f08);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091e5d);
                if (i % 2 != 0) {
                    SkinManager.setBackgroundResource(linearLayout, R.color.CAM_X0205);
                }
                SkinManager.setBackgroundColor(this.s, R.color.CAM_X0201);
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.n, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.r, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(this.q, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0105, 1);
                SkinManager.setBackgroundColor(findViewById, R.color.CAM_X0204);
                SkinManager.setImageResource(imageView, BitmapHelper.getGradeResourceIdNew(levelInfo.id.intValue()));
                textView.setText(levelInfo.name);
                if (levelInfo.score.intValue() <= 3000000 && levelInfo.score.intValue() > 0) {
                    textView2.setText(levelInfo.score + "");
                } else if (levelInfo.score.intValue() <= 0) {
                    textView2.setText("0");
                } else {
                    textView2.setText("3000000");
                }
                this.f13448f.addView(inflate);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f13447e.setVisibility(0);
            this.a.hideLoadingView(this.f13444b);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f13447e.setVisibility(0);
            this.a.hideNetRefreshView(this.f13444b);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String string = getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f1377);
            String string2 = getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f1378);
            int length = string2.length();
            int indexOf = string.indexOf(string2);
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(this.w, indexOf, length + indexOf, 33);
            this.i.setText(spannableString);
            this.i.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d081a, (ViewGroup) null);
            this.f13444b = relativeLayout;
            this.a.setContentView(relativeLayout);
            this.m = (TextView) this.f13444b.findViewById(R.id.obfuscated_res_0x7f0923fb);
            this.n = (TextView) this.f13444b.findViewById(R.id.obfuscated_res_0x7f0919ae);
            this.o = (TextView) this.f13444b.findViewById(R.id.obfuscated_res_0x7f09093b);
            this.p = (TextView) this.f13444b.findViewById(R.id.obfuscated_res_0x7f09181d);
            this.q = (TextView) this.f13444b.findViewById(R.id.obfuscated_res_0x7f092026);
            this.r = (TextView) this.f13444b.findViewById(R.id.obfuscated_res_0x7f092442);
            this.s = (RelativeLayout) this.f13444b.findViewById(R.id.obfuscated_res_0x7f0923f2);
            this.l = this.f13444b.findViewById(R.id.obfuscated_res_0x7f0920d1);
            if (!l.A()) {
                this.l.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + n.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f070251);
            } else {
                this.l.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + n.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f0702ff);
            }
            NavigationBar navigationBar = (NavigationBar) this.f13444b.findViewById(R.id.obfuscated_res_0x7f0923cf);
            this.f13446d = navigationBar;
            navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f137a));
            this.f13446d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f13446d.showBottomLine();
            this.f13447e = (ScrollView) this.f13444b.findViewById(R.id.obfuscated_res_0x7f091f0a);
            this.k = (LinearLayout) this.f13444b.findViewById(R.id.obfuscated_res_0x7f0909a3);
            this.j = (TextView) this.f13444b.findViewById(R.id.obfuscated_res_0x7f091f09);
            this.f13448f = (LinearLayout) this.f13444b.findViewById(R.id.obfuscated_res_0x7f091e5b);
            this.f13449g = (TextView) this.f13444b.findViewById(R.id.obfuscated_res_0x7f0922b8);
            this.f13450h = (ImageView) this.f13444b.findViewById(R.id.obfuscated_res_0x7f090d3c);
            this.i = (TextView) this.f13444b.findViewById(R.id.obfuscated_res_0x7f091f0b);
            this.f13445c = (NoNetworkView) this.f13444b.findViewById(R.id.obfuscated_res_0x7f0923d1);
            j();
            n();
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            NavigationBar navigationBar = this.f13446d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), i);
            }
            NoNetworkView noNetworkView = this.f13445c;
            if (noNetworkView != null) {
                noNetworkView.c(this.a.getPageContext(), i);
            }
            g(this.u);
            d(this.v);
            this.a.getLayoutMode().k(i == 1);
            this.a.getLayoutMode().j(this.f13444b);
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (!z) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.l.getLayoutParams();
                layoutParams.height = UtilHelper.getLightStatusBarHeight() + n.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f070251);
                this.l.setLayoutParams(layoutParams);
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams2.height = UtilHelper.getLightStatusBarHeight() + n.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f0702ff);
            this.l.setLayoutParams(layoutParams2);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.j.setOnClickListener(this.t);
            this.i.setOnClickListener(this.t);
        }
    }

    public void o(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f13445c.a(bVar);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f13447e.setVisibility(8);
            this.a.showLoadingView(this.f13444b, true);
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f13447e.setVisibility(8);
            this.a.showNetRefreshView(this.f13444b, str, true);
            this.a.setNetRefreshViewTopMargin(400);
        }
    }
}
