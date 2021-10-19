package c.a.r0.x0.n1.g;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.q0.s.q.d2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class g extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout O;
    public TextView P;
    public TextView Q;
    public TextView R;

    /* loaded from: classes4.dex */
    public class a implements c.a.q0.f1.j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f27493a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27493a = gVar;
        }

        @Override // c.a.q0.f1.j.d
        public void a(View view, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                g gVar = this.f27493a;
                if (gVar.z == null || !gVar.T()) {
                    return;
                }
                UrlManager urlManager = UrlManager.getInstance();
                g gVar2 = this.f27493a;
                urlManager.dealOneLink(gVar2.f15708f, new String[]{gVar2.z.x()});
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View j2 = j();
        this.O = (RelativeLayout) j2.findViewById(R.id.lottery_info_layout);
        this.P = (TextView) j2.findViewById(R.id.lottery_time_tv);
        this.Q = (TextView) j2.findViewById(R.id.lottery_join_count_tv);
        this.R = (TextView) j2.findViewById(R.id.lottery_btn);
    }

    public boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TbadkCoreApplication.isLogin()) {
                return true;
            }
            ViewHelper.skipToLoginActivity(this.f15708f.getPageActivity());
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.b0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.card_frs_lottery_new_frame : invokeV.intValue;
    }

    @Override // c.a.r0.x0.n1.g.c, c.a.r0.b0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            if (this.y != i2) {
                SkinManager.setBackgroundColor(this.O, R.color.CAM_X0205);
                SkinManager.setViewTextColor(this.P, R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.Q, R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.R, R.color.CAM_X0302);
                SkinManager.setBackgroundResource(this.R, R.drawable.bg_card_frs_lottery_btn);
            }
            super.l(tbPageContext, i2);
        }
    }

    @Override // c.a.r0.x0.n1.g.c
    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && this.z != null && T()) {
            UrlManager.getInstance().dealOneLink(this.f15708f, new String[]{this.z.x()});
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.b0.b
    /* renamed from: y */
    public void k(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, d2Var) == null) || d2Var == null) {
            return;
        }
        if (ListUtils.getCount(d2Var.E0()) > 1) {
            ArrayList<MediaData> arrayList = new ArrayList<>();
            arrayList.add(d2Var.E0().get(0));
            d2Var.h4(arrayList);
        }
        super.y(d2Var);
        this.D.setImageClickListener(new a(this));
        c.a.q0.s.q.b bVar = (c.a.q0.s.q.b) ListUtils.getItem(d2Var.q(), 0);
        if (bVar != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
            this.P.setText(StringUtils.string(d().getResources().getString(R.string.lottery_time), GlideException.IndentedAppendable.INDENT, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.b()))), "-", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.c())))));
            this.Q.setText(String.format(d().getResources().getString(R.string.lottery_join_num), String.valueOf(bVar.f())));
            this.R.setText(R.string.lottery_btn_text);
            this.o.setCommentNumEnable(false);
        }
    }
}
