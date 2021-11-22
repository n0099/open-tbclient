package b.a.r0.k2.u.d;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.e.m.e.n;
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
    public FoldCommentActivity f20418a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f20419b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.k2.u.f.d1.a f20420c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.k2.u.f.d1.c f20421d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f20422e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f20423f;

    /* renamed from: g  reason: collision with root package name */
    public TbRichTextView.z f20424g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.k2.s.c f20425h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnLongClickListener f20426i;
    public SubPbReplyAdapter j;
    public b k;
    public List<b.a.e.m.e.a> l;
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
        this.f20418a = foldCommentActivity;
        this.f20419b = bdTypeListView;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f20418a, b.a.r0.k2.u.h.g.b.f21184f);
            this.j = subPbReplyAdapter;
            subPbReplyAdapter.i0(false);
            this.l.add(this.j);
            FoldCommentActivity foldCommentActivity = this.f20418a;
            b bVar = new b(foldCommentActivity, PostData.y0, foldCommentActivity.getPageContext());
            this.k = bVar;
            bVar.Q0(this.f20420c);
            this.k.R0(this.f20421d);
            this.k.T0(this.f20418a);
            this.k.m(this.f20422e);
            this.k.e(this.f20423f);
            this.k.p(this.f20424g);
            this.k.S0(this.f20425h);
            this.k.d(this.f20426i);
            this.l.add(this.k);
            this.f20419b.addAdapters(this.l);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f20419b.getAdapter2() == null) {
            return;
        }
        this.f20419b.getAdapter2().notifyDataSetChanged();
    }

    public void c(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f20423f = onClickListener;
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
            this.f20422e = onClickListener;
        }
    }

    public void f(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, zVar) == null) {
            this.f20424g = zVar;
        }
    }

    public void g(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onLongClickListener) == null) {
            this.f20426i = onLongClickListener;
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
            this.f20419b.setData(this.n);
            this.f20419b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void i(b.a.r0.k2.u.f.d1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f20420c = aVar;
        }
    }

    public void j(b.a.r0.k2.u.f.d1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f20421d = cVar;
        }
    }

    public void k(b.a.r0.k2.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f20425h = cVar;
        }
    }
}
