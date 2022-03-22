package c.a.p0.w0.o;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.r.t.a;
import c.a.p0.w0.e.i;
import c.a.p0.w0.i.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.adapter.LikeForumItemAdapter;
import com.baidu.tieba.enterForum.callback.LikeForumDragCallBack;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends c.a.o0.k0.f.a<i, c.a.p0.w0.e.e> implements c.a.p0.w0.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public View f19588g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19589h;
    public TextView i;
    public RecyclerView j;
    public LikeForumItemAdapter k;
    public c.a.p0.w0.i.b l;
    public EnterForumModel m;
    public ViewEventCenter n;

    /* loaded from: classes2.dex */
    public class a implements b.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumModel a;

        public a(d dVar, EnterForumModel enterForumModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, enterForumModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = enterForumModel;
        }

        @Override // c.a.p0.w0.i.b.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.K(true, i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements LikeForumItemAdapter.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ItemTouchHelper f19590b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f19591c;

        public b(d dVar, h hVar, ItemTouchHelper itemTouchHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, hVar, itemTouchHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19591c = dVar;
            this.a = hVar;
            this.f19590b = itemTouchHelper;
        }

        @Override // com.baidu.tieba.enterForum.adapter.LikeForumItemAdapter.b
        public boolean a(Object obj, RecyclerView.ViewHolder viewHolder) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, viewHolder)) == null) {
                if (this.a.r()) {
                    return false;
                }
                if (this.f19591c.l.p() == 1) {
                    if (obj instanceof c.a.p0.w0.e.h) {
                        this.f19590b.startDrag(viewHolder);
                    }
                } else {
                    Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                    if (currentActivity != null) {
                        BdTopToast bdTopToast = new BdTopToast(currentActivity, 2000);
                        bdTopToast.i(false);
                        bdTopToast.h(currentActivity.getString(R.string.obfuscated_res_0x7f0f09df));
                        bdTopToast.j((ViewGroup) currentActivity.findViewById(16908290));
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* loaded from: classes2.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.o0.r.t.a.e
            public void onClick(c.a.o0.r.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes2.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.o0.r.t.a.e
            public void onClick(c.a.o0.r.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* renamed from: c.a.p0.w0.o.d$c$c  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1482c implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C1482c(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.o0.r.t.a.e
            public void onClick(c.a.o0.r.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String y;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.m.A()) {
                    if (this.a.n != null) {
                        this.a.n.dispatchMvcEvent(new c.a.o0.k0.c.b(14, null, null, null));
                    }
                } else if (this.a.d() == null) {
                } else {
                    boolean z = false;
                    ForumCreateInfoData b2 = this.a.m.C().b();
                    if (b2 != null) {
                        int z2 = b2.z();
                        if (z2 == 220012) {
                            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                            if (m.isEmpty(b2.y())) {
                                y = this.a.d().getString(R.string.obfuscated_res_0x7f0f0458);
                            } else {
                                y = b2.y();
                            }
                            blockPopInfoData.block_info = y;
                            blockPopInfoData.ahead_info = this.a.d().getString(R.string.obfuscated_res_0x7f0f045a);
                            blockPopInfoData.ok_info = this.a.d().getString(R.string.obfuscated_res_0x7f0f0984);
                            blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                            AntiHelper.s(this.a.d().getPageActivity(), blockPopInfoData);
                        } else if (z2 == 2121002) {
                            c.a.o0.s.h.a.b(this.a.d(), null, this.a.d().getString(R.string.obfuscated_res_0x7f0f045c), this.a.d().getString(R.string.obfuscated_res_0x7f0f13ef), this.a.d().getString(R.string.obfuscated_res_0x7f0f138c), new a(this), new b(this)).show();
                        }
                        z = true;
                    }
                    if (z) {
                        return;
                    }
                    String string = this.a.d().getString(R.string.obfuscated_res_0x7f0f0459);
                    if (b2 != null) {
                        if (m.isEmpty(b2.y())) {
                            string = this.a.d().getResources().getString(R.string.obfuscated_res_0x7f0f0459);
                        } else {
                            string = b2.y();
                        }
                    }
                    c.a.o0.s.h.a.b(this.a.d(), null, string, this.a.d().getResources().getString(R.string.obfuscated_res_0x7f0f0984), null, new C1482c(this), null).show();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter, h hVar, EnterForumModel enterForumModel) {
        super(tbPageContext, view, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, viewEventCenter, hVar, enterForumModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1], (ViewEventCenter) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19588g = view.findViewById(R.id.obfuscated_res_0x7f09124f);
        this.f19589h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09202b);
        this.i = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091d42);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.obfuscated_res_0x7f091a27);
        this.j = recyclerView;
        this.m = enterForumModel;
        this.n = viewEventCenter;
        recyclerView.setNestedScrollingEnabled(false);
        this.j.setLayoutManager(new GridLayoutManager(getContext(), 2));
        LikeForumItemAdapter likeForumItemAdapter = new LikeForumItemAdapter(tbPageContext, null, viewEventCenter);
        this.k = likeForumItemAdapter;
        likeForumItemAdapter.f(p());
        this.j.setAdapter(this.k);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new LikeForumDragCallBack(this.k, this));
        itemTouchHelper.attachToRecyclerView(this.j);
        c.a.p0.w0.i.b bVar = new c.a.p0.w0.i.b(tbPageContext.getPageActivity(), Integer.valueOf(c.a.p0.w0.b.a(1)).intValue(), 0, hVar);
        this.l = bVar;
        bVar.v(new a(this, enterForumModel));
        this.k.g(new b(this, hVar, itemTouchHelper));
    }

    @Override // c.a.p0.w0.d.a
    public void a(String str, String str2) {
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || (enterForumModel = this.m) == null) {
            return;
        }
        enterForumModel.W(str, str2);
    }

    @Override // c.a.p0.a4.v
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i)) == null) {
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f19588g);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.f19589h, (int) R.color.CAM_X0105);
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final View.OnClickListener p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new c(this) : (View.OnClickListener) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.k0.f.e
    /* renamed from: q */
    public void i(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            super.i(iVar);
            r(iVar.f19373d);
            List<c.a.p0.w0.e.h> list = iVar.f19374e;
            int size = list != null ? 1 + list.size() : 1;
            this.j.getLayoutParams().height = n.f(getContext(), R.dimen.tbds156) * ((int) Math.ceil((size * 1.0f) / 2.0f));
            this.j.getRecycledViewPool().setMaxRecycledViews(0, size);
            this.k.update(iVar.f19374e);
            onChangeSkinType(d(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void r(c.a.p0.w0.e.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) || gVar == null) {
            return;
        }
        this.l.w(this.i);
        this.l.s();
        this.l.r(TbadkCoreApplication.getInst().getSkinType());
        this.f19589h.setText(gVar.f19363d);
        SkinManager.setViewTextColor(this.f19589h, (int) R.color.CAM_X0105);
        TextView textView = this.i;
        if (textView != null) {
            if (gVar.f19364e) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            SkinManager.setBackgroundColor(this.i, R.color.transparent);
        }
    }
}
