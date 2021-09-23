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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f28463e;

    /* renamed from: f  reason: collision with root package name */
    public List<j> f28464f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f28465e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f28466f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f28467g;

        public a(e eVar, int i2, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2), jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28467g = eVar;
            this.f28465e = i2;
            this.f28466f = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c11219").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.f28465e + 1));
                TbPageContext tbPageContext = (TbPageContext) c.a.e.a.j.a(this.f28467g.f28463e);
                if (tbPageContext == null) {
                    return;
                }
                if (!StringUtils.isNull(this.f28466f.d())) {
                    TiebaStatic.log(new StatisticItem("c10445").param("obj_id", this.f28466f.a()));
                    MemberCenterStatic.a(tbPageContext, new String[]{this.f28466f.d(), this.f28466f.b(), this.f28466f.e()});
                }
                if (this.f28466f.c() > 0) {
                    String currentAccount = !TbadkCoreApplication.isLogin() ? SevenZipUtils.FILE_NAME_TEMP : TbadkCoreApplication.getCurrentAccount();
                    c.a.q0.s.d0.b.j().x("member_center_item_red_tip_" + this.f28466f.c() + currentAccount, this.f28466f.i());
                    b bVar = (b) view.getTag();
                    if (bVar != null) {
                        bVar.f28473f.setVisibility(8);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f28468a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f28469b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f28470c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f28471d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f28472e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f28473f;

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

    public e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28463e = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public j getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<j> list = this.f28464f;
            if (list == null || i2 < 0 || i2 >= list.size()) {
                return null;
            }
            return this.f28464f.get(i2);
        }
        return (j) invokeI.objValue;
    }

    public void c(b bVar, j jVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, jVar) == null) || jVar == null || bVar == null) {
            return;
        }
        bVar.f28469b.startLoad(jVar.b(), 10, false);
        bVar.f28470c.startLoad(jVar.e(), 10, false);
        bVar.f28472e.setText(jVar.f());
        bVar.f28471d.setText(jVar.h());
        if (TbadkCoreApplication.isLogin() && jVar.c() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String p = c.a.q0.s.d0.b.j().p("member_center_item_red_tip_" + jVar.c() + currentAccount, "0");
            if (Long.parseLong(StringUtils.isNull(jVar.i()) ? "0" : jVar.i()) > Long.parseLong(StringUtils.isNull(p) ? "0" : p)) {
                if (jVar.j() == 1) {
                    bVar.f28473f.setVisibility(8);
                } else {
                    bVar.f28473f.setVisibility(0);
                }
            } else {
                bVar.f28473f.setVisibility(8);
            }
        } else {
            bVar.f28473f.setVisibility(8);
        }
        TbPageContext tbPageContext = (TbPageContext) c.a.e.a.j.a(this.f28463e);
        if (tbPageContext == null) {
            return;
        }
        tbPageContext.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(bVar.f28468a);
    }

    public void d(List<j> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f28464f = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<j> list = this.f28464f;
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
                view = LayoutInflater.from(this.f28463e).inflate(R.layout.index_dressup_card_item, (ViewGroup) null);
                bVar = new b();
                bVar.f28468a = view.findViewById(R.id.root_card_item_view);
                bVar.f28469b = (TbImageView) view.findViewById(R.id.bg_image);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.permission_icon);
                bVar.f28470c = tbImageView;
                tbImageView.setDefaultResource(R.drawable.transparent_bg);
                bVar.f28470c.setDefaultBgResource(R.drawable.transparent_bg);
                bVar.f28471d = (TextView) view.findViewById(R.id.txt_type);
                bVar.f28472e = (TextView) view.findViewById(R.id.txt_name);
                bVar.f28473f = (TbImageView) view.findViewById(R.id.privilege_new_icon);
            }
            c(bVar, item);
            view.setTag(bVar);
            view.setOnClickListener(new a(this, i2, item));
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
