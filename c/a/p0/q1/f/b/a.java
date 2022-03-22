package c.a.p0.q1.f.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoGridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f17262b;

    /* renamed from: c  reason: collision with root package name */
    public GameVideoGridView f17263c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.q1.f.a.b f17264d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f17265e;

    /* renamed from: f  reason: collision with root package name */
    public b f17266f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f17267g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f17268h;

    /* renamed from: c.a.p0.q1.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1295a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1295a(a aVar) {
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

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.f17264d == null || i >= this.a.f17264d.getCount() || this.a.f17264d.getItem(i) == null || !(this.a.f17264d.getItem(i) instanceof c.a.p0.q1.f.c.a)) {
                return;
            }
            c.a.p0.q1.f.c.a aVar = (c.a.p0.q1.f.c.a) this.a.f17264d.getItem(i);
            if (aVar.f17285d == 1) {
                this.a.f17264d.c(aVar.a);
                if (this.a.f17266f != null) {
                    this.a.f17266f.a(aVar);
                }
                this.a.d();
                c.a.o0.r.j0.b.k().w("key_game_video_tab_has_choosed_sub_class_id", aVar.a);
                c.a.o0.r.j0.b.k().y("key_game_video_tab_has_choosed_sub_class_name", aVar.f17283b);
                TiebaStatic.log(new StatisticItem("c13485").param("obj_type", aVar.a));
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(c.a.p0.q1.f.c.a aVar);
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17268h = new C1295a(this);
        this.a = tbPageContext;
        this.f17267g = bdUniqueId;
        e();
    }

    public void c(ViewGroup viewGroup) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || viewGroup == null || (view = this.f17262b) == null) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f17262b.getParent()).removeView(this.f17262b);
        }
        viewGroup.addView(this.f17262b);
        TiebaStatic.log("c13484");
    }

    public void d() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (view = this.f17262b) == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f17262b.getParent()).removeView(this.f17262b);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d037e, (ViewGroup) null);
            this.f17262b = inflate;
            this.f17263c = (GameVideoGridView) inflate.findViewById(R.id.obfuscated_res_0x7f090e27);
            this.f17264d = new c.a.p0.q1.f.a.b(this.a, 101, this.f17267g);
            this.f17263c.setNumColumns(4);
            this.f17263c.setAdapter((ListAdapter) this.f17264d);
            this.f17263c.setOnItemClickListener(this.f17268h);
            this.f17265e = (TextView) this.f17262b.findViewById(R.id.obfuscated_res_0x7f090e28);
            f();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = this.f17265e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            }
            View view = this.f17262b;
            if (view != null) {
                SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
            }
        }
    }

    public void g() {
        GameVideoGridView gameVideoGridView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gameVideoGridView = this.f17263c) == null) {
            return;
        }
        gameVideoGridView.d();
    }

    public void h(List<c.a.p0.q1.f.c.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f17264d.b(list);
        this.f17264d.notifyDataSetChanged();
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f17266f = bVar;
        }
    }
}
