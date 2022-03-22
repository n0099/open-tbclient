package c.a.p0.s2.h;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import c.a.o0.r.v.c;
import c.a.p0.s2.c.b;
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
    public BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public int f18249b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f18250c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<Integer> f18251d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f18252e;

    /* renamed from: f  reason: collision with root package name */
    public View f18253f;

    /* renamed from: g  reason: collision with root package name */
    public View f18254g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18255h;
    public NavigationBar i;
    public BaseInterestedForumFragment j;
    public BaseInterestSelectionFragment k;

    public a(BaseFragmentActivity baseFragmentActivity, int i, boolean z, ArrayList<Integer> arrayList, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, Integer.valueOf(i), Boolean.valueOf(z), arrayList, strArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = baseFragmentActivity;
        this.f18249b = i;
        this.f18250c = z;
        this.f18251d = arrayList;
        this.f18252e = strArr;
        f();
        g();
    }

    @Override // com.baidu.tieba.newinterest.fragment.BaseInterestSelectionFragment.a
    public void a(List<b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            if (UbsABTestHelper.isInterestGuideStyleAOrB()) {
                this.j = InterestedForumStyleAFragment.I0(this.f18249b, this.f18252e);
            } else {
                this.j = InterestedForumFragment.H0(this.f18249b, this.f18252e);
            }
            this.j.F0(list);
            b().beginTransaction().add(R.id.obfuscated_res_0x7f0906df, this.j).addToBackStack(null).commitAllowingStateLoss();
            c.a.p0.s2.e.a.a(b().getFragments().size() == 1 ? 1 : 2, 1, this.f18249b, c(list), "");
        }
    }

    public final FragmentManager b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getSupportFragmentManager() : (FragmentManager) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18253f : (View) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 1);
            TiebaStatic.log(statisticItem);
            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.a).createNormalCfg(0)));
        }
    }

    public final void f() {
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d003c, (ViewGroup) null);
            this.f18253f = inflate;
            this.i = (NavigationBar) inflate.findViewById(R.id.obfuscated_res_0x7f091519);
            if (UbsABTestHelper.isInterestGuideStyleB()) {
                c.d(this.i).f(R.color.CAM_X0206);
            }
            TextView addTextButton = this.i.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(R.string.obfuscated_res_0x7f0f117c));
            this.f18255h = addTextButton;
            addTextButton.setId(R.id.obfuscated_res_0x7f090438);
            if (!UbsABTestHelper.isInterestGuideStyleA() && !UbsABTestHelper.isInterestGuideStyleB()) {
                SkinManager.setViewTextColor(this.f18255h, (int) R.color.CAM_X0107);
            } else {
                SkinManager.setViewTextColor(this.f18255h, (int) R.color.CAM_X0108);
            }
            this.f18254g = this.i.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            if (this.f18250c) {
                if (UbsABTestHelper.isInterestGuideStyleAOrB()) {
                    this.j = InterestedForumStyleAFragment.H0(this.f18249b, this.f18250c, this.f18252e);
                } else {
                    this.j = InterestedForumFragment.G0(this.f18249b, this.f18250c, this.f18252e);
                }
                List<b> j = j();
                if (j != null) {
                    this.j.F0(j);
                }
                fragment = this.j;
                this.f18254g.setVisibility(4);
            } else {
                if (UbsABTestHelper.isInterestGuideStyleA()) {
                    this.k = InterestSelectionStyleAFragment.G0(this.f18249b, this.f18252e);
                } else if (UbsABTestHelper.isInterestGuideStyleB()) {
                    this.k = InterestSelectionStyleBFragment.G0(this.f18249b, this.f18252e);
                } else {
                    this.k = InterestSelectionFragment.G0(this.f18249b, this.f18252e);
                }
                fragment = this.k;
            }
            b().beginTransaction().add(R.id.obfuscated_res_0x7f0906df, fragment).commitAllowingStateLoss();
            TiebaStatic.log(new StatisticItem("c13681"));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f18255h.setOnClickListener(this);
            this.f18254g.setOnClickListener(this);
            BaseInterestSelectionFragment baseInterestSelectionFragment = this.k;
            if (baseInterestSelectionFragment != null) {
                baseInterestSelectionFragment.F0(this);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && b().getFragments().size() == 1) {
            c.a.p0.s2.e.a.c(1, this.f18249b);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SkinManager.setBackgroundColor(this.f18253f, R.color.CAM_X0201);
        }
    }

    public final List<b> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (ListUtils.isEmpty(this.f18251d)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<Integer> it = this.f18251d.iterator();
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
            if (view == this.f18254g && this.a != null) {
                BaseInterestedForumFragment baseInterestedForumFragment = this.j;
                if (baseInterestedForumFragment != null && baseInterestedForumFragment.isVisible()) {
                    b().popBackStack();
                    c.a.p0.s2.e.a.c(1, this.f18249b);
                    return;
                }
                e();
            } else if (view == this.f18255h) {
                e();
                c.a.p0.s2.e.a.a(b().getFragments().size() != 1 ? 2 : 1, 2, this.f18249b, "", "");
            }
        }
    }
}
