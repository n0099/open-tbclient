package c.a.r0.q4.u;

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
import c.a.q0.r.r.w;
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
/* loaded from: classes2.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f21405e;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<c.a.q0.r.l0.s.a> f21406f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<w> f21407g;

    /* renamed from: h  reason: collision with root package name */
    public b f21408h;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f21409e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f21410f;

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
            this.f21410f = dVar;
            this.f21409e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.q0.r.l0.s.a g2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (g2 = this.f21410f.g(this.f21409e)) == null) {
                return;
            }
            if (this.f21410f.f21408h != null) {
                this.f21410f.f21408h.b(g2.e());
            }
            if (this.f21410f.f21408h != null) {
                this.f21410f.f21408h.a(this.f21410f.f21407g);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(List<w> list);

        void b(int i2);
    }

    /* loaded from: classes2.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public View f21411b;

        /* renamed from: c  reason: collision with root package name */
        public View f21412c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f21413d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f21414e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f21415f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f21416g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f21417h;

        /* renamed from: i  reason: collision with root package name */
        public View f21418i;

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
        this.f21407g = new LinkedList<>();
        this.f21405e = tbPageContext;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21407g.clear();
            if (ListUtils.isEmpty(this.f21406f)) {
                return;
            }
            Iterator<c.a.q0.r.l0.s.a> it = this.f21406f.iterator();
            while (it.hasNext()) {
                c.a.q0.r.l0.s.a next = it.next();
                if (next.h() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.t() != null) {
                        w t = tbLinkSpanGroup.t();
                        t.t = tbLinkSpanGroup.f();
                        this.f21407g.add(t);
                    }
                }
            }
            Collections.sort(this.f21407g);
        }
    }

    public LinkedList<w> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21407g : (LinkedList) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (ListUtils.isEmpty(this.f21407g)) {
                return true;
            }
            Iterator<w> it = this.f21407g.iterator();
            while (it.hasNext()) {
                w next = it.next();
                if (next.f13397f == 2 || !next.m) {
                    return false;
                }
                while (it.hasNext()) {
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public LinkedList<c.a.q0.r.l0.s.a> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21406f : (LinkedList) invokeV.objValue;
    }

    public c.a.q0.r.l0.s.a g(int i2) {
        InterceptResult invokeI;
        LinkedList<c.a.q0.r.l0.s.a> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            long itemId = getItemId(i2);
            if (itemId != 0 && (linkedList = this.f21406f) != null) {
                Iterator<c.a.q0.r.l0.s.a> it = linkedList.iterator();
                while (it.hasNext()) {
                    c.a.q0.r.l0.s.a next = it.next();
                    if (next.e() == itemId) {
                        return next;
                    }
                }
            }
            return null;
        }
        return (c.a.q0.r.l0.s.a) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            LinkedList<w> linkedList = this.f21407g;
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
            LinkedList<w> linkedList = this.f21407g;
            if (linkedList == null || linkedList.size() <= i2) {
                return null;
            }
            return this.f21407g.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            LinkedList<w> linkedList = this.f21407g;
            return (linkedList == null || linkedList.size() <= i2 || this.f21407g.get(i2) == null) ? 0 : this.f21407g.get(i2).f13396e;
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
                view2 = LayoutInflater.from(this.f21405e.getPageActivity()).inflate(R.layout.item_commodity_link, (ViewGroup) null);
                cVar = new c(this, null);
                cVar.a = view2.findViewById(R.id.commodity_root_view);
                cVar.f21411b = view2.findViewById(R.id.commodity_main_view);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.commodity_link_icon);
                cVar.f21413d = tbImageView;
                tbImageView.setConrers(15);
                cVar.f21413d.setRadius(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                cVar.f21413d.setPlaceHolderAutoChangeSkinType(1);
                cVar.f21413d.setGifIconSupport(false);
                cVar.f21413d.setLongIconSupport(false);
                cVar.f21413d.setDrawBorder(true);
                cVar.f21413d.setBorderWidth(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                cVar.f21413d.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                cVar.f21414e = (TextView) view2.findViewById(R.id.commodity_link_content);
                cVar.f21415f = (ImageView) view2.findViewById(R.id.commodity_link_close_button);
                cVar.f21412c = view2.findViewById(R.id.extra_info_container);
                cVar.f21416g = (TextView) view2.findViewById(R.id.commodity_price);
                cVar.f21417h = (TextView) view2.findViewById(R.id.commodity_extra_infos);
                cVar.f21418i = view2.findViewById(R.id.commodity_tail_text_mask);
                view2.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
                view2 = view;
            }
            cVar.f21413d.startLoad(wVar.f13400i, 10, false);
            if (TextUtils.isEmpty(wVar.f13401j)) {
                cVar.f21412c.setVisibility(8);
                cVar.f21414e.setMaxLines(2);
            } else {
                cVar.f21412c.setVisibility(0);
                cVar.f21414e.setMaxLines(1);
            }
            if (TextUtils.isEmpty(wVar.f13401j)) {
                cVar.f21416g.setVisibility(8);
            } else {
                cVar.f21416g.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), wVar.f13401j));
                cVar.f21416g.setVisibility(0);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!TextUtils.isEmpty(wVar.p)) {
                spannableStringBuilder.append((CharSequence) wVar.p);
                int f2 = n.f(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                int f3 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int f4 = n.f(TbadkCoreApplication.getInst(), R.dimen.T_X10);
                int f5 = n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                int f6 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                int f7 = n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
                c.a.q0.r.l0.b bVar = new c.a.q0.r.l0.b(f2, -1, R.color.CAM_X0305, f4, R.color.CAM_X0305, f5, n.f(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                bVar.b(f3);
                bVar.h(f6);
                bVar.i(f7);
                spannableStringBuilder.setSpan(bVar, 0, wVar.p.length(), 17);
            }
            if (!wVar.r && wVar.f13397f != 2 && !wVar.m) {
                String str = wVar.k;
                if (str != null) {
                    spannableStringBuilder.append((CharSequence) str);
                }
                cVar.f21414e.setMaxLines(1);
            } else {
                String str2 = wVar.f13398g;
                if (str2 != null) {
                    spannableStringBuilder.append((CharSequence) str2);
                }
            }
            cVar.f21414e.setText(spannableStringBuilder);
            cVar.f21415f.setOnClickListener(new a(this, i2));
            n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            SkinManager.setBackgroundShapeDrawable(cVar.a, 0, R.color.CAM_X0205, R.color.CAM_X0205);
            c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(cVar.f21411b);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            cVar.f21415f.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
            SkinManager.setViewTextColor(cVar.f21414e, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(cVar.f21416g, (int) R.color.CAM_X0305);
            SkinManager.setViewTextColor(cVar.f21417h, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundColorToTransparent(cVar.f21418i, R.color.CAM_X0206, GradientDrawable.Orientation.RIGHT_LEFT);
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

    public void i(LinkedList<c.a.q0.r.l0.s.a> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, linkedList) == null) {
            this.f21406f = linkedList;
        }
    }

    public void j(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.f21408h = bVar;
        }
    }
}
