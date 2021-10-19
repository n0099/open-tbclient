package c.a.r0.d4.u;

import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.s.q.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f17104e;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<c.a.q0.s.f0.s.a> f17105f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<w> f17106g;

    /* renamed from: h  reason: collision with root package name */
    public b f17107h;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f17108e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f17109f;

        public a(d dVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17109f = dVar;
            this.f17108e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.q0.s.f0.s.a g2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (g2 = this.f17109f.g(this.f17108e)) == null) {
                return;
            }
            if (this.f17109f.f17107h != null) {
                this.f17109f.f17107h.b(g2.e());
            }
            if (this.f17109f.f17107h != null) {
                this.f17109f.f17107h.a(this.f17109f.f17106g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(List<w> list);

        void b(int i2);
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f17110a;

        /* renamed from: b  reason: collision with root package name */
        public View f17111b;

        /* renamed from: c  reason: collision with root package name */
        public View f17112c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f17113d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f17114e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f17115f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f17116g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f17117h;

        /* renamed from: i  reason: collision with root package name */
        public View f17118i;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(d dVar, a aVar) {
            this(dVar);
        }
    }

    public d(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17106g = new LinkedList<>();
        this.f17104e = tbPageContext;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f17106g.clear();
            if (ListUtils.isEmpty(this.f17105f)) {
                return;
            }
            Iterator<c.a.q0.s.f0.s.a> it = this.f17105f.iterator();
            while (it.hasNext()) {
                c.a.q0.s.f0.s.a next = it.next();
                if (next.h() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.t() != null) {
                        w t = tbLinkSpanGroup.t();
                        t.t = tbLinkSpanGroup.f();
                        this.f17106g.add(t);
                    }
                }
            }
            Collections.sort(this.f17106g);
        }
    }

    public LinkedList<w> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f17106g : (LinkedList) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (ListUtils.isEmpty(this.f17106g)) {
                return true;
            }
            Iterator<w> it = this.f17106g.iterator();
            while (it.hasNext()) {
                w next = it.next();
                if (next.f14354f == 2 || !next.m) {
                    return false;
                }
                while (it.hasNext()) {
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public LinkedList<c.a.q0.s.f0.s.a> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f17105f : (LinkedList) invokeV.objValue;
    }

    public c.a.q0.s.f0.s.a g(int i2) {
        InterceptResult invokeI;
        LinkedList<c.a.q0.s.f0.s.a> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            long itemId = getItemId(i2);
            if (itemId != 0 && (linkedList = this.f17105f) != null) {
                Iterator<c.a.q0.s.f0.s.a> it = linkedList.iterator();
                while (it.hasNext()) {
                    c.a.q0.s.f0.s.a next = it.next();
                    if (next.e() == itemId) {
                        return next;
                    }
                }
            }
            return null;
        }
        return (c.a.q0.s.f0.s.a) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            LinkedList<w> linkedList = this.f17106g;
            if (linkedList == null) {
                return 0;
            }
            return linkedList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            LinkedList<w> linkedList = this.f17106g;
            if (linkedList == null || linkedList.size() <= i2) {
                return null;
            }
            return this.f17106g.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            LinkedList<w> linkedList = this.f17106g;
            return (linkedList == null || linkedList.size() <= i2 || this.f17106g.get(i2) == null) ? 0 : this.f17106g.get(i2).f14353e;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            w wVar = (w) getItem(i2);
            if (wVar == null) {
                return null;
            }
            if (view == null) {
                view2 = LayoutInflater.from(this.f17104e.getPageActivity()).inflate(R.layout.item_commodity_link, (ViewGroup) null);
                cVar = new c(this, null);
                cVar.f17110a = view2.findViewById(R.id.commodity_root_view);
                cVar.f17111b = view2.findViewById(R.id.commodity_main_view);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.commodity_link_icon);
                cVar.f17113d = tbImageView;
                tbImageView.setConrers(15);
                cVar.f17113d.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                cVar.f17113d.setPlaceHolderAutoChangeSkinType(1);
                cVar.f17113d.setGifIconSupport(false);
                cVar.f17113d.setLongIconSupport(false);
                cVar.f17113d.setDrawBorder(true);
                cVar.f17113d.setBorderWidth(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                cVar.f17113d.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                cVar.f17114e = (TextView) view2.findViewById(R.id.commodity_link_content);
                cVar.f17115f = (ImageView) view2.findViewById(R.id.commodity_link_close_button);
                cVar.f17112c = view2.findViewById(R.id.extra_info_container);
                cVar.f17116g = (TextView) view2.findViewById(R.id.commodity_price);
                cVar.f17117h = (TextView) view2.findViewById(R.id.commodity_extra_infos);
                cVar.f17118i = view2.findViewById(R.id.commodity_tail_text_mask);
                view2.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
                view2 = view;
            }
            cVar.f17113d.startLoad(wVar.f14357i, 10, false);
            if (TextUtils.isEmpty(wVar.f14358j)) {
                cVar.f17112c.setVisibility(8);
                cVar.f17114e.setMaxLines(2);
            } else {
                cVar.f17112c.setVisibility(0);
                cVar.f17114e.setMaxLines(1);
            }
            if (TextUtils.isEmpty(wVar.f14358j)) {
                cVar.f17116g.setVisibility(8);
            } else {
                cVar.f17116g.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), wVar.f14358j));
                cVar.f17116g.setVisibility(0);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!TextUtils.isEmpty(wVar.p)) {
                spannableStringBuilder.append((CharSequence) wVar.p);
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int i3 = R.color.CAM_X0305;
                int g4 = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X10);
                int g5 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                int g6 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                int g7 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
                c.a.q0.s.f0.b bVar = new c.a.q0.s.f0.b(g2, -1, i3, g4, i3, g5, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                bVar.b(g3);
                bVar.h(g6);
                bVar.i(g7);
                spannableStringBuilder.setSpan(bVar, 0, wVar.p.length(), 17);
            }
            if (!wVar.r && wVar.f14354f != 2 && !wVar.m) {
                String str = wVar.k;
                if (str != null) {
                    spannableStringBuilder.append((CharSequence) str);
                }
                cVar.f17114e.setMaxLines(1);
            } else {
                String str2 = wVar.f14355g;
                if (str2 != null) {
                    spannableStringBuilder.append((CharSequence) str2);
                }
            }
            cVar.f17114e.setText(spannableStringBuilder);
            cVar.f17115f.setOnClickListener(new a(this, i2));
            l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            View view3 = cVar.f17110a;
            int i4 = R.color.CAM_X0205;
            SkinManager.setBackgroundShapeDrawable(view3, 0, i4, i4);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(cVar.f17111b);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            cVar.f17115f.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
            SkinManager.setViewTextColor(cVar.f17114e, R.color.CAM_X0105);
            SkinManager.setViewTextColor(cVar.f17116g, R.color.CAM_X0305);
            SkinManager.setViewTextColor(cVar.f17117h, R.color.CAM_X0109);
            SkinManager.setBackgroundColorToTransparent(cVar.f17118i, R.color.CAM_X0206, GradientDrawable.Orientation.RIGHT_LEFT);
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c();
            notifyDataSetChanged();
        }
    }

    public void i(LinkedList<c.a.q0.s.f0.s.a> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, linkedList) == null) {
            this.f17105f = linkedList;
        }
    }

    public void j(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.f17107h = bVar;
        }
    }
}
