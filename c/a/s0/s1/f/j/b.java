package c.a.s0.s1.f.j;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.s0.s1.l.c.a;
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
/* loaded from: classes8.dex */
public class b extends c.a.d.a.c<OfficialBarFeedActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f22081b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f22082c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22083d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22084e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f22085f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f22086g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialFeedItemImage f22087h;

    /* renamed from: i  reason: collision with root package name */
    public OfficialFeedItemBottom f22088i;

    /* renamed from: j  reason: collision with root package name */
    public OfficialBarFeedMsglistAdapter.c f22089j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f22090k;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1326a f22091e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f22092f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f22093g;

        public a(b bVar, a.C1326a c1326a, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, c1326a, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22093g = bVar;
            this.f22091e = c1326a;
            this.f22092f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22093g.f22089j == null) {
                return;
            }
            this.f22093g.f22089j.a(this.f22093g.f22086g, this.f22091e, this.f22092f, 0L);
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
        this.f22089j = null;
        this.f22090k = z;
        g();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22082c = (BarImageView) c(R.id.bar_icon);
            this.f22083d = (TextView) c(R.id.bar_name);
            this.f22084e = (TextView) c(R.id.message_time);
            this.f22085f = (LinearLayout) c(R.id.item_container);
            this.f22086g = (RelativeLayout) c(R.id.official_bar_feed_item);
            View c2 = c(R.id.official_bar_feed_item_bg);
            this.f22081b = c2;
            if (this.f22090k) {
                c2.setVisibility(8);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.f22084e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f22083d, R.color.CAM_X0105);
            OfficialFeedItemImage officialFeedItemImage = this.f22087h;
            if (officialFeedItemImage != null) {
                officialFeedItemImage.onSkinTypeChange();
            }
            OfficialFeedItemBottom officialFeedItemBottom = this.f22088i;
            if (officialFeedItemBottom != null) {
                officialFeedItemBottom.onSkinTypeChange();
            }
            if (this.f22090k) {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(m.f(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(m.f(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(m.f(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f22085f);
            } else {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(m.f(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(m.f(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(m.f(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f22081b);
            }
        }
    }

    public void i(Context context, a.C1326a c1326a, c.a.s0.s1.h.o.a aVar, c.a.s0.s1.i.a.b.b bVar, int i2, boolean z, int i3) {
        String formatTimeForJustNow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, c1326a, aVar, bVar, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) || c1326a == null) {
            return;
        }
        if (this.f22090k) {
            this.f22082c.setVisibility(8);
            this.f22083d.setVisibility(8);
            this.f22084e.setTextSize(0, m.f(this.mContext.getPageActivity(), R.dimen.tbds40));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f22084e.getLayoutParams();
            layoutParams.removeRule(11);
            layoutParams.addRule(14);
            this.f22084e.setLayoutParams(layoutParams);
            int f2 = m.f(this.mContext.getPageActivity(), R.dimen.tbds10);
            int f3 = m.f(this.mContext.getPageActivity(), R.dimen.tbds5);
            int f4 = m.f(this.mContext.getPageActivity(), R.dimen.tbds52);
            this.f22086g.setPadding(0, m.f(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
            this.f22085f.setPadding(f2, f3, f2, StringUtils.isNull(c1326a.f22267b) ? 0 : f4 + f2);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f22085f.getLayoutParams();
            layoutParams2.topMargin = m.f(this.mContext.getPageActivity(), R.dimen.tbds27);
            this.f22085f.setLayoutParams(layoutParams2);
        } else {
            this.f22082c.setShowOval(true);
            this.f22082c.setAutoChangeStyle(true);
            this.f22082c.setStrokeWith(m.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f22082c.setStrokeColorResId(R.color.CAM_X0401);
            this.f22082c.setPlaceHolder(1);
        }
        if (!this.f22090k && aVar != null) {
            this.f22082c.startLoad(aVar.c(), 10, false);
            this.f22083d.setText(String.format("%s%s", aVar.a(), context.getString(R.string.forum)));
        }
        long j2 = c1326a.m * 1000;
        if (this.f22090k) {
            formatTimeForJustNow = l.getTimeStringNoYear(new Date(j2));
        } else {
            formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(j2);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(j2);
            }
        }
        this.f22084e.setText(formatTimeForJustNow);
        this.f22088i = new OfficialFeedItemBottom(context);
        if (this.f22090k) {
            int f5 = m.f(this.mContext.getPageActivity(), R.dimen.tbds29);
            this.f22088i.setPadding(f5, 0, f5, 0);
        }
        this.f22088i.setData(c1326a, z);
        this.f22085f.removeAllViews();
        this.f22086g.setOnClickListener(new a(this, c1326a, i3));
        if (z) {
            OfficialFeedItemImage officialFeedItemImage = new OfficialFeedItemImage(context, this.f22090k);
            this.f22087h = officialFeedItemImage;
            if (this.f22090k) {
                officialFeedItemImage.adjustForSingleForum();
                this.f22088i.adjustForSingleForum(m.f(this.mContext.getPageActivity(), R.dimen.tbds29));
            }
            this.f22085f.addView(this.f22087h);
            this.f22085f.addView(this.f22088i);
            this.f22087h.setData(c1326a, i2, bVar);
        } else {
            if (this.f22090k) {
                int f6 = m.f(this.mContext.getPageActivity(), R.dimen.tbds10);
                int f7 = m.f(this.mContext.getPageActivity(), R.dimen.tbds5);
                int f8 = m.f(this.mContext.getPageActivity(), R.dimen.tbds53);
                this.f22085f.setPadding(f6, f7 + f8, f6, f8 + f6);
                this.f22088i.adjustForSingleForum(m.f(this.mContext.getPageActivity(), R.dimen.tbds26));
            }
            this.f22085f.addView(this.f22088i);
        }
        h();
    }

    public void j(OfficialBarFeedMsglistAdapter.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f22089j = cVar;
        }
    }
}
