package c.a.u0.s4.e0;

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
import c.a.d.f.p.n;
import c.a.t0.s.r.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f22090e;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<c.a.t0.s.l0.s.a> f22091f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<w> f22092g;

    /* renamed from: h  reason: collision with root package name */
    public b f22093h;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f22094e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f22095f;

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
            this.f22095f = dVar;
            this.f22094e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.t0.s.l0.s.a g2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (g2 = this.f22095f.g(this.f22094e)) == null) {
                return;
            }
            if (this.f22095f.f22093h != null) {
                this.f22095f.f22093h.b(g2.e());
            }
            if (this.f22095f.f22093h != null) {
                this.f22095f.f22093h.a(this.f22095f.f22092g);
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(List<w> list);

        void b(int i2);
    }

    /* loaded from: classes9.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public View f22096b;

        /* renamed from: c  reason: collision with root package name */
        public View f22097c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f22098d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f22099e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f22100f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f22101g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f22102h;

        /* renamed from: i  reason: collision with root package name */
        public View f22103i;

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
        this.f22092g = new LinkedList<>();
        this.f22090e = tbPageContext;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22092g.clear();
            if (ListUtils.isEmpty(this.f22091f)) {
                return;
            }
            Iterator<c.a.t0.s.l0.s.a> it = this.f22091f.iterator();
            while (it.hasNext()) {
                c.a.t0.s.l0.s.a next = it.next();
                if (next.h() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.t() != null) {
                        w t = tbLinkSpanGroup.t();
                        t.t = tbLinkSpanGroup.f();
                        this.f22092g.add(t);
                    }
                }
            }
            Collections.sort(this.f22092g);
        }
    }

    public LinkedList<w> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22092g : (LinkedList) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (ListUtils.isEmpty(this.f22092g)) {
                return true;
            }
            Iterator<w> it = this.f22092g.iterator();
            while (it.hasNext()) {
                w next = it.next();
                if (next.f13981f == 2 || !next.m) {
                    return false;
                }
                while (it.hasNext()) {
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public LinkedList<c.a.t0.s.l0.s.a> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22091f : (LinkedList) invokeV.objValue;
    }

    public c.a.t0.s.l0.s.a g(int i2) {
        InterceptResult invokeI;
        LinkedList<c.a.t0.s.l0.s.a> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            long itemId = getItemId(i2);
            if (itemId != 0 && (linkedList = this.f22091f) != null) {
                Iterator<c.a.t0.s.l0.s.a> it = linkedList.iterator();
                while (it.hasNext()) {
                    c.a.t0.s.l0.s.a next = it.next();
                    if (next.e() == itemId) {
                        return next;
                    }
                }
            }
            return null;
        }
        return (c.a.t0.s.l0.s.a) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            LinkedList<w> linkedList = this.f22092g;
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
            LinkedList<w> linkedList = this.f22092g;
            if (linkedList == null || linkedList.size() <= i2) {
                return null;
            }
            return this.f22092g.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            LinkedList<w> linkedList = this.f22092g;
            return (linkedList == null || linkedList.size() <= i2 || this.f22092g.get(i2) == null) ? 0 : this.f22092g.get(i2).f13980e;
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
                view2 = LayoutInflater.from(this.f22090e.getPageActivity()).inflate(c.a.u0.s4.h.item_commodity_link, (ViewGroup) null);
                cVar = new c(this, null);
                cVar.a = view2.findViewById(c.a.u0.s4.g.commodity_root_view);
                cVar.f22096b = view2.findViewById(c.a.u0.s4.g.commodity_main_view);
                TbImageView tbImageView = (TbImageView) view2.findViewById(c.a.u0.s4.g.commodity_link_icon);
                cVar.f22098d = tbImageView;
                tbImageView.setConrers(15);
                cVar.f22098d.setRadius(n.f(TbadkCoreApplication.getInst(), c.a.u0.s4.e.tbds10));
                cVar.f22098d.setPlaceHolderAutoChangeSkinType(1);
                cVar.f22098d.setGifIconSupport(false);
                cVar.f22098d.setLongIconSupport(false);
                cVar.f22098d.setDrawBorder(true);
                cVar.f22098d.setBorderWidth(n.f(TbadkCoreApplication.getInst(), c.a.u0.s4.e.tbds1));
                cVar.f22098d.setBorderColor(SkinManager.getColor(c.a.u0.s4.d.CAM_X0401));
                cVar.f22099e = (TextView) view2.findViewById(c.a.u0.s4.g.commodity_link_content);
                cVar.f22100f = (ImageView) view2.findViewById(c.a.u0.s4.g.commodity_link_close_button);
                cVar.f22097c = view2.findViewById(c.a.u0.s4.g.extra_info_container);
                cVar.f22101g = (TextView) view2.findViewById(c.a.u0.s4.g.commodity_price);
                cVar.f22102h = (TextView) view2.findViewById(c.a.u0.s4.g.commodity_extra_infos);
                cVar.f22103i = view2.findViewById(c.a.u0.s4.g.commodity_tail_text_mask);
                view2.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
                view2 = view;
            }
            cVar.f22098d.startLoad(wVar.f13984i, 10, false);
            if (TextUtils.isEmpty(wVar.f13985j)) {
                cVar.f22097c.setVisibility(8);
                cVar.f22099e.setMaxLines(2);
            } else {
                cVar.f22097c.setVisibility(0);
                cVar.f22099e.setMaxLines(1);
            }
            if (TextUtils.isEmpty(wVar.f13985j)) {
                cVar.f22101g.setVisibility(8);
            } else {
                cVar.f22101g.setText(String.format(TbadkCoreApplication.getInst().getString(c.a.u0.s4.j.commodity_price_prefix), wVar.f13985j));
                cVar.f22101g.setVisibility(0);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!TextUtils.isEmpty(wVar.p)) {
                spannableStringBuilder.append((CharSequence) wVar.p);
                int f2 = n.f(TbadkCoreApplication.getInst(), c.a.u0.s4.e.L_X01);
                int f3 = n.f(TbadkCoreApplication.getInst(), c.a.u0.s4.e.tbds10);
                int i3 = c.a.u0.s4.d.CAM_X0305;
                int f4 = n.f(TbadkCoreApplication.getInst(), c.a.u0.s4.e.T_X10);
                int f5 = n.f(TbadkCoreApplication.getInst(), c.a.u0.s4.e.M_W_X002);
                int f6 = n.f(TbadkCoreApplication.getInst(), c.a.u0.s4.e.tbds2);
                int f7 = n.f(TbadkCoreApplication.getInst(), c.a.u0.s4.e.M_W_X003);
                c.a.t0.s.l0.b bVar = new c.a.t0.s.l0.b(f2, -1, i3, f4, i3, f5, n.f(TbadkCoreApplication.getInst(), c.a.u0.s4.e.tbds38));
                bVar.b(f3);
                bVar.h(f6);
                bVar.i(f7);
                spannableStringBuilder.setSpan(bVar, 0, wVar.p.length(), 17);
            }
            if (!wVar.r && wVar.f13981f != 2 && !wVar.m) {
                String str = wVar.k;
                if (str != null) {
                    spannableStringBuilder.append((CharSequence) str);
                }
                cVar.f22099e.setMaxLines(1);
            } else {
                String str2 = wVar.f13982g;
                if (str2 != null) {
                    spannableStringBuilder.append((CharSequence) str2);
                }
            }
            cVar.f22099e.setText(spannableStringBuilder);
            cVar.f22100f.setOnClickListener(new a(this, i2));
            n.f(TbadkCoreApplication.getInst(), c.a.u0.s4.e.tbds10);
            View view3 = cVar.a;
            int i4 = c.a.u0.s4.d.CAM_X0205;
            SkinManager.setBackgroundShapeDrawable(view3, 0, i4, i4);
            c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(cVar.f22096b);
            d2.n(c.a.u0.s4.j.J_X05);
            d2.f(c.a.u0.s4.d.CAM_X0206);
            cVar.f22100f.setImageDrawable(WebPManager.getMaskDrawable(c.a.u0.s4.f.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
            SkinManager.setViewTextColor(cVar.f22099e, c.a.u0.s4.d.CAM_X0105);
            SkinManager.setViewTextColor(cVar.f22101g, c.a.u0.s4.d.CAM_X0305);
            SkinManager.setViewTextColor(cVar.f22102h, c.a.u0.s4.d.CAM_X0109);
            SkinManager.setBackgroundColorToTransparent(cVar.f22103i, c.a.u0.s4.d.CAM_X0206, GradientDrawable.Orientation.RIGHT_LEFT);
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

    public void i(LinkedList<c.a.t0.s.l0.s.a> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, linkedList) == null) {
            this.f22091f = linkedList;
        }
    }

    public void j(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.f22093h = bVar;
        }
    }
}
