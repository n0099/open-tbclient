package c.a.r0.l1.f.j;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.r0.l1.l.c.a;
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
/* loaded from: classes3.dex */
public class b extends c.a.e.a.c<OfficialBarFeedActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f21443b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f21444c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21445d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f21446e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f21447f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f21448g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialFeedItemImage f21449h;

    /* renamed from: i  reason: collision with root package name */
    public OfficialFeedItemBottom f21450i;

    /* renamed from: j  reason: collision with root package name */
    public OfficialBarFeedMsglistAdapter.c f21451j;
    public boolean k;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1010a f21452e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f21453f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f21454g;

        public a(b bVar, a.C1010a c1010a, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, c1010a, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21454g = bVar;
            this.f21452e = c1010a;
            this.f21453f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21454g.f21451j == null) {
                return;
            }
            this.f21454g.f21451j.a(this.f21454g.f21448g, this.f21452e, this.f21453f, 0L);
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
                super((c.a.e.a.f) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21451j = null;
        this.k = z;
        g();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21444c = (BarImageView) c(R.id.bar_icon);
            this.f21445d = (TextView) c(R.id.bar_name);
            this.f21446e = (TextView) c(R.id.message_time);
            this.f21447f = (LinearLayout) c(R.id.item_container);
            this.f21448g = (RelativeLayout) c(R.id.official_bar_feed_item);
            View c2 = c(R.id.official_bar_feed_item_bg);
            this.f21443b = c2;
            if (this.k) {
                c2.setVisibility(8);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.f21446e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f21445d, R.color.CAM_X0105);
            OfficialFeedItemImage officialFeedItemImage = this.f21449h;
            if (officialFeedItemImage != null) {
                officialFeedItemImage.onSkinTypeChange();
            }
            OfficialFeedItemBottom officialFeedItemBottom = this.f21450i;
            if (officialFeedItemBottom != null) {
                officialFeedItemBottom.onSkinTypeChange();
            }
            if (this.k) {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f21447f);
            } else {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f21443b);
            }
        }
    }

    public void i(Context context, a.C1010a c1010a, c.a.r0.l1.h.o.a aVar, c.a.r0.l1.i.a.b.b bVar, int i2, boolean z, int i3) {
        String formatTimeForJustNow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, c1010a, aVar, bVar, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) || c1010a == null) {
            return;
        }
        if (this.k) {
            this.f21444c.setVisibility(8);
            this.f21445d.setVisibility(8);
            this.f21446e.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds40));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f21446e.getLayoutParams();
            layoutParams.removeRule(11);
            layoutParams.addRule(14);
            this.f21446e.setLayoutParams(layoutParams);
            int g2 = l.g(this.mContext.getPageActivity(), R.dimen.tbds10);
            int g3 = l.g(this.mContext.getPageActivity(), R.dimen.tbds5);
            int g4 = l.g(this.mContext.getPageActivity(), R.dimen.tbds52);
            this.f21448g.setPadding(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
            this.f21447f.setPadding(g2, g3, g2, StringUtils.isNull(c1010a.f21673b) ? 0 : g4 + g2);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f21447f.getLayoutParams();
            layoutParams2.topMargin = l.g(this.mContext.getPageActivity(), R.dimen.tbds27);
            this.f21447f.setLayoutParams(layoutParams2);
        } else {
            this.f21444c.setShowOval(true);
            this.f21444c.setAutoChangeStyle(true);
            this.f21444c.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f21444c.setStrokeColorResId(R.color.CAM_X0401);
            this.f21444c.setPlaceHolder(1);
        }
        if (!this.k && aVar != null) {
            this.f21444c.startLoad(aVar.c(), 10, false);
            this.f21445d.setText(String.format("%s%s", aVar.a(), context.getString(R.string.forum)));
        }
        long j2 = c1010a.m * 1000;
        if (this.k) {
            formatTimeForJustNow = k.getTimeStringNoYear(new Date(j2));
        } else {
            formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(j2);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(j2);
            }
        }
        this.f21446e.setText(formatTimeForJustNow);
        this.f21450i = new OfficialFeedItemBottom(context);
        if (this.k) {
            int g5 = l.g(this.mContext.getPageActivity(), R.dimen.tbds29);
            this.f21450i.setPadding(g5, 0, g5, 0);
        }
        this.f21450i.setData(c1010a, z);
        this.f21447f.removeAllViews();
        this.f21448g.setOnClickListener(new a(this, c1010a, i3));
        if (z) {
            OfficialFeedItemImage officialFeedItemImage = new OfficialFeedItemImage(context, this.k);
            this.f21449h = officialFeedItemImage;
            if (this.k) {
                officialFeedItemImage.adjustForSingleForum();
                this.f21450i.adjustForSingleForum(l.g(this.mContext.getPageActivity(), R.dimen.tbds29));
            }
            this.f21447f.addView(this.f21449h);
            this.f21447f.addView(this.f21450i);
            this.f21449h.setData(c1010a, i2, bVar);
        } else {
            if (this.k) {
                int g6 = l.g(this.mContext.getPageActivity(), R.dimen.tbds10);
                int g7 = l.g(this.mContext.getPageActivity(), R.dimen.tbds5);
                int g8 = l.g(this.mContext.getPageActivity(), R.dimen.tbds53);
                this.f21447f.setPadding(g6, g7 + g8, g6, g8 + g6);
                this.f21450i.adjustForSingleForum(l.g(this.mContext.getPageActivity(), R.dimen.tbds26));
            }
            this.f21447f.addView(this.f21450i);
        }
        h();
    }

    public void j(OfficialBarFeedMsglistAdapter.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f21451j = cVar;
        }
    }
}
