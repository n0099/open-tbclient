package c.a.t0.t1.b;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.ChatAggregationFragment;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class a extends c.a.s0.l0.f.a<FeedData, c.a.s0.l0.d.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView k;
    public TextView l;
    public ImageView m;
    public TextView n;
    public TextView o;
    public View p;
    public int q;

    /* renamed from: c.a.t0.t1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1444a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23712e;

        public View$OnClickListenerC1444a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23712e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23712e.b().dispatchMvcEvent(new c.a.s0.l0.c.b(ChatAggregationFragment.EVENT_TO_PERSON_CENTER, this.f23712e.a(), null, null));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23713e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23713e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                FeedData a = this.f23713e.a();
                this.f23713e.b().dispatchMvcEvent(new c.a.s0.l0.c.b(ChatAggregationFragment.EVENT_TO_PB, a, null, null));
                StatisticItem statisticItem = new StatisticItem("c13784");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fname", a.getFname());
                statisticItem.param("tid", a.getThread_id());
                statisticItem.param("obj_type", 1);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23714e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23714e = aVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f23714e.b().dispatchMvcEvent(new c.a.s0.l0.c.b(ChatAggregationFragment.EVENT_TO_DELETE_AT_ME_ITEM, this.f23714e.a(), null, null));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1], (ViewEventCenter) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = R.color.CAM_X0108;
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.photo);
        this.k = headImageView;
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.k.setAutoChangeStyle(true);
        this.k.setPlaceHolder(1);
        this.l = (TextView) view.findViewById(R.id.user_name);
        this.m = (ImageView) view.findViewById(R.id.fans_reply);
        this.n = (TextView) view.findViewById(R.id.time);
        this.o = (TextView) view.findViewById(R.id.content);
        this.p = view.findViewById(R.id.line);
        this.k.setOnClickListener(new View$OnClickListenerC1444a(this));
        view.setOnClickListener(new b(this));
        view.setOnLongClickListener(new c(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.s0.l0.f.e
    /* renamed from: o */
    public void h(FeedData feedData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, feedData) == null) {
            super.h(feedData);
            if (feedData.getReplyer() != null) {
                MetaData replyer = feedData.getReplyer();
                this.l.setText(UtilHelper.getUserName(replyer));
                if (feedData.getReplyer().isBigV()) {
                    this.q = R.color.cp_cont_r;
                } else {
                    this.q = R.color.CAM_X0108;
                }
                SkinManager.setViewTextColor(this.l, this.q);
                this.k.setIsRound(true);
                this.k.setVisibility(0);
                UtilHelper.showHeadImageViewBigV(this.k, replyer, 0);
                this.k.setTag(null);
                String avater = feedData.getReplyer().getAvater();
                if (avater != null && avater.length() > 0) {
                    this.k.startLoad(avater, 12, false);
                } else {
                    this.k.setImageResource(R.drawable.photo);
                }
                if (feedData.getReplyer().getIsMyFans() == 1) {
                    this.m.setVisibility(0);
                } else {
                    this.m.setVisibility(8);
                }
            }
            this.n.setText(StringHelper.getFormatTime(feedData.getTime()));
            this.o.setText(feedData.getContent());
        }
    }

    @Override // c.a.t0.w3.u
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2)) == null) {
            d().setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
            SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.m, R.drawable.icon_pb_fans);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.l, this.q);
            this.k.invalidate();
            this.n.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
            return false;
        }
        return invokeLI.booleanValue;
    }
}
