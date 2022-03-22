package c.a.p0.v1.b;

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
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class a extends c.a.o0.k0.f.a<FeedData, c.a.o0.k0.d.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f19101g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19102h;
    public ImageView i;
    public TextView j;
    public TextView k;
    public View l;
    public int m;

    /* renamed from: c.a.p0.v1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1446a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public View$OnClickListenerC1446a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.c().dispatchMvcEvent(new c.a.o0.k0.c.b(9483, this.a.b(), null, null));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                FeedData b2 = this.a.b();
                this.a.c().dispatchMvcEvent(new c.a.o0.k0.c.b(9484, b2, null, null));
                StatisticItem statisticItem = new StatisticItem("c13784");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fname", b2.getFname());
                statisticItem.param("tid", b2.getThread_id());
                statisticItem.param("obj_type", 1);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.a.c().dispatchMvcEvent(new c.a.o0.k0.c.b(9489, this.a.b(), null, null));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1], (ViewEventCenter) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = R.color.CAM_X0108;
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.obfuscated_res_0x7f091827);
        this.f19101g = headImageView;
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f19101g.setAutoChangeStyle(true);
        this.f19101g.setPlaceHolder(1);
        this.f19102h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0922bb);
        this.i = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090974);
        this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091ffb);
        this.k = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0906d7);
        this.l = view.findViewById(R.id.obfuscated_res_0x7f091255);
        this.f19101g.setOnClickListener(new View$OnClickListenerC1446a(this));
        view.setOnClickListener(new b(this));
        view.setOnLongClickListener(new c(this));
    }

    @Override // c.a.p0.a4.v
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i)) == null) {
            e().setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.i, R.drawable.icon_pb_fans);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f19102h, this.m);
            this.f19101g.invalidate();
            this.j.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.k0.f.e
    /* renamed from: p */
    public void i(FeedData feedData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, feedData) == null) {
            super.i(feedData);
            if (feedData.getReplyer() != null) {
                MetaData replyer = feedData.getReplyer();
                this.f19102h.setText(UtilHelper.getUserName(replyer));
                if (feedData.getReplyer().isBigV()) {
                    this.m = R.color.cp_cont_r;
                } else {
                    this.m = R.color.CAM_X0108;
                }
                SkinManager.setViewTextColor(this.f19102h, this.m);
                this.f19101g.setIsRound(true);
                this.f19101g.setVisibility(0);
                UtilHelper.showHeadImageViewBigV(this.f19101g, replyer, 0);
                this.f19101g.setTag(null);
                String avater = feedData.getReplyer().getAvater();
                if (avater != null && avater.length() > 0) {
                    this.f19101g.J(avater, 12, false);
                } else {
                    this.f19101g.setImageResource(R.drawable.obfuscated_res_0x7f080ed1);
                }
                if (feedData.getReplyer().getIsMyFans() == 1) {
                    this.i.setVisibility(0);
                } else {
                    this.i.setVisibility(8);
                }
            }
            this.j.setText(StringHelper.getFormatTime(feedData.getTime()));
            this.k.setText(feedData.getContent());
        }
    }
}
