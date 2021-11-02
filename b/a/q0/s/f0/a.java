package b.a.q0.s.f0;

import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import b.a.e.a.f;
import b.a.e.a.j;
import b.a.e.e.l.c;
import b.a.e.e.l.d;
import b.a.e.e.p.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f12942a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTabHost f12943b;

    /* renamed from: c  reason: collision with root package name */
    public final c<b.a.e.l.d.a> f12944c;

    /* renamed from: b.a.q0.s.f0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0676a extends c<b.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f12945a;

        public C0676a(a aVar) {
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
            this.f12945a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.l.c
        public void onLoaded(b.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((C0676a) aVar, str, i2);
                if (this.f12945a.f12943b == null || aVar == null || !aVar.w()) {
                    this.f12945a.f();
                    return;
                }
                FragmentTabWidget fragmentTabWidget = this.f12945a.f12943b.getFragmentTabWidget();
                CustomViewPager fragmentViewPager = this.f12945a.f12943b.getFragmentViewPager();
                ViewGroup tabWrapper = this.f12945a.f12943b.getTabWrapper();
                if (fragmentTabWidget == null || fragmentViewPager == null) {
                    return;
                }
                this.f12945a.f12943b.setNeedShowThemeStyle(false);
                fragmentTabWidget.setBackGroundDrawableResId(R.color.black_alpha0);
                SkinManager.setBackgroundColor(tabWrapper, R.color.black_alpha0);
                SkinManager.setBackgroundColor(fragmentTabWidget, R.color.black_alpha0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fragmentViewPager.getLayoutParams();
                layoutParams.bottomMargin = l.g(this.f12945a.f12943b.getContext(), R.dimen.tbds100);
                fragmentViewPager.setLayoutParams(layoutParams);
                fragmentTabWidget.setBackgroundDrawable(new BitmapDrawable(aVar.p()));
            }
        }
    }

    public a(FragmentTabHost fragmentTabHost, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentTabHost, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12942a = 0;
        this.f12944c = new C0676a(this);
        this.f12943b = fragmentTabHost;
        this.f12942a = i2;
    }

    public final BdUniqueId c() {
        InterceptResult invokeV;
        f<?> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FragmentTabHost fragmentTabHost = this.f12943b;
            if (fragmentTabHost == null || fragmentTabHost.getContext() == null || (a2 = j.a(this.f12943b.getContext())) == null) {
                return null;
            }
            return a2.getUniqueId();
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            d.h().m(str, 10, this.f12944c, c());
        }
    }

    public void e(Pair<String, String> pair) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pair) == null) || pair == null) {
            return;
        }
        String str = (String) pair.first;
        String str2 = (String) pair.second;
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(str2)) {
            d(str2);
        } else if (!TextUtils.isEmpty(str)) {
            d(str);
        } else {
            f();
        }
    }

    public final void f() {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (fragmentTabHost = this.f12943b) == null || fragmentTabHost.getFragmentTabWidget() == null) {
            return;
        }
        this.f12943b.getFragmentTabWidget().setBackGroundDrawableResId(this.f12942a);
        SkinManager.setBackgroundColor(this.f12943b.getFragmentTabWidget(), this.f12942a);
        SkinManager.setBackgroundColor(this.f12943b.getTabWrapper(), this.f12942a);
    }
}
