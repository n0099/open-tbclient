package c.a.r0.a0.f.i;

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
/* loaded from: classes2.dex */
public class b extends c.a.r0.f0.b<c.a.r0.a0.f.a.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public c.a.r0.a0.f.a.c n;
    public a o;
    public int p;
    public int q;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f14557b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14558c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14559d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f14560e;

        /* renamed from: f  reason: collision with root package name */
        public RelativeLayout f14561f;

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
            this.f14557b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f14558c = (TextView) view.findViewById(R.id.tvActiveTitle);
            this.f14559d = (TextView) view.findViewById(R.id.tvActiveSubTitle);
            this.f14560e = (LinearLayout) view.findViewById(R.id.llActiveInfoPanel);
            this.f14561f = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f14558c.setTypeface(Typeface.defaultFromStyle(1));
            this.f14557b.setDefaultBgResource(c.a.r0.a0.f.i.a.a());
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

    @Override // c.a.r0.f0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.square_active_all_layout : invokeV.intValue;
    }

    @Override // c.a.r0.f0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.m == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.o.f14561f, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.o.f14558c, (int) R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.o.f14559d, (int) R.color.CAM_X0111);
        this.o.f14559d.setAlpha(0.9f);
        this.m = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.r0.a0.f.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || view != j() || (cVar = this.n) == null || StringUtils.isNull(cVar.f14169j)) {
            return;
        }
        t(this.n.f14169j);
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int k = n.k(this.f17262g) / 2;
            this.p = k;
            this.q = (k * 9) / 16;
            this.o = new a(j());
            j().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.f0.b
    /* renamed from: q */
    public void k(c.a.r0.a0.f.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || cVar == null) {
            return;
        }
        this.n = cVar;
        int i2 = this.q;
        int i3 = cVar.f14166g;
        if (i3 > 0) {
            i2 = (this.p * cVar.f14167h) / i3;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.o.f14561f.getLayoutParams();
        layoutParams.width = this.p;
        layoutParams.height = i2;
        this.o.f14561f.setLayoutParams(layoutParams);
        this.o.f14557b.startLoad(this.n.f14165f, 10, false);
        this.o.f14558c.setText(this.n.f14164e);
        this.o.f14559d.setText(this.n.f14168i);
        l(this.f17261f, TbadkCoreApplication.getInst().getSkinType());
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
                n.M(this.f17261f.getPageActivity(), R.string.url_is_null);
            } else {
                UrlManager.getInstance().dealOneLinkWithDialog(this.f17261f, "", new String[]{str}, false, null, true);
            }
        }
    }
}
