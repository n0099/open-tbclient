package c.a.p0.k0;

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
import c.a.d.f.p.n;
import c.a.o0.e1.d;
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
/* loaded from: classes2.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<c.a.p0.k0.a> a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f15923b;

    /* renamed from: c  reason: collision with root package name */
    public int f15924c;

    /* loaded from: classes2.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.k0.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f15925b;

        public a(c cVar, c.a.p0.k0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15925b = cVar;
            this.a = aVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                String h2 = this.a.h();
                if (StringUtils.isNull(h2)) {
                    return false;
                }
                ClipboardManager clipboardManager = (ClipboardManager) this.f15925b.f15923b.getPageActivity().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
                clipboardManager.setText(h2);
                if (clipboardManager.getText() != null) {
                    n.M(this.f15925b.f15923b.getPageActivity(), R.string.obfuscated_res_0x7f0f043a);
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.k0.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f15926b;

        public b(c cVar, c.a.p0.k0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15926b = cVar;
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f15926b.f15923b, new String[]{this.a.c()});
            }
        }
    }

    /* renamed from: c.a.p0.k0.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1192c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f15927b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15928c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15929d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f15930e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f15931f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f15932g;

        /* renamed from: h  reason: collision with root package name */
        public View f15933h;
        public TextView i;
        public TextView j;

        public C1192c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public c(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15923b = tbPageContext;
        this.f15924c = i;
    }

    public final SpannableString b(int i, long j, ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2, AbsoluteSizeSpan absoluteSizeSpan, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), foregroundColorSpan, foregroundColorSpan2, absoluteSizeSpan, Integer.valueOf(i2)})) == null) {
            String string = this.f15923b.getString(i);
            String formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(i2, j);
            String str = string + "    [icon]" + formatOverBaiwanNum;
            SpannableString spannableString = new SpannableString(str);
            UtilHelper.setSpan(spannableString, str, str, foregroundColorSpan);
            Drawable moneyIcon = CurrencySwitchUtil.getMoneyIcon(i2);
            int f2 = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701e8);
            moneyIcon.setBounds(0, 0, f2, f2);
            d dVar = new d(moneyIcon);
            dVar.b(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070229));
            dVar.c(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070229));
            UtilHelper.setSpan(spannableString, str, "[icon]", dVar);
            UtilHelper.setSpan(spannableString, str, formatOverBaiwanNum, foregroundColorSpan2);
            UtilHelper.setSpan(spannableString, str, formatOverBaiwanNum, absoluteSizeSpan);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public final SpannableString c(int i, long j, ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), foregroundColorSpan, foregroundColorSpan2})) == null) {
            String string = this.f15923b.getString(i);
            String long2String = StringHelper.long2String(j, "yyyy-MM-dd HH:mm");
            String str = string + "    " + long2String;
            SpannableString spannableString = new SpannableString(str);
            UtilHelper.setSpan(spannableString, str, str, foregroundColorSpan);
            UtilHelper.setSpan(spannableString, str, long2String, foregroundColorSpan2);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public final SpannableString d(int i, String str, ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), str, foregroundColorSpan, foregroundColorSpan2})) == null) {
            String str2 = this.f15923b.getString(i) + "    " + str;
            SpannableString spannableString = new SpannableString(str2);
            UtilHelper.setSpan(spannableString, str2, str2, foregroundColorSpan);
            UtilHelper.setSpan(spannableString, str2, str, foregroundColorSpan2);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public final void e(C1192c c1192c, c.a.p0.k0.a aVar) {
        SpannableString spannableString;
        SpannableString spannableString2;
        SpannableString spannableString3;
        SpannableString spannableString4;
        String l;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, c1192c, aVar) == null) || c1192c == null || aVar == null) {
            return;
        }
        c1192c.f15932g.setText(this.f15923b.getString(R.string.obfuscated_res_0x7f0f0cdb) + "    ");
        c1192c.a.setText(aVar.h());
        c1192c.a.setOnLongClickListener(new a(this, aVar));
        if (aVar.k() == 1) {
            c1192c.f15927b.J(String.valueOf((int) R.drawable.obfuscated_res_0x7f080884), 24, false);
            SkinManager.setViewTextColor(c1192c.f15927b, R.color.CAM_X0305, 1);
        } else {
            c1192c.f15927b.J(String.valueOf((int) R.drawable.obfuscated_res_0x7f080883), 24, false);
            SkinManager.setViewTextColor(c1192c.f15927b, R.color.CAM_X0109, 1);
        }
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105));
        new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305));
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(24, true);
        int i3 = this.f15924c;
        if (i3 == 1) {
            SpannableString d2 = d(R.string.obfuscated_res_0x7f0f0347, aVar.l(), foregroundColorSpan, foregroundColorSpan2);
            spannableString3 = b(R.string.obfuscated_res_0x7f0f0429, aVar.m(), foregroundColorSpan, foregroundColorSpan2, absoluteSizeSpan, aVar.e());
            spannableString = c(R.string.obfuscated_res_0x7f0f0357, aVar.d(), foregroundColorSpan, foregroundColorSpan2);
            spannableString4 = d2;
            spannableString2 = null;
        } else if (i3 == 2) {
            SpannableString d3 = d(R.string.obfuscated_res_0x7f0f078d, aVar.l(), foregroundColorSpan, foregroundColorSpan2);
            spannableString3 = b(CurrencySwitchUtil.isYyIsConvert(aVar.e()) ? R.string.obfuscated_res_0x7f0f078e : R.string.obfuscated_res_0x7f0f078b, aVar.m(), foregroundColorSpan, foregroundColorSpan2, absoluteSizeSpan, aVar.e());
            spannableString = c(R.string.obfuscated_res_0x7f0f0357, aVar.d(), foregroundColorSpan, foregroundColorSpan2);
            String str = "" + aVar.j();
            String str2 = this.f15923b.getString(R.string.obfuscated_res_0x7f0f0271) + "    " + str;
            SpannableString spannableString5 = new SpannableString(str2);
            UtilHelper.setSpan(spannableString5, str2, str2, foregroundColorSpan);
            UtilHelper.setSpan(spannableString5, str2, str, foregroundColorSpan2);
            spannableString2 = spannableString5;
            spannableString4 = d3;
        } else if (i3 == 3) {
            String string = this.f15923b.getString(R.string.obfuscated_res_0x7f0f0f36);
            if (CurrencySwitchUtil.isYyIsConvert(aVar.e())) {
                l = String.format(this.f15923b.getString(R.string.obfuscated_res_0x7f0f15af), g(Double.valueOf(aVar.i())));
            } else {
                l = aVar.l();
            }
            String str3 = string + "    " + l;
            spannableString4 = new SpannableString(str3);
            UtilHelper.setSpan(spannableString4, str3, str3, foregroundColorSpan);
            UtilHelper.setSpan(spannableString4, str3, l, foregroundColorSpan2);
            String str4 = ("" + aVar.g()) + this.f15923b.getString(R.string.obfuscated_res_0x7f0f0f39);
            String str5 = this.f15923b.getString(R.string.obfuscated_res_0x7f0f0f35) + "    " + str4;
            SpannableString spannableString6 = new SpannableString(str5);
            UtilHelper.setSpan(spannableString6, str5, str5, foregroundColorSpan);
            UtilHelper.setSpan(spannableString6, str5, str4, foregroundColorSpan2);
            UtilHelper.setSpan(spannableString6, str5, str4, absoluteSizeSpan);
            spannableString3 = spannableString6;
            SpannableString c2 = c(R.string.obfuscated_res_0x7f0f0f38, aVar.f(), foregroundColorSpan, foregroundColorSpan2);
            String str6 = "" + aVar.j();
            String str7 = this.f15923b.getString(R.string.obfuscated_res_0x7f0f0f34) + "    " + str6;
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
        c1192c.f15928c.setText(spannableString4);
        c1192c.f15929d.setText(spannableString3);
        c1192c.f15930e.setText(spannableString);
        if (!StringUtils.isNull(aVar.j()) && ((i2 = this.f15924c) == 3 || i2 == 2)) {
            c1192c.f15931f.setVisibility(0);
            c1192c.f15931f.setText(spannableString2);
        } else {
            c1192c.f15931f.setVisibility(8);
        }
        if (!StringUtils.isNull(aVar.b())) {
            c1192c.i.setText(aVar.b());
            if (!StringUtils.isNull(aVar.a())) {
                c1192c.j.setText(aVar.a());
                i = 0;
                c1192c.j.setVisibility(0);
            } else {
                i = 0;
                c1192c.j.setVisibility(8);
            }
            c1192c.j.setOnClickListener(new b(this, aVar));
            c1192c.f15933h.setVisibility(i);
            return;
        }
        c1192c.f15933h.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: f */
    public c.a.p0.k0.a getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            ArrayList<c.a.p0.k0.a> arrayList = this.a;
            if (arrayList == null || arrayList.size() <= 0 || i < 0 || i >= getCount()) {
                return null;
            }
            return this.a.get(i);
        }
        return (c.a.p0.k0.a) invokeI.objValue;
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
            ArrayList<c.a.p0.k0.a> arrayList = this.a;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1192c c1192c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view, viewGroup)) == null) {
            c.a.p0.k0.a item = getItem(i);
            if (view != null) {
                c1192c = (C1192c) view.getTag();
            } else {
                view = LayoutInflater.from(this.f15923b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0735, viewGroup, false);
                c1192c = new C1192c();
                c1192c.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091616);
                c1192c.f15927b = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f09161a);
                c1192c.f15928c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09161c);
                c1192c.f15929d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091619);
                c1192c.f15932g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091617);
                c1192c.f15931f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091613);
                c1192c.f15930e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09161b);
                c1192c.f15933h = view.findViewById(R.id.obfuscated_res_0x7f091614);
                c1192c.i = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090071);
                c1192c.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09006e);
                view.setTag(c1192c);
            }
            e(c1192c, item);
            this.f15923b.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public void h(ArrayList<c.a.p0.k0.a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, arrayList) == null) {
            this.a = arrayList;
        }
    }
}
