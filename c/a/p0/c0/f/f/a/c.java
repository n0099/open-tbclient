package c.a.p0.c0.f.f.a;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.p0.c0.f.f.b.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
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
public class c extends c.a.p0.c0.f.f.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f13043e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC0983c f13044f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f13045g;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.c0.f.f.b.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f13046b;

        public a(c cVar, c.a.p0.c0.f.f.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13046b = cVar;
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f13046b.f13044f == null) {
                return;
            }
            this.f13046b.f13044f.a(this.a);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.c0.f.f.b.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MetaData f13047b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f13048c;

        public b(c cVar, c.a.p0.c0.f.f.b.b bVar, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13048c = cVar;
            this.a = bVar;
            this.f13047b = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                boolean g2 = this.f13048c.g(this.a.f13058d);
                StatisticItem statisticItem = new StatisticItem("c12661");
                statisticItem.param("obj_id", this.a.a.getAuthor().getUserId());
                statisticItem.param("obj_type", g2 ? 1 : 0);
                TiebaStatic.log(statisticItem);
                if (!this.f13048c.g(this.a.f13058d)) {
                    this.f13048c.h(this.f13047b);
                    return;
                }
                c cVar = this.f13048c;
                cVar.b(cVar.a, this.a.a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_WHOLE_TAB);
            }
        }
    }

    /* renamed from: c.a.p0.c0.f.f.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0983c {
        void a(c.a.p0.c0.f.f.b.b bVar);
    }

    /* loaded from: classes2.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f13049b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f13050c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f13051d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f13052e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f13053f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f13054g;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13043e = c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.f13045g = SkinManager.getDrawable(this.f13034b.getResources(), (int) R.drawable.icon_video_direct_seeding);
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view2;
        d dVar;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, view, viewGroup)) == null) {
            if (view == null) {
                dVar = new d(this, null);
                view2 = LayoutInflater.from(this.f13034b).inflate(R.layout.obfuscated_res_0x7f0d07ab, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0919dc);
                dVar.a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
                dVar.a.setIsRound(true);
                dVar.a.setAutoChangeStyle(false);
                dVar.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                dVar.f13049b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919e1);
                dVar.f13050c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919de);
                dVar.f13051d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919df);
                dVar.f13052e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919dd);
                dVar.f13053f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919db);
                dVar.f13054g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919e0);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                SkinManager.setViewTextColor(dVar.f13049b, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(dVar.f13052e, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(dVar.f13053f, (int) R.color.CAM_X0110);
                SkinManager.setViewTextColor(dVar.f13054g, (int) R.color.obfuscated_res_0x7f060a05);
                dVar.f13050c.setCompoundDrawablesWithIntrinsicBounds(this.f13045g, (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(dVar.f13051d, (int) R.color.CAM_X0301);
                view2.setTag(dVar);
            } else {
                view2 = view;
                dVar = (d) view.getTag();
            }
            c.a.p0.c0.f.f.b.b item = getItem(i);
            if (item != null && (threadData = item.a) != null && threadData.getAuthor() != null) {
                com.baidu.tbadk.core.data.MetaData author = item.a.getAuthor();
                int i2 = 12;
                dVar.a.J(author.getPortrait(), 12, false);
                this.f13036d = 0;
                dVar.f13050c.setVisibility(8);
                dVar.f13051d.setVisibility(8);
                if (!ListUtils.isEmpty(item.f13058d)) {
                    for (b.a aVar : item.f13058d) {
                        if (aVar != null) {
                            int i3 = aVar.a;
                            if (1 == i3) {
                                dVar.f13050c.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f13059b)) {
                                    dVar.f13050c.setText(aVar.f13059b);
                                }
                                this.f13036d++;
                            } else if (2 == i3) {
                                dVar.f13051d.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f13059b)) {
                                    dVar.f13051d.setText(aVar.f13059b);
                                }
                                this.f13036d++;
                            }
                        }
                    }
                }
                boolean z = item.f13056b;
                String name_show = author.getName_show();
                if (this.f13036d <= 1) {
                    i2 = 14;
                } else if (!z) {
                    i2 = 10;
                }
                if (m.byteLength(name_show) > i2) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE);
                }
                dVar.f13049b.setText(name_show);
                dVar.f13052e.setText(StringHelper.getFormatTimeShort(item.f13057c * 1000));
                j(z, dVar);
                dVar.f13054g.setOnClickListener(new a(this, item));
                view2.setOnClickListener(new b(this, item, author));
                StatisticItem statisticItem = new StatisticItem("c12660");
                statisticItem.param("obj_id", item.a.getAuthor().getUserId());
                c.a.p0.c0.f.e.a.c().a(statisticItem);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, metaData) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f13034b).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.f13043e).equals(metaData.getUserId()), metaData.isBigV())));
        }
    }

    public void i(InterfaceC0983c interfaceC0983c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0983c) == null) {
            this.f13044f = interfaceC0983c;
        }
    }

    public final void j(boolean z, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, dVar) == null) {
            if (z) {
                dVar.f13054g.setVisibility(8);
                dVar.f13053f.setVisibility(0);
                dVar.f13053f.setEnabled(false);
                return;
            }
            dVar.f13053f.setVisibility(8);
            dVar.f13054g.setVisibility(0);
        }
    }
}
