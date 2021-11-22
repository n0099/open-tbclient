package b.a.r0.w.f.f.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.a.e.f.p.k;
import b.a.q0.s.q.d2;
import b.a.r0.w.f.f.b.b;
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
/* loaded from: classes5.dex */
public class b extends b.a.r0.w.f.f.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.w.f.f.b.b f26291e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f26292f;

        public a(b bVar, b.a.r0.w.f.f.b.b bVar2) {
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
            this.f26292f = bVar;
            this.f26291e = bVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem("c12659");
                statisticItem.param("tid", this.f26291e.f26314a.t1());
                TiebaStatic.log(statisticItem);
                b bVar = this.f26292f;
                bVar.b(bVar.f26287e, this.f26291e.f26314a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
            }
        }
    }

    /* renamed from: b.a.r0.w.f.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1278b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f26293a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f26294b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f26295c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f26296d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f26297e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f26298f;

        public C1278b() {
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

        public /* synthetic */ C1278b(a aVar) {
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
        C1278b c1278b;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c1278b = new C1278b(null);
                view2 = LayoutInflater.from(this.f26288f).inflate(R.layout.square_recent_history_living_item, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_living_img);
                c1278b.f26293a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
                c1278b.f26294b = (TextView) view2.findViewById(R.id.recent_history_living_title);
                c1278b.f26295c = (TextView) view2.findViewById(R.id.recent_history_living_audience_count);
                c1278b.f26296d = (TextView) view2.findViewById(R.id.recent_history_living_user_name);
                c1278b.f26297e = (TextView) view2.findViewById(R.id.recent_history_living_living_tag);
                c1278b.f26298f = (TextView) view2.findViewById(R.id.recent_history_living_send_gift_tag);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                SkinManager.setViewTextColor(c1278b.f26294b, R.color.CAM_X0105);
                SkinManager.setViewTextColor(c1278b.f26295c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(c1278b.f26296d, R.color.CAM_X0107);
                SkinManager.setViewTextColor(c1278b.f26298f, R.color.CAM_X0301);
                view2.setTag(c1278b);
            } else {
                view2 = view;
                c1278b = (C1278b) view.getTag();
            }
            b.a.r0.w.f.f.b.b item = getItem(i2);
            if (item != null && (d2Var = item.f26314a) != null && d2Var.J() != null && item.f26314a.m1() != null) {
                MetaData J = item.f26314a.J();
                c1278b.f26293a.startLoad(item.f26314a.m1().cover, 10, false);
                c1278b.f26294b.setText(item.f26314a.getTitle());
                this.f26290h = 0;
                c1278b.f26297e.setVisibility(8);
                c1278b.f26298f.setVisibility(8);
                if (!ListUtils.isEmpty(item.f26317d)) {
                    for (b.a aVar : item.f26317d) {
                        if (aVar != null) {
                            int i3 = aVar.f26318a;
                            if (1 == i3) {
                                c1278b.f26297e.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f26319b)) {
                                    c1278b.f26297e.setText(aVar.f26319b);
                                }
                                this.f26290h++;
                            } else if (2 == i3) {
                                c1278b.f26298f.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f26319b)) {
                                    c1278b.f26298f.setText(aVar.f26319b);
                                }
                                this.f26290h++;
                            }
                        }
                    }
                }
                String name_show = J.getName_show();
                int i4 = this.f26290h <= 1 ? 14 : 13;
                if (k.byteLength(name_show) > i4) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i4, "...");
                }
                c1278b.f26296d.setText(name_show);
                c1278b.f26295c.setText(this.f26288f.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, StringHelper.numberUniformFormatExtra(item.f26314a.m1().audience_count)));
                view2.setOnClickListener(new a(this, item));
                StatisticItem statisticItem = new StatisticItem("c12658");
                statisticItem.param("tid", item.f26314a.t1());
                b.a.r0.w.f.e.a.c().a(statisticItem);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
