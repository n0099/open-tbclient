package c.a.r0.x1.c.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import c.a.r0.x1.c.k.j;
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
    public static int f28477g = 131;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f28478e;

    /* renamed from: f  reason: collision with root package name */
    public List<j> f28479f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f28480e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f28481f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f28482g;

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
            this.f28482g = gVar;
            this.f28480e = jVar;
            this.f28481f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (tbPageContext = (TbPageContext) c.a.e.a.j.a(this.f28482g.f28478e)) == null) {
                return;
            }
            if (this.f28480e.g() == g.f28477g) {
                MemberCenterStatic.b(tbPageContext);
            } else {
                TiebaStatic.log(new StatisticItem("c11218").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.f28481f + 1));
                if (!StringUtils.isNull(this.f28480e.d())) {
                    TiebaStatic.log(new StatisticItem("c10445").param("obj_id", this.f28480e.a()));
                    MemberCenterStatic.a(tbPageContext, new String[]{this.f28480e.d(), this.f28480e.b(), this.f28480e.e()});
                }
            }
            if (this.f28480e.c() > 0) {
                String currentAccount = !TbadkCoreApplication.isLogin() ? SevenZipUtils.FILE_NAME_TEMP : TbadkCoreApplication.getCurrentAccount();
                c.a.q0.s.d0.b.j().x("member_center_item_red_tip_" + this.f28480e.c() + currentAccount, this.f28480e.i());
                b bVar = (b) view.getTag();
                if (bVar != null) {
                    bVar.f28488f.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f28483a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f28484b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f28485c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f28486d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f28487e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f28488f;

        /* renamed from: g  reason: collision with root package name */
        public HeadPendantView f28489g;

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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(31014480, "Lc/a/r0/x1/c/j/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(31014480, "Lc/a/r0/x1/c/j/g;");
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
        this.f28478e = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public j getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<j> list = this.f28479f;
            if (list == null || i2 < 0 || i2 >= list.size()) {
                return null;
            }
            return this.f28479f.get(i2);
        }
        return (j) invokeI.objValue;
    }

    public void c(b bVar, j jVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, jVar) == null) || jVar == null || bVar == null) {
            return;
        }
        if (jVar.g() == f28477g) {
            SkinManager.setBackgroundResource(bVar.f28484b, R.color.CAM_X0204);
            bVar.f28484b.setImageResource(0);
            bVar.f28484b.startLoad("", 10, false);
            bVar.f28489g.setVisibility(0);
            if (bVar.f28489g.getHeadView() != null) {
                if (jVar.k()) {
                    bVar.f28489g.getHeadView().startLoad(String.valueOf(R.drawable.pic_shop_woman), 24, false);
                } else {
                    bVar.f28489g.getHeadView().startLoad(String.valueOf(R.drawable.pic_shop_man), 24, false);
                }
            }
            bVar.f28489g.startLoadPendantUrl(jVar.b());
        } else {
            bVar.f28484b.startLoad(jVar.b(), 10, false);
            bVar.f28489g.setVisibility(8);
        }
        bVar.f28485c.startLoad(jVar.e(), 10, false);
        bVar.f28487e.setText(jVar.f());
        bVar.f28486d.setText(jVar.h());
        if (TbadkCoreApplication.isLogin() && jVar.c() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String p = c.a.q0.s.d0.b.j().p("member_center_item_red_tip_" + jVar.c() + currentAccount, "0");
            if (Long.parseLong(StringUtils.isNull(jVar.i()) ? "0" : jVar.i()) > Long.parseLong(StringUtils.isNull(p) ? "0" : p)) {
                if (jVar.j() == 1) {
                    bVar.f28488f.setVisibility(8);
                } else {
                    bVar.f28488f.setVisibility(0);
                }
            } else {
                bVar.f28488f.setVisibility(8);
            }
        } else {
            bVar.f28488f.setVisibility(8);
        }
        TbPageContext tbPageContext = (TbPageContext) c.a.e.a.j.a(this.f28478e);
        if (tbPageContext == null) {
            return;
        }
        tbPageContext.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(bVar.f28483a);
    }

    public void d(List<j> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f28479f = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<j> list = this.f28479f;
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
                view = LayoutInflater.from(this.f28478e).inflate(R.layout.index_dressup_item, (ViewGroup) null);
                bVar = new b();
                bVar.f28483a = view.findViewById(R.id.root_bg_item_view);
                bVar.f28484b = (TbImageView) view.findViewById(R.id.bg_image);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.permission_icon);
                bVar.f28485c = tbImageView;
                tbImageView.setDefaultResource(R.drawable.transparent_bg);
                bVar.f28485c.setDefaultBgResource(R.drawable.transparent_bg);
                bVar.f28486d = (TextView) view.findViewById(R.id.txt_type);
                bVar.f28487e = (TextView) view.findViewById(R.id.txt_name);
                bVar.f28488f = (TbImageView) view.findViewById(R.id.privilege_new_icon);
                HeadPendantView headPendantView = (HeadPendantView) view.findViewById(R.id.avatar_image);
                bVar.f28489g = headPendantView;
                if (headPendantView.getHeadView() != null) {
                    bVar.f28489g.getHeadView().setIsRound(true);
                    bVar.f28489g.getHeadView().setDrawBorder(false);
                }
                bVar.f28489g.setHasPendantStyle();
                if (bVar.f28489g.getPendantView() != null) {
                    bVar.f28489g.getPendantView().setIsRound(true);
                    bVar.f28489g.getPendantView().setDrawBorder(false);
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
