package c.a.t0.v0.i;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.t0.v0.i.c.c;
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
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f24334b;

    /* renamed from: c  reason: collision with root package name */
    public RankListViewController.RankListViewHolder f24335c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24336d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f24337e;

    /* renamed from: f  reason: collision with root package name */
    public String f24338f;

    /* renamed from: g  reason: collision with root package name */
    public int f24339g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f24340h;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24341e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24341e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (TextUtils.isEmpty(this.f24341e.f24338f)) {
                    this.f24341e.a.showToast(R.string.load_error_retry);
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f24341e.a, new String[]{this.f24341e.f24338f});
                if (this.f24341e.f24339g == 0) {
                    return;
                }
                if (this.f24341e.f24339g != 2) {
                    if (this.f24341e.f24339g == 1) {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24340h = new a(this);
        this.a = tbPageContext;
        this.f24334b = view;
        RankListViewController.RankListViewHolder rankListViewHolder = new RankListViewController.RankListViewHolder(view.findViewById(R.id.user_view));
        this.f24335c = rankListViewHolder;
        rankListViewHolder.setViewHolderType(1);
        this.f24336d = (TextView) view.findViewById(R.id.get_influence);
        TextView textView = (TextView) view.findViewById(R.id.rank_num);
        this.f24337e = textView;
        textView.setTextSize(0, n.f(this.a.getPageActivity(), R.dimen.tbfontsize46));
        this.f24336d.setOnClickListener(this.f24340h);
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f24335c.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.f24335c.itemView, R.color.CAM_X0207);
            SkinManager.setViewTextColor(this.f24336d, R.color.CAM_X0302);
        }
    }

    public void e(c cVar) {
        c.a.t0.v0.i.c.b bVar;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (bVar = cVar.f24355c) != null && (metaData = bVar.f24351f) != null && !metaData.isMask && TbadkCoreApplication.isLogin()) {
                this.f24334b.setVisibility(0);
                this.f24335c.bindData(cVar.f24355c);
                this.f24335c.hideIntroAndLikeButton();
                this.f24338f = cVar.f24357e;
                return;
            }
            this.f24334b.setVisibility(8);
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f24339g = i2;
        }
    }
}
