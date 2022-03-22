package c.a.p0.v3.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import c.a.d.a.e;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.forumlist.SquareForumListActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tbclient.GetForumsFromForumClass.ForumSpaceForumInfo;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Long, Integer> a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<SquareForumListActivity> f19243b;

    /* renamed from: c  reason: collision with root package name */
    public int f19244c;

    /* renamed from: d  reason: collision with root package name */
    public List<ForumSpaceForumInfo> f19245d;

    /* renamed from: e  reason: collision with root package name */
    public LikeModel f19246e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f19247f;

    /* renamed from: c.a.p0.v3.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1456a extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1456a(a aVar) {
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
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && AntiHelper.m(this.a.f19246e.getErrorCode(), this.a.f19246e.getErrorString())) {
                AntiHelper.u(this.a.f19243b.getPageActivity(), this.a.f19246e.getErrorString());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String valueOf;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.obfuscated_res_0x7f090a58) {
                    if (!l.z()) {
                        this.a.f19243b.showToast(R.string.obfuscated_res_0x7f0f0c15);
                    } else if (ViewHelper.checkUpIsLogin(this.a.f19243b.getPageActivity())) {
                        String valueOf2 = view.getTag(R.id.obfuscated_res_0x7f090a93) == null ? "" : String.valueOf(view.getTag(R.id.obfuscated_res_0x7f090a93));
                        valueOf = view.getTag(R.id.obfuscated_res_0x7f090a29) != null ? String.valueOf(view.getTag(R.id.obfuscated_res_0x7f090a29)) : "";
                        this.a.f19246e.P(valueOf2, valueOf);
                        if (this.a.f19244c != 1) {
                            if (this.a.f19244c == 2) {
                                TiebaStatic.log(new StatisticItem("c10587").param("fid", valueOf));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new StatisticItem("c10566").param("fid", valueOf));
                    }
                } else if (view.getId() != R.id.obfuscated_res_0x7f091d6a) {
                    String valueOf3 = view.getTag(R.id.obfuscated_res_0x7f090a93) == null ? "" : String.valueOf(view.getTag(R.id.obfuscated_res_0x7f090a93));
                    valueOf = view.getTag(R.id.obfuscated_res_0x7f090a29) != null ? String.valueOf(view.getTag(R.id.obfuscated_res_0x7f090a29)) : "";
                    this.a.f19243b.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.f19243b.getContext()).createNormalCfg(valueOf3, null)));
                    if (this.a.f19244c != 1) {
                        if (this.a.f19244c == 2) {
                            TiebaStatic.log(new StatisticItem("c10586").param("obj_type", 1).param("fid", valueOf));
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c10565").param("obj_type", 1).param("fid", valueOf));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f19248b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f19249c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f19250d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f19251e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f19252f;

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

        public /* synthetic */ c(a aVar, C1456a c1456a) {
            this(aVar);
        }
    }

    public a(TbPageContext<SquareForumListActivity> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        this.f19243b = tbPageContext;
        this.f19244c = i;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f19246e = likeModel;
        likeModel.setLoadDataCallBack(new C1456a(this));
        this.f19247f = new b(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public ForumSpaceForumInfo getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (getCount() > 1 && i != 0) {
                return (ForumSpaceForumInfo) ListUtils.getItem(this.f19245d, i - 1);
            }
            return null;
        }
        return (ForumSpaceForumInfo) invokeI.objValue;
    }

    public void e(List<ForumSpaceForumInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f19245d = list;
            notifyDataSetChanged();
        }
    }

    public void f(Long l, boolean z) {
        Integer valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, l, z) == null) {
            if (this.a.containsKey(l)) {
                Integer num = this.a.get(l);
                if (z) {
                    valueOf = Integer.valueOf(num.intValue() + 1);
                } else {
                    valueOf = Integer.valueOf(num.intValue() - 1);
                }
                this.a.put(l, valueOf);
            } else if (!this.a.containsKey(l)) {
                this.a.put(l, z ? 1 : -1);
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (ListUtils.getCount(this.f19245d) > 0) {
                return ListUtils.getCount(this.f19245d) + 1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view, viewGroup)) == null) {
            if (i == 0) {
                if (view == null || !(view instanceof TbImageView)) {
                    view = LayoutInflater.from(this.f19243b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d079f, (ViewGroup) null);
                }
                SkinManager.setImageResource((TbImageView) view, this.f19244c == 1 ? R.drawable.pic_batuijian_bg_red : R.drawable.pic_batuijian_bg_yellow);
                SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
                return view;
            }
            ForumSpaceForumInfo item = getItem(i);
            if (item == null) {
                return null;
            }
            if (view == null || !(view.getTag(R.id.obfuscated_res_0x7f090a6c) instanceof c)) {
                view = LayoutInflater.from(this.f19243b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d07a0, (ViewGroup) null);
                c cVar = new c(this, null);
                cVar.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090a6c);
                cVar.f19248b = (BarImageView) view.findViewById(R.id.obfuscated_res_0x7f090a4c);
                cVar.f19252f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090a58);
                cVar.f19249c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090a93);
                cVar.f19250d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090a29);
                cVar.f19251e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090a9d);
                n.b(this.f19243b.getPageActivity(), cVar.f19252f, 20, 20, 20, 20);
                cVar.f19252f.setOnClickListener(this.f19247f);
                view.setOnClickListener(this.f19247f);
                view.setTag(R.id.obfuscated_res_0x7f090a6c, cVar);
            }
            SkinManager.setBackgroundResource(view, R.drawable.square_list_item_bg_selector);
            c cVar2 = (c) view.getTag(R.id.obfuscated_res_0x7f090a6c);
            if (i == 1) {
                cVar2.a.setText("");
                SkinManager.setBackgroundResource(cVar2.a, R.drawable.icon_grade_shaitu1);
            } else if (i == 2) {
                cVar2.a.setText("");
                SkinManager.setBackgroundResource(cVar2.a, R.drawable.icon_grade_shaitu2);
            } else if (i == 3) {
                cVar2.a.setText("");
                SkinManager.setBackgroundResource(cVar2.a, R.drawable.icon_grade_shaitu3);
            } else if (i < 10) {
                TextView textView = cVar2.a;
                textView.setText("0" + i);
                cVar2.a.setBackgroundResource(0);
            } else {
                TextView textView2 = cVar2.a;
                textView2.setText("" + i);
                cVar2.a.setBackgroundResource(0);
            }
            SkinManager.setViewTextColor(cVar2.a, (int) R.color.CAM_X0108);
            cVar2.f19248b.J(item.avatar, 10, false);
            cVar2.f19249c.setText(item.forum_name + this.f19243b.getString(R.string.obfuscated_res_0x7f0f063c));
            SkinManager.setViewTextColor(cVar2.f19249c, (int) R.color.CAM_X0105);
            Integer num = this.a.get(item.forum_id);
            int intValue = item.like_num.intValue() + (num == null ? 0 : num.intValue());
            cVar2.f19250d.setText(this.f19243b.getString(R.string.obfuscated_res_0x7f0f029b) + ":" + StringHelper.numberUniformFormat(intValue) + GlideException.IndentedAppendable.INDENT + this.f19243b.getString(R.string.obfuscated_res_0x7f0f1385) + ":" + StringHelper.numberUniformFormat(item.post_num.intValue()));
            SkinManager.setViewTextColor(cVar2.f19250d, (int) R.color.CAM_X0109);
            cVar2.f19251e.setText(item._abstract);
            SkinManager.setViewTextColor(cVar2.f19251e, (int) R.color.CAM_X0109);
            cVar2.f19252f.setTag(R.id.obfuscated_res_0x7f090a93, item.forum_name);
            cVar2.f19252f.setTag(R.id.obfuscated_res_0x7f090a29, item.forum_id);
            int intValue2 = this.a.get(item.forum_id) == null ? 0 : this.a.get(item.forum_id).intValue();
            if ((item.is_like.intValue() == 0 && intValue2 > 0) || (item.is_like.intValue() == 1 && intValue2 >= 0)) {
                cVar2.f19252f.setText(R.string.obfuscated_res_0x7f0f0f68);
                cVar2.f19252f.setBackgroundResource(0);
                SkinManager.setViewTextColor(cVar2.f19252f, (int) R.color.CAM_X0109);
            } else {
                cVar2.f19252f.setText(R.string.obfuscated_res_0x7f0f029b);
                cVar2.f19252f.setBackgroundResource(R.drawable.btn_blue_bg);
                SkinManager.setViewTextColor(cVar2.f19252f, (int) R.color.CAM_X0101);
            }
            view.setTag(R.id.obfuscated_res_0x7f090a93, item.forum_name);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
