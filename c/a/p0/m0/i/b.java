package c.a.p0.m0.i;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.p0.m0.i.c.c;
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
    public TbPageContext f21707a;

    /* renamed from: b  reason: collision with root package name */
    public View f21708b;

    /* renamed from: c  reason: collision with root package name */
    public RankListViewController.RankListViewHolder f21709c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21710d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f21711e;

    /* renamed from: f  reason: collision with root package name */
    public String f21712f;

    /* renamed from: g  reason: collision with root package name */
    public int f21713g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f21714h;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21715e;

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
            this.f21715e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (TextUtils.isEmpty(this.f21715e.f21712f)) {
                    this.f21715e.f21707a.showToast(R.string.load_error_retry);
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f21715e.f21707a, new String[]{this.f21715e.f21712f});
                if (this.f21715e.f21713g == 0) {
                    return;
                }
                if (this.f21715e.f21713g != 2) {
                    if (this.f21715e.f21713g == 1) {
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
        this.f21714h = new a(this);
        this.f21707a = tbPageContext;
        this.f21708b = view;
        RankListViewController.RankListViewHolder rankListViewHolder = new RankListViewController.RankListViewHolder(view.findViewById(R.id.user_view));
        this.f21709c = rankListViewHolder;
        rankListViewHolder.setViewHolderType(1);
        this.f21710d = (TextView) view.findViewById(R.id.get_influence);
        TextView textView = (TextView) view.findViewById(R.id.rank_num);
        this.f21711e = textView;
        textView.setTextSize(0, l.g(this.f21707a.getPageActivity(), R.dimen.tbfontsize46));
        this.f21710d.setOnClickListener(this.f21714h);
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f21709c.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.f21709c.itemView, R.color.CAM_X0207);
            SkinManager.setViewTextColor(this.f21710d, R.color.CAM_X0302);
        }
    }

    public void e(c cVar) {
        c.a.p0.m0.i.c.b bVar;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (bVar = cVar.f21732c) != null && (metaData = bVar.f21727f) != null && !metaData.isMask && TbadkCoreApplication.isLogin()) {
                this.f21708b.setVisibility(0);
                this.f21709c.bindData(cVar.f21732c);
                this.f21709c.hideIntroAndLikeButton();
                this.f21712f = cVar.f21734e;
                return;
            }
            this.f21708b.setVisibility(8);
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f21713g = i2;
        }
    }
}
