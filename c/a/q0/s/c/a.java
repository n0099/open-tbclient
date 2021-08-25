package c.a.q0.s.c;

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
import c.a.e.e.p.l;
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

    /* renamed from: e  reason: collision with root package name */
    public Context f24197e;

    /* renamed from: f  reason: collision with root package name */
    public List<c.a.p0.t.f.a> f24198f;

    /* renamed from: g  reason: collision with root package name */
    public int f24199g;

    /* renamed from: h  reason: collision with root package name */
    public int f24200h;

    /* renamed from: i  reason: collision with root package name */
    public int f24201i;

    /* renamed from: j  reason: collision with root package name */
    public int f24202j;
    public Drawable k;
    public Drawable l;
    public int m;
    public boolean n;

    /* renamed from: c.a.q0.s.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C1115a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f24203a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f24204b;

        /* renamed from: c  reason: collision with root package name */
        public View f24205c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f24206d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f24207e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar, C1115a c1115a) {
            this(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f24208a;

        /* renamed from: b  reason: collision with root package name */
        public View f24209b;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(a aVar, C1115a c1115a) {
            this(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ImageView f24210a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f24211b;

        /* renamed from: c  reason: collision with root package name */
        public View f24212c;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(a aVar, C1115a c1115a) {
            this(aVar);
        }
    }

    public a(Context context, c.a.p0.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = true;
        this.f24197e = context;
        this.f24200h = R.color.CAM_X0105;
        this.f24201i = R.color.CAM_X0108;
        this.f24202j = R.color.CAM_X0109;
        this.m = l.g(context, R.dimen.ds24);
        this.n = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true : invokeL.booleanValue;
    }

    public boolean b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? j2 > 0 && j2 < Long.MAX_VALUE : invokeJ.booleanValue;
    }

    public final void c(TextView textView, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, textView, i2) == null) {
            if (i2 <= 0) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            SkinManager.setViewTextColor(textView, R.color.common_color_10225, 1);
            if (i2 < 10) {
                textView.setText(String.valueOf(i2));
                i3 = R.drawable.icon_news_head_prompt_one;
            } else if (i2 < 100) {
                textView.setText(String.valueOf(i2));
                i3 = R.drawable.icon_news_head_prompt_two;
            } else {
                textView.setText("99+");
                i3 = R.drawable.icon_news_head_prompt_two;
            }
            SkinManager.setBackgroundResource(textView, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public c.a.p0.t.f.a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int i3 = this.n ? 3 : 2;
            if (i2 < i3 || i2 >= getCount()) {
                return null;
            }
            return this.f24198f.get(i2 - i3);
        }
        return (c.a.p0.t.f.a) invokeI.objValue;
    }

    public void e(List<c.a.p0.t.f.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f24198f = list;
            notifyDataSetChanged();
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f24199g = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i2 = this.n ? 3 : 2;
            List<c.a.p0.t.f.a> list = this.f24198f;
            return list == null ? i2 : list.size() + i2;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            c.a.p0.t.f.a item = getItem(i2);
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 1) {
                return 5;
            }
            if (i2 == 2 && this.n) {
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
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        c cVar;
        d dVar;
        d dVar2;
        d dVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i2, view, viewGroup)) == null) {
            if (getItemViewType(i2) == 4) {
                return null;
            }
            if (getItemViewType(i2) == 0) {
                if (view != 0 && view.getTag() != null && (view.getTag() instanceof d)) {
                    dVar3 = (d) view.getTag();
                } else {
                    view = LayoutInflater.from(this.f24197e).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                    dVar3 = new d(this, null);
                    dVar3.f24210a = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                    dVar3.f24211b = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                    dVar3.f24212c = view.findViewById(R.id.addresslist_new_friend_divider);
                    view.setTag(dVar3);
                }
                SkinManager.setImageResource(dVar3.f24210a, R.drawable.icon_new_friend);
                SkinManager.setViewTextColor(dVar3.f24211b, this.f24200h, 1);
                SkinManager.setBackgroundResource(dVar3.f24212c, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                c((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.f24199g);
                return view;
            } else if (getItemViewType(i2) == 5) {
                if (view != 0 && view.getTag() != null && (view.getTag() instanceof d)) {
                    dVar2 = (d) view.getTag();
                } else {
                    view = LayoutInflater.from(this.f24197e).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                    dVar2 = new d(this, null);
                    dVar2.f24210a = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                    dVar2.f24211b = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                    dVar2.f24212c = view.findViewById(R.id.addresslist_new_friend_divider);
                    view.setTag(dVar2);
                }
                SkinManager.setImageResource(dVar2.f24210a, R.drawable.icon_add_friend);
                SkinManager.setViewTextColor(dVar2.f24211b, this.f24200h, 1);
                dVar2.f24211b.setText(this.f24197e.getResources().getString(R.string.find_new_friend));
                SkinManager.setBackgroundResource(dVar2.f24212c, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
                return view;
            } else if (getItemViewType(i2) == 1) {
                if (view != 0 && view.getTag() != null && (view.getTag() instanceof d)) {
                    dVar = (d) view.getTag();
                } else {
                    view = LayoutInflater.from(this.f24197e).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                    dVar = new d(this, null);
                    dVar.f24210a = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                    dVar.f24211b = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                    view.setTag(dVar);
                }
                SkinManager.setImageResource(dVar.f24210a, R.drawable.icon_me_group);
                SkinManager.setViewTextColor(dVar.f24211b, this.f24200h, 1);
                SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                c.a.p0.t.f.a item = getItem(i2);
                if (getItemViewType(i2) == 2) {
                    if (view != null && view.getTag() != null && (view.getTag() instanceof c)) {
                        cVar = (c) view.getTag();
                    } else {
                        view = LayoutInflater.from(this.f24197e).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                        cVar = new c(this, null);
                        cVar.f24208a = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                        cVar.f24209b = view.findViewById(R.id.addresslist_group_item_divider);
                        view.setTag(cVar);
                    }
                    if (item.a() != null) {
                        cVar.f24208a.setText(item.a());
                    }
                    SkinManager.setViewTextColor(cVar.f24208a, this.f24201i, 1);
                    SkinManager.setBackgroundResource(cVar.f24209b, R.color.CAM_X0204);
                    return view;
                } else if (getItemViewType(i2) == 3) {
                    if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
                        bVar = (b) view.getTag();
                    } else {
                        bVar = new b(this, null);
                        view = LayoutInflater.from(this.f24197e).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                        bVar.f24203a = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                        bVar.f24204b = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                        bVar.f24206d = (TextView) view.findViewById(R.id.detail_info_distance);
                        bVar.f24207e = (TextView) view.findViewById(R.id.detail_info_time);
                        bVar.f24205c = view.findViewById(R.id.addresslist_child_item_divider);
                        view.setTag(bVar);
                    }
                    if (item.f() != null) {
                        bVar.f24204b.setText(item.f());
                        bVar.f24203a.startLoad(item.h(), 12, false);
                    }
                    item.l(null);
                    if (item.b() != null) {
                        if (item.b().b() == 1) {
                            bVar.f24206d.setVisibility(0);
                            SkinManager.setViewTextColor(bVar.f24206d, this.f24202j, 1);
                            bVar.f24206d.setText(this.f24197e.getResources().getString(R.string.contact_yinshen));
                            bVar.f24206d.setCompoundDrawables(null, null, null, null);
                            bVar.f24207e.setVisibility(8);
                        } else if (item.b().b() == 0) {
                            if (a(item.b().a()) && b(item.b().c())) {
                                bVar.f24206d.setVisibility(0);
                                bVar.f24207e.setVisibility(0);
                                bVar.f24206d.setText(item.b().a());
                                bVar.f24207e.setText(StringHelper.getTimeInterval(item.b().c()));
                                SkinManager.setViewTextColor(bVar.f24206d, this.f24202j, 1);
                                Drawable drawable = SkinManager.getDrawable(R.drawable.icon_friend_pin);
                                this.k = drawable;
                                int i3 = this.m;
                                drawable.setBounds(0, 0, i3, i3);
                                bVar.f24206d.setCompoundDrawables(this.k, null, null, null);
                                Drawable drawable2 = SkinManager.getDrawable(R.drawable.icon_friend_time);
                                this.l = drawable2;
                                int i4 = this.m;
                                drawable2.setBounds(0, 0, i4, i4);
                                bVar.f24207e.setCompoundDrawables(this.l, null, null, null);
                                SkinManager.setViewTextColor(bVar.f24207e, this.f24202j, 1);
                            } else {
                                bVar.f24206d.setVisibility(8);
                                bVar.f24207e.setVisibility(8);
                            }
                        } else {
                            bVar.f24206d.setVisibility(8);
                            bVar.f24207e.setVisibility(8);
                        }
                    } else {
                        bVar.f24206d.setVisibility(8);
                        bVar.f24207e.setVisibility(8);
                    }
                    SkinManager.setViewTextColor(bVar.f24204b, this.f24200h, 1);
                    String a2 = item.a();
                    c.a.p0.t.f.a item2 = getItem(i2 + 1);
                    if ((TextUtils.isEmpty(a2) || item2 == null || a2.equals(item2.a())) ? false : true) {
                        bVar.f24205c.setVisibility(4);
                    } else {
                        bVar.f24205c.setVisibility(0);
                        SkinManager.setBackgroundResource(bVar.f24205c, R.color.CAM_X0204);
                    }
                    SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                    SkinManager.setViewTextColor(bVar.f24204b, this.f24200h, 1);
                    SkinManager.setBackgroundResource(bVar.f24205c, R.color.CAM_X0204);
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
