package c.a.t0.a0.f.i;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b extends c.a.t0.g0.b<c.a.t0.a0.f.a.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public c.a.t0.a0.f.a.c n;
    public a o;
    public int p;
    public int q;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f15095b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15096c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15097d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f15098e;

        /* renamed from: f  reason: collision with root package name */
        public RelativeLayout f15099f;

        public a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view;
            this.f15095b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f15096c = (TextView) view.findViewById(R.id.tvActiveTitle);
            this.f15097d = (TextView) view.findViewById(R.id.tvActiveSubTitle);
            this.f15098e = (LinearLayout) view.findViewById(R.id.llActiveInfoPanel);
            this.f15099f = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f15096c.setTypeface(Typeface.defaultFromStyle(1));
            this.f15095b.setDefaultBgResource(c.a.t0.a0.f.i.a.a());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext) {
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
        this.m = 3;
        this.p = 0;
        this.q = 0;
        p();
    }

    @Override // c.a.t0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.square_active_all_layout : invokeV.intValue;
    }

    @Override // c.a.t0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.m == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.o.f15099f, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.o.f15096c, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.o.f15097d, R.color.CAM_X0111);
        this.o.f15097d.setAlpha(0.9f);
        this.m = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.t0.a0.f.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || view != j() || (cVar = this.n) == null || StringUtils.isNull(cVar.f14689j)) {
            return;
        }
        t(this.n.f14689j);
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int k2 = n.k(this.f18211g) / 2;
            this.p = k2;
            this.q = (k2 * 9) / 16;
            this.o = new a(j());
            j().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.g0.b
    /* renamed from: q */
    public void k(c.a.t0.a0.f.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || cVar == null) {
            return;
        }
        this.n = cVar;
        int i2 = this.q;
        int i3 = cVar.f14686g;
        if (i3 > 0) {
            i2 = (this.p * cVar.f14687h) / i3;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.o.f15099f.getLayoutParams();
        layoutParams.width = this.p;
        layoutParams.height = i2;
        this.o.f15099f.setLayoutParams(layoutParams);
        this.o.f15095b.startLoad(this.n.f14685f, 10, false);
        this.o.f15096c.setText(this.n.f14684e);
        this.o.f15097d.setText(this.n.f14688i);
        l(this.f18210f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void s(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
        }
    }

    public final void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                n.L(this.f18210f.getPageActivity(), R.string.url_is_null);
            } else {
                UrlManager.getInstance().dealOneLinkWithDialog(this.f18210f, "", new String[]{str}, false, null, true);
            }
        }
    }
}
