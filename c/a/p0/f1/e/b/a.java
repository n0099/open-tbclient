package c.a.p0.f1.e.b;

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
    public TbPageContext f17105a;

    /* renamed from: b  reason: collision with root package name */
    public View f17106b;

    /* renamed from: c  reason: collision with root package name */
    public GameVideoGridView f17107c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.f1.e.a.b f17108d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f17109e;

    /* renamed from: f  reason: collision with root package name */
    public b f17110f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f17111g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f17112h;

    /* renamed from: c.a.p0.f1.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0832a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f17113e;

        public C0832a(a aVar) {
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
            this.f17113e = aVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f17113e.f17108d == null || i2 >= this.f17113e.f17108d.getCount() || this.f17113e.f17108d.getItem(i2) == null || !(this.f17113e.f17108d.getItem(i2) instanceof c.a.p0.f1.e.c.a)) {
                return;
            }
            c.a.p0.f1.e.c.a aVar = (c.a.p0.f1.e.c.a) this.f17113e.f17108d.getItem(i2);
            if (aVar.f17152d == 1) {
                this.f17113e.f17108d.c(aVar.f17149a);
                if (this.f17113e.f17110f != null) {
                    this.f17113e.f17110f.a(aVar);
                }
                this.f17113e.d();
                c.a.o0.s.d0.b.j().v("key_game_video_tab_has_choosed_sub_class_id", aVar.f17149a);
                c.a.o0.s.d0.b.j().x("key_game_video_tab_has_choosed_sub_class_name", aVar.f17150b);
                TiebaStatic.log(new StatisticItem("c13485").param("obj_type", aVar.f17149a));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(c.a.p0.f1.e.c.a aVar);
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
        this.f17112h = new C0832a(this);
        this.f17105a = tbPageContext;
        this.f17111g = bdUniqueId;
        e();
    }

    public void c(ViewGroup viewGroup) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || viewGroup == null || (view = this.f17106b) == null) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f17106b.getParent()).removeView(this.f17106b);
        }
        viewGroup.addView(this.f17106b);
        TiebaStatic.log("c13484");
    }

    public void d() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (view = this.f17106b) == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f17106b.getParent()).removeView(this.f17106b);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.f17105a.getPageActivity()).inflate(R.layout.game_video_choose_fullscreen_layout, (ViewGroup) null);
            this.f17106b = inflate;
            this.f17107c = (GameVideoGridView) inflate.findViewById(R.id.id_game_video_choose_full_gridview);
            this.f17108d = new c.a.p0.f1.e.a.b(this.f17105a, 101, this.f17111g);
            this.f17107c.setNumColumns(4);
            this.f17107c.setAdapter((ListAdapter) this.f17108d);
            this.f17107c.setOnItemClickListener(this.f17112h);
            this.f17109e = (TextView) this.f17106b.findViewById(R.id.id_game_video_choose_full_title);
            f();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = this.f17109e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            }
            View view = this.f17106b;
            if (view != null) {
                SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
            }
        }
    }

    public void g() {
        GameVideoGridView gameVideoGridView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gameVideoGridView = this.f17107c) == null) {
            return;
        }
        gameVideoGridView.onDestroy();
    }

    public void h(List<c.a.p0.f1.e.c.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f17108d.b(list);
        this.f17108d.notifyDataSetChanged();
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f17110f = bVar;
        }
    }
}
