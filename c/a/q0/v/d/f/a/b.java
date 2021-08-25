package c.a.q0.v.d.f.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.e.e.p.k;
import c.a.p0.s.q.c2;
import c.a.q0.v.d.f.b.b;
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
public class b extends c.a.q0.v.d.f.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.v.d.f.b.b f25260e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f25261f;

        public a(b bVar, c.a.q0.v.d.f.b.b bVar2) {
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
            this.f25261f = bVar;
            this.f25260e = bVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem("c12659");
                statisticItem.param("tid", this.f25260e.f25284a.q1());
                TiebaStatic.log(statisticItem);
                b bVar = this.f25261f;
                bVar.b(bVar.f25256e, this.f25260e.f25284a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
            }
        }
    }

    /* renamed from: c.a.q0.v.d.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1178b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f25262a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f25263b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f25264c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f25265d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f25266e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f25267f;

        public C1178b() {
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

        public /* synthetic */ C1178b(a aVar) {
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
        C1178b c1178b;
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c1178b = new C1178b(null);
                view2 = LayoutInflater.from(this.f25257f).inflate(R.layout.square_recent_history_living_item, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_living_img);
                c1178b.f25262a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
                c1178b.f25263b = (TextView) view2.findViewById(R.id.recent_history_living_title);
                c1178b.f25264c = (TextView) view2.findViewById(R.id.recent_history_living_audience_count);
                c1178b.f25265d = (TextView) view2.findViewById(R.id.recent_history_living_user_name);
                c1178b.f25266e = (TextView) view2.findViewById(R.id.recent_history_living_living_tag);
                c1178b.f25267f = (TextView) view2.findViewById(R.id.recent_history_living_send_gift_tag);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                SkinManager.setViewTextColor(c1178b.f25263b, R.color.CAM_X0105);
                SkinManager.setViewTextColor(c1178b.f25264c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(c1178b.f25265d, R.color.CAM_X0107);
                SkinManager.setViewTextColor(c1178b.f25267f, R.color.CAM_X0301);
                view2.setTag(c1178b);
            } else {
                view2 = view;
                c1178b = (C1178b) view.getTag();
            }
            c.a.q0.v.d.f.b.b item = getItem(i2);
            if (item != null && (c2Var = item.f25284a) != null && c2Var.J() != null && item.f25284a.j1() != null) {
                MetaData J = item.f25284a.J();
                c1178b.f25262a.startLoad(item.f25284a.j1().cover, 10, false);
                c1178b.f25263b.setText(item.f25284a.getTitle());
                this.f25259h = 0;
                c1178b.f25266e.setVisibility(8);
                c1178b.f25267f.setVisibility(8);
                if (!ListUtils.isEmpty(item.f25287d)) {
                    for (b.a aVar : item.f25287d) {
                        if (aVar != null) {
                            int i3 = aVar.f25288a;
                            if (1 == i3) {
                                c1178b.f25266e.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f25289b)) {
                                    c1178b.f25266e.setText(aVar.f25289b);
                                }
                                this.f25259h++;
                            } else if (2 == i3) {
                                c1178b.f25267f.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f25289b)) {
                                    c1178b.f25267f.setText(aVar.f25289b);
                                }
                                this.f25259h++;
                            }
                        }
                    }
                }
                String name_show = J.getName_show();
                int i4 = this.f25259h <= 1 ? 14 : 13;
                if (k.byteLength(name_show) > i4) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i4, "...");
                }
                c1178b.f25265d.setText(name_show);
                c1178b.f25264c.setText(this.f25257f.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, StringHelper.numberUniformFormatExtra(item.f25284a.j1().audience_count)));
                view2.setOnClickListener(new a(this, item));
                StatisticItem statisticItem = new StatisticItem("c12658");
                statisticItem.param("tid", item.f25284a.q1());
                c.a.q0.v.d.e.a.c().a(statisticItem);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
