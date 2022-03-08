package c.a.r0.o1.f.b;

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
    public View f19825b;

    /* renamed from: c  reason: collision with root package name */
    public GameVideoGridView f19826c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.o1.f.a.b f19827d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19828e;

    /* renamed from: f  reason: collision with root package name */
    public b f19829f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f19830g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f19831h;

    /* renamed from: c.a.r0.o1.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1241a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19832e;

        public C1241a(a aVar) {
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
            this.f19832e = aVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f19832e.f19827d == null || i2 >= this.f19832e.f19827d.getCount() || this.f19832e.f19827d.getItem(i2) == null || !(this.f19832e.f19827d.getItem(i2) instanceof c.a.r0.o1.f.c.a)) {
                return;
            }
            c.a.r0.o1.f.c.a aVar = (c.a.r0.o1.f.c.a) this.f19832e.f19827d.getItem(i2);
            if (aVar.f19861d == 1) {
                this.f19832e.f19827d.c(aVar.a);
                if (this.f19832e.f19829f != null) {
                    this.f19832e.f19829f.a(aVar);
                }
                this.f19832e.d();
                c.a.q0.r.j0.b.k().w("key_game_video_tab_has_choosed_sub_class_id", aVar.a);
                c.a.q0.r.j0.b.k().y("key_game_video_tab_has_choosed_sub_class_name", aVar.f19859b);
                TiebaStatic.log(new StatisticItem("c13485").param("obj_type", aVar.a));
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(c.a.r0.o1.f.c.a aVar);
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19831h = new C1241a(this);
        this.a = tbPageContext;
        this.f19830g = bdUniqueId;
        e();
    }

    public void c(ViewGroup viewGroup) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || viewGroup == null || (view = this.f19825b) == null) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f19825b.getParent()).removeView(this.f19825b);
        }
        viewGroup.addView(this.f19825b);
        TiebaStatic.log("c13484");
    }

    public void d() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (view = this.f19825b) == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f19825b.getParent()).removeView(this.f19825b);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.game_video_choose_fullscreen_layout, (ViewGroup) null);
            this.f19825b = inflate;
            this.f19826c = (GameVideoGridView) inflate.findViewById(R.id.id_game_video_choose_full_gridview);
            this.f19827d = new c.a.r0.o1.f.a.b(this.a, 101, this.f19830g);
            this.f19826c.setNumColumns(4);
            this.f19826c.setAdapter((ListAdapter) this.f19827d);
            this.f19826c.setOnItemClickListener(this.f19831h);
            this.f19828e = (TextView) this.f19825b.findViewById(R.id.id_game_video_choose_full_title);
            f();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = this.f19828e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            }
            View view = this.f19825b;
            if (view != null) {
                SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
            }
        }
    }

    public void g() {
        GameVideoGridView gameVideoGridView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gameVideoGridView = this.f19826c) == null) {
            return;
        }
        gameVideoGridView.onDestroy();
    }

    public void h(List<c.a.r0.o1.f.c.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f19827d.b(list);
        this.f19827d.notifyDataSetChanged();
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f19829f = bVar;
        }
    }
}
