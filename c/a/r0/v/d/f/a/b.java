package c.a.r0.v.d.f.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.e.e.p.k;
import c.a.q0.s.q.d2;
import c.a.r0.v.d.f.b.b;
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
public class b extends c.a.r0.v.d.f.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.v.d.f.b.b f25738e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f25739f;

        public a(b bVar, c.a.r0.v.d.f.b.b bVar2) {
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
            this.f25739f = bVar;
            this.f25738e = bVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem("c12659");
                statisticItem.param("tid", this.f25738e.f25762a.s1());
                TiebaStatic.log(statisticItem);
                b bVar = this.f25739f;
                bVar.b(bVar.f25734e, this.f25738e.f25762a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
            }
        }
    }

    /* renamed from: c.a.r0.v.d.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1202b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f25740a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f25741b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f25742c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f25743d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f25744e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f25745f;

        public C1202b() {
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

        public /* synthetic */ C1202b(a aVar) {
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
        C1202b c1202b;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c1202b = new C1202b(null);
                view2 = LayoutInflater.from(this.f25735f).inflate(R.layout.square_recent_history_living_item, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_living_img);
                c1202b.f25740a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
                c1202b.f25741b = (TextView) view2.findViewById(R.id.recent_history_living_title);
                c1202b.f25742c = (TextView) view2.findViewById(R.id.recent_history_living_audience_count);
                c1202b.f25743d = (TextView) view2.findViewById(R.id.recent_history_living_user_name);
                c1202b.f25744e = (TextView) view2.findViewById(R.id.recent_history_living_living_tag);
                c1202b.f25745f = (TextView) view2.findViewById(R.id.recent_history_living_send_gift_tag);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                SkinManager.setViewTextColor(c1202b.f25741b, R.color.CAM_X0105);
                SkinManager.setViewTextColor(c1202b.f25742c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(c1202b.f25743d, R.color.CAM_X0107);
                SkinManager.setViewTextColor(c1202b.f25745f, R.color.CAM_X0301);
                view2.setTag(c1202b);
            } else {
                view2 = view;
                c1202b = (C1202b) view.getTag();
            }
            c.a.r0.v.d.f.b.b item = getItem(i2);
            if (item != null && (d2Var = item.f25762a) != null && d2Var.J() != null && item.f25762a.l1() != null) {
                MetaData J = item.f25762a.J();
                c1202b.f25740a.startLoad(item.f25762a.l1().cover, 10, false);
                c1202b.f25741b.setText(item.f25762a.getTitle());
                this.f25737h = 0;
                c1202b.f25744e.setVisibility(8);
                c1202b.f25745f.setVisibility(8);
                if (!ListUtils.isEmpty(item.f25765d)) {
                    for (b.a aVar : item.f25765d) {
                        if (aVar != null) {
                            int i3 = aVar.f25766a;
                            if (1 == i3) {
                                c1202b.f25744e.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f25767b)) {
                                    c1202b.f25744e.setText(aVar.f25767b);
                                }
                                this.f25737h++;
                            } else if (2 == i3) {
                                c1202b.f25745f.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f25767b)) {
                                    c1202b.f25745f.setText(aVar.f25767b);
                                }
                                this.f25737h++;
                            }
                        }
                    }
                }
                String name_show = J.getName_show();
                int i4 = this.f25737h <= 1 ? 14 : 13;
                if (k.byteLength(name_show) > i4) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i4, "...");
                }
                c1202b.f25743d.setText(name_show);
                c1202b.f25742c.setText(this.f25735f.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, StringHelper.numberUniformFormatExtra(item.f25762a.l1().audience_count)));
                view2.setOnClickListener(new a(this, item));
                StatisticItem statisticItem = new StatisticItem("c12658");
                statisticItem.param("tid", item.f25762a.s1());
                c.a.r0.v.d.e.a.c().a(statisticItem);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
