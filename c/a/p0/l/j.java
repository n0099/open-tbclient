package c.a.p0.l;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.r.r.v0;
import c.a.p0.l.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRuleEditActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public i B;
    public UserData C;
    public boolean D;
    public boolean E;
    public int F;
    public ClickableSpan G;
    public boolean H;
    public CompoundButton.OnCheckedChangeListener I;
    public PopupWindow.OnDismissListener J;
    public CustomMessageListener K;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f16022b;

    /* renamed from: c  reason: collision with root package name */
    public v0 f16023c;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<String> f16024d;

    /* renamed from: e  reason: collision with root package name */
    public List<b.C1197b> f16025e;

    /* renamed from: f  reason: collision with root package name */
    public int f16026f;

    /* renamed from: g  reason: collision with root package name */
    public int f16027g;

    /* renamed from: h  reason: collision with root package name */
    public int f16028h;
    public NEGFeedBackView.b i;
    public PopupWindow j;
    public View k;
    public c.a.p0.l.b l;
    public boolean m;
    public int n;
    public PopupWindow o;
    public ViewGroup p;
    public EMTextView q;
    public EMTextView r;
    public EMTextView s;
    public EMTextView t;
    public EMTextView u;
    public LinearLayout v;
    public String w;
    public g x;
    public h y;
    public c.a.o0.r.l0.a z;

    /* loaded from: classes2.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (this.a.i != null) {
                    this.a.i.b(this.a.f16023c, compoundButton, z);
                }
                if (compoundButton.getTag() instanceof b.C1197b) {
                    b.C1197b c1197b = (b.C1197b) compoundButton.getTag();
                    if (z) {
                        if (this.a.f16025e.contains(c1197b)) {
                            return;
                        }
                        this.a.f16025e.add(c1197b);
                        if (!this.a.D || this.a.r == null) {
                            return;
                        }
                        this.a.r.setClickable(true);
                        c.a.o0.r.v.c.d(this.a.r).v(R.color.CAM_X0302);
                        return;
                    }
                    this.a.f16025e.remove(c1197b);
                    if (!this.a.D || this.a.r == null) {
                        return;
                    }
                    this.a.r.setClickable(false);
                    this.a.r.setTextColor(c.a.p0.a4.c.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public b(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.j == null) {
                return;
            }
            this.a.j.dismiss();
            this.a.j = null;
            MessageManager.getInstance().unRegisterListener(this.a.K);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(j jVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i)};
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
            this.a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.a.t();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public d(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.j != null) {
                    this.a.j.dismiss();
                    this.a.j = null;
                }
                if (this.a.o != null) {
                    this.a.o.dismiss();
                    this.a.o = null;
                }
                if (this.a.H) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_CANCEL_CLICK).param("obj_source", this.a.w));
                }
                if (this.a.x != null) {
                    this.a.x.onClick();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public e(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                JSONObject w = this.a.w();
                if (this.a.w == "3" || this.a.w == "4" || this.a.w == "1") {
                    this.a.v();
                } else if (w != null) {
                    this.a.H();
                    CustomMessage customMessage = new CustomMessage(2016489, this.a.f16022b.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, w);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public f(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRuleEditActivityConfig(this.a.a, this.a.B.b(), this.a.B.c(), this.a.B.a(), this.a.B.g(), ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS)));
                if (this.a.j != null) {
                    this.a.j.dismiss();
                    this.a.j = null;
                }
                if (this.a.o != null) {
                    this.a.o.dismiss();
                    this.a.o = null;
                }
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(SkinManager.getColor(R.color.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface g {
        void onClick();
    }

    /* loaded from: classes2.dex */
    public interface h {
        void a(JSONArray jSONArray);
    }

    public j(TbPageContext tbPageContext, View view, i iVar, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, iVar, userData};
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
        this.f16023c = null;
        this.f16024d = null;
        this.f16025e = new ArrayList();
        this.i = null;
        this.o = null;
        this.z = null;
        this.A = 3;
        this.D = true;
        this.E = false;
        this.I = new a(this);
        this.J = new b(this);
        this.K = new c(this, 2001304);
        this.a = tbPageContext.getPageActivity();
        this.f16022b = tbPageContext;
        this.k = view;
        this.B = iVar;
        this.C = userData;
        A();
        z();
    }

    public final void A() {
        UserData userData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i iVar = this.B;
            if (iVar != null) {
                if (iVar.e() == 1) {
                    this.D = false;
                } else {
                    this.D = true;
                }
                if (this.B.d() == 1) {
                    this.E = false;
                } else {
                    this.E = true;
                }
            }
            if (!this.E || (userData = this.C) == null) {
                return;
            }
            this.F = userData.getIs_manager();
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.m && this.f16025e.size() != 0) {
            this.f16025e.clear();
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.H = z;
        }
    }

    public void D(v0 v0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, v0Var) == null) || v0Var == null) {
            return;
        }
        this.f16023c = v0Var;
        SparseArray<String> b2 = v0Var.b();
        this.f16024d = b2;
        if (b2 != null && b2.size() > 8) {
            for (int size = this.f16024d.size() - 1; size >= 8; size--) {
                this.f16024d.removeAt(size);
            }
        }
        this.l.j(v0Var);
    }

    public void E(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, strArr) == null) {
            this.l.k(strArr);
        }
    }

    public void F(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
            this.y = hVar;
        }
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || this.a == null) {
            return;
        }
        this.w = str;
        View x = x();
        if (x != null && x.getParent() != null) {
            ((ViewGroup) x.getParent()).removeView(x);
        }
        if (x == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0205));
        gradientDrawable.setCornerRadius(n.f(this.a, R.dimen.tbds31));
        x.setBackgroundDrawable(gradientDrawable);
        t();
        this.f16026f = y();
        PopupWindow popupWindow = new PopupWindow(x, this.f16027g, this.f16026f);
        this.o = popupWindow;
        popupWindow.setFocusable(true);
        this.o.setTouchable(true);
        this.o.setOnDismissListener(this.J);
        B();
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d089c, (ViewGroup) null), -1, -1);
        this.j = popupWindow2;
        if (Build.VERSION.SDK_INT >= 22) {
            popupWindow2.setAttachedInDecor(false);
        }
        this.j.showAtLocation(this.k, 0, 0, 0);
        this.o.showAtLocation(this.k, 17, 0, 0);
        NEGFeedBackView.b bVar = this.i;
        if (bVar != null) {
            bVar.c(this.f16023c);
        }
        this.m = true;
        MessageManager.getInstance().registerListener(this.K);
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.z == null) {
                this.z = new c.a.o0.r.l0.a(this.f16022b);
            }
            this.z.i(R.string.obfuscated_res_0x7f0f0a2e);
            this.z.h(true);
        }
    }

    public final void t() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.A) {
            return;
        }
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColorSelector(this.q, R.color.CAM_X0105);
        if (this.D) {
            this.r.setTextColor(c.a.p0.a4.c.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
            this.r.setClickable(false);
        } else {
            c.a.o0.r.v.c.d(this.r).v(R.color.CAM_X0302);
        }
        SkinManager.setViewTextColor(this.t, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0105, 1);
        this.u.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.pic_popup_guide));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0205));
        gradientDrawable.setCornerRadius(n.f(this.a, R.dimen.tbds31));
        this.p.setBackgroundDrawable(gradientDrawable);
        this.A = skinType;
    }

    public void u() {
        c.a.o0.r.l0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (aVar = this.z) == null) {
            return;
        }
        aVar.h(false);
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            PopupWindow popupWindow = this.o;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.o = null;
            }
            PopupWindow popupWindow2 = this.j;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
                this.j = null;
            }
        }
    }

    public final JSONObject w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.f16023c == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            if (!ListUtils.isEmpty(this.f16025e)) {
                int i2 = 0;
                while (i < this.f16025e.size()) {
                    b.C1197b c1197b = this.f16025e.get(i);
                    if (c1197b != null) {
                        jSONArray.put(String.valueOf(c1197b.f15984b));
                        i2 = c1197b.a + 1;
                    }
                    i++;
                }
                i = i2;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_DELETE_THREAD_REASON).param("obj_source", this.w).param("obj_type", i));
            if (this.H) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_REASON_CLICK).param("obj_source", this.w).param("obj_type", i));
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_CONFIRM_CLICK).param("obj_source", this.w).param("obj_type", i));
            }
            h hVar = this.y;
            if (hVar != null) {
                hVar.a(jSONArray);
            }
            try {
                jSONObject.put("reason", jSONArray);
                jSONObject.put("thread_ids", this.f16023c.g());
                jSONObject.put("type", this.f16023c.a());
                jSONObject.put("forum_id", this.f16023c.c());
                jSONObject.put("is_frs_masks", this.f16023c.d());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            Context context = this.a;
            if (context == null) {
                return null;
            }
            if (this.p == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0857, (ViewGroup) null);
                this.p = viewGroup;
                EMTextView eMTextView = (EMTextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09225d);
                this.s = eMTextView;
                if (this.H) {
                    eMTextView.setText(R.string.obfuscated_res_0x7f0f1155);
                } else {
                    eMTextView.setText(R.string.obfuscated_res_0x7f0f049b);
                }
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.s);
                d2.A(R.string.F_X02);
                d2.v(R.color.CAM_X0105);
                EMTextView eMTextView2 = (EMTextView) this.p.findViewById(R.id.obfuscated_res_0x7f092258);
                this.t = eMTextView2;
                c.a.o0.r.v.c.d(eMTextView2).z(R.dimen.T_X08);
                EMTextView eMTextView3 = (EMTextView) this.p.findViewById(R.id.obfuscated_res_0x7f092256);
                this.q = eMTextView3;
                eMTextView3.setOnClickListener(new d(this));
                EMTextView eMTextView4 = (EMTextView) this.p.findViewById(R.id.obfuscated_res_0x7f092257);
                this.r = eMTextView4;
                if (this.H) {
                    eMTextView4.setText(R.string.obfuscated_res_0x7f0f1152);
                } else {
                    eMTextView4.setText(R.string.obfuscated_res_0x7f0f048e);
                }
                this.r.setOnClickListener(new e(this));
            }
            this.v = (LinearLayout) this.p.findViewById(R.id.obfuscated_res_0x7f09225a);
            View g2 = this.l.g();
            if (g2 != null && g2.getParent() == null) {
                int f2 = n.f(this.a, R.dimen.M_W_X009);
                g2.setPadding(f2, 0, f2, 0);
                this.v.addView(g2);
            }
            EMTextView eMTextView5 = (EMTextView) this.p.findViewById(R.id.obfuscated_res_0x7f09225c);
            this.u = eMTextView5;
            eMTextView5.setHighlightColor(SelectorHelper.getResources().getColor(17170445));
            if (this.E) {
                this.u.setVisibility(0);
                if (1 == this.F) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) this.a.getString(R.string.obfuscated_res_0x7f0f10ec));
                    f fVar = new f(this);
                    this.G = fVar;
                    spannableStringBuilder.setSpan(fVar, 13, 17, 18);
                    this.u.setText(spannableStringBuilder);
                    this.u.setMovementMethod(LinkMovementMethod.getInstance());
                } else {
                    this.u.setText(this.a.getString(R.string.obfuscated_res_0x7f0f10eb));
                }
            } else {
                this.u.setVisibility(8);
            }
            this.u.setClickable(false);
            this.u.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.pic_popup_guide));
            t();
            return this.p;
        }
        return (View) invokeV.objValue;
    }

    public final int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ViewGroup viewGroup = this.p;
            if (viewGroup == null) {
                return 0;
            }
            viewGroup.measure(0, 0);
            int measuredHeight = this.p.getMeasuredHeight();
            this.f16028h = measuredHeight;
            return measuredHeight;
        }
        return invokeV.intValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.n = n.f(this.a, R.dimen.M_W_X009);
            this.f16027g = n.k(this.a) - (this.n * 2);
            c.a.p0.l.b bVar = new c.a.p0.l.b(this.f16022b);
            this.l = bVar;
            bVar.o(this.I);
            this.l.n(true);
            if (this.E) {
                this.l.l(5);
            }
        }
    }
}
