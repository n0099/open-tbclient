package b.a.r0.h1.e.b;

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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f18564a;

    /* renamed from: b  reason: collision with root package name */
    public View f18565b;

    /* renamed from: c  reason: collision with root package name */
    public GameVideoGridView f18566c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.h1.e.a.b f18567d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f18568e;

    /* renamed from: f  reason: collision with root package name */
    public b f18569f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f18570g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f18571h;

    /* renamed from: b.a.r0.h1.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0945a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f18572e;

        public C0945a(a aVar) {
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
            this.f18572e = aVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f18572e.f18567d == null || i2 >= this.f18572e.f18567d.getCount() || this.f18572e.f18567d.getItem(i2) == null || !(this.f18572e.f18567d.getItem(i2) instanceof b.a.r0.h1.e.c.a)) {
                return;
            }
            b.a.r0.h1.e.c.a aVar = (b.a.r0.h1.e.c.a) this.f18572e.f18567d.getItem(i2);
            if (aVar.f18609d == 1) {
                this.f18572e.f18567d.c(aVar.f18606a);
                if (this.f18572e.f18569f != null) {
                    this.f18572e.f18569f.a(aVar);
                }
                this.f18572e.d();
                b.a.q0.s.e0.b.j().v("key_game_video_tab_has_choosed_sub_class_id", aVar.f18606a);
                b.a.q0.s.e0.b.j().x("key_game_video_tab_has_choosed_sub_class_name", aVar.f18607b);
                TiebaStatic.log(new StatisticItem("c13485").param("obj_type", aVar.f18606a));
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(b.a.r0.h1.e.c.a aVar);
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
        this.f18571h = new C0945a(this);
        this.f18564a = tbPageContext;
        this.f18570g = bdUniqueId;
        e();
    }

    public void c(ViewGroup viewGroup) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || viewGroup == null || (view = this.f18565b) == null) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f18565b.getParent()).removeView(this.f18565b);
        }
        viewGroup.addView(this.f18565b);
        TiebaStatic.log("c13484");
    }

    public void d() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (view = this.f18565b) == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f18565b.getParent()).removeView(this.f18565b);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.f18564a.getPageActivity()).inflate(R.layout.game_video_choose_fullscreen_layout, (ViewGroup) null);
            this.f18565b = inflate;
            this.f18566c = (GameVideoGridView) inflate.findViewById(R.id.id_game_video_choose_full_gridview);
            this.f18567d = new b.a.r0.h1.e.a.b(this.f18564a, 101, this.f18570g);
            this.f18566c.setNumColumns(4);
            this.f18566c.setAdapter((ListAdapter) this.f18567d);
            this.f18566c.setOnItemClickListener(this.f18571h);
            this.f18568e = (TextView) this.f18565b.findViewById(R.id.id_game_video_choose_full_title);
            f();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = this.f18568e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            }
            View view = this.f18565b;
            if (view != null) {
                SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
            }
        }
    }

    public void g() {
        GameVideoGridView gameVideoGridView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gameVideoGridView = this.f18566c) == null) {
            return;
        }
        gameVideoGridView.onDestroy();
    }

    public void h(List<b.a.r0.h1.e.c.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f18567d.b(list);
        this.f18567d.notifyDataSetChanged();
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f18569f = bVar;
        }
    }
}
