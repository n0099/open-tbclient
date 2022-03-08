package c.a.r0.a0.f.f.a;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.q0.r.r.e2;
import c.a.r0.a0.f.f.b.b;
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
/* loaded from: classes2.dex */
public class c extends c.a.r0.a0.f.f.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public long f14403i;

    /* renamed from: j  reason: collision with root package name */
    public InterfaceC0926c f14404j;
    public Drawable k;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a0.f.f.b.b f14405e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f14406f;

        public a(c cVar, c.a.r0.a0.f.f.b.b bVar) {
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
            this.f14406f = cVar;
            this.f14405e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14406f.f14404j == null) {
                return;
            }
            this.f14406f.f14404j.a(this.f14405e);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a0.f.f.b.b f14407e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MetaData f14408f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f14409g;

        public b(c cVar, c.a.r0.a0.f.f.b.b bVar, MetaData metaData) {
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
            this.f14409g = cVar;
            this.f14407e = bVar;
            this.f14408f = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                boolean g2 = this.f14409g.g(this.f14407e.f14419d);
                StatisticItem statisticItem = new StatisticItem("c12661");
                statisticItem.param("obj_id", this.f14407e.a.J().getUserId());
                statisticItem.param("obj_type", g2 ? 1 : 0);
                TiebaStatic.log(statisticItem);
                if (!this.f14409g.g(this.f14407e.f14419d)) {
                    this.f14409g.h(this.f14408f);
                    return;
                }
                c cVar = this.f14409g;
                cVar.b(cVar.f14392e, this.f14407e.a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_WHOLE_TAB);
            }
        }
    }

    /* renamed from: c.a.r0.a0.f.f.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0926c {
        void a(c.a.r0.a0.f.f.b.b bVar);
    }

    /* loaded from: classes2.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14410b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14411c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14412d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f14413e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f14414f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14415g;

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
        this.f14403i = c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.k = SkinManager.getDrawable(this.f14393f.getResources(), (int) R.drawable.icon_video_direct_seeding);
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
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                dVar = new d(this, null);
                view2 = LayoutInflater.from(this.f14393f).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_whole_img);
                dVar.a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
                dVar.a.setIsRound(true);
                dVar.a.setAutoChangeStyle(false);
                dVar.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                dVar.f14410b = (TextView) view2.findViewById(R.id.recent_history_whole_user_name);
                dVar.f14411c = (TextView) view2.findViewById(R.id.recent_history_whole_living_tag);
                dVar.f14412d = (TextView) view2.findViewById(R.id.recent_history_whole_send_gift_tag);
                dVar.f14413e = (TextView) view2.findViewById(R.id.recent_history_whole_live_begin_time);
                dVar.f14414f = (TextView) view2.findViewById(R.id.recent_history_whole_follow_btn);
                dVar.f14415g = (TextView) view2.findViewById(R.id.recent_history_whole_unfollow_btn);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                SkinManager.setViewTextColor(dVar.f14410b, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(dVar.f14413e, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(dVar.f14414f, (int) R.color.CAM_X0110);
                SkinManager.setViewTextColor(dVar.f14415g, (int) R.color.square_follow_btn_txt_color);
                dVar.f14411c.setCompoundDrawablesWithIntrinsicBounds(this.k, (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(dVar.f14412d, (int) R.color.CAM_X0301);
                view2.setTag(dVar);
            } else {
                view2 = view;
                dVar = (d) view.getTag();
            }
            c.a.r0.a0.f.f.b.b item = getItem(i2);
            if (item != null && (e2Var = item.a) != null && e2Var.J() != null) {
                com.baidu.tbadk.core.data.MetaData J = item.a.J();
                int i3 = 12;
                dVar.a.startLoad(J.getPortrait(), 12, false);
                this.f14395h = 0;
                dVar.f14411c.setVisibility(8);
                dVar.f14412d.setVisibility(8);
                if (!ListUtils.isEmpty(item.f14419d)) {
                    for (b.a aVar : item.f14419d) {
                        if (aVar != null) {
                            int i4 = aVar.a;
                            if (1 == i4) {
                                dVar.f14411c.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f14420b)) {
                                    dVar.f14411c.setText(aVar.f14420b);
                                }
                                this.f14395h++;
                            } else if (2 == i4) {
                                dVar.f14412d.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f14420b)) {
                                    dVar.f14412d.setText(aVar.f14420b);
                                }
                                this.f14395h++;
                            }
                        }
                    }
                }
                boolean z = item.f14417b;
                String name_show = J.getName_show();
                if (this.f14395h <= 1) {
                    i3 = 14;
                } else if (!z) {
                    i3 = 10;
                }
                if (m.byteLength(name_show) > i3) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i3, "...");
                }
                dVar.f14410b.setText(name_show);
                dVar.f14413e.setText(StringHelper.getFormatTimeShort(item.f14418c * 1000));
                j(z, dVar);
                dVar.f14415g.setOnClickListener(new a(this, item));
                view2.setOnClickListener(new b(this, item, J));
                StatisticItem statisticItem = new StatisticItem("c12660");
                statisticItem.param("obj_id", item.a.J().getUserId());
                c.a.r0.a0.f.e.a.c().a(statisticItem);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, metaData) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f14393f).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.f14403i).equals(metaData.getUserId()), metaData.isBigV())));
        }
    }

    public void i(InterfaceC0926c interfaceC0926c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0926c) == null) {
            this.f14404j = interfaceC0926c;
        }
    }

    public final void j(boolean z, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, dVar) == null) {
            if (z) {
                dVar.f14415g.setVisibility(8);
                dVar.f14414f.setVisibility(0);
                dVar.f14414f.setEnabled(false);
                return;
            }
            dVar.f14414f.setVisibility(8);
            dVar.f14415g.setVisibility(0);
        }
    }
}
