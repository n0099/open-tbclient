package c.a.q0.m0.i;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.q0.m0.i.c.c;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f22037a;

    /* renamed from: b  reason: collision with root package name */
    public View f22038b;

    /* renamed from: c  reason: collision with root package name */
    public RankListViewController.RankListViewHolder f22039c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22040d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22041e;

    /* renamed from: f  reason: collision with root package name */
    public String f22042f;

    /* renamed from: g  reason: collision with root package name */
    public int f22043g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f22044h;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22045e;

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
            this.f22045e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (TextUtils.isEmpty(this.f22045e.f22042f)) {
                    this.f22045e.f22037a.showToast(R.string.load_error_retry);
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f22045e.f22037a, new String[]{this.f22045e.f22042f});
                if (this.f22045e.f22043g == 0) {
                    return;
                }
                if (this.f22045e.f22043g != 2) {
                    if (this.f22045e.f22043g == 1) {
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
        this.f22044h = new a(this);
        this.f22037a = tbPageContext;
        this.f22038b = view;
        RankListViewController.RankListViewHolder rankListViewHolder = new RankListViewController.RankListViewHolder(view.findViewById(R.id.user_view));
        this.f22039c = rankListViewHolder;
        rankListViewHolder.setViewHolderType(1);
        this.f22040d = (TextView) view.findViewById(R.id.get_influence);
        TextView textView = (TextView) view.findViewById(R.id.rank_num);
        this.f22041e = textView;
        textView.setTextSize(0, l.g(this.f22037a.getPageActivity(), R.dimen.tbfontsize46));
        this.f22040d.setOnClickListener(this.f22044h);
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f22039c.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.f22039c.itemView, R.color.CAM_X0207);
            SkinManager.setViewTextColor(this.f22040d, R.color.CAM_X0302);
        }
    }

    public void e(c cVar) {
        c.a.q0.m0.i.c.b bVar;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (bVar = cVar.f22062c) != null && (metaData = bVar.f22057f) != null && !metaData.isMask && TbadkCoreApplication.isLogin()) {
                this.f22038b.setVisibility(0);
                this.f22039c.bindData(cVar.f22062c);
                this.f22039c.hideIntroAndLikeButton();
                this.f22042f = cVar.f22064e;
                return;
            }
            this.f22038b.setVisibility(8);
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f22043g = i2;
        }
    }
}
