package c.a.p0.l3;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActionControl;
import tbclient.AdCloseInfo;
/* loaded from: classes2.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PlaceId A;
    public View.OnClickListener B;
    public View.OnClickListener C;
    public PopupWindow.OnDismissListener D;
    public final CustomMessageListener E;
    public View.OnClickListener F;
    public final View a;

    /* renamed from: b  reason: collision with root package name */
    public Context f16325b;

    /* renamed from: c  reason: collision with root package name */
    public PopupWindow f16326c;

    /* renamed from: d  reason: collision with root package name */
    public PopupWindow f16327d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f16328e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f16329f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.o0.r.l0.n.b f16330g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16331h;
    public RelativeLayout i;
    public EMTextView j;
    public ImageView k;
    public TextView l;
    public List<CheckBox> m;
    public AdvertAppInfo n;
    public ActionControl o;
    public List<String> p;
    public String q;
    public String r;
    public int s;
    public int t;
    public View u;
    public int v;
    public int w;
    public int x;
    public int y;
    public boolean z;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x a;

        public a(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int k = this.a.k();
                if (k > 0) {
                    x xVar = this.a;
                    xVar.f16329f.setText(xVar.f16325b.getResources().getString(R.string.obfuscated_res_0x7f0f041a));
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) this.a.f16325b.getString(R.string.obfuscated_res_0x7f0f00a3));
                    int color = SkinManager.getColor(R.color.CAM_X0105);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(k));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) this.a.f16325b.getString(R.string.obfuscated_res_0x7f0f00a2));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    this.a.f16331h.setText(spannableStringBuilder);
                    return;
                }
                x xVar2 = this.a;
                xVar2.f16329f.setText(xVar2.f16325b.getResources().getString(R.string.obfuscated_res_0x7f0f00b2));
                x xVar3 = this.a;
                xVar3.f16331h.setText(xVar3.q);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x a;

        public b(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.n == null) {
                return;
            }
            x xVar = this.a;
            if (xVar.f16326c == null) {
                return;
            }
            String n = xVar.n();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, this.a.n.a));
            this.a.l();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
            tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
            httpMessage.addParam("pi", this.a.A.value);
            httpMessage.addParam("cr", n);
            httpMessage.addParam("ext", this.a.n.f29821h);
            httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
            MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x a;

        public c(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            PopupWindow popupWindow;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (popupWindow = this.a.f16327d) == null) {
                return;
            }
            popupWindow.dismiss();
            this.a.f16327d = null;
        }
    }

    /* loaded from: classes2.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(x xVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.l();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x a;

        public e(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.p();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x a;

        public f(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.l();
            }
        }
    }

    public x(@NonNull AdvertAppInfo advertAppInfo, @NonNull AdCloseInfo adCloseInfo, @NonNull Context context, View view, int i, PlaceId placeId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {advertAppInfo, adCloseInfo, context, view, Integer.valueOf(i), placeId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16326c = null;
        this.f16327d = null;
        this.m = null;
        this.p = new ArrayList();
        this.z = false;
        this.B = new a(this);
        this.C = new b(this);
        this.D = new c(this);
        this.E = new d(this, 2016524);
        this.F = new e(this);
        this.n = advertAppInfo;
        this.f16325b = context;
        this.a = view;
        this.A = placeId;
        this.y = i;
        c.a.p0.b2.o.k.a.c(this.p);
        if (adCloseInfo != null) {
            this.o = adCloseInfo.action_control;
            for (String str : adCloseInfo.reasons) {
                c.a.p0.b2.o.k.a.a(this.p, str);
            }
            String str2 = adCloseInfo.title;
            this.q = str2;
            if (TextUtils.isEmpty(str2)) {
                this.q = this.f16325b.getString(R.string.obfuscated_res_0x7f0f1380);
            }
            this.r = adCloseInfo.confirm_title;
        }
        this.s = c.a.d.f.p.n.f(this.f16325b, R.dimen.obfuscated_res_0x7f07028a);
        this.t = c.a.d.f.p.n.k(this.f16325b) - (this.w * 2);
        this.v = c.a.d.f.p.n.f(this.f16325b, R.dimen.obfuscated_res_0x7f070235);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c.a.p0.b2.o.k.a.e(this.p)) {
            return;
        }
        int k = c.a.p0.b2.o.k.a.k(this.p);
        this.f16328e.setVisibility(0);
        int i = 0;
        for (int i2 = 0; i2 < Math.ceil(k / 2.0d); i2++) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f16325b).inflate(R.layout.obfuscated_res_0x7f0d006b, (ViewGroup) null);
            linearLayout.setOrientation(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 1;
            if (i2 != 0) {
                layoutParams.topMargin = c.a.d.f.p.n.f(this.f16325b, R.dimen.M_H_X003);
            }
            linearLayout.setLayoutParams(layoutParams);
            this.f16328e.addView(linearLayout);
            for (int i3 = 0; i3 < linearLayout.getChildCount() && (i = i + 1) <= k; i3++) {
                CheckBox checkBox = (CheckBox) linearLayout.getChildAt(i3);
                checkBox.setOnClickListener(this.B);
                checkBox.setVisibility(0);
                c.a.p0.b2.o.k.a.a(this.m, checkBox);
            }
        }
        for (int i4 = 0; i4 < c.a.p0.b2.o.k.a.k(this.p); i4++) {
            String str = (String) c.a.p0.b2.o.k.a.d(this.p, i4);
            CheckBox checkBox2 = (CheckBox) c.a.p0.b2.o.k.a.d(this.m, i4);
            if (checkBox2 != null) {
                checkBox2.setText(str);
            }
        }
    }

    public final boolean i(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr})) == null) {
            if (context == null || view == null || iArr == null || iArr.length != 2) {
                return false;
            }
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr2);
            int height = view.getHeight();
            int i5 = c.a.d.f.p.n.i(context);
            int k = c.a.d.f.p.n.k(context);
            boolean z = ((i5 - iArr2[1]) - height) - i3 < i;
            iArr[0] = k - i2;
            if (z) {
                iArr[1] = (iArr2[1] - i) - i4;
            } else {
                iArr[1] = iArr2[1] + height + i4;
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ActionControl actionControl = this.o;
            return (actionControl == null || TextUtils.isEmpty(actionControl.url) || TextUtils.isEmpty(this.o.name)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (c.a.p0.b2.o.k.a.e(this.m)) {
                return 0;
            }
            int i = 0;
            for (int i2 = 0; i2 < c.a.p0.b2.o.k.a.k(this.m); i2++) {
                CheckBox checkBox = (CheckBox) c.a.p0.b2.o.k.a.d(this.m, i2);
                if (checkBox != null && checkBox.isChecked()) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PopupWindow popupWindow = this.f16326c;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.f16326c = null;
            }
            PopupWindow popupWindow2 = this.f16327d;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
                this.f16327d = null;
            }
        }
    }

    public final View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Context context = this.f16325b;
            if (context == null) {
                return null;
            }
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d006a, (ViewGroup) null);
            this.f16331h = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090d26);
            this.i = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0920a3);
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f0900e2);
            this.j = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f0900e1);
            this.k = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0902a8);
            if (!TextUtils.isEmpty(this.q)) {
                this.f16331h.setText(this.q);
            }
            this.f16329f = (TBSpecificationBtn) inflate.findViewById(R.id.obfuscated_res_0x7f090a0f);
            c.a.o0.r.l0.n.b bVar = new c.a.o0.r.l0.n.b();
            this.f16330g = bVar;
            bVar.r(R.color.CAM_X0304);
            this.f16329f.setConfig(this.f16330g);
            if (!TextUtils.isEmpty(this.r)) {
                this.f16329f.setText(this.r);
            } else {
                this.f16329f.setText(this.f16325b.getResources().getString(R.string.obfuscated_res_0x7f0f00b2));
            }
            this.f16329f.setOnClickListener(this.C);
            if (j()) {
                this.j.setText(this.o.name);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this.F);
            }
            SkinManager.setViewTextColor(this.f16331h, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1);
            this.k.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_ad_dislike_arrow20_right_n));
            this.f16328e = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0919ca);
            this.m = new ArrayList();
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09048f);
            this.l = textView;
            textView.setVisibility(0);
            this.l.setOnClickListener(new f(this));
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.n == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (!c.a.p0.b2.o.k.a.e(this.m)) {
                for (int i = 0; i < c.a.p0.b2.o.k.a.k(this.m); i++) {
                    CheckBox checkBox = (CheckBox) c.a.p0.b2.o.k.a.d(this.m, i);
                    if (checkBox != null && checkBox.isChecked() && c.a.p0.b2.o.k.a.k(this.p) > i) {
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append((String) c.a.p0.b2.o.k.a.d(this.p, i));
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            View view = this.u;
            if (view == null) {
                return 0;
            }
            try {
                view.measure(0, 0);
                return this.u.getMeasuredHeight();
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && j()) {
            c.a.p0.x.b.l().c(this.f16325b, new String[]{this.o.url}, null);
        }
    }

    public void q() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (context = this.f16325b) == null || FullBrowseHelper.checkAndShowFullBrowseModeDialog(c.a.d.a.j.a(context), null)) {
            return;
        }
        l();
        View m = m();
        h();
        this.u = m;
        this.s = o();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0204));
        gradientDrawable.setCornerRadius(c.a.d.f.p.n.f(this.f16325b, R.dimen.tbds31));
        this.u.setBackgroundDrawable(gradientDrawable);
        PopupWindow popupWindow = new PopupWindow(m, this.t, this.s);
        this.f16326c = popupWindow;
        popupWindow.setFocusable(true);
        this.f16326c.setTouchable(true);
        this.f16326c.setSoftInputMode(16);
        this.f16326c.setOnDismissListener(this.D);
        if (Build.VERSION.SDK_INT >= 22) {
            this.f16326c.setAttachedInDecor(false);
        }
        if (!this.z) {
            MessageManager.getInstance().registerListener(this.E);
            this.z = true;
        }
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.f16325b).inflate(R.layout.obfuscated_res_0x7f0d089c, (ViewGroup) null), -1, -1);
        this.f16327d = popupWindow2;
        popupWindow2.setFocusable(false);
        this.f16327d.setTouchable(false);
        if (Build.VERSION.SDK_INT >= 22) {
            this.f16327d.setAttachedInDecor(false);
        }
        this.f16327d.showAtLocation(this.a, this.y, 0, 0);
        int[] iArr = new int[2];
        i(this.f16325b, this.a, this.s, this.t, this.v, this.x, iArr);
        if (iArr[0] == 0 && iArr[1] == 0) {
            return;
        }
        this.f16326c.setBackgroundDrawable(new ColorDrawable(0));
        this.f16326c.showAtLocation(this.a, this.y, iArr[0] - this.w, iArr[1]);
    }
}
