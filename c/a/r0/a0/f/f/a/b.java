package c.a.r0.a0.f.f.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.f.p.k;
import c.a.q0.s.q.d2;
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
/* loaded from: classes5.dex */
public class b extends c.a.r0.a0.f.f.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a0.f.f.b.b f14086e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f14087f;

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
            this.f14087f = bVar;
            this.f14086e = bVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem("c12659");
                statisticItem.param("tid", this.f14086e.a.v1());
                TiebaStatic.log(statisticItem);
                b bVar = this.f14087f;
                bVar.b(bVar.f14082e, this.f14086e.a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
            }
        }
    }

    /* renamed from: c.a.r0.a0.f.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0854b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14088b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14089c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14090d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f14091e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f14092f;

        public C0854b() {
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

        public /* synthetic */ C0854b(a aVar) {
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
        C0854b c0854b;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c0854b = new C0854b(null);
                view2 = LayoutInflater.from(this.f14083f).inflate(R.layout.square_recent_history_living_item, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_living_img);
                c0854b.a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
                c0854b.f14088b = (TextView) view2.findViewById(R.id.recent_history_living_title);
                c0854b.f14089c = (TextView) view2.findViewById(R.id.recent_history_living_audience_count);
                c0854b.f14090d = (TextView) view2.findViewById(R.id.recent_history_living_user_name);
                c0854b.f14091e = (TextView) view2.findViewById(R.id.recent_history_living_living_tag);
                c0854b.f14092f = (TextView) view2.findViewById(R.id.recent_history_living_send_gift_tag);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                SkinManager.setViewTextColor(c0854b.f14088b, R.color.CAM_X0105);
                SkinManager.setViewTextColor(c0854b.f14089c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(c0854b.f14090d, R.color.CAM_X0107);
                SkinManager.setViewTextColor(c0854b.f14092f, R.color.CAM_X0301);
                view2.setTag(c0854b);
            } else {
                view2 = view;
                c0854b = (C0854b) view.getTag();
            }
            c.a.r0.a0.f.f.b.b item = getItem(i2);
            if (item != null && (d2Var = item.a) != null && d2Var.J() != null && item.a.o1() != null) {
                MetaData J = item.a.J();
                c0854b.a.startLoad(item.a.o1().cover, 10, false);
                c0854b.f14088b.setText(item.a.getTitle());
                this.f14085h = 0;
                c0854b.f14091e.setVisibility(8);
                c0854b.f14092f.setVisibility(8);
                if (!ListUtils.isEmpty(item.f14110d)) {
                    for (b.a aVar : item.f14110d) {
                        if (aVar != null) {
                            int i3 = aVar.a;
                            if (1 == i3) {
                                c0854b.f14091e.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f14111b)) {
                                    c0854b.f14091e.setText(aVar.f14111b);
                                }
                                this.f14085h++;
                            } else if (2 == i3) {
                                c0854b.f14092f.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f14111b)) {
                                    c0854b.f14092f.setText(aVar.f14111b);
                                }
                                this.f14085h++;
                            }
                        }
                    }
                }
                String name_show = J.getName_show();
                int i4 = this.f14085h <= 1 ? 14 : 13;
                if (k.byteLength(name_show) > i4) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i4, "...");
                }
                c0854b.f14090d.setText(name_show);
                c0854b.f14089c.setText(this.f14083f.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, StringHelper.numberUniformFormatExtra(item.a.o1().audience_count)));
                view2.setOnClickListener(new a(this, item));
                StatisticItem statisticItem = new StatisticItem("c12658");
                statisticItem.param("tid", item.a.v1());
                c.a.r0.a0.f.e.a.c().a(statisticItem);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
