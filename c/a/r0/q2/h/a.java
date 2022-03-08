package c.a.r0.q2.h;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import c.a.q0.r.v.c;
import c.a.r0.q2.c.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener, BaseInterestSelectionFragment.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f21098e;

    /* renamed from: f  reason: collision with root package name */
    public int f21099f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21100g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Integer> f21101h;

    /* renamed from: i  reason: collision with root package name */
    public String[] f21102i;

    /* renamed from: j  reason: collision with root package name */
    public View f21103j;
    public View k;
    public TextView l;
    public NavigationBar m;
    public BaseInterestedForumFragment n;
    public BaseInterestSelectionFragment o;

    public a(BaseFragmentActivity baseFragmentActivity, int i2, boolean z, ArrayList<Integer> arrayList, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, Integer.valueOf(i2), Boolean.valueOf(z), arrayList, strArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21098e = baseFragmentActivity;
        this.f21099f = i2;
        this.f21100g = z;
        this.f21101h = arrayList;
        this.f21102i = strArr;
        f();
        g();
    }

    @Override // com.baidu.tieba.newinterest.fragment.BaseInterestSelectionFragment.a
    public void a(List<b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            if (UbsABTestHelper.isInterestGuideStyleAOrB()) {
                this.n = InterestedForumStyleAFragment.getInstance(this.f21099f, this.f21102i);
            } else {
                this.n = InterestedForumFragment.getInstance(this.f21099f, this.f21102i);
            }
            this.n.setSelectedInterest(list);
            b().beginTransaction().add(R.id.content_container, this.n).addToBackStack(null).commitAllowingStateLoss();
            c.a.r0.q2.e.a.a(b().getFragments().size() == 1 ? 1 : 2, 1, this.f21099f, c(list), "");
        }
    }

    public final FragmentManager b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21098e.getSupportFragmentManager() : (FragmentManager) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21103j : (View) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 1);
            TiebaStatic.log(statisticItem);
            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.f21098e).createNormalCfg(0)));
        }
    }

    public final void f() {
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View inflate = LayoutInflater.from(this.f21098e).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
            this.f21103j = inflate;
            this.m = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
            if (UbsABTestHelper.isInterestGuideStyleB()) {
                c.d(this.m).f(R.color.CAM_X0206);
            }
            TextView addTextButton = this.m.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f21098e.getString(R.string.skip));
            this.l = addTextButton;
            addTextButton.setId(R.id.btn_skip);
            if (!UbsABTestHelper.isInterestGuideStyleA() && !UbsABTestHelper.isInterestGuideStyleB()) {
                SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0107);
            } else {
                SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0108);
            }
            this.k = this.m.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            if (this.f21100g) {
                if (UbsABTestHelper.isInterestGuideStyleAOrB()) {
                    this.n = InterestedForumStyleAFragment.getInstance(this.f21099f, this.f21100g, this.f21102i);
                } else {
                    this.n = InterestedForumFragment.getInstance(this.f21099f, this.f21100g, this.f21102i);
                }
                List<b> j2 = j();
                if (j2 != null) {
                    this.n.setSelectedInterest(j2);
                }
                fragment = this.n;
                this.k.setVisibility(4);
            } else {
                if (UbsABTestHelper.isInterestGuideStyleA()) {
                    this.o = InterestSelectionStyleAFragment.getInstance(this.f21099f, this.f21102i);
                } else if (UbsABTestHelper.isInterestGuideStyleB()) {
                    this.o = InterestSelectionStyleBFragment.getInstance(this.f21099f, this.f21102i);
                } else {
                    this.o = InterestSelectionFragment.getInstance(this.f21099f, this.f21102i);
                }
                fragment = this.o;
            }
            b().beginTransaction().add(R.id.content_container, fragment).commitAllowingStateLoss();
            TiebaStatic.log(new StatisticItem("c13681"));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l.setOnClickListener(this);
            this.k.setOnClickListener(this);
            BaseInterestSelectionFragment baseInterestSelectionFragment = this.o;
            if (baseInterestSelectionFragment != null) {
                baseInterestSelectionFragment.setNextStepClickListener(this);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && b().getFragments().size() == 1) {
            c.a.r0.q2.e.a.c(1, this.f21099f);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SkinManager.setBackgroundColor(this.f21103j, R.color.CAM_X0201);
        }
    }

    public final List<b> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (ListUtils.isEmpty(this.f21101h)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<Integer> it = this.f21101h.iterator();
            while (it.hasNext()) {
                b bVar = new b();
                bVar.k(it.next().intValue());
                arrayList.add(bVar);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            if (view == this.k && this.f21098e != null) {
                BaseInterestedForumFragment baseInterestedForumFragment = this.n;
                if (baseInterestedForumFragment != null && baseInterestedForumFragment.isVisible()) {
                    b().popBackStack();
                    c.a.r0.q2.e.a.c(1, this.f21099f);
                    return;
                }
                e();
            } else if (view == this.l) {
                e();
                c.a.r0.q2.e.a.a(b().getFragments().size() != 1 ? 2 : 1, 2, this.f21099f, "", "");
            }
        }
    }
}
