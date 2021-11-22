package b.a.r0.w.f.f.a;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.e.f.p.k;
import b.a.q0.s.q.d2;
import b.a.r0.w.f.f.b.b;
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
/* loaded from: classes5.dex */
public class c extends b.a.r0.w.f.f.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public long f26299i;
    public InterfaceC1279c j;
    public Drawable k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.w.f.f.b.b f26300e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f26301f;

        public a(c cVar, b.a.r0.w.f.f.b.b bVar) {
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
            this.f26301f = cVar;
            this.f26300e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26301f.j == null) {
                return;
            }
            this.f26301f.j.a(this.f26300e);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.w.f.f.b.b f26302e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MetaData f26303f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f26304g;

        public b(c cVar, b.a.r0.w.f.f.b.b bVar, MetaData metaData) {
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
            this.f26304g = cVar;
            this.f26302e = bVar;
            this.f26303f = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                boolean g2 = this.f26304g.g(this.f26302e.f26317d);
                StatisticItem statisticItem = new StatisticItem("c12661");
                statisticItem.param("obj_id", this.f26302e.f26314a.J().getUserId());
                statisticItem.param("obj_type", g2 ? 1 : 0);
                TiebaStatic.log(statisticItem);
                if (!this.f26304g.g(this.f26302e.f26317d)) {
                    this.f26304g.h(this.f26303f);
                    return;
                }
                c cVar = this.f26304g;
                cVar.b(cVar.f26287e, this.f26302e.f26314a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_WHOLE_TAB);
            }
        }
    }

    /* renamed from: b.a.r0.w.f.f.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1279c {
        void a(b.a.r0.w.f.f.b.b bVar);
    }

    /* loaded from: classes5.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f26305a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f26306b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f26307c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f26308d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f26309e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f26310f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f26311g;

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
        this.f26299i = b.a.e.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.k = SkinManager.getDrawable(this.f26288f.getResources(), R.drawable.icon_video_direct_seeding);
    }

    public final boolean g(List<b.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.f26318a) {
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
                view2 = LayoutInflater.from(this.f26288f).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_whole_img);
                dVar.f26305a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
                dVar.f26305a.setIsRound(true);
                dVar.f26305a.setAutoChangeStyle(false);
                dVar.f26305a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                dVar.f26306b = (TextView) view2.findViewById(R.id.recent_history_whole_user_name);
                dVar.f26307c = (TextView) view2.findViewById(R.id.recent_history_whole_living_tag);
                dVar.f26308d = (TextView) view2.findViewById(R.id.recent_history_whole_send_gift_tag);
                dVar.f26309e = (TextView) view2.findViewById(R.id.recent_history_whole_live_begin_time);
                dVar.f26310f = (TextView) view2.findViewById(R.id.recent_history_whole_follow_btn);
                dVar.f26311g = (TextView) view2.findViewById(R.id.recent_history_whole_unfollow_btn);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                SkinManager.setViewTextColor(dVar.f26306b, R.color.CAM_X0105);
                SkinManager.setViewTextColor(dVar.f26309e, R.color.CAM_X0109);
                SkinManager.setViewTextColor(dVar.f26310f, R.color.CAM_X0110);
                SkinManager.setViewTextColor(dVar.f26311g, R.color.square_follow_btn_txt_color);
                dVar.f26307c.setCompoundDrawablesWithIntrinsicBounds(this.k, (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(dVar.f26308d, R.color.CAM_X0301);
                view2.setTag(dVar);
            } else {
                view2 = view;
                dVar = (d) view.getTag();
            }
            b.a.r0.w.f.f.b.b item = getItem(i2);
            if (item != null && (d2Var = item.f26314a) != null && d2Var.J() != null) {
                com.baidu.tbadk.core.data.MetaData J = item.f26314a.J();
                int i3 = 12;
                dVar.f26305a.startLoad(J.getPortrait(), 12, false);
                this.f26290h = 0;
                dVar.f26307c.setVisibility(8);
                dVar.f26308d.setVisibility(8);
                if (!ListUtils.isEmpty(item.f26317d)) {
                    for (b.a aVar : item.f26317d) {
                        if (aVar != null) {
                            int i4 = aVar.f26318a;
                            if (1 == i4) {
                                dVar.f26307c.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f26319b)) {
                                    dVar.f26307c.setText(aVar.f26319b);
                                }
                                this.f26290h++;
                            } else if (2 == i4) {
                                dVar.f26308d.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f26319b)) {
                                    dVar.f26308d.setText(aVar.f26319b);
                                }
                                this.f26290h++;
                            }
                        }
                    }
                }
                boolean z = item.f26315b;
                String name_show = J.getName_show();
                if (this.f26290h <= 1) {
                    i3 = 14;
                } else if (!z) {
                    i3 = 10;
                }
                if (k.byteLength(name_show) > i3) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i3, "...");
                }
                dVar.f26306b.setText(name_show);
                dVar.f26309e.setText(StringHelper.getFormatTimeShort(item.f26316c * 1000));
                j(z, dVar);
                dVar.f26311g.setOnClickListener(new a(this, item));
                view2.setOnClickListener(new b(this, item, J));
                StatisticItem statisticItem = new StatisticItem("c12660");
                statisticItem.param("obj_id", item.f26314a.J().getUserId());
                b.a.r0.w.f.e.a.c().a(statisticItem);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, metaData) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f26288f).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.f26299i).equals(metaData.getUserId()), metaData.isBigV())));
        }
    }

    public void i(InterfaceC1279c interfaceC1279c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC1279c) == null) {
            this.j = interfaceC1279c;
        }
    }

    public final void j(boolean z, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, dVar) == null) {
            if (z) {
                dVar.f26311g.setVisibility(8);
                dVar.f26310f.setVisibility(0);
                dVar.f26310f.setEnabled(false);
                return;
            }
            dVar.f26310f.setVisibility(8);
            dVar.f26311g.setVisibility(0);
        }
    }
}
