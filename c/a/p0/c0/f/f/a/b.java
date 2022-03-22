package c.a.p0.c0.f.f.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.p0.c0.f.f.b.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
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
public class b extends c.a.p0.c0.f.f.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.c0.f.f.b.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f13037b;

        public a(b bVar, c.a.p0.c0.f.f.b.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13037b = bVar;
            this.a = bVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem("c12659");
                statisticItem.param("tid", this.a.a.getTid());
                TiebaStatic.log(statisticItem);
                b bVar = this.f13037b;
                bVar.b(bVar.a, this.a.a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
            }
        }
    }

    /* renamed from: c.a.p0.c0.f.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0982b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f13038b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f13039c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f13040d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f13041e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f13042f;

        public C0982b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ C0982b(a aVar) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view2;
        C0982b c0982b;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i, view, viewGroup)) == null) {
            if (view == null) {
                c0982b = new C0982b(null);
                view2 = LayoutInflater.from(this.f13034b).inflate(R.layout.obfuscated_res_0x7f0d07a9, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0919d6);
                c0982b.a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
                c0982b.f13038b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919d9);
                c0982b.f13039c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919d5);
                c0982b.f13040d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919da);
                c0982b.f13041e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919d7);
                c0982b.f13042f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919d8);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                SkinManager.setViewTextColor(c0982b.f13038b, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(c0982b.f13039c, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(c0982b.f13040d, (int) R.color.CAM_X0107);
                SkinManager.setViewTextColor(c0982b.f13042f, (int) R.color.CAM_X0301);
                view2.setTag(c0982b);
            } else {
                view2 = view;
                c0982b = (C0982b) view.getTag();
            }
            c.a.p0.c0.f.f.b.b item = getItem(i);
            if (item != null && (threadData = item.a) != null && threadData.getAuthor() != null && item.a.getThreadAlaInfo() != null) {
                MetaData author = item.a.getAuthor();
                c0982b.a.J(item.a.getThreadAlaInfo().cover, 10, false);
                c0982b.f13038b.setText(item.a.getTitle());
                this.f13036d = 0;
                c0982b.f13041e.setVisibility(8);
                c0982b.f13042f.setVisibility(8);
                if (!ListUtils.isEmpty(item.f13058d)) {
                    for (b.a aVar : item.f13058d) {
                        if (aVar != null) {
                            int i2 = aVar.a;
                            if (1 == i2) {
                                c0982b.f13041e.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f13059b)) {
                                    c0982b.f13041e.setText(aVar.f13059b);
                                }
                                this.f13036d++;
                            } else if (2 == i2) {
                                c0982b.f13042f.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f13059b)) {
                                    c0982b.f13042f.setText(aVar.f13059b);
                                }
                                this.f13036d++;
                            }
                        }
                    }
                }
                String name_show = author.getName_show();
                int i3 = this.f13036d <= 1 ? 14 : 13;
                if (m.byteLength(name_show) > i3) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i3, StringHelper.STRING_MORE);
                }
                c0982b.f13040d.setText(name_show);
                c0982b.f13039c.setText(this.f13034b.getResources().getString(R.string.obfuscated_res_0x7f0f119e, StringHelper.numberUniformFormatExtra(item.a.getThreadAlaInfo().audience_count)));
                view2.setOnClickListener(new a(this, item));
                StatisticItem statisticItem = new StatisticItem("c12658");
                statisticItem.param("tid", item.a.getTid());
                c.a.p0.c0.f.e.a.c().a(statisticItem);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
