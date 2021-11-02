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
    public TbPageContext f17096a;

    /* renamed from: b  reason: collision with root package name */
    public View f17097b;

    /* renamed from: c  reason: collision with root package name */
    public GameVideoGridView f17098c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.h1.e.a.b f17099d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f17100e;

    /* renamed from: f  reason: collision with root package name */
    public b f17101f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f17102g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f17103h;

    /* renamed from: b.a.r0.h1.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0877a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f17104e;

        public C0877a(a aVar) {
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
            this.f17104e = aVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f17104e.f17099d == null || i2 >= this.f17104e.f17099d.getCount() || this.f17104e.f17099d.getItem(i2) == null || !(this.f17104e.f17099d.getItem(i2) instanceof b.a.r0.h1.e.c.a)) {
                return;
            }
            b.a.r0.h1.e.c.a aVar = (b.a.r0.h1.e.c.a) this.f17104e.f17099d.getItem(i2);
            if (aVar.f17141d == 1) {
                this.f17104e.f17099d.c(aVar.f17138a);
                if (this.f17104e.f17101f != null) {
                    this.f17104e.f17101f.a(aVar);
                }
                this.f17104e.d();
                b.a.q0.s.e0.b.j().v("key_game_video_tab_has_choosed_sub_class_id", aVar.f17138a);
                b.a.q0.s.e0.b.j().x("key_game_video_tab_has_choosed_sub_class_name", aVar.f17139b);
                TiebaStatic.log(new StatisticItem("c13485").param("obj_type", aVar.f17138a));
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
        this.f17103h = new C0877a(this);
        this.f17096a = tbPageContext;
        this.f17102g = bdUniqueId;
        e();
    }

    public void c(ViewGroup viewGroup) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || viewGroup == null || (view = this.f17097b) == null) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f17097b.getParent()).removeView(this.f17097b);
        }
        viewGroup.addView(this.f17097b);
        TiebaStatic.log("c13484");
    }

    public void d() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (view = this.f17097b) == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f17097b.getParent()).removeView(this.f17097b);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.f17096a.getPageActivity()).inflate(R.layout.game_video_choose_fullscreen_layout, (ViewGroup) null);
            this.f17097b = inflate;
            this.f17098c = (GameVideoGridView) inflate.findViewById(R.id.id_game_video_choose_full_gridview);
            this.f17099d = new b.a.r0.h1.e.a.b(this.f17096a, 101, this.f17102g);
            this.f17098c.setNumColumns(4);
            this.f17098c.setAdapter((ListAdapter) this.f17099d);
            this.f17098c.setOnItemClickListener(this.f17103h);
            this.f17100e = (TextView) this.f17097b.findViewById(R.id.id_game_video_choose_full_title);
            f();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = this.f17100e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            }
            View view = this.f17097b;
            if (view != null) {
                SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
            }
        }
    }

    public void g() {
        GameVideoGridView gameVideoGridView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gameVideoGridView = this.f17098c) == null) {
            return;
        }
        gameVideoGridView.onDestroy();
    }

    public void h(List<b.a.r0.h1.e.c.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f17099d.b(list);
        this.f17099d.notifyDataSetChanged();
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f17101f = bVar;
        }
    }
}
