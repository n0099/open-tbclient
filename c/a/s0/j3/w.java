package c.a.s0.j3;

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
/* loaded from: classes7.dex */
public class w {
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
    public Context f18527b;

    /* renamed from: c  reason: collision with root package name */
    public PopupWindow f18528c;

    /* renamed from: d  reason: collision with root package name */
    public PopupWindow f18529d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f18530e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f18531f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.s.i0.n.b f18532g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18533h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f18534i;

    /* renamed from: j  reason: collision with root package name */
    public EMTextView f18535j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f18536k;
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

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ w f18537e;

        public a(w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18537e = wVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int k2 = this.f18537e.k();
                if (k2 > 0) {
                    w wVar = this.f18537e;
                    wVar.f18531f.setText(wVar.f18527b.getResources().getString(R.string.confirm));
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) this.f18537e.f18527b.getString(R.string.ad_close_title_prefix));
                    int color = SkinManager.getColor(R.color.CAM_X0105);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(k2));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) this.f18537e.f18527b.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    this.f18537e.f18533h.setText(spannableStringBuilder);
                    return;
                }
                w wVar2 = this.f18537e;
                wVar2.f18531f.setText(wVar2.f18527b.getResources().getString(R.string.ad_no_interest));
                w wVar3 = this.f18537e;
                wVar3.f18533h.setText(wVar3.q);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ w f18538e;

        public b(w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18538e = wVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f18538e.n == null) {
                return;
            }
            w wVar = this.f18538e;
            if (wVar.f18528c == null) {
                return;
            }
            String n = wVar.n();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, this.f18538e.n.d4));
            this.f18538e.l();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
            tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
            httpMessage.addParam("pi", this.f18538e.A.value);
            httpMessage.addParam("cr", n);
            httpMessage.addParam("ext", this.f18538e.n.k4);
            httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
            MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ w f18539e;

        public c(w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18539e = wVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            PopupWindow popupWindow;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (popupWindow = this.f18539e.f18529d) == null) {
                return;
            }
            popupWindow.dismiss();
            this.f18539e.f18529d = null;
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(w wVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wVar;
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

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ w f18540e;

        public e(w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18540e = wVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18540e.p();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ w f18541e;

        public f(w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18541e = wVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18541e.l();
            }
        }
    }

    public w(@NonNull AdvertAppInfo advertAppInfo, @NonNull AdCloseInfo adCloseInfo, @NonNull Context context, View view, int i2, PlaceId placeId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {advertAppInfo, adCloseInfo, context, view, Integer.valueOf(i2), placeId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18528c = null;
        this.f18529d = null;
        this.m = null;
        this.p = new ArrayList();
        this.z = false;
        this.B = new a(this);
        this.C = new b(this);
        this.D = new c(this);
        this.E = new d(this, 2016524);
        this.F = new e(this);
        this.n = advertAppInfo;
        this.f18527b = context;
        this.a = view;
        this.A = placeId;
        this.y = i2;
        c.a.s0.x1.o.k.a.c(this.p);
        if (adCloseInfo != null) {
            this.o = adCloseInfo.action_control;
            for (String str : adCloseInfo.reasons) {
                c.a.s0.x1.o.k.a.a(this.p, str);
            }
            String str2 = adCloseInfo.title;
            this.q = str2;
            if (TextUtils.isEmpty(str2)) {
                this.q = this.f18527b.getString(R.string.tell_us_reason);
            }
            this.r = adCloseInfo.confirm_title;
        }
        this.s = c.a.d.f.p.m.f(this.f18527b, R.dimen.ds278);
        this.t = c.a.d.f.p.m.k(this.f18527b) - (this.w * 2);
        this.v = c.a.d.f.p.m.f(this.f18527b, R.dimen.ds120);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c.a.s0.x1.o.k.a.e(this.p)) {
            return;
        }
        int k2 = c.a.s0.x1.o.k.a.k(this.p);
        this.f18530e.setVisibility(0);
        int i2 = 0;
        for (int i3 = 0; i3 < Math.ceil(k2 / 2.0d); i3++) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f18527b).inflate(R.layout.ad_close_row_view, (ViewGroup) null);
            linearLayout.setOrientation(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 1;
            if (i3 != 0) {
                layoutParams.topMargin = c.a.d.f.p.m.f(this.f18527b, R.dimen.M_H_X003);
            }
            linearLayout.setLayoutParams(layoutParams);
            this.f18530e.addView(linearLayout);
            for (int i4 = 0; i4 < linearLayout.getChildCount() && (i2 = i2 + 1) <= k2; i4++) {
                CheckBox checkBox = (CheckBox) linearLayout.getChildAt(i4);
                checkBox.setOnClickListener(this.B);
                checkBox.setVisibility(0);
                c.a.s0.x1.o.k.a.a(this.m, checkBox);
            }
        }
        for (int i5 = 0; i5 < c.a.s0.x1.o.k.a.k(this.p); i5++) {
            String str = (String) c.a.s0.x1.o.k.a.d(this.p, i5);
            CheckBox checkBox2 = (CheckBox) c.a.s0.x1.o.k.a.d(this.m, i5);
            if (checkBox2 != null) {
                checkBox2.setText(str);
            }
        }
    }

    public final boolean i(Context context, View view, int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) {
            if (context == null || view == null || iArr == null || iArr.length != 2) {
                return false;
            }
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr2);
            int height = view.getHeight();
            int i6 = c.a.d.f.p.m.i(context);
            int k2 = c.a.d.f.p.m.k(context);
            boolean z = ((i6 - iArr2[1]) - height) - i4 < i2;
            iArr[0] = k2 - i3;
            if (z) {
                iArr[1] = (iArr2[1] - i2) - i5;
            } else {
                iArr[1] = iArr2[1] + height + i5;
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
            if (c.a.s0.x1.o.k.a.e(this.m)) {
                return 0;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < c.a.s0.x1.o.k.a.k(this.m); i3++) {
                CheckBox checkBox = (CheckBox) c.a.s0.x1.o.k.a.d(this.m, i3);
                if (checkBox != null && checkBox.isChecked()) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PopupWindow popupWindow = this.f18528c;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.f18528c = null;
            }
            PopupWindow popupWindow2 = this.f18529d;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
                this.f18529d = null;
            }
        }
    }

    public final View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Context context = this.f18527b;
            if (context == null) {
                return null;
            }
            View inflate = LayoutInflater.from(context).inflate(R.layout.ad_close_popupwindow, (ViewGroup) null);
            this.f18533h = (TextView) inflate.findViewById(R.id.head_text);
            this.f18534i = (RelativeLayout) inflate.findViewById(R.id.top_area);
            View findViewById = inflate.findViewById(R.id.ad_show_reason_wrapper);
            this.f18535j = (EMTextView) inflate.findViewById(R.id.ad_show_reason);
            this.f18536k = (ImageView) inflate.findViewById(R.id.arrow_right);
            if (!TextUtils.isEmpty(this.q)) {
                this.f18533h.setText(this.q);
            }
            this.f18531f = (TBSpecificationBtn) inflate.findViewById(R.id.forbid_thread_btn);
            c.a.r0.s.i0.n.b bVar = new c.a.r0.s.i0.n.b();
            this.f18532g = bVar;
            bVar.r(R.color.CAM_X0304);
            this.f18531f.setConfig(this.f18532g);
            if (!TextUtils.isEmpty(this.r)) {
                this.f18531f.setText(this.r);
            } else {
                this.f18531f.setText(this.f18527b.getResources().getString(R.string.ad_no_interest));
            }
            this.f18531f.setOnClickListener(this.C);
            if (j()) {
                this.f18535j.setText(this.o.name);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this.F);
            }
            SkinManager.setViewTextColor(this.f18533h, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.f18535j, R.color.CAM_X0107, 1);
            this.f18536k.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_ad_dislike_arrow20_right_n));
            this.f18530e = (LinearLayout) inflate.findViewById(R.id.reason_root_container);
            this.m = new ArrayList();
            TextView textView = (TextView) inflate.findViewById(R.id.cancel_button);
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
            if (!c.a.s0.x1.o.k.a.e(this.m)) {
                for (int i2 = 0; i2 < c.a.s0.x1.o.k.a.k(this.m); i2++) {
                    CheckBox checkBox = (CheckBox) c.a.s0.x1.o.k.a.d(this.m, i2);
                    if (checkBox != null && checkBox.isChecked() && c.a.s0.x1.o.k.a.k(this.p) > i2) {
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append((String) c.a.s0.x1.o.k.a.d(this.p, i2));
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
            c.a.s0.v.b.l().c(this.f18527b, new String[]{this.o.url}, null);
        }
    }

    public void q() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (context = this.f18527b) == null || FullBrowseHelper.checkAndShowFullBrowseModeDialog(c.a.d.a.j.a(context), null)) {
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
        gradientDrawable.setCornerRadius(c.a.d.f.p.m.f(this.f18527b, R.dimen.tbds31));
        this.u.setBackgroundDrawable(gradientDrawable);
        PopupWindow popupWindow = new PopupWindow(m, this.t, this.s);
        this.f18528c = popupWindow;
        popupWindow.setFocusable(true);
        this.f18528c.setTouchable(true);
        this.f18528c.setSoftInputMode(16);
        this.f18528c.setOnDismissListener(this.D);
        if (Build.VERSION.SDK_INT >= 22) {
            this.f18528c.setAttachedInDecor(false);
        }
        if (!this.z) {
            MessageManager.getInstance().registerListener(this.E);
            this.z = true;
        }
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.f18527b).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.f18529d = popupWindow2;
        popupWindow2.setFocusable(false);
        this.f18529d.setTouchable(false);
        if (Build.VERSION.SDK_INT >= 22) {
            this.f18529d.setAttachedInDecor(false);
        }
        this.f18529d.showAtLocation(this.a, this.y, 0, 0);
        int[] iArr = new int[2];
        i(this.f18527b, this.a, this.s, this.t, this.v, this.x, iArr);
        if (iArr[0] == 0 && iArr[1] == 0) {
            return;
        }
        this.f18528c.setBackgroundDrawable(new ColorDrawable(0));
        this.f18528c.showAtLocation(this.a, this.y, iArr[0] - this.w, iArr[1]);
    }
}
