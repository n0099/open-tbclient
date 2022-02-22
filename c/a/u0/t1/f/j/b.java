package c.a.u0.t1.f.j;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.u0.t1.l.c.a;
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
/* loaded from: classes9.dex */
public class b extends c.a.d.a.c<OfficialBarFeedActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f22466b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f22467c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22468d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22469e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f22470f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f22471g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialFeedItemImage f22472h;

    /* renamed from: i  reason: collision with root package name */
    public OfficialFeedItemBottom f22473i;

    /* renamed from: j  reason: collision with root package name */
    public OfficialBarFeedMsglistAdapter.c f22474j;
    public boolean k;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1387a f22475e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f22476f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f22477g;

        public a(b bVar, a.C1387a c1387a, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, c1387a, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22477g = bVar;
            this.f22475e = c1387a;
            this.f22476f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22477g.f22474j == null) {
                return;
            }
            this.f22477g.f22474j.a(this.f22477g.f22471g, this.f22475e, this.f22476f, 0L);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<OfficialBarFeedActivity> tbPageContext, boolean z) {
        super(tbPageContext, R.layout.official_feed_item_container);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.d.a.f) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22474j = null;
        this.k = z;
        g();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22467c = (BarImageView) c(R.id.bar_icon);
            this.f22468d = (TextView) c(R.id.bar_name);
            this.f22469e = (TextView) c(R.id.message_time);
            this.f22470f = (LinearLayout) c(R.id.item_container);
            this.f22471g = (RelativeLayout) c(R.id.official_bar_feed_item);
            View c2 = c(R.id.official_bar_feed_item_bg);
            this.f22466b = c2;
            if (this.k) {
                c2.setVisibility(8);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.f22469e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f22468d, R.color.CAM_X0105);
            OfficialFeedItemImage officialFeedItemImage = this.f22472h;
            if (officialFeedItemImage != null) {
                officialFeedItemImage.onSkinTypeChange();
            }
            OfficialFeedItemBottom officialFeedItemBottom = this.f22473i;
            if (officialFeedItemBottom != null) {
                officialFeedItemBottom.onSkinTypeChange();
            }
            if (this.k) {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(n.f(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(n.f(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(n.f(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f22470f);
            } else {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(n.f(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(n.f(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(n.f(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f22466b);
            }
        }
    }

    public void i(Context context, a.C1387a c1387a, c.a.u0.t1.h.o.a aVar, c.a.u0.t1.i.a.b.b bVar, int i2, boolean z, int i3) {
        String formatTimeForJustNow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, c1387a, aVar, bVar, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) || c1387a == null) {
            return;
        }
        if (this.k) {
            this.f22467c.setVisibility(8);
            this.f22468d.setVisibility(8);
            this.f22469e.setTextSize(0, n.f(this.mContext.getPageActivity(), R.dimen.tbds40));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f22469e.getLayoutParams();
            layoutParams.removeRule(11);
            layoutParams.addRule(14);
            this.f22469e.setLayoutParams(layoutParams);
            int f2 = n.f(this.mContext.getPageActivity(), R.dimen.tbds10);
            int f3 = n.f(this.mContext.getPageActivity(), R.dimen.tbds5);
            int f4 = n.f(this.mContext.getPageActivity(), R.dimen.tbds52);
            this.f22471g.setPadding(0, n.f(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
            this.f22470f.setPadding(f2, f3, f2, StringUtils.isNull(c1387a.f22645b) ? 0 : f4 + f2);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f22470f.getLayoutParams();
            layoutParams2.topMargin = n.f(this.mContext.getPageActivity(), R.dimen.tbds27);
            this.f22470f.setLayoutParams(layoutParams2);
        } else {
            this.f22467c.setShowOval(true);
            this.f22467c.setAutoChangeStyle(true);
            this.f22467c.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f22467c.setStrokeColorResId(R.color.CAM_X0401);
            this.f22467c.setPlaceHolder(1);
        }
        if (!this.k && aVar != null) {
            this.f22467c.startLoad(aVar.c(), 10, false);
            this.f22468d.setText(String.format("%s%s", aVar.a(), context.getString(R.string.forum)));
        }
        long j2 = c1387a.m * 1000;
        if (this.k) {
            formatTimeForJustNow = m.getTimeStringNoYear(new Date(j2));
        } else {
            formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(j2);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(j2);
            }
        }
        this.f22469e.setText(formatTimeForJustNow);
        this.f22473i = new OfficialFeedItemBottom(context);
        if (this.k) {
            int f5 = n.f(this.mContext.getPageActivity(), R.dimen.tbds29);
            this.f22473i.setPadding(f5, 0, f5, 0);
        }
        this.f22473i.setData(c1387a, z);
        this.f22470f.removeAllViews();
        this.f22471g.setOnClickListener(new a(this, c1387a, i3));
        if (z) {
            OfficialFeedItemImage officialFeedItemImage = new OfficialFeedItemImage(context, this.k);
            this.f22472h = officialFeedItemImage;
            if (this.k) {
                officialFeedItemImage.adjustForSingleForum();
                this.f22473i.adjustForSingleForum(n.f(this.mContext.getPageActivity(), R.dimen.tbds29));
            }
            this.f22470f.addView(this.f22472h);
            this.f22470f.addView(this.f22473i);
            this.f22472h.setData(c1387a, i2, bVar);
        } else {
            if (this.k) {
                int f6 = n.f(this.mContext.getPageActivity(), R.dimen.tbds10);
                int f7 = n.f(this.mContext.getPageActivity(), R.dimen.tbds5);
                int f8 = n.f(this.mContext.getPageActivity(), R.dimen.tbds53);
                this.f22470f.setPadding(f6, f7 + f8, f6, f8 + f6);
                this.f22473i.adjustForSingleForum(n.f(this.mContext.getPageActivity(), R.dimen.tbds26));
            }
            this.f22470f.addView(this.f22473i);
        }
        h();
    }

    public void j(OfficialBarFeedMsglistAdapter.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f22474j = cVar;
        }
    }
}
