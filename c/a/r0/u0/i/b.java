package c.a.r0.u0.i;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.r0.u0.i.c.c;
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
    public View f22626b;

    /* renamed from: c  reason: collision with root package name */
    public RankListViewController.RankListViewHolder f22627c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22628d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22629e;

    /* renamed from: f  reason: collision with root package name */
    public String f22630f;

    /* renamed from: g  reason: collision with root package name */
    public int f22631g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f22632h;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22633e;

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
            this.f22633e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (TextUtils.isEmpty(this.f22633e.f22630f)) {
                    this.f22633e.a.showToast(R.string.load_error_retry);
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f22633e.a, new String[]{this.f22633e.f22630f});
                if (this.f22633e.f22631g == 0) {
                    return;
                }
                if (this.f22633e.f22631g != 2) {
                    if (this.f22633e.f22631g == 1) {
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
        this.f22632h = new a(this);
        this.a = tbPageContext;
        this.f22626b = view;
        RankListViewController.RankListViewHolder rankListViewHolder = new RankListViewController.RankListViewHolder(view.findViewById(R.id.user_view));
        this.f22627c = rankListViewHolder;
        rankListViewHolder.setViewHolderType(1);
        this.f22628d = (TextView) view.findViewById(R.id.get_influence);
        TextView textView = (TextView) view.findViewById(R.id.rank_num);
        this.f22629e = textView;
        textView.setTextSize(0, n.f(this.a.getPageActivity(), R.dimen.tbfontsize46));
        this.f22628d.setOnClickListener(this.f22632h);
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f22627c.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.f22627c.itemView, R.color.CAM_X0207);
            SkinManager.setViewTextColor(this.f22628d, (int) R.color.CAM_X0302);
        }
    }

    public void e(c cVar) {
        c.a.r0.u0.i.c.b bVar;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (bVar = cVar.f22647c) != null && (metaData = bVar.f22643f) != null && !metaData.isMask && TbadkCoreApplication.isLogin()) {
                this.f22626b.setVisibility(0);
                this.f22627c.bindData(cVar.f22647c);
                this.f22627c.hideIntroAndLikeButton();
                this.f22630f = cVar.f22649e;
                return;
            }
            this.f22626b.setVisibility(8);
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f22631g = i2;
        }
    }
}
