package c.a.q0.v.d.f.a;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.e.e.p.k;
import c.a.p0.s.q.c2;
import c.a.q0.v.d.f.b.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends c.a.q0.v.d.f.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public long f25268i;

    /* renamed from: j  reason: collision with root package name */
    public InterfaceC1179c f25269j;
    public Drawable k;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.v.d.f.b.b f25270e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f25271f;

        public a(c cVar, c.a.q0.v.d.f.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25271f = cVar;
            this.f25270e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25271f.f25269j == null) {
                return;
            }
            this.f25271f.f25269j.a(this.f25270e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.v.d.f.b.b f25272e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MetaData f25273f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f25274g;

        public b(c cVar, c.a.q0.v.d.f.b.b bVar, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25274g = cVar;
            this.f25272e = bVar;
            this.f25273f = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                boolean g2 = this.f25274g.g(this.f25272e.f25287d);
                StatisticItem statisticItem = new StatisticItem("c12661");
                statisticItem.param("obj_id", this.f25272e.f25284a.J().getUserId());
                statisticItem.param("obj_type", g2 ? 1 : 0);
                TiebaStatic.log(statisticItem);
                if (!this.f25274g.g(this.f25272e.f25287d)) {
                    this.f25274g.h(this.f25273f);
                    return;
                }
                c cVar = this.f25274g;
                cVar.b(cVar.f25256e, this.f25272e.f25284a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_WHOLE_TAB);
            }
        }
    }

    /* renamed from: c.a.q0.v.d.f.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1179c {
        void a(c.a.q0.v.d.f.b.b bVar);
    }

    /* loaded from: classes3.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f25275a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f25276b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f25277c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f25278d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f25279e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f25280f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f25281g;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(c cVar, a aVar) {
            this(cVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25268i = c.a.e.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.k = SkinManager.getDrawable(this.f25257f.getResources(), R.drawable.icon_video_direct_seeding);
    }

    public final boolean g(List<b.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.f25288a) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view2;
        d dVar;
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                dVar = new d(this, null);
                view2 = LayoutInflater.from(this.f25257f).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_whole_img);
                dVar.f25275a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
                dVar.f25275a.setIsRound(true);
                dVar.f25275a.setAutoChangeStyle(false);
                dVar.f25275a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                dVar.f25276b = (TextView) view2.findViewById(R.id.recent_history_whole_user_name);
                dVar.f25277c = (TextView) view2.findViewById(R.id.recent_history_whole_living_tag);
                dVar.f25278d = (TextView) view2.findViewById(R.id.recent_history_whole_send_gift_tag);
                dVar.f25279e = (TextView) view2.findViewById(R.id.recent_history_whole_live_begin_time);
                dVar.f25280f = (TextView) view2.findViewById(R.id.recent_history_whole_follow_btn);
                dVar.f25281g = (TextView) view2.findViewById(R.id.recent_history_whole_unfollow_btn);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                SkinManager.setViewTextColor(dVar.f25276b, R.color.CAM_X0105);
                SkinManager.setViewTextColor(dVar.f25279e, R.color.CAM_X0109);
                SkinManager.setViewTextColor(dVar.f25280f, R.color.CAM_X0110);
                SkinManager.setViewTextColor(dVar.f25281g, R.color.square_follow_btn_txt_color);
                dVar.f25277c.setCompoundDrawablesWithIntrinsicBounds(this.k, (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(dVar.f25278d, R.color.CAM_X0301);
                view2.setTag(dVar);
            } else {
                view2 = view;
                dVar = (d) view.getTag();
            }
            c.a.q0.v.d.f.b.b item = getItem(i2);
            if (item != null && (c2Var = item.f25284a) != null && c2Var.J() != null) {
                com.baidu.tbadk.core.data.MetaData J = item.f25284a.J();
                int i3 = 12;
                dVar.f25275a.startLoad(J.getPortrait(), 12, false);
                this.f25259h = 0;
                dVar.f25277c.setVisibility(8);
                dVar.f25278d.setVisibility(8);
                if (!ListUtils.isEmpty(item.f25287d)) {
                    for (b.a aVar : item.f25287d) {
                        if (aVar != null) {
                            int i4 = aVar.f25288a;
                            if (1 == i4) {
                                dVar.f25277c.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f25289b)) {
                                    dVar.f25277c.setText(aVar.f25289b);
                                }
                                this.f25259h++;
                            } else if (2 == i4) {
                                dVar.f25278d.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f25289b)) {
                                    dVar.f25278d.setText(aVar.f25289b);
                                }
                                this.f25259h++;
                            }
                        }
                    }
                }
                boolean z = item.f25285b;
                String name_show = J.getName_show();
                if (this.f25259h <= 1) {
                    i3 = 14;
                } else if (!z) {
                    i3 = 10;
                }
                if (k.byteLength(name_show) > i3) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i3, "...");
                }
                dVar.f25276b.setText(name_show);
                dVar.f25279e.setText(StringHelper.getFormatTimeShort(item.f25286c * 1000));
                j(z, dVar);
                dVar.f25281g.setOnClickListener(new a(this, item));
                view2.setOnClickListener(new b(this, item, J));
                StatisticItem statisticItem = new StatisticItem("c12660");
                statisticItem.param("obj_id", item.f25284a.J().getUserId());
                c.a.q0.v.d.e.a.c().a(statisticItem);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, metaData) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f25257f).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.f25268i).equals(metaData.getUserId()), metaData.isBigV())));
        }
    }

    public void i(InterfaceC1179c interfaceC1179c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC1179c) == null) {
            this.f25269j = interfaceC1179c;
        }
    }

    public final void j(boolean z, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, dVar) == null) {
            if (z) {
                dVar.f25281g.setVisibility(8);
                dVar.f25280f.setVisibility(0);
                dVar.f25280f.setEnabled(false);
                return;
            }
            dVar.f25280f.setVisibility(8);
            dVar.f25281g.setVisibility(0);
        }
    }
}
