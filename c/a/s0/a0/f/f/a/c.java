package c.a.s0.a0.f.f.a;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.r0.s.r.d2;
import c.a.s0.a0.f.f.b.b;
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
/* loaded from: classes6.dex */
public class c extends c.a.s0.a0.f.f.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public long f14433i;

    /* renamed from: j  reason: collision with root package name */
    public InterfaceC0891c f14434j;

    /* renamed from: k  reason: collision with root package name */
    public Drawable f14435k;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a0.f.f.b.b f14436e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f14437f;

        public a(c cVar, c.a.s0.a0.f.f.b.b bVar) {
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
            this.f14437f = cVar;
            this.f14436e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14437f.f14434j == null) {
                return;
            }
            this.f14437f.f14434j.a(this.f14436e);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a0.f.f.b.b f14438e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MetaData f14439f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f14440g;

        public b(c cVar, c.a.s0.a0.f.f.b.b bVar, MetaData metaData) {
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
            this.f14440g = cVar;
            this.f14438e = bVar;
            this.f14439f = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                boolean g2 = this.f14440g.g(this.f14438e.f14450d);
                StatisticItem statisticItem = new StatisticItem("c12661");
                statisticItem.param("obj_id", this.f14438e.a.J().getUserId());
                statisticItem.param("obj_type", g2 ? 1 : 0);
                TiebaStatic.log(statisticItem);
                if (!this.f14440g.g(this.f14438e.f14450d)) {
                    this.f14440g.h(this.f14439f);
                    return;
                }
                c cVar = this.f14440g;
                cVar.b(cVar.f14422e, this.f14438e.a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_WHOLE_TAB);
            }
        }
    }

    /* renamed from: c.a.s0.a0.f.f.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0891c {
        void a(c.a.s0.a0.f.f.b.b bVar);
    }

    /* loaded from: classes6.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14441b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14442c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14443d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f14444e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f14445f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14446g;

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
        this.f14433i = c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.f14435k = SkinManager.getDrawable(this.f14423f.getResources(), R.drawable.icon_video_direct_seeding);
    }

    public final boolean g(List<b.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.a) {
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
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                dVar = new d(this, null);
                view2 = LayoutInflater.from(this.f14423f).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_whole_img);
                dVar.a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
                dVar.a.setIsRound(true);
                dVar.a.setAutoChangeStyle(false);
                dVar.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                dVar.f14441b = (TextView) view2.findViewById(R.id.recent_history_whole_user_name);
                dVar.f14442c = (TextView) view2.findViewById(R.id.recent_history_whole_living_tag);
                dVar.f14443d = (TextView) view2.findViewById(R.id.recent_history_whole_send_gift_tag);
                dVar.f14444e = (TextView) view2.findViewById(R.id.recent_history_whole_live_begin_time);
                dVar.f14445f = (TextView) view2.findViewById(R.id.recent_history_whole_follow_btn);
                dVar.f14446g = (TextView) view2.findViewById(R.id.recent_history_whole_unfollow_btn);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                SkinManager.setViewTextColor(dVar.f14441b, R.color.CAM_X0105);
                SkinManager.setViewTextColor(dVar.f14444e, R.color.CAM_X0109);
                SkinManager.setViewTextColor(dVar.f14445f, R.color.CAM_X0110);
                SkinManager.setViewTextColor(dVar.f14446g, R.color.square_follow_btn_txt_color);
                dVar.f14442c.setCompoundDrawablesWithIntrinsicBounds(this.f14435k, (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(dVar.f14443d, R.color.CAM_X0301);
                view2.setTag(dVar);
            } else {
                view2 = view;
                dVar = (d) view.getTag();
            }
            c.a.s0.a0.f.f.b.b item = getItem(i2);
            if (item != null && (d2Var = item.a) != null && d2Var.J() != null) {
                com.baidu.tbadk.core.data.MetaData J = item.a.J();
                int i3 = 12;
                dVar.a.startLoad(J.getPortrait(), 12, false);
                this.f14425h = 0;
                dVar.f14442c.setVisibility(8);
                dVar.f14443d.setVisibility(8);
                if (!ListUtils.isEmpty(item.f14450d)) {
                    for (b.a aVar : item.f14450d) {
                        if (aVar != null) {
                            int i4 = aVar.a;
                            if (1 == i4) {
                                dVar.f14442c.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f14451b)) {
                                    dVar.f14442c.setText(aVar.f14451b);
                                }
                                this.f14425h++;
                            } else if (2 == i4) {
                                dVar.f14443d.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f14451b)) {
                                    dVar.f14443d.setText(aVar.f14451b);
                                }
                                this.f14425h++;
                            }
                        }
                    }
                }
                boolean z = item.f14448b;
                String name_show = J.getName_show();
                if (this.f14425h <= 1) {
                    i3 = 14;
                } else if (!z) {
                    i3 = 10;
                }
                if (l.byteLength(name_show) > i3) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i3, "...");
                }
                dVar.f14441b.setText(name_show);
                dVar.f14444e.setText(StringHelper.getFormatTimeShort(item.f14449c * 1000));
                j(z, dVar);
                dVar.f14446g.setOnClickListener(new a(this, item));
                view2.setOnClickListener(new b(this, item, J));
                StatisticItem statisticItem = new StatisticItem("c12660");
                statisticItem.param("obj_id", item.a.J().getUserId());
                c.a.s0.a0.f.e.a.c().a(statisticItem);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, metaData) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f14423f).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.f14433i).equals(metaData.getUserId()), metaData.isBigV())));
        }
    }

    public void i(InterfaceC0891c interfaceC0891c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0891c) == null) {
            this.f14434j = interfaceC0891c;
        }
    }

    public final void j(boolean z, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, dVar) == null) {
            if (z) {
                dVar.f14446g.setVisibility(8);
                dVar.f14445f.setVisibility(0);
                dVar.f14445f.setEnabled(false);
                return;
            }
            dVar.f14445f.setVisibility(8);
            dVar.f14446g.setVisibility(0);
        }
    }
}
