package c.a.t0.a0.f.f.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.s0.s.q.d2;
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
        public final /* synthetic */ c.a.t0.a0.f.f.b.b f14925e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f14926f;

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
            this.f14926f = bVar;
            this.f14925e = bVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem("c12659");
                statisticItem.param("tid", this.f14925e.a.v1());
                TiebaStatic.log(statisticItem);
                b bVar = this.f14926f;
                bVar.b(bVar.f14921e, this.f14925e.a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
            }
        }
    }

    /* renamed from: c.a.t0.a0.f.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0915b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14927b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14928c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14929d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f14930e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f14931f;

        public C0915b() {
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

        public /* synthetic */ C0915b(a aVar) {
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
        C0915b c0915b;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c0915b = new C0915b(null);
                view2 = LayoutInflater.from(this.f14922f).inflate(R.layout.square_recent_history_living_item, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_living_img);
                c0915b.a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
                c0915b.f14927b = (TextView) view2.findViewById(R.id.recent_history_living_title);
                c0915b.f14928c = (TextView) view2.findViewById(R.id.recent_history_living_audience_count);
                c0915b.f14929d = (TextView) view2.findViewById(R.id.recent_history_living_user_name);
                c0915b.f14930e = (TextView) view2.findViewById(R.id.recent_history_living_living_tag);
                c0915b.f14931f = (TextView) view2.findViewById(R.id.recent_history_living_send_gift_tag);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                SkinManager.setViewTextColor(c0915b.f14927b, R.color.CAM_X0105);
                SkinManager.setViewTextColor(c0915b.f14928c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(c0915b.f14929d, R.color.CAM_X0107);
                SkinManager.setViewTextColor(c0915b.f14931f, R.color.CAM_X0301);
                view2.setTag(c0915b);
            } else {
                view2 = view;
                c0915b = (C0915b) view.getTag();
            }
            c.a.t0.a0.f.f.b.b item = getItem(i2);
            if (item != null && (d2Var = item.a) != null && d2Var.J() != null && item.a.o1() != null) {
                MetaData J = item.a.J();
                c0915b.a.startLoad(item.a.o1().cover, 10, false);
                c0915b.f14927b.setText(item.a.getTitle());
                this.f14924h = 0;
                c0915b.f14930e.setVisibility(8);
                c0915b.f14931f.setVisibility(8);
                if (!ListUtils.isEmpty(item.f14949d)) {
                    for (b.a aVar : item.f14949d) {
                        if (aVar != null) {
                            int i3 = aVar.a;
                            if (1 == i3) {
                                c0915b.f14930e.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f14950b)) {
                                    c0915b.f14930e.setText(aVar.f14950b);
                                }
                                this.f14924h++;
                            } else if (2 == i3) {
                                c0915b.f14931f.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f14950b)) {
                                    c0915b.f14931f.setText(aVar.f14950b);
                                }
                                this.f14924h++;
                            }
                        }
                    }
                }
                String name_show = J.getName_show();
                int i4 = this.f14924h <= 1 ? 14 : 13;
                if (m.byteLength(name_show) > i4) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i4, "...");
                }
                c0915b.f14929d.setText(name_show);
                c0915b.f14928c.setText(this.f14922f.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, StringHelper.numberUniformFormatExtra(item.a.o1().audience_count)));
                view2.setOnClickListener(new a(this, item));
                StatisticItem statisticItem = new StatisticItem("c12658");
                statisticItem.param("tid", item.a.v1());
                c.a.t0.a0.f.e.a.c().a(statisticItem);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
