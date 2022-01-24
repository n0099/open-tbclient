package c.a.t0.c1.d.b;

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
/* loaded from: classes6.dex */
public class a extends d<TbTitleActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbTitleActivity a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f15560b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f15561c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f15562d;

    /* renamed from: e  reason: collision with root package name */
    public ScrollView f15563e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f15564f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15565g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f15566h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f15567i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f15568j;
    public LinearLayout k;
    public View l;
    public View.OnClickListener m;
    public List<LevelInfo> n;
    public DataRes o;
    public b p;

    /* renamed from: c.a.t0.c1.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0992a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15569e;

        public View$OnClickListenerC0992a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15569e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f15569e.a.getPageContext().getContext()).createNormalCfg(this.f15569e.getPageContext().getString(R.string.tieba_text), "from")));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public View.OnClickListener f15570e;

        public b(a aVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15570e = onClickListener;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f15570e.onClick(view);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new b(this, new View$OnClickListenerC0992a(this));
        this.a = tbTitleActivity;
        this.m = onClickListener;
        initUI();
    }

    public void d(DataRes dataRes) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
            this.o = dataRes;
            if (dataRes == null) {
                return;
            }
            if (dataRes.is_like.intValue() == 1 && (linearLayout = this.k) != null) {
                linearLayout.setVisibility(8);
            }
            if (this.f15565g != null) {
                if (StringUtils.isNull(this.o.level_name, true)) {
                    this.f15565g.setText(this.o.level_name);
                } else {
                    this.f15565g.setVisibility(8);
                }
            }
            if (this.f15566h != null) {
                if (this.o.user_level.intValue() > 0 && this.o.user_level.intValue() <= 18) {
                    SkinManager.setImageResource(this.f15566h, BitmapHelper.getGradeResourceIdNew(this.o.user_level.intValue()));
                } else {
                    this.f15566h.setVisibility(8);
                }
            }
        }
    }

    public void e(List<LevelInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.n = list;
            if (this.f15564f == null || list == null || list.size() == 0) {
                return;
            }
            this.f15564f.removeAllViews();
            for (int i2 = 1; i2 <= list.size(); i2++) {
                LevelInfo levelInfo = list.get(i2 - 1);
                View inflate = LayoutInflater.from(this.a.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.table_item_background);
                TextView textView = (TextView) inflate.findViewById(R.id.table_item_level_name);
                TextView textView2 = (TextView) inflate.findViewById(R.id.table_item_need_experienment);
                View findViewById = inflate.findViewById(R.id.tbtile_item_horizontal_line);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.table_item_level_img);
                if (i2 % 2 != 0) {
                    SkinManager.setBackgroundResource(linearLayout, R.color.CAM_X0205);
                }
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
                this.f15564f.addView(inflate);
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f15563e.setVisibility(0);
            this.a.hideLoadingView(this.f15560b);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f15563e.setVisibility(0);
            this.a.hideNetRefreshView(this.f15560b);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
            String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
            int length = string2.length();
            int indexOf = string.indexOf(string2);
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(this.p, indexOf, length + indexOf, 33);
            this.f15567i.setText(spannableString);
            this.f15567i.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            NavigationBar navigationBar = this.f15562d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), i2);
            }
            NoNetworkView noNetworkView = this.f15561c;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.a.getPageContext(), i2);
            }
            e(this.n);
            d(this.o);
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f15560b);
        }
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
            this.f15560b = relativeLayout;
            this.a.setContentView(relativeLayout);
            this.l = this.f15560b.findViewById(R.id.top_view);
            if (!l.A()) {
                this.l.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + n.f(this.a.getActivity(), R.dimen.ds170);
            } else {
                this.l.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + n.f(this.a.getActivity(), R.dimen.ds88);
            }
            NavigationBar navigationBar = (NavigationBar) this.f15560b.findViewById(R.id.view_navigation_bar);
            this.f15562d = navigationBar;
            navigationBar.setCenterTextTitle(this.a.getString(R.string.tbtitle_title));
            this.f15562d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f15562d.showBottomLine();
            this.f15563e = (ScrollView) this.f15560b.findViewById(R.id.tbtitle_scroll_view);
            this.k = (LinearLayout) this.f15560b.findViewById(R.id.first_line_layout);
            this.f15568j = (TextView) this.f15560b.findViewById(R.id.tbtile_like_btn);
            this.f15564f = (LinearLayout) this.f15560b.findViewById(R.id.table_canvas);
            this.f15565g = (TextView) this.f15560b.findViewById(R.id.user_level_name);
            this.f15566h = (ImageView) this.f15560b.findViewById(R.id.header_level_img);
            this.f15567i = (TextView) this.f15560b.findViewById(R.id.tbtitle_tip_detail2);
            this.f15561c = (NoNetworkView) this.f15560b.findViewById(R.id.view_no_network);
            h();
            k();
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (!z) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.l.getLayoutParams();
                layoutParams.height = UtilHelper.getLightStatusBarHeight() + n.f(this.a.getActivity(), R.dimen.ds170);
                this.l.setLayoutParams(layoutParams);
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams2.height = UtilHelper.getLightStatusBarHeight() + n.f(this.a.getActivity(), R.dimen.ds88);
            this.l.setLayoutParams(layoutParams2);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f15568j.setOnClickListener(this.m);
            this.f15567i.setOnClickListener(this.m);
        }
    }

    public void l(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f15561c.addNetworkChangeListener(bVar);
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f15563e.setVisibility(8);
            this.a.showLoadingView(this.f15560b, true);
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f15563e.setVisibility(8);
            this.a.showNetRefreshView(this.f15560b, str, true);
            this.a.setNetRefreshViewTopMargin(400);
        }
    }
}
