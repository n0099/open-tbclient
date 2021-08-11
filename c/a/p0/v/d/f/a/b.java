package c.a.p0.v.d.f.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.e.e.p.k;
import c.a.o0.s.q.c2;
import c.a.p0.v.d.f.b.b;
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
/* loaded from: classes3.dex */
public class b extends c.a.p0.v.d.f.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.v.d.f.b.b f24927e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f24928f;

        public a(b bVar, c.a.p0.v.d.f.b.b bVar2) {
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
            this.f24928f = bVar;
            this.f24927e = bVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem("c12659");
                statisticItem.param("tid", this.f24927e.f24951a.q1());
                TiebaStatic.log(statisticItem);
                b bVar = this.f24928f;
                bVar.b(bVar.f24923e, this.f24927e.f24951a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
            }
        }
    }

    /* renamed from: c.a.p0.v.d.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1167b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f24929a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f24930b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f24931c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f24932d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f24933e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f24934f;

        public C1167b() {
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

        public /* synthetic */ C1167b(a aVar) {
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
        C1167b c1167b;
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c1167b = new C1167b(null);
                view2 = LayoutInflater.from(this.f24924f).inflate(R.layout.square_recent_history_living_item, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_living_img);
                c1167b.f24929a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
                c1167b.f24930b = (TextView) view2.findViewById(R.id.recent_history_living_title);
                c1167b.f24931c = (TextView) view2.findViewById(R.id.recent_history_living_audience_count);
                c1167b.f24932d = (TextView) view2.findViewById(R.id.recent_history_living_user_name);
                c1167b.f24933e = (TextView) view2.findViewById(R.id.recent_history_living_living_tag);
                c1167b.f24934f = (TextView) view2.findViewById(R.id.recent_history_living_send_gift_tag);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                SkinManager.setViewTextColor(c1167b.f24930b, R.color.CAM_X0105);
                SkinManager.setViewTextColor(c1167b.f24931c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(c1167b.f24932d, R.color.CAM_X0107);
                SkinManager.setViewTextColor(c1167b.f24934f, R.color.CAM_X0301);
                view2.setTag(c1167b);
            } else {
                view2 = view;
                c1167b = (C1167b) view.getTag();
            }
            c.a.p0.v.d.f.b.b item = getItem(i2);
            if (item != null && (c2Var = item.f24951a) != null && c2Var.J() != null && item.f24951a.j1() != null) {
                MetaData J = item.f24951a.J();
                c1167b.f24929a.startLoad(item.f24951a.j1().cover, 10, false);
                c1167b.f24930b.setText(item.f24951a.getTitle());
                this.f24926h = 0;
                c1167b.f24933e.setVisibility(8);
                c1167b.f24934f.setVisibility(8);
                if (!ListUtils.isEmpty(item.f24954d)) {
                    for (b.a aVar : item.f24954d) {
                        if (aVar != null) {
                            int i3 = aVar.f24955a;
                            if (1 == i3) {
                                c1167b.f24933e.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f24956b)) {
                                    c1167b.f24933e.setText(aVar.f24956b);
                                }
                                this.f24926h++;
                            } else if (2 == i3) {
                                c1167b.f24934f.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f24956b)) {
                                    c1167b.f24934f.setText(aVar.f24956b);
                                }
                                this.f24926h++;
                            }
                        }
                    }
                }
                String name_show = J.getName_show();
                int i4 = this.f24926h <= 1 ? 14 : 13;
                if (k.byteLength(name_show) > i4) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i4, "...");
                }
                c1167b.f24932d.setText(name_show);
                c1167b.f24931c.setText(this.f24924f.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, StringHelper.numberUniformFormatExtra(item.f24951a.j1().audience_count)));
                view2.setOnClickListener(new a(this, item));
                StatisticItem statisticItem = new StatisticItem("c12658");
                statisticItem.param("tid", item.f24951a.q1());
                c.a.p0.v.d.e.a.c().a(statisticItem);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
