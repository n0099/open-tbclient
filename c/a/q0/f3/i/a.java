package c.a.q0.f3.i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import c.a.e.a.e;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Map<Long, Integer> f18184e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<SquareForumListActivity> f18185f;

    /* renamed from: g  reason: collision with root package name */
    public int f18186g;

    /* renamed from: h  reason: collision with root package name */
    public List<ForumSpaceForumInfo> f18187h;

    /* renamed from: i  reason: collision with root package name */
    public LikeModel f18188i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f18189j;

    /* renamed from: c.a.q0.f3.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0876a extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f18190a;

        public C0876a(a aVar) {
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
                    return;
                }
            }
            this.f18190a = aVar;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && AntiHelper.m(this.f18190a.f18188i.getErrorCode(), this.f18190a.f18188i.getErrorString())) {
                AntiHelper.u(this.f18190a.f18185f.getPageActivity(), this.f18190a.f18188i.getErrorString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f18191e;

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
                    return;
                }
            }
            this.f18191e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String valueOf;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.forum_like) {
                    if (!j.z()) {
                        this.f18191e.f18185f.showToast(R.string.neterror);
                    } else if (ViewHelper.checkUpIsLogin(this.f18191e.f18185f.getPageActivity())) {
                        String valueOf2 = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                        valueOf = view.getTag(R.id.forum_desc) != null ? String.valueOf(view.getTag(R.id.forum_desc)) : "";
                        this.f18191e.f18188i.L(valueOf2, valueOf);
                        if (this.f18191e.f18186g != 1) {
                            if (this.f18191e.f18186g == 2) {
                                TiebaStatic.log(new StatisticItem("c10587").param("fid", valueOf));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new StatisticItem("c10566").param("fid", valueOf));
                    }
                } else if (view.getId() != R.id.square_forum_list_image) {
                    String valueOf3 = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                    valueOf = view.getTag(R.id.forum_desc) != null ? String.valueOf(view.getTag(R.id.forum_desc)) : "";
                    this.f18191e.f18185f.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f18191e.f18185f.getContext()).createNormalCfg(valueOf3, null)));
                    if (this.f18191e.f18186g != 1) {
                        if (this.f18191e.f18186g == 2) {
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

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f18192a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f18193b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f18194c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f18195d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f18196e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f18197f;

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

        public /* synthetic */ c(a aVar, C0876a c0876a) {
            this(aVar);
        }
    }

    public a(TbPageContext<SquareForumListActivity> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18184e = new HashMap();
        this.f18185f = tbPageContext;
        this.f18186g = i2;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f18188i = likeModel;
        likeModel.setLoadDataCallBack(new C0876a(this));
        this.f18189j = new b(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public ForumSpaceForumInfo getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (getCount() > 1 && i2 != 0) {
                return (ForumSpaceForumInfo) ListUtils.getItem(this.f18187h, i2 - 1);
            }
            return null;
        }
        return (ForumSpaceForumInfo) invokeI.objValue;
    }

    public void e(List<ForumSpaceForumInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f18187h = list;
            notifyDataSetChanged();
        }
    }

    public void f(Long l, boolean z) {
        Integer valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, l, z) == null) {
            if (this.f18184e.containsKey(l)) {
                Integer num = this.f18184e.get(l);
                if (z) {
                    valueOf = Integer.valueOf(num.intValue() + 1);
                } else {
                    valueOf = Integer.valueOf(num.intValue() - 1);
                }
                this.f18184e.put(l, valueOf);
            } else if (!this.f18184e.containsKey(l)) {
                this.f18184e.put(l, z ? 1 : -1);
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (ListUtils.getCount(this.f18187h) > 0) {
                return ListUtils.getCount(this.f18187h) + 1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (i2 == 0) {
                if (view == null || !(view instanceof TbImageView)) {
                    view = LayoutInflater.from(this.f18185f.getPageActivity()).inflate(R.layout.square_forum_list_header, (ViewGroup) null);
                }
                SkinManager.setImageResource((TbImageView) view, this.f18186g == 1 ? R.drawable.pic_batuijian_bg_red : R.drawable.pic_batuijian_bg_yellow);
                SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
                return view;
            }
            ForumSpaceForumInfo item = getItem(i2);
            if (item == null) {
                return null;
            }
            if (view == null || !(view.getTag(R.id.forum_rank) instanceof c)) {
                view = LayoutInflater.from(this.f18185f.getPageActivity()).inflate(R.layout.square_forum_list_item, (ViewGroup) null);
                c cVar = new c(this, null);
                cVar.f18192a = (TextView) view.findViewById(R.id.forum_rank);
                cVar.f18193b = (BarImageView) view.findViewById(R.id.forum_image);
                cVar.f18197f = (TextView) view.findViewById(R.id.forum_like);
                cVar.f18194c = (TextView) view.findViewById(R.id.forum_title);
                cVar.f18195d = (TextView) view.findViewById(R.id.forum_desc);
                cVar.f18196e = (TextView) view.findViewById(R.id.forum_value);
                l.c(this.f18185f.getPageActivity(), cVar.f18197f, 20, 20, 20, 20);
                cVar.f18197f.setOnClickListener(this.f18189j);
                view.setOnClickListener(this.f18189j);
                view.setTag(R.id.forum_rank, cVar);
            }
            SkinManager.setBackgroundResource(view, R.drawable.square_list_item_bg_selector);
            c cVar2 = (c) view.getTag(R.id.forum_rank);
            if (i2 == 1) {
                cVar2.f18192a.setText("");
                SkinManager.setBackgroundResource(cVar2.f18192a, R.drawable.icon_grade_shaitu1);
            } else if (i2 == 2) {
                cVar2.f18192a.setText("");
                SkinManager.setBackgroundResource(cVar2.f18192a, R.drawable.icon_grade_shaitu2);
            } else if (i2 == 3) {
                cVar2.f18192a.setText("");
                SkinManager.setBackgroundResource(cVar2.f18192a, R.drawable.icon_grade_shaitu3);
            } else if (i2 < 10) {
                TextView textView = cVar2.f18192a;
                textView.setText("0" + i2);
                cVar2.f18192a.setBackgroundResource(0);
            } else {
                TextView textView2 = cVar2.f18192a;
                textView2.setText("" + i2);
                cVar2.f18192a.setBackgroundResource(0);
            }
            SkinManager.setViewTextColor(cVar2.f18192a, R.color.CAM_X0108);
            cVar2.f18193b.startLoad(item.avatar, 10, false);
            cVar2.f18194c.setText(item.forum_name + this.f18185f.getString(R.string.forum));
            SkinManager.setViewTextColor(cVar2.f18194c, R.color.CAM_X0105);
            Integer num = this.f18184e.get(item.forum_id);
            int intValue = item.like_num.intValue() + (num == null ? 0 : num.intValue());
            cVar2.f18195d.setText(this.f18185f.getString(R.string.attention) + ":" + StringHelper.numberUniformFormat(intValue) + GlideException.IndentedAppendable.INDENT + this.f18185f.getString(R.string.text_post) + ":" + StringHelper.numberUniformFormat(item.post_num.intValue()));
            SkinManager.setViewTextColor(cVar2.f18195d, R.color.CAM_X0109);
            cVar2.f18196e.setText(item._abstract);
            SkinManager.setViewTextColor(cVar2.f18196e, R.color.CAM_X0109);
            cVar2.f18197f.setTag(R.id.forum_title, item.forum_name);
            cVar2.f18197f.setTag(R.id.forum_desc, item.forum_id);
            int intValue2 = this.f18184e.get(item.forum_id) == null ? 0 : this.f18184e.get(item.forum_id).intValue();
            if ((item.is_like.intValue() == 0 && intValue2 > 0) || (item.is_like.intValue() == 1 && intValue2 >= 0)) {
                cVar2.f18197f.setText(R.string.relate_forum_is_followed);
                cVar2.f18197f.setBackgroundResource(0);
                SkinManager.setViewTextColor(cVar2.f18197f, R.color.CAM_X0109);
            } else {
                cVar2.f18197f.setText(R.string.attention);
                cVar2.f18197f.setBackgroundResource(R.drawable.btn_blue_bg);
                SkinManager.setViewTextColor(cVar2.f18197f, R.color.CAM_X0101);
            }
            view.setTag(R.id.forum_title, item.forum_name);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
