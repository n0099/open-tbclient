package c.a.p0.u1.f.j;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.p0.u1.l.c.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistAdapter;
import com.baidu.tieba.im.chat.officialBar.OfficialFeedItemBottom;
import com.baidu.tieba.im.chat.officialBar.OfficialFeedItemImage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes2.dex */
public class b extends c.a.d.a.c<OfficialBarFeedActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f18701b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f18702c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f18703d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f18704e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f18705f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f18706g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialFeedItemImage f18707h;
    public OfficialFeedItemBottom i;
    public OfficialBarFeedMsglistAdapter.c j;
    public boolean k;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.C1417a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18708b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f18709c;

        public a(b bVar, a.C1417a c1417a, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, c1417a, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18709c = bVar;
            this.a = c1417a;
            this.f18708b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f18709c.j == null) {
                return;
            }
            this.f18709c.j.a(this.f18709c.f18706g, this.a, this.f18708b, 0L);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<OfficialBarFeedActivity> tbPageContext, boolean z) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d0641);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.d.a.f) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = null;
        this.k = z;
        i();
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f18702c = (BarImageView) c(R.id.obfuscated_res_0x7f09030d);
            this.f18703d = (TextView) c(R.id.obfuscated_res_0x7f09031c);
            this.f18704e = (TextView) c(R.id.obfuscated_res_0x7f09140b);
            this.f18705f = (LinearLayout) c(R.id.obfuscated_res_0x7f090f61);
            this.f18706g = (RelativeLayout) c(R.id.obfuscated_res_0x7f0915e9);
            View c2 = c(R.id.obfuscated_res_0x7f0915ea);
            this.f18701b = c2;
            if (this.k) {
                c2.setVisibility(8);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.f18704e, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f18703d, (int) R.color.CAM_X0105);
            OfficialFeedItemImage officialFeedItemImage = this.f18707h;
            if (officialFeedItemImage != null) {
                officialFeedItemImage.c();
            }
            OfficialFeedItemBottom officialFeedItemBottom = this.i;
            if (officialFeedItemBottom != null) {
                officialFeedItemBottom.c();
            }
            if (this.k) {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(n.f(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(n.f(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(n.f(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f18705f);
            } else {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(n.f(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(n.f(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(n.f(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f18701b);
            }
        }
    }

    public void k(Context context, a.C1417a c1417a, c.a.p0.u1.h.o.a aVar, c.a.p0.u1.i.a.b.b bVar, int i, boolean z, int i2) {
        String formatTimeForJustNow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, c1417a, aVar, bVar, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || c1417a == null) {
            return;
        }
        if (this.k) {
            this.f18702c.setVisibility(8);
            this.f18703d.setVisibility(8);
            this.f18704e.setTextSize(0, n.f(this.mContext.getPageActivity(), R.dimen.tbds40));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f18704e.getLayoutParams();
            layoutParams.removeRule(11);
            layoutParams.addRule(14);
            this.f18704e.setLayoutParams(layoutParams);
            int f2 = n.f(this.mContext.getPageActivity(), R.dimen.tbds10);
            int f3 = n.f(this.mContext.getPageActivity(), R.dimen.tbds5);
            int f4 = n.f(this.mContext.getPageActivity(), R.dimen.tbds52);
            this.f18706g.setPadding(0, n.f(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
            this.f18705f.setPadding(f2, f3, f2, StringUtils.isNull(c1417a.f18834b) ? 0 : f4 + f2);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f18705f.getLayoutParams();
            layoutParams2.topMargin = n.f(this.mContext.getPageActivity(), R.dimen.tbds27);
            this.f18705f.setLayoutParams(layoutParams2);
        } else {
            this.f18702c.setShowOval(true);
            this.f18702c.setAutoChangeStyle(true);
            this.f18702c.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f18702c.setStrokeColorResId(R.color.CAM_X0401);
            this.f18702c.setPlaceHolder(1);
        }
        if (!this.k && aVar != null) {
            this.f18702c.J(aVar.c(), 10, false);
            this.f18703d.setText(String.format("%s%s", aVar.a(), context.getString(R.string.obfuscated_res_0x7f0f063c)));
        }
        long j = c1417a.m * 1000;
        if (this.k) {
            formatTimeForJustNow = m.getTimeStringNoYear(new Date(j));
        } else {
            formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(j);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(j);
            }
        }
        this.f18704e.setText(formatTimeForJustNow);
        this.i = new OfficialFeedItemBottom(context);
        if (this.k) {
            int f5 = n.f(this.mContext.getPageActivity(), R.dimen.tbds29);
            this.i.setPadding(f5, 0, f5, 0);
        }
        this.i.setData(c1417a, z);
        this.f18705f.removeAllViews();
        this.f18706g.setOnClickListener(new a(this, c1417a, i2));
        if (z) {
            OfficialFeedItemImage officialFeedItemImage = new OfficialFeedItemImage(context, this.k);
            this.f18707h = officialFeedItemImage;
            if (this.k) {
                officialFeedItemImage.a();
                this.i.a(n.f(this.mContext.getPageActivity(), R.dimen.tbds29));
            }
            this.f18705f.addView(this.f18707h);
            this.f18705f.addView(this.i);
            this.f18707h.setData(c1417a, i, bVar);
        } else {
            if (this.k) {
                int f6 = n.f(this.mContext.getPageActivity(), R.dimen.tbds10);
                int f7 = n.f(this.mContext.getPageActivity(), R.dimen.tbds5);
                int f8 = n.f(this.mContext.getPageActivity(), R.dimen.tbds53);
                this.f18705f.setPadding(f6, f7 + f8, f6, f8 + f6);
                this.i.a(n.f(this.mContext.getPageActivity(), R.dimen.tbds26));
            }
            this.f18705f.addView(this.i);
        }
        j();
    }

    public void l(OfficialBarFeedMsglistAdapter.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.j = cVar;
        }
    }
}
