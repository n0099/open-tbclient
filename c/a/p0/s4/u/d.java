package c.a.p0.s4.u;

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
import c.a.o0.r.r.w;
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
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedList<c.a.o0.r.l0.s.a> f18482b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<w> f18483c;

    /* renamed from: d  reason: collision with root package name */
    public b f18484d;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f18485b;

        public a(d dVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18485b = dVar;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.o0.r.l0.s.a g2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (g2 = this.f18485b.g(this.a)) == null) {
                return;
            }
            if (this.f18485b.f18484d != null) {
                this.f18485b.f18484d.b(g2.e());
            }
            if (this.f18485b.f18484d != null) {
                this.f18485b.f18484d.a(this.f18485b.f18483c);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(List<w> list);

        void b(int i);
    }

    /* loaded from: classes2.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public View f18486b;

        /* renamed from: c  reason: collision with root package name */
        public View f18487c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f18488d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f18489e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f18490f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f18491g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f18492h;
        public View i;

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18483c = new LinkedList<>();
        this.a = tbPageContext;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f18483c.clear();
            if (ListUtils.isEmpty(this.f18482b)) {
                return;
            }
            Iterator<c.a.o0.r.l0.s.a> it = this.f18482b.iterator();
            while (it.hasNext()) {
                c.a.o0.r.l0.s.a next = it.next();
                if (next.h() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.t() != null) {
                        w t = tbLinkSpanGroup.t();
                        t.p = tbLinkSpanGroup.f();
                        this.f18483c.add(t);
                    }
                }
            }
            Collections.sort(this.f18483c);
        }
    }

    public LinkedList<w> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18483c : (LinkedList) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (ListUtils.isEmpty(this.f18483c)) {
                return true;
            }
            Iterator<w> it = this.f18483c.iterator();
            while (it.hasNext()) {
                w next = it.next();
                if (next.f10972b == 2 || !next.i) {
                    return false;
                }
                while (it.hasNext()) {
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public LinkedList<c.a.o0.r.l0.s.a> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18482b : (LinkedList) invokeV.objValue;
    }

    public c.a.o0.r.l0.s.a g(int i) {
        InterceptResult invokeI;
        LinkedList<c.a.o0.r.l0.s.a> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            long itemId = getItemId(i);
            if (itemId != 0 && (linkedList = this.f18482b) != null) {
                Iterator<c.a.o0.r.l0.s.a> it = linkedList.iterator();
                while (it.hasNext()) {
                    c.a.o0.r.l0.s.a next = it.next();
                    if (next.e() == itemId) {
                        return next;
                    }
                }
            }
            return null;
        }
        return (c.a.o0.r.l0.s.a) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            LinkedList<w> linkedList = this.f18483c;
            if (linkedList == null) {
                return 0;
            }
            return linkedList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            LinkedList<w> linkedList = this.f18483c;
            if (linkedList == null || linkedList.size() <= i) {
                return null;
            }
            return this.f18483c.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            LinkedList<w> linkedList = this.f18483c;
            return (linkedList == null || linkedList.size() <= i || this.f18483c.get(i) == null) ? 0 : this.f18483c.get(i).a;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view, viewGroup)) == null) {
            w wVar = (w) getItem(i);
            if (wVar == null) {
                return null;
            }
            if (view == null) {
                view2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d03fb, (ViewGroup) null);
                cVar = new c(this, null);
                cVar.a = view2.findViewById(R.id.obfuscated_res_0x7f09069a);
                cVar.f18486b = view2.findViewById(R.id.obfuscated_res_0x7f090698);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090696);
                cVar.f18488d = tbImageView;
                tbImageView.setConrers(15);
                cVar.f18488d.setRadius(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                cVar.f18488d.setPlaceHolderAutoChangeSkinType(1);
                cVar.f18488d.setGifIconSupport(false);
                cVar.f18488d.setLongIconSupport(false);
                cVar.f18488d.setDrawBorder(true);
                cVar.f18488d.setBorderWidth(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                cVar.f18488d.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                cVar.f18489e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090695);
                cVar.f18490f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090694);
                cVar.f18487c = view2.findViewById(R.id.obfuscated_res_0x7f090946);
                cVar.f18491g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090699);
                cVar.f18492h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090693);
                cVar.i = view2.findViewById(R.id.obfuscated_res_0x7f09069b);
                view2.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
                view2 = view;
            }
            cVar.f18488d.J(wVar.f10975e, 10, false);
            if (TextUtils.isEmpty(wVar.f10976f)) {
                cVar.f18487c.setVisibility(8);
                cVar.f18489e.setMaxLines(2);
            } else {
                cVar.f18487c.setVisibility(0);
                cVar.f18489e.setMaxLines(1);
            }
            if (TextUtils.isEmpty(wVar.f10976f)) {
                cVar.f18491g.setVisibility(8);
            } else {
                cVar.f18491g.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0401), wVar.f10976f));
                cVar.f18491g.setVisibility(0);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!TextUtils.isEmpty(wVar.l)) {
                spannableStringBuilder.append((CharSequence) wVar.l);
                int f2 = n.f(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                int f3 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int f4 = n.f(TbadkCoreApplication.getInst(), R.dimen.T_X10);
                int f5 = n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                int f6 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                int f7 = n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
                c.a.o0.r.l0.b bVar = new c.a.o0.r.l0.b(f2, -1, R.color.CAM_X0305, f4, R.color.CAM_X0305, f5, n.f(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                bVar.b(f3);
                bVar.h(f6);
                bVar.i(f7);
                spannableStringBuilder.setSpan(bVar, 0, wVar.l.length(), 17);
            }
            if (!wVar.n && wVar.f10972b != 2 && !wVar.i) {
                String str = wVar.f10977g;
                if (str != null) {
                    spannableStringBuilder.append((CharSequence) str);
                }
                cVar.f18489e.setMaxLines(1);
            } else {
                String str2 = wVar.f10973c;
                if (str2 != null) {
                    spannableStringBuilder.append((CharSequence) str2);
                }
            }
            cVar.f18489e.setText(spannableStringBuilder);
            cVar.f18490f.setOnClickListener(new a(this, i));
            n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            SkinManager.setBackgroundShapeDrawable(cVar.a, 0, R.color.CAM_X0205, R.color.CAM_X0205);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(cVar.f18486b);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            cVar.f18490f.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08080f, WebPManager.ResourceStateType.NORMAL));
            SkinManager.setViewTextColor(cVar.f18489e, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(cVar.f18491g, (int) R.color.CAM_X0305);
            SkinManager.setViewTextColor(cVar.f18492h, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundColorToTransparent(cVar.i, R.color.CAM_X0206, GradientDrawable.Orientation.RIGHT_LEFT);
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

    public void i(LinkedList<c.a.o0.r.l0.s.a> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, linkedList) == null) {
            this.f18482b = linkedList;
        }
    }

    public void j(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.f18484d = bVar;
        }
    }
}
