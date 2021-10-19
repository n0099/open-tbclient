package c.a.r0.w.f.f.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.e.e.p.k;
import c.a.q0.s.q.d2;
import c.a.r0.w.f.f.b.b;
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
public class b extends c.a.r0.w.f.f.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.w.f.f.b.b f25936e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f25937f;

        public a(b bVar, c.a.r0.w.f.f.b.b bVar2) {
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
            this.f25937f = bVar;
            this.f25936e = bVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem("c12659");
                statisticItem.param("tid", this.f25936e.f25960a.s1());
                TiebaStatic.log(statisticItem);
                b bVar = this.f25937f;
                bVar.b(bVar.f25932e, this.f25936e.f25960a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
            }
        }
    }

    /* renamed from: c.a.r0.w.f.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1209b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f25938a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f25939b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f25940c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f25941d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f25942e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f25943f;

        public C1209b() {
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

        public /* synthetic */ C1209b(a aVar) {
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
        C1209b c1209b;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c1209b = new C1209b(null);
                view2 = LayoutInflater.from(this.f25933f).inflate(R.layout.square_recent_history_living_item, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_living_img);
                c1209b.f25938a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
                c1209b.f25939b = (TextView) view2.findViewById(R.id.recent_history_living_title);
                c1209b.f25940c = (TextView) view2.findViewById(R.id.recent_history_living_audience_count);
                c1209b.f25941d = (TextView) view2.findViewById(R.id.recent_history_living_user_name);
                c1209b.f25942e = (TextView) view2.findViewById(R.id.recent_history_living_living_tag);
                c1209b.f25943f = (TextView) view2.findViewById(R.id.recent_history_living_send_gift_tag);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                SkinManager.setViewTextColor(c1209b.f25939b, R.color.CAM_X0105);
                SkinManager.setViewTextColor(c1209b.f25940c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(c1209b.f25941d, R.color.CAM_X0107);
                SkinManager.setViewTextColor(c1209b.f25943f, R.color.CAM_X0301);
                view2.setTag(c1209b);
            } else {
                view2 = view;
                c1209b = (C1209b) view.getTag();
            }
            c.a.r0.w.f.f.b.b item = getItem(i2);
            if (item != null && (d2Var = item.f25960a) != null && d2Var.J() != null && item.f25960a.l1() != null) {
                MetaData J = item.f25960a.J();
                c1209b.f25938a.startLoad(item.f25960a.l1().cover, 10, false);
                c1209b.f25939b.setText(item.f25960a.getTitle());
                this.f25935h = 0;
                c1209b.f25942e.setVisibility(8);
                c1209b.f25943f.setVisibility(8);
                if (!ListUtils.isEmpty(item.f25963d)) {
                    for (b.a aVar : item.f25963d) {
                        if (aVar != null) {
                            int i3 = aVar.f25964a;
                            if (1 == i3) {
                                c1209b.f25942e.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f25965b)) {
                                    c1209b.f25942e.setText(aVar.f25965b);
                                }
                                this.f25935h++;
                            } else if (2 == i3) {
                                c1209b.f25943f.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f25965b)) {
                                    c1209b.f25943f.setText(aVar.f25965b);
                                }
                                this.f25935h++;
                            }
                        }
                    }
                }
                String name_show = J.getName_show();
                int i4 = this.f25935h <= 1 ? 14 : 13;
                if (k.byteLength(name_show) > i4) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i4, "...");
                }
                c1209b.f25941d.setText(name_show);
                c1209b.f25940c.setText(this.f25933f.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, StringHelper.numberUniformFormatExtra(item.f25960a.l1().audience_count)));
                view2.setOnClickListener(new a(this, item));
                StatisticItem statisticItem = new StatisticItem("c12658");
                statisticItem.param("tid", item.f25960a.s1());
                c.a.r0.w.f.e.a.c().a(statisticItem);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
