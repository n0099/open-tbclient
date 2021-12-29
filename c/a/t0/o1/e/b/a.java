package c.a.t0.o1.e.b;

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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f20836b;

    /* renamed from: c  reason: collision with root package name */
    public GameVideoGridView f20837c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.o1.e.a.b f20838d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f20839e;

    /* renamed from: f  reason: collision with root package name */
    public b f20840f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f20841g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f20842h;

    /* renamed from: c.a.t0.o1.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1258a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20843e;

        public C1258a(a aVar) {
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
            this.f20843e = aVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f20843e.f20838d == null || i2 >= this.f20843e.f20838d.getCount() || this.f20843e.f20838d.getItem(i2) == null || !(this.f20843e.f20838d.getItem(i2) instanceof c.a.t0.o1.e.c.a)) {
                return;
            }
            c.a.t0.o1.e.c.a aVar = (c.a.t0.o1.e.c.a) this.f20843e.f20838d.getItem(i2);
            if (aVar.f20874d == 1) {
                this.f20843e.f20838d.c(aVar.a);
                if (this.f20843e.f20840f != null) {
                    this.f20843e.f20840f.a(aVar);
                }
                this.f20843e.d();
                c.a.s0.s.g0.b.j().v("key_game_video_tab_has_choosed_sub_class_id", aVar.a);
                c.a.s0.s.g0.b.j().x("key_game_video_tab_has_choosed_sub_class_name", aVar.f20872b);
                TiebaStatic.log(new StatisticItem("c13485").param("obj_type", aVar.a));
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(c.a.t0.o1.e.c.a aVar);
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
        this.f20842h = new C1258a(this);
        this.a = tbPageContext;
        this.f20841g = bdUniqueId;
        e();
    }

    public void c(ViewGroup viewGroup) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || viewGroup == null || (view = this.f20836b) == null) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f20836b.getParent()).removeView(this.f20836b);
        }
        viewGroup.addView(this.f20836b);
        TiebaStatic.log("c13484");
    }

    public void d() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (view = this.f20836b) == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f20836b.getParent()).removeView(this.f20836b);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.game_video_choose_fullscreen_layout, (ViewGroup) null);
            this.f20836b = inflate;
            this.f20837c = (GameVideoGridView) inflate.findViewById(R.id.id_game_video_choose_full_gridview);
            this.f20838d = new c.a.t0.o1.e.a.b(this.a, 101, this.f20841g);
            this.f20837c.setNumColumns(4);
            this.f20837c.setAdapter((ListAdapter) this.f20838d);
            this.f20837c.setOnItemClickListener(this.f20842h);
            this.f20839e = (TextView) this.f20836b.findViewById(R.id.id_game_video_choose_full_title);
            f();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = this.f20839e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            }
            View view = this.f20836b;
            if (view != null) {
                SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
            }
        }
    }

    public void g() {
        GameVideoGridView gameVideoGridView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gameVideoGridView = this.f20837c) == null) {
            return;
        }
        gameVideoGridView.onDestroy();
    }

    public void h(List<c.a.t0.o1.e.c.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f20838d.b(list);
        this.f20838d.notifyDataSetChanged();
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f20840f = bVar;
        }
    }
}
