package c.a.r0.s1.f.j;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.r0.s1.l.c.a;
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
    public View f21722b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f21723c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21724d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f21725e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f21726f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f21727g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialFeedItemImage f21728h;

    /* renamed from: i  reason: collision with root package name */
    public OfficialFeedItemBottom f21729i;

    /* renamed from: j  reason: collision with root package name */
    public OfficialBarFeedMsglistAdapter.c f21730j;
    public boolean k;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1364a f21731e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f21732f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f21733g;

        public a(b bVar, a.C1364a c1364a, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, c1364a, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21733g = bVar;
            this.f21731e = c1364a;
            this.f21732f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21733g.f21730j == null) {
                return;
            }
            this.f21733g.f21730j.a(this.f21733g.f21727g, this.f21731e, this.f21732f, 0L);
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
        this.f21730j = null;
        this.k = z;
        g();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21723c = (BarImageView) c(R.id.bar_icon);
            this.f21724d = (TextView) c(R.id.bar_name);
            this.f21725e = (TextView) c(R.id.message_time);
            this.f21726f = (LinearLayout) c(R.id.item_container);
            this.f21727g = (RelativeLayout) c(R.id.official_bar_feed_item);
            View c2 = c(R.id.official_bar_feed_item_bg);
            this.f21722b = c2;
            if (this.k) {
                c2.setVisibility(8);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.f21725e, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f21724d, (int) R.color.CAM_X0105);
            OfficialFeedItemImage officialFeedItemImage = this.f21728h;
            if (officialFeedItemImage != null) {
                officialFeedItemImage.onSkinTypeChange();
            }
            OfficialFeedItemBottom officialFeedItemBottom = this.f21729i;
            if (officialFeedItemBottom != null) {
                officialFeedItemBottom.onSkinTypeChange();
            }
            if (this.k) {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(n.f(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(n.f(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(n.f(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f21726f);
            } else {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(n.f(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(n.f(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(n.f(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f21722b);
            }
        }
    }

    public void i(Context context, a.C1364a c1364a, c.a.r0.s1.h.o.a aVar, c.a.r0.s1.i.a.b.b bVar, int i2, boolean z, int i3) {
        String formatTimeForJustNow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, c1364a, aVar, bVar, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) || c1364a == null) {
            return;
        }
        if (this.k) {
            this.f21723c.setVisibility(8);
            this.f21724d.setVisibility(8);
            this.f21725e.setTextSize(0, n.f(this.mContext.getPageActivity(), R.dimen.tbds40));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f21725e.getLayoutParams();
            layoutParams.removeRule(11);
            layoutParams.addRule(14);
            this.f21725e.setLayoutParams(layoutParams);
            int f2 = n.f(this.mContext.getPageActivity(), R.dimen.tbds10);
            int f3 = n.f(this.mContext.getPageActivity(), R.dimen.tbds5);
            int f4 = n.f(this.mContext.getPageActivity(), R.dimen.tbds52);
            this.f21727g.setPadding(0, n.f(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
            this.f21726f.setPadding(f2, f3, f2, StringUtils.isNull(c1364a.f21901b) ? 0 : f4 + f2);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f21726f.getLayoutParams();
            layoutParams2.topMargin = n.f(this.mContext.getPageActivity(), R.dimen.tbds27);
            this.f21726f.setLayoutParams(layoutParams2);
        } else {
            this.f21723c.setShowOval(true);
            this.f21723c.setAutoChangeStyle(true);
            this.f21723c.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f21723c.setStrokeColorResId(R.color.CAM_X0401);
            this.f21723c.setPlaceHolder(1);
        }
        if (!this.k && aVar != null) {
            this.f21723c.startLoad(aVar.c(), 10, false);
            this.f21724d.setText(String.format("%s%s", aVar.a(), context.getString(R.string.forum)));
        }
        long j2 = c1364a.m * 1000;
        if (this.k) {
            formatTimeForJustNow = m.getTimeStringNoYear(new Date(j2));
        } else {
            formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(j2);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(j2);
            }
        }
        this.f21725e.setText(formatTimeForJustNow);
        this.f21729i = new OfficialFeedItemBottom(context);
        if (this.k) {
            int f5 = n.f(this.mContext.getPageActivity(), R.dimen.tbds29);
            this.f21729i.setPadding(f5, 0, f5, 0);
        }
        this.f21729i.setData(c1364a, z);
        this.f21726f.removeAllViews();
        this.f21727g.setOnClickListener(new a(this, c1364a, i3));
        if (z) {
            OfficialFeedItemImage officialFeedItemImage = new OfficialFeedItemImage(context, this.k);
            this.f21728h = officialFeedItemImage;
            if (this.k) {
                officialFeedItemImage.adjustForSingleForum();
                this.f21729i.adjustForSingleForum(n.f(this.mContext.getPageActivity(), R.dimen.tbds29));
            }
            this.f21726f.addView(this.f21728h);
            this.f21726f.addView(this.f21729i);
            this.f21728h.setData(c1364a, i2, bVar);
        } else {
            if (this.k) {
                int f6 = n.f(this.mContext.getPageActivity(), R.dimen.tbds10);
                int f7 = n.f(this.mContext.getPageActivity(), R.dimen.tbds5);
                int f8 = n.f(this.mContext.getPageActivity(), R.dimen.tbds53);
                this.f21726f.setPadding(f6, f7 + f8, f6, f8 + f6);
                this.f21729i.adjustForSingleForum(n.f(this.mContext.getPageActivity(), R.dimen.tbds26));
            }
            this.f21726f.addView(this.f21729i);
        }
        h();
    }

    public void j(OfficialBarFeedMsglistAdapter.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f21730j = cVar;
        }
    }
}
