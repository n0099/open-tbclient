package c.a.p0.w2.m.d;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.p0.w2.i.f;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FoldCommentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f19929b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.w2.m.f.k1.a f19930c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.w2.m.f.k1.c f19931d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f19932e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f19933f;

    /* renamed from: g  reason: collision with root package name */
    public TbRichTextView.y f19934g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.w2.j.c f19935h;
    public View.OnLongClickListener i;
    public SubPbReplyAdapter j;
    public b k;
    public List<c.a.d.o.e.a> l;
    public f m;
    public ArrayList<n> n;

    public a(FoldCommentActivity foldCommentActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {foldCommentActivity, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new ArrayList();
        this.n = new ArrayList<>();
        this.a = foldCommentActivity;
        this.f19929b = bdTypeListView;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.a, c.a.p0.w2.m.h.g.b.f20404b);
            this.j = subPbReplyAdapter;
            subPbReplyAdapter.b0(false);
            this.l.add(this.j);
            FoldCommentActivity foldCommentActivity = this.a;
            b bVar = new b(foldCommentActivity, PostData.w0, foldCommentActivity.getPageContext());
            this.k = bVar;
            bVar.J0(this.f19930c);
            this.k.K0(this.f19931d);
            this.k.M0(this.a);
            this.k.m(this.f19932e);
            this.k.e(this.f19933f);
            this.k.p(this.f19934g);
            this.k.L0(this.f19935h);
            this.k.d(this.i);
            this.l.add(this.k);
            this.f19929b.a(this.l);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f19929b.getAdapter2() == null) {
            return;
        }
        this.f19929b.getAdapter2().notifyDataSetChanged();
    }

    public void c(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f19933f = onClickListener;
        }
    }

    public void d(boolean z) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (bVar = this.k) == null) {
            return;
        }
        bVar.setFromCDN(z);
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f19932e = onClickListener;
        }
    }

    public void f(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yVar) == null) {
            this.f19934g = yVar;
        }
    }

    public void g(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onLongClickListener) == null) {
            this.i = onLongClickListener;
        }
    }

    public void h(f fVar) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.m = fVar;
            b bVar2 = this.k;
            if (bVar2 != null) {
                bVar2.t(fVar);
            }
            this.n.clear();
            f fVar2 = this.m;
            if (fVar2 != null && fVar2.F() != null && this.m.F().size() > 0) {
                c.a.p0.w2.m.h.g.b bVar3 = new c.a.p0.w2.m.h.g.b();
                bVar3.b(fVar.F().size());
                this.n.add(bVar3);
                Iterator<PostData> it = this.m.F().iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next.getType() != PostData.v0) {
                        this.n.add(next);
                    }
                }
            }
            if (fVar.O() != null && fVar.O().getAuthor() != null && (bVar = this.k) != null) {
                bVar.q(fVar.O().getAuthor().getUserId());
            }
            if (this.m != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_HAS_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.m.m());
                statisticItem.param("fname", this.m.n());
                statisticItem.param("tid", this.m.Q());
                TiebaStatic.log(statisticItem);
            }
            this.f19929b.setData(this.n);
            this.f19929b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void i(c.a.p0.w2.m.f.k1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f19930c = aVar;
        }
    }

    public void j(c.a.p0.w2.m.f.k1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f19931d = cVar;
        }
    }

    public void k(c.a.p0.w2.j.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f19935h = cVar;
        }
    }
}
