package c.a.p0.w0.j;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.p0.w0.j.c.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.RankListViewController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f19434b;

    /* renamed from: c  reason: collision with root package name */
    public RankListViewController.RankListViewHolder f19435c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19436d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19437e;

    /* renamed from: f  reason: collision with root package name */
    public String f19438f;

    /* renamed from: g  reason: collision with root package name */
    public int f19439g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f19440h;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (TextUtils.isEmpty(this.a.f19438f)) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0a29);
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.a.a, new String[]{this.a.f19438f});
                if (this.a.f19439g == 0) {
                    return;
                }
                if (this.a.f19439g != 2) {
                    if (this.a.f19439g == 1) {
                        StatisticItem statisticItem = new StatisticItem("c13669");
                        statisticItem.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem("c13658");
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("obj_locate", 2);
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    public b(TbPageContext tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19440h = new a(this);
        this.a = tbPageContext;
        this.f19434b = view;
        RankListViewController.RankListViewHolder rankListViewHolder = new RankListViewController.RankListViewHolder(view.findViewById(R.id.obfuscated_res_0x7f0922df));
        this.f19435c = rankListViewHolder;
        rankListViewHolder.i(1);
        this.f19436d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090c8d);
        TextView textView = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0919b7);
        this.f19437e = textView;
        textView.setTextSize(0, n.f(this.a.getPageActivity(), R.dimen.tbfontsize46));
        this.f19436d.setOnClickListener(this.f19440h);
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.f19435c.f(i);
            SkinManager.setBackgroundColor(this.f19435c.itemView, R.color.CAM_X0207);
            SkinManager.setViewTextColor(this.f19436d, (int) R.color.CAM_X0302);
        }
    }

    public void e(c cVar) {
        c.a.p0.w0.j.c.b bVar;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (bVar = cVar.f19454c) != null && (metaData = bVar.f19450f) != null && !metaData.isMask && TbadkCoreApplication.isLogin()) {
                this.f19434b.setVisibility(0);
                this.f19435c.c(cVar.f19454c);
                this.f19435c.e();
                this.f19438f = cVar.f19456e;
                return;
            }
            this.f19434b.setVisibility(8);
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.f19439g = i;
        }
    }
}
