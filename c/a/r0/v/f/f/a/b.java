package c.a.r0.v.f.f.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.e.e.p.k;
import c.a.q0.s.q.d2;
import c.a.r0.v.f.f.b.b;
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
/* loaded from: classes4.dex */
public class b extends c.a.r0.v.f.f.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.v.f.f.b.b f25761e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f25762f;

        public a(b bVar, c.a.r0.v.f.f.b.b bVar2) {
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
            this.f25762f = bVar;
            this.f25761e = bVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem("c12659");
                statisticItem.param("tid", this.f25761e.f25785a.s1());
                TiebaStatic.log(statisticItem);
                b bVar = this.f25762f;
                bVar.b(bVar.f25757e, this.f25761e.f25785a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
            }
        }
    }

    /* renamed from: c.a.r0.v.f.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1200b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f25763a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f25764b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f25765c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f25766d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f25767e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f25768f;

        public C1200b() {
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

        public /* synthetic */ C1200b(a aVar) {
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
        C1200b c1200b;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c1200b = new C1200b(null);
                view2 = LayoutInflater.from(this.f25758f).inflate(R.layout.square_recent_history_living_item, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_living_img);
                c1200b.f25763a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
                c1200b.f25764b = (TextView) view2.findViewById(R.id.recent_history_living_title);
                c1200b.f25765c = (TextView) view2.findViewById(R.id.recent_history_living_audience_count);
                c1200b.f25766d = (TextView) view2.findViewById(R.id.recent_history_living_user_name);
                c1200b.f25767e = (TextView) view2.findViewById(R.id.recent_history_living_living_tag);
                c1200b.f25768f = (TextView) view2.findViewById(R.id.recent_history_living_send_gift_tag);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                SkinManager.setViewTextColor(c1200b.f25764b, R.color.CAM_X0105);
                SkinManager.setViewTextColor(c1200b.f25765c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(c1200b.f25766d, R.color.CAM_X0107);
                SkinManager.setViewTextColor(c1200b.f25768f, R.color.CAM_X0301);
                view2.setTag(c1200b);
            } else {
                view2 = view;
                c1200b = (C1200b) view.getTag();
            }
            c.a.r0.v.f.f.b.b item = getItem(i2);
            if (item != null && (d2Var = item.f25785a) != null && d2Var.J() != null && item.f25785a.l1() != null) {
                MetaData J = item.f25785a.J();
                c1200b.f25763a.startLoad(item.f25785a.l1().cover, 10, false);
                c1200b.f25764b.setText(item.f25785a.getTitle());
                this.f25760h = 0;
                c1200b.f25767e.setVisibility(8);
                c1200b.f25768f.setVisibility(8);
                if (!ListUtils.isEmpty(item.f25788d)) {
                    for (b.a aVar : item.f25788d) {
                        if (aVar != null) {
                            int i3 = aVar.f25789a;
                            if (1 == i3) {
                                c1200b.f25767e.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f25790b)) {
                                    c1200b.f25767e.setText(aVar.f25790b);
                                }
                                this.f25760h++;
                            } else if (2 == i3) {
                                c1200b.f25768f.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f25790b)) {
                                    c1200b.f25768f.setText(aVar.f25790b);
                                }
                                this.f25760h++;
                            }
                        }
                    }
                }
                String name_show = J.getName_show();
                int i4 = this.f25760h <= 1 ? 14 : 13;
                if (k.byteLength(name_show) > i4) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i4, "...");
                }
                c1200b.f25766d.setText(name_show);
                c1200b.f25765c.setText(this.f25758f.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, StringHelper.numberUniformFormatExtra(item.f25785a.l1().audience_count)));
                view2.setOnClickListener(new a(this, item));
                StatisticItem statisticItem = new StatisticItem("c12658");
                statisticItem.param("tid", item.f25785a.s1());
                c.a.r0.v.f.e.a.c().a(statisticItem);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
