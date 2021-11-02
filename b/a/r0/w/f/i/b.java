package b.a.r0.w.f.i;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.e.p.l;
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
/* loaded from: classes5.dex */
public class b extends b.a.r0.b0.b<b.a.r0.w.f.a.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public b.a.r0.w.f.a.c n;
    public a o;
    public int p;
    public int q;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f24960a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f24961b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f24962c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f24963d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f24964e;

        /* renamed from: f  reason: collision with root package name */
        public RelativeLayout f24965f;

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
            this.f24960a = view;
            this.f24961b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f24962c = (TextView) view.findViewById(R.id.tvActiveTitle);
            this.f24963d = (TextView) view.findViewById(R.id.tvActiveSubTitle);
            this.f24964e = (LinearLayout) view.findViewById(R.id.llActiveInfoPanel);
            this.f24965f = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f24962c.setTypeface(Typeface.defaultFromStyle(1));
            this.f24961b.setDefaultBgResource(b.a.r0.w.f.i.a.a());
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
        o();
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.square_active_all_layout : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.m == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.o.f24965f, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.o.f24962c, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.o.f24963d, R.color.CAM_X0111);
        this.o.f24963d.setAlpha(0.9f);
        this.m = i2;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int k = l.k(this.f14738g) / 2;
            this.p = k;
            this.q = (k * 9) / 16;
            this.o = new a(i());
            i().setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.a.r0.w.f.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || view != i() || (cVar = this.n) == null || StringUtils.isNull(cVar.j)) {
            return;
        }
        s(this.n.j);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: p */
    public void j(b.a.r0.w.f.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || cVar == null) {
            return;
        }
        this.n = cVar;
        int i2 = this.q;
        int i3 = cVar.f24504g;
        if (i3 > 0) {
            i2 = (this.p * cVar.f24505h) / i3;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.o.f24965f.getLayoutParams();
        layoutParams.width = this.p;
        layoutParams.height = i2;
        this.o.f24965f.setLayoutParams(layoutParams);
        this.o.f24961b.startLoad(this.n.f24503f, 10, false);
        this.o.f24962c.setText(this.n.f24502e);
        this.o.f24963d.setText(this.n.f24506i);
        k(this.f14737f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void q(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
        }
    }

    public final void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                l.L(this.f14737f.getPageActivity(), R.string.url_is_null);
            } else {
                UrlManager.getInstance().dealOneLinkWithDialog(this.f14737f, "", new String[]{str}, false, null, true);
            }
        }
    }
}
