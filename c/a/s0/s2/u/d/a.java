package c.a.s0.s2.u.d;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.m.e.n;
import c.a.s0.s2.r.f;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity;
import com.baidu.tieba.pb.pb.sub.adapter.SubPbReplyAdapter;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FoldCommentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f22646b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.s0.s2.u.f.d1.a f22647c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.s0.s2.u.f.d1.c f22648d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f22649e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f22650f;

    /* renamed from: g  reason: collision with root package name */
    public TbRichTextView.y f22651g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.s0.s2.s.c f22652h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnLongClickListener f22653i;

    /* renamed from: j  reason: collision with root package name */
    public SubPbReplyAdapter f22654j;

    /* renamed from: k  reason: collision with root package name */
    public b f22655k;
    public List<c.a.d.m.e.a> l;
    public f m;
    public ArrayList<n> n;

    public a(FoldCommentActivity foldCommentActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {foldCommentActivity, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new ArrayList();
        this.n = new ArrayList<>();
        this.a = foldCommentActivity;
        this.f22646b = bdTypeListView;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.a, c.a.s0.s2.u.h.g.b.f23333f);
            this.f22654j = subPbReplyAdapter;
            subPbReplyAdapter.i0(false);
            this.l.add(this.f22654j);
            FoldCommentActivity foldCommentActivity = this.a;
            b bVar = new b(foldCommentActivity, PostData.z0, foldCommentActivity.getPageContext());
            this.f22655k = bVar;
            bVar.Q0(this.f22647c);
            this.f22655k.R0(this.f22648d);
            this.f22655k.T0(this.a);
            this.f22655k.m(this.f22649e);
            this.f22655k.e(this.f22650f);
            this.f22655k.p(this.f22651g);
            this.f22655k.S0(this.f22652h);
            this.f22655k.d(this.f22653i);
            this.l.add(this.f22655k);
            this.f22646b.addAdapters(this.l);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f22646b.getAdapter2() == null) {
            return;
        }
        this.f22646b.getAdapter2().notifyDataSetChanged();
    }

    public void c(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f22650f = onClickListener;
        }
    }

    public void d(boolean z) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (bVar = this.f22655k) == null) {
            return;
        }
        bVar.setFromCDN(z);
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f22649e = onClickListener;
        }
    }

    public void f(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yVar) == null) {
            this.f22651g = yVar;
        }
    }

    public void g(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onLongClickListener) == null) {
            this.f22653i = onLongClickListener;
        }
    }

    public void h(f fVar) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.m = fVar;
            b bVar2 = this.f22655k;
            if (bVar2 != null) {
                bVar2.t(fVar);
            }
            this.n.clear();
            f fVar2 = this.m;
            if (fVar2 != null && fVar2.F() != null && this.m.F().size() > 0) {
                c.a.s0.s2.u.h.g.b bVar3 = new c.a.s0.s2.u.h.g.b();
                bVar3.d(fVar.F().size());
                this.n.add(bVar3);
                Iterator<PostData> it = this.m.F().iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next.getType() != PostData.y0) {
                        this.n.add(next);
                    }
                }
            }
            if (fVar.O() != null && fVar.O().J() != null && (bVar = this.f22655k) != null) {
                bVar.q(fVar.O().J().getUserId());
            }
            if (this.m != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_HAS_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.m.m());
                statisticItem.param("fname", this.m.n());
                statisticItem.param("tid", this.m.Q());
                TiebaStatic.log(statisticItem);
            }
            this.f22646b.setData(this.n);
            this.f22646b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void i(c.a.s0.s2.u.f.d1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f22647c = aVar;
        }
    }

    public void j(c.a.s0.s2.u.f.d1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f22648d = cVar;
        }
    }

    public void k(c.a.s0.s2.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f22652h = cVar;
        }
    }
}
