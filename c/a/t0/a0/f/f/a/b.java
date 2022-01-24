package c.a.t0.a0.f.f.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.s0.s.q.e2;
import c.a.t0.a0.f.f.b.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b extends c.a.t0.a0.f.f.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.a0.f.f.b.b f14707e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f14708f;

        public a(b bVar, c.a.t0.a0.f.f.b.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14708f = bVar;
            this.f14707e = bVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem("c12659");
                statisticItem.param("tid", this.f14707e.a.w1());
                TiebaStatic.log(statisticItem);
                b bVar = this.f14708f;
                bVar.b(bVar.f14703e, this.f14707e.a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
            }
        }
    }

    /* renamed from: c.a.t0.a0.f.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0938b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14709b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14710c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14711d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f14712e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f14713f;

        public C0938b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ C0938b(a aVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext) {
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
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view2;
        C0938b c0938b;
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c0938b = new C0938b(null);
                view2 = LayoutInflater.from(this.f14704f).inflate(R.layout.square_recent_history_living_item, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_living_img);
                c0938b.a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
                c0938b.f14709b = (TextView) view2.findViewById(R.id.recent_history_living_title);
                c0938b.f14710c = (TextView) view2.findViewById(R.id.recent_history_living_audience_count);
                c0938b.f14711d = (TextView) view2.findViewById(R.id.recent_history_living_user_name);
                c0938b.f14712e = (TextView) view2.findViewById(R.id.recent_history_living_living_tag);
                c0938b.f14713f = (TextView) view2.findViewById(R.id.recent_history_living_send_gift_tag);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                SkinManager.setViewTextColor(c0938b.f14709b, R.color.CAM_X0105);
                SkinManager.setViewTextColor(c0938b.f14710c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(c0938b.f14711d, R.color.CAM_X0107);
                SkinManager.setViewTextColor(c0938b.f14713f, R.color.CAM_X0301);
                view2.setTag(c0938b);
            } else {
                view2 = view;
                c0938b = (C0938b) view.getTag();
            }
            c.a.t0.a0.f.f.b.b item = getItem(i2);
            if (item != null && (e2Var = item.a) != null && e2Var.J() != null && item.a.p1() != null) {
                MetaData J = item.a.J();
                c0938b.a.startLoad(item.a.p1().cover, 10, false);
                c0938b.f14709b.setText(item.a.getTitle());
                this.f14706h = 0;
                c0938b.f14712e.setVisibility(8);
                c0938b.f14713f.setVisibility(8);
                if (!ListUtils.isEmpty(item.f14730d)) {
                    for (b.a aVar : item.f14730d) {
                        if (aVar != null) {
                            int i3 = aVar.a;
                            if (1 == i3) {
                                c0938b.f14712e.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f14731b)) {
                                    c0938b.f14712e.setText(aVar.f14731b);
                                }
                                this.f14706h++;
                            } else if (2 == i3) {
                                c0938b.f14713f.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f14731b)) {
                                    c0938b.f14713f.setText(aVar.f14731b);
                                }
                                this.f14706h++;
                            }
                        }
                    }
                }
                String name_show = J.getName_show();
                int i4 = this.f14706h <= 1 ? 14 : 13;
                if (m.byteLength(name_show) > i4) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i4, "...");
                }
                c0938b.f14711d.setText(name_show);
                c0938b.f14710c.setText(this.f14704f.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, StringHelper.numberUniformFormatExtra(item.a.p1().audience_count)));
                view2.setOnClickListener(new a(this, item));
                StatisticItem statisticItem = new StatisticItem("c12658");
                statisticItem.param("tid", item.a.w1());
                c.a.t0.a0.f.e.a.c().a(statisticItem);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
