package c.a.t0.o2.h;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentManager;
import c.a.s0.b.d;
import c.a.s0.s.u.c;
import c.a.t0.o2.c.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.fragment.BaseInterestSelectionFragment;
import com.baidu.tieba.newinterest.fragment.BaseInterestedForumFragment;
import com.baidu.tieba.newinterest.fragment.InterestSelectionFragment;
import com.baidu.tieba.newinterest.fragment.InterestSelectionStyleAFragment;
import com.baidu.tieba.newinterest.fragment.InterestSelectionStyleBFragment;
import com.baidu.tieba.newinterest.fragment.InterestedForumFragment;
import com.baidu.tieba.newinterest.fragment.InterestedForumStyleAFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class a implements View.OnClickListener, BaseInterestSelectionFragment.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f21433e;

    /* renamed from: f  reason: collision with root package name */
    public int f21434f;

    /* renamed from: g  reason: collision with root package name */
    public View f21435g;

    /* renamed from: h  reason: collision with root package name */
    public View f21436h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f21437i;

    /* renamed from: j  reason: collision with root package name */
    public NavigationBar f21438j;

    /* renamed from: k  reason: collision with root package name */
    public BaseInterestedForumFragment f21439k;
    public BaseInterestSelectionFragment l;

    public a(BaseFragmentActivity baseFragmentActivity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21433e = baseFragmentActivity;
        this.f21434f = i2;
        f();
        g();
    }

    @Override // com.baidu.tieba.newinterest.fragment.BaseInterestSelectionFragment.a
    public void a(List<b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            if (d.E()) {
                this.f21439k = InterestedForumStyleAFragment.getInstance(this.f21434f);
            } else {
                this.f21439k = InterestedForumFragment.getInstance(this.f21434f);
            }
            this.f21439k.setSelectedInterest(list);
            b().beginTransaction().add(R.id.content_container, this.f21439k).addToBackStack(null).commitAllowingStateLoss();
            c.a.t0.o2.e.a.a(b().getFragments().size() == 1 ? 1 : 2, 1, this.f21434f, c(list), "");
        }
    }

    public final FragmentManager b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21433e.getSupportFragmentManager() : (FragmentManager) invokeV.objValue;
    }

    public String c(List<b> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (b bVar : list) {
                if (bVar != null) {
                    if (sb.length() > 0) {
                        sb.append("|");
                    }
                    sb.append(TextUtils.isEmpty(bVar.b()) ? bVar.f() : bVar.b());
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21435g : (View) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 1);
            TiebaStatic.log(statisticItem);
            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.f21433e).createNormalCfg(0)));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View inflate = LayoutInflater.from(this.f21433e).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
            this.f21435g = inflate;
            this.f21438j = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
            if (d.F()) {
                c.d(this.f21438j).f(R.color.CAM_X0206);
            }
            TextView addTextButton = this.f21438j.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f21433e.getString(R.string.skip));
            this.f21437i = addTextButton;
            addTextButton.setId(R.id.btn_skip);
            if (!d.D() && !d.F()) {
                SkinManager.setViewTextColor(this.f21437i, R.color.CAM_X0107);
            } else {
                SkinManager.setViewTextColor(this.f21437i, R.color.CAM_X0108);
            }
            this.f21436h = this.f21438j.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            if (d.D()) {
                this.l = InterestSelectionStyleAFragment.getInstance(this.f21434f);
            } else if (d.F()) {
                this.l = InterestSelectionStyleBFragment.getInstance(this.f21434f);
            } else {
                this.l = InterestSelectionFragment.getInstance(this.f21434f);
            }
            b().beginTransaction().add(R.id.content_container, this.l).commitAllowingStateLoss();
            TiebaStatic.log(new StatisticItem("c13681"));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f21437i.setOnClickListener(this);
            this.f21436h.setOnClickListener(this);
            this.l.setNextStepClickListener(this);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && b().getFragments().size() == 1) {
            c.a.t0.o2.e.a.c(1, this.f21434f);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SkinManager.setBackgroundColor(this.f21435g, R.color.CAM_X0201);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            if (view == this.f21436h && this.f21433e != null) {
                BaseInterestedForumFragment baseInterestedForumFragment = this.f21439k;
                if (baseInterestedForumFragment != null && baseInterestedForumFragment.isVisible()) {
                    b().popBackStack();
                    c.a.t0.o2.e.a.c(1, this.f21434f);
                    return;
                }
                e();
            } else if (view == this.f21437i) {
                e();
                c.a.t0.o2.e.a.a(b().getFragments().size() != 1 ? 2 : 1, 2, this.f21434f, "", "");
            }
        }
    }
}
