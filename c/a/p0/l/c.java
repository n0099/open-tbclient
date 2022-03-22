package c.a.p0.l;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.r.r.v0;
import c.a.p0.l.b;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static String G;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CompoundButton.OnCheckedChangeListener B;
    public Runnable C;
    public View.OnClickListener D;
    public PopupWindow.OnDismissListener E;
    public CustomMessageListener F;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f15987b;

    /* renamed from: c  reason: collision with root package name */
    public PopupWindow f15988c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f15989d;

    /* renamed from: e  reason: collision with root package name */
    public v0 f15990e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<String> f15991f;

    /* renamed from: g  reason: collision with root package name */
    public List<b.C1197b> f15992g;

    /* renamed from: h  reason: collision with root package name */
    public int f15993h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public NEGFeedBackView.b p;
    public PopupWindow q;
    public View r;
    public TextView s;
    public TBSpecificationBtn t;
    public c.a.o0.r.l0.n.b u;
    public c.a.p0.l.b v;
    public boolean w;
    public int x;
    public NEGFeedBackView y;
    public boolean z;

    /* loaded from: classes2.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (this.a.p != null) {
                    this.a.p.b(this.a.f15990e, compoundButton, z);
                }
                if (compoundButton.getTag() instanceof b.C1197b) {
                    b.C1197b c1197b = (b.C1197b) compoundButton.getTag();
                    if (z) {
                        if (!this.a.f15992g.contains(c1197b)) {
                            this.a.f15992g.add(c1197b);
                        }
                    } else {
                        this.a.f15992g.remove(c1197b);
                    }
                }
                if (this.a.y == null || ListUtils.isEmpty(this.a.f15992g)) {
                    return;
                }
                this.a.y.removeCallbacks(this.a.C);
                this.a.y.postDelayed(this.a.C, 500L);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.s();
            }
        }
    }

    /* renamed from: c.a.p0.l.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1198c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public View$OnClickListenerC1198c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.s();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.y != null) {
                    this.a.y.setACRotateAnimation();
                    this.a.y.removeCallbacks(this.a.C);
                    this.a.y = null;
                }
                if (this.a.q != null) {
                    this.a.q.dismiss();
                    this.a.q = null;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(c cVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i)};
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
            this.a = cVar;
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

    public c(TbPageContext tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f15988c = null;
        this.f15990e = null;
        this.f15991f = null;
        this.f15992g = new ArrayList();
        this.p = null;
        this.x = 3;
        this.z = true;
        this.A = false;
        this.B = new a(this);
        this.C = new b(this);
        this.D = new View$OnClickListenerC1198c(this);
        this.E = new d(this);
        this.F = new e(this, 2016524);
        this.a = tbPageContext.getPageActivity();
        this.f15987b = tbPageContext;
        this.r = view;
        q();
    }

    public void A(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        CustomMessageListener customMessageListener = this.F;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.F);
    }

    public void B(View view) {
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.a == null) {
            return;
        }
        if (this.A || !((sparseArray = this.f15991f) == null || sparseArray.size() == 0)) {
            NEGFeedBackView nEGFeedBackView = (NEGFeedBackView) view;
            this.y = nEGFeedBackView;
            nEGFeedBackView.setCWRotateAnimation();
            View m = m();
            this.i = n.k(this.a) - (this.l * 2);
            int p = p();
            this.f15993h = p;
            int[] iArr = new int[2];
            boolean j = j(this.a, this.r, p, this.i, this.k, this.m, iArr);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0213));
            gradientDrawable.setCornerRadius(n.f(this.a, R.dimen.tbds31));
            m.setBackgroundDrawable(gradientDrawable);
            PopupWindow popupWindow = new PopupWindow(m, this.i, p());
            this.f15988c = popupWindow;
            popupWindow.setFocusable(true);
            this.f15988c.setTouchable(true);
            this.f15988c.setOnDismissListener(this.E);
            t();
            PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d089c, (ViewGroup) null), -1, -1);
            this.q = popupWindow2;
            if (Build.VERSION.SDK_INT >= 22) {
                popupWindow2.setAttachedInDecor(false);
            }
            this.q.showAtLocation(this.r, 0, 0, 0);
            if (iArr[0] == 0 && iArr[1] == 0) {
                return;
            }
            this.f15988c.setBackgroundDrawable(new ColorDrawable(0));
            if (j) {
                this.f15988c.setAnimationStyle(R.style.obfuscated_res_0x7f1003e2);
            } else {
                this.f15988c.setAnimationStyle(R.style.obfuscated_res_0x7f1003e3);
            }
            this.f15988c.showAtLocation(this.r, 0, iArr[0] - this.l, iArr[1]);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
            NEGFeedBackView.b bVar = this.p;
            if (bVar != null) {
                bVar.c(this.f15990e);
            }
            this.w = true;
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.A = z;
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int size = this.f15992g.size();
            if (size > 0) {
                String string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f05ef, Integer.valueOf(size));
                SpannableString spannableString = new SpannableString(string);
                UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)));
                TextView textView = this.s;
                if (textView != null) {
                    textView.setText(spannableString);
                }
                TBSpecificationBtn tBSpecificationBtn = this.t;
                if (tBSpecificationBtn != null) {
                    tBSpecificationBtn.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f041a));
                    return;
                }
                return;
            }
            if (this.s != null) {
                if (!m.isEmpty(G)) {
                    this.s.setText(G);
                } else {
                    this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1380));
                }
            }
            TBSpecificationBtn tBSpecificationBtn2 = this.t;
            if (tBSpecificationBtn2 != null) {
                tBSpecificationBtn2.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c74));
            }
        }
    }

    public final boolean j(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{context, view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr})) == null) {
            if (context == null || view == null || iArr == null || iArr.length != 2) {
                return false;
            }
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr2);
            int height = view.getHeight();
            int i5 = n.i(context);
            int k = n.k(context);
            boolean z = ((i5 - iArr2[1]) - height) - i3 < i;
            iArr[0] = k - i2;
            if (z) {
                iArr[1] = (iArr2[1] - i) - i4;
                iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            } else {
                iArr[1] = iArr2[1] + height + i4;
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public final void k() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.x) {
            return;
        }
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1);
        this.x = skinType;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PopupWindow popupWindow = this.f15988c;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.f15988c = null;
            }
            PopupWindow popupWindow2 = this.q;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
                this.q = null;
            }
        }
    }

    public final View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Context context = this.a;
            if (context == null) {
                return null;
            }
            if (this.f15989d == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05ec, (ViewGroup) null);
                this.f15989d = viewGroup;
                this.s = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090d26);
                if (!m.isEmpty(G)) {
                    this.s.setText(G);
                }
                this.t = (TBSpecificationBtn) this.f15989d.findViewById(R.id.obfuscated_res_0x7f09226d);
                c.a.o0.r.l0.n.b bVar = new c.a.o0.r.l0.n.b();
                this.u = bVar;
                bVar.r(R.color.CAM_X0304);
                this.t.setConfig(this.u);
                this.t.setOnClickListener(this.D);
                this.t.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c74));
                this.t.setTextSize(R.dimen.T_X08);
                ViewGroup viewGroup2 = this.f15989d;
                int i = this.n;
                viewGroup2.setPadding(i, 0, i, this.A ? 0 : this.o);
            }
            k();
            View h2 = this.v.h();
            if (h2 != null && h2.getParent() == null) {
                this.f15989d.addView(h2);
            }
            return this.f15989d;
        }
        return (View) invokeV.objValue;
    }

    public final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (ListUtils.isEmpty(this.f15992g)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (b.C1197b c1197b : this.f15992g) {
                if (c1197b != null) {
                    if (sb.length() != 0) {
                        sb.append(",");
                    }
                    sb.append(c1197b.f15985c);
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final JSONObject o(ArrayList<Integer> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, arrayList)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.f15990e == null || arrayList == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            if (!ListUtils.isEmpty(this.f15992g)) {
                for (b.C1197b c1197b : this.f15992g) {
                    if (c1197b != null) {
                        arrayList.add(Integer.valueOf(c1197b.f15984b));
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append(String.valueOf(c1197b.f15984b));
                        if (sb2.length() != 0) {
                            sb2.append(",");
                        }
                        sb2.append(c1197b.f15986d);
                    }
                }
            }
            try {
                jSONObject.put("tid", this.f15990e.f());
                if (sb.length() != 0) {
                    jSONObject.put("dislike_ids", sb.toString());
                }
                jSONObject.put("fid", this.f15990e.c());
                jSONObject.put("click_time", System.currentTimeMillis());
                if (!StringUtils.isNull(this.f15990e.getType())) {
                    jSONObject.put("type", this.f15990e.getType());
                }
                if (this.f15990e.h() != 0) {
                    jSONObject.put("topic_id", this.f15990e.h());
                }
                jSONObject.put("extra", sb2.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ViewGroup viewGroup = this.f15989d;
            if (viewGroup == null) {
                return 0;
            }
            viewGroup.measure(0, 0);
            int measuredHeight = this.f15989d.getMeasuredHeight();
            this.j = measuredHeight;
            return measuredHeight;
        }
        return invokeV.intValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l = n.f(this.a, R.dimen.M_W_X004);
            this.m = n.f(this.a, R.dimen.tbds14);
            this.n = n.f(this.a, R.dimen.M_W_X005);
            this.o = n.f(this.a, R.dimen.M_H_X007);
            this.i = n.k(this.a) - (this.l * 2);
            this.k = n.f(this.a, R.dimen.tbds160);
            c.a.p0.l.b bVar = new c.a.p0.l.b(this.f15987b);
            this.v = bVar;
            bVar.n(true);
            this.v.i(false);
            this.v.o(this.B);
            this.f15987b.registerListener(this.F);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.F);
            l();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.f15990e == null || this.f15988c == null) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        JSONObject o = o(arrayList);
        if (this.z) {
            if (!StringUtils.isNull(this.f15990e.getType())) {
                CustomMessage customMessage = new CustomMessage(2921324, this.f15987b.getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921324, o);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            } else {
                CustomMessage customMessage2 = new CustomMessage(2016488, this.f15987b.getUniqueId());
                CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2016488, o);
                customResponsedMessage2.setOrginalMessage(customMessage2);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
            }
        }
        l();
        new c.a.o0.r.l0.c().a = 1500L;
        String string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f61);
        if (o != null && "7".equals(o.optString("dislike_ids"))) {
            string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0634);
        }
        n.N(this.a, string);
        NEGFeedBackView.b bVar = this.p;
        if (bVar != null) {
            bVar.a(arrayList, n(), this.f15990e);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.w && this.f15992g.size() != 0) {
            this.f15992g.clear();
            D();
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.z = z;
        }
    }

    public void v(v0 v0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, v0Var) == null) || v0Var == null) {
            return;
        }
        this.f15990e = v0Var;
        SparseArray<String> b2 = v0Var.b();
        this.f15991f = b2;
        if (b2 != null && b2.size() > 9) {
            for (int size = this.f15991f.size() - 1; size >= 9; size--) {
                this.f15991f.removeAt(size);
            }
        }
        this.v.j(v0Var);
    }

    public void w(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, strArr) == null) {
            this.v.k(strArr);
        }
    }

    public void x(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            this.p = bVar;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.v.m(z);
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || m.isEmpty(str)) {
            return;
        }
        G = str;
    }
}
