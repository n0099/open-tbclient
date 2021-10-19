package c.a.r0.h1.e.b;

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
    public TbPageContext f18152a;

    /* renamed from: b  reason: collision with root package name */
    public View f18153b;

    /* renamed from: c  reason: collision with root package name */
    public GameVideoGridView f18154c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.h1.e.a.b f18155d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f18156e;

    /* renamed from: f  reason: collision with root package name */
    public b f18157f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f18158g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f18159h;

    /* renamed from: c.a.r0.h1.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0882a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f18160e;

        public C0882a(a aVar) {
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
            this.f18160e = aVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f18160e.f18155d == null || i2 >= this.f18160e.f18155d.getCount() || this.f18160e.f18155d.getItem(i2) == null || !(this.f18160e.f18155d.getItem(i2) instanceof c.a.r0.h1.e.c.a)) {
                return;
            }
            c.a.r0.h1.e.c.a aVar = (c.a.r0.h1.e.c.a) this.f18160e.f18155d.getItem(i2);
            if (aVar.f18199d == 1) {
                this.f18160e.f18155d.c(aVar.f18196a);
                if (this.f18160e.f18157f != null) {
                    this.f18160e.f18157f.a(aVar);
                }
                this.f18160e.d();
                c.a.q0.s.d0.b.j().v("key_game_video_tab_has_choosed_sub_class_id", aVar.f18196a);
                c.a.q0.s.d0.b.j().x("key_game_video_tab_has_choosed_sub_class_name", aVar.f18197b);
                TiebaStatic.log(new StatisticItem("c13485").param("obj_type", aVar.f18196a));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(c.a.r0.h1.e.c.a aVar);
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
        this.f18159h = new C0882a(this);
        this.f18152a = tbPageContext;
        this.f18158g = bdUniqueId;
        e();
    }

    public void c(ViewGroup viewGroup) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || viewGroup == null || (view = this.f18153b) == null) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f18153b.getParent()).removeView(this.f18153b);
        }
        viewGroup.addView(this.f18153b);
        TiebaStatic.log("c13484");
    }

    public void d() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (view = this.f18153b) == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f18153b.getParent()).removeView(this.f18153b);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.f18152a.getPageActivity()).inflate(R.layout.game_video_choose_fullscreen_layout, (ViewGroup) null);
            this.f18153b = inflate;
            this.f18154c = (GameVideoGridView) inflate.findViewById(R.id.id_game_video_choose_full_gridview);
            this.f18155d = new c.a.r0.h1.e.a.b(this.f18152a, 101, this.f18158g);
            this.f18154c.setNumColumns(4);
            this.f18154c.setAdapter((ListAdapter) this.f18155d);
            this.f18154c.setOnItemClickListener(this.f18159h);
            this.f18156e = (TextView) this.f18153b.findViewById(R.id.id_game_video_choose_full_title);
            f();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = this.f18156e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            }
            View view = this.f18153b;
            if (view != null) {
                SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
            }
        }
    }

    public void g() {
        GameVideoGridView gameVideoGridView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gameVideoGridView = this.f18154c) == null) {
            return;
        }
        gameVideoGridView.onDestroy();
    }

    public void h(List<c.a.r0.h1.e.c.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f18155d.b(list);
        this.f18155d.notifyDataSetChanged();
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f18157f = bVar;
        }
    }
}
