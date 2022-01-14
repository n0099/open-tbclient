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
        public final /* synthetic */ c.a.t0.a0.f.f.b.b f14567e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f14568f;

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
            this.f14568f = bVar;
            this.f14567e = bVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem("c12659");
                statisticItem.param("tid", this.f14567e.a.v1());
                TiebaStatic.log(statisticItem);
                b bVar = this.f14568f;
                bVar.b(bVar.f14563e, this.f14567e.a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
            }
        }
    }

    /* renamed from: c.a.t0.a0.f.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0928b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14569b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14570c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14571d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f14572e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f14573f;

        public C0928b() {
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

        public /* synthetic */ C0928b(a aVar) {
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
        C0928b c0928b;
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c0928b = new C0928b(null);
                view2 = LayoutInflater.from(this.f14564f).inflate(R.layout.square_recent_history_living_item, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_living_img);
                c0928b.a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
                c0928b.f14569b = (TextView) view2.findViewById(R.id.recent_history_living_title);
                c0928b.f14570c = (TextView) view2.findViewById(R.id.recent_history_living_audience_count);
                c0928b.f14571d = (TextView) view2.findViewById(R.id.recent_history_living_user_name);
                c0928b.f14572e = (TextView) view2.findViewById(R.id.recent_history_living_living_tag);
                c0928b.f14573f = (TextView) view2.findViewById(R.id.recent_history_living_send_gift_tag);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                SkinManager.setViewTextColor(c0928b.f14569b, R.color.CAM_X0105);
                SkinManager.setViewTextColor(c0928b.f14570c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(c0928b.f14571d, R.color.CAM_X0107);
                SkinManager.setViewTextColor(c0928b.f14573f, R.color.CAM_X0301);
                view2.setTag(c0928b);
            } else {
                view2 = view;
                c0928b = (C0928b) view.getTag();
            }
            c.a.t0.a0.f.f.b.b item = getItem(i2);
            if (item != null && (e2Var = item.a) != null && e2Var.J() != null && item.a.o1() != null) {
                MetaData J = item.a.J();
                c0928b.a.startLoad(item.a.o1().cover, 10, false);
                c0928b.f14569b.setText(item.a.getTitle());
                this.f14566h = 0;
                c0928b.f14572e.setVisibility(8);
                c0928b.f14573f.setVisibility(8);
                if (!ListUtils.isEmpty(item.f14590d)) {
                    for (b.a aVar : item.f14590d) {
                        if (aVar != null) {
                            int i3 = aVar.a;
                            if (1 == i3) {
                                c0928b.f14572e.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f14591b)) {
                                    c0928b.f14572e.setText(aVar.f14591b);
                                }
                                this.f14566h++;
                            } else if (2 == i3) {
                                c0928b.f14573f.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f14591b)) {
                                    c0928b.f14573f.setText(aVar.f14591b);
                                }
                                this.f14566h++;
                            }
                        }
                    }
                }
                String name_show = J.getName_show();
                int i4 = this.f14566h <= 1 ? 14 : 13;
                if (m.byteLength(name_show) > i4) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i4, "...");
                }
                c0928b.f14571d.setText(name_show);
                c0928b.f14570c.setText(this.f14564f.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, StringHelper.numberUniformFormatExtra(item.a.o1().audience_count)));
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
