package b.a.r0.k2.u.d;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.e.l.e.n;
import b.a.r0.k2.r.f;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FoldCommentActivity f18881a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f18882b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.k2.u.f.c1.a f18883c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.k2.u.f.c1.c f18884d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f18885e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f18886f;

    /* renamed from: g  reason: collision with root package name */
    public TbRichTextView.z f18887g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.k2.s.c f18888h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnLongClickListener f18889i;
    public SubPbReplyAdapter j;
    public b k;
    public List<b.a.e.l.e.a> l;
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
        this.f18881a = foldCommentActivity;
        this.f18882b = bdTypeListView;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f18881a, b.a.r0.k2.u.h.g.b.f19647f);
            this.j = subPbReplyAdapter;
            subPbReplyAdapter.i0(false);
            this.l.add(this.j);
            FoldCommentActivity foldCommentActivity = this.f18881a;
            b bVar = new b(foldCommentActivity, PostData.y0, foldCommentActivity.getPageContext());
            this.k = bVar;
            bVar.Q0(this.f18883c);
            this.k.R0(this.f18884d);
            this.k.T0(this.f18881a);
            this.k.m(this.f18885e);
            this.k.e(this.f18886f);
            this.k.p(this.f18887g);
            this.k.S0(this.f18888h);
            this.k.d(this.f18889i);
            this.l.add(this.k);
            this.f18882b.addAdapters(this.l);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f18882b.getAdapter2() == null) {
            return;
        }
        this.f18882b.getAdapter2().notifyDataSetChanged();
    }

    public void c(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f18886f = onClickListener;
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
            this.f18885e = onClickListener;
        }
    }

    public void f(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, zVar) == null) {
            this.f18887g = zVar;
        }
    }

    public void g(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onLongClickListener) == null) {
            this.f18889i = onLongClickListener;
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
                b.a.r0.k2.u.h.g.b bVar3 = new b.a.r0.k2.u.h.g.b();
                bVar3.d(fVar.F().size());
                this.n.add(bVar3);
                Iterator<PostData> it = this.m.F().iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next.getType() != PostData.x0) {
                        this.n.add(next);
                    }
                }
            }
            if (fVar.O() != null && fVar.O().J() != null && (bVar = this.k) != null) {
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
            this.f18882b.setData(this.n);
            this.f18882b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void i(b.a.r0.k2.u.f.c1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f18883c = aVar;
        }
    }

    public void j(b.a.r0.k2.u.f.c1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f18884d = cVar;
        }
    }

    public void k(b.a.r0.k2.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f18888h = cVar;
        }
    }
}
