package c.a.p0.t3;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.SignAllForumActivity;
import com.baidu.tieba.signall.SignSingleModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<d> a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.t3.c f18633b;

    /* renamed from: c  reason: collision with root package name */
    public SignAllForumActivity f18634c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, SignSingleModel> f18635d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18636e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18637f;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f18638b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f18639c;

        public a(g gVar, d dVar, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, dVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18639c = gVar;
            this.a = dVar;
            this.f18638b = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.k()) {
                return;
            }
            this.f18638b.i.setVisibility(4);
            this.f18638b.j.setVisibility(0);
            this.f18638b.k.setText(R.string.obfuscated_res_0x7f0f1172);
            this.a.t(true);
            SignSingleModel signSingleModel = new SignSingleModel(this.f18639c.f18634c);
            signSingleModel.H(this.f18639c);
            String str = this.a.c() + "";
            synchronized (this.f18639c) {
                this.f18639c.f18635d.put(str, signSingleModel);
            }
            signSingleModel.I(this.a.d(), str);
            TiebaStatic.log("signall_resign_click");
        }
    }

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f18640b;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BarImageView a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f18641b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f18642c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f18643d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f18644e;

        /* renamed from: f  reason: collision with root package name */
        public FrameLayout f18645f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f18646g;

        /* renamed from: h  reason: collision with root package name */
        public RelativeLayout f18647h;
        public ImageView i;
        public ProgressBar j;
        public TextView k;
        public TextView l;
        public TextView m;

        public c(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {signAllForumActivity, textView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
        this.f18635d = new HashMap<>();
        this.f18637f = true;
        this.f18634c = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.b
    public void a(SignData signData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, signData) == null) {
            String str = signData.forumId;
            synchronized (this) {
                this.f18635d.remove(str);
            }
            i(str, true, signData, null);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f18636e = true;
            synchronized (this) {
                try {
                    for (Map.Entry<String, SignSingleModel> entry : this.f18635d.entrySet()) {
                        entry.getValue().G();
                    }
                    this.f18635d.clear();
                }
            }
        }
    }

    public final View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            View inflate = LayoutInflater.from(this.f18634c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0779, (ViewGroup) null);
            NoDataView a2 = NoDataViewFactory.a(this.f18634c.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091cfd), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.FINDBAR, this.f18634c.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.e.d(null, this.f18634c.getResources().getString(R.string.obfuscated_res_0x7f0f0c27)), null);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f18634c.getLayoutMode().k(skinType == 1);
            this.f18634c.getLayoutMode().j(inflate);
            a2.f(this.f18634c.getPageContext(), skinType);
            a2.setVisibility(0);
            a2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public final View f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i == 0) {
                View inflate = LayoutInflater.from(this.f18634c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d077d, (ViewGroup) null);
                c cVar = new c(this);
                BarImageView barImageView = (BarImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091d0f);
                cVar.a = barImageView;
                barImageView.setIsRound(false);
                cVar.a.setGifIconSupport(false);
                cVar.f18642c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091d16);
                cVar.f18643d = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091d14);
                cVar.f18644e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091d12);
                cVar.f18645f = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091d17);
                cVar.f18646g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091d10);
                cVar.f18647h = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091d18);
                cVar.i = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091d19);
                cVar.j = (ProgressBar) inflate.findViewById(R.id.obfuscated_res_0x7f091d1b);
                cVar.k = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091d1c);
                cVar.l = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091d11);
                cVar.f18641b = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091d15);
                cVar.m = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091d13);
                inflate.setTag(cVar);
                return inflate;
            }
            View inflate2 = LayoutInflater.from(this.f18634c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d077c, (ViewGroup) null);
            b bVar = new b(this);
            bVar.a = (TextView) inflate2.findViewById(R.id.obfuscated_res_0x7f091d0d);
            bVar.f18640b = (TextView) inflate2.findViewById(R.id.obfuscated_res_0x7f091d0c);
            inflate2.setTag(bVar);
            return inflate2;
        }
        return (View) invokeI.objValue;
    }

    public final void g(View view, View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, view, view2, i) == null) {
            this.f18634c.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f18634c.getLayoutMode().j(view);
            c cVar = (c) view.getTag();
            d dVar = (d) getItem(i);
            if (dVar == null) {
                return;
            }
            String d2 = dVar.d();
            if (d2 != null && d2.length() > 8) {
                char[] charArray = d2.toCharArray();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i2 >= charArray.length) {
                        break;
                    }
                    i3 = StringUtils.isChinese(charArray[i2]) ? i3 + 2 : i3 + 1;
                    if (i3 > 16) {
                        d2 = d2.substring(0, i2) + StringHelper.STRING_MORE;
                        break;
                    }
                    i2++;
                }
            }
            cVar.f18642c.setText(d2);
            SkinManager.setImageResource(cVar.f18643d, BitmapHelper.getSmallGradeResourceIdNew(dVar.i()));
            cVar.f18644e.setText(dVar.h() + "/" + dVar.g());
            cVar.m.clearAnimation();
            if (dVar.l()) {
                cVar.f18641b.setVisibility(0);
                cVar.l.setVisibility(8);
                cVar.f18646g.setVisibility(0);
                cVar.f18647h.setVisibility(8);
                cVar.f18646g.setText(String.format(this.f18634c.getPageContext().getString(R.string.obfuscated_res_0x7f0f116b), Integer.valueOf(dVar.b())));
                if (dVar.m()) {
                    cVar.f18644e.setText(this.f18634c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1175));
                    cVar.m.setVisibility(8);
                } else {
                    cVar.f18644e.setText(dVar.h() + "/" + dVar.g());
                    cVar.m.setVisibility(0);
                }
                int e2 = dVar.e();
                if (e2 > 0) {
                    cVar.m.setVisibility(0);
                    cVar.m.setText(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + e2);
                } else {
                    cVar.m.setVisibility(8);
                }
            } else if (dVar.j()) {
                cVar.f18641b.setVisibility(0);
                cVar.l.setVisibility(8);
                cVar.m.setVisibility(8);
                cVar.f18646g.setVisibility(8);
                cVar.f18647h.setVisibility(0);
                if (dVar.k()) {
                    cVar.i.setVisibility(4);
                    cVar.j.setVisibility(0);
                    cVar.k.setText(R.string.obfuscated_res_0x7f0f1172);
                } else {
                    cVar.i.setVisibility(0);
                    cVar.j.setVisibility(4);
                    cVar.k.setText(R.string.obfuscated_res_0x7f0f1171);
                }
                cVar.f18647h.setOnClickListener(new a(this, dVar, cVar));
            } else {
                cVar.f18646g.setVisibility(8);
                cVar.f18647h.setVisibility(8);
                cVar.m.setVisibility(8);
                cVar.f18641b.setVisibility(0);
                cVar.l.setVisibility(8);
            }
            String a2 = dVar.a();
            cVar.a.setTag(a2);
            cVar.a.setPlaceHolder(1);
            cVar.a.J(a2, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f18637f) {
                return this.a.size();
            }
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (this.a.size() > i) {
                return this.a.get(i);
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? getItem(i) instanceof c.a.p0.t3.b ? 1 : 0 : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view, viewGroup)) == null) {
            if (!this.f18637f) {
                return e();
            }
            int itemViewType = getItemViewType(i);
            if (view == null) {
                view = f(itemViewType);
            }
            if (itemViewType == 1) {
                if (view.getTag() != null && (view.getTag() instanceof b)) {
                    bVar = (b) view.getTag();
                } else {
                    view = f(itemViewType);
                    bVar = (b) view.getTag();
                }
                this.f18634c.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.f18634c.getLayoutMode().j(view.findViewById(R.id.obfuscated_res_0x7f091cff));
                bVar.a.setText(((c.a.p0.t3.b) getItem(i)).x());
                j(bVar.f18640b, i);
            } else {
                if (view.getTag() == null || !(view.getTag() instanceof c)) {
                    view = f(itemViewType);
                }
                g(view, viewGroup, i);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public void h(c.a.p0.t3.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) || cVar == null) {
            return;
        }
        this.f18633b = cVar;
        ArrayList<d> k = cVar.k();
        this.a = k;
        if (k.size() == 0) {
            this.f18637f = false;
        } else {
            this.f18637f = true;
        }
        notifyDataSetChanged();
    }

    public final void i(String str, boolean z, SignData signData, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, Boolean.valueOf(z), signData, str2}) == null) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                d dVar = this.a.get(i);
                if ((dVar.c() + "").equals(str)) {
                    dVar.u(z);
                    dVar.s(!z);
                    dVar.t(false);
                    if (z) {
                        dVar.o(signData.count_sign_num);
                        dVar.q(signData.sign_bonus_point);
                        dVar.r(1);
                        TbadkApplication.getInst().addSignedForum(dVar.d(), signData.sign_bonus_point, -1);
                        ArrayList<d> x = this.f18633b.x();
                        if (x.contains(dVar)) {
                            x.remove(dVar);
                            this.f18633b.r().add(dVar);
                        }
                    } else {
                        dVar.p(str2);
                    }
                    if (this.f18636e) {
                        return;
                    }
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }

    public final void j(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, textView, i) == null) {
            c.a.p0.t3.c cVar = this.f18633b;
            int l = cVar == null ? 7 : cVar.l();
            ArrayList<d> arrayList = this.a;
            if (arrayList == null || arrayList.size() <= 0) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
            } else {
                Iterator<d> it = this.a.iterator();
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                while (it.hasNext()) {
                    d next = it.next();
                    if (!TextUtils.isEmpty(next.d())) {
                        if (next.i() >= l) {
                            if (next.l()) {
                                i2++;
                            } else {
                                i3++;
                            }
                        } else if (next.l()) {
                            i4++;
                        } else {
                            i5++;
                        }
                    }
                }
            }
            if (i == 0 && i2 + i3 > 0) {
                format = String.format(this.f18634c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1170), Integer.valueOf(i2), Integer.valueOf(i3));
            } else {
                format = String.format(this.f18634c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1170), Integer.valueOf(i4), Integer.valueOf(i5));
            }
            textView.setText(format);
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.b
    public void onError(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            if (!TextUtils.isEmpty(str2)) {
                n.N(this.f18634c.getPageContext().getPageActivity(), str2);
            }
            synchronized (this) {
                this.f18635d.remove(str);
            }
            i(str, false, null, str2);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048591, this, absListView, i, i2, i3) == null) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048592, this, absListView, i) == null) && i == 0) {
            notifyDataSetChanged();
        }
    }
}
