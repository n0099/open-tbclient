package c.a.r0.l4.u;

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
import c.a.d.f.p.l;
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
/* loaded from: classes6.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f19684e;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<c.a.q0.s.g0.s.a> f19685f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<w> f19686g;

    /* renamed from: h  reason: collision with root package name */
    public b f19687h;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19688e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f19689f;

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
            this.f19689f = dVar;
            this.f19688e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.q0.s.g0.s.a g2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (g2 = this.f19689f.g(this.f19688e)) == null) {
                return;
            }
            if (this.f19689f.f19687h != null) {
                this.f19689f.f19687h.b(g2.e());
            }
            if (this.f19689f.f19687h != null) {
                this.f19689f.f19687h.a(this.f19689f.f19686g);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(List<w> list);

        void b(int i2);
    }

    /* loaded from: classes6.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public View f19690b;

        /* renamed from: c  reason: collision with root package name */
        public View f19691c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f19692d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f19693e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f19694f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f19695g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f19696h;

        /* renamed from: i  reason: collision with root package name */
        public View f19697i;

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
        this.f19686g = new LinkedList<>();
        this.f19684e = tbPageContext;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f19686g.clear();
            if (ListUtils.isEmpty(this.f19685f)) {
                return;
            }
            Iterator<c.a.q0.s.g0.s.a> it = this.f19685f.iterator();
            while (it.hasNext()) {
                c.a.q0.s.g0.s.a next = it.next();
                if (next.h() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.t() != null) {
                        w t = tbLinkSpanGroup.t();
                        t.t = tbLinkSpanGroup.f();
                        this.f19686g.add(t);
                    }
                }
            }
            Collections.sort(this.f19686g);
        }
    }

    public LinkedList<w> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19686g : (LinkedList) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (ListUtils.isEmpty(this.f19686g)) {
                return true;
            }
            Iterator<w> it = this.f19686g.iterator();
            while (it.hasNext()) {
                w next = it.next();
                if (next.f13073f == 2 || !next.m) {
                    return false;
                }
                while (it.hasNext()) {
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public LinkedList<c.a.q0.s.g0.s.a> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19685f : (LinkedList) invokeV.objValue;
    }

    public c.a.q0.s.g0.s.a g(int i2) {
        InterceptResult invokeI;
        LinkedList<c.a.q0.s.g0.s.a> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            long itemId = getItemId(i2);
            if (itemId != 0 && (linkedList = this.f19685f) != null) {
                Iterator<c.a.q0.s.g0.s.a> it = linkedList.iterator();
                while (it.hasNext()) {
                    c.a.q0.s.g0.s.a next = it.next();
                    if (next.e() == itemId) {
                        return next;
                    }
                }
            }
            return null;
        }
        return (c.a.q0.s.g0.s.a) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            LinkedList<w> linkedList = this.f19686g;
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
            LinkedList<w> linkedList = this.f19686g;
            if (linkedList == null || linkedList.size() <= i2) {
                return null;
            }
            return this.f19686g.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            LinkedList<w> linkedList = this.f19686g;
            return (linkedList == null || linkedList.size() <= i2 || this.f19686g.get(i2) == null) ? 0 : this.f19686g.get(i2).f13072e;
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
                view2 = LayoutInflater.from(this.f19684e.getPageActivity()).inflate(R.layout.item_commodity_link, (ViewGroup) null);
                cVar = new c(this, null);
                cVar.a = view2.findViewById(R.id.commodity_root_view);
                cVar.f19690b = view2.findViewById(R.id.commodity_main_view);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.commodity_link_icon);
                cVar.f19692d = tbImageView;
                tbImageView.setConrers(15);
                cVar.f19692d.setRadius(l.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                cVar.f19692d.setPlaceHolderAutoChangeSkinType(1);
                cVar.f19692d.setGifIconSupport(false);
                cVar.f19692d.setLongIconSupport(false);
                cVar.f19692d.setDrawBorder(true);
                cVar.f19692d.setBorderWidth(l.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                cVar.f19692d.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                cVar.f19693e = (TextView) view2.findViewById(R.id.commodity_link_content);
                cVar.f19694f = (ImageView) view2.findViewById(R.id.commodity_link_close_button);
                cVar.f19691c = view2.findViewById(R.id.extra_info_container);
                cVar.f19695g = (TextView) view2.findViewById(R.id.commodity_price);
                cVar.f19696h = (TextView) view2.findViewById(R.id.commodity_extra_infos);
                cVar.f19697i = view2.findViewById(R.id.commodity_tail_text_mask);
                view2.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
                view2 = view;
            }
            cVar.f19692d.startLoad(wVar.f13076i, 10, false);
            if (TextUtils.isEmpty(wVar.f13077j)) {
                cVar.f19691c.setVisibility(8);
                cVar.f19693e.setMaxLines(2);
            } else {
                cVar.f19691c.setVisibility(0);
                cVar.f19693e.setMaxLines(1);
            }
            if (TextUtils.isEmpty(wVar.f13077j)) {
                cVar.f19695g.setVisibility(8);
            } else {
                cVar.f19695g.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), wVar.f13077j));
                cVar.f19695g.setVisibility(0);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!TextUtils.isEmpty(wVar.p)) {
                spannableStringBuilder.append((CharSequence) wVar.p);
                int f2 = l.f(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                int f3 = l.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int i3 = R.color.CAM_X0305;
                int f4 = l.f(TbadkCoreApplication.getInst(), R.dimen.T_X10);
                int f5 = l.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                int f6 = l.f(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                int f7 = l.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
                c.a.q0.s.g0.b bVar = new c.a.q0.s.g0.b(f2, -1, i3, f4, i3, f5, l.f(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                bVar.b(f3);
                bVar.h(f6);
                bVar.i(f7);
                spannableStringBuilder.setSpan(bVar, 0, wVar.p.length(), 17);
            }
            if (!wVar.r && wVar.f13073f != 2 && !wVar.m) {
                String str = wVar.f13078k;
                if (str != null) {
                    spannableStringBuilder.append((CharSequence) str);
                }
                cVar.f19693e.setMaxLines(1);
            } else {
                String str2 = wVar.f13074g;
                if (str2 != null) {
                    spannableStringBuilder.append((CharSequence) str2);
                }
            }
            cVar.f19693e.setText(spannableStringBuilder);
            cVar.f19694f.setOnClickListener(new a(this, i2));
            l.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            View view3 = cVar.a;
            int i4 = R.color.CAM_X0205;
            SkinManager.setBackgroundShapeDrawable(view3, 0, i4, i4);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(cVar.f19690b);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            cVar.f19694f.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
            SkinManager.setViewTextColor(cVar.f19693e, R.color.CAM_X0105);
            SkinManager.setViewTextColor(cVar.f19695g, R.color.CAM_X0305);
            SkinManager.setViewTextColor(cVar.f19696h, R.color.CAM_X0109);
            SkinManager.setBackgroundColorToTransparent(cVar.f19697i, R.color.CAM_X0206, GradientDrawable.Orientation.RIGHT_LEFT);
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

    public void i(LinkedList<c.a.q0.s.g0.s.a> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, linkedList) == null) {
            this.f19685f = linkedList;
        }
    }

    public void j(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.f19687h = bVar;
        }
    }
}
