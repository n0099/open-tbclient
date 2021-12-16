package c.a.s0.n4.e0;

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
import c.a.d.f.p.m;
import c.a.r0.s.r.w;
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
/* loaded from: classes7.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f20226e;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<c.a.r0.s.i0.s.a> f20227f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<w> f20228g;

    /* renamed from: h  reason: collision with root package name */
    public b f20229h;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f20230e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f20231f;

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
            this.f20231f = dVar;
            this.f20230e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.r0.s.i0.s.a g2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (g2 = this.f20231f.g(this.f20230e)) == null) {
                return;
            }
            if (this.f20231f.f20229h != null) {
                this.f20231f.f20229h.b(g2.e());
            }
            if (this.f20231f.f20229h != null) {
                this.f20231f.f20229h.a(this.f20231f.f20228g);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(List<w> list);

        void b(int i2);
    }

    /* loaded from: classes7.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public View f20232b;

        /* renamed from: c  reason: collision with root package name */
        public View f20233c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f20234d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f20235e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f20236f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f20237g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f20238h;

        /* renamed from: i  reason: collision with root package name */
        public View f20239i;

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
        this.f20228g = new LinkedList<>();
        this.f20226e = tbPageContext;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f20228g.clear();
            if (ListUtils.isEmpty(this.f20227f)) {
                return;
            }
            Iterator<c.a.r0.s.i0.s.a> it = this.f20227f.iterator();
            while (it.hasNext()) {
                c.a.r0.s.i0.s.a next = it.next();
                if (next.h() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.t() != null) {
                        w t = tbLinkSpanGroup.t();
                        t.t = tbLinkSpanGroup.f();
                        this.f20228g.add(t);
                    }
                }
            }
            Collections.sort(this.f20228g);
        }
    }

    public LinkedList<w> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20228g : (LinkedList) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (ListUtils.isEmpty(this.f20228g)) {
                return true;
            }
            Iterator<w> it = this.f20228g.iterator();
            while (it.hasNext()) {
                w next = it.next();
                if (next.f13453f == 2 || !next.m) {
                    return false;
                }
                while (it.hasNext()) {
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public LinkedList<c.a.r0.s.i0.s.a> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f20227f : (LinkedList) invokeV.objValue;
    }

    public c.a.r0.s.i0.s.a g(int i2) {
        InterceptResult invokeI;
        LinkedList<c.a.r0.s.i0.s.a> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            long itemId = getItemId(i2);
            if (itemId != 0 && (linkedList = this.f20227f) != null) {
                Iterator<c.a.r0.s.i0.s.a> it = linkedList.iterator();
                while (it.hasNext()) {
                    c.a.r0.s.i0.s.a next = it.next();
                    if (next.e() == itemId) {
                        return next;
                    }
                }
            }
            return null;
        }
        return (c.a.r0.s.i0.s.a) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            LinkedList<w> linkedList = this.f20228g;
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
            LinkedList<w> linkedList = this.f20228g;
            if (linkedList == null || linkedList.size() <= i2) {
                return null;
            }
            return this.f20228g.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            LinkedList<w> linkedList = this.f20228g;
            return (linkedList == null || linkedList.size() <= i2 || this.f20228g.get(i2) == null) ? 0 : this.f20228g.get(i2).f13452e;
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
                view2 = LayoutInflater.from(this.f20226e.getPageActivity()).inflate(c.a.s0.n4.h.item_commodity_link, (ViewGroup) null);
                cVar = new c(this, null);
                cVar.a = view2.findViewById(c.a.s0.n4.g.commodity_root_view);
                cVar.f20232b = view2.findViewById(c.a.s0.n4.g.commodity_main_view);
                TbImageView tbImageView = (TbImageView) view2.findViewById(c.a.s0.n4.g.commodity_link_icon);
                cVar.f20234d = tbImageView;
                tbImageView.setConrers(15);
                cVar.f20234d.setRadius(m.f(TbadkCoreApplication.getInst(), c.a.s0.n4.e.tbds10));
                cVar.f20234d.setPlaceHolderAutoChangeSkinType(1);
                cVar.f20234d.setGifIconSupport(false);
                cVar.f20234d.setLongIconSupport(false);
                cVar.f20234d.setDrawBorder(true);
                cVar.f20234d.setBorderWidth(m.f(TbadkCoreApplication.getInst(), c.a.s0.n4.e.tbds1));
                cVar.f20234d.setBorderColor(SkinManager.getColor(c.a.s0.n4.d.CAM_X0401));
                cVar.f20235e = (TextView) view2.findViewById(c.a.s0.n4.g.commodity_link_content);
                cVar.f20236f = (ImageView) view2.findViewById(c.a.s0.n4.g.commodity_link_close_button);
                cVar.f20233c = view2.findViewById(c.a.s0.n4.g.extra_info_container);
                cVar.f20237g = (TextView) view2.findViewById(c.a.s0.n4.g.commodity_price);
                cVar.f20238h = (TextView) view2.findViewById(c.a.s0.n4.g.commodity_extra_infos);
                cVar.f20239i = view2.findViewById(c.a.s0.n4.g.commodity_tail_text_mask);
                view2.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
                view2 = view;
            }
            cVar.f20234d.startLoad(wVar.f13456i, 10, false);
            if (TextUtils.isEmpty(wVar.f13457j)) {
                cVar.f20233c.setVisibility(8);
                cVar.f20235e.setMaxLines(2);
            } else {
                cVar.f20233c.setVisibility(0);
                cVar.f20235e.setMaxLines(1);
            }
            if (TextUtils.isEmpty(wVar.f13457j)) {
                cVar.f20237g.setVisibility(8);
            } else {
                cVar.f20237g.setText(String.format(TbadkCoreApplication.getInst().getString(c.a.s0.n4.j.commodity_price_prefix), wVar.f13457j));
                cVar.f20237g.setVisibility(0);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!TextUtils.isEmpty(wVar.p)) {
                spannableStringBuilder.append((CharSequence) wVar.p);
                int f2 = m.f(TbadkCoreApplication.getInst(), c.a.s0.n4.e.L_X01);
                int f3 = m.f(TbadkCoreApplication.getInst(), c.a.s0.n4.e.tbds10);
                int i3 = c.a.s0.n4.d.CAM_X0305;
                int f4 = m.f(TbadkCoreApplication.getInst(), c.a.s0.n4.e.T_X10);
                int f5 = m.f(TbadkCoreApplication.getInst(), c.a.s0.n4.e.M_W_X002);
                int f6 = m.f(TbadkCoreApplication.getInst(), c.a.s0.n4.e.tbds2);
                int f7 = m.f(TbadkCoreApplication.getInst(), c.a.s0.n4.e.M_W_X003);
                c.a.r0.s.i0.b bVar = new c.a.r0.s.i0.b(f2, -1, i3, f4, i3, f5, m.f(TbadkCoreApplication.getInst(), c.a.s0.n4.e.tbds38));
                bVar.b(f3);
                bVar.h(f6);
                bVar.i(f7);
                spannableStringBuilder.setSpan(bVar, 0, wVar.p.length(), 17);
            }
            if (!wVar.r && wVar.f13453f != 2 && !wVar.m) {
                String str = wVar.f13458k;
                if (str != null) {
                    spannableStringBuilder.append((CharSequence) str);
                }
                cVar.f20235e.setMaxLines(1);
            } else {
                String str2 = wVar.f13454g;
                if (str2 != null) {
                    spannableStringBuilder.append((CharSequence) str2);
                }
            }
            cVar.f20235e.setText(spannableStringBuilder);
            cVar.f20236f.setOnClickListener(new a(this, i2));
            m.f(TbadkCoreApplication.getInst(), c.a.s0.n4.e.tbds10);
            View view3 = cVar.a;
            int i4 = c.a.s0.n4.d.CAM_X0205;
            SkinManager.setBackgroundShapeDrawable(view3, 0, i4, i4);
            c.a.r0.s.v.c d2 = c.a.r0.s.v.c.d(cVar.f20232b);
            d2.n(c.a.s0.n4.j.J_X05);
            d2.f(c.a.s0.n4.d.CAM_X0206);
            cVar.f20236f.setImageDrawable(WebPManager.getMaskDrawable(c.a.s0.n4.f.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
            SkinManager.setViewTextColor(cVar.f20235e, c.a.s0.n4.d.CAM_X0105);
            SkinManager.setViewTextColor(cVar.f20237g, c.a.s0.n4.d.CAM_X0305);
            SkinManager.setViewTextColor(cVar.f20238h, c.a.s0.n4.d.CAM_X0109);
            SkinManager.setBackgroundColorToTransparent(cVar.f20239i, c.a.s0.n4.d.CAM_X0206, GradientDrawable.Orientation.RIGHT_LEFT);
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

    public void i(LinkedList<c.a.r0.s.i0.s.a> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, linkedList) == null) {
            this.f20227f = linkedList;
        }
    }

    public void j(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.f20229h = bVar;
        }
    }
}
