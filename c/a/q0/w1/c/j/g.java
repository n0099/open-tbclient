package c.a.q0.w1.c.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import c.a.q0.w1.c.k.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.util.List;
/* loaded from: classes4.dex */
public class g extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static int f27770g = 131;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f27771e;

    /* renamed from: f  reason: collision with root package name */
    public List<j> f27772f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f27773e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f27774f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f27775g;

        public a(g gVar, j jVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, jVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27775g = gVar;
            this.f27773e = jVar;
            this.f27774f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (tbPageContext = (TbPageContext) c.a.e.a.j.a(this.f27775g.f27771e)) == null) {
                return;
            }
            if (this.f27773e.g() == g.f27770g) {
                MemberCenterStatic.b(tbPageContext);
            } else {
                TiebaStatic.log(new StatisticItem("c11218").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.f27774f + 1));
                if (!StringUtils.isNull(this.f27773e.d())) {
                    TiebaStatic.log(new StatisticItem("c10445").param("obj_id", this.f27773e.a()));
                    MemberCenterStatic.a(tbPageContext, new String[]{this.f27773e.d(), this.f27773e.b(), this.f27773e.e()});
                }
            }
            if (this.f27773e.c() > 0) {
                String currentAccount = !TbadkCoreApplication.isLogin() ? SevenZipUtils.FILE_NAME_TEMP : TbadkCoreApplication.getCurrentAccount();
                c.a.p0.s.d0.b.j().x("member_center_item_red_tip_" + this.f27773e.c() + currentAccount, this.f27773e.i());
                b bVar = (b) view.getTag();
                if (bVar != null) {
                    bVar.f27781f.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f27776a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f27777b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f27778c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f27779d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f27780e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f27781f;

        /* renamed from: g  reason: collision with root package name */
        public HeadPendantView f27782g;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1709386224, "Lc/a/q0/w1/c/j/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1709386224, "Lc/a/q0/w1/c/j/g;");
        }
    }

    public g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27771e = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public j getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<j> list = this.f27772f;
            if (list == null || i2 < 0 || i2 >= list.size()) {
                return null;
            }
            return this.f27772f.get(i2);
        }
        return (j) invokeI.objValue;
    }

    public void c(b bVar, j jVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, jVar) == null) || jVar == null || bVar == null) {
            return;
        }
        if (jVar.g() == f27770g) {
            SkinManager.setBackgroundResource(bVar.f27777b, R.color.CAM_X0204);
            bVar.f27777b.setImageResource(0);
            bVar.f27777b.startLoad("", 10, false);
            bVar.f27782g.setVisibility(0);
            if (bVar.f27782g.getHeadView() != null) {
                if (jVar.k()) {
                    bVar.f27782g.getHeadView().startLoad(String.valueOf(R.drawable.pic_shop_woman), 24, false);
                } else {
                    bVar.f27782g.getHeadView().startLoad(String.valueOf(R.drawable.pic_shop_man), 24, false);
                }
            }
            bVar.f27782g.startLoadPendantUrl(jVar.b());
        } else {
            bVar.f27777b.startLoad(jVar.b(), 10, false);
            bVar.f27782g.setVisibility(8);
        }
        bVar.f27778c.startLoad(jVar.e(), 10, false);
        bVar.f27780e.setText(jVar.f());
        bVar.f27779d.setText(jVar.h());
        if (TbadkCoreApplication.isLogin() && jVar.c() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String p = c.a.p0.s.d0.b.j().p("member_center_item_red_tip_" + jVar.c() + currentAccount, "0");
            if (Long.parseLong(StringUtils.isNull(jVar.i()) ? "0" : jVar.i()) > Long.parseLong(StringUtils.isNull(p) ? "0" : p)) {
                if (jVar.j() == 1) {
                    bVar.f27781f.setVisibility(8);
                } else {
                    bVar.f27781f.setVisibility(0);
                }
            } else {
                bVar.f27781f.setVisibility(8);
            }
        } else {
            bVar.f27781f.setVisibility(8);
        }
        TbPageContext tbPageContext = (TbPageContext) c.a.e.a.j.a(this.f27771e);
        if (tbPageContext == null) {
            return;
        }
        tbPageContext.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(bVar.f27776a);
    }

    public void d(List<j> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f27772f = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<j> list = this.f27772f;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            j item = getItem(i2);
            if (item == null) {
                return view;
            }
            if (view != null && (view.getTag() instanceof b)) {
                bVar = (b) view.getTag();
            } else {
                view = LayoutInflater.from(this.f27771e).inflate(R.layout.index_dressup_item, (ViewGroup) null);
                bVar = new b();
                bVar.f27776a = view.findViewById(R.id.root_bg_item_view);
                bVar.f27777b = (TbImageView) view.findViewById(R.id.bg_image);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.permission_icon);
                bVar.f27778c = tbImageView;
                tbImageView.setDefaultResource(R.drawable.transparent_bg);
                bVar.f27778c.setDefaultBgResource(R.drawable.transparent_bg);
                bVar.f27779d = (TextView) view.findViewById(R.id.txt_type);
                bVar.f27780e = (TextView) view.findViewById(R.id.txt_name);
                bVar.f27781f = (TbImageView) view.findViewById(R.id.privilege_new_icon);
                HeadPendantView headPendantView = (HeadPendantView) view.findViewById(R.id.avatar_image);
                bVar.f27782g = headPendantView;
                if (headPendantView.getHeadView() != null) {
                    bVar.f27782g.getHeadView().setIsRound(true);
                    bVar.f27782g.getHeadView().setDrawBorder(false);
                }
                bVar.f27782g.setHasPendantStyle();
                if (bVar.f27782g.getPendantView() != null) {
                    bVar.f27782g.getPendantView().setIsRound(true);
                    bVar.f27782g.getPendantView().setDrawBorder(false);
                }
            }
            c(bVar, item);
            view.setTag(bVar);
            view.setOnClickListener(new a(this, item, i2));
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
