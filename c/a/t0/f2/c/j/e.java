package c.a.t0.f2.c.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import c.a.t0.f2.c.k.j;
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
/* loaded from: classes7.dex */
public class e extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f17840e;

    /* renamed from: f  reason: collision with root package name */
    public List<j> f17841f;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f17842e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f17843f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f17844g;

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
            this.f17844g = eVar;
            this.f17842e = i2;
            this.f17843f = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c11219").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.f17842e + 1));
                TbPageContext tbPageContext = (TbPageContext) c.a.d.a.j.a(this.f17844g.f17840e);
                if (tbPageContext == null) {
                    return;
                }
                if (!StringUtils.isNull(this.f17843f.d())) {
                    TiebaStatic.log(new StatisticItem("c10445").param("obj_id", this.f17843f.a()));
                    MemberCenterStatic.a(tbPageContext, new String[]{this.f17843f.d(), this.f17843f.b(), this.f17843f.e()});
                }
                if (this.f17843f.c() > 0) {
                    String currentAccount = !TbadkCoreApplication.isLogin() ? SevenZipUtils.FILE_NAME_TEMP : TbadkCoreApplication.getCurrentAccount();
                    c.a.s0.s.g0.b.j().x("member_center_item_red_tip_" + this.f17843f.c() + currentAccount, this.f17843f.h());
                    b bVar = (b) view.getTag();
                    if (bVar != null) {
                        bVar.f17849f.setVisibility(8);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f17845b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f17846c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17847d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f17848e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f17849f;

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
        this.f17840e = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public j getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<j> list = this.f17841f;
            if (list == null || i2 < 0 || i2 >= list.size()) {
                return null;
            }
            return this.f17841f.get(i2);
        }
        return (j) invokeI.objValue;
    }

    public void c(b bVar, j jVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, jVar) == null) || jVar == null || bVar == null) {
            return;
        }
        bVar.f17845b.startLoad(jVar.b(), 10, false);
        bVar.f17846c.startLoad(jVar.e(), 10, false);
        bVar.f17848e.setText(jVar.f());
        bVar.f17847d.setText(jVar.g());
        if (TbadkCoreApplication.isLogin() && jVar.c() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String p = c.a.s0.s.g0.b.j().p("member_center_item_red_tip_" + jVar.c() + currentAccount, "0");
            if (Long.parseLong(StringUtils.isNull(jVar.h()) ? "0" : jVar.h()) > Long.parseLong(StringUtils.isNull(p) ? "0" : p)) {
                if (jVar.i() == 1) {
                    bVar.f17849f.setVisibility(8);
                } else {
                    bVar.f17849f.setVisibility(0);
                }
            } else {
                bVar.f17849f.setVisibility(8);
            }
        } else {
            bVar.f17849f.setVisibility(8);
        }
        TbPageContext tbPageContext = (TbPageContext) c.a.d.a.j.a(this.f17840e);
        if (tbPageContext == null) {
            return;
        }
        tbPageContext.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(bVar.a);
    }

    public void d(List<j> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f17841f = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<j> list = this.f17841f;
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
                view = LayoutInflater.from(this.f17840e).inflate(R.layout.index_dressup_card_item, (ViewGroup) null);
                bVar = new b();
                bVar.a = view.findViewById(R.id.root_card_item_view);
                bVar.f17845b = (TbImageView) view.findViewById(R.id.bg_image);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.permission_icon);
                bVar.f17846c = tbImageView;
                tbImageView.setDefaultResource(R.drawable.transparent_bg);
                bVar.f17846c.setDefaultBgResource(R.drawable.transparent_bg);
                bVar.f17847d = (TextView) view.findViewById(R.id.txt_type);
                bVar.f17848e = (TextView) view.findViewById(R.id.txt_name);
                bVar.f17849f = (TbImageView) view.findViewById(R.id.privilege_new_icon);
            }
            c(bVar, item);
            view.setTag(bVar);
            view.setOnClickListener(new a(this, i2, item));
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
