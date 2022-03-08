package c.a.r0.a0.f.f.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.q0.r.r.e2;
import c.a.r0.a0.f.f.b.b;
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
/* loaded from: classes2.dex */
public class b extends c.a.r0.a0.f.f.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a0.f.f.b.b f14396e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f14397f;

        public a(b bVar, c.a.r0.a0.f.f.b.b bVar2) {
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
            this.f14397f = bVar;
            this.f14396e = bVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem("c12659");
                statisticItem.param("tid", this.f14396e.a.w1());
                TiebaStatic.log(statisticItem);
                b bVar = this.f14397f;
                bVar.b(bVar.f14392e, this.f14396e.a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
            }
        }
    }

    /* renamed from: c.a.r0.a0.f.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0925b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14398b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14399c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14400d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f14401e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f14402f;

        public C0925b() {
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

        public /* synthetic */ C0925b(a aVar) {
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
        C0925b c0925b;
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c0925b = new C0925b(null);
                view2 = LayoutInflater.from(this.f14393f).inflate(R.layout.square_recent_history_living_item, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_living_img);
                c0925b.a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
                c0925b.f14398b = (TextView) view2.findViewById(R.id.recent_history_living_title);
                c0925b.f14399c = (TextView) view2.findViewById(R.id.recent_history_living_audience_count);
                c0925b.f14400d = (TextView) view2.findViewById(R.id.recent_history_living_user_name);
                c0925b.f14401e = (TextView) view2.findViewById(R.id.recent_history_living_living_tag);
                c0925b.f14402f = (TextView) view2.findViewById(R.id.recent_history_living_send_gift_tag);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                SkinManager.setViewTextColor(c0925b.f14398b, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(c0925b.f14399c, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(c0925b.f14400d, (int) R.color.CAM_X0107);
                SkinManager.setViewTextColor(c0925b.f14402f, (int) R.color.CAM_X0301);
                view2.setTag(c0925b);
            } else {
                view2 = view;
                c0925b = (C0925b) view.getTag();
            }
            c.a.r0.a0.f.f.b.b item = getItem(i2);
            if (item != null && (e2Var = item.a) != null && e2Var.J() != null && item.a.p1() != null) {
                MetaData J = item.a.J();
                c0925b.a.startLoad(item.a.p1().cover, 10, false);
                c0925b.f14398b.setText(item.a.getTitle());
                this.f14395h = 0;
                c0925b.f14401e.setVisibility(8);
                c0925b.f14402f.setVisibility(8);
                if (!ListUtils.isEmpty(item.f14419d)) {
                    for (b.a aVar : item.f14419d) {
                        if (aVar != null) {
                            int i3 = aVar.a;
                            if (1 == i3) {
                                c0925b.f14401e.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f14420b)) {
                                    c0925b.f14401e.setText(aVar.f14420b);
                                }
                                this.f14395h++;
                            } else if (2 == i3) {
                                c0925b.f14402f.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f14420b)) {
                                    c0925b.f14402f.setText(aVar.f14420b);
                                }
                                this.f14395h++;
                            }
                        }
                    }
                }
                String name_show = J.getName_show();
                int i4 = this.f14395h <= 1 ? 14 : 13;
                if (m.byteLength(name_show) > i4) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i4, "...");
                }
                c0925b.f14400d.setText(name_show);
                c0925b.f14399c.setText(this.f14393f.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, StringHelper.numberUniformFormatExtra(item.a.p1().audience_count)));
                view2.setOnClickListener(new a(this, item));
                StatisticItem statisticItem = new StatisticItem("c12658");
                statisticItem.param("tid", item.a.w1());
                c.a.r0.a0.f.e.a.c().a(statisticItem);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
