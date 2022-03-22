package c.a.p0.z.c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.o0.s.f.a> f20817b;

    /* renamed from: c  reason: collision with root package name */
    public int f20818c;

    /* renamed from: d  reason: collision with root package name */
    public int f20819d;

    /* renamed from: e  reason: collision with root package name */
    public int f20820e;

    /* renamed from: f  reason: collision with root package name */
    public int f20821f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f20822g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f20823h;
    public int i;
    public boolean j;

    /* renamed from: c.a.p0.z.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C1556a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f20824b;

        /* renamed from: c  reason: collision with root package name */
        public View f20825c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f20826d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f20827e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar, C1556a c1556a) {
            this(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public View f20828b;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(a aVar, C1556a c1556a) {
            this(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f20829b;

        /* renamed from: c  reason: collision with root package name */
        public View f20830c;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(a aVar, C1556a c1556a) {
            this(aVar);
        }
    }

    public a(Context context, c.a.o0.r.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = true;
        this.a = context;
        this.f20819d = R.color.CAM_X0105;
        this.f20820e = R.color.CAM_X0108;
        this.f20821f = R.color.CAM_X0109;
        this.i = n.f(context, R.dimen.obfuscated_res_0x7f0701e8);
        this.j = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true : invokeL.booleanValue;
    }

    public boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? j > 0 && j < Long.MAX_VALUE : invokeJ.booleanValue;
    }

    public final void c(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, textView, i) == null) {
            if (i <= 0) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            SkinManager.setViewTextColor(textView, R.color.common_color_10225, 1);
            int i2 = R.drawable.icon_news_head_prompt_two;
            if (i < 10) {
                textView.setText(String.valueOf(i));
                i2 = R.drawable.icon_news_head_prompt_one;
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
            } else {
                textView.setText("99+");
            }
            SkinManager.setBackgroundResource(textView, i2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public c.a.o0.s.f.a getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            int i2 = this.j ? 3 : 2;
            if (i < i2 || i >= getCount()) {
                return null;
            }
            return this.f20817b.get(i - i2);
        }
        return (c.a.o0.s.f.a) invokeI.objValue;
    }

    public void e(List<c.a.o0.s.f.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f20817b = list;
            notifyDataSetChanged();
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f20818c = i;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i = this.j ? 3 : 2;
            List<c.a.o0.s.f.a> list = this.f20817b;
            return list == null ? i : list.size() + i;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            c.a.o0.s.f.a item = getItem(i);
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 5;
            }
            if (i == 2 && this.j) {
                return 1;
            }
            if (item == null) {
                return 4;
            }
            return (!TextUtils.isEmpty(item.a()) && TextUtils.isEmpty(item.f()) && TextUtils.isEmpty(item.h())) ? 2 : 3;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        c cVar;
        d dVar;
        d dVar2;
        d dVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i, view, viewGroup)) == null) {
            if (getItemViewType(i) == 4) {
                return null;
            }
            if (getItemViewType(i) == 0) {
                if (view != 0 && view.getTag() != null && (view.getTag() instanceof d)) {
                    dVar3 = (d) view.getTag();
                } else {
                    view = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0083, (ViewGroup) null);
                    dVar3 = new d(this, null);
                    dVar3.a = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090139);
                    dVar3.f20829b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09013b);
                    dVar3.f20830c = view.findViewById(R.id.obfuscated_res_0x7f090138);
                    view.setTag(dVar3);
                }
                SkinManager.setImageResource(dVar3.a, R.drawable.icon_new_friend);
                SkinManager.setViewTextColor(dVar3.f20829b, this.f20819d, 1);
                SkinManager.setBackgroundResource(dVar3.f20830c, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                c((TextView) view.findViewById(R.id.obfuscated_res_0x7f09013a), this.f20818c);
                return view;
            } else if (getItemViewType(i) == 5) {
                if (view != 0 && view.getTag() != null && (view.getTag() instanceof d)) {
                    dVar2 = (d) view.getTag();
                } else {
                    view = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0083, (ViewGroup) null);
                    dVar2 = new d(this, null);
                    dVar2.a = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090139);
                    dVar2.f20829b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09013b);
                    dVar2.f20830c = view.findViewById(R.id.obfuscated_res_0x7f090138);
                    view.setTag(dVar2);
                }
                SkinManager.setImageResource(dVar2.a, R.drawable.icon_add_friend);
                SkinManager.setViewTextColor(dVar2.f20829b, this.f20819d, 1);
                dVar2.f20829b.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0610));
                SkinManager.setBackgroundResource(dVar2.f20830c, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                ((TextView) view.findViewById(R.id.obfuscated_res_0x7f09013a)).setVisibility(8);
                return view;
            } else if (getItemViewType(i) == 1) {
                if (view != 0 && view.getTag() != null && (view.getTag() instanceof d)) {
                    dVar = (d) view.getTag();
                } else {
                    view = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0082, (ViewGroup) null);
                    dVar = new d(this, null);
                    dVar.a = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090136);
                    dVar.f20829b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090137);
                    view.setTag(dVar);
                }
                SkinManager.setImageResource(dVar.a, R.drawable.icon_me_group);
                SkinManager.setViewTextColor(dVar.f20829b, this.f20819d, 1);
                SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                c.a.o0.s.f.a item = getItem(i);
                if (getItemViewType(i) == 2) {
                    if (view != null && view.getTag() != null && (view.getTag() instanceof c)) {
                        cVar = (c) view.getTag();
                    } else {
                        view = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0081, (ViewGroup) null);
                        cVar = new c(this, null);
                        cVar.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090134);
                        cVar.f20828b = view.findViewById(R.id.obfuscated_res_0x7f090133);
                        view.setTag(cVar);
                    }
                    if (item.a() != null) {
                        cVar.a.setText(item.a());
                    }
                    SkinManager.setViewTextColor(cVar.a, this.f20820e, 1);
                    SkinManager.setBackgroundResource(cVar.f20828b, R.color.CAM_X0204);
                    return view;
                } else if (getItemViewType(i) == 3) {
                    if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
                        bVar = (b) view.getTag();
                    } else {
                        bVar = new b(this, null);
                        view = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d007f, (ViewGroup) null);
                        bVar.a = (HeadImageView) view.findViewById(R.id.obfuscated_res_0x7f09012f);
                        bVar.f20824b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090130);
                        bVar.f20826d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09078b);
                        bVar.f20827e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09078c);
                        bVar.f20825c = view.findViewById(R.id.obfuscated_res_0x7f09012e);
                        view.setTag(bVar);
                    }
                    if (item.f() != null) {
                        bVar.f20824b.setText(item.f());
                        bVar.a.J(item.h(), 12, false);
                    }
                    item.l(null);
                    if (item.b() != null) {
                        if (item.b().b() == 1) {
                            bVar.f20826d.setVisibility(0);
                            SkinManager.setViewTextColor(bVar.f20826d, this.f20821f, 1);
                            bVar.f20826d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f042a));
                            bVar.f20826d.setCompoundDrawables(null, null, null, null);
                            bVar.f20827e.setVisibility(8);
                        } else if (item.b().b() == 0) {
                            if (a(item.b().a()) && b(item.b().c())) {
                                bVar.f20826d.setVisibility(0);
                                bVar.f20827e.setVisibility(0);
                                bVar.f20826d.setText(item.b().a());
                                bVar.f20827e.setText(StringHelper.getTimeInterval(item.b().c()));
                                SkinManager.setViewTextColor(bVar.f20826d, this.f20821f, 1);
                                Drawable drawable = SkinManager.getDrawable(R.drawable.icon_friend_pin);
                                this.f20822g = drawable;
                                int i2 = this.i;
                                drawable.setBounds(0, 0, i2, i2);
                                bVar.f20826d.setCompoundDrawables(this.f20822g, null, null, null);
                                Drawable drawable2 = SkinManager.getDrawable(R.drawable.icon_friend_time);
                                this.f20823h = drawable2;
                                int i3 = this.i;
                                drawable2.setBounds(0, 0, i3, i3);
                                bVar.f20827e.setCompoundDrawables(this.f20823h, null, null, null);
                                SkinManager.setViewTextColor(bVar.f20827e, this.f20821f, 1);
                            } else {
                                bVar.f20826d.setVisibility(8);
                                bVar.f20827e.setVisibility(8);
                            }
                        } else {
                            bVar.f20826d.setVisibility(8);
                            bVar.f20827e.setVisibility(8);
                        }
                    } else {
                        bVar.f20826d.setVisibility(8);
                        bVar.f20827e.setVisibility(8);
                    }
                    SkinManager.setViewTextColor(bVar.f20824b, this.f20819d, 1);
                    String a = item.a();
                    c.a.o0.s.f.a item2 = getItem(i + 1);
                    if ((TextUtils.isEmpty(a) || item2 == null || a.equals(item2.a())) ? false : true) {
                        bVar.f20825c.setVisibility(4);
                    } else {
                        bVar.f20825c.setVisibility(0);
                        SkinManager.setBackgroundResource(bVar.f20825c, R.color.CAM_X0204);
                    }
                    SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                    SkinManager.setViewTextColor(bVar.f20824b, this.f20819d, 1);
                    SkinManager.setBackgroundResource(bVar.f20825c, R.color.CAM_X0204);
                    SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                    return view;
                } else {
                    return null;
                }
            }
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 6;
        }
        return invokeV.intValue;
    }
}
