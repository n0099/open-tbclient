package c.a.q0.f1.e.b;

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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f17450a;

    /* renamed from: b  reason: collision with root package name */
    public View f17451b;

    /* renamed from: c  reason: collision with root package name */
    public GameVideoGridView f17452c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.f1.e.a.b f17453d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f17454e;

    /* renamed from: f  reason: collision with root package name */
    public b f17455f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f17456g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f17457h;

    /* renamed from: c.a.q0.f1.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0844a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f17458e;

        public C0844a(a aVar) {
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
            this.f17458e = aVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f17458e.f17453d == null || i2 >= this.f17458e.f17453d.getCount() || this.f17458e.f17453d.getItem(i2) == null || !(this.f17458e.f17453d.getItem(i2) instanceof c.a.q0.f1.e.c.a)) {
                return;
            }
            c.a.q0.f1.e.c.a aVar = (c.a.q0.f1.e.c.a) this.f17458e.f17453d.getItem(i2);
            if (aVar.f17497d == 1) {
                this.f17458e.f17453d.c(aVar.f17494a);
                if (this.f17458e.f17455f != null) {
                    this.f17458e.f17455f.a(aVar);
                }
                this.f17458e.d();
                c.a.p0.s.d0.b.j().v("key_game_video_tab_has_choosed_sub_class_id", aVar.f17494a);
                c.a.p0.s.d0.b.j().x("key_game_video_tab_has_choosed_sub_class_name", aVar.f17495b);
                TiebaStatic.log(new StatisticItem("c13485").param("obj_type", aVar.f17494a));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(c.a.q0.f1.e.c.a aVar);
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
        this.f17457h = new C0844a(this);
        this.f17450a = tbPageContext;
        this.f17456g = bdUniqueId;
        e();
    }

    public void c(ViewGroup viewGroup) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || viewGroup == null || (view = this.f17451b) == null) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f17451b.getParent()).removeView(this.f17451b);
        }
        viewGroup.addView(this.f17451b);
        TiebaStatic.log("c13484");
    }

    public void d() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (view = this.f17451b) == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f17451b.getParent()).removeView(this.f17451b);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.f17450a.getPageActivity()).inflate(R.layout.game_video_choose_fullscreen_layout, (ViewGroup) null);
            this.f17451b = inflate;
            this.f17452c = (GameVideoGridView) inflate.findViewById(R.id.id_game_video_choose_full_gridview);
            this.f17453d = new c.a.q0.f1.e.a.b(this.f17450a, 101, this.f17456g);
            this.f17452c.setNumColumns(4);
            this.f17452c.setAdapter((ListAdapter) this.f17453d);
            this.f17452c.setOnItemClickListener(this.f17457h);
            this.f17454e = (TextView) this.f17451b.findViewById(R.id.id_game_video_choose_full_title);
            f();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = this.f17454e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            }
            View view = this.f17451b;
            if (view != null) {
                SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
            }
        }
    }

    public void g() {
        GameVideoGridView gameVideoGridView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gameVideoGridView = this.f17452c) == null) {
            return;
        }
        gameVideoGridView.onDestroy();
    }

    public void h(List<c.a.q0.f1.e.c.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f17453d.b(list);
        this.f17453d.notifyDataSetChanged();
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f17455f = bVar;
        }
    }
}
