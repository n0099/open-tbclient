package c.a.p0.v3.f;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import c.a.o0.r.r.y1;
import c.a.o0.r.x.b.c;
import c.a.o0.r.x.b.d;
import c.a.o0.r.x.b.e;
import c.a.p0.v3.e.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashSet<String> a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<g> f19314b;

    /* renamed from: c  reason: collision with root package name */
    public CoverFlowView<g> f19315c;

    /* renamed from: d  reason: collision with root package name */
    public d<g> f19316d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f19317e;

    /* renamed from: c.a.p0.v3.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1459a implements d<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1459a(a aVar) {
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

        @Override // c.a.o0.r.x.b.d
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                String makeStatisticsParam = SingleSquareActivityConfig.makeStatisticsParam("carousel_recommend", String.valueOf(i));
                g gVar = (g) ListUtils.getItem(this.a.f19314b, i);
                String c2 = gVar != null ? gVar.c() : null;
                if (UrlManager.getInstance().dealOneLink(this.a.f19317e, new String[]{str, null, makeStatisticsParam}) && i == 2 && !TextUtils.isEmpty(c2)) {
                    TiebaStatic.eventStat(this.a.f19317e.getPageActivity(), "tbanner", null, 1, "line", "PT", "page", "OT", "locate", "c0116", "action_type", "CLICK", "task", "tbanner", "obj_id", String.valueOf(c2), "obj_name", String.valueOf(c2), "obj_cpid", 0, TiebaStatic.Params.OBJ_URL, str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", "android", HttpConstants.OS_VERSION, Build.VERSION.RELEASE, "log_ver", "1.1");
                }
                Activity pageActivity = this.a.f19317e.getPageActivity();
                TiebaStatic.eventStat(pageActivity, "square_banner_picture", "click", 1, "loc", (i - 1) + "");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.r.x.b.d
        /* renamed from: c */
        public void a(int i, g gVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, gVar) == null) || gVar == null) {
                return;
            }
            String c2 = gVar.c();
            if (i == 2 && !TextUtils.isEmpty(c2) && this.a.a.add(c2)) {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "OT", "locate", "c0116", "action_type", "VIEW_TRUE", "task", "tbanner", "obj_id", String.valueOf(c2), "obj_name", String.valueOf(c2), "obj_cpid", 0, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", "android", HttpConstants.OS_VERSION, Build.VERSION.RELEASE);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends c.a.o0.r.x.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        public b(a aVar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
        }

        @Override // c.a.o0.r.x.b.b, c.a.o0.r.x.a
        public c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c a = super.a();
                if (a != null) {
                    a.d(85);
                    a.e(R.dimen.obfuscated_res_0x7f0701d5);
                    a.f(R.dimen.obfuscated_res_0x7f070201);
                }
                return a;
            }
            return (c) invokeV.objValue;
        }

        @Override // c.a.o0.r.x.b.b, c.a.o0.r.x.a
        public e c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                e eVar = new e();
                eVar.a(this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07029b));
                return eVar;
            }
            return (e) invokeV.objValue;
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashSet<>();
        this.f19314b = new ArrayList<>();
        this.f19315c = null;
        this.f19316d = new C1459a(this);
        this.f19317e = tbPageContext;
        this.f19315c = new CoverFlowView<>(tbPageContext.getPageActivity());
        this.f19315c.setCoverFlowFactory(new b(this, tbPageContext));
        this.f19315c.setCallback(this.f19316d);
    }

    public CoverFlowView<g> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19315c : (CoverFlowView) invokeV.objValue;
    }

    public void e(int i) {
        CoverFlowView<g> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (coverFlowView = this.f19315c) == null) {
            return;
        }
        coverFlowView.s();
    }

    public void f(ArrayList<y1> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            ArrayList<g> arrayList2 = new ArrayList<>();
            Iterator<y1> it = arrayList.iterator();
            while (it.hasNext()) {
                y1 next = it.next();
                if (next != null) {
                    arrayList2.add(new g(next));
                }
            }
            this.f19314b = arrayList2;
            this.f19315c.setData(arrayList2);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<g> arrayList = this.f19314b;
            return (arrayList != null ? arrayList.size() + 0 : 0) > 0 ? 1 : 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? Integer.valueOf(i) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view, viewGroup)) == null) ? this.f19315c : (View) invokeILL.objValue;
    }
}
