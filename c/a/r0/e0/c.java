package c.a.r0.e0;

import android.content.ClipboardManager;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.f1.d;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c.a.r0.e0.a> f17249e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f17250f;

    /* renamed from: g  reason: collision with root package name */
    public int f17251g;

    /* loaded from: classes3.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.e0.a f17252e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f17253f;

        public a(c cVar, c.a.r0.e0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17253f = cVar;
            this.f17252e = aVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                String h2 = this.f17252e.h();
                if (StringUtils.isNull(h2)) {
                    return false;
                }
                ClipboardManager clipboardManager = (ClipboardManager) this.f17253f.f17250f.getPageActivity().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
                clipboardManager.setText(h2);
                if (clipboardManager.getText() != null) {
                    l.L(this.f17253f.f17250f.getPageActivity(), R.string.copy_to_clip);
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.e0.a f17254e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f17255f;

        public b(c cVar, c.a.r0.e0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17255f = cVar;
            this.f17254e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f17255f.f17250f, new String[]{this.f17254e.c()});
            }
        }
    }

    /* renamed from: c.a.r0.e0.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0831c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f17256a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f17257b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17258c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17259d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f17260e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f17261f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f17262g;

        /* renamed from: h  reason: collision with root package name */
        public View f17263h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f17264i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f17265j;

        public C0831c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public c(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17250f = tbPageContext;
        this.f17251g = i2;
    }

    public final SpannableString b(int i2, long j2, ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2, AbsoluteSizeSpan absoluteSizeSpan, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), foregroundColorSpan, foregroundColorSpan2, absoluteSizeSpan, Integer.valueOf(i3)})) == null) {
            String string = this.f17250f.getString(i2);
            String formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(i3, j2);
            String str = string + "    [icon]" + formatOverBaiwanNum;
            SpannableString spannableString = new SpannableString(str);
            UtilHelper.setSpan(spannableString, str, str, foregroundColorSpan);
            Drawable moneyIcon = CurrencySwitchUtil.getMoneyIcon(i3);
            int g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds24);
            moneyIcon.setBounds(0, 0, g2, g2);
            d dVar = new d(moneyIcon);
            dVar.b(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
            dVar.c(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
            UtilHelper.setSpan(spannableString, str, "[icon]", dVar);
            UtilHelper.setSpan(spannableString, str, formatOverBaiwanNum, foregroundColorSpan2);
            UtilHelper.setSpan(spannableString, str, formatOverBaiwanNum, absoluteSizeSpan);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public final SpannableString c(int i2, long j2, ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), foregroundColorSpan, foregroundColorSpan2})) == null) {
            String string = this.f17250f.getString(i2);
            String long2String = StringHelper.long2String(j2, "yyyy-MM-dd HH:mm");
            String str = string + "    " + long2String;
            SpannableString spannableString = new SpannableString(str);
            UtilHelper.setSpan(spannableString, str, str, foregroundColorSpan);
            UtilHelper.setSpan(spannableString, str, long2String, foregroundColorSpan2);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public final SpannableString d(int i2, String str, ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), str, foregroundColorSpan, foregroundColorSpan2})) == null) {
            String str2 = this.f17250f.getString(i2) + "    " + str;
            SpannableString spannableString = new SpannableString(str2);
            UtilHelper.setSpan(spannableString, str2, str2, foregroundColorSpan);
            UtilHelper.setSpan(spannableString, str2, str, foregroundColorSpan2);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public final void e(C0831c c0831c, c.a.r0.e0.a aVar) {
        SpannableString spannableString;
        SpannableString spannableString2;
        SpannableString spannableString3;
        SpannableString spannableString4;
        String l;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, c0831c, aVar) == null) || c0831c == null || aVar == null) {
            return;
        }
        c0831c.f17262g.setText(this.f17250f.getString(R.string.order_id) + "    ");
        c0831c.f17256a.setText(aVar.h());
        c0831c.f17256a.setOnLongClickListener(new a(this, aVar));
        if (aVar.k() == 1) {
            c0831c.f17257b.startLoad(String.valueOf(R.drawable.icon_payment_success), 24, false);
            SkinManager.setViewTextColor(c0831c.f17257b, R.color.CAM_X0305, 1);
        } else {
            c0831c.f17257b.startLoad(String.valueOf(R.drawable.icon_payment_fail), 24, false);
            SkinManager.setViewTextColor(c0831c.f17257b, R.color.CAM_X0109, 1);
        }
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105));
        new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305));
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(24, true);
        int i4 = this.f17251g;
        if (i4 == 1) {
            SpannableString d2 = d(R.string.buy_product, aVar.l(), foregroundColorSpan, foregroundColorSpan2);
            spannableString3 = b(R.string.consumption_t_bean, aVar.m(), foregroundColorSpan, foregroundColorSpan2, absoluteSizeSpan, aVar.e());
            spannableString = c(R.string.buy_time, aVar.d(), foregroundColorSpan, foregroundColorSpan2);
            spannableString4 = d2;
            spannableString2 = null;
        } else if (i4 == 2) {
            SpannableString d3 = d(R.string.get_with_product, aVar.l(), foregroundColorSpan, foregroundColorSpan2);
            spannableString3 = b(CurrencySwitchUtil.isYyIsConvert(aVar.e()) ? R.string.get_y_bean : R.string.get_t_bean, aVar.m(), foregroundColorSpan, foregroundColorSpan2, absoluteSizeSpan, aVar.e());
            spannableString = c(R.string.buy_time, aVar.d(), foregroundColorSpan, foregroundColorSpan2);
            String str = "" + aVar.j();
            String str2 = this.f17250f.getString(R.string.alternative_account) + "    " + str;
            SpannableString spannableString5 = new SpannableString(str2);
            UtilHelper.setSpan(spannableString5, str2, str2, foregroundColorSpan);
            UtilHelper.setSpan(spannableString5, str2, str, foregroundColorSpan2);
            spannableString2 = spannableString5;
            spannableString4 = d3;
        } else if (i4 == 3) {
            String string = this.f17250f.getString(R.string.recharge_product);
            if (CurrencySwitchUtil.isYyIsConvert(aVar.e())) {
                l = String.format(this.f17250f.getString(R.string.ydou_rmb), g(Double.valueOf(aVar.i())));
            } else {
                l = aVar.l();
            }
            String str3 = string + "    " + l;
            spannableString4 = new SpannableString(str3);
            UtilHelper.setSpan(spannableString4, str3, str3, foregroundColorSpan);
            UtilHelper.setSpan(spannableString4, str3, l, foregroundColorSpan2);
            String str4 = ("" + aVar.g()) + this.f17250f.getString(R.string.recharge_use_money);
            String str5 = this.f17250f.getString(R.string.recharge_money) + "    " + str4;
            SpannableString spannableString6 = new SpannableString(str5);
            UtilHelper.setSpan(spannableString6, str5, str5, foregroundColorSpan);
            UtilHelper.setSpan(spannableString6, str5, str4, foregroundColorSpan2);
            UtilHelper.setSpan(spannableString6, str5, str4, absoluteSizeSpan);
            spannableString3 = spannableString6;
            SpannableString c2 = c(R.string.recharge_time, aVar.f(), foregroundColorSpan, foregroundColorSpan2);
            String str6 = "" + aVar.j();
            String str7 = this.f17250f.getString(R.string.recharge_account) + "    " + str6;
            spannableString2 = new SpannableString(str7);
            UtilHelper.setSpan(spannableString2, str7, str7, foregroundColorSpan);
            UtilHelper.setSpan(spannableString2, str7, str6, foregroundColorSpan2);
            spannableString = c2;
        } else {
            spannableString = null;
            spannableString2 = null;
            spannableString3 = null;
            spannableString4 = null;
        }
        c0831c.f17258c.setText(spannableString4);
        c0831c.f17259d.setText(spannableString3);
        c0831c.f17260e.setText(spannableString);
        if (!StringUtils.isNull(aVar.j()) && ((i3 = this.f17251g) == 3 || i3 == 2)) {
            c0831c.f17261f.setVisibility(0);
            c0831c.f17261f.setText(spannableString2);
        } else {
            c0831c.f17261f.setVisibility(8);
        }
        if (!StringUtils.isNull(aVar.b())) {
            c0831c.f17264i.setText(aVar.b());
            if (!StringUtils.isNull(aVar.a())) {
                c0831c.f17265j.setText(aVar.a());
                i2 = 0;
                c0831c.f17265j.setVisibility(0);
            } else {
                i2 = 0;
                c0831c.f17265j.setVisibility(8);
            }
            c0831c.f17265j.setOnClickListener(new b(this, aVar));
            c0831c.f17263h.setVisibility(i2);
            return;
        }
        c0831c.f17263h.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: f */
    public c.a.r0.e0.a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            ArrayList<c.a.r0.e0.a> arrayList = this.f17249e;
            if (arrayList == null || arrayList.size() <= 0 || i2 < 0 || i2 >= getCount()) {
                return null;
            }
            return this.f17249e.get(i2);
        }
        return (c.a.r0.e0.a) invokeI.objValue;
    }

    public final String g(Double d2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, d2)) == null) {
            if (d2.doubleValue() == d2.intValue()) {
                return d2.intValue() + "";
            }
            return d2 + "";
        }
        return (String) invokeL.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList<c.a.r0.e0.a> arrayList = this.f17249e;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C0831c c0831c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i2, view, viewGroup)) == null) {
            c.a.r0.e0.a item = getItem(i2);
            if (view != null) {
                c0831c = (C0831c) view.getTag();
            } else {
                view = LayoutInflater.from(this.f17250f.getPageActivity()).inflate(R.layout.records_item_layout, viewGroup, false);
                c0831c = new C0831c();
                c0831c.f17256a = (TextView) view.findViewById(R.id.order_id_textview);
                c0831c.f17257b = (TbImageView) view.findViewById(R.id.order_status_textview);
                c0831c.f17258c = (TextView) view.findViewById(R.id.order_title_textview);
                c0831c.f17259d = (TextView) view.findViewById(R.id.order_price_textview);
                c0831c.f17262g = (TextView) view.findViewById(R.id.order_id_tip);
                c0831c.f17261f = (TextView) view.findViewById(R.id.order_account_textview);
                c0831c.f17260e = (TextView) view.findViewById(R.id.order_time_textview);
                c0831c.f17263h = view.findViewById(R.id.order_activity_content);
                c0831c.f17264i = (TextView) view.findViewById(R.id.activity_desc_textview);
                c0831c.f17265j = (TextView) view.findViewById(R.id.activity_button_textview);
                view.setTag(c0831c);
            }
            e(c0831c, item);
            this.f17250f.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public void h(ArrayList<c.a.r0.e0.a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, arrayList) == null) {
            this.f17249e = arrayList;
        }
    }
}
