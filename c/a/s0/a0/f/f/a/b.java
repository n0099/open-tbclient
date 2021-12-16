package c.a.s0.a0.f.f.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.r0.s.r.d2;
import c.a.s0.a0.f.f.b.b;
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
public class b extends c.a.s0.a0.f.f.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a0.f.f.b.b f14426e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f14427f;

        public a(b bVar, c.a.s0.a0.f.f.b.b bVar2) {
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
            this.f14427f = bVar;
            this.f14426e = bVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem("c12659");
                statisticItem.param("tid", this.f14426e.a.v1());
                TiebaStatic.log(statisticItem);
                b bVar = this.f14427f;
                bVar.b(bVar.f14422e, this.f14426e.a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
            }
        }
    }

    /* renamed from: c.a.s0.a0.f.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0890b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14428b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14429c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14430d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f14431e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f14432f;

        public C0890b() {
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

        public /* synthetic */ C0890b(a aVar) {
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
        C0890b c0890b;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c0890b = new C0890b(null);
                view2 = LayoutInflater.from(this.f14423f).inflate(R.layout.square_recent_history_living_item, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_living_img);
                c0890b.a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
                c0890b.f14428b = (TextView) view2.findViewById(R.id.recent_history_living_title);
                c0890b.f14429c = (TextView) view2.findViewById(R.id.recent_history_living_audience_count);
                c0890b.f14430d = (TextView) view2.findViewById(R.id.recent_history_living_user_name);
                c0890b.f14431e = (TextView) view2.findViewById(R.id.recent_history_living_living_tag);
                c0890b.f14432f = (TextView) view2.findViewById(R.id.recent_history_living_send_gift_tag);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                SkinManager.setViewTextColor(c0890b.f14428b, R.color.CAM_X0105);
                SkinManager.setViewTextColor(c0890b.f14429c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(c0890b.f14430d, R.color.CAM_X0107);
                SkinManager.setViewTextColor(c0890b.f14432f, R.color.CAM_X0301);
                view2.setTag(c0890b);
            } else {
                view2 = view;
                c0890b = (C0890b) view.getTag();
            }
            c.a.s0.a0.f.f.b.b item = getItem(i2);
            if (item != null && (d2Var = item.a) != null && d2Var.J() != null && item.a.o1() != null) {
                MetaData J = item.a.J();
                c0890b.a.startLoad(item.a.o1().cover, 10, false);
                c0890b.f14428b.setText(item.a.getTitle());
                this.f14425h = 0;
                c0890b.f14431e.setVisibility(8);
                c0890b.f14432f.setVisibility(8);
                if (!ListUtils.isEmpty(item.f14450d)) {
                    for (b.a aVar : item.f14450d) {
                        if (aVar != null) {
                            int i3 = aVar.a;
                            if (1 == i3) {
                                c0890b.f14431e.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f14451b)) {
                                    c0890b.f14431e.setText(aVar.f14451b);
                                }
                                this.f14425h++;
                            } else if (2 == i3) {
                                c0890b.f14432f.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f14451b)) {
                                    c0890b.f14432f.setText(aVar.f14451b);
                                }
                                this.f14425h++;
                            }
                        }
                    }
                }
                String name_show = J.getName_show();
                int i4 = this.f14425h <= 1 ? 14 : 13;
                if (l.byteLength(name_show) > i4) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i4, "...");
                }
                c0890b.f14430d.setText(name_show);
                c0890b.f14429c.setText(this.f14423f.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, StringHelper.numberUniformFormatExtra(item.a.o1().audience_count)));
                view2.setOnClickListener(new a(this, item));
                StatisticItem statisticItem = new StatisticItem("c12658");
                statisticItem.param("tid", item.a.v1());
                c.a.s0.a0.f.e.a.c().a(statisticItem);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
