package c.a.r0.g1.e.b;

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
    public TbPageContext f17974a;

    /* renamed from: b  reason: collision with root package name */
    public View f17975b;

    /* renamed from: c  reason: collision with root package name */
    public GameVideoGridView f17976c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.g1.e.a.b f17977d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f17978e;

    /* renamed from: f  reason: collision with root package name */
    public b f17979f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f17980g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f17981h;

    /* renamed from: c.a.r0.g1.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0875a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f17982e;

        public C0875a(a aVar) {
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
            this.f17982e = aVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f17982e.f17977d == null || i2 >= this.f17982e.f17977d.getCount() || this.f17982e.f17977d.getItem(i2) == null || !(this.f17982e.f17977d.getItem(i2) instanceof c.a.r0.g1.e.c.a)) {
                return;
            }
            c.a.r0.g1.e.c.a aVar = (c.a.r0.g1.e.c.a) this.f17982e.f17977d.getItem(i2);
            if (aVar.f18021d == 1) {
                this.f17982e.f17977d.c(aVar.f18018a);
                if (this.f17982e.f17979f != null) {
                    this.f17982e.f17979f.a(aVar);
                }
                this.f17982e.d();
                c.a.q0.s.d0.b.j().v("key_game_video_tab_has_choosed_sub_class_id", aVar.f18018a);
                c.a.q0.s.d0.b.j().x("key_game_video_tab_has_choosed_sub_class_name", aVar.f18019b);
                TiebaStatic.log(new StatisticItem("c13485").param("obj_type", aVar.f18018a));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(c.a.r0.g1.e.c.a aVar);
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
        this.f17981h = new C0875a(this);
        this.f17974a = tbPageContext;
        this.f17980g = bdUniqueId;
        e();
    }

    public void c(ViewGroup viewGroup) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || viewGroup == null || (view = this.f17975b) == null) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f17975b.getParent()).removeView(this.f17975b);
        }
        viewGroup.addView(this.f17975b);
        TiebaStatic.log("c13484");
    }

    public void d() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (view = this.f17975b) == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f17975b.getParent()).removeView(this.f17975b);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.f17974a.getPageActivity()).inflate(R.layout.game_video_choose_fullscreen_layout, (ViewGroup) null);
            this.f17975b = inflate;
            this.f17976c = (GameVideoGridView) inflate.findViewById(R.id.id_game_video_choose_full_gridview);
            this.f17977d = new c.a.r0.g1.e.a.b(this.f17974a, 101, this.f17980g);
            this.f17976c.setNumColumns(4);
            this.f17976c.setAdapter((ListAdapter) this.f17977d);
            this.f17976c.setOnItemClickListener(this.f17981h);
            this.f17978e = (TextView) this.f17975b.findViewById(R.id.id_game_video_choose_full_title);
            f();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = this.f17978e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            }
            View view = this.f17975b;
            if (view != null) {
                SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
            }
        }
    }

    public void g() {
        GameVideoGridView gameVideoGridView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gameVideoGridView = this.f17976c) == null) {
            return;
        }
        gameVideoGridView.onDestroy();
    }

    public void h(List<c.a.r0.g1.e.c.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f17977d.b(list);
        this.f17977d.notifyDataSetChanged();
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f17979f = bVar;
        }
    }
}
